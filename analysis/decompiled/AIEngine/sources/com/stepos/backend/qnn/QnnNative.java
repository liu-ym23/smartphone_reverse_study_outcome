package com.stepos.backend.qnn;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.base.health.EngineMetrics;
import com.stepos.core.performance.orchestrator.PerformanceOrchestratorImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class QnnNative {
    private static final String ADSP_LIBRARY_PATH = "/vendor/lib/rfsa/adsp:/vendor/dsp/cdsp:/system/lib/rfsa/adsp:/dsp";
    private static final long SO_LOAD_SLOW_MS = 2000;
    private static final String TAG = "QnnNative";
    private static final ConcurrentHashMap<ComputeBucket, ResizableSemaphore> buckets;
    private static volatile boolean isInitialized;
    private static volatile boolean jniLibrariesLoaded;
    private static final ConcurrentHashMap<String, Mutex> modelLocks;
    private static volatile boolean stageCallbackEnabled;
    public static final QnnNative INSTANCE = new QnnNative();
    private static final Mutex inferLock = MutexKt.Mutex$default(false, 1, null);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface IAsrStreamCallback {
        void onChunk(String str, long j10, long j11);

        void onEnd();

        void onError(int i10, String str);

        void onTokenLimit();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ResizableSemaphore extends Semaphore {
        private volatile int maxPermits;

        public ResizableSemaphore(int i10) {
            super(i10, true);
            this.maxPermits = i10;
        }

        public final int getMaxPermits() {
            return this.maxPermits;
        }

        public final synchronized void setMax(int i10) {
            try {
                int i11 = i10 - this.maxPermits;
                if (i11 > 0) {
                    release(i11);
                } else if (i11 < 0) {
                    reducePermits(-i11);
                }
                this.maxPermits = i10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnNative", f = "QnnNative.kt", l = {415, 424}, m = "acquireInferPermit")
    /* renamed from: com.stepos.backend.qnn.QnnNative$acquireInferPermit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnNative.this.acquireInferPermit(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnNative$acquireInferPermit$2", f = "QnnNative.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnNative$acquireInferPermit$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {
        final /* synthetic */ String $modelId;
        final /* synthetic */ ResizableSemaphore $sem;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, ResizableSemaphore resizableSemaphore, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$modelId = str;
            this.$sem = resizableSemaphore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new AnonymousClass2(this.$modelId, this.$sem, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws InterruptedException {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            Log.d(QnnNative.TAG, "Waiting for infer permit (fair queue) modelId=" + this.$modelId + "...");
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            this.$sem.acquire();
            AtomicLong atomicLong = EngineMetrics.f6226a;
            EngineMetrics.f6242s.l((SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000);
            return lb.n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnNative$acquireInferPermitWithTimeout$2", f = "QnnNative.kt", l = {449}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnNative$acquireInferPermitWithTimeout$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02572 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super Boolean>, Object> {
        final /* synthetic */ String $modelId;
        final /* synthetic */ ResizableSemaphore $sem;
        final /* synthetic */ long $timeoutMs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02572(String str, long j10, ResizableSemaphore resizableSemaphore, qb.b<? super C02572> bVar) {
            super(2, bVar);
            this.$modelId = str;
            this.$timeoutMs = j10;
            this.$sem = resizableSemaphore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new C02572(this.$modelId, this.$timeoutMs, this.$sem, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            boolean z = true;
            if (i10 == 0) {
                kotlin.c.b(obj);
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                StringBuilder sbL = com.stepos.core.ota.d.l("Waiting for infer permit modelId=", this.$timeoutMs, this.$modelId, " timeout=");
                sbL.append("ms...");
                Log.d(QnnNative.TAG, sbL.toString());
                if (!this.$sem.tryAcquire(this.$timeoutMs, TimeUnit.MILLISECONDS)) {
                    Log.w(QnnNative.TAG, a0.a.h("⚠️ Infer permit timeout after ", this.$timeoutMs, "ms modelId=", this.$modelId));
                    return Boolean.FALSE;
                }
                long jElapsedRealtime2 = this.$timeoutMs - (SystemClock.elapsedRealtime() - jElapsedRealtime);
                if (jElapsedRealtime2 < 1) {
                    jElapsedRealtime2 = 1;
                }
                QnnNative$acquireInferPermitWithTimeout$2$gotLock$1 qnnNative$acquireInferPermitWithTimeout$2$gotLock$1 = new QnnNative$acquireInferPermitWithTimeout$2$gotLock$1(this.$modelId, null);
                this.label = 1;
                obj = TimeoutKt.withTimeoutOrNull(jElapsedRealtime2, qnnNative$acquireInferPermitWithTimeout$2$gotLock$1, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            Boolean bool = (Boolean) obj;
            if (bool != null ? bool.booleanValue() : false) {
                a0.a.v("Infer permit acquired (with timeout) modelId=", this.$modelId, QnnNative.TAG);
            } else {
                this.$sem.release();
                ai.onnxruntime.a.x("⚠️ model lock timeout modelId=", this.$modelId, ", permit released", QnnNative.TAG);
                z = false;
            }
            return Boolean.valueOf(z);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Boolean> bVar) {
            return ((C02572) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnNative$acquireRawPermitWithTimeout$2", f = "QnnNative.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.qnn.QnnNative$acquireRawPermitWithTimeout$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02582 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super Boolean>, Object> {
        final /* synthetic */ long $timeoutMs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02582(long j10, qb.b<? super C02582> bVar) {
            super(2, bVar);
            this.$timeoutMs = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            return new C02582(this.$timeoutMs, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return Boolean.valueOf(QnnNative.INSTANCE.bucketSemaphore(ComputeBucket.HTP).tryAcquire(this.$timeoutMs, TimeUnit.MILLISECONDS));
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super Boolean> bVar) {
            return ((C02582) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.QnnNative", f = "QnnNative.kt", l = {941, 392}, m = "withInferLock")
    /* renamed from: com.stepos.backend.qnn.QnnNative$withInferLock$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02591<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02591(qb.b<? super C02591> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QnnNative.this.withInferLock(null, null, this);
        }
    }

    static {
        ConcurrentHashMap<ComputeBucket, ResizableSemaphore> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(ComputeBucket.HTP, new ResizableSemaphore(2));
        buckets = concurrentHashMap;
        modelLocks = new ConcurrentHashMap<>();
        stageCallbackEnabled = true;
    }

    private QnnNative() {
    }

    public static /* synthetic */ Object acquireInferPermitWithTimeout$default(QnnNative qnnNative, String str, long j10, qb.b bVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 15000;
        }
        return qnnNative.acquireInferPermitWithTimeout(str, j10, bVar);
    }

    public static /* synthetic */ Object acquireRawPermitWithTimeout$default(QnnNative qnnNative, long j10, qb.b bVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 15000;
        }
        return qnnNative.acquireRawPermitWithTimeout(j10, bVar);
    }

    private final ComputeBucket bucketFor(String str) {
        return ComputeBucket.HTP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResizableSemaphore bucketSemaphore(ComputeBucket computeBucket) {
        ResizableSemaphore resizableSemaphorePutIfAbsent;
        ConcurrentHashMap<ComputeBucket, ResizableSemaphore> concurrentHashMap = buckets;
        ResizableSemaphore resizableSemaphore = concurrentHashMap.get(computeBucket);
        if (resizableSemaphore == null && (resizableSemaphorePutIfAbsent = concurrentHashMap.putIfAbsent(computeBucket, (resizableSemaphore = new ResizableSemaphore(2)))) != null) {
            resizableSemaphore = resizableSemaphorePutIfAbsent;
        }
        return resizableSemaphore;
    }

    public static final boolean getStageCallbackEnabled() {
        return stageCallbackEnabled;
    }

    private static final void loadQnnLibraries$tryLoad(String str, boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            System.loadLibrary(str);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            Log.d(TAG, "✅ Loaded: " + str + " (" + jElapsedRealtime2 + "ms)");
            if (jElapsedRealtime2 > 2000) {
                Log.w(TAG, "so_load_slow: " + str + " took " + jElapsedRealtime2 + "ms (threshold=2000ms)");
            }
        } catch (UnsatisfiedLinkError e10) {
            String strL = ai.onnxruntime.a.l("loadLibrary(", str, ") failed: ", e10.getMessage());
            if (!z) {
                ai.onnxruntime.a.x("⚠️ ", strL, " (optional, skipped)", TAG);
                return;
            }
            Log.e(TAG, "❌ " + strL);
            throw e10;
        }
    }

    public static /* synthetic */ void loadQnnLibraries$tryLoad$default(String str, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = true;
        }
        loadQnnLibraries$tryLoad(str, z);
    }

    public static final native long nativeAsrCreate(String str, String str2, boolean z);

    public static final native boolean nativeAsrFileGenerate(long j10, byte[] bArr, int i10, int i11, boolean z, Object obj);

    public static final native String nativeAsrGenerate(long j10, byte[] bArr, int i10, int i11);

    public static final native String nativeAsrPostprocess(String str, int i10, int i11);

    public static final native void nativeAsrRelease(long j10);

    public static final native boolean nativeAsrSetPerformancePolicy(long j10, int i10);

    public static final native boolean nativeAsrStreamGenerate(long j10, byte[] bArr, int i10, int i11, boolean z, Object obj);

    public static final native boolean nativeAsrTextGenerate(long j10, String str, Object obj);

    public static final native boolean nativeChatStream(long j10, String str, Object obj, int i10);

    public static final native boolean nativeChatStreamWithSystem(long j10, String str, String str2, Object obj, int i10, float f8, int i11, float f9, float f10);

    public static final native void nativeClearASRPhaseCallback(long j10);

    public static final native void nativeClearLLMPhaseCallback(long j10, int i10);

    public static final native void nativeClearTTSPhaseCallback(long j10);

    public static final native long nativeInit(String str, String str2);

    public static final native boolean nativeLLMCancel(long j10);

    public static final native void nativeRelease(long j10);

    public static final native boolean nativeResetChat(long j10);

    public static final native void nativeResetLoRA(long j10);

    public static final native int nativeSetASRPhaseCallback(long j10, int i10, int i11, Object obj);

    public static final native void nativeSetEnv(String str, String str2);

    public static final native int nativeSetLLMPhaseCallback(long j10, int i10, int i11, Object obj);

    public static final native int nativeSetTTSPhaseCallback(long j10, int i10, int i11, Object obj);

    public static final native boolean nativeSwitchLoRA(long j10, String str);

    public static final native boolean nativeTTSGenerate(long j10, String str, String str2, String str3, Object obj);

    public static final native int[] nativeTTSGetAudioInfo(long j10);

    public static final native long nativeTTSInit(String str, String str2, boolean z);

    public static final native void nativeTTSRelease(long j10);

    public static final native boolean nativeVLMCancel(long j10);

    public static final native long nativeVLMInit(String str, String str2);

    public static final native void nativeVLMRelease(long j10);

    public static final native boolean nativeVLMStream(long j10, String str, String str2, byte[][] bArr, String[] strArr, int i10, int i11, float f8, int i12, float f9, Object obj);

    private final void refreshDspConcurrency() {
        Object objA;
        Context context;
        try {
            context = l7.a.f10344a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (context == null) {
            throw new IllegalStateException("ContextHolder must be initialized before use!");
        }
        int iA0 = dc.h.a0(PerformanceOrchestratorImpl.Companion.getInstance(context).cachedVerdict().getDspMaxConcurrent(), 1, 2);
        for (Map.Entry<ComputeBucket, ResizableSemaphore> entry : buckets.entrySet()) {
            ComputeBucket key = entry.getKey();
            ResizableSemaphore value = entry.getValue();
            if (iA0 != value.getMaxPermits()) {
                value.setMax(iA0);
                Log.i(TAG, "dspMaxConcurrent applied: bucket=" + key + " permits=" + iA0);
            }
        }
        objA = lb.n.f10413a;
        Throwable thB = Result.b(objA);
        if (thB != null) {
            a0.a.v("refreshDspConcurrency skipped: ", thB.getMessage(), TAG);
        }
    }

    public static final void setStageCallbackEnabled(boolean z) {
        stageCallbackEnabled = z;
    }

    private final void setupEnvironment(Context context) {
        try {
            String str = context.getApplicationInfo().nativeLibraryDir;
            String str2 = str + ":/vendor/lib64:/system/lib64";
            System.setProperty("java.library.path", str2);
            Log.d(TAG, "Environment setup: nativeLibDir=" + str);
            Log.d(TAG, "Environment setup: java.library.path=" + str2);
            Log.d(TAG, "Environment setup: ADSP_LIBRARY_PATH=/vendor/lib/rfsa/adsp:/vendor/dsp/cdsp:/system/lib/rfsa/adsp:/dsp (set by nativeSetEnv)");
        } catch (Exception e10) {
            a0.a.A("Failed to setup environment: ", e10.getMessage(), TAG);
        }
    }

    public static /* synthetic */ Object withInferLock$default(QnnNative qnnNative, String str, zb.l lVar, qb.b bVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return qnnNative.withInferLock(str, lVar, bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
    
        if (kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r2, null, r0, 1, null) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object acquireInferPermit(java.lang.String r7, qb.b<? super lb.n> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.backend.qnn.QnnNative.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.backend.qnn.QnnNative$acquireInferPermit$1 r0 = (com.stepos.backend.qnn.QnnNative.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.QnnNative$acquireInferPermit$1 r0 = new com.stepos.backend.qnn.QnnNative$acquireInferPermit$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$1
            com.stepos.backend.qnn.QnnNative$ResizableSemaphore r6 = (com.stepos.backend.qnn.QnnNative.ResizableSemaphore) r6
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.c.b(r8)
            goto L8f
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            java.lang.Object r6 = r0.L$1
            com.stepos.backend.qnn.QnnNative$ResizableSemaphore r6 = (com.stepos.backend.qnn.QnnNative.ResizableSemaphore) r6
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.c.b(r8)
            goto L6b
        L47:
            kotlin.c.b(r8)
            r6.refreshDspConcurrency()
            com.stepos.backend.qnn.ComputeBucket r8 = r6.bucketFor(r7)
            com.stepos.backend.qnn.QnnNative$ResizableSemaphore r6 = r6.bucketSemaphore(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
            com.stepos.backend.qnn.QnnNative$acquireInferPermit$2 r2 = new com.stepos.backend.qnn.QnnNative$acquireInferPermit$2
            r2.<init>(r7, r6, r4)
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r5
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L6b
            goto L8e
        L6b:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, kotlinx.coroutines.sync.Mutex> r8 = com.stepos.backend.qnn.QnnNative.modelLocks
            java.lang.Object r2 = r8.get(r7)
            if (r2 != 0) goto L80
            r2 = 0
            kotlinx.coroutines.sync.Mutex r2 = kotlinx.coroutines.sync.MutexKt.Mutex$default(r2, r5, r4)
            java.lang.Object r8 = r8.putIfAbsent(r7, r2)
            if (r8 != 0) goto L7f
            goto L80
        L7f:
            r2 = r8
        L80:
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r2, r4, r0, r5, r4)
            if (r8 != r1) goto L8f
        L8e:
            return r1
        L8f:
            int r6 = r6.availablePermits()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Infer permit acquired modelId="
            r8.<init>(r0)
            r8.append(r7)
            java.lang.String r7 = ", avail="
            r8.append(r7)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.String r7 = "QnnNative"
            android.util.Log.d(r7, r6)
            lb.n r6 = lb.n.f10413a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnNative.acquireInferPermit(java.lang.String, qb.b):java.lang.Object");
    }

    public final Object acquireInferPermitWithTimeout(String str, long j10, qb.b<? super Boolean> bVar) {
        refreshDspConcurrency();
        return BuildersKt.withContext(Dispatchers.getIO(), new C02572(str, j10, bucketSemaphore(bucketFor(str)), null), bVar);
    }

    public final Object acquireRawPermitWithTimeout(long j10, qb.b<? super Boolean> bVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C02582(j10, null), bVar);
    }

    public final Map<ComputeBucket, Pair<Integer, Integer>> bucketPermits() {
        ConcurrentHashMap<ComputeBucket, ResizableSemaphore> concurrentHashMap = buckets;
        LinkedHashMap linkedHashMap = new LinkedHashMap(mb.v.a0(concurrentHashMap.size()));
        Iterator<T> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            ResizableSemaphore resizableSemaphore = (ResizableSemaphore) entry.getValue();
            linkedHashMap.put(key, new Pair(Integer.valueOf(resizableSemaphore.availablePermits()), Integer.valueOf(resizableSemaphore.getMaxPermits())));
        }
        return linkedHashMap;
    }

    public final int dspPermitCapacity() {
        return bucketSemaphore(ComputeBucket.HTP).getMaxPermits();
    }

    public final Map<String, Object> getDiagnostics() {
        Pair pair = new Pair("initialized", Boolean.valueOf(isInitialized));
        Pair pair2 = new Pair("jniLoaded", Boolean.valueOf(jniLibrariesLoaded));
        b7.o.f3112a.getClass();
        String str = (String) kotlin.collections.a.v0(b7.o.f3113b);
        if (str == null) {
            str = "/data/local/tmp";
        }
        return kotlin.collections.b.g0(pair, pair2, new Pair("modelRootDir", str));
    }

    public final String getModelRootDir() {
        b7.o.f3112a.getClass();
        String str = (String) kotlin.collections.a.v0(b7.o.f3113b);
        return str == null ? "/data/local/tmp" : str;
    }

    public final synchronized void init(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        if (isInitialized) {
            Log.d(TAG, "QnnNative already initialized");
            return;
        }
        Log.i(TAG, "Initializing QnnNative...");
        String str = context.getApplicationInfo().nativeLibraryDir;
        initJniLibraries(context);
        nativeSetEnv("ADSP_LIBRARY_PATH", ADSP_LIBRARY_PATH);
        Log.i(TAG, "ADSP_LIBRARY_PATH set to: /vendor/lib/rfsa/adsp:/vendor/dsp/cdsp:/system/lib/rfsa/adsp:/dsp");
        if (new File(str).isDirectory()) {
            kotlin.jvm.internal.g.c(str);
            nativeSetEnv("LD_LIBRARY_PATH", str);
            Log.i(TAG, "LD_LIBRARY_PATH set to nativeLibraryDir: ".concat(str));
        } else {
            Log.w(TAG, "nativeLibraryDir not exist: " + str + ", skip LD_LIBRARY_PATH setenv");
        }
        setupEnvironment(context);
        Log.d(TAG, "Attempting to load QNN libraries via public library namespace (vendor)");
        loadQnnLibraries();
        isInitialized = true;
        Log.i(TAG, "✅ QnnNative initialized");
    }

    public final void initJniLibraries(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        if (jniLibrariesLoaded) {
            Log.d(TAG, "JNI libraries already loaded");
            return;
        }
        try {
            String str = context.getApplicationInfo().nativeLibraryDir;
            Log.d(TAG, "Native library directory: " + str);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            File file = new File(str, "libstep_infer.so");
            if (file.exists()) {
                System.load(file.getAbsolutePath());
                Log.i(TAG, "✅ Loaded: libstep_infer.so");
            } else {
                File file2 = new File("/system/priv-app/AIEngine/lib/arm64/libstep_infer.so");
                if (file2.exists()) {
                    System.load(file2.getAbsolutePath());
                    Log.i(TAG, "✅ Loaded from priv-app: libstep_infer.so");
                } else {
                    System.loadLibrary("step_infer");
                    Log.i(TAG, "✅ Loaded via loadLibrary: libstep_infer.so");
                }
            }
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (jElapsedRealtime2 > 2000) {
                Log.w(TAG, "so_load_slow: libstep_infer.so took " + jElapsedRealtime2 + "ms (threshold=2000ms)");
            }
            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
            File file3 = new File(str, "libaiengine.so");
            if (file3.exists()) {
                System.load(file3.getAbsolutePath());
                Log.i(TAG, "✅ Loaded: libaiengine.so");
            } else {
                File file4 = new File("/system/priv-app/AIEngine/lib/arm64/libaiengine.so");
                if (file4.exists()) {
                    System.load(file4.getAbsolutePath());
                    Log.i(TAG, "✅ Loaded from priv-app: libaiengine.so");
                } else {
                    System.loadLibrary("aiengine");
                    Log.i(TAG, "✅ Loaded via loadLibrary: libaiengine.so");
                }
            }
            long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime3;
            if (jElapsedRealtime4 > 2000) {
                Log.w(TAG, "so_load_slow: libaiengine.so took " + jElapsedRealtime4 + "ms (threshold=2000ms)");
            }
            Log.i(TAG, "JNI libraries loaded: step_infer=" + jElapsedRealtime2 + "ms aiengine=" + jElapsedRealtime4 + "ms");
            jniLibrariesLoaded = true;
        } catch (UnsatisfiedLinkError e10) {
            Log.e(TAG, "❌ Failed to load JNI library: " + e10.getMessage(), e10);
            throw e10;
        }
    }

    public final void initWithContext(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        b7.o.f3112a.getClass();
        String strJ = a0.a.j(context.getFilesDir().getAbsolutePath(), "/models");
        ArrayList arrayList = b7.o.f3113b;
        if (arrayList.isEmpty()) {
            arrayList.add(strJ);
        } else {
            arrayList.set(0, strJ);
        }
        Log.i("ModelPathResolver", "initWithContext: primary root = " + strJ);
        String str = (String) kotlin.collections.a.v0(arrayList);
        if (str == null) {
            str = "/data/local/tmp";
        }
        Log.i(TAG, "Model root dir initialized to: ".concat(str));
    }

    public final void loadQnnLibraries() {
        Log.d(TAG, "Loading QNN libraries (vendor via uses-native-library)");
        loadQnnLibraries$tryLoad("cdsprpc", false);
        loadQnnLibraries$tryLoad$default("QnnSystem", false, 2, null);
        loadQnnLibraries$tryLoad$default("QnnHtpPrepare", false, 2, null);
        loadQnnLibraries$tryLoad$default("QnnHtpV81Stub", false, 2, null);
        loadQnnLibraries$tryLoad$default("QnnHtp", false, 2, null);
        loadQnnLibraries$tryLoad$default("Genie", false, 2, null);
    }

    public final void releaseInferPermit(String modelId) {
        Object objA;
        kotlin.jvm.internal.g.f(modelId, "modelId");
        try {
            Mutex mutex = modelLocks.get(modelId);
            objA = null;
            if (mutex != null) {
                if (!mutex.isLocked()) {
                    mutex = null;
                }
                if (mutex != null) {
                    Mutex.DefaultImpls.unlock$default(mutex, null, 1, null);
                    objA = lb.n.f10413a;
                }
            }
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            a0.a.w("Failed to unlock model mutex modelId=", modelId, ": ", thB.getMessage(), TAG);
        }
        ResizableSemaphore resizableSemaphoreBucketSemaphore = bucketSemaphore(bucketFor(modelId));
        try {
            resizableSemaphoreBucketSemaphore.release();
            Log.d(TAG, "Infer permit released modelId=" + modelId + ", available=" + resizableSemaphoreBucketSemaphore.availablePermits());
        } catch (Exception e10) {
            a0.a.w("Failed to release infer permit modelId=", modelId, ": ", e10.getMessage(), TAG);
        }
    }

    public final void releaseRawPermit() {
        try {
            bucketSemaphore(ComputeBucket.HTP).release();
        } catch (Exception e10) {
            a0.a.A("Failed to release raw permit: ", e10.getMessage(), TAG);
        }
    }

    public final int semaphoreAvailable() {
        return bucketSemaphore(ComputeBucket.HTP).availablePermits();
    }

    public final void setModelRootDir(String dir) {
        kotlin.jvm.internal.g.f(dir, "dir");
        b7.o.f3112a.getClass();
        String strO0 = gc.q.O0(dir, '/');
        ArrayList arrayList = b7.o.f3113b;
        if (arrayList.isEmpty()) {
            arrayList.add(strO0);
        } else {
            arrayList.set(0, strO0);
        }
        Log.i("ModelPathResolver", "setModelRootDir: " + strO0);
        Log.i(TAG, "Model root dir set to: ".concat(dir));
    }

    public final void setupLLMEnvironment(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        setupEnvironment(context);
    }

    public final void setupVLMEnvironment(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        setupEnvironment(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object withInferLock(java.lang.String r6, zb.l<? super qb.b<? super T>, ? extends java.lang.Object> r7, qb.b<? super T> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r6 = r8 instanceof com.stepos.backend.qnn.QnnNative.C02591
            if (r6 == 0) goto L13
            r6 = r8
            com.stepos.backend.qnn.QnnNative$withInferLock$1 r6 = (com.stepos.backend.qnn.QnnNative.C02591) r6
            int r0 = r6.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r6.label = r0
            goto L18
        L13:
            com.stepos.backend.qnn.QnnNative$withInferLock$1 r6 = new com.stepos.backend.qnn.QnnNative$withInferLock$1
            r6.<init>(r8)
        L18:
            java.lang.Object r5 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r0 = r6.label
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L47
            if (r0 == r2) goto L39
            if (r0 != r1) goto L31
            java.lang.Object r6 = r6.L$0
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            kotlin.c.b(r5)     // Catch: java.lang.Throwable -> L2f
            goto L69
        L2f:
            r5 = move-exception
            goto L71
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            java.lang.Object r7 = r6.L$1
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r0 = r6.L$0
            zb.l r0 = (zb.l) r0
            kotlin.c.b(r5)
            r5 = r7
            r7 = r0
            goto L59
        L47:
            kotlin.c.b(r5)
            kotlinx.coroutines.sync.Mutex r5 = com.stepos.backend.qnn.QnnNative.inferLock
            r6.L$0 = r7
            r6.L$1 = r5
            r6.label = r2
            java.lang.Object r0 = r5.lock(r3, r6)
            if (r0 != r8) goto L59
            goto L65
        L59:
            r6.L$0 = r5     // Catch: java.lang.Throwable -> L6d
            r6.L$1 = r3     // Catch: java.lang.Throwable -> L6d
            r6.label = r1     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r6 = r7.invoke(r6)     // Catch: java.lang.Throwable -> L6d
            if (r6 != r8) goto L66
        L65:
            return r8
        L66:
            r4 = r6
            r6 = r5
            r5 = r4
        L69:
            r6.unlock(r3)
            return r5
        L6d:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L71:
            r6.unlock(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.QnnNative.withInferLock(java.lang.String, zb.l, qb.b):java.lang.Object");
    }

    public static /* synthetic */ void getStageCallbackEnabled$annotations() {
    }
}
