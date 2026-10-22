package o;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public final class x extends j1.k0 implements r0.e {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7141b = 1;

    /* renamed from: c, reason: collision with root package name */
    public final g f7142c;

    /* renamed from: d, reason: collision with root package name */
    public final y f7143d;

    /* renamed from: e, reason: collision with root package name */
    public Object f7144e;

    public x(g gVar, y yVar) {
        this.f7142c = gVar;
        this.f7143d = yVar;
    }

    public static boolean t(float f10, EdgeEffect edgeEffect, Canvas canvas) {
        if (f10 == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int iSave = canvas.save();
        canvas.rotate(f10);
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    public static boolean u(float f10, long j2, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(f10);
        canvas.translate(t0.b.d(j2), t0.b.e(j2));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    @Override // r0.e
    public final void e(i1.h0 h0Var) {
        boolean zU;
        float f10;
        boolean zT;
        float f11;
        float f12;
        float f13;
        switch (this.f7141b) {
            case 0:
                r.c0 c0Var = ((r0) this.f7144e).f7124b;
                w0.b bVar = h0Var.f4489f;
                long jD = bVar.d();
                g gVar = this.f7142c;
                gVar.l(jD);
                if (t0.e.e(bVar.d())) {
                    h0Var.a();
                    return;
                }
                h0Var.a();
                gVar.f7050h.getValue();
                Canvas canvasA = u0.b.a(bVar.f10630g.a());
                y yVar = this.f7143d;
                if (y.f(yVar.f7152f)) {
                    EdgeEffect edgeEffectC = yVar.c();
                    float f14 = -t0.e.b(bVar.d());
                    d2.l lVarF = h0Var.f();
                    c0Var.getClass();
                    zU = u(270.0f, n7.b.b(f14, h0Var.o(lVarF == d2.l.f2793f ? c0Var.f8850a : c0Var.f8852c)), edgeEffectC, canvasA);
                } else {
                    zU = false;
                }
                if (y.f(yVar.f7150d)) {
                    zU = u(0.0f, n7.b.b(0.0f, h0Var.o(c0Var.f8851b)), yVar.e(), canvasA) || zU;
                }
                if (y.f(yVar.f7153g)) {
                    EdgeEffect edgeEffectD = yVar.d();
                    int iU = s7.a.U(t0.e.d(bVar.d()));
                    d2.l lVarF2 = h0Var.f();
                    c0Var.getClass();
                    zU = u(90.0f, n7.b.b(0.0f, h0Var.o(lVarF2 == d2.l.f2793f ? c0Var.f8852c : c0Var.f8850a) + (-((float) iU))), edgeEffectD, canvasA) || zU;
                }
                if (y.f(yVar.f7151e)) {
                    zU = u(180.0f, n7.b.b(-t0.e.d(bVar.d()), (-t0.e.b(bVar.d())) + h0Var.o(c0Var.f8853d)), yVar.b(), canvasA) || zU;
                }
                if (zU) {
                    gVar.g();
                    return;
                }
                return;
            default:
                w0.b bVar2 = h0Var.f4489f;
                long jD2 = bVar2.d();
                g gVar2 = this.f7142c;
                gVar2.l(jD2);
                if (t0.e.e(bVar2.d())) {
                    h0Var.a();
                    return;
                }
                gVar2.f7050h.getValue();
                float fO = h0Var.o(u.f7129a);
                Canvas canvasA2 = u0.b.a(bVar2.f10630g.a());
                y yVar2 = this.f7143d;
                boolean z4 = y.f(yVar2.f7150d) || y.g(yVar2.f7154h) || y.f(yVar2.f7151e) || y.g(yVar2.f7155i);
                boolean z10 = y.f(yVar2.f7152f) || y.g(yVar2.f7156j) || y.f(yVar2.f7153g) || y.g(yVar2.f7157k);
                if (z4 && z10) {
                    v().setPosition(0, 0, canvasA2.getWidth(), canvasA2.getHeight());
                } else if (z4) {
                    v().setPosition(0, 0, (s7.a.U(fO) * 2) + canvasA2.getWidth(), canvasA2.getHeight());
                } else {
                    if (!z10) {
                        h0Var.a();
                        return;
                    }
                    v().setPosition(0, 0, canvasA2.getWidth(), (s7.a.U(fO) * 2) + canvasA2.getHeight());
                }
                RecordingCanvas recordingCanvasBeginRecording = v().beginRecording();
                if (y.g(yVar2.f7156j)) {
                    EdgeEffect edgeEffectA = yVar2.f7156j;
                    if (edgeEffectA == null) {
                        edgeEffectA = yVar2.a();
                        yVar2.f7156j = edgeEffectA;
                    }
                    t(90.0f, edgeEffectA, recordingCanvasBeginRecording);
                    edgeEffectA.finish();
                }
                boolean zF = y.f(yVar2.f7152f);
                h hVar = h.f7056a;
                if (zF) {
                    EdgeEffect edgeEffectC2 = yVar2.c();
                    zT = t(270.0f, edgeEffectC2, recordingCanvasBeginRecording);
                    if (y.g(yVar2.f7152f)) {
                        float fE = t0.b.e(gVar2.f());
                        EdgeEffect edgeEffectA2 = yVar2.f7156j;
                        if (edgeEffectA2 == null) {
                            edgeEffectA2 = yVar2.a();
                            yVar2.f7156j = edgeEffectA2;
                        }
                        int i2 = Build.VERSION.SDK_INT;
                        float fB = i2 >= 31 ? hVar.b(edgeEffectC2) : 0.0f;
                        f10 = fO;
                        float f15 = 1 - fE;
                        if (i2 >= 31) {
                            hVar.c(edgeEffectA2, fB, f15);
                        } else {
                            edgeEffectA2.onPull(fB, f15);
                        }
                    } else {
                        f10 = fO;
                    }
                } else {
                    f10 = fO;
                    zT = false;
                }
                if (y.g(yVar2.f7154h)) {
                    EdgeEffect edgeEffectA3 = yVar2.f7154h;
                    if (edgeEffectA3 == null) {
                        edgeEffectA3 = yVar2.a();
                        yVar2.f7154h = edgeEffectA3;
                    }
                    t(180.0f, edgeEffectA3, recordingCanvasBeginRecording);
                    edgeEffectA3.finish();
                }
                if (y.f(yVar2.f7150d)) {
                    EdgeEffect edgeEffectE = yVar2.e();
                    boolean z11 = t(0.0f, edgeEffectE, recordingCanvasBeginRecording) || zT;
                    if (y.g(yVar2.f7150d)) {
                        float fD = t0.b.d(gVar2.f());
                        EdgeEffect edgeEffectA4 = yVar2.f7154h;
                        if (edgeEffectA4 == null) {
                            edgeEffectA4 = yVar2.a();
                            yVar2.f7154h = edgeEffectA4;
                        }
                        int i10 = Build.VERSION.SDK_INT;
                        float fB2 = i10 >= 31 ? hVar.b(edgeEffectE) : 0.0f;
                        if (i10 >= 31) {
                            hVar.c(edgeEffectA4, fB2, fD);
                        } else {
                            edgeEffectA4.onPull(fB2, fD);
                        }
                    }
                    zT = z11;
                }
                if (y.g(yVar2.f7157k)) {
                    EdgeEffect edgeEffectA5 = yVar2.f7157k;
                    if (edgeEffectA5 == null) {
                        edgeEffectA5 = yVar2.a();
                        yVar2.f7157k = edgeEffectA5;
                    }
                    t(270.0f, edgeEffectA5, recordingCanvasBeginRecording);
                    edgeEffectA5.finish();
                }
                if (y.f(yVar2.f7153g)) {
                    EdgeEffect edgeEffectD2 = yVar2.d();
                    boolean z12 = t(90.0f, edgeEffectD2, recordingCanvasBeginRecording) || zT;
                    if (y.g(yVar2.f7153g)) {
                        float fE2 = t0.b.e(gVar2.f());
                        EdgeEffect edgeEffectA6 = yVar2.f7157k;
                        if (edgeEffectA6 == null) {
                            edgeEffectA6 = yVar2.a();
                            yVar2.f7157k = edgeEffectA6;
                        }
                        int i11 = Build.VERSION.SDK_INT;
                        float fB3 = i11 >= 31 ? hVar.b(edgeEffectD2) : 0.0f;
                        if (i11 >= 31) {
                            hVar.c(edgeEffectA6, fB3, fE2);
                        } else {
                            edgeEffectA6.onPull(fB3, fE2);
                        }
                    }
                    zT = z12;
                }
                if (y.g(yVar2.f7155i)) {
                    EdgeEffect edgeEffectA7 = yVar2.f7155i;
                    if (edgeEffectA7 == null) {
                        edgeEffectA7 = yVar2.a();
                        yVar2.f7155i = edgeEffectA7;
                    }
                    f11 = 0.0f;
                    t(0.0f, edgeEffectA7, recordingCanvasBeginRecording);
                    edgeEffectA7.finish();
                } else {
                    f11 = 0.0f;
                }
                if (y.f(yVar2.f7151e)) {
                    EdgeEffect edgeEffectB = yVar2.b();
                    boolean z13 = t(180.0f, edgeEffectB, recordingCanvasBeginRecording) || zT;
                    if (y.g(yVar2.f7151e)) {
                        float fD2 = t0.b.d(gVar2.f());
                        EdgeEffect edgeEffectA8 = yVar2.f7155i;
                        if (edgeEffectA8 == null) {
                            edgeEffectA8 = yVar2.a();
                            yVar2.f7155i = edgeEffectA8;
                        }
                        int i12 = Build.VERSION.SDK_INT;
                        float fB4 = i12 >= 31 ? hVar.b(edgeEffectB) : f11;
                        float f16 = 1 - fD2;
                        if (i12 >= 31) {
                            hVar.c(edgeEffectA8, fB4, f16);
                        } else {
                            edgeEffectA8.onPull(fB4, f16);
                        }
                    }
                    zT = z13;
                }
                if (zT) {
                    gVar2.g();
                }
                float f17 = z10 ? f11 : f10;
                if (!z4) {
                    f11 = f10;
                }
                d2.l lVarF3 = h0Var.f();
                u0.a aVar = new u0.a();
                aVar.f9869a = recordingCanvasBeginRecording;
                long jD3 = bVar2.d();
                u5.h hVar2 = bVar2.f10630g;
                w0.a aVar2 = ((w0.b) hVar2.f10131c).f10629f;
                d2.c cVar = aVar2.f10625a;
                d2.l lVar = aVar2.f10626b;
                u0.l lVarA = hVar2.a();
                long jB = bVar2.f10630g.b();
                u5.h hVar3 = bVar2.f10630g;
                x0.b bVar3 = (x0.b) hVar3.f10130b;
                hVar3.h(h0Var);
                hVar3.i(lVarF3);
                hVar3.g(aVar);
                hVar3.j(jD3);
                hVar3.f10130b = null;
                aVar.h();
                try {
                    ((o4.d0) bVar2.f10630g.f10129a).S(f17, f11);
                    try {
                        h0Var.a();
                        aVar.g();
                        u5.h hVar4 = bVar2.f10630g;
                        hVar4.h(cVar);
                        hVar4.i(lVar);
                        hVar4.g(lVarA);
                        hVar4.j(jB);
                        hVar4.f10130b = bVar3;
                        v().endRecording();
                        int iSave = canvasA2.save();
                        canvasA2.translate(f12, f13);
                        canvasA2.drawRenderNode(v());
                        canvasA2.restoreToCount(iSave);
                        return;
                    } finally {
                        ((o4.d0) bVar2.f10630g.f10129a).S(-f17, -f11);
                    }
                } catch (Throwable th) {
                    aVar.g();
                    u5.h hVar5 = bVar2.f10630g;
                    hVar5.h(cVar);
                    hVar5.i(lVar);
                    hVar5.g(lVarA);
                    hVar5.j(jB);
                    hVar5.f10130b = bVar3;
                    throw th;
                }
        }
    }

    public RenderNode v() {
        RenderNode renderNode = (RenderNode) this.f7144e;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode renderNode2 = new RenderNode("AndroidEdgeEffectOverscrollEffect");
        this.f7144e = renderNode2;
        return renderNode2;
    }

    public x(g gVar, y yVar, r0 r0Var) {
        this.f7142c = gVar;
        this.f7143d = yVar;
        this.f7144e = r0Var;
    }
}
