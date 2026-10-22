package com.alibaba.fastjson.util;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.asm.ClassReader;
import com.alibaba.fastjson.asm.TypeCollector;
import com.alipay.sdk.m.u.i;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class ASMUtils {
    public static final boolean IS_ANDROID = false;
    public static final String JAVA_VM_NAME = null;

    public ASMUtils() {
    }

    static {
        String r100 = System.getProperty("java.vm.name");
        JAVA_VM_NAME = r100;
        IS_ANDROID = isAndroid(r100);
    }

    public static boolean checkName(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length()) goto L14;
        char r102 = r100.charAt(r101);
        if (r102 < 1) goto L13;
        if (r102 > 127) goto L13;
        if (r102 == '.') goto L13;
        r101 = r101 + 1;
    L13:
        return false;
    L14:
        return true;
    }

    public static String desc(Class<?> r100) {
        if (r100.isPrimitive() == false) goto L7;
        return getPrimitiveLetter(r100);
    L7:
        if (r100.isArray() == false) goto L11;
        return "[" + desc(r100.getComponentType());
    L11:
        return "L" + type(r100) + i.f25853b;
    }

    public static String getPrimitiveLetter(Class<?> r100) {
        if (Integer.TYPE != r100) goto L7;
        return "I";
    L7:
        if (Void.TYPE != r100) goto L11;
        return "V";
    L11:
        if (Boolean.TYPE != r100) goto L15;
        return "Z";
    L15:
        if (Character.TYPE != r100) goto L19;
        return "C";
    L19:
        if (Byte.TYPE != r100) goto L23;
        return "B";
    L23:
        if (Short.TYPE != r100) goto L27;
        return ExifInterface.LATITUDE_SOUTH;
    L27:
        if (Float.TYPE != r100) goto L31;
        return FaceService.girlLabel;
    L31:
        if (Long.TYPE != r100) goto L35;
        return "J";
    L35:
        if (Double.TYPE != r100) goto L39;
        return "D";
    L39:
        throw new IllegalStateException("Type: " + r100.getCanonicalName() + " is not a primitive type");
    }

    public static boolean isAndroid(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.toLowerCase();
        if (r101.contains("dalvik") == false) goto L8;
    L9:
        return true;
    L8:
        if (r101.contains("lemur") == true) goto L9;
        return false;
    }

    public static String[] lookupParameterNames(AccessibleObject r100) {
        if (IS_ANDROID == false) goto L7;
        return new String[0];
    L7:
        if ((r100 instanceof Method) == false) goto L9;
        Method r101 = (Method) r100;
        Class<?>[] r102 = r101.getParameterTypes();
        String r103 = r101.getName();
        Class<?> r104 = r101.getDeclaringClass();
        Annotation[][] r105 = TypeUtils.getParameterAnnotations(r101);
    L11:
        if (r102.length == 0) goto L13;
        ClassLoader r106 = r104.getClassLoader();
        if (r106 != null) goto L17;
        r106 = ClassLoader.getSystemClassLoader();
    L17:
        InputStream r107 = r106.getResourceAsStream(r104.getName().replace('.', '/') + ".class");
        if (r107 == null) goto L20;
        ClassReader r108 = new ClassReader(r107, false);     // Catch: Throwable -> L40 IOException -> L42
        TypeCollector r109 = new TypeCollector(r103, r102);     // Catch: Throwable -> L40 IOException -> L42
        r108.accept(r109);     // Catch: Throwable -> L40 IOException -> L42
        String[] r110 = r109.getParameterNamesForMethod();     // Catch: Throwable -> L40 IOException -> L42
        int r111 = 0;
    L23:
        if (r111 >= r110.length) goto L38;
        Annotation[] r112 = r105[r111];     // Catch: Throwable -> L40 IOException -> L42
        if (r112 == null) goto L37;
        int r113 = 0;
    L28:
        if (r113 >= r112.length) goto L37;
        Annotation r114 = r112[r113];     // Catch: Throwable -> L40 IOException -> L42
        if ((r114 instanceof JSONField) == false) goto L36;
        String r115 = ((JSONField) r114).name();     // Catch: Throwable -> L40 IOException -> L42
        if (r115 == null) goto L36;
        if (r115.length() <= 0) goto L36;
        r110[r111] = r115;     // Catch: Throwable -> L40 IOException -> L42
    L36:
        r113 = r113 + 1;
    L37:
        r111 = r111 + 1;
        goto L23
    L38:
        IOUtils.close(r107);
        return r110;
    L42:
        String[] r116 = new String[0];     // Catch: Throwable -> L40
        IOUtils.close(r107);
        return r116;
    L20:
        return new String[0];
    L40:
        th = move-exception;
        IOUtils.close(r107);
        throw th;
    L13:
        return new String[0];
    L9:
        Constructor r117 = (Constructor) r100;
        r102 = r117.getParameterTypes();
        r104 = r117.getDeclaringClass();
        r105 = TypeUtils.getParameterAnnotations(r117);
        r103 = "<init>";
        goto L11
    }

    public static String type(Class<?> r100) {
        if (r100.isArray() == false) goto L7;
        return "[" + desc(r100.getComponentType());
    L7:
        if (r100.isPrimitive() == true) goto L11;
        return r100.getName().replace('.', '/');
    L11:
        return getPrimitiveLetter(r100);
    }

    public static String desc(Method r100) {
        Class<?>[] r101 = r100.getParameterTypes();
        StringBuilder r102 = new StringBuilder((r101.length + 1) << 4);
        r102.append('(');
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L6;
        r102.append(desc(r101[r103]));
        r103 = r103 + 1;
        goto L4
    L6:
        r102.append(')');
        r102.append(desc(r100.getReturnType()));
        return r102.toString();
    }

    public static Type getMethodType(Class<?> r100, String r101) {
        return r100.getMethod(r101, new Class[0]).getGenericReturnType();
    L5:
        return null;
    }
}
