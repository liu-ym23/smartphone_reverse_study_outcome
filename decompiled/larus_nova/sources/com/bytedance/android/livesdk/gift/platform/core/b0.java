package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f130471a = null;

    public b0() {
    }

    static {
        f130471a = new b0();
    }

    public static void a(long r110, int r111) {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("status_code", 0);
        r100.put("status", 0);
        r100.put("source_type", Integer.valueOf(r111));
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put("duration", Long.valueOf(r110));
        LinkedHashMap r113 = new LinkedHashMap();
        yz0.g r114 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        String r101 = null;
        if (r114 == null) goto L5;
        IRoomBase r115 = r114.getRoom();
    L7:
        if ((r115 instanceof IRoom) == true) goto L9;
        r115 = null;
    L9:
        IRoom r116 = (IRoom) r115;
        String r102 = "";
        if (r116 == null) goto L15;
        r113.put("room_id", Long.valueOf(IRoomKtKt.getId(r116)));
        String r103 = IRoomKt_androidKt.getAnchorId(r116);
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        r113.put("anchor_id", r103);
    L15:
        i12.d r104 = i12.m.f487958e2.a();
        if (r104 == null) goto L18;
        com.bytedance.android.scope.m.f163449e.getClass();
        com.bytedance.android.scope.o r105 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r104).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class));
    L19:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r106 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r105;
        if (r106 == null) goto L27;
        IBaseUser r107 = r106.f128462a;
        if (r107 == null) goto L27;
        String r108 = r107.getIdString();
        if (r108 == null) goto L27;
        r101 = r108;
    L29:
        if (r101 == null) goto L32;
        r102 = r101;
    L32:
        r113.put("to_anchor_id", r102);
        String r109 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_asset_list_status");
        JSONObject r117 = new JSONObject();
        JSONObject r118 = new JSONObject();
        JSONObject r119 = new JSONObject();
        Intrinsics.checkNotNullParameter(r119, "extra");
        Intrinsics.checkNotNullParameter(r118, "metric");
        EventModule r120 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r120, "eventModule");
        String r121 = r120.getValue();
        Intrinsics.checkNotNullParameter(r117, "map");
        Intrinsics.checkNotNullParameter(r100, "value");
        Iterator r122 = r100.entrySet().iterator();
    L34:
        if (r122.hasNext() == false) goto L36;
        Map.Entry r123 = (Map.Entry) r122.next();
        r117.put((String) r123.getKey(), r123.getValue());
        goto L34
    L36:
        Intrinsics.checkNotNullParameter(r118, "map");
        Intrinsics.checkNotNullParameter(r112, "value");
        Iterator r124 = r112.entrySet().iterator();
    L38:
        if (r124.hasNext() == false) goto L40;
        Map.Entry r125 = (Map.Entry) r124.next();
        r118.put((String) r125.getKey(), r125.getValue());
        goto L38
    L40:
        Intrinsics.checkNotNullParameter(r119, "map");
        Intrinsics.checkNotNullParameter(r113, "value");
        Iterator r126 = r113.entrySet().iterator();
    L42:
        if (r126.hasNext() == false) goto L44;
        Map.Entry r127 = (Map.Entry) r126.next();
        r119.put((String) r127.getKey(), r127.getValue());
        goto L42
    L44:
        cy0.e.f465759a.getClass();
        cy0.j r128 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r129 = com.bytedance.android.scope.m.b(r128).b(n97.a.class);
        Intrinsics.checkNotNull(r129);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r129)).g(r109, r121, "bussiness_api_call", r117, r118, r119);
        return;
    L27:
        if (r116 == null) goto L29;
        r101 = IRoomKt_androidKt.getAnchorId(r116);
        goto L29
    L18:
        r105 = null;
        goto L19
    L5:
        r115 = null;
        goto L7
    }

    public static void c(b0 r100, String r101, JSONObject r102, int r110) {
        r100.getClass();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter(r104, "metric");
        EventModule r106 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r106, "eventModule");
        String r107 = r106.getValue();
        r104.put("status", String.valueOf(r110));
        Intrinsics.checkNotNullParameter(r105, "map");
        Iterator<String> r108 = r102.keys();
    L4:
        if (r108.hasNext() == false) goto L6;
        String r111 = r108.next();
        Object r109 = r102.get(r111);
        Intrinsics.checkNotNullParameter(r111, "key");
        Intrinsics.checkNotNullParameter(r109, "value");
        r105.put(r111, r109);
        goto L4
    L6:
        cy0.e.f465759a.getClass();
        cy0.j r112 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r113 = com.bytedance.android.scope.m.b(r112).b(n97.a.class);
        Intrinsics.checkNotNull(r113);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r113)).g(r101, r107, "bussiness_api_call", r103, r104, r105);
    }

    public final void d(long r100, long r101, int r102, Throwable r103) {
        JSONObject r104 = new JSONObject();
        j01.d.b(r104, "room_id", Long.valueOf(r101));
        j01.d.b(r104, ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r100));
        j01.d.b(r104, "action", Integer.valueOf(r102));
        if (r103 == null) goto L5;
        j01.d.b(r104, "error", String.valueOf(r103.getMessage()));
        c(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_gift_mostly_used_operate_status"), r104, 1);
        return;
    L5:
        c(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_mostly_used_operate_status"), r104, 0);
    }

    public final void e(int r100, long r101, Long r102, Throwable r103) {
        JSONObject r104 = new JSONObject();
        j01.d.b(r104, "room_id", Long.valueOf(r101));
        j01.d.b(r104, "sort_strategy", Integer.valueOf(r100));
        if (r102 == null) goto L6;
        r102.longValue();
        j01.d.b(r104, "new_sort_strategy", r102);
    L6:
        if (r103 == null) goto L8;
        j01.d.b(r104, "error", String.valueOf(r103.getMessage()));
        c(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_gift_mostly_used_pin_status"), r104, 1);
        return;
    L8:
        c(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_mostly_used_pin_status"), r104, 0);
    }

    public final void b(long r100, long r101, String r102, long r103, long r110, long r111) {
        JSONObject r104 = new JSONObject();
        j01.d.b(r104, ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r100));
        j01.d.b(r104, "asset_id", Long.valueOf(r101));
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        j01.d.b(r104, "log_id", r102);
        j01.d.b(r104, "receive_time_mills", Long.valueOf(r103));
        j01.d.b(r104, "expired_time_mills", Long.valueOf(r110));
        j01.d.b(r104, "total_spend_time", Long.valueOf(r111));
        j01.d.b(r104, "duration", 0);
        c(this, "ttlive_gift_message_expired_status", r104, 1);
        jy0.b.b("IGiftMessage", "sticker message expired extra:" + r104, null);
    }
}
