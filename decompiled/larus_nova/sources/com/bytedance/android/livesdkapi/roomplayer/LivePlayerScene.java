package com.bytedance.android.livesdkapi.roomplayer;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010 \n\u0002\b\u001f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0011\u0010/\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u000402¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006R\u0011\u00107\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0011\u00109\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0011\u0010;\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u0011\u0010=\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0006R\u0011\u0010?\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0006R\u0011\u0010A\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0006R\u0011\u0010C\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0006R\u0011\u0010E\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0006R\u0011\u0010G\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0006R\u0011\u0010I\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0006R\u0011\u0010K\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0006R\u0011\u0010M\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0006R\u0011\u0010O\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0006¨\u0006Q"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerScene;", "", "()V", "AD_FLOAT_WINDOW", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "getAD_FLOAT_WINDOW", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "CHALLENGE_DETAIL", "getCHALLENGE_DETAIL", "CIRCLE_PREVIEW", "getCIRCLE_PREVIEW", "COMMERCE_CHALLENGE", "getCOMMERCE_CHALLENGE", "DRAWER_FEED", "getDRAWER_FEED", "EC_FEED", "getEC_FEED", "EC_FLOAT_WINDOW", "getEC_FLOAT_WINDOW", "EC_FOLLOW_FEED", "getEC_FOLLOW_FEED", "EC_RECOMMEND_CARD", "getEC_RECOMMEND_CARD", "EC_STORE_PROFILE", "getEC_STORE_PROFILE", "EC_STORE_TAB", "getEC_STORE_TAB", "EXPLORE_PREVIEW", "getEXPLORE_PREVIEW", "FEEDBACK_PREVIEW", "getFEEDBACK_PREVIEW", "FEED_PAID_PREVIEW", "getFEED_PAID_PREVIEW", "FEED_PREVIEW", "getFEED_PREVIEW", "FLOAT_WINDOW", "getFLOAT_WINDOW", "FORMAT_LIVE_INNER_DRAW", "getFORMAT_LIVE_INNER_DRAW", "FORMAT_LIVE_PREIVEW", "getFORMAT_LIVE_PREIVEW", "FRIEND_ROOM_PREVIEW", "getFRIEND_ROOM_PREVIEW", "IM_PREVIEW", "getIM_PREVIEW", "INNER_DRAW", "getINNER_DRAW", "INNER_FLOAT_WINDOW", "getINNER_FLOAT_WINDOW", "IN_ROOM_SCENE_LIST", "", "getIN_ROOM_SCENE_LIST", "()Ljava/util/List;", "LIVE_DETAIL_ROOM", "getLIVE_DETAIL_ROOM", "NEAYBY_PREVIEW", "getNEAYBY_PREVIEW", "OUTER_FLOAT_WINDOW", "getOUTER_FLOAT_WINDOW", "PK_PREVIEW", "getPK_PREVIEW", "PREVIEW", "getPREVIEW", "PREVIEW_EXTRA_RENDER", "getPREVIEW_EXTRA_RENDER", "PROFILE_PREVIEW", "getPROFILE_PREVIEW", "RECOMMEND_PREVIEW", "getRECOMMEND_PREVIEW", "SEARCH_DUAL_PREVIEW", "getSEARCH_DUAL_PREVIEW", "SEARCH_PAID_PREVIEW", "getSEARCH_PAID_PREVIEW", "SEARCH_PREVIEW", "getSEARCH_PREVIEW", "TOGETHER_PREVIEW", "getTOGETHER_PREVIEW", "VOIP_FEED_PREVIEW", "getVOIP_FEED_PREVIEW", "VS_PREVIEW", "getVS_PREVIEW", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerScene {
    private static final ILivePlayerScene AD_FLOAT_WINDOW = null;
    private static final ILivePlayerScene CHALLENGE_DETAIL = null;
    private static final ILivePlayerScene CIRCLE_PREVIEW = null;
    private static final ILivePlayerScene COMMERCE_CHALLENGE = null;
    private static final ILivePlayerScene DRAWER_FEED = null;
    private static final ILivePlayerScene EC_FEED = null;
    private static final ILivePlayerScene EC_FLOAT_WINDOW = null;
    private static final ILivePlayerScene EC_FOLLOW_FEED = null;
    private static final ILivePlayerScene EC_RECOMMEND_CARD = null;
    private static final ILivePlayerScene EC_STORE_PROFILE = null;
    private static final ILivePlayerScene EC_STORE_TAB = null;
    private static final ILivePlayerScene EXPLORE_PREVIEW = null;
    private static final ILivePlayerScene FEEDBACK_PREVIEW = null;
    private static final ILivePlayerScene FEED_PAID_PREVIEW = null;
    private static final ILivePlayerScene FEED_PREVIEW = null;
    private static final ILivePlayerScene FLOAT_WINDOW = null;
    private static final ILivePlayerScene FORMAT_LIVE_INNER_DRAW = null;
    private static final ILivePlayerScene FORMAT_LIVE_PREIVEW = null;
    private static final ILivePlayerScene FRIEND_ROOM_PREVIEW = null;
    private static final ILivePlayerScene IM_PREVIEW = null;
    private static final ILivePlayerScene INNER_DRAW = null;
    private static final ILivePlayerScene INNER_FLOAT_WINDOW = null;
    public static final LivePlayerScene INSTANCE = null;
    private static final List<ILivePlayerScene> IN_ROOM_SCENE_LIST = null;
    private static final ILivePlayerScene LIVE_DETAIL_ROOM = null;
    private static final ILivePlayerScene NEAYBY_PREVIEW = null;
    private static final ILivePlayerScene OUTER_FLOAT_WINDOW = null;
    private static final ILivePlayerScene PK_PREVIEW = null;
    private static final ILivePlayerScene PREVIEW = null;
    private static final ILivePlayerScene PREVIEW_EXTRA_RENDER = null;
    private static final ILivePlayerScene PROFILE_PREVIEW = null;
    private static final ILivePlayerScene RECOMMEND_PREVIEW = null;
    private static final ILivePlayerScene SEARCH_DUAL_PREVIEW = null;
    private static final ILivePlayerScene SEARCH_PAID_PREVIEW = null;
    private static final ILivePlayerScene SEARCH_PREVIEW = null;
    private static final ILivePlayerScene TOGETHER_PREVIEW = null;
    private static final ILivePlayerScene VOIP_FEED_PREVIEW = null;
    private static final ILivePlayerScene VS_PREVIEW = null;

    private LivePlayerScene() {
    }

    static {
        INSTANCE = new LivePlayerScene();
        ILivePlayerScene.Companion r100 = ILivePlayerScene.Companion;
        ILivePlayerScene r101 = r100.innerDraw();
        INNER_DRAW = r101;
        PREVIEW = r100.preview();
        SEARCH_PREVIEW = r100.scene("search_preview");
        SEARCH_DUAL_PREVIEW = r100.scene("search_dual_preview");
        NEAYBY_PREVIEW = r100.scene("nearby_preview");
        DRAWER_FEED = r100.scene("drawer_feed_preview");
        PROFILE_PREVIEW = r100.scene("profile_preview");
        AD_FLOAT_WINDOW = r100.scene("ad_float_window");
        FLOAT_WINDOW = r100.scene("float_window");
        EXPLORE_PREVIEW = r100.scene("explore_preview");
        FRIEND_ROOM_PREVIEW = r100.scene("friend_room_preview");
        SEARCH_PAID_PREVIEW = r100.scene("search_paid_preview");
        FEED_PAID_PREVIEW = r100.scene("feed_paid_preview");
        FEED_PREVIEW = r100.scene("feed_preview");
        VS_PREVIEW = r100.scene("vs_preview");
        RECOMMEND_PREVIEW = r100.scene("recommend");
        PK_PREVIEW = r100.scene("pk_preview");
        FEEDBACK_PREVIEW = r100.scene("question_feedback_preview");
        TOGETHER_PREVIEW = r100.scene("together_preview");
        CHALLENGE_DETAIL = r100.scene("challenge_detail_preview");
        IM_PREVIEW = r100.scene("im_preview");
        COMMERCE_CHALLENGE = r100.scene("commerce_challenge");
        CIRCLE_PREVIEW = r100.scene("circle_preview");
        EC_STORE_PROFILE = r100.scene("ec_store_profile");
        ILivePlayerScene r102 = r100.scene("ec_store_tab");
        EC_STORE_TAB = r102;
        ILivePlayerScene r103 = r100.scene("live_detail_room");
        LIVE_DETAIL_ROOM = r103;
        EC_FEED = r100.scene("ec_feed");
        EC_FOLLOW_FEED = r100.scene("ec_follow_feed");
        EC_RECOMMEND_CARD = r100.scene("ec_recommend_card");
        VOIP_FEED_PREVIEW = r100.scene("voip_feed_preview");
        PREVIEW_EXTRA_RENDER = r100.scene("preview_extrea_render");
        OUTER_FLOAT_WINDOW = r100.scene("outer_float_window");
        INNER_FLOAT_WINDOW = r100.scene("inner_float_window");
        EC_FLOAT_WINDOW = r100.scene("ec_float_window");
        FORMAT_LIVE_PREIVEW = r100.scene("format_live_preview");
        FORMAT_LIVE_INNER_DRAW = r100.scene("format_live_inner");
        IN_ROOM_SCENE_LIST = CollectionsKt.listOf(new ILivePlayerScene[]{r101, r102, r103});
    }

    public final ILivePlayerScene getAD_FLOAT_WINDOW() {
        return AD_FLOAT_WINDOW;
    }

    public final ILivePlayerScene getCHALLENGE_DETAIL() {
        return CHALLENGE_DETAIL;
    }

    public final ILivePlayerScene getCIRCLE_PREVIEW() {
        return CIRCLE_PREVIEW;
    }

    public final ILivePlayerScene getCOMMERCE_CHALLENGE() {
        return COMMERCE_CHALLENGE;
    }

    public final ILivePlayerScene getDRAWER_FEED() {
        return DRAWER_FEED;
    }

    public final ILivePlayerScene getEC_FEED() {
        return EC_FEED;
    }

    public final ILivePlayerScene getEC_FLOAT_WINDOW() {
        return EC_FLOAT_WINDOW;
    }

    public final ILivePlayerScene getEC_FOLLOW_FEED() {
        return EC_FOLLOW_FEED;
    }

    public final ILivePlayerScene getEC_RECOMMEND_CARD() {
        return EC_RECOMMEND_CARD;
    }

    public final ILivePlayerScene getEC_STORE_PROFILE() {
        return EC_STORE_PROFILE;
    }

    public final ILivePlayerScene getEC_STORE_TAB() {
        return EC_STORE_TAB;
    }

    public final ILivePlayerScene getEXPLORE_PREVIEW() {
        return EXPLORE_PREVIEW;
    }

    public final ILivePlayerScene getFEEDBACK_PREVIEW() {
        return FEEDBACK_PREVIEW;
    }

    public final ILivePlayerScene getFEED_PAID_PREVIEW() {
        return FEED_PAID_PREVIEW;
    }

    public final ILivePlayerScene getFEED_PREVIEW() {
        return FEED_PREVIEW;
    }

    public final ILivePlayerScene getFLOAT_WINDOW() {
        return FLOAT_WINDOW;
    }

    public final ILivePlayerScene getFORMAT_LIVE_INNER_DRAW() {
        return FORMAT_LIVE_INNER_DRAW;
    }

    public final ILivePlayerScene getFORMAT_LIVE_PREIVEW() {
        return FORMAT_LIVE_PREIVEW;
    }

    public final ILivePlayerScene getFRIEND_ROOM_PREVIEW() {
        return FRIEND_ROOM_PREVIEW;
    }

    public final ILivePlayerScene getIM_PREVIEW() {
        return IM_PREVIEW;
    }

    public final ILivePlayerScene getINNER_DRAW() {
        return INNER_DRAW;
    }

    public final ILivePlayerScene getINNER_FLOAT_WINDOW() {
        return INNER_FLOAT_WINDOW;
    }

    public final List<ILivePlayerScene> getIN_ROOM_SCENE_LIST() {
        return IN_ROOM_SCENE_LIST;
    }

    public final ILivePlayerScene getLIVE_DETAIL_ROOM() {
        return LIVE_DETAIL_ROOM;
    }

    public final ILivePlayerScene getNEAYBY_PREVIEW() {
        return NEAYBY_PREVIEW;
    }

    public final ILivePlayerScene getOUTER_FLOAT_WINDOW() {
        return OUTER_FLOAT_WINDOW;
    }

    public final ILivePlayerScene getPK_PREVIEW() {
        return PK_PREVIEW;
    }

    public final ILivePlayerScene getPREVIEW() {
        return PREVIEW;
    }

    public final ILivePlayerScene getPREVIEW_EXTRA_RENDER() {
        return PREVIEW_EXTRA_RENDER;
    }

    public final ILivePlayerScene getPROFILE_PREVIEW() {
        return PROFILE_PREVIEW;
    }

    public final ILivePlayerScene getRECOMMEND_PREVIEW() {
        return RECOMMEND_PREVIEW;
    }

    public final ILivePlayerScene getSEARCH_DUAL_PREVIEW() {
        return SEARCH_DUAL_PREVIEW;
    }

    public final ILivePlayerScene getSEARCH_PAID_PREVIEW() {
        return SEARCH_PAID_PREVIEW;
    }

    public final ILivePlayerScene getSEARCH_PREVIEW() {
        return SEARCH_PREVIEW;
    }

    public final ILivePlayerScene getTOGETHER_PREVIEW() {
        return TOGETHER_PREVIEW;
    }

    public final ILivePlayerScene getVOIP_FEED_PREVIEW() {
        return VOIP_FEED_PREVIEW;
    }

    public final ILivePlayerScene getVS_PREVIEW() {
        return VS_PREVIEW;
    }
}
