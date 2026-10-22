package com.stepos.common.utils.filestorage.internal;

import android.content.Context;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.io.Serializable;
import java.util.List;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import lb.n;
import o8.h;
import o8.i;
import rb.c;
import zb.p;
import zb.r;
import zb.s;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4", f = "UploadCoordinator.kt", l = {ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR, 126, 131, 133}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class UploadCoordinator$uploadBatch$4 extends SuspendLambda implements p<CoroutineScope, qb.b<? super List<? extends i>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f6691a;

    /* renamed from: b, reason: collision with root package name */
    public Serializable f6692b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6693c;

    /* renamed from: d, reason: collision with root package name */
    public Job f6694d;

    /* renamed from: e, reason: collision with root package name */
    public int f6695e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public long f6696j;

    /* renamed from: k, reason: collision with root package name */
    public int f6697k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f6698l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ List<h> f6699m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ UploadCoordinator f6700n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Context f6701o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ p<Integer, qb.b<? super n>, Object> f6702p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ r<Integer, String, Integer, qb.b<? super n>, Object> f6703q;
    public final /* synthetic */ s<Integer, i, Integer, Integer, qb.b<? super n>, Object> r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadCoordinator$uploadBatch$4(List<h> list, UploadCoordinator uploadCoordinator, Context context, p<? super Integer, ? super qb.b<? super n>, ? extends Object> pVar, r<? super Integer, ? super String, ? super Integer, ? super qb.b<? super n>, ? extends Object> rVar, s<? super Integer, ? super i, ? super Integer, ? super Integer, ? super qb.b<? super n>, ? extends Object> sVar, qb.b<? super UploadCoordinator$uploadBatch$4> bVar) {
        super(2, bVar);
        this.f6699m = list;
        this.f6700n = uploadCoordinator;
        this.f6701o = context;
        this.f6702p = pVar;
        this.f6703q = rVar;
        this.r = sVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.util.concurrent.atomic.AtomicLong r8, long r9, java.util.concurrent.atomic.AtomicInteger r11, zb.p r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            boolean r0 = r13 instanceof com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReport$1
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReport$1 r0 = (com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReport$1) r0
            int r1 = r0.f6712b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6712b = r1
            goto L18
        L13:
            com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReport$1 r0 = new com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReport$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f6711a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f6712b
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r13)     // Catch: java.lang.Throwable -> L64
            goto L61
        L27:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2f:
            kotlin.c.b(r13)
            long r4 = r8.get()
            int r8 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r8 <= 0) goto L3b
            r4 = r9
        L3b:
            r6 = 100
            long r4 = r4 * r6
            long r4 = r4 / r9
            int r8 = (int) r4
            r9 = 0
            r10 = 100
            int r8 = dc.h.a0(r8, r9, r10)
            int r9 = r11.get()
            if (r8 <= r9) goto L68
            boolean r9 = r11.compareAndSet(r9, r8)
            if (r9 == 0) goto L68
            java.lang.Integer r9 = new java.lang.Integer     // Catch: java.lang.Throwable -> L64
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L64
            r0.f6712b = r3     // Catch: java.lang.Throwable -> L64
            java.lang.Object r8 = r12.invoke(r9, r0)     // Catch: java.lang.Throwable -> L64
            if (r8 != r1) goto L61
            return r1
        L61:
            lb.n r8 = lb.n.f10413a     // Catch: java.lang.Throwable -> L64
            goto L68
        L64:
            r8 = move-exception
            kotlin.c.a(r8)
        L68:
            lb.n r8 = lb.n.f10413a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4.b(java.util.concurrent.atomic.AtomicLong, long, java.util.concurrent.atomic.AtomicInteger, zb.p, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(n8.a[] r10, java.util.concurrent.atomic.AtomicIntegerArray r11, zb.r r12, java.util.List r13, int r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            boolean r0 = r15 instanceof com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReportFile$1
            if (r0 == 0) goto L13
            r0 = r15
            com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReportFile$1 r0 = (com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReportFile$1) r0
            int r1 = r0.f6714b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6714b = r1
            goto L18
        L13:
            com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReportFile$1 r0 = new com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReportFile$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.f6713a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.f6714b
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.c.b(r15)     // Catch: java.lang.Throwable -> L75
            goto L72
        L27:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L2f:
            kotlin.c.b(r15)
            r10 = r10[r14]
            long r4 = r10.f10647b
            r6 = 1
            int r15 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r15 >= 0) goto L3d
            r4 = r6
        L3d:
            long r6 = r10.f10649d
            r8 = 100
            long r6 = r6 * r8
            long r6 = r6 / r4
            int r10 = (int) r6
            r15 = 0
            r2 = 100
            int r10 = dc.h.a0(r10, r15, r2)
            int r15 = r11.get(r14)
            if (r10 <= r15) goto L79
            boolean r11 = r11.compareAndSet(r14, r15, r10)
            if (r11 == 0) goto L79
            java.lang.Integer r11 = new java.lang.Integer     // Catch: java.lang.Throwable -> L75
            r11.<init>(r14)     // Catch: java.lang.Throwable -> L75
            java.lang.Object r13 = r13.get(r14)     // Catch: java.lang.Throwable -> L75
            o8.h r13 = (o8.h) r13     // Catch: java.lang.Throwable -> L75
            java.lang.String r13 = r13.f10822a     // Catch: java.lang.Throwable -> L75
            java.lang.Integer r14 = new java.lang.Integer     // Catch: java.lang.Throwable -> L75
            r14.<init>(r10)     // Catch: java.lang.Throwable -> L75
            r0.f6714b = r3     // Catch: java.lang.Throwable -> L75
            java.lang.Object r10 = r12.a(r11, r13, r14, r0)     // Catch: java.lang.Throwable -> L75
            if (r10 != r1) goto L72
            return r1
        L72:
            lb.n r10 = lb.n.f10413a     // Catch: java.lang.Throwable -> L75
            goto L79
        L75:
            r10 = move-exception
            kotlin.c.a(r10)
        L79:
            lb.n r10 = lb.n.f10413a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4.c(n8.a[], java.util.concurrent.atomic.AtomicIntegerArray, zb.r, java.util.List, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        UploadCoordinator$uploadBatch$4 uploadCoordinator$uploadBatch$4 = new UploadCoordinator$uploadBatch$4(this.f6699m, this.f6700n, this.f6701o, this.f6702p, this.f6703q, this.r, bVar);
        uploadCoordinator$uploadBatch$4.f6698l = obj;
        return uploadCoordinator$uploadBatch$4;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super List<? extends i>> bVar) {
        return ((UploadCoordinator$uploadBatch$4) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0311  */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.io.Serializable, java.lang.Object, kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v4, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x02ae -> B:66:0x02b7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
