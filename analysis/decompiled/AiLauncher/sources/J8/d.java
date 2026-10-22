package J8;

import Yb.u;
import Yb.z;

/* loaded from: classes4.dex */
public class d extends i {
    @Override // J8.i
    public u e() {
        int i10 = this.f3757d;
        this.f3757d = i10 + 1;
        if (j() != '[') {
            return null;
        }
        this.f3757d++;
        z zVarO = o("![");
        a(Tb.e.a(zVarO, i10 + 1, b(), c()));
        return zVarO;
    }

    @Override // J8.i
    public char m() {
        return '!';
    }
}
