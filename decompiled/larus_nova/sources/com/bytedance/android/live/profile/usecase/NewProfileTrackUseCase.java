package com.bytedance.android.live.profile.usecase;

import am2.u;
import am2.x;
import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.EcomInfo;
import com.bytedance.android.live.base.model.user.HeartDiamondInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileConstant$ProfileType;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.base.model.user.ShopHeaderInfo;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.profile.model.ProfileRoomProxy;
import com.bytedance.android.live.profile.p004enum.TrackArea;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.message.model.vh;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorTogetherLive;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.JsonObject;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class NewProfileTrackUseCase implements ut0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.profile.model.f f86981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f86982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f86983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f86984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f86985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f86986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.profile.usecase.a f86987g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/usecase/NewProfileTrackUseCase$LogProfileType;", "", "POI_VIEW_CLK", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LogProfileType extends Enum<LogProfileType> {
        public static final LogProfileType POI_VIEW_CLK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogProfileType[] f86988a = null;

        static {
            LogProfileType r100 = new LogProfileType();
            POI_VIEW_CLK = r100;
            f86988a = new LogProfileType[]{r100};
        }

        public static LogProfileType valueOf(String r100) {
            return (LogProfileType) r27.a.a(LogProfileType.class, r100);
        }

        public static LogProfileType[] values() {
            return (LogProfileType[]) f86988a.clone();
        }

        public LogProfileType() {
            super("POI_VIEW_CLK", 0);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // ut0.f
    public final void j() {
    }

    @Override // ut0.f
    public final void a() {
        HashMap r100 = new HashMap();
        ps0.b r101 = this.f86987g.getRoom();
        r100.put("anchor_id", r101.getOwnerUserIdStr().toString());
        r100.put("room_id", String.valueOf(r101.getId()));
        int r102 = vt0.e.f557188a;
        r100.put("user_type", vt0.e.a(r101.getOwnerUserIdStr(), this.f86987g.getTargetUser().baseProfileInfo.getIdStr()));
        boolean r103 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        kc0.e r104 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getRevLinkControlService();
        if (r104 == null) goto L7;
        String r105 = r104.getConnectionType();
        if (r105 == null) goto L7;
        r100.put("connection_type", r105);
    L7:
        j0.l().sendLog("livesdk_profile_card_send_show", r100, new Object[]{new x(), IRoom.class});
    }

    @Override // ut0.f
    public final void c() {
        HashMap r100 = new HashMap();
        IMiddlewareUserService r101 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        String r102 = "";
        if (r101 == null) goto L10;
        com.bytedance.android.livesdk.user.e r103 = r101.user();
        if (r103 == null) goto L10;
        IBaseUser r104 = r103.b();
        if (r104 == null) goto L10;
        String r105 = r104.getIdString();
        if (r105 == null) goto L10;
    L11:
        r100.put("user_id", r105);
        com.bytedance.android.livesdk.chatroom.o r106 = os0.b.a();
        if (r106 != null) goto L14;
    L31:
        r100.put("user_type", r102);
        r100.put("request_page", "profile_card");
        j0.l().sendLog("livesdk_chatroom_audiencelink_icon_show", r100, new Object[]{IRoom.class, x.class});
        return;
    L14:
        if (Intrinsics.areEqual(r106.isAnchor(), Boolean.TRUE) == false) goto L16;
        r102 = "anchor";
        goto L31
    L16:
        IMiddlewareUserService r107 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r107 == null) goto L28;
        com.bytedance.android.livesdk.user.e r108 = r107.user();
        if (r108 == null) goto L28;
        IBaseUser r109 = r108.b();
        if (r109 == null) goto L28;
        py.t r110 = r109.getUserAttrExt();
        if (r110 == null) goto L28;
        if (r110.isAdmin() != true) goto L28;
        r102 = UserGroupScene.DEFAULT_NAME_SPACE;
    L28:
        if (os0.b.c().getLinkPlayerState().getData() != 2) goto L30;
        r102 = "guest";
        goto L31
    L30:
        r102 = SourceType.DEFAULT;
    L10:
        r105 = "";
        goto L11
    }

    @Override // ut0.f
    public final vh g() {
        UserProfileEvent r100 = this.f86987g.getUserProfileEvent();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.originRoomInfo;
    }

    @Override // ut0.f
    public final void n() {
        HashMap r100 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r101 = j0.l().c(x.class);
        if (r101 == null) goto L15;
        String r102 = r101.getMap().get("enter_from_merge");
        String r103 = "";
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r100.put("enter_from_merge", r102);
        String r104 = r101.getMap().get("enter_method");
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        r100.put("enter_method", r104);
        String r105 = r101.getMap().get("action_type");
        if (r105 == null) goto L14;
        r103 = r105;
    L14:
        r100.put("action_type", r103);
    L15:
        ps0.b r106 = this.f86987g.getRoom();
        LiveMode r107 = r106.getStreamType();
        int r108 = h1.f66189a;
        r100.put("live_type", i1.a(r107));
        r100.put("anchor_id", r106.getOwnerUserIdStr().toString());
        r100.put("room_id", String.valueOf(r106.getId()));
        r100.put("function_type", os0.b.c().getIInteractService().getCurrentFunctionType());
        com.bytedance.android.livesdk.chatroom.o r109 = os0.b.a();
        String r110 = "guest";
        if (r109 != null) goto L18;
    L25:
        IMiddlewareUserService r111 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r111 == null) goto L30;
        com.bytedance.android.livesdk.user.e r112 = r111.user();
        if (r112 == null) goto L30;
        String r113 = r112.n();
    L31:
        r100.put("user_id", String.valueOf(r113));
        qs0.h r114 = os0.b.c().getInteractLogUtils();
        if (r114 == null) goto L36;
        String r115 = r114.getCurrentPlayModes();
        if (r115 == null) goto L36;
        r100.put(FastStartLiveConfig.PLAY_MODE, r115);
    L36:
        String r116 = this.f86987g.getTargetUser().baseProfileInfo.getIdStr();
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r116.toString());
        if (Intrinsics.areEqual(r116, r106.getOwnerUserIdStr()) == false) goto L39;
        r110 = "anchor";
    L39:
        r100.put("to_user_type", r110);
        r100.put("request_page", "profile_card");
        j0.l().sendLog("livesdk_like_button_show", r100, new Object[0]);
        return;
    L30:
        r113 = null;
        goto L31
    L18:
        if (Intrinsics.areEqual(r109.isAnchor(), Boolean.TRUE) == false) goto L21;
        String r117 = "anchor";
    L24:
        r100.put("user_type", r117);
        goto L25
    L21:
        if (os0.b.c().getLinkPlayerState().getData() == 0) goto L23;
        r117 = "guest";
        goto L24
    L23:
        r117 = SourceType.DEFAULT;
        goto L24
    }

    public final Map<String, String> p() {
        HashMap r100 = new HashMap();
        com.bytedance.android.livesdk.chatroom.o r101 = os0.b.a();
        String r102 = "guest";
        if (r101 != null) goto L5;
        String r103 = "";
    L12:
        r100.put("user_type", r103);
        IMiddlewareUserService r104 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r104 == null) goto L17;
        com.bytedance.android.livesdk.user.e r105 = r104.user();
        if (r105 == null) goto L17;
        String r106 = r105.n();
    L18:
        r100.put("user_id", String.valueOf(r106));
        ps0.b r107 = this.f86987g.getRoom();
        String r108 = this.f86987g.getTargetUser().baseProfileInfo.getIdStr();
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r108.toString());
        if (Intrinsics.areEqual(r108, r107.getOwnerUserIdStr()) == false) goto L21;
        r102 = "anchor";
    L21:
        r100.put("to_user_type", r102);
        r100.put("request_page", "profile_card");
        return r100;
    L17:
        r106 = null;
        goto L18
    L5:
        if (Intrinsics.areEqual(r101.isAnchor(), Boolean.TRUE) == false) goto L8;
        r103 = "anchor";
        goto L12
    L8:
        if (os0.b.c().getLinkPlayerState().getData() == 0) goto L10;
        r103 = "guest";
        goto L12
    L10:
        r103 = "user";
        goto L12
    }

    public final HashMap<String, String> r() {
        IBaseUser r100 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().b();
        NewProfileUser r101 = this.f86987g.getTargetUser();
        HashMap<String, String> r102 = new HashMap();
        r102.put("request_page", "user_card");
        if (u() == false) goto L6;
        String r103 = "anchor";
    L9:
        r102.put("user_type", r103);
        if (StringUtils.equal(r100.getIdString().toString(), r101.baseProfileInfo.getIdStr()) == false) goto L12;
        String r104 = "oneself";
    L13:
        r102.put("to_user_type", r104);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r101.baseProfileInfo.getIdStr());
        return r102;
    L12:
        r104 = "others";
        goto L13
    L6:
        if (os0.b.c().getLinkPlayerState().getData() != 2) goto L8;
        r103 = "guest";
        goto L9
    L8:
        r103 = "user";
        goto L9
    }

    public final Map<String, String> t() {
        DressSuitInfo r100 = this.f86987g.getTargetUser().getDressSuitInfo();
        if (r100 == null) goto L17;
        String r101 = r100.getExtra();
        if (r101 == null) goto L17;
        LinkedHashMap r102 = null;
        JsonObject r103 = (JsonObject) GsonHelper.get().fromJson(r101, JsonObject.class);     // Catch: Exception -> L9
    L10:
        if (r103 == null) goto L15;
        GsonMap r104 = UtilsKt.i(r103);
        r102 = new LinkedHashMap(MapsKt.mapCapacity(r104.size()));
        Iterator<T> r105 = r104.entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L15;
        Map.Entry r106 = (Map.Entry) r105.next();
        r102.put(r106.getKey(), String.valueOf(r106.getValue()));
    L15:
        if (r102 == null) goto L17;
        return r102;
    L9:
        r103 = null;
    L17:
        return MapsKt.emptyMap();
    }

    public static boolean u() {
        com.bytedance.android.livesdk.chatroom.o r100 = os0.b.a();
        if (r100 == null) goto L5;
        Boolean r101 = r100.isAnchor();
    L7:
        return Intrinsics.areEqual(r101, Boolean.TRUE);
    L5:
        r101 = null;
        goto L7
    }

    @Override // ut0.f
    public final void d() {
        j0.l().sendLog("livesdk_room_meetgame_invite_message_icon_show", p(), new Object[]{IRoom.class, x.class});
    }

    @Override // ut0.f
    public final void e() {
        j0.l().sendLog("livesdk_room_meetgame_invite_icon_show", p(), new Object[]{IRoom.class, x.class});
    }

    @Override // ut0.f
    public final void h() {
        j0.l().sendLog("livesdk_room_meetgame_invite_message_icon_click", p(), new Object[]{IRoom.class, x.class});
    }

    @Override // ut0.f
    public final void i() {
        j0.l().sendLog("livesdk_room_meetgame_invite_icon_click", p(), new Object[]{IRoom.class, x.class});
    }

    public NewProfileTrackUseCase(com.bytedance.android.live.profile.usecase.a r100) {
        Intrinsics.checkNotNullParameter(r100, "profileViewModel");
        this.f86987g = r100;
        this.f86981a = new com.bytedance.android.live.profile.model.f();
        this.f86982b = new x();
        this.f86983c = "";
        this.f86984d = "";
        this.f86985e = MapsKt.mapOf(TuplesKt.to("request_page", "personal_profile"));
        this.f86986f = new s();
        if (j0.l().c(com.bytedance.android.live.profile.model.f.class) != null) goto L6;
        j0.l().register(com.bytedance.android.live.profile.model.f.class, new com.bytedance.android.live.profile.model.g());
        return;
    }

    @Override // ut0.f
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        HashMap r101 = new HashMap();
        r101.put("message_type", r100);
        r101.put("click_user_position", this.f86984d);
        B("livesdk_anchor_audiencecard_click", r101);
    }

    @Override // ut0.f
    public final void l(List<? extends ProfileTagContent> r100) {
        Intrinsics.checkNotNullParameter(r100, PromotionProductPrivilegesStruct.TAGS);
        Iterator<T> r101 = r100.iterator();
        String r102 = "";
    L4:
        if (r101.hasNext() == false) goto L9;
        ProfileTagContent r103 = (ProfileTagContent) r101.next();
        if (r103 == null) goto L4;
        r102 = r102 + r103.tagType + ',';
        goto L4
    L9:
        C("livesdk_standard_show_tags", MapsKt.mapOf(TuplesKt.to(PromotionProductPrivilegesStruct.TAGS, r102)));
    }

    @Override // ut0.f
    public final void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        HashMap r101 = new HashMap();
        com.bytedance.android.livesdk.chatroom.o r102 = os0.b.a();
        if (r102 == null) goto L5;
        Boolean r103 = r102.isAnchor();
    L7:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L9;
        String r104 = "anchor";
    L10:
        r101.put("user_type", r104);
        r101.put("action_type", r100);
        qs0.i r105 = os0.b.c().getIInteractService();
        if (r105 == null) goto L15;
        String r106 = r105.getCurrentFunctionType();
        if (r106 == null) goto L15;
        r101.put("function_type", r106);
    L15:
        if (r105 == null) goto L19;
        String r107 = r105.getFunctionType2();
        if (r107 == null) goto L19;
        r101.put("function_type2", r107);
    L19:
        if (r105 == null) goto L27;
        Boolean r108 = r105.chatRoomIsOpen();
        if (r108 == null) goto L27;
        if (r108.booleanValue() == false) goto L25;
        String r109 = "0";
    L26:
        r101.put("pre_status", r109);
        goto L27
    L25:
        r109 = "1";
    L27:
        j0.l().sendLog("livesdk_profile_card_user_connect", r101, new Object[]{x.class, IRoom.class});
        return;
    L9:
        r104 = UserGroupScene.DEFAULT_NAME_SPACE;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    @Override // ut0.f
    public final void o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        HashMap r101 = new HashMap();
        r101.put("message_type", r100);
        r101.put("click_user_position", this.f86984d);
        B("livesdk_anchor_audiencecard_show", r101);
    }

    public final HashMap<String, String> q(String r100) {
        HashMap<String, String> r101 = new HashMap();
        NewProfileUser r102 = this.f86987g.getTargetUser();
        DressSuitInfo r103 = r102.getDressSuitInfo();
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getUserSuitId();
    L6:
        boolean r106 = false;
        if (r105 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        String r108 = "none";
    L20:
        r101.put(Constants.PACKAGE_ID, r108);
        String r109 = "1";
        if (this.f86987g.getPageTypeUseCase().f87043a == false) goto L23;
        String r110 = "1";
    L24:
        r101.put(com.bytedance.android.ec.core.event.a.KEY_IS_SELF, r110);
        DressSuitInfo r111 = this.f86987g.getTargetUser().getDressSuitInfo();
        if (r111 == null) goto L27;
        r104 = r111.getUserSuitId();
    L27:
        if (r104 != null) goto L29;
    L30:
        r106 = true;
    L31:
        if (r106 == false) goto L33;
        r109 = "0";
    L33:
        r101.put("is_wear", r109);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100.toString());
        r101.putAll(t());
        return r101;
    L29:
        if (r104.length() != 0) goto L31;
    L23:
        r110 = "0";
        goto L24
    L15:
        DressSuitInfo r112 = r102.getDressSuitInfo();
        if (r112 == null) goto L18;
        r108 = r112.getUserSuitId();
    L19:
        Intrinsics.checkNotNull(r108);
        goto L20
    L18:
        r108 = null;
        goto L19
    L9:
        if (r105.length() == 0) goto L12;
        r107 = false;
        goto L13
    L5:
        r105 = null;
        goto L6
    }

    public final void v(boolean r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == false) goto L5;
        String r102 = "fans";
    L6:
        r101.put(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, r102);
        String r103 = "guest";
        if (u() == false) goto L10;
        String r104 = "anchor";
    L13:
        r101.put("user_type", r104);
        if (u() == false) goto L16;
        String r105 = "1";
    L17:
        r101.put(IPerformanceManager.Params.is_anchor, r105);
        String r106 = this.f86987g.getTargetUser().baseProfileInfo.getIdStr();
        if (Intrinsics.areEqual(r106, this.f86987g.getRoom().getOwnerUserIdStr()) == false) goto L21;
        r103 = "anchor";
    L24:
        r101.put("multi_to_user_type", r103);
        r101.put("multi_to_user_id", r106);
        B("livesdk_profile_card_fans_club_join", r101);
        return;
    L21:
        if (vt0.h.b(r106) == true) goto L24;
        r103 = SourceType.DEFAULT;
        goto L24
    L16:
        r105 = "0";
        goto L17
    L10:
        if (os0.b.c().getLinkPlayerState().getData() == 0) goto L12;
        r104 = "guest";
        goto L13
    L12:
        r104 = SourceType.DEFAULT;
        goto L13
    L5:
        r102 = "not_fans";
        goto L6
    }

    public static void y(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        Intrinsics.checkNotNullParameter(r101, "selfId");
        HashMap r102 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r103 = j0.l().c(x.class);
        String r104 = "";
        if (r103 == null) goto L14;
        String r105 = r103.getMap().get("enter_from_merge");
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        r102.put("enter_from_merge", r105);
        String r106 = r103.getMap().get("enter_method");
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        r102.put("enter_method", r106);
        String r107 = r103.getMap().get("action_type");
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        r102.put("action_type", r107);
    L14:
        com.bytedance.android.livesdk.chatroom.o r108 = os0.b.a();
        Long r109 = null;
        if (r108 == null) goto L19;
        com.bytedance.live.datacontext.m<IRoom> r110 = r108.getRoom();
        if (r110 == null) goto L19;
        IRoom r111 = r110.getValue();
    L20:
        if (r111 == null) goto L23;
        String r112 = r111.getOwnerUserIdString();
        if (r112 == null) goto L23;
    L24:
        r102.put("anchor_id", r112);
        if (r111 == null) goto L27;
        r109 = Long.valueOf(r111.getId());
    L27:
        r102.put("room_id", String.valueOf(r109));
        if (r111 == null) goto L33;
        String r113 = r111.getRequestId();
        if (r113 == null) goto L33;
        r104 = r113;
    L33:
        r102.put("request_id", r104);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, s(r112, r101, r100));
        j0.l().sendLog("livesdk_profile_card_livevip_join", r102, new Object[]{am2.o.class});
        return;
    L23:
        r112 = "0";
    L19:
        r111 = null;
        goto L20
    }

    public final void A(String r100, Map<? extends String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ps0.b r102 = this.f86987g.getRoom();
        BaseProfileInfo r103 = this.f86987g.getTargetUser().baseProfileInfo;
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getIdStr();
    L6:
        LinkedHashMap r106 = new LinkedHashMap();
        int r107 = vt0.h.f557191a;
        IMiddlewareUserService r108 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r108 == null) goto L11;
        com.bytedance.android.livesdk.user.e r109 = r108.user();
        if (r109 == null) goto L11;
        r104 = r109.n();
    L11:
        r106.put("request_page", vt0.h.a(String.valueOf(r104), this.f86987g.getTargetUser().baseProfileInfo.getIdStr(), this.f86987g.getRoom().getOwnerUserIdStr()));
        IRoomOthersData r110 = r102.k3();
        if (r110 == null) goto L16;
        IGroupLiveData r111 = r110.getGroupData();
        if (r111 == null) goto L16;
        int r112 = r111.getGroupLiveMode();
    L17:
        IRoomOthersData r113 = r102.k3();
        if (r113 == null) goto L23;
        IGroupLiveData r114 = r113.getGroupData();
        if (r114 == null) goto L23;
        String r115 = String.valueOf(r114.isGroupLive());
        if (r115 == null) goto L23;
    L24:
        r106.put("is_grouped_lived", r115);
        r106.put("is_union_battle", String.valueOf(r112));
        if (r112 == 1) goto L31;
        boolean r116 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        r106.put("group_member_cnt", String.valueOf(((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).getGroupMemberNum()));
        if (Intrinsics.areEqual(r105, this.f86987g.getRoom().getOwnerUserIdStr()) == false) goto L29;
        String r117 = "group_room_owner";
    L34:
        r106.put("to_user_type", r117);
        r106.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, String.valueOf(r105));
        r106.put("function_type", r100);
        if (r101 == null) goto L55;
        Iterator<Map.Entry<? extends String, String>> r118 = r101.entrySet().iterator();
    L38:
        if (r118.hasNext() == false) goto L55;
        Map.Entry<? extends String, String> r119 = r118.next();
        String r120 = r119.getKey();
        String r121 = r119.getValue();
        if (r120 != null) goto L42;
    L45:
        boolean r122 = true;
    L46:
        if (r122 == true) goto L38;
        if (r121 != null) goto L49;
    L52:
        boolean r123 = true;
    L53:
        if (r123 == true) goto L38;
        r106.put(r120, r121);
        goto L38
    L49:
        if (r121.length() == 0) goto L52;
        r123 = false;
        goto L53
    L42:
        if (r120.length() == 0) goto L45;
        r122 = false;
    L55:
        B("livesdk_profile_card_function_click", r106);
        return;
    L29:
        r117 = "group_member";
        goto L34
    L31:
        if (Intrinsics.areEqual(r105, this.f86987g.getRoom().getOwnerUserIdStr()) == false) goto L33;
        r117 = "union_battle_room_owner";
        goto L34
    L33:
        r117 = "union_battle_member";
    L23:
        r115 = "0";
    L16:
        r112 = 0;
        goto L17
    L5:
        r105 = null;
        goto L6
    }

    public final void B(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "logName");
        Intrinsics.checkNotNullParameter(r101, "map");
        j0.l().sendLog(r100, r101, new Object[]{this.f86981a, this.f86982b, IRoom.class});
    }

    public final void C(String r100, Map<String, String> r101) {
        j0.l().sendLog(r100, r101, new Object[]{this.f86981a, this.f86982b, IRoom.class});
    }

    @Override // ut0.f
    public final void b(ProfileTagContent r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tagContent");
        String r102 = r100.clickBuriedPoint;
        if (r102 != null) goto L5;
        return;
    L5:
        LinkedHashMap r103 = new LinkedHashMap();
        Map<String, String> r104 = r100.clickBuriedPointParams;
        if (r104 == null) goto L8;
        r103.putAll(r104);
    L8:
        if (r101 == null) goto L10;
        r103.putAll(r101);
    L10:
        C(r102, r103);
    }

    @Override // ut0.f
    public final void f(ProfileTagContent r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tagContent");
        String r102 = r100.showBuriedPoint;
        if (r102 != null) goto L5;
        return;
    L5:
        LinkedHashMap r103 = new LinkedHashMap();
        Map<String, String> r104 = r100.showBuriedPointParams;
        if (r104 == null) goto L8;
        r103.putAll(r104);
    L8:
        if (r101 == null) goto L10;
        r103.putAll(r101);
    L10:
        C(r102, r103);
    }

    @Override // ut0.f
    public final void recordBusinessShow(TrackArea r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "area");
        Intrinsics.checkNotNullParameter(r101, "name");
        s r102 = this.f86986f;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "area");
        Intrinsics.checkNotNullParameter(r101, "name");
        LinkedHashMap r103 = (LinkedHashMap) r102.f87053a;
        Object r104 = r103.get(r100);
        if (r104 != null) goto L5;
        r104 = new ArrayList();
        r103.put(r100, r104);
    L5:
        ((List) r104).add(r101);
    }

    public final void x(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "targetUserId");
        qs0.i r102 = os0.b.c().getIInteractService();
        Integer r103 = null;
        if (r102 == null) goto L7;
        mv0.k.e r104 = r102.getVideoTalkService();
        if (r104 == null) goto L7;
        Pair<Boolean, Long> r105 = r104.k(r100.toString());
    L9:
        if (r105 != null) goto L11;
    L17:
        HashMap r106 = new HashMap();
        r106.put("to_anchor_id", r100.toString());
        r106.put("to_room_id", String.valueOf(r101));
        boolean r107 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        p11.j r108 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getRevenueLinkDataHolder();
        if (r108 != null) goto L20;
    L22:
        if (r108 == null) goto L24;
        r103 = Integer.valueOf(r108.getMatchType());
    L24:
        int r109 = r103.intValue();
        if (r109 == 0) goto L29;
        if (r109 == 1) goto L28;
        String r110 = "non_connection_screen";
    L30:
        if (r108 == null) goto L32;
        r106.put("channel_id", String.valueOf(r108.getChannelId()));
        r106.put("pk_id", String.valueOf(r108.getPkId()));
    L32:
        r106.put("connection_type", r110);
        j0.l().sendLog("connection_room_transfer", r106, new Object[]{this.f86981a, this.f86982b, IRoom.class});
        return;
    L28:
        r110 = "random_pk";
        goto L30
    L29:
        r110 = "manual_pk";
        goto L30
    L20:
        if (r108.getDuration() != 0) goto L22;
        r110 = "anchor";
        goto L30
    L11:
        if (r105.getFirst().booleanValue() != true) goto L17;
        Long r111 = r105.getSecond();
        qs0.i r112 = os0.b.c().getIInteractService();
        if (r112 == null) goto L34;
        mv0.k.e r113 = r112.getVideoTalkService();
        if (r113 == null) goto L35;
        r113.n(r100);
        return;
    L35:
        return;
    L34:
        return;
    L7:
        r105 = null;
        goto L9
    }

    public static String s(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "anchorId");
        Intrinsics.checkNotNullParameter(r101, "selfId");
        Intrinsics.checkNotNullParameter(r102, "targetId");
        if (Intrinsics.areEqual(r101, r100) == false) goto L9;
        if (Intrinsics.areEqual(r102, r101) == false) goto L7;
        return "anchor_c_anchor";
    L7:
        return "anchor_c_user";
    L9:
        if (Intrinsics.areEqual(r102, r101) == false) goto L12;
        return "user_c_user";
    L12:
        if (Intrinsics.areEqual(r102, r100) == false) goto L14;
        return "user_c_anchor";
    L14:
        return "user_c_others";
    }

    public final void z(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r102, "from");
        HashMap r103 = new HashMap();
        r103.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r103.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, r102);
        com.bytedance.android.livesdk.log.filter.o r104 = j0.l().c(x.class);
        String r105 = "";
        if (r104 == null) goto L11;
        String r106 = r104.getMap().get("enter_from_merge");
        if (r106 != null) goto L7;
        r106 = "";
    L7:
        String r107 = r104.getMap().get("enter_method");
        if (r107 != null) goto L10;
        r107 = "";
    L10:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r106);
        r103.put(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r107);
    L11:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, "live");
        if (r101 != ProfileConstant$ProfileType.SHOP.getType()) goto L14;
        String r108 = "shop";
    L15:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, r108);
        EcomInfo r109 = this.f86987g.getTargetUser().ecomInfo;
        if (r109 == null) goto L22;
        ShopHeaderInfo r110 = r109.getShopHeaderInfo();
        if (r110 == null) goto L22;
        HeartDiamondInfo r111 = r110.getHeartDiamondInfo();
        if (r111 == null) goto L22;
        Integer r112 = Integer.valueOf(r111.getLevel());
    L23:
        r103.put("dou_shop_level", String.valueOf(r112));
        com.bytedance.android.livesdk.log.filter.o r113 = j0.l().c(IRoom.class);
        if (r113 == null) goto L30;
        String r114 = r113.getMap().get("anchor_id");
        if (r114 == null) goto L29;
        r105 = r114;
    L29:
        r103.put("author_id", r105);
    L30:
        j0.l().sendLog(r100, r103, new Object[0]);
        return;
    L22:
        r112 = null;
        goto L23
    L14:
        r108 = LiveEndPageData.TAG_WINDOW;
        goto L15
    }

    public final void w(boolean r210, boolean r211, String r212, String r213) {
        Intrinsics.checkNotNullParameter(r212, "mFromSource");
        Intrinsics.checkNotNullParameter(r213, "clickPosition");
        String r100 = this.f86987g.getTargetUser().baseProfileInfo.getIdStr();
        boolean r101 = this.f86987g.getPageTypeUseCase().f87045c;
        ps0.b r102 = this.f86987g.getRoom();
        boolean r103 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ILinkService r104 = (ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class);
        p11.j r105 = r104.getRevenueLinkDataHolder();
        if (r105 == null) goto L5;
        String r106 = r105.a();
    L6:
        boolean r107 = Intrinsics.areEqual(r106, r100.toString());
        if (Intrinsics.areEqual(r102.getOwnerUserIdStr(), r100) == false) goto L9;
        char r110 = 0;
    L16:
        qs0.s r111 = os0.b.c().getIMicRoomService();
        String r112 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n();
        boolean r113 = r102.a();
        if (r111 == null) goto L22;
        if (r113 == false) goto L22;
        if (r111.isLoyalAudience() == false) goto L22;
        boolean r114 = true;
    L23:
        qs0.i r108 = os0.b.c().getIInteractService();
        if (r113 == true) goto L26;
    L28:
        boolean r115 = false;
    L29:
        if (r113 == true) goto L31;
    L33:
        boolean r116 = false;
    L34:
        IRoom r117 = r102.b();
        if ((r117 instanceof IRoom) == true) goto L37;
        r117 = null;
    L37:
        IRoom r118 = r117;
        if (r113 == false) goto L49;
        if (r118 == null) goto L45;
        IOfficialChannelInfo r119 = r118.getOfficialChannelInfo();
        if (r119 == null) goto L45;
        IBaseUser r120 = r119.getChannelUser();
        if (r120 == null) goto L45;
        String r121 = r120.getIdString();
    L47:
        if (Intrinsics.areEqual(r100, r121) == false) goto L49;
        r110 = 3;
    L45:
        r121 = null;
    L49:
        FollowLog r122 = new FollowLog("", r100);
        if (r107 == false) goto L53;
        r122.f153384c = "right_anchor";
    L53:
        if (TextUtils.isEmpty(this.f86983c) == true) goto L61;
        String r123 = this.f86983c;
        String r124 = "";
        if (Intrinsics.areEqual(r123, "guest_connection") == false) goto L57;
    L60:
        r122.f153384c = r123;
    L62:
        if (r101 == true) goto L64;
        if (r113 == false) goto L95;
        if (r110 != 0) goto L78;
    L79:
        if (r110 != 0) goto L87;
        if (r115 == false) goto L82;
        r122.f153382a = "carousel_host_c_anchor";
    L115:
        if (TextUtils.equals(r212, UserProfileEvent.POSITION_TOP_SINGLE_ROOM_RANK) == false) goto L117;
    L120:
        r122.f153382a = r212;
    L121:
        HashMap r109 = new HashMap();
        if (r210 == false) goto L124;
        r109.put("growth_deepevent", String.valueOf(1));
    L124:
        r109.put("is_personal_profile", "1");
        boolean r125 = Intrinsics.areEqual(r100, r102.getOwnerUserIdStr());
        if (r210 == false) goto L133;
        qs0.d r126 = os0.b.c().getIBroadcastService();
        if (r126 == null) goto L133;
        if (r126.isPlayingGame() == false) goto L131;
        Object r127 = "1";
    L132:
        r109.put("is_gaming", r127);
        Unit r128 = Unit.INSTANCE;
        goto L133
    L131:
        r127 = "0";
    L133:
        if (r210 == false) goto L136;
        HashMap r129 = new HashMap();
        r129.put("follow_type", "follow");
        r129.put("type", "native");
        LiveSlardarMonitor.monitorStatus("ttlive_monitor_profile_follow", 0, r129);
    L136:
        if ((r102.b() instanceof IRoom) == false) goto L142;
        int r130 = h1.f66189a;
        IRoom r131 = r102.b();
        if (r131 == null) goto L141;
        r109.putAll(h1.a(r131));
        goto L142
    L141:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoom");
    L142:
        LiveMode r132 = r102.getStreamType();
        int r133 = h1.f66189a;
        r109.put("live_type", i1.a(r132));
        Long r134 = r102.getAutoCover();
        if (r134 != null) goto L146;
    L147:
        Long r135 = r102.getAutoCover();
        if (r135 != null) goto L151;
    L153:
        String r136 = "other";
    L154:
        r109.put(ILiveRoomPlayFragmentConstant.EXTRA_COVER_TYPE, r136);
    L156:
        if (ts0.a.f547340e.getValue().booleanValue() == false) goto L158;
        Object r137 = "1";
    L159:
        r109.put("is_screen_clear", r137);
        qs0.b r138 = os0.b.c().getAudienceGameContext();
        if (r138 != null) goto L162;
    L164:
        r109.put("action_page", "profile_card");
        if (r211 == false) goto L167;
        Object r139 = "1";
    L168:
        r109.put("is_follow_back", r139);
        r109.put("connection_type", r108.getLinkConnectionType());
        String r140 = r104.getLinkAnchorCount();
        if (r140 == null) goto L171;
        r109.put("anchor_cnt", r140);
        Unit r141 = Unit.INSTANCE;
    L171:
        if (r210 == false) goto L181;
        com.bytedance.android.livesdk.chatroom.o r142 = os0.b.a();
        if (r142 == null) goto L179;
        com.bytedance.live.datacontext.m<Boolean> r143 = r142.isCleanMode();
        if (r143 == null) goto L179;
        if (r143.getValue().booleanValue() != true) goto L179;
        Object r144 = "1";
    L180:
        r109.put("if_clear_mode", r144);
    L179:
        r144 = "0";
    L181:
        r109.put("click_user_position", r213);
        boolean r145 = r102 instanceof ProfileRoomProxy;
        if (r145 == false) goto L225;
        if (r145 == true) goto L185;
        ps0.b r146 = null;
    L186:
        ProfileRoomProxy r147 = (ProfileRoomProxy) r146;
        if (r147 == null) goto L189;
        IRoom r148 = r147.f86058a;
    L190:
        int r149 = vt0.g.f557190a;
        Intrinsics.checkNotNullParameter(r100, "uid");
        ILinkService r150 = (ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class);
        p11.j r151 = r150.getRevenueLinkDataHolder();
        if (r151 == null) goto L193;
        String r152 = r151.a();
    L195:
        if (Intrinsics.areEqual(r152, r100) == true) goto L223;
        p11.e r153 = r150.getMultiAnchorService();
        if (r153 != null) goto L199;
    L201:
        if (r148 != null) goto L206;
        com.bytedance.live.datacontext.m<IRoom> r154 = os0.b.a().getRoom();
        if (r154 == null) goto L205;
        r148 = r154.getValue();
        goto L206
    L205:
        r148 = null;
    L206:
        if (r148 == null) goto L208;
        String r155 = r148.getOwnerUserIdString();
    L210:
        if (Intrinsics.areEqual(r155, r100) == true) goto L223;
        if (r148 == null) goto L218;
        IOfficialChannelInfo r156 = r148.getOfficialChannelInfo();
        if (r156 == null) goto L218;
        IBaseUser r157 = r156.getChannelUser();
        if (r157 == null) goto L218;
        String r158 = r157.getIdString();
    L220:
        if (Intrinsics.areEqual(r158, r100) == true) goto L223;
        int r159 = 0;
    L224:
        r122.f153385d = r159;
    L229:
        p11.h r160 = r104.getPkService();
        if (r160 != null) goto L232;
    L234:
        boolean r161 = false;
    L235:
        if (r161 == false) goto L241;
        if (r105 == null) goto L238;
        Long r162 = Long.valueOf(r105.getPkId());
    L239:
        String r163 = String.valueOf(r162.longValue());
        if (r163 == null) goto L241;
    L242:
        r109.put("pk_id", r163);
        if (r161 == false) goto L245;
        Object r164 = "1";
    L246:
        r109.put("is_in_pk", r164);
        NewProfileUser r165 = this.f86987g.getTargetUser();
        DressSuitInfo r166 = r165.getDressSuitInfo();
        if (r166 == null) goto L249;
        String r167 = r166.getUserSuitId();
    L250:
        if (r167 != null) goto L252;
    L255:
        boolean r168 = true;
    L256:
        if (r168 == false) goto L258;
        String r169 = "none";
    L263:
        r109.put(Constants.PACKAGE_ID, r169);
        com.bytedance.android.live.profile.model.d r170 = this.f86987g.getPageTypeUseCase().a(r165);
        if (r170.f86075a != 0) goto L271;
        int r171 = r170.f86076b;
        int r172 = 1;
        int r173 = 3;
        if (r171 == 1) goto L270;
        if (r171 == 3) goto L270;
        String r174 = "audience_to_audience";
    L277:
        int r175 = r170.f86076b;
        if (r175 == r172) goto L282;
        if (r175 == r173) goto L281;
        String r176 = "-1";
    L283:
        r122.f153386e = FollowLog.Scene.ProfileCard;
        r122.f153388g = r174;
        r122.f153389h = r176;
        if (Intrinsics.areEqual(r102.getOwnerUserIdStr(), r100) == false) goto L286;
        r109.put("to_user_type", "anchor");
    L361:
        UserProfileEvent r177 = this.f86987g.getUserProfileEvent();
        if (r177 == null) goto L366;
        Long r178 = r177.getCommentMsgId();
        if (r178 == null) goto L366;
        r109.put("msg_id", String.valueOf(r178.longValue()));
        Unit r179 = Unit.INSTANCE;
    L366:
        p11.h r180 = r104.getPkService();
        if (r180 == null) goto L371;
        HashMap<String, String> r181 = r180.getFollowExtraParams(r100);
        if (r181 == null) goto L371;
        r109.putAll(r181);
        Unit r182 = Unit.INSTANCE;
    L371:
        com.bytedance.android.live.profile.usecase.a r183 = this.f86987g;
        if ((r183 instanceof com.bytedance.android.live.profile.a) == true) goto L374;
    L376:
        r109.put("is_square_msg_enter", "0");
    L377:
        j0 r184 = j0.l();
        if (r210 == false) goto L380;
        String r185 = "livesdk_follow";
    L381:
        x r186 = new x();
        r186.f4349a = "live_interact";
        r186.f4350b = "live_detail";
        r184.sendLog(r185, r109, new Object[]{this.f86981a, r122, u.class, r186, IRoom.class, am2.n.f()});
        return;
    L380:
        r185 = "livesdk_unfollow";
        goto L381
    L374:
        if (((com.bytedance.android.live.profile.a) r183).showSquareButtonArea() == false) goto L376;
        r109.put("is_square_msg_enter", "1");
        goto L377
    L286:
        mv0.k.d r187 = os0.b.c().getIInteractService().getLinkUserInfoCenter();
        if (r187 == null) goto L304;
        List<ILinkPlayerInfoBridge> r188 = r187.n();
        if (r188 == null) goto L304;
        Iterator<T> r189 = r188.iterator();
    L292:
        if (r189.hasNext() == false) goto L302;
        Object r190 = r189.next();
        ILinkPlayerInfoBridge r191 = (ILinkPlayerInfoBridge) r190;
        if (r191 == null) goto L298;
        IBaseUser r192 = r191.getUser();
        if (r192 == null) goto L298;
        String r193 = r192.getIdString();
    L300:
        if (Intrinsics.areEqual(r193, r100) == false) goto L292;
    L303:
        ILinkPlayerInfoBridge r194 = (ILinkPlayerInfoBridge) r190;
    L306:
        if (r194 == null) goto L308;
        r109.put("to_user_type", "guest");
        goto L361
    L308:
        mv0.k.d r195 = os0.b.c().getIInteractService().getLinkUserInfoCenter();
        if (r195 == null) goto L326;
        List<ILinkPlayerInfoBridge> r196 = r195.m();
        if (r196 == null) goto L326;
        Iterator<T> r197 = r196.iterator();
    L314:
        if (r197.hasNext() == false) goto L324;
        Object r198 = r197.next();
        ILinkPlayerInfoBridge r199 = (ILinkPlayerInfoBridge) r198;
        if (r199 == null) goto L320;
        IBaseUser r1100 = r199.getUser();
        if (r1100 == null) goto L320;
        String r1101 = r1100.getIdString();
    L322:
        if (Intrinsics.areEqual(r1101, r100) == false) goto L314;
    L325:
        ILinkPlayerInfoBridge r200 = (ILinkPlayerInfoBridge) r198;
    L327:
        if (r200 == null) goto L329;
        r109.put("to_user_type", "guest");
        goto L361
    L329:
        IRoomOthersData r201 = r102.k3();
        if (r201 == null) goto L343;
        IAnchorTogetherLive r202 = r201.getAnchorTogetherLive();
        if (r202 == null) goto L343;
        List<IBaseUser> r203 = r202.getTogetherAnchor();
        if (r203 == null) goto L343;
        Iterator<T> r204 = r203.iterator();
    L337:
        if (r204.hasNext() == false) goto L341;
        Object r205 = r204.next();
        if (Intrinsics.areEqual(((IBaseUser) r205).getIdString(), r100) == false) goto L337;
    L342:
        IBaseUser r206 = (IBaseUser) r205;
    L345:
        if (r206 == null) goto L347;
        r109.put("to_user_type", "member");
        goto L361
    L347:
        boolean r207 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        List<IBaseUser> r208 = ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).getGroupMemberList();
        if (r208 == null) goto L357;
        Iterator<T> r209 = r208.iterator();
    L351:
        if (r209.hasNext() == false) goto L355;
        Object r214 = r209.next();
        if (Intrinsics.areEqual(((IBaseUser) r214).getIdString(), r100) == false) goto L351;
        Object r215 = r214;
    L356:
        IBaseUser r216 = (IBaseUser) r215;
    L358:
        if (r216 == null) goto L360;
        r109.put("to_user_type", "member");
        goto L361
    L360:
        r109.put("to_user_type", r124);
        goto L361
    L355:
        r215 = null;
        goto L356
    L357:
        r216 = null;
        goto L358
    L341:
        r205 = null;
    L343:
        r206 = null;
    L320:
        r1101 = null;
        goto L322
    L324:
        r198 = null;
    L326:
        r200 = null;
    L298:
        r193 = null;
        goto L300
    L302:
        r190 = null;
    L304:
        r194 = null;
        goto L306
    L281:
        r176 = "0";
        goto L283
    L282:
        r176 = "1";
    L270:
        r174 = "audience_to_anchor";
        goto L277
    L271:
        r172 = 1;
        r173 = 3;
        int r217 = r170.f86076b;
        if (r217 == 1) goto L276;
        if (r217 == 3) goto L276;
        r174 = "anchor_to_audience";
    L276:
        r174 = "anchor_to_anchor";
        goto L277
    L258:
        DressSuitInfo r218 = r165.getDressSuitInfo();
        if (r218 == null) goto L261;
        r169 = r218.getUserSuitId();
    L262:
        Intrinsics.checkNotNull(r169);
        goto L263
    L261:
        r169 = null;
        goto L262
    L252:
        if (r167.length() == 0) goto L255;
        r168 = false;
        goto L256
    L249:
        r167 = null;
        goto L250
    L245:
        r164 = "0";
        goto L246
    L238:
        r162 = null;
    L241:
        r163 = r124;
        goto L242
    L232:
        if (r160.getPkState() != 1) goto L234;
        r161 = true;
    L218:
        r158 = null;
        goto L220
    L208:
        r155 = null;
        goto L210
    L199:
        if (r153.a(r100) != true) goto L201;
    L223:
        r159 = 1;
        goto L224
    L193:
        r152 = null;
        goto L195
    L189:
        r148 = null;
        goto L190
    L185:
        r146 = r102;
        goto L186
    L225:
        if (r125 == false) goto L227;
        Object r219 = "1";
    L228:
        r109.put(IPerformanceManager.Params.is_anchor, r219);
        goto L229
    L227:
        r219 = "0";
        goto L228
    L167:
        r139 = "0";
        goto L168
    L162:
        if (r138.j() == null) goto L164;
        qs0.b.a r1102 = r138.j();
        Intrinsics.checkNotNull(r1102);
        r109.put("game_id", String.valueOf(r1102.a()));
        qs0.b.a r1103 = r138.j();
        Intrinsics.checkNotNull(r1103);
        r109.put(EventConstants.ExtraJson.GAME_NAME, String.valueOf(r1103.b()));
        goto L164
    L158:
        r137 = "0";
        goto L159
    L151:
        if (r135.longValue() != 1) goto L153;
        r136 = "autocover";
        goto L154
    L146:
        if (r134.longValue() == 0) goto L156;
    L117:
        if (TextUtils.equals(r212, UserProfileEvent.POSITION_SINGLE_ROOM_RANK) == true) goto L120;
        if (TextUtils.equals(r212, "weekly_rank") == false) goto L121;
    L82:
        if (r114 == false) goto L84;
        String r220 = "loyal_audience_c_anchor";
    L85:
        r122.f153382a = r220;
        goto L115
    L84:
        r220 = "carousel_audience_c_anchor";
        goto L85
    L87:
        if (r110 != 3) goto L115;
        if (r115 == false) goto L90;
        r122.f153382a = "carousel_host_c_official_id";
        goto L115
    L90:
        if (r114 == false) goto L92;
        String r221 = "loyal_audience_c_official_id";
    L93:
        r122.f153382a = r221;
        goto L115
    L92:
        r221 = "carousel_audience_c_official_id";
        goto L93
    L78:
        if (r110 == 3) goto L79;
    L95:
        if (r110 == 1) goto L98;
        r122.f153382a = "live_audience_c_anchor";
        goto L115
    L98:
        if (r113 == false) goto L104;
        if (r116 == false) goto L104;
        if (r114 == false) goto L102;
        String r222 = "loyal_audience_c_carousel_host";
    L103:
        r123 = r222;
        r122.f153382a = r123;
    L112:
        if (TextUtils.isEmpty(r123) == false) goto L115;
        r122.f153382a = "live_audience_c_audience";
        goto L115
    L102:
        r222 = "carousel_audience_c_carousel_host";
    L104:
        if (r107 == false) goto L108;
        r122.f153382a = "audience_c_anchor";
        if (r122.f153384c != null) goto L112;
        r123 = "audience_c_anchor";
        goto L112
    L108:
        r122.f153382a = "live_audience_c_audience";
        if (r122.f153384c != null) goto L112;
        r123 = "live_audience_c_audience";
        goto L112
    L64:
        if (r113 == false) goto L67;
        if (r116 == false) goto L67;
        r122.f153382a = "anchor_c_carousel_host";
    L73:
        if (TextUtils.isEmpty(r123) == false) goto L115;
        r122.f153382a = "live_anchor_c_audience";
    L67:
        if (r107 == false) goto L69;
        r122.f153382a = "anchor_c_anchor";
        goto L73
    L69:
        r122.f153382a = "live_anchor_c_audience";
        if (r122.f153384c != null) goto L73;
        r123 = "live_anchor_c_audience";
        goto L73
    L57:
        if (Intrinsics.areEqual(r123, "guest_contribution_list") == true) goto L60;
        if (Intrinsics.areEqual(r123, "guest_waiting_list") == false) goto L62;
    L61:
        r124 = "";
        r123 = null;
        goto L62
    L31:
        if (r108.isMicRoomHost(r100) == false) goto L33;
        r116 = true;
        goto L34
    L26:
        if (r108.isMicRoomHost(r112.toString()) == false) goto L28;
        r115 = true;
    L22:
        r114 = false;
        goto L23
    L9:
        if (r105 == null) goto L11;
        String r1104 = r105.a();
    L13:
        if (Intrinsics.areEqual(r1104, r100) == false) goto L15;
        r110 = 2;
        goto L16
    L15:
        r110 = 1;
        goto L16
    L11:
        r1104 = null;
        goto L13
    L5:
        r106 = null;
        goto L6
    }
}
