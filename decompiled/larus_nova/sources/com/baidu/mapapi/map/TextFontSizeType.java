package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum TextFontSizeType extends Enum<TextFontSizeType> {
    public static final TextFontSizeType AdaptTextFontSize = null;
    public static final TextFontSizeType PixelTextFontSize = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ TextFontSizeType[] f31377a = null;

    static {
        TextFontSizeType r100 = new TextFontSizeType("AdaptTextFontSize", 0);
        AdaptTextFontSize = r100;
        TextFontSizeType r101 = new TextFontSizeType("PixelTextFontSize", 1);
        PixelTextFontSize = r101;
        f31377a = new TextFontSizeType[]{r100, r101};
    }

    public static TextFontSizeType[] values() {
        return (TextFontSizeType[]) f31377a.clone();
    }

    public static TextFontSizeType valueOf(String r100) {
        return (TextFontSizeType) r27.a.a(TextFontSizeType.class, r100);
    }

    private TextFontSizeType(String r100, int r101) {
        super(r100, r101);
    }
}
