package t;

import android.widget.EdgeEffect;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements b1 {

    /* renamed from: c, reason: collision with root package name */
    public c1.b f12969c;

    /* renamed from: f, reason: collision with root package name */
    public z f12970f;

    /* renamed from: g, reason: collision with root package name */
    public k0.k1 f12971g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12972h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public long f12973j;

    /* renamed from: k, reason: collision with root package name */
    public o1.r f12974k;

    /* renamed from: l, reason: collision with root package name */
    public w0.m f12975l;

    /* JADX WARN: Code restructure failed: missing block: B:50:0x011c, code lost:
    
        if (r1 == r5) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // t.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r18, m8.h r20, nb.c r21) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t.f.a(long, m8.h, nb.c):java.lang.Object");
    }

    @Override // t.b1
    public final w0.m b() {
        return this.f12975l;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0135 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0139  */
    @Override // t.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long c(long r18, int r20, a2.m r21) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t.f.c(long, int, a2.m):long");
    }

    @Override // t.b1
    public final boolean d() {
        z zVar = this.f12970f;
        EdgeEffect edgeEffect = zVar.f13097d;
        g gVar = g.f12979a;
        if (edgeEffect != null && gVar.b(edgeEffect) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect2 = zVar.f13098e;
        if (edgeEffect2 != null && gVar.b(edgeEffect2) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect3 = zVar.f13099f;
        if (edgeEffect3 != null && gVar.b(edgeEffect3) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect4 = zVar.f13100g;
        return (edgeEffect4 == null || gVar.b(edgeEffect4) == 0.0f) ? false : true;
    }

    public final void e() {
        boolean zIsFinished;
        z zVar = this.f12970f;
        EdgeEffect edgeEffect = zVar.f13097d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = edgeEffect.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = zVar.f13098e;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished = edgeEffect2.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect3 = zVar.f13099f;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished = edgeEffect3.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect4 = zVar.f13100g;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished = edgeEffect4.isFinished() || zIsFinished;
        }
        if (zIsFinished) {
            g();
        }
    }

    public final long f() {
        c1.b bVar = this.f12969c;
        long jA = bVar != null ? bVar.f2165a : a.a.A(this.f12973j);
        return id.k.d(c1.b.e(jA) / c1.e.e(this.f12973j), c1.b.f(jA) / c1.e.c(this.f12973j));
    }

    public final void g() {
        if (this.f12972h) {
            this.f12971g.setValue(jb.v.f6774a);
        }
    }

    public final float h(long j10) {
        float fE = c1.b.e(f());
        float f5 = c1.b.f(j10) / c1.e.c(this.f12973j);
        EdgeEffect edgeEffectB = this.f12970f.b();
        float f10 = 1 - fE;
        g gVar = g.f12979a;
        return gVar.b(edgeEffectB) == 0.0f ? c1.e.c(this.f12973j) * (-gVar.c(edgeEffectB, -f5, f10)) : c1.b.f(j10);
    }

    public final float i(long j10) {
        float f5 = c1.b.f(f());
        float fE = c1.b.e(j10) / c1.e.e(this.f12973j);
        EdgeEffect edgeEffectC = this.f12970f.c();
        float f10 = 1 - f5;
        g gVar = g.f12979a;
        return gVar.b(edgeEffectC) == 0.0f ? c1.e.e(this.f12973j) * gVar.c(edgeEffectC, fE, f10) : c1.b.e(j10);
    }

    public final float j(long j10) {
        float f5 = c1.b.f(f());
        float fE = c1.b.e(j10) / c1.e.e(this.f12973j);
        EdgeEffect edgeEffectD = this.f12970f.d();
        g gVar = g.f12979a;
        return gVar.b(edgeEffectD) == 0.0f ? c1.e.e(this.f12973j) * (-gVar.c(edgeEffectD, -fE, f5)) : c1.b.e(j10);
    }

    public final float k(long j10) {
        float fE = c1.b.e(f());
        float f5 = c1.b.f(j10) / c1.e.c(this.f12973j);
        EdgeEffect edgeEffectE = this.f12970f.e();
        g gVar = g.f12979a;
        return gVar.b(edgeEffectE) == 0.0f ? c1.e.c(this.f12973j) * gVar.c(edgeEffectE, f5, fE) : c1.b.f(j10);
    }
}
