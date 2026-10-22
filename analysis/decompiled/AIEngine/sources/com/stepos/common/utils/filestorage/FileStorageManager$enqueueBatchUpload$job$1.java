package com.stepos.common.utils.filestorage;

import android.content.Context;
import androidx.compose.runtime.i;
import com.stepos.common.utils.filestorage.a;
import com.stepos.core.common.cloud.e;
import com.stepos.core.common.cloud.f;
import com.stepos.core.data.base.Content;
import java.util.List;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import o8.h;
import qb.b;
import rb.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1", f = "FileStorageManager.kt", l = {Content.Types.TYPE_INT_ARRAY, 121}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class FileStorageManager$enqueueBatchUpload$job$1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f6589a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.C0046a f6590b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f6591c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List<h> f6592d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f6593e;
    public final /* synthetic */ i h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e f6594j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ f f6595k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ l<List<o8.i>, n> f6596l;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l<List<o8.i>, n> f6597a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<o8.i> f6598b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(l<? super List<o8.i>, n> lVar, List<o8.i> list, b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.f6597a = lVar;
            this.f6598b = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new AnonymousClass1(this.f6597a, this.f6598b, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            this.f6597a.invoke(this.f6598b);
            return n.f10413a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageManager$enqueueBatchUpload$job$1(a.C0046a c0046a, Context context, List list, String str, i iVar, e eVar, f fVar, l lVar, b bVar) {
        super(2, bVar);
        this.f6590b = c0046a;
        this.f6591c = context;
        this.f6592d = list;
        this.f6593e = str;
        this.h = iVar;
        this.f6594j = eVar;
        this.f6595k = fVar;
        this.f6596l = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new FileStorageManager$enqueueBatchUpload$job$1(this.f6590b, this.f6591c, this.f6592d, this.f6593e, this.h, this.f6594j, this.f6595k, this.f6596l, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((FileStorageManager$enqueueBatchUpload$job$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r13, r1, r12) == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r13.f6589a
            java.lang.String r2 = r13.f6593e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L23
            if (r1 == r4) goto L1e
            if (r1 != r3) goto L16
            kotlin.c.b(r14)     // Catch: java.lang.Throwable -> L13
            goto L63
        L13:
            r0 = move-exception
            r13 = r0
            goto L6b
        L16:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L1e:
            kotlin.c.b(r14)     // Catch: java.lang.Throwable -> L13
            r12 = r13
            goto L4d
        L23:
            kotlin.c.b(r14)
            com.stepos.common.utils.filestorage.a$a r14 = r13.f6590b     // Catch: java.lang.Throwable -> L13
            com.stepos.common.utils.filestorage.internal.UploadCoordinator r6 = r14.f6636c     // Catch: java.lang.Throwable -> L13
            android.content.Context r7 = r13.f6591c     // Catch: java.lang.Throwable -> L13
            java.util.List<o8.h> r8 = r13.f6592d     // Catch: java.lang.Throwable -> L13
            com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$1 r9 = new com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$1     // Catch: java.lang.Throwable -> L13
            androidx.compose.runtime.i r14 = r13.h     // Catch: java.lang.Throwable -> L13
            r9.<init>(r14, r5)     // Catch: java.lang.Throwable -> L13
            com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$2 r10 = new com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$2     // Catch: java.lang.Throwable -> L13
            com.stepos.core.common.cloud.e r14 = r13.f6594j     // Catch: java.lang.Throwable -> L13
            r10.<init>(r14, r5)     // Catch: java.lang.Throwable -> L13
            com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$3 r11 = new com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$results$3     // Catch: java.lang.Throwable -> L13
            com.stepos.core.common.cloud.f r14 = r13.f6595k     // Catch: java.lang.Throwable -> L13
            r11.<init>(r14, r5)     // Catch: java.lang.Throwable -> L13
            r13.f6589a = r4     // Catch: java.lang.Throwable -> L13
            r12 = r13
            java.lang.Object r14 = r6.d(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L13
            if (r14 != r0) goto L4d
            goto L62
        L4d:
            java.util.List r14 = (java.util.List) r14     // Catch: java.lang.Throwable -> L13
            kotlinx.coroutines.MainCoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L13
            com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$1 r1 = new com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1$1     // Catch: java.lang.Throwable -> L13
            zb.l<java.util.List<o8.i>, lb.n> r4 = r12.f6596l     // Catch: java.lang.Throwable -> L13
            r1.<init>(r4, r14, r5)     // Catch: java.lang.Throwable -> L13
            r12.f6589a = r3     // Catch: java.lang.Throwable -> L13
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.withContext(r13, r1, r12)     // Catch: java.lang.Throwable -> L13
            if (r13 != r0) goto L63
        L62:
            return r0
        L63:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, kotlinx.coroutines.Job> r13 = com.stepos.common.utils.filestorage.a.f6633b
            r13.remove(r2)
            lb.n r13 = lb.n.f10413a
            return r13
        L6b:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, kotlinx.coroutines.Job> r14 = com.stepos.common.utils.filestorage.a.f6633b
            r14.remove(r2)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.FileStorageManager$enqueueBatchUpload$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
