package J8;

import Yb.u;
import Yb.z;

/* loaded from: classes4.dex */
public abstract class h {
    public static void a(u uVar) {
        if (uVar.c() == uVar.d()) {
            return;
        }
        d(uVar.c(), uVar.d());
    }

    public static void b(z zVar, z zVar2, int i10) {
        if (zVar == null || zVar2 == null || zVar == zVar2) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(i10);
        sb2.append(zVar.m());
        u uVarE = zVar.e();
        u uVarE2 = zVar2.e();
        while (uVarE != uVarE2) {
            sb2.append(((z) uVarE).m());
            u uVarE3 = uVarE.e();
            uVarE.l();
            uVarE = uVarE3;
        }
        zVar.n(sb2.toString());
    }

    public static void c(u uVar, u uVar2) {
        if (uVar == uVar2 || uVar.e() == uVar2) {
            return;
        }
        d(uVar.e(), uVar2.g());
    }

    public static void d(u uVar, u uVar2) {
        z zVar = null;
        z zVar2 = null;
        int length = 0;
        while (uVar != null) {
            if (uVar instanceof z) {
                zVar2 = (z) uVar;
                if (zVar == null) {
                    zVar = zVar2;
                }
                length += zVar2.m().length();
            } else {
                b(zVar, zVar2, length);
                zVar = null;
                zVar2 = null;
                length = 0;
            }
            if (uVar == uVar2) {
                break;
            } else {
                uVar = uVar.e();
            }
        }
        b(zVar, zVar2, length);
    }
}
