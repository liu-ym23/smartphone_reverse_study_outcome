package com.stepos.datacenter.api;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)J"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.datacenter.api.StorageOps$clearTable$2", f = "StorageOps.kt", l = {26, 28}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class StorageOps$clearTable$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Long>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f29895a;

    /* renamed from: b, reason: collision with root package name */
    public long f29896b;

    /* renamed from: c, reason: collision with root package name */
    public int f29897c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Class<T> f29898d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DataCenter f29899e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorageOps$clearTable$2(Class<T> cls, DataCenter dataCenter, InterfaceC4014c<? super StorageOps$clearTable$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f29898d = cls;
        this.f29899e = dataCenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new StorageOps$clearTable$2(this.f29898d, this.f29899e, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Long> interfaceC4014c) {
        return ((StorageOps$clearTable$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r11.f29897c
            java.lang.String r2 = "DataCenter"
            r3 = 0
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L2e
            if (r1 == r6) goto L24
            if (r1 != r5) goto L1c
            long r0 = r11.f29896b
            kotlin.C4849c.b(r12)     // Catch: java.lang.Exception -> L19
            goto L93
        L19:
            r12 = move-exception
            goto Lbe
        L1c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L24:
            long r6 = r11.f29896b
            java.lang.Object r1 = r11.f29895a
            Q8.a r1 = (Q8.a) r1
            kotlin.C4849c.b(r12)     // Catch: java.lang.Exception -> L19
            goto L6a
        L2e:
            kotlin.C4849c.b(r12)
            S6.a r12 = S6.a.f5644a     // Catch: java.lang.Exception -> L19
            io.objectbox.BoxStore r12 = r12.a()     // Catch: java.lang.Exception -> L19
            java.lang.Class<T> r1 = r11.f29898d     // Catch: java.lang.Exception -> L19
            Q8.a r1 = r12.i(r1)     // Catch: java.lang.Exception -> L19
            long r7 = r1.c()     // Catch: java.lang.Exception -> L19
            int r12 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r12 <= 0) goto Lbc
            java.lang.Class<T> r12 = r11.f29898d     // Catch: java.lang.Exception -> L19
            java.lang.String r12 = r12.getSimpleName()     // Catch: java.lang.Exception -> L19
            com.stepos.datacenter.api.DataCenter$Companion r9 = com.stepos.datacenter.api.DataCenter.INSTANCE     // Catch: java.lang.Exception -> L19
            android.content.Context r9 = r9.getAppContext$sdk_release()     // Catch: java.lang.Exception -> L19
            if (r9 == 0) goto L74
            b7.a$a r10 = b7.C1453a.INSTANCE     // Catch: java.lang.Exception -> L19
            b7.a r9 = r10.a(r9)     // Catch: java.lang.Exception -> L19
            kotlin.jvm.internal.p.f(r12)     // Catch: java.lang.Exception -> L19
            r11.f29895a = r1     // Catch: java.lang.Exception -> L19
            r11.f29896b = r7     // Catch: java.lang.Exception -> L19
            r11.f29897c = r6     // Catch: java.lang.Exception -> L19
            java.lang.Object r12 = r9.c(r12, r11)     // Catch: java.lang.Exception -> L19
            if (r12 != r0) goto L69
            goto L91
        L69:
            r6 = r7
        L6a:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Exception -> L19
            boolean r12 = r12.booleanValue()     // Catch: java.lang.Exception -> L19
            g9.C4109a.a(r12)     // Catch: java.lang.Exception -> L19
            goto L75
        L74:
            r6 = r7
        L75:
            com.stepos.datacenter.api.DataCenter r12 = r11.f29899e     // Catch: java.lang.Exception -> L19
            W6.a r12 = r12.getStorageRouter()     // Catch: java.lang.Exception -> L19
            java.util.List r1 = r1.f()     // Catch: java.lang.Exception -> L19
            java.lang.String r8 = "getAll(...)"
            kotlin.jvm.internal.p.h(r1, r8)     // Catch: java.lang.Exception -> L19
            r8 = 0
            r11.f29895a = r8     // Catch: java.lang.Exception -> L19
            r11.f29896b = r6     // Catch: java.lang.Exception -> L19
            r11.f29897c = r5     // Catch: java.lang.Exception -> L19
            java.lang.Object r12 = r12.b(r1, r11)     // Catch: java.lang.Exception -> L19
            if (r12 != r0) goto L92
        L91:
            return r0
        L92:
            r0 = r6
        L93:
            java.lang.Class<T> r12 = r11.f29898d     // Catch: java.lang.Exception -> L19
            java.lang.String r12 = r12.getSimpleName()     // Catch: java.lang.Exception -> L19
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L19
            r5.<init>()     // Catch: java.lang.Exception -> L19
            java.lang.String r6 = "Cleared table "
            r5.append(r6)     // Catch: java.lang.Exception -> L19
            r5.append(r12)     // Catch: java.lang.Exception -> L19
            java.lang.String r12 = ", removed "
            r5.append(r12)     // Catch: java.lang.Exception -> L19
            r5.append(r0)     // Catch: java.lang.Exception -> L19
            java.lang.String r12 = " records"
            r5.append(r12)     // Catch: java.lang.Exception -> L19
            java.lang.String r12 = r5.toString()     // Catch: java.lang.Exception -> L19
            android.util.Log.d(r2, r12)     // Catch: java.lang.Exception -> L19
            r3 = r0
            goto Ld8
        Lbc:
            r3 = r7
            goto Ld8
        Lbe:
            java.lang.Class<T> r11 = r11.f29898d
            java.lang.String r11 = r11.getSimpleName()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to clear table "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            android.util.Log.e(r2, r11, r12)
        Ld8:
            java.lang.Long r11 = g9.C4109a.g(r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.StorageOps$clearTable$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
