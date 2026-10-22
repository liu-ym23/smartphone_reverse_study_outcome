package t;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends v1.g0 implements a1.f {

    /* renamed from: f, reason: collision with root package name */
    public f f13089f;

    /* renamed from: g, reason: collision with root package name */
    public z f13090g;

    /* renamed from: h, reason: collision with root package name */
    public RenderNode f13091h;

    public static boolean y(float f5, EdgeEffect edgeEffect, Canvas canvas) {
        if (f5 == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int iSave = canvas.save();
        canvas.rotate(f5);
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    @Override // a1.f
    public final void b(u1.i0 i0Var) {
        boolean zY;
        float f5;
        float f10;
        long j10;
        char c9;
        z zVar = this.f13090g;
        f fVar = this.f13089f;
        f1.b bVar = i0Var.f13838c;
        long jE = bVar.e();
        boolean zB = c1.e.b(fVar.f12973j, 0L);
        boolean zB2 = c1.e.b(jE, fVar.f12973j);
        fVar.f12973j = jE;
        if (!zB2) {
            z zVar2 = fVar.f12970f;
            long jB = ac.a.b(ac.a.Q(c1.e.e(jE)), ac.a.Q(c1.e.c(jE)));
            zVar2.f13096c = jB;
            EdgeEffect edgeEffect = zVar2.f13097d;
            if (edgeEffect != null) {
                j10 = 4294967295L;
                edgeEffect.setSize((int) (jB >> 32), (int) (jB & 4294967295L));
            } else {
                j10 = 4294967295L;
            }
            EdgeEffect edgeEffect2 = zVar2.f13098e;
            if (edgeEffect2 != null) {
                c9 = ' ';
                edgeEffect2.setSize((int) (jB >> 32), (int) (jB & j10));
            } else {
                c9 = ' ';
            }
            EdgeEffect edgeEffect3 = zVar2.f13099f;
            if (edgeEffect3 != null) {
                edgeEffect3.setSize((int) (jB & j10), (int) (jB >> c9));
            }
            EdgeEffect edgeEffect4 = zVar2.f13100g;
            if (edgeEffect4 != null) {
                edgeEffect4.setSize((int) (jB & j10), (int) (jB >> c9));
            }
            EdgeEffect edgeEffect5 = zVar2.f13101h;
            if (edgeEffect5 != null) {
                edgeEffect5.setSize((int) (jB >> c9), (int) (jB & j10));
            }
            EdgeEffect edgeEffect6 = zVar2.i;
            if (edgeEffect6 != null) {
                edgeEffect6.setSize((int) (jB >> c9), (int) (jB & j10));
            }
            EdgeEffect edgeEffect7 = zVar2.f13102j;
            if (edgeEffect7 != null) {
                edgeEffect7.setSize((int) (jB & j10), (int) (jB >> c9));
            }
            EdgeEffect edgeEffect8 = zVar2.f13103k;
            if (edgeEffect8 != null) {
                edgeEffect8.setSize((int) (jB & j10), (int) (jB >> c9));
            }
        }
        if (!zB && !zB2) {
            fVar.g();
            fVar.e();
        }
        if (c1.e.f(bVar.e())) {
            i0Var.b();
            return;
        }
        fVar.f12971g.getValue();
        float fX = i0Var.X(u.f13065a);
        Canvas canvasA = d1.b.a(bVar.f3859f.y());
        boolean z10 = z.f(zVar.f13097d) || z.g(zVar.f13101h) || z.f(zVar.f13098e) || z.g(zVar.i);
        boolean z11 = z.f(zVar.f13099f) || z.g(zVar.f13102j) || z.f(zVar.f13100g) || z.g(zVar.f13103k);
        if (z10 && z11) {
            z().setPosition(0, 0, canvasA.getWidth(), canvasA.getHeight());
        } else if (z10) {
            z().setPosition(0, 0, (ac.a.Q(fX) * 2) + canvasA.getWidth(), canvasA.getHeight());
        } else {
            if (!z11) {
                i0Var.b();
                return;
            }
            z().setPosition(0, 0, canvasA.getWidth(), (ac.a.Q(fX) * 2) + canvasA.getHeight());
        }
        RecordingCanvas recordingCanvasBeginRecording = z().beginRecording();
        if (z.g(zVar.f13102j)) {
            EdgeEffect edgeEffectA = zVar.f13102j;
            if (edgeEffectA == null) {
                edgeEffectA = zVar.a();
                zVar.f13102j = edgeEffectA;
            }
            y(90.0f, edgeEffectA, recordingCanvasBeginRecording);
            edgeEffectA.finish();
        }
        boolean zF = z.f(zVar.f13099f);
        g gVar = g.f12979a;
        if (zF) {
            EdgeEffect edgeEffectC = zVar.c();
            zY = y(270.0f, edgeEffectC, recordingCanvasBeginRecording);
            if (z.g(zVar.f13099f)) {
                float f11 = c1.b.f(fVar.f());
                EdgeEffect edgeEffectA2 = zVar.f13102j;
                if (edgeEffectA2 == null) {
                    edgeEffectA2 = zVar.a();
                    zVar.f13102j = edgeEffectA2;
                }
                gVar.c(edgeEffectA2, gVar.b(edgeEffectC), 1 - f11);
            }
        } else {
            zY = false;
        }
        if (z.g(zVar.f13101h)) {
            EdgeEffect edgeEffectA3 = zVar.f13101h;
            if (edgeEffectA3 == null) {
                edgeEffectA3 = zVar.a();
                zVar.f13101h = edgeEffectA3;
            }
            y(180.0f, edgeEffectA3, recordingCanvasBeginRecording);
            edgeEffectA3.finish();
        }
        if (z.f(zVar.f13097d)) {
            EdgeEffect edgeEffectE = zVar.e();
            zY = y(0.0f, edgeEffectE, recordingCanvasBeginRecording) || zY;
            if (z.g(zVar.f13097d)) {
                float fE = c1.b.e(fVar.f());
                EdgeEffect edgeEffectA4 = zVar.f13101h;
                if (edgeEffectA4 == null) {
                    edgeEffectA4 = zVar.a();
                    zVar.f13101h = edgeEffectA4;
                }
                gVar.c(edgeEffectA4, gVar.b(edgeEffectE), fE);
            }
        }
        if (z.g(zVar.f13103k)) {
            EdgeEffect edgeEffectA5 = zVar.f13103k;
            if (edgeEffectA5 == null) {
                edgeEffectA5 = zVar.a();
                zVar.f13103k = edgeEffectA5;
            }
            y(270.0f, edgeEffectA5, recordingCanvasBeginRecording);
            edgeEffectA5.finish();
        }
        if (z.f(zVar.f13100g)) {
            EdgeEffect edgeEffectD = zVar.d();
            zY = y(90.0f, edgeEffectD, recordingCanvasBeginRecording) || zY;
            if (z.g(zVar.f13100g)) {
                float f12 = c1.b.f(fVar.f());
                EdgeEffect edgeEffectA6 = zVar.f13103k;
                if (edgeEffectA6 == null) {
                    edgeEffectA6 = zVar.a();
                    zVar.f13103k = edgeEffectA6;
                }
                gVar.c(edgeEffectA6, gVar.b(edgeEffectD), f12);
            }
        }
        if (z.g(zVar.i)) {
            EdgeEffect edgeEffectA7 = zVar.i;
            if (edgeEffectA7 == null) {
                edgeEffectA7 = zVar.a();
                zVar.i = edgeEffectA7;
            }
            y(0.0f, edgeEffectA7, recordingCanvasBeginRecording);
            edgeEffectA7.finish();
        }
        if (z.f(zVar.f13098e)) {
            EdgeEffect edgeEffectB = zVar.b();
            boolean z12 = y(180.0f, edgeEffectB, recordingCanvasBeginRecording) || zY;
            if (z.g(zVar.f13098e)) {
                float fE2 = c1.b.e(fVar.f());
                EdgeEffect edgeEffectA8 = zVar.i;
                if (edgeEffectA8 == null) {
                    edgeEffectA8 = zVar.a();
                    zVar.i = edgeEffectA8;
                }
                gVar.c(edgeEffectA8, gVar.b(edgeEffectB), 1 - fE2);
            }
            zY = z12;
        }
        if (zY) {
            fVar.g();
        }
        float f13 = z11 ? 0.0f : fX;
        if (z10) {
            fX = 0.0f;
        }
        o2.l layoutDirection = i0Var.getLayoutDirection();
        d1.a aVar = new d1.a();
        aVar.f2954a = recordingCanvasBeginRecording;
        long jE2 = bVar.e();
        p5.m mVar = bVar.f3859f;
        f1.a aVar2 = ((f1.b) mVar.f9743h).f3858c;
        o2.c cVar = aVar2.f3854a;
        o2.l lVar = aVar2.f3855b;
        d1.o oVarY = mVar.y();
        long jD = bVar.f3859f.D();
        p5.m mVar2 = bVar.f3859f;
        g1.b bVar2 = (g1.b) mVar2.f9742g;
        mVar2.P(i0Var);
        mVar2.Q(layoutDirection);
        mVar2.O(aVar);
        mVar2.R(jE2);
        mVar2.f9742g = null;
        aVar.i();
        try {
            ((a1.g) bVar.f3859f.f9741f).z(f13, fX);
            try {
                i0Var.b();
                aVar.o();
                p5.m mVar3 = bVar.f3859f;
                mVar3.P(cVar);
                mVar3.Q(lVar);
                mVar3.O(oVarY);
                mVar3.R(jD);
                mVar3.f9742g = bVar2;
                z().endRecording();
                int iSave = canvasA.save();
                canvasA.translate(f5, f10);
                canvasA.drawRenderNode(z());
                canvasA.restoreToCount(iSave);
            } finally {
                ((a1.g) bVar.f3859f.f9741f).z(-f13, -fX);
            }
        } catch (Throwable th) {
            aVar.o();
            p5.m mVar4 = bVar.f3859f;
            mVar4.P(cVar);
            mVar4.Q(lVar);
            mVar4.O(oVarY);
            mVar4.R(jD);
            mVar4.f9742g = bVar2;
            throw th;
        }
    }

    public final RenderNode z() {
        RenderNode renderNode = this.f13091h;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode renderNode2 = new RenderNode("AndroidEdgeEffectOverscrollEffect");
        this.f13091h = renderNode2;
        return renderNode2;
    }
}
