package y;

import b0.z1;

/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final x.f f11353a = new x.f(0.16f, 0.1f, 0.08f, 0.1f);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0114  */
    /* JADX WARN: Type inference failed for: r13v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(p7.a r26, n0.m r27, boolean r28, u0.c0 r29, y.a r30, y.d r31, o.o r32, r.c0 r33, j0.d r34, b0.p r35, int r36, int r37) {
        /*
            Method dump skipped, instructions count: 814
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.a0.a(p7.a, n0.m, boolean, u0.c0, y.a, y.d, o.o, r.c0, j0.d, b0.p, int, int):void");
    }

    public static final void b(n0.m mVar, float f10, long j2, b0.p pVar, int i2, int i10) {
        int i11;
        pVar.T(75144485);
        int i12 = i10 & 1;
        if (i12 != 0) {
            i11 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i11 = (pVar.f(mVar) ? 4 : 2) | i2;
        } else {
            i11 = i2;
        }
        if (((i11 | 48) & 147) == 146 && pVar.z()) {
            pVar.O();
        } else {
            pVar.Q();
            if ((i2 & 1) == 0 || pVar.x()) {
                if (i12 != 0) {
                    mVar = n0.j.f6796a;
                }
                f10 = o.f11511a;
            } else {
                pVar.O();
            }
            pVar.r();
            n0.m mVarB = androidx.compose.foundation.layout.a.b(mVar.c(androidx.compose.foundation.layout.a.f744a), f10);
            Object objJ = pVar.J();
            if (objJ == b0.k.f1229a) {
                objJ = new p(f10, j2);
                pVar.b0(objJ);
            }
            n7.b.a(mVarB, (p7.k) objJ, pVar, 0);
        }
        n0.m mVar2 = mVar;
        float f11 = f10;
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new q(mVar2, f11, j2, i2, i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(p7.a r23, n0.m r24, boolean r25, u0.c0 r26, y.a r27, o.o r28, r.c0 r29, j0.d r30, b0.p r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.a0.c(p7.a, n0.m, boolean, u0.c0, y.a, o.o, r.c0, j0.d, b0.p, int, int):void");
    }
}
