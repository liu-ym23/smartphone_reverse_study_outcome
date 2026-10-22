package oc;

import nc.j0;
import nc.r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends j0 implements r0 {
    @Override // nc.r0
    public final Object getValue() {
        Integer numValueOf;
        synchronized (this) {
            Object[] objArr = this.f8862l;
            objArr.getClass();
            numValueOf = Integer.valueOf(((Number) objArr[((int) ((this.f8863m + ((int) ((m() + this.f8865o) - this.f8863m))) - 1)) & (objArr.length - 1)]).intValue());
        }
        return numValueOf;
    }

    public final void u(int i) {
        synchronized (this) {
            Object[] objArr = this.f8862l;
            objArr.getClass();
            o(Integer.valueOf(((Number) objArr[((int) ((this.f8863m + ((int) ((m() + this.f8865o) - this.f8863m))) - 1)) & (objArr.length - 1)]).intValue() + i));
        }
    }
}
