package com.bytedance.android.livesdk.vscore_api.paid;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/paid/PaidSceneViewEntry;", "", "", "isPreview", "isInRoom", "isReplay", "isAnchor", "isSearchLive", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "UNKNOWN", "IN_ROOM", "FEED_PREVIEW", "IM", "PROFILE_CARD", "GENERAL_SEARCH", "SEARCH_LIVE", "ML_VIDEO", "LVIDEO_THEATER", FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, "LYNX", "REPLAY_IN_ROOM", "REPLAY_SEARCH", "REPLAY_ML_VIDEO", "REPLAY_LVIDEO_THEATER", "REPLAY_LYNX_VIEW", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PaidSceneViewEntry extends Enum<PaidSceneViewEntry> {
    public static final PaidSceneViewEntry ANCHOR = null;
    public static final PaidSceneViewEntry FEED_PREVIEW = null;
    public static final PaidSceneViewEntry GENERAL_SEARCH = null;
    public static final PaidSceneViewEntry IM = null;
    public static final PaidSceneViewEntry IN_ROOM = null;
    public static final PaidSceneViewEntry LVIDEO_THEATER = null;
    public static final PaidSceneViewEntry LYNX = null;
    public static final PaidSceneViewEntry ML_VIDEO = null;
    public static final PaidSceneViewEntry PROFILE_CARD = null;
    public static final PaidSceneViewEntry REPLAY_IN_ROOM = null;
    public static final PaidSceneViewEntry REPLAY_LVIDEO_THEATER = null;
    public static final PaidSceneViewEntry REPLAY_LYNX_VIEW = null;
    public static final PaidSceneViewEntry REPLAY_ML_VIDEO = null;
    public static final PaidSceneViewEntry REPLAY_SEARCH = null;
    public static final PaidSceneViewEntry SEARCH_LIVE = null;
    public static final PaidSceneViewEntry UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PaidSceneViewEntry[] f159402a = null;
    private final String desc;

    public static PaidSceneViewEntry valueOf(String r100) {
        return (PaidSceneViewEntry) a.a(PaidSceneViewEntry.class, r100);
    }

    public static PaidSceneViewEntry[] values() {
        return (PaidSceneViewEntry[]) f159402a.clone();
    }

    public final boolean isReplay() {
        return ArraysKt.contains(new PaidSceneViewEntry[]{REPLAY_IN_ROOM, REPLAY_SEARCH, REPLAY_ML_VIDEO, REPLAY_LVIDEO_THEATER, REPLAY_LYNX_VIEW}, this);
    }

    static {
        PaidSceneViewEntry r100 = new PaidSceneViewEntry("UNKNOWN", 0, PlayerResolution.NAME.UNKNOWN);
        UNKNOWN = r100;
        PaidSceneViewEntry r101 = new PaidSceneViewEntry("IN_ROOM", 1, "房间内");
        IN_ROOM = r101;
        PaidSceneViewEntry r102 = new PaidSceneViewEntry("FEED_PREVIEW", 2, "feed预览流");
        FEED_PREVIEW = r102;
        PaidSceneViewEntry r103 = new PaidSceneViewEntry("IM", 3, "IM分享");
        IM = r103;
        PaidSceneViewEntry r104 = new PaidSceneViewEntry("PROFILE_CARD", 4, "个人页大卡");
        PROFILE_CARD = r104;
        PaidSceneViewEntry r105 = new PaidSceneViewEntry("GENERAL_SEARCH", 5, "综搜");
        GENERAL_SEARCH = r105;
        PaidSceneViewEntry r106 = new PaidSceneViewEntry("SEARCH_LIVE", 6, "垂搜直播tab");
        SEARCH_LIVE = r106;
        PaidSceneViewEntry r107 = new PaidSceneViewEntry("ML_VIDEO", 7, "长视频tab");
        ML_VIDEO = r107;
        PaidSceneViewEntry r108 = new PaidSceneViewEntry("LVIDEO_THEATER", 8, "放映厅");
        LVIDEO_THEATER = r108;
        PaidSceneViewEntry r109 = new PaidSceneViewEntry(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, 9, "主播付费开播");
        ANCHOR = r109;
        PaidSceneViewEntry r110 = new PaidSceneViewEntry("LYNX", 10, "直播播放器lynx组件");
        LYNX = r110;
        PaidSceneViewEntry r111 = new PaidSceneViewEntry("REPLAY_IN_ROOM", 11, "回放房间内");
        REPLAY_IN_ROOM = r111;
        PaidSceneViewEntry r112 = new PaidSceneViewEntry("REPLAY_SEARCH", 12, "回放搜索");
        REPLAY_SEARCH = r112;
        PaidSceneViewEntry r113 = new PaidSceneViewEntry("REPLAY_ML_VIDEO", 13, "回放长视频tab");
        REPLAY_ML_VIDEO = r113;
        PaidSceneViewEntry r114 = new PaidSceneViewEntry("REPLAY_LVIDEO_THEATER", 14, "回放放映厅");
        REPLAY_LVIDEO_THEATER = r114;
        PaidSceneViewEntry r115 = new PaidSceneViewEntry("REPLAY_LYNX_VIEW", 15, "回放Lynx View");
        REPLAY_LYNX_VIEW = r115;
        f159402a = new PaidSceneViewEntry[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115};
    }

    public final boolean isAnchor() {
        if (this != ANCHOR) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isInRoom() {
        if (this != IN_ROOM) goto L5;
    L8:
        return true;
    L5:
        if (this == REPLAY_IN_ROOM) goto L8;
        return false;
    }

    public final boolean isPreview() {
        return ArraysKt.contains(new PaidSceneViewEntry[]{FEED_PREVIEW, IM, PROFILE_CARD, GENERAL_SEARCH, SEARCH_LIVE, ML_VIDEO, LYNX, LVIDEO_THEATER, REPLAY_SEARCH, REPLAY_ML_VIDEO, REPLAY_LVIDEO_THEATER, REPLAY_LYNX_VIEW}, this);
    }

    public final boolean isSearchLive() {
        if (this != GENERAL_SEARCH) goto L5;
    L8:
        return true;
    L5:
        if (this == SEARCH_LIVE) goto L8;
        return false;
    }

    public final String getDesc() {
        return this.desc;
    }

    public PaidSceneViewEntry(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
