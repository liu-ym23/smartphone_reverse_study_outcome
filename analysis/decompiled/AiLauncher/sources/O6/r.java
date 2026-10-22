package O6;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class r {
    private static f sReflect = new b();

    public static class b implements f {
        private Map<ClassLoader, Map<String, g>> mCacheClass;

        public b() {
            this.mCacheClass = new HashMap();
        }

        @Override // O6.r.f
        public g a(Class<?> cls) throws ClassNotFoundException {
            return c(cls.getClassLoader(), cls.getName());
        }

        @Override // O6.r.f
        public g b(String str) throws ClassNotFoundException {
            return c(getClass().getClassLoader(), str);
        }

        public g c(ClassLoader classLoader, String str) throws ClassNotFoundException {
            Map<String, g> map = this.mCacheClass.get(classLoader);
            if (map == null) {
                map = new HashMap<>();
                this.mCacheClass.put(classLoader, map);
            }
            g gVar = map.get(str);
            if (gVar != null) {
                return gVar;
            }
            c cVar = new c(classLoader.loadClass(str));
            map.put(str, cVar);
            return cVar;
        }

        @Override // O6.r.f
        public g from(Object obj) throws ClassNotFoundException {
            return a(obj.getClass());
        }
    }

    public static class c implements g {
        private Class<?> mClass;
        private Map<String, Object> mConstructors = new HashMap();
        private Map<String, i> mMethods = new HashMap();
        private Map<String, h> mFields = new HashMap();

        public c(Class<?> cls) {
            this.mClass = cls;
        }

        @Override // O6.r.g
        public i a(String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
            Method declaredMethod;
            StringBuilder sb2 = new StringBuilder(str);
            if (clsArr != null && clsArr.length > 0) {
                for (Class cls : clsArr) {
                    sb2.append(cls.getName());
                }
            }
            String string = sb2.toString();
            i iVar = this.mMethods.get(string);
            if (iVar != null) {
                return iVar;
            }
            Class<?> superclass = this.mClass;
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
                this.mMethods.put(string, eVar);
                return eVar;
            }
            throw new NoSuchMethodException(str + " " + Arrays.toString(clsArr));
        }

        @Override // O6.r.g
        public h b(String str) throws NoSuchFieldException {
            Field declaredField;
            h hVar = this.mFields.get(str);
            if (hVar != null) {
                return hVar;
            }
            Class<?> superclass = this.mClass;
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
            this.mFields.put(str, dVar);
            return dVar;
        }
    }

    public static class d implements h {
        private Field mField;

        public d(Field field) throws SecurityException {
            this.mField = field;
            field.setAccessible(true);
        }

        @Override // O6.r.h
        public int a(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.mField.getInt(obj);
        }

        @Override // O6.r.h
        public Object get(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return this.mField.get(obj);
        }
    }

    public static class e implements i {
        private Method mMethod;

        public e(Method method) throws SecurityException {
            this.mMethod = method;
            method.setAccessible(true);
        }

        @Override // O6.r.i
        public Object a(Object obj, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            return this.mMethod.invoke(obj, objArr);
        }
    }

    public interface f {
        g a(Class<?> cls) throws ClassNotFoundException;

        g b(String str) throws ClassNotFoundException;

        g from(Object obj) throws ClassNotFoundException;
    }

    public interface g {
        i a(String str, Class... clsArr) throws NoSuchMethodException;

        h b(String str) throws NoSuchFieldException;
    }

    public interface h {
        int a(Object obj) throws IllegalAccessException, IllegalArgumentException;

        Object get(Object obj) throws IllegalAccessException, IllegalArgumentException;
    }

    public interface i {
        Object a(Object obj, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
    }

    public static g a(Class<?> cls) throws ClassNotFoundException {
        return sReflect.a(cls);
    }

    public static g b(Object obj) throws ClassNotFoundException {
        return sReflect.from(obj);
    }

    public static g c(String str) throws ClassNotFoundException {
        return sReflect.b(str);
    }
}
