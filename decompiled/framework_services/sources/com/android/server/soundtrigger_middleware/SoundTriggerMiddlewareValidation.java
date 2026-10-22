package com.android.server.soundtrigger_middleware;

import android.media.permission.Identity;
import android.media.permission.IdentityContext;
import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.ISoundTriggerCallback;
import android.media.soundtrigger_middleware.ISoundTriggerModule;
import android.media.soundtrigger_middleware.PhraseRecognitionEventSys;
import android.media.soundtrigger_middleware.RecognitionEventSys;
import android.media.soundtrigger_middleware.SoundTriggerModuleDescriptor;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceSpecificException;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.Preconditions;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerMiddlewareValidation implements ISoundTriggerMiddlewareInternal, Dumpable {
    private static final String TAG = "SoundTriggerMiddlewareValidation";
    private final ISoundTriggerMiddlewareInternal mDelegate;
    private Map<Integer, ModuleState> mModules;

    static class ModelState {
        Activity activityState;
        RecognitionConfig config;
        final String description;
        private final Map<Integer, ModelParameterRange> parameterSupport;

        static final enum Activity extends Enum<Activity> {
            private static final /* synthetic */ Activity[] $VALUES = null;
            public static final Activity ACTIVE = null;
            public static final Activity LOADED = null;
            public static final Activity PREEMPTED = null;

            private static /* synthetic */ Activity[] $values() {
                return new Activity[]{LOADED, ACTIVE, PREEMPTED};
            }

            private Activity(String r1, int r2) {
                super(r1, r2);
            }

            public static Activity valueOf(String name) {
                return (Activity) Enum.valueOf(Activity.class, name);
            }

            public static Activity[] values() {
                return (Activity[]) $VALUES.clone();
            }

            static {
                LOADED = new Activity("LOADED", 0);
                ACTIVE = new Activity("ACTIVE", 1);
                PREEMPTED = new Activity("PREEMPTED", 2);
                $VALUES = $values();
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetparameterSupport, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8269$$Nest$fgetparameterSupport(ModelState r0) {
            return r0.parameterSupport;
        }

        ModelState(SoundModel model) {
            this.activityState = Activity.LOADED;
            this.parameterSupport = new HashMap();
            this.description = ObjectPrinter.print(model, 16);
        }

        ModelState(PhraseSoundModel model) {
            this.activityState = Activity.LOADED;
            this.parameterSupport = new HashMap();
            this.description = ObjectPrinter.print(model, 16);
        }

        void checkSupported(int modelParam) {
            if (this.parameterSupport.containsKey(Integer.valueOf(modelParam)) == false) goto L10;
            ModelParameterRange range = this.parameterSupport.get(Integer.valueOf(modelParam));
            if (range == null) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("Paramater is not supported.");
        L10:
            throw new IllegalStateException("Parameter has not been checked for support.");
        }

        void checkSupported(int modelParam, int value) {
            if (this.parameterSupport.containsKey(Integer.valueOf(modelParam)) == false) goto L11;
            ModelParameterRange range = this.parameterSupport.get(Integer.valueOf(modelParam));
            if (range == null) goto L9;
            Preconditions.checkArgumentInRange(value, range.minInclusive, range.maxInclusive, "value");
            return;
        L9:
            throw new IllegalArgumentException("Paramater is not supported.");
        L11:
            throw new IllegalStateException("Parameter has not been checked for support.");
        }
    }

    private class ModuleState {
        public Properties properties;
        public Set<Session> sessions;

        /* synthetic */ ModuleState(SoundTriggerMiddlewareValidation r1, Properties r2, SoundTriggerMiddlewareValidationIA r3) {
            this(r1, r2);
        }

        private ModuleState(SoundTriggerMiddlewareValidation r1, Properties properties) {
            this.sessions = new HashSet();
            this.properties = properties;
        }
    }

    private static final enum ModuleStatus extends Enum<ModuleStatus> {
        private static final /* synthetic */ ModuleStatus[] $VALUES = null;
        public static final ModuleStatus ALIVE = null;
        public static final ModuleStatus DEAD = null;
        public static final ModuleStatus DETACHED = null;

        private static /* synthetic */ ModuleStatus[] $values() {
            return new ModuleStatus[]{ALIVE, DETACHED, DEAD};
        }

        private ModuleStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static ModuleStatus valueOf(String name) {
            return (ModuleStatus) Enum.valueOf(ModuleStatus.class, name);
        }

        public static ModuleStatus[] values() {
            return (ModuleStatus[]) $VALUES.clone();
        }

        static {
            ALIVE = new ModuleStatus("ALIVE", 0);
            DETACHED = new ModuleStatus("DETACHED", 1);
            DEAD = new ModuleStatus("DEAD", 2);
            $VALUES = $values();
        }
    }

    private class Session extends ISoundTriggerModule.Stub {
        private final CallbackWrapper mCallbackWrapper;
        private ISoundTriggerModule mDelegate;
        private final int mHandle;
        private final Map<Integer, ModelState> mLoadedModels;
        private final Identity mOriginatorIdentity;
        private ModuleStatus mState;
        final /* synthetic */ SoundTriggerMiddlewareValidation this$0;

        class CallbackWrapper implements ISoundTriggerCallback, IBinder.DeathRecipient {
            private final ISoundTriggerCallback mCallback;
            final /* synthetic */ Session this$1;

            CallbackWrapper(Session this$1, ISoundTriggerCallback callback) {
                this.this$1 = this$1;
                this.mCallback = callback;
                this.mCallback.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
                return;
            L5:
                e = move-exception;
                throw e.rethrowAsRuntimeException();
            }

            void detached() {
                this.mCallback.asBinder().unlinkToDeath(this, 0);
            }

            public void onRecognition(int modelHandle, RecognitionEventSys event, int captureSession) {
                SoundTriggerMiddlewareValidation r0 = this.this$1.this$0;
                monitor-enter(r0);
                ModelState modelState = (ModelState) Session.m8271$$Nest$fgetmLoadedModels(this.this$1).get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L7
                if (event.recognitionEvent.recognitionStillActive == true) goto L9;
                modelState.activityState = ModelState.Activity.LOADED;     // Catch: Throwable -> L7
            L9:
                monitor-exit(r0);     // Catch: Throwable -> L7
                this.mCallback.onRecognition(modelHandle, event, captureSession);     // Catch: Exception -> L12
                return;
            L12:
                e = move-exception;
                Slog.w(SoundTriggerMiddlewareValidation.TAG, "Client callback exception.", e);
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public void onPhraseRecognition(int modelHandle, PhraseRecognitionEventSys event, int captureSession) {
                SoundTriggerMiddlewareValidation r0 = this.this$1.this$0;
                monitor-enter(r0);
                ModelState modelState = (ModelState) Session.m8271$$Nest$fgetmLoadedModels(this.this$1).get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L7
                if (event.phraseRecognitionEvent.common.recognitionStillActive == true) goto L9;
                modelState.activityState = ModelState.Activity.LOADED;     // Catch: Throwable -> L7
            L9:
                monitor-exit(r0);     // Catch: Throwable -> L7
                this.mCallback.onPhraseRecognition(modelHandle, event, captureSession);     // Catch: Exception -> L12
                return;
            L12:
                e = move-exception;
                Slog.w(SoundTriggerMiddlewareValidation.TAG, "Client callback exception.", e);
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public void onModelUnloaded(int modelHandle) {
                SoundTriggerMiddlewareValidation r0 = this.this$1.this$0;
                monitor-enter(r0);
                ModelState modelState = (ModelState) Session.m8271$$Nest$fgetmLoadedModels(this.this$1).get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L11
                modelState.activityState = ModelState.Activity.PREEMPTED;     // Catch: Throwable -> L11
                monitor-exit(r0);     // Catch: Throwable -> L11
                this.mCallback.onModelUnloaded(modelHandle);     // Catch: Exception -> L8
                return;
            L8:
                e = move-exception;
                Slog.w(SoundTriggerMiddlewareValidation.TAG, "Client callback exception.", e);
                return;
            L11:
                th = move-exception;
                throw th;
            }

            public void onResourcesAvailable() {
                this.mCallback.onResourcesAvailable();     // Catch: RemoteException -> L4
                return;
            L4:
                e = move-exception;
                Slog.e(SoundTriggerMiddlewareValidation.TAG, "Client callback exception.", e);
            }

            public void onModuleDied() {
                SoundTriggerMiddlewareValidation r0 = this.this$1.this$0;
                monitor-enter(r0);
                Session.m8272$$Nest$fputmState(this.this$1, ModuleStatus.DEAD);     // Catch: Throwable -> L11
                monitor-exit(r0);     // Catch: Throwable -> L11
                this.mCallback.onModuleDied();     // Catch: RemoteException -> L8
                return;
            L8:
                e = move-exception;
                Slog.e(SoundTriggerMiddlewareValidation.TAG, "Client callback exception.", e);
                return;
            L11:
                th = move-exception;
                throw th;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                SparseArray<ModelState.Activity> cachedMap = new SparseArray();
                SoundTriggerMiddlewareValidation r1 = this.this$1.this$0;
                monitor-enter(r1);
                Iterator r2 = Session.m8271$$Nest$fgetmLoadedModels(this.this$1).entrySet().iterator();     // Catch: Throwable -> L8
            L6:
                if (r2.hasNext() == false) goto L10;
                Map.Entry<Integer, ModelState> entry = (Map.Entry) r2.next();     // Catch: Throwable -> L8
                cachedMap.put(entry.getKey().intValue(), entry.getValue().activityState);     // Catch: Throwable -> L8
                goto L6
            L10:
                monitor-exit(r1);     // Catch: Throwable -> L8
                int i = 0;
            L47:
                if (i >= cachedMap.size()) goto L21;
                if (cachedMap.valueAt(i) != ModelState.Activity.ACTIVE) goto L19;
                Session.m8270$$Nest$fgetmDelegate(this.this$1).stopRecognition(cachedMap.keyAt(i));     // Catch: Exception -> L17
            L19:
                Session.m8270$$Nest$fgetmDelegate(this.this$1).unloadModel(cachedMap.keyAt(i));     // Catch: Exception -> L17
                i = i + 1;
                goto L47
            L21:
                SoundTriggerMiddlewareValidation r3 = this.this$1.this$0;
                monitor-enter(r3);
                Iterator r4 = Session.m8271$$Nest$fgetmLoadedModels(this.this$1).entrySet().iterator();     // Catch: Throwable -> L29
            L25:
                if (r4.hasNext() == false) goto L33;
                Map.Entry<Integer, ModelState> entry2 = (Map.Entry) r4.next();     // Catch: Throwable -> L29
                if (cachedMap.get(entry2.getKey().intValue()) == entry2.getValue().activityState) goto L25;
                Slog.e(SoundTriggerMiddlewareValidation.TAG, "Unexpected state update in binderDied. Race occurred!");     // Catch: Throwable -> L29
                goto L25
            L33:
                if (Session.m8271$$Nest$fgetmLoadedModels(this.this$1).size() == cachedMap.size()) goto L51;
                Slog.e(SoundTriggerMiddlewareValidation.TAG, "Unexpected state update in binderDied. Race occurred!");     // Catch: Throwable -> L29
            L51:
                Session.m8273$$Nest$mdetachInternal(this.this$1);     // Catch: Throwable -> L29 Exception -> L38
                monitor-exit(r3);     // Catch: Throwable -> L29
                return;
            L38:
                e = move-exception;
                throw SoundTriggerMiddlewareValidation.handleException(e);     // Catch: Throwable -> L29
            L29:
                th = move-exception;
                throw th;
            L17:
                e = move-exception;
                throw SoundTriggerMiddlewareValidation.handleException(e);
            L8:
                th = move-exception;
                throw th;
            }

            public IBinder asBinder() {
                return this.mCallback.asBinder();
            }

            public String toString() {
                return Objects.toString(Session.m8270$$Nest$fgetmDelegate(this.this$1));
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDelegate, reason: not valid java name */
        static /* bridge */ /* synthetic */ ISoundTriggerModule m8270$$Nest$fgetmDelegate(Session r0) {
            return r0.mDelegate;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLoadedModels, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8271$$Nest$fgetmLoadedModels(Session r0) {
            return r0.mLoadedModels;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8272$$Nest$fputmState(Session r0, ModuleStatus r1) {
            r0.mState = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mdetachInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8273$$Nest$mdetachInternal(Session r0) {
            r0.detachInternal();
        }

        Session(SoundTriggerMiddlewareValidation r1, int handle, ISoundTriggerCallback callback) {
            this.this$0 = r1;
            this.mLoadedModels = new HashMap();
            this.mState = ModuleStatus.ALIVE;
            this.mCallbackWrapper = new CallbackWrapper(this, callback);
            this.mHandle = handle;
            this.mOriginatorIdentity = IdentityContext.get();
        }

        ISoundTriggerCallback getCallbackWrapper() {
            return this.mCallbackWrapper;
        }

        void attach(ISoundTriggerModule delegate) {
            this.mDelegate = delegate;
            ((ModuleState) SoundTriggerMiddlewareValidation.m8268$$Nest$fgetmModules(this.this$0).get(Integer.valueOf(this.mHandle))).sessions.add(this);
        }

        public int loadModel(SoundModel model) {
            ValidationUtil.validateGenericModel(model);
            SoundTriggerMiddlewareValidation r0 = this.this$0;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mState == ModuleStatus.DETACHED) goto L15;
            int handle = this.mDelegate.loadModel(model);     // Catch: Throwable -> L9 Exception -> L11
            this.mLoadedModels.put(Integer.valueOf(handle), new ModelState(model));     // Catch: Throwable -> L9 Exception -> L11
            monitor-exit(r0);     // Catch: Throwable -> L9
            return handle;
        L11:
            e = move-exception;
            throw SoundTriggerMiddlewareValidation.handleException(e);     // Catch: Throwable -> L9
        L15:
            throw new IllegalStateException("Module has been detached.");     // Catch: Throwable -> L9
        }

        public int loadPhraseModel(PhraseSoundModel model) {
            ValidationUtil.validatePhraseModel(model);
            SoundTriggerMiddlewareValidation r0 = this.this$0;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mState == ModuleStatus.DETACHED) goto L15;
            int handle = this.mDelegate.loadPhraseModel(model);     // Catch: Throwable -> L9 Exception -> L11
            this.mLoadedModels.put(Integer.valueOf(handle), new ModelState(model));     // Catch: Throwable -> L9 Exception -> L11
            monitor-exit(r0);     // Catch: Throwable -> L9
            return handle;
        L11:
            e = move-exception;
            throw SoundTriggerMiddlewareValidation.handleException(e);     // Catch: Throwable -> L9
        L15:
            throw new IllegalStateException("Module has been detached.");     // Catch: Throwable -> L9
        }

        public void unloadModel(int modelHandle) {
            SoundTriggerMiddlewareValidation r0 = this.this$0;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.mState == ModuleStatus.DETACHED) goto L33;
            ModelState modelState = this.mLoadedModels.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L15
            if (modelState == null) goto L31;
            if (modelState.activityState == ModelState.Activity.LOADED) goto L17;
            if (modelState.activityState == ModelState.Activity.PREEMPTED) goto L17;
            throw new IllegalStateException("Model with handle: " + modelHandle + " has invalid state for unloading");     // Catch: Throwable -> L15
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L15
            this.mDelegate.unloadModel(modelHandle);     // Catch: Exception -> L27
            SoundTriggerMiddlewareValidation r1 = this.this$0;
            monitor-enter(r1);
            this.mLoadedModels.remove(Integer.valueOf(modelHandle));     // Catch: Throwable -> L24
            monitor-exit(r1);     // Catch: Throwable -> L24
            return;
        L24:
            th = move-exception;
            throw th;
        L27:
            e = move-exception;
            throw SoundTriggerMiddlewareValidation.handleException(e);
        L31:
            throw new IllegalStateException("Invalid handle: " + modelHandle);     // Catch: Throwable -> L15
        L33:
            throw new IllegalStateException("Module has been detached.");     // Catch: Throwable -> L15
        }

        public IBinder startRecognition(int modelHandle, RecognitionConfig config) {
            ValidationUtil.validateRecognitionConfig(config);
            SoundTriggerMiddlewareValidation r0 = this.this$0;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.mState == ModuleStatus.DETACHED) goto L26;
            ModelState modelState = this.mLoadedModels.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L15
            if (modelState == null) goto L24;
            ModelState.Activity activityState = modelState.activityState;     // Catch: Throwable -> L15
            if (activityState == ModelState.Activity.LOADED) goto L30;
            if (activityState == ModelState.Activity.PREEMPTED) goto L30;
            throw new IllegalStateException("Model with handle: " + modelHandle + " has invalid state for starting recognition");     // Catch: Throwable -> L15
        L30:
            IBinder result = this.mDelegate.startRecognition(modelHandle, config);     // Catch: Throwable -> L15 Exception -> L20
            modelState.config = config;     // Catch: Throwable -> L15 Exception -> L20
            modelState.activityState = ModelState.Activity.ACTIVE;     // Catch: Throwable -> L15 Exception -> L20
            monitor-exit(r0);     // Catch: Throwable -> L15
            return result;
        L20:
            e = move-exception;
            throw SoundTriggerMiddlewareValidation.handleException(e);     // Catch: Throwable -> L15
        L24:
            throw new IllegalStateException("Invalid handle: " + modelHandle);     // Catch: Throwable -> L15
        L26:
            throw new IllegalStateException("Module has been detached.");     // Catch: Throwable -> L15
        }

        public void stopRecognition(int modelHandle) {
            SoundTriggerMiddlewareValidation r0 = this.this$0;
            monitor-enter(r0);
        L28:
            th = move-exception;
            throw th;
        L5:
            if (this.mState == ModuleStatus.DETACHED) goto L33;
            if (this.mLoadedModels.get(Integer.valueOf(modelHandle)) == null) goto L31;
            monitor-exit(r0);     // Catch: Throwable -> L28
            this.mDelegate.stopRecognition(modelHandle);     // Catch: Exception -> L25
            SoundTriggerMiddlewareValidation r1 = this.this$0;
            monitor-enter(r1);
            ModelState modelState = this.mLoadedModels.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L16
            if (modelState != null) goto L19;
            monitor-exit(r1);     // Catch: Throwable -> L16
            return;
        L19:
            if (modelState.activityState == ModelState.Activity.PREEMPTED) goto L21;
            modelState.activityState = ModelState.Activity.LOADED;     // Catch: Throwable -> L16
        L21:
            monitor-exit(r1);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        L25:
            e = move-exception;
            throw SoundTriggerMiddlewareValidation.handleException(e);
        L31:
            throw new IllegalStateException("Invalid handle: " + modelHandle);     // Catch: Throwable -> L28
        L33:
            throw new IllegalStateException("Module has been detached.");     // Catch: Throwable -> L28
        }

        public void forceRecognitionEvent(int modelHandle) {
            SoundTriggerMiddlewareValidation r0 = this.this$0;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mState == ModuleStatus.DETACHED) goto L24;
            ModelState modelState = this.mLoadedModels.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L12
            if (modelState == null) goto L22;
        L14:
            e = move-exception;
            throw SoundTriggerMiddlewareValidation.handleException(e);     // Catch: Throwable -> L12
        L9:
            if (modelState.activityState != ModelState.Activity.ACTIVE) goto L17;
            this.mDelegate.forceRecognitionEvent(modelHandle);     // Catch: Throwable -> L12 Exception -> L14
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L22:
            throw new IllegalStateException("Invalid handle: " + modelHandle);     // Catch: Throwable -> L12
        L24:
            throw new IllegalStateException("Module has been detached.");     // Catch: Throwable -> L12
        }

        public void setModelParameter(int modelHandle, int modelParam, int value) {
            ValidationUtil.validateModelParameter(modelParam);
            SoundTriggerMiddlewareValidation r0 = this.this$0;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mState == ModuleStatus.DETACHED) goto L20;
            ModelState modelState = this.mLoadedModels.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L12
            if (modelState == null) goto L18;
            modelState.checkSupported(modelParam, value);     // Catch: Throwable -> L12
            this.mDelegate.setModelParameter(modelHandle, modelParam, value);     // Catch: Throwable -> L12 Exception -> L14
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L14:
            e = move-exception;
            throw SoundTriggerMiddlewareValidation.handleException(e);     // Catch: Throwable -> L12
        L18:
            throw new IllegalStateException("Invalid handle: " + modelHandle);     // Catch: Throwable -> L12
        L20:
            throw new IllegalStateException("Module has been detached.");     // Catch: Throwable -> L12
        }

        public int getModelParameter(int modelHandle, int modelParam) {
            ValidationUtil.validateModelParameter(modelParam);
            SoundTriggerMiddlewareValidation r0 = this.this$0;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mState == ModuleStatus.DETACHED) goto L20;
            ModelState modelState = this.mLoadedModels.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L12
            if (modelState == null) goto L18;
            modelState.checkSupported(modelParam);     // Catch: Throwable -> L12
            int r2 = this.mDelegate.getModelParameter(modelHandle, modelParam);     // Catch: Throwable -> L12 Exception -> L14
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r2;
        L14:
            e = move-exception;
            throw SoundTriggerMiddlewareValidation.handleException(e);     // Catch: Throwable -> L12
        L18:
            throw new IllegalStateException("Invalid handle: " + modelHandle);     // Catch: Throwable -> L12
        L20:
            throw new IllegalStateException("Module has been detached.");     // Catch: Throwable -> L12
        }

        public ModelParameterRange queryModelParameterSupport(int modelHandle, int modelParam) {
            ValidationUtil.validateModelParameter(modelParam);
            SoundTriggerMiddlewareValidation r0 = this.this$0;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mState == ModuleStatus.DETACHED) goto L19;
            ModelState modelState = this.mLoadedModels.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L11
            if (modelState == null) goto L17;
            ModelParameterRange result = this.mDelegate.queryModelParameterSupport(modelHandle, modelParam);     // Catch: Throwable -> L11 Exception -> L13
            ModelState.m8269$$Nest$fgetparameterSupport(modelState).put(Integer.valueOf(modelParam), result);     // Catch: Throwable -> L11 Exception -> L13
            monitor-exit(r0);     // Catch: Throwable -> L11
            return result;
        L13:
            e = move-exception;
            throw SoundTriggerMiddlewareValidation.handleException(e);     // Catch: Throwable -> L11
        L17:
            throw new IllegalStateException("Invalid handle: " + modelHandle);     // Catch: Throwable -> L11
        L19:
            throw new IllegalStateException("Module has been detached.");     // Catch: Throwable -> L11
        }

        public void detach() {
            SoundTriggerMiddlewareValidation r0 = this.this$0;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.mState == ModuleStatus.DETACHED) goto L22;
            if (this.mState != ModuleStatus.ALIVE) goto L26;
            if (this.mLoadedModels.isEmpty() == true) goto L26;
            throw new IllegalStateException("Cannot detach while models are loaded.");     // Catch: Throwable -> L13
        L26:
            detachInternal();     // Catch: Throwable -> L13 Exception -> L18
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L18:
            e = move-exception;
            throw SoundTriggerMiddlewareValidation.handleException(e);     // Catch: Throwable -> L13
        L22:
            throw new IllegalStateException("Module has already been detached.");     // Catch: Throwable -> L13
        }

        public String toString() {
            return Objects.toString(this.mDelegate);
        }

        private void detachInternal() {
            this.mDelegate.detach();     // Catch: RemoteException -> L4
            this.mState = ModuleStatus.DETACHED;     // Catch: RemoteException -> L4
            this.mCallbackWrapper.detached();     // Catch: RemoteException -> L4
            ((ModuleState) SoundTriggerMiddlewareValidation.m8268$$Nest$fgetmModules(this.this$0).get(Integer.valueOf(this.mHandle))).sessions.remove(this);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            throw e.rethrowAsRuntimeException();
        }

        void dump(PrintWriter pw) {
            if (this.mState != ModuleStatus.ALIVE) goto L9;
            pw.println("-------------------------------");
            pw.printf("Session %s, client: %s\n", new Object[]{toString(), ObjectPrinter.print(this.mOriginatorIdentity, 16)});
            pw.println("Loaded models (handle, active, description):");
            pw.println();
            pw.println("-------------------------------");
            Iterator<Map.Entry<Integer, ModelState>> r0 = this.mLoadedModels.entrySet().iterator();
        L6:
            if (r0.hasNext() == false) goto L8;
            Map.Entry<Integer, ModelState> entry = r0.next();
            pw.print(entry.getKey());
            pw.print('\t');
            pw.print(entry.getValue().activityState.name());
            pw.print('\t');
            pw.print(entry.getValue().description);
            pw.println();
            goto L6
        L8:
            pw.println();
            return;
        L9:
            pw.printf("Session %s is dead", new Object[]{toString()});
            pw.println();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmModules, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m8268$$Nest$fgetmModules(SoundTriggerMiddlewareValidation r0) {
        return r0.mModules;
    }

    public SoundTriggerMiddlewareValidation(ISoundTriggerMiddlewareInternal delegate) {
        this.mDelegate = delegate;
    }

    static RuntimeException handleException(Exception e) {
        if ((e instanceof RecoverableException) == true) goto L5;
        Slog.wtf(TAG, "Unexpected exception", e);
        throw new ServiceSpecificException(5, e.getMessage());
    L5:
        throw new ServiceSpecificException(((RecoverableException) e).errorCode, e.getMessage());
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerMiddlewareInternal
    public SoundTriggerModuleDescriptor[] listModules() {
        monitor-enter(this);
        SoundTriggerModuleDescriptor[] result = this.mDelegate.listModules();     // Catch: Throwable -> L8 Exception -> L10
        int r2 = 0;
        if (this.mModules != null) goto L13;
        this.mModules = new HashMap(result.length);     // Catch: Throwable -> L8 Exception -> L10
        int r1 = result.length;     // Catch: Throwable -> L8 Exception -> L10
    L6:
        if (r2 >= r1) goto L21;
        SoundTriggerModuleDescriptor desc = result[r2];     // Catch: Throwable -> L8 Exception -> L10
        this.mModules.put(Integer.valueOf(desc.handle), new ModuleState(this, desc.properties, null));     // Catch: Throwable -> L8 Exception -> L10
        r2 = r2 + 1;     // Catch: Throwable -> L8 Exception -> L10
    L21:
        monitor-exit(this);     // Catch: Throwable -> L8
        return result;
    L13:
        if (result.length != this.mModules.size()) goto L24;
        int r3 = result.length;     // Catch: Throwable -> L8 Exception -> L10
    L15:
        if (r2 >= r3) goto L21;
        SoundTriggerModuleDescriptor desc2 = result[r2];     // Catch: Throwable -> L8 Exception -> L10
        if (this.mModules.containsKey(Integer.valueOf(desc2.handle)) == false) goto L20;
        ModuleState r4 = this.mModules.get(Integer.valueOf(desc2.handle));     // Catch: Throwable -> L8 Exception -> L10
        r4.properties = desc2.properties;     // Catch: Throwable -> L8 Exception -> L10
        r2 = r2 + 1;     // Catch: Throwable -> L8 Exception -> L10
        goto L15
    L20:
        throw new RuntimeException("listModules must always return the same result.");     // Catch: Throwable -> L8 Exception -> L10
    L24:
        throw new RuntimeException("listModules must always return the same result.");     // Catch: Throwable -> L8 Exception -> L10
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        throw handleException(e);     // Catch: Throwable -> L8
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerMiddlewareInternal
    public ISoundTriggerModule attach(int handle, ISoundTriggerCallback callback, boolean isTrusted) {
        callback.getClass();
        callback.asBinder().getClass();
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mModules == null) goto L19;
        if (this.mModules.containsKey(Integer.valueOf(handle)) == false) goto L17;
        Session session = new Session(this, handle, callback);     // Catch: Throwable -> L11 Exception -> L13
        session.attach(this.mDelegate.attach(handle, session.getCallbackWrapper(), isTrusted));     // Catch: Throwable -> L11 Exception -> L13
        monitor-exit(this);     // Catch: Throwable -> L11
        return session;
    L13:
        e = move-exception;
        throw handleException(e);     // Catch: Throwable -> L11
    L17:
        throw new IllegalArgumentException("Invalid handle: " + handle);     // Catch: Throwable -> L11
    L19:
        throw new IllegalStateException("Client must call listModules() prior to attaching.");     // Catch: Throwable -> L11
    }

    public String toString() {
        return this.mDelegate.toString();
    }

    @Override // com.android.server.soundtrigger_middleware.Dumpable
    public void dump(PrintWriter pw) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mModules == null) goto L16;
        Iterator<Integer> r0 = this.mModules.keySet().iterator();     // Catch: Throwable -> L12
    L7:
        if (r0.hasNext() == false) goto L17;
        int handle = r0.next().intValue();     // Catch: Throwable -> L12
        ModuleState module = this.mModules.get(Integer.valueOf(handle));     // Catch: Throwable -> L12
        pw.println("=========================================");     // Catch: Throwable -> L12
        pw.printf("Module %d\n%s\n", new Object[]{Integer.valueOf(handle), ObjectPrinter.print(module.properties, 16)});     // Catch: Throwable -> L12
        pw.println("=========================================");     // Catch: Throwable -> L12
        Iterator<Session> r3 = module.sessions.iterator();     // Catch: Throwable -> L12
    L10:
        if (r3.hasNext() == false) goto L7;
        Session session = r3.next();     // Catch: Throwable -> L12
        session.dump(pw);     // Catch: Throwable -> L12
    L17:
        monitor-exit(this);     // Catch: Throwable -> L12
        pw.println();
        if ((this.mDelegate instanceof Dumpable) == false) goto L28;
        ((Dumpable) this.mDelegate).dump(pw);
        return;
    L28:
        return;
    L16:
        pw.println("Modules have not yet been enumerated.");     // Catch: Throwable -> L12
        goto L17
    }
}
