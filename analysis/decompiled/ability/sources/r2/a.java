package r2;

import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f5671a;

    static {
        HashMap map = new HashMap();
        f5671a = map;
        Class cls = Boolean.TYPE;
        map.put(Boolean.class, cls);
        Class cls2 = Byte.TYPE;
        map.put(Byte.class, cls2);
        Class cls3 = Character.TYPE;
        map.put(Character.class, cls3);
        Class cls4 = Short.TYPE;
        map.put(Short.class, cls4);
        Class cls5 = Integer.TYPE;
        map.put(Integer.class, cls5);
        Class cls6 = Float.TYPE;
        map.put(Float.class, cls6);
        Class cls7 = Long.TYPE;
        map.put(Long.class, cls7);
        Class cls8 = Double.TYPE;
        map.put(Double.class, cls8);
        map.put(cls, cls);
        map.put(cls2, cls2);
        map.put(cls3, cls3);
        map.put(cls4, cls4);
        map.put(cls5, cls5);
        map.put(cls6, cls6);
        map.put(cls7, cls7);
        map.put(cls8, cls8);
    }

    public static Object a(Class cls, Object... objArr) throws NoSuchMethodException, SecurityException {
        Class[] clsArr;
        Object[] objArr2;
        if (objArr.length > 0) {
            clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                clsArr[i] = obj == null ? null : obj.getClass();
            }
        } else {
            clsArr = null;
        }
        Method methodB = b(cls, clsArr);
        if (objArr.length > 0) {
            objArr2 = new Object[objArr.length];
            for (int i6 = 0; i6 < objArr.length; i6++) {
                objArr2[i6] = objArr[i6];
            }
        } else {
            objArr2 = null;
        }
        return methodB.invoke(null, objArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Method b(Class cls, Class... clsArr) throws NoSuchMethodException, SecurityException {
        Method method;
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        loop0: while (true) {
            if (i >= length) {
                method = null;
                break;
            }
            method = declaredMethods[i];
            if (method.getName().equals("setPermissions")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes == 0) {
                    if (clsArr == null || clsArr.length == 0) {
                        break;
                    }
                } else if (clsArr == null) {
                    if (parameterTypes.length == 0) {
                        break;
                    }
                } else {
                    if (parameterTypes.length == clsArr.length) {
                        for (int i6 = 0; i6 < parameterTypes.length; i6++) {
                            if (!parameterTypes[i6].isAssignableFrom(clsArr[i6])) {
                                Object[] objArr = parameterTypes[i6];
                                HashMap map = f5671a;
                                if (!map.containsKey(objArr) || !((Class) map.get(parameterTypes[i6])).equals(map.get(clsArr[i6]))) {
                                    break;
                                }
                            }
                        }
                        break loop0;
                    }
                    continue;
                }
            }
            i++;
        }
        if (method != null) {
            method.setAccessible(true);
            return method;
        }
        if (cls.getSuperclass() != null) {
            return b(cls.getSuperclass(), clsArr);
        }
        throw new NoSuchMethodException();
    }
}
