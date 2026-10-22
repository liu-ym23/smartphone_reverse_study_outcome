package n3;

import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import h3.C0611u;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* renamed from: n3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0782c {

    /* renamed from: a, reason: collision with root package name */
    public static int f13664a;

    /* renamed from: b, reason: collision with root package name */
    public static final o3.b f13665b = new o3.b(1);

    /* renamed from: c, reason: collision with root package name */
    public static final C0611u f13666c = new C0611u(18);

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f13667d = {"1.6", "1.7"};

    /* renamed from: e, reason: collision with root package name */
    public static final String f13668e = "org/slf4j/impl/StaticLoggerBinder.class";

    public static LinkedHashSet a() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = AbstractC0782c.class.getClassLoader();
            String str = f13668e;
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(str) : classLoader.getResources(str);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e4) {
            com.stepos.statsrpk.c.K("Error getting resources from path", e4);
        }
        return linkedHashSet;
    }

    public static final void b() {
        o3.b bVar = f13665b;
        bVar.getClass();
        ArrayList arrayList = new ArrayList(bVar.f13805a.values());
        if (arrayList.isEmpty()) {
            return;
        }
        com.stepos.statsrpk.c.J("The following set of substitute loggers may have been accessed");
        com.stepos.statsrpk.c.J("during the initialization phase. Logging calls during this");
        com.stepos.statsrpk.c.J("phase were not honored. However, subsequent logging calls to these");
        com.stepos.statsrpk.c.J("loggers will work as normally expected.");
        com.stepos.statsrpk.c.J("See also http://www.slf4j.org/codes.html#substituteLogger");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            o3.f fVar = (o3.f) it.next();
            fVar.f13810b = e(fVar.f13809a);
            com.stepos.statsrpk.c.J(fVar.f13809a);
        }
        f13665b.f13805a.clear();
    }

    public static InterfaceC0780a c() {
        String[] strArr;
        if (f13664a == 0) {
            f13664a = 1;
            try {
                LinkedHashSet linkedHashSetA = a();
                g(linkedHashSetA);
                p3.a aVar = p3.a.f13931d;
                f13664a = 3;
                f(linkedHashSetA);
                b();
            } catch (Exception e4) {
                f13664a = 2;
                com.stepos.statsrpk.c.K("Failed to instantiate SLF4J LoggerFactory", e4);
                throw new IllegalStateException("Unexpected initialization failure", e4);
            } catch (NoClassDefFoundError e5) {
                String message = e5.getMessage();
                if (message == null || (message.indexOf("org/slf4j/impl/StaticLoggerBinder") == -1 && message.indexOf("org.slf4j.impl.StaticLoggerBinder") == -1)) {
                    f13664a = 2;
                    com.stepos.statsrpk.c.K("Failed to instantiate SLF4J LoggerFactory", e5);
                    throw e5;
                }
                f13664a = 4;
                com.stepos.statsrpk.c.J("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                com.stepos.statsrpk.c.J("Defaulting to no-operation (NOP) logger implementation");
                com.stepos.statsrpk.c.J("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
            } catch (NoSuchMethodError e6) {
                String message2 = e6.getMessage();
                if (message2 != null && message2.indexOf("org.slf4j.impl.StaticLoggerBinder.getSingleton()") != -1) {
                    f13664a = 2;
                    com.stepos.statsrpk.c.J("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                    com.stepos.statsrpk.c.J("Your binding is version 1.5.5 or earlier.");
                    com.stepos.statsrpk.c.J("Upgrade your binding to version 1.6.x.");
                }
                throw e6;
            }
            if (f13664a == 3) {
                try {
                    p3.a aVar2 = p3.a.f13931d;
                    int i4 = 0;
                    boolean z4 = false;
                    while (true) {
                        strArr = f13667d;
                        if (i4 >= strArr.length) {
                            break;
                        }
                        if ("1.6".startsWith(strArr[i4])) {
                            z4 = true;
                        }
                        i4++;
                    }
                    if (!z4) {
                        com.stepos.statsrpk.c.J("The requested version 1.6 by your slf4j binding is not compatible with " + Arrays.asList(strArr).toString());
                        com.stepos.statsrpk.c.J("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
                    }
                } catch (NoSuchFieldError unused) {
                } catch (Throwable th) {
                    com.stepos.statsrpk.c.K("Unexpected problem occured during version sanity check", th);
                }
            }
        }
        int i5 = f13664a;
        if (i5 == 1) {
            return f13665b;
        }
        if (i5 == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i5 != 3) {
            if (i5 == 4) {
                return f13666c;
            }
            throw new IllegalStateException("Unreachable code");
        }
        p3.a aVar3 = p3.a.f13931d;
        if (!aVar3.f13933a) {
            return aVar3.f13934b;
        }
        ContextSelectorStaticBinder contextSelectorStaticBinder = aVar3.f13935c;
        if (contextSelectorStaticBinder.getContextSelector() != null) {
            return contextSelectorStaticBinder.getContextSelector().getLoggerContext();
        }
        throw new IllegalStateException("contextSelector cannot be null. See also http://logback.qos.ch/codes.html#null_CS");
    }

    public static InterfaceC0781b d(Class cls) {
        return e(cls.getName());
    }

    public static InterfaceC0781b e(String str) {
        return c().getLogger(str);
    }

    public static void f(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.size() > 1) {
            com.stepos.statsrpk.c.J("Actual binding is of type [" + p3.a.f13931d.f13935c.getClass().getName() + "]");
        }
    }

    public static void g(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.size() > 1) {
            com.stepos.statsrpk.c.J("Class path contains multiple SLF4J bindings.");
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                com.stepos.statsrpk.c.J("Found binding in [" + ((URL) it.next()) + "]");
            }
            com.stepos.statsrpk.c.J("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
