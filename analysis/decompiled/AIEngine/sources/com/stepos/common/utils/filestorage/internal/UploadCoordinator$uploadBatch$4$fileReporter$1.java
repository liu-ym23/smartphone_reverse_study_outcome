package com.stepos.common.utils.filestorage.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import o8.h;
import rb.c;
import zb.p;
import zb.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$fileReporter$1", f = "UploadCoordinator.kt", l = {99, 100}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class UploadCoordinator$uploadBatch$4$fileReporter$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f6704a;

    /* renamed from: b, reason: collision with root package name */
    public int f6705b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6706c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n8.a[] f6707d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicIntegerArray f6708e;
    public final /* synthetic */ CoroutineScope h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ r<Integer, String, Integer, qb.b<? super n>, Object> f6709j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ List<h> f6710k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadCoordinator$uploadBatch$4$fileReporter$1(int i10, n8.a[] aVarArr, AtomicIntegerArray atomicIntegerArray, CoroutineScope coroutineScope, r<? super Integer, ? super String, ? super Integer, ? super qb.b<? super n>, ? extends Object> rVar, List<h> list, qb.b<? super UploadCoordinator$uploadBatch$4$fileReporter$1> bVar) {
        super(2, bVar);
        this.f6706c = i10;
        this.f6707d = aVarArr;
        this.f6708e = atomicIntegerArray;
        this.h = coroutineScope;
        this.f6709j = rVar;
        this.f6710k = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new UploadCoordinator$uploadBatch$4$fileReporter$1(this.f6706c, this.f6707d, this.f6708e, this.h, this.f6709j, this.f6710k, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((UploadCoordinator$uploadBatch$4$fileReporter$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        r9 = r10;
        r9.f6705b = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(80, r9) != r0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029 A[Catch: CancellationException -> 0x0050, TryCatch #0 {CancellationException -> 0x0050, blocks: (B:6:0x000c, B:15:0x0025, B:17:0x0029, B:21:0x003e, B:22:0x0042, B:11:0x001b), top: B:28:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0042 A[EDGE_INSN: B:31:0x0042->B:22:0x0042 BREAK  A[LOOP:0: B:15:0x0025->B:21:0x003e], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004b -> B:25:0x004e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r10.f6705b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L19
            if (r1 != r2) goto L11
            kotlin.c.b(r11)     // Catch: java.util.concurrent.CancellationException -> L50
            r9 = r10
            goto L4e
        L11:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L19:
            int r1 = r10.f6704a
            kotlin.c.b(r11)     // Catch: java.util.concurrent.CancellationException -> L50
            r9 = r10
            goto L3e
        L20:
            kotlin.c.b(r11)
        L23:
            r11 = 0
            r8 = r11
        L25:
            int r11 = r10.f6706c     // Catch: java.util.concurrent.CancellationException -> L50
            if (r8 >= r11) goto L42
            n8.a[] r4 = r10.f6707d     // Catch: java.util.concurrent.CancellationException -> L50
            java.util.concurrent.atomic.AtomicIntegerArray r5 = r10.f6708e     // Catch: java.util.concurrent.CancellationException -> L50
            zb.r<java.lang.Integer, java.lang.String, java.lang.Integer, qb.b<? super lb.n>, java.lang.Object> r6 = r10.f6709j     // Catch: java.util.concurrent.CancellationException -> L50
            java.util.List<o8.h> r7 = r10.f6710k     // Catch: java.util.concurrent.CancellationException -> L50
            r10.f6704a = r8     // Catch: java.util.concurrent.CancellationException -> L50
            r10.f6705b = r3     // Catch: java.util.concurrent.CancellationException -> L50
            r9 = r10
            java.lang.Object r10 = com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4.c(r4, r5, r6, r7, r8, r9)     // Catch: java.util.concurrent.CancellationException -> L50
            if (r10 != r0) goto L3d
            goto L4d
        L3d:
            r1 = r8
        L3e:
            int r8 = r1 + 1
            r10 = r9
            goto L25
        L42:
            r9 = r10
            r9.f6705b = r2     // Catch: java.util.concurrent.CancellationException -> L50
            r10 = 80
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r10, r9)     // Catch: java.util.concurrent.CancellationException -> L50
            if (r10 != r0) goto L4e
        L4d:
            return r0
        L4e:
            r10 = r9
            goto L23
        L50:
            lb.n r10 = lb.n.f10413a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$fileReporter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
