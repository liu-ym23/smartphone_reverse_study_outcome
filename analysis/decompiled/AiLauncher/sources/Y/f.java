package Y;

import D.A;
import D.AbstractC0772i;
import D.B;
import D.C0761b0;
import K.InterfaceC0898v;
import U.C1037s;
import U.M;
import V.n;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;
import android.util.Size;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode;
import g3.InterfaceFutureC4095a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class f extends UseCase {

    /* renamed from: A, reason: collision with root package name */
    public SurfaceProcessorNode f6941A;

    /* renamed from: B, reason: collision with root package name */
    public DualSurfaceProcessorNode f6942B;

    /* renamed from: C, reason: collision with root package name */
    public SurfaceProcessorNode f6943C;

    /* renamed from: D, reason: collision with root package name */
    public M f6944D;

    /* renamed from: E, reason: collision with root package name */
    public M f6945E;

    /* renamed from: F, reason: collision with root package name */
    public M f6946F;

    /* renamed from: G, reason: collision with root package name */
    public M f6947G;

    /* renamed from: H, reason: collision with root package name */
    public M f6948H;

    /* renamed from: I, reason: collision with root package name */
    public M f6949I;

    /* renamed from: J, reason: collision with root package name */
    public SessionConfig.b f6950J;

    /* renamed from: K, reason: collision with root package name */
    public SessionConfig.b f6951K;

    /* renamed from: L, reason: collision with root package name */
    public SessionConfig.c f6952L;

    /* renamed from: v, reason: collision with root package name */
    public final h f6953v;

    /* renamed from: w, reason: collision with root package name */
    public final j f6954w;

    /* renamed from: x, reason: collision with root package name */
    public final A f6955x;

    /* renamed from: y, reason: collision with root package name */
    public final A f6956y;

    /* renamed from: z, reason: collision with root package name */
    public SurfaceProcessorNode f6957z;

    public interface a {
        InterfaceFutureC4095a<Void> a(int i10, int i11);
    }

    public f(CameraInternal cameraInternal, CameraInternal cameraInternal2, A a10, A a11, Set<UseCase> set, UseCaseConfigFactory useCaseConfigFactory) {
        super(w0(set));
        this.f6953v = w0(set);
        this.f6955x = a10;
        this.f6956y = a11;
        this.f6954w = new j(cameraInternal, cameraInternal2, set, useCaseConfigFactory, new a() { // from class: Y.e
            @Override // Y.f.a
            public final InterfaceFutureC4095a a(int i10, int i11) {
                return f.i0(this.f6940a, i10, i11);
            }
        });
        G0(set);
    }

    public static boolean B0(UseCase useCase) {
        return useCase instanceof f;
    }

    public static /* synthetic */ void h0(f fVar, String str, String str2, z zVar, y yVar, y yVar2, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (fVar.i() == null) {
            return;
        }
        fVar.k0();
        fVar.e0(fVar.n0(str, str2, zVar, yVar, yVar2));
        fVar.L();
        fVar.f6954w.O();
    }

    public static /* synthetic */ InterfaceFutureC4095a i0(f fVar, int i10, int i11) {
        SurfaceProcessorNode surfaceProcessorNode = fVar.f6941A;
        return surfaceProcessorNode != null ? surfaceProcessorNode.e().b(i10, i11) : O.f.f(new Exception("Failed to take picture: pipeline is not ready."));
    }

    private void k0() {
        SessionConfig.c cVar = this.f6952L;
        if (cVar != null) {
            cVar.b();
            this.f6952L = null;
        }
        M m10 = this.f6944D;
        if (m10 != null) {
            m10.i();
            this.f6944D = null;
        }
        M m11 = this.f6945E;
        if (m11 != null) {
            m11.i();
            this.f6945E = null;
        }
        M m12 = this.f6946F;
        if (m12 != null) {
            m12.i();
            this.f6946F = null;
        }
        M m13 = this.f6947G;
        if (m13 != null) {
            m13.i();
            this.f6947G = null;
        }
        M m14 = this.f6948H;
        if (m14 != null) {
            m14.i();
            this.f6948H = null;
        }
        M m15 = this.f6949I;
        if (m15 != null) {
            m15.i();
            this.f6949I = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.f6941A;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.f();
            this.f6941A = null;
        }
        DualSurfaceProcessorNode dualSurfaceProcessorNode = this.f6942B;
        if (dualSurfaceProcessorNode != null) {
            dualSurfaceProcessorNode.d();
            this.f6942B = null;
        }
        SurfaceProcessorNode surfaceProcessorNode2 = this.f6957z;
        if (surfaceProcessorNode2 != null) {
            surfaceProcessorNode2.f();
            this.f6957z = null;
        }
        SurfaceProcessorNode surfaceProcessorNode3 = this.f6943C;
        if (surfaceProcessorNode3 != null) {
            surfaceProcessorNode3.f();
            this.f6943C = null;
        }
    }

    public static List<UseCaseConfigFactory.CaptureType> r0(UseCase useCase) {
        ArrayList arrayList = new ArrayList();
        if (!B0(useCase)) {
            arrayList.add(useCase.l().V());
            return arrayList;
        }
        Iterator<UseCase> it = ((f) useCase).t0().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().l().V());
        }
        return arrayList;
    }

    public static int s0(UseCase useCase) {
        return useCase.l().P().q();
    }

    private Rect u0(Size size) {
        return E() != null ? E() : new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    public static h w0(Set<UseCase> set) {
        t tVarA = new g().a();
        tVarA.t(r.f11483n, 34);
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : set) {
            if (useCase.l().b(z.f11551L)) {
                arrayList.add(useCase.l().V());
            } else {
                Log.e("StreamSharing", "A child does not have capture type.");
            }
        }
        tVarA.t(h.f6959S, arrayList);
        tVarA.t(s.f11489t, 2);
        tVarA.t(z.f11556Q, StreamUseCase.PREVIEW_VIDEO_STILL);
        return new h(v.j0(tVarA));
    }

    @Override // androidx.camera.core.UseCase
    public Set<B> A(InterfaceC0898v interfaceC0898v) {
        Set<UseCase> setT0 = t0();
        HashSet hashSet = null;
        if (setT0.isEmpty()) {
            return null;
        }
        Iterator<UseCase> it = setT0.iterator();
        while (it.hasNext()) {
            Set<B> setA = it.next().A(interfaceC0898v);
            if (setA != null) {
                if (hashSet == null) {
                    hashSet = new HashSet(setA);
                } else {
                    hashSet.retainAll(setA);
                }
            }
        }
        return hashSet;
    }

    public final M A0(M m10, CameraInternal cameraInternal, boolean z10) {
        return (n() == null || n().h() == 2 || z10 || n().e() == 1) ? m10 : x0(m10, cameraInternal);
    }

    @Override // androidx.camera.core.UseCase
    public Set<Integer> B() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    public final void C0(Size size, SessionConfig.b bVar) {
        Iterator<UseCase> it = t0().iterator();
        while (it.hasNext()) {
            SessionConfig sessionConfigO = SessionConfig.b.p(it.next().l(), size).o();
            bVar.c(sessionConfigO.k());
            bVar.a(sessionConfigO.o());
            bVar.d(sessionConfigO.m());
            bVar.b(sessionConfigO.c());
            bVar.g(sessionConfigO.g());
        }
    }

    @Override // androidx.camera.core.UseCase
    public z.b<?, ?, ?> D(Config config) {
        return new g(u.l0(config));
    }

    public final void D0(SessionConfig.b bVar) {
        Iterator<UseCase> it = t0().iterator();
        int iF = -1;
        while (it.hasNext()) {
            iF = SessionConfig.f(iF, s0(it.next()));
        }
        if (iF != -1) {
            bVar.x(iF);
        }
    }

    public final void E0(M m10, SurfaceProcessorNode surfaceProcessorNode, boolean z10) throws ProcessingException {
        boolean z11 = E() != null;
        Map<UseCase, W.e> mapC = this.f6954w.C(m10, C(), z11, z10);
        SurfaceProcessorNode.Out outJ = surfaceProcessorNode.j(SurfaceProcessorNode.b.c(m10, new ArrayList(mapC.values())));
        HashMap map = new HashMap();
        for (Map.Entry<UseCase, W.e> entry : mapC.entrySet()) {
            map.put(entry.getKey(), outJ.get(entry.getValue()));
        }
        this.f6954w.R(map, this.f6954w.H(m10, z11));
    }

    public final void F0(M m10, M m11, DualSurfaceProcessorNode dualSurfaceProcessorNode, y yVar) throws ProcessingException {
        if (n() == null) {
            boolean z10 = E() != null;
            Map<UseCase, V.c> mapD = this.f6954w.D(m10, m11, C(), z10);
            DualSurfaceProcessorNode.Out outG = this.f6942B.g(DualSurfaceProcessorNode.b.d(m10, m11, new ArrayList(mapD.values())));
            HashMap map = new HashMap();
            for (Map.Entry<UseCase, V.c> entry : mapD.entrySet()) {
                map.put(entry.getKey(), outG.get(entry.getValue()));
            }
            this.f6954w.R(map, this.f6954w.H(m10, z10));
            return;
        }
        this.f6948H = dualSurfaceProcessorNode.g(DualSurfaceProcessorNode.b.d(m10, m11, Arrays.asList(this.f6954w.w(m10, m11, C(), E() != null)))).values().iterator().next();
        if (n().e() == 1) {
            this.f6949I = this.f6948H;
        } else {
            M m12 = this.f6948H;
            Objects.requireNonNull(m12);
            CameraInternal cameraInternalI = i();
            Objects.requireNonNull(cameraInternalI);
            this.f6949I = x0(m12, cameraInternalI);
        }
        CameraInternal cameraInternalI2 = i();
        Objects.requireNonNull(cameraInternalI2);
        SurfaceProcessorNode surfaceProcessorNodeM0 = m0(cameraInternalI2, yVar);
        this.f6943C = surfaceProcessorNodeM0;
        E0(this.f6949I, surfaceProcessorNodeM0, true);
    }

    public void G0(Set<UseCase> set) {
        Y(set.iterator().next().o());
    }

    @Override // androidx.camera.core.UseCase
    public void N() {
        super.N();
        this.f6954w.r();
    }

    @Override // androidx.camera.core.UseCase
    public void O() {
        super.O();
        this.f6954w.L();
    }

    @Override // androidx.camera.core.UseCase
    public z<?> P(InterfaceC0898v interfaceC0898v, z.b<?, ?, ?> bVar) {
        this.f6954w.K(bVar.a());
        return bVar.d();
    }

    @Override // androidx.camera.core.UseCase
    public void R() {
        super.R();
        this.f6954w.M();
    }

    @Override // androidx.camera.core.UseCase
    public void S() {
        super.S();
        this.f6954w.N();
    }

    @Override // androidx.camera.core.UseCase
    public y T(Config config) {
        this.f6950J.g(config);
        e0(List.of(this.f6950J.o()));
        return g().i().d(config).a();
    }

    @Override // androidx.camera.core.UseCase
    public y U(y yVar, y yVar2) {
        C0761b0.a("StreamSharing", "onSuggestedStreamSpecUpdated: primaryStreamSpec = " + yVar + ", secondaryStreamSpec " + yVar2);
        e0(n0(k(), w(), l(), yVar, yVar2));
        J();
        return yVar;
    }

    @Override // androidx.camera.core.UseCase
    public void V() {
        super.V();
        k0();
        this.f6954w.T();
    }

    public final void j0(SessionConfig.b bVar, final String str, final String str2, final z<?> zVar, final y yVar, final y yVar2) {
        SessionConfig.c cVar = this.f6952L;
        if (cVar != null) {
            cVar.b();
        }
        SessionConfig.c cVar2 = new SessionConfig.c(new SessionConfig.d() { // from class: Y.d
            @Override // androidx.camera.core.impl.SessionConfig.d
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                f.h0(this.f6934a, str, str2, zVar, yVar, yVar2, sessionConfig, sessionError);
            }
        });
        this.f6952L = cVar2;
        bVar.q(cVar2);
    }

    public final DualSurfaceProcessorNode l0(CameraInternal cameraInternal, CameraInternal cameraInternal2, y yVar, A a10, A a11) {
        return new DualSurfaceProcessorNode(cameraInternal, cameraInternal2, n.a.a(yVar.b(), a10, a11), "StreamSharing");
    }

    @Override // androidx.camera.core.UseCase
    public z<?> m(boolean z10, UseCaseConfigFactory useCaseConfigFactory) {
        Config configA = useCaseConfigFactory.a(this.f6953v.V(), 1);
        if (z10) {
            configA = Config.X(configA, this.f6953v.getConfig());
        }
        if (configA == null) {
            return null;
        }
        return D(configA).d();
    }

    public final SurfaceProcessorNode m0(CameraInternal cameraInternal, y yVar) {
        if (n() == null || n().e() != 1) {
            return new SurfaceProcessorNode(cameraInternal, C1037s.a.a(yVar.b()), "StreamSharing");
        }
        SurfaceProcessorNode surfaceProcessorNode = new SurfaceProcessorNode(cameraInternal, n().a(), "StreamSharing");
        this.f6957z = surfaceProcessorNode;
        return surfaceProcessorNode;
    }

    public final List<SessionConfig> n0(String str, String str2, z<?> zVar, y yVar, y yVar2) throws ProcessingException {
        M.n.b();
        if (yVar2 != null) {
            M mO0 = o0(str, str2, zVar, yVar, yVar2);
            M mP0 = p0(str, str2, zVar, yVar, yVar2);
            DualSurfaceProcessorNode dualSurfaceProcessorNodeL0 = l0(i(), v(), yVar, this.f6955x, this.f6956y);
            this.f6942B = dualSurfaceProcessorNodeL0;
            F0(mO0, mP0, dualSurfaceProcessorNodeL0, yVar);
            return List.of(this.f6950J.o(), this.f6951K.o());
        }
        M mO02 = o0(str, str2, zVar, yVar, null);
        CameraInternal cameraInternalI = i();
        Objects.requireNonNull(cameraInternalI);
        SurfaceProcessorNode surfaceProcessorNodeM0 = m0(cameraInternalI, yVar);
        this.f6941A = surfaceProcessorNodeM0;
        E0(mO02, surfaceProcessorNodeM0, false);
        return List.of(this.f6950J.o());
    }

    public final M o0(String str, String str2, z<?> zVar, y yVar, y yVar2) {
        Matrix matrixY = y();
        CameraInternal cameraInternalI = i();
        Objects.requireNonNull(cameraInternalI);
        boolean zP = cameraInternalI.p();
        Rect rectU0 = u0(yVar.f());
        Objects.requireNonNull(rectU0);
        CameraInternal cameraInternalI2 = i();
        Objects.requireNonNull(cameraInternalI2);
        int iT = t(cameraInternalI2);
        CameraInternal cameraInternalI3 = i();
        Objects.requireNonNull(cameraInternalI3);
        M m10 = new M(3, 34, yVar, matrixY, zP, rectU0, iT, -1, H(cameraInternalI3));
        this.f6944D = m10;
        boolean z10 = str2 != null;
        CameraInternal cameraInternalI4 = i();
        Objects.requireNonNull(cameraInternalI4);
        this.f6946F = A0(m10, cameraInternalI4, z10);
        SessionConfig.b bVarQ0 = q0(this.f6944D, zVar, yVar);
        this.f6950J = bVarQ0;
        j0(bVarQ0, str, str2, zVar, yVar, yVar2);
        return this.f6946F;
    }

    public final M p0(String str, String str2, z<?> zVar, y yVar, y yVar2) {
        Matrix matrixY = y();
        CameraInternal cameraInternalV = v();
        Objects.requireNonNull(cameraInternalV);
        boolean zP = cameraInternalV.p();
        Rect rectU0 = u0(yVar2.f());
        Objects.requireNonNull(rectU0);
        CameraInternal cameraInternalV2 = v();
        Objects.requireNonNull(cameraInternalV2);
        int iT = t(cameraInternalV2);
        CameraInternal cameraInternalV3 = v();
        Objects.requireNonNull(cameraInternalV3);
        M m10 = new M(3, 34, yVar2, matrixY, zP, rectU0, iT, -1, H(cameraInternalV3));
        this.f6945E = m10;
        CameraInternal cameraInternalV4 = v();
        Objects.requireNonNull(cameraInternalV4);
        this.f6947G = A0(m10, cameraInternalV4, true);
        SessionConfig.b bVarQ0 = q0(this.f6945E, zVar, yVar2);
        this.f6951K = bVarQ0;
        j0(bVarQ0, str, str2, zVar, yVar, yVar2);
        return this.f6947G;
    }

    public final SessionConfig.b q0(M m10, z<?> zVar, y yVar) {
        SessionConfig.b bVarP = SessionConfig.b.p(zVar, yVar.f());
        D0(bVarP);
        C0(yVar.f(), bVarP);
        bVarP.n(m10.o(), yVar.b(), null, -1);
        bVarP.j(this.f6954w.F());
        if (yVar.d() != null) {
            bVarP.g(yVar.d());
        }
        bVarP.w(yVar.g());
        b(bVarP, yVar);
        return bVarP;
    }

    public Set<UseCase> t0() {
        return this.f6954w.B();
    }

    public final Rect v0(M m10) {
        return ((AbstractC0772i) B0.h.f(n())).h() == 1 ? M.o.p(m10.s().f()) : m10.n();
    }

    public final M x0(M m10, CameraInternal cameraInternal) {
        this.f6957z = new SurfaceProcessorNode(cameraInternal, n().a(), "StreamSharing");
        int iZ0 = z0();
        Rect rectV0 = v0(m10);
        W.e eVarI = W.e.i(m10.t(), m10.p(), rectV0, M.o.e(rectV0, iZ0), iZ0, y0(), true);
        M m11 = this.f6957z.j(SurfaceProcessorNode.b.c(m10, Collections.singletonList(eVarI))).get(eVarI);
        Objects.requireNonNull(m11);
        return m11;
    }

    public final boolean y0() {
        if (((AbstractC0772i) B0.h.f(n())).h() == 1) {
            CameraInternal cameraInternal = (CameraInternal) B0.h.f(i());
            if (cameraInternal.j() && cameraInternal.p()) {
                return true;
            }
        }
        return false;
    }

    public final int z0() {
        if (((AbstractC0772i) B0.h.f(n())).h() == 1) {
            return t((CameraInternal) B0.h.f(i()));
        }
        return 0;
    }
}
