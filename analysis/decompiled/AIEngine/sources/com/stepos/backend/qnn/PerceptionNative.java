package com.stepos.backend.qnn;

import ai.onnxruntime.BuildConfig;
import android.content.Context;
import android.util.Log;
import com.stepos.core.ability.speech.AsrCloudConfig;
import com.stepos.core.common.log.AiEngineAtrace;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PerceptionNative {
    private static final String TAG = "PerceptionNative";
    private static volatile boolean initialized;
    private static volatile boolean libraryLoaded;
    public static final PerceptionNative INSTANCE = new PerceptionNative();
    private static final Mutex inferMutex = MutexKt.Mutex$default(false, 1, null);
    private static final Object loadLock = new Object();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface StreamCallback {
        void onComplete();

        void onError(int i10, String str);

        void onToken(String str);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.PerceptionNative", f = "PerceptionNative.kt", l = {170}, m = "init")
    /* renamed from: com.stepos.backend.qnn.PerceptionNative$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PerceptionNative.this.init(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.PerceptionNative", f = "PerceptionNative.kt", l = {170}, m = BuildConfig.BUILD_TYPE)
    /* renamed from: com.stepos.backend.qnn.PerceptionNative$release$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02281 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02281(qb.b<? super C02281> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PerceptionNative.this.release(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.PerceptionNative", f = "PerceptionNative.kt", l = {170}, m = "reset")
    /* renamed from: com.stepos.backend.qnn.PerceptionNative$reset$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02291 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02291(qb.b<? super C02291> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PerceptionNative.this.reset(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.qnn.PerceptionNative", f = "PerceptionNative.kt", l = {170, 112}, m = AsrCloudConfig.SCENE_MODE_STREAM)
    /* renamed from: com.stepos.backend.qnn.PerceptionNative$stream$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02301 extends ContinuationImpl {
        float F$0;
        float F$1;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C02301(qb.b<? super C02301> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PerceptionNative.this.stream(null, null, null, 0, 0.0f, 0, 0.0f, null, this);
        }
    }

    private PerceptionNative() {
    }

    private static final native boolean nativeInit(String str, String str2);

    private static final native boolean nativeRelease();

    private static final native boolean nativeReset();

    /* JADX INFO: Access modifiers changed from: private */
    public static final native boolean nativeStream(String str, String str2, byte[][] bArr, int i10, float f8, int i11, float f9, StreamCallback streamCallback);

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stream$lambda$5$lambda$4(final String str, final String str2, final byte[][] bArr, final int i10, final float f8, final int i11, final float f9, final StreamCallback streamCallback) {
        return ((Boolean) AiEngineAtrace.section("qnn/call", "perception_stream", new zb.a() { // from class: com.stepos.backend.qnn.b
            @Override // zb.a
            public final Object invoke() {
                return Boolean.valueOf(PerceptionNative.nativeStream(str, str2, bArr, i10, f8, i11, f9, streamCallback));
            }
        })).booleanValue();
    }

    public final void ensureLibraryLoaded(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        if (libraryLoaded) {
            return;
        }
        synchronized (loadLock) {
            if (libraryLoaded) {
                return;
            }
            QnnNative.INSTANCE.init(context);
            try {
                System.loadLibrary("step_infer_perception");
                libraryLoaded = true;
                Log.i(TAG, "✅ libstep_infer_perception.so loaded");
            } catch (UnsatisfiedLinkError e10) {
                Log.e(TAG, "❌ Failed to load libstep_infer_perception.so: " + e10.getMessage(), e10);
                throw e10;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object init(java.lang.String r5, java.lang.String r6, qb.b<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.backend.qnn.PerceptionNative.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.backend.qnn.PerceptionNative$init$1 r0 = (com.stepos.backend.qnn.PerceptionNative.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.PerceptionNative$init$1 r0 = new com.stepos.backend.qnn.PerceptionNative$init$1
            r0.<init>(r7)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3e
            if (r1 != r2) goto L36
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.c.b(r4)
            r4 = r5
            r5 = r7
            goto L52
        L36:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3e:
            kotlin.c.b(r4)
            kotlinx.coroutines.sync.Mutex r4 = com.stepos.backend.qnn.PerceptionNative.inferMutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r4
            r0.label = r2
            java.lang.Object r0 = r4.lock(r3, r0)
            if (r0 != r7) goto L52
            return r7
        L52:
            boolean r7 = com.stepos.backend.qnn.PerceptionNative.initialized     // Catch: java.lang.Throwable -> L5e
            if (r7 == 0) goto L60
            java.lang.String r5 = "PerceptionNative"
            java.lang.String r6 = "init: already initialized, idempotent OK"
            android.util.Log.i(r5, r6)     // Catch: java.lang.Throwable -> L5e
            goto L6c
        L5e:
            r5 = move-exception
            goto L74
        L60:
            boolean r5 = nativeInit(r5, r6)     // Catch: java.lang.Throwable -> L5e
            if (r5 == 0) goto L68
            com.stepos.backend.qnn.PerceptionNative.initialized = r2     // Catch: java.lang.Throwable -> L5e
        L68:
            if (r5 == 0) goto L6b
            goto L6c
        L6b:
            r2 = 0
        L6c:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L5e
            r4.unlock(r3)
            return r5
        L74:
            r4.unlock(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.PerceptionNative.init(java.lang.String, java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object release(qb.b<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.backend.qnn.PerceptionNative.C02281
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.backend.qnn.PerceptionNative$release$1 r0 = (com.stepos.backend.qnn.PerceptionNative.C02281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.PerceptionNative$release$1 r0 = new com.stepos.backend.qnn.PerceptionNative$release$1
            r0.<init>(r5)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            kotlin.c.b(r4)
            goto L45
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.c.b(r4)
            kotlinx.coroutines.sync.Mutex r4 = com.stepos.backend.qnn.PerceptionNative.inferMutex
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r0 = r4.lock(r3, r0)
            if (r0 != r5) goto L44
            return r5
        L44:
            r5 = r4
        L45:
            boolean r4 = com.stepos.backend.qnn.PerceptionNative.initialized     // Catch: java.lang.Throwable -> L54
            if (r4 != 0) goto L4a
            goto L5a
        L4a:
            boolean r4 = nativeRelease()     // Catch: java.lang.Throwable -> L54
            r0 = 0
            if (r4 == 0) goto L56
            com.stepos.backend.qnn.PerceptionNative.initialized = r0     // Catch: java.lang.Throwable -> L54
            goto L56
        L54:
            r4 = move-exception
            goto L62
        L56:
            if (r4 == 0) goto L59
            goto L5a
        L59:
            r2 = r0
        L5a:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L54
            r5.unlock(r3)
            return r4
        L62:
            r5.unlock(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.PerceptionNative.release(qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reset(qb.b<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.backend.qnn.PerceptionNative.C02291
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.backend.qnn.PerceptionNative$reset$1 r0 = (com.stepos.backend.qnn.PerceptionNative.C02291) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.qnn.PerceptionNative$reset$1 r0 = new com.stepos.backend.qnn.PerceptionNative$reset$1
            r0.<init>(r5)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.sync.Mutex r5 = (kotlinx.coroutines.sync.Mutex) r5
            kotlin.c.b(r4)
            goto L45
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.c.b(r4)
            kotlinx.coroutines.sync.Mutex r4 = com.stepos.backend.qnn.PerceptionNative.inferMutex
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r0 = r4.lock(r3, r0)
            if (r0 != r5) goto L44
            return r5
        L44:
            r5 = r4
        L45:
            boolean r4 = com.stepos.backend.qnn.PerceptionNative.initialized     // Catch: java.lang.Throwable -> L57
            if (r4 != 0) goto L4b
            r4 = 0
            goto L4f
        L4b:
            boolean r4 = nativeReset()     // Catch: java.lang.Throwable -> L57
        L4f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L57
            r5.unlock(r3)
            return r4
        L57:
            r4 = move-exception
            r5.unlock(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.PerceptionNative.reset(qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object stream(java.lang.String r17, java.lang.String r18, byte[][] r19, int r20, float r21, int r22, float r23, com.stepos.backend.qnn.PerceptionNative.StreamCallback r24, qb.b<? super java.lang.Boolean> r25) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.qnn.PerceptionNative.stream(java.lang.String, java.lang.String, byte[][], int, float, int, float, com.stepos.backend.qnn.PerceptionNative$StreamCallback, qb.b):java.lang.Object");
    }
}
