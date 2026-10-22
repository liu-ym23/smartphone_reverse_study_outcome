package W9;

import Z8.C1173v;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* renamed from: W9.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC1094c {

    /* renamed from: W9.c$a */
    public static final class a implements InterfaceC1094c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6726a = new a();

        @Override // W9.InterfaceC1094c
        public Z9.w a(ga.e name) {
            kotlin.jvm.internal.p.i(name, "name");
            return null;
        }

        @Override // W9.InterfaceC1094c
        public Set<ga.e> b() {
            return Z8.Y.e();
        }

        @Override // W9.InterfaceC1094c
        public Set<ga.e> c() {
            return Z8.Y.e();
        }

        @Override // W9.InterfaceC1094c
        public Set<ga.e> d() {
            return Z8.Y.e();
        }

        @Override // W9.InterfaceC1094c
        public Z9.n e(ga.e name) {
            kotlin.jvm.internal.p.i(name, "name");
            return null;
        }

        @Override // W9.InterfaceC1094c
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public List<Z9.r> f(ga.e name) {
            kotlin.jvm.internal.p.i(name, "name");
            return C1173v.m();
        }
    }

    Z9.w a(ga.e eVar);

    Set<ga.e> b();

    Set<ga.e> c();

    Set<ga.e> d();

    Z9.n e(ga.e eVar);

    Collection<Z9.r> f(ga.e eVar);
}
