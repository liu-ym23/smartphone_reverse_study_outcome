package com.stepos.common.utils.filestorage.internal;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$reporter$1", f = "UploadCoordinator.kt", l = {71, 72}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class UploadCoordinator$uploadBatch$4$reporter$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f6715a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicLong f6716b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f6717c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f6718d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f6719e;
    public final /* synthetic */ p<Integer, qb.b<? super n>, Object> h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadCoordinator$uploadBatch$4$reporter$1(AtomicLong atomicLong, long j10, AtomicInteger atomicInteger, CoroutineScope coroutineScope, p<? super Integer, ? super qb.b<? super n>, ? extends Object> pVar, qb.b<? super UploadCoordinator$uploadBatch$4$reporter$1> bVar) {
        super(2, bVar);
        this.f6716b = atomicLong;
        this.f6717c = j10;
        this.f6718d = atomicInteger;
        this.f6719e = coroutineScope;
        this.h = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new UploadCoordinator$uploadBatch$4$reporter$1(this.f6716b, this.f6717c, this.f6718d, this.f6719e, this.h, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((UploadCoordinator$uploadBatch$4$reporter$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(80, r9) != r0) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033 A[Catch: CancellationException -> 0x0040, PHI: r9
      0x0033: PHI (r9v0 com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$reporter$1) = 
      (r9v1 com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$reporter$1)
      (r9v3 com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$reporter$1)
     binds: [B:14:0x0030, B:11:0x001c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0040, blocks: (B:6:0x000c, B:13:0x0021, B:16:0x0033, B:10:0x0019), top: B:22:0x0006 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003b -> B:19:0x003e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r10.f6715a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L19
            if (r1 != r2) goto L11
            kotlin.c.b(r11)     // Catch: java.util.concurrent.CancellationException -> L40
            r9 = r10
            goto L3e
        L11:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L19:
            kotlin.c.b(r11)     // Catch: java.util.concurrent.CancellationException -> L40
            r9 = r10
            goto L33
        L1e:
            kotlin.c.b(r11)
        L21:
            java.util.concurrent.atomic.AtomicLong r4 = r10.f6716b     // Catch: java.util.concurrent.CancellationException -> L40
            long r5 = r10.f6717c     // Catch: java.util.concurrent.CancellationException -> L40
            java.util.concurrent.atomic.AtomicInteger r7 = r10.f6718d     // Catch: java.util.concurrent.CancellationException -> L40
            zb.p<java.lang.Integer, qb.b<? super lb.n>, java.lang.Object> r8 = r10.h     // Catch: java.util.concurrent.CancellationException -> L40
            r10.f6715a = r3     // Catch: java.util.concurrent.CancellationException -> L40
            r9 = r10
            java.lang.Object r10 = com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4.b(r4, r5, r7, r8, r9)     // Catch: java.util.concurrent.CancellationException -> L40
            if (r10 != r0) goto L33
            goto L3d
        L33:
            r9.f6715a = r2     // Catch: java.util.concurrent.CancellationException -> L40
            r10 = 80
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r10, r9)     // Catch: java.util.concurrent.CancellationException -> L40
            if (r10 != r0) goto L3e
        L3d:
            return r0
        L3e:
            r10 = r9
            goto L21
        L40:
            lb.n r10 = lb.n.f10413a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$reporter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
