package N8;

import Yb.u;

/* loaded from: classes4.dex */
public abstract class e {
    public static void a(u uVar, u uVar2) {
        u uVarE = uVar2.e();
        while (uVarE != null) {
            u uVarE2 = uVarE.e();
            uVar.b(uVarE);
            uVarE = uVarE2;
        }
    }
}
