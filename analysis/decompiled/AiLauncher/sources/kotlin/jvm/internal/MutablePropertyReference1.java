package kotlin.jvm.internal;

import w9.InterfaceC5744c;
import w9.InterfaceC5751j;
import w9.InterfaceC5754m;

/* loaded from: classes4.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements InterfaceC5751j {
    public MutablePropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public InterfaceC5744c computeReflected() {
        return t.f(this);
    }

    @Override // w9.InterfaceC5754m
    public Object getDelegate(Object obj) {
        return ((InterfaceC5751j) getReflected()).getDelegate(obj);
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // w9.InterfaceC5752k
    /* renamed from: getGetter */
    public InterfaceC5754m.a n0() {
        return ((InterfaceC5751j) getReflected()).n0();
    }

    @Override // w9.InterfaceC5749h
    public InterfaceC5751j.a getSetter() {
        return ((InterfaceC5751j) getReflected()).getSetter();
    }

    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
