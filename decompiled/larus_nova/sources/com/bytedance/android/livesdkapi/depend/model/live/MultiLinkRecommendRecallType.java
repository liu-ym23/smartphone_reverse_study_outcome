package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MultiLinkRecommendRecallType;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "LINKMIC", "LIVE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkRecommendRecallType extends Enum<MultiLinkRecommendRecallType> {
    private static final /* synthetic */ MultiLinkRecommendRecallType[] $VALUES = null;
    public static final MultiLinkRecommendRecallType LINKMIC = null;
    public static final MultiLinkRecommendRecallType LIVE = null;
    public static final MultiLinkRecommendRecallType UNKNOWN = null;

    static {
        MultiLinkRecommendRecallType r100 = new MultiLinkRecommendRecallType("UNKNOWN", 0);
        UNKNOWN = r100;
        MultiLinkRecommendRecallType r101 = new MultiLinkRecommendRecallType("LINKMIC", 1);
        LINKMIC = r101;
        MultiLinkRecommendRecallType r102 = new MultiLinkRecommendRecallType("LIVE", 2);
        LIVE = r102;
        $VALUES = new MultiLinkRecommendRecallType[]{r100, r101, r102};
    }

    public static MultiLinkRecommendRecallType valueOf(String r100) {
        return (MultiLinkRecommendRecallType) a.a(MultiLinkRecommendRecallType.class, r100);
    }

    public static MultiLinkRecommendRecallType[] values() {
        return (MultiLinkRecommendRecallType[]) $VALUES.clone();
    }

    private MultiLinkRecommendRecallType(String r100, int r101) {
        super(r100, r101);
    }
}
