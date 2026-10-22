package N1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static f f4202a = new b();

    private static class b implements f {

        /* renamed from: a, reason: collision with root package name */
        private Map<ClassLoader, Map<String, g>> f4203a;

        private b() {
            this.f4203a = new HashMap();
        }

        @Override // N1.h.f
        public g a(String str) {
            return d(getClass().getClassLoader(), str);
        }

        @Override // N1.h.f
        public g b(Object obj) {
            return c(obj.getClass());
        }

        @Override // N1.h.f
        public g c(Class<?> cls) {
            return d(cls.getClassLoader(), cls.getName());
        }

        public g d(ClassLoader classLoader, String str) {
            Map<String, g> map = this.f4203a.get(classLoader);
            if (map == null) {
                map = new HashMap<>();
                this.f4203a.put(classLoader, map);
            }
            g gVar = map.get(str);
            if (gVar != null) {
                return gVar;
            }
            c cVar = new c(classLoader.loadClass(str));
            map.put(str, cVar);
            return cVar;
        }
    }

    private static class c implements g {

        /* renamed from: a, reason: collision with root package name */
        private Class<?> f4204a;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, Object> f4205b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        private Map<String, i> f4206c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        private Map<String, InterfaceC0062h> f4207d = new HashMap();

        c(Class<?> cls) {
            this.f4204a = cls;
        }

        @Override // N1.h.g
        public i a(String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
            Method declaredMethod;
            StringBuilder sb = new StringBuilder(str);
            if (clsArr != null && clsArr.length > 0) {
                for (Class cls : clsArr) {
                    sb.append(cls.getName());
                }
            }
            String string = sb.toString();
            i iVar = this.f4206c.get(string);
            if (iVar != null) {
                return iVar;
            }
            Class<?> superclass = this.f4204a;
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
            if (declaredMethod != null) {
                e eVar = new e(declaredMethod);
                this.f4206c.put(string, eVar);
                return eVar;
            }
            throw new NoSuchMethodException(str + " " + Arrays.toString(clsArr));
        }

        @Override // N1.h.g
        public InterfaceC0062h b(String str) throws NoSuchFieldException {
            Field declaredField;
            InterfaceC0062h interfaceC0062h = this.f4207d.get(str);
            if (interfaceC0062h != null) {
                return interfaceC0062h;
            }
            Class<?> superclass = this.f4204a;
            while (true) {
                if (superclass == null) {
                    declaredField = null;
                    break;
                }
                try {
                    declaredField = superclass.getDeclaredField(str);
                    break;
                } catch (Exception unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredField == null) {
                throw new NoSuchFieldException(str);
            }
            d dVar = new d(declaredField);
            this.f4207d.put(str, dVar);
            return dVar;
        }
    }

    private static class d implements InterfaceC0062h {

        /* renamed from: a, reason: collision with root package name */
        private Field f4208a;

        d(Field field) throws SecurityException {
            this.f4208a = field;
            field.setAccessible(true);
        }

        @Override // N1.h.InterfaceC0062h
        public void a(Object obj, int i5) throws IllegalAccessException, IllegalArgumentException {
            this.f4208a.setInt(obj, i5);
        }

        @Override // N1.h.InterfaceC0062h
        public void b(Object obj, boolean z5) throws IllegalAccessException, IllegalArgumentException {
            this.f4208a.setBoolean(obj, z5);
        }

        @Override // N1.h.InterfaceC0062h
        public int c(Object obj) {
            return this.f4208a.getInt(obj);
        }

        @Override // N1.h.InterfaceC0062h
        public void d(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
            this.f4208a.set(obj, obj2);
        }

        @Override // N1.h.InterfaceC0062h
        public Object get(Object obj) {
            return this.f4208a.get(obj);
        }
    }

    private static class e implements i {

        /* renamed from: a, reason: collision with root package name */
        private Method f4209a;

        e(Method method) throws SecurityException {
            this.f4209a = method;
            method.setAccessible(true);
        }

        @Override // N1.h.i
        public Object a(Object obj, Object... objArr) {
            return this.f4209a.invoke(obj, objArr);
        }
    }

    public interface f {
        g a(String str);

        g b(Object obj);

        g c(Class<?> cls);
    }

    public interface g {
        i a(String str, Class... clsArr);

        InterfaceC0062h b(String str);
    }

    /* renamed from: N1.h$h, reason: collision with other inner class name */
    public interface InterfaceC0062h {
        void a(Object obj, int i5);

        void b(Object obj, boolean z5);

        int c(Object obj);

        void d(Object obj, Object obj2);

        Object get(Object obj);
    }

    public interface i {
        Object a(Object obj, Object... objArr);
    }

    public static g a(Class<?> cls) {
        return f4202a.c(cls);
    }

    public static g b(Object obj) {
        return f4202a.b(obj);
    }

    public static g c(String str) {
        return f4202a.a(str);
    }
}
