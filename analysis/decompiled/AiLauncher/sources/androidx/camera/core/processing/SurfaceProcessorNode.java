package androidx.camera.core.processing;

import B0.h;
import D.C0761b0;
import D.r0;
import M.n;
import M.o;
import O.c;
import O.f;
import U.M;
import U.Q;
import U.Y;
import W.e;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.processing.SurfaceProcessorNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public class SurfaceProcessorNode {

    /* renamed from: a, reason: collision with root package name */
    public final Q f11647a;

    /* renamed from: b, reason: collision with root package name */
    public final CameraInternal f11648b;

    /* renamed from: c, reason: collision with root package name */
    public Out f11649c;

    /* renamed from: d, reason: collision with root package name */
    public b f11650d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11651e;

    public static class Out extends HashMap<e, M> {
    }

    public class a implements c<r0> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ M f11652a;

        public a(M m10) {
            this.f11652a = m10;
        }

        @Override // O.c
        public void b(Throwable th) {
            if (this.f11652a.t() == 2 && (th instanceof CancellationException)) {
                C0761b0.a("SurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                return;
            }
            C0761b0.p("SurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + Y.a(this.f11652a.t()), th);
        }

        @Override // O.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(r0 r0Var) throws ProcessingException {
            h.f(r0Var);
            SurfaceProcessorNode.this.f11647a.c(r0Var);
        }
    }

    public static abstract class b {
        public static b c(M m10, List<e> list) {
            return new androidx.camera.core.processing.a(m10, list);
        }

        public abstract List<e> a();

        public abstract M b();
    }

    @SuppressLint({"LambdaLast"})
    public SurfaceProcessorNode(CameraInternal cameraInternal, Q q10, String str) {
        this.f11648b = cameraInternal;
        this.f11647a = q10;
        this.f11651e = str;
    }

    public static /* synthetic */ void b(Map map, SurfaceRequest.g gVar) {
        for (Map.Entry entry : map.entrySet()) {
            int iB = gVar.b() - ((e) entry.getKey()).c();
            if (((e) entry.getKey()).g()) {
                iB = -iB;
            }
            ((M) entry.getValue()).z(o.u(iB), -1);
        }
    }

    public static /* synthetic */ void c(SurfaceProcessorNode surfaceProcessorNode) {
        Out out = surfaceProcessorNode.f11649c;
        if (out != null) {
            Iterator<M> it = out.values().iterator();
            while (it.hasNext()) {
                it.next().i();
            }
        }
    }

    public final void d(M m10, Map.Entry<e, M> entry) {
        M value = entry.getValue();
        C0761b0.a("SurfaceProcessorNode", "     -> outputEdge = " + value);
        f.b(value.j(entry.getKey().b(), r0.a.f(m10.s().f(), entry.getKey().a(), m10.u() ? this.f11648b : null, entry.getKey().c(), entry.getKey().g()), null), new a(value), N.a.d());
    }

    public Q e() {
        return this.f11647a;
    }

    public void f() {
        this.f11647a.release();
        n.e(new Runnable() { // from class: U.U
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceProcessorNode.c(this.f6078a);
            }
        });
    }

    public final void g(final M m10, Map<e, M> map) {
        for (final Map.Entry<e, M> entry : map.entrySet()) {
            d(m10, entry);
            entry.getValue().e(new Runnable() { // from class: U.S
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6074a.d(m10, entry);
                }
            });
        }
    }

    public final void h(M m10) throws ProcessingException {
        this.f11647a.a(m10.k(this.f11648b));
    }

    public void i(M m10, final Map<e, M> map) {
        m10.f(new B0.a() { // from class: U.T
            @Override // B0.a
            public final void accept(Object obj) {
                SurfaceProcessorNode.b(map, (SurfaceRequest.g) obj);
            }
        });
    }

    public Out j(b bVar) throws ProcessingException {
        n.b();
        C0761b0.a("SurfaceProcessorNode", (this.f11651e == null ? "" : "[" + this.f11651e + "] ") + "SurfaceProcessorNode Transform (Processor=" + this.f11647a + "\n   inputEdge = " + bVar.b());
        Iterator<e> it = bVar.a().iterator();
        while (it.hasNext()) {
            C0761b0.a("SurfaceProcessorNode", "   outputConfig = " + it.next());
        }
        this.f11650d = bVar;
        this.f11649c = new Out();
        M mB = bVar.b();
        for (e eVar : bVar.a()) {
            this.f11649c.put(eVar, k(mB, eVar));
        }
        h(mB);
        g(mB, this.f11649c);
        i(mB, this.f11649c);
        return this.f11649c;
    }

    public final M k(M m10, e eVar) {
        Rect rectP;
        Rect rectA = eVar.a();
        int iC = eVar.c();
        boolean zG = eVar.g();
        Matrix matrix = new Matrix(m10.r());
        Matrix matrixD = o.d(new RectF(rectA), o.r(eVar.d()), iC, zG);
        matrix.postConcat(matrixD);
        h.a(o.i(o.e(rectA, iC), eVar.d()));
        if (eVar.k()) {
            h.b(eVar.a().contains(m10.n()), String.format("Output crop rect %s must contain input crop rect %s", eVar.a(), m10.n()));
            rectP = new Rect();
            RectF rectF = new RectF(m10.n());
            matrixD.mapRect(rectF);
            rectF.round(rectP);
        } else {
            rectP = o.p(eVar.d());
        }
        Rect rect = rectP;
        return new M(eVar.e(), eVar.b(), m10.s().i().f(eVar.d()).a(), matrix, false, rect, m10.q() - iC, -1, m10.w() != zG);
    }
}
