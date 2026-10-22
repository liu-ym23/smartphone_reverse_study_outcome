package com.bytedance.android.bcm.impl;

import com.bytedance.android.bcm.api.BcmHostDependManager;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl.model.ParamType;
import com.bytedance.android.bcm.impl.model.ValueType;
import com.bytedance.android.bcm.impl.model.f;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kc.d;
import kc.e;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "old checker class", replaceWith = @ReplaceWith(expression = "BcmParamsChecker", imports = {"com.bytedance.android.bcm.impl.paramcheck"}))
public final class BcmParamsCheckerOld {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f41780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f41781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f41782c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.android.bcm.impl.model.a f41783d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, b> f41784e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap<String, b> f41785f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap<String, b> f41786g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f41787h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f41788i = null;

    /* JADX INFO: loaded from: classes43.dex */
    public static final class a implements ic.b {
        public a() {
        }
    }

    public BcmParamsCheckerOld() {
    }

    public static ReentrantLock f() {
        return (ReentrantLock) f41782c.getValue();
    }

    static {
        f41782c = LazyKt.lazy(BcmParamsCheckerOld$l$2.INSTANCE);
        f41783d = new com.bytedance.android.bcm.impl.model.a();
        f41784e = new HashMap();
        f41785f = new HashMap();
        f41786g = new HashMap();
        f41787h = LazyKt.lazy(BcmParamsCheckerOld$bq$2.INSTANCE);
        f41788i = LazyKt.lazy(BcmParamsCheckerOld$extraCheckerList$2.INSTANCE);
    }

    public static void g() {
        if (f41780a == false) goto L5;
        return;
    L5:
        BtmSetting r100 = BtmSetting.f42469d;
        if (r100.c().c().v() == true) goto L8;
        return;
    L8:
        f().lock();
    L25:
        th = move-exception;
        com.bytedance.android.bcm.impl.monitor.b.b(4003, "init BcmParamsChecker failed", null, null, th, null, 188);     // Catch: Throwable -> L29
    L21:
        f().unlock();
        return;
    L29:
        th = move-exception;
        f().unlock();
        throw th;
    L10:
        if (f41780a == true) goto L21;
        f41780a = true;     // Catch: Throwable -> L25
        if (r100.c().c().g().b() != 1) goto L15;
    L18:
        BcmHostDependManager r101 = BcmHostDependManager.f41760e;     // Catch: Throwable -> L25
        r101.getClass();     // Catch: Throwable -> L25
        ic.a r102 = (ic.a) BcmHostDependManager.f41757b.getValue(r101, BcmHostDependManager.f41756a[0]);     // Catch: Throwable -> L25
    L19:
        if (r102 != null) goto L23;
        f41781b = true;     // Catch: Throwable -> L25
        goto L21
    L23:
        r102.a(new a());     // Catch: Throwable -> L25
        goto L21
    L15:
        if (BtmHostDependManager.F.c() == false) goto L18;
        BcmHostDependManager.f41760e.getClass();     // Catch: Throwable -> L25
        r102 = null;
        goto L19
    }

    public static final void a(e r100) {
        if (r100 == null) goto L19;
        String r101 = r100.f502369b;     // Catch: Exception -> L14
        if (r101 != null) goto L6;
        com.bytedance.android.bcm.impl.monitor.b.b(4001, "pageBtm is null", null, null, null, null, 252);     // Catch: Exception -> L14
        return;
    L6:
        c(r101, r100);     // Catch: Exception -> L14
        Lazy r102 = BtmFormatUtils.f42489a;     // Catch: Exception -> L14
        String r103 = BtmFormatUtils.g(r100.f502368a);     // Catch: Exception -> L14
        if (r103 != null) goto L9;
        com.bytedance.android.bcm.impl.monitor.b.b(4002, "btmId is null", null, null, null, null, 252);     // Catch: Exception -> L14
        return;
    L9:
        d(r101, r103, r100);     // Catch: Exception -> L14
        Iterator r104 = ((ArrayList) f41788i.getValue()).iterator();     // Catch: Exception -> L14
    L11:
        if (r104.hasNext() == false) goto L22;
        ((d) r104.next()).a(r101, r103, r100);     // Catch: Exception -> L14
        goto L11
    L22:
        return;
    L14:
        e = move-exception;
        com.bytedance.android.bcm.impl.monitor.b.b(4003, "innerCheck exception", null, null, e, null, 188);
        return;
    }

