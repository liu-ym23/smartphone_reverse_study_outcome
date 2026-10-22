package kotlin.jvm.internal;

import w9.InterfaceC5745d;
import w9.InterfaceC5747f;

/* loaded from: classes4.dex */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    public MutablePropertyReference1Impl(InterfaceC5747f interfaceC5747f, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((f) interfaceC5747f).m(), str, str2, !(interfaceC5747f instanceof InterfaceC5745d) ? 1 : 0);
    }

    public Object get(Object obj) {
        return n0().call(obj);
    }

    public void set(Object obj, Object obj2) {
        getSetter().call(obj, obj2);
    }

    public MutablePropertyReference1Impl(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    public MutablePropertyReference1Impl(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
