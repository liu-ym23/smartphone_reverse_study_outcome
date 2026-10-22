package com.bytedance.android.annie.lynx.service.latch;

import com.bytedance.android.latch.LatchOptions;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class LatchMonitorImpl implements LatchOptions.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LatchMonitorImpl f39532a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f39533b = null;

    public LatchMonitorImpl() {
    }

    static {
        f39532a = new LatchMonitorImpl();
        f39533b = LazyKt.lazy(LatchMonitorImpl$monitor$2.INSTANCE);
    }

    @Override // com.bytedance.android.latch.LatchOptions.a
    public final void a(String r110, int r111, long r210) {
        Intrinsics.checkNotNullParameter(r110, "pageUrl");
        String r112 = "88888";
        if (r111 >= 4) goto L14;
        j9.b r100 = (j9.b) f39533b.getValue();
        JSONObject r101 = new JSONObject();
        r101.put("stage", r111);
        Unit r102 = Unit.INSTANCE;
        JSONObject r103 = new JSONObject();
        r103.put("duration", r210);
        JSONObject r113 = new JSONObject();
        com.bytedance.android.annie.ng.a r104 = com.bytedance.android.annie.ng.g.f39671c.get("host");
        if (r104 == null) goto L12;
        o8.f r105 = r104.f39644b;
        if (r105 == null) goto L12;
        String r106 = r105.f522331a;
        if (r106 == null) goto L12;
        r112 = r106;
    L12:
        r113.put("virtual_aid", r112);
        j9.b.a.a(r100, null, "latch_ng_duration", r110, r101, r103, null, r113, 0, 256);
        return;
    L14:
        if (r111 != 5) goto L33;
        Lazy r107 = f39533b;
        j9.b r108 = (j9.b) r107.getValue();
        JSONObject r109 = new JSONObject();
        r109.put("optimize_type", 1);
        Unit r114 = Unit.INSTANCE;
        JSONObject r115 = new JSONObject();
        r115.put("duration", r210);
        JSONObject r116 = new JSONObject();
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r117 = com.bytedance.android.annie.ng.g.f39671c;
        com.bytedance.android.annie.ng.a r118 = r117.get("host");
        if (r118 == null) goto L21;
        o8.f r119 = r118.f39644b;
        if (r119 == null) goto L21;
        String r120 = r119.f522331a;
        if (r120 == null) goto L21;
    L22:
        r116.put("virtual_aid", r120);
        j9.b.a.a(r108, null, "latch_ng_callback", r110, r109, r115, null, r116, 0, 256);
        j9.b r121 = (j9.b) r107.getValue();
        JSONObject r122 = new JSONObject();
        JSONObject r123 = new JSONObject();
        JSONObject r124 = new JSONObject();
        com.bytedance.android.annie.ng.a r125 = r117.get("host");
        if (r125 == null) goto L30;
        o8.f r126 = r125.f39644b;
        if (r126 == null) goto L30;
        String r127 = r126.f522331a;
        if (r127 == null) goto L30;
        r112 = r127;
    L30:
        r124.put("virtual_aid", r112);
        j9.b.a.a(r121, null, "latch_ng_success", r110, r122, r123, null, r124, 0, 256);
        return;
    L21:
        r120 = "88888";
        goto L22
    }

    @Override // com.bytedance.android.latch.LatchOptions.a
    public final void b(String r110, int r111, String r112, Map<String, ? extends Object> r113) {
        Intrinsics.checkNotNullParameter(r110, "pageUrl");
        Intrinsics.checkNotNullParameter(r112, "message");
        Intrinsics.checkNotNullParameter(r113, "extra");
        j9.b r100 = (j9.b) f39533b.getValue();
        JSONObject r101 = new JSONObject();
        r101.put("stage", r111);
        Unit r102 = Unit.INSTANCE;
        JSONObject r114 = new JSONObject();
        r114.put("message", r112);
        r114.put("extra", new JSONObject(r113));
        JSONObject r103 = new JSONObject();
        com.bytedance.android.annie.ng.a r104 = com.bytedance.android.annie.ng.g.f39671c.get("host");
        if (r104 == null) goto L8;
        o8.f r105 = r104.f39644b;
        if (r105 == null) goto L8;
        String r106 = r105.f522331a;
        if (r106 == null) goto L8;
    L9:
        r103.put("virtual_aid", r106);
        j9.b.a.a(r100, null, "latch_ng_error", r110, r101, null, r114, r103, 0, 256);
        return;
    L8:
        r106 = "88888";
        goto L9
    }
}
