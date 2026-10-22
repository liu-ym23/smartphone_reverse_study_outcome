package androidx.camera.core;

import D.AbstractC0772i;
import D.B;
import D.C0761b0;
import D.i0;
import H.DynamicRangeFeature;
import H.FpsRangeFeature;
import H.VideoStabilizationFeature;
import K.InterfaceC0898v;
import M.o;
import M.q;
import U.Y;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import androidx.camera.core.internal.compat.quirk.AeFpsRangeQuirk;
import androidx.camera.core.l;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class UseCase {

    /* renamed from: f, reason: collision with root package name */
    public z<?> f11254f;

    /* renamed from: g, reason: collision with root package name */
    public z<?> f11255g;

    /* renamed from: h, reason: collision with root package name */
    public Set<F.b> f11256h;

    /* renamed from: i, reason: collision with root package name */
    public z<?> f11257i;

    /* renamed from: j, reason: collision with root package name */
    public y f11258j;

    /* renamed from: k, reason: collision with root package name */
    public z<?> f11259k;

    /* renamed from: l, reason: collision with root package name */
    public Rect f11260l;

    /* renamed from: n, reason: collision with root package name */
    public CameraInternal f11262n;

    /* renamed from: o, reason: collision with root package name */
    public CameraInternal f11263o;

    /* renamed from: p, reason: collision with root package name */
    public AbstractC0772i f11264p;

    /* renamed from: q, reason: collision with root package name */
    public String f11265q;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11249a = false;

    /* renamed from: b, reason: collision with root package name */
    public final Set<b> f11250b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public final Object f11251c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final Object f11252d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public State f11253e = State.INACTIVE;

    /* renamed from: m, reason: collision with root package name */
    public Matrix f11261m = new Matrix();

    /* renamed from: r, reason: collision with root package name */
    public l f11266r = null;

    /* renamed from: s, reason: collision with root package name */
    public final l.c f11267s = new l.c() { // from class: D.D0
        @Override // androidx.camera.core.l.c
        public final void a(int i10) {
            this.f2011a.Q(i10);
        }
    };

    /* renamed from: t, reason: collision with root package name */
    public SessionConfig f11268t = SessionConfig.b();

    /* renamed from: u, reason: collision with root package name */
    public SessionConfig f11269u = SessionConfig.b();

    public enum State {
        ACTIVE,
        INACTIVE
    }

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11270a;

        static {
            int[] iArr = new int[VideoStabilization.values().length];
            f11270a = iArr;
            try {
                iArr[VideoStabilization.UNSPECIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11270a[VideoStabilization.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11270a[VideoStabilization.ON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11270a[VideoStabilization.PREVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface b {
        void b(UseCase useCase);

        void c(UseCase useCase);

        void k(UseCase useCase);

        void l(UseCase useCase);
    }

    public UseCase(z<?> zVar) {
        this.f11255g = zVar;
        this.f11257i = zVar;
    }

    public Set<B> A(InterfaceC0898v interfaceC0898v) {
        return null;
    }

    public Set<Integer> B() {
        return Collections.EMPTY_SET;
    }

    @SuppressLint({"WrongConstant"})
    public int C() {
        return ((s) this.f11257i).I(0);
    }

    public abstract z.b<?, ?, ?> D(Config config);

    public Rect E() {
        return this.f11260l;
    }

    public boolean F() {
        return false;
    }

    public boolean G(int i10) {
        Iterator<Integer> it = B().iterator();
        while (it.hasNext()) {
            if (Y.c(i10, it.next().intValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean H(CameraInternal cameraInternal) {
        int iQ = q();
        if (iQ == -1 || iQ == 0) {
            return false;
        }
        if (iQ == 1) {
            return true;
        }
        if (iQ == 2) {
            return cameraInternal.j();
        }
        throw new AssertionError("Unknown mirrorMode: " + iQ);
    }

    public z<?> I(InterfaceC0898v interfaceC0898v, z<?> zVar, z<?> zVar2) {
        u uVarK0;
        if (zVar2 != null) {
            uVarK0 = u.l0(zVar2);
            uVarK0.m0(P.m.f5353b);
        } else {
            uVarK0 = u.k0();
        }
        if (this.f11255g.b(s.f11486q) || this.f11255g.b(s.f11490u)) {
            Config.a<X.c> aVar = s.f11494y;
            if (uVarK0.b(aVar)) {
                uVarK0.m0(aVar);
            }
        }
        z<?> zVar3 = this.f11255g;
        Config.a<X.c> aVar2 = s.f11494y;
        if (zVar3.b(aVar2)) {
            Config.a<Size> aVar3 = s.f11492w;
            if (uVarK0.b(aVar3) && ((X.c) this.f11255g.a(aVar2)).d() != null) {
                uVarK0.m0(aVar3);
            }
        }
        Iterator<Config.a<?>> it = this.f11255g.e().iterator();
        while (it.hasNext()) {
            Config.J(uVarK0, uVarK0, this.f11255g, it.next());
        }
        if (zVar != null) {
            for (Config.a<?> aVar4 : zVar.e()) {
                if (!aVar4.c().equals(P.m.f5353b.c())) {
                    Config.J(uVarK0, uVarK0, zVar, aVar4);
                }
            }
        }
        if (uVarK0.b(s.f11490u)) {
            Config.a<Integer> aVar5 = s.f11486q;
            if (uVarK0.b(aVar5)) {
                uVarK0.m0(aVar5);
            }
        }
        Config.a<X.c> aVar6 = s.f11494y;
        if (uVarK0.b(aVar6) && ((X.c) uVarK0.a(aVar6)).a() != 0) {
            uVarK0.t(z.f11549J, Boolean.TRUE);
        }
        c(uVarK0);
        return P(interfaceC0898v, D(uVarK0));
    }

    public final void J() {
        this.f11253e = State.ACTIVE;
        M();
    }

    public final void K() {
        this.f11253e = State.INACTIVE;
        M();
    }

    public final void L() {
        Iterator<b> it = this.f11250b.iterator();
        while (it.hasNext()) {
            it.next().k(this);
        }
    }

    public final void M() {
        int iOrdinal = this.f11253e.ordinal();
        if (iOrdinal == 0) {
            Iterator<b> it = this.f11250b.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        } else {
            if (iOrdinal != 1) {
                return;
            }
            Iterator<b> it2 = this.f11250b.iterator();
            while (it2.hasNext()) {
                it2.next().l(this);
            }
        }
    }

    public void N() {
    }

    public void O() {
    }

    public z<?> P(InterfaceC0898v interfaceC0898v, z.b<?, ?, ?> bVar) {
        return bVar.d();
    }

    public void Q(int i10) {
        b0(i10);
    }

    public void R() {
        this.f11249a = true;
    }

    public void S() {
        this.f11249a = false;
    }

    public y T(Config config) {
        y yVar = this.f11258j;
        if (yVar != null) {
            return yVar.i().d(config).a();
        }
        throw new UnsupportedOperationException("Attempt to update the implementation options for a use case without attached stream specifications.");
    }

    public y U(y yVar, y yVar2) {
        return yVar;
    }

    public void V() {
    }

    public final void W(b bVar) {
        this.f11250b.remove(bVar);
    }

    public void X(AbstractC0772i abstractC0772i) {
        B0.h.a(abstractC0772i == null || G(abstractC0772i.g()));
        this.f11264p = abstractC0772i;
    }

    public void Y(Set<F.b> set) {
        this.f11256h = set != null ? new HashSet(set) : null;
    }

    public void Z(l lVar) {
        synchronized (this.f11252d) {
            this.f11266r = lVar;
        }
    }

    public final void a(b bVar) {
        this.f11250b.add(bVar);
    }

    public void a0(Matrix matrix) {
        this.f11261m = new Matrix(matrix);
    }

    public void b(SessionConfig.b bVar, y yVar) {
        if (!y.f11539a.equals(yVar.c())) {
            bVar.r(yVar.c());
            return;
        }
        synchronized (this.f11251c) {
            try {
                List listC = ((CameraInternal) B0.h.f(this.f11262n)).i().s().c(AeFpsRangeQuirk.class);
                boolean z10 = true;
                if (listC.size() > 1) {
                    z10 = false;
                }
                B0.h.b(z10, "There should not have more than one AeFpsRangeQuirk.");
                if (!listC.isEmpty()) {
                    bVar.r(((AeFpsRangeQuirk) listC.get(0)).a());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b0(int i10) {
        int I10 = ((s) l()).I(-1);
        if (I10 != -1 && I10 == i10) {
            return false;
        }
        z.b<?, ?, ?> bVarD = D(this.f11255g);
        T.d.a(bVarD, i10);
        this.f11255g = bVarD.d();
        CameraInternal cameraInternalI = i();
        if (cameraInternalI == null) {
            this.f11257i = this.f11255g;
            return true;
        }
        this.f11257i = I(cameraInternalI.i(), this.f11254f, this.f11259k);
        return true;
    }

    public final void c(u uVar) {
        C0761b0.a("UseCase", "applyFeaturesToConfig: mFeatureGroup = " + this.f11256h + ", this = " + this);
        Set<F.b> set = this.f11256h;
        if (set == null) {
            return;
        }
        B bF = DynamicRangeFeature.f2904j;
        Range<Integer> range = y.f11539a;
        VideoStabilization videoStabilizationF = VideoStabilizationFeature.f2916j;
        for (F.b bVar : set) {
            if (bVar instanceof DynamicRangeFeature) {
                bF = ((DynamicRangeFeature) bVar).getDynamicRange();
            } else if (bVar instanceof FpsRangeFeature) {
                FpsRangeFeature bVar2 = (FpsRangeFeature) bVar;
                range = new Range<>(Integer.valueOf(bVar2.getMinFps()), Integer.valueOf(bVar2.getMaxFps()));
            } else if (bVar instanceof VideoStabilizationFeature) {
                videoStabilizationF = ((VideoStabilizationFeature) bVar).getVideoStabilization();
            }
        }
        if ((this instanceof i0) || q.h(this)) {
            uVar.t(r.f11485p, bF);
        }
        uVar.t(z.f11546G, range);
        int i10 = a.f11270a[videoStabilizationF.ordinal()];
        if (i10 == 1) {
            uVar.t(z.f11552M, 0);
            uVar.t(z.f11553N, 0);
            return;
        }
        if (i10 == 2) {
            uVar.t(z.f11552M, 1);
            uVar.t(z.f11553N, 1);
        } else if (i10 == 3) {
            uVar.t(z.f11552M, 0);
            uVar.t(z.f11553N, 2);
        } else {
            if (i10 != 4) {
                return;
            }
            uVar.t(z.f11552M, 2);
            uVar.t(z.f11553N, 0);
        }
    }

    public void c0(Rect rect) {
        this.f11260l = rect;
    }

    @SuppressLint({"WrongConstant"})
    public final void d(CameraInternal cameraInternal, CameraInternal cameraInternal2, z<?> zVar, z<?> zVar2) {
        synchronized (this.f11251c) {
            try {
                this.f11262n = cameraInternal;
                this.f11263o = cameraInternal2;
                a(cameraInternal);
                if (cameraInternal2 != null) {
                    a(cameraInternal2);
                }
            } finally {
            }
        }
        this.f11254f = zVar;
        this.f11259k = zVar2;
        this.f11257i = I(cameraInternal.i(), this.f11254f, this.f11259k);
        synchronized (this.f11252d) {
            try {
                l lVar = this.f11266r;
                if (lVar != null) {
                    lVar.c(N.a.d(), this.f11267s);
                }
            } finally {
            }
        }
        N();
    }

    public final void d0(CameraInternal cameraInternal) {
        V();
        synchronized (this.f11251c) {
            try {
                CameraInternal cameraInternal2 = this.f11262n;
                if (cameraInternal == cameraInternal2) {
                    W(cameraInternal2);
                    this.f11262n = null;
                }
                CameraInternal cameraInternal3 = this.f11263o;
                if (cameraInternal == cameraInternal3) {
                    W(cameraInternal3);
                    this.f11263o = null;
                }
            } finally {
            }
        }
        synchronized (this.f11252d) {
            try {
                l lVar = this.f11266r;
                if (lVar != null) {
                    lVar.e(this.f11267s);
                }
            } finally {
            }
        }
        this.f11258j = null;
        this.f11260l = null;
        this.f11257i = this.f11255g;
        this.f11254f = null;
        this.f11259k = null;
    }

    public z<?> e() {
        return this.f11255g;
    }

    public void e0(List<SessionConfig> list) {
        if (list.isEmpty()) {
            return;
        }
        this.f11268t = list.get(0);
        if (list.size() > 1) {
            this.f11269u = list.get(1);
        }
        Iterator<SessionConfig> it = list.iterator();
        while (it.hasNext()) {
            for (DeferrableSurface deferrableSurface : it.next().p()) {
                if (deferrableSurface.g() == null) {
                    deferrableSurface.p(getClass());
                }
            }
        }
    }

    public int f() {
        return ((s) this.f11257i).v(-1);
    }

    public void f0(y yVar, y yVar2) {
        this.f11258j = U(yVar, yVar2);
    }

    public y g() {
        return this.f11258j;
    }

    public void g0(Config config) {
        this.f11258j = T(config);
    }

    public Size h() {
        y yVar = this.f11258j;
        if (yVar != null) {
            return yVar.f();
        }
        return null;
    }

    public CameraInternal i() {
        CameraInternal cameraInternal;
        synchronized (this.f11251c) {
            cameraInternal = this.f11262n;
        }
        return cameraInternal;
    }

    public androidx.camera.core.impl.h j() {
        synchronized (this.f11251c) {
            try {
                CameraInternal cameraInternal = this.f11262n;
                if (cameraInternal == null) {
                    return androidx.camera.core.impl.h.f11423a;
                }
                return cameraInternal.d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String k() {
        return ((CameraInternal) B0.h.g(i(), "No camera attached to use case: " + this)).i().h();
    }

    public z<?> l() {
        return this.f11257i;
    }

    public abstract z<?> m(boolean z10, UseCaseConfigFactory useCaseConfigFactory);

    public AbstractC0772i n() {
        return this.f11264p;
    }

    public Set<F.b> o() {
        return this.f11256h;
    }

    public int p() {
        return this.f11257i.o();
    }

    public int q() {
        return ((s) this.f11257i).g0(-1);
    }

    public String r() {
        String strW = this.f11257i.w("<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(strW);
        return strW;
    }

    public String s() {
        return this.f11265q;
    }

    public int t(CameraInternal cameraInternal) {
        return u(cameraInternal, false);
    }

    public int u(CameraInternal cameraInternal, boolean z10) {
        int iZ = cameraInternal.i().z(C());
        return (cameraInternal.p() || !z10) ? iZ : o.u(-iZ);
    }

    public CameraInternal v() {
        CameraInternal cameraInternal;
        synchronized (this.f11251c) {
            cameraInternal = this.f11263o;
        }
        return cameraInternal;
    }

    public String w() {
        if (v() == null) {
            return null;
        }
        return v().i().h();
    }

    public SessionConfig x() {
        return this.f11269u;
    }

    public Matrix y() {
        return this.f11261m;
    }

    public SessionConfig z() {
        return this.f11268t;
    }
}
