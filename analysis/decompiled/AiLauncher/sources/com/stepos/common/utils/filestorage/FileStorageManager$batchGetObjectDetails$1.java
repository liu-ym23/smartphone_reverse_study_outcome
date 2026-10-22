package com.stepos.common.utils.filestorage;

import P6.BatchQueryStorageObjectResponse;
import Ua.M;
import Y8.t;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$batchGetObjectDetails$1", f = "FileStorageManager.kt", l = {168, 173, 176}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FileStorageManager$batchGetObjectDetails$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ FileStorageManager.Components $comp;
    final /* synthetic */ List<String> $fileIds;
    final /* synthetic */ InterfaceC5074l<Throwable, t> $onError;
    final /* synthetic */ InterfaceC5074l<BatchQueryStorageObjectResponse, t> $onSuccess;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$batchGetObjectDetails$1$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$batchGetObjectDetails$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ InterfaceC5074l<BatchQueryStorageObjectResponse, t> $onSuccess;
        final /* synthetic */ BatchQueryStorageObjectResponse $resp;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super BatchQueryStorageObjectResponse, t> interfaceC5074l, BatchQueryStorageObjectResponse batchQueryStorageObjectResponse, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onSuccess = interfaceC5074l;
            this.$resp = batchQueryStorageObjectResponse;
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
    @InterfaceC4112d(c = "com.stepos.common.utils.filestorage.FileStorageManager$batchGetObjectDetails$1$2", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.common.utils.filestorage.FileStorageManager$batchGetObjectDetails$1$2, reason: invalid class name */
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
    public FileStorageManager$batchGetObjectDetails$1(FileStorageManager.Components components, List<String> list, InterfaceC5074l<? super BatchQueryStorageObjectResponse, t> interfaceC5074l, InterfaceC5074l<? super Throwable, t> interfaceC5074l2, InterfaceC4014c<? super FileStorageManager$batchGetObjectDetails$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$comp = components;
        this.$fileIds = list;
        this.$onSuccess = interfaceC5074l;
        this.$onError = interfaceC5074l2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FileStorageManager$batchGetObjectDetails$1(this.$comp, this.$fileIds, this.$onSuccess, this.$onError, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FileStorageManager$batchGetObjectDetails$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        if (Ua.C1056g.j(r1, r6, r9) == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bc, code lost:
    
        if (Ua.C1056g.j(r1, r3, r9) != r0) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r9.label
            r2 = 0
            java.lang.String r3 = "FileStorageManager"
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L2c
            if (r1 == r6) goto L28
            if (r1 == r5) goto L21
            if (r1 != r4) goto L19
            kotlin.C4849c.b(r10)
            goto Lbf
        L19:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L21:
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L26
            goto Lbf
        L26:
            r10 = move-exception
            goto L83
        L28:
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L26
            goto L41
        L2c:
            kotlin.C4849c.b(r10)
            com.stepos.common.utils.filestorage.FileStorageManager$a r10 = r9.$comp     // Catch: java.lang.Throwable -> L26
            com.stepos.common.utils.filestorage.internal.FileStorageApi r10 = r10.getApi()     // Catch: java.lang.Throwable -> L26
            java.util.List<java.lang.String> r1 = r9.$fileIds     // Catch: java.lang.Throwable -> L26
            r9.label = r6     // Catch: java.lang.Throwable -> L26
            java.lang.Object r10 = r10.a(r1, r9)     // Catch: java.lang.Throwable -> L26
            if (r10 != r0) goto L41
            goto Lbe
        L41:
            P6.c r10 = (P6.BatchQueryStorageObjectResponse) r10     // Catch: java.lang.Throwable -> L26
            java.util.List r1 = r10.c()     // Catch: java.lang.Throwable -> L26
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L26
            java.util.List r6 = r10.d()     // Catch: java.lang.Throwable -> L26
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L26
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L26
            r7.<init>()     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = "batchGetObjectDetails ok found="
            r7.append(r8)     // Catch: java.lang.Throwable -> L26
            r7.append(r1)     // Catch: java.lang.Throwable -> L26
            java.lang.String r1 = " notFound="
            r7.append(r1)     // Catch: java.lang.Throwable -> L26
            r7.append(r6)     // Catch: java.lang.Throwable -> L26
            java.lang.String r1 = r7.toString()     // Catch: java.lang.Throwable -> L26
            android.util.Log.i(r3, r1)     // Catch: java.lang.Throwable -> L26
            Ua.A0 r1 = Ua.Y.c()     // Catch: java.lang.Throwable -> L26
            com.stepos.common.utils.filestorage.FileStorageManager$batchGetObjectDetails$1$1 r6 = new com.stepos.common.utils.filestorage.FileStorageManager$batchGetObjectDetails$1$1     // Catch: java.lang.Throwable -> L26
            p9.l<P6.c, Y8.t> r7 = r9.$onSuccess     // Catch: java.lang.Throwable -> L26
            r6.<init>(r7, r10, r2)     // Catch: java.lang.Throwable -> L26
            r9.label = r5     // Catch: java.lang.Throwable -> L26
            java.lang.Object r9 = Ua.C1056g.j(r1, r6, r9)     // Catch: java.lang.Throwable -> L26
            if (r9 != r0) goto Lbf
            goto Lbe
        L83:
            java.lang.Class r1 = r10.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r5 = r10.getMessage()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "batchGetObjectDetails fail err="
            r6.append(r7)
            r6.append(r1)
            java.lang.String r1 = ": "
            r6.append(r1)
            r6.append(r5)
            java.lang.String r1 = r6.toString()
            android.util.Log.w(r3, r1)
            Ua.A0 r1 = Ua.Y.c()
            com.stepos.common.utils.filestorage.FileStorageManager$batchGetObjectDetails$1$2 r3 = new com.stepos.common.utils.filestorage.FileStorageManager$batchGetObjectDetails$1$2
            p9.l<java.lang.Throwable, Y8.t> r5 = r9.$onError
            r3.<init>(r5, r10, r2)
            r9.label = r4
            java.lang.Object r9 = Ua.C1056g.j(r1, r3, r9)
            if (r9 != r0) goto Lbf
        Lbe:
            return r0
        Lbf:
            Y8.t r9 = Y8.t.f7040a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.FileStorageManager$batchGetObjectDetails$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
