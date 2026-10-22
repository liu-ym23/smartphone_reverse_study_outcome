package kotlin.jvm.internal;

import Z7.r;
import Z7.s;

/* loaded from: classes3.dex */
public abstract class PropertyReference1 extends PropertyReference implements s {
    @Override // kotlin.jvm.internal.CallableReference
    public Z7.c computeReflected() {
        return m.f4928a.g(this);
    }

    @Override // Z7.s
    public Object getDelegate(Object obj) {
        return ((s) getReflected()).getDelegate(obj);
    }

    @Override // S7.k
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // Z7.t
    public r getGetter() {
        return ((s) getReflected()).getGetter();
    }
}
