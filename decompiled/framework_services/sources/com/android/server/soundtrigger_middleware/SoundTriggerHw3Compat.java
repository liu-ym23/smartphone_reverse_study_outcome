package com.android.server.soundtrigger_middleware;

import android.hardware.soundtrigger3.ISoundTriggerHw;
import android.hardware.soundtrigger3.ISoundTriggerHwCallback;
import android.hardware.soundtrigger3.ISoundTriggerHwGlobalCallback;
import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseRecognitionEvent;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.RecognitionEvent;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.PhraseRecognitionEventSys;
import android.media.soundtrigger_middleware.RecognitionEventSys;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceSpecificException;
import android.os.SystemClock;
import com.android.server.FgThread;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerHw3Compat implements ISoundTriggerHal {
    private final ISoundTriggerHw mDriver;
    private final Runnable mRebootRunnable;

    private static class GlobalCallbackAdaper extends ISoundTriggerHwGlobalCallback.Stub {
        private final ISoundTriggerHal.GlobalCallback mDelegate;

        public GlobalCallbackAdaper(ISoundTriggerHal.GlobalCallback callback) {
            this.mDelegate = callback;
        }

        public void onResourcesAvailable() {
            Executor r0 = FgThread.getExecutor();
            ISoundTriggerHal.GlobalCallback r1 = this.mDelegate;
            r1.getClass();
            r0.execute(new SoundTriggerHalConcurrentCaptureHandler$$ExternalSyntheticLambda0(r1));
        }

        public int getInterfaceVersion() {
            return 3;
        }

        public String getInterfaceHash() {
            return "f2ec48a74490bf9d5675f48cb89ecdb3e5cd9c35";
        }
    }

    private static class ModelCallbackAdaper extends ISoundTriggerHwCallback.Stub {
        private final ISoundTriggerHal.ModelCallback mDelegate;

        public ModelCallbackAdaper(ISoundTriggerHal.ModelCallback callback) {
            this.mDelegate = callback;
        }

        public void modelUnloaded(int model) {
            this.mDelegate.modelUnloaded(model);
        }

        public void phraseRecognitionCallback(int model, PhraseRecognitionEvent event) {
            RecognitionEvent r0 = event.common;
            boolean r1 = r0.recognitionStillActive;
            if (event.common.status != 3) goto L5;
            boolean r2 = true;
        L6:
            r0.recognitionStillActive = r1 | r2;
            PhraseRecognitionEventSys phraseRecognitionEventSys = new PhraseRecognitionEventSys();
            phraseRecognitionEventSys.phraseRecognitionEvent = event;
            phraseRecognitionEventSys.halEventReceivedMillis = SystemClock.elapsedRealtimeNanos();
            this.mDelegate.phraseRecognitionCallback(model, phraseRecognitionEventSys);
            return;
        L5:
            r2 = false;
            goto L6
        }

        public void recognitionCallback(int model, RecognitionEvent event) {
            boolean r0 = event.recognitionStillActive;
            if (event.status != 3) goto L5;
            boolean r1 = true;
        L6:
            event.recognitionStillActive = r0 | r1;
            RecognitionEventSys recognitionEventSys = new RecognitionEventSys();
            recognitionEventSys.recognitionEvent = event;
            recognitionEventSys.halEventReceivedMillis = SystemClock.elapsedRealtimeNanos();
            this.mDelegate.recognitionCallback(model, recognitionEventSys);
            return;
        L5:
            r1 = false;
            goto L6
        }

        public int getInterfaceVersion() {
            return 3;
        }

        public String getInterfaceHash() {
            return "f2ec48a74490bf9d5675f48cb89ecdb3e5cd9c35";
        }
    }

    public SoundTriggerHw3Compat(IBinder binder, Runnable rebootRunnable) {
        this.mDriver = ISoundTriggerHw.Stub.asInterface(binder);
        this.mRebootRunnable = rebootRunnable;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public Properties getProperties() {
        return this.mDriver.getProperties();
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void registerCallback(ISoundTriggerHal.GlobalCallback callback) {
        this.mDriver.registerGlobalCallback(new GlobalCallbackAdaper(callback));     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadSoundModel(SoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        return this.mDriver.loadSoundModel(soundModel, new ModelCallbackAdaper(callback));
    L6:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L4:
        e = move-exception;
        if (e.errorCode == 1) goto L11;
        throw e;
    L11:
        throw new RecoverableException(1);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadPhraseSoundModel(PhraseSoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        return this.mDriver.loadPhraseSoundModel(soundModel, new ModelCallbackAdaper(callback));
    L6:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L4:
        e = move-exception;
        if (e.errorCode == 1) goto L11;
        throw e;
    L11:
        throw new RecoverableException(1);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unloadSoundModel(int modelHandle) {
        this.mDriver.unloadSoundModel(modelHandle);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void startRecognition(int modelHandle, int deviceHandle, int ioHandle, RecognitionConfig config) {
        this.mDriver.startRecognition(modelHandle, deviceHandle, ioHandle, config);     // Catch: ServiceSpecificException -> L4 RemoteException -> L6
        return;
    L4:
        e = move-exception;
        if (e.errorCode == 1) goto L11;
        throw e;
    L11:
        throw new RecoverableException(1);
    L6:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void stopRecognition(int modelHandle) {
        this.mDriver.stopRecognition(modelHandle);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void forceRecognitionEvent(int modelHandle) {
        this.mDriver.forceRecognitionEvent(modelHandle);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public ModelParameterRange queryParameter(int modelHandle, int param) {
        return this.mDriver.queryParameter(modelHandle, param);
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int getModelParameter(int modelHandle, int param) {
        return this.mDriver.getParameter(modelHandle, param);
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void setModelParameter(int modelHandle, int param, int value) {
        this.mDriver.setParameter(modelHandle, param, value);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public String interfaceDescriptor() {
        return this.mDriver.asBinder().getInterfaceDescriptor();
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void linkToDeath(IBinder.DeathRecipient recipient) {
        this.mDriver.asBinder().linkToDeath(recipient, 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unlinkToDeath(IBinder.DeathRecipient recipient) {
        this.mDriver.asBinder().unlinkToDeath(recipient, 0);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void flushCallbacks() {
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void clientAttached(IBinder binder) {
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void clientDetached(IBinder binder) {
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void reboot() {
        this.mRebootRunnable.run();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void detach() {
    }
}
