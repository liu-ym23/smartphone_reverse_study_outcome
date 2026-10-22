package com.bytedance.android.shopping.api.mall.feed;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/feed/ECMallFeedState;", "", "PREPARING", "PREPARE_SUCCESS", "PREPARE_FAILED", "INITIALIZING", "INIT_WITH_CACHE_SUCCESS", "INIT_DATA_PREPARED", "FIRST_SCREEN_LYNX_END", "INIT_SUCCESS", "INIT_FAILED", "REFRESHING", "REFRESH_DATA_PREPARED", "REFRESH_SUCCESS", "REFRESH_FAILED", "LOADING_MORE", "LOAD_MORE_SUCCESS", "LOAD_MORE_FAILED", "NO_MORE", "LOAD_BY_USER_BEHAVIOR", "LOAD_BY_USER_BEHAVIOR_SUCCESS", "LOAD_BY_USER_BEHAVIOR_FAILED", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECMallFeedState extends Enum<ECMallFeedState> {
    public static final ECMallFeedState FIRST_SCREEN_LYNX_END = null;
    public static final ECMallFeedState INITIALIZING = null;
    public static final ECMallFeedState INIT_DATA_PREPARED = null;
    public static final ECMallFeedState INIT_FAILED = null;
    public static final ECMallFeedState INIT_SUCCESS = null;
    public static final ECMallFeedState INIT_WITH_CACHE_SUCCESS = null;
    public static final ECMallFeedState LOADING_MORE = null;
    public static final ECMallFeedState LOAD_BY_USER_BEHAVIOR = null;
    public static final ECMallFeedState LOAD_BY_USER_BEHAVIOR_FAILED = null;
    public static final ECMallFeedState LOAD_BY_USER_BEHAVIOR_SUCCESS = null;
    public static final ECMallFeedState LOAD_MORE_FAILED = null;
    public static final ECMallFeedState LOAD_MORE_SUCCESS = null;
    public static final ECMallFeedState NO_MORE = null;
    public static final ECMallFeedState PREPARE_FAILED = null;
    public static final ECMallFeedState PREPARE_SUCCESS = null;
    public static final ECMallFeedState PREPARING = null;
    public static final ECMallFeedState REFRESHING = null;
    public static final ECMallFeedState REFRESH_DATA_PREPARED = null;
    public static final ECMallFeedState REFRESH_FAILED = null;
    public static final ECMallFeedState REFRESH_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECMallFeedState[] f170501a = null;

    static {
        ECMallFeedState r100 = new ECMallFeedState("PREPARING", 0);
        PREPARING = r100;
        ECMallFeedState r101 = new ECMallFeedState("PREPARE_SUCCESS", 1);
        PREPARE_SUCCESS = r101;
        ECMallFeedState r102 = new ECMallFeedState("PREPARE_FAILED", 2);
        PREPARE_FAILED = r102;
        ECMallFeedState r103 = new ECMallFeedState("INITIALIZING", 3);
        INITIALIZING = r103;
        ECMallFeedState r104 = new ECMallFeedState("INIT_WITH_CACHE_SUCCESS", 4);
        INIT_WITH_CACHE_SUCCESS = r104;
        ECMallFeedState r105 = new ECMallFeedState("INIT_DATA_PREPARED", 5);
        INIT_DATA_PREPARED = r105;
        ECMallFeedState r106 = new ECMallFeedState("FIRST_SCREEN_LYNX_END", 6);
        FIRST_SCREEN_LYNX_END = r106;
        ECMallFeedState r107 = new ECMallFeedState("INIT_SUCCESS", 7);
        INIT_SUCCESS = r107;
        ECMallFeedState r108 = new ECMallFeedState("INIT_FAILED", 8);
        INIT_FAILED = r108;
        ECMallFeedState r109 = new ECMallFeedState("REFRESHING", 9);
        REFRESHING = r109;
        ECMallFeedState r110 = new ECMallFeedState("REFRESH_DATA_PREPARED", 10);
        REFRESH_DATA_PREPARED = r110;
        ECMallFeedState r111 = new ECMallFeedState("REFRESH_SUCCESS", 11);
        REFRESH_SUCCESS = r111;
        ECMallFeedState r112 = new ECMallFeedState("REFRESH_FAILED", 12);
        REFRESH_FAILED = r112;
        ECMallFeedState r113 = new ECMallFeedState("LOADING_MORE", 13);
        LOADING_MORE = r113;
        ECMallFeedState r114 = new ECMallFeedState("LOAD_MORE_SUCCESS", 14);
        LOAD_MORE_SUCCESS = r114;
        ECMallFeedState r115 = new ECMallFeedState("LOAD_MORE_FAILED", 15);
        LOAD_MORE_FAILED = r115;
        ECMallFeedState r116 = new ECMallFeedState("NO_MORE", 16);
        NO_MORE = r116;
        ECMallFeedState r117 = new ECMallFeedState("LOAD_BY_USER_BEHAVIOR", 17);
        LOAD_BY_USER_BEHAVIOR = r117;
        ECMallFeedState r118 = new ECMallFeedState("LOAD_BY_USER_BEHAVIOR_SUCCESS", 18);
        LOAD_BY_USER_BEHAVIOR_SUCCESS = r118;
        ECMallFeedState r119 = new ECMallFeedState("LOAD_BY_USER_BEHAVIOR_FAILED", 19);
        LOAD_BY_USER_BEHAVIOR_FAILED = r119;
        f170501a = new ECMallFeedState[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119};
    }

    public static ECMallFeedState valueOf(String r100) {
        return (ECMallFeedState) r27.a.a(ECMallFeedState.class, r100);
    }

    public static ECMallFeedState[] values() {
        return (ECMallFeedState[]) f170501a.clone();
    }

    public ECMallFeedState(String r100, int r101) {
        super(r100, r101);
    }
}
