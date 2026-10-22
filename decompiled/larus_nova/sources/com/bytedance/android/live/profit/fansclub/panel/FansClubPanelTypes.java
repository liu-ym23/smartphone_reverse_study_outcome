package com.bytedance.android.live.profit.fansclub.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/panel/FansClubPanelTypes;", "", "Native", "Web", "Lynx", "Redirect", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FansClubPanelTypes extends Enum<FansClubPanelTypes> {
    public static final FansClubPanelTypes Lynx = null;
    public static final FansClubPanelTypes Native = null;
    public static final FansClubPanelTypes Redirect = null;
    public static final FansClubPanelTypes Web = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FansClubPanelTypes[] f87336a = null;

    static {
        FansClubPanelTypes r100 = new FansClubPanelTypes("Native", 0);
        Native = r100;
        FansClubPanelTypes r101 = new FansClubPanelTypes("Web", 1);
        Web = r101;
        FansClubPanelTypes r102 = new FansClubPanelTypes("Lynx", 2);
        Lynx = r102;
        FansClubPanelTypes r103 = new FansClubPanelTypes("Redirect", 3);
        Redirect = r103;
        f87336a = new FansClubPanelTypes[]{r100, r101, r102, r103};
    }

    public static FansClubPanelTypes valueOf(String r100) {
        return (FansClubPanelTypes) r27.a.a(FansClubPanelTypes.class, r100);
    }

    public static FansClubPanelTypes[] values() {
        return (FansClubPanelTypes[]) f87336a.clone();
    }

    public FansClubPanelTypes(String r100, int r101) {
        super(r100, r101);
    }
}
