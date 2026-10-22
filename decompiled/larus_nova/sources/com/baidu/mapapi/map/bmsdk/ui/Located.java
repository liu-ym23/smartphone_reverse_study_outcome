package com.baidu.mapapi.map.bmsdk.ui;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum Located extends Enum<Located> {
    public static final Located BOTTOM = null;
    public static final Located CENTER = null;
    public static final Located LEFT = null;
    public static final Located LEFT_BOTTOM = null;
    public static final Located LEFT_TOP = null;
    public static final Located RIGHT = null;
    public static final Located RIGHT_BOTTOM = null;
    public static final Located RIGHT_TOP = null;
    public static final Located TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ Located[] f31578a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31579b;

    static {
        Located r100 = new Located("CENTER", 0, 1);
        CENTER = r100;
        Located r101 = new Located("TOP", 1, 2);
        TOP = r101;
        Located r102 = new Located("BOTTOM", 2, 4);
        BOTTOM = r102;
        Located r103 = new Located("LEFT", 3, 8);
        LEFT = r103;
        Located r104 = new Located("RIGHT", 4, 16);
        RIGHT = r104;
        Located r110 = new Located("LEFT_TOP", 5, 10);
        LEFT_TOP = r110;
        Located r111 = new Located("LEFT_BOTTOM", 6, 12);
        LEFT_BOTTOM = r111;
        Located r112 = new Located("RIGHT_TOP", 7, 18);
        RIGHT_TOP = r112;
        Located r113 = new Located("RIGHT_BOTTOM", 8, 20);
        RIGHT_BOTTOM = r113;
        f31578a = new Located[]{r100, r101, r102, r103, r104, r110, r111, r112, r113};
    }

    public static Located[] values() {
        return (Located[]) f31578a.clone();
    }

    public int getNumber() {
        return this.f31579b;
    }

    public static Located valueOf(String r100) {
        return (Located) a.a(Located.class, r100);
    }

    private Located(String r100, int r101, int r102) {
        super(r100, r101);
        this.f31579b = r102;
    }
}
