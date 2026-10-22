package j5;

import java.lang.reflect.Method;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f3509a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        p.b(methods);
        int length = methods.length;
        int i8 = 0;
        while (true) {
            method = null;
            if (i8 >= length) {
                break;
            }
            Method method2 = methods[i8];
            if (p.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                p.d(parameterTypes, "getParameterTypes(...)");
                if (p.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i8++;
        }
        f3509a = method;
        int length2 = methods.length;
        for (int i9 = 0; i9 < length2 && !p.a(methods[i9].getName(), "getSuppressed"); i9++) {
        }
    }
}
