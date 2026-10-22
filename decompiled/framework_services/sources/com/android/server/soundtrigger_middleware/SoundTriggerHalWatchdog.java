package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.os.IBinder;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerHalWatchdog implements ISoundTriggerHal {
    private static final String TAG = "SoundTriggerHalWatchdog";
    private static final long TIMEOUT_MS = 3000;
    private final UptimeTimer mTimer;
    private final ISoundTriggerHal mUnderlying;

    private class Watchdog implements AutoCloseable {
        private final Exception mException;
        private final UptimeTimer.Task mTask;
        final /* synthetic */ SoundTriggerHalWatchdog this$0;

        /* JADX INFO: renamed from: $r8$lambda$mMwEu2Uln443_35_--eYfPlSriU, reason: not valid java name */
        public static /* synthetic */ void m8256$r8$lambda$mMwEu2Uln443_35_eYfPlSriU(Watchdog r0) {
            r0.lambda$new$0();
        }

        Watchdog(SoundTriggerHalWatchdog r4) {
            this.this$0 = r4;
            this.mException = new Exception();
            this.mTask = SoundTriggerHalWatchdog.m8255$$Nest$fgetmTimer(r4).createTask(new SoundTriggerHalWatchdog$Watchdog$$ExternalSyntheticLambda0(this), 3000);
        }

        private /* synthetic */ void lambda$new$0() {
            Slog.e(SoundTriggerHalWatchdog.TAG, "HAL deadline expired. Rebooting.", this.mException);
            this.this$0.reboot();
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            this.mTask.cancel();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTimer, reason: not valid java name */
    static /* bridge */ /* synthetic */ UptimeTimer m8255$$Nest$fgetmTimer(SoundTriggerHalWatchdog r0) {
        return r0.mTimer;
    }

    public SoundTriggerHalWatchdog(ISoundTriggerHal underlying) {
        underlying.getClass();
        this.mUnderlying = underlying;
        this.mTimer = new UptimeTimer(TAG);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public Properties getProperties() {
        Watchdog ignore = new Watchdog(this);
        Properties r1 = this.mUnderlying.getProperties();     // Catch: Throwable -> L6
        ignore.close();
        return r1;
    L6:
        th = move-exception;
        ignore.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void registerCallback(ISoundTriggerHal.GlobalCallback callback) {
        Watchdog ignore = new Watchdog(this);
        this.mUnderlying.registerCallback(callback);     // Catch: Throwable -> L6
        ignore.close();
        return;
    L6:
        th = move-exception;
        ignore.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadSoundModel(SoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        Watchdog ignore = new Watchdog(this);
        int r1 = this.mUnderlying.loadSoundModel(soundModel, callback);     // Catch: Throwable -> L6
        ignore.close();
        return r1;
    L6:
        th = move-exception;
        ignore.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadPhraseSoundModel(PhraseSoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        Watchdog ignore = new Watchdog(this);
        int r1 = this.mUnderlying.loadPhraseSoundModel(soundModel, callback);     // Catch: Throwable -> L6
        ignore.close();
        return r1;
    L6:
        th = move-exception;
        ignore.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unloadSoundModel(int modelHandle) {
        Watchdog ignore = new Watchdog(this);
        this.mUnderlying.unloadSoundModel(modelHandle);     // Catch: Throwable -> L6
        ignore.close();
        return;
    L6:
        th = move-exception;
        ignore.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void stopRecognition(int modelHandle) {
        Watchdog ignore = new Watchdog(this);
        this.mUnderlying.stopRecognition(modelHandle);     // Catch: Throwable -> L6
        ignore.close();
        return;
    L6:
        th = move-exception;
        ignore.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void startRecognition(int modelHandle, int deviceHandle, int ioHandle, RecognitionConfig config) {
        Watchdog ignore = new Watchdog(this);
        this.mUnderlying.startRecognition(modelHandle, deviceHandle, ioHandle, config);     // Catch: Throwable -> L6
        ignore.close();
        return;
    L6:
        th = move-exception;
        ignore.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void forceRecognitionEvent(int modelHandle) {
        Watchdog ignore = new Watchdog(this);
        this.mUnderlying.forceRecognitionEvent(modelHandle);     // Catch: Throwable -> L6
        ignore.close();
        return;
    L6:
        th = move-exception;
        ignore.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int getModelParameter(int modelHandle, int param) {
        Watchdog ignore = new Watchdog(this);
        int r1 = this.mUnderlying.getModelParameter(modelHandle, param);     // Catch: Throwable -> L6
        ignore.close();
        return r1;
    L6:
        th = move-exception;
        ignore.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void setModelParameter(int modelHandle, int param, int value) {
        Watchdog ignore = new Watchdog(this);
        this.mUnderlying.setModelParameter(modelHandle, param, value);     // Catch: Throwable -> L6
        ignore.close();
        return;
    L6:
        th = move-exception;
        ignore.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public ModelParameterRange queryParameter(int modelHandle, int param) {
        Watchdog ignore = new Watchdog(this);
        ModelParameterRange r1 = this.mUnderlying.queryParameter(modelHandle, param);     // Catch: Throwable -> L6
        ignore.close();
        return r1;
    L6:
        th = move-exception;
        ignore.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void linkToDeath(IBinder.DeathRecipient recipient) {
        this.mUnderlying.linkToDeath(recipient);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unlinkToDeath(IBinder.DeathRecipient recipient) {
        this.mUnderlying.unlinkToDeath(recipient);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public String interfaceDescriptor() {
        return this.mUnderlying.interfaceDescriptor();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void flushCallbacks() {
        this.mUnderlying.flushCallbacks();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void clientAttached(IBinder binder) {
        this.mUnderlying.clientAttached(binder);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void clientDetached(IBinder binder) {
        this.mUnderlying.clientDetached(binder);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void reboot() {
        this.mUnderlying.reboot();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void detach() {
        this.mUnderlying.detach();
        this.mTimer.quit();
    }
}
