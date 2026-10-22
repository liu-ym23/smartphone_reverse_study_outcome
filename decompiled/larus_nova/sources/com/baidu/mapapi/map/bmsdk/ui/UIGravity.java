package com.baidu.mapapi.map.bmsdk.ui;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum UIGravity extends Enum<UIGravity> {
    public static final UIGravity BOTTOM = null;
    public static final UIGravity CENTER = null;
    public static final UIGravity CENTER_HORIZONTAL = null;
    public static final UIGravity CENTER_VERTICAL = null;
    public static final UIGravity LEFT = null;
    public static final UIGravity RIGHT = null;
    public static final UIGravity TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ UIGravity[] f31582a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31583b;

    static {
        UIGravity r100 = new UIGravity("LEFT", 0, 1);
        LEFT = r100;
        UIGravity r101 = new UIGravity("TOP", 1, 2);
        TOP = r101;
        UIGravity r102 = new UIGravity("RIGHT", 2, 4);
        RIGHT = r102;
        UIGravity r103 = new UIGravity("BOTTOM", 3, 8);
        BOTTOM = r103;
        UIGravity r104 = new UIGravity("CENTER_HORIZONTAL", 4, 16);
        CENTER_HORIZONTAL = r104;
        UIGravity r105 = new UIGravity("CENTER_VERTICAL", 5, 32);
        CENTER_VERTICAL = r105;
        UIGravity r110 = new UIGravity("CENTER", 6, 48);
        CENTER = r110;
        f31582a = new UIGravity[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static UIGravity[] values() {
        return (UIGravity[]) f31582a.clone();
    }

    public int getNumber() {
        return this.f31583b;
    }

    public static UIGravity valueOf(String r100) {
        return (UIGravity) a.a(UIGravity.class, r100);
    }

    private UIGravity(String r100, int r101, int r102) {
        super(r100, r101);
        this.f31583b = r102;
    }
}
