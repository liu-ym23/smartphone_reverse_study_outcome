package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class o {
    public static final String c() {
        yz0.k r100 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r100 == null) goto L5;
        IRoom r101 = r100.getRoom();
    L7:
        if (r101 == null) goto L13;
        IRoomCart r102 = r101.getRoomCart();
        if (r102 == null) goto L13;
        if (r102.getShowCartExt() != 1) goto L13;
        return "ecom";
    L13:
        if (r101 == null) goto L21;
        IMainRoom r103 = iy0.e.a(r101);
        if (r103 == null) goto L21;
        IRoomSpecificSceneTypeInfo r104 = r103.getSceneTypeInfo();
        if (r104 == null) goto L21;
        if (r104.isLife() != true) goto L21;
        return "life";
    L21:
        if (r101 != null) goto L23;
    L25:
        return "other";
    L23:
        if (r101.getLiveRoomMode() != 1) goto L25;
        return "game";
    L5:
        r101 = null;
        goto L7
    }

    public static final String b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "activityId");
        boolean r102 = true;
        if (r100.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L12;
        if (r101 != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        return "vou_money";
    L9:
        r104 = false;
    L12:
        Intrinsics.checkNotNullParameter(r100, "activityId");
        if (r100.length() <= 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L22;
        if (r101 != 1) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L22;
        return "vou_gift";
    L19:
        r106 = false;
    L22:
        if (r101 != 0) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == false) goto L27;
        return "money";
    L27:
        if (r101 == 1) goto L30;
        r102 = false;
    L30:
        if (r102 == false) goto L33;
        return PbRequest.SwitchType.GIFT;
    L33:
        return String.valueOf(r101);
    L24:
        r107 = false;
        goto L25
    L15:
        r105 = false;
        goto L16
    L5:
        r103 = false;
        goto L6
    }

    public static final String f(String r100, long r101) {
        if (r100 != null) goto L15;
    L13:
        return "";
    L15:
        k r102 = (k) new Gson().fromJson(r100, k.class);     // Catch: Exception -> L14
        if (r102 == null) goto L13;
        Map<String, String> r103 = r102.a();     // Catch: Exception -> L14
        if (r103 == null) goto L13;
        String r104 = r103.get(String.valueOf(r101));     // Catch: Exception -> L14
        if (r104 != null) goto L12;
        return "";
    L12:
        return r104;
    }

    public static final void a(Map<String, String> r100, n0 r101, boolean r102) {
        r100.put(IPerformanceManager.Params.room_type, c());
        r100.put("redpackage_id", r101.f88668d.toString());
        r100.put("redpackage_content", b(r101.f88681q, r101.getType()));
        Intrinsics.checkNotNullParameter(r101, "$this$redPacketType");
        if (r101.f88671g.a(com.bytedance.android.live.revenue.common.u0.f90999f) <= 0) goto L5;
        String r103 = "countdown_five";
    L6:
        r100.put("redpackage_type", r103);
        r100.put("biz_type_id", String.valueOf(r101.f88676l));
        r100.put("params_for_special", com.bytedance.android.ec.core.event.a.VALUE_PARAMS_FOR_SPECIAL);
        if (r102 == false) goto L9;
        String r104 = "1";
    L10:
        r100.put(IPerformanceManager.Params.is_anchor, r104);
        return;
    L9:
        r104 = "0";
        goto L10
    L5:
        r103 = "immediate";
        goto L6
    }

    public static final void e(n0 r100, boolean r101, RedPacketMissReason r102) {
        Intrinsics.checkNotNullParameter(r100, "currentPacket");
        Intrinsics.checkNotNullParameter(r102, "reason");
        r100.getType();
        Intrinsics.checkNotNullParameter(r100, "redPacket");
        Intrinsics.checkNotNullParameter(r102, "reason");
        Pair[] r103 = new Pair[3];
        if (r101 == false) goto L5;
        String r104 = "1";
    L6:
        r103[0] = TuplesKt.to(IPerformanceManager.Params.is_anchor, r104);
        r103[1] = TuplesKt.to("reason", r102.getReasonString());
        r103[2] = TuplesKt.to("redpackage_send_num", f(r100.f88683s, r100.f88676l));
        Map<? extends String, ? extends String> r105 = MapsKt.mutableMapOf(r103);
        a(r105, r100, r101);
        mz0.n r106 = new mz0.n();
        Map<String, String> r107 = r106.f516447a;
        Intrinsics.checkNotNullParameter(r107, "map");
        Intrinsics.checkNotNullParameter(r105, "map");
        r107.putAll(r105);
        mz0.m r108 = new mz0.m();
        r108.b(LogCommon.PAGE_SOURCE_LOG);
        r108.b(LogCommon.ROOM);
        List<Object> r109 = r106.f516448b;
        ArrayList r110 = (ArrayList) r109;
        r110.addAll(r108.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r111 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r112 = com.bytedance.android.scope.m.b(r111).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r112);
        ((mz0.i) ((f80.a) r112)).w3("livesdk_redpackage_grab_disappear", r106.f516447a, r106.f516448b);
        return;
    L5:
        r104 = "0";
        goto L6
    }

    public static final void d(String r100, String r101, String r102, String r103) {
        com.bytedance.android.livesdk.revenue.service.room.c r104 = (com.bytedance.android.livesdk.revenue.service.room.c) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class));
        if (r104 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r105 = r104.getRoomContext();
        if (r105 == null) goto L11;
        com.bytedance.live.datacontext.i<Boolean> r106 = r105.isAnchor();
        if (r106 == null) goto L11;
        Boolean r107 = r106.getValue();
        if (r107 == null) goto L11;
        boolean r108 = r107.booleanValue();
    L12:
        Map<? extends String, ? extends String> r109 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(IPerformanceManager.Params.is_anchor, String.valueOf(r108)), TuplesKt.to("is_success", "0"), TuplesKt.to("redpackage_prize_result", "nop"), TuplesKt.to("redpackage_type", "countdown_five")});
        r109.put("redpackage_id_list", r100);
        r109.put("redpackage_content_list", r101);
        r109.put("redpackage_cnt", r102);
        if (r103 == null) goto L15;
        r109.put("redpackage_send_num_list", r103);
    L15:
        mz0.n r110 = new mz0.n();
        Map<String, String> r111 = r110.f516447a;
        Intrinsics.checkNotNullParameter(r111, "map");
        Intrinsics.checkNotNullParameter(r109, "map");
        r111.putAll(r109);
        mz0.m r112 = new mz0.m();
        r112.b(LogCommon.PAGE_SOURCE_LOG);
        r112.b(LogCommon.ROOM);
        ((ArrayList) r110.f516448b).addAll(r112.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r113 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r114 = com.bytedance.android.scope.m.b(r113).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r114);
        ((mz0.i) ((f80.a) r114)).w3("livesdk_redpackage_result_toast_show", r110.f516447a, r110.f516448b);
        return;
    L11:
        r108 = false;
        goto L12
    }
}
