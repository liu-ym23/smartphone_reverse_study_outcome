package kotlin.jvm.internal;

import Z7.q;

/* loaded from: classes3.dex */
public abstract class PropertyReference0 extends PropertyReference implements q {
    @Override // kotlin.jvm.internal.CallableReference
    public Z7.c computeReflected() {
        return m.f4928a.f(this);
    }

    @Override // Z7.q
    public Object getDelegate() {
        return ((q) getReflected()).getDelegate();
    }

    @Override // S7.a
    public Object invoke() {
        return get();
    }

    @Override // Z7.t
    public Z7.p getGetter() {
        return ((q) getReflected()).getGetter();
    }
}
