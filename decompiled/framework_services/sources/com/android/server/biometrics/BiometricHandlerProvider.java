package com.android.server.biometrics;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public class BiometricHandlerProvider {
    private static final BiometricHandlerProvider sBiometricHandlerProvider = null;
    private Handler mBiometricsCallbackHandler;
    private Handler mFaceHandler;
    private Handler mFingerprintHandler;

    static {
        sBiometricHandlerProvider = new BiometricHandlerProvider();
    }

    public static BiometricHandlerProvider getInstance() {
        return sBiometricHandlerProvider;
    }

    private BiometricHandlerProvider() {
    }

    public synchronized Handler getBiometricCallbackHandler() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mBiometricsCallbackHandler != null) goto L8;
        this.mBiometricsCallbackHandler = getNewHandler("BiometricsCallbackHandler", -4);     // Catch: Throwable -> L6
    L8:
        Handler r0 = this.mBiometricsCallbackHandler;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    }

    public synchronized Handler getFaceHandler() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mFaceHandler != null) goto L8;
        this.mFaceHandler = getNewHandler("FaceHandler", 0);     // Catch: Throwable -> L6
    L8:
        Handler r0 = this.mFaceHandler;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    }

    public synchronized Handler getFingerprintHandler() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mFingerprintHandler != null) goto L8;
        this.mFingerprintHandler = getNewHandler("FingerprintHandler", 0);     // Catch: Throwable -> L6
    L8:
        Handler r0 = this.mFingerprintHandler;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    }

    private Handler getNewHandler(String tag, int priority) {
        HandlerThread handlerThread = new HandlerThread(tag, priority);
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }
}
