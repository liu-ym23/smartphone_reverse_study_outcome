package com.bytedance.android.ec.window.base.shop;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/WindowFansClubScene;", "", "DEFAULT", "LIVE", "Shop", "Window", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowFansClubScene extends Enum<WindowFansClubScene> {
    public static final WindowFansClubScene DEFAULT = null;
    public static final WindowFansClubScene LIVE = null;
    public static final WindowFansClubScene Shop = null;
    public static final WindowFansClubScene Window = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowFansClubScene[] f49591a = null;

    static {
        WindowFansClubScene r100 = new WindowFansClubScene("DEFAULT", 0);
        DEFAULT = r100;
        WindowFansClubScene r101 = new WindowFansClubScene("LIVE", 1);
        LIVE = r101;
        WindowFansClubScene r102 = new WindowFansClubScene("Shop", 2);
        Shop = r102;
        WindowFansClubScene r103 = new WindowFansClubScene("Window", 3);
        Window = r103;
        f49591a = new WindowFansClubScene[]{r100, r101, r102, r103};
    }

    public static WindowFansClubScene valueOf(String r100) {
        return (WindowFansClubScene) r27.a.a(WindowFansClubScene.class, r100);
    }

    public static WindowFansClubScene[] values() {
        return (WindowFansClubScene[]) f49591a.clone();
    }

    public WindowFansClubScene(String r100, int r101) {
        super(r100, r101);
    }
}
