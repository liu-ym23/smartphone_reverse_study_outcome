package com.bytedance.android.livesdk.revenue.log;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/log/LogCommon;", "", "ROOM", "LIVE_SHARE_LOG", "PAGE_SOURCE_LOG", "FOLLOW_LOG", "RECOMMEND_SOURCE_LOG", "LIVE_END_PAGE_LOG", "DRAWER_LOG", "LIVE_AD_LOG", "GAME_PARAM_ITEM", "LIVE_SEARCH_LOG", "LINKMIC_SCENE_DATA", "REMOVE_STAGING_FLAG_LOG", "PAD_DATA_LOG", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LogCommon extends Enum<LogCommon> {
    public static final LogCommon DRAWER_LOG = null;
    public static final LogCommon FOLLOW_LOG = null;
    public static final LogCommon GAME_PARAM_ITEM = null;
    public static final LogCommon LINKMIC_SCENE_DATA = null;
    public static final LogCommon LIVE_AD_LOG = null;
    public static final LogCommon LIVE_END_PAGE_LOG = null;
    public static final LogCommon LIVE_SEARCH_LOG = null;
    public static final LogCommon LIVE_SHARE_LOG = null;
    public static final LogCommon PAD_DATA_LOG = null;
    public static final LogCommon PAGE_SOURCE_LOG = null;
    public static final LogCommon RECOMMEND_SOURCE_LOG = null;
    public static final LogCommon REMOVE_STAGING_FLAG_LOG = null;
    public static final LogCommon ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogCommon[] f157170a = null;

    static {
        LogCommon r100 = new LogCommon("ROOM", 0);
        ROOM = r100;
        LogCommon r101 = new LogCommon("LIVE_SHARE_LOG", 1);
        LIVE_SHARE_LOG = r101;
        LogCommon r102 = new LogCommon("PAGE_SOURCE_LOG", 2);
        PAGE_SOURCE_LOG = r102;
        LogCommon r103 = new LogCommon("FOLLOW_LOG", 3);
        FOLLOW_LOG = r103;
        LogCommon r104 = new LogCommon("RECOMMEND_SOURCE_LOG", 4);
        RECOMMEND_SOURCE_LOG = r104;
        LogCommon r105 = new LogCommon("LIVE_END_PAGE_LOG", 5);
        LIVE_END_PAGE_LOG = r105;
        LogCommon r106 = new LogCommon("DRAWER_LOG", 6);
        DRAWER_LOG = r106;
        LogCommon r107 = new LogCommon("LIVE_AD_LOG", 7);
        LIVE_AD_LOG = r107;
        LogCommon r108 = new LogCommon("GAME_PARAM_ITEM", 8);
        GAME_PARAM_ITEM = r108;
        LogCommon r109 = new LogCommon("LIVE_SEARCH_LOG", 9);
        LIVE_SEARCH_LOG = r109;
        LogCommon r110 = new LogCommon("LINKMIC_SCENE_DATA", 10);
        LINKMIC_SCENE_DATA = r110;
        LogCommon r111 = new LogCommon("REMOVE_STAGING_FLAG_LOG", 11);
        REMOVE_STAGING_FLAG_LOG = r111;
        LogCommon r112 = new LogCommon("PAD_DATA_LOG", 12);
        PAD_DATA_LOG = r112;
        f157170a = new LogCommon[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public static LogCommon valueOf(String r100) {
        return (LogCommon) r27.a.a(LogCommon.class, r100);
    }

    public static LogCommon[] values() {
        return (LogCommon[]) f157170a.clone();
    }

    public LogCommon(String r100, int r101) {
        super(r100, r101);
    }
}
