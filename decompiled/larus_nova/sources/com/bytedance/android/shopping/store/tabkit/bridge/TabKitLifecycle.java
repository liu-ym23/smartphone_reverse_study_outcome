package com.bytedance.android.shopping.store.tabkit.bridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitLifecycle;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "TTI_READY", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabKitLifecycle extends Enum<TabKitLifecycle> {
    public static final TabKitLifecycle TTI_READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabKitLifecycle[] f186605a = null;
    private final String type;

    static {
        TabKitLifecycle r100 = new TabKitLifecycle();
        TTI_READY = r100;
        f186605a = new TabKitLifecycle[]{r100};
    }

    public static TabKitLifecycle valueOf(String r100) {
        return (TabKitLifecycle) r27.a.a(TabKitLifecycle.class, r100);
    }

    public static TabKitLifecycle[] values() {
        return (TabKitLifecycle[]) f186605a.clone();
    }

    public TabKitLifecycle() {
        super("TTI_READY", 0);
        this.type = "tti_ready";
    }

    public final String getType() {
        return this.type;
    }
}
