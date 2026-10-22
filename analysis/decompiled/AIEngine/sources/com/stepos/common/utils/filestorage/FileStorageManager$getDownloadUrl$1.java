package com.stepos.common.utils.filestorage;

import androidx.compose.runtime.g;
import com.stepos.common.utils.filestorage.a;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import o8.d;
import qb.b;
import rb.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.FileStorageManager$getDownloadUrl$1", f = "FileStorageManager.kt", l = {162, 168, 171}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class FileStorageManager$getDownloadUrl$1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f6623a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.C0046a f6624b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f6625c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f6626d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f6627e;
    public final /* synthetic */ l<Throwable, n> h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.common.utils.filestorage.FileStorageManager$getDownloadUrl$1$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$getDownloadUrl$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f6628a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f6629b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(g gVar, d dVar, b bVar) {
            super(2, bVar);
            this.f6628a = gVar;
            this.f6629b = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new AnonymousClass1(this.f6628a, this.f6629b, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            this.f6628a.invoke(this.f6629b);
            return n.f10413a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.common.utils.filestorage.FileStorageManager$getDownloadUrl$1$2", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$getDownloadUrl$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l<Throwable, n> f6630a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f6631b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(l<? super Throwable, n> lVar, Throwable th, b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.f6630a = lVar;
            this.f6631b = th;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new AnonymousClass2(this.f6630a, this.f6631b, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            kotlin.c.b(obj);
            this.f6630a.invoke(this.f6631b);
            return n.f10413a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageManager$getDownloadUrl$1(a.C0046a c0046a, String str, Integer num, g gVar, l lVar, b bVar) {
        super(2, bVar);
        this.f6624b = c0046a;
        this.f6625c = str;
        this.f6626d = num;
        this.f6627e = gVar;
        this.h = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new FileStorageManager$getDownloadUrl$1(this.f6624b, this.f6625c, this.f6626d, this.f6627e, this.h, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((FileStorageManager$getDownloadUrl$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r0, r2, r11) == r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b4, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r0, r2, r11) != r1) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.String r0 = "getDownloadUrl ok fileId="
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r11.f6623a
            r3 = 0
            java.lang.String r4 = "FileStorageManager"
            r5 = 3
            r6 = 2
            r7 = 1
            java.lang.String r8 = r11.f6625c
            if (r2 == 0) goto L2e
            if (r2 == r7) goto L2a
            if (r2 == r6) goto L23
            if (r2 != r5) goto L1b
            kotlin.c.b(r12)
            goto Lb7
        L1b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L23:
            kotlin.c.b(r12)     // Catch: java.lang.Throwable -> L28
            goto Lb7
        L28:
            r12 = move-exception
            goto L83
        L2a:
            kotlin.c.b(r12)     // Catch: java.lang.Throwable -> L28
            goto L40
        L2e:
            kotlin.c.b(r12)
            com.stepos.common.utils.filestorage.a$a r12 = r11.f6624b     // Catch: java.lang.Throwable -> L28
            com.stepos.common.utils.filestorage.internal.a r12 = r12.f6635b     // Catch: java.lang.Throwable -> L28
            java.lang.Integer r2 = r11.f6626d     // Catch: java.lang.Throwable -> L28
            r11.f6623a = r7     // Catch: java.lang.Throwable -> L28
            java.lang.Object r12 = r12.b(r8, r2, r11)     // Catch: java.lang.Throwable -> L28
            if (r12 != r1) goto L40
            goto Lb6
        L40:
            o8.d r12 = (o8.d) r12     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = r12.f10794a     // Catch: java.lang.Throwable -> L28
            java.lang.String r7 = r12.f10796c     // Catch: java.lang.Throwable -> L28
            java.lang.String r9 = r12.f10798e     // Catch: java.lang.Throwable -> L28
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L28
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L28
            r10.append(r8)     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = " model="
            r10.append(r0)     // Catch: java.lang.Throwable -> L28
            r10.append(r2)     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = " ct="
            r10.append(r0)     // Catch: java.lang.Throwable -> L28
            r10.append(r7)     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = " expiresAt="
            r10.append(r0)     // Catch: java.lang.Throwable -> L28
            r10.append(r9)     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = r10.toString()     // Catch: java.lang.Throwable -> L28
            android.util.Log.i(r4, r0)     // Catch: java.lang.Throwable -> L28
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L28
            com.stepos.common.utils.filestorage.FileStorageManager$getDownloadUrl$1$1 r2 = new com.stepos.common.utils.filestorage.FileStorageManager$getDownloadUrl$1$1     // Catch: java.lang.Throwable -> L28
            androidx.compose.runtime.g r7 = r11.f6627e     // Catch: java.lang.Throwable -> L28
            r2.<init>(r7, r12, r3)     // Catch: java.lang.Throwable -> L28
            r11.f6623a = r6     // Catch: java.lang.Throwable -> L28
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r0, r2, r11)     // Catch: java.lang.Throwable -> L28
            if (r11 != r1) goto Lb7
            goto Lb6
        L83:
            java.lang.Class r0 = r12.getClass()
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r2 = r12.getMessage()
            java.lang.String r6 = " err="
            java.lang.String r7 = ": "
            java.lang.String r9 = "getDownloadUrl fail fileId="
            java.lang.StringBuilder r0 = ai.onnxruntime.a.s(r9, r8, r6, r0, r7)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r4, r0)
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
            com.stepos.common.utils.filestorage.FileStorageManager$getDownloadUrl$1$2 r2 = new com.stepos.common.utils.filestorage.FileStorageManager$getDownloadUrl$1$2
            zb.l<java.lang.Throwable, lb.n> r4 = r11.h
            r2.<init>(r4, r12, r3)
            r11.f6623a = r5
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r0, r2, r11)
            if (r11 != r1) goto Lb7
        Lb6:
            return r1
        Lb7:
            lb.n r11 = lb.n.f10413a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.FileStorageManager$getDownloadUrl$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
