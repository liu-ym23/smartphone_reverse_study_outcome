package com.bytedance.android.shopping.orderlist.common.monitor.error;

import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f179894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> f179895b;

    public static final class a {
    }

    static {
    }

    public c(WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f179895b = r100;
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("type", "COMMON_LOG");
        Unit r102 = Unit.INSTANCE;
        this.f179894a = r101;
    }

    public final void a(Map r100) {
        Intrinsics.checkNotNullParameter("custom_event_fields_error", SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter("selfSaveTrigger", "errorEventName");
        Intrinsics.checkNotNullParameter(r100, "extraParams");
        this.f179894a.put(SocialConstants.PARAM_APP_DESC, "custom_event_fields_error");
        this.f179894a.put("error_event_name", "selfSaveTrigger");
        this.f179894a.putAll(r100);
        com.bytedance.android.shopping.orderlist.common.monitor.error.a r101 = this.f179895b.get();
        if (r101 == null) goto L6;
        r101.b("ies_ecommerce_fe_custom_log", this.f179894a);
        return;
    }

    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r101, "extraParams");
        this.f179894a.put(SocialConstants.PARAM_APP_DESC, r100);
        this.f179894a.putAll(r101);
        com.bytedance.android.shopping.orderlist.common.monitor.error.a r102 = this.f179895b.get();
        if (r102 == null) goto L6;
        r102.b("ies_ecommerce_fe_custom_log", this.f179894a);
        return;
    }
}
