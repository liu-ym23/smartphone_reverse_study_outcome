package tb;

import java.lang.reflect.Method;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: tb.a$a, reason: collision with other inner class name */
    public static final class C0148a {

        /* renamed from: a, reason: collision with root package name */
        public static final Method f12957a;

        static {
            Method method;
            Method[] methods = Throwable.class.getMethods();
            g.c(methods);
            int length = methods.length;
            int i10 = 0;
            while (true) {
                method = null;
                if (i10 >= length) {
                    break;
                }
                Method method2 = methods[i10];
                if (g.b(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    g.e(parameterTypes, "getParameterTypes(...)");
                    if (g.b(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                        method = method2;
                        break;
                    }
                }
                i10++;
            }
            f12957a = method;
            int length2 = methods.length;
            for (int i11 = 0; i11 < length2 && !g.b(methods[i11].getName(), "getSuppressed"); i11++) {
            }
        }
    }

    public void a(Throwable cause, Throwable exception) {
        g.f(cause, "cause");
        g.f(exception, "exception");
        Method method = C0148a.f12957a;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }
}
