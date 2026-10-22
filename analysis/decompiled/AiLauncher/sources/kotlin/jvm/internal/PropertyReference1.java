package kotlin.jvm.internal;

import w9.InterfaceC5744c;
import w9.InterfaceC5754m;

/* loaded from: classes4.dex */
public abstract class PropertyReference1 extends PropertyReference implements InterfaceC5754m {
    public PropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public InterfaceC5744c computeReflected() {
        return t.i(this);
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // w9.InterfaceC5752k
    /* renamed from: getGetter */
    public InterfaceC5754m.a n0() {
        return ((InterfaceC5754m) getReflected()).n0();
    }
}
