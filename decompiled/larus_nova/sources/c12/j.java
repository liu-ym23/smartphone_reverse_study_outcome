package c12;

import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.revenue.host.RevHostPluginType;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdk.revenue.monitor.EventType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class j {
    public static boolean b() {
        return ((dr2.h) com.bytedance.android.live.revenue.core.util.e.a(dr2.h.class)).r8(RevHostPluginType.LivePcdnDouyin).b();
    }

    public static void a(String r110, boolean r111) {
        boolean r100 = d0.f130477a;
        Intrinsics.checkNotNullParameter(r110, "name");
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r102, "metric");
        EventModule r104 = EventModule.PCDN;
        Intrinsics.checkNotNullParameter(r104, "eventModule");
        String r105 = r104.getValue();
        EventType r106 = EventType.BUSSINESS_API_CALL;
        Intrinsics.checkNotNullParameter(r106, "eventType");
        String r107 = r106.getValue();
        Intrinsics.checkNotNullParameter(r101, "map");
        Intrinsics.checkNotNullParameter("name", "key");
        Intrinsics.checkNotNullParameter(r110, "value");
        r101.put("name", r110);
        Intrinsics.checkNotNullParameter(r102, "map");
        Boolean r112 = Boolean.valueOf(r111);
        Intrinsics.checkNotNullParameter("result", "key");
        Intrinsics.checkNotNullParameter(r112, "value");
        r102.put("result", r112);
        cy0.e.f465759a.getClass();
        cy0.j r113 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r114 = com.bytedance.android.scope.m.b(r113).b(n97.a.class);
        Intrinsics.checkNotNull(r114);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r114)).g("ttlive_pcdn_load", r105, r107, r101, r102, r103);
    }
}
