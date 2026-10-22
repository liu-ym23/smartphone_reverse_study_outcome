package u8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class j {

    public static class a extends j {
        @Override // u8.j
        public List<Yb.u> b(Yb.u uVar) {
            Yb.u uVarC = uVar.c();
            if (uVarC == null) {
                return Collections.singletonList(uVar);
            }
            ArrayList arrayList = new ArrayList();
            while (uVarC != null) {
                if (!(uVarC instanceof Yb.r)) {
                    arrayList.add(uVarC);
                }
                Yb.u uVarE = uVarC.e();
                uVarC.l();
                uVarC = uVarE;
            }
            return arrayList;
        }
    }

    public static j a() {
        return new a();
    }

    public abstract List<Yb.u> b(Yb.u uVar);
}
