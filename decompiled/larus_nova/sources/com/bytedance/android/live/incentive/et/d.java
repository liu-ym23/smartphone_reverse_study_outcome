package com.bytedance.android.live.incentive.et;

import com.bytedance.android.live.incentive.exchange.e;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f69339a = null;

    public d() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f69339a = new d();
    }

    public static void a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "eventProperties");
        String r102 = (String) r101.get("_exchange_session_id");
        if (r102 != null) goto L5;
        return;
    L5:
        Map<String, WeakReference<e>> r103 = e.f69349a;
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        WeakReference r104 = (WeakReference) ((LinkedHashMap) e.f69349a).get(r102);
        if (r104 == null) goto L8;
        e r105 = (e) r104.get();
    L9:
        if (r105 != null) goto L11;
        return;
    L11:
        r101.remove("_exchange_session_id");
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("request_page", "diamond_not_enough");
        k r107 = (k) f.d(j.C0.a(), k.class);
        if (r107 == null) goto L14;
        Boolean r108 = Boolean.valueOf(r107.isAnchor());
    L15:
        if (r108 == null) goto L17;
        boolean r109 = r108.booleanValue();
    L18:
        if (r109 == false) goto L20;
        String r110 = "1";
    L21:
        r106.put(IPerformanceManager.Params.is_anchor, r110);
        int r111 = com.bytedance.android.live.incentive.balance.b.c.f69334a;
        throw null;
    L20:
        r110 = "0";
        goto L21
    L17:
        r109 = false;
        goto L18
    L14:
        r108 = null;
        goto L15
    L8:
        r105 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        a(r100, r101);
    }
}
