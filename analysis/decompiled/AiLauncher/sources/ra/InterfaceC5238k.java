package ra;

import E9.O;
import Z8.Y;
import java.util.Collection;
import java.util.Set;
import p9.InterfaceC5074l;

/* renamed from: ra.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC5238k extends InterfaceC5241n {

    /* renamed from: a, reason: collision with root package name */
    public static final a f38895a = a.f38896a;

    /* renamed from: ra.k$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f38896a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final InterfaceC5074l<ga.e, Boolean> f38897b = C5237j.f38894a;

        public static final boolean a(ga.e it) {
            kotlin.jvm.internal.p.i(it, "it");
            return true;
        }

        public final InterfaceC5074l<ga.e, Boolean> c() {
            return f38897b;
        }
    }

    /* renamed from: ra.k$b */
    public static final class b extends AbstractC5239l {

        /* renamed from: b, reason: collision with root package name */
        public static final b f38898b = new b();

        @Override // ra.AbstractC5239l, ra.InterfaceC5238k
        public Set<ga.e> b() {
            return Y.e();
        }

        @Override // ra.AbstractC5239l, ra.InterfaceC5238k
        public Set<ga.e> f() {
            return Y.e();
        }

        @Override // ra.AbstractC5239l, ra.InterfaceC5238k
        public Set<ga.e> getVariableNames() {
            return Y.e();
        }
    }

    Collection<? extends O> a(ga.e eVar, M9.b bVar);

    Set<ga.e> b();

    Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e eVar, M9.b bVar);

    Set<ga.e> f();

    Set<ga.e> getVariableNames();
}
