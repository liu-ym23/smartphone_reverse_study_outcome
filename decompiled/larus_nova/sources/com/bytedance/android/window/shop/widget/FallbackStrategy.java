package com.bytedance.android.window.shop.widget;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/widget/FallbackStrategy;", "", "REPLACE", "REMOVE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FallbackStrategy extends Enum<FallbackStrategy> {
    public static final FallbackStrategy REMOVE = null;
    public static final FallbackStrategy REPLACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FallbackStrategy[] f189853a = null;

    static {
        FallbackStrategy r100 = new FallbackStrategy("REPLACE", 0);
        REPLACE = r100;
        FallbackStrategy r101 = new FallbackStrategy("REMOVE", 1);
        REMOVE = r101;
        f189853a = new FallbackStrategy[]{r100, r101};
    }

    public static FallbackStrategy valueOf(String r100) {
        return (FallbackStrategy) r27.a.a(FallbackStrategy.class, r100);
    }

    public static FallbackStrategy[] values() {
        return (FallbackStrategy[]) f189853a.clone();
    }

    public FallbackStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
