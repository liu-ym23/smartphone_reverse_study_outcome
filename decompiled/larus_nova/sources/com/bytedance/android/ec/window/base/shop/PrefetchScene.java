package com.bytedance.android.ec.window.base.shop;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/PrefetchScene;", "", "WINDOW", "TABKIT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PrefetchScene extends Enum<PrefetchScene> {
    public static final PrefetchScene TABKIT = null;
    public static final PrefetchScene WINDOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrefetchScene[] f49586a = null;

    static {
        PrefetchScene r100 = new PrefetchScene("WINDOW", 0);
        WINDOW = r100;
        PrefetchScene r101 = new PrefetchScene("TABKIT", 1);
        TABKIT = r101;
        f49586a = new PrefetchScene[]{r100, r101};
    }

    public static PrefetchScene valueOf(String r100) {
        return (PrefetchScene) r27.a.a(PrefetchScene.class, r100);
    }

    public static PrefetchScene[] values() {
        return (PrefetchScene[]) f49586a.clone();
    }

    public PrefetchScene(String r100, int r101) {
        super(r100, r101);
    }
}
