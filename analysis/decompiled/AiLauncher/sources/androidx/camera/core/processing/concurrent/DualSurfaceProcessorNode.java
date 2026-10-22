package androidx.camera.core.processing.concurrent;

import B0.h;
import D.C0761b0;
import D.r0;
import M.n;
import M.o;
import O.f;
import U.M;
import U.Q;
import U.Y;
import V.c;
import W.e;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public class DualSurfaceProcessorNode {

    /* renamed from: a, reason: collision with root package name */
    public final Q f11656a;

    /* renamed from: b, reason: collision with root package name */
    public final CameraInternal f11657b;

    /* renamed from: c, reason: collision with root package name */
    public final CameraInternal f11658c;

    /* renamed from: d, reason: collision with root package name */
    public Out f11659d;

    /* renamed from: e, reason: collision with root package name */
    public b f11660e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11661f;

    public static class Out extends HashMap<c, M> {
    }

    public class a implements O.c<r0> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ M f11662a;

        public a(M m10) {
            this.f11662a = m10;
        }

        @Override // O.c
        public void b(Throwable th) {
            if (this.f11662a.t() == 2 && (th instanceof CancellationException)) {
                C0761b0.a("DualSurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                return;
            }
            C0761b0.p("DualSurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + Y.a(this.f11662a.t()), th);
        }

        @Override // O.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(r0 r0Var) throws ProcessingException {
            h.f(r0Var);
            DualSurfaceProcessorNode.this.f11656a.c(r0Var);
        }
    }

    public static abstract class b {
        public static b d(M m10, M m11, List<c> list) {
            return new androidx.camera.core.processing.concurrent.a(m10, m11, list);
        }

        public abstract List<c> a();

        public abstract M b();

        public abstract M c();
    }

    @SuppressLint({"LambdaLast"})
    public DualSurfaceProcessorNode(CameraInternal cameraInternal, CameraInternal cameraInternal2, Q q10, String str) {
        this.f11657b = cameraInternal;
        this.f11658c = cameraInternal2;
        this.f11656a = q10;
        this.f11661f = str;
    }

    public static /* synthetic */ void a(DualSurfaceProcessorNode dualSurfaceProcessorNode) {
        Out out = dualSurfaceProcessorNode.f11659d;
        if (out != null) {
            Iterator<M> it = out.values().iterator();
            while (it.hasNext()) {
                it.next().i();
            }
        }
    }

    public final void c(CameraInternal cameraInternal, CameraInternal cameraInternal2, M m10, M m11, Map.Entry<c, M> entry) {
        M value = entry.getValue();
        C0761b0.a("DualSurfaceProcessorNode", "     -> outputEdge = " + value);
        Size sizeF = m10.s().f();
        Rect rectA = entry.getKey().a().a();
        if (!m10.u()) {
            cameraInternal = null;
        }
        r0.a aVarF = r0.a.f(sizeF, rectA, cameraInternal, entry.getKey().a().c(), entry.getKey().a().g());
        Size sizeF2 = m11.s().f();
        Rect rectA2 = entry.getKey().b().a();
        if (!m11.u()) {
            cameraInternal2 = null;
        }
        f.b(value.j(entry.getKey().a().b(), aVarF, r0.a.f(sizeF2, rectA2, cameraInternal2, entry.getKey().b().c(), entry.getKey().b().g())), new a(value), N.a.d());
    }

    public void d() {
        this.f11656a.release();
        n.e(new Runnable() { // from class: V.o
            @Override // java.lang.Runnable
            public final void run() {
                DualSurfaceProcessorNode.a(this.f6456a);
            }
        });
    }

    public final void e(CameraInternal cameraInternal, CameraInternal cameraInternal2, M m10, M m11, Map<c, M> map) {
        for (final Map.Entry<c, M> entry : map.entrySet()) {
            final DualSurfaceProcessorNode dualSurfaceProcessorNode = this;
            final CameraInternal cameraInternal3 = cameraInternal;
            final CameraInternal cameraInternal4 = cameraInternal2;
            final M m12 = m10;
            final M m13 = m11;
            dualSurfaceProcessorNode.c(cameraInternal3, cameraInternal4, m12, m13, entry);
            entry.getValue().e(new Runnable() { // from class: V.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6457a.c(cameraInternal3, cameraInternal4, m12, m13, entry);
                }
            });
            this = dualSurfaceProcessorNode;
            cameraInternal = cameraInternal3;
            cameraInternal2 = cameraInternal4;
            m10 = m12;
            m11 = m13;
        }
    }

    public final void f(CameraInternal cameraInternal, M m10, boolean z10) throws ProcessingException {
        this.f11656a.a(m10.l(cameraInternal, z10));
    }

    public Out g(b bVar) throws ProcessingException {
        n.b();
        C0761b0.a("DualSurfaceProcessorNode", (this.f11661f == null ? "" : "[" + this.f11661f + "] ") + "DualSurfaceProcessorNode Transform Processor = " + this.f11656a + "\n   primary input = " + bVar.b() + "\n   secondary input = " + bVar.c());
        Iterator<c> it = bVar.a().iterator();
        while (it.hasNext()) {
            C0761b0.a("SurfaceProcessorNode", "   outputConfig = " + it.next());
        }
        this.f11660e = bVar;
        this.f11659d = new Out();
        M mB = this.f11660e.b();
        M mC = this.f11660e.c();
        for (c cVar : this.f11660e.a()) {
            this.f11659d.put(cVar, h(mB, cVar.a()));
        }
        f(this.f11657b, mB, true);
        f(this.f11658c, mC, false);
        e(this.f11657b, this.f11658c, mB, mC, this.f11659d);
        return this.f11659d;
    }

    public final M h(M m10, e eVar) {
        Rect rectA = eVar.a();
        int iC = eVar.c();
        boolean zG = eVar.g();
        Matrix matrix = new Matrix(m10.r());
        matrix.postConcat(o.d(new RectF(rectA), o.r(eVar.d()), iC, zG));
        h.a(o.i(o.e(rectA, iC), eVar.d()));
        Rect rectP = o.p(eVar.d());
        return new M(eVar.e(), eVar.b(), m10.s().i().f(eVar.d()).a(), matrix, false, rectP, m10.q() - iC, -1, m10.w() != zG);
    }
}
