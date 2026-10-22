package rd;

import io.modelcontextprotocol.spec.McpSchema;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import r2.i;
import td.e;
import td.f;
import td.g;
import td.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f10573a;

    /* renamed from: b, reason: collision with root package name */
    public static final td.c f10574b;

    /* renamed from: c, reason: collision with root package name */
    public static final td.c f10575c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f10576d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile td.c f10577e;

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f10578f;

    static {
        String property;
        td.c cVar = new td.c(1);
        f fVar = new f();
        fVar.f13304c = false;
        fVar.f13305f = new ConcurrentHashMap();
        fVar.f13306g = new LinkedBlockingQueue();
        VarHandle.storeStoreFence();
        cVar.f13295b = fVar;
        new ConcurrentHashMap();
        new ThreadLocal();
        new td.a();
        VarHandle.storeStoreFence();
        f10574b = cVar;
        td.c cVar2 = new td.c(0);
        cVar2.f13295b = new i(18);
        new ConcurrentHashMap();
        VarHandle.storeStoreFence();
        f10575c = cVar2;
        try {
            property = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            property = null;
        }
        f10576d = property != null ? property.equalsIgnoreCase("true") : false;
        f10578f = new String[]{McpSchema.JSONRPC_VERSION};
    }

    public static ArrayList a() {
        ServiceLoader serviceLoaderLoad;
        ArrayList arrayList = new ArrayList();
        ClassLoader classLoader = d.class.getClassLoader();
        String property = System.getProperty("slf4j.provider");
        td.c cVar = null;
        if (property != null && !property.isEmpty()) {
            try {
                String str = "Attempting to load provider \"" + property + "\" specified via \"slf4j.provider\" system property";
                int i = td.d.f13296a;
                if (s.f.c(2) >= s.f.c(td.d.f13297b)) {
                    td.d.b().println("SLF4J(I): ".concat(str));
                }
                cVar = (td.c) classLoader.loadClass(property).getConstructor(null).newInstance(null);
            } catch (ClassCastException e10) {
                td.d.a("Specified SLF4JServiceProvider (" + property + ") does not implement SLF4JServiceProvider interface", e10);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e11) {
                td.d.a("Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e11);
            }
        }
        if (cVar != null) {
            arrayList.add(cVar);
            return arrayList;
        }
        if (System.getSecurityManager() == null) {
            serviceLoaderLoad = ServiceLoader.load(td.c.class, classLoader);
        } else {
            c cVar2 = new c();
            cVar2.f10572a = classLoader;
            VarHandle.storeStoreFence();
            serviceLoaderLoad = (ServiceLoader) AccessController.doPrivileged(cVar2);
        }
        Iterator it = serviceLoaderLoad.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add((td.c) it.next());
            } catch (ServiceConfigurationError e12) {
                td.d.b().println("SLF4J(E): ".concat("A service provider failed to instantiate:\n" + e12.getMessage()));
            }
        }
        return arrayList;
    }

    public static b b(Class cls) {
        int i;
        b bVarC = c(cls.getName());
        if (f10576d) {
            g gVar = h.f13307a;
            Class cls2 = null;
            if (gVar == null) {
                if (h.f13308b) {
                    gVar = null;
                } else {
                    try {
                        gVar = new g();
                    } catch (SecurityException unused) {
                        gVar = null;
                    }
                    h.f13307a = gVar;
                    h.f13308b = true;
                }
            }
            if (gVar != null) {
                Class[] classContext = gVar.getClassContext();
                String name = h.class.getName();
                int i3 = 0;
                while (i3 < classContext.length && !name.equals(classContext[i3].getName())) {
                    i3++;
                }
                if (i3 >= classContext.length || (i = i3 + 2) >= classContext.length) {
                    od.f.e("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
                    return null;
                }
                cls2 = classContext[i];
            }
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                td.d.c("Detected logger name mismatch. Given name: \"" + bVarC.getName() + "\"; computed name: \"" + cls2.getName() + "\".");
                td.d.c("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return bVarC;
    }

    public static b c(String str) {
        td.c cVar;
        a aVar;
        if (f10573a == 0) {
            synchronized (d.class) {
                try {
                    if (f10573a == 0) {
                        f10573a = 1;
                        d();
                    }
                } finally {
                }
            }
        }
        int i = f10573a;
        if (i == 1) {
            cVar = f10574b;
        } else {
            if (i == 2) {
                od.f.e("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
                return null;
            }
            if (i == 3) {
                cVar = f10577e;
            } else {
                if (i != 4) {
                    od.f.e("Unreachable code");
                    return null;
                }
                cVar = f10575c;
            }
        }
        switch (cVar.f13294a) {
            case 0:
                aVar = (i) cVar.f13295b;
                break;
            default:
                aVar = (f) cVar.f13295b;
                break;
        }
        return aVar.a(str);
    }

    public static final void d() {
        try {
            ArrayList arrayListA = a();
            h(arrayListA);
            if (arrayListA.isEmpty()) {
                f10573a = 4;
                td.d.c("No SLF4J providers were found.");
                td.d.c("Defaulting to no-operation (NOP) logger implementation");
                td.d.c("See https://www.slf4j.org/codes.html#noProviders for further details.");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                try {
                    ClassLoader classLoader = d.class.getClassLoader();
                    Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class") : classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
                    while (systemResources.hasMoreElements()) {
                        linkedHashSet.add(systemResources.nextElement());
                    }
                } catch (IOException e10) {
                    td.d.a("Error getting resources from path", e10);
                }
                g(linkedHashSet);
            } else {
                f10577e = (td.c) arrayListA.get(0);
                f10577e.getClass();
                f10577e.getClass();
                f10573a = 3;
                f(arrayListA);
            }
            e();
            if (f10573a == 3) {
                try {
                    switch (f10577e.f13294a) {
                        case 0:
                            boolean z10 = false;
                            for (String str : f10578f) {
                                if ("2.0.99".startsWith(str)) {
                                    z10 = true;
                                }
                            }
                            if (z10) {
                                return;
                            }
                            td.d.c("The requested version 2.0.99 by your slf4j provider is not compatible with " + Arrays.asList(f10578f).toString());
                            td.d.c("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
                            return;
                        default:
                            throw new UnsupportedOperationException();
                    }
                } catch (Throwable th) {
                    td.d.a("Unexpected problem occurred during version sanity check", th);
                }
            }
        } catch (Exception e11) {
            f10573a = 2;
            td.d.a("Failed to instantiate SLF4J LoggerFactory", e11);
            throw new IllegalStateException("Unexpected initialization failure", e11);
        }
    }

    public static void e() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        td.c cVar = f10574b;
        synchronized (cVar) {
            try {
                ((f) cVar.f13295b).f13304c = true;
                f fVar = (f) cVar.f13295b;
                fVar.getClass();
                ArrayList arrayList = new ArrayList(fVar.f13305f.values());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    e eVar = (e) obj;
                    eVar.f13299f = c(eVar.f13298c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = ((f) f10574b.f13295b).f13306g;
        int size2 = linkedBlockingQueue.size();
        ArrayList arrayList2 = new ArrayList(128);
        int i3 = 0;
        while (linkedBlockingQueue.drainTo(arrayList2, 128) != 0) {
            int size3 = arrayList2.size();
            int i10 = 0;
            while (i10 < size3) {
                Object obj2 = arrayList2.get(i10);
                i10++;
                sd.b bVar = (sd.b) obj2;
                if (bVar != null) {
                    e eVar2 = bVar.f12196b;
                    String str = eVar2.f13298c;
                    if (eVar2.f13299f == null) {
                        od.f.e("Delegate logger cannot be null at this state.");
                        return;
                    } else if (!(eVar2.f13299f instanceof td.b)) {
                        if (!eVar2.j()) {
                            td.d.c(str);
                        } else if (eVar2.g(bVar.f12195a) && eVar2.j()) {
                            try {
                                eVar2.f13301h.invoke(eVar2.f13299f, bVar);
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                            }
                        }
                    }
                }
                int i11 = i3 + 1;
                if (i3 == 0) {
                    if (bVar.f12196b.j()) {
                        td.d.c("A number (" + size2 + ") of logging calls during the initialization phase have been intercepted and are");
                        td.d.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        td.d.c("See also https://www.slf4j.org/codes.html#replay");
                    } else if (!(bVar.f12196b.f13299f instanceof td.b)) {
                        td.d.c("The following set of substitute loggers may have been accessed");
                        td.d.c("during the initialization phase. Logging calls during this");
                        td.d.c("phase were not honored. However, subsequent logging calls to these");
                        td.d.c("loggers will work as normally expected.");
                        td.d.c("See also https://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i3 = i11;
            }
            arrayList2.clear();
        }
        f fVar2 = (f) f10574b.f13295b;
        fVar2.f13305f.clear();
        fVar2.f13306g.clear();
    }

    public static void f(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            od.f.e("No providers were found which is impossible after successful initialization.");
            return;
        }
        if (arrayList.size() > 1) {
            String str = "Actual provider is of type [" + arrayList.get(0) + "]";
            int i = td.d.f13296a;
            if (s.f.c(2) >= s.f.c(td.d.f13297b)) {
                td.d.b().println("SLF4J(I): ".concat(str));
                return;
            }
            return;
        }
        String str2 = "Connected with provider of type [" + ((td.c) arrayList.get(0)).getClass().getName() + "]";
        int i3 = td.d.f13296a;
        if (s.f.c(1) >= s.f.c(td.d.f13297b)) {
            td.d.b().println("SLF4J(D): ".concat(str2));
        }
    }

    public static void g(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.isEmpty()) {
            return;
        }
        td.d.c("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            td.d.c("Ignoring binding found at [" + ((URL) it.next()) + "]");
        }
        td.d.c("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    public static void h(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            td.d.c("Class path contains multiple SLF4J providers.");
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                td.d.c("Found provider [" + ((td.c) obj) + "]");
            }
            td.d.c("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
