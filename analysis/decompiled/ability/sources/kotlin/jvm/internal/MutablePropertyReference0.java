package kotlin.jvm.internal;

/* loaded from: classes3.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements Z7.j {
    @Override // kotlin.jvm.internal.CallableReference
    public Z7.c computeReflected() {
        return m.f4928a.d(this);
    }

    @Override // Z7.q
    public Object getDelegate() {
        return ((Z7.j) getReflected()).getDelegate();
    }

    @Override // S7.a
    public Object invoke() {
        return get();
    }

    @Override // Z7.t
    public Z7.p getGetter() {
        return ((Z7.j) getReflected()).getGetter();
    }

    @Override // Z7.m
    public Z7.i getSetter() {
        return ((Z7.j) getReflected()).getSetter();
    }
}
