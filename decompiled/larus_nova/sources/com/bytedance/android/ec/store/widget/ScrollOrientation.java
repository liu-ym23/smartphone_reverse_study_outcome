package com.bytedance.android.ec.store.widget;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/store/widget/ScrollOrientation;", "", "BOTTOM_UP", "TOP_DOWN", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ScrollOrientation extends Enum<ScrollOrientation> {
    public static final ScrollOrientation BOTTOM_UP = null;
    public static final ScrollOrientation TOP_DOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScrollOrientation[] f48990a = null;

    static {
        ScrollOrientation r100 = new ScrollOrientation("BOTTOM_UP", 0);
        BOTTOM_UP = r100;
        ScrollOrientation r101 = new ScrollOrientation("TOP_DOWN", 1);
        TOP_DOWN = r101;
        f48990a = new ScrollOrientation[]{r100, r101};
    }

    public static ScrollOrientation valueOf(String r100) {
        return (ScrollOrientation) r27.a.a(ScrollOrientation.class, r100);
    }

    public static ScrollOrientation[] values() {
        return (ScrollOrientation[]) f48990a.clone();
    }

    public ScrollOrientation(String r100, int r101) {
        super(r100, r101);
    }
}
