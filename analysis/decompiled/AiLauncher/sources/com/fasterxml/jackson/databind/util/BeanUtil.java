package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* loaded from: classes2.dex */
public class BeanUtil {
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String checkUnsupportedType(com.fasterxml.jackson.databind.cfg.MapperConfig<?> r4, com.fasterxml.jackson.databind.JavaType r5) {
        /*
            java.lang.Class r0 = r5.getRawClass()
            java.lang.String r0 = r0.getName()
            boolean r1 = isJava8TimeClass(r0)
            r2 = 0
            if (r1 == 0) goto L35
            r1 = 46
            r3 = 10
            int r0 = r0.indexOf(r1, r3)
            if (r0 < 0) goto L1a
            return r2
        L1a:
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            boolean r0 = r5.isTypeOrSubTypeOf(r0)
            if (r0 == 0) goto L23
            return r2
        L23:
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.REQUIRE_HANDLERS_FOR_JAVA8_TIMES
            if (r4 == 0) goto L2f
            boolean r4 = r4.isEnabled(r0)
            if (r4 == 0) goto L2e
            goto L2f
        L2e:
            return r2
        L2f:
            java.lang.String r4 = "Java 8 date/time"
            java.lang.String r1 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310"
        L33:
            r2 = r0
            goto L57
        L35:
            boolean r1 = isJodaTimeClass(r0)
            if (r1 == 0) goto L40
            java.lang.String r4 = "Joda date/time"
            java.lang.String r1 = "com.fasterxml.jackson.datatype:jackson-datatype-joda"
            goto L57
        L40:
            boolean r0 = isJava8OptionalClass(r0)
            if (r0 == 0) goto L76
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.REQUIRE_HANDLERS_FOR_JAVA8_OPTIONALS
            if (r4 == 0) goto L52
            boolean r4 = r4.isEnabled(r0)
            if (r4 == 0) goto L51
            goto L52
        L51:
            return r2
        L52:
            java.lang.String r4 = "Java 8 optional"
            java.lang.String r1 = "com.fasterxml.jackson.datatype:jackson-datatype-jdk8"
            goto L33
        L57:
            java.lang.String r5 = com.fasterxml.jackson.databind.util.ClassUtil.getTypeDescription(r5)
            java.lang.Object[] r4 = new java.lang.Object[]{r4, r5, r1}
            java.lang.String r5 = "%s type %s not supported by default: add Module \"%s\" to enable handling"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            if (r2 == 0) goto L75
            java.lang.String r5 = r2.name()
            java.lang.Object[] r4 = new java.lang.Object[]{r4, r5}
            java.lang.String r5 = "%s (or disable `MapperFeature.%s`)"
            java.lang.String r4 = java.lang.String.format(r5, r4)
        L75:
            return r4
        L76:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.util.BeanUtil.checkUnsupportedType(com.fasterxml.jackson.databind.cfg.MapperConfig, com.fasterxml.jackson.databind.JavaType):java.lang.String");
    }

    public static Object getDefaultValue(JavaType javaType) {
        Class<?> rawClass = javaType.getRawClass();
        Class<?> clsPrimitiveType = ClassUtil.primitiveType(rawClass);
        if (clsPrimitiveType != null) {
            return ClassUtil.defaultValue(clsPrimitiveType);
        }
        if (javaType.isContainerType() || javaType.isReferenceType()) {
            return JsonInclude.Include.NON_EMPTY;
        }
        if (rawClass == String.class) {
            return "";
        }
        if (javaType.isTypeOrSubTypeOf(Date.class)) {
            return new Date(0L);
        }
        if (!javaType.isTypeOrSubTypeOf(Calendar.class)) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(0L);
        return gregorianCalendar;
    }

    public static boolean isCglibGetCallbacks(AnnotatedMethod annotatedMethod) {
        Class<?> rawType = annotatedMethod.getRawType();
        if (rawType.isArray()) {
            String name = rawType.getComponentType().getName();
            if (name.contains(".cglib")) {
                return name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib");
            }
        }
        return false;
    }

    public static boolean isGroovyMetaClassGetter(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.getRawType().getName().startsWith("groovy.lang");
    }

    public static boolean isJava8OptionalClass(Class<?> cls) {
        return isJava8OptionalClass(cls.getName());
    }

    public static boolean isJava8TimeClass(Class<?> cls) {
        return isJava8TimeClass(cls.getName());
    }

    public static boolean isJodaTimeClass(Class<?> cls) {
        return isJodaTimeClass(cls.getName());
    }

    public static String legacyManglePropertyName(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return null;
        }
        char cCharAt = str.charAt(i10);
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i10);
        }
        StringBuilder sb2 = new StringBuilder(length - i10);
        sb2.append(lowerCase);
        while (true) {
            i10++;
            if (i10 >= length) {
                break;
            }
            char cCharAt2 = str.charAt(i10);
            char lowerCase2 = Character.toLowerCase(cCharAt2);
            if (cCharAt2 == lowerCase2) {
                sb2.append((CharSequence) str, i10, length);
                break;
            }
            sb2.append(lowerCase2);
        }
        return sb2.toString();
    }

    @Deprecated
    public static String okNameForGetter(AnnotatedMethod annotatedMethod, boolean z10) {
        String name = annotatedMethod.getName();
        String strOkNameForIsGetter = okNameForIsGetter(annotatedMethod, name, z10);
        return strOkNameForIsGetter == null ? okNameForRegularGetter(annotatedMethod, name, z10) : strOkNameForIsGetter;
    }

    @Deprecated
    public static String okNameForIsGetter(AnnotatedMethod annotatedMethod, String str, boolean z10) {
        if (!str.startsWith("is")) {
            return null;
        }
        Class<?> rawType = annotatedMethod.getRawType();
        if (rawType == Boolean.class || rawType == Boolean.TYPE) {
            return z10 ? stdManglePropertyName(str, 2) : legacyManglePropertyName(str, 2);
        }
        return null;
    }

    @Deprecated
    public static String okNameForMutator(AnnotatedMethod annotatedMethod, String str, boolean z10) {
        String name = annotatedMethod.getName();
        if (name.startsWith(str)) {
            return z10 ? stdManglePropertyName(name, str.length()) : legacyManglePropertyName(name, str.length());
        }
        return null;
    }

    @Deprecated
    public static String okNameForRegularGetter(AnnotatedMethod annotatedMethod, String str, boolean z10) {
        if (!str.startsWith("get")) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (isCglibGetCallbacks(annotatedMethod)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && isGroovyMetaClassGetter(annotatedMethod)) {
            return null;
        }
        return z10 ? stdManglePropertyName(str, 3) : legacyManglePropertyName(str, 3);
    }

    @Deprecated
    public static String okNameForSetter(AnnotatedMethod annotatedMethod, boolean z10) {
        return okNameForMutator(annotatedMethod, "set", z10);
    }

    public static String stdManglePropertyName(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return null;
        }
        char cCharAt = str.charAt(i10);
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i10);
        }
        int i11 = i10 + 1;
        if (i11 < length && Character.isUpperCase(str.charAt(i11))) {
            return str.substring(i10);
        }
        StringBuilder sb2 = new StringBuilder(length - i10);
        sb2.append(lowerCase);
        sb2.append((CharSequence) str, i11, length);
        return sb2.toString();
    }

    private static boolean isJava8OptionalClass(String str) {
        return str.startsWith("java.util.Optional");
    }

    private static boolean isJava8TimeClass(String str) {
        return str.startsWith("java.time.");
    }

    private static boolean isJodaTimeClass(String str) {
        return str.startsWith("org.joda.time.");
    }

    @Deprecated
    public static String checkUnsupportedType(JavaType javaType) {
        return checkUnsupportedType(null, javaType);
    }
}
