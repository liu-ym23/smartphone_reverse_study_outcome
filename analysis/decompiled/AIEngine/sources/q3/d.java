package q3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {
    public static String a(JavaType javaType) {
        String str;
        String str2;
        String name = javaType.f3690a.getName();
        if (name.startsWith("java.time.")) {
            if (name.indexOf(46, 10) >= 0) {
                return null;
            }
            str = "Java 8 date/time";
            str2 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
        } else {
            if (!name.startsWith("org.joda.time.")) {
                return null;
            }
            str = "Joda date/time";
            str2 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
        }
        return str + " type " + com.fasterxml.jackson.databind.util.a.r(javaType) + " not supported by default: add Module \"" + str2 + "\" to enable handling";
    }

    public static Object b(JavaType javaType) {
        Class<?> cls = javaType.f3690a;
        Class<?> clsZ = com.fasterxml.jackson.databind.util.a.z(cls);
        if (clsZ == null) {
            if (javaType.y() || javaType.d()) {
                return JsonInclude.Include.f3466c;
            }
            if (cls == String.class) {
                return "";
            }
            if (javaType.D(Date.class)) {
                return new Date(0L);
            }
            if (!javaType.D(Calendar.class)) {
                return null;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0L);
            return gregorianCalendar;
        }
        if (clsZ == Integer.TYPE) {
            return 0;
        }
        if (clsZ == Long.TYPE) {
            return 0L;
        }
        if (clsZ == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (clsZ == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (clsZ == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (clsZ == Byte.TYPE) {
            return (byte) 0;
        }
        if (clsZ == Short.TYPE) {
            return (short) 0;
        }
        if (clsZ == Character.TYPE) {
            return (char) 0;
        }
        throw new IllegalArgumentException("Class " + clsZ.getName() + " is not a primitive type");
    }
}
