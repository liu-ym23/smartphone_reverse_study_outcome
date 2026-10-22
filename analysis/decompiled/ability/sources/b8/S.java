package b8;

import h8.InterfaceC1499G;
import h8.InterfaceC1501I;
import h8.InterfaceC1520c;
import h8.InterfaceC1536s;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KParameter$Kind;

/* loaded from: classes4.dex */
public final class S implements Z7.n {
    public static final /* synthetic */ Z7.t[] e;

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0857s f2028a;
    public final int b;
    public final KParameter$Kind c;
    public final p0 d;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        e = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(S.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), nVar.g(new PropertyReference1Impl(nVar.b(S.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public S(AbstractC0857s abstractC0857s, int i, KParameter$Kind kParameter$Kind, S7.a aVar) {
        this.f2028a = abstractC0857s;
        this.b = i;
        this.c = kParameter$Kind;
        this.d = N9.j.E(null, aVar);
        N9.j.E(null, new P(this, 0));
    }

    public final InterfaceC1499G b() {
        Z7.t tVar = e[0];
        Object objInvoke = this.d.invoke();
        kotlin.jvm.internal.k.e(objInvoke, "getValue(...)");
        return (InterfaceC1499G) objInvoke;
    }

    public final l0 d() {
        X8.w type = b().getType();
        kotlin.jvm.internal.k.e(type, "getType(...)");
        return new l0(type, new P(this, 1));
    }

    public final boolean e() {
        InterfaceC1499G interfaceC1499GB = b();
        k8.Q q5 = interfaceC1499GB instanceof k8.Q ? (k8.Q) interfaceC1499GB : null;
        if (q5 != null) {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.a(q5);
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof S)) {
            return false;
        }
        S s5 = (S) obj;
        return kotlin.jvm.internal.k.b(this.f2028a, s5.f2028a) && this.b == s5.b;
    }

    public final boolean f() {
        InterfaceC1499G interfaceC1499GB = b();
        return (interfaceC1499GB instanceof k8.Q) && ((k8.Q) interfaceC1499GB).f4842j != null;
    }

    public final String getName() {
        InterfaceC1499G interfaceC1499GB = b();
        k8.Q q5 = interfaceC1499GB instanceof k8.Q ? (k8.Q) interfaceC1499GB : null;
        if (q5 != null && !q5.d().e0()) {
            G8.f name = q5.getName();
            kotlin.jvm.internal.k.e(name, "getName(...)");
            if (!name.b) {
                return name.b();
            }
        }
        return null;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f2028a.hashCode() * 31);
    }

    public final String toString() throws IOException {
        String strB;
        I8.g gVar = s0.f2054a;
        StringBuilder sb = new StringBuilder();
        int iOrdinal = this.c.ordinal();
        if (iOrdinal == 0) {
            sb.append("instance parameter");
        } else if (iOrdinal == 2) {
            sb.append("extension receiver parameter");
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            sb.append("parameter #" + this.b + ' ' + getName());
        }
        sb.append(" of ");
        InterfaceC1520c interfaceC1520cG = this.f2028a.g();
        if (interfaceC1520cG instanceof InterfaceC1501I) {
            strB = s0.c((InterfaceC1501I) interfaceC1520cG);
        } else {
            if (!(interfaceC1520cG instanceof InterfaceC1536s)) {
                throw new IllegalStateException(("Illegal callable: " + interfaceC1520cG).toString());
            }
            strB = s0.b((InterfaceC1536s) interfaceC1520cG);
        }
        sb.append(strB);
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }
}
