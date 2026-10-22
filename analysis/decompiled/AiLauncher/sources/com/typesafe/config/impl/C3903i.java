package com.typesafe.config.impl;

import b8.InterfaceC1455a;
import b8.InterfaceC1457c;
import com.autonavi.aps.amapapi.config.Const;
import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.ConfigString;
import com.typesafe.config.impl.O;
import java.io.File;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;

/* renamed from: com.typesafe.config.impl.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C3903i {

    /* renamed from: a, reason: collision with root package name */
    public static final b8.k f31863a;

    /* renamed from: b, reason: collision with root package name */
    public static final ConfigBoolean f31864b;

    /* renamed from: c, reason: collision with root package name */
    public static final ConfigBoolean f31865c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConfigNull f31866d;

    /* renamed from: e, reason: collision with root package name */
    public static final SimpleConfigList f31867e;

    /* renamed from: f, reason: collision with root package name */
    public static final SimpleConfigObject f31868f;

    /* renamed from: com.typesafe.config.impl.i$a */
    public static class a implements Callable<InterfaceC1455a> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClassLoader f31869a;

        public a(ClassLoader classLoader) {
            this.f31869a = classLoader;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC1455a call() {
            return C3903i.x().f(C3903i.D(this.f31869a)).b();
        }
    }

    /* renamed from: com.typesafe.config.impl.i$b */
    public static class b implements Callable<InterfaceC1455a> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClassLoader f31870a;

        public b(ClassLoader classLoader) {
            this.f31870a = classLoader;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC1455a call() {
            return C.p("reference.conf", b8.l.b().i(this.f31870a)).r().k();
        }
    }

    /* renamed from: com.typesafe.config.impl.i$c */
    public static class c implements O.a {
        @Override // com.typesafe.config.impl.O.a
        public b8.m a(String str, b8.l lVar) {
            return C.p(str, lVar);
        }
    }

    /* renamed from: com.typesafe.config.impl.i$d */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static String f31871a = "loads";

        /* renamed from: b, reason: collision with root package name */
        public static String f31872b = "substitutions";

        /* renamed from: c, reason: collision with root package name */
        public static final Map<String, Boolean> f31873c;

        /* renamed from: d, reason: collision with root package name */
        public static final boolean f31874d;

        /* renamed from: e, reason: collision with root package name */
        public static final boolean f31875e;

        static {
            Map<String, Boolean> mapA = a();
            f31873c = mapA;
            f31874d = mapA.get(f31871a).booleanValue();
            f31875e = mapA.get(f31872b).booleanValue();
        }

        public static Map<String, Boolean> a() {
            HashMap map = new HashMap();
            String str = f31871a;
            Boolean bool = Boolean.FALSE;
            map.put(str, bool);
            map.put(f31872b, bool);
            String property = System.getProperty("config.trace");
            if (property != null) {
                for (String str2 : property.split(Const.STR_MART_COMMA)) {
                    if (str2.equals(f31871a)) {
                        map.put(f31871a, Boolean.TRUE);
                    } else if (str2.equals(f31872b)) {
                        map.put(f31872b, Boolean.TRUE);
                    } else {
                        System.err.println("config.trace property contains unknown trace topic '" + str2 + "'");
                    }
                }
            }
            return map;
        }

        public static boolean b() {
            return f31874d;
        }

        public static boolean c() {
            return f31875e;
        }
    }

    /* renamed from: com.typesafe.config.impl.i$e */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static final InterfaceC1457c f31876a = new O(null);
    }

    /* renamed from: com.typesafe.config.impl.i$f */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public static volatile AbstractC3897c f31877a = C3903i.q();
    }

    /* renamed from: com.typesafe.config.impl.i$g */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public static volatile AbstractC3897c f31878a = C3903i.r();
    }

    /* renamed from: com.typesafe.config.impl.i$h */
    public static class h implements O.a {
        @Override // com.typesafe.config.impl.O.a
        public b8.m a(String str, b8.l lVar) {
            return C.l(new File(str), lVar);
        }
    }

    /* renamed from: com.typesafe.config.impl.i$i, reason: collision with other inner class name */
    public static class C0382i {

        /* renamed from: a, reason: collision with root package name */
        public InterfaceC1455a f31879a = null;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference<ClassLoader> f31880b = new WeakReference<>(null);

        /* renamed from: c, reason: collision with root package name */
        public Map<String, InterfaceC1455a> f31881c = new HashMap();

        public synchronized InterfaceC1455a a(ClassLoader classLoader, String str, Callable<InterfaceC1455a> callable) {
            InterfaceC1455a interfaceC1455aCall;
            try {
                if (classLoader != this.f31880b.get()) {
                    this.f31881c.clear();
                    this.f31880b = new WeakReference<>(classLoader);
                }
                InterfaceC1455a interfaceC1455aX = C3903i.x();
                if (interfaceC1455aX != this.f31879a) {
                    this.f31881c.clear();
                    this.f31879a = interfaceC1455aX;
                }
                interfaceC1455aCall = this.f31881c.get(str);
                if (interfaceC1455aCall == null) {
                    try {
                        try {
                            interfaceC1455aCall = callable.call();
                            if (interfaceC1455aCall == null) {
                                throw new ConfigException.BugOrBroken("null config from cache updater");
                            }
                            this.f31881c.put(str, interfaceC1455aCall);
                        } catch (Exception e10) {
                            throw new ConfigException.Generic(e10.getMessage(), e10);
                        }
                    } catch (RuntimeException e11) {
                        throw e11;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
            return interfaceC1455aCall;
        }
    }

    /* renamed from: com.typesafe.config.impl.i$j */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public static final C0382i f31882a = new C0382i();
    }

    /* renamed from: com.typesafe.config.impl.i$k */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public static volatile AbstractC3897c f31883a = C3903i.s();
    }

    static {
        M mR = M.r("hardcoded value");
        f31863a = mR;
        f31864b = new ConfigBoolean(mR, true);
        f31865c = new ConfigBoolean(mR, false);
        f31866d = new ConfigNull(mR);
        f31867e = new SimpleConfigList(mR, Collections.EMPTY_LIST);
        f31868f = SimpleConfigObject.K0(mR);
    }

    public static void A(String str) {
        System.err.println(str);
    }

    public static boolean B() {
        try {
            return d.b();
        } catch (ExceptionInInitializerError e10) {
            throw C3904j.c(e10);
        }
    }

    public static boolean C() {
        try {
            return d.c();
        } catch (ExceptionInInitializerError e10) {
            throw C3904j.c(e10);
        }
    }

    public static InterfaceC1455a D(ClassLoader classLoader) {
        return e(classLoader, "unresolvedReference", new b(classLoader));
    }

    public static InterfaceC1455a e(ClassLoader classLoader, String str, Callable<InterfaceC1455a> callable) {
        try {
            return j.f31882a.a(classLoader, str, callable);
        } catch (ExceptionInInitializerError e10) {
            throw C3904j.c(e10);
        }
    }

    public static InterfaceC1457c f() {
        try {
            return e.f31876a;
        } catch (ExceptionInInitializerError e10) {
            throw C3904j.c(e10);
        }
    }

    public static InterfaceC1455a g(ClassLoader classLoader) {
        return e(classLoader, "defaultReference", new a(classLoader));
    }

    public static InterfaceC1455a h(ClassLoader classLoader) {
        try {
            g(classLoader);
            return D(classLoader);
        } catch (ConfigException.UnresolvedSubstitution e10) {
            throw e10.c("Could not resolve substitution in reference.conf to a value: %s. All reference.conf files are required to be fully, independently resolvable, and should not require the presence of values for substitutions from further up the hierarchy.");
        }
    }

    public static SimpleConfigList i(b8.k kVar) {
        return (kVar == null || kVar == f31863a) ? f31867e : new SimpleConfigList(kVar, Collections.EMPTY_LIST);
    }

    public static AbstractC3897c j(b8.k kVar) {
        return kVar == f31863a ? f31868f : SimpleConfigObject.K0(kVar);
    }

    public static AbstractC3897c k() {
        try {
            return f.f31877a;
        } catch (ExceptionInInitializerError e10) {
            throw C3904j.c(e10);
        }
    }

    public static InterfaceC1455a l() {
        return m().k();
    }

    public static AbstractC3897c m() {
        try {
            return g.f31878a;
        } catch (ExceptionInInitializerError e10) {
            throw C3904j.c(e10);
        }
    }

    public static AbstractConfigValue n(Object obj, b8.k kVar, FromMapMode fromMapMode) {
        if (kVar == null) {
            throw new ConfigException.BugOrBroken("origin not supposed to be null");
        }
        if (obj == null) {
            return kVar != f31863a ? new ConfigNull(kVar) : f31866d;
        }
        if (obj instanceof AbstractConfigValue) {
            return (AbstractConfigValue) obj;
        }
        if (obj instanceof Boolean) {
            return kVar != f31863a ? new ConfigBoolean(kVar, ((Boolean) obj).booleanValue()) : ((Boolean) obj).booleanValue() ? f31864b : f31865c;
        }
        if (obj instanceof String) {
            return new ConfigString.Quoted(kVar, (String) obj);
        }
        if (obj instanceof Number) {
            return obj instanceof Double ? new ConfigDouble(kVar, ((Double) obj).doubleValue(), null) : obj instanceof Integer ? new ConfigInt(kVar, ((Integer) obj).intValue(), null) : obj instanceof Long ? new ConfigLong(kVar, ((Long) obj).longValue(), null) : ConfigNumber.u0(kVar, ((Number) obj).doubleValue(), null);
        }
        if (obj instanceof Duration) {
            return new ConfigLong(kVar, ((Duration) obj).toMillis(), null);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof Iterable)) {
                if (obj instanceof b8.h) {
                    return new ConfigLong(kVar, ((b8.h) obj).a(), null);
                }
                throw new ConfigException.BugOrBroken("bug in method caller: not valid to create ConfigValue from: " + obj);
            }
            Iterator it = ((Iterable) obj).iterator();
            if (!it.hasNext()) {
                return i(kVar);
            }
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                arrayList.add(n(it.next(), kVar, fromMapMode));
            }
            return new SimpleConfigList(kVar, arrayList);
        }
        Map map = (Map) obj;
        if (map.isEmpty()) {
            return j(kVar);
        }
        if (fromMapMode != FromMapMode.KEYS_ARE_KEYS) {
            return G.c(kVar, map);
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (!(key instanceof String)) {
                throw new ConfigException.BugOrBroken("bug in method caller: not valid to create ConfigObject from map with non-String key: " + key);
            }
            map2.put((String) key, n(entry.getValue(), kVar, fromMapMode));
        }
        return new SimpleConfigObject(kVar, map2);
    }

    public static Properties o() {
        Properties properties = System.getProperties();
        Properties properties2 = new Properties();
        synchronized (properties) {
            try {
                for (Map.Entry entry : properties.entrySet()) {
                    if (!entry.getKey().toString().startsWith("java.version.")) {
                        properties2.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return properties2;
    }

    public static ConfigException.NotResolved p(D d10, ConfigException.NotResolved notResolved) {
        String str = d10.k() + " has not been resolved, you need to call Config#resolve(), see API docs for Config#resolve()";
        return str.equals(notResolved.getMessage()) ? notResolved : new ConfigException.NotResolved(str, notResolved);
    }

    public static AbstractC3897c q() {
        return G.f(t("env variables"), System.getenv());
    }

    public static AbstractC3897c r() {
        HashMap map = new HashMap(System.getenv());
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            if (str.startsWith("CONFIG_FORCE_")) {
                map2.put(C3904j.a(str, "CONFIG_FORCE_"), map.get(str));
            }
        }
        return G.f(u("env variables overrides"), map2);
    }

    public static AbstractC3897c s() {
        return (AbstractC3897c) C.n(o(), b8.l.b().k("system properties")).r();
    }

    public static b8.k t(String str) {
        return M.n(str);
    }

    public static b8.k u(String str) {
        return str == null ? f31863a : M.r(str);
    }

    public static b8.j v(File file, b8.l lVar) {
        return O.g(new h(), file.getPath(), lVar);
    }

    public static b8.j w(String str, b8.l lVar) {
        return O.g(new c(), str, lVar);
    }

    public static InterfaceC1455a x() {
        return y().k();
    }

    public static AbstractC3897c y() {
        try {
            return k.f31883a;
        } catch (ExceptionInInitializerError e10) {
            throw C3904j.c(e10);
        }
    }

    public static void z(int i10, String str) {
        while (i10 > 0) {
            System.err.print("  ");
            i10--;
        }
        System.err.println(str);
    }
}
