package m;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class b {
    public final a d;

    /* renamed from: a, reason: collision with root package name */
    public g f3851a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f3852b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3853c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f3854e = false;

    public b(a4.d dVar) {
        this.d = new a(this, dVar);
    }

    public final void a(c cVar, int i8) {
        this.d.g(cVar.j(i8), 1.0f);
        this.d.g(cVar.j(i8), -1.0f);
    }

    public final void b(g gVar, g gVar2, g gVar3, int i8) {
        boolean z = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z = true;
            }
            this.f3852b = i8;
        }
        if (z) {
            this.d.g(gVar, 1.0f);
            this.d.g(gVar2, -1.0f);
            this.d.g(gVar3, -1.0f);
        } else {
            this.d.g(gVar, -1.0f);
            this.d.g(gVar2, 1.0f);
            this.d.g(gVar3, 1.0f);
        }
    }

    public final void c(g gVar, g gVar2, g gVar3, int i8) {
        boolean z = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z = true;
            }
            this.f3852b = i8;
        }
        if (z) {
            this.d.g(gVar, 1.0f);
            this.d.g(gVar2, -1.0f);
            this.d.g(gVar3, 1.0f);
        } else {
            this.d.g(gVar, -1.0f);
            this.d.g(gVar2, 1.0f);
            this.d.g(gVar3, -1.0f);
        }
    }

    public g d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.f3851a == null && this.f3852b == 0.0f && this.d.d() == 0;
    }

    public final g f(boolean[] zArr, g gVar) {
        int i8;
        int iD = this.d.d();
        g gVar2 = null;
        float f3 = 0.0f;
        for (int i9 = 0; i9 < iD; i9++) {
            float f7 = this.d.f(i9);
            if (f7 < 0.0f) {
                g gVarE = this.d.e(i9);
                if ((zArr == null || !zArr[gVarE.f3878b]) && gVarE != gVar && (((i8 = gVarE.f3887m) == 3 || i8 == 4) && f7 < f3)) {
                    f3 = f7;
                    gVar2 = gVarE;
                }
            }
        }
        return gVar2;
    }

    public final void g(g gVar) {
        g gVar2 = this.f3851a;
        if (gVar2 != null) {
            this.d.g(gVar2, -1.0f);
            this.f3851a.f3879c = -1;
            this.f3851a = null;
        }
        float fH = this.d.h(gVar, true) * (-1.0f);
        this.f3851a = gVar;
        if (fH == 1.0f) {
            return;
        }
        this.f3852b /= fH;
        a aVar = this.d;
        int i8 = aVar.f3848h;
        for (int i9 = 0; i8 != -1 && i9 < aVar.f3842a; i9++) {
            float[] fArr = aVar.f3847g;
            fArr[i8] = fArr[i8] / fH;
            i8 = aVar.f3846f[i8];
        }
    }

    public final void h(c cVar, g gVar, boolean z) {
        if (gVar.f3881f) {
            float fC = this.d.c(gVar);
            this.f3852b = (gVar.f3880e * fC) + this.f3852b;
            this.d.h(gVar, z);
            if (z) {
                gVar.b(this);
            }
            if (this.d.d() == 0) {
                this.f3854e = true;
                cVar.f3857a = true;
            }
        }
    }

    public void i(c cVar, b bVar, boolean z) {
        a aVar = this.d;
        aVar.getClass();
        float fC = aVar.c(bVar.f3851a);
        aVar.h(bVar.f3851a, z);
        a aVar2 = bVar.d;
        int iD = aVar2.d();
        for (int i8 = 0; i8 < iD; i8++) {
            g gVarE = aVar2.e(i8);
            aVar.a(gVarE, aVar2.c(gVarE) * fC, z);
        }
        this.f3852b = (bVar.f3852b * fC) + this.f3852b;
        if (z) {
            bVar.f3851a.b(this);
        }
        if (this.f3851a == null || this.d.d() != 0) {
            return;
        }
        this.f3854e = true;
        cVar.f3857a = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            m.g r0 = r10.f3851a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            m.g r1 = r10.f3851a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = a8.b.n(r0, r1)
            float r1 = r10.f3852b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L39
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f3852b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r4
            goto L3a
        L39:
            r1 = r3
        L3a:
            m.a r5 = r10.d
            int r5 = r5.d()
        L40:
            if (r3 >= r5) goto La0
            m.a r6 = r10.d
            m.g r6 = r6.e(r3)
            if (r6 != 0) goto L4b
            goto L9d
        L4b:
            m.a r7 = r10.d
            float r7 = r7.f(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L56
            goto L9d
        L56:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L6a
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L7a
            java.lang.String r1 = "- "
            java.lang.String r0 = a8.b.n(r0, r1)
        L68:
            float r7 = r7 * r9
            goto L7a
        L6a:
            if (r8 <= 0) goto L73
            java.lang.String r1 = " + "
            java.lang.String r0 = a8.b.n(r0, r1)
            goto L7a
        L73:
            java.lang.String r1 = " - "
            java.lang.String r0 = a8.b.n(r0, r1)
            goto L68
        L7a:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L85
            java.lang.String r0 = a8.b.n(r0, r6)
            goto L9c
        L85:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L9c:
            r1 = r4
        L9d:
            int r3 = r3 + 1
            goto L40
        La0:
            if (r1 != 0) goto La9
            java.lang.String r10 = "0.0"
            java.lang.String r10 = a8.b.n(r0, r10)
            return r10
        La9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.b.toString():java.lang.String");
    }
}
