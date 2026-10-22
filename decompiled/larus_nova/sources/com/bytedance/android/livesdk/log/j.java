package com.bytedance.android.livesdk.log;

import android.os.SystemClock;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.q2;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.landscapeslide.LiveLandSlideContext;
import com.bytedance.android.livesdk.landscapeslide.PreRoomInfoContext;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.PreviewLandScapeUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f153352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f153353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f153354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f153355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f153356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f153357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f153358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f153359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f153360i;

    public final void d() {
        if (this.f153352a <= 0) goto L8;
        if (this.f153354c == false) goto L8;
        this.f153353b += SystemClock.elapsedRealtime() - this.f153352a;
        this.f153352a = 0;
    L8:
        if (this.f153356e > 0) goto L10;
        return;
    L10:
        if (this.f153354c == false) goto L14;
        this.f153355d += SystemClock.elapsedRealtime() - this.f153356e;
        this.f153356e = 0;
        return;
    }

    public final void f() {
        if (this.f153352a <= 0) goto L6;
        d();
    L6:
        if (this.f153353b > 0) goto L8;
        return;
    L8:
        if (this.f153360i == false) goto L21;
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.f153359h, 0, 2);
        if (r100 == null) goto L12;
        Room r101 = r100.getVsRoom();
    L14:
        if (q2.b(r101) == true) goto L17;
        this.f153352a = 0;
        this.f153353b = 0;
        return;
    L17:
        g r102 = u.l();
        HashMap r110 = new HashMap();
        r110.put("duration", String.valueOf(this.f153353b));
        r110.put(VrBgLogData.KEY_VR_TYPE, VrUtils.n());
        r110.put("is_vr_machine", VrUtils.o(this.f153359h));
        nm1.m r103 = pm1.f.l();
        if (r103 == null) goto L20;
        r103.x(this.f153359h, r110);
    L20:
        Unit r104 = Unit.INSTANCE;
        r102.sendLog("live_machine_play_time", r110, new Object[]{new am2.x(), Room.class, am2.u.class});
    L30:
        if (this.f153360i == true) goto L32;
        b(null);
    L32:
        this.f153352a = 0;
        this.f153353b = 0;
        return;
    L12:
        r101 = null;
        goto L14
    L21:
        RoomContext r105 = RoomContext.a.c(RoomContext.Companion, this.f153359h, 0, 2);
        if (r105 == null) goto L30;
        if (r105.isVSRoom() != true) goto L30;
        g r106 = u.l();
        HashMap r111 = new HashMap();
        r111.put("duration", String.valueOf(this.f153353b));
        r111.put(VrBgLogData.KEY_VR_TYPE, VrUtils.n());
        r111.put("is_vr_machine", VrUtils.o(this.f153359h));
        nm1.m r107 = pm1.f.l();
        if (r107 == null) goto L28;
        r107.x(this.f153359h, r111);
    L28:
        Unit r108 = Unit.INSTANCE;
        r106.sendLog("livesdk_live_duration_all_reject_pause", r111, new Object[]{new am2.x(), Room.class, am2.u.class});
        goto L30
    }

    public final void e() {
        long r100 = SystemClock.elapsedRealtime();
        this.f153352a = r100;
        this.f153356e = r100;
    }

    public final void b(Integer r100) {
        if (this.f153356e <= 0) goto L8;
        if (this.f153354c == false) goto L8;
        long r101 = SystemClock.elapsedRealtime();
        this.f153355d += r101 - this.f153356e;
        this.f153356e = r101;
    L8:
        if (this.f153355d <= 0) goto L23;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, this.f153359h, 0, 2);
        if (r102 != null) goto L12;
    L14:
        if (r100 == null) goto L19;
        if (r100.intValue() != 0) goto L19;
    L20:
        c(x6.b(null), -1);
    L21:
        this.f153357f = 0;
        this.f153355d = 0;
        return;
    L19:
        if (e5.n() == false) goto L21;
    L12:
        if (r102.isVSLive() != true) goto L14;
        g r103 = u.l();
        HashMap r104 = new HashMap();
        r104.put("duration", String.valueOf(this.f153355d));
        Unit r105 = Unit.INSTANCE;
        r103.sendLog("livesdk_live_landscape_and_portrait_play_duration", r104, new Object[]{new am2.x(), Room.class});
        goto L21
    }

    public j(DataCenter r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f153359h = r100;
        this.f153360i = r101;
    }

    public final void c(String r100, int r110) {
        if (this.f153356e > 0) goto L5;
    L7:
        long r101 = this.f153355d;
        long r102 = this.f153357f;
        long r103 = r101 - r102;
        this.f153357f = r102 + r103;
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, this.f153359h, 0, 2);
        Long r105 = null;
        if (r104 == null) goto L14;
        com.bytedance.live.datacontext.m<Room> r106 = r104.getRoom();
        if (r106 == null) goto L14;
        Room r107 = r106.getValue();
        if (r107 == null) goto L14;
        Long r108 = Long.valueOf(r107.getRoomId());
    L15:
        LiveLandSlideContext.Companion.getClass();
        LiveLandSlideContext r109 = LiveLandSlideContext.a.a();
        if (r109 == null) goto L18;
        r105 = Long.valueOf(r109.getInitRoomId());
    L18:
        boolean r111 = !Intrinsics.areEqual(r108, r105);
        if (r110 == (-1)) goto L21;
    L24:
        Pair[] r112 = new Pair[4];
        r112[0] = TuplesKt.to("duration", String.valueOf(r103));
        r112[1] = TuplesKt.to("picture_type", r100);
        if (x6.f114304e == false) goto L27;
        String r113 = "1";
    L28:
        r112[2] = TuplesKt.to("is_hand_big", r113);
        r112[3] = TuplesKt.to("is_sandwich", String.valueOf(r110));
        Map r114 = MapsKt.mapOf(r112);
        PreRoomInfoContext.Companion.getClass();
        a("livesdk_picture_fit_live_duration", r111, MapsKt.plus(r114, PreRoomInfoContext.a.c()));
        return;
    L27:
        r113 = "0";
        goto L28
    L21:
        if (x6.f() == false) goto L23;
        r110 = 1;
        goto L24
    L23:
        r110 = 0;
    L14:
        r108 = null;
        goto L15
    L5:
        if (this.f153354c == false) goto L7;
        long r115 = SystemClock.elapsedRealtime();
        this.f153355d += r115 - this.f153356e;
        this.f153356e = r115;
        goto L7
    }

    public final void a(String r110, boolean r210, Map<String, String> r211) {
        String r100 = "0";
        if (Intrinsics.areEqual(r211.get("is_support_landscape"), "0") == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.log.filter.o r101 = u.l().c(am2.x.class);
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, this.f153359h, 0, 2);
        if (r102 == null) goto L10;
        com.bytedance.live.datacontext.m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L10;
        Room r104 = r103.getValue();
    L11:
        IUserService r105 = (IUserService) jc1.k.f(IUserService.class);
        if (r105 == null) goto L16;
        com.bytedance.android.livesdk.user.f r106 = r105.user();
        if (r106 == null) goto L16;
        String r107 = r106.n();
    L17:
        String r111 = r101.getMap().get("action_type");
        if (r111 != null) goto L20;
    L28:
        r111 = "switch";
    L29:
        ILivePlayerClient r112 = LivePlatformPlayerManager.f();
        if (r112 == null) goto L34;
        ILivePlayerExtraRenderController r113 = r112.extraRenderController();
        if (r113 == null) goto L34;
        Integer r114 = Integer.valueOf(r113.getGameLayoutType());
    L36:
        if (r114 != null) goto L39;
    L41:
        if (r114 != null) goto L44;
    L46:
        if (r114 != null) goto L49;
    L51:
        if (r114 != null) goto L54;
    L56:
        String r108 = "customize";
    L57:
        com.bytedance.android.livesdk.log.filter.o r109 = u.l().c(Room.class);
        Pair[] r115 = new Pair[13];
        r115[0] = TuplesKt.to("user_id", r107);
        if (r104 == null) goto L60;
        String r116 = r104.getIdStr();
    L61:
        r115[1] = TuplesKt.to("room_id", r116);
        if (r104 == null) goto L64;
        String r117 = r104.getOwnerUserIdString();
    L65:
        r115[2] = TuplesKt.to("anchor_id", r117);
        r115[3] = TuplesKt.to("enter_method", r101.getMap().get("enter_method"));
        r115[4] = TuplesKt.to("enter_from_merge", r101.getMap().get("enter_from_merge"));
        if (r104 == null) goto L68;
        LiveMode r118 = r104.getStreamType();
    L69:
        int r119 = h1.f66189a;
        r115[5] = TuplesKt.to("live_type", i1.a(r118));
        r115[6] = TuplesKt.to("action_type", r101.getMap().get("action_type"));
        r115[7] = TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE, r111);
        if (r210 == false) goto L72;
        r100 = "1";
    L72:
        r115[8] = TuplesKt.to("is_landscape_stream", r100);
        if (r109 == null) goto L78;
        Map<String, String> r120 = r109.getMap();
        if (r120 == null) goto L78;
        String r121 = r120.get("request_id");
        if (r121 == null) goto L78;
    L79:
        r115[9] = TuplesKt.to("request_id", r121);
        if (r104 == null) goto L82;
        int r122 = r104.isGameRoom();
    L83:
        r115[10] = TuplesKt.to("is_game_live", String.valueOf(r122));
        if (r104 == null) goto L86;
        long r123 = r104.getGameTagId();
    L87:
        r115[11] = TuplesKt.to("game_tag_id", String.valueOf(r123));
        r115[12] = TuplesKt.to(AdDownloadModel.JsonKey.MODEL_TYPE, r108);
        Map<String, String> r124 = MapsKt.mutableMapOf(r115);
        if (r104 != null) goto L90;
    L92:
        r124.putAll(r211);
        u.l().sendLog(r110, r124, new Object[0]);
        return;
    L90:
        if (r104.isMergeVSRoom() != true) goto L92;
        r124.put("is_vs", "1");
        int r125 = ju2.f.M;
        r124.putAll(ju2.f.a.a(r104).b());
        goto L92
    L86:
        r123 = 0;
        goto L87
    L82:
        r122 = 0;
    L78:
        r121 = "";
        goto L79
    L68:
        r118 = null;
        goto L69
    L64:
        r117 = null;
        goto L65
    L60:
        r116 = null;
        goto L61
    L54:
        if (r114.intValue() != 4) goto L56;
        r108 = "cam_temp_split";
        goto L57
    L49:
        if (r114.intValue() != 3) goto L51;
        r108 = "cam_temp_floating";
        goto L57
    L44:
        if (r114.intValue() != 2) goto L46;
        r108 = "cam_temp_left_right";
        goto L57
    L39:
        if (r114.intValue() != 1) goto L41;
        r108 = "cam_temp_small";
    L34:
        r114 = null;
        goto L36
    L20:
        if (Intrinsics.areEqual(r111, "draw") == false) goto L23;
        if (r210 == false) goto L23;
        boolean r126 = true;
    L24:
        if (r126 == true) goto L27;
        r111 = null;
    L27:
        if (r111 != null) goto L29;
    L23:
        r126 = false;
    L16:
        r107 = null;
    L10:
        r104 = null;
        goto L11
    }

    public static void g(j r100, Boolean r110, long r111, int r112) {
        IQuality r101 = null;
        Object r102 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        if ((r112 & 1) == 0) goto L6;
        r110 = null;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r111 = 0;
    L8:
        r100.getClass();
        boolean r113 = false;
        if ((SystemClock.elapsedRealtime() - r100.f153358g) <= 500) goto L11;
        boolean r103 = true;
    L12:
        if (r110 == null) goto L14;
        boolean r114 = r110.booleanValue();
    L15:
        if (r103 == true) goto L17;
        return;
    L17:
        if (r100.f153360i == true) goto L95;
        if (r114 == false) goto L20;
    L21:
        r100.f153358g = SystemClock.elapsedRealtime();
        LiveLandSlideContext.Companion.getClass();
        LiveLandSlideContext r115 = LiveLandSlideContext.a.a();
        if (r115 == null) goto L24;
        int r116 = r115.getRelateRoomIndex();
    L26:
        if (r111 == 0) goto L28;
        HashMap r117 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("room_id", String.valueOf(r111))});
    L29:
        PreviewLandScapeUtils r118 = PreviewLandScapeUtils.INSTANCE;
        if (r118.getLandscapePlayMob() == false) goto L32;
        r117.put("landscape_click_page", "preview");
        r118.setLandscapePlayMob(false);
    L34:
        if (x6.f() == false) goto L36;
        String r119 = "1";
    L37:
        r117.put("is_sandwich", r119);
        ILivePlayerClient r120 = LivePlatformPlayerManager.f();
        if (r120 == null) goto L87;
        PlayerResolution.PickResult r104 = r120.context().getResolutionResult();
        int r105 = r120.getAutoResolutionState();
        if ((r120 instanceof as0.a) == true) goto L42;
        r120 = null;
    L42:
        as0.a r121 = (as0.a) r120;
        if (r121 == null) goto L61;
        RoomBaseSession r122 = r121.d();
        if (r122 == null) goto L61;
        StreamUrl r123 = r122.getStreamUrl();
        if (r123 == null) goto L61;
        List<IQuality> r124 = r123.qualityList;
        if (r124 == null) goto L61;
        Iterator<T> r125 = r124.iterator();
    L52:
        if (r125.hasNext() == false) goto L60;
        Object r106 = r125.next();
        String r107 = ((IQuality) r106).getSdkKey();
        if (r104 == null) goto L56;
        String r108 = r104.getResultSdkKey();
    L58:
        if (Intrinsics.areEqual(r107, r108) == false) goto L52;
        r102 = r106;
        goto L60
    L56:
        r108 = null;
    L60:
        r101 = (IQuality) r102;
    L61:
        String r126 = "";
        if (r104 == null) goto L65;
        String r109 = r104.getPickStrategy();
        if (r109 == null) goto L65;
    L66:
        r117.put("resolution_strategy", r109);
        if (r104 == null) goto L70;
        String r127 = r104.getResultSdkKey();
        if (r127 == null) goto L70;
    L71:
        r117.put("result_sdk_key", r127);
        if (r104 == null) goto L75;
        String r128 = r104.getShotStrategyId();
        if (r128 == null) goto L75;
    L76:
        r117.put("strategy_info", r128);
        r117.put("auto_resolution_state", String.valueOf(r105));
        if (r101 == null) goto L82;
        String r129 = r101.getName();
        if (r129 == null) goto L82;
        r126 = r129;
    L82:
        r117.put("resolution_ui_name", r126);
        if (r101 == null) goto L85;
        int r130 = r101.getFps();
    L86:
        String r131 = (String) r117.put("resolution_fps", String.valueOf(r130));
        goto L87
    L85:
        r130 = -1;
    L75:
        r128 = "";
    L70:
        r127 = "";
    L65:
        r109 = "";
    L87:
        if (r116 == 0) goto L89;
        r113 = true;
    L89:
        r100.a("livesdk_live_landscape_play", r113, r117);
        return;
    L36:
        r119 = "0";
        goto L37
    L32:
        r117.put("landscape_click_page", "live");
        goto L34
    L28:
        r117 = new HashMap();
        goto L29
    L24:
        r116 = 0;
        goto L26
    L20:
        if (PreviewLandScapeUtils.INSTANCE.getLandscapePlayMob() == true) goto L21;
        return;
    L95:
        return;
    L14:
        r114 = e5.n();
        goto L15
    L11:
        r103 = false;
        goto L12
    }
}
