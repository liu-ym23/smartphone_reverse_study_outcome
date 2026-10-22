package androidx.camera.core.impl;

import K.AbstractC0889l;
import K.E0;
import K.InterfaceC0891n;
import K.m0;
import K.o0;
import android.util.Range;
import androidx.camera.core.impl.Config;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: i, reason: collision with root package name */
    public static final Config.a<Integer> f11441i = Config.a.a("camerax.core.captureConfig.rotation", Integer.TYPE);

    /* renamed from: j, reason: collision with root package name */
    public static final Config.a<Integer> f11442j = Config.a.a("camerax.core.captureConfig.jpegQuality", Integer.class);

    /* renamed from: k, reason: collision with root package name */
    public static final Config.a<Range<Integer>> f11443k = Config.a.a("camerax.core.captureConfig.resolvedFrameRate", Range.class);

    /* renamed from: a, reason: collision with root package name */
    public final List<DeferrableSurface> f11444a;

    /* renamed from: b, reason: collision with root package name */
    public final Config f11445b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11446c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11447d;

    /* renamed from: e, reason: collision with root package name */
    public final List<AbstractC0889l> f11448e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11449f;

    /* renamed from: g, reason: collision with root package name */
    public final E0 f11450g;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC0891n f11451h;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Set<DeferrableSurface> f11452a = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        public t f11453b = u.k0();

        /* renamed from: c, reason: collision with root package name */
        public int f11454c = -1;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11455d = false;

        /* renamed from: e, reason: collision with root package name */
        public List<AbstractC0889l> f11456e = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        public boolean f11457f = false;

        /* renamed from: g, reason: collision with root package name */
        public o0 f11458g = o0.g();

        /* renamed from: h, reason: collision with root package name */
        public InterfaceC0891n f11459h;

        public static a i(z<?> zVar) {
            b bVarS = zVar.s(null);
            if (bVarS != null) {
                a aVar = new a();
                bVarS.a(zVar, aVar);
                return aVar;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + zVar.w(zVar.toString()));
        }

        public void a(Collection<AbstractC0889l> collection) {
            Iterator<AbstractC0889l> it = collection.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
        }

        public void b(E0 e02) {
            this.f11458g.f(e02);
        }

        public void c(AbstractC0889l abstractC0889l) {
            if (this.f11456e.contains(abstractC0889l)) {
                return;
            }
            this.f11456e.add(abstractC0889l);
        }

        public <T> void d(Config.a<T> aVar, T t10) {
            this.f11453b.t(aVar, t10);
        }

        public void e(Config config) {
            for (Config.a<?> aVar : config.e()) {
                Object objG = this.f11453b.g(aVar, null);
                Object objA = config.a(aVar);
                if (objG instanceof m0) {
                    ((m0) objG).a(((m0) objA).c());
                } else {
                    if (objA instanceof m0) {
                        objA = ((m0) objA).clone();
                    }
                    this.f11453b.q(aVar, config.h(aVar), objA);
                }
            }
        }

        public void f(DeferrableSurface deferrableSurface) {
            this.f11452a.add(deferrableSurface);
        }

        public void g(String str, Object obj) {
            this.f11458g.h(str, obj);
        }

        public l h() {
            return new l(new ArrayList(this.f11452a), v.j0(this.f11453b), this.f11454c, this.f11455d, new ArrayList(this.f11456e), this.f11457f, E0.c(this.f11458g), this.f11459h);
        }

        public Range<Integer> j() {
            return (Range) this.f11453b.g(l.f11443k, y.f11539a);
        }

        public Set<DeferrableSurface> k() {
            return this.f11452a;
        }

        public int l() {
            return this.f11454c;
        }

        public void m(Range<Integer> range) {
            d(l.f11443k, range);
        }

        public void n(int i10) {
            this.f11458g.h("CAPTURE_CONFIG_ID_KEY", Integer.valueOf(i10));
        }

        public void o(Config config) {
            this.f11453b = u.l0(config);
        }

        public void p(boolean z10) {
            this.f11455d = z10;
        }

        public void q(int i10) {
            if (i10 != 0) {
                d(z.f11552M, Integer.valueOf(i10));
            }
        }

        public void r(int i10) {
            this.f11454c = i10;
        }

        public void s(boolean z10) {
            this.f11457f = z10;
        }

        public void t(int i10) {
            if (i10 != 0) {
                d(z.f11553N, Integer.valueOf(i10));
            }
        }
    }

    public interface b {
        void a(z<?> zVar, a aVar);
    }

    public l(List<DeferrableSurface> list, Config config, int i10, boolean z10, List<AbstractC0889l> list2, boolean z11, E0 e02, InterfaceC0891n interfaceC0891n) {
        this.f11444a = list;
        this.f11445b = config;
        this.f11446c = i10;
        this.f11448e = Collections.unmodifiableList(list2);
        this.f11449f = z11;
        this.f11450g = e02;
        this.f11451h = interfaceC0891n;
        this.f11447d = z10;
    }

    public static l b() {
        return new a().h();
    }

    public List<AbstractC0889l> c() {
        return this.f11448e;
    }

    public Range<Integer> d() {
        Range<Integer> range = (Range) this.f11445b.g(f11443k, y.f11539a);
        Objects.requireNonNull(range);
        return range;
    }

    public int e() {
        Object objD = this.f11450g.d("CAPTURE_CONFIG_ID_KEY");
        if (objD == null) {
            return -1;
        }
        return ((Integer) objD).intValue();
    }

    public Config f() {
        return this.f11445b;
    }

    public int g() {
        Integer num = (Integer) this.f11445b.g(z.f11552M, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public List<DeferrableSurface> h() {
        return Collections.unmodifiableList(this.f11444a);
    }

    public E0 i() {
        return this.f11450g;
    }

    public int j() {
        return this.f11446c;
    }

    public int k() {
        Integer num = (Integer) this.f11445b.g(z.f11553N, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public boolean l() {
        return this.f11449f;
    }
}
