package com.bytedance.android.annie.business.latch;

import com.bytedance.android.latch.LatchOptions;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieBusinessLatchMonitorImpl implements LatchOptions.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f39004a;

    public AnnieBusinessLatchMonitorImpl() {
        this.f39004a = LazyKt.lazy(AnnieBusinessLatchMonitorImpl$monitor$2.INSTANCE);
    }

    @Override // com.bytedance.android.latch.LatchOptions.a
    public final void a(String r110, int r111, long r210) {
        Intrinsics.checkNotNullParameter(r110, "pageUrl");
        HybridLogger r100 = HybridLogger.f246343a;
        HybridLogger.f("AnnieBusinessLatchService", "=======duration: " + r111 + "========", null, 12);
        if (r111 >= 4) goto L13;
        j9.b r101 = (j9.b) this.f39004a.getValue();
        JSONObject r102 = new JSONObject();
        r102.put("stage", r111);
        Unit r103 = Unit.INSTANCE;
        JSONObject r112 = new JSONObject();
        r112.put("duration", r210);
        JSONObject r113 = new JSONObject();
        com.bytedance.android.annie.ng.a r104 = com.bytedance.android.annie.ng.g.f39671c.get("host");
        if (r104 == null) goto L10;
        o8.f r105 = r104.f39644b;
        if (r105 == null) goto L10;
        String r106 = r105.f522331a;
        if (r106 == null) goto L10;
    L11:
        r113.put("virtual_aid", r106);
        j9.b.a.a(r101, null, "latch_ng_duration", r110, r102, r112, null, r113, 0, 256);
        return;
    L10:
        r106 = "88888";
        goto L11
    L13:
        if (r111 != 5) goto L31;
        j9.b r107 = (j9.b) this.f39004a.getValue();
        JSONObject r108 = new JSONObject();
        r108.put("optimize_type", 1);
        Unit r109 = Unit.INSTANCE;
        JSONObject r114 = new JSONObject();
        r114.put("duration", r210);
        JSONObject r115 = new JSONObject();
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r116 = com.bytedance.android.annie.ng.g.f39671c;
        com.bytedance.android.annie.ng.a r117 = r116.get("host");
        if (r117 == null) goto L20;
        o8.f r118 = r117.f39644b;
        if (r118 == null) goto L20;
        String r119 = r118.f522331a;
        if (r119 == null) goto L20;
    L21:
        r115.put("virtual_aid", r119);
        j9.b.a.a(r107, null, "latch_ng_callback", r110, r108, r114, null, r115, 0, 256);
        j9.b r120 = (j9.b) this.f39004a.getValue();
        JSONObject r121 = new JSONObject();
        JSONObject r122 = new JSONObject();
        JSONObject r123 = new JSONObject();
        com.bytedance.android.annie.ng.a r124 = r116.get("host");
        if (r124 == null) goto L27;
        o8.f r125 = r124.f39644b;
        if (r125 == null) goto L27;
        String r126 = r125.f522331a;
        if (r126 == null) goto L27;
    L28:
        r123.put("virtual_aid", r126);
        j9.b.a.a(r120, null, "latch_ng_success", r110, r121, r122, null, r123, 0, 256);
        return;
    L27:
        r126 = "88888";
    L20:
        r119 = "88888";
        goto L21
    }

    @Override // com.bytedance.android.latch.LatchOptions.a
    public final void b(String r110, int r111, String r112, Map<String, ? extends Object> r113) {
        Intrinsics.checkNotNullParameter(r110, "pageUrl");
        Intrinsics.checkNotNullParameter(r112, "message");
        Intrinsics.checkNotNullParameter(r113, "extra");
        HybridLogger r100 = HybridLogger.f246343a;
        HybridLogger.f("AnnieBusinessLatchService", "=======error==== pageUrl:" + r110 + ", message:" + r112, null, 12);
        j9.b r101 = (j9.b) this.f39004a.getValue();
        JSONObject r102 = new JSONObject();
        r102.put("stage", r111);
        Unit r103 = Unit.INSTANCE;
        JSONObject r114 = new JSONObject();
        r114.put("message", r112);
        r114.put("extra", new JSONObject(r113));
        JSONObject r115 = new JSONObject();
        com.bytedance.android.annie.ng.a r104 = com.bytedance.android.annie.ng.g.f39671c.get("host");
        if (r104 == null) goto L8;
        o8.f r105 = r104.f39644b;
        if (r105 == null) goto L8;
        String r106 = r105.f522331a;
        if (r106 == null) goto L8;
    L9:
        r115.put("virtual_aid", r106);
        j9.b.a.a(r101, null, "latch_ng_error", r110, r102, null, r114, r115, 0, 256);
        return;
    L8:
        r106 = "88888";
        goto L9
    }
}
