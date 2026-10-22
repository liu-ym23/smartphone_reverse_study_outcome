package ch.qos.logback.classic.spi;

import ch.qos.logback.core.CoreConstants;
import java.net.URL;
import java.security.CodeSource;
import java.util.HashMap;
import sun.reflect.Reflection;

/* loaded from: classes.dex */
public class PackagingDataCalculator {
    private static boolean GET_CALLER_CLASS_METHOD_AVAILABLE = false;
    static final StackTraceElementProxy[] STEP_ARRAY_TEMPLATE = new StackTraceElementProxy[0];
    HashMap<String, ClassPackagingData> cache = new HashMap<>();

    static {
        try {
            Reflection.getCallerClass(2);
            GET_CALLER_CLASS_METHOD_AVAILABLE = true;
        } catch (NoClassDefFoundError | NoSuchMethodError | UnsupportedOperationException unused) {
        } catch (Throwable th) {
            System.err.println("Unexpected exception");
            th.printStackTrace();
        }
    }

    private Class bestEffortLoadClass(ClassLoader classLoader, String str) {
        Class clsLoadClass = loadClass(classLoader, str);
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != classLoader) {
            clsLoadClass = loadClass(contextClassLoader, str);
        }
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private ClassPackagingData calculateByExactType(Class cls) {
        String name = cls.getName();
        ClassPackagingData classPackagingData = this.cache.get(name);
        if (classPackagingData != null) {
            return classPackagingData;
        }
        ClassPackagingData classPackagingData2 = new ClassPackagingData(getCodeLocation(cls), getImplementationVersion(cls));
        this.cache.put(name, classPackagingData2);
        return classPackagingData2;
    }

    private ClassPackagingData computeBySTEP(StackTraceElementProxy stackTraceElementProxy, ClassLoader classLoader) {
        String className = stackTraceElementProxy.ste.getClassName();
        ClassPackagingData classPackagingData = this.cache.get(className);
        if (classPackagingData != null) {
            return classPackagingData;
        }
        Class clsBestEffortLoadClass = bestEffortLoadClass(classLoader, className);
        ClassPackagingData classPackagingData2 = new ClassPackagingData(getCodeLocation(clsBestEffortLoadClass), getImplementationVersion(clsBestEffortLoadClass), false);
        this.cache.put(className, classPackagingData2);
        return classPackagingData2;
    }

    private boolean isFolder(int i4, String str) {
        return i4 != -1 && i4 + 1 == str.length();
    }

    private Class loadClass(ClassLoader classLoader, String str) {
        if (classLoader == null) {
            return null;
        }
        try {
            return classLoader.loadClass(str);
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void calculate(IThrowableProxy iThrowableProxy) {
        while (iThrowableProxy != null) {
            populateFrames(iThrowableProxy.getStackTraceElementProxyArray());
            IThrowableProxy[] suppressed = iThrowableProxy.getSuppressed();
            if (suppressed != null) {
                for (IThrowableProxy iThrowableProxy2 : suppressed) {
                    populateFrames(iThrowableProxy2.getStackTraceElementProxyArray());
                }
            }
            iThrowableProxy = iThrowableProxy.getCause();
        }
    }

    public String getCodeLocation(Class cls) {
        URL location;
        if (cls == null) {
            return "na";
        }
        try {
            CodeSource codeSource = cls.getProtectionDomain().getCodeSource();
            if (codeSource == null || (location = codeSource.getLocation()) == null) {
                return "na";
            }
            String string = location.toString();
            String codeLocation = getCodeLocation(string, '/');
            return codeLocation != null ? codeLocation : getCodeLocation(string, CoreConstants.ESCAPE_CHAR);
        } catch (Exception unused) {
            return "na";
        }
    }

    public String getImplementationVersion(Class cls) {
        Package r12;
        String implementationVersion;
        return (cls == null || (r12 = cls.getPackage()) == null || (implementationVersion = r12.getImplementationVersion()) == null) ? "na" : implementationVersion;
    }

    public void populateFrames(StackTraceElementProxy[] stackTraceElementProxyArr) {
        StackTraceElement[] stackTrace = new Throwable("local stack reference").getStackTrace();
        int iFindNumberOfCommonFrames = STEUtil.findNumberOfCommonFrames(stackTrace, stackTraceElementProxyArr);
        int length = stackTrace.length - iFindNumberOfCommonFrames;
        int length2 = stackTraceElementProxyArr.length - iFindNumberOfCommonFrames;
        ClassLoader classLoader = null;
        ClassLoader classLoader2 = null;
        int i4 = 0;
        for (int i5 = 0; i5 < iFindNumberOfCommonFrames; i5++) {
            Class callerClass = GET_CALLER_CLASS_METHOD_AVAILABLE ? Reflection.getCallerClass(((length + i5) - i4) + 1) : null;
            StackTraceElementProxy stackTraceElementProxy = stackTraceElementProxyArr[length2 + i5];
            String className = stackTraceElementProxy.ste.getClassName();
            if (callerClass == null || !className.equals(callerClass.getName())) {
                i4++;
                stackTraceElementProxy.setClassPackagingData(computeBySTEP(stackTraceElementProxy, classLoader2));
            } else {
                classLoader2 = callerClass.getClassLoader();
                if (classLoader == null) {
                    classLoader = classLoader2;
                }
                stackTraceElementProxy.setClassPackagingData(calculateByExactType(callerClass));
            }
        }
        populateUncommonFrames(iFindNumberOfCommonFrames, stackTraceElementProxyArr, classLoader);
    }

    public void populateUncommonFrames(int i4, StackTraceElementProxy[] stackTraceElementProxyArr, ClassLoader classLoader) {
        int length = stackTraceElementProxyArr.length - i4;
        for (int i5 = 0; i5 < length; i5++) {
            StackTraceElementProxy stackTraceElementProxy = stackTraceElementProxyArr[i5];
            stackTraceElementProxy.setClassPackagingData(computeBySTEP(stackTraceElementProxy, classLoader));
        }
    }

    private String getCodeLocation(String str, char c4) {
        int iLastIndexOf = str.lastIndexOf(c4);
        if (isFolder(iLastIndexOf, str)) {
            return str.substring(str.lastIndexOf(c4, iLastIndexOf - 1) + 1);
        }
        if (iLastIndexOf > 0) {
            return str.substring(iLastIndexOf + 1);
        }
        return null;
    }
}
