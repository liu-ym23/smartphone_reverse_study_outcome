package d2;

import android.graphics.Canvas;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final k2.d f3036a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3037b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3038c;

    /* renamed from: d, reason: collision with root package name */
    public final e2.i f3039d;

    /* renamed from: e, reason: collision with root package name */
    public final CharSequence f3040e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f3041f;

    /* JADX WARN: Removed duplicated region for block: B:101:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(k2.d r21, int r22, int r23, long r24) {
        /*
            Method dump skipped, instructions count: 821
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.a.<init>(k2.d, int, int, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b8  */
    /* JADX WARN: Type inference failed for: r12v2, types: [f2.h] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [f2.h[]] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [android.graphics.Paint$FontMetricsInt] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e2.i a(int r32, int r33, android.text.TextUtils.TruncateAt r34, int r35, int r36, int r37, int r38, int r39, java.lang.CharSequence r40) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.a.a(int, int, android.text.TextUtils$TruncateAt, int, int, int, int, int, java.lang.CharSequence):e2.i");
    }

    public final float b() {
        return this.f3039d.a();
    }

    public final float c() {
        return o2.a.i(this.f3038c);
    }

    public final void d(d1.o oVar) {
        Canvas canvasA = d1.b.a(oVar);
        e2.i iVar = this.f3039d;
        if (iVar.f3437d) {
            canvasA.save();
            canvasA.clipRect(0.0f, 0.0f, c(), b());
        }
        int i = iVar.f3440g;
        if (canvasA.getClipBounds(iVar.f3447o)) {
            if (i != 0) {
                canvasA.translate(0.0f, i);
            }
            e2.h hVar = e2.j.f3449a;
            hVar.f3433a = canvasA;
            iVar.f3438e.draw(hVar);
            if (i != 0) {
                canvasA.translate(0.0f, (-1) * i);
            }
        }
        if (iVar.f3437d) {
            canvasA.restore();
        }
    }

    public final void e(d1.o oVar, long j10, d1.i0 i0Var, n2.l lVar, td.h hVar) {
        k2.f fVar = this.f3036a.f7186g;
        int i = fVar.f7195c;
        fVar.d(j10);
        fVar.f(i0Var);
        fVar.g(lVar);
        fVar.e(hVar);
        fVar.b(3);
        d(oVar);
        fVar.b(i);
    }

    public final void f(d1.o oVar, d1.f0 f0Var, float f5, d1.i0 i0Var, n2.l lVar, td.h hVar) {
        k2.f fVar = this.f3036a.f7186g;
        int i = fVar.f7195c;
        float fC = c();
        float fB = b();
        fVar.c(f0Var, (Float.floatToRawIntBits(fB) & 4294967295L) | (Float.floatToRawIntBits(fC) << 32), f5);
        fVar.f(i0Var);
        fVar.g(lVar);
        fVar.e(hVar);
        fVar.b(3);
        d(oVar);
        fVar.b(i);
    }
}
