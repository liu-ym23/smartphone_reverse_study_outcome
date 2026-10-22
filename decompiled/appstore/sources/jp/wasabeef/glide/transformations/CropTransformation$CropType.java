package jp.wasabeef.glide.transformations;

/* JADX INFO: loaded from: classes4.dex */
public final enum CropTransformation$CropType extends Enum<CropTransformation$CropType> {
    private static final /* synthetic */ CropTransformation$CropType[] $VALUES = null;
    public static final CropTransformation$CropType BOTTOM = null;
    public static final CropTransformation$CropType CENTER = null;
    public static final CropTransformation$CropType TOP = null;

    static {
        CropTransformation$CropType r10 = new CropTransformation$CropType("TOP", 0);
        TOP = r10;
        CropTransformation$CropType r11 = new CropTransformation$CropType("CENTER", 1);
        CENTER = r11;
        CropTransformation$CropType r12 = new CropTransformation$CropType("BOTTOM", 2);
        BOTTOM = r12;
        $VALUES = new CropTransformation$CropType[]{r10, r11, r12};
    }

    private CropTransformation$CropType(String r10, int r11) {
        super(r10, r11);
    }

    public static CropTransformation$CropType valueOf(String r10) {
        return (CropTransformation$CropType) Enum.valueOf(CropTransformation$CropType.class, r10);
    }

    public static CropTransformation$CropType[] values() {
        return (CropTransformation$CropType[]) $VALUES.clone();
    }
}
