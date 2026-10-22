package Y;

import D.B;
import D.C0761b0;
import D.i0;
import K.AbstractC0889l;
import K.InterfaceC0891n;
import U.M;
import Y.f;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class j implements UseCase.b {

    /* renamed from: a, reason: collision with root package name */
    public final Set<UseCase> f6965a;

    /* renamed from: e, reason: collision with root package name */
    public final UseCaseConfigFactory f6969e;

    /* renamed from: f, reason: collision with root package name */
    public final CameraInternal f6970f;

    /* renamed from: g, reason: collision with root package name */
    public final CameraInternal f6971g;

    /* renamed from: i, reason: collision with root package name */
    public final Set<z<?>> f6973i;

    /* renamed from: j, reason: collision with root package name */
    public final Map<UseCase, z<?>> f6974j;

    /* renamed from: k, reason: collision with root package name */
    public final c f6975k;

    /* renamed from: l, reason: collision with root package name */
    public c f6976l;

    /* renamed from: b, reason: collision with root package name */
    public final Map<UseCase, M> f6966b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map<UseCase, i> f6967c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Map<UseCase, Boolean> f6968d = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final AbstractC0889l f6972h = t();

    public static class a extends AbstractC0889l {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<j> f6977a;

        public a(j jVar) {
            this.f6977a = new WeakReference<>(jVar);
        }

        @Override // K.AbstractC0889l
        public void b(int i10, InterfaceC0891n interfaceC0891n) {
            j jVar = this.f6977a.get();
            if (jVar != null) {
                Iterator<UseCase> it = jVar.f6965a.iterator();
                while (it.hasNext()) {
                    j.Q(interfaceC0891n, it.next().z(), i10);
                }
            }
        }
    }

    public j(CameraInternal cameraInternal, CameraInternal cameraInternal2, Set<UseCase> set, UseCaseConfigFactory useCaseConfigFactory, f.a aVar) {
        this.f6970f = cameraInternal;
        this.f6971g = cameraInternal2;
        this.f6969e = useCaseConfigFactory;
        this.f6965a = set;
        Map<UseCase, z<?>> mapS = S(cameraInternal, set, useCaseConfigFactory);
        this.f6974j = mapS;
        HashSet hashSet = new HashSet(mapS.values());
        this.f6973i = hashSet;
        this.f6975k = new c(cameraInternal, hashSet);
        if (cameraInternal2 != null) {
            this.f6976l = new c(cameraInternal2, hashSet);
        }
        for (UseCase useCase : set) {
            this.f6968d.put(useCase, Boolean.FALSE);
            this.f6967c.put(useCase, new i(cameraInternal, this, aVar));
        }
    }

    public static int A(UseCase useCase) {
        if (useCase instanceof i0) {
            return 1;
        }
        return useCase instanceof ImageCapture ? 4 : 2;
    }

    public static int E(Set<z<?>> set) {
        Iterator<z<?>> it = set.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().D(0));
        }
        return iMax;
    }

    public static Range<Integer> P(Set<z<?>> set) {
        Range<Integer> rangeIntersect = y.f11539a;
        Iterator<z<?>> it = set.iterator();
        while (it.hasNext()) {
            Range<Integer> rangeA = it.next().A(rangeIntersect);
            Objects.requireNonNull(rangeA);
            if (y.f11539a.equals(rangeIntersect)) {
                rangeIntersect = rangeA;
            } else {
                try {
                    rangeIntersect = rangeIntersect.intersect(rangeA);
                } catch (IllegalArgumentException unused) {
                    C0761b0.a("VirtualCameraAdapter", "No intersected frame rate can be found from the target frame rate settings of the UseCases! Resolved: " + rangeIntersect + " <<>> " + rangeA);
                    return rangeIntersect.extend(rangeA);
                }
            }
        }
        return rangeIntersect;
    }

    public static void Q(InterfaceC0891n interfaceC0891n, SessionConfig sessionConfig, int i10) {
        Iterator<AbstractC0889l> it = sessionConfig.k().iterator();
        while (it.hasNext()) {
            it.next().b(i10, new k(sessionConfig.l().i(), interfaceC0891n));
        }
    }

    public static Map<UseCase, z<?>> S(CameraInternal cameraInternal, Set<UseCase> set, UseCaseConfigFactory useCaseConfigFactory) {
        HashMap map = new HashMap();
        for (UseCase useCase : set) {
            map.put(useCase, useCase.I(cameraInternal.getCameraInfo(), null, useCase.m(true, useCaseConfigFactory)));
        }
        return map;
    }

    public static void u(M m10, DeferrableSurface deferrableSurface, SessionConfig sessionConfig) {
        m10.v();
        try {
            m10.y(deferrableSurface);
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            if (sessionConfig.d() != null) {
                sessionConfig.d().a(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
        }
    }

    public static int v(UseCase useCase) {
        return useCase instanceof ImageCapture ? 256 : 34;
    }

    public static y y(UseCase useCase, y yVar, Map<UseCase, Size> map) {
        y.a aVarI = yVar.i();
        Size size = map.get(useCase);
        if (size != null) {
            aVarI.e(size);
        }
        return aVarI.a();
    }

    public static DeferrableSurface z(UseCase useCase) {
        List<DeferrableSurface> listP = useCase instanceof ImageCapture ? useCase.z().p() : useCase.z().l().h();
        B0.h.h(listP.size() <= 1);
        if (listP.size() == 1) {
            return listP.get(0);
        }
        return null;
    }

    public Set<UseCase> B() {
        return this.f6965a;
    }

    public Map<UseCase, W.e> C(M m10, int i10, boolean z10, boolean z11) {
        HashMap map = new HashMap();
        for (UseCase useCase : this.f6965a) {
            j jVar = this;
            W.e eVarS = jVar.s(useCase, this.f6975k, this.f6970f, m10, i10, z10, z11);
            jVar.U(useCase);
            map.put(useCase, eVarS);
            this = jVar;
        }
        return map;
    }

    public Map<UseCase, V.c> D(M m10, M m11, int i10, boolean z10) {
        HashMap map = new HashMap();
        for (UseCase useCase : this.f6965a) {
            j jVar = this;
            int i11 = i10;
            W.e eVarS = jVar.s(useCase, this.f6975k, this.f6970f, m10, i11, z10, false);
            c cVar = jVar.f6976l;
            Objects.requireNonNull(cVar);
            CameraInternal cameraInternal = jVar.f6971g;
            Objects.requireNonNull(cameraInternal);
            M m12 = m11;
            W.e eVarS2 = jVar.s(useCase, cVar, cameraInternal, m12, i11, z10, false);
            jVar.U(useCase);
            map.put(useCase, V.c.c(eVarS, eVarS2));
            this = jVar;
            m11 = m12;
            i10 = i11;
        }
        return map;
    }

    public AbstractC0889l F() {
        return this.f6972h;
    }

    public final i0 G() {
        for (UseCase useCase : this.f6965a) {
            if (useCase instanceof i0) {
                return (i0) useCase;
            }
        }
        return null;
    }

    public Map<UseCase, Size> H(M m10, boolean z10) {
        HashMap map = new HashMap();
        for (UseCase useCase : this.f6965a) {
            c cVar = this.f6975k;
            z<?> zVar = this.f6974j.get(useCase);
            Objects.requireNonNull(zVar);
            PreferredChildSize preferredChildSizeQ = cVar.q(zVar, m10.n(), M.o.f(m10.r()), z10);
            map.put(useCase, preferredChildSizeQ.getOriginalSelectedChildSize());
            C0761b0.a("VirtualCameraAdapter", "Selected child size: " + preferredChildSizeQ.getOriginalSelectedChildSize() + ", useCase: " + useCase);
        }
        return map;
    }

    public final M I(UseCase useCase) {
        M m10 = this.f6966b.get(useCase);
        Objects.requireNonNull(m10);
        return m10;
    }

    public final boolean J(UseCase useCase) {
        Boolean bool = this.f6968d.get(useCase);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    public void K(t tVar) {
        tVar.t(s.f11495z, this.f6975k.o(tVar));
        tVar.t(z.f11544E, Integer.valueOf(E(this.f6973i)));
        B bD = Y.a.d(this.f6973i);
        if (bD == null) {
            throw new IllegalArgumentException("Failed to merge child dynamic ranges, can not find a dynamic range that satisfies all children.");
        }
        tVar.t(r.f11485p, bD);
        tVar.t(z.f11546G, P(this.f6973i));
        Iterator<UseCase> it = this.f6965a.iterator();
        while (it.hasNext()) {
            z<?> zVar = this.f6974j.get(it.next());
            Objects.requireNonNull(zVar);
            z<?> zVar2 = zVar;
            if (zVar2.z() != 0) {
                tVar.t(z.f11553N, Integer.valueOf(zVar2.z()));
            }
            if (zVar2.F() != 0) {
                tVar.t(z.f11552M, Integer.valueOf(zVar2.F()));
            }
        }
    }

    public void L() {
        Iterator<UseCase> it = this.f6965a.iterator();
        while (it.hasNext()) {
            it.next().O();
        }
    }

    public void M() {
        Iterator<UseCase> it = this.f6965a.iterator();
        while (it.hasNext()) {
            it.next().R();
        }
    }

    public void N() {
        Iterator<UseCase> it = this.f6965a.iterator();
        while (it.hasNext()) {
            it.next().S();
        }
    }

    public void O() {
        M.n.b();
        Iterator<UseCase> it = this.f6965a.iterator();
        while (it.hasNext()) {
            k(it.next());
        }
    }

    public void R(Map<UseCase, M> map, Map<UseCase, Size> map2) {
        this.f6966b.clear();
        this.f6966b.putAll(map);
        for (Map.Entry<UseCase, M> entry : this.f6966b.entrySet()) {
            UseCase key = entry.getKey();
            M value = entry.getValue();
            key.c0(value.n());
            key.a0(value.r());
            key.f0(y(key, value.s(), map2), null);
            key.M();
        }
    }

    public void T() {
        for (UseCase useCase : this.f6965a) {
            i iVar = this.f6967c.get(useCase);
            Objects.requireNonNull(iVar);
            useCase.d0(iVar);
        }
    }

    public final void U(UseCase useCase) {
        int iX = x(useCase, this.f6970f);
        i iVar = this.f6967c.get(useCase);
        Objects.requireNonNull(iVar);
        iVar.r(iX);
    }

    @Override // androidx.camera.core.UseCase.b
    public void b(UseCase useCase) {
        M.n.b();
        if (J(useCase)) {
            return;
        }
        this.f6968d.put(useCase, Boolean.TRUE);
        DeferrableSurface deferrableSurfaceZ = z(useCase);
        if (deferrableSurfaceZ != null) {
            u(I(useCase), deferrableSurfaceZ, useCase.z());
        }
    }

    @Override // androidx.camera.core.UseCase.b
    public void c(UseCase useCase) {
        M.n.b();
        if (J(useCase)) {
            M mI = I(useCase);
            DeferrableSurface deferrableSurfaceZ = z(useCase);
            if (deferrableSurfaceZ != null) {
                u(mI, deferrableSurfaceZ, useCase.z());
            } else {
                mI.m();
            }
        }
    }

    @Override // androidx.camera.core.UseCase.b
    public void k(UseCase useCase) {
        DeferrableSurface deferrableSurfaceZ;
        M.n.b();
        M mI = I(useCase);
        if (J(useCase) && (deferrableSurfaceZ = z(useCase)) != null) {
            u(mI, deferrableSurfaceZ, useCase.z());
        }
    }

    @Override // androidx.camera.core.UseCase.b
    public void l(UseCase useCase) {
        M.n.b();
        if (J(useCase)) {
            this.f6968d.put(useCase, Boolean.FALSE);
            I(useCase).m();
        }
    }

    public void r() {
        for (UseCase useCase : this.f6965a) {
            i iVar = this.f6967c.get(useCase);
            Objects.requireNonNull(iVar);
            useCase.d(iVar, null, null, useCase.m(true, this.f6969e));
        }
    }

    public final W.e s(UseCase useCase, c cVar, CameraInternal cameraInternal, M m10, int i10, boolean z10, boolean z11) {
        int iZ = cameraInternal.a().z(i10);
        boolean zK = M.o.k(m10.r());
        z<?> zVar = this.f6974j.get(useCase);
        Objects.requireNonNull(zVar);
        PreferredChildSize preferredChildSizeQ = cVar.q(zVar, m10.n(), M.o.f(m10.r()), z10);
        Rect cropRectBeforeScaling = preferredChildSizeQ.getCropRectBeforeScaling();
        Size childSizeToScale = preferredChildSizeQ.getChildSizeToScale();
        int iU = M.o.u((m10.q() + x(useCase, cameraInternal)) - iZ);
        return W.e.h(A(useCase), v(useCase), cropRectBeforeScaling, M.o.o(childSizeToScale, iU), iU, z11 ? false : useCase.H(cameraInternal) ^ zK);
    }

    public AbstractC0889l t() {
        return new a(this);
    }

    public V.c w(M m10, M m11, int i10, boolean z10) {
        i0 i0Var = (i0) B0.h.f(G());
        return V.c.c(s(i0Var, this.f6975k, this.f6970f, m10, i10, z10, false), s(i0Var, this.f6975k, this.f6971g, m11, i10, z10, false));
    }

    public final int x(UseCase useCase, CameraInternal cameraInternal) {
        return cameraInternal.a().z(((s) useCase.l()).I(0));
    }
}
