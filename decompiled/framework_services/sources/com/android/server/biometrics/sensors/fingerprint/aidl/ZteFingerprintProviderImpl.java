package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.content.Context;
import android.hardware.biometrics.fingerprint.IFingerprint;
import android.os.IBinder;
import android.util.Slog;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.sensors.AuthenticationClient;
import com.android.server.biometrics.sensors.BaseClientMonitor;
import com.android.server.biometrics.sensors.SensorList;
import com.android.server.biometrics.sensors.fingerprint.aidl.udfpsdecouple.UdfpsDecoupleController;
import vendor.zte.fingerprint.ztecmdaidl.IZtecmdCallback;
import vendor.zte.fingerprint.ztecmdaidl.IZtecmdDaemon;

/* JADX INFO: loaded from: classes.dex */
public class ZteFingerprintProviderImpl implements IZteFingerprintProvider {
    private static final String TAG = "ZteFingerprintProvider";
    final Context mContext;
    final FingerprintProvider mFingerprintProvider;
    final SensorList<Sensor> mFingerprintSensors;
    final String mTAG;
    final UdfpsDecoupleController mUdfpsDecoupleController;
    private IZtecmdDaemon mZtecmdDaemon;

    private class ZtecmdCallback extends IZtecmdCallback.Stub {
        /* synthetic */ ZtecmdCallback(ZteFingerprintProviderImpl r1, ZteFingerprintProviderImplIA r2) {
            this(r1);
        }

        private ZtecmdCallback(ZteFingerprintProviderImpl r1) {
        }

        @Override // vendor.zte.fingerprint.ztecmdaidl.IZtecmdCallback
        public void onTestResult(int cmdId, int para, int testResult) {
            Slog.d("FingerprintProvider", "ZtecmdCallback $ onTestResult: cmdId=" + cmdId + ", para=" + para + ", testResult=" + testResult);
        }

        @Override // vendor.zte.fingerprint.ztecmdaidl.IZtecmdCallback
        public int getInterfaceVersion() {
            return 1;
        }

        @Override // vendor.zte.fingerprint.ztecmdaidl.IZtecmdCallback
        public String getInterfaceHash() {
            return "9d0889b7ecde4c347e888c7c37b8fcd0f6c7970d";
        }
    }

    ZteFingerprintProviderImpl(Context context, FingerprintProvider fingerprintProvider, String tag) {
        this.mContext = context;
        this.mFingerprintProvider = fingerprintProvider;
        this.mUdfpsDecoupleController = new UdfpsDecoupleController(context, fingerprintProvider, fingerprintProvider.mFingerprintSensors);
        this.mFingerprintSensors = fingerprintProvider.mFingerprintSensors;
        this.mTAG = tag;
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.aidl.IZteFingerprintProvider
    public void binderDiedForZteCmd() {
        this.mZtecmdDaemon = null;
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.aidl.IZteFingerprintProvider
    public int setFpTestCmd(int cmd, int param) {
        IZtecmdDaemon ztecmdDaemon = getHalInstanceExt();     // Catch: Exception -> L16
        if (ztecmdDaemon != null) goto L6;
        Slog.d(this.mTAG, "setFpTestCmdAidl: IZtecmdDaemon is null");
        return -1;
    L6:
        if (cmd != 10) goto L21;
        if (param != 1) goto L21;
        BaseClientMonitor client = this.mFingerprintSensors.valueAt(0).getScheduler().getCurrentClient();     // Catch: Exception -> L16
        if ((client instanceof AuthenticationClient) == true) goto L11;
        Slog.e(this.mTAG, "setFpTestCmdAidl: not authenticate cmd=" + cmd + ", param=" + param);     // Catch: Exception -> L16
        ztecmdDaemon.zteCmd(cmd, param, 0, "fptest_cmd");     // Catch: Exception -> L16
    L22:
        return 1;
    L11:
        if (Utils.isKeyguard(this.mContext, client.getOwnerString()) == true) goto L18;
        if ("com.android.settings".equals(client.getOwnerString()) == true) goto L18;
        Slog.d(this.mTAG, "setFpTestCmdAidl: cmd=" + cmd + ", param1=" + param + ", parma2=1");     // Catch: Exception -> L16
        ztecmdDaemon.zteCmd(cmd, param, 1, "fptest_cmd");     // Catch: Exception -> L16
    L18:
        Slog.d(this.mTAG, "setFpTestCmdAidl: cmd=" + cmd + ", param1=" + param + ", parma2=0");     // Catch: Exception -> L16
        ztecmdDaemon.zteCmd(cmd, param, 0, "fptest_cmd");     // Catch: Exception -> L16
    L21:
        Slog.d(this.mTAG, "setFpTestCmdAidl: cmd=" + cmd + ", param1=" + param);     // Catch: Exception -> L16
        ztecmdDaemon.zteCmd(cmd, param, 0, "fptest_cmd");     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Slog.e(this.mTAG, "setFpTestCmdAidl: e=" + e);
        return -1;
    }

    private IZtecmdDaemon getHalInstanceExt() {
        if (this.mZtecmdDaemon != null) goto L5;
        IFingerprint daemon = this.mFingerprintProvider.getHalInstance();
        ZteFingerprintProviderImplIA r1 = null;
        if (daemon != null) goto L11;
        Slog.e(this.mTAG, "getHalInstanceExt: daemon is null!");
        return null;
    L11:
        if (this.mZtecmdDaemon != null) goto L28;
        IBinder ext = daemon.asBinder().getExtension();     // Catch: Exception -> L20
        if (ext == null) goto L23;
        String descriptor = ext.getInterfaceDescriptor();     // Catch: Exception -> L20
        if (descriptor != null) goto L17;
    L22:
        this.mZtecmdDaemon = IZtecmdDaemon.Stub.asInterface(ext);     // Catch: Exception -> L20
        this.mZtecmdDaemon.setNotify_zte(new ZtecmdCallback(this, r1));     // Catch: Exception -> L20
        goto L28
    L17:
        if (descriptor.equals(IZtecmdDaemon.DESCRIPTOR) == true) goto L22;
        Slog.w(this.mTAG, "getHalInstanceExt: ext binder is not right, but " + descriptor);     // Catch: Exception -> L20
        return null;
    L23:
        Slog.e(this.mTAG, "getHalInstanceExt: getExtension is null!");     // Catch: Exception -> L20
        return null;
    L20:
        e = move-exception;
        Slog.e(this.mTAG, "getHalInstanceExt: e=" + e);
        return null;
    L28:
        if (this.mZtecmdDaemon != null) goto L31;
        Slog.e(this.mTAG, "getHalInstanceExt: IZtecmdDaemon is null!");
        return null;
    L31:
        Slog.d(this.mTAG, "getHalInstanceExt: IZtecmdDaemon init success!");
        return this.mZtecmdDaemon;
    L5:
        return this.mZtecmdDaemon;
    }
}