    public static String h(String r110) {
        if (StringsKt.contains$default(r110, "_i", false, 2, null) == false) goto L8;
        List r100 = StringsKt.split$default(r110, new String[]{"_i"}, false, 0, 6, null);
        if (StringsKt.contains$default((CharSequence) ListProtector.get(r100, 0), ".d", false, 2, null) == true) goto L7;
        return r110;
    L7:
        return (String) ListProtector.get(r100, 0);
    L8:
        return r110;
    }

    public static boolean b(f r100, Map r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        BcmParams r102 = (BcmParams) r101.get(r100.b());
        if (r102 == null) goto L33;
        Object r103 = r102.opt(r100.a());
        if (r103 == null) goto L33;
        if ((r103 instanceof String) == false) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L20;
        if (r100.g() != ValueType.STRING) goto L20;
    L25:
        if (r100.d() != ParamType.ENUM) goto L32;
        List<Object> r105 = r100.c();
        if (r105 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        if (r105.contains(r103) == true) goto L32;
        return false;
    L32:
        return true;
    L20:
        if ((r103 instanceof Integer) == false) goto L33;
        if (r100.g() == ValueType.INT) goto L25;
    L12:
        if ((r103 instanceof JSONObject) == true) goto L15;
        r104 = false;
    L33:
        return false;
    }

    public static void c(String r100, e r101) {
        Map<String, BcmParams> r102 = r101.f502370c;
        b r103 = f41784e.get(r100);
        if (r103 == null) goto L10;
        List<f> r104 = r103.f41798a;
        if (r104 == null) goto L12;
        Iterator r105 = ((ArrayList) r104).iterator();
    L8:
        if (r105.hasNext() == false) goto L13;
        b((f) r105.next(), r102);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public static void d(String r100, String r101, e r102) {
        Map<String, BcmParams> r103 = r102.f502371d;
        b r104 = f41785f.get(h(r101));
        if (r104 == null) goto L10;
        List<f> r105 = r104.f41798a;
        if (r105 == null) goto L10;
        Iterator r106 = ((ArrayList) r105).iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        b((f) r106.next(), r103);
    L10:
        HashMap<String, b> r107 = f41786g;
        List r108 = StringsKt.split$default(r101, new String[]{"."}, false, 0, 6, null);
        if (r108.size() < 3) goto L14;
        r101 = ((String) ListProtector.get(r108, 0)) + "." + ((String) ListProtector.get(r108, 1)) + "." + ((String) ListProtector.get(r108, 2));
    L14:
        b r109 = r107.get(r101);
        if (r109 == null) goto L22;
        List<f> r110 = r109.f41798a;
        if (r110 == null) goto L22;
        Iterator r111 = ((ArrayList) r110).iterator();
    L20:
        if (r111.hasNext() == false) goto L22;
        b((f) r111.next(), r103);
    L22:
        int r112 = com.bytedance.android.bcm.impl.monitor.d.f41840a;
    }

    public static List e(String r100, String r101, HashMap r102) {
        b r103 = (b) r102.get(r100);
        if (r103 != null) goto L6;
        r103 = new b();
    L6:
        Iterator r104 = ((ArrayList) r103.f41798a).iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        f r105 = (f) r104.next();
        if (Intrinsics.areEqual(r101, r105.a()) == false) goto L8;
        return r105.c();
    L13:
        return null;
    }
}
