package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.config.po0;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorData;
import com.bytedance.android.livesdkapi.depend.model.live.ClientComponent;
import com.bytedance.android.livesdkapi.depend.model.live.GameAnchorInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.MatchRoomData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.im.IMIndustryServiceInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveUIBaseConfig;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.PreviewLandScapeUtils;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.utility.StringUtils;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class s0 extends a<Room> implements u<Room> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f153332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f153333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Long, Room> f153334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LruCache<Long, Room> f153335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f153336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f153337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ym0.a f153338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f153339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f153340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f153341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f153342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f153343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f153344o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Pair<String, String> f153345p;

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final String n() {
        return String.valueOf(this.f153337h);
    }

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final void x() {
        this.f153339j = "6dof";
    }

    public s0() {
        this.f153339j = "non_6dof";
        this.f153340k = false;
        this.f153341l = 0;
        this.f153342m = 0;
        this.f153343n = "0";
        this.f153344o = "";
        this.f153332c = Collections.synchronizedMap(new HashMap());
        this.f153333d = Collections.synchronizedMap(new HashMap());
        this.f153334e = Collections.synchronizedMap(new HashMap());
        po0 r100 = po0.f120996a;
        if (r100.getValue().getEnable() == false) goto L10;
        int r101 = r100.getValue().getMaxCacheCount();
        if (r101 > 0) goto L8;
        r101 = 50;
    L8:
        this.f153335f = new LruCache(r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final void C(ym0.a r100) {
        this.f153338i = r100;
    }

    public final void J(Map<String, String> r100) {
        Map<String, String> r101 = this.f153291b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.containsKey("home_team_state") == false) goto L20;
        String r102 = "";
        if (StringUtils.equal(this.f153291b.get("home_team_state"), "1") == false) goto L17;
        r100.put("home_team_state", "1");
        if (this.f153291b.get("team_id") != null) goto L11;
        String r103 = "";
    L12:
        r100.put("team_id", r103);
        if (this.f153291b.get("team_name") == null) goto L16;
        r102 = this.f153291b.get("team_name");
    L16:
        r100.put("team_name", r102);
        return;
    L11:
        r103 = this.f153291b.get("team_id");
        goto L12
    L17:
        r100.put("home_team_state", "0");
        r100.put("team_id", "0");
        r100.put("team_name", "");
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
        long r101 = this.f153342m;
        String r102 = "1";
        if (r101 != 0) goto L5;
    L7:
        r100.put("is_related_room", "0");
    L9:
        if (this.f153333d.get(this.f153336g) == null) goto L11;
        r100.put("request_id", this.f153333d.get(this.f153336g));
    L11:
        r100.put("log_pb", this.f153332c.get(this.f153336g));
        Pair<String, String> r103 = this.f153345p;
        if (r103 == null) goto L18;
        Object r104 = r103.first;
        if (r104 == null) goto L18;
        if (((String) r104).equals(this.f153336g) == false) goto L18;
        r100.put("audience_type", (String) this.f153345p.second);
    L18:
        Map<String, String> r105 = this.f153291b;
        if (r105 != null) goto L21;
    L23:
        Map<String, String> r106 = this.f153291b;
        if (r106 != null) goto L26;
    L28:
        Map<String, String> r107 = this.f153291b;
        if (r107 != null) goto L31;
    L33:
        Map<String, String> r108 = this.f153291b;
        if (r108 != null) goto L36;
    L38:
        Map<String, String> r109 = this.f153291b;
        if (r109 != null) goto L41;
    L43:
        ce1.d r110 = ce1.e.f23443a;
        if (r110 != null) goto L46;
    L57:
        Map<String, String> r111 = this.f153291b;
        if (r111 != null) goto L60;
    L62:
        J(r100);
        K(null, r100);
        r100.put("vr_6dof_type", this.f153339j);
        Map<String, String> r112 = this.f153291b;
        if (r112 != null) goto L65;
    L67:
        M(r100, "is_key_anchor");
        M(r100, "game_category_id");
        IHostBusiness r113 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r113 == null) goto L72;
        String r114 = r113.getDesktopParams();
        if (r114 == null) goto L72;
        r100.put(WindowEvent.Params.LAUNCH_METHOD, r114);
    L72:
        M(r100, "is_game_live");
        M(r100, "game_tag_id");
        M(r100, "has_game_cp");
        M(r100, "dual_live_type");
        M(r100, IPerformanceManager.Params.is_anchor);
        return;
    L65:
        if (r112.containsKey("multi_tab_room") == false) goto L67;
        r100.put("multi_tab_room", this.f153291b.get("multi_tab_room"));
        goto L67
    L60:
        if (r111.containsKey("live_type") == false) goto L62;
        r100.put("live_type", this.f153291b.get("live_type"));
        goto L62
    L46:
        if (r110.e() == false) goto L48;
        r100.put("liveroom_orientation", "1");
        r100.put("is_full_screen", "1");
        r100.put("vs_screen_type", "landscape");
    L50:
        if (TextUtils.isEmpty(this.f153344o) == false) goto L52;
        this.f153344o = r110.a();
    L52:
        r100.put("is_pad", this.f153344o);
        r100.put("function_type", r110.c());
        if (r110.isEnableSwitchLandscape() == true) goto L56;
        r102 = "0";
    L56:
        r100.put("is_landscape_screen_judge", r102);
        r110.f(this.f153336g, r100);
        goto L57
    L48:
        r100.put("liveroom_orientation", "0");
        r100.put("is_full_screen", "0");
        r100.put("vs_screen_type", "portrait");
        goto L50
    L41:
        if (r109.containsKey("is_ecom_live") == false) goto L43;
        r100.put("is_ecom_live", this.f153291b.get("is_ecom_live"));
        goto L43
    L36:
        if (r108.containsKey("visibility_range") == false) goto L38;
        r100.put("visibility_range", this.f153291b.get("visibility_range"));
        goto L38
    L31:
        if (r107.containsKey(VrBgLogData.KEY_VR_TYPE) == false) goto L33;
        r100.put(VrBgLogData.KEY_VR_TYPE, this.f153291b.get(VrBgLogData.KEY_VR_TYPE));
        goto L33
    L26:
        if (r106.containsKey("is_life") == false) goto L28;
        r100.put("is_life", this.f153291b.get("is_life"));
        goto L28
    L21:
        if (r105.containsKey(IPerformanceManager.Params.room_type) == false) goto L23;
        r100.put(IPerformanceManager.Params.room_type, this.f153291b.get(IPerformanceManager.Params.room_type));
        goto L23
    L5:
        if (r101 != this.f153341l) goto L7;
        r100.put("is_related_room", "1");
        goto L9
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r210) {
        Room r100 = (Room) r210;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getMRoomAuthStatus() == null) goto L8;
        this.f153340k = !r100.getMRoomAuthStatus().getEnableUserCard();
    L8:
        this.f153336g = String.valueOf(r100.getId());
        Map<String, String> r101 = this.f153291b;
        if (r100.getId() == 0) goto L12;
        r101.put("room_id", String.valueOf(r100.getId()));
    L12:
        if (TextUtils.isEmpty(r100.getRequestId()) == true) goto L15;
        r101.put("request_id", r100.getRequestId());
    L15:
        if (TextUtils.isEmpty(r100.getLog_pb()) == true) goto L17;
        r101.put("log_pb", r100.getLog_pb());
    L19:
        if (r100.getBaseOwner() == null) goto L27;
        String r102 = r100.getBaseOwner().getIdString();
        if (r100.getBaseOwner().getFollowInfo() != null) goto L23;
    L28:
        r101.put("anchor_id", r102);
        if (r100.isVirtualLive() == false) goto L31;
        String r103 = "1";
    L32:
        r101.put("is_virtual_live", r103);
        if (TextUtils.isEmpty(r100.getSourceType()) == true) goto L36;
        r101.put("moment_room_source", r100.getSourceType());
    L36:
        if (r100.getSceneTypeInfo() == null) goto L45;
        if (r100.getSceneTypeInfo().isUnionLiveRoom() != true) goto L45;
        if (r100.getBaseOwner() == null) goto L42;
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_JOINT_ANCHOR_ID, r100.getBaseOwner().getIdString());
    L43:
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_JOINT_ROOM, "1");
        goto L45
    L42:
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_JOINT_ANCHOR_ID, r100.getOwnerUserIdString());
    L45:
        if (r100.getSceneTypeInfo() != null) goto L47;
    L49:
        r101.put("is_life", "0");
    L50:
        r101.put(VrBgLogData.KEY_VR_TYPE, String.valueOf(r100.getVRType()));
        if (r100.getRoomCart() != null) goto L53;
    L55:
        r101.put("is_ecom_live", "0");
    L56:
        r101.put(IPerformanceManager.Params.room_type, String.valueOf(r100.getStreamType().getLogStreamingType()));
        ce1.d r104 = ce1.e.f23443a;
        if (r100.isMediaRoom() == false) goto L59;
        String r110 = "media";
    L60:
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_LAYOUT, r110);
        L(r100, r101);
        if (r104 == null) goto L64;
        r101.put("live_type", r104.d(r100.getStreamType()));
    L64:
        if (r100.getLiveHotSpotInfo() != null) goto L66;
    L68:
        r101.remove("trending_topic");
    L70:
        if (r100.isSimilarRoom == false) goto L72;
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_SIMILAR, "1");
    L73:
        String r111 = "regular";
        String r112 = "try_end";
        if (r100.getPaidLiveData() == null) goto L98;
        r101.put("is_paidlive", String.valueOf(r100.getPaidLiveData().getPaidType()));
        if (r100.isPaidRoom() == false) goto L81;
        if (r100.getPaidLiveData().getTicketSession() == null) goto L81;
        r101.put("ticket_id", String.valueOf(r100.getPaidLiveData().getTicketSession().getTicketId()));
        r101.put("ticket_type", r100.getPaidLiveData().getTicketSession().getTicketCategoryLogStr());
    L81:
        if (r100.getPaidLiveData().mo8273getDuration() != null) goto L83;
    L87:
        String r105 = "try";
    L89:
        if (r100.getPaidLiveData().getViewRight() != 9) goto L92;
        r105 = "vmember";
    L95:
        if (r100.getPaidLiveData().mo8274getMaxViewDuration() == null) goto L97;
        r101.put("try_duration", r100.getPaidLiveData().mo8274getMaxViewDuration().toString());
    L97:
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_PAID_LIVE_STATUS, r105);
    L99:
        r101.put("is_carry_paidlive", "0");
        if (r100.isPaidSubscribeRoom() == false) goto L120;
        r101.put("is_member_live", "1");
        PrivilegeInfo r106 = r100.getPaidLiveData().getPrivilegeInfo().get(String.valueOf(101));
        PaidLiveConfig r113 = r106.entityConfig;
        if (r113 == null) goto L118;
        PaidLiveUIBaseConfig r114 = r106.uiConfig;
        if (r114 == null) goto L118;
        String r115 = r102;
        if (r113.userRight.duration <= r114.duration) goto L113;
    L115:
        if (r106.entityConfig.userRight.viewRight != 0) goto L119;
        r111 = r112;
    L119:
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_PAID_LIVE_STATUS, r111);
    L121:
        Map<String, PrivilegeInfo> r107 = r100.getPrivilegeInfo();
        if (r107 != null) goto L124;
        r101.put("privilege_status", "none");
    L131:
        ClientComponent r108 = r100.clientComponentData;
        if (r108 != null) goto L134;
    L138:
        r101.put("live_template_type", "-1");
    L139:
        IMIndustryServiceInfo r109 = r100.imIndustryServiceInfo;
        if (r109 != null) goto L142;
    L144:
        boolean r116 = false;
    L145:
        if (r116 == false) goto L147;
        String r117 = "1";
    L148:
        r101.put("enable_im", r117);
        if (r100.isCompoundScene() == false) goto L151;
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_COVER_TYPE, "camera");
        r101.put("frame_type", "camera");
    L152:
        String r118 = "";
        if (r100.getBaseOwner() == null) goto L159;
        r101.put("releationship", r100.getBaseOwner().getRelationship());
        if (r100.getBaseOwner().getFollowInfo() == null) goto L157;
        String r119 = String.valueOf(r100.getBaseOwner().getFollowInfo().getFollowStatus());
    L158:
        r101.put("follow_status", r119);
        goto L159
    L157:
        r119 = "";
    L159:
        MatchRoomData r120 = r100.matchRoomData;
        if (r120 != null) goto L162;
    L173:
        r101.put("home_team_state", "0");
        r101.put("team_id", "0");
        r101.put("team_name", "");
    L175:
        if (r101.containsKey("guide_type") == false) goto L180;
        if ("landscape_button".equals(r101.get("guide_type")) == false) goto L180;
        r101.remove("guide_type");
    L180:
        if (r101.containsKey("click_method") == false) goto L185;
        if ("landscape_button".equals(r101.get("click_method")) == false) goto L185;
        r101.remove("click_method");
    L185:
        if (r100.isMergeVSRoom() == true) goto L187;
    L198:
        r101.put("visibility_range", String.valueOf(r100.getVisibilityRange()));
        AnchorData r121 = r100.getAnchorData();
        if (r121 == null) goto L203;
        GameAnchorInfo r122 = r121.getAnchorInfo();
        if (r122 == null) goto L203;
        r101.put("is_key_anchor", r122.logIsKeyAnchor());
        r101.put("game_category_id", r122.logCategoryId());
    L203:
        r101.put("is_game_live", String.valueOf(r100.isGameRoom()));
        r101.put("game_tag_id", String.valueOf(r100.getGameTagId()));
        r101.put("has_game_cp", String.valueOf(r100.isGameCPRoom()));
        r101.put("dual_live_type", String.valueOf(r100.getCompoundSceneType()));
        if (r100.getStreamUrl() == null) goto L211;
        if (r100.getStreamUrl().getStreamOrientation() != 2) goto L208;
        String r123 = "1";
    L209:
        r101.put("is_anchor_live_mode_judge", r123);
        goto L211
    L208:
        r123 = "0";
    L211:
        if (r100.getExtra() != null) goto L213;
    L215:
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_XIGUA_UID);
    L216:
        long r124 = r100.appId;
        if (r124 == 0) goto L219;
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_APP_ID, String.valueOf(r124));
    L221:
        if (TextUtils.isEmpty(r100.getLiveReason()) == true) goto L223;
        r101.put("live_reason", String.valueOf(r100.getLiveReason()));
    L225:
        if (TextUtils.isEmpty(r100.liveRecommendInfo) == true) goto L227;
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO, String.valueOf(r100.liveRecommendInfo));
    L229:
        if (r100.getStreamType() != LiveMode.MEDIA) goto L231;
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_MEDIA, "1");
    L232:
        LruCache<Long, Room> r125 = this.f153335f;
        if (r125 == null) goto L235;
        r125.put(Long.valueOf(r100.getId()), r100);
    L237:
        if (t0.a(this, r115) == false) goto L240;
        r101.put(IPerformanceManager.Params.is_anchor, "1");
    L240:
        if (r100.isEcomNew() == false) goto L242;
        r101.put("is_ecom_new", "1");
        return;
    L242:
        r101.put("is_ecom_new", "0");
        return;
    L235:
        this.f153334e.put(Long.valueOf(r100.getId()), r100);
        goto L237
    L231:
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_IS_MEDIA);
        goto L232
    L227:
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO);
        goto L229
    L223:
        r101.remove("live_reason");
        goto L225
    L219:
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_APP_ID);
        goto L221
    L213:
        if (r100.getExtra().getXiguaUid() == 0) goto L215;
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_XIGUA_UID, String.valueOf(r100.getExtra().getXiguaUid()));
        goto L216
    L187:
        if (r100.getEpisodeExtra() == null) goto L196;
        if (r100.getEpisodeExtra().getMultiTab() == null) goto L196;
        if (r100.getEpisodeExtra2().getMultiTab().getValidTabs() == null) goto L196;
        if (r100.getEpisodeExtra2().getMultiTab().getValidTabs().size() <= 1) goto L196;
        r101.put("multi_tab_room", "1");
    L196:
        if (PreviewLandScapeUtils.INSTANCE.isPreviewLandscapeEnterForVS() == false) goto L198;
        r101.put("guide_type", "landscape_button");
        r101.put("click_method", "landscape_button");
        goto L198
    L162:
        if (r120.getMatchUserInfo() == null) goto L173;
        if (r100.matchRoomData.getMatchUserInfo().getTeamInfo() == null) goto L173;
        MatchRoomData.TeamInfo r126 = r100.matchRoomData.getMatchUserInfo().getTeamInfo();
        long r127 = r126.getTeamId();
        String r128 = r126.getTeamName();
        if (r127 == 0) goto L172;
        r101.put("home_team_state", "1");
        r101.put("team_id", "" + r127);
        if (r128 == null) goto L171;
        r118 = r128;
    L171:
        r101.put("team_name", r118);
        goto L175
    L172:
        r101.put("home_team_state", "0");
        r101.put("team_id", "0");
        r101.put("team_name", "");
        goto L175
    L151:
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_COVER_TYPE);
        r101.remove("frame_type");
        goto L152
    L147:
        r117 = "0";
        goto L148
    L142:
        if (r109.isEntranceOpen() == false) goto L144;
        r116 = true;
        goto L145
    L134:
        if (r108.getTemplateId() == null) goto L138;
        if (r100.clientComponentData.getTemplateId().intValue() == 0) goto L138;
        r101.put("live_template_type", String.valueOf(r100.clientComponentData.getTemplateId()));
        goto L139
    L124:
        r101.put("privilege_status", "paid");
        Iterator<Map.Entry<String, PrivilegeInfo>> r129 = r107.entrySet().iterator();
        if (r129.hasNext() == false) goto L131;
        Map.Entry<String, PrivilegeInfo> r130 = r129.next();
        if (r130.getValue().paidLiveInfo == null) goto L131;
        if (r130.getValue().paidLiveInfo.viewRight != 0) goto L131;
        r101.put("privilege_status", "not_paid");
    L113:
        r112 = "try";
    L111:
        r115 = r102;
    L118:
        r115 = r102;
        r111 = "try";
        goto L119
    L120:
        r115 = r102;
        r101.put("is_member_live", "0");
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_MEMBER_LIVE_STATUS, "try");
        goto L121
    L92:
        if (r100.getPaidLiveData().getViewRight() == 0) goto L95;
        r105 = "regular";
        goto L95
    L83:
        if (r100.getPaidLiveData().mo8274getMaxViewDuration() == null) goto L87;
        if (r100.getPaidLiveData().mo8273getDuration().longValue() <= r100.getPaidLiveData().mo8274getMaxViewDuration().longValue()) goto L87;
        r105 = "try_end";
        goto L89
    L98:
        r101.put("is_paidlive", "0");
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_PAID_LIVE_STATUS, "try");
        goto L99
    L72:
        r101.remove(ILiveRoomPlayFragmentConstant.EXTRA_IS_SIMILAR);
        goto L73
    L66:
        if (TextUtils.isEmpty(r100.getLiveHotSpotInfo().title) == true) goto L68;
        r101.put("trending_topic", r100.getLiveHotSpotInfo().title);
        goto L70
    L59:
        r110 = "normal";
        goto L60
    L53:
        if (r100.getRoomCart().getShowCartExt() != 1) goto L55;
        r101.put("is_ecom_live", "1");
        goto L56
    L47:
        if (r100.getSceneTypeInfo().isLife() != true) goto L49;
        r101.put("is_life", "1");
        goto L50
    L31:
        r103 = "0";
        goto L32
    L23:
        if (r100.getBaseOwner().isFollowing() == false) goto L25;
        String r131 = "1";
    L26:
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_FANS, r131);
        goto L28
    L25:
        r131 = "0";
        goto L26
    L27:
        r102 = r100.getOwnerUserIdString();
        goto L28
    L17:
        r101.remove("log_pb");
        goto L19
    }

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final void v(Map<String, String> r100) {
        K(null, r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final void y(String r100) {
        this.f153343n = r100;
    }

    @Override // com.bytedance.android.livesdk.log.filter.u
    public final String z(String r100) {
        if (this.f153333d.containsKey(r100) == true) goto L5;
        return "";
    L5:
        return this.f153333d.get(r100);
    }

    public static void L(Room r100, Map r101) {
        if (r100.mBasisRoomData != null) goto L5;
        return;
    L5:
        if (r100.isLiveTypeAudio() == true) goto L7;
        return;
    L7:
        if (r100.mBasisRoomData.isCustomizeAudioRoom().booleanValue() == false) goto L9;
        String r102 = "customize";
    L10:
        r101.put("voice_mode", r102);
        return;
    L9:
        r102 = "head";
        goto L10
    }

    public final void K(Room r100, Map<String, String> r101) {
        long r102 = d5.c(this.f153336g);
        if (r100 != null) goto L7;
        LruCache<Long, Room> r103 = this.f153335f;
        if (r103 == null) goto L7;
        r100 = r103.get(Long.valueOf(r102));
    L7:
        if (r100 != null) goto L11;
        Map<Long, Room> r104 = this.f153334e;
        if (r104 == null) goto L11;
        r100 = r104.get(Long.valueOf(r102));
    L11:
        String r105 = "1";
        if (r100 != null) goto L14;
    L23:
        String r106 = "0";
    L24:
        r101.put("is_multi_camera_mode_on", r106);
        ym0.a r107 = this.f153338i;
        if (r107 == null) goto L43;
        r101.put("multi_camera_serial", String.valueOf(r107.b()));
        r101.put("stream_id", String.valueOf(this.f153338i.f()));
        boolean r108 = false;
        if (this.f153338i.d() != 1) goto L29;
        boolean r109 = true;
    L31:
        if (this.f153338i.c() != 1) goto L33;
        r108 = true;
    L33:
        if (r109 == true) goto L37;
        if (r108 == false) goto L37;
        String r110 = "1";
    L38:
        r101.put("is_vr_machine", r110);
        if (this.f153338i.d() == 1) goto L42;
        r105 = "0";
    L42:
        r101.put("is_host_camera", r105);
        return;
    L37:
        r110 = "0";
        goto L38
    L29:
        r109 = false;
        goto L31
    L43:
        r101.put("is_vr_machine", this.f153343n);
        return;
    L14:
        if (r100.getToolbarData() == null) goto L23;
        if (r100.getToolbarData().getToolbarDataList() == null) goto L23;
        Iterator<IToolbarComponentData> r111 = r100.getToolbarData().getToolbarDataList().iterator();
    L19:
        if (r111.hasNext() == false) goto L23;
        if (r111.next().getId() != 42) goto L19;
        r106 = "1";
        goto L24
    }

    public final void M(Map<String, String> r100, String r101) {
        Map<String, String> r102 = this.f153291b;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.containsKey(r101) == false) goto L9;
        r100.put(r101, this.f153291b.get(r101));
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r110, Object r111) {
        Room r112 = (Room) r111;
        if (r112 == null) goto L90;
        long r100 = this.f153342m;
        String r101 = "0";
        if (r100 != 0) goto L8;
    L10:
        r110.put("is_related_room", "0");
    L12:
        if (r112.getId() == 0) goto L15;
        r110.put("room_id", String.valueOf(r112.getId()));
    L15:
        if (TextUtils.isEmpty(r112.getRequestId()) == true) goto L18;
        r110.put("request_id", r112.getRequestId());
    L18:
        if (TextUtils.isEmpty(r112.getLog_pb()) == true) goto L21;
        r110.put("log_pb", r112.getLog_pb());
    L21:
        if (r112.getBaseOwner() == null) goto L23;
        String r102 = r112.getBaseOwner().getIdString();
    L24:
        r110.put("anchor_id", r102);
        if (r112.isVirtualLive() == false) goto L27;
        Object r103 = "1";
    L28:
        r110.put("is_virtual_live", r103);
        if (r112.getSceneTypeInfo() == null) goto L38;
        if (r112.getSceneTypeInfo().isUnionLiveRoom() != true) goto L38;
        if (r112.getBaseOwner() == null) goto L35;
        r110.put(ILiveRoomPlayFragmentConstant.EXTRA_JOINT_ANCHOR_ID, String.valueOf(r112.getBaseOwner().getIdString()));
    L36:
        r110.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_JOINT_ROOM, "1");
        goto L38
    L35:
        r110.put(ILiveRoomPlayFragmentConstant.EXTRA_JOINT_ANCHOR_ID, String.valueOf(r112.getOwnerUserIdString()));
    L38:
        if (r112.isSimilarRoom == false) goto L40;
        r110.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_SIMILAR, "1");
    L40:
        Map<String, String> r104 = this.f153291b;
        if (r104 != null) goto L43;
    L45:
        Map<String, String> r105 = this.f153291b;
        if (r105 != null) goto L48;
    L50:
        Map<String, String> r106 = this.f153291b;
        if (r106 != null) goto L53;
    L55:
        r110.put("visibility_range", String.valueOf(r112.getVisibilityRange()));
    L56:
        Map<String, String> r107 = this.f153291b;
        if (r107 == null) goto L62;
        if (r107.containsKey("is_ecom_live") == false) goto L62;
        r110.put("is_ecom_live", this.f153291b.get("is_ecom_live"));
    L62:
        if (TextUtils.isEmpty(r112.getSourceType()) == true) goto L64;
        r110.put("moment_room_source", r112.getSourceType());
    L64:
        L(r112, r110);
        ce1.d r108 = ce1.e.f23443a;
        if (r108 == null) goto L78;
        r110.put("live_type", r108.d(r112.getStreamType()));
        r110.put("function_type", r108.c());
        if (r108.e() == false) goto L69;
        r110.put("liveroom_orientation", "1");
        r110.put("is_full_screen", "1");
        r110.put("vs_screen_type", "landscape");
    L71:
        if (TextUtils.isEmpty(this.f153344o) == false) goto L73;
        this.f153344o = r108.a();
    L73:
        r110.put("is_pad", this.f153344o);
        if (r108.isEnableSwitchLandscape() == false) goto L76;
        r101 = "1";
    L76:
        r110.put("is_landscape_screen_judge", r101);
        r108.f(String.valueOf(r112.getId()), r110);
        goto L78
    L69:
        r110.put("liveroom_orientation", "0");
        r110.put("is_full_screen", "0");
        r110.put("vs_screen_type", "portrait");
    L78:
        if (r112.getLiveHashTagInfo() == null) goto L80;
        r110.put("tag_id", r112.getLiveHashTagInfo().f162597id);
    L80:
        J(r110);
        K(r112, r110);
        r110.put("vr_6dof_type", this.f153339j);
        IHostBusiness r109 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r109 == null) goto L85;
        String r113 = r109.getDesktopParams();
        if (r113 == null) goto L85;
        r110.put(WindowEvent.Params.LAUNCH_METHOD, r113);
    L85:
        r110.put("is_game_live", String.valueOf(r112.isGameRoom()));
        r110.put("game_tag_id", String.valueOf(r112.getGameTagId()));
        r110.put("has_game_cp", String.valueOf(r112.isGameCPRoom()));
        r110.put("dual_live_type", String.valueOf(r112.getCompoundSceneType()));
        if (t0.a(this, r102) == false) goto L89;
        r110.put(IPerformanceManager.Params.is_anchor, "1");
        return;
    L89:
        return;
    L53:
        if (r106.containsKey("visibility_range") == false) goto L55;
        r110.put("visibility_range", this.f153291b.get("visibility_range"));
        goto L56
    L48:
        if (r105.containsKey(VrBgLogData.KEY_VR_TYPE) == false) goto L50;
        r110.put(VrBgLogData.KEY_VR_TYPE, this.f153291b.get(VrBgLogData.KEY_VR_TYPE));
        goto L50
    L43:
        if (r104.containsKey("is_life") == false) goto L45;
        r110.put("is_life", this.f153291b.get("is_life"));
        goto L45
    L27:
        r103 = "0";
        goto L28
    L23:
        r102 = r112.getOwnerUserIdString();
        goto L24
    L8:
        if (r100 != this.f153341l) goto L10;
        r110.put("is_related_room", "1");
        goto L12
    }
}
