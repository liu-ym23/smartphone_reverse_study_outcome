package l8;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10353a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public HashMap f10354a;

        public final d a(ClassLoader classLoader, String str) throws ClassNotFoundException {
            HashMap map = this.f10354a;
            Map map2 = (Map) map.get(classLoader);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(classLoader, map2);
            }
            d dVar = (d) map2.get(str);
            if (dVar != null) {
                return dVar;
            }
            Class<?> clsLoadClass = classLoader.loadClass(str);
            b bVar = new b();
            new HashMap();
            bVar.f10356b = new HashMap();
            new HashMap();
            bVar.f10355a = clsLoadClass;
            map2.put(str, bVar);
            return bVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        public Class<?> f10355a;

        /* renamed from: b, reason: collision with root package name */
        public HashMap f10356b;

        @Override // l8.e.d
        public final InterfaceC0106e a(String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
            Method declaredMethod;
            HashMap map = this.f10356b;
            StringBuilder sb2 = new StringBuilder(str);
            if (clsArr.length > 0) {
                for (Class cls : clsArr) {
                    sb2.append(cls.getName());
                }
            }
            String string = sb2.toString();
            InterfaceC0106e interfaceC0106e = (InterfaceC0106e) map.get(string);
            if (interfaceC0106e != null) {
                return interfaceC0106e;
            }
            Class<?> superclass = this.f10355a;
            while (true) {
                if (superclass == null) {
                    declaredMethod = null;
                    break;
                }
                try {
                    declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                    break;
                } catch (Exception unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod == null) {
                StringBuilder sbP = a0.a.p(str, " ");
                sbP.append(Arrays.toString(clsArr));
                throw new NoSuchMethodException(sbP.toString());
            }
            c cVar = new c();
            cVar.f10357a = declaredMethod;
            declaredMethod.setAccessible(true);
            map.put(string, cVar);
            return cVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c implements InterfaceC0106e {

        /* renamed from: a, reason: collision with root package name */
        public Method f10357a;

        @Override // l8.e.InterfaceC0106e
        public final Object a(Object obj, Object... objArr) {
            return this.f10357a.invoke(obj, objArr);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface d {
        InterfaceC0106e a(String str, Class... clsArr);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: l8.e$e, reason: collision with other inner class name */
    public interface InterfaceC0106e {
        Object a(Object obj, Object... objArr);
    }

    static {
        a aVar = new a();
        aVar.f10354a = new HashMap();
        f10353a = aVar;
    }

    public static d a(Object obj) {
        a aVar = f10353a;
        aVar.getClass();
        Class<?> cls = obj.getClass();
        return aVar.a(cls.getClassLoader(), cls.getName());
    }

    public static d b(String str) {
        a aVar = f10353a;
        aVar.getClass();
        return aVar.a(a.class.getClassLoader(), str);
    }
}
