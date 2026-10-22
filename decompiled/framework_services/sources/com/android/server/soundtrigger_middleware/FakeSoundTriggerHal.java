package com.android.server.soundtrigger_middleware;

import android.hardware.soundtrigger3.ISoundTriggerHw;
import android.hardware.soundtrigger3.ISoundTriggerHwCallback;
import android.hardware.soundtrigger3.ISoundTriggerHwGlobalCallback;
import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseRecognitionEvent;
import android.media.soundtrigger.PhraseRecognitionExtra;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.RecognitionEvent;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.IAcknowledgeEvent;
import android.media.soundtrigger_middleware.IInjectGlobalEvent;
import android.media.soundtrigger_middleware.IInjectModelEvent;
import android.media.soundtrigger_middleware.IInjectRecognitionEvent;
import android.media.soundtrigger_middleware.ISoundTriggerInjection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceSpecificException;
import android.util.Slog;
import com.android.internal.util.FunctionalUtils;
import com.android.server.pm.PackageManagerService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class FakeSoundTriggerHal extends ISoundTriggerHw.Stub {
    private static final String TAG = "FakeSoundTriggerHal";
    private static final int THRESHOLD_MAX = 10;
    private static final int THRESHOLD_MIN = -10;
    private IBinder.DeathRecipient mDeathRecipient;
    private GlobalCallbackDispatcher mGlobalCallbackDispatcher;
    private final IInjectGlobalEvent.Stub mGlobalEventSession;
    private final InjectionDispatcher mInjectionDispatcher;
    private boolean mIsDead;
    private boolean mIsResourceContended;
    private final Object mLock;
    private int mModelKeyCounter;
    private final Map<Integer, ModelSession> mModelSessionMap;
    private final Properties mProperties;

    /* JADX INFO: renamed from: com.android.server.soundtrigger_middleware.FakeSoundTriggerHal$1, reason: invalid class name */
    class AnonymousClass1 extends IInjectGlobalEvent.Stub {
        final /* synthetic */ FakeSoundTriggerHal this$0;

        public static /* synthetic */ void $r8$lambda$0I3wUPpT2O1jPmU7rvfsHh15TjU(AnonymousClass1 r0, ISoundTriggerInjection r1) {
            r0.lambda$triggerRestart$0(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$0fUJo4CNumzi9DwI8-dodpsTlVs, reason: not valid java name */
        public static /* synthetic */ void m8233$r8$lambda$0fUJo4CNumzi9DwI8dodpsTlVs(AnonymousClass1 r0, IBinder.DeathRecipient r1) {
            r0.lambda$triggerRestart$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$eCkCVlx2Nhvqk7b5yO4sbdkZqRc(IAcknowledgeEvent r0, ISoundTriggerInjection r1) {
            lambda$setResourceContention$2(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$yK_ZP4EqOj4lTMG8hyfcaMiB1oM(ISoundTriggerHwGlobalCallback r0) {
            lambda$setResourceContention$3(r0);
        }

        public static /* synthetic */ void $r8$lambda$zW0J9Gdsh0Oj00E49z0mhcL3qIo(ISoundTriggerHwGlobalCallback r0) {
            lambda$triggerOnResourcesAvailable$4(r0);
        }

        AnonymousClass1(FakeSoundTriggerHal this$0) {
            this.this$0 = this$0;
        }

        public void triggerRestart() {
            Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (FakeSoundTriggerHal.m8223$$Nest$fgetmIsDead(this.this$0) == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            FakeSoundTriggerHal.m8228$$Nest$fputmIsDead(this.this$0, true);     // Catch: Throwable -> L8
            InjectionDispatcher.m8236$$Nest$mwrap(FakeSoundTriggerHal.m8222$$Nest$fgetmInjectionDispatcher(this.this$0), new FakeSoundTriggerHal$1$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L8
            FakeSoundTriggerHal.m8226$$Nest$fgetmModelSessionMap(this.this$0).clear();     // Catch: Throwable -> L8
            if (FakeSoundTriggerHal.m8220$$Nest$fgetmDeathRecipient(this.this$0) == null) goto L13;
            final IBinder.DeathRecipient deathRecipient = FakeSoundTriggerHal.m8220$$Nest$fgetmDeathRecipient(this.this$0);     // Catch: Throwable -> L8
            ExecutorHolder.CALLBACK_EXECUTOR.execute(new FakeSoundTriggerHal$1$$ExternalSyntheticLambda3(this, deathRecipient));     // Catch: Throwable -> L8
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private /* synthetic */ void lambda$triggerRestart$0(ISoundTriggerInjection cb) throws Exception {
            cb.onRestarted(this);
        }

        private /* synthetic */ void lambda$triggerRestart$1(IBinder.DeathRecipient deathRecipient) {
            deathRecipient.binderDied(this.this$0.asBinder());     // Catch: Throwable -> L4
            return;
        L4:
            e = move-exception;
            Slog.wtf(FakeSoundTriggerHal.TAG, "Callback dispatch threw", e);
        }

        public void setResourceContention(boolean isResourcesContended, final IAcknowledgeEvent callback) {
            Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (FakeSoundTriggerHal.m8223$$Nest$fgetmIsDead(this.this$0) == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            boolean oldIsResourcesContended = FakeSoundTriggerHal.m8224$$Nest$fgetmIsResourceContended(this.this$0);     // Catch: Throwable -> L8
            FakeSoundTriggerHal.m8229$$Nest$fputmIsResourceContended(this.this$0, isResourcesContended);     // Catch: Throwable -> L8
            InjectionDispatcher.m8236$$Nest$mwrap(FakeSoundTriggerHal.m8222$$Nest$fgetmInjectionDispatcher(this.this$0), new FakeSoundTriggerHal$1$$ExternalSyntheticLambda0(callback));     // Catch: Throwable -> L8
            if (FakeSoundTriggerHal.m8224$$Nest$fgetmIsResourceContended(this.this$0) == true) goto L14;
            if (oldIsResourcesContended == false) goto L14;
            GlobalCallbackDispatcher.m8235$$Nest$mwrap(FakeSoundTriggerHal.m8221$$Nest$fgetmGlobalCallbackDispatcher(this.this$0), new FakeSoundTriggerHal$1$$ExternalSyntheticLambda1());     // Catch: Throwable -> L8
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private static /* synthetic */ void lambda$setResourceContention$2(IAcknowledgeEvent callback, ISoundTriggerInjection unused) throws Exception {
            callback.eventReceived();
        }

        private static /* synthetic */ void lambda$setResourceContention$3(ISoundTriggerHwGlobalCallback cb) throws Exception {
            cb.onResourcesAvailable();
        }

        public void triggerOnResourcesAvailable() {
            Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (FakeSoundTriggerHal.m8223$$Nest$fgetmIsDead(this.this$0) == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            GlobalCallbackDispatcher.m8235$$Nest$mwrap(FakeSoundTriggerHal.m8221$$Nest$fgetmGlobalCallbackDispatcher(this.this$0), new FakeSoundTriggerHal$1$$ExternalSyntheticLambda4());     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private static /* synthetic */ void lambda$triggerOnResourcesAvailable$4(ISoundTriggerHwGlobalCallback cb) throws Exception {
            cb.onResourcesAvailable();
        }
    }

    private static class CallbackDispatcher {
        private final ISoundTriggerHwCallback mCallback;

        public static /* synthetic */ void $r8$lambda$T_PSu1xehZK73SX8hijnV85RhCk(CallbackDispatcher r0, FunctionalUtils.ThrowingConsumer r1) {
            r0.lambda$wrap$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mwrap, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8234$$Nest$mwrap(CallbackDispatcher r0, FunctionalUtils.ThrowingConsumer r1) {
            r0.wrap(r1);
        }

        /* synthetic */ CallbackDispatcher(ISoundTriggerHwCallback r1, FakeSoundTriggerHalIA r2) {
            this(r1);
        }

        private CallbackDispatcher(ISoundTriggerHwCallback callback) {
            this.mCallback = callback;
        }

        private void wrap(final FunctionalUtils.ThrowingConsumer<ISoundTriggerHwCallback> command) {
            ExecutorHolder.CALLBACK_EXECUTOR.execute(new FakeSoundTriggerHal$CallbackDispatcher$$ExternalSyntheticLambda0(this, command));
        }

        private /* synthetic */ void lambda$wrap$0(FunctionalUtils.ThrowingConsumer command) {
            command.accept(this.mCallback);     // Catch: Throwable -> L4
            return;
        L4:
            e = move-exception;
            Slog.wtf(FakeSoundTriggerHal.TAG, "Callback dispatch threw", e);
        }
    }

    static class ExecutorHolder {
        static final Executor CALLBACK_EXECUTOR = null;
        static final Executor INJECTION_EXECUTOR = null;

        ExecutorHolder() {
        }

        static {
            CALLBACK_EXECUTOR = Executors.newSingleThreadExecutor();
            INJECTION_EXECUTOR = Executors.newSingleThreadExecutor();
        }
    }

    private static class GlobalCallbackDispatcher {
        private final ISoundTriggerHwGlobalCallback mCallback;

        public static /* synthetic */ void $r8$lambda$OFltW2Ss4U4fPSdWApyMhiD5bLE(GlobalCallbackDispatcher r0, FunctionalUtils.ThrowingConsumer r1) {
            r0.lambda$wrap$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mwrap, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8235$$Nest$mwrap(GlobalCallbackDispatcher r0, FunctionalUtils.ThrowingConsumer r1) {
            r0.wrap(r1);
        }

        /* synthetic */ GlobalCallbackDispatcher(ISoundTriggerHwGlobalCallback r1, FakeSoundTriggerHalIA r2) {
            this(r1);
        }

        private GlobalCallbackDispatcher(ISoundTriggerHwGlobalCallback callback) {
            this.mCallback = callback;
        }

        private void wrap(final FunctionalUtils.ThrowingConsumer<ISoundTriggerHwGlobalCallback> command) {
            ExecutorHolder.CALLBACK_EXECUTOR.execute(new FakeSoundTriggerHal$GlobalCallbackDispatcher$$ExternalSyntheticLambda0(this, command));
        }

        private /* synthetic */ void lambda$wrap$0(FunctionalUtils.ThrowingConsumer command) {
            command.accept(this.mCallback);     // Catch: Throwable -> L4
            return;
        L4:
            e = move-exception;
            Slog.wtf(FakeSoundTriggerHal.TAG, "Callback dispatch threw", e);
        }
    }

    private static class InjectionDispatcher {
        private final ISoundTriggerInjection mInjection;

        public static /* synthetic */ void $r8$lambda$pnpqzoQdTdzjstzdqhpQnNpOVVU(InjectionDispatcher r0, FunctionalUtils.ThrowingConsumer r1) {
            r0.lambda$wrap$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mwrap, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8236$$Nest$mwrap(InjectionDispatcher r0, FunctionalUtils.ThrowingConsumer r1) {
            r0.wrap(r1);
        }

        /* synthetic */ InjectionDispatcher(ISoundTriggerInjection r1, FakeSoundTriggerHalIA r2) {
            this(r1);
        }

        private InjectionDispatcher(ISoundTriggerInjection injection) {
            this.mInjection = injection;
        }

        private void wrap(final FunctionalUtils.ThrowingConsumer<ISoundTriggerInjection> command) {
            ExecutorHolder.INJECTION_EXECUTOR.execute(new FakeSoundTriggerHal$InjectionDispatcher$$ExternalSyntheticLambda0(this, command));
        }

        private /* synthetic */ void lambda$wrap$0(FunctionalUtils.ThrowingConsumer command) {
            command.accept(this.mInjection);     // Catch: Throwable -> L4
            return;
        L4:
            e = move-exception;
            Slog.wtf(FakeSoundTriggerHal.TAG, "Callback dispatch threw", e);
        }
    }

    private class ModelSession extends IInjectModelEvent.Stub {
        private final CallbackDispatcher mCallbackDispatcher;
        private final boolean mIsKeyphrase;
        private boolean mIsUnloaded;
        private final int mModelHandle;
        private RecognitionSession mRecognitionSession;
        private int mThreshold;
        final /* synthetic */ FakeSoundTriggerHal this$0;

        private class RecognitionSession extends IInjectRecognitionEvent.Stub {
            final /* synthetic */ ModelSession this$1;

            public static /* synthetic */ void $r8$lambda$64sjqgD4sp65UsgVinjblnckP_g(RecognitionSession r0, RecognitionEvent r1, ISoundTriggerHwCallback r2) {
                r0.lambda$triggerRecognitionEvent$1(r1, r2);
            }

            /* JADX INFO: renamed from: $r8$lambda$EMcy5W6yFUWOLq6cqxfHmLsvK-o, reason: not valid java name */
            public static /* synthetic */ void m8250$r8$lambda$EMcy5W6yFUWOLq6cqxfHmLsvKo(RecognitionSession r0, ISoundTriggerHwCallback r1) {
                r0.lambda$triggerAbortRecognition$3(r1);
            }

            public static /* synthetic */ void $r8$lambda$ZbWqbYP3Z9bKdBjIPxI3tqNU4jU(RecognitionSession r0, ISoundTriggerHwCallback r1) {
                r0.lambda$triggerAbortRecognition$2(r1);
            }

            /* JADX INFO: renamed from: $r8$lambda$pTiAeDwF6qkw5-M0rGvKKO9owKA, reason: not valid java name */
            public static /* synthetic */ void m8251$r8$lambda$pTiAeDwF6qkw5M0rGvKKO9owKA(RecognitionSession r0, PhraseRecognitionEvent r1, ISoundTriggerHwCallback r2) {
                r0.lambda$triggerRecognitionEvent$0(r1, r2);
            }

            /* synthetic */ RecognitionSession(ModelSession r1, FakeSoundTriggerHalIA r2) {
                this(r1);
            }

            private RecognitionSession(ModelSession r1) {
                this.this$1 = r1;
            }

            public void triggerRecognitionEvent(byte[] data, PhraseRecognitionExtra[] phraseExtras) {
                Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$1.this$0);
                monitor-enter(r0);
            L14:
                th = move-exception;
                throw th;
            L5:
                if (FakeSoundTriggerHal.m8223$$Nest$fgetmIsDead(this.this$1.this$0) == true) goto L20;
                if (ModelSession.m8241$$Nest$fgetmRecognitionSession(this.this$1) != this) goto L20;
                ModelSession.m8242$$Nest$fputmRecognitionSession(this.this$1, null);     // Catch: Throwable -> L14
                if (ModelSession.m8239$$Nest$fgetmIsKeyphrase(this.this$1) == false) goto L17;
                final PhraseRecognitionEvent phraseEvent = FakeSoundTriggerHal.m8232$$Nest$smcreateDefaultKeyphraseEvent(0);     // Catch: Throwable -> L14
                phraseEvent.common.data = data;     // Catch: Throwable -> L14
                if (phraseExtras == null) goto L16;
                phraseEvent.phraseExtras = phraseExtras;     // Catch: Throwable -> L14
            L16:
                CallbackDispatcher.m8234$$Nest$mwrap(ModelSession.m8238$$Nest$fgetmCallbackDispatcher(this.this$1), new FakeSoundTriggerHal$ModelSession$RecognitionSession$$ExternalSyntheticLambda2(this, phraseEvent));     // Catch: Throwable -> L14
            L18:
                monitor-exit(r0);     // Catch: Throwable -> L14
                return;
            L17:
                final RecognitionEvent event = FakeSoundTriggerHal.m8231$$Nest$smcreateDefaultEvent(0);     // Catch: Throwable -> L14
                event.data = data;     // Catch: Throwable -> L14
                CallbackDispatcher.m8234$$Nest$mwrap(ModelSession.m8238$$Nest$fgetmCallbackDispatcher(this.this$1), new FakeSoundTriggerHal$ModelSession$RecognitionSession$$ExternalSyntheticLambda3(this, event));     // Catch: Throwable -> L14
            L20:
                monitor-exit(r0);     // Catch: Throwable -> L14
            }

            private /* synthetic */ void lambda$triggerRecognitionEvent$0(PhraseRecognitionEvent phraseEvent, ISoundTriggerHwCallback cb) throws Exception {
                cb.phraseRecognitionCallback(ModelSession.m8240$$Nest$fgetmModelHandle(this.this$1), phraseEvent);
            }

            private /* synthetic */ void lambda$triggerRecognitionEvent$1(RecognitionEvent event, ISoundTriggerHwCallback cb) throws Exception {
                cb.recognitionCallback(ModelSession.m8240$$Nest$fgetmModelHandle(this.this$1), event);
            }

            public void triggerAbortRecognition() {
                Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$1.this$0);
                monitor-enter(r0);
            L12:
                th = move-exception;
                throw th;
            L5:
                if (FakeSoundTriggerHal.m8223$$Nest$fgetmIsDead(this.this$1.this$0) == true) goto L17;
                if (ModelSession.m8241$$Nest$fgetmRecognitionSession(this.this$1) != this) goto L17;
                ModelSession.m8242$$Nest$fputmRecognitionSession(this.this$1, null);     // Catch: Throwable -> L12
                if (ModelSession.m8239$$Nest$fgetmIsKeyphrase(this.this$1) == false) goto L14;
                CallbackDispatcher.m8234$$Nest$mwrap(ModelSession.m8238$$Nest$fgetmCallbackDispatcher(this.this$1), new FakeSoundTriggerHal$ModelSession$RecognitionSession$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L12
            L15:
                monitor-exit(r0);     // Catch: Throwable -> L12
                return;
            L14:
                CallbackDispatcher.m8234$$Nest$mwrap(ModelSession.m8238$$Nest$fgetmCallbackDispatcher(this.this$1), new FakeSoundTriggerHal$ModelSession$RecognitionSession$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L12
            L17:
                monitor-exit(r0);     // Catch: Throwable -> L12
            }

            private /* synthetic */ void lambda$triggerAbortRecognition$2(ISoundTriggerHwCallback cb) throws Exception {
                cb.phraseRecognitionCallback(ModelSession.m8240$$Nest$fgetmModelHandle(this.this$1), FakeSoundTriggerHal.m8232$$Nest$smcreateDefaultKeyphraseEvent(1));
            }

            private /* synthetic */ void lambda$triggerAbortRecognition$3(ISoundTriggerHwCallback cb) throws Exception {
                cb.recognitionCallback(ModelSession.m8240$$Nest$fgetmModelHandle(this.this$1), FakeSoundTriggerHal.m8231$$Nest$smcreateDefaultEvent(1));
            }
        }

        public static /* synthetic */ void $r8$lambda$3ufpFdEAzJMmtJMjpCpdd7c0BVk(ISoundTriggerHwGlobalCallback r0) {
            lambda$triggerUnloadModel$3(r0);
        }

        public static /* synthetic */ void $r8$lambda$qb5X1SYl0FCs3qEYbOWGSaiTkgM(ModelSession r0, PhraseRecognitionEvent r1, ISoundTriggerHwCallback r2) {
            r0.lambda$forceRecognitionForModel$0(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$y_eY-d2JY3NOeDspNBkQhT0bVEM, reason: not valid java name */
        public static /* synthetic */ void m8237$r8$lambda$y_eYd2JY3NOeDspNBkQhT0bVEM(ModelSession r0, RecognitionEvent r1, ISoundTriggerHwCallback r2) {
            r0.lambda$forceRecognitionForModel$1(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$zpM3wiIVhMroZUIX7L4vxoh_Fgs(ModelSession r0, ISoundTriggerHwCallback r1) {
            r0.lambda$triggerUnloadModel$2(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallbackDispatcher, reason: not valid java name */
        static /* bridge */ /* synthetic */ CallbackDispatcher m8238$$Nest$fgetmCallbackDispatcher(ModelSession r0) {
            return r0.mCallbackDispatcher;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsKeyphrase, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8239$$Nest$fgetmIsKeyphrase(ModelSession r0) {
            return r0.mIsKeyphrase;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmModelHandle, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8240$$Nest$fgetmModelHandle(ModelSession r0) {
            return r0.mModelHandle;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRecognitionSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ RecognitionSession m8241$$Nest$fgetmRecognitionSession(ModelSession r0) {
            return r0.mRecognitionSession;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmRecognitionSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8242$$Nest$fputmRecognitionSession(ModelSession r0, RecognitionSession r1) {
            r0.mRecognitionSession = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mforceRecognitionForModel, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8243$$Nest$mforceRecognitionForModel(ModelSession r0) {
            r0.forceRecognitionForModel();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetIsUnloaded, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8244$$Nest$mgetIsUnloaded(ModelSession r0) {
            return r0.getIsUnloaded();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetRecogSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ RecognitionSession m8245$$Nest$mgetRecogSession(ModelSession r0) {
            return r0.getRecogSession();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetThresholdFactor, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8246$$Nest$mgetThresholdFactor(ModelSession r0) {
            return r0.getThresholdFactor();
        }

        /* JADX INFO: renamed from: -$$Nest$msetThresholdFactor, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8247$$Nest$msetThresholdFactor(ModelSession r0, int r1) {
            r0.setThresholdFactor(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mstartRecognitionForModel, reason: not valid java name */
        static /* bridge */ /* synthetic */ RecognitionSession m8248$$Nest$mstartRecognitionForModel(ModelSession r0) {
            return r0.startRecognitionForModel();
        }

        /* JADX INFO: renamed from: -$$Nest$mstopRecognitionForModel, reason: not valid java name */
        static /* bridge */ /* synthetic */ RecognitionSession m8249$$Nest$mstopRecognitionForModel(ModelSession r0) {
            return r0.stopRecognitionForModel();
        }

        /* synthetic */ ModelSession(FakeSoundTriggerHal r1, int r2, CallbackDispatcher r3, boolean r4, FakeSoundTriggerHalIA r5) {
            this(r1, r2, r3, r4);
        }

        private ModelSession(FakeSoundTriggerHal r1, int modelHandle, CallbackDispatcher callbackDispatcher, boolean isKeyphrase) {
            this.this$0 = r1;
            this.mThreshold = 0;
            this.mIsUnloaded = false;
            this.mModelHandle = modelHandle;
            this.mCallbackDispatcher = callbackDispatcher;
            this.mIsKeyphrase = isKeyphrase;
        }

        private RecognitionSession startRecognitionForModel() {
            Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.mRecognitionSession = new RecognitionSession(this, null);     // Catch: Throwable -> L7
            RecognitionSession r1 = this.mRecognitionSession;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        private RecognitionSession stopRecognitionForModel() {
            Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RecognitionSession session = this.mRecognitionSession;     // Catch: Throwable -> L7
            this.mRecognitionSession = null;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return session;
        L7:
            th = move-exception;
            throw th;
        }

        private void forceRecognitionForModel() {
            Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mIsKeyphrase == false) goto L9;
            final PhraseRecognitionEvent phraseEvent = FakeSoundTriggerHal.m8232$$Nest$smcreateDefaultKeyphraseEvent(3);     // Catch: Throwable -> L7
            CallbackDispatcher.m8234$$Nest$mwrap(this.mCallbackDispatcher, new FakeSoundTriggerHal$ModelSession$$ExternalSyntheticLambda2(this, phraseEvent));     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            final RecognitionEvent event = FakeSoundTriggerHal.m8231$$Nest$smcreateDefaultEvent(3);     // Catch: Throwable -> L7
            CallbackDispatcher.m8234$$Nest$mwrap(this.mCallbackDispatcher, new FakeSoundTriggerHal$ModelSession$$ExternalSyntheticLambda3(this, event));     // Catch: Throwable -> L7
            goto L10
        }

        private /* synthetic */ void lambda$forceRecognitionForModel$0(PhraseRecognitionEvent phraseEvent, ISoundTriggerHwCallback cb) throws Exception {
            cb.phraseRecognitionCallback(this.mModelHandle, phraseEvent);
        }

        private /* synthetic */ void lambda$forceRecognitionForModel$1(RecognitionEvent event, ISoundTriggerHwCallback cb) throws Exception {
            cb.recognitionCallback(this.mModelHandle, event);
        }

        private void setThresholdFactor(int value) {
            Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.mThreshold = value;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private int getThresholdFactor() {
            Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int r1 = this.mThreshold;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        private boolean getIsUnloaded() {
            Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = this.mIsUnloaded;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        private RecognitionSession getRecogSession() {
            Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RecognitionSession r1 = this.mRecognitionSession;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void triggerUnloadModel() {
            Object r0 = FakeSoundTriggerHal.m8225$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (FakeSoundTriggerHal.m8223$$Nest$fgetmIsDead(this.this$0) == true) goto L21;
            if (this.mIsUnloaded == true) goto L21;
            if (this.mRecognitionSession == null) goto L14;
            this.mRecognitionSession.triggerAbortRecognition();     // Catch: Throwable -> L12
        L14:
            this.mIsUnloaded = true;     // Catch: Throwable -> L12
            CallbackDispatcher.m8234$$Nest$mwrap(this.mCallbackDispatcher, new FakeSoundTriggerHal$ModelSession$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L12
            if (FakeSoundTriggerHal.m8230$$Nest$mgetNumLoadedModelsLocked(this.this$0) == (FakeSoundTriggerHal.m8227$$Nest$fgetmProperties(this.this$0).maxSoundModels - 1)) goto L17;
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L17:
            if (FakeSoundTriggerHal.m8224$$Nest$fgetmIsResourceContended(this.this$0) == true) goto L19;
            GlobalCallbackDispatcher.m8235$$Nest$mwrap(FakeSoundTriggerHal.m8221$$Nest$fgetmGlobalCallbackDispatcher(this.this$0), new FakeSoundTriggerHal$ModelSession$$ExternalSyntheticLambda1());     // Catch: Throwable -> L12
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L12
        }

        private /* synthetic */ void lambda$triggerUnloadModel$2(ISoundTriggerHwCallback cb) throws Exception {
            cb.modelUnloaded(this.mModelHandle);
        }

        private static /* synthetic */ void lambda$triggerUnloadModel$3(ISoundTriggerHwGlobalCallback cb) throws Exception {
            cb.onResourcesAvailable();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-Qjoj0MqRXhchf-50-IjfmQxECU, reason: not valid java name */
    public static /* synthetic */ void m8217$r8$lambda$Qjoj0MqRXhchf50IjfmQxECU(RecognitionConfig r0, ModelSession.RecognitionSession r1, ModelSession r2, ISoundTriggerInjection r3) {
        lambda$startRecognition$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$41friA0u5mUpSibCjA5jNhYu5ps(FakeSoundTriggerHal r0, SoundModel r1, ModelSession r2, ISoundTriggerInjection r3) {
        r0.lambda$loadSoundModel$1(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$5oM9qepYifylrd9ttRDTLXLM84g(ModelSession r0, ISoundTriggerInjection r1) {
        lambda$unloadSoundModel$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$D8VAFUSx6IBzUHbmeGEYHDY1R0Y(FakeSoundTriggerHal r0, PhraseSoundModel r1, ModelSession r2, ISoundTriggerInjection r3) {
        r0.lambda$loadPhraseSoundModel$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$IDPo4Vyq08W-b31ENAIaet2E0FE, reason: not valid java name */
    public static /* synthetic */ void m8218$r8$lambda$IDPo4Vyq08Wb31ENAIaet2E0FE(ISoundTriggerHwGlobalCallback r0) {
        lambda$unloadSoundModel$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$_r7zgC45YMbhkVPbRFw41fe6CNU(FakeSoundTriggerHal r0, ISoundTriggerInjection r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$hs93o6QYJV0yRbAqrtTPfQ-bqSM, reason: not valid java name */
    public static /* synthetic */ void m8219$r8$lambda$hs93o6QYJV0yRbAqrtTPfQbqSM(int r0, int r1, ModelSession r2, ISoundTriggerInjection r3) {
        lambda$setParameter$7(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ic_NsW2JMiOfkLXCdZ7rrUTsAVE(ModelSession.RecognitionSession r0, ISoundTriggerInjection r1) {
        lambda$stopRecognition$6(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeathRecipient, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder.DeathRecipient m8220$$Nest$fgetmDeathRecipient(FakeSoundTriggerHal r0) {
        return r0.mDeathRecipient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGlobalCallbackDispatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ GlobalCallbackDispatcher m8221$$Nest$fgetmGlobalCallbackDispatcher(FakeSoundTriggerHal r0) {
        return r0.mGlobalCallbackDispatcher;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjectionDispatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ InjectionDispatcher m8222$$Nest$fgetmInjectionDispatcher(FakeSoundTriggerHal r0) {
        return r0.mInjectionDispatcher;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsDead, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8223$$Nest$fgetmIsDead(FakeSoundTriggerHal r0) {
        return r0.mIsDead;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsResourceContended, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8224$$Nest$fgetmIsResourceContended(FakeSoundTriggerHal r0) {
        return r0.mIsResourceContended;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8225$$Nest$fgetmLock(FakeSoundTriggerHal r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmModelSessionMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m8226$$Nest$fgetmModelSessionMap(FakeSoundTriggerHal r0) {
        return r0.mModelSessionMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ Properties m8227$$Nest$fgetmProperties(FakeSoundTriggerHal r0) {
        return r0.mProperties;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsDead, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8228$$Nest$fputmIsDead(FakeSoundTriggerHal r0, boolean r1) {
        r0.mIsDead = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsResourceContended, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8229$$Nest$fputmIsResourceContended(FakeSoundTriggerHal r0, boolean r1) {
        r0.mIsResourceContended = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetNumLoadedModelsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8230$$Nest$mgetNumLoadedModelsLocked(FakeSoundTriggerHal r0) {
        return r0.getNumLoadedModelsLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$smcreateDefaultEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ RecognitionEvent m8231$$Nest$smcreateDefaultEvent(int r0) {
        return createDefaultEvent(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smcreateDefaultKeyphraseEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ PhraseRecognitionEvent m8232$$Nest$smcreateDefaultKeyphraseEvent(int r0) {
        return createDefaultKeyphraseEvent(r0);
    }

    public FakeSoundTriggerHal(ISoundTriggerInjection injection) {
        this.mLock = new Object();
        this.mGlobalCallbackDispatcher = null;
        this.mIsResourceContended = false;
        this.mModelSessionMap = new HashMap();
        this.mModelKeyCounter = 101;
        this.mIsDead = false;
        this.mProperties = createDefaultProperties();
        this.mInjectionDispatcher = new InjectionDispatcher(injection, null);
        this.mGlobalCallbackDispatcher = null;
        this.mGlobalEventSession = new AnonymousClass1(this);
        InjectionDispatcher.m8236$$Nest$mwrap(this.mInjectionDispatcher, new FakeSoundTriggerHal$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$new$0(ISoundTriggerInjection cb) throws Exception {
        cb.registerGlobalEventInjection(this.mGlobalEventSession);
    }

    public IInjectGlobalEvent getGlobalEventInjection() {
        return this.mGlobalEventSession;
    }

    public void linkToDeath(IBinder.DeathRecipient recipient, int flags) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mDeathRecipient == null) goto L9;
        Slog.wtf(TAG, "Received two death recipients concurrently");     // Catch: Throwable -> L7
    L9:
        this.mDeathRecipient = recipient;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public boolean unlinkToDeath(IBinder.DeathRecipient recipient, int flags) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L12:
        if (this.mDeathRecipient != recipient) goto L18;
        this.mDeathRecipient = null;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L18:
        throw new NoSuchElementException();     // Catch: Throwable -> L9
    }

    public Properties getProperties() throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == true) goto L17;
        Parcel parcel = Parcel.obtain();     // Catch: Throwable -> L11
        this.mProperties.writeToParcel(parcel, 0);     // Catch: Throwable -> L13
        parcel.setDataPosition(0);     // Catch: Throwable -> L13
        Properties r2 = (Properties) Properties.CREATOR.createFromParcel(parcel);     // Catch: Throwable -> L13
        parcel.recycle();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L13:
        th = move-exception;
        parcel.recycle();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L17:
        throw new DeadObjectException();     // Catch: Throwable -> L11
    }

    public void registerGlobalCallback(ISoundTriggerHwGlobalCallback callback) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == true) goto L12;
        this.mGlobalCallbackDispatcher = new GlobalCallbackDispatcher(callback, null);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new DeadObjectException();     // Catch: Throwable -> L9
    }

    public int loadSoundModel(final SoundModel soundModel, ISoundTriggerHwCallback callback) throws RemoteException {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L17:
        th = th;
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L15
        throw th;
    L5:
        if (this.mIsDead == true) goto L22;
        if (this.mIsResourceContended == true) goto L20;
        if (getNumLoadedModelsLocked() == this.mProperties.maxSoundModels) goto L20;
        int key = this.mModelKeyCounter;     // Catch: Throwable -> L17
        this.mModelKeyCounter = key + 1;     // Catch: Throwable -> L17
        final ModelSession session = new ModelSession(this, key, new CallbackDispatcher(callback, null), false, null);     // Catch: Throwable -> L15
        this.mModelSessionMap.put(Integer.valueOf(key), session);     // Catch: Throwable -> L15
        InjectionDispatcher.m8236$$Nest$mwrap(this.mInjectionDispatcher, new FakeSoundTriggerHal$$ExternalSyntheticLambda4(this, soundModel, session));     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return key;
    L20:
        throw new ServiceSpecificException(1);     // Catch: Throwable -> L15
    L22:
        throw new DeadObjectException();     // Catch: Throwable -> L15
    L15:
        th = th;
        goto L23
    }

    private /* synthetic */ void lambda$loadSoundModel$1(SoundModel soundModel, ModelSession session, ISoundTriggerInjection cb) throws Exception {
        cb.onSoundModelLoaded(soundModel, null, session, this.mGlobalEventSession);
    }

    public int loadPhraseSoundModel(final PhraseSoundModel soundModel, ISoundTriggerHwCallback callback) throws RemoteException {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L17:
        th = th;
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L15
        throw th;
    L5:
        if (this.mIsDead == true) goto L22;
        if (this.mIsResourceContended == true) goto L20;
        if (getNumLoadedModelsLocked() == this.mProperties.maxSoundModels) goto L20;
        int key = this.mModelKeyCounter;     // Catch: Throwable -> L17
        this.mModelKeyCounter = key + 1;     // Catch: Throwable -> L17
        final ModelSession session = new ModelSession(this, key, new CallbackDispatcher(callback, null), true, null);     // Catch: Throwable -> L15
        this.mModelSessionMap.put(Integer.valueOf(key), session);     // Catch: Throwable -> L15
        InjectionDispatcher.m8236$$Nest$mwrap(this.mInjectionDispatcher, new FakeSoundTriggerHal$$ExternalSyntheticLambda5(this, soundModel, session));     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return key;
    L20:
        throw new ServiceSpecificException(1);     // Catch: Throwable -> L15
    L22:
        throw new DeadObjectException();     // Catch: Throwable -> L15
    L15:
        th = th;
        goto L23
    }

    private /* synthetic */ void lambda$loadPhraseSoundModel$2(PhraseSoundModel soundModel, ModelSession session, ISoundTriggerInjection cb) throws Exception {
        cb.onSoundModelLoaded(soundModel.common, soundModel.phrases, session, this.mGlobalEventSession);
    }

    public void unloadSoundModel(int modelHandle) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == true) goto L26;
        final ModelSession session = this.mModelSessionMap.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L9
        if (session != null) goto L12;
        Slog.wtf(TAG, "Attempted to unload model which was never loaded");     // Catch: Throwable -> L9
    L12:
        if (ModelSession.m8245$$Nest$mgetRecogSession(session) == null) goto L15;
        Slog.wtf(TAG, "Session unloaded before recog stopped!");     // Catch: Throwable -> L9
    L15:
        if (ModelSession.m8244$$Nest$mgetIsUnloaded(session) == false) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L18:
        InjectionDispatcher.m8236$$Nest$mwrap(this.mInjectionDispatcher, new FakeSoundTriggerHal$$ExternalSyntheticLambda1(session));     // Catch: Throwable -> L9
        if (getNumLoadedModelsLocked() == (this.mProperties.maxSoundModels - 1)) goto L21;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L21:
        if (this.mIsResourceContended == true) goto L23;
        GlobalCallbackDispatcher.m8235$$Nest$mwrap(this.mGlobalCallbackDispatcher, new FakeSoundTriggerHal$$ExternalSyntheticLambda2());     // Catch: Throwable -> L9
        goto L23
    L26:
        throw new DeadObjectException();     // Catch: Throwable -> L9
    }

    private static /* synthetic */ void lambda$unloadSoundModel$3(ModelSession session, ISoundTriggerInjection cb) throws Exception {
        cb.onSoundModelUnloaded(session);
    }

    private static /* synthetic */ void lambda$unloadSoundModel$4(ISoundTriggerHwGlobalCallback cb) throws Exception {
        cb.onResourcesAvailable();
    }

    public void startRecognition(int modelHandle, int deviceHandle, int ioHandle, final RecognitionConfig config) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == true) goto L23;
        final ModelSession session = this.mModelSessionMap.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L9
        if (session != null) goto L12;
        Slog.wtf(TAG, "Attempted to start recognition with invalid handle");     // Catch: Throwable -> L9
    L12:
        if (this.mIsResourceContended == true) goto L21;
        if (ModelSession.m8244$$Nest$mgetIsUnloaded(session) == true) goto L19;
        final ModelSession.RecognitionSession recogSession = ModelSession.m8248$$Nest$mstartRecognitionForModel(session);     // Catch: Throwable -> L9
        InjectionDispatcher.m8236$$Nest$mwrap(this.mInjectionDispatcher, new FakeSoundTriggerHal$$ExternalSyntheticLambda6(config, recogSession, session));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L19:
        throw new ServiceSpecificException(1);     // Catch: Throwable -> L9
    L21:
        throw new ServiceSpecificException(1);     // Catch: Throwable -> L9
    L23:
        throw new DeadObjectException();     // Catch: Throwable -> L9
    }

    private static /* synthetic */ void lambda$startRecognition$5(RecognitionConfig config, ModelSession.RecognitionSession recogSession, ModelSession session, ISoundTriggerInjection cb) throws Exception {
        cb.onRecognitionStarted(-1, config, recogSession, session);
    }

    public void stopRecognition(int modelHandle) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == true) goto L17;
        ModelSession session = this.mModelSessionMap.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L9
        if (session != null) goto L11;
        Slog.wtf(TAG, "Attempted to stop recognition with invalid handle");     // Catch: Throwable -> L9
    L11:
        final ModelSession.RecognitionSession recogSession = ModelSession.m8249$$Nest$mstopRecognitionForModel(session);     // Catch: Throwable -> L9
        if (recogSession == null) goto L14;
        InjectionDispatcher.m8236$$Nest$mwrap(this.mInjectionDispatcher, new FakeSoundTriggerHal$$ExternalSyntheticLambda7(recogSession));     // Catch: Throwable -> L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L17:
        throw new DeadObjectException();     // Catch: Throwable -> L9
    }

    private static /* synthetic */ void lambda$stopRecognition$6(ModelSession.RecognitionSession recogSession, ISoundTriggerInjection cb) throws Exception {
        cb.onRecognitionStopped(recogSession);
    }

    public void forceRecognitionEvent(int modelHandle) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == true) goto L19;
        ModelSession session = this.mModelSessionMap.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L9
        if (session != null) goto L12;
        Slog.wtf(TAG, "Attempted to force recognition with invalid handle");     // Catch: Throwable -> L9
    L12:
        if (ModelSession.m8245$$Nest$mgetRecogSession(session) != null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L15:
        ModelSession.m8243$$Nest$mforceRecognitionForModel(session);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L19:
        throw new DeadObjectException();     // Catch: Throwable -> L9
    }

    public ModelParameterRange queryParameter(int modelHandle, int modelParam) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == true) goto L18;
        ModelSession session = this.mModelSessionMap.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L9
        if (session != null) goto L11;
        Slog.wtf(TAG, "Attempted to get param with invalid handle");     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (modelParam != 0) goto L15;
        ModelParameterRange range = new ModelParameterRange();
        range.minInclusive = -10;
        range.maxInclusive = 10;
        return range;
    L15:
        return null;
    L18:
        throw new DeadObjectException();     // Catch: Throwable -> L9
    }

    public int getParameter(int modelHandle, int modelParam) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == true) goto L18;
        ModelSession session = this.mModelSessionMap.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L9
        if (session != null) goto L11;
        Slog.wtf(TAG, "Attempted to get param with invalid handle");     // Catch: Throwable -> L9
    L11:
        if (modelParam != 0) goto L16;
        int r2 = ModelSession.m8246$$Nest$mgetThresholdFactor(session);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L16:
        throw new IllegalArgumentException();     // Catch: Throwable -> L9
    L18:
        throw new DeadObjectException();     // Catch: Throwable -> L9
    }

    public void setParameter(int modelHandle, final int modelParam, final int value) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == true) goto L23;
        final ModelSession session = this.mModelSessionMap.get(Integer.valueOf(modelHandle));     // Catch: Throwable -> L9
        if (session != null) goto L11;
        Slog.wtf(TAG, "Attempted to get param with invalid handle");     // Catch: Throwable -> L9
    L11:
        if (modelParam == 0) goto L19;
        if (value < (-10)) goto L18;
        if (value <= 10) goto L19;
    L18:
        throw new IllegalArgumentException();     // Catch: Throwable -> L9
    L19:
        ModelSession.m8247$$Nest$msetThresholdFactor(session, value);     // Catch: Throwable -> L9
        InjectionDispatcher.m8236$$Nest$mwrap(this.mInjectionDispatcher, new FakeSoundTriggerHal$$ExternalSyntheticLambda3(modelParam, value, session));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L23:
        throw new DeadObjectException();     // Catch: Throwable -> L9
    }

    private static /* synthetic */ void lambda$setParameter$7(int modelParam, int value, ModelSession session, ISoundTriggerInjection cb) throws Exception {
        cb.onParamSet(modelParam, value, session);
    }

    public int getInterfaceVersion() throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 3;
    L12:
        throw new DeadObjectException();     // Catch: Throwable -> L9
    }

    public String getInterfaceHash() throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDead == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return "f2ec48a74490bf9d5675f48cb89ecdb3e5cd9c35";
    L12:
        throw new DeadObjectException();     // Catch: Throwable -> L9
    }

    private int getNumLoadedModelsLocked() {
        int numModels = 0;
        Iterator<ModelSession> r1 = this.mModelSessionMap.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ModelSession session = r1.next();
        if (ModelSession.m8244$$Nest$mgetIsUnloaded(session) == true) goto L4;
        numModels = numModels + 1;
        goto L4
    L9:
        return numModels;
    }

    private static Properties createDefaultProperties() {
        Properties properties = new Properties();
        properties.implementor = PackageManagerService.PLATFORM_PACKAGE_NAME;
        properties.description = "AOSP fake STHAL";
        properties.version = 1;
        properties.uuid = "00000001-0002-0003-0004-deadbeefabcd";
        properties.supportedModelArch = "injection";
        properties.maxSoundModels = 8;
        properties.maxKeyPhrases = 2;
        properties.maxUsers = 2;
        properties.recognitionModes = 9;
        properties.captureTransition = true;
        properties.maxBufferMs = 5000;
        properties.concurrentCapture = true;
        properties.triggerInEvent = false;
        properties.powerConsumptionMw = 0;
        properties.audioCapabilities = 0;
        return properties;
    }

    private static RecognitionEvent createDefaultEvent(int status) {
        RecognitionEvent event = new RecognitionEvent();
        event.status = status;
        event.type = 1;
        event.captureAvailable = true;
        event.captureDelayMs = 50;
        event.capturePreambleMs = 200;
        event.triggerInData = false;
        event.audioConfig = null;
        event.data = new byte[0];
        event.recognitionStillActive = false;
        return event;
    }

    private static PhraseRecognitionEvent createDefaultKeyphraseEvent(int status) {
        RecognitionEvent event = createDefaultEvent(status);
        event.type = 0;
        PhraseRecognitionEvent phraseEvent = new PhraseRecognitionEvent();
        phraseEvent.common = event;
        phraseEvent.phraseExtras = new PhraseRecognitionExtra[0];
        return phraseEvent;
    }
}
