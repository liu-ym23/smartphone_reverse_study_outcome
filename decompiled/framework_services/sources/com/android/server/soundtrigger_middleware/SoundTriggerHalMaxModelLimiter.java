package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerHalMaxModelLimiter implements ISoundTriggerHal {
    private final ISoundTriggerHal mDelegate;
    private ISoundTriggerHal.GlobalCallback mGlobalCallback;
    private final int mMaxModels;
    private int mNumLoadedModels;

    public SoundTriggerHalMaxModelLimiter(ISoundTriggerHal delegate, int maxModels) {
        this.mNumLoadedModels = 0;
        this.mDelegate = delegate;
        this.mMaxModels = maxModels;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void reboot() {
        this.mDelegate.reboot();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void detach() {
        this.mDelegate.detach();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public Properties getProperties() {
        return this.mDelegate.getProperties();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void registerCallback(ISoundTriggerHal.GlobalCallback callback) {
        this.mGlobalCallback = callback;
        this.mDelegate.registerCallback(this.mGlobalCallback);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadSoundModel(SoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mNumLoadedModels == this.mMaxModels) goto L11;
        int result = this.mDelegate.loadSoundModel(soundModel, callback);     // Catch: Throwable -> L8
        this.mNumLoadedModels++;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return result;
    L11:
        throw new RecoverableException(1);     // Catch: Throwable -> L8
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadPhraseSoundModel(PhraseSoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mNumLoadedModels == this.mMaxModels) goto L11;
        int result = this.mDelegate.loadPhraseSoundModel(soundModel, callback);     // Catch: Throwable -> L8
        this.mNumLoadedModels++;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return result;
    L11:
        throw new RecoverableException(1);     // Catch: Throwable -> L8
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unloadSoundModel(int modelHandle) {
        monitor-enter(this);
        int r0 = this.mNumLoadedModels;     // Catch: Throwable -> L20
        this.mNumLoadedModels = r0 - 1;     // Catch: Throwable -> L20
        if (r0 != this.mMaxModels) goto L6;
        boolean wasAtMaxCapacity = true;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L20
        this.mDelegate.unloadSoundModel(modelHandle);     // Catch: Exception -> L12
        if (wasAtMaxCapacity == false) goto L29;
        this.mGlobalCallback.onResourcesAvailable();
        return;
    L29:
        return;
    L12:
        e = move-exception;
        monitor-enter(this);
        this.mNumLoadedModels++;     // Catch: Throwable -> L17
        throw e;
    L17:
        th = move-exception;
        throw th;
    L6:
        wasAtMaxCapacity = false;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void stopRecognition(int modelHandle) {
        this.mDelegate.stopRecognition(modelHandle);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void startRecognition(int modelHandle, int deviceHandle, int ioHandle, RecognitionConfig config) {
        this.mDelegate.startRecognition(modelHandle, deviceHandle, ioHandle, config);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void forceRecognitionEvent(int modelHandle) {
        this.mDelegate.forceRecognitionEvent(modelHandle);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int getModelParameter(int modelHandle, int param) {
        return this.mDelegate.getModelParameter(modelHandle, param);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void setModelParameter(int modelHandle, int param, int value) {
        this.mDelegate.setModelParameter(modelHandle, param, value);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public ModelParameterRange queryParameter(int modelHandle, int param) {
        return this.mDelegate.queryParameter(modelHandle, param);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void linkToDeath(IBinder.DeathRecipient recipient) {
        this.mDelegate.linkToDeath(recipient);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unlinkToDeath(IBinder.DeathRecipient recipient) {
        this.mDelegate.unlinkToDeath(recipient);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public String interfaceDescriptor() {
        return this.mDelegate.interfaceDescriptor();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void flushCallbacks() {
        this.mDelegate.flushCallbacks();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void clientAttached(IBinder binder) {
        this.mDelegate.clientAttached(binder);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void clientDetached(IBinder binder) {
        this.mDelegate.clientDetached(binder);
    }
}
