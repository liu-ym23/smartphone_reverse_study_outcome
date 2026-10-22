package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.ISoundTriggerCallback;
import android.media.soundtrigger_middleware.ISoundTriggerModule;
import android.media.soundtrigger_middleware.PhraseRecognitionEventSys;
import android.media.soundtrigger_middleware.RecognitionEventSys;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class SoundTriggerModule implements IBinder.DeathRecipient, ISoundTriggerHal.GlobalCallback {
    private static final String TAG = "SoundTriggerModule";
    private final Set<Session> mActiveSessions;
    private final SoundTriggerMiddlewareImpl.AudioSessionProvider mAudioSessionProvider;
    private final HalFactory mHalFactory;
    private ISoundTriggerHal mHalService;
    private Properties mProperties;

    private static final enum ModelState extends Enum<ModelState> {
        private static final /* synthetic */ ModelState[] $VALUES = null;
        public static final ModelState ACTIVE = null;
        public static final ModelState INIT = null;
        public static final ModelState LOADED = null;

        private static /* synthetic */ ModelState[] $values() {
            return new ModelState[]{INIT, LOADED, ACTIVE};
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
            INIT = new ModelState("INIT", 0);
            LOADED = new ModelState("LOADED", 1);
            ACTIVE = new ModelState("ACTIVE", 2);
            $VALUES = $values();
        }
    }

    private class Session implements ISoundTriggerModule {
        private ISoundTriggerCallback mCallback;
        private final Map<Integer, Model> mLoadedModels;
        private final IBinder mToken;
        final /* synthetic */ SoundTriggerModule this$0;

        private class Model implements ISoundTriggerHal.ModelCallback {
            public int mHandle;
            private boolean mIsStopping;
            private IBinder mRecognitionToken;
            private SoundTriggerMiddlewareImpl.AudioSessionProvider.AudioSession mSession;
            private ModelState mState;
            final /* synthetic */ Session this$1;

            /* JADX INFO: renamed from: -$$Nest$mforceRecognitionEvent, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m8280$$Nest$mforceRecognitionEvent(Model r0) {
                r0.forceRecognitionEvent();
            }

            /* JADX INFO: renamed from: -$$Nest$mgetParameter, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m8281$$Nest$mgetParameter(Model r0, int r1) {
                return r0.getParameter(r1);
            }

            /* JADX INFO: renamed from: -$$Nest$mgetSession, reason: not valid java name */
            static /* bridge */ /* synthetic */ SoundTriggerMiddlewareImpl.AudioSessionProvider.AudioSession m8282$$Nest$mgetSession(Model r0) {
                return r0.getSession();
            }

            /* JADX INFO: renamed from: -$$Nest$mload, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m8283$$Nest$mload(Model r0, PhraseSoundModel r1, SoundTriggerMiddlewareImpl.AudioSessionProvider.AudioSession r2) {
                return r0.load(r1, r2);
            }

            /* JADX INFO: renamed from: -$$Nest$mload, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m8284$$Nest$mload(Model r0, SoundModel r1, SoundTriggerMiddlewareImpl.AudioSessionProvider.AudioSession r2) {
                return r0.load(r1, r2);
            }

            /* JADX INFO: renamed from: -$$Nest$mqueryModelParameterSupport, reason: not valid java name */
            static /* bridge */ /* synthetic */ ModelParameterRange m8285$$Nest$mqueryModelParameterSupport(Model r0, int r1) {
                return r0.queryModelParameterSupport(r1);
            }

            /* JADX INFO: renamed from: -$$Nest$msetParameter, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m8286$$Nest$msetParameter(Model r0, int r1, int r2) {
                r0.setParameter(r1, r2);
            }

            /* JADX INFO: renamed from: -$$Nest$mstartRecognition, reason: not valid java name */
            static /* bridge */ /* synthetic */ IBinder m8287$$Nest$mstartRecognition(Model r0, RecognitionConfig r1) {
                return r0.startRecognition(r1);
            }

            /* JADX INFO: renamed from: -$$Nest$mstopRecognition, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m8288$$Nest$mstopRecognition(Model r0) {
                r0.stopRecognition();
            }

            /* synthetic */ Model(Session r1, SoundTriggerModuleIA r2) {
                this(r1);
            }

            private Model(Session r1) {
                this.this$1 = r1;
                this.mState = ModelState.INIT;
                this.mRecognitionToken = null;
                this.mIsStopping = false;
            }

            private ModelState getState() {
                return this.mState;
            }

            private SoundTriggerMiddlewareImpl.AudioSessionProvider.AudioSession getSession() {
                return this.mSession;
            }

            private void setState(ModelState state) {
                this.mState = state;
                this.this$1.this$0.notifyAll();
            }

            private int load(SoundModel model, SoundTriggerMiddlewareImpl.AudioSessionProvider.AudioSession audioSession) {
                this.mSession = audioSession;
                this.mHandle = SoundTriggerModule.m8275$$Nest$fgetmHalService(this.this$1.this$0).loadSoundModel(model, this);
                setState(ModelState.LOADED);
                Session.m8278$$Nest$fgetmLoadedModels(this.this$1).put(Integer.valueOf(this.mHandle), this);
                return this.mHandle;
            }

            private int load(PhraseSoundModel model, SoundTriggerMiddlewareImpl.AudioSessionProvider.AudioSession audioSession) {
                this.mSession = audioSession;
                this.mHandle = SoundTriggerModule.m8275$$Nest$fgetmHalService(this.this$1.this$0).loadPhraseSoundModel(model, this);
                setState(ModelState.LOADED);
                Session.m8278$$Nest$fgetmLoadedModels(this.this$1).put(Integer.valueOf(this.mHandle), this);
                return this.mHandle;
            }

            private IBinder startRecognition(RecognitionConfig config) {
                if (this.mIsStopping == true) goto L7;
                SoundTriggerModule.m8275$$Nest$fgetmHalService(this.this$1.this$0).startRecognition(this.mHandle, this.mSession.mDeviceHandle, this.mSession.mIoHandle, config);
                this.mRecognitionToken = new Binder();
                setState(ModelState.ACTIVE);
                return this.mRecognitionToken;
            L7:
                throw new RecoverableException(5, "Race occurred");
            }

            private void stopRecognition() {
                SoundTriggerModule r0 = this.this$1.this$0;
                monitor-enter(r0);
            L8:
                th = move-exception;
                throw th;
            L5:
                if (getState() != ModelState.LOADED) goto L10;
                monitor-exit(r0);     // Catch: Throwable -> L8
                return;
            L10:
                this.mRecognitionToken = null;     // Catch: Throwable -> L8
                this.mIsStopping = true;     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                SoundTriggerModule.m8275$$Nest$fgetmHalService(this.this$1.this$0).stopRecognition(this.mHandle);
                SoundTriggerModule r1 = this.this$1.this$0;
                monitor-enter(r1);
                this.mIsStopping = false;     // Catch: Throwable -> L18
                setState(ModelState.LOADED);     // Catch: Throwable -> L18
                monitor-exit(r1);     // Catch: Throwable -> L18
                return;
            L18:
                th = move-exception;
                throw th;
            }

            private void forceRecognitionEvent() {
                if (getState() == ModelState.ACTIVE) goto L5;
                return;
            L5:
                SoundTriggerModule.m8275$$Nest$fgetmHalService(this.this$1.this$0).forceRecognitionEvent(this.mHandle);
            }

            private void setParameter(int modelParam, int value) {
                SoundTriggerModule.m8275$$Nest$fgetmHalService(this.this$1.this$0).setModelParameter(this.mHandle, ConversionUtil.aidl2hidlModelParameter(modelParam), value);
            }

            private int getParameter(int modelParam) {
                return SoundTriggerModule.m8275$$Nest$fgetmHalService(this.this$1.this$0).getModelParameter(this.mHandle, ConversionUtil.aidl2hidlModelParameter(modelParam));
            }

            private ModelParameterRange queryModelParameterSupport(int modelParam) {
                return SoundTriggerModule.m8275$$Nest$fgetmHalService(this.this$1.this$0).queryParameter(this.mHandle, modelParam);
            }

            @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal.ModelCallback
            public void recognitionCallback(int modelHandle, RecognitionEventSys event) {
                SoundTriggerModule r0 = this.this$1.this$0;
                monitor-enter(r0);
            L8:
                th = move-exception;
                throw th;
            L5:
                if (this.mRecognitionToken != null) goto L10;
                monitor-exit(r0);     // Catch: Throwable -> L8
                return;
            L10:
                event.token = this.mRecognitionToken;     // Catch: Throwable -> L8
                if (event.recognitionEvent.recognitionStillActive == true) goto L13;
                setState(ModelState.LOADED);     // Catch: Throwable -> L8
                this.mRecognitionToken = null;     // Catch: Throwable -> L8
            L13:
                ISoundTriggerCallback callback = Session.m8277$$Nest$fgetmCallback(this.this$1);     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                if (callback != null) goto L25;
                return;
            L25:
                callback.onRecognition(this.mHandle, event, this.mSession.mSessionHandle);     // Catch: RemoteException -> L18
                return;
            L18:
                e = move-exception;
                throw e.rethrowAsRuntimeException();
            }

            @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal.ModelCallback
            public void phraseRecognitionCallback(int modelHandle, PhraseRecognitionEventSys event) {
                SoundTriggerModule r0 = this.this$1.this$0;
                monitor-enter(r0);
            L8:
                th = move-exception;
                throw th;
            L5:
                if (this.mRecognitionToken != null) goto L10;
                monitor-exit(r0);     // Catch: Throwable -> L8
                return;
            L10:
                event.token = this.mRecognitionToken;     // Catch: Throwable -> L8
                if (event.phraseRecognitionEvent.common.recognitionStillActive == true) goto L13;
                setState(ModelState.LOADED);     // Catch: Throwable -> L8
                this.mRecognitionToken = null;     // Catch: Throwable -> L8
            L13:
                ISoundTriggerCallback callback = Session.m8277$$Nest$fgetmCallback(this.this$1);     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                if (callback != null) goto L25;
                return;
            L25:
                Session.m8277$$Nest$fgetmCallback(this.this$1).onPhraseRecognition(this.mHandle, event, this.mSession.mSessionHandle);     // Catch: RemoteException -> L18
                return;
            L18:
                e = move-exception;
                throw e.rethrowAsRuntimeException();
            }

            @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal.ModelCallback
            public void modelUnloaded(int modelHandle) {
                SoundTriggerModule r0 = this.this$1.this$0;
                monitor-enter(r0);
                ISoundTriggerCallback callback = Session.m8277$$Nest$fgetmCallback(this.this$1);     // Catch: Throwable -> L14
                monitor-exit(r0);     // Catch: Throwable -> L14
                if (callback != null) goto L17;
                return;
            L17:
                callback.onModelUnloaded(modelHandle);     // Catch: RemoteException -> L9
                return;
            L9:
                e = move-exception;
                throw e.rethrowAsRuntimeException();
            L14:
                th = move-exception;
                throw th;
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ ISoundTriggerCallback m8277$$Nest$fgetmCallback(Session r0) {
            return r0.mCallback;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLoadedModels, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8278$$Nest$fgetmLoadedModels(Session r0) {
            return r0.mLoadedModels;
        }

        /* JADX INFO: renamed from: -$$Nest$mmoduleDied, reason: not valid java name */
        static /* bridge */ /* synthetic */ ISoundTriggerCallback m8279$$Nest$mmoduleDied(Session r0) {
            return r0.moduleDied();
        }

        /* synthetic */ Session(SoundTriggerModule r1, ISoundTriggerCallback r2, SoundTriggerModuleIA r3) {
            this(r1, r2);
        }

        private Session(SoundTriggerModule r2, ISoundTriggerCallback callback) {
            this.this$0 = r2;
            this.mToken = new Binder();
            this.mLoadedModels = new HashMap();
            this.mCallback = callback;
            SoundTriggerModule.m8275$$Nest$fgetmHalService(r2).clientAttached(this.mToken);
        }

        public void detach() {
            SoundTriggerModule r0 = this.this$0;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mCallback != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            SoundTriggerModule.m8276$$Nest$mremoveSession(this.this$0, this);     // Catch: Throwable -> L8
            this.mCallback = null;     // Catch: Throwable -> L8
            SoundTriggerModule.m8275$$Nest$fgetmHalService(this.this$0).clientDetached(this.mToken);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        public int loadModel(SoundModel model) {
            SoundTriggerModule r0 = this.this$0;
            monitor-enter(r0);
            SoundTriggerMiddlewareImpl.AudioSessionProvider.AudioSession audioSession = SoundTriggerModule.m8274$$Nest$fgetmAudioSessionProvider(this.this$0).acquireSession();     // Catch: Throwable -> L8
            checkValid();     // Catch: Throwable -> L8 Exception -> L10
            Model loadedModel = new Model(this, null);     // Catch: Throwable -> L8 Exception -> L10
            int r3 = Model.m8284$$Nest$mload(loadedModel, model, audioSession);     // Catch: Throwable -> L8 Exception -> L10
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r3;
        L10:
            e = move-exception;
            SoundTriggerModule.m8274$$Nest$fgetmAudioSessionProvider(this.this$0).releaseSession(audioSession.mSessionHandle);     // Catch: Throwable -> L8 Exception -> L13
        L16:
            throw e;     // Catch: Throwable -> L8
        L13:
            ee = move-exception;
            Slog.e(SoundTriggerModule.TAG, "Failed to release session.", ee);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        public int loadPhraseModel(PhraseSoundModel model) {
            SoundTriggerModule r0 = this.this$0;
            monitor-enter(r0);
            SoundTriggerMiddlewareImpl.AudioSessionProvider.AudioSession audioSession = SoundTriggerModule.m8274$$Nest$fgetmAudioSessionProvider(this.this$0).acquireSession();     // Catch: Throwable -> L8
            checkValid();     // Catch: Throwable -> L8 Exception -> L10
            Model loadedModel = new Model(this, null);     // Catch: Throwable -> L8 Exception -> L10
            int result = Model.m8283$$Nest$mload(loadedModel, model, audioSession);     // Catch: Throwable -> L8 Exception -> L10
            Slog.d(SoundTriggerModule.TAG, String.format("loadPhraseModel()->%d", new Object[]{Integer.valueOf(result)}));     // Catch: Throwable -> L8 Exception -> L10
            monitor-exit(r0);     // Catch: Throwable -> L8
            return result;
        L10:
            e = move-exception;
            SoundTriggerModule.m8274$$Nest$fgetmAudioSessionProvider(this.this$0).releaseSession(audioSession.mSessionHandle);     // Catch: Throwable -> L8 Exception -> L13
        L16:
            throw e;     // Catch: Throwable -> L8
        L13:
            ee = move-exception;
            Slog.e(SoundTriggerModule.TAG, "Failed to release session.", ee);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        public void unloadModel(int modelHandle) {
            SoundTriggerModule r0 = this.this$0;
            monitor-enter(r0);
            checkValid();     // Catch: Throwable -> L8
            SoundTriggerMiddlewareImpl.AudioSessionProvider.AudioSession session = Model.m8282$$Nest$mgetSession(this.mLoadedModels.get(Integer.valueOf(modelHandle)));     // Catch: Throwable -> L8
            this.mLoadedModels.remove(Integer.valueOf(modelHandle));     // Catch: Throwable -> L8
            SoundTriggerModule.m8274$$Nest$fgetmAudioSessionProvider(this.this$0).releaseSession(session.mSessionHandle);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            SoundTriggerModule.m8275$$Nest$fgetmHalService(this.this$0).unloadSoundModel(modelHandle);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public IBinder startRecognition(int modelHandle, RecognitionConfig config) {
            SoundTriggerModule r0 = this.this$0;
            monitor-enter(r0);
            checkValid();     // Catch: Throwable -> L7
            IBinder r1 = Model.m8287$$Nest$mstartRecognition(this.mLoadedModels.get(Integer.valueOf(modelHandle)), config);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void stopRecognition(int modelHandle) {
            SoundTriggerModule r0 = this.this$0;
            monitor-enter(r0);
            checkValid();     // Catch: Throwable -> L8
            Model model = this.mLoadedModels.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            Model.m8288$$Nest$mstopRecognition(model);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void forceRecognitionEvent(int modelHandle) {
            SoundTriggerModule r0 = this.this$0;
            monitor-enter(r0);
            checkValid();     // Catch: Throwable -> L7
            Model.m8280$$Nest$mforceRecognitionEvent(this.mLoadedModels.get(Integer.valueOf(modelHandle)));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setModelParameter(int modelHandle, int modelParam, int value) {
            SoundTriggerModule r0 = this.this$0;
            monitor-enter(r0);
            checkValid();     // Catch: Throwable -> L7
            Model.m8286$$Nest$msetParameter(this.mLoadedModels.get(Integer.valueOf(modelHandle)), modelParam, value);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public int getModelParameter(int modelHandle, int modelParam) {
            SoundTriggerModule r0 = this.this$0;
            monitor-enter(r0);
            checkValid();     // Catch: Throwable -> L7
            int r1 = Model.m8281$$Nest$mgetParameter(this.mLoadedModels.get(Integer.valueOf(modelHandle)), modelParam);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public ModelParameterRange queryModelParameterSupport(int modelHandle, int modelParam) {
            SoundTriggerModule r0 = this.this$0;
            monitor-enter(r0);
            checkValid();     // Catch: Throwable -> L7
            ModelParameterRange r1 = Model.m8285$$Nest$mqueryModelParameterSupport(this.mLoadedModels.get(Integer.valueOf(modelHandle)), modelParam);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        private ISoundTriggerCallback moduleDied() {
            ISoundTriggerCallback callback = this.mCallback;
            this.mCallback = null;
            return callback;
        }

        private void checkValid() {
            if (this.mCallback == null) goto L6;
            return;
        L6:
            throw new RecoverableException(4);
        }

        public IBinder asBinder() {
            throw new UnsupportedOperationException("This implementation is not intended to be used directly with Binder.");
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioSessionProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ SoundTriggerMiddlewareImpl.AudioSessionProvider m8274$$Nest$fgetmAudioSessionProvider(SoundTriggerModule r0) {
        return r0.mAudioSessionProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHalService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ISoundTriggerHal m8275$$Nest$fgetmHalService(SoundTriggerModule r0) {
        return r0.mHalService;
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8276$$Nest$mremoveSession(SoundTriggerModule r0, Session r1) {
        r0.removeSession(r1);
    }

    SoundTriggerModule(HalFactory halFactory, SoundTriggerMiddlewareImpl.AudioSessionProvider audioSessionProvider) {
        this.mActiveSessions = new HashSet();
        halFactory.getClass();
        this.mHalFactory = halFactory;
        audioSessionProvider.getClass();
        this.mAudioSessionProvider = audioSessionProvider;
        attachToHal();
    }

    synchronized ISoundTriggerModule attach(ISoundTriggerCallback callback) {
        monitor-enter(this);
        Session session = new Session(this, callback, null);     // Catch: Throwable -> L6
        this.mActiveSessions.add(session);     // Catch: Throwable -> L6
        monitor-exit(this);
        return session;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Properties getProperties() {
        monitor-enter(this);
        Properties r0 = this.mProperties;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Slog.w(TAG, "Underlying HAL driver died.");
        monitor-enter(this);
        List<ISoundTriggerCallback> callbacks = new ArrayList(this.mActiveSessions.size());     // Catch: Throwable -> L8
        Iterator<Session> r1 = this.mActiveSessions.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        Session session = r1.next();     // Catch: Throwable -> L8
        callbacks.add(Session.m8279$$Nest$mmoduleDied(session));     // Catch: Throwable -> L8
        goto L6
    L10:
        this.mActiveSessions.clear();     // Catch: Throwable -> L8
        reset();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        Iterator<ISoundTriggerCallback> r2 = callbacks.iterator();
    L14:
        if (r2.hasNext() == false) goto L21;
        ISoundTriggerCallback callback = r2.next();
        callback.onModuleDied();     // Catch: RemoteException -> L18
    L18:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L21:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void reset() {
        this.mHalService.detach();
        attachToHal();
    }

    private void attachToHal() {
        this.mHalService = null;
    L4:
        if (this.mHalService != null) goto L12;
        this.mHalService = new SoundTriggerHalEnforcer(new SoundTriggerHalWatchdog(new SoundTriggerDuplicateModelHandler(this.mHalFactory.create())));     // Catch: RuntimeException -> L7
    L7:
        e = move-exception;
        if ((e.getCause() instanceof RemoteException) == true) goto L4;
        throw e;
    L12:
        this.mHalService.linkToDeath(this);
        this.mHalService.registerCallback(this);
        this.mProperties = this.mHalService.getProperties();
    }

    private void removeSession(Session session) {
        this.mActiveSessions.remove(session);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal.GlobalCallback
    public void onResourcesAvailable() {
        monitor-enter(this);
        List<ISoundTriggerCallback> callbacks = new ArrayList(this.mActiveSessions.size());     // Catch: Throwable -> L7
        Iterator<Session> r1 = this.mActiveSessions.iterator();     // Catch: Throwable -> L7
    L5:
        if (r1.hasNext() == false) goto L9;
        Session session = r1.next();     // Catch: Throwable -> L7
        callbacks.add(Session.m8277$$Nest$fgetmCallback(session));     // Catch: Throwable -> L7
        goto L5
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        Iterator<ISoundTriggerCallback> r2 = callbacks.iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        ISoundTriggerCallback callback = r2.next();
        callback.onResourcesAvailable();     // Catch: RemoteException -> L16
    L16:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L19:
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
