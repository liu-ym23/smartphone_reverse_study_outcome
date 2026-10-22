package ya;

import E9.InterfaceC0799d;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class o0 {

    /* renamed from: e, reason: collision with root package name */
    public static final a f44115e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final o0 f44116a;

    /* renamed from: b, reason: collision with root package name */
    public final E9.a0 f44117b;

    /* renamed from: c, reason: collision with root package name */
    public final List<B0> f44118c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<E9.b0, B0> f44119d;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final o0 a(o0 o0Var, E9.a0 typeAliasDescriptor, List<? extends B0> arguments) {
            kotlin.jvm.internal.p.i(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.p.i(arguments, "arguments");
            List<E9.b0> parameters = typeAliasDescriptor.j().getParameters();
            kotlin.jvm.internal.p.h(parameters, "getParameters(...)");
            List<E9.b0> list = parameters;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((E9.b0) it.next()).a());
            }
            return new o0(o0Var, typeAliasDescriptor, arguments, kotlin.collections.a.y(Z8.F.w1(arrayList, arguments)), null);
        }

        public a() {
        }
    }

    public /* synthetic */ o0(o0 o0Var, E9.a0 a0Var, List list, Map map, kotlin.jvm.internal.i iVar) {
        this(o0Var, a0Var, list, map);
    }

    public final List<B0> a() {
        return this.f44118c;
    }

    public final E9.a0 b() {
        return this.f44117b;
    }

    public final B0 c(v0 constructor) {
        kotlin.jvm.internal.p.i(constructor, "constructor");
        InterfaceC0799d interfaceC0799dD = constructor.d();
        if (interfaceC0799dD instanceof E9.b0) {
            return this.f44119d.get(interfaceC0799dD);
        }
        return null;
    }

    public final boolean d(E9.a0 descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        if (kotlin.jvm.internal.p.d(this.f44117b, descriptor)) {
            return true;
        }
        o0 o0Var = this.f44116a;
        return o0Var != null ? o0Var.d(descriptor) : false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o0(o0 o0Var, E9.a0 a0Var, List<? extends B0> list, Map<E9.b0, ? extends B0> map) {
        this.f44116a = o0Var;
        this.f44117b = a0Var;
        this.f44118c = list;
        this.f44119d = map;
    }
}
