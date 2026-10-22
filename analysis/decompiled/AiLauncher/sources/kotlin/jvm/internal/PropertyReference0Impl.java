package kotlin.jvm.internal;

import w9.InterfaceC5745d;
import w9.InterfaceC5747f;

/* loaded from: classes4.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(InterfaceC5747f interfaceC5747f, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((f) interfaceC5747f).m(), str, str2, !(interfaceC5747f instanceof InterfaceC5745d) ? 1 : 0);
    }

    public Object get() {
        return n0().call(new Object[0]);
    }

    public PropertyReference0Impl(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    public PropertyReference0Impl(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
