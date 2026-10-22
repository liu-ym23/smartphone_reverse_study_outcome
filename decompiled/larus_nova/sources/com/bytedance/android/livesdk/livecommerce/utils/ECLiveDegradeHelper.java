package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes10.dex */
public final class ECLiveDegradeHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f153040a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f153041b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ECLiveDegradeHelper f153042c = null;

    public ECLiveDegradeHelper() {
    }

    public static ECLiveDegradeConfig b() {
        return (ECLiveDegradeConfig) f153041b.getValue();
    }

    static {
        f153042c = new ECLiveDegradeHelper();
        f153040a = LazyKt.lazy(ECLiveDegradeHelper$enableDynamicDegrade$2.INSTANCE);
        f153041b = LazyKt.lazy(ECLiveDegradeHelper$degradeConfig$2.INSTANCE);
    }

    public static int c() {
        return a("shopping_card_animation_degrade", b().getEnableShoppingCardAnimationDegrade());
    }

    public static int a(String r100, Integer r110) {
        String r101 = "live_ecom_dynamic_".concat(r100);
        int r102 = 0;
        if (((Boolean) f153040a.getValue()).booleanValue() == true) goto L26;
        dm.a.a("LiveDegrade").a("get degrade config of [" + r100 + "]: dynamic degrade is forbidden, return null.");
        Integer r103 = null;
    L13:
        if (r103 != null) goto L28;
        hh2.g r104 = hh2.f.f485165a.f485167a;
        if (r104 == null) goto L20;
        Boolean r105 = r104.d();
        if (r105 == null) goto L20;
        boolean r106 = r105.booleanValue();
    L21:
        if (r106 == false) goto L24;
        if (r110 == null) goto L24;
        r102 = r110.intValue();
    L24:
        dm.a.a("LiveDegrade").a("get degrade config of [" + r100 + "]: " + r102 + " by static.");
        return r102;
    L20:
        r106 = true;
        goto L21
    L28:
        return r103.intValue();
    L26:
        int r107 = ECSdk.f48106a;     // Catch: Exception -> L9
        IAdapterService r108 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Exception -> L9
        if (r108 == null) goto L7;
        r108.getStrategyService();     // Catch: Exception -> L9
    L7:
        Integer r109 = 0;     // Catch: Exception -> L9
        int r111 = r109.intValue();     // Catch: Exception -> L9
    L11:
        dm.a.a("LiveDegrade").a("get degrade config of [" + r100 + "]: " + r111 + " by dynamic. (dynamic_key: " + r101 + ')');
        r103 = Integer.valueOf(r111);
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r111 = 0;
        goto L11
    }
}
