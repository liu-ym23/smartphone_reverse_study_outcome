package u0;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import m0.InterfaceC0854b;
import n0.C0872b;

/* renamed from: u0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1152b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f22728a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f22729b;

    static {
        String property = System.getProperty("java.vm.name");
        f22728a = property;
        f22729b = e(property);
    }

    public static boolean a(String str) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt < 1 || cCharAt > 127 || cCharAt == '.') {
                return false;
            }
        }
        return true;
    }

    public static String b(Class<?> cls) {
        if (cls.isPrimitive()) {
            return d(cls);
        }
        if (cls.isArray()) {
            return "[" + b(cls.getComponentType());
        }
        return "L" + g(cls) + ";";
    }

    public static String c(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuilder sb = new StringBuilder((parameterTypes.length + 1) << 4);
        sb.append('(');
        for (Class<?> cls : parameterTypes) {
            sb.append(b(cls));
        }
        sb.append(')');
        sb.append(b(method.getReturnType()));
        return sb.toString();
    }

    public static String d(Class<?> cls) {
        if (Integer.TYPE == cls) {
            return "I";
        }
        if (Void.TYPE == cls) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
        if (Boolean.TYPE == cls) {
            return "Z";
        }
        if (Character.TYPE == cls) {
            return "C";
        }
        if (Byte.TYPE == cls) {
            return "B";
        }
        if (Short.TYPE == cls) {
            return ExifInterface.LATITUDE_SOUTH;
        }
        if (Float.TYPE == cls) {
            return "F";
        }
        if (Long.TYPE == cls) {
            return "J";
        }
        if (Double.TYPE == cls) {
            return "D";
        }
        throw new IllegalStateException("Type: " + cls.getCanonicalName() + " is not a primitive type");
    }

    public static boolean e(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("dalvik") || lowerCase.contains("lemur");
    }

    public static String[] f(AccessibleObject accessibleObject) throws IOException {
        Class<?>[] parameterTypes;
        Class<?> declaringClass;
        Annotation[][] annotationArrC0;
        String name;
        String strName;
        if (f22729b) {
            return new String[0];
        }
        if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            parameterTypes = method.getParameterTypes();
            name = method.getName();
            declaringClass = method.getDeclaringClass();
            annotationArrC0 = o.d0(method);
        } else {
            Constructor constructor = (Constructor) accessibleObject;
            parameterTypes = constructor.getParameterTypes();
            declaringClass = constructor.getDeclaringClass();
            annotationArrC0 = o.c0(constructor);
            name = "<init>";
        }
        if (parameterTypes.length == 0) {
            return new String[0];
        }
        ClassLoader classLoader = declaringClass.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(declaringClass.getName().replace('.', '/') + ".class");
        if (resourceAsStream == null) {
            return new String[0];
        }
        try {
            C0872b c0872b = new C0872b(resourceAsStream, false);
            n0.k kVar = new n0.k(name, parameterTypes);
            c0872b.a(kVar);
            String[] strArrB = kVar.b();
            for (int i5 = 0; i5 < strArrB.length; i5++) {
                Annotation[] annotationArr = annotationArrC0[i5];
                if (annotationArr != null) {
                    for (Annotation annotation : annotationArr) {
                        if ((annotation instanceof InterfaceC0854b) && (strName = ((InterfaceC0854b) annotation).name()) != null && strName.length() > 0) {
                            strArrB[i5] = strName;
                        }
                    }
                }
            }
            return strArrB;
        } catch (IOException unused) {
            return new String[0];
        } finally {
            g.a(resourceAsStream);
        }
    }

    public static String g(Class<?> cls) {
        if (!cls.isArray()) {
            return !cls.isPrimitive() ? cls.getName().replace('.', '/') : d(cls);
        }
        return "[" + b(cls.getComponentType());
    }
}
