package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerDuplicateModelHandler implements ISoundTriggerHal {
    private final ISoundTriggerHal mDelegate;
    private ISoundTriggerHal.GlobalCallback mGlobalCallback;
    private final List<ModelData> mModelList;

    private static final class ModelData {
        private int mModelId;
        private String mUuid;
        private boolean mWasContended;

        ModelData(int modelId, String uuid) {
            this.mWasContended = false;
            this.mModelId = modelId;
            this.mUuid = uuid;
        }

        int getModelId() {
            return this.mModelId;
        }

        String getUuid() {
            return this.mUuid;
        }

        boolean getWasContended() {
            return this.mWasContended;
        }

        void setWasContended() {
            this.mWasContended = true;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$V7Lvj05OSCYFyDiIiDGWhmH6NIU(String r0, ModelData r1) {
        return lambda$checkDuplicateModelUuid$0(r0, r1);
    }

    public SoundTriggerDuplicateModelHandler(ISoundTriggerHal delegate) {
        this.mModelList = new ArrayList();
        this.mDelegate = delegate;
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
        checkDuplicateModelUuid(soundModel.uuid);     // Catch: Throwable -> L6
        int result = this.mDelegate.loadSoundModel(soundModel, callback);     // Catch: Throwable -> L6
        this.mModelList.add(new ModelData(result, soundModel.uuid));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return result;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadPhraseSoundModel(PhraseSoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        monitor-enter(this);
        checkDuplicateModelUuid(soundModel.common.uuid);     // Catch: Throwable -> L6
        int result = this.mDelegate.loadPhraseSoundModel(soundModel, callback);     // Catch: Throwable -> L6
        this.mModelList.add(new ModelData(result, soundModel.common.uuid));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return result;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unloadSoundModel(int modelHandle) {
        this.mDelegate.unloadSoundModel(modelHandle);
        int i = 0;
    L4:
        if (i >= this.mModelList.size()) goto L13;
        if (this.mModelList.get(i).getModelId() == modelHandle) goto L7;
        i = i + 1;
        goto L4
    L7:
        ModelData modelData = this.mModelList.remove(i);
        if (modelData.getWasContended() == false) goto L16;
        this.mGlobalCallback.onResourcesAvailable();
        return;
    L16:
        return;
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

    private void checkDuplicateModelUuid(final String uuid) {
        Optional<ModelData> model = this.mModelList.stream().filter(new SoundTriggerDuplicateModelHandler$$ExternalSyntheticLambda0(uuid)).findFirst();
        if (model.isPresent() == true) goto L5;
        return;
    L5:
        model.get().setWasContended();
        throw new RecoverableException(1);
    }

    private static /* synthetic */ boolean lambda$checkDuplicateModelUuid$0(String uuid, ModelData x) {
        return x.getUuid().equals(uuid);
    }
}
