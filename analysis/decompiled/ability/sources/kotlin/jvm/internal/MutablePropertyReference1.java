package kotlin.jvm.internal;

import Z7.r;

/* loaded from: classes3.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements Z7.l {
    @Override // kotlin.jvm.internal.CallableReference
    public Z7.c computeReflected() {
        return m.f4928a.e(this);
    }

    @Override // Z7.s
    public Object getDelegate(Object obj) {
        return ((Z7.l) getReflected()).getDelegate(obj);
    }

    @Override // S7.k
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // Z7.t
    public r getGetter() {
        return ((Z7.l) getReflected()).getGetter();
    }

    @Override // Z7.m
    public Z7.k getSetter() {
        return ((Z7.l) getReflected()).getSetter();
    }
}
