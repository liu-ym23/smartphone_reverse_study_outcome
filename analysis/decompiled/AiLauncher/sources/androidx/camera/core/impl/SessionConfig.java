package androidx.camera.core.impl;

import D.B;
import D.C0761b0;
import K.AbstractC0889l;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.e;
import androidx.camera.core.impl.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class SessionConfig {

    /* renamed from: j, reason: collision with root package name */
    public static final List<Integer> f11335j = Arrays.asList(1, 5, 3);

    /* renamed from: a, reason: collision with root package name */
    public final List<f> f11336a;

    /* renamed from: b, reason: collision with root package name */
    public final f f11337b;

    /* renamed from: c, reason: collision with root package name */
    public final List<CameraDevice.StateCallback> f11338c;

    /* renamed from: d, reason: collision with root package name */
    public final List<CameraCaptureSession.StateCallback> f11339d;

    /* renamed from: e, reason: collision with root package name */
    public final List<AbstractC0889l> f11340e;

    /* renamed from: f, reason: collision with root package name */
    public final d f11341f;

    /* renamed from: g, reason: collision with root package name */
    public final l f11342g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11343h;

    /* renamed from: i, reason: collision with root package name */
    public InputConfiguration f11344i;

    public enum SessionError {
        SESSION_ERROR_SURFACE_NEEDS_RESET,
        SESSION_ERROR_UNKNOWN
    }

    public static class a {

        /* renamed from: f, reason: collision with root package name */
        public d f11350f;

        /* renamed from: g, reason: collision with root package name */
        public InputConfiguration f11351g;

        /* renamed from: i, reason: collision with root package name */
        public f f11353i;

        /* renamed from: a, reason: collision with root package name */
        public final Set<f> f11345a = new LinkedHashSet();

        /* renamed from: b, reason: collision with root package name */
        public final l.a f11346b = new l.a();

        /* renamed from: c, reason: collision with root package name */
        public final List<CameraDevice.StateCallback> f11347c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final List<CameraCaptureSession.StateCallback> f11348d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public final List<AbstractC0889l> f11349e = new ArrayList();

        /* renamed from: h, reason: collision with root package name */
        public int f11352h = 0;
    }

    public static class b extends a {
        public static b p(z<?> zVar, Size size) {
            e eVarF0 = zVar.f0(null);
            if (eVarF0 != null) {
                b bVar = new b();
                eVarF0.a(size, zVar, bVar);
                return bVar;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + zVar.w(zVar.toString()));
        }

        public b a(Collection<AbstractC0889l> collection) {
            for (AbstractC0889l abstractC0889l : collection) {
                this.f11346b.c(abstractC0889l);
                if (!this.f11349e.contains(abstractC0889l)) {
                    this.f11349e.add(abstractC0889l);
                }
            }
            return this;
        }

        public b b(Collection<CameraDevice.StateCallback> collection) {
            Iterator<CameraDevice.StateCallback> it = collection.iterator();
            while (it.hasNext()) {
                f(it.next());
            }
            return this;
        }

        public b c(Collection<AbstractC0889l> collection) {
            this.f11346b.a(collection);
            return this;
        }

        public b d(List<CameraCaptureSession.StateCallback> list) {
            Iterator<CameraCaptureSession.StateCallback> it = list.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
            return this;
        }

        public b e(AbstractC0889l abstractC0889l) {
            this.f11346b.c(abstractC0889l);
            if (!this.f11349e.contains(abstractC0889l)) {
                this.f11349e.add(abstractC0889l);
            }
            return this;
        }

        public b f(CameraDevice.StateCallback stateCallback) {
            if (this.f11347c.contains(stateCallback)) {
                return this;
            }
            this.f11347c.add(stateCallback);
            return this;
        }

        public b g(Config config) {
            this.f11346b.e(config);
            return this;
        }

        public b h(DeferrableSurface deferrableSurface) {
            return i(deferrableSurface, B.f1998d);
        }

        public b i(DeferrableSurface deferrableSurface, B b10) {
            this.f11345a.add(f.a(deferrableSurface).b(b10).a());
            return this;
        }

        public b j(AbstractC0889l abstractC0889l) {
            this.f11346b.c(abstractC0889l);
            return this;
        }

        public b k(CameraCaptureSession.StateCallback stateCallback) {
            if (this.f11348d.contains(stateCallback)) {
                return this;
            }
            this.f11348d.add(stateCallback);
            return this;
        }

        public b l(DeferrableSurface deferrableSurface) {
            return m(deferrableSurface, B.f1998d);
        }

        public b m(DeferrableSurface deferrableSurface, B b10) {
            return n(deferrableSurface, b10, null, -1);
        }

        public b n(DeferrableSurface deferrableSurface, B b10, String str, int i10) {
            this.f11345a.add(f.a(deferrableSurface).d(str).b(b10).c(i10).a());
            this.f11346b.f(deferrableSurface);
            return this;
        }

        public SessionConfig o() {
            return new SessionConfig(new ArrayList(this.f11345a), new ArrayList(this.f11347c), new ArrayList(this.f11348d), new ArrayList(this.f11349e), this.f11346b.h(), this.f11350f, this.f11351g, this.f11352h, this.f11353i);
        }

        public b q(d dVar) {
            this.f11350f = dVar;
            return this;
        }

        public b r(Range<Integer> range) {
            this.f11346b.m(range);
            return this;
        }

        public b s(Config config) {
            this.f11346b.o(config);
            return this;
        }

        public b t(InputConfiguration inputConfiguration) {
            this.f11351g = inputConfiguration;
            return this;
        }

        public b u(DeferrableSurface deferrableSurface) {
            this.f11353i = f.a(deferrableSurface).a();
            return this;
        }

        public b v(int i10) {
            if (i10 != 0) {
                this.f11346b.q(i10);
            }
            return this;
        }

        public b w(int i10) {
            this.f11352h = i10;
            return this;
        }

        public b x(int i10) {
            this.f11346b.r(i10);
            return this;
        }

        public b y(int i10) {
            if (i10 != 0) {
                this.f11346b.t(i10);
            }
            return this;
        }
    }

    public static final class c implements d {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f11354a = new AtomicBoolean(false);

        /* renamed from: b, reason: collision with root package name */
        public final d f11355b;

        public c(d dVar) {
            this.f11355b = dVar;
        }

        @Override // androidx.camera.core.impl.SessionConfig.d
        public void a(SessionConfig sessionConfig, SessionError sessionError) {
            if (this.f11354a.get()) {
                return;
            }
            this.f11355b.a(sessionConfig, sessionError);
        }

        public void b() {
            this.f11354a.set(true);
        }
    }

    public interface d {
        void a(SessionConfig sessionConfig, SessionError sessionError);
    }

    public interface e {
        void a(Size size, z<?> zVar, b bVar);
    }

    public static abstract class f {

        public static abstract class a {
            public abstract f a();

            public abstract a b(B b10);

            public abstract a c(int i10);

            public abstract a d(String str);

            public abstract a e(List<DeferrableSurface> list);

            public abstract a f(int i10);
        }

        public static a a(DeferrableSurface deferrableSurface) {
            return new e.b().g(deferrableSurface).e(Collections.EMPTY_LIST).d(null).c(-1).f(-1).b(B.f1998d);
        }

        public abstract B b();

        public abstract int c();

        public abstract String d();

        public abstract List<DeferrableSurface> e();

        public abstract DeferrableSurface f();

        public abstract int g();
    }

    public static final class g extends a {

        /* renamed from: j, reason: collision with root package name */
        public final S.g f11356j = new S.g();

        /* renamed from: k, reason: collision with root package name */
        public boolean f11357k = true;

        /* renamed from: l, reason: collision with root package name */
        public StringBuilder f11358l = new StringBuilder();

        /* renamed from: m, reason: collision with root package name */
        public boolean f11359m = false;

        /* renamed from: n, reason: collision with root package name */
        public List<d> f11360n = new ArrayList();

        public static /* synthetic */ void a(g gVar, SessionConfig sessionConfig, SessionError sessionError) {
            Iterator<d> it = gVar.f11360n.iterator();
            while (it.hasNext()) {
                it.next().a(sessionConfig, sessionError);
            }
        }

        public void b(SessionConfig sessionConfig) {
            l lVarL = sessionConfig.l();
            if (lVarL.j() != -1) {
                this.f11359m = true;
                this.f11346b.r(SessionConfig.f(lVarL.j(), this.f11346b.l()));
            }
            g(lVarL.d());
            h(lVarL.g());
            i(lVarL.k());
            this.f11346b.b(sessionConfig.l().i());
            this.f11347c.addAll(sessionConfig.c());
            this.f11348d.addAll(sessionConfig.m());
            this.f11346b.a(sessionConfig.k());
            this.f11349e.addAll(sessionConfig.o());
            if (sessionConfig.d() != null) {
                this.f11360n.add(sessionConfig.d());
            }
            if (sessionConfig.h() != null) {
                this.f11351g = sessionConfig.h();
            }
            this.f11345a.addAll(sessionConfig.i());
            this.f11346b.k().addAll(lVarL.h());
            if (!e().containsAll(this.f11346b.k())) {
                C0761b0.a("ValidatingBuilder", "Invalid configuration due to capture request surfaces are not a subset of surfaces");
                this.f11357k = false;
                this.f11358l.append("Invalid configuration due to capture request surfaces are not a subset of surfaces");
            }
            if (sessionConfig.n() != this.f11352h && sessionConfig.n() != 0 && this.f11352h != 0) {
                C0761b0.a("ValidatingBuilder", "Invalid configuration due to that two non-default session types are set");
                this.f11357k = false;
                this.f11358l.append("Invalid configuration due to that two non-default session types are set");
            } else if (sessionConfig.n() != 0) {
                this.f11352h = sessionConfig.n();
            }
            if (sessionConfig.f11337b != null) {
                if (this.f11353i == sessionConfig.f11337b || this.f11353i == null) {
                    this.f11353i = sessionConfig.f11337b;
                } else {
                    C0761b0.a("ValidatingBuilder", "Invalid configuration due to that two different postview output configs are set");
                    this.f11357k = false;
                    this.f11358l.append("Invalid configuration due to that two different postview output configs are set");
                }
            }
            this.f11346b.e(lVarL.f());
        }

        public SessionConfig c() {
            if (!this.f11357k) {
                throw new IllegalArgumentException("Unsupported session configuration combination");
            }
            ArrayList arrayList = new ArrayList(this.f11345a);
            this.f11356j.c(arrayList);
            if (this.f11352h == 1) {
                new P.d().e(arrayList, this.f11346b);
            }
            return new SessionConfig(arrayList, new ArrayList(this.f11347c), new ArrayList(this.f11348d), new ArrayList(this.f11349e), this.f11346b.h(), !this.f11360n.isEmpty() ? new d() { // from class: K.y0
                @Override // androidx.camera.core.impl.SessionConfig.d
                public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                    SessionConfig.g.a(this.f4022a, sessionConfig, sessionError);
                }
            } : null, this.f11351g, this.f11352h, this.f11353i);
        }

        public String d() {
            return !this.f11359m ? "Template is not set" : this.f11358l.toString();
        }

        public final List<DeferrableSurface> e() {
            ArrayList arrayList = new ArrayList();
            for (f fVar : this.f11345a) {
                arrayList.add(fVar.f());
                Iterator<DeferrableSurface> it = fVar.e().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
            return arrayList;
        }

        public boolean f() {
            return this.f11359m && this.f11357k;
        }

        public final void g(Range<Integer> range) {
            Range<Integer> range2 = y.f11539a;
            if (range.equals(range2)) {
                return;
            }
            if (this.f11346b.j().equals(range2)) {
                this.f11346b.m(range);
                return;
            }
            if (this.f11346b.j().equals(range)) {
                return;
            }
            this.f11357k = false;
            String str = "Different ExpectedFrameRateRange values; current = " + this.f11346b.j() + ", new = " + range;
            C0761b0.c("ValidatingBuilder", str);
            this.f11358l.append(str);
        }

        public final void h(int i10) {
            if (i10 != 0) {
                this.f11346b.q(i10);
            }
        }

        public final void i(int i10) {
            if (i10 != 0) {
                this.f11346b.t(i10);
            }
        }
    }

    public SessionConfig(List<f> list, List<CameraDevice.StateCallback> list2, List<CameraCaptureSession.StateCallback> list3, List<AbstractC0889l> list4, l lVar, d dVar, InputConfiguration inputConfiguration, int i10, f fVar) {
        this.f11336a = list;
        this.f11338c = Collections.unmodifiableList(list2);
        this.f11339d = Collections.unmodifiableList(list3);
        this.f11340e = Collections.unmodifiableList(list4);
        this.f11341f = dVar;
        this.f11342g = lVar;
        this.f11344i = inputConfiguration;
        this.f11343h = i10;
        this.f11337b = fVar;
    }

    public static SessionConfig b() {
        return new SessionConfig(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new l.a().h(), null, null, 0, null);
    }

    public static int f(int i10, int i11) {
        List<Integer> list = f11335j;
        return list.indexOf(Integer.valueOf(i10)) >= list.indexOf(Integer.valueOf(i11)) ? i10 : i11;
    }

    public List<CameraDevice.StateCallback> c() {
        return this.f11338c;
    }

    public d d() {
        return this.f11341f;
    }

    public Range<Integer> e() {
        return this.f11342g.d();
    }

    public Config g() {
        return this.f11342g.f();
    }

    public InputConfiguration h() {
        return this.f11344i;
    }

    public List<f> i() {
        return this.f11336a;
    }

    public f j() {
        return this.f11337b;
    }

    public List<AbstractC0889l> k() {
        return this.f11342g.c();
    }

    public l l() {
        return this.f11342g;
    }

    public List<CameraCaptureSession.StateCallback> m() {
        return this.f11339d;
    }

    public int n() {
        return this.f11343h;
    }

    public List<AbstractC0889l> o() {
        return this.f11340e;
    }

    public List<DeferrableSurface> p() {
        ArrayList arrayList = new ArrayList();
        for (f fVar : this.f11336a) {
            arrayList.add(fVar.f());
            Iterator<DeferrableSurface> it = fVar.e().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int q() {
        return this.f11342g.j();
    }
}
