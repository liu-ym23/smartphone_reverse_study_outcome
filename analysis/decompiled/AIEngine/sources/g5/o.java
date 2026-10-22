package g5;

import d5.u;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o<T> extends u<T> {

    /* renamed from: a, reason: collision with root package name */
    public final d5.i f9032a;

    /* renamed from: b, reason: collision with root package name */
    public final u<T> f9033b;

    /* renamed from: c, reason: collision with root package name */
    public final Type f9034c;

    public o(d5.i iVar, u<T> uVar, Type type) {
        this.f9032a = iVar;
        this.f9033b = uVar;
        this.f9034c = type;
    }

    @Override // d5.u
    public final T a(k5.a aVar) {
        return this.f9033b.a(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.reflect.Type] */
    @Override // d5.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(k5.b r4, T r5) {
        /*
            r3 = this;
            java.lang.reflect.Type r0 = r3.f9034c
            if (r5 == 0) goto L11
            boolean r1 = r0 instanceof java.lang.Class
            if (r1 != 0) goto Lc
            boolean r1 = r0 instanceof java.lang.reflect.TypeVariable
            if (r1 == 0) goto L11
        Lc:
            java.lang.Class r1 = r5.getClass()
            goto L12
        L11:
            r1 = r0
        L12:
            d5.u<T> r2 = r3.f9033b
            if (r1 == r0) goto L3c
            d5.i r3 = r3.f9032a
            com.google.gson.reflect.TypeToken r0 = com.google.gson.reflect.TypeToken.get(r1)
            d5.u r3 = r3.e(r0)
            boolean r0 = r3 instanceof g5.k.b
            if (r0 != 0) goto L25
            goto L3b
        L25:
            r0 = r2
        L26:
            boolean r1 = r0 instanceof g5.m
            if (r1 == 0) goto L36
            r1 = r0
            g5.m r1 = (g5.m) r1
            d5.u r1 = r1.c()
            if (r1 != r0) goto L34
            goto L36
        L34:
            r0 = r1
            goto L26
        L36:
            boolean r0 = r0 instanceof g5.k.b
            if (r0 != 0) goto L3b
            goto L3c
        L3b:
            r2 = r3
        L3c:
            r2.b(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.o.b(k5.b, java.lang.Object):void");
    }
}
