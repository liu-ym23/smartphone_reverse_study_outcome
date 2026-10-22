package com.bytedance.android.live.revlink.impl.multianchor.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/UILayout;", "", "Normal", "Enlarge", "FULL", "FULL_RECORD", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UILayout extends Enum<UILayout> {
    public static final UILayout Enlarge = null;
    public static final UILayout FULL = null;
    public static final UILayout FULL_RECORD = null;
    public static final UILayout Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UILayout[] f94794a = null;

    static {
        UILayout r100 = new UILayout("Normal", 0);
        Normal = r100;
        UILayout r101 = new UILayout("Enlarge", 1);
        Enlarge = r101;
        UILayout r102 = new UILayout("FULL", 2);
        FULL = r102;
        UILayout r103 = new UILayout("FULL_RECORD", 3);
        FULL_RECORD = r103;
        f94794a = new UILayout[]{r100, r101, r102, r103};
    }

    public static UILayout valueOf(String r100) {
        return (UILayout) r27.a.a(UILayout.class, r100);
    }

    public static UILayout[] values() {
        return (UILayout[]) f94794a.clone();
    }

    public UILayout(String r100, int r101) {
        super(r100, r101);
    }
}
