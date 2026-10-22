package com.stepos.common.utils.filestorage.internal;

import P6.UploadRequest;
import P6.UploadResult;
import Ua.M;
import Y8.t;
import android.content.Context;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.s;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LP6/m;", "<anonymous>", "(LUa/M;)LP6/m;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$results$1$1", f = "UploadCoordinator.kt", l = {116, 118, 120}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class UploadCoordinator$uploadBatch$4$results$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super UploadResult>, Object> {
    final /* synthetic */ AtomicInteger $completed;
    final /* synthetic */ Context $context;
    final /* synthetic */ a[] $fileTrackers;
    final /* synthetic */ int $idx;
    final /* synthetic */ s<Integer, UploadResult, Integer, Integer, InterfaceC4014c<? super t>, Object> $onFileFinished;
    final /* synthetic */ UploadRequest $req;
    final /* synthetic */ List<Long> $resolvedSizes;
    final /* synthetic */ eb.g $semaphore;
    final /* synthetic */ int $total;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UploadCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadCoordinator$uploadBatch$4$results$1$1(eb.g gVar, UploadCoordinator uploadCoordinator, Context context, UploadRequest uploadRequest, List<Long> list, int i10, a[] aVarArr, AtomicInteger atomicInteger, s<? super Integer, ? super UploadResult, ? super Integer, ? super Integer, ? super InterfaceC4014c<? super t>, ? extends Object> sVar, int i11, InterfaceC4014c<? super UploadCoordinator$uploadBatch$4$results$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$semaphore = gVar;
        this.this$0 = uploadCoordinator;
        this.$context = context;
        this.$req = uploadRequest;
        this.$resolvedSizes = list;
        this.$idx = i10;
        this.$fileTrackers = aVarArr;
        this.$completed = atomicInteger;
        this.$onFileFinished = sVar;
        this.$total = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        UploadCoordinator$uploadBatch$4$results$1$1 uploadCoordinator$uploadBatch$4$results$1$1 = new UploadCoordinator$uploadBatch$4$results$1$1(this.$semaphore, this.this$0, this.$context, this.$req, this.$resolvedSizes, this.$idx, this.$fileTrackers, this.$completed, this.$onFileFinished, this.$total, interfaceC4014c);
        uploadCoordinator$uploadBatch$4$results$1$1.L$0 = obj;
        return uploadCoordinator$uploadBatch$4$results$1$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super UploadResult> interfaceC4014c) {
        return ((UploadCoordinator$uploadBatch$4$results$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:0|2|(6:(1:(1:(1:(8:7|61|8|9|55|34|41|42)(2:12|13))(10:14|53|15|16|59|29|57|30|(5:33|55|34|41|42)|32))(1:19))(3:20|(0)|32)|63|25|26|(5:59|29|57|30|(0))|32)|51|23|24|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c2, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c3, code lost:
    
        r8 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.UploadCoordinator$uploadBatch$4$results$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
