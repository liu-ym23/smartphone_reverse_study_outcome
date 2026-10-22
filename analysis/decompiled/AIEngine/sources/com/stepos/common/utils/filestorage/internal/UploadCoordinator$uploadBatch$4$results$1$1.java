package com.stepos.common.utils.filestorage.internal;

import android.content.Context;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;
import lb.n;
import o8.h;
import o8.i;
import rb.c;
import zb.p;
import zb.s;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$results$1$1", f = "UploadCoordinator.kt", l = {116, 118, 120}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class UploadCoordinator$uploadBatch$4$results$1$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super i>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f6724a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6725b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Semaphore f6726c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UploadCoordinator f6727d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f6728e;
    public final /* synthetic */ h h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ List<Long> f6729j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f6730k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ n8.a[] f6731l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f6732m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ s<Integer, i, Integer, Integer, qb.b<? super n>, Object> f6733n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f6734o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadCoordinator$uploadBatch$4$results$1$1(Semaphore semaphore, UploadCoordinator uploadCoordinator, Context context, h hVar, List<Long> list, int i10, n8.a[] aVarArr, AtomicInteger atomicInteger, s<? super Integer, ? super i, ? super Integer, ? super Integer, ? super qb.b<? super n>, ? extends Object> sVar, int i11, qb.b<? super UploadCoordinator$uploadBatch$4$results$1$1> bVar) {
        super(2, bVar);
        this.f6726c = semaphore;
        this.f6727d = uploadCoordinator;
        this.f6728e = context;
        this.h = hVar;
        this.f6729j = list;
        this.f6730k = i10;
        this.f6731l = aVarArr;
        this.f6732m = atomicInteger;
        this.f6733n = sVar;
        this.f6734o = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        UploadCoordinator$uploadBatch$4$results$1$1 uploadCoordinator$uploadBatch$4$results$1$1 = new UploadCoordinator$uploadBatch$4$results$1$1(this.f6726c, this.f6727d, this.f6728e, this.h, this.f6729j, this.f6730k, this.f6731l, this.f6732m, this.f6733n, this.f6734o, bVar);
        uploadCoordinator$uploadBatch$4$results$1$1.f6725b = obj;
        return uploadCoordinator$uploadBatch$4$results$1$1;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super i> bVar) {
        return ((UploadCoordinator$uploadBatch$4$results$1$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r13.f6724a
            r2 = 3
            r3 = 2
            r4 = 1
            int r5 = r13.f6730k
            kotlinx.coroutines.sync.Semaphore r6 = r13.f6726c
            if (r1 == 0) goto L3d
            if (r1 == r4) goto L35
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            java.lang.Object r13 = r13.f6725b
            o8.i r13 = (o8.i) r13
            kotlin.c.b(r14)     // Catch: java.lang.Throwable -> L1c
            goto L97
        L1c:
            r0 = move-exception
            r14 = r0
            goto La2
        L20:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L28:
            java.lang.Object r1 = r13.f6725b
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.c.b(r14)     // Catch: java.lang.Throwable -> L31
            r12 = r13
            goto L6f
        L31:
            r0 = move-exception
            r13 = r0
            goto La9
        L35:
            java.lang.Object r1 = r13.f6725b
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.c.b(r14)
            goto L50
        L3d:
            kotlin.c.b(r14)
            java.lang.Object r14 = r13.f6725b
            r1 = r14
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            r13.f6725b = r1
            r13.f6724a = r4
            java.lang.Object r14 = r6.acquire(r13)
            if (r14 != r0) goto L50
            goto L95
        L50:
            com.stepos.common.utils.filestorage.internal.UploadCoordinator r7 = r13.f6727d     // Catch: java.lang.Throwable -> L31
            android.content.Context r8 = r13.f6728e     // Catch: java.lang.Throwable -> L31
            o8.h r9 = r13.h     // Catch: java.lang.Throwable -> L31
            java.util.List<java.lang.Long> r14 = r13.f6729j     // Catch: java.lang.Throwable -> L31
            java.lang.Object r14 = r14.get(r5)     // Catch: java.lang.Throwable -> L31
            r10 = r14
            java.lang.Long r10 = (java.lang.Long) r10     // Catch: java.lang.Throwable -> L31
            n8.a[] r14 = r13.f6731l     // Catch: java.lang.Throwable -> L31
            r11 = r14[r5]     // Catch: java.lang.Throwable -> L31
            r13.f6725b = r1     // Catch: java.lang.Throwable -> L31
            r13.f6724a = r3     // Catch: java.lang.Throwable -> L31
            r12 = r13
            java.lang.Object r14 = com.stepos.common.utils.filestorage.internal.UploadCoordinator.a(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L31
            if (r14 != r0) goto L6f
            goto L95
        L6f:
            r9 = r14
            o8.i r9 = (o8.i) r9     // Catch: java.lang.Throwable -> L31
            java.util.concurrent.atomic.AtomicInteger r13 = r12.f6732m     // Catch: java.lang.Throwable -> L31
            int r13 = r13.incrementAndGet()     // Catch: java.lang.Throwable -> L31
            zb.s<java.lang.Integer, o8.i, java.lang.Integer, java.lang.Integer, qb.b<? super lb.n>, java.lang.Object> r7 = r12.f6733n     // Catch: java.lang.Throwable -> L31
            int r14 = r12.f6734o     // Catch: java.lang.Throwable -> L31
            java.lang.Integer r8 = new java.lang.Integer     // Catch: java.lang.Throwable -> L9e
            r8.<init>(r5)     // Catch: java.lang.Throwable -> L9e
            java.lang.Integer r10 = new java.lang.Integer     // Catch: java.lang.Throwable -> L9e
            r10.<init>(r13)     // Catch: java.lang.Throwable -> L9e
            java.lang.Integer r11 = new java.lang.Integer     // Catch: java.lang.Throwable -> L9e
            r11.<init>(r14)     // Catch: java.lang.Throwable -> L9e
            r12.f6725b = r9     // Catch: java.lang.Throwable -> L9a
            r12.f6724a = r2     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r13 = r7.d(r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L9a
            if (r13 != r0) goto L96
        L95:
            return r0
        L96:
            r13 = r9
        L97:
            lb.n r14 = lb.n.f10413a     // Catch: java.lang.Throwable -> L1c
            goto La5
        L9a:
            r0 = move-exception
            r14 = r0
        L9c:
            r13 = r9
            goto La2
        L9e:
            r0 = move-exception
            r13 = r0
            r14 = r13
            goto L9c
        La2:
            kotlin.c.a(r14)     // Catch: java.lang.Throwable -> L31
        La5:
            r6.release()
            return r13
        La9:
            r6.release()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$results$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
