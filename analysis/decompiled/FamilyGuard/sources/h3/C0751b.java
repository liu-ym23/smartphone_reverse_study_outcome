package h3;

import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: h3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0751b {

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, C0750a> f17596b;

    /* renamed from: a, reason: collision with root package name */
    private final String f17597a;

    /* renamed from: h3.b$b, reason: collision with other inner class name */
    private static class C0218b {

        /* renamed from: a, reason: collision with root package name */
        private static final C0751b f17598a = new C0751b();
    }

    public static C0751b a() {
        return C0218b.f17598a;
    }

    private void e(String str, C0750a c0750a) {
        f17596b.put(str, c0750a);
    }

    public Class<?> b(String str) {
        return c(str, Boolean.TRUE);
    }

    public Class<?> c(String str, Boolean bool) throws ClassNotFoundException {
        if (!bool.booleanValue()) {
            return Class.forName(str);
        }
        C0750a c0750a = f17596b.get(str);
        if (c0750a != null) {
            return c0750a.f17593a;
        }
        Class<?> cls = Class.forName(str);
        e(str, new C0750a(cls, str));
        return cls;
    }

    public Method d(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        if (f17596b.get(cls.getName()) == null) {
            try {
                c(cls.getName(), Boolean.TRUE);
            } catch (ClassNotFoundException e6) {
                e6.printStackTrace();
            }
        }
        C0750a c0750a = f17596b.get(cls.getName());
        if (c0750a == null) {
            return null;
        }
        String str2 = str;
        for (Class<?> cls2 : clsArr) {
            str2 = str2 + cls2.toString();
        }
        Method methodB = c0750a.b(str2);
        if (methodB != null) {
            return methodB;
        }
        Method method = cls.getMethod(str, clsArr);
        c0750a.a(str2, method);
        return method;
    }

    private C0751b() {
        this.f17597a = "ReflectionCache";
        f17596b = new HashMap<>();
    }
}
