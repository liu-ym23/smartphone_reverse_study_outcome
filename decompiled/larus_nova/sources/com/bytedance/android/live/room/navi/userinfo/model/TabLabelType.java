package com.bytedance.android.live.room.navi.userinfo.model;

import r27.a;

/* JADX INFO: loaded from: classes47.dex */
public final enum TabLabelType extends Enum<TabLabelType> {
    public static final TabLabelType AnchorIdentity = null;
    public static final TabLabelType BaseSelection = null;
    public static final TabLabelType BrandStore = null;
    public static final TabLabelType POI = null;
    public static final TabLabelType QualityGeek = null;
    public static final TabLabelType SecureBuy = null;
    public static final TabLabelType Undefined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabLabelType[] f99808a = null;
    public final int value;

    static {
        TabLabelType r100 = new TabLabelType("Undefined", 0, 0);
        Undefined = r100;
        TabLabelType r101 = new TabLabelType("BaseSelection", 1, 101);
        BaseSelection = r101;
        TabLabelType r102 = new TabLabelType("BrandStore", 2, 106);
        BrandStore = r102;
        TabLabelType r103 = new TabLabelType("SecureBuy", 3, 109);
        SecureBuy = r103;
        TabLabelType r104 = new TabLabelType("QualityGeek", 4, 1013);
        QualityGeek = r104;
        TabLabelType r105 = new TabLabelType("AnchorIdentity", 5, 1015);
        AnchorIdentity = r105;
        TabLabelType r110 = new TabLabelType("POI", 6, 10001);
        POI = r110;
        f99808a = new TabLabelType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static TabLabelType[] values() {
        return (TabLabelType[]) f99808a.clone();
    }

    public static TabLabelType valueOf(String r100) {
        return (TabLabelType) a.a(TabLabelType.class, r100);
    }

    public TabLabelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
