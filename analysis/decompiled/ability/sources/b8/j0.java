package b8;

import java.lang.reflect.Type;
import n8.AbstractC1744c;

/* loaded from: classes4.dex */
public final class j0 implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2044a;
    public final l0 b;

    public /* synthetic */ j0(l0 l0Var, int i) {
        this.f2044a = i;
        this.b = l0Var;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f2044a) {
            case 0:
                l0 l0Var = this.b;
                return l0Var.b(l0Var.f2046a);
            default:
                p0 p0Var = this.b.b;
                Type type = p0Var != null ? (Type) p0Var.invoke() : null;
                kotlin.jvm.internal.k.c(type);
                return AbstractC1744c.c(type);
        }
    }
}
