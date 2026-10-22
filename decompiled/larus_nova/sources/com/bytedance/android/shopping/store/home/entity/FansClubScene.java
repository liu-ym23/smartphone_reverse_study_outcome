package com.bytedance.android.shopping.store.home.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/FansClubScene;", "", "DEFAULT", "LIVE", "Shop", "Window", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FansClubScene extends Enum<FansClubScene> {
    public static final FansClubScene DEFAULT = null;
    public static final FansClubScene LIVE = null;
    public static final FansClubScene Shop = null;
    public static final FansClubScene Window = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FansClubScene[] f183638a = null;

    static {
        FansClubScene r100 = new FansClubScene("DEFAULT", 0);
        DEFAULT = r100;
        FansClubScene r101 = new FansClubScene("LIVE", 1);
        LIVE = r101;
        FansClubScene r102 = new FansClubScene("Shop", 2);
        Shop = r102;
        FansClubScene r103 = new FansClubScene("Window", 3);
        Window = r103;
        f183638a = new FansClubScene[]{r100, r101, r102, r103};
    }

    public static FansClubScene valueOf(String r100) {
        return (FansClubScene) r27.a.a(FansClubScene.class, r100);
    }

    public static FansClubScene[] values() {
        return (FansClubScene[]) f183638a.clone();
    }

    public FansClubScene(String r100, int r101) {
        super(r100, r101);
    }
}
