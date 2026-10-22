package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum WidthType extends Enum<WidthType> {
    public static final WidthType AdaptWidth = null;
    public static final WidthType PixelWidth = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ WidthType[] f31559a = null;

    static {
        WidthType r100 = new WidthType("AdaptWidth", 0);
        AdaptWidth = r100;
        WidthType r101 = new WidthType("PixelWidth", 1);
        PixelWidth = r101;
        f31559a = new WidthType[]{r100, r101};
    }

    public static WidthType[] values() {
        return (WidthType[]) f31559a.clone();
    }

    public static WidthType valueOf(String r100) {
        return (WidthType) r27.a.a(WidthType.class, r100);
    }

    private WidthType(String r100, int r101) {
        super(r100, r101);
    }
}
