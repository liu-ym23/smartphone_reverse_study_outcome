package com.stepos.common.utils.filestorage;

import P6.DocumentPreviewResponse;
import Ua.M;
import Y8.t;
import com.stepos.common.utils.filestorage.FileStorageManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$getPreviewUrl$1", f = "FileStorageManager.kt", l = {225, 230, 233}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FileStorageManager$getPreviewUrl$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ FileStorageManager.Components $comp;
    final /* synthetic */ String $dstType;
    final /* synthetic */ Integer $expiresSeconds;
    final /* synthetic */ String $fileId;
    final /* synthetic */ InterfaceC5074l<Throwable, t> $onError;
    final /* synthetic */ InterfaceC5074l<DocumentPreviewResponse, t> $onSuccess;
    final /* synthetic */ Integer $page;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$getPreviewUrl$1$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$getPreviewUrl$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ InterfaceC5074l<DocumentPreviewResponse, t> $onSuccess;
        final /* synthetic */ DocumentPreviewResponse $resp;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super DocumentPreviewResponse, t> interfaceC5074l, DocumentPreviewResponse documentPreviewResponse, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onSuccess = interfaceC5074l;
            this.$resp = documentPreviewResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$onSuccess, this.$resp, interfaceC4014c);
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
            this.$onSuccess.invoke(this.$resp);
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$getPreviewUrl$1$2", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$getPreviewUrl$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ Throwable $e;
        final /* synthetic */ InterfaceC5074l<Throwable, t> $onError;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(InterfaceC5074l<? super Throwable, t> interfaceC5074l, Throwable th, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onError = interfaceC5074l;
            this.$e = th;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$onError, this.$e, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$onError.invoke(this.$e);
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileStorageManager$getPreviewUrl$1(FileStorageManager.Components components, String str, String str2, Integer num, Integer num2, InterfaceC5074l<? super DocumentPreviewResponse, t> interfaceC5074l, InterfaceC5074l<? super Throwable, t> interfaceC5074l2, InterfaceC4014c<? super FileStorageManager$getPreviewUrl$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$comp = components;
        this.$fileId = str;
        this.$dstType = str2;
        this.$expiresSeconds = num;
        this.$page = num2;
        this.$onSuccess = interfaceC5074l;
        this.$onError = interfaceC5074l2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FileStorageManager$getPreviewUrl$1(this.$comp, this.$fileId, this.$dstType, this.$expiresSeconds, this.$page, this.$onSuccess, this.$onError, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FileStorageManager$getPreviewUrl$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
    
        if (Ua.C1056g.j(r13, r0, r12) == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e5, code lost:
    
        if (Ua.C1056g.j(r13, r0, r12) != r1) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r1 = f9.C4063a.g()
            int r0 = r13.label
            r2 = 0
            java.lang.String r3 = "FileStorageManager"
            r4 = 3
            r5 = 2
            r6 = 1
            if (r0 == 0) goto L30
            if (r0 == r6) goto L2b
            if (r0 == r5) goto L21
            if (r0 != r4) goto L19
            kotlin.C4849c.b(r14)
            goto Le8
        L19:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L21:
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L26
            goto Le8
        L26:
            r0 = move-exception
            r14 = r0
            r12 = r13
            goto La2
        L2b:
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L26
            r12 = r13
            goto L4c
        L30:
            kotlin.C4849c.b(r14)
            com.stepos.common.utils.filestorage.FileStorageManager$a r14 = r13.$comp     // Catch: java.lang.Throwable -> L9f
            com.stepos.common.utils.filestorage.internal.FileStorageApi r7 = r14.getApi()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r8 = r13.$fileId     // Catch: java.lang.Throwable -> L9f
            java.lang.String r9 = r13.$dstType     // Catch: java.lang.Throwable -> L9f
            java.lang.Integer r10 = r13.$expiresSeconds     // Catch: java.lang.Throwable -> L9f
            java.lang.Integer r11 = r13.$page     // Catch: java.lang.Throwable -> L9f
            r13.label = r6     // Catch: java.lang.Throwable -> L9f
            r12 = r13
            java.lang.Object r14 = r7.d(r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L9c
            if (r14 != r1) goto L4c
            goto Le7
        L4c:
            P6.f r14 = (P6.DocumentPreviewResponse) r14     // Catch: java.lang.Throwable -> L9c
            java.lang.String r13 = r12.$fileId     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r14.getDstType()     // Catch: java.lang.Throwable -> L9c
            java.lang.Integer r6 = r14.getPage()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r7 = r14.getExpiresAt()     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r8.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r9 = "getPreviewUrl ok fileId="
            r8.append(r9)     // Catch: java.lang.Throwable -> L9c
            r8.append(r13)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r13 = " dstType="
            r8.append(r13)     // Catch: java.lang.Throwable -> L9c
            r8.append(r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r13 = " page="
            r8.append(r13)     // Catch: java.lang.Throwable -> L9c
            r8.append(r6)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r13 = " expiresAt="
            r8.append(r13)     // Catch: java.lang.Throwable -> L9c
            r8.append(r7)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r13 = r8.toString()     // Catch: java.lang.Throwable -> L9c
            android.util.Log.i(r3, r13)     // Catch: java.lang.Throwable -> L9c
            Ua.A0 r13 = Ua.Y.c()     // Catch: java.lang.Throwable -> L9c
            com.stepos.common.utils.filestorage.FileStorageManager$getPreviewUrl$1$1 r0 = new com.stepos.common.utils.filestorage.FileStorageManager$getPreviewUrl$1$1     // Catch: java.lang.Throwable -> L9c
            p9.l<P6.f, Y8.t> r6 = r12.$onSuccess     // Catch: java.lang.Throwable -> L9c
            r0.<init>(r6, r14, r2)     // Catch: java.lang.Throwable -> L9c
            r12.label = r5     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r13 = Ua.C1056g.j(r13, r0, r12)     // Catch: java.lang.Throwable -> L9c
            if (r13 != r1) goto Le8
            goto Le7
        L9c:
            r0 = move-exception
        L9d:
            r14 = r0
            goto La2
        L9f:
            r0 = move-exception
            r12 = r13
            goto L9d
        La2:
            java.lang.String r13 = r12.$fileId
            java.lang.Class r0 = r14.getClass()
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r5 = r14.getMessage()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "getPreviewUrl fail fileId="
            r6.append(r7)
            r6.append(r13)
            java.lang.String r13 = " err="
            r6.append(r13)
            r6.append(r0)
            java.lang.String r13 = ": "
            r6.append(r13)
            r6.append(r5)
            java.lang.String r13 = r6.toString()
            android.util.Log.w(r3, r13)
            Ua.A0 r13 = Ua.Y.c()
            com.stepos.common.utils.filestorage.FileStorageManager$getPreviewUrl$1$2 r0 = new com.stepos.common.utils.filestorage.FileStorageManager$getPreviewUrl$1$2
            p9.l<java.lang.Throwable, Y8.t> r3 = r12.$onError
            r0.<init>(r3, r14, r2)
            r12.label = r4
            java.lang.Object r13 = Ua.C1056g.j(r13, r0, r12)
            if (r13 != r1) goto Le8
        Le7:
            return r1
        Le8:
            Y8.t r13 = Y8.t.f7040a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.FileStorageManager$getPreviewUrl$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
