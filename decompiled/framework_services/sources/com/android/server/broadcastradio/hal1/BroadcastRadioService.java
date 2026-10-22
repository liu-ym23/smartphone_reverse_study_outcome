package com.android.server.broadcastradio.hal1;

import android.hardware.radio.ITuner;
import android.hardware.radio.ITunerCallback;
import android.hardware.radio.RadioManager;
import com.android.server.broadcastradio.RadioServiceUserController;
import com.android.server.utils.Slogf;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastRadioService {
    private static final String TAG = "BcRadio1Srv";
    private final Object mLock;
    private final long mNativeContext;
    private final RadioServiceUserController mUserController;

    private native void nativeFinalize(long r1);

    private native long nativeInit();

    private native List<RadioManager.ModuleProperties> nativeLoadModules(long r1);

    private native Tuner nativeOpenTuner(long r1, int r3, RadioManager.BandConfig r4, boolean r5, ITunerCallback r6);

    protected void finalize() throws Throwable {
        nativeFinalize(this.mNativeContext);
        super.finalize();
    }

    public BroadcastRadioService(RadioServiceUserController userController) {
        this.mNativeContext = nativeInit();
        this.mLock = new Object();
        userController.getClass();
        this.mUserController = userController;
    }

    public List<RadioManager.ModuleProperties> loadModules() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<RadioManager.ModuleProperties> r1 = nativeLoadModules(this.mNativeContext);     // Catch: Throwable -> L7
        r1.getClass();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public ITuner openTuner(int moduleId, RadioManager.BandConfig bandConfig, boolean withAudio, ITunerCallback callback) {
        if (this.mUserController.isCurrentOrSystemUser() == false) goto L17;
        Object r1 = this.mLock;
        monitor-enter(r1);
        Tuner r10 = nativeOpenTuner(this.mNativeContext, moduleId, bandConfig, withAudio, callback);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r10;
    L11:
        th = move-exception;
        Throwable r11 = th;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L11
        throw r11;
    L13:
        th = move-exception;
        r11 = th;
        goto L15
    L17:
        Slogf.e(TAG, "Cannot open tuner on HAL 1.x client for non-current user");
        throw new IllegalStateException("Cannot open tuner for non-current user");
    }
}
