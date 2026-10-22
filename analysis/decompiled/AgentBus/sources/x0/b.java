package x0;

import android.graphics.Outline;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.os.Build;
import c1.o;
import d2.l;
import h4.s;
import java.util.Locale;
import q7.k;
import q7.m;
import t0.e;
import u0.f;
import u0.t;
import u0.u;
import u0.v;
import u0.w;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final c f11063a;

    /* renamed from: f, reason: collision with root package name */
    public Outline f11068f;

    /* renamed from: j, reason: collision with root package name */
    public float f11072j;

    /* renamed from: k, reason: collision with root package name */
    public w f11073k;

    /* renamed from: l, reason: collision with root package name */
    public f f11074l;

    /* renamed from: m, reason: collision with root package name */
    public f f11075m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11076n;

    /* renamed from: o, reason: collision with root package name */
    public w0.b f11077o;

    /* renamed from: p, reason: collision with root package name */
    public s f11078p;

    /* renamed from: q, reason: collision with root package name */
    public int f11079q;

    /* renamed from: s, reason: collision with root package name */
    public boolean f11081s;

    /* renamed from: t, reason: collision with root package name */
    public long f11082t;

    /* renamed from: u, reason: collision with root package name */
    public long f11083u;

    /* renamed from: v, reason: collision with root package name */
    public long f11084v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f11085w;

    /* renamed from: x, reason: collision with root package name */
    public RectF f11086x;

    /* renamed from: b, reason: collision with root package name */
    public d2.c f11064b = w0.c.f10633a;

    /* renamed from: c, reason: collision with root package name */
    public l f11065c = l.f2793f;

    /* renamed from: d, reason: collision with root package name */
    public m f11066d = a.f11062g;

    /* renamed from: e, reason: collision with root package name */
    public final r8.c f11067e = new r8.c(15, this);

    /* renamed from: g, reason: collision with root package name */
    public boolean f11069g = true;

    /* renamed from: h, reason: collision with root package name */
    public long f11070h = 0;

    /* renamed from: i, reason: collision with root package name */
    public long f11071i = 9205357640488583168L;

    /* renamed from: r, reason: collision with root package name */
    public final o f11080r = new o();

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        k.d(lowerCase, "toLowerCase(...)");
        lowerCase.equals("robolectric");
    }

    public b(c cVar) {
        this.f11063a = cVar;
        cVar.c(false);
        this.f11082t = 0L;
        this.f11083u = 0L;
        this.f11084v = 9205357640488583168L;
    }

    public final void a() {
        c cVar = this.f11063a;
        RenderNode renderNode = cVar.f11089c;
        if (this.f11069g) {
            boolean z4 = this.f11085w;
            if (z4 || cVar.f11098l > 0.0f) {
                f fVar = this.f11074l;
                if (fVar != null) {
                    RectF rectF = this.f11086x;
                    if (rectF == null) {
                        rectF = new RectF();
                        this.f11086x = rectF;
                    }
                    boolean z10 = fVar instanceof f;
                    if (!z10) {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                    fVar.f9903a.computeBounds(rectF, false);
                    Outline outline = this.f11068f;
                    if (outline == null) {
                        outline = new Outline();
                        this.f11068f = outline;
                    }
                    if (!z10) {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                    outline.setPath(fVar.f9903a);
                    this.f11076n = !outline.canClip();
                    this.f11074l = fVar;
                    outline.setAlpha(cVar.f11094h);
                    Math.round(rectF.width());
                    Math.round(rectF.height());
                    renderNode.setOutline(outline);
                    cVar.f11093g = true;
                    cVar.a();
                    if (this.f11076n && this.f11085w) {
                        cVar.c(false);
                        renderNode.discardDisplayList();
                    } else {
                        cVar.c(this.f11085w);
                    }
                } else {
                    cVar.c(z4);
                    Outline outline2 = this.f11068f;
                    if (outline2 == null) {
                        outline2 = new Outline();
                        this.f11068f = outline2;
                    }
                    Outline outline3 = outline2;
                    long jW = ib.k.W(this.f11083u);
                    long j2 = this.f11070h;
                    long j4 = this.f11071i;
                    if (j4 != 9205357640488583168L) {
                        jW = j4;
                    }
                    int i2 = (int) (j2 >> 32);
                    int i10 = (int) (j2 & 4294967295L);
                    int i11 = (int) (jW >> 32);
                    int i12 = (int) (jW & 4294967295L);
                    outline3.setRoundRect(Math.round(Float.intBitsToFloat(i2)), Math.round(Float.intBitsToFloat(i10)), Math.round(Float.intBitsToFloat(i11) + Float.intBitsToFloat(i2)), Math.round(Float.intBitsToFloat(i12) + Float.intBitsToFloat(i10)), this.f11072j);
                    outline3.setAlpha(cVar.f11094h);
                    Math.round(Float.intBitsToFloat(i11));
                    Math.round(Float.intBitsToFloat(i12));
                    renderNode.setOutline(outline3);
                    cVar.f11093g = true;
                    cVar.a();
                }
            } else {
                cVar.c(false);
                renderNode.setOutline(null);
                cVar.f11093g = false;
                cVar.a();
            }
        }
        this.f11069g = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r15 = this;
            boolean r0 = r15.f11081s
            if (r0 == 0) goto L6b
            int r0 = r15.f11079q
            if (r0 != 0) goto L6b
            c1.o r0 = r15.f11080r
            java.lang.Object r1 = r0.f1834b
            x0.b r1 = (x0.b) r1
            if (r1 == 0) goto L16
            r1.e()
            r1 = 0
            r0.f1834b = r1
        L16:
            java.lang.Object r0 = r0.f1836d
            k.b0 r0 = (k.b0) r0
            if (r0 == 0) goto L64
            java.lang.Object[] r1 = r0.f5454b
            long[] r2 = r0.f5453a
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
            x0.b r11 = (x0.b) r11
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
            x0.c r15 = r15.f11063a
            android.graphics.RenderNode r15 = r15.f11089c
            r15.discardDisplayList()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.b.b():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARN: Type inference failed for: r13v1, types: [p7.k, q7.m] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(w0.d r14) {
        /*
            r13 = this;
            c1.o r0 = r13.f11080r
            java.lang.Object r1 = r0.f1834b
            x0.b r1 = (x0.b) r1
            r0.f1835c = r1
            java.lang.Object r1 = r0.f1836d
            k.b0 r1 = (k.b0) r1
            if (r1 == 0) goto L29
            boolean r2 = r1.h()
            if (r2 == 0) goto L29
            java.lang.Object r2 = r0.f1837e
            k.b0 r2 = (k.b0) r2
            if (r2 != 0) goto L23
            int r2 = k.h0.f5493a
            k.b0 r2 = new k.b0
            r2.<init>()
            r0.f1837e = r2
        L23:
            r2.j(r1)
            r1.b()
        L29:
            r1 = 1
            r0.f1833a = r1
            q7.m r13 = r13.f11066d
            r13.invoke(r14)
            r13 = 0
            r0.f1833a = r13
            java.lang.Object r14 = r0.f1835c
            x0.b r14 = (x0.b) r14
            if (r14 == 0) goto L3d
            r14.e()
        L3d:
            java.lang.Object r14 = r0.f1837e
            k.b0 r14 = (k.b0) r14
            if (r14 == 0) goto L90
            boolean r0 = r14.h()
            if (r0 == 0) goto L90
            java.lang.Object[] r0 = r14.f5454b
            long[] r1 = r14.f5453a
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
            x0.b r9 = (x0.b) r9
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
        throw new UnsupportedOperationException("Method not decompiled: x0.b.c(w0.d):void");
    }

    public final w d() {
        w uVar;
        w wVar = this.f11073k;
        f fVar = this.f11074l;
        if (wVar != null) {
            return wVar;
        }
        if (fVar != null) {
            t tVar = new t(fVar);
            this.f11073k = tVar;
            return tVar;
        }
        long jW = ib.k.W(this.f11083u);
        long j2 = this.f11070h;
        long j4 = this.f11071i;
        if (j4 != 9205357640488583168L) {
            jW = j4;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jW >> 32)) + fIntBitsToFloat;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jW & 4294967295L)) + fIntBitsToFloat2;
        if (this.f11072j > 0.0f) {
            uVar = new v(n7.o.c(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, (Float.floatToRawIntBits(r0) << 32) | (4294967295L & Float.floatToRawIntBits(r0))));
        } else {
            uVar = new u(new t0.c(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4));
        }
        this.f11073k = uVar;
        return uVar;
    }

    public final void e() {
        this.f11079q--;
        b();
    }

    public final void f(long j2, long j4, float f10) {
        if (t0.b.b(this.f11070h, j2) && e.a(this.f11071i, j4) && this.f11072j == f10 && this.f11074l == null) {
            return;
        }
        this.f11073k = null;
        this.f11074l = null;
        this.f11069g = true;
        this.f11076n = false;
        this.f11070h = j2;
        this.f11071i = j4;
        this.f11072j = f10;
        a();
    }
}
