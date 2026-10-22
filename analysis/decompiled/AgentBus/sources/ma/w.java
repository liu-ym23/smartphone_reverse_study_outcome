package ma;

import la.j0;
import la.s0;

/* loaded from: classes.dex */
public final class w extends j0 implements s0 {
    @Override // la.s0
    public final Object getValue() {
        Integer numValueOf;
        synchronized (this) {
            Object[] objArr = this.f5939m;
            q7.k.b(objArr);
            numValueOf = Integer.valueOf(((Number) objArr[((int) ((this.f5940n + ((int) ((l() + this.f5942p) - this.f5940n))) - 1)) & (objArr.length - 1)]).intValue());
        }
        return numValueOf;
    }

    public final void s(int i2) {
        synchronized (this) {
            Object[] objArr = this.f5939m;
            q7.k.b(objArr);
            M(Integer.valueOf(((Number) objArr[((int) ((this.f5940n + ((int) ((l() + this.f5942p) - this.f5940n))) - 1)) & (objArr.length - 1)]).intValue() + i2));
        }
    }
}
