package q9;

import p9.t;

/* loaded from: classes4.dex */
public final class l extends kotlinx.coroutines.flow.h implements t {
    @Override // p9.t
    public final Object getValue() {
        Integer numValueOf;
        synchronized (this) {
            Object[] objArr = this.h;
            kotlin.jvm.internal.k.c(objArr);
            numValueOf = Integer.valueOf(((Number) objArr[((int) ((this.i + ((int) ((o() + this.k) - this.i))) - 1)) & (objArr.length - 1)]).intValue());
        }
        return numValueOf;
    }

    public final void v(int i) {
        synchronized (this) {
            Object[] objArr = this.h;
            kotlin.jvm.internal.k.c(objArr);
            a(Integer.valueOf(((Number) objArr[((int) ((this.i + ((int) ((o() + this.k) - this.i))) - 1)) & (objArr.length - 1)]).intValue() + i));
        }
    }
}
