package L1;

import I1.l;
import J1.f;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f4286a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f4287b = true;

    /* renamed from: c, reason: collision with root package name */
    public static ConcurrentMap<String, Class<?>> f4288c;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f4288c = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        f4288c.put("short", Short.TYPE);
        f4288c.put("int", Integer.TYPE);
        f4288c.put("long", Long.TYPE);
        f4288c.put("float", Float.TYPE);
        f4288c.put("double", Double.TYPE);
        f4288c.put("boolean", Boolean.TYPE);
        f4288c.put("char", Character.TYPE);
        f4288c.put("[byte", byte[].class);
        f4288c.put("[short", short[].class);
        f4288c.put("[int", int[].class);
        f4288c.put("[long", long[].class);
        f4288c.put("[float", float[].class);
        f4288c.put("[double", double[].class);
        f4288c.put("[boolean", boolean[].class);
        f4288c.put("[char", char[].class);
        f4288c.put("[B", byte[].class);
        f4288c.put("[S", short[].class);
        f4288c.put("[I", int[].class);
        f4288c.put("[J", long[].class);
        f4288c.put("[F", float[].class);
        f4288c.put("[D", double[].class);
        f4288c.put("[C", char[].class);
        f4288c.put("[Z", boolean[].class);
        f4288c.put(HashMap.class.getName(), HashMap.class);
    }

    public static Field A(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        for (Field field : fieldArr) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        Field[] declaredFields = map != null ? map.get(superclass) : null;
        if (declaredFields == null) {
            declaredFields = superclass.getDeclaredFields();
            if (map != null) {
                map.put(superclass, declaredFields);
            }
        }
        return z(superclass, str, declaredFields, map);
    }

    public static Type B(Type type) {
        return type instanceof Class ? B(((Class) type).getGenericSuperclass()) : type;
    }

    public static H1.b C(Class<?> cls, Method method) throws SecurityException {
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Method method2 : cls2.getMethods()) {
                if (method2.getName().equals(method.getName())) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes.length != parameterTypes2.length) {
                        continue;
                    } else {
                        int i10 = 0;
                        while (true) {
                            if (i10 >= parameterTypes.length) {
                                H1.b bVar = (H1.b) method2.getAnnotation(H1.b.class);
                                if (bVar != null) {
                                    return bVar;
                                }
                            } else {
                                if (!parameterTypes[i10].equals(parameterTypes2[i10])) {
                                    break;
                                }
                                i10++;
                            }
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= parameterTypes3.length) {
                            H1.b bVar2 = (H1.b) method3.getAnnotation(H1.b.class);
                            if (bVar2 != null) {
                                return bVar2;
                            }
                        } else {
                            if (!parameterTypes4[i11].equals(parameterTypes3[i11])) {
                                break;
                            }
                            i11++;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean D(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        return (type instanceof Class) && (genericSuperclass = ((Class) type).getGenericSuperclass()) != Object.class && D(genericSuperclass);
    }

    public static boolean E(Class<?> cls, H1.c cVar, String str) {
        if (cVar != null && cVar.ignores() != null) {
            for (String str2 : cVar.ignores()) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == Object.class || superclass == null || !E(superclass, (H1.c) superclass.getAnnotation(H1.c.class), str)) ? false : true;
    }

    public static Class<?> F(String str, ClassLoader classLoader) throws ClassNotFoundException {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() >= 256) {
            throw new JSONException("className too long. " + str);
        }
        Class<?> clsLoadClass = f4288c.get(str);
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance(F(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(Const.STR_MART_SEMICOLON)) {
            return F(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                clsLoadClass = classLoader.loadClass(str);
                f4288c.put(str, clsLoadClass);
                return clsLoadClass;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null && contextClassLoader != classLoader) {
                clsLoadClass = contextClassLoader.loadClass(str);
                f4288c.put(str, clsLoadClass);
                return clsLoadClass;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            clsLoadClass = Class.forName(str);
            f4288c.put(str, clsLoadClass);
            return clsLoadClass;
        } catch (Exception e12) {
            e12.printStackTrace();
            return clsLoadClass;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean G(Class<?> cls, Member member, int i10) throws SecurityException {
        if (member != 0 && f4287b) {
            Class<? super Object> superclass = cls.getSuperclass();
            if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i10 & 1) != 0) {
                return false;
            }
            try {
                ((AccessibleObject) member).setAccessible(true);
                return true;
            } catch (AccessControlException unused) {
                f4287b = false;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(Object obj, Class<T> cls, l lVar) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Object obj2;
        if (obj == 0) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls != obj.getClass()) {
            if (!(obj instanceof Map)) {
                int i10 = 0;
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection collection = (Collection) obj;
                        T t10 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                        Iterator it = collection.iterator();
                        while (it.hasNext()) {
                            Array.set(t10, i10, a(it.next(), cls.getComponentType(), lVar));
                            i10++;
                        }
                        return t10;
                    }
                    if (cls == byte[].class) {
                        return (T) h(obj);
                    }
                }
                if (!cls.isAssignableFrom(obj.getClass())) {
                    if (cls == Boolean.TYPE || cls == Boolean.class) {
                        return (T) f(obj);
                    }
                    if (cls == Byte.TYPE || cls == Byte.class) {
                        return (T) g(obj);
                    }
                    if ((cls == Character.TYPE || cls == Character.class) && (obj instanceof String)) {
                        String str = (String) obj;
                        if (str.length() == 1) {
                            return (T) Character.valueOf(str.charAt(0));
                        }
                    }
                    if (cls == Short.TYPE || cls == Short.class) {
                        return (T) q(obj);
                    }
                    if (cls == Integer.TYPE || cls == Integer.class) {
                        return (T) n(obj);
                    }
                    if (cls == Long.TYPE || cls == Long.class) {
                        return (T) p(obj);
                    }
                    if (cls == Float.TYPE || cls == Float.class) {
                        return (T) m(obj);
                    }
                    if (cls == Double.TYPE || cls == Double.class) {
                        return (T) k(obj);
                    }
                    if (cls == String.class) {
                        return (T) r(obj);
                    }
                    if (cls == BigDecimal.class) {
                        return (T) d(obj);
                    }
                    if (cls == BigInteger.class) {
                        return (T) e(obj);
                    }
                    if (cls == Date.class) {
                        return (T) j(obj);
                    }
                    if (cls.isEnum()) {
                        return (T) l(obj, cls, lVar);
                    }
                    if (Calendar.class.isAssignableFrom(cls)) {
                        Date dateJ = j(obj);
                        if (cls == Calendar.class) {
                            obj2 = (T) Calendar.getInstance(G1.a.f2772a, G1.a.f2773b);
                        } else {
                            try {
                                obj2 = (T) ((Calendar) cls.newInstance());
                            } catch (Exception e10) {
                                throw new JSONException("can not cast to : " + cls.getName(), e10);
                            }
                        }
                        ((Calendar) obj2).setTime(dateJ);
                        return (T) obj2;
                    }
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (str2.length() == 0 || "null".equals(str2)) {
                            return null;
                        }
                        if (cls == Currency.class) {
                            return (T) Currency.getInstance(str2);
                        }
                    }
                    throw new JSONException("can not cast to : " + cls.getName());
                }
            } else if (cls != Map.class) {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey("@type")) {
                    return (T) o(map, cls, lVar);
                }
            }
        }
        return obj;
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [T, java.util.HashMap, java.util.Map] */
    public static final <T> T b(Object obj, ParameterizedType parameterizedType, l lVar) {
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                T t10 = (rawType == Set.class || rawType == HashSet.class) ? (T) new HashSet() : rawType == TreeSet.class ? (T) new TreeSet() : (T) new ArrayList();
                Iterator<T> it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    ((Collection) t10).add(c(it.next(), type, lVar));
                }
                return t10;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r82 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r82.put(c(entry.getKey(), type2, lVar), c(entry.getValue(), type3, lVar));
                }
                return r82;
            }
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) c(obj, rawType, lVar);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T c(Object obj, Type type, l lVar) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) a(obj, (Class) type, lVar);
        }
        if (type instanceof ParameterizedType) {
            return (T) b(obj, (ParameterizedType) type, lVar);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    public static final BigDecimal d(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string)) {
            return null;
        }
        return new BigDecimal(string);
    }

    public static final BigInteger e(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string)) {
            return null;
        }
        return new BigInteger(string);
    }

    public static final Boolean f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Byte g(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to byte, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str)) {
            return null;
        }
        return Byte.valueOf(Byte.parseByte(str));
    }

    public static final byte[] h(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return I1.d.h(str, 0, str.length());
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Character i(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to byte, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static final Date j(Object obj) throws NumberFormatException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        long jLongValue = obj instanceof Number ? ((Number) obj).longValue() : -1L;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.indexOf(45) != -1) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str.length() == G1.a.f2775d.length() ? G1.a.f2775d : str.length() == 10 ? "yyyy-MM-dd" : str.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : (str.length() == 29 && str.charAt(26) == ':' && str.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd HH:mm:ss.SSS", G1.a.f2773b);
                simpleDateFormat.setTimeZone(G1.a.f2772a);
                try {
                    return simpleDateFormat.parse(str);
                } catch (ParseException unused) {
                    throw new JSONException("can not cast to Date, value : " + str);
                }
            }
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            jLongValue = Long.parseLong(str);
        }
        if (jLongValue >= 0) {
            return new Date(jLongValue);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static final Double k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to double, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string)) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(string));
    }

    public static final <T> T l(Object obj, Class<T> cls, l lVar) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int iIntValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (iIntValue < enumConstants.length) {
                    return enumConstants[iIntValue];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e10) {
            throw new JSONException("can not cast to : " + cls.getName(), e10);
        }
    }

    public static final Float m(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to float, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string)) {
            return null;
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    public static final Integer n(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to int, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str)) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public static final <T> T o(Map<String, Object> map, Class<T> cls, l lVar) throws ClassNotFoundException {
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                return (T) new StackTraceElement(str, str2, str3, number == null ? 0 : number.intValue());
            }
            Object obj = map.get("@type");
            if (obj instanceof String) {
                String str4 = (String) obj;
                Class<?> clsF = F(str4, null);
                if (clsF == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!clsF.equals(cls)) {
                    return (T) o(map, clsF, lVar);
                }
            }
            if (cls.isInterface()) {
                JSONObject jSONObject = map instanceof JSONObject ? (JSONObject) map : new JSONObject(map);
                if (lVar == null) {
                    lVar = l.d();
                }
                return lVar.c(cls) != null ? (T) G1.a.y(G1.a.N(jSONObject), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (cls == String.class && (map instanceof JSONObject)) {
                return (T) map.toString();
            }
            if (lVar == null) {
                lVar = l.f3331e;
            }
            f fVarC = lVar.c(cls);
            I1.f fVar = fVarC instanceof I1.f ? (I1.f) fVarC : null;
            if (fVar != null) {
                return (T) fVar.c(map, lVar);
            }
            throw new JSONException("can not get javaBeanDeserializer");
        } catch (Exception e10) {
            throw new JSONException(e10.getMessage(), e10);
        }
    }

    public static final Long p(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                I1.d dVar = new I1.d(str);
                Calendar calendar = dVar.K(false) ? dVar.f3294o : null;
                dVar.e();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static final Short q(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (!(obj instanceof String)) {
            throw new JSONException("can not cast to short, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str)) {
            return null;
        }
        return Short.valueOf(Short.parseShort(str));
    }

    public static final String r(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0206 A[PHI: r6 r7 r9
      0x0206: PHI (r6v17 int) = (r6v10 int), (r6v19 int), (r6v19 int) binds: [B:92:0x01ca, B:97:0x01e8, B:99:0x01ee] A[DONT_GENERATE, DONT_INLINE]
      0x0206: PHI (r7v12 int) = (r7v5 int), (r7v14 int), (r7v14 int) binds: [B:92:0x01ca, B:97:0x01e8, B:99:0x01ee] A[DONT_GENERATE, DONT_INLINE]
      0x0206: PHI (r9v19 java.lang.String) = (r9v11 java.lang.String), (r9v11 java.lang.String), (r9v20 java.lang.String) binds: [B:92:0x01ca, B:97:0x01e8, B:99:0x01ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<L1.a> s(java.lang.Class<?> r25, int r26, boolean r27, H1.c r28, java.util.Map<java.lang.String, java.lang.String> r29, boolean r30, boolean r31, boolean r32, com.alibaba.fastjson.PropertyNamingStrategy r33) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 1180
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L1.d.s(java.lang.Class, int, boolean, H1.c, java.util.Map, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }

    public static String t(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Object u(Class<?> cls) {
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        return cls == Float.TYPE ? Float.valueOf(0.0f) : cls == Double.TYPE ? Double.valueOf(0.0d) : cls == Boolean.TYPE ? Boolean.FALSE : cls == Character.TYPE ? '0' : null;
    }

    public static long v(String str) {
        long j10 = -2128831035;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '_' && cCharAt != '-') {
                if (cCharAt >= 'A' && cCharAt <= 'Z') {
                    cCharAt = (char) (cCharAt + ' ');
                }
                j10 = (j10 ^ cCharAt) * 16777619;
            }
        }
        return j10;
    }

    public static boolean w(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z10 = false;
        for (int i10 = 0; i10 < typeArr.length; i10++) {
            Type type = typeArr[i10];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (w(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i10] = new c(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
                    z10 = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i11 = 0; i11 < typeVariableArr.length; i11++) {
                    if (type.equals(typeVariableArr[i11])) {
                        typeArr[i10] = typeArr2[i11];
                        z10 = true;
                    }
                }
            }
        }
        return z10;
    }

    public static Class<?> x(Type type) {
        return type.getClass() == Class.class ? (Class) type : type instanceof ParameterizedType ? x(((ParameterizedType) type).getRawType()) : type instanceof TypeVariable ? (Class) ((TypeVariable) type).getBounds()[0] : Object.class;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Type y(java.lang.reflect.Type r4) {
        /*
            boolean r0 = r4 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L1f
            java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
            java.lang.reflect.Type[] r4 = r4.getActualTypeArguments()
            r0 = 0
            r4 = r4[r0]
            boolean r1 = r4 instanceof java.lang.reflect.WildcardType
            if (r1 == 0) goto L3b
            r1 = r4
            java.lang.reflect.WildcardType r1 = (java.lang.reflect.WildcardType) r1
            java.lang.reflect.Type[] r1 = r1.getUpperBounds()
            int r2 = r1.length
            r3 = 1
            if (r2 != r3) goto L3b
            r4 = r1[r0]
            goto L3b
        L1f:
            boolean r0 = r4 instanceof java.lang.Class
            if (r0 == 0) goto L3a
            java.lang.Class r4 = (java.lang.Class) r4
            java.lang.String r0 = r4.getName()
            java.lang.String r1 = "java."
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L3a
            java.lang.reflect.Type r4 = r4.getGenericSuperclass()
            java.lang.reflect.Type r4 = y(r4)
            goto L3b
        L3a:
            r4 = 0
        L3b:
            if (r4 != 0) goto L3f
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
        L3f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: L1.d.y(java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public static Field z(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        Field fieldA = A(cls, str, fieldArr, map);
        if (fieldA == null) {
            fieldA = A(cls, "_" + str, fieldArr, map);
        }
        if (fieldA == null) {
            fieldA = A(cls, "m_" + str, fieldArr, map);
        }
        if (fieldA != null) {
            return fieldA;
        }
        return A(cls, "m" + str.substring(0, 1).toUpperCase() + str.substring(1), fieldArr, map);
    }
}
