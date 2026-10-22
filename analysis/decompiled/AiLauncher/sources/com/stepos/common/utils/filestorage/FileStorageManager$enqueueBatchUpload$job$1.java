package com.stepos.common.utils.filestorage;

import P6.UploadRequest;
import P6.UploadResult;
import Ua.M;
import Y8.t;
import android.content.Context;
import com.stepos.common.utils.filestorage.FileStorageManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;
import p9.q;
import p9.r;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1", f = "FileStorageManager.kt", l = {108, 122}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FileStorageManager$enqueueBatchUpload$job$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ FileStorageManager.Components $comp;
    final /* synthetic */ Context $context;
    final /* synthetic */ List<UploadRequest> $items;
    final /* synthetic */ r<Integer, UploadResult, Integer, Integer, t> $onFileFinished;
    final /* synthetic */ q<Integer, String, Integer, t> $onFileProgress;
    final /* synthetic */ InterfaceC5074l<List<UploadResult>, t> $onFinished;
    final /* synthetic */ InterfaceC5074l<Integer, t> $onTotalProgress;
    final /* synthetic */ boolean $onlyReturnSuccess;
    final /* synthetic */ String $taskId;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ List<UploadResult> $finalResults;
        final /* synthetic */ InterfaceC5074l<List<UploadResult>, t> $onFinished;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super List<UploadResult>, t> interfaceC5074l, List<UploadResult> list, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onFinished = interfaceC5074l;
            this.$finalResults = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$onFinished, this.$finalResults, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$onFinished.invoke(this.$finalResults);
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileStorageManager$enqueueBatchUpload$job$1(FileStorageManager.Components components, Context context, List<UploadRequest> list, boolean z10, String str, InterfaceC5074l<? super Integer, t> interfaceC5074l, q<? super Integer, ? super String, ? super Integer, t> qVar, r<? super Integer, ? super UploadResult, ? super Integer, ? super Integer, t> rVar, InterfaceC5074l<? super List<UploadResult>, t> interfaceC5074l2, InterfaceC4014c<? super FileStorageManager$enqueueBatchUpload$job$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$comp = components;
        this.$context = context;
        this.$items = list;
        this.$onlyReturnSuccess = z10;
        this.$taskId = str;
        this.$onTotalProgress = interfaceC5074l;
        this.$onFileProgress = qVar;
        this.$onFileFinished = rVar;
        this.$onFinished = interfaceC5074l2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FileStorageManager$enqueueBatchUpload$job$1(this.$comp, this.$context, this.$items, this.$onlyReturnSuccess, this.$taskId, this.$onTotalProgress, this.$onFileProgress, this.$onFileFinished, this.$onFinished, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FileStorageManager$enqueueBatchUpload$job$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0090, code lost:
    
        if (Ua.C1056g.j(r12, r1, r11) == r0) goto L33;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L27
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L15
            r11 = r12
            goto L93
        L15:
            r0 = move-exception
            r13 = r0
            r11 = r12
            goto La2
        L1a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L22:
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L15
            r11 = r12
            goto L53
        L27:
            kotlin.C4849c.b(r13)
            com.stepos.common.utils.filestorage.FileStorageManager$a r13 = r12.$comp     // Catch: java.lang.Throwable -> L9f
            com.stepos.common.utils.filestorage.internal.UploadCoordinator r5 = r13.getCoordinator()     // Catch: java.lang.Throwable -> L9f
            android.content.Context r6 = r12.$context     // Catch: java.lang.Throwable -> L9f
            java.util.List<P6.l> r7 = r12.$items     // Catch: java.lang.Throwable -> L9f
            com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$1 r8 = new com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$1     // Catch: java.lang.Throwable -> L9f
            p9.l<java.lang.Integer, Y8.t> r13 = r12.$onTotalProgress     // Catch: java.lang.Throwable -> L9f
            r8.<init>(r13, r4)     // Catch: java.lang.Throwable -> L9f
            com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$2 r9 = new com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$2     // Catch: java.lang.Throwable -> L9f
            p9.q<java.lang.Integer, java.lang.String, java.lang.Integer, Y8.t> r13 = r12.$onFileProgress     // Catch: java.lang.Throwable -> L9f
            r9.<init>(r13, r4)     // Catch: java.lang.Throwable -> L9f
            com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$3 r10 = new com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$3     // Catch: java.lang.Throwable -> L9f
            p9.r<java.lang.Integer, P6.m, java.lang.Integer, java.lang.Integer, Y8.t> r13 = r12.$onFileFinished     // Catch: java.lang.Throwable -> L9f
            r10.<init>(r13, r4)     // Catch: java.lang.Throwable -> L9f
            r12.label = r3     // Catch: java.lang.Throwable -> L9f
            r11 = r12
            java.lang.Object r13 = r5.j(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L7b
            if (r13 != r0) goto L53
            goto L92
        L53:
            java.util.List r13 = (java.util.List) r13     // Catch: java.lang.Throwable -> L7b
            boolean r12 = r11.$onlyReturnSuccess     // Catch: java.lang.Throwable -> L7b
            if (r12 == 0) goto L7f
            java.lang.Iterable r13 = (java.lang.Iterable) r13     // Catch: java.lang.Throwable -> L7b
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L7b
            r12.<init>()     // Catch: java.lang.Throwable -> L7b
            java.util.Iterator r13 = r13.iterator()     // Catch: java.lang.Throwable -> L7b
        L64:
            boolean r1 = r13.hasNext()     // Catch: java.lang.Throwable -> L7b
            if (r1 == 0) goto L7e
            java.lang.Object r1 = r13.next()     // Catch: java.lang.Throwable -> L7b
            r3 = r1
            P6.m r3 = (P6.UploadResult) r3     // Catch: java.lang.Throwable -> L7b
            boolean r3 = r3.getSuccess()     // Catch: java.lang.Throwable -> L7b
            if (r3 == 0) goto L64
            r12.add(r1)     // Catch: java.lang.Throwable -> L7b
            goto L64
        L7b:
            r0 = move-exception
        L7c:
            r13 = r0
            goto La2
        L7e:
            r13 = r12
        L7f:
            Ua.A0 r12 = Ua.Y.c()     // Catch: java.lang.Throwable -> L7b
            com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$1 r1 = new com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$1     // Catch: java.lang.Throwable -> L7b
            p9.l<java.util.List<P6.m>, Y8.t> r3 = r11.$onFinished     // Catch: java.lang.Throwable -> L7b
            r1.<init>(r3, r13, r4)     // Catch: java.lang.Throwable -> L7b
            r11.label = r2     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r12 = Ua.C1056g.j(r12, r1, r11)     // Catch: java.lang.Throwable -> L7b
            if (r12 != r0) goto L93
        L92:
            return r0
        L93:
            java.util.concurrent.ConcurrentHashMap r12 = com.stepos.common.utils.filestorage.FileStorageManager.c()
            java.lang.String r13 = r11.$taskId
            r12.remove(r13)
            Y8.t r12 = Y8.t.f7040a
            return r12
        L9f:
            r0 = move-exception
            r11 = r12
            goto L7c
        La2:
            java.util.concurrent.ConcurrentHashMap r12 = com.stepos.common.utils.filestorage.FileStorageManager.c()
            java.lang.String r0 = r11.$taskId
            r12.remove(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
