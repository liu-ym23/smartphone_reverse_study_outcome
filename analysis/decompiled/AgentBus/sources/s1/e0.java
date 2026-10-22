package s1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f9249a;

    /* renamed from: b, reason: collision with root package name */
    public final l0.i f9250b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9251c;

    /* renamed from: d, reason: collision with root package name */
    public final float f9252d;

    /* renamed from: e, reason: collision with root package name */
    public final float f9253e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f9254f;

    public e0(d0 d0Var, l0.i iVar, long j2) {
        this.f9249a = d0Var;
        this.f9250b = iVar;
        this.f9251c = j2;
        ArrayList arrayList = (ArrayList) iVar.f5757e;
        float fC = 0.0f;
        this.f9252d = arrayList.isEmpty() ? 0.0f : ((m) arrayList.get(0)).f9283a.f9207d.c(0);
        if (!arrayList.isEmpty()) {
            m mVar = (m) d7.r.W0(arrayList);
            fC = mVar.f9283a.f9207d.c(r4.f9692f - 1) + mVar.f9288f;
        }
        this.f9253e = fC;
        this.f9254f = (ArrayList) iVar.f5756d;
    }

    public final int a(int i2) {
        l0.i iVar = this.f9250b;
        ArrayList arrayList = (ArrayList) iVar.f5757e;
        m mVar = (m) arrayList.get(i2 >= ((e) ((a3.b) iVar.f5755c).f162f).f9246g.length() ? d7.s.t0(arrayList) : i2 < 0 ? 0 : z.c(i2, arrayList));
        return mVar.f9283a.f9207d.f9691e.getLineForOffset(mVar.a(i2)) + mVar.f9286d;
    }

    public final int b(float f10) {
        ArrayList arrayList = (ArrayList) this.f9250b.f5757e;
        int iT0 = 0;
        if (f10 > 0.0f) {
            if (f10 < ((m) d7.r.W0(arrayList)).f9289g) {
                int size = arrayList.size() - 1;
                int i2 = 0;
                while (true) {
                    if (i2 > size) {
                        iT0 = -(i2 + 1);
                        break;
                    }
                    int i10 = (i2 + size) >>> 1;
                    m mVar = (m) arrayList.get(i10);
                    char c10 = mVar.f9288f > f10 ? (char) 1 : mVar.f9289g <= f10 ? (char) 65535 : (char) 0;
                    if (c10 >= 0) {
                        if (c10 <= 0) {
                            iT0 = i10;
                            break;
                        }
                        size = i10 - 1;
                    } else {
                        i2 = i10 + 1;
                    }
                }
            } else {
                iT0 = d7.s.t0(arrayList);
            }
        }
        m mVar2 = (m) arrayList.get(iT0);
        int i11 = mVar2.f9285c;
        int i12 = mVar2.f9286d;
        if (i11 - mVar2.f9284b == 0) {
            return i12;
        }
        a aVar = mVar2.f9283a;
        float f11 = f10 - mVar2.f9288f;
        t1.h hVar = aVar.f9207d;
        return hVar.f9691e.getLineForVertical(((int) f11) - hVar.f9693g) + i12;
    }

    public final int c(int i2) {
        l0.i iVar = this.f9250b;
        iVar.b(i2);
        ArrayList arrayList = (ArrayList) iVar.f5757e;
        m mVar = (m) arrayList.get(z.d(i2, arrayList));
        a aVar = mVar.f9283a;
        return aVar.f9207d.f9691e.getLineStart(i2 - mVar.f9286d) + mVar.f9284b;
    }

    public final float d(int i2) {
        l0.i iVar = this.f9250b;
        iVar.b(i2);
        ArrayList arrayList = (ArrayList) iVar.f5757e;
        m mVar = (m) arrayList.get(z.d(i2, arrayList));
        a aVar = mVar.f9283a;
        return aVar.f9207d.f(i2 - mVar.f9286d) + mVar.f9288f;
    }

    public final c2.j e(int i2) {
        l0.i iVar = this.f9250b;
        ArrayList arrayList = (ArrayList) iVar.f5757e;
        a3.b bVar = (a3.b) iVar.f5755c;
        boolean z4 = false;
        if (i2 >= 0 && i2 <= ((e) bVar.f162f).f9246g.length()) {
            z4 = true;
        }
        if (!z4) {
            StringBuilder sbN = a1.a.n(i2, "offset(", ") is out of bounds [0, ");
            sbN.append(((e) bVar.f162f).f9246g.length());
            sbN.append(']');
            x1.a.a(sbN.toString());
        }
        m mVar = (m) arrayList.get(i2 == ((e) ((a3.b) iVar.f5755c).f162f).f9246g.length() ? d7.s.t0(arrayList) : z.c(i2, arrayList));
        a aVar = mVar.f9283a;
        int iA = mVar.a(i2);
        t1.h hVar = aVar.f9207d;
        return hVar.f9691e.getParagraphDirection(hVar.f9691e.getLineForOffset(iA)) == 1 ? c2.j.f1871f : c2.j.f1872g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return q7.k.a(this.f9249a, e0Var.f9249a) && this.f9250b.equals(e0Var.f9250b) && d2.k.a(this.f9251c, e0Var.f9251c) && this.f9252d == e0Var.f9252d && this.f9253e == e0Var.f9253e && q7.k.a(this.f9254f, e0Var.f9254f);
    }

    public final int hashCode() {
        return this.f9254f.hashCode() + m.x.d(this.f9253e, m.x.d(this.f9252d, m.x.f(this.f9251c, (this.f9250b.hashCode() + (this.f9249a.hashCode() * 31)) * 31, 31), 31), 31);
    }

    public final String toString() {
        return "TextLayoutResult(layoutInput=" + this.f9249a + ", multiParagraph=" + this.f9250b + ", size=" + ((Object) d2.k.b(this.f9251c)) + ", firstBaseline=" + this.f9252d + ", lastBaseline=" + this.f9253e + ", placeholderRects=" + this.f9254f + ')';
    }
}
