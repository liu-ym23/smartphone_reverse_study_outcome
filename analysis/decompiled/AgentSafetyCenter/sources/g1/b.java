package g1;

import a1.g;
import a2.m;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.os.Build;
import d1.a0;
import d1.b0;
import d1.c0;
import d1.f;
import d1.h;
import d1.z;
import ed.e;
import java.util.Locale;
import o2.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final c f4201a;

    /* renamed from: f, reason: collision with root package name */
    public Outline f4206f;

    /* renamed from: j, reason: collision with root package name */
    public float f4209j;

    /* renamed from: k, reason: collision with root package name */
    public c0 f4210k;

    /* renamed from: l, reason: collision with root package name */
    public h f4211l;

    /* renamed from: m, reason: collision with root package name */
    public h f4212m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4213n;

    /* renamed from: o, reason: collision with root package name */
    public f1.b f4214o;

    /* renamed from: p, reason: collision with root package name */
    public f f4215p;

    /* renamed from: q, reason: collision with root package name */
    public int f4216q;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4218s;

    /* renamed from: t, reason: collision with root package name */
    public long f4219t;

    /* renamed from: u, reason: collision with root package name */
    public long f4220u;

    /* renamed from: v, reason: collision with root package name */
    public long f4221v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4222w;

    /* renamed from: x, reason: collision with root package name */
    public RectF f4223x;

    /* renamed from: b, reason: collision with root package name */
    public o2.c f4202b = f1.c.f3862a;

    /* renamed from: c, reason: collision with root package name */
    public l f4203c = l.f9123c;

    /* renamed from: d, reason: collision with root package name */
    public yb.l f4204d = a.f4200c;

    /* renamed from: e, reason: collision with root package name */
    public final m f4205e = new m(this, 3);

    /* renamed from: g, reason: collision with root package name */
    public boolean f4207g = true;

    /* renamed from: h, reason: collision with root package name */
    public long f4208h = 0;
    public long i = 9205357640488583168L;

    /* renamed from: r, reason: collision with root package name */
    public final e f4217r = new e();

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        lowerCase.equals("robolectric");
    }

    public b(c cVar) {
        this.f4201a = cVar;
        cVar.f4238p = false;
        cVar.a();
        this.f4219t = 0L;
        this.f4220u = 0L;
        this.f4221v = 9205357640488583168L;
    }

    public final void a() {
        c cVar = this.f4201a;
        RenderNode renderNode = cVar.f4226c;
        if (this.f4207g) {
            boolean z10 = this.f4222w;
            if (z10 || cVar.f4234l > 0.0f) {
                h hVar = this.f4211l;
                if (hVar != null) {
                    RectF rectF = this.f4223x;
                    if (rectF == null) {
                        rectF = new RectF();
                        this.f4223x = rectF;
                    }
                    boolean z11 = hVar instanceof h;
                    if (!z11) {
                        g5.f.o("Unable to obtain android.graphics.Path");
                        return;
                    }
                    hVar.f2990a.computeBounds(rectF, false);
                    Outline outline = this.f4206f;
                    if (outline == null) {
                        outline = new Outline();
                        this.f4206f = outline;
                    }
                    if (!z11) {
                        g5.f.o("Unable to obtain android.graphics.Path");
                        return;
                    }
                    outline.setPath(hVar.f2990a);
                    this.f4213n = !outline.canClip();
                    this.f4211l = hVar;
                    outline.setAlpha(cVar.f4231h);
                    Math.round(rectF.width());
                    Math.round(rectF.height());
                    renderNode.setOutline(outline);
                    cVar.f4230g = true;
                    cVar.a();
                    if (this.f4213n && this.f4222w) {
                        cVar.f4238p = false;
                        cVar.a();
                        renderNode.discardDisplayList();
                    } else {
                        cVar.f4238p = this.f4222w;
                        cVar.a();
                    }
                } else {
                    cVar.f4238p = z10;
                    cVar.a();
                    Outline outline2 = this.f4206f;
                    if (outline2 == null) {
                        outline2 = new Outline();
                        this.f4206f = outline2;
                    }
                    Outline outline3 = outline2;
                    long jI0 = ac.a.i0(this.f4220u);
                    long j10 = this.f4208h;
                    long j11 = this.i;
                    if (j11 != 9205357640488583168L) {
                        jI0 = j11;
                    }
                    int i = (int) (j10 >> 32);
                    int i3 = (int) (j10 & 4294967295L);
                    int i10 = (int) (jI0 >> 32);
                    int i11 = (int) (jI0 & 4294967295L);
                    outline3.setRoundRect(Math.round(Float.intBitsToFloat(i)), Math.round(Float.intBitsToFloat(i3)), Math.round(Float.intBitsToFloat(i10) + Float.intBitsToFloat(i)), Math.round(Float.intBitsToFloat(i11) + Float.intBitsToFloat(i3)), this.f4209j);
                    outline3.setAlpha(cVar.f4231h);
                    Math.round(Float.intBitsToFloat(i10));
                    Math.round(Float.intBitsToFloat(i11));
                    renderNode.setOutline(outline3);
                    cVar.f4230g = true;
                    cVar.a();
                }
            } else {
                cVar.f4238p = false;
                cVar.a();
                renderNode.setOutline(null);
                cVar.f4230g = false;
                cVar.a();
            }
        }
        this.f4207g = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r15 = this;
            boolean r0 = r15.f4218s
            if (r0 == 0) goto L6b
            int r0 = r15.f4216q
            if (r0 != 0) goto L6b
            ed.e r0 = r15.f4217r
            java.lang.Object r1 = r0.f3784b
            g1.b r1 = (g1.b) r1
            if (r1 == 0) goto L16
            r1.e()
            r1 = 0
            r0.f3784b = r1
        L16:
            java.lang.Object r0 = r0.f3786d
            p.g0 r0 = (p.g0) r0
            if (r0 == 0) goto L64
            java.lang.Object[] r1 = r0.f9561b
            long[] r2 = r0.f9560a
            int r3 = r2.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L61
            r4 = 0
            r5 = r4
        L27:
            r6 = r2[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L5c
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L41:
            if (r10 >= r8) goto L5a
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L56
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r1[r11]
            g1.b r11 = (g1.b) r11
            r11.e()
        L56:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L41
        L5a:
            if (r8 != r9) goto L61
        L5c:
            if (r5 == r3) goto L61
            int r5 = r5 + 1
            goto L27
        L61:
            r0.b()
        L64:
            g1.c r15 = r15.f4201a
            android.graphics.RenderNode r15 = r15.f4226c
            r15.discardDisplayList()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.b.b():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARN: Type inference failed for: r13v1, types: [xb.l, yb.l] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(f1.d r14) {
        /*
            r13 = this;
            ed.e r0 = r13.f4217r
            java.lang.Object r1 = r0.f3784b
            g1.b r1 = (g1.b) r1
            r0.f3785c = r1
            java.lang.Object r1 = r0.f3786d
            p.g0 r1 = (p.g0) r1
            if (r1 == 0) goto L29
            boolean r2 = r1.h()
            if (r2 == 0) goto L29
            java.lang.Object r2 = r0.f3787e
            p.g0 r2 = (p.g0) r2
            if (r2 != 0) goto L23
            int r2 = p.o0.f9601a
            p.g0 r2 = new p.g0
            r2.<init>()
            r0.f3787e = r2
        L23:
            r2.j(r1)
            r1.b()
        L29:
            r1 = 1
            r0.f3783a = r1
            yb.l r13 = r13.f4204d
            r13.invoke(r14)
            r13 = 0
            r0.f3783a = r13
            java.lang.Object r14 = r0.f3785c
            g1.b r14 = (g1.b) r14
            if (r14 == 0) goto L3d
            r14.e()
        L3d:
            java.lang.Object r14 = r0.f3787e
            p.g0 r14 = (p.g0) r14
            if (r14 == 0) goto L90
            boolean r0 = r14.h()
            if (r0 == 0) goto L90
            java.lang.Object[] r0 = r14.f9561b
            long[] r1 = r14.f9560a
            int r2 = r1.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L8d
            r3 = r13
        L53:
            r4 = r1[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L88
            int r6 = r3 - r2
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r13
        L6d:
            if (r8 >= r6) goto L86
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L82
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            g1.b r9 = (g1.b) r9
            r9.e()
        L82:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L6d
        L86:
            if (r6 != r7) goto L8d
        L88:
            if (r3 == r2) goto L8d
            int r3 = r3 + 1
            goto L53
        L8d:
            r14.b()
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.b.c(f1.d):void");
    }

    public final c0 d() {
        c0 a0Var;
        c0 c0Var = this.f4210k;
        h hVar = this.f4211l;
        if (c0Var != null) {
            return c0Var;
        }
        if (hVar != null) {
            z zVar = new z(hVar);
            this.f4210k = zVar;
            return zVar;
        }
        long jI0 = ac.a.i0(this.f4220u);
        long j10 = this.f4208h;
        long j11 = this.i;
        if (j11 != 9205357640488583168L) {
            jI0 = j11;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jI0 >> 32)) + fIntBitsToFloat;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jI0 & 4294967295L)) + fIntBitsToFloat2;
        if (this.f4209j > 0.0f) {
            a0Var = new b0(td.h.e(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, (Float.floatToRawIntBits(r0) << 32) | (4294967295L & Float.floatToRawIntBits(r0))));
        } else {
            a0Var = new a0(new c1.c(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4));
        }
        this.f4210k = a0Var;
        return a0Var;
    }

    public final void e() {
        this.f4216q--;
        b();
    }

    public final void f() {
        o2.c cVar = this.f4202b;
        l lVar = this.f4203c;
        m mVar = this.f4205e;
        c cVar2 = this.f4201a;
        f1.b bVar = cVar2.f4225b;
        RenderNode renderNode = cVar2.f4226c;
        RecordingCanvas recordingCanvasBeginRecording = renderNode.beginRecording();
        try {
            g gVar = cVar2.f4224a;
            d1.a aVar = (d1.a) gVar.f19f;
            Canvas canvas = aVar.f2954a;
            aVar.f2954a = recordingCanvasBeginRecording;
            p5.m mVar2 = bVar.f3859f;
            mVar2.P(cVar);
            mVar2.Q(lVar);
            mVar2.f9742g = this;
            mVar2.R(cVar2.f4227d);
            mVar2.O(aVar);
            mVar.invoke(bVar);
            ((d1.a) gVar.f19f).f2954a = canvas;
        } finally {
            renderNode.endRecording();
        }
    }

    public final void g(long j10) {
        if (c1.b.c(this.f4221v, j10)) {
            return;
        }
        this.f4221v = j10;
        long j11 = 9223372034707292159L & j10;
        RenderNode renderNode = this.f4201a.f4226c;
        if (j11 == 9205357640488583168L) {
            renderNode.resetPivot();
        } else {
            renderNode.setPivotX(Float.intBitsToFloat((int) (j10 >> 32)));
            renderNode.setPivotY(Float.intBitsToFloat((int) (j10 & 4294967295L)));
        }
    }

    public final void h(long j10, long j11) {
        int i = (int) (j10 >> 32);
        int i3 = (int) (j10 & 4294967295L);
        c cVar = this.f4201a;
        cVar.f4226c.setPosition(i, i3, ((int) (j11 >> 32)) + i, ((int) (4294967295L & j11)) + i3);
        cVar.f4227d = ac.a.i0(j11);
    }

    public final void i(long j10, long j11, float f5) {
        if (c1.b.c(this.f4208h, j10) && c1.e.b(this.i, j11) && this.f4209j == f5 && this.f4211l == null) {
            return;
        }
        this.f4210k = null;
        this.f4211l = null;
        this.f4207g = true;
        this.f4213n = false;
        this.f4208h = j10;
        this.i = j11;
        this.f4209j = f5;
        a();
    }
}
