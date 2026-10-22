package t;

import com.stepos.alphame.utils.Property;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public final b f15270d;

    /* renamed from: a, reason: collision with root package name */
    public i f15267a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f15268b = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f15269c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f15271e = false;

    public c(d dVar) {
        this.f15270d = new a(this, dVar);
    }

    public final void a(e eVar, int i4) {
        this.f15270d.d(eVar.j(i4), 1.0f);
        this.f15270d.d(eVar.j(i4), -1.0f);
    }

    public final void b(i iVar, i iVar2, i iVar3, int i4) {
        boolean z4;
        if (i4 != 0) {
            if (i4 < 0) {
                i4 *= -1;
                z4 = true;
            } else {
                z4 = false;
            }
            this.f15268b = i4;
            if (z4) {
                this.f15270d.d(iVar, 1.0f);
                this.f15270d.d(iVar2, -1.0f);
                this.f15270d.d(iVar3, -1.0f);
                return;
            }
        }
        this.f15270d.d(iVar, -1.0f);
        this.f15270d.d(iVar2, 1.0f);
        this.f15270d.d(iVar3, 1.0f);
    }

    public final void c(i iVar, i iVar2, i iVar3, int i4) {
        boolean z4;
        if (i4 != 0) {
            if (i4 < 0) {
                i4 *= -1;
                z4 = true;
            } else {
                z4 = false;
            }
            this.f15268b = i4;
            if (z4) {
                this.f15270d.d(iVar, 1.0f);
                this.f15270d.d(iVar2, -1.0f);
                this.f15270d.d(iVar3, 1.0f);
                return;
            }
        }
        this.f15270d.d(iVar, -1.0f);
        this.f15270d.d(iVar2, 1.0f);
        this.f15270d.d(iVar3, -1.0f);
    }

    public i d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.f15267a == null && this.f15268b == Property.DEFAULT_FLOAT_VALUE && this.f15270d.f() == 0;
    }

    public final i f(boolean[] zArr, i iVar) {
        int i4;
        int iF = this.f15270d.f();
        i iVar2 = null;
        float f4 = 0.0f;
        for (int i5 = 0; i5 < iF; i5++) {
            float fA = this.f15270d.a(i5);
            if (fA < Property.DEFAULT_FLOAT_VALUE) {
                i iVarH = this.f15270d.h(i5);
                if ((zArr == null || !zArr[iVarH.f15302b]) && iVarH != iVar && (((i4 = iVarH.f15312l) == 3 || i4 == 4) && fA < f4)) {
                    f4 = fA;
                    iVar2 = iVarH;
                }
            }
        }
        return iVar2;
    }

    public final void g(i iVar) {
        i iVar2 = this.f15267a;
        if (iVar2 != null) {
            this.f15270d.d(iVar2, -1.0f);
            this.f15267a.f15303c = -1;
            this.f15267a = null;
        }
        float fC = this.f15270d.c(iVar, true) * (-1.0f);
        this.f15267a = iVar;
        if (fC == 1.0f) {
            return;
        }
        this.f15268b /= fC;
        this.f15270d.i(fC);
    }

    public final void h(e eVar, i iVar, boolean z4) {
        if (iVar == null || !iVar.f15306f) {
            return;
        }
        float fE = this.f15270d.e(iVar);
        this.f15268b = (iVar.f15305e * fE) + this.f15268b;
        this.f15270d.c(iVar, z4);
        if (z4) {
            iVar.b(this);
        }
        if (this.f15270d.f() == 0) {
            this.f15271e = true;
            eVar.f15279a = true;
        }
    }

    public void i(e eVar, c cVar, boolean z4) {
        float fB = this.f15270d.b(cVar, z4);
        this.f15268b = (cVar.f15268b * fB) + this.f15268b;
        if (z4) {
            cVar.f15267a.b(this);
        }
        if (this.f15267a == null || this.f15270d.f() != 0) {
            return;
        }
        this.f15271e = true;
        eVar.f15279a = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            t.i r0 = r10.f15267a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            t.i r1 = r10.f15267a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = androidx.room.AbstractC0351g.p(r0, r1)
            float r1 = r10.f15268b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = B0.g.s(r0)
            float r1 = r10.f15268b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r3
            goto L36
        L35:
            r1 = r4
        L36:
            t.b r5 = r10.f15270d
            int r5 = r5.f()
        L3c:
            if (r4 >= r5) goto L9c
            t.b r6 = r10.f15270d
            t.i r6 = r6.h(r4)
            if (r6 != 0) goto L47
            goto L99
        L47:
            t.b r7 = r10.f15270d
            float r7 = r7.a(r4)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L52
            goto L99
        L52:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L66
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L76
            java.lang.String r1 = "- "
            java.lang.String r0 = androidx.room.AbstractC0351g.p(r0, r1)
        L64:
            float r7 = r7 * r9
            goto L76
        L66:
            if (r8 <= 0) goto L6f
            java.lang.String r1 = " + "
            java.lang.String r0 = androidx.room.AbstractC0351g.p(r0, r1)
            goto L76
        L6f:
            java.lang.String r1 = " - "
            java.lang.String r0 = androidx.room.AbstractC0351g.p(r0, r1)
            goto L64
        L76:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L81
            java.lang.String r0 = androidx.room.AbstractC0351g.p(r0, r6)
            goto L98
        L81:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L98:
            r1 = r3
        L99:
            int r4 = r4 + 1
            goto L3c
        L9c:
            if (r1 != 0) goto La4
            java.lang.String r10 = "0.0"
            java.lang.String r0 = androidx.room.AbstractC0351g.p(r0, r10)
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t.c.toString():java.lang.String");
    }
}
