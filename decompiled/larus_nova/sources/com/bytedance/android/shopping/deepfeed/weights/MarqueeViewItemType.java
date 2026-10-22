package com.bytedance.android.shopping.deepfeed.weights;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/MarqueeViewItemType;", "", "HAS_COUNTDOWN_VIEW", "HAS_QCPX_VIEW", "TWO_REC_REASON_VIEW", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MarqueeViewItemType extends Enum<MarqueeViewItemType> {
    public static final MarqueeViewItemType HAS_COUNTDOWN_VIEW = null;
    public static final MarqueeViewItemType HAS_QCPX_VIEW = null;
    public static final MarqueeViewItemType TWO_REC_REASON_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MarqueeViewItemType[] f174140a = null;

    static {
        MarqueeViewItemType r100 = new MarqueeViewItemType("HAS_COUNTDOWN_VIEW", 0);
        HAS_COUNTDOWN_VIEW = r100;
        MarqueeViewItemType r101 = new MarqueeViewItemType("HAS_QCPX_VIEW", 1);
        HAS_QCPX_VIEW = r101;
        MarqueeViewItemType r102 = new MarqueeViewItemType("TWO_REC_REASON_VIEW", 2);
        TWO_REC_REASON_VIEW = r102;
        f174140a = new MarqueeViewItemType[]{r100, r101, r102};
    }

    public static MarqueeViewItemType valueOf(String r100) {
        return (MarqueeViewItemType) r27.a.a(MarqueeViewItemType.class, r100);
    }

    public static MarqueeViewItemType[] values() {
        return (MarqueeViewItemType[]) f174140a.clone();
    }

    public MarqueeViewItemType(String r100, int r101) {
        super(r100, r101);
    }
}
