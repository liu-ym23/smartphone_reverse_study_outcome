package com.bytedance.android.anniex.base.service;

import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieXServiceCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnnieXServiceCenter f40313a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f40314b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f40315c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f40316d = null;

    public static final class a<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final I f40317a;

        public a(I r100) {
            this.f40317a = r100;
        }
    }

    public AnnieXServiceCenter() {
    }

    static {
        f40313a = new AnnieXServiceCenter();
        f40314b = LazyKt.lazy(AnnieXServiceCenter$bidServicesMap$2.INSTANCE);
        f40315c = LazyKt.lazy(AnnieXServiceCenter$serviceProviderMap$2.INSTANCE);
        f40316d = LazyKt.lazy(AnnieXServiceCenter$createServiceMethodMap$2.INSTANCE);
    }

    public static ConcurrentHashMap b() {
        return (ConcurrentHashMap) f40314b.getValue();
    }

    public static ConcurrentHashMap e() {
        return (ConcurrentHashMap) f40315c.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e c(String r100) {
        ConcurrentHashMap r101 = (ConcurrentHashMap) b().get("default_bid");
        if (r101 == null) goto L16;
        a r102 = (a) r101.get(r100);
        if (r102 != null) goto L7;
        f40313a.getClass();
        a r103 = (a) e().get("default_bid");
        if (r103 == null) goto L14;
        AnnieXServiceProvider r104 = (AnnieXServiceProvider) r103.f40317a;
        if (r104 == null) goto L14;
        e r105 = a(r100, r104);
        r101.put(r100, new a(r105));
        return r105;
    L14:
        HybridLogger.i("XInit", "miss AnnieXServiceProvider on default bid", null, 12);
        r101.put(r100, new a(null));
        return null;
    L7:
        return (e) r102.f40317a;
    L16:
        ha.a r106 = (ha.a) AnnieXRuntime.f40275a.getValue();
        if (r106 == null) goto L19;
        AnnieXServiceProvider r107 = r106.createServiceProvider("default_bid");
    L20:
        if (r107 == null) goto L23;
        e().put("default_bid", new a(r107));
        e r108 = a(r100, r107);
        ConcurrentHashMap r109 = b();
        ConcurrentHashMap r110 = new ConcurrentHashMap();
        r110.put(r100, new a(r108));
        r109.put("default_bid", r110);
        return r108;
    L23:
        HybridLogger.i("XInit", "miss AnnieXServiceProvider on default bid", null, 12);
        ConcurrentHashMap r111 = b();
        ConcurrentHashMap r112 = new ConcurrentHashMap();
        r112.put(r100, new a(null));
        r111.put("default_bid", r112);
        return null;
    L19:
        r107 = null;
        goto L20
    }

    public static e a(String r100, AnnieXServiceProvider r101) {
        Lazy r102 = f40316d;
        String r103 = (String) ((ConcurrentHashMap) r102.getValue()).get(r100);
        if (r103 != null) goto L13;
        r103 = "create".concat(r100);
        f40313a.getClass();
        ((ConcurrentHashMap) r102.getValue()).put(r100, r103);
    L13:
        Object r104 = r101.getClass().getMethod(r103, new Class[0]).invoke(r101, new Object[0]);     // Catch: Exception -> L10
        if ((r104 instanceof e) == false) goto L15;
        return (e) r104;
    L15:
        return null;
    L10:
        e = move-exception;
        HybridLogger r105 = HybridLogger.f246343a;
        HybridLogger.i("XInit", "createServiceByProvider failed: methodName=" + r103 + ", message=" + e.getMessage(), null, 12);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e d(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        String r102 = r101.getSimpleName();
        ConcurrentHashMap r103 = (ConcurrentHashMap) b().get(r100);
        if (r103 == null) goto L31;
        a r104 = (a) r103.get(r102);
        if (r104 == null) goto L15;
        I r105 = r104.f40317a;
        if (r105 != 0) goto L9;
        f40313a.getClass();
        e r106 = c(r102);
        if ((r106 instanceof e) == true) goto L14;
        return null;
    L14:
        return r106;
    L9:
        if ((r105 instanceof e) == true) goto L54;
        return null;
    L54:
        return (e) r105;
    L15:
        f40313a.getClass();
        a r107 = (a) e().get(r100);
        if (r107 == null) goto L26;
        AnnieXServiceProvider r108 = (AnnieXServiceProvider) r107.f40317a;
        if (r108 == null) goto L26;
        e r109 = a(r102, r108);
        r103.put(r102, new a(r109));
        if (r109 != null) goto L25;
        r109 = c(r102);
        if ((r109 instanceof e) == true) goto L25;
        return null;
    L25:
        return r109;
    L26:
        r103.put(r102, new a(null));
        e r110 = c(r102);
        if ((r110 instanceof e) == true) goto L29;
        return null;
    L29:
        return r110;
    L31:
        if (e().containsKey(r100) == false) goto L36;
        a r111 = (a) e().get(r100);
        if (r111 == null) goto L35;
        AnnieXServiceProvider r112 = (AnnieXServiceProvider) r111.f40317a;
    L41:
        if (r112 == null) goto L49;
        e r113 = a(r102, r112);
        ConcurrentHashMap r114 = b();
        ConcurrentHashMap r115 = new ConcurrentHashMap();
        r115.put(r102, new a(r113));
        r114.put(r100, r115);
        if (r113 != null) goto L58;
        e r116 = c(r102);
        if ((r116 instanceof e) == true) goto L48;
        return null;
    L48:
        return r116;
    L58:
        return r113;
    L49:
        ConcurrentHashMap r117 = b();
        ConcurrentHashMap r118 = new ConcurrentHashMap();
        r118.put(r102, new a(null));
        r117.put(r100, r118);
        e r119 = c(r102);
        if ((r119 instanceof e) == true) goto L52;
        return null;
    L52:
        return r119;
    L35:
        r112 = null;
        goto L41
    L36:
        ha.a r120 = (ha.a) AnnieXRuntime.f40275a.getValue();
        if (r120 == null) goto L39;
        r112 = r120.createServiceProvider(r100);
    L40:
        e().put(r100, new a(r112));
        goto L41
    L39:
        r112 = null;
        goto L40
    }
}
