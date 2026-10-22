package com.bytedance.android.livesdk.ktvimpl.base.sei;

import android.text.TextUtils;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.RegionList;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.common.utility.Lists;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<ILinkPlayerInfoBridge> f143339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IInteractService f143340b;

    static {
        f143339a = new ArrayList();
    }

    public static final IInteractService g() {
        if (f143340b != null) goto L6;
        f143340b = (IInteractService) jc1.k.f(IInteractService.class);
    L6:
        return f143340b;
    }

    public static OrderedSongDataContext j() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isKtvMode() == false) goto L6;
        return KtvModeOrderedSongDataContext.Companion.getContext();
    L6:
        return KtvComponentOrderedSongDataContext.Companion.getContext();
    }

    public static final String f() {
        com.bytedance.live.datacontext.m<IRoom> r100 = o3.f().getRoom();
        String r101 = "";
        if (r100 == null) goto L8;
        IRoom r102 = r100.getValue();
        if (r102 == null) goto L8;
        String r103 = r102.getOwnerUserIdString();
        if (r103 == null) goto L8;
    L9:
        IInteractService r104 = g();
        if (r104 == null) goto L20;
        FeedViewRoomInfoStore r105 = r104.getFeedViewRoomInfoStore();
        if (r105 == null) goto L20;
        IRoom r106 = r105.getRoom();
        if (r106 == null) goto L20;
        String r107 = r106.getOwnerUserIdString();
        if (r107 == null) goto L20;
        r101 = r107;
    L20:
        if (TextUtils.isEmpty(r103) == true) goto L22;
        return r103;
    L22:
        return r101;
    L8:
        r103 = "";
        goto L9
    }

    public static final List<ILinkPlayerInfoBridge> i() {
        IInteractService r100 = g();
        if (r100 == null) goto L7;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r101 = r100.getLinkUserInfoCenter();
        if (r101 == null) goto L7;
        List r102 = r101.getOnlineUserList();
    L9:
        if (Lists.notEmpty(r102) == true) goto L11;
        IInteractService r103 = g();
        if (r103 == null) goto L42;
        FeedViewRoomInfoStore r104 = r103.getFeedViewRoomInfoStore();
        if (r104 == null) goto L42;
        List<ILinkPlayerInfoBridge> r105 = r104.getOnlineList();
    L44:
        if (Lists.notEmpty(r105) == false) goto L51;
        IInteractService r106 = g();
        if (r106 == null) goto L60;
        FeedViewRoomInfoStore r107 = r106.getFeedViewRoomInfoStore();
        if (r107 != null) goto L62;
        return null;
    L62:
        return r107.getOnlineList();
    L60:
        return null;
    L51:
        return f143339a;
    L42:
        r105 = null;
        goto L44
    L11:
        if (f143339a.isEmpty() == false) goto L32;
        IInteractService r108 = g();
        if (r108 == null) goto L30;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r109 = r108.getLinkUserInfoCenter();
        if (r109 == null) goto L30;
        Iterable r110 = r109.getOnlineUserList();
        if (r110 == null) goto L30;
        ArrayList r111 = new ArrayList();
        Iterator r112 = r110.iterator();
    L20:
        if (r112.hasNext() == false) goto L28;
        Object r113 = r112.next();
        IBaseUser r114 = ((ILinkPlayerInfoBridge) r113).getUser();
        if (r114 == null) goto L24;
        String r115 = r114.getIdString();
    L26:
        if (Intrinsics.areEqual(r115, f()) == false) goto L20;
        r111.add(r113);
        goto L20
    L24:
        r115 = null;
        goto L26
    L28:
        List<ILinkPlayerInfoBridge> r116 = CollectionsKt.toMutableList(r111);
        if (r116 == null) goto L30;
    L31:
        f143339a = r116;
    L30:
        r116 = new ArrayList();
    L32:
        IInteractService r117 = g();
        if (r117 == null) goto L57;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r118 = r117.getLinkUserInfoCenter();
        if (r118 != null) goto L59;
        return null;
    L59:
        return r118.getOnlineUserList();
    L57:
        return null;
    L7:
        r102 = null;
        goto L9
    }

    public static final long h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        List<ILinkPlayerInfoBridge> r101 = i();
        Object r102 = null;
        if (r101 == null) goto L29;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L23;
        Object r104 = r103.next();
        ILinkPlayerInfoBridge r105 = (ILinkPlayerInfoBridge) r104;
        IBaseUser r106 = r105.getUser();
        if (r106 == null) goto L10;
        String r107 = r106.getIdString();
    L12:
        if (TextUtils.isEmpty(r107) == true) goto L20;
        IBaseUser r108 = r105.getUser();
        if (r108 == null) goto L16;
        String r109 = r108.getIdString();
    L18:
        if (Intrinsics.areEqual(r109, r100) == false) goto L20;
        boolean r110 = true;
    L21:
        if (r110 == false) goto L6;
    L24:
        ILinkPlayerInfoBridge r111 = (ILinkPlayerInfoBridge) r104;
        if (r111 == null) goto L29;
        Long r112 = r111.getKSongUid();
        if (r112 == null) goto L29;
        long r113 = r112.longValue();
    L31:
        if (r113 == 0) goto L33;
        return r113;
    L33:
        ChorusContext.a r114 = ChorusContext.Companion;
        if (r114.c() == false) goto L71;
        ChorusContext r115 = r114.getContext();
        if (r115 == null) goto L105;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r116 = r115.getChorusSelectedSongList();
        if (r116 == null) goto L106;
        List<MusicPanel> r117 = r116.getValue();
        if (r117 == null) goto L107;
        Iterator<T> r118 = r117.iterator();
    L43:
        if (r118.hasNext() == false) goto L64;
        Object r119 = r118.next();
        MusicPanel r120 = (MusicPanel) r119;
        OrderInfo r121 = r120.d();
        if (r121 == null) goto L49;
        InteractiveSongUserInfo r122 = r121.getTopUser();
        if (r122 == null) goto L49;
        String r123 = r122.getIdString();
    L51:
        if (TextUtils.isEmpty(r123) == true) goto L61;
        OrderInfo r124 = r120.d();
        if (r124 == null) goto L57;
        InteractiveSongUserInfo r125 = r124.getTopUser();
        if (r125 == null) goto L57;
        String r126 = r125.getIdString();
    L59:
        if (Intrinsics.areEqual(r126, r100) == false) goto L61;
        boolean r127 = true;
    L62:
        if (r127 == false) goto L43;
        r102 = r119;
    L57:
        r126 = null;
    L61:
        r127 = false;
    L49:
        r123 = null;
    L64:
        MusicPanel r128 = (MusicPanel) r102;
        if (r128 == null) goto L108;
        OrderInfo r129 = r128.d();
        if (r129 == null) goto L109;
        InteractiveSongUserInfo r130 = r129.getTopUser();
        if (r130 != null) goto L111;
        return 0;
    L111:
        return r130.getKSongUid().longValue();
    L109:
        return 0;
    L108:
        return 0;
    L107:
        return 0;
    L106:
        return 0;
    L105:
        return 0;
    L71:
        OrderedSongDataContext r131 = j();
        if (r131 == null) goto L112;
        List<SongUniqueInfo> r132 = r131.getKtvPublicSongUniqueInfoList();
        if (r132 == null) goto L113;
        Iterator<T> r133 = r132.iterator();
    L77:
        if (r133.hasNext() == false) goto L86;
        Object r134 = r133.next();
        SongUniqueInfo r135 = (SongUniqueInfo) r134;
        if (TextUtils.isEmpty(r135.getUserId()) == false) goto L81;
    L83:
        boolean r136 = false;
    L84:
        if (r136 == false) goto L77;
        r102 = r134;
        goto L86
    L81:
        if (Intrinsics.areEqual(r135.getUserId(), r100) == false) goto L83;
        r136 = true;
    L86:
        SongUniqueInfo r137 = (SongUniqueInfo) r102;
        if (r137 != null) goto L89;
        return 0;
    L89:
        return r137.getKSongUid();
    L113:
        return 0;
    L112:
        return 0;
    L16:
        r109 = null;
    L20:
        r110 = false;
        goto L21
    L10:
        r107 = null;
        goto L12
    L23:
        r104 = null;
    L29:
        r113 = 0;
        goto L31
    }

    public static final String k(long r110) {
        List<ILinkPlayerInfoBridge> r100 = i();
        Object r101 = null;
        if (r100 == null) goto L28;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L21;
        Object r103 = r102.next();
        ILinkPlayerInfoBridge r104 = (ILinkPlayerInfoBridge) r103;
        Long r105 = r104.getKSongUid();
        if (r105 != null) goto L11;
    L12:
        Long r106 = r104.getKSongUid();
        if (r106 != null) goto L16;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == false) goto L6;
    L22:
        ILinkPlayerInfoBridge r108 = (ILinkPlayerInfoBridge) r103;
        if (r108 == null) goto L28;
        IBaseUser r109 = r108.getUser();
        if (r109 == null) goto L28;
        String r111 = r109.getIdString();
        if (r111 == null) goto L28;
    L30:
        if (TextUtils.isEmpty(r111) == true) goto L32;
        return r111;
    L32:
        ChorusContext.a r112 = ChorusContext.Companion;
        if (r112.c() == false) goto L68;
        ChorusContext r113 = r112.getContext();
        if (r113 == null) goto L105;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r114 = r113.getChorusSelectedSongList();
        if (r114 == null) goto L106;
        List<MusicPanel> r115 = r114.getValue();
        if (r115 == null) goto L107;
        Iterator<T> r116 = r115.iterator();
    L42:
        if (r116.hasNext() == false) goto L59;
        Object r117 = r116.next();
        MusicPanel r118 = (MusicPanel) r117;
        OrderInfo r119 = r118.d();
        if (r119 == null) goto L49;
        InteractiveSongUserInfo r120 = r119.getTopUser();
        if (r120 == null) goto L49;
        if (r120.getKSongUid().longValue() != 0) goto L49;
    L56:
        boolean r121 = false;
    L57:
        if (r121 == false) goto L42;
        r101 = r117;
    L49:
        OrderInfo r122 = r118.d();
        if (r122 == null) goto L56;
        InteractiveSongUserInfo r123 = r122.getTopUser();
        if (r123 == null) goto L56;
        if (r123.getKSongUid().longValue() != r110) goto L56;
        r121 = true;
    L59:
        MusicPanel r124 = (MusicPanel) r101;
        if (r124 == null) goto L108;
        OrderInfo r125 = r124.d();
        if (r125 == null) goto L109;
        InteractiveSongUserInfo r126 = r125.getTopUser();
        if (r126 == null) goto L110;
        String r127 = r126.getIdString();
        if (r127 != null) goto L89;
        return "";
    L89:
        return r127;
    L110:
        return "";
    L109:
        return "";
    L108:
        return "";
    L107:
        return "";
    L106:
        return "";
    L105:
        return "";
    L68:
        OrderedSongDataContext r128 = j();
        if (r128 == null) goto L111;
        List<SongUniqueInfo> r129 = r128.getKtvPublicSongUniqueInfoList();
        if (r129 == null) goto L112;
        Iterator<T> r130 = r129.iterator();
    L74:
        if (r130.hasNext() == false) goto L83;
        Object r131 = r130.next();
        SongUniqueInfo r132 = (SongUniqueInfo) r131;
        if (r132.getKSongUid() != 0) goto L78;
    L80:
        boolean r133 = false;
    L81:
        if (r133 == false) goto L74;
        r101 = r131;
        goto L83
    L78:
        if (r132.getKSongUid() != r110) goto L80;
        r133 = true;
    L83:
        SongUniqueInfo r134 = (SongUniqueInfo) r101;
        if (r134 == null) goto L113;
        r127 = r134.getUserId();
        if (r127 != null) goto L89;
        return "";
    L113:
        return "";
    L112:
        return "";
    L111:
        return "";
    L16:
        if (r106.longValue() != r110) goto L18;
        r107 = true;
        goto L19
    L11:
        if (r105.longValue() == 0) goto L18;
    L21:
        r103 = null;
    L28:
        r111 = "";
        goto L30
    }

    public static final JSONObject e(int r100, long r101) {
        return new JSONObject().put("cmd", r100).put("id", r101);
    }

    public static final JSONObject c(int r100, KtvMusic r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        boolean r103 = true;
        JSONObject r104 = new JSONObject().put("cmd", 1);
        if (r101 == null) goto L5;
        long r105 = r101.getMId();
    L6:
        JSONObject r106 = r104.put("id", r105).put("state", r100);
        KtvComponentContext r107 = KtvComponentContext.Companion.getContext();
        int r108 = 0;
        if (r107 == null) goto L21;
        com.bytedance.live.datacontext.n<Float> r109 = r107.getBallRelativeY();
        if (r109 == null) goto L21;
        Float r110 = r109.getValue();
        if (r110 == null) goto L21;
        if (r110.floatValue() >= 0) goto L16;
        r103 = false;
    L16:
        if (r103 == true) goto L19;
        r110 = null;
    L19:
        if (r110 == null) goto L21;
        r106.put("grid_y", Float.valueOf(r110.floatValue()));
    L21:
        KtvContext.Companion.getClass();
        KtvContext r111 = KtvContext.a.g();
        if (r111 == null) goto L28;
        com.bytedance.live.datacontext.n<String> r112 = r111.getCurrentMvVid();
        if (r112 == null) goto L28;
        Object r113 = (String) r112.getValue();
        if (r113 == null) goto L28;
        r106.put("vid", r113);
    L28:
        String r114 = "";
        if (KtvSettingHelper.w() == true) goto L31;
    L46:
        JSONObject r115 = new JSONObject();
        if (r101 == null) goto L54;
        OrderInfo r116 = r101.getOrderInfo();
        if (r116 == null) goto L54;
        InteractiveSongUserInfo r117 = r116.getTopUser();
        if (r117 == null) goto L54;
        String r118 = r117.getIdString();
        if (r118 == null) goto L54;
    L55:
        JSONObject r119 = r115.put("user_id", h(r118)).put("anchor_id", h(r102));
        if (r101 == null) goto L59;
        String r120 = r101.getMTitle();
        if (r120 == null) goto L59;
    L60:
        JSONObject r121 = r119.put("song_title", r120);
        if (r101 == null) goto L68;
        OrderInfo r122 = r101.getOrderInfo();
        if (r122 == null) goto L68;
        InteractiveSongUserInfo r123 = r122.getTopUser();
        if (r123 == null) goto L68;
        String r124 = r123.getNickNameFlex();
        if (r124 == null) goto L68;
    L69:
        JSONObject r125 = r121.put(InstantPlayContext.NICKNAME, r124);
        if (r101 == null) goto L79;
        OrderInfo r126 = r101.getOrderInfo();
        if (r126 == null) goto L79;
        InteractiveSongUserInfo r127 = r126.getTopUser();
        if (r127 == null) goto L79;
        String r128 = r127.getHighScoreSongCountFlex();
        if (r128 == null) goto L79;
        r114 = r128;
    L79:
        JSONObject r129 = r125.put("h_song_count", r114);
        if (r101 == null) goto L86;
        OrderInfo r130 = r101.getOrderInfo();
        if (r130 == null) goto L86;
        InteractiveSongUserInfo r131 = r130.getTopUser();
        if (r131 == null) goto L86;
        int r132 = r131.getKtvComponentLyricTextSecondLine();
    L87:
        JSONObject r133 = r129.put("ksong_lyric", r132);
        if (r101 == null) goto L94;
        OrderInfo r134 = r101.getOrderInfo();
        if (r134 == null) goto L94;
        InteractiveSongUserInfo r135 = r134.getTopUser();
        if (r135 == null) goto L94;
        r108 = r135.getKtvLyricTextFlex();
    L94:
        JSONObject r136 = r133.put("ktv_lyric", r108);
        if (r101 == null) goto L99;
        String r137 = r101.getMAuthor();
        if (TextUtils.isEmpty(r137) == true) goto L99;
        r136.put("author", r137);
    L99:
        JSONObject r138 = new JSONObject();
        if (r101 == null) goto L112;
        OrderInfo r139 = r101.getOrderInfo();
        if (r139 == null) goto L112;
        InteractiveSongUserInfo r140 = r139.getTopUser();
        if (r140 == null) goto L112;
        py.k r141 = r140.getAvatarThumbFlex();
        if (r141 == null) goto L112;
        List<String> r142 = r141.getUrls();
        if (r142 == null) goto L112;
        String r143 = (String) CollectionsKt.firstOrNull(r142);
        if (r143 == null) goto L112;
        r138.put(ScoreTags.STAR_URL_LIST, new JSONArray().put(r143));
    L112:
        r136.put("avatar_thumb", r138);
        r106.put("order_info", r136);
        return r106;
    L86:
        r132 = 0;
    L68:
        r124 = "";
    L59:
        r120 = "";
    L54:
        r118 = "";
        goto L55
    L31:
        if (((Boolean) KtvSettingHelper.f70606a1.getValue()).booleanValue() == true) goto L46;
        if (r101 == null) goto L46;
        JSONObject r144 = r106.put("lyrics_type", r101.getMLyricType()).put("lyrics_offset", Float.valueOf(r101.getMPreviewStartTime()));
        List<String> r145 = r101.getMLyricUrlList();
        if (r145 == null) goto L37;
        Object r146 = (String) CollectionsKt.firstOrNull(r145);
        if (r146 == null) goto L37;
    L38:
        JSONObject r147 = r144.put("lyric_url", r146);
        KtvMusic.Companion.getClass();
        JSONObject r148 = r147.put("duration", KtvMusic.a.a(r101)).put("copyrighted_app_ids", new JSONArray(r101.getCopyrightedAppIds()));
        Map<Long, RegionList> r149 = r101.getGlobalCopyrightRegionInfo();
        if (r149 == null) goto L44;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l.getClass();
        RegionList r150 = r149.get(Long.valueOf(com.bytedance.android.livesdk.ktvimpl.base.util.j.f143553d));
        if (r150 == null) goto L44;
        List<String> r151 = r150.getValues();
        if (r151 == null) goto L44;
    L45:
        r148.put("copyrighted_region_ids", new JSONArray(r151));
    L44:
        r151 = CollectionsKt.emptyList();
    L37:
        r146 = "";
        goto L38
    L5:
        r105 = 0;
        goto L6
    }

    public static final JSONObject d(int r100, float r101, Integer r102, Boolean r103) {
        JSONObject r104 = new JSONObject();
        r104.put("cmd", r100);
        r104.put(SlcFlexDirection.FLEX_ROW, r102);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_SCORE, Float.valueOf(r101));
        r104.put("show_score", r103);
        return r104;
    }

    public static final JSONObject a(float r100, float r101, float r102, int r103, int r104, String r105, int r106, String r107, Integer r110) {
        Intrinsics.checkNotNullParameter(r105, "anchorId");
        JSONObject r108 = new JSONObject();
        r108.put("cur_tone", Float.valueOf(r100));
        r108.put("standard_tone", Float.valueOf(r101));
        r108.put(com.bytedance.android.ec.core.event.a.KEY_SCORE, Float.valueOf(r102));
        r108.put("sentence_index", r103);
        r108.put("hit_type", r104);
        if (r107 != null) goto L5;
        r107 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n();
    L5:
        r108.put("sender_user_id", h(r107));
        r108.put("anchor_id", h(r105));
        r108.put("combo", r106);
        r108.put("forward", r110);
        return r108;
    }

    public static final JSONObject b(String r100, String r101, String r102, String r103, long r110, String r111, float r112, boolean r113, String r114, boolean r115, long r116, String r117, double r210) {
        Intrinsics.checkNotNullParameter(r114, "tips");
        Intrinsics.checkNotNullParameter(r117, "anchorId");
        JSONObject r104 = new JSONObject();
        r104.put("avatar_thumb", r100);
        if (r101 != null) goto L5;
        String r105 = "";
    L6:
        r104.put("user_id", h(r105));
        r104.put("sec_uid", r102);
        r104.put("nick_name", r103);
        r104.put(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, r110);
        r104.put("song_title", r111);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_SCORE, Float.valueOf(r112));
        r104.put("is_high_score", r113);
        r104.put("midi_tips", r114);
        r104.put("hit_record_ab", r115);
        r104.put("song_id", r116);
        r104.put("threshold", r210);
        r104.put("sender_user_id", h(((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n()));
        r104.put("anchor_id", h(r117));
        return r104;
    L5:
        r105 = r101;
        goto L6
    }
}
