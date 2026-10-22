package u2;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public final a f13993d;

    /* renamed from: a, reason: collision with root package name */
    public e f13990a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f13991b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f13992c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f13994e = false;

    public b(m mVar) {
        a aVar = new a();
        aVar.f13981a = 0;
        aVar.f13984d = 8;
        aVar.f13985e = new int[8];
        aVar.f13986f = new int[8];
        aVar.f13987g = new float[8];
        aVar.f13988h = -1;
        aVar.i = -1;
        aVar.f13989j = false;
        aVar.f13982b = this;
        aVar.f13983c = mVar;
        VarHandle.storeStoreFence();
        this.f13993d = aVar;
    }

    public final void a(c cVar, int i) {
        this.f13993d.g(cVar.j(i), 1.0f);
        this.f13993d.g(cVar.j(i), -1.0f);
    }

    public final void b(e eVar, e eVar2, e eVar3, int i) {
        boolean z10 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z10 = true;
            }
            this.f13991b = i;
        }
        a aVar = this.f13993d;
        if (z10) {
            aVar.g(eVar, 1.0f);
            this.f13993d.g(eVar2, -1.0f);
            this.f13993d.g(eVar3, -1.0f);
        } else {
            aVar.g(eVar, -1.0f);
            this.f13993d.g(eVar2, 1.0f);
            this.f13993d.g(eVar3, 1.0f);
        }
    }

    public final void c(e eVar, e eVar2, e eVar3, int i) {
        boolean z10 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z10 = true;
            }
            this.f13991b = i;
        }
        a aVar = this.f13993d;
        if (z10) {
            aVar.g(eVar, 1.0f);
            this.f13993d.g(eVar2, -1.0f);
            this.f13993d.g(eVar3, 1.0f);
        } else {
            aVar.g(eVar, -1.0f);
            this.f13993d.g(eVar2, 1.0f);
            this.f13993d.g(eVar3, -1.0f);
        }
    }

    public e d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.f13990a == null && this.f13991b == 0.0f && this.f13993d.d() == 0;
    }

    public final e f(boolean[] zArr, e eVar) {
        int i;
        int iD = this.f13993d.d();
        e eVar2 = null;
        float f5 = 0.0f;
        for (int i3 = 0; i3 < iD; i3++) {
            float f10 = this.f13993d.f(i3);
            if (f10 < 0.0f) {
                e eVarE = this.f13993d.e(i3);
                if ((zArr == null || !zArr[eVarE.f14015f]) && eVarE != eVar && (((i = eVarE.f14024p) == 3 || i == 4) && f10 < f5)) {
                    f5 = f10;
                    eVar2 = eVarE;
                }
            }
        }
        return eVar2;
    }

    public final void g(e eVar) {
        e eVar2 = this.f13990a;
        if (eVar2 != null) {
            this.f13993d.g(eVar2, -1.0f);
            this.f13990a.f14016g = -1;
            this.f13990a = null;
        }
        float fH = this.f13993d.h(eVar, true) * (-1.0f);
        this.f13990a = eVar;
        if (fH == 1.0f) {
            return;
        }
        this.f13991b /= fH;
        a aVar = this.f13993d;
        int i = aVar.f13988h;
        for (int i3 = 0; i != -1 && i3 < aVar.f13981a; i3++) {
            float[] fArr = aVar.f13987g;
            fArr[i] = fArr[i] / fH;
            i = aVar.f13986f[i];
        }
    }

    public final void h(c cVar, e eVar, boolean z10) {
        if (eVar.f14018j) {
            float fC = this.f13993d.c(eVar);
            this.f13991b = (eVar.i * fC) + this.f13991b;
            this.f13993d.h(eVar, z10);
            if (z10) {
                eVar.b(this);
            }
            if (this.f13993d.d() == 0) {
                this.f13994e = true;
                cVar.f13997a = true;
            }
        }
    }

    public void i(c cVar, b bVar, boolean z10) {
        a aVar = this.f13993d;
        aVar.getClass();
        float fC = aVar.c(bVar.f13990a);
        aVar.h(bVar.f13990a, z10);
        a aVar2 = bVar.f13993d;
        int iD = aVar2.d();
        for (int i = 0; i < iD; i++) {
            e eVarE = aVar2.e(i);
            aVar.a(eVarE, aVar2.c(eVarE) * fC, z10);
        }
        this.f13991b = (bVar.f13991b * fC) + this.f13991b;
        if (z10) {
            bVar.f13990a.b(this);
        }
        if (this.f13990a == null || this.f13993d.d() != 0) {
            return;
        }
        this.f13994e = true;
        cVar.f13997a = true;
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
            u2.e r0 = r10.f13990a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            u2.e r1 = r10.f13990a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = r0.concat(r1)
            float r1 = r10.f13991b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = w2.c.c(r0)
            float r1 = r10.f13991b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r4
            goto L36
        L35:
            r1 = r3
        L36:
            u2.a r5 = r10.f13993d
            int r5 = r5.d()
        L3c:
            if (r3 >= r5) goto L9c
            u2.a r6 = r10.f13993d
            u2.e r6 = r6.e(r3)
            if (r6 != 0) goto L47
            goto L99
        L47:
            u2.a r7 = r10.f13993d
            float r7 = r7.f(r3)
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
            java.lang.String r0 = k0.a.n(r0, r1)
        L64:
            float r7 = r7 * r9
            goto L76
        L66:
            if (r8 <= 0) goto L6f
            java.lang.String r1 = " + "
            java.lang.String r0 = k0.a.n(r0, r1)
            goto L76
        L6f:
            java.lang.String r1 = " - "
            java.lang.String r0 = k0.a.n(r0, r1)
            goto L64
        L76:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L81
            java.lang.String r0 = k0.a.n(r0, r6)
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
            r1 = r4
        L99:
            int r3 = r3 + 1
            goto L3c
        L9c:
            if (r1 != 0) goto La5
            java.lang.String r10 = "0.0"
            java.lang.String r10 = k0.a.n(r0, r10)
            return r10
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.b.toString():java.lang.String");
    }
}
