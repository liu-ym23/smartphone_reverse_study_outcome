package com.bytedance.android.ec.store.common.bubble;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/store/common/bubble/BubbleShowStrategy;", "", "ONLY_ONE_ONCE", "ALL_ONCE", "ONE_BY_ONE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BubbleShowStrategy extends Enum<BubbleShowStrategy> {
    public static final BubbleShowStrategy ALL_ONCE = null;
    public static final BubbleShowStrategy ONE_BY_ONE = null;
    public static final BubbleShowStrategy ONLY_ONE_ONCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleShowStrategy[] f48204a = null;

    static {
        BubbleShowStrategy r100 = new BubbleShowStrategy("ONLY_ONE_ONCE", 0);
        ONLY_ONE_ONCE = r100;
        BubbleShowStrategy r101 = new BubbleShowStrategy("ALL_ONCE", 1);
        ALL_ONCE = r101;
        BubbleShowStrategy r102 = new BubbleShowStrategy("ONE_BY_ONE", 2);
        ONE_BY_ONE = r102;
        f48204a = new BubbleShowStrategy[]{r100, r101, r102};
    }

    public static BubbleShowStrategy valueOf(String r100) {
        return (BubbleShowStrategy) r27.a.a(BubbleShowStrategy.class, r100);
    }

    public static BubbleShowStrategy[] values() {
        return (BubbleShowStrategy[]) f48204a.clone();
    }

    public BubbleShowStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
