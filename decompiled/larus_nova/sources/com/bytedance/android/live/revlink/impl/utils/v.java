package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class v extends y50.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f97676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f97677c;

    public v(com.bytedance.android.livesdk.revenue.service.room.c r100, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r101) {
        this.f97676b = r100;
        this.f97677c = r101;
    }

    public final void b(String r100, JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "extra");
        LiveTracingMonitorKt.EventModule r101 = LiveTracingMonitorKt.EventModule.PK;
        com.bytedance.android.live.revlink.impl.global.c r102 = this.f97677c;
        com.bytedance.android.live.revenuelink.f r103 = null;
        if (r102 == null) goto L5;
        LiveFullLinkPKMonitor r104 = r102.getLiveFullLinkPKMonitor();
    L6:
        if (r104 == null) goto L8;
        r104.d(r110);
    L8:
        com.bytedance.android.live.revlink.impl.global.c r105 = this.f97677c;
        if (r105 == null) goto L11;
        LinkCrossRoomDataHolder r106 = r105.getLinkCrossRoomDataHolder();
    L12:
        if (r106 == null) goto L14;
        Long r107 = Long.valueOf(r106.c());
    L15:
        y50.b.a.d(r110, "channel_id", String.valueOf(r107));
        com.bytedance.android.livesdk.revenue.service.room.c r108 = this.f97676b;
        if (r108 == null) goto L20;
        com.bytedance.android.livesdk.revenue.room.a r109 = r108.getRoomContext();
        if (r109 == null) goto L20;
        IRoomBase r111 = r109.getCommonRoom();
    L21:
        IRoom r112 = (IRoom) r111;
        if (r112 != null) goto L24;
    L26:
        boolean r113 = false;
    L27:
        if (r113 == false) goto L29;
        IRoom r114 = r112;
    L30:
        String r115 = "";
        if (r114 == null) goto L47;
        if (r112 != null) goto L34;
    L36:
        String r116 = "";
    L37:
        y50.b.a.d(r110, "room_id", r116);
        if (r112 != null) goto L40;
    L45:
        String r117 = "";
    L46:
        y50.b.a.d(r110, "anchor_id", r117);
        goto L47
    L40:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r112) != true) goto L45;
        IBaseUser r118 = r114.getOwnerKt();
        if (r118 == null) goto L45;
        r117 = r118.getIdString();
        if (r117 != null) goto L46;
    L34:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r112) != true) goto L36;
        r116 = r114.getIdStr();
    L47:
        com.bytedance.android.live.revlink.impl.global.c r119 = this.f97677c;
        if (r119 == null) goto L50;
        w31.c r120 = r119.getPkLinkUtils();
    L51:
        if (r120 == null) goto L63;
        IRoom r121 = r120.k();
        if (r121 == null) goto L63;
        y50.b.a.d(r110, "to_room_id", String.valueOf(IRoomKtKt.getId(r121)));
        if (r121.getOwnerKt() == null) goto L63;
        IBaseUser r122 = r121.getOwnerKt();
        if (r122 == null) goto L62;
        Intrinsics.checkNotNullParameter(r122, "$this$secUidExt");
        String r123 = r122.getCastSecUid();
        if (r123 == null) goto L62;
        r115 = r123;
    L62:
        y50.b.a.d(r110, "set_to_user_id", r115);
    L63:
        y50.b.a.d(r110, "business_api_name", r100);
        HashMap r124 = new HashMap();
        r124.put("android_event_key", "ttlive_link_business_api_call");
        r124.put("business_api_name", r100);
        com.bytedance.android.live.revlink.impl.global.c r125 = this.f97677c;
        if (r125 == null) goto L66;
        r103 = r125.getRevenueLinkTraceMonitor();
    L66:
        if (r103 == null) goto L69;
        com.bytedance.android.live.revenuelink.f.a.a(r103, "ttlive_link_business_api_call", r101, r124, r110);
        return;
    L69:
        return;
    L50:
        r120 = null;
        goto L51
    L29:
        r114 = null;
        goto L30
    L24:
        if (com.bytedance.android.live.revlink.impl.monitor.a.a(r112) != true) goto L26;
        r113 = true;
    L20:
        r111 = null;
        goto L21
    L14:
        r107 = null;
        goto L15
    L11:
        r106 = null;
        goto L12
    L5:
        r104 = null;
        goto L6
    }
}
