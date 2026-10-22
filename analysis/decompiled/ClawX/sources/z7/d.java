package z7;

import b8.e;
import b8.g;
import b8.h;
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
import m.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f6549a;

    /* renamed from: b, reason: collision with root package name */
    public static final b8.c f6550b = new b8.c(1);

    /* renamed from: c, reason: collision with root package name */
    public static final b8.c f6551c = new b8.c(0);
    public static final boolean d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile b8.c f6552e;

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f6553f;

    static {
        String property;
        try {
            property = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            property = null;
        }
        d = property == null ? false : property.equalsIgnoreCase("true");
        f6553f = new String[]{"2.0"};
    }

    public static ArrayList a() {
        ArrayList arrayList = new ArrayList();
        final ClassLoader classLoader = d.class.getClassLoader();
        String property = System.getProperty("slf4j.provider");
        b8.c cVar = null;
        if (property != null && !property.isEmpty()) {
            try {
                String str = "Attempting to load provider \"" + property + "\" specified via \"slf4j.provider\" system property";
                int i8 = b8.d.f1001a;
                if (f.a(2) >= f.a(b8.d.f1002b)) {
                    b8.d.b().println("SLF4J(I): " + str);
                }
                cVar = (b8.c) classLoader.loadClass(property).getConstructor(null).newInstance(null);
            } catch (ClassCastException e9) {
                b8.d.a("Specified SLF4JServiceProvider (" + property + ") does not implement SLF4JServiceProvider interface", e9);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
                b8.d.a("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e10);
            }
        }
        if (cVar != null) {
            arrayList.add(cVar);
            return arrayList;
        }
        Iterator it = (System.getSecurityManager() == null ? ServiceLoader.load(b8.c.class, classLoader) : (ServiceLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: z7.c
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return ServiceLoader.load(b8.c.class, classLoader);
            }
        })).iterator();
        while (it.hasNext()) {
            try {
                arrayList.add((b8.c) it.next());
            } catch (ServiceConfigurationError e11) {
                String str2 = "A service provider failed to instantiate:\n" + e11.getMessage();
                b8.d.b().println("SLF4J(E): " + str2);
            }
        }
        return arrayList;
    }

    public static b b(Class cls) {
        int i8;
        b bVarC = c(cls.getName());
        if (d) {
            g gVar = h.f1012a;
            Class cls2 = null;
            if (gVar == null) {
                if (h.f1013b) {
                    gVar = null;
                } else {
                    try {
                        gVar = new g();
                    } catch (SecurityException unused) {
                        gVar = null;
                    }
                    h.f1012a = gVar;
                    h.f1013b = true;
                }
            }
            if (gVar != null) {
                Class[] classContext = gVar.getClassContext();
                String name = h.class.getName();
                int i9 = 0;
                while (i9 < classContext.length && !name.equals(classContext[i9].getName())) {
                    i9++;
                }
                if (i9 >= classContext.length || (i8 = i9 + 2) >= classContext.length) {
                    throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
                }
                cls2 = classContext[i8];
            }
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                b8.d.c("Detected logger name mismatch. Given name: \"" + bVarC.getName() + "\"; computed name: \"" + cls2.getName() + "\".");
                b8.d.c("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return bVarC;
    }

    public static b c(String str) {
        b8.c cVar;
        a aVar;
        if (f6549a == 0) {
            synchronized (d.class) {
                try {
                    if (f6549a == 0) {
                        f6549a = 1;
                        d();
                    }
                } finally {
                }
            }
        }
        int i8 = f6549a;
        if (i8 == 1) {
            cVar = f6550b;
        } else {
            if (i8 == 2) {
                throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
            }
            if (i8 == 3) {
                cVar = f6552e;
            } else {
                if (i8 != 4) {
                    throw new IllegalStateException("Unreachable code");
                }
                cVar = f6551c;
            }
        }
        switch (cVar.f999a) {
            case 0:
                aVar = (t1.f) cVar.f1000b;
                break;
            default:
                aVar = (b8.f) cVar.f1000b;
                break;
        }
        return aVar.a(str);
    }

    public static final void d() {
        try {
            ArrayList arrayListA = a();
            h(arrayListA);
            if (arrayListA.isEmpty()) {
                f6549a = 4;
                b8.d.c("No SLF4J providers were found.");
                b8.d.c("Defaulting to no-operation (NOP) logger implementation");
                b8.d.c("See https://www.slf4j.org/codes.html#noProviders for further details.");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                try {
                    ClassLoader classLoader = d.class.getClassLoader();
                    Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class") : classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
                    while (systemResources.hasMoreElements()) {
                        linkedHashSet.add(systemResources.nextElement());
                    }
                } catch (IOException e9) {
                    b8.d.a("Error getting resources from path", e9);
                }
                g(linkedHashSet);
            } else {
                f6552e = (b8.c) arrayListA.get(0);
                f6552e.getClass();
                f6549a = 3;
                f(arrayListA);
            }
            e();
            if (f6549a == 3) {
                try {
                    switch (f6552e.f999a) {
                        case 0:
                            boolean z = false;
                            for (String str : f6553f) {
                                if ("2.0.99".startsWith(str)) {
                                    z = true;
                                }
                            }
                            if (z) {
                                return;
                            }
                            b8.d.c("The requested version 2.0.99 by your slf4j provider is not compatible with " + Arrays.asList(f6553f).toString());
                            b8.d.c("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
                            return;
                        default:
                            throw new UnsupportedOperationException();
                    }
                } catch (Throwable th) {
                    b8.d.a("Unexpected problem occurred during version sanity check", th);
                }
            }
        } catch (Exception e10) {
            f6549a = 2;
            b8.d.a("Failed to instantiate SLF4J LoggerFactory", e10);
            throw new IllegalStateException("Unexpected initialization failure", e10);
        }
    }

    public static void e() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        b8.c cVar = f6550b;
        synchronized (cVar) {
            try {
                ((b8.f) cVar.f1000b).f1009a = true;
                b8.f fVar = (b8.f) cVar.f1000b;
                fVar.getClass();
                ArrayList arrayList = new ArrayList(fVar.f1010b.values());
                int size = arrayList.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj = arrayList.get(i8);
                    i8++;
                    e eVar = (e) obj;
                    eVar.f1004b = c(eVar.f1003a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = ((b8.f) f6550b.f1000b).f1011c;
        int size2 = linkedBlockingQueue.size();
        ArrayList arrayList2 = new ArrayList(128);
        int i9 = 0;
        while (linkedBlockingQueue.drainTo(arrayList2, 128) != 0) {
            int size3 = arrayList2.size();
            int i10 = 0;
            while (i10 < size3) {
                Object obj2 = arrayList2.get(i10);
                i10++;
                a8.c cVar2 = (a8.c) obj2;
                if (cVar2 != null) {
                    e eVar2 = cVar2.f239b;
                    String str = eVar2.f1003a;
                    if (eVar2.f1004b == null) {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    }
                    if (!(eVar2.f1004b instanceof b8.b)) {
                        if (!eVar2.t()) {
                            b8.d.c(str);
                        } else if (eVar2.j(cVar2.f238a) && eVar2.t()) {
                            try {
                                eVar2.d.invoke(eVar2.f1004b, cVar2);
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                            }
                        }
                    }
                }
                int i11 = i9 + 1;
                if (i9 == 0) {
                    if (cVar2.f239b.t()) {
                        b8.d.c("A number (" + size2 + ") of logging calls during the initialization phase have been intercepted and are");
                        b8.d.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        b8.d.c("See also https://www.slf4j.org/codes.html#replay");
                    } else if (!(cVar2.f239b.f1004b instanceof b8.b)) {
                        b8.d.c("The following set of substitute loggers may have been accessed");
                        b8.d.c("during the initialization phase. Logging calls during this");
                        b8.d.c("phase were not honored. However, subsequent logging calls to these");
                        b8.d.c("loggers will work as normally expected.");
                        b8.d.c("See also https://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i9 = i11;
            }
            arrayList2.clear();
        }
        b8.f fVar2 = (b8.f) f6550b.f1000b;
        fVar2.f1010b.clear();
        fVar2.f1011c.clear();
    }

    public static void f(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No providers were found which is impossible after successful initialization.");
        }
        if (arrayList.size() > 1) {
            String str = "Actual provider is of type [" + arrayList.get(0) + "]";
            int i8 = b8.d.f1001a;
            if (f.a(2) >= f.a(b8.d.f1002b)) {
                b8.d.b().println("SLF4J(I): " + str);
                return;
            }
            return;
        }
        String str2 = "Connected with provider of type [" + ((b8.c) arrayList.get(0)).getClass().getName() + "]";
        int i9 = b8.d.f1001a;
        if (f.a(1) >= f.a(b8.d.f1002b)) {
            b8.d.b().println("SLF4J(D): " + str2);
        }
    }

    public static void g(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.isEmpty()) {
            return;
        }
        b8.d.c("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            b8.d.c("Ignoring binding found at [" + ((URL) it.next()) + "]");
        }
        b8.d.c("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    public static void h(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            b8.d.c("Class path contains multiple SLF4J providers.");
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = arrayList.get(i8);
                i8++;
                b8.d.c("Found provider [" + ((b8.c) obj) + "]");
            }
            b8.d.c("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
