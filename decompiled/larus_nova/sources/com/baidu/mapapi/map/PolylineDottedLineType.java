package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum PolylineDottedLineType extends Enum<PolylineDottedLineType> {
    public static final PolylineDottedLineType DOTTED_LINE_CIRCLE = null;
    public static final PolylineDottedLineType DOTTED_LINE_CIRCLE_RECTANGLE = null;
    public static final PolylineDottedLineType DOTTED_LINE_SQUARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ PolylineDottedLineType[] f31280a = null;

    static {
        PolylineDottedLineType r100 = new PolylineDottedLineType("DOTTED_LINE_SQUARE", 0);
        DOTTED_LINE_SQUARE = r100;
        PolylineDottedLineType r101 = new PolylineDottedLineType("DOTTED_LINE_CIRCLE", 1);
        DOTTED_LINE_CIRCLE = r101;
        PolylineDottedLineType r102 = new PolylineDottedLineType("DOTTED_LINE_CIRCLE_RECTANGLE", 2);
        DOTTED_LINE_CIRCLE_RECTANGLE = r102;
        f31280a = new PolylineDottedLineType[]{r100, r101, r102};
    }

    public static PolylineDottedLineType[] values() {
        return (PolylineDottedLineType[]) f31280a.clone();
    }

    public static PolylineDottedLineType valueOf(String r100) {
        return (PolylineDottedLineType) r27.a.a(PolylineDottedLineType.class, r100);
    }

    private PolylineDottedLineType(String r100, int r101) {
        super(r100, r101);
    }
}
