package ud;

import com.stepos.core.common.util.TraceIdKeys;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.helpers.NOPLogger;
import org.slf4j.impl.StaticLoggerBinder;
import wd.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f13229a;

    /* renamed from: b, reason: collision with root package name */
    public static final wd.b f13230b = new wd.b();

    /* renamed from: c, reason: collision with root package name */
    public static final jd.b f13231c = new jd.b();

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f13232d;

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f13233e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f13234f;

    static {
        String property;
        try {
            property = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            property = null;
        }
        f13232d = property == null ? false : property.equalsIgnoreCase("true");
        f13233e = new String[]{"1.6", "1.7"};
        f13234f = "org/slf4j/impl/StaticLoggerBinder.class";
    }

    public static final void a() {
        LinkedHashSet linkedHashSetB;
        try {
            if (g()) {
                linkedHashSetB = null;
            } else {
                linkedHashSetB = b();
                j(linkedHashSetB);
            }
            StaticLoggerBinder.getSingleton();
            f13229a = 3;
            i(linkedHashSetB);
            c();
            h();
            wd.b bVar = f13230b;
            bVar.f13687b.clear();
            bVar.f13688c.clear();
        } catch (Exception e10) {
            f13229a = 2;
            System.err.println("Failed to instantiate SLF4J LoggerFactory");
            System.err.println("Reported exception:");
            e10.printStackTrace();
            throw new IllegalStateException("Unexpected initialization failure", e10);
        } catch (NoClassDefFoundError e11) {
            String message = e11.getMessage();
            if (message == null || !(message.contains("org/slf4j/impl/StaticLoggerBinder") || message.contains("org.slf4j.impl.StaticLoggerBinder"))) {
                f13229a = 2;
                System.err.println("Failed to instantiate SLF4J LoggerFactory");
                System.err.println("Reported exception:");
                e11.printStackTrace();
                throw e11;
            }
            f13229a = 4;
            c.a("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
            c.a("Defaulting to no-operation (NOP) logger implementation");
            c.a("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        } catch (NoSuchMethodError e12) {
            String message2 = e12.getMessage();
            if (message2 != null && message2.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f13229a = 2;
                c.a("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                c.a("Your binding is version 1.5.5 or earlier.");
                c.a("Upgrade your binding to version 1.6.x.");
            }
            throw e12;
        }
    }

    public static LinkedHashSet b() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = b.class.getClassLoader();
            String str = f13234f;
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(str) : classLoader.getResources(str);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
            return linkedHashSet;
        } catch (IOException e10) {
            System.err.println("Error getting resources from path");
            System.err.println("Reported exception:");
            e10.printStackTrace();
            return linkedHashSet;
        }
    }

    public static void c() {
        wd.b bVar = f13230b;
        synchronized (bVar) {
            try {
                bVar.f13686a = true;
                ArrayList arrayList = new ArrayList(bVar.f13687b.values());
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    wd.a aVar = (wd.a) obj;
                    aVar.f13681b = f(aVar.f13680a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ILoggerFactory d() {
        if (f13229a == 0) {
            synchronized (b.class) {
                try {
                    if (f13229a == 0) {
                        f13229a = 1;
                        a();
                        if (f13229a == 3) {
                            k();
                        }
                    }
                } finally {
                }
            }
        }
        int i10 = f13229a;
        if (i10 == 1) {
            return f13230b;
        }
        if (i10 == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i10 == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        if (i10 == 4) {
            return f13231c;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static a e(Class<?> cls) {
        int i10;
        a aVarF = f(cls.getName());
        if (f13232d) {
            c.a aVar = c.f13689a;
            Class<?> cls2 = null;
            if (aVar == null) {
                if (c.f13690b) {
                    aVar = null;
                } else {
                    try {
                        aVar = new c.a();
                    } catch (SecurityException unused) {
                        aVar = null;
                    }
                    c.f13689a = aVar;
                    c.f13690b = true;
                }
            }
            if (aVar != null) {
                Class<?>[] classContext = aVar.getClassContext();
                String name = c.class.getName();
                int i11 = 0;
                while (i11 < classContext.length && !name.equals(classContext[i11].getName())) {
                    i11++;
                }
                if (i11 >= classContext.length || (i10 = i11 + 2) >= classContext.length) {
                    throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
                }
                cls2 = classContext[i10];
            }
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                c.a("Detected logger name mismatch. Given name: \"" + aVarF.getName() + "\"; computed name: \"" + cls2.getName() + "\".");
                c.a("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return aVarF;
    }

    public static a f(String str) {
        return d().a(str);
    }

    public static boolean g() {
        String property;
        try {
            property = System.getProperty("java.vendor.url");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return false;
        }
        return property.toLowerCase().contains("android");
    }

    public static void h() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        LinkedBlockingQueue<vd.c> linkedBlockingQueue = f13230b.f13688c;
        int size = linkedBlockingQueue.size();
        ArrayList arrayList = new ArrayList(TraceIdKeys.MAX_LENGTH);
        int i10 = 0;
        while (linkedBlockingQueue.drainTo(arrayList, TraceIdKeys.MAX_LENGTH) != 0) {
            int size2 = arrayList.size();
            int i11 = 0;
            while (i11 < size2) {
                Object obj = arrayList.get(i11);
                i11++;
                vd.c cVar = (vd.c) obj;
                if (cVar != null) {
                    wd.a aVar = cVar.f13525a;
                    String str = aVar.f13680a;
                    if (aVar.f13681b == null) {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    }
                    if (!(aVar.f13681b instanceof NOPLogger)) {
                        if (!aVar.g()) {
                            c.a(str);
                        } else if (aVar.g()) {
                            try {
                                aVar.f13683d.invoke(aVar.f13681b, cVar);
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                            }
                        }
                    }
                }
                int i12 = i10 + 1;
                if (i10 == 0) {
                    if (cVar.f13525a.g()) {
                        c.a("A number (" + size + ") of logging calls during the initialization phase have been intercepted and are");
                        c.a("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        c.a("See also http://www.slf4j.org/codes.html#replay");
                    } else if (!(cVar.f13525a.f13681b instanceof NOPLogger)) {
                        c.a("The following set of substitute loggers may have been accessed");
                        c.a("during the initialization phase. Logging calls during this");
                        c.a("phase were not honored. However, subsequent logging calls to these");
                        c.a("loggers will work as normally expected.");
                        c.a("See also http://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i10 = i12;
            }
            arrayList.clear();
        }
    }

    public static void i(LinkedHashSet linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.size() <= 1) {
            return;
        }
        c.a("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
    }

    public static void j(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.size() > 1) {
            c.a("Class path contains multiple SLF4J bindings.");
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                c.a("Found binding in [" + ((URL) it.next()) + "]");
            }
            c.a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    public static final void k() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z = false;
            for (String str2 : f13233e) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            c.a("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f13233e).toString());
            c.a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            System.err.println("Unexpected problem occured during version sanity check");
            System.err.println("Reported exception:");
            th.printStackTrace();
        }
    }
}
