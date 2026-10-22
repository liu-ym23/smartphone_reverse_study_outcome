package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum CircleDottedStrokeType extends Enum<CircleDottedStrokeType> {
    public static final CircleDottedStrokeType DOTTED_LINE_CIRCLE = null;
    public static final CircleDottedStrokeType DOTTED_LINE_RECTANGLE = null;
    public static final CircleDottedStrokeType DOTTED_LINE_SQUARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ CircleDottedStrokeType[] f30831a = null;

    static {
        CircleDottedStrokeType r100 = new CircleDottedStrokeType("DOTTED_LINE_SQUARE", 0);
        DOTTED_LINE_SQUARE = r100;
        CircleDottedStrokeType r101 = new CircleDottedStrokeType("DOTTED_LINE_CIRCLE", 1);
        DOTTED_LINE_CIRCLE = r101;
        CircleDottedStrokeType r102 = new CircleDottedStrokeType("DOTTED_LINE_RECTANGLE", 2);
        DOTTED_LINE_RECTANGLE = r102;
        f30831a = new CircleDottedStrokeType[]{r100, r101, r102};
    }

    public static CircleDottedStrokeType[] values() {
        return (CircleDottedStrokeType[]) f30831a.clone();
    }

    public static CircleDottedStrokeType valueOf(String r100) {
        return (CircleDottedStrokeType) r27.a.a(CircleDottedStrokeType.class, r100);
    }

    private CircleDottedStrokeType(String r100, int r101) {
        super(r100, r101);
    }
}
