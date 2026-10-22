package kotlin.jvm.internal;

import w9.InterfaceC5744c;
import w9.InterfaceC5750i;
import w9.InterfaceC5753l;

/* loaded from: classes4.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements InterfaceC5750i {
    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public InterfaceC5744c computeReflected() {
        return t.e(this);
    }

    @Override // w9.InterfaceC5753l
    public Object getDelegate() {
        return ((InterfaceC5750i) getReflected()).getDelegate();
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return get();
    }

    @Override // w9.InterfaceC5752k
    public InterfaceC5753l.a getGetter() {
        return ((InterfaceC5750i) getReflected()).getGetter();
    }

    @Override // w9.InterfaceC5749h
    public InterfaceC5750i.a getSetter() {
        return ((InterfaceC5750i) getReflected()).getSetter();
    }
}
