package ya;

import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class w0 extends E0 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f44131c = new a(null);

    public static final class a {

        /* renamed from: ya.w0$a$a, reason: collision with other inner class name */
        public static final class C0558a extends w0 {

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Map<v0, B0> f44132d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f44133e;

            /* JADX WARN: Multi-variable type inference failed */
            public C0558a(Map<v0, ? extends B0> map, boolean z10) {
                this.f44132d = map;
                this.f44133e = z10;
            }

            @Override // ya.E0
            public boolean a() {
                return this.f44133e;
            }

            @Override // ya.E0
            public boolean f() {
                return this.f44132d.isEmpty();
            }

            @Override // ya.w0
            public B0 k(v0 key) {
                kotlin.jvm.internal.p.i(key, "key");
                return this.f44132d.get(key);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ w0 e(a aVar, Map map, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return aVar.d(map, z10);
        }

        public final E0 a(S kotlinType) {
            kotlin.jvm.internal.p.i(kotlinType, "kotlinType");
            return b(kotlinType.H0(), kotlinType.F0());
        }

        public final E0 b(v0 typeConstructor, List<? extends B0> arguments) {
            kotlin.jvm.internal.p.i(typeConstructor, "typeConstructor");
            kotlin.jvm.internal.p.i(arguments, "arguments");
            List<E9.b0> parameters = typeConstructor.getParameters();
            kotlin.jvm.internal.p.h(parameters, "getParameters(...)");
            E9.b0 b0Var = (E9.b0) Z8.F.E0(parameters);
            if (b0Var == null || !b0Var.M()) {
                return new C5978M(parameters, arguments);
            }
            List<E9.b0> parameters2 = typeConstructor.getParameters();
            kotlin.jvm.internal.p.h(parameters2, "getParameters(...)");
            List<E9.b0> list = parameters2;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((E9.b0) it.next()).j());
            }
            return e(this, kotlin.collections.a.y(Z8.F.w1(arrayList, arguments)), false, 2, null);
        }

        public final w0 c(Map<v0, ? extends B0> map) {
            kotlin.jvm.internal.p.i(map, "map");
            return e(this, map, false, 2, null);
        }

        public final w0 d(Map<v0, ? extends B0> map, boolean z10) {
            kotlin.jvm.internal.p.i(map, "map");
            return new C0558a(map, z10);
        }

        public a() {
        }
    }

    public static final E0 i(v0 v0Var, List<? extends B0> list) {
        return f44131c.b(v0Var, list);
    }

    public static final w0 j(Map<v0, ? extends B0> map) {
        return f44131c.c(map);
    }

    @Override // ya.E0
    public B0 e(S key) {
        kotlin.jvm.internal.p.i(key, "key");
        return k(key.H0());
    }

    public abstract B0 k(v0 v0Var);
}
