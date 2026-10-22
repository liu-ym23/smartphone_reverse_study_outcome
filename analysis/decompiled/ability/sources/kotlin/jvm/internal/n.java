package kotlin.jvm.internal;

import Z7.q;
import Z7.s;

/* loaded from: classes3.dex */
public class n {
    public Z7.g a(FunctionReference functionReference) {
        return functionReference;
    }

    public Z7.d b(Class cls) {
        return new d(cls);
    }

    public Z7.f c(Class cls, String str) {
        return new l(cls, str);
    }

    public Z7.j d(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public Z7.l e(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public q f(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public s g(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public String h(h hVar) {
        String string = hVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String i(Lambda lambda) {
        return h(lambda);
    }
}
