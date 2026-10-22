package ua;

import java.lang.reflect.Method;
import java.util.HashMap;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, ua.a> f13190a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f13191a;

        static {
            b bVar = new b();
            b.f13190a = new HashMap<>();
            f13191a = bVar;
        }
    }

    public static Class a(String str) throws ClassNotFoundException {
        ua.a aVar = f13190a.get(str);
        if (aVar != null) {
            return aVar.f13188a;
        }
        Class<?> cls = Class.forName(str);
        f13190a.put(str, new ua.a(cls));
        return cls;
    }

    public static Method b(Class cls, Class... clsArr) throws NoSuchMethodException, SecurityException {
        if (f13190a.get(cls.getName()) == null) {
            try {
                a(cls.getName());
            } catch (ClassNotFoundException e10) {
                e10.printStackTrace();
            }
        }
        ua.a aVar = f13190a.get(cls.getName());
        if (aVar == null) {
            return null;
        }
        HashMap<String, Method> map = aVar.f13189b;
        String string = "get";
        for (Class cls2 : clsArr) {
            StringBuilder sbB = d.b(string);
            sbB.append(cls2.toString());
            string = sbB.toString();
        }
        Method method = map.get(string);
        if (method != null) {
            return method;
        }
        Method method2 = cls.getMethod("get", clsArr);
        map.put(string, method2);
        return method2;
    }
}
