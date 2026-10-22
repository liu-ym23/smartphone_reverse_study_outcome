package com.bytedance.android.bcm.impl.config;

import com.bytedance.android.bcm.api.BcmHostDependManager;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.tool.BtmDebugTool;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.SharedPreferenceUtil;
import com.google.gson.Gson;
import ic.b;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class BcmConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.android.bcm.impl.config.a f41809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f41810b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f41811c = null;

    public static final class a implements b {
        public a() {
        }
    }

    static {
        f41809a = new com.bytedance.android.bcm.impl.config.a();
        f41810b = new AtomicInteger(0);
        f41811c = LazyKt.lazy(BcmConfig$cache$2.INSTANCE);
    }

    public static void a() {
        if (f41810b.get() != 0) goto L6;
        b();
        return;
    }

    public static void b() {
        AtomicInteger r100 = f41810b;
        if (r100.compareAndSet(0, 1) == false) goto L39;
        ALogger r101 = ALogger.f41996d;
        r101.a("BcmConfig", false, BcmConfig$fetchBcmConfig$1.INSTANCE);
        BtmSetting.f42469d.getClass();     // Catch: Throwable -> L31
        Gson r102 = BtmSetting.b();     // Catch: Throwable -> L31
        SharedPreferenceUtil r103 = (SharedPreferenceUtil) f41811c.getValue();     // Catch: Throwable -> L31
        Object r104 = null;
        if (r103 == null) goto L8;
        String r105 = r103.c("BcmConfig", "");     // Catch: Throwable -> L31
    L9:
        com.bytedance.android.bcm.impl.config.a r106 = (com.bytedance.android.bcm.impl.config.a) r102.fromJson(r105, com.bytedance.android.bcm.impl.config.a.class);     // Catch: Throwable -> L31
        if (r106 != null) goto L26;
        r106 = new com.bytedance.android.bcm.impl.config.a();     // Catch: Throwable -> L31
        BcmHostDependManager r107 = BcmHostDependManager.f41760e;     // Catch: Throwable -> L31
        r107.getClass();     // Catch: Throwable -> L31
        ic.a r108 = (ic.a) BcmHostDependManager.f41758c.getValue(r107, BcmHostDependManager.f41756a[1]);     // Catch: Throwable -> L31
        if (r108 == null) goto L17;
        JSONObject r109 = r108.getDefault();     // Catch: Throwable -> L31
        if (r109 == null) goto L17;
        Object r110 = r109.opt("bcm_in_chain");     // Catch: Throwable -> L31
    L19:
        if ((r110 instanceof List) == false) goto L22;
        r104 = r110;
    L22:
        List<String> r111 = (List) r104;     // Catch: Throwable -> L31
        if (r111 == null) goto L25;
        r106.e(r111);     // Catch: Throwable -> L31
    L25:
        r101.a("BcmConfig", false, BcmConfig$loadDefaultConfig$2.INSTANCE);     // Catch: Throwable -> L31
    L17:
        r110 = null;
    L26:
        f41809a = r106;     // Catch: Throwable -> L31
        Lazy r112 = BtmDebugTool.f42072a;     // Catch: Throwable -> L31
        if (BtmHostDependManager.F.c() == false) goto L29;
        BtmDebugTool.b().e();     // Catch: Throwable -> L31
    L29:
        r101.a("BcmConfig", false, BcmConfig$loadFromCache$1.INSTANCE);     // Catch: Throwable -> L31
        r100.set(2);     // Catch: Throwable -> L31
    L33:
        BcmHostDependManager r113 = BcmHostDependManager.f41760e;
        r113.getClass();
        ic.a r114 = (ic.a) BcmHostDependManager.f41758c.getValue(r113, BcmHostDependManager.f41756a[1]);
        if (r114 == null) goto L40;
        r114.a(new a());
        return;
    L40:
        return;
    L8:
        r105 = null;
    L31:
        th = move-exception;
        ALogger.f41996d.a("BcmConfig", false, new BcmConfig$loadFromCache$2(th));
        goto L33
    }
}
