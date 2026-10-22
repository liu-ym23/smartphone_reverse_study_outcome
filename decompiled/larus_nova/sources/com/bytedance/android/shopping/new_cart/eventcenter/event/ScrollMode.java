package com.bytedance.android.shopping.new_cart.eventcenter.event;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/eventcenter/event/ScrollMode;", "", "TOP", "CENTER", "BOTTOM", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ScrollMode extends Enum<ScrollMode> {
    public static final ScrollMode BOTTOM = null;
    public static final ScrollMode CENTER = null;
    public static final ScrollMode TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScrollMode[] f179036a = null;

    static {
        ScrollMode r100 = new ScrollMode("TOP", 0);
        TOP = r100;
        ScrollMode r101 = new ScrollMode("CENTER", 1);
        CENTER = r101;
        ScrollMode r102 = new ScrollMode("BOTTOM", 2);
        BOTTOM = r102;
        f179036a = new ScrollMode[]{r100, r101, r102};
    }

    public static ScrollMode valueOf(String r100) {
        return (ScrollMode) r27.a.a(ScrollMode.class, r100);
    }

    public static ScrollMode[] values() {
        return (ScrollMode[]) f179036a.clone();
    }

    public ScrollMode(String r100, int r101) {
        super(r100, r101);
    }
}
