package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.PhraseRecognitionEventSys;
import android.media.soundtrigger_middleware.RecognitionEventSys;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.util.Slog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerHalEnforcer implements ISoundTriggerHal {
    private static final String TAG = "SoundTriggerHalEnforcer";
    private final Map<Integer, ModelState> mModelStates;
    private final ISoundTriggerHal mUnderlying;

    private class ModelCallbackEnforcer implements ISoundTriggerHal.ModelCallback {
        private final ISoundTriggerHal.ModelCallback mUnderlying;
        final /* synthetic */ SoundTriggerHalEnforcer this$0;

        /* synthetic */ ModelCallbackEnforcer(SoundTriggerHalEnforcer r1, ISoundTriggerHal.ModelCallback r2, SoundTriggerHalEnforcerIA r3) {
            this(r1, r2);
        }

        private ModelCallbackEnforcer(SoundTriggerHalEnforcer r1, ISoundTriggerHal.ModelCallback underlying) {
            this.this$0 = r1;
            this.mUnderlying = underlying;
        }

        @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal.ModelCallback
        public void recognitionCallback(int model, RecognitionEventSys event) {
            Map r0 = SoundTriggerHalEnforcer.m8254$$Nest$fgetmModelStates(this.this$0);
            monitor-enter(r0);
            ModelState state = (ModelState) SoundTriggerHalEnforcer.m8254$$Nest$fgetmModelStates(this.this$0).get(Integer.valueOf(model));     // Catch: Throwable -> L9
            if (state != null) goto L12;
            Slog.wtfStack(SoundTriggerHalEnforcer.TAG, "Unexpected recognition event for model: " + model);     // Catch: Throwable -> L9
            this.this$0.reboot();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            if (event.recognitionEvent.recognitionStillActive == false) goto L21;
            if (event.recognitionEvent.status == 0) goto L21;
            if (event.recognitionEvent.status == 3) goto L21;
            Slog.wtfStack(SoundTriggerHalEnforcer.TAG, "recognitionStillActive is only allowed when the recognition status is SUCCESS");     // Catch: Throwable -> L9
            this.this$0.reboot();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L21:
            if (event.recognitionEvent.recognitionStillActive == true) goto L23;
            SoundTriggerHalEnforcer.m8254$$Nest$fgetmModelStates(this.this$0).replace(Integer.valueOf(model), ModelState.INACTIVE);     // Catch: Throwable -> L9
        L23:
            monitor-exit(r0);     // Catch: Throwable -> L9
            this.mUnderlying.recognitionCallback(model, event);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal.ModelCallback
        public void phraseRecognitionCallback(int model, PhraseRecognitionEventSys event) {
            Map r0 = SoundTriggerHalEnforcer.m8254$$Nest$fgetmModelStates(this.this$0);
            monitor-enter(r0);
            ModelState state = (ModelState) SoundTriggerHalEnforcer.m8254$$Nest$fgetmModelStates(this.this$0).get(Integer.valueOf(model));     // Catch: Throwable -> L9
            if (state != null) goto L12;
            Slog.wtfStack(SoundTriggerHalEnforcer.TAG, "Unexpected recognition event for model: " + model);     // Catch: Throwable -> L9
            this.this$0.reboot();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            if (event.phraseRecognitionEvent.common.recognitionStillActive == false) goto L21;
            if (event.phraseRecognitionEvent.common.status == 0) goto L21;
            if (event.phraseRecognitionEvent.common.status == 3) goto L21;
            Slog.wtfStack(SoundTriggerHalEnforcer.TAG, "recognitionStillActive is only allowed when the recognition status is SUCCESS");     // Catch: Throwable -> L9
            this.this$0.reboot();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L21:
            if (event.phraseRecognitionEvent.common.recognitionStillActive == true) goto L23;
            SoundTriggerHalEnforcer.m8254$$Nest$fgetmModelStates(this.this$0).replace(Integer.valueOf(model), ModelState.INACTIVE);     // Catch: Throwable -> L9
        L23:
            monitor-exit(r0);     // Catch: Throwable -> L9
            this.mUnderlying.phraseRecognitionCallback(model, event);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal.ModelCallback
        public void modelUnloaded(int modelHandle) {
            Map r0 = SoundTriggerHalEnforcer.m8254$$Nest$fgetmModelStates(this.this$0);
            monitor-enter(r0);
            ModelState state = (ModelState) SoundTriggerHalEnforcer.m8254$$Nest$fgetmModelStates(this.this$0).get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L9
            if (state != null) goto L12;
            Slog.wtfStack(SoundTriggerHalEnforcer.TAG, "Unexpected unload event for model: " + modelHandle);     // Catch: Throwable -> L9
            this.this$0.reboot();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            if (state != ModelState.ACTIVE) goto L16;
            Slog.wtfStack(SoundTriggerHalEnforcer.TAG, "Trying to unload an active model: " + modelHandle);     // Catch: Throwable -> L9
            this.this$0.reboot();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L16:
            SoundTriggerHalEnforcer.m8254$$Nest$fgetmModelStates(this.this$0).remove(Integer.valueOf(modelHandle));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            this.mUnderlying.modelUnloaded(modelHandle);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    private static final enum ModelState extends Enum<ModelState> {
        private static final /* synthetic */ ModelState[] $VALUES = null;
        public static final ModelState ACTIVE = null;
        public static final ModelState INACTIVE = null;
        public static final ModelState PENDING_STOP = null;

        private static /* synthetic */ ModelState[] $values() {
            return new ModelState[]{INACTIVE, ACTIVE, PENDING_STOP};
        }

        private ModelState(String r1, int r2) {
            super(r1, r2);
        }

        public static ModelState valueOf(String name) {
            return (ModelState) Enum.valueOf(ModelState.class, name);
        }

        public static ModelState[] values() {
            return (ModelState[]) $VALUES.clone();
        }

        static {
            INACTIVE = new ModelState("INACTIVE", 0);
            ACTIVE = new ModelState("ACTIVE", 1);
            PENDING_STOP = new ModelState("PENDING_STOP", 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmModelStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m8254$$Nest$fgetmModelStates(SoundTriggerHalEnforcer r0) {
        return r0.mModelStates;
    }

    public SoundTriggerHalEnforcer(ISoundTriggerHal underlying) {
        this.mModelStates = new HashMap();
        this.mUnderlying = underlying;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public Properties getProperties() {
        return this.mUnderlying.getProperties();
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void registerCallback(ISoundTriggerHal.GlobalCallback callback) {
        this.mUnderlying.registerCallback(callback);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadSoundModel(SoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        Map<Integer, ModelState> r0 = this.mModelStates;     // Catch: RuntimeException -> L10
        monitor-enter(r0);     // Catch: RuntimeException -> L10
        int handle = this.mUnderlying.loadSoundModel(soundModel, new ModelCallbackEnforcer(this, callback, null));     // Catch: Throwable -> L7
        this.mModelStates.put(Integer.valueOf(handle), ModelState.INACTIVE);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return handle;
    L7:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L10
    L10:
        e = move-exception;
        throw handleException(e);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadPhraseSoundModel(PhraseSoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        Map<Integer, ModelState> r0 = this.mModelStates;     // Catch: RuntimeException -> L10
        monitor-enter(r0);     // Catch: RuntimeException -> L10
        int handle = this.mUnderlying.loadPhraseSoundModel(soundModel, new ModelCallbackEnforcer(this, callback, null));     // Catch: Throwable -> L7
        this.mModelStates.put(Integer.valueOf(handle), ModelState.INACTIVE);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return handle;
    L7:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L10
    L10:
        e = move-exception;
        throw handleException(e);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unloadSoundModel(int modelHandle) {
        this.mUnderlying.unloadSoundModel(modelHandle);     // Catch: RuntimeException -> L10
        Map<Integer, ModelState> r0 = this.mModelStates;     // Catch: RuntimeException -> L10
        monitor-enter(r0);     // Catch: RuntimeException -> L10
        this.mModelStates.remove(Integer.valueOf(modelHandle));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L10
    L10:
        e = move-exception;
        throw handleException(e);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void stopRecognition(int modelHandle) {
        Map<Integer, ModelState> r0 = this.mModelStates;     // Catch: RuntimeException -> L14
        monitor-enter(r0);     // Catch: RuntimeException -> L14
        this.mModelStates.replace(Integer.valueOf(modelHandle), ModelState.PENDING_STOP);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        this.mUnderlying.stopRecognition(modelHandle);     // Catch: RuntimeException -> L14
        Map<Integer, ModelState> r1 = this.mModelStates;     // Catch: RuntimeException -> L14
        monitor-enter(r1);     // Catch: RuntimeException -> L14
        this.mModelStates.replace(Integer.valueOf(modelHandle), ModelState.INACTIVE);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L14
    L16:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L14
    L14:
        e = move-exception;
        throw handleException(e);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void startRecognition(int modelHandle, int deviceHandle, int ioHandle, RecognitionConfig config) {
        Map<Integer, ModelState> r0 = this.mModelStates;     // Catch: RuntimeException -> L10
        monitor-enter(r0);     // Catch: RuntimeException -> L10
        this.mUnderlying.startRecognition(modelHandle, deviceHandle, ioHandle, config);     // Catch: Throwable -> L7
        this.mModelStates.replace(Integer.valueOf(modelHandle), ModelState.ACTIVE);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L10
    L10:
        e = move-exception;
        throw handleException(e);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void forceRecognitionEvent(int modelHandle) {
        this.mUnderlying.forceRecognitionEvent(modelHandle);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int getModelParameter(int modelHandle, int param) {
        return this.mUnderlying.getModelParameter(modelHandle, param);
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void setModelParameter(int modelHandle, int param, int value) {
        this.mUnderlying.setModelParameter(modelHandle, param, value);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        throw handleException(e);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public ModelParameterRange queryParameter(int modelHandle, int param) {
        return this.mUnderlying.queryParameter(modelHandle, param);
    L4:
        e = move-exception;
        throw handleException(e);
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

    private RuntimeException handleException(RuntimeException e) {
        if ((e instanceof RecoverableException) == false) goto L5;
        throw e;
    L5:
        if ((e.getCause() instanceof DeadObjectException) == false) goto L8;
        Slog.e(TAG, "HAL died");
        throw new RecoverableException(4);
    L8:
        Slog.e(TAG, "Exception caught from HAL, rebooting HAL");
        reboot();
        throw e;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void reboot() {
        this.mUnderlying.reboot();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void detach() {
        this.mUnderlying.detach();
    }
}
