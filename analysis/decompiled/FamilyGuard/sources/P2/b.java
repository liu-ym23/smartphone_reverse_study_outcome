package P2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, P2.a> f4825b;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, Method> f4826c;

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<String, Field> f4827d;

    /* renamed from: a, reason: collision with root package name */
    private final String f4828a;

    /* renamed from: P2.b$b, reason: collision with other inner class name */
    private static class C0073b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f4829a = new b();
    }

    public static b a() {
        return C0073b.f4829a;
    }

    private P2.a d(String str) {
        return f4825b.get(str);
    }

    private void f(String str, P2.a aVar) {
        f4825b.put(str, aVar);
    }

    public Class<?> b(String str) {
        return c(str, Boolean.TRUE);
    }

    public synchronized Class<?> c(String str, Boolean bool) {
        if (!bool.booleanValue()) {
            return Class.forName(str);
        }
        P2.a aVarD = d(str);
        if (aVarD != null) {
            return aVarD.f4822a;
        }
        Class<?> cls = Class.forName(str);
        f(str, new P2.a(cls, str));
        return cls;
    }

    public synchronized Method e(Class<?> cls, String str, Class... clsArr) {
        try {
            P2.a aVarD = d(cls.getName());
            boolean z5 = aVarD != null;
            String str2 = str;
            for (Class cls2 : clsArr) {
                str2 = str2 + cls2.toString();
            }
            if (z5) {
                Method methodB = aVarD.b(str2);
                if (methodB != null) {
                    return methodB;
                }
                Method method = cls.getMethod(str, clsArr);
                aVarD.a(str2, method);
                return method;
            }
            Method method2 = f4826c.get(str2);
            if (method2 != null) {
                return method2;
            }
            Method method3 = cls.getMethod(str, clsArr);
            f4826c.put(str2, method3);
            return method3;
        } catch (Throwable th) {
            throw th;
        }
    }

    private b() {
        this.f4828a = "ReflectionCache";
        f4825b = new HashMap<>();
        f4826c = new HashMap<>();
        f4827d = new HashMap<>();
    }
}
