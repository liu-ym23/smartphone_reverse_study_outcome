package aa;

import ba.C0866a;
import ca.AbstractC0897f;
import ca.C0893b;
import ca.C0894c;
import ca.C0895d;
import ca.C0896e;
import io.modelcontextprotocol.spec.McpSchema;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.helpers.NOPLogger;

/* renamed from: aa.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0317d {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f1653a;
    public static final C0893b b = new C0893b(1);
    public static final C0893b c = new C0893b(0);
    public static final boolean d;
    public static volatile C0893b e;
    public static final String[] f;

    static {
        String property;
        try {
            property = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            property = null;
        }
        d = property == null ? false : property.equalsIgnoreCase("true");
        f = new String[]{McpSchema.JSONRPC_VERSION};
    }

    public static ArrayList a() {
        ArrayList arrayList = new ArrayList();
        final ClassLoader classLoader = AbstractC0317d.class.getClassLoader();
        String property = System.getProperty("slf4j.provider");
        C0893b c0893b = null;
        if (property != null && !property.isEmpty()) {
            try {
                org.slf4j.helpers.a.d("Attempting to load provider \"" + property + "\" specified via \"slf4j.provider\" system property");
                c0893b = (C0893b) classLoader.loadClass(property).getConstructor(null).newInstance(null);
            } catch (ClassCastException e6) {
                org.slf4j.helpers.a.b("Specified SLF4JServiceProvider (" + property + ") does not implement SLF4JServiceProvider interface", e6);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e9) {
                org.slf4j.helpers.a.b("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e9);
            }
        }
        if (c0893b != null) {
            arrayList.add(c0893b);
            return arrayList;
        }
        Iterator it = (System.getSecurityManager() == null ? ServiceLoader.load(C0893b.class, classLoader) : (ServiceLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: aa.c
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return ServiceLoader.load(C0893b.class, classLoader);
            }
        })).iterator();
        while (it.hasNext()) {
            try {
                arrayList.add((C0893b) it.next());
            } catch (ServiceConfigurationError e10) {
                String str = "A service provider failed to instantiate:\n" + e10.getMessage();
                org.slf4j.helpers.a.c().println("SLF4J(E): " + str);
            }
        }
        return arrayList;
    }

    public static InterfaceC0315b b(Class cls) {
        int i;
        InterfaceC0315b interfaceC0315bC = c(cls.getName());
        if (d) {
            C0896e c0896e = AbstractC0897f.f2118a;
            Class cls2 = null;
            if (c0896e == null) {
                if (AbstractC0897f.b) {
                    c0896e = null;
                } else {
                    try {
                        c0896e = new C0896e();
                    } catch (SecurityException unused) {
                        c0896e = null;
                    }
                    AbstractC0897f.f2118a = c0896e;
                    AbstractC0897f.b = true;
                }
            }
            if (c0896e != null) {
                Class[] classContext = c0896e.getClassContext();
                String name = AbstractC0897f.class.getName();
                int i6 = 0;
                while (i6 < classContext.length && !name.equals(classContext[i6].getName())) {
                    i6++;
                }
                if (i6 >= classContext.length || (i = i6 + 2) >= classContext.length) {
                    throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
                }
                cls2 = classContext[i];
            }
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                org.slf4j.helpers.a.e("Detected logger name mismatch. Given name: \"" + interfaceC0315bC.getName() + "\"; computed name: \"" + cls2.getName() + "\".");
                org.slf4j.helpers.a.e("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return interfaceC0315bC;
    }

    public static InterfaceC0315b c(String str) {
        C0893b c0893b;
        InterfaceC0314a interfaceC0314a;
        if (f1653a == 0) {
            synchronized (AbstractC0317d.class) {
                try {
                    if (f1653a == 0) {
                        f1653a = 1;
                        d();
                    }
                } finally {
                }
            }
        }
        int i = f1653a;
        if (i == 1) {
            c0893b = b;
        } else {
            if (i == 2) {
                throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
            }
            if (i == 3) {
                c0893b = e;
            } else {
                if (i != 4) {
                    throw new IllegalStateException("Unreachable code");
                }
                c0893b = c;
            }
        }
        switch (c0893b.f2106a) {
            case 0:
                interfaceC0314a = (F1.a) c0893b.b;
                break;
            default:
                interfaceC0314a = (C0895d) c0893b.b;
                break;
        }
        return interfaceC0314a.d(str);
    }

    public static final void d() {
        try {
            ArrayList arrayListA = a();
            h(arrayListA);
            if (arrayListA.isEmpty()) {
                f1653a = 4;
                org.slf4j.helpers.a.e("No SLF4J providers were found.");
                org.slf4j.helpers.a.e("Defaulting to no-operation (NOP) logger implementation");
                org.slf4j.helpers.a.e("See https://www.slf4j.org/codes.html#noProviders for further details.");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                try {
                    ClassLoader classLoader = AbstractC0317d.class.getClassLoader();
                    Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class") : classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
                    while (systemResources.hasMoreElements()) {
                        linkedHashSet.add(systemResources.nextElement());
                    }
                } catch (IOException e6) {
                    org.slf4j.helpers.a.b("Error getting resources from path", e6);
                }
                g(linkedHashSet);
            } else {
                e = (C0893b) arrayListA.get(0);
                e.getClass();
                e.getClass();
                f1653a = 3;
                f(arrayListA);
            }
            e();
            if (f1653a == 3) {
                try {
                    switch (e.f2106a) {
                        case 0:
                            boolean z10 = false;
                            for (String str : f) {
                                if ("2.0.99".startsWith(str)) {
                                    z10 = true;
                                }
                            }
                            if (z10) {
                                return;
                            }
                            org.slf4j.helpers.a.e("The requested version 2.0.99 by your slf4j provider is not compatible with " + Arrays.asList(f).toString());
                            org.slf4j.helpers.a.e("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
                            return;
                        default:
                            throw new UnsupportedOperationException();
                    }
                } catch (Throwable th) {
                    org.slf4j.helpers.a.b("Unexpected problem occurred during version sanity check", th);
                }
            }
        } catch (Exception e9) {
            f1653a = 2;
            org.slf4j.helpers.a.b("Failed to instantiate SLF4J LoggerFactory", e9);
            throw new IllegalStateException("Unexpected initialization failure", e9);
        }
    }

    public static void e() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C0893b c0893b = b;
        synchronized (c0893b) {
            try {
                ((C0895d) c0893b.b).f2108a = true;
                C0895d c0895d = (C0895d) c0893b.b;
                c0895d.getClass();
                Iterator it = new ArrayList(c0895d.b.values()).iterator();
                while (it.hasNext()) {
                    C0894c c0894c = (C0894c) it.next();
                    c0894c.b = c(c0894c.f2107a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = ((C0895d) b.b).c;
        int size = linkedBlockingQueue.size();
        ArrayList arrayList = new ArrayList(128);
        int i = 0;
        while (linkedBlockingQueue.drainTo(arrayList, 128) != 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C0866a c0866a = (C0866a) it2.next();
                if (c0866a != null) {
                    C0894c c0894c2 = c0866a.b;
                    String str = c0894c2.f2107a;
                    if (c0894c2.b == null) {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    }
                    if (!(c0894c2.b instanceof NOPLogger)) {
                        if (!c0894c2.l()) {
                            org.slf4j.helpers.a.e(str);
                        } else if (c0894c2.d(c0866a.f2066a) && c0894c2.l()) {
                            try {
                                c0894c2.d.invoke(c0894c2.b, c0866a);
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                            }
                        }
                    }
                }
                int i6 = i + 1;
                if (i == 0) {
                    if (c0866a.b.l()) {
                        org.slf4j.helpers.a.e("A number (" + size + ") of logging calls during the initialization phase have been intercepted and are");
                        org.slf4j.helpers.a.e("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        org.slf4j.helpers.a.e("See also https://www.slf4j.org/codes.html#replay");
                    } else if (!(c0866a.b.b instanceof NOPLogger)) {
                        org.slf4j.helpers.a.e("The following set of substitute loggers may have been accessed");
                        org.slf4j.helpers.a.e("during the initialization phase. Logging calls during this");
                        org.slf4j.helpers.a.e("phase were not honored. However, subsequent logging calls to these");
                        org.slf4j.helpers.a.e("loggers will work as normally expected.");
                        org.slf4j.helpers.a.e("See also https://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i = i6;
            }
            arrayList.clear();
        }
        C0895d c0895d2 = (C0895d) b.b;
        c0895d2.b.clear();
        c0895d2.c.clear();
    }

    public static void f(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No providers were found which is impossible after successful initialization.");
        }
        if (arrayList.size() > 1) {
            org.slf4j.helpers.a.d("Actual provider is of type [" + arrayList.get(0) + "]");
            return;
        }
        org.slf4j.helpers.a.a("Connected with provider of type [" + ((C0893b) arrayList.get(0)).getClass().getName() + "]");
    }

    public static void g(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.isEmpty()) {
            return;
        }
        org.slf4j.helpers.a.e("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            org.slf4j.helpers.a.e("Ignoring binding found at [" + ((URL) it.next()) + "]");
        }
        org.slf4j.helpers.a.e("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    public static void h(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            org.slf4j.helpers.a.e("Class path contains multiple SLF4J providers.");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                org.slf4j.helpers.a.e("Found provider [" + ((C0893b) it.next()) + "]");
            }
            org.slf4j.helpers.a.e("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
