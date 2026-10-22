package com.android.server.soundtrigger_middleware;

import android.hardware.soundtrigger.V2_0.ISoundTriggerHw;
import android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback;
import android.hardware.soundtrigger.V2_3.OptionalModelParameterRange;
import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.PhraseRecognitionEventSys;
import android.media.soundtrigger_middleware.RecognitionEventSys;
import android.os.IBinder;
import android.os.IHwBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.system.OsConstants;
import android.util.Slog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class SoundTriggerHw2Compat implements ISoundTriggerHal {
    private static final String TAG = "SoundTriggerHw2Compat";
    private final IHwBinder mBinder;
    private final Map<IBinder.DeathRecipient, IHwBinder.DeathRecipient> mDeathRecipientMap;
    private final ConcurrentMap<Integer, ISoundTriggerHal.ModelCallback> mModelCallbacks;
    private final Properties mProperties;
    private final Runnable mRebootRunnable;
    private ISoundTriggerHw mUnderlying_2_0;
    private android.hardware.soundtrigger.V2_1.ISoundTriggerHw mUnderlying_2_1;
    private android.hardware.soundtrigger.V2_2.ISoundTriggerHw mUnderlying_2_2;
    private android.hardware.soundtrigger.V2_3.ISoundTriggerHw mUnderlying_2_3;

    private static class ModelCallbackWrapper extends ISoundTriggerHwCallback.Stub {
        private final ISoundTriggerHal.ModelCallback mDelegate;

        /* synthetic */ ModelCallbackWrapper(ISoundTriggerHal.ModelCallback r1, SoundTriggerHw2CompatIA r2) {
            this(r1);
        }

        private ModelCallbackWrapper(ISoundTriggerHal.ModelCallback delegate) {
            delegate.getClass();
            this.mDelegate = delegate;
        }

        @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback
        public void recognitionCallback_2_1(ISoundTriggerHwCallback.RecognitionEvent event, int cookie) {
            RecognitionEventSys eventSys = new RecognitionEventSys();
            eventSys.recognitionEvent = ConversionUtil.hidl2aidlRecognitionEvent(event);
            eventSys.halEventReceivedMillis = SystemClock.elapsedRealtime();
            this.mDelegate.recognitionCallback(event.header.model, eventSys);
        }

        @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback
        public void phraseRecognitionCallback_2_1(ISoundTriggerHwCallback.PhraseRecognitionEvent event, int cookie) {
            PhraseRecognitionEventSys eventSys = new PhraseRecognitionEventSys();
            eventSys.phraseRecognitionEvent = ConversionUtil.hidl2aidlPhraseRecognitionEvent(event);
            eventSys.halEventReceivedMillis = SystemClock.elapsedRealtime();
            this.mDelegate.phraseRecognitionCallback(event.common.header.model, eventSys);
        }

        @Override // android.hardware.soundtrigger.V2_1.ISoundTriggerHwCallback
        public void soundModelCallback_2_1(ISoundTriggerHwCallback.ModelEvent event, int cookie) {
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback
        public void recognitionCallback(android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback.RecognitionEvent event, int cookie) {
            ISoundTriggerHwCallback.RecognitionEvent event_2_1 = Hw2CompatUtil.convertRecognitionEvent_2_0_to_2_1(event);
            recognitionCallback_2_1(event_2_1, cookie);
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback
        public void phraseRecognitionCallback(android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback.PhraseRecognitionEvent event, int cookie) {
            ISoundTriggerHwCallback.PhraseRecognitionEvent event_2_1 = Hw2CompatUtil.convertPhraseRecognitionEvent_2_0_to_2_1(event);
            phraseRecognitionCallback_2_1(event_2_1, cookie);
        }

        @Override // android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback
        public void soundModelCallback(android.hardware.soundtrigger.V2_0.ISoundTriggerHwCallback.ModelEvent event, int cookie) {
        }
    }

    private static class NotSupported extends Exception {
        NotSupported(String message) {
            super(message);
        }

        RecoverableException throwAsRecoverableException() {
            throw new RecoverableException(2, getMessage());
        }
    }

    public static /* synthetic */ void $r8$lambda$9haPk7j7dtwnoAHwbx8690skM1Y(AtomicInteger r0, AtomicInteger r1, int r2, int r3) {
        lambda$loadSoundModel_2_0$7(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$A4BrqWquKPBqezAkT33LO6zQEhQ(AtomicInteger r0, AtomicInteger r1, int r2, int r3) {
        lambda$loadSoundModel$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$MG6UmWvdj7aG3UzL3X_MRJEwRs4(AtomicInteger r0, AtomicReference r1, int r2, OptionalModelParameterRange r3) {
        lambda$queryParameter$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$MjCM49VkkZDAPGeNHPuefSKPjFY(IBinder.DeathRecipient r0, long r1) {
        lambda$linkToDeath$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$My_51mdMqfVt9tFj6Dvb1i6Eo7s(AtomicInteger r0, AtomicInteger r1, int r2, int r3) {
        lambda$getModelParameter$3(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$WmxvGrR7wyO3fcw-rc1y3_enelo, reason: not valid java name */
    public static /* synthetic */ void m8257$r8$lambda$WmxvGrR7wyO3fcwrc1y3_enelo(AtomicInteger r0, AtomicReference r1, int r2, android.hardware.soundtrigger.V2_3.Properties r3) {
        lambda$getPropertiesInternal$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ZElrq0fydHMXzrtMhEj1C_ds4gw(AtomicInteger r0, AtomicReference r1, int r2, ISoundTriggerHw.Properties r3) {
        lambda$getProperties_2_0$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$uP8AQmIzgAPZI0WSikuoT_qDvzs(AtomicInteger r0, AtomicInteger r1, int r2, int r3) {
        lambda$loadPhraseSoundModel$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$yu9FjgvCm4rZd8zV4JzlalBuG6U(AtomicInteger r0, AtomicInteger r1, int r2, int r3) {
        lambda$loadPhraseSoundModel_2_0$8(r0, r1, r2, r3);
    }

    static ISoundTriggerHal create(ISoundTriggerHw underlying, Runnable rebootRunnable, ICaptureStateNotifier notifier) {
        return create(underlying.asBinder(), rebootRunnable, notifier);
    }

    static ISoundTriggerHal create(IHwBinder binder, Runnable rebootRunnable, ICaptureStateNotifier notifier) {
        SoundTriggerHw2Compat compat = new SoundTriggerHw2Compat(binder, rebootRunnable);
        ISoundTriggerHal result = new SoundTriggerHalMaxModelLimiter(compat, compat.mProperties.maxSoundModels);
        if (compat.mProperties.concurrentCapture == false) goto L5;
        return result;
    L5:
        return new SoundTriggerHalConcurrentCaptureHandler(result, notifier);
    }

    private SoundTriggerHw2Compat(IHwBinder binder, Runnable rebootRunnable) {
        this.mModelCallbacks = new ConcurrentHashMap();
        this.mDeathRecipientMap = new HashMap();
        rebootRunnable.getClass();
        this.mRebootRunnable = rebootRunnable;
        binder.getClass();
        this.mBinder = binder;
        initUnderlying(binder);
        Properties r0 = getPropertiesInternal();
        r0.getClass();
        this.mProperties = r0;
    }

    private void initUnderlying(IHwBinder binder) {
        android.hardware.soundtrigger.V2_3.ISoundTriggerHw as2_3 = android.hardware.soundtrigger.V2_3.ISoundTriggerHw.asInterface(binder);
        if (as2_3 == null) goto L6;
        this.mUnderlying_2_3 = as2_3;
        this.mUnderlying_2_2 = as2_3;
        this.mUnderlying_2_1 = as2_3;
        this.mUnderlying_2_0 = as2_3;
        return;
    L6:
        android.hardware.soundtrigger.V2_2.ISoundTriggerHw as2_2 = android.hardware.soundtrigger.V2_2.ISoundTriggerHw.asInterface(binder);
        if (as2_2 == null) goto L10;
        this.mUnderlying_2_2 = as2_2;
        this.mUnderlying_2_1 = as2_2;
        this.mUnderlying_2_0 = as2_2;
        this.mUnderlying_2_3 = null;
        return;
    L10:
        android.hardware.soundtrigger.V2_1.ISoundTriggerHw as2_1 = android.hardware.soundtrigger.V2_1.ISoundTriggerHw.asInterface(binder);
        if (as2_1 == null) goto L14;
        this.mUnderlying_2_1 = as2_1;
        this.mUnderlying_2_0 = as2_1;
        this.mUnderlying_2_3 = null;
        this.mUnderlying_2_2 = null;
        return;
    L14:
        ISoundTriggerHw as2_0 = ISoundTriggerHw.asInterface(binder);
        if (as2_0 == null) goto L19;
        this.mUnderlying_2_0 = as2_0;
        this.mUnderlying_2_3 = null;
        this.mUnderlying_2_2 = null;
        this.mUnderlying_2_1 = null;
        return;
    L19:
        throw new RuntimeException("Binder doesn't support ISoundTriggerHw@2.0");
    }

    private static void handleHalStatus(int status, String methodName) {
        if (status != 0) goto L5;
        return;
    L5:
        throw new HalException(status, methodName);
    }

    private static void handleHalStatusAllowBusy(int status, String methodName) {
        if (status == (-OsConstants.EBUSY)) goto L7;
        handleHalStatus(status, methodName);
        return;
    L7:
        throw new RecoverableException(1);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void reboot() {
        this.mRebootRunnable.run();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void detach() {
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public Properties getProperties() {
        return this.mProperties;
    }

    private Properties getPropertiesInternal() {
        final AtomicInteger retval = new AtomicInteger(-1);     // Catch: RemoteException -> L6
        final AtomicReference<android.hardware.soundtrigger.V2_3.Properties> properties = new AtomicReference();     // Catch: RemoteException -> L6
        as2_3().getProperties_2_3(new SoundTriggerHw2Compat$$ExternalSyntheticLambda6(retval, properties));     // Catch: RemoteException -> L6 NotSupported -> L8
        handleHalStatus(retval.get(), "getProperties_2_3");     // Catch: RemoteException -> L6
        return ConversionUtil.hidl2aidlProperties(properties.get());
    L10:
        return getProperties_2_0();
    L6:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    private static /* synthetic */ void lambda$getPropertiesInternal$0(AtomicInteger retval, AtomicReference properties, int r, android.hardware.soundtrigger.V2_3.Properties p) {
        retval.set(r);
        properties.set(p);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void registerCallback(ISoundTriggerHal.GlobalCallback callback) {
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadSoundModel(SoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        android.hardware.soundtrigger.V2_1.ISoundTriggerHw.SoundModel hidlModel = ConversionUtil.aidl2hidlSoundModel(soundModel);
        final AtomicInteger retval = new AtomicInteger(-1);     // Catch: Throwable -> L13 RemoteException -> L15
        final AtomicInteger handle = new AtomicInteger(0);     // Catch: Throwable -> L13 RemoteException -> L15
        as2_1().loadSoundModel_2_1(hidlModel, new ModelCallbackWrapper(callback, null), 0, new SoundTriggerHw2Compat$$ExternalSyntheticLambda7(retval, handle));     // Catch: Throwable -> L13 RemoteException -> L15 NotSupported -> L17
        handleHalStatus(retval.get(), "loadSoundModel_2_1");     // Catch: Throwable -> L13 RemoteException -> L15 NotSupported -> L17
        this.mModelCallbacks.put(Integer.valueOf(handle.get()), callback);     // Catch: Throwable -> L13 RemoteException -> L15 NotSupported -> L17
        int r5 = handle.get();     // Catch: Throwable -> L13 RemoteException -> L15
        if (hidlModel.data != null) goto L41;
    L12:
        return r5;
    L41:
        hidlModel.data.close();     // Catch: IOException -> L10
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to close file", e);
    L18:
        int r6 = loadSoundModel_2_0(hidlModel, callback);     // Catch: Throwable -> L13 RemoteException -> L15
        if (hidlModel.data != null) goto L39;
    L25:
        return r6;
    L39:
        hidlModel.data.close();     // Catch: IOException -> L23
    L23:
        e = move-exception;
        Slog.e(TAG, "Failed to close file", e);
    L13:
        th = move-exception;
        if (hidlModel.data != null) goto L36;
    L35:
        throw th;
    L36:
        hidlModel.data.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        Slog.e(TAG, "Failed to close file", e);
    L15:
        e = move-exception;
        throw e.rethrowAsRuntimeException();     // Catch: Throwable -> L13
    }

    private static /* synthetic */ void lambda$loadSoundModel$1(AtomicInteger retval, AtomicInteger handle, int r, int h) {
        retval.set(r);
        handle.set(h);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadPhraseSoundModel(PhraseSoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        android.hardware.soundtrigger.V2_1.ISoundTriggerHw.PhraseSoundModel hidlModel = ConversionUtil.aidl2hidlPhraseSoundModel(soundModel);
        final AtomicInteger retval = new AtomicInteger(-1);     // Catch: Throwable -> L13 RemoteException -> L15
        final AtomicInteger handle = new AtomicInteger(0);     // Catch: Throwable -> L13 RemoteException -> L15
        as2_1().loadPhraseSoundModel_2_1(hidlModel, new ModelCallbackWrapper(callback, null), 0, new SoundTriggerHw2Compat$$ExternalSyntheticLambda1(retval, handle));     // Catch: Throwable -> L13 RemoteException -> L15 NotSupported -> L17
        handleHalStatus(retval.get(), "loadPhraseSoundModel_2_1");     // Catch: Throwable -> L13 RemoteException -> L15 NotSupported -> L17
        this.mModelCallbacks.put(Integer.valueOf(handle.get()), callback);     // Catch: Throwable -> L13 RemoteException -> L15 NotSupported -> L17
        int r5 = handle.get();     // Catch: Throwable -> L13 RemoteException -> L15
        if (hidlModel.common.data != null) goto L41;
    L12:
        return r5;
    L41:
        hidlModel.common.data.close();     // Catch: IOException -> L10
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to close file", e);
    L18:
        int r6 = loadPhraseSoundModel_2_0(hidlModel, callback);     // Catch: Throwable -> L13 RemoteException -> L15
        if (hidlModel.common.data != null) goto L43;
    L25:
        return r6;
    L43:
        hidlModel.common.data.close();     // Catch: IOException -> L23
    L23:
        e = move-exception;
        Slog.e(TAG, "Failed to close file", e);
    L13:
        th = move-exception;
        if (hidlModel.common.data != null) goto L38;
    L35:
        throw th;
    L38:
        hidlModel.common.data.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        Slog.e(TAG, "Failed to close file", e);
    L15:
        e = move-exception;
        throw e.rethrowAsRuntimeException();     // Catch: Throwable -> L13
    }

    private static /* synthetic */ void lambda$loadPhraseSoundModel$2(AtomicInteger retval, AtomicInteger handle, int r, int h) {
        retval.set(r);
        handle.set(h);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unloadSoundModel(int modelHandle) {
        this.mModelCallbacks.remove(Integer.valueOf(modelHandle));     // Catch: RemoteException -> L4
        int retval = as2_0().unloadSoundModel(modelHandle);     // Catch: RemoteException -> L4
        handleHalStatus(retval, "unloadSoundModel");     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void stopRecognition(int modelHandle) {
        int retval = as2_0().stopRecognition(modelHandle);     // Catch: RemoteException -> L4
        handleHalStatus(retval, "stopRecognition");     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void startRecognition(int modelHandle, int deviceHandle, int ioHandle, RecognitionConfig config) {
        android.hardware.soundtrigger.V2_3.RecognitionConfig hidlConfig = ConversionUtil.aidl2hidlRecognitionConfig(config, deviceHandle, ioHandle);
        int retval = as2_3().startRecognition_2_3(modelHandle, hidlConfig);     // Catch: RemoteException -> L5 NotSupported -> L7
        handleHalStatus(retval, "startRecognition_2_3");     // Catch: RemoteException -> L5 NotSupported -> L7
        goto L8
    L16:
        return;
    L5:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L8:
        startRecognition_2_1(modelHandle, hidlConfig);     // Catch: RemoteException -> L5
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void forceRecognitionEvent(int modelHandle) {
        int retval = as2_2().getModelState(modelHandle);     // Catch: NotSupported -> L4 RemoteException -> L6
        handleHalStatus(retval, "getModelState");     // Catch: NotSupported -> L4 RemoteException -> L6
        return;
    L6:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L4:
        e = move-exception;
        throw e.throwAsRecoverableException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int getModelParameter(int modelHandle, int param) {
        final AtomicInteger status = new AtomicInteger(-1);
        final AtomicInteger value = new AtomicInteger(0);
        as2_3().getParameter(modelHandle, param, new SoundTriggerHw2Compat$$ExternalSyntheticLambda8(status, value));     // Catch: NotSupported -> L6 RemoteException -> L8
        handleHalStatus(status.get(), "getParameter");
        return value.get();
    L8:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L6:
        e = move-exception;
        throw e.throwAsRecoverableException();
    }

    private static /* synthetic */ void lambda$getModelParameter$3(AtomicInteger status, AtomicInteger value, int s, int v) {
        status.set(s);
        value.set(v);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void setModelParameter(int modelHandle, int param, int value) {
        int retval = as2_3().setParameter(modelHandle, param, value);     // Catch: NotSupported -> L4 RemoteException -> L6
        handleHalStatus(retval, "setParameter");     // Catch: NotSupported -> L4 RemoteException -> L6
        return;
    L6:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L4:
        e = move-exception;
        throw e.throwAsRecoverableException();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public ModelParameterRange queryParameter(int modelHandle, int param) {
        final AtomicInteger status = new AtomicInteger(-1);
        final AtomicReference<OptionalModelParameterRange> optionalRange = new AtomicReference();
        as2_3().queryParameter(modelHandle, param, new SoundTriggerHw2Compat$$ExternalSyntheticLambda2(status, optionalRange));     // Catch: RemoteException -> L9 NotSupported -> L11
        handleHalStatus(status.get(), "queryParameter");
        if (optionalRange.get().getDiscriminator() == 1) goto L8;
        return null;
    L8:
        return ConversionUtil.hidl2aidlModelParameterRange(optionalRange.get().range());
    L9:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L16:
        return null;
    }

    private static /* synthetic */ void lambda$queryParameter$4(AtomicInteger status, AtomicReference optionalRange, int s, OptionalModelParameterRange r) {
        status.set(s);
        optionalRange.set(r);
    }

    private static /* synthetic */ void lambda$linkToDeath$5(IBinder.DeathRecipient recipient, long cookie) {
        recipient.binderDied();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void linkToDeath(final IBinder.DeathRecipient recipient) {
        IHwBinder.DeathRecipient wrapper = new SoundTriggerHw2Compat$$ExternalSyntheticLambda3(recipient);
        this.mDeathRecipientMap.put(recipient, wrapper);
        this.mBinder.linkToDeath(wrapper, 0);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unlinkToDeath(IBinder.DeathRecipient recipient) {
        this.mBinder.unlinkToDeath(this.mDeathRecipientMap.remove(recipient));
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public String interfaceDescriptor() {
        return as2_0().interfaceDescriptor();
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
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

    private Properties getProperties_2_0() throws RemoteException {
        final AtomicInteger retval = new AtomicInteger(-1);
        final AtomicReference<ISoundTriggerHw.Properties> properties = new AtomicReference();
        as2_0().getProperties(new SoundTriggerHw2Compat$$ExternalSyntheticLambda5(retval, properties));
        handleHalStatus(retval.get(), "getProperties");
        return ConversionUtil.hidl2aidlProperties(Hw2CompatUtil.convertProperties_2_0_to_2_3(properties.get()));
    }

    private static /* synthetic */ void lambda$getProperties_2_0$6(AtomicInteger retval, AtomicReference properties, int r, ISoundTriggerHw.Properties p) {
        retval.set(r);
        properties.set(p);
    }

    private int loadSoundModel_2_0(android.hardware.soundtrigger.V2_1.ISoundTriggerHw.SoundModel soundModel, ISoundTriggerHal.ModelCallback callback) throws RemoteException {
        ISoundTriggerHw.SoundModel model_2_0 = Hw2CompatUtil.convertSoundModel_2_1_to_2_0(soundModel);
        final AtomicInteger retval = new AtomicInteger(-1);
        final AtomicInteger handle = new AtomicInteger(0);
        as2_0().loadSoundModel(model_2_0, new ModelCallbackWrapper(callback, null), 0, new SoundTriggerHw2Compat$$ExternalSyntheticLambda0(retval, handle));
        handleHalStatus(retval.get(), "loadSoundModel");
        this.mModelCallbacks.put(Integer.valueOf(handle.get()), callback);
        return handle.get();
    }

    private static /* synthetic */ void lambda$loadSoundModel_2_0$7(AtomicInteger retval, AtomicInteger handle, int r, int h) {
        retval.set(r);
        handle.set(h);
    }

    private int loadPhraseSoundModel_2_0(android.hardware.soundtrigger.V2_1.ISoundTriggerHw.PhraseSoundModel soundModel, ISoundTriggerHal.ModelCallback callback) throws RemoteException {
        ISoundTriggerHw.PhraseSoundModel model_2_0 = Hw2CompatUtil.convertPhraseSoundModel_2_1_to_2_0(soundModel);
        final AtomicInteger retval = new AtomicInteger(-1);
        final AtomicInteger handle = new AtomicInteger(0);
        as2_0().loadPhraseSoundModel(model_2_0, new ModelCallbackWrapper(callback, null), 0, new SoundTriggerHw2Compat$$ExternalSyntheticLambda4(retval, handle));
        handleHalStatus(retval.get(), "loadSoundModel");
        this.mModelCallbacks.put(Integer.valueOf(handle.get()), callback);
        return handle.get();
    }

    private static /* synthetic */ void lambda$loadPhraseSoundModel_2_0$8(AtomicInteger retval, AtomicInteger handle, int r, int h) {
        retval.set(r);
        handle.set(h);
    }

    private void startRecognition_2_1(int modelHandle, android.hardware.soundtrigger.V2_3.RecognitionConfig config) {
        android.hardware.soundtrigger.V2_1.ISoundTriggerHw.RecognitionConfig config_2_1 = Hw2CompatUtil.convertRecognitionConfig_2_3_to_2_1(config);     // Catch: RemoteException -> L4 NotSupported -> L6
        int retval = as2_1().startRecognition_2_1(modelHandle, config_2_1, new ModelCallbackWrapper(this.mModelCallbacks.get(Integer.valueOf(modelHandle)), null), 0);     // Catch: RemoteException -> L4 NotSupported -> L6
        handleHalStatus(retval, "startRecognition_2_1");     // Catch: RemoteException -> L4 NotSupported -> L6
        goto L7
    L15:
        return;
    L4:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L7:
        startRecognition_2_0(modelHandle, config);     // Catch: RemoteException -> L4
    }

    private void startRecognition_2_0(int modelHandle, android.hardware.soundtrigger.V2_3.RecognitionConfig config) throws RemoteException {
        ISoundTriggerHw.RecognitionConfig config_2_0 = Hw2CompatUtil.convertRecognitionConfig_2_3_to_2_0(config);
        int retval = as2_0().startRecognition(modelHandle, config_2_0, new ModelCallbackWrapper(this.mModelCallbacks.get(Integer.valueOf(modelHandle)), null), 0);
        handleHalStatus(retval, "startRecognition");
    }

    private ISoundTriggerHw as2_0() {
        return this.mUnderlying_2_0;
    }

    private android.hardware.soundtrigger.V2_1.ISoundTriggerHw as2_1() throws NotSupported {
        if (this.mUnderlying_2_1 == null) goto L7;
        return this.mUnderlying_2_1;
    L7:
        throw new NotSupported("Underlying driver version < 2.1");
    }

    private android.hardware.soundtrigger.V2_2.ISoundTriggerHw as2_2() throws NotSupported {
        if (this.mUnderlying_2_2 == null) goto L7;
        return this.mUnderlying_2_2;
    L7:
        throw new NotSupported("Underlying driver version < 2.2");
    }

    private android.hardware.soundtrigger.V2_3.ISoundTriggerHw as2_3() throws NotSupported {
        if (this.mUnderlying_2_3 == null) goto L7;
        return this.mUnderlying_2_3;
    L7:
        throw new NotSupported("Underlying driver version < 2.3");
    }
}
