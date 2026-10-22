package com.zyql.common.utils.upload;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import android.content.Context;
import com.zyql.common.utils.upload.UploadManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.zyql.common.utils.upload.UploadManager$startBatchUpload$job$1", f = "UploadManager.kt", l = {122, 125, 134}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes3.dex */
public final class UploadManager$startBatchUpload$job$1 extends SuspendLambda implements n {
    final /* synthetic */ String $bucket;
    final /* synthetic */ Context $context;
    final /* synthetic */ k $onFinished;
    final /* synthetic */ k $onTotalProgress;
    final /* synthetic */ boolean $onlyReturnSuccess;
    final /* synthetic */ List<UploadManager.UploadTask> $tasks;
    int label;

    @c(c = "com.zyql.common.utils.upload.UploadManager$startBatchUpload$job$1$1", f = "UploadManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.zyql.common.utils.upload.UploadManager$startBatchUpload$job$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ List<UploadManager.UploadResult> $finalResults;
        final /* synthetic */ k $onFinished;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar, List<UploadManager.UploadResult> list, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$onFinished = kVar;
            this.$finalResults = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$onFinished, this.$finalResults, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            this.$onFinished.invoke(this.$finalResults);
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadManager$startBatchUpload$job$1(Context context, String str, List<UploadManager.UploadTask> list, k kVar, boolean z10, k kVar2, H7.c<? super UploadManager$startBatchUpload$job$1> cVar) {
        super(2, cVar);
        this.$context = context;
        this.$bucket = str;
        this.$tasks = list;
        this.$onTotalProgress = kVar;
        this.$onlyReturnSuccess = z10;
        this.$onFinished = kVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new UploadManager$startBatchUpload$job$1(this.$context, this.$bucket, this.$tasks, this.$onTotalProgress, this.$onlyReturnSuccess, this.$onFinished, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
    
        if (m9.AbstractC1683A.w(r11, r1, r10) != r0) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r11.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L26
            if (r1 == r5) goto L22
            if (r1 == r4) goto L1d
            if (r1 != r3) goto L15
            kotlin.b.b(r12)
            goto L85
        L15:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1d:
            kotlin.b.b(r12)
            r10 = r11
            goto L48
        L22:
            kotlin.b.b(r12)
            goto L34
        L26:
            kotlin.b.b(r12)
            com.zyql.common.utils.upload.UploadManager r12 = com.zyql.common.utils.upload.UploadManager.INSTANCE
            r11.label = r5
            java.lang.Object r12 = com.zyql.common.utils.upload.UploadManager.access$checkInit(r12, r11)
            if (r12 != r0) goto L34
            goto L84
        L34:
            com.zyql.common.utils.upload.UploadManager r5 = com.zyql.common.utils.upload.UploadManager.INSTANCE
            android.content.Context r6 = r11.$context
            java.lang.String r7 = r11.$bucket
            java.util.List<com.zyql.common.utils.upload.UploadManager$UploadTask> r8 = r11.$tasks
            S7.k r9 = r11.$onTotalProgress
            r11.label = r4
            r10 = r11
            java.lang.Object r12 = com.zyql.common.utils.upload.UploadManager.access$uploadBatchInternal(r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L48
            goto L84
        L48:
            java.util.List r12 = (java.util.List) r12
            boolean r11 = r10.$onlyReturnSuccess
            if (r11 == 0) goto L71
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r12 = r12.iterator()
        L59:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L70
            java.lang.Object r1 = r12.next()
            r4 = r1
            com.zyql.common.utils.upload.UploadManager$UploadResult r4 = (com.zyql.common.utils.upload.UploadManager.UploadResult) r4
            boolean r4 = r4.getSuccess()
            if (r4 == 0) goto L59
            r11.add(r1)
            goto L59
        L70:
            r12 = r11
        L71:
            u9.d r11 = m9.AbstractC1691I.f5315a
            n9.d r11 = s9.k.f6003a
            com.zyql.common.utils.upload.UploadManager$startBatchUpload$job$1$1 r1 = new com.zyql.common.utils.upload.UploadManager$startBatchUpload$job$1$1
            S7.k r4 = r10.$onFinished
            r1.<init>(r4, r12, r2)
            r10.label = r3
            java.lang.Object r11 = m9.AbstractC1683A.w(r11, r1, r10)
            if (r11 != r0) goto L85
        L84:
            return r0
        L85:
            java.util.concurrent.atomic.AtomicReference r11 = com.zyql.common.utils.upload.UploadManager.access$getCurrentJob$p()
            r11.set(r2)
            C7.r r11 = C7.r.f317a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.common.utils.upload.UploadManager$startBatchUpload$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((UploadManager$startBatchUpload$job$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
