package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class v implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Member f2100a;
    public final Type b;
    public final Class c;
    public final List d;

    /* JADX WARN: Removed duplicated region for block: B:6:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public v(java.lang.reflect.Member r1, java.lang.reflect.Type r2, java.lang.Class r3, java.lang.reflect.Type[] r4) {
        /*
            r0 = this;
            r0.<init>()
            r0.f2100a = r1
            r0.b = r2
            r0.c = r3
            if (r3 == 0) goto L2b
            Z0.a r1 = new Z0.a
            r2 = 2
            r1.<init>(r2)
            java.lang.Object r2 = r1.f1582a
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r1.D(r3)
            r1.E(r4)
            int r1 = r2.size()
            java.lang.reflect.Type[] r1 = new java.lang.reflect.Type[r1]
            java.lang.Object[] r1 = r2.toArray(r1)
            java.util.List r1 = H4.o.N(r1)
            if (r1 != 0) goto L2f
        L2b:
            java.util.List r1 = D7.q.I0(r4)
        L2f:
            r0.d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c8.v.<init>(java.lang.reflect.Member, java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type[]):void");
    }

    @Override // c8.e
    public final List a() {
        return this.d;
    }

    public void b(Object[] objArr) {
        AbstractC1451a.r(this, objArr);
    }

    public final void c(Object obj) {
        if (obj == null || !this.f2100a.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    @Override // c8.e
    public final Member getMember() {
        return this.f2100a;
    }

    @Override // c8.e
    public final Type getReturnType() {
        return this.b;
    }
}
