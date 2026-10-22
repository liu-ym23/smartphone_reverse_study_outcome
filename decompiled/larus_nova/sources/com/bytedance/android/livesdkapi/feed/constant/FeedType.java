package com.bytedance.android.livesdkapi.feed.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/constant/FeedType;", "", "(Ljava/lang/String;I)V", "COMMON_FEED", "FOLLOW_FEED", "HOT_FEED", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeedType extends Enum<FeedType> {
    private static final /* synthetic */ FeedType[] $VALUES = null;
    public static final FeedType COMMON_FEED = null;
    public static final FeedType FOLLOW_FEED = null;
    public static final FeedType HOT_FEED = null;

    static {
        FeedType r100 = new FeedType("COMMON_FEED", 0);
        COMMON_FEED = r100;
        FeedType r101 = new FeedType("FOLLOW_FEED", 1);
        FOLLOW_FEED = r101;
        FeedType r102 = new FeedType("HOT_FEED", 2);
        HOT_FEED = r102;
        $VALUES = new FeedType[]{r100, r101, r102};
    }

    public static FeedType valueOf(String r100) {
        return (FeedType) a.a(FeedType.class, r100);
    }

    public static FeedType[] values() {
        return (FeedType[]) $VALUES.clone();
    }

    private FeedType(String r100, int r101) {
        super(r100, r101);
    }
}
