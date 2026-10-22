package com.bytedance.android.livesdkapi.feed.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/constant/FeedStyle;", "", "(Ljava/lang/String;I)V", "DOUBLE_LIST_D", "SIMPLE_LIST", "SINGLE_LIST_H", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeedStyle extends Enum<FeedStyle> {
    private static final /* synthetic */ FeedStyle[] $VALUES = null;
    public static final FeedStyle DOUBLE_LIST_D = null;
    public static final FeedStyle SIMPLE_LIST = null;
    public static final FeedStyle SINGLE_LIST_H = null;

    static {
        FeedStyle r100 = new FeedStyle("DOUBLE_LIST_D", 0);
        DOUBLE_LIST_D = r100;
        FeedStyle r101 = new FeedStyle("SIMPLE_LIST", 1);
        SIMPLE_LIST = r101;
        FeedStyle r102 = new FeedStyle("SINGLE_LIST_H", 2);
        SINGLE_LIST_H = r102;
        $VALUES = new FeedStyle[]{r100, r101, r102};
    }

    public static FeedStyle valueOf(String r100) {
        return (FeedStyle) a.a(FeedStyle.class, r100);
    }

    public static FeedStyle[] values() {
        return (FeedStyle[]) $VALUES.clone();
    }

    private FeedStyle(String r100, int r101) {
        super(r100, r101);
    }
}
