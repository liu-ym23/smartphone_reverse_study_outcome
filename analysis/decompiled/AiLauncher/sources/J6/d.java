package J6;

import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, J6.a> f3736b;

    /* renamed from: a, reason: collision with root package name */
    public final String f3737a;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final d f3738a = new d();
    }

    public static d a() {
        return b.f3738a;
    }

    public Class<?> b(String str, Boolean bool) throws ClassNotFoundException {
        if (!bool.booleanValue()) {
            return Class.forName(str);
        }
        J6.a aVar = f3736b.get(str);
        if (aVar != null) {
            return aVar.f3732a;
        }
        Class<?> cls = Class.forName(str);
        d(str, new J6.a(cls, str));
        return cls;
    }

    public Method c(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        if (f3736b.get(cls.getName()) == null) {
            try {
                b(cls.getName(), Boolean.TRUE);
            } catch (ClassNotFoundException e10) {
                e10.printStackTrace();
            }
        }
        J6.a aVar = f3736b.get(cls.getName());
        if (aVar == null) {
            return null;
        }
        String str2 = str;
        for (Class<?> cls2 : clsArr) {
            str2 = str2 + cls2.toString();
        }
        Method methodB = aVar.b(str2);
        if (methodB != null) {
            return methodB;
        }
        Method method = cls.getMethod(str, clsArr);
        aVar.a(str2, method);
        return method;
    }

    public final void d(String str, J6.a aVar) {
        f3736b.put(str, aVar);
    }

    public d() {
        this.f3737a = "ReflectionCache";
        f3736b = new HashMap<>();
    }
}
