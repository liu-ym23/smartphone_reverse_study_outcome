package d2;

import android.graphics.RectF;
import android.text.Layout;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final h0 f3122a;

    /* renamed from: b, reason: collision with root package name */
    public final o f3123b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3124c;

    /* renamed from: d, reason: collision with root package name */
    public final float f3125d;

    /* renamed from: e, reason: collision with root package name */
    public final float f3126e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f3127f;

    public i0(h0 h0Var, o oVar, long j10) {
        this.f3122a = h0Var;
        this.f3123b = oVar;
        this.f3124c = j10;
        ArrayList arrayList = oVar.f3156h;
        float fD = 0.0f;
        this.f3125d = arrayList.isEmpty() ? 0.0f : ((q) arrayList.get(0)).f3159a.f3039d.d(0);
        if (!arrayList.isEmpty()) {
            q qVar = (q) kb.l.C0(arrayList);
            fD = qVar.f3159a.f3039d.d(r4.f3439f - 1) + qVar.f3164f;
        }
        this.f3126e = fD;
        this.f3127f = oVar.f3155g;
    }

    public final c1.c a(int i) {
        float fI;
        float fI2;
        float fH;
        float fH2;
        o oVar = this.f3123b;
        g gVar = (g) oVar.f3149a.f631a;
        if (i < 0 || i >= gVar.f3101f.length()) {
            StringBuilder sbT = k0.a.t(i, "offset(", ") is out of bounds [0, ");
            sbT.append(gVar.f3101f.length());
            sbT.append(')');
            i2.a.a(sbT.toString());
        }
        ArrayList arrayList = oVar.f3156h;
        q qVar = (q) arrayList.get(a.a.r(i, arrayList));
        a aVar = qVar.f3159a;
        int iA = qVar.a(i);
        CharSequence charSequence = aVar.f3040e;
        if (iA < 0 || iA >= charSequence.length()) {
            StringBuilder sbT2 = k0.a.t(iA, "offset(", ") is out of bounds [0,");
            sbT2.append(charSequence.length());
            sbT2.append(')');
            i2.a.a(sbT2.toString());
        }
        e2.i iVar = aVar.f3039d;
        Layout layout = iVar.f3438e;
        int lineForOffset = layout.getLineForOffset(iA);
        float fG = iVar.g(lineForOffset);
        float fE = iVar.e(lineForOffset);
        boolean z10 = layout.getParagraphDirection(lineForOffset) == 1;
        boolean zIsRtlCharAt = layout.isRtlCharAt(iA);
        if (!z10 || zIsRtlCharAt) {
            if (z10 && zIsRtlCharAt) {
                fH = iVar.i(iA, false);
                fH2 = iVar.i(iA + 1, true);
            } else if (zIsRtlCharAt) {
                fH = iVar.h(iA, false);
                fH2 = iVar.h(iA + 1, true);
            } else {
                fI = iVar.i(iA, false);
                fI2 = iVar.i(iA + 1, true);
            }
            float f5 = fH;
            fI = fH2;
            fI2 = f5;
        } else {
            fI = iVar.h(iA, false);
            fI2 = iVar.h(iA + 1, true);
        }
        RectF rectF = new RectF(fI, fG, fI2, fE);
        float f10 = rectF.left;
        float f11 = rectF.top;
        float f12 = rectF.right;
        float f13 = rectF.bottom;
        long jFloatToRawIntBits = (Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(qVar.f3164f) & 4294967295L);
        int i3 = (int) (jFloatToRawIntBits >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat(i3) + f10;
        int i10 = (int) (jFloatToRawIntBits & 4294967295L);
        return new c1.c(fIntBitsToFloat, Float.intBitsToFloat(i10) + f11, Float.intBitsToFloat(i3) + f12, Float.intBitsToFloat(i10) + f13);
    }

    public final int b(int i) {
        o oVar = this.f3123b;
        ArrayList arrayList = oVar.f3156h;
        q qVar = (q) arrayList.get(i >= ((g) oVar.f3149a.f631a).f3101f.length() ? ac.a.x(arrayList) : i < 0 ? 0 : a.a.r(i, arrayList));
        return qVar.f3159a.f3039d.f3438e.getLineForOffset(qVar.a(i)) + qVar.f3162d;
    }

    public final int c(float f5) {
        ArrayList arrayList = this.f3123b.f3156h;
        q qVar = (q) arrayList.get(a.a.t(arrayList, f5));
        int i = qVar.f3161c - qVar.f3160b;
        int i3 = qVar.f3162d;
        if (i == 0) {
            return i3;
        }
        a aVar = qVar.f3159a;
        float f10 = f5 - qVar.f3164f;
        e2.i iVar = aVar.f3039d;
        return iVar.f3438e.getLineForVertical(((int) f10) - iVar.f3440g) + i3;
    }

    public final int d(int i) {
        o oVar = this.f3123b;
        oVar.b(i);
        ArrayList arrayList = oVar.f3156h;
        q qVar = (q) arrayList.get(a.a.s(i, arrayList));
        a aVar = qVar.f3159a;
        return aVar.f3039d.f3438e.getLineStart(i - qVar.f3162d) + qVar.f3160b;
    }

    public final float e(int i) {
        o oVar = this.f3123b;
        oVar.b(i);
        ArrayList arrayList = oVar.f3156h;
        q qVar = (q) arrayList.get(a.a.s(i, arrayList));
        a aVar = qVar.f3159a;
        return aVar.f3039d.g(i - qVar.f3162d) + qVar.f3164f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return yb.k.a(this.f3122a, i0Var.f3122a) && this.f3123b.equals(i0Var.f3123b) && o2.k.b(this.f3124c, i0Var.f3124c) && this.f3125d == i0Var.f3125d && this.f3126e == i0Var.f3126e && yb.k.a(this.f3127f, i0Var.f3127f);
    }

    public final n2.j f(int i) {
        o oVar = this.f3123b;
        g gVar = (g) oVar.f3149a.f631a;
        if (i < 0 || i > gVar.f3101f.length()) {
            StringBuilder sbT = k0.a.t(i, "offset(", ") is out of bounds [0, ");
            sbT.append(gVar.f3101f.length());
            sbT.append(']');
            i2.a.a(sbT.toString());
        }
        int length = ((g) oVar.f3149a.f631a).f3101f.length();
        ArrayList arrayList = oVar.f3156h;
        q qVar = (q) arrayList.get(i == length ? ac.a.x(arrayList) : a.a.r(i, arrayList));
        a aVar = qVar.f3159a;
        int iA = qVar.a(i);
        e2.i iVar = aVar.f3039d;
        return iVar.f3438e.getParagraphDirection(iVar.f3438e.getLineForOffset(iA)) == 1 ? n2.j.f8659c : n2.j.f8660f;
    }

    public final d1.h g(int i, int i3) {
        o oVar = this.f3123b;
        g gVar = (g) oVar.f3149a.f631a;
        if (i < 0 || i > i3 || i3 > gVar.f3101f.length()) {
            StringBuilder sbU = k0.a.u("Start(", i, ") or End(", ") is out of range [0..", i3);
            sbU.append(gVar.f3101f.length());
            sbU.append("), or start > end!");
            i2.a.a(sbU.toString());
        }
        if (i == i3) {
            return d1.k.a();
        }
        d1.h hVarA = d1.k.a();
        ArrayList arrayList = oVar.f3156h;
        long jA = com.stepos.statsrpk.h.a(i, i3);
        n nVar = new n(0);
        nVar.f3147h = hVarA;
        nVar.f3145f = i;
        nVar.f3146g = i3;
        VarHandle.storeStoreFence();
        int size = arrayList.size();
        for (int iR = a.a.r(k0.a(jA), arrayList); iR < size; iR++) {
            q qVar = (q) arrayList.get(iR);
            if (qVar.f3160b >= Math.max((int) (jA >> 32), (int) (4294967295L & jA))) {
                break;
            }
            if (qVar.f3160b != qVar.f3161c) {
                nVar.invoke(qVar);
            }
        }
        return hVarA;
    }

    public final int hashCode() {
        return this.f3127f.hashCode() + k0.a.g(k0.a.g(k0.a.i(this.f3124c, (this.f3123b.hashCode() + (this.f3122a.hashCode() * 31)) * 31, 31), this.f3125d, 31), this.f3126e, 31);
    }

    public final String toString() {
        return "TextLayoutResult(layoutInput=" + this.f3122a + ", multiParagraph=" + this.f3123b + ", size=" + ((Object) o2.k.c(this.f3124c)) + ", firstBaseline=" + this.f3125d + ", lastBaseline=" + this.f3126e + ", placeholderRects=" + this.f3127f + ')';
    }
}
