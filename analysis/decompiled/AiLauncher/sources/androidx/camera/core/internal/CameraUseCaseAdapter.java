package androidx.camera.core.internal;

import B0.h;
import D.A;
import D.AbstractC0772i;
import D.B;
import D.C0761b0;
import D.C0777n;
import D.E0;
import D.InterfaceC0771h;
import D.InterfaceC0778o;
import D.i0;
import G.ResolvedFeatureGroup;
import K.C0877d;
import P.StreamSpecQueryResult;
import P.i;
import P.m;
import S.e;
import U.Y;
import Y.f;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.g;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class CameraUseCaseAdapter implements InterfaceC0771h {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.camera.core.impl.a f11558a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.camera.core.impl.a f11559b;

    /* renamed from: c, reason: collision with root package name */
    public final UseCaseConfigFactory f11560c;

    /* renamed from: d, reason: collision with root package name */
    public final C0777n f11561d;

    /* renamed from: g, reason: collision with root package name */
    public final E.a f11564g;

    /* renamed from: k, reason: collision with root package name */
    public final g f11568k;

    /* renamed from: o, reason: collision with root package name */
    public UseCase f11572o;

    /* renamed from: p, reason: collision with root package name */
    public f f11573p;

    /* renamed from: q, reason: collision with root package name */
    public final A f11574q;

    /* renamed from: r, reason: collision with root package name */
    public final A f11575r;

    /* renamed from: t, reason: collision with root package name */
    public final i f11577t;

    /* renamed from: e, reason: collision with root package name */
    public final List<UseCase> f11562e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final List<UseCase> f11563f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public List<AbstractC0772i> f11565h = Collections.EMPTY_LIST;

    /* renamed from: i, reason: collision with root package name */
    public int f11566i = 0;

    /* renamed from: j, reason: collision with root package name */
    public Range<Integer> f11567j = y.f11539a;

    /* renamed from: l, reason: collision with root package name */
    public final Object f11569l = new Object();

    /* renamed from: m, reason: collision with root package name */
    public boolean f11570m = true;

    /* renamed from: n, reason: collision with root package name */
    public Config f11571n = null;

    /* renamed from: s, reason: collision with root package name */
    public final e f11576s = new e();

    public static final class CameraException extends Exception {
        public CameraException(Throwable th) {
            super(th);
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public z<?> f11578a;

        /* renamed from: b, reason: collision with root package name */
        public z<?> f11579b;

        public a(z<?> zVar, z<?> zVar2) {
            this.f11578a = zVar;
            this.f11579b = zVar2;
        }
    }

    public CameraUseCaseAdapter(CameraInternal cameraInternal, CameraInternal cameraInternal2, C0877d c0877d, C0877d c0877d2, A a10, A a11, E.a aVar, i iVar, UseCaseConfigFactory useCaseConfigFactory) {
        this.f11568k = c0877d.b();
        this.f11558a = new androidx.camera.core.impl.a(cameraInternal, c0877d);
        if (cameraInternal2 == null || c0877d2 == null) {
            this.f11559b = null;
        } else {
            this.f11559b = new androidx.camera.core.impl.a(cameraInternal2, c0877d2);
        }
        this.f11574q = a10;
        this.f11575r = a11;
        this.f11564g = aVar;
        this.f11560c = useCaseConfigFactory;
        this.f11561d = C0777n.a.e(c0877d, c0877d2);
        this.f11577t = iVar;
    }

    public static void B(Collection<UseCase> collection) {
        Iterator<UseCase> it = collection.iterator();
        while (it.hasNext()) {
            it.next().Y(null);
        }
    }

    public static z<?> G(UseCaseConfigFactory useCaseConfigFactory, f fVar) {
        z<?> zVarM = new i0.a().e().m(false, useCaseConfigFactory);
        if (zVarM == null) {
            return null;
        }
        u uVarL0 = u.l0(zVarM);
        uVarL0.m0(m.f5354c);
        return fVar.D(uVarL0).d();
    }

    public static Map<UseCase, a> J(Collection<UseCase> collection, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2, int i10, Range<Integer> range) {
        HashMap map = new HashMap();
        for (UseCase useCase : collection) {
            map.put(useCase, new a(f.B0(useCase) ? G(useCaseConfigFactory, (f) useCase) : useCase.m(false, useCaseConfigFactory), t(useCase, useCase.m(true, useCaseConfigFactory2), i10, range)));
        }
        return map;
    }

    public static boolean O(y yVar, SessionConfig sessionConfig) {
        Config configD = yVar.d();
        Config configG = sessionConfig.g();
        Objects.requireNonNull(configD);
        if (configD.e().size() != sessionConfig.g().e().size()) {
            return true;
        }
        for (Config.a<?> aVar : configD.e()) {
            if (!configG.b(aVar) || !Objects.equals(configG.a(aVar), configD.a(aVar))) {
                return true;
            }
        }
        return false;
    }

    public static boolean P(Collection<UseCase> collection) {
        Iterator<UseCase> it = collection.iterator();
        while (it.hasNext()) {
            if (X(it.next().l().K())) {
                return true;
            }
        }
        return false;
    }

    public static boolean Q(Collection<UseCase> collection) {
        for (UseCase useCase : collection) {
            if (W(useCase)) {
                z<?> zVarL = useCase.l();
                Config.a<?> aVar = q.f11473W;
                if (zVarL.b(aVar) && ((Integer) h.f((Integer) zVarL.a(aVar))).intValue() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean R(Collection<UseCase> collection) {
        for (UseCase useCase : collection) {
            if (W(useCase)) {
                z<?> zVarL = useCase.l();
                Config.a<?> aVar = q.f11473W;
                if (zVarL.b(aVar) && ((Integer) h.f((Integer) zVarL.a(aVar))).intValue() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean T(Collection<UseCase> collection) {
        boolean z10 = false;
        boolean z11 = false;
        for (UseCase useCase : collection) {
            if (Y(useCase) || f.B0(useCase)) {
                z10 = true;
            } else if (W(useCase)) {
                z11 = true;
            }
        }
        return z10 && !z11;
    }

    public static boolean U(Collection<UseCase> collection) {
        boolean z10 = false;
        boolean z11 = false;
        for (UseCase useCase : collection) {
            if (Y(useCase) || f.B0(useCase)) {
                z11 = true;
            } else if (W(useCase)) {
                z10 = true;
            }
        }
        return z10 && !z11;
    }

    @SafeVarargs
    public static boolean V(List<UseCase>... listArr) {
        boolean z10 = false;
        for (List<UseCase> list : listArr) {
            Iterator<UseCase> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().o() != null) {
                    z10 = true;
                    break;
                }
            }
            if (z10) {
                return z10;
            }
        }
        return z10;
    }

    public static boolean W(UseCase useCase) {
        return useCase instanceof ImageCapture;
    }

    public static boolean X(B b10) {
        return (b10.a() == 10) || (b10.b() != 1 && b10.b() != 0);
    }

    public static boolean Y(UseCase useCase) {
        return useCase instanceof i0;
    }

    public static boolean a0(Collection<UseCase> collection) {
        int[] iArr = {1, 2, 4};
        HashSet hashSet = new HashSet();
        for (UseCase useCase : collection) {
            for (int i10 = 0; i10 < 3; i10++) {
                int i11 = iArr[i10];
                if (useCase.G(i11)) {
                    if (hashSet.contains(Integer.valueOf(i11))) {
                        return false;
                    }
                    hashSet.add(Integer.valueOf(i11));
                }
            }
        }
        return true;
    }

    public static /* synthetic */ void b(SurfaceRequest surfaceRequest) throws ExecutionException, InterruptedException {
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(surfaceRequest.n().getWidth(), surfaceRequest.n().getHeight());
        surfaceTexture.detachFromGLContext();
        final Surface surface = new Surface(surfaceTexture);
        surfaceRequest.r(surface, N.a.a(), new B0.a() { // from class: P.c
            @Override // B0.a
            public final void accept(Object obj) {
                CameraUseCaseAdapter.c(surface, surfaceTexture, (SurfaceRequest.f) obj);
            }
        });
    }

    public static /* synthetic */ void c(Surface surface, SurfaceTexture surfaceTexture, SurfaceRequest.f fVar) {
        surface.release();
        surfaceTexture.release();
    }

    public static void c0(Map<UseCase, Set<F.b>> map) {
        for (Map.Entry<UseCase, Set<F.b>> entry : map.entrySet()) {
            entry.getKey().Y(entry.getValue());
        }
    }

    public static List<AbstractC0772i> f0(List<AbstractC0772i> list, Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(list);
        for (UseCase useCase : collection) {
            useCase.X(null);
            for (AbstractC0772i abstractC0772i : list) {
                if (useCase.G(abstractC0772i.g())) {
                    h.i(useCase.n() == null, useCase + " already has effect" + useCase.n());
                    useCase.X(abstractC0772i);
                    arrayList.remove(abstractC0772i);
                }
            }
        }
        return arrayList;
    }

    public static void l0(List<AbstractC0772i> list, Collection<UseCase> collection, Collection<UseCase> collection2) {
        List<AbstractC0772i> listF0 = f0(list, collection);
        ArrayList arrayList = new ArrayList(collection2);
        arrayList.removeAll(collection);
        List<AbstractC0772i> listF02 = f0(listF0, arrayList);
        if (listF02.isEmpty()) {
            return;
        }
        C0761b0.o("CameraUseCaseAdapter", "Unused effects: " + listF02);
    }

    public static Map<UseCase, Set<F.b>> s(Collection<UseCase> collection, ResolvedFeatureGroup aVar) {
        HashMap map = new HashMap();
        for (UseCase useCase : collection) {
            map.put(useCase, useCase.o());
            useCase.Y(aVar != null ? aVar.a() : null);
        }
        return map;
    }

    public static z<?> t(UseCase useCase, z<?> zVar, int i10, Range<Integer> range) {
        u uVarL0 = zVar != null ? u.l0(zVar) : u.k0();
        uVarL0.t(z.f11545F, Integer.valueOf(i10));
        if (!y.f11539a.equals(range)) {
            uVarL0.q(z.f11546G, Config.OptionPriority.HIGH_PRIORITY_REQUIRED, range);
            uVarL0.t(z.f11547H, Boolean.TRUE);
        }
        return useCase.D(uVarL0).d();
    }

    public static Collection<UseCase> x(Collection<UseCase> collection, UseCase useCase, f fVar) {
        ArrayList arrayList = new ArrayList(collection);
        if (useCase != null) {
            arrayList.add(useCase);
        }
        if (fVar != null) {
            arrayList.add(fVar);
            arrayList.removeAll(fVar.t0());
        }
        return arrayList;
    }

    public static Matrix z(Rect rect, Size size) {
        h.b(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    public final void A(Collection<UseCase> collection) throws IllegalArgumentException {
        if (N()) {
            if (P(collection)) {
                throw new IllegalArgumentException("Extensions are only supported for use with standard dynamic range.");
            }
            if (Q(collection)) {
                throw new IllegalArgumentException("Extensions are not supported for use with Raw image capture.");
            }
        }
        synchronized (this.f11569l) {
            try {
                if (!this.f11565h.isEmpty() && (R(collection) || Q(collection))) {
                    throw new IllegalArgumentException("Ultra HDR image and Raw capture does not support for use with CameraEffect.");
                }
            } finally {
            }
        }
    }

    public final ImageCapture C() {
        return new ImageCapture.b().p("ImageCapture-Extra").e();
    }

    public final i0 D() {
        i0 i0VarE = new i0.a().o("Preview-Extra").e();
        i0VarE.r0(new i0.c() { // from class: P.b
            @Override // D.i0.c
            public final void a(SurfaceRequest surfaceRequest) throws ExecutionException, InterruptedException {
                CameraUseCaseAdapter.b(surfaceRequest);
            }
        });
        return i0VarE;
    }

    public final f E(Collection<UseCase> collection, boolean z10) {
        synchronized (this.f11569l) {
            try {
                Set<UseCase> setL = L(collection, z10);
                if (setL.size() >= 2 || (N() && M.q.b(setL))) {
                    f fVar = this.f11573p;
                    if (fVar == null || !fVar.t0().equals(setL)) {
                        if (!a0(setL)) {
                            return null;
                        }
                        return new f(this.f11558a, this.f11559b, this.f11574q, this.f11575r, setL, this.f11560c);
                    }
                    this.f11573p.G0(setL);
                    f fVar2 = this.f11573p;
                    Objects.requireNonNull(fVar2);
                    return fVar2;
                }
                return null;
            } finally {
            }
        }
    }

    public void F() {
        synchronized (this.f11569l) {
            try {
                if (this.f11570m) {
                    this.f11558a.h(new ArrayList(this.f11563f));
                    androidx.camera.core.impl.a aVar = this.f11559b;
                    if (aVar != null) {
                        aVar.h(new ArrayList(this.f11563f));
                    }
                    v();
                    this.f11570m = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C0777n H() {
        return this.f11561d;
    }

    public final int I() {
        synchronized (this.f11569l) {
            try {
                return this.f11564g.e() == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int K(boolean z10) {
        int iG;
        synchronized (this.f11569l) {
            try {
                Iterator<AbstractC0772i> it = this.f11565h.iterator();
                AbstractC0772i abstractC0772i = null;
                while (true) {
                    iG = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    AbstractC0772i next = it.next();
                    if (Y.b(next.g()) > 1) {
                        h.i(abstractC0772i == null, "Can only have one sharing effect.");
                        abstractC0772i = next;
                    }
                }
                if (abstractC0772i != null) {
                    iG = abstractC0772i.g();
                }
                if (z10) {
                    iG |= 3;
                }
            } finally {
            }
        }
        return iG;
    }

    public final Set<UseCase> L(Collection<UseCase> collection, boolean z10) {
        HashSet hashSet = new HashSet();
        int iK = K(z10);
        for (UseCase useCase : collection) {
            h.b(!f.B0(useCase), "Only support one level of sharing for now.");
            if (useCase.G(iK)) {
                hashSet.add(useCase);
            }
        }
        return hashSet;
    }

    public List<UseCase> M() {
        ArrayList arrayList;
        synchronized (this.f11569l) {
            arrayList = new ArrayList(this.f11562e);
        }
        return arrayList;
    }

    public final boolean N() {
        boolean z10;
        synchronized (this.f11569l) {
            z10 = this.f11568k.T(null) != null;
        }
        return z10;
    }

    public final boolean S() {
        boolean z10;
        synchronized (this.f11569l) {
            z10 = true;
            if (this.f11568k.x() != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    public final boolean Z() {
        return (N() || this.f11559b != null || this.f11566i == 1) ? false : true;
    }

    @Override // D.InterfaceC0771h
    public InterfaceC0778o a() {
        return this.f11558a.a();
    }

    public void b0(Collection<UseCase> collection) {
        synchronized (this.f11569l) {
            B(collection);
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.f11562e);
            linkedHashSet.removeAll(collection);
            l(w(linkedHashSet, this.f11559b != null, false));
        }
    }

    public final void d0() {
        synchronized (this.f11569l) {
            try {
                if (this.f11571n != null) {
                    this.f11558a.d().f(this.f11571n);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e0(List<AbstractC0772i> list) {
        synchronized (this.f11569l) {
            this.f11565h = list;
        }
    }

    public void f(boolean z10) {
        this.f11558a.f(z10);
    }

    public void g0(Range<Integer> range) {
        synchronized (this.f11569l) {
            this.f11567j = range;
        }
    }

    public void h0(int i10) {
        synchronized (this.f11569l) {
            this.f11566i = i10;
        }
    }

    public void i0(E0 e02) {
        synchronized (this.f11569l) {
        }
    }

    public final boolean j0(Collection<UseCase> collection) {
        if (N() && M.q.b(collection)) {
            return true;
        }
        return this.f11576s.a(this.f11558a.i().h(), collection);
    }

    public void k(Collection<UseCase> collection, ResolvedFeatureGroup aVar) throws CameraException {
        C0761b0.a("CameraUseCaseAdapter", "addUseCases: appUseCasesToAdd = " + collection + ", featureGroup = " + aVar);
        synchronized (this.f11569l) {
            try {
                r();
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.f11562e);
                linkedHashSet.addAll(collection);
                Map<UseCase, Set<F.b>> mapS = s(linkedHashSet, aVar);
                try {
                    l(w(linkedHashSet, this.f11559b != null, false));
                } catch (IllegalArgumentException e10) {
                    c0(mapS);
                    throw new CameraException(e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public CalculatedUseCaseInfo k0(Collection<UseCase> collection, ResolvedFeatureGroup aVar, boolean z10) throws CameraException {
        CalculatedUseCaseInfo aVarW;
        C0761b0.a("CameraUseCaseAdapter", "simulateAddUseCases: appUseCasesToAdd = " + collection + ", featureGroup = " + aVar);
        synchronized (this.f11569l) {
            r();
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.f11562e);
            linkedHashSet.addAll(collection);
            Map<UseCase, Set<F.b>> mapS = s(linkedHashSet, aVar);
            try {
                try {
                    aVarW = w(linkedHashSet, this.f11559b != null, z10);
                } catch (IllegalArgumentException e10) {
                    throw new CameraException(e10);
                }
            } finally {
                c0(mapS);
            }
        }
        return aVarW;
    }

    public final void l(CalculatedUseCaseInfo aVar) {
        m0(aVar.getPrimaryStreamSpecResult().b(), aVar.b());
        l0(this.f11565h, aVar.b(), aVar.a());
        Iterator<UseCase> it = aVar.d().iterator();
        while (it.hasNext()) {
            it.next().d0(this.f11558a);
        }
        this.f11558a.h(aVar.d());
        if (this.f11559b != null) {
            for (UseCase useCase : aVar.d()) {
                androidx.camera.core.impl.a aVar2 = this.f11559b;
                Objects.requireNonNull(aVar2);
                useCase.d0(aVar2);
            }
            androidx.camera.core.impl.a aVar3 = this.f11559b;
            Objects.requireNonNull(aVar3);
            aVar3.h(aVar.d());
        }
        if (aVar.d().isEmpty()) {
            for (UseCase useCase2 : aVar.e()) {
                Map<UseCase, y> mapB = aVar.getPrimaryStreamSpecResult().b();
                if (mapB.containsKey(useCase2)) {
                    y yVar = mapB.get(useCase2);
                    Objects.requireNonNull(yVar);
                    Config configD = yVar.d();
                    if (configD != null && O(yVar, useCase2.z())) {
                        useCase2.g0(configD);
                        if (this.f11570m) {
                            this.f11558a.c(useCase2);
                            androidx.camera.core.impl.a aVar4 = this.f11559b;
                            if (aVar4 != null) {
                                Objects.requireNonNull(aVar4);
                                aVar4.c(useCase2);
                            }
                        }
                    }
                }
            }
        }
        for (UseCase useCase3 : aVar.c()) {
            a aVar5 = aVar.j().get(useCase3);
            Objects.requireNonNull(aVar5);
            androidx.camera.core.impl.a aVar6 = this.f11559b;
            if (aVar6 != null) {
                androidx.camera.core.impl.a aVar7 = this.f11558a;
                Objects.requireNonNull(aVar6);
                useCase3.d(aVar7, aVar6, aVar5.f11578a, aVar5.f11579b);
                useCase3.f0((y) h.f(aVar.getPrimaryStreamSpecResult().b().get(useCase3)), ((StreamSpecQueryResult) h.f(aVar.getSecondaryStreamSpecResult())).b().get(useCase3));
            } else {
                useCase3.d(this.f11558a, null, aVar5.f11578a, aVar5.f11579b);
                useCase3.f0((y) h.f(aVar.getPrimaryStreamSpecResult().b().get(useCase3)), null);
            }
        }
        if (this.f11570m) {
            this.f11558a.g(aVar.c());
            androidx.camera.core.impl.a aVar8 = this.f11559b;
            if (aVar8 != null) {
                Objects.requireNonNull(aVar8);
                aVar8.g(aVar.c());
            }
        }
        Iterator<UseCase> it2 = aVar.c().iterator();
        while (it2.hasNext()) {
            it2.next().M();
        }
        this.f11562e.clear();
        this.f11562e.addAll(aVar.a());
        this.f11563f.clear();
        this.f11563f.addAll(aVar.b());
        this.f11572o = aVar.getPlaceholderForExtensions();
        this.f11573p = aVar.getStreamSharing();
    }

    public final void m0(Map<UseCase, y> map, Collection<UseCase> collection) {
        synchronized (this.f11569l) {
            try {
                for (UseCase useCase : collection) {
                    useCase.a0(z(this.f11558a.i().j(), ((y) h.f(map.get(useCase))).f()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean n() {
        if (this.f11558a.n()) {
            return true;
        }
        androidx.camera.core.impl.a aVar = this.f11559b;
        return aVar != null && aVar.n();
    }

    public final void r() {
        this.f11558a.m(this.f11568k);
        androidx.camera.core.impl.a aVar = this.f11559b;
        if (aVar != null) {
            aVar.m(this.f11568k);
        }
    }

    public void u() {
        synchronized (this.f11569l) {
            try {
                if (!this.f11570m) {
                    if (!this.f11563f.isEmpty()) {
                        this.f11558a.m(this.f11568k);
                        androidx.camera.core.impl.a aVar = this.f11559b;
                        if (aVar != null) {
                            aVar.m(this.f11568k);
                        }
                    }
                    this.f11558a.g(this.f11563f);
                    androidx.camera.core.impl.a aVar2 = this.f11559b;
                    if (aVar2 != null) {
                        aVar2.g(this.f11563f);
                    }
                    d0();
                    Iterator<UseCase> it = this.f11563f.iterator();
                    while (it.hasNext()) {
                        it.next().M();
                    }
                    this.f11570m = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void v() {
        synchronized (this.f11569l) {
            androidx.camera.core.impl.h hVarD = this.f11558a.d();
            this.f11571n = hVarD.e();
            hVarD.i();
        }
    }

    public final CalculatedUseCaseInfo w(Collection<UseCase> collection, boolean z10, boolean z11) throws IllegalArgumentException {
        StreamSpecQueryResult hVarB;
        boolean z12 = z11;
        A(collection);
        if (!z10 && j0(collection)) {
            return w(collection, true, z12);
        }
        f fVarE = E(collection, z10);
        UseCase useCaseY = y(collection, fVarE);
        Collection<UseCase> collectionX = x(collection, useCaseY, fVarE);
        ArrayList arrayList = new ArrayList(collectionX);
        arrayList.removeAll(this.f11563f);
        ArrayList arrayList2 = new ArrayList(collectionX);
        arrayList2.retainAll(this.f11563f);
        ArrayList arrayList3 = new ArrayList(this.f11563f);
        arrayList3.removeAll(collectionX);
        Map<UseCase, a> mapJ = J(arrayList, this.f11568k.k(), this.f11560c, this.f11566i, this.f11567j);
        boolean zV = V(arrayList, arrayList2);
        try {
            StreamSpecQueryResult hVarB2 = this.f11577t.b(I(), this.f11558a.i(), arrayList, arrayList2, this.f11568k, this.f11566i, this.f11567j, zV, z12);
            try {
                if (this.f11559b != null) {
                    i iVar = this.f11577t;
                    int I10 = I();
                    androidx.camera.core.impl.a aVar = this.f11559b;
                    Objects.requireNonNull(aVar);
                    z12 = z11;
                    hVarB = iVar.b(I10, aVar.i(), arrayList, arrayList2, this.f11568k, this.f11566i, this.f11567j, zV, z12);
                } else {
                    hVarB = null;
                }
                return new CalculatedUseCaseInfo(collection, collectionX, arrayList, arrayList2, arrayList3, fVarE, useCaseY, mapJ, hVarB2, hVarB);
            } catch (IllegalArgumentException e10) {
                e = e10;
                z12 = z11;
                if (z10 || !Z()) {
                    throw e;
                }
                return w(collection, true, z12);
            }
        } catch (IllegalArgumentException e11) {
            e = e11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.camera.core.UseCase y(java.util.Collection<androidx.camera.core.UseCase> r3, Y.f r4) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f11569l
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L15
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L15
            if (r4 == 0) goto L17
            r1.add(r4)     // Catch: java.lang.Throwable -> L15
            java.util.Set r3 = r4.t0()     // Catch: java.lang.Throwable -> L15
            r1.removeAll(r3)     // Catch: java.lang.Throwable -> L15
            goto L17
        L15:
            r2 = move-exception
            goto L4c
        L17:
            boolean r3 = r2.S()     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L49
            boolean r3 = U(r1)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L33
            androidx.camera.core.UseCase r3 = r2.f11572o     // Catch: java.lang.Throwable -> L15
            boolean r3 = Y(r3)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L2e
            androidx.camera.core.UseCase r2 = r2.f11572o     // Catch: java.lang.Throwable -> L15
            goto L4a
        L2e:
            D.i0 r2 = r2.D()     // Catch: java.lang.Throwable -> L15
            goto L4a
        L33:
            boolean r3 = T(r1)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L49
            androidx.camera.core.UseCase r3 = r2.f11572o     // Catch: java.lang.Throwable -> L15
            boolean r3 = W(r3)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L44
            androidx.camera.core.UseCase r2 = r2.f11572o     // Catch: java.lang.Throwable -> L15
            goto L4a
        L44:
            androidx.camera.core.ImageCapture r2 = r2.C()     // Catch: java.lang.Throwable -> L15
            goto L4a
        L49:
            r2 = 0
        L4a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            return r2
        L4c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.y(java.util.Collection, Y.f):androidx.camera.core.UseCase");
    }
}
