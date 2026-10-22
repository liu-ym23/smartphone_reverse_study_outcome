package com.bytedance.android.livesdkapi.room.state;

import android.os.Bundle;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 m2\u00020\u0001:\u0001mBë\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010 \u001a\u00020\b\u0012\b\u0010!\u001a\u0004\u0018\u00010\b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010#\u001a\u0004\u0018\u00010$\u0012\b\u0010%\u001a\u0004\u0018\u00010\b\u0012\b\u0010&\u001a\u0004\u0018\u00010\b\u0012\b\u0010'\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010(\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010)\u001a\u00020\u0005\u0012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0002\u0010+J\u0006\u0010k\u001a\u00020lR \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010&\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u0010(\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0014\u0010 \u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010'\u001a\u0004\u0018\u00010\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0016\u0010\"\u001a\u0004\u0018\u00010\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u0014\u0010)\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010-R\u001a\u00109\u001a\u00020:X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u00107R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010G\"\u0004\bL\u0010IR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u00107R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u00107R\u001a\u0010M\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00107\"\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u00107R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010DR\u001a\u0010Q\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00107\"\u0004\bR\u0010OR\u0014\u0010S\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u00107R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010DR\u0014\u0010T\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u00107R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010DR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u00107R\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u00107R\u0014\u0010U\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u00107R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010DR\u001a\u0010V\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00107\"\u0004\bW\u0010OR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010GR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u00103R\u0014\u0010\u0016\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010GR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010/R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010DR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010-R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010/R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010/R\u0014\u0010\n\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010/R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010/R\u001c\u0010b\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010/\"\u0004\bd\u0010eR\u0014\u0010\u0011\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010GR\u0016\u0010#\u001a\u0004\u0018\u00010$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0016\u0010!\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010/R\u0016\u0010%\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010/¨\u0006n"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/state/RoomState;", "Lcom/bytedance/android/livesdkapi/room/state/IRoomState;", "itemType", "", "isAnchor", "", "isPortrait", "roomId", "", "roomAnchorId", "roomAnchorSecId", "isFollowed", "isReplayOpen", "isLoginFunc", "Lkotlin/Function0;", "hasViewRightFunc", "isRoomVisibleFunc", "streamType", "reportParams", "", "extra", "Landroid/os/Bundle;", "liveSdkVersion", "enterRoomParams", "isKtvFun", "isInInteractionGameFun", "panelHeight", "cartIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", "landscapeCartIcon", "requestId", "logPb", "anchorName", "title", "cover", "streamUrl", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "viewCount", "anchorFollowerCount", "contentLabel", "anchorLocation", "enterFromSpecialAd", "adLiveParams", "(IZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ILjava/util/Map;Landroid/os/Bundle;ILjava/util/Map;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/bytedance/android/live/base/model/ImageModel;Lcom/bytedance/android/live/base/model/ImageModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/live/base/model/ImageModel;Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/live/base/model/ImageModel;Ljava/lang/String;ZLjava/util/Map;)V", "getAdLiveParams", "()Ljava/util/Map;", "getAnchorFollowerCount", "()Ljava/lang/String;", "getAnchorLocation", "getAnchorName", "getCartIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "getContentLabel", "getCover", "getEnterFromSpecialAd", "()Z", "getEnterRoomParams", "episodeId", "", "getEpisodeId", "()J", "setEpisodeId", "(J)V", "getExtra", "()Landroid/os/Bundle;", "hasViewRight", "getHasViewRight", "getHasViewRightFunc", "()Lkotlin/jvm/functions/Function0;", "instantType", "getInstantType", "()I", "setInstantType", "(I)V", "introType", "getIntroType", "setIntroType", "isGameRoom", "setGameRoom", "(Z)V", "isInInteractionGame", "isInPreview", "setInPreview", "isKtv", Keys.API_RETURN_KEY_IS_LOGIN, "isRoomVisible", "isVerticalVideo", "setVerticalVideo", "getItemType", "getLandscapeCartIcon", "getLiveSdkVersion", "getLogPb", "getPanelHeight", "getReportParams", "getRequestId", "getRoomAnchorId", "getRoomAnchorSecId", "getRoomId", "routeRule", "getRouteRule", "setRouteRule", "(Ljava/lang/String;)V", "getStreamType", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "getTitle", "getViewCount", "convert", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomState implements IRoomState {
    public static final Companion Companion = null;
    public static final String EXTRA_BOOL_ANCHOR_HAS_COMMERCE_PERMISSION = "EXTRA_BOOL_ANCHOR_HAS_COMMERCE_PERMISSION";
    public static final String EXTRA_BOOL_AUTO_OPEN_LIVE_AD_LANDING_PAGE = "auto_open_live_ad_landing_page";
    public static final String EXTRA_BOOL_COMMODITY_NO_FILTER = "EXTRA_BOOL_COMMODITY_NO_FILTER";
    public static final String EXTRA_BOOL_COMMODITY_NO_FILTER_DEFAULT_OPEN = "EXTRA_BOOL_COMMODITY_NO_FILTER_DEFAULT_OPEN";
    public static final String EXTRA_BOOL_FROM_AD = "EXTRA_BOOL_FROM_AD";
    public static final String EXTRA_BOOL_FULL_FEATURED_LIVE_COMMERCE = "EXTRA_BOOL_FULL_FEATURED_LIVE_COMMERCE";
    public static final String EXTRA_BOOL_IS_BUSINESS_ROOM = "EXTRA_BOOL_IS_BUSINESS_ROOM";
    public static final String EXTRA_BOOL_IS_HORIZONTAL_STREAM = "EXTRA_BOOL_IS_HORIZONTAL_STREAM";
    public static final String EXTRA_BOOL_IS_LANDSCAPE_NEW_STYLE = "EXTRA_BOOL_IS_LANDSCAPE_NEW_STYLE";
    public static final String EXTRA_BOOL_IS_TOOLBAR_EQUAL_CART = "EXTRA_BOOL_IS_TOOLBAR_EQUAL_CART";
    public static final String EXTRA_BOOL_ROOM_FORBID_COMMERCE_CARD = "EXTRA_BOOL_ROOM_FORBID_COMMERCE_CARD";
    public static final String EXTRA_BOOL_ROOM_HAS_CART_INFO = "EXTRA_BOOL_ROOM_HAS_CART_INFO";
    public static final String EXTRA_BOOL_ROOM_HAS_COMMERCE = "EXTRA_BOOL_ROOM_HAS_COMMERCE";
    public static final String EXTRA_BOOL_ROOM_HAS_COMMERCE_LOTTERY = "EXTRA_BOOL_ROOM_HAS_COMMERCE_LOTTERY";
    public static final String EXTRA_BOOL_ROOM_HAS_GROUP_PURCHASE_PERMISSION = "EXTRA_BOOL_ROOM_HAS_GROUP_PURCHASE_PERMISSION";
    public static final String EXTRA_BOOL_ROOM_HAS_INIT_GOOD = "EXTRA_BOOL_ROOM_HAS_INIT_GOOD";
    public static final String EXTRA_BOOL_SLIDED_IN_VIEW_PAGER = "EXTRA_BOOL_SLIDED_IN_VIEW_PAGER";
    public static final String EXTRA_DATA_ENTER_LOCALLIFT_LIVE_ENV_PARAMS = "data_enter_locallife_live_env_params";
    public static final String EXTRA_DATA_ENTER_LOCALLIFT_LIVE_PARAMS = "data_enter_locallife_live_params";
    public static final String EXTRA_DATA_ENTER_ROOM_OPEN_GAME_DETAIL = "game_promote_enter_room";
    public static final String EXTRA_ENTER_REQUEST = "enter_request";
    public static final String EXTRA_INT_BUSINESS_SHOW_WINDMILL = "EXTRA_INT_BUSINESS_SHOW_WINDMILL";
    public static final String EXTRA_INT_FLASH_SHOPPING_GOOD = "EXTRA_INT_FLASH_SHOPPING_GOOD";
    public static final String EXTRA_INT_SHOW_CART = "EXTRA_INT_SHOW_CART";
    public static final String EXTRA_INT_TOTAL_SHOPPING_GOOD = "EXTRA_INT_TOTAL_SHOPPING_GOOD";
    public static final String EXTRA_IS_D_ROOM = "EXTRA_IS_D_ROOM";
    public static final String EXTRA_IS_FIRST_ROOM = "EXTRA_IS_FIRST_ROOM";
    public static final String EXTRA_IS_ROOM_VISIBLE = "EXTRA_IS_ROOM_VISIBLE";
    public static final String EXTRA_JSON_STR_ACTIVITY_TRANSMISSION = "EXTRA_JSON_STR_ACTIVITY_TRANSMISSION";
    public static final String EXTRA_LONG_COMMERCE_CARD = "EXTRA_LONG_COMMERCE_CARD";
    public static final String EXTRA_MAP_CART_HORIZONTAL = "EXTRA_MAP_CART_HORIZONTAL";
    public static final String EXTRA_MAP_CART_STYLE = "EXTRA_MAP_CART_STYLE";
    public static final String EXTRA_MAP_CART_VERTICAL = "EXTRA_MAP_CART_VERTICAL";
    public static final String EXTRA_ROOM_DRAW_INDEX = "EXTRA_ROOM_DRAW_INDEX";
    public static final String EXTRA_STRING_CART_ICON = "EXTRA_STRING_CART_ICON";
    public static final String EXTRA_STRING_ROOM_ENTER_LOG_ID = "EXTRA_ROOM_ENTER_LOG_ID";
    public static final int ITEM_TYPE_ROOM = 0;
    public static final int ITEM_TYPE_VS_FIRST_SHOW = 2;
    public static final int ITEM_TYPE_VS_ROOM = 1;
    public static final int ITEM_TYPE_VS_VIDEO = 3;
    private final Map<String, String> adLiveParams;
    private final String anchorFollowerCount;
    private final String anchorLocation;
    private final String anchorName;
    private final ImageModel cartIcon;
    private final ImageModel contentLabel;
    private final ImageModel cover;
    private final boolean enterFromSpecialAd;
    private final Map<String, String> enterRoomParams;
    private long episodeId;
    private final Bundle extra;
    private final Function0<Boolean> hasViewRightFunc;
    private int instantType;
    private int introType;
    private final boolean isAnchor;
    private final boolean isFollowed;
    private boolean isGameRoom;
    private final boolean isInInteractionGame;
    private final Function0<Boolean> isInInteractionGameFun;
    private boolean isInPreview;
    private final Function0<Boolean> isKtvFun;
    private final Function0<Boolean> isLoginFunc;
    private final boolean isPortrait;
    private final boolean isReplayOpen;
    private final Function0<Boolean> isRoomVisibleFunc;
    private boolean isVerticalVideo;
    private final int itemType;
    private final ImageModel landscapeCartIcon;
    private final int liveSdkVersion;
    private final String logPb;
    private final Function0<Integer> panelHeight;
    private final Map<String, String> reportParams;
    private final String requestId;
    private final String roomAnchorId;
    private final String roomAnchorSecId;
    private final String roomId;
    private String routeRule;
    private final int streamType;
    private final StreamUrl streamUrl;
    private final String title;
    private final String viewCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020)X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020)X\u0086T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/state/RoomState$Companion;", "", "()V", RoomState.EXTRA_BOOL_ANCHOR_HAS_COMMERCE_PERMISSION, "", "EXTRA_BOOL_AUTO_OPEN_LIVE_AD_LANDING_PAGE", RoomState.EXTRA_BOOL_COMMODITY_NO_FILTER, RoomState.EXTRA_BOOL_COMMODITY_NO_FILTER_DEFAULT_OPEN, RoomState.EXTRA_BOOL_FROM_AD, RoomState.EXTRA_BOOL_FULL_FEATURED_LIVE_COMMERCE, RoomState.EXTRA_BOOL_IS_BUSINESS_ROOM, RoomState.EXTRA_BOOL_IS_HORIZONTAL_STREAM, RoomState.EXTRA_BOOL_IS_LANDSCAPE_NEW_STYLE, RoomState.EXTRA_BOOL_IS_TOOLBAR_EQUAL_CART, RoomState.EXTRA_BOOL_ROOM_FORBID_COMMERCE_CARD, RoomState.EXTRA_BOOL_ROOM_HAS_CART_INFO, RoomState.EXTRA_BOOL_ROOM_HAS_COMMERCE, RoomState.EXTRA_BOOL_ROOM_HAS_COMMERCE_LOTTERY, RoomState.EXTRA_BOOL_ROOM_HAS_GROUP_PURCHASE_PERMISSION, RoomState.EXTRA_BOOL_ROOM_HAS_INIT_GOOD, RoomState.EXTRA_BOOL_SLIDED_IN_VIEW_PAGER, "EXTRA_DATA_ENTER_LOCALLIFT_LIVE_ENV_PARAMS", "EXTRA_DATA_ENTER_LOCALLIFT_LIVE_PARAMS", "EXTRA_DATA_ENTER_ROOM_OPEN_GAME_DETAIL", "EXTRA_ENTER_REQUEST", RoomState.EXTRA_INT_BUSINESS_SHOW_WINDMILL, RoomState.EXTRA_INT_FLASH_SHOPPING_GOOD, RoomState.EXTRA_INT_SHOW_CART, RoomState.EXTRA_INT_TOTAL_SHOPPING_GOOD, RoomState.EXTRA_IS_D_ROOM, RoomState.EXTRA_IS_FIRST_ROOM, RoomState.EXTRA_IS_ROOM_VISIBLE, RoomState.EXTRA_JSON_STR_ACTIVITY_TRANSMISSION, RoomState.EXTRA_LONG_COMMERCE_CARD, RoomState.EXTRA_MAP_CART_HORIZONTAL, RoomState.EXTRA_MAP_CART_STYLE, RoomState.EXTRA_MAP_CART_VERTICAL, RoomState.EXTRA_ROOM_DRAW_INDEX, RoomState.EXTRA_STRING_CART_ICON, "EXTRA_STRING_ROOM_ENTER_LOG_ID", "ITEM_TYPE_ROOM", "", "ITEM_TYPE_VS_FIRST_SHOW", "ITEM_TYPE_VS_ROOM", "ITEM_TYPE_VS_VIDEO", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final Room convert() {
        Room r100 = new Room();
        Long r101 = StringsKt.toLongOrNull(getRoomId());
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L6:
        r100.f162599id = r102;
        r100.setOwnerUserIdString(getRoomAnchorId());
        r100.setRequestId(getRequestId());
        r100.setLog_pb(getLogPb());
        r100.setTitle(getTitle());
        r100.setStreamUrl(getStreamUrl());
        return r100;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public /* bridge */ /* synthetic */ k getCartIcon() {
        return getCartIcon();
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public /* bridge */ /* synthetic */ k getContentLabel() {
        return getContentLabel();
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public /* bridge */ /* synthetic */ k getCover() {
        return getCover();
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean getHasViewRight() {
        return getHasViewRightFunc().invoke().booleanValue();
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public /* bridge */ /* synthetic */ k getLandscapeCartIcon() {
        return getLandscapeCartIcon();
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public /* bridge */ /* synthetic */ IBaseStreamUrl getStreamUrl() {
        return getStreamUrl();
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean isKtv() {
        return isKtvFun().invoke().booleanValue();
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean isLogin() {
        return isLoginFunc().invoke().booleanValue();
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean isRoomVisible() {
        return isRoomVisibleFunc().invoke().booleanValue();
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public Map<String, String> getAdLiveParams() {
        return this.adLiveParams;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public String getAnchorFollowerCount() {
        return this.anchorFollowerCount;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public String getAnchorLocation() {
        return this.anchorLocation;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public String getAnchorName() {
        return this.anchorName;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean getEnterFromSpecialAd() {
        return this.enterFromSpecialAd;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public Map<String, String> getEnterRoomParams() {
        return this.enterRoomParams;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public long getEpisodeId() {
        return this.episodeId;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public Bundle getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public Function0<Boolean> getHasViewRightFunc() {
        return this.hasViewRightFunc;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public int getInstantType() {
        return this.instantType;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public int getIntroType() {
        return this.introType;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public int getItemType() {
        return this.itemType;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public int getLiveSdkVersion() {
        return this.liveSdkVersion;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public String getLogPb() {
        return this.logPb;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public Function0<Integer> getPanelHeight() {
        return this.panelHeight;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public Map<String, String> getReportParams() {
        return this.reportParams;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public String getRequestId() {
        return this.requestId;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public String getRoomAnchorId() {
        return this.roomAnchorId;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public String getRoomAnchorSecId() {
        return this.roomAnchorSecId;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public String getRoomId() {
        return this.roomId;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public String getRouteRule() {
        return this.routeRule;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public int getStreamType() {
        return this.streamType;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public String getTitle() {
        return this.title;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public String getViewCount() {
        return this.viewCount;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean isAnchor() {
        return this.isAnchor;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean isFollowed() {
        return this.isFollowed;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean isGameRoom() {
        return this.isGameRoom;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean isInInteractionGame() {
        return this.isInInteractionGame;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public Function0<Boolean> isInInteractionGameFun() {
        return this.isInInteractionGameFun;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean isInPreview() {
        return this.isInPreview;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public Function0<Boolean> isKtvFun() {
        return this.isKtvFun;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public Function0<Boolean> isLoginFunc() {
        return this.isLoginFunc;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean isPortrait() {
        return this.isPortrait;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean isReplayOpen() {
        return this.isReplayOpen;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public Function0<Boolean> isRoomVisibleFunc() {
        return this.isRoomVisibleFunc;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public boolean isVerticalVideo() {
        return this.isVerticalVideo;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public ImageModel getCartIcon() {
        return this.cartIcon;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public ImageModel getContentLabel() {
        return this.contentLabel;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public ImageModel getCover() {
        return this.cover;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public ImageModel getLandscapeCartIcon() {
        return this.landscapeCartIcon;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public StreamUrl getStreamUrl() {
        return this.streamUrl;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public void setEpisodeId(long r100) {
        this.episodeId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public void setGameRoom(boolean r100) {
        this.isGameRoom = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public void setInPreview(boolean r100) {
        this.isInPreview = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public void setInstantType(int r100) {
        this.instantType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public void setIntroType(int r100) {
        this.introType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public void setRouteRule(String r100) {
        this.routeRule = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.state.IRoomState
    public void setVerticalVideo(boolean r100) {
        this.isVerticalVideo = r100;
    }

    public RoomState(int r110, boolean r111, boolean r112, String r210, String r211, String r212, boolean r213, boolean r214, Function0<Boolean> r215, Function0<Boolean> r216, Function0<Boolean> r217, int r218, Map<String, String> r219, Bundle r310, int r311, Map<String, String> r312, Function0<Boolean> r313, Function0<Boolean> r314, Function0<Integer> r315, ImageModel r316, ImageModel r317, String r318, String r319, String r410, String r411, ImageModel r412, StreamUrl r413, String r414, String r415, ImageModel r416, String r417, boolean r418, Map<String, String> r419) {
        Intrinsics.checkNotNullParameter(r210, "roomId");
        Intrinsics.checkNotNullParameter(r211, "roomAnchorId");
        Intrinsics.checkNotNullParameter(r212, "roomAnchorSecId");
        Intrinsics.checkNotNullParameter(r215, "isLoginFunc");
        Intrinsics.checkNotNullParameter(r216, "hasViewRightFunc");
        Intrinsics.checkNotNullParameter(r217, "isRoomVisibleFunc");
        Intrinsics.checkNotNullParameter(r219, "reportParams");
        Intrinsics.checkNotNullParameter(r310, "extra");
        Intrinsics.checkNotNullParameter(r312, "enterRoomParams");
        Intrinsics.checkNotNullParameter(r313, "isKtvFun");
        Intrinsics.checkNotNullParameter(r314, "isInInteractionGameFun");
        Intrinsics.checkNotNullParameter(r315, "panelHeight");
        Intrinsics.checkNotNullParameter(r410, "anchorName");
        Intrinsics.checkNotNullParameter(r419, "adLiveParams");
        this.itemType = r110;
        this.isAnchor = r111;
        this.isPortrait = r112;
        this.roomId = r210;
        this.roomAnchorId = r211;
        this.roomAnchorSecId = r212;
        this.isFollowed = r213;
        this.isReplayOpen = r214;
        this.isLoginFunc = r215;
        this.hasViewRightFunc = r216;
        this.isRoomVisibleFunc = r217;
        this.streamType = r218;
        this.reportParams = r219;
        this.extra = r310;
        this.liveSdkVersion = r311;
        this.enterRoomParams = r312;
        this.isKtvFun = r313;
        this.isInInteractionGameFun = r314;
        this.panelHeight = r315;
        this.cartIcon = r316;
        this.landscapeCartIcon = r317;
        this.requestId = r318;
        this.logPb = r319;
        this.anchorName = r410;
        this.title = r411;
        this.cover = r412;
        this.streamUrl = r413;
        this.viewCount = r414;
        this.anchorFollowerCount = r415;
        this.contentLabel = r416;
        this.anchorLocation = r417;
        this.enterFromSpecialAd = r418;
        this.adLiveParams = r419;
        this.isInInteractionGame = isInInteractionGameFun().invoke().booleanValue();
    }
}
