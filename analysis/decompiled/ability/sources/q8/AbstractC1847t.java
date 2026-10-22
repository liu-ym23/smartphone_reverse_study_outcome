package q8;

import ca.AbstractC0897f;

/* renamed from: q8.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1847t {

    /* renamed from: a, reason: collision with root package name */
    public static final G8.c f5610a;
    public static final G8.b b;

    static {
        G8.c cVar = new G8.c("kotlin.jvm.JvmField");
        f5610a = cVar;
        AbstractC0897f.N(cVar);
        AbstractC0897f.N(new G8.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        b = AbstractC0897f.A("kotlin/jvm/internal/RepeatableContainer", false);
    }

    public static final String a(String propertyName) {
        kotlin.jvm.internal.k.f(propertyName, "propertyName");
        return c(propertyName) ? propertyName : "get".concat(M0.i.q(propertyName));
    }

    public static final String b(String str) {
        String strQ;
        if (c(str)) {
            strQ = str.substring(2);
            kotlin.jvm.internal.k.e(strQ, "substring(...)");
        } else {
            strQ = M0.i.q(str);
        }
        return "set".concat(strQ);
    }

    public static final boolean c(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        if (j9.t.e0(name, "is", false) && name.length() != 2) {
            char cCharAt = name.charAt(2);
            if (kotlin.jvm.internal.k.g(97, cCharAt) > 0 || kotlin.jvm.internal.k.g(cCharAt, 122) > 0) {
                return true;
            }
        }
        return false;
    }
}
