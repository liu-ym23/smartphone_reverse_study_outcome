package rb;

import java.lang.reflect.Method;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f10527a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f10528b;

    static {
        Method method;
        Method method2;
        Method[] methods = Throwable.class.getMethods();
        methods.getClass();
        int length = methods.length;
        int i = 0;
        int i3 = 0;
        while (true) {
            method = null;
            if (i3 >= length) {
                method2 = null;
                break;
            }
            method2 = methods[i3];
            if (k.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                parameterTypes.getClass();
                if (k.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    break;
                }
            }
            i3++;
        }
        f10527a = method2;
        int length2 = methods.length;
        while (true) {
            if (i >= length2) {
                break;
            }
            Method method3 = methods[i];
            if (k.a(method3.getName(), "getSuppressed")) {
                method = method3;
                break;
            }
            i++;
        }
        f10528b = method;
    }
}
