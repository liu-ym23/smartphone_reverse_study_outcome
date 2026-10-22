package ch.qos.logback.core.util;

import B0.g;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.PropertyContainer;
import ch.qos.logback.core.spi.ScanException;
import ch.qos.logback.core.subst.NodeToStringTransformer;
import java.util.Properties;

/* loaded from: classes.dex */
public class OptionHelper {
    static final String DELIM_DEFAULT = ":-";
    static final int DELIM_DEFAULT_LEN = 2;
    static final String DELIM_START = "${";
    static final int DELIM_START_LEN = 2;
    static final char DELIM_STOP = '}';
    static final int DELIM_STOP_LEN = 1;
    static final String _IS_UNDEFINED = "_IS_UNDEFINED";

    public static String[] extractDefaultReplacement(String str) {
        String[] strArr = new String[2];
        if (str == null) {
            return strArr;
        }
        strArr[0] = str;
        int iIndexOf = str.indexOf(":-");
        if (iIndexOf != -1) {
            strArr[0] = str.substring(0, iIndexOf);
            strArr[1] = str.substring(iIndexOf + 2);
        }
        return strArr;
    }

    public static String getEnv(String str) {
        try {
            return System.getenv(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static Properties getSystemProperties() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return System.getProperty(str, str2);
        } catch (SecurityException unused) {
            return str2;
        }
    }

    public static Object instantiateByClassName(String str, Class<?> cls, Context context) throws DynamicClassLoadingException, IncompatibleClassException {
        return instantiateByClassName(str, cls, Loader.getClassLoaderOfObject(context));
    }

    public static Object instantiateByClassNameAndParameter(String str, Class<?> cls, Context context, Class<?> cls2, Object obj) throws DynamicClassLoadingException, IncompatibleClassException {
        return instantiateByClassNameAndParameter(str, cls, Loader.getClassLoaderOfObject(context), cls2, obj);
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static String propertyLookup(String str, PropertyContainer propertyContainer, PropertyContainer propertyContainer2) {
        String property = propertyContainer.getProperty(str);
        if (property == null && propertyContainer2 != null) {
            property = propertyContainer2.getProperty(str);
        }
        if (property == null) {
            property = getSystemProperty(str, null);
        }
        return property == null ? getEnv(str) : property;
    }

    public static void setSystemProperties(ContextAware contextAware, Properties properties) {
        for (String str : properties.keySet()) {
            setSystemProperty(contextAware, str, properties.getProperty(str));
        }
    }

    public static void setSystemProperty(ContextAware contextAware, String str, String str2) {
        try {
            System.setProperty(str, str2);
        } catch (SecurityException e4) {
            contextAware.addError("Failed to set system property [" + str + "]", e4);
        }
    }

    public static String substVars(String str, PropertyContainer propertyContainer) {
        return substVars(str, propertyContainer, null);
    }

    public static boolean toBoolean(String str, boolean z4) {
        if (str == null) {
            return z4;
        }
        String strTrim = str.trim();
        if ("true".equalsIgnoreCase(strTrim)) {
            return true;
        }
        if ("false".equalsIgnoreCase(strTrim)) {
            return false;
        }
        return z4;
    }

    public static String getSystemProperty(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static String substVars(String str, PropertyContainer propertyContainer, PropertyContainer propertyContainer2) {
        try {
            return NodeToStringTransformer.substituteVariable(str, propertyContainer, propertyContainer2);
        } catch (ScanException e4) {
            throw new IllegalArgumentException(g.n("Failed to parse input [", str, "]"), e4);
        }
    }

    public static Object instantiateByClassName(String str, Class<?> cls, ClassLoader classLoader) throws DynamicClassLoadingException, IncompatibleClassException {
        return instantiateByClassNameAndParameter(str, cls, classLoader, (Class<?>) null, (Object) null);
    }

    public static Object instantiateByClassNameAndParameter(String str, Class<?> cls, ClassLoader classLoader, Class<?> cls2, Object obj) throws DynamicClassLoadingException, IncompatibleClassException {
        str.getClass();
        try {
            Class<?> clsLoadClass = classLoader.loadClass(str);
            if (!cls.isAssignableFrom(clsLoadClass)) {
                throw new IncompatibleClassException(cls, clsLoadClass);
            }
            if (cls2 == null) {
                return clsLoadClass.newInstance();
            }
            return clsLoadClass.getConstructor(cls2).newInstance(obj);
        } catch (IncompatibleClassException e4) {
            throw e4;
        } catch (Throwable th) {
            throw new DynamicClassLoadingException("Failed to instantiate type ".concat(str), th);
        }
    }
}
