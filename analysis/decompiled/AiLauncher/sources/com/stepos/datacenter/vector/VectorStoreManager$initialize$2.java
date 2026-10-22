package com.stepos.datacenter.vector;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.vector.VectorStoreManager$initialize$2", f = "VectorStoreManager.kt", l = {65, 66, 68}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class VectorStoreManager$initialize$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f30118a;

    /* renamed from: b, reason: collision with root package name */
    public int f30119b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VectorStoreManager f30120c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorStoreManager$initialize$2(VectorStoreManager vectorStoreManager, InterfaceC4014c<? super VectorStoreManager$initialize$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f30120c = vectorStoreManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new VectorStoreManager$initialize$2(this.f30120c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((VectorStoreManager$initialize$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0064 A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:8:0x0017, B:33:0x0076, B:35:0x0095, B:14:0x0026, B:27:0x005c, B:29:0x0064, B:34:0x0090, B:15:0x002a, B:24:0x004d, B:21:0x003e), top: B:40:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0090 A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:8:0x0017, B:33:0x0076, B:35:0x0095, B:14:0x0026, B:27:0x005c, B:29:0x0064, B:34:0x0090, B:15:0x002a, B:24:0x004d, B:21:0x003e), top: B:40:0x000b }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.f30119b
            r2 = 3
            r3 = 2
            java.lang.String r4 = "VectorStoreManager"
            r5 = 1
            if (r1 == 0) goto L2e
            if (r1 == r5) goto L2a
            if (r1 == r3) goto L26
            if (r1 != r2) goto L1e
            java.lang.Object r0 = r6.f30118a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L1b
            goto L76
        L1b:
            r6 = move-exception
            goto L9b
        L1e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L26:
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L1b
            goto L5c
        L2a:
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L1b
            goto L4d
        L2e:
            kotlin.C4849c.b(r7)
            com.stepos.datacenter.vector.VectorStoreManager r7 = r6.f30120c
            boolean r7 = com.stepos.datacenter.vector.VectorStoreManager.a(r7)
            if (r7 == 0) goto L3e
            java.lang.Boolean r6 = g9.C4109a.a(r5)
            return r6
        L3e:
            com.stepos.datacenter.vector.VectorStoreManager r7 = r6.f30120c     // Catch: java.lang.Throwable -> L1b
            com.stepos.usearch.VectorUSearchWrapper r7 = com.stepos.datacenter.vector.VectorStoreManager.c(r7)     // Catch: java.lang.Throwable -> L1b
            r6.f30119b = r5     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r7 = r7.s(r6)     // Catch: java.lang.Throwable -> L1b
            if (r7 != r0) goto L4d
            goto L74
        L4d:
            com.stepos.datacenter.vector.VectorStoreManager r7 = r6.f30120c     // Catch: java.lang.Throwable -> L1b
            com.stepos.usearch.VectorUSearchWrapper r7 = com.stepos.datacenter.vector.VectorStoreManager.c(r7)     // Catch: java.lang.Throwable -> L1b
            r6.f30119b = r3     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r7 = r7.t(r6)     // Catch: java.lang.Throwable -> L1b
            if (r7 != r0) goto L5c
            goto L74
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L1b
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L1b
            if (r7 == 0) goto L90
            com.stepos.datacenter.vector.VectorStoreManager r7 = r6.f30120c     // Catch: java.lang.Throwable -> L1b
            com.stepos.usearch.VectorUSearchWrapper r7 = com.stepos.datacenter.vector.VectorStoreManager.c(r7)     // Catch: java.lang.Throwable -> L1b
            r6.f30118a = r4     // Catch: java.lang.Throwable -> L1b
            r6.f30119b = r2     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r7 = r7.o(r6)     // Catch: java.lang.Throwable -> L1b
            if (r7 != r0) goto L75
        L74:
            return r0
        L75:
            r0 = r4
        L76:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b
            r1.<init>()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r2 = "Vector index restored from disk: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L1b
            r1.append(r7)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r7 = " entries"
            r1.append(r7)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> L1b
            android.util.Log.d(r0, r7)     // Catch: java.lang.Throwable -> L1b
            goto L95
        L90:
            java.lang.String r7 = "No existing vector index found, starting fresh"
            android.util.Log.d(r4, r7)     // Catch: java.lang.Throwable -> L1b
        L95:
            com.stepos.datacenter.vector.VectorStoreManager r6 = r6.f30120c     // Catch: java.lang.Throwable -> L1b
            com.stepos.datacenter.vector.VectorStoreManager.d(r6, r5)     // Catch: java.lang.Throwable -> L1b
            goto La1
        L9b:
            java.lang.String r7 = "VectorStoreManager initialization failed"
            android.util.Log.e(r4, r7, r6)
            r5 = 0
        La1:
            java.lang.Boolean r6 = g9.C4109a.a(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.vector.VectorStoreManager$initialize$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
