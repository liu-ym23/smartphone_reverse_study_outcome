package vc;

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
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.helpers.Reporter;
import org.slf4j.helpers.j;
import org.slf4j.helpers.l;
import xc.h;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f42875a;

    /* renamed from: e, reason: collision with root package name */
    public static volatile h f42879e;

    /* renamed from: b, reason: collision with root package name */
    public static final j f42876b = new j();

    /* renamed from: c, reason: collision with root package name */
    public static final org.slf4j.helpers.f f42877c = new org.slf4j.helpers.f();

    /* renamed from: d, reason: collision with root package name */
    public static boolean f42878d = l.d("slf4j.detectLoggerNameMismatch");

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f42880f = {"2.0"};

    public static final void A() {
        try {
            String strB = f42879e.b();
            boolean z10 = false;
            for (String str : f42880f) {
                if (strB.startsWith(str)) {
                    z10 = true;
                }
            }
            if (z10) {
                return;
            }
            Reporter.i("The requested version " + strB + " by your slf4j provider is not compatible with " + Arrays.asList(f42880f).toString());
            Reporter.i("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (Throwable th) {
            Reporter.c("Unexpected problem occurred during version sanity check", th);
        }
    }

    public static final void b() {
        try {
            List<h> listI = i();
            y(listI);
            if (listI == null || listI.isEmpty()) {
                f42875a = 4;
                Reporter.i("No SLF4J providers were found.");
                Reporter.i("Defaulting to no-operation (NOP) logger implementation");
                Reporter.i("See https://www.slf4j.org/codes.html#noProviders for further details.");
                x(h());
            } else {
                f42879e = listI.get(0);
                c();
                f42879e.initialize();
                f42875a = 3;
                w(listI);
            }
            t();
        } catch (Exception e10) {
            g(e10);
            throw new IllegalStateException("Unexpected initialization failure", e10);
        }
    }

    public static void c() {
        xc.f fVarD = f42879e.d();
        if (fVarD != null) {
            f.g(fVarD);
        }
    }

    public static void d(wc.d dVar, int i10) {
        if (dVar.f().r()) {
            e(i10);
        } else {
            if (dVar.f().A()) {
                return;
            }
            f();
        }
    }

    public static void e(int i10) {
        Reporter.i("A number (" + i10 + ") of logging calls during the initialization phase have been intercepted and are");
        Reporter.i("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        Reporter.i("See also https://www.slf4j.org/codes.html#replay");
    }

    public static void f() {
        Reporter.i("The following set of substitute loggers may have been accessed");
        Reporter.i("during the initialization phase. Logging calls during this");
        Reporter.i("phase were not honored. However, subsequent logging calls to these");
        Reporter.i("loggers will work as normally expected.");
        Reporter.i("See also https://www.slf4j.org/codes.html#substituteLogger");
    }

    public static void g(Throwable th) {
        f42875a = 2;
        Reporter.c("Failed to instantiate SLF4J LoggerFactory", th);
    }

    public static Set<URL> h() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = e.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class") : classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
            return linkedHashSet;
        } catch (IOException e10) {
            Reporter.c("Error getting resources from path", e10);
            return linkedHashSet;
        }
    }

    public static List<h> i() {
        ArrayList arrayList = new ArrayList();
        ClassLoader classLoader = e.class.getClassLoader();
        h hVarQ = q(classLoader);
        if (hVarQ != null) {
            arrayList.add(hVarQ);
            return arrayList;
        }
        Iterator<h> it = o(classLoader).iterator();
        while (it.hasNext()) {
            z(arrayList, it);
        }
        return arrayList;
    }

    public static void j() {
        j jVar = f42876b;
        synchronized (jVar) {
            try {
                jVar.e().e();
                for (org.slf4j.helpers.h hVar : jVar.e().d()) {
                    hVar.D(m(hVar.getName()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static a k() {
        return n().a();
    }

    public static c l(Class<?> cls) {
        Class<?> clsA;
        c cVarM = m(cls.getName());
        if (f42878d && (clsA = l.a()) != null && r(cls, clsA)) {
            Reporter.i(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", cVarM.getName(), clsA.getName()));
            Reporter.i("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return cVarM;
    }

    public static c m(String str) {
        return k().a(str);
    }

    public static h n() {
        if (f42875a == 0) {
            synchronized (e.class) {
                try {
                    if (f42875a == 0) {
                        f42875a = 1;
                        s();
                    }
                } finally {
                }
            }
        }
        int i10 = f42875a;
        if (i10 == 1) {
            return f42876b;
        }
        if (i10 == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i10 == 3) {
            return f42879e;
        }
        if (i10 == 4) {
            return f42877c;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static ServiceLoader<h> o(final ClassLoader classLoader) {
        return System.getSecurityManager() == null ? ServiceLoader.load(h.class, classLoader) : (ServiceLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: vc.d
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return ServiceLoader.load(h.class, classLoader);
            }
        });
    }

    public static boolean p(List<h> list) {
        return list.size() > 1;
    }

    public static h q(ClassLoader classLoader) {
        String property = System.getProperty("slf4j.provider");
        if (property != null && !property.isEmpty()) {
            try {
                Reporter.f(String.format("Attempting to load provider \"%s\" specified via \"%s\" system property", property, "slf4j.provider"));
                return (h) classLoader.loadClass(property).getConstructor(null).newInstance(null);
            } catch (ClassCastException e10) {
                Reporter.c(String.format("Specified SLF4JServiceProvider (%s) does not implement SLF4JServiceProvider interface", property), e10);
                return null;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e11) {
                Reporter.c(String.format("Failed to instantiate the specified SLF4JServiceProvider (%s)", property), e11);
            }
        }
        return null;
    }

    public static boolean r(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    public static final void s() {
        b();
        if (f42875a == 3) {
            A();
        }
    }

    public static void t() {
        j();
        u();
        f42876b.e().b();
    }

    public static void u() {
        LinkedBlockingQueue<wc.d> linkedBlockingQueueC = f42876b.e().c();
        int size = linkedBlockingQueueC.size();
        ArrayList<wc.d> arrayList = new ArrayList(128);
        int i10 = 0;
        while (linkedBlockingQueueC.drainTo(arrayList, 128) != 0) {
            for (wc.d dVar : arrayList) {
                v(dVar);
                int i11 = i10 + 1;
                if (i10 == 0) {
                    d(dVar, size);
                }
                i10 = i11;
            }
            arrayList.clear();
        }
    }

    public static void v(wc.d dVar) {
        if (dVar == null) {
            return;
        }
        org.slf4j.helpers.h hVarF = dVar.f();
        String name = hVarF.getName();
        if (hVarF.B()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (hVarF.A()) {
            return;
        }
        if (!hVarF.r()) {
            Reporter.i(name);
        } else if (hVarF.f(dVar.getLevel())) {
            hVarF.C(dVar);
        }
    }

    public static void w(List<h> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("No providers were found which is impossible after successful initialization.");
        }
        if (p(list)) {
            Reporter.f("Actual provider is of type [" + list.get(0) + "]");
            return;
        }
        Reporter.a("Connected with provider of type [" + list.get(0).getClass().getName() + "]");
    }

    public static void x(Set<URL> set) {
        if (set.isEmpty()) {
            return;
        }
        Reporter.i("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator<URL> it = set.iterator();
        while (it.hasNext()) {
            Reporter.i("Ignoring binding found at [" + it.next() + "]");
        }
        Reporter.i("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    public static void y(List<h> list) {
        if (p(list)) {
            Reporter.i("Class path contains multiple SLF4J providers.");
            Iterator<h> it = list.iterator();
            while (it.hasNext()) {
                Reporter.i("Found provider [" + it.next() + "]");
            }
            Reporter.i("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    public static void z(List<h> list, Iterator<h> it) {
        try {
            list.add(it.next());
        } catch (ServiceConfigurationError e10) {
            Reporter.b("A service provider failed to instantiate:\n" + e10.getMessage());
        }
    }
}
