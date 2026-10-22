package com.android.server.biometrics.sensors.face.aidl;

import android.content.ContentResolver;
import android.content.Context;
import android.hardware.biometrics.face.ISession;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.ErrorConsumer;
import com.android.server.biometrics.sensors.HalClientMonitor;
import com.android.server.biometrics.sensors.face.hidl.HidlToAidlSessionAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FaceGetFeatureClient extends HalClientMonitor<AidlSession> implements ErrorConsumer {
    private static final String TAG = "FaceGetFeatureClient";
    private final int mFeature;
    private final int mUserId;

    public FaceGetFeatureClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, ClientMonitorCallbackConverter listener, int userId, String owner, int sensorId, BiometricLogger logger, BiometricContext biometricContext, int feature) {
        super(context, lazyDaemon, token, listener, userId, owner, 0, sensorId, logger, biometricContext, false);
        this.mUserId = userId;
        this.mFeature = feature;
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    public void unableToStart() {
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        startHalOperation();
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        ISession session = getFreshDaemon().getSession();     // Catch: RemoteException -> L5
        if ((session instanceof HidlToAidlSessionAdapter) == false) goto L7;
        ((HidlToAidlSessionAdapter) session).setFeature(this.mFeature);     // Catch: RemoteException -> L5
    L7:
        session.getFeatures();     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Unable to getFeature", e);
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 9;
    }

    public void onFeatureGet(boolean success, byte[] features) {
        HashMap<Integer, Boolean> featureMap = getFeatureMap();     // Catch: Throwable -> L7
        int[] featuresToSend = new int[featureMap.size()];     // Catch: Throwable -> L7
        boolean[] featureState = new boolean[featureMap.size()];     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= features.length) goto L9;
        featureMap.put(Integer.valueOf(AidlConversionUtils.convertAidlToFrameworkFeature(features[i])), true);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        int i2 = 0;
        Iterator<Map.Entry<Integer, Boolean>> r6 = featureMap.entrySet().iterator();     // Catch: Throwable -> L7
    L11:
        if (r6.hasNext() == false) goto L13;
        Map.Entry<Integer, Boolean> entry = r6.next();     // Catch: Throwable -> L7
        featuresToSend[i2] = entry.getKey().intValue();     // Catch: Throwable -> L7
        featureState[i2] = entry.getValue().booleanValue();     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        goto L11
    L13:
        boolean attentionEnabled = featureMap.get(1).booleanValue();     // Catch: Throwable -> L7
        Slog.d(TAG, "Updating attention value for user: " + this.mUserId + " to value: " + attentionEnabled);     // Catch: Throwable -> L7
        ContentResolver r8 = getContext().getContentResolver();     // Catch: Throwable -> L7
        if (attentionEnabled == false) goto L16;
        int r10 = 1;
    L17:
        Settings.Secure.putIntForUser(r8, "face_unlock_attention_required", r10, this.mUserId);     // Catch: Throwable -> L7
        getListener().onFeatureGet(success, featuresToSend, featureState);     // Catch: Throwable -> L7
        this.mCallback.onClientFinished(this, true);
        return;
    L16:
        r10 = 0;
    L7:
        e = move-exception;
        Slog.e(TAG, "exception", e);
        this.mCallback.onClientFinished(this, false);
    }

    private HashMap<Integer, Boolean> getFeatureMap() {
        HashMap<Integer, Boolean> featureMap = new HashMap();
        featureMap.put(1, false);
        return featureMap;
    }

    @Override // com.android.server.biometrics.sensors.ErrorConsumer
    public void onError(int errorCode, int vendorCode) {
        getListener().onFeatureGet(false, new int[0], new boolean[0]);     // Catch: RemoteException -> L5
    L7:
        this.mCallback.onClientFinished(this, false);
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Remote exception", e);
        goto L7
    }
}
