package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;

/* JADX INFO: loaded from: classes4.dex */
public class v {
    public v() {
    }

    public KFunction a(FunctionReference r10) {
        return r10;
    }

    public KClass b(Class r10) {
        return new l(r10);
    }

    public KDeclarationContainer c(Class r10, String r11) {
        return new s(r10, r11);
    }

    public KMutableProperty0 d(MutablePropertyReference0 r10) {
        return r10;
    }

    public KMutableProperty1 e(MutablePropertyReference1 r10) {
        return r10;
    }

    public KMutableProperty2 f(MutablePropertyReference2 r10) {
        return r10;
    }

    public KProperty0 g(PropertyReference0 r10) {
        return r10;
    }

    public KProperty1 h(PropertyReference1 r10) {
        return r10;
    }

    public KProperty2 i(PropertyReference2 r10) {
        return r10;
    }

    public String j(FunctionBase r10) {
        String r11 = r10.getClass().getGenericInterfaces()[0].toString();
        if (r11.startsWith("kotlin.jvm.functions.") == true) goto L5;
        return r11;
    L5:
        return r11.substring(21);
    }

    public String k(Lambda r10) {
        return j(r10);
    }
}
