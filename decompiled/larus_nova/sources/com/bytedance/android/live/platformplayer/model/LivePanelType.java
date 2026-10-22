package com.bytedance.android.live.platformplayer.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/platformplayer/model/LivePanelType;", "", "", LocationMonitorConst.IDENTIFIER, "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "UN_KNOW", "AUDIENCE_LIST", "HOUR_RANK_LIST", "TOOL_BAR_MORE", "GIFT", "PERSONAL_PROFILE", "INPUT", "SHOPPING_CAT", "SHOPPING_CARD", "SHOPPING_RANK_LIST", "OLD_LONG_PRESS", "RECOGNITION_CONTAINER", "LOCAL_LIFE_LIST", "GAME_DETAIL", "LOTTERY", "PREDICTOR", "WINDMILL", "platform-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePanelType extends Enum<LivePanelType> {
    public static final LivePanelType AUDIENCE_LIST = null;
    public static final LivePanelType GAME_DETAIL = null;
    public static final LivePanelType GIFT = null;
    public static final LivePanelType HOUR_RANK_LIST = null;
    public static final LivePanelType INPUT = null;
    public static final LivePanelType LOCAL_LIFE_LIST = null;
    public static final LivePanelType LOTTERY = null;
    public static final LivePanelType OLD_LONG_PRESS = null;
    public static final LivePanelType PERSONAL_PROFILE = null;
    public static final LivePanelType PREDICTOR = null;
    public static final LivePanelType RECOGNITION_CONTAINER = null;
    public static final LivePanelType SHOPPING_CARD = null;
    public static final LivePanelType SHOPPING_CAT = null;
    public static final LivePanelType SHOPPING_RANK_LIST = null;
    public static final LivePanelType TOOL_BAR_MORE = null;
    public static final LivePanelType UN_KNOW = null;
    public static final LivePanelType WINDMILL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LivePanelType[] f85722a = null;
    private final String identifier;

    public static LivePanelType valueOf(String r100) {
        return (LivePanelType) a.a(LivePanelType.class, r100);
    }

    public static LivePanelType[] values() {
        return (LivePanelType[]) f85722a.clone();
    }

    static {
        LivePanelType r100 = new LivePanelType("UN_KNOW", 0, "un_know");
        UN_KNOW = r100;
        LivePanelType r101 = new LivePanelType("AUDIENCE_LIST", 1, "audience_list");
        AUDIENCE_LIST = r101;
        LivePanelType r102 = new LivePanelType("HOUR_RANK_LIST", 2, "hour_ranklist");
        HOUR_RANK_LIST = r102;
        LivePanelType r103 = new LivePanelType("TOOL_BAR_MORE", 3, "live_more_tools_panel");
        TOOL_BAR_MORE = r103;
        LivePanelType r104 = new LivePanelType("GIFT", 4, "live_send_gift_panel");
        GIFT = r104;
        LivePanelType r105 = new LivePanelType("PERSONAL_PROFILE", 5, "live_user_card_panel");
        PERSONAL_PROFILE = r105;
        LivePanelType r106 = new LivePanelType("INPUT", 6, "live_comment_board");
        INPUT = r106;
        LivePanelType r107 = new LivePanelType("SHOPPING_CAT", 7, "live_goods_list");
        SHOPPING_CAT = r107;
        LivePanelType r108 = new LivePanelType("SHOPPING_CARD", 8, "live_explain_card");
        SHOPPING_CARD = r108;
        LivePanelType r109 = new LivePanelType("SHOPPING_RANK_LIST", 9, "shopping_rank_list");
        SHOPPING_RANK_LIST = r109;
        LivePanelType r110 = new LivePanelType("OLD_LONG_PRESS", 10, com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK);
        OLD_LONG_PRESS = r110;
        LivePanelType r111 = new LivePanelType("RECOGNITION_CONTAINER", 11, "live_recognition_container");
        RECOGNITION_CONTAINER = r111;
        LivePanelType r112 = new LivePanelType("LOCAL_LIFE_LIST", 12, "local_life_list");
        LOCAL_LIFE_LIST = r112;
        LivePanelType r113 = new LivePanelType("GAME_DETAIL", 13, "game_detail");
        GAME_DETAIL = r113;
        LivePanelType r114 = new LivePanelType("LOTTERY", 14, "lottery");
        LOTTERY = r114;
        LivePanelType r115 = new LivePanelType("PREDICTOR", 15, "predictor");
        PREDICTOR = r115;
        LivePanelType r116 = new LivePanelType("WINDMILL", 16, "windmill");
        WINDMILL = r116;
        f85722a = new LivePanelType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116};
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public LivePanelType(String r100, int r101, String r102) {
        super(r100, r101);
        this.identifier = r102;
    }
}
