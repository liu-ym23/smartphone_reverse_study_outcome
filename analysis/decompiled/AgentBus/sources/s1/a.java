package s1;

import android.graphics.Canvas;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final z1.d f9204a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9205b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9206c;

    /* renamed from: d, reason: collision with root package name */
    public final t1.h f9207d;

    /* renamed from: e, reason: collision with root package name */
    public final CharSequence f9208e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f9209f;

    /* JADX WARN: Removed duplicated region for block: B:102:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(z1.d r21, int r22, int r23, long r24) {
        /*
            Method dump skipped, instructions count: 839
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.a.<init>(z1.d, int, int, long):void");
    }

    public final t1.h a(int i2, int i10, TextUtils.TruncateAt truncateAt, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence) {
        r rVar;
        float fC = c();
        z1.d dVar = this.f9204a;
        z1.e eVar = dVar.f11764l;
        int i16 = dVar.f11769q;
        t1.d dVar2 = dVar.f11766n;
        h0 h0Var = dVar.f11759g;
        z1.a aVar = z1.b.f11756a;
        s sVar = h0Var.f9274c;
        return new t1.h(charSequence, fC, eVar, i2, truncateAt, i16, (sVar == null || (rVar = sVar.f9305a) == null) ? false : rVar.f9304a, i11, i13, i14, i15, i12, i10, dVar2);
    }

    public final float b() {
        return this.f9207d.a();
    }

    public final float c() {
        return d2.a.h(this.f9206c);
    }

    public final void d(u0.l lVar) {
        Canvas canvasA = u0.b.a(lVar);
        t1.h hVar = this.f9207d;
        if (hVar.f9690d) {
            canvasA.save();
            canvasA.clipRect(0.0f, 0.0f, c(), b());
        }
        int i2 = hVar.f9693g;
        if (canvasA.getClipBounds(hVar.f9701o)) {
            if (i2 != 0) {
                canvasA.translate(0.0f, i2);
            }
            t1.g gVar = t1.i.f9703a;
            gVar.f9686a = canvasA;
            hVar.f9691e.draw(gVar);
            if (i2 != 0) {
                canvasA.translate(0.0f, (-1) * i2);
            }
        }
        if (hVar.f9690d) {
            canvasA.restore();
        }
    }
}
