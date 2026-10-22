package com.stepos.common.utils.filestorage.internal;

import P6.UploadRequest;
import P6.UploadResult;
import Ua.M;
import Y8.t;
import android.content.Context;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.r;
import p9.s;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "LP6/m;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4", f = "UploadCoordinator.kt", l = {46, 126, 131, 133}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class UploadCoordinator$uploadBatch$4 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends UploadResult>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<UploadRequest> $items;
    final /* synthetic */ s<Integer, UploadResult, Integer, Integer, InterfaceC4014c<? super t>, Object> $onFileFinished;
    final /* synthetic */ r<Integer, String, Integer, InterfaceC4014c<? super t>, Object> $onFileProgress;
    final /* synthetic */ p<Integer, InterfaceC4014c<? super t>, Object> $onTotalProgress;
    int I$0;
    int I$1;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ UploadCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadCoordinator$uploadBatch$4(List<UploadRequest> list, UploadCoordinator uploadCoordinator, Context context, p<? super Integer, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, r<? super Integer, ? super String, ? super Integer, ? super InterfaceC4014c<? super t>, ? extends Object> rVar, s<? super Integer, ? super UploadResult, ? super Integer, ? super Integer, ? super InterfaceC4014c<? super t>, ? extends Object> sVar, InterfaceC4014c<? super UploadCoordinator$uploadBatch$4> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$items = list;
        this.this$0 = uploadCoordinator;
        this.$context = context;
        this.$onTotalProgress = pVar;
        this.$onFileProgress = rVar;
        this.$onFileFinished = sVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(java.util.concurrent.atomic.AtomicLong r7, long r8, java.util.concurrent.atomic.AtomicInteger r10, Ua.M r11, p9.p<? super java.lang.Integer, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r12, e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            boolean r11 = r13 instanceof com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReport$1
            if (r11 == 0) goto L13
            r11 = r13
            com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReport$1 r11 = (com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReport$1) r11
            int r0 = r11.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r11.label = r0
            goto L18
        L13:
            com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReport$1 r11 = new com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReport$1
            r11.<init>(r13)
        L18:
            java.lang.Object r13 = r11.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r11.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L69
            goto L63
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            kotlin.C4849c.b(r13)
            long r3 = r7.get()
            long r3 = v9.C5685n.k(r3, r8)
            r5 = 100
            long r3 = r3 * r5
            long r3 = r3 / r8
            int r7 = (int) r3
            r8 = 0
            r9 = 100
            int r7 = v9.C5685n.n(r7, r8, r9)
            int r8 = r10.get()
            if (r7 <= r8) goto L73
            boolean r8 = r10.compareAndSet(r8, r7)
            if (r8 == 0) goto L73
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L69
            java.lang.Integer r7 = g9.C4109a.f(r7)     // Catch: java.lang.Throwable -> L69
            r11.label = r2     // Catch: java.lang.Throwable -> L69
            java.lang.Object r7 = r12.invoke(r7, r11)     // Catch: java.lang.Throwable -> L69
            if (r7 != r0) goto L63
            return r0
        L63:
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L69
            kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L69
            goto L73
        L69:
            r7 = move-exception
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            kotlin.Result.b(r7)
        L73:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4.i(java.util.concurrent.atomic.AtomicLong, long, java.util.concurrent.atomic.AtomicInteger, Ua.M, p9.p, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object n(com.stepos.common.utils.filestorage.internal.a[] r3, java.util.concurrent.atomic.AtomicIntegerArray r4, Ua.M r5, p9.r<? super java.lang.Integer, ? super java.lang.String, ? super java.lang.Integer, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r6, java.util.List<P6.UploadRequest> r7, int r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            boolean r5 = r9 instanceof com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReportFile$1
            if (r5 == 0) goto L13
            r5 = r9
            com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReportFile$1 r5 = (com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReportFile$1) r5
            int r0 = r5.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r5.label = r0
            goto L18
        L13:
            com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReportFile$1 r5 = new com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$maybeReportFile$1
            r5.<init>(r9)
        L18:
            java.lang.Object r9 = r5.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L69
            goto L63
        L29:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L31:
            kotlin.C4849c.b(r9)
            r3 = r3[r8]
            int r3 = r3.a()
            int r9 = r4.get(r8)
            if (r3 <= r9) goto L73
            boolean r4 = r4.compareAndSet(r8, r9, r3)
            if (r4 == 0) goto L73
            kotlin.Result$a r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L69
            java.lang.Integer r4 = g9.C4109a.f(r8)     // Catch: java.lang.Throwable -> L69
            java.lang.Object r7 = r7.get(r8)     // Catch: java.lang.Throwable -> L69
            P6.l r7 = (P6.UploadRequest) r7     // Catch: java.lang.Throwable -> L69
            java.lang.String r7 = r7.getUriOrPath()     // Catch: java.lang.Throwable -> L69
            java.lang.Integer r3 = g9.C4109a.f(r3)     // Catch: java.lang.Throwable -> L69
            r5.label = r2     // Catch: java.lang.Throwable -> L69
            java.lang.Object r3 = r6.invoke(r4, r7, r3, r5)     // Catch: java.lang.Throwable -> L69
            if (r3 != r0) goto L63
            return r0
        L63:
            Y8.t r3 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L69
            kotlin.Result.b(r3)     // Catch: java.lang.Throwable -> L69
            goto L73
        L69:
            r3 = move-exception
            kotlin.Result$a r4 = kotlin.Result.INSTANCE
            java.lang.Object r3 = kotlin.C4849c.a(r3)
            kotlin.Result.b(r3)
        L73:
            Y8.t r3 = Y8.t.f7040a
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4.n(com.stepos.common.utils.filestorage.internal.a[], java.util.concurrent.atomic.AtomicIntegerArray, Ua.M, p9.r, java.util.List, int, e9.c):java.lang.Object");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        UploadCoordinator$uploadBatch$4 uploadCoordinator$uploadBatch$4 = new UploadCoordinator$uploadBatch$4(this.$items, this.this$0, this.$context, this.$onTotalProgress, this.$onFileProgress, this.$onFileFinished, interfaceC4014c);
        uploadCoordinator$uploadBatch$4.L$0 = obj;
        return uploadCoordinator$uploadBatch$4;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<UploadResult>> interfaceC4014c) {
        return ((UploadCoordinator$uploadBatch$4) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02f2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0292 -> B:56:0x0296). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 831
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends UploadResult>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<UploadResult>>) interfaceC4014c);
    }
}
