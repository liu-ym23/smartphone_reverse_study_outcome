package com.zyql.common.utils.upload;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import android.content.Context;
import com.zyql.common.utils.upload.UploadManager;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import w9.e;

@c(c = "com.zyql.common.utils.upload.UploadManager$uploadBatchInternal$2$1$1", f = "UploadManager.kt", l = {163, 185, 199, 208}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/zyql/common/utils/upload/UploadManager$UploadResult;", "<anonymous>", "(Lm9/z;)Lcom/zyql/common/utils/upload/UploadManager$UploadResult;"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes3.dex */
public final class UploadManager$uploadBatchInternal$2$1$1 extends SuspendLambda implements n {
    final /* synthetic */ String $bucket;
    final /* synthetic */ AtomicInteger $completed;
    final /* synthetic */ Context $context;
    final /* synthetic */ k $onTotalProgress;
    final /* synthetic */ e $semaphore;
    final /* synthetic */ UploadManager.UploadTask $task;
    final /* synthetic */ int $total;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;

    @c(c = "com.zyql.common.utils.upload.UploadManager$uploadBatchInternal$2$1$1$1", f = "UploadManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.zyql.common.utils.upload.UploadManager$uploadBatchInternal$2$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ k $onTotalProgress;
        final /* synthetic */ int $progress;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar, int i, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$onTotalProgress = kVar;
            this.$progress = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$onTotalProgress, this.$progress, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            this.$onTotalProgress.invoke(new Integer(this.$progress));
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadManager$uploadBatchInternal$2$1$1(e eVar, UploadManager.UploadTask uploadTask, Context context, String str, AtomicInteger atomicInteger, int i, k kVar, H7.c<? super UploadManager$uploadBatchInternal$2$1$1> cVar) {
        super(2, cVar);
        this.$semaphore = eVar;
        this.$task = uploadTask;
        this.$context = context;
        this.$bucket = str;
        this.$completed = atomicInteger;
        this.$total = i;
        this.$onTotalProgress = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new UploadManager$uploadBatchInternal$2$1$1(this.$semaphore, this.$task, this.$context, this.$bucket, this.$completed, this.$total, this.$onTotalProgress, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
    
        if (((kotlinx.coroutines.sync.b) r0).a(r19) == r8) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0104, code lost:
    
        if (kotlinx.coroutines.a.f(800, r19) == r8) goto L36;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0169 A[RETURN] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v2, types: [H7.c] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.zyql.common.utils.upload.UploadManager$UploadResult] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0104 -> B:32:0x0107). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.common.utils.upload.UploadManager$uploadBatchInternal$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super UploadManager.UploadResult> cVar) {
        return ((UploadManager$uploadBatchInternal$2$1$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
