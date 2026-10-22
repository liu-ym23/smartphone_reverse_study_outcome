package com.bytedance.android.shopping.orderlist.common.widgets.bubble;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/bubble/BubbleOrientation;", "", "TOP", "BOTTOM", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BubbleOrientation extends Enum<BubbleOrientation> {
    public static final BubbleOrientation BOTTOM = null;
    public static final BubbleOrientation TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleOrientation[] f179992a = null;

    static {
        BubbleOrientation r100 = new BubbleOrientation("TOP", 0);
        TOP = r100;
        BubbleOrientation r101 = new BubbleOrientation("BOTTOM", 1);
        BOTTOM = r101;
        f179992a = new BubbleOrientation[]{r100, r101};
    }

    public static BubbleOrientation valueOf(String r100) {
        return (BubbleOrientation) r27.a.a(BubbleOrientation.class, r100);
    }

    public static BubbleOrientation[] values() {
        return (BubbleOrientation[]) f179992a.clone();
    }

    public BubbleOrientation(String r100, int r101) {
        super(r100, r101);
    }
}
