package com.obric.cae.libs.multipath;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class CaeMultipathClient {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile CaeMultipathClient f31747e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeMultipathManager f31748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f31749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f31750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f31751d;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeMultipathClient f31752a;

        public a(CaeMultipathClient r1, Looper r2) {
            this.f31752a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            int r4 = r3.what;
            boolean r0 = true;
            if (r4 != 1) goto L5;
            CaeMultipathClient.a(this.f31752a);
            return;
        L5:
            if (r4 != 2) goto L17;
            CaeMultipathClient r2 = this.f31752a;
            if (r2.f31748a != null) goto L11;
            r0 = false;
        L11:
            if (r0 == true) goto L15;
            CaeMultipathClient.a(r2);
            return;
        L15:
            return;
        }
    }

    public CaeMultipathClient() {
        this.f31751d = false;
        a();
        this.f31750c.sendEmptyMessage(1);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static CaeMultipathClient getInstance() {
        if (f31747e != null) goto L15;
        monitor-enter(CaeMultipathClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f31747e != null) goto L9;
        f31747e = new CaeMultipathClient();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeMultipathClient.class);     // Catch: Throwable -> L11
    L15:
        return f31747e;
    }

    public final void a() {
        HandlerThread r0 = new HandlerThread("CaeMultipathConnectThread");
        this.f31749b = r0;
        r0.start();
        this.f31750c = new a(this, this.f31749b.getLooper());
    }

    public String getLatestNetworkTruth() {
        ICaeMultipathManager r3 = this.f31748a;
        if (r3 == null) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L15;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeMultipathClient", "Service not connected");
        return null;
    L15:
        return r3.getLatestNetworkTruth();
    L12:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeMultipathClient", "Failed to get latest network truth", e);
        return null;
    L5:
        r0 = false;
        goto L7
    }

    public boolean reportAssistantFailure() {
        ICaeMultipathManager r4 = this.f31748a;
        if (r4 == null) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L15;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeMultipathClient", "Service not connected");
        return false;
    L15:
        r4.reportAssistantFailure();     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeMultipathClient", "Failed to report assistant failure", e);
        return false;
    L5:
        r2 = false;
        goto L7
    }

    public boolean reportAssistantOperateApps(int[] r5) {
        ICaeMultipathManager r4 = this.f31748a;
        if (r4 == null) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L15;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeMultipathClient", "Service not connected");
        return false;
    L15:
        r4.reportAssistantOperateApps(r5);     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeMultipathClient", "Failed to report assistant operate apps", e);
        return false;
    L5:
        r2 = false;
        goto L7
    }

    public static void a(CaeMultipathClient r11) {
        if (r11.f31751d == false) goto L5;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CaeMultipathClient", "Already connecting, skipping");
        return;
    L5:
        r11.f31751d = true;
        IBinder r6 = ServiceManager.getService("cae_multipath");     // Catch: Throwable -> L23 Exception -> L25
        if (r6 != null) goto L34;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeMultipathClient", "Failed to get cae_multipath service binder");     // Catch: Throwable -> L23 Exception -> L25
        r11.f31750c.removeMessages(2);     // Catch: Throwable -> L23 Exception -> L25
        r11.f31750c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L23 Exception -> L25
    L27:
        r11.f31751d = false;
        return;
    L34:
        int r8 = ICaeMultipathManager.Stub.TRANSACTION_startMultipath;     // Catch: Exception -> L20 Throwable -> L23
        ICaeMultipathManager r0 = (ICaeMultipathManager) ZeusTransformUtils.preCheckCast(ICaeMultipathManager.Stub.class.getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r6}), ICaeMultipathManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L20 Throwable -> L23
        r11.f31748a = r0;     // Catch: Exception -> L20 Throwable -> L23
        if (r0 != null) goto L32;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeMultipathClient", "Failed to create service interface");     // Catch: Exception -> L20 Throwable -> L23
        r11.f31750c.removeMessages(2);     // Catch: Exception -> L20 Throwable -> L23
        r11.f31750c.sendEmptyMessageDelayed(2, 5000);     // Catch: Exception -> L20 Throwable -> L23
        goto L27
    L32:
        r6.linkToDeath(new com.obric.cae.libs.multipath.a(r11), 0);     // Catch: RemoteException -> L16 Throwable -> L23 Exception -> L25
    L18:
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CaeMultipathClient", "Connected to cae_multipath service");     // Catch: Throwable -> L23 Exception -> L25
        r11.f31751d = false;
        return;
    L16:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeMultipathClient", "Failed to link to death", e);     // Catch: Throwable -> L23 Exception -> L25
    L20:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeMultipathClient", "Failed to get Stub class or asInterface method", e);     // Catch: Throwable -> L23 Exception -> L25
        r11.f31750c.removeMessages(2);     // Catch: Throwable -> L23 Exception -> L25
        r11.f31750c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L23 Exception -> L25
    L25:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeMultipathClient", "Failed to connect to cae_multipath service", e);     // Catch: Throwable -> L23
        r11.f31750c.removeMessages(2);     // Catch: Throwable -> L23
        r11.f31750c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r11.f31751d = false;
        throw th;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_multipath_CaeMultipathClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
