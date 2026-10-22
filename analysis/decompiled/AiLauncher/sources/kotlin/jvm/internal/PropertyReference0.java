package kotlin.jvm.internal;

import w9.InterfaceC5744c;
import w9.InterfaceC5753l;

/* loaded from: classes4.dex */
public abstract class PropertyReference0 extends PropertyReference implements InterfaceC5753l {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public InterfaceC5744c computeReflected() {
        return t.h(this);
    }

    @Override // w9.InterfaceC5753l
    public Object getDelegate() {
        return ((InterfaceC5753l) getReflected()).getDelegate();
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return get();
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // w9.InterfaceC5752k
    /* renamed from: getGetter */
    public InterfaceC5753l.a n0() {
        return ((InterfaceC5753l) getReflected()).n0();
    }

    public PropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
