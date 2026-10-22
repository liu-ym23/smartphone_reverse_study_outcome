package com.stepos.core.ability.speech;

import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadGate {
    private final Context context;
    private final int frameSize;
    private final Mutex inferLock;
    private volatile boolean initialized;
    private final int minSpeechFrames;
    private volatile b7.a model;
    private final String tag;
    private final int targetSampleRate;
    private volatile boolean unavailable;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadGate", f = "VadGate.kt", l = {194, 181}, m = "close")
    /* renamed from: com.stepos.core.ability.speech.VadGate$close$1, reason: invalid class name */
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
            return VadGate.this.close(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadGate", f = "VadGate.kt", l = {194, 97}, m = "ensureInitialized")
    /* renamed from: com.stepos.core.ability.speech.VadGate$ensureInitialized$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03591(qb.b<? super C03591> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VadGate.this.ensureInitialized(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadGate", f = "VadGate.kt", l = {194, 135}, m = "hasSpeech")
    /* renamed from: com.stepos.core.ability.speech.VadGate$hasSpeech$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03601 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C03601(qb.b<? super C03601> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VadGate.this.hasSpeech(null, 0, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.speech.VadGate", f = "VadGate.kt", l = {165}, m = "inferFrameLocked")
    /* renamed from: com.stepos.core.ability.speech.VadGate$inferFrameLocked$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03611 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C03611(qb.b<? super C03611> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VadGate.this.inferFrameLocked(null, null, this);
        }
    }

    public VadGate(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        this.context = context;
        this.tag = "VadGate";
        this.frameSize = 256;
        this.targetSampleRate = 16000;
        this.minSpeechFrames = 2;
        this.inferLock = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object inferFrameLocked(b7.a r5, short[] r6, qb.b<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.core.ability.speech.VadGate.C03611
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.core.ability.speech.VadGate$inferFrameLocked$1 r0 = (com.stepos.core.ability.speech.VadGate.C03611) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.speech.VadGate$inferFrameLocked$1 r0 = new com.stepos.core.ability.speech.VadGate$inferFrameLocked$1
            r0.<init>(r7)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 != r3) goto L2c
            kotlin.c.b(r4)
            kotlin.Result r4 = (kotlin.Result) r4
            java.lang.Object r4 = r4.f9987a
            goto L40
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.c.b(r4)
            r0.label = r3
            java.lang.Object r4 = r5.mo10infer0E7RQCE(r6, r2, r0)
            if (r4 != r7) goto L40
            return r7
        L40:
            boolean r5 = r4 instanceof kotlin.Result.Failure
            if (r5 == 0) goto L45
            r4 = r2
        L45:
            if (r4 != 0) goto L4a
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L4a:
            boolean r5 = r4 instanceof kotlin.Pair
            r6 = 0
            if (r5 == 0) goto L61
            kotlin.Pair r4 = (kotlin.Pair) r4
            B r4 = r4.f9986b
            boolean r5 = r4 instanceof java.lang.Boolean
            if (r5 == 0) goto L5a
            r2 = r4
            java.lang.Boolean r2 = (java.lang.Boolean) r2
        L5a:
            if (r2 == 0) goto L6b
            boolean r6 = r2.booleanValue()
            goto L6b
        L61:
            boolean r5 = r4 instanceof java.lang.Boolean
            if (r5 == 0) goto L6b
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r6 = r4.booleanValue()
        L6b:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadGate.inferFrameLocked(b7.a, short[], qb.b):java.lang.Object");
    }

    private final void resetModelStateLocked(b7.a aVar) {
        Object objA;
        try {
            objA = aVar.getClass().getMethod("reset", null).invoke(aVar, null);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (Result.b(objA) != null) {
            AIEngineLogger.d(LogModule.ABILITY, this.tag, "reset() not available on ".concat(aVar.getClass().getSimpleName()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0096 A[Catch: all -> 0x00ae, TryCatch #3 {all -> 0x00ae, blocks: (B:35:0x0090, B:37:0x0096, B:42:0x00b5, B:23:0x0063), top: B:53:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object close(qb.b<? super lb.n> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 193
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadGate.close(qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object ensureInitialized(qb.b<? super lb.n> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadGate.ensureInitialized(qb.b):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(13:12|69|13|47|(1:52)(2:49|(4:51|59|60|61))|53|54|42|(1:44)|58|59|60|61)(2:17|18))(1:19))(2:20|(2:22|23)(2:24|(2:26|27)(2:28|(2:30|31)(2:32|(2:34|35)(3:36|(1:39)|46)))))|67|40|41|42|(0)|58|59|60|61|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
    
        if (r3 == r5) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fa, code lost:
    
        r13 = r6;
        r6 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cc A[Catch: all -> 0x004d, TryCatch #2 {all -> 0x004d, blocks: (B:13:0x0048, B:47:0x00e6, B:49:0x00ee, B:53:0x00f5, B:42:0x00c5, B:44:0x00cc), top: B:69:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e3 -> B:47:0x00e6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object hasSpeech(short[] r17, int r18, qb.b<? super java.lang.Boolean> r19) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.VadGate.hasSpeech(short[], int, qb.b):java.lang.Object");
    }

    public final boolean isAvailable() {
        return this.initialized && !this.unavailable;
    }
}
