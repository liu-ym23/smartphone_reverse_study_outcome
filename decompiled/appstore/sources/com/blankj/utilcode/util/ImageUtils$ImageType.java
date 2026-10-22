package com.blankj.utilcode.util;

/* JADX INFO: loaded from: classes.dex */
public final enum ImageUtils$ImageType extends Enum<ImageUtils$ImageType> {
    private static final /* synthetic */ ImageUtils$ImageType[] $VALUES = null;
    public static final ImageUtils$ImageType TYPE_BMP = null;
    public static final ImageUtils$ImageType TYPE_GIF = null;
    public static final ImageUtils$ImageType TYPE_ICO = null;
    public static final ImageUtils$ImageType TYPE_JPG = null;
    public static final ImageUtils$ImageType TYPE_PNG = null;
    public static final ImageUtils$ImageType TYPE_TIFF = null;
    public static final ImageUtils$ImageType TYPE_UNKNOWN = null;
    public static final ImageUtils$ImageType TYPE_WEBP = null;
    String value;

    static {
        ImageUtils$ImageType r10 = new ImageUtils$ImageType("TYPE_JPG", 0, "jpg");
        TYPE_JPG = r10;
        ImageUtils$ImageType r11 = new ImageUtils$ImageType("TYPE_PNG", 1, "png");
        TYPE_PNG = r11;
        ImageUtils$ImageType r12 = new ImageUtils$ImageType("TYPE_GIF", 2, "gif");
        TYPE_GIF = r12;
        ImageUtils$ImageType r13 = new ImageUtils$ImageType("TYPE_TIFF", 3, "tiff");
        TYPE_TIFF = r13;
        ImageUtils$ImageType r14 = new ImageUtils$ImageType("TYPE_BMP", 4, "bmp");
        TYPE_BMP = r14;
        ImageUtils$ImageType r15 = new ImageUtils$ImageType("TYPE_WEBP", 5, "webp");
        TYPE_WEBP = r15;
        ImageUtils$ImageType r16 = new ImageUtils$ImageType("TYPE_ICO", 6, "ico");
        TYPE_ICO = r16;
        ImageUtils$ImageType r17 = new ImageUtils$ImageType("TYPE_UNKNOWN", 7, "unknown");
        TYPE_UNKNOWN = r17;
        $VALUES = new ImageUtils$ImageType[]{r10, r11, r12, r13, r14, r15, r16, r17};
    }

    private ImageUtils$ImageType(String r10, int r11, String r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static ImageUtils$ImageType valueOf(String r10) {
        return (ImageUtils$ImageType) Enum.valueOf(ImageUtils$ImageType.class, r10);
    }

    public static ImageUtils$ImageType[] values() {
        return (ImageUtils$ImageType[]) $VALUES.clone();
    }

    public String getValue() {
        return this.value;
    }
}
