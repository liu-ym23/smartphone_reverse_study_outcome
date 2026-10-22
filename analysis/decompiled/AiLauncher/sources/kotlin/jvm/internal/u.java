package kotlin.jvm.internal;

import java.util.List;
import kotlin.reflect.KVariance;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5746e;
import w9.InterfaceC5747f;
import w9.InterfaceC5748g;
import w9.InterfaceC5750i;
import w9.InterfaceC5751j;
import w9.InterfaceC5753l;
import w9.InterfaceC5754m;
import w9.InterfaceC5755n;
import w9.InterfaceC5756o;

/* loaded from: classes4.dex */
public class u {
    public InterfaceC5748g a(FunctionReference functionReference) {
        return functionReference;
    }

    public InterfaceC5745d b(Class cls) {
        return new g(cls);
    }

    public InterfaceC5747f c(Class cls, String str) {
        return new s(cls, str);
    }

    public InterfaceC5755n d(InterfaceC5755n interfaceC5755n) {
        C c10 = (C) interfaceC5755n;
        return new C(interfaceC5755n.getClassifier(), interfaceC5755n.g(), c10.getPlatformTypeUpperBound(), c10.getFlags() | 2);
    }

    public InterfaceC5750i e(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public InterfaceC5751j f(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public InterfaceC5753l g(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public InterfaceC5754m h(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public String i(m mVar) {
        String string = mVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String j(Lambda lambda) {
        return i(lambda);
    }

    public void k(InterfaceC5756o interfaceC5756o, List<InterfaceC5755n> list) {
        ((A) interfaceC5756o).a(list);
    }

    public InterfaceC5755n l(InterfaceC5746e interfaceC5746e, List<C5757p> list, boolean z10) {
        return new C(interfaceC5746e, list, z10);
    }

    public InterfaceC5756o m(Object obj, String str, KVariance kVariance, boolean z10) {
        return new A(obj, str, kVariance, z10);
    }
}
