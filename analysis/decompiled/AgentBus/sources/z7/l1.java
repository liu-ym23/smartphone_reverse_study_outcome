package z7;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class l1 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11902g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ m1 f11903h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l1(m1 m1Var, int i2) {
        super(0);
        this.f11902g = i2;
        this.f11903h = m1Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f11902g) {
            case 0:
                q1 q1Var = this.f11903h.f11909g;
                Type type = q1Var != null ? (Type) q1Var.c() : null;
                q7.k.b(type);
                return l8.d.c(type);
            default:
                m1 m1Var = this.f11903h;
                return m1Var.a(m1Var.f11908f);
        }
    }
}
