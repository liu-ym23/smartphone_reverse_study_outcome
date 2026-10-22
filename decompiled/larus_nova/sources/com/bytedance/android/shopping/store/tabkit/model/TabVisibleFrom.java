package com.bytedance.android.shopping.store.tabkit.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/TabVisibleFrom;", "", "Enter", "Route", "App", "Unknown", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabVisibleFrom extends Enum<TabVisibleFrom> {
    public static final TabVisibleFrom App = null;
    public static final TabVisibleFrom Enter = null;
    public static final TabVisibleFrom Route = null;
    public static final TabVisibleFrom Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabVisibleFrom[] f186818a = null;

    static {
        TabVisibleFrom r100 = new TabVisibleFrom("Enter", 0);
        Enter = r100;
        TabVisibleFrom r101 = new TabVisibleFrom("Route", 1);
        Route = r101;
        TabVisibleFrom r102 = new TabVisibleFrom("App", 2);
        App = r102;
        TabVisibleFrom r103 = new TabVisibleFrom("Unknown", 3);
        Unknown = r103;
        f186818a = new TabVisibleFrom[]{r100, r101, r102, r103};
    }

    public static TabVisibleFrom valueOf(String r100) {
        return (TabVisibleFrom) r27.a.a(TabVisibleFrom.class, r100);
    }

    public static TabVisibleFrom[] values() {
        return (TabVisibleFrom[]) f186818a.clone();
    }

    public TabVisibleFrom(String r100, int r101) {
        super(r100, r101);
    }
}
