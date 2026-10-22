package jp.wasabeef.glide.transformations;

/* JADX INFO: loaded from: classes4.dex */
public final enum RoundedCornersTransformation$CornerType extends Enum<RoundedCornersTransformation$CornerType> {
    private static final /* synthetic */ RoundedCornersTransformation$CornerType[] $VALUES = null;
    public static final RoundedCornersTransformation$CornerType ALL = null;
    public static final RoundedCornersTransformation$CornerType BOTTOM = null;
    public static final RoundedCornersTransformation$CornerType BOTTOM_LEFT = null;
    public static final RoundedCornersTransformation$CornerType BOTTOM_RIGHT = null;
    public static final RoundedCornersTransformation$CornerType DIAGONAL_FROM_TOP_LEFT = null;
    public static final RoundedCornersTransformation$CornerType DIAGONAL_FROM_TOP_RIGHT = null;
    public static final RoundedCornersTransformation$CornerType LEFT = null;
    public static final RoundedCornersTransformation$CornerType OTHER_BOTTOM_LEFT = null;
    public static final RoundedCornersTransformation$CornerType OTHER_BOTTOM_RIGHT = null;
    public static final RoundedCornersTransformation$CornerType OTHER_TOP_LEFT = null;
    public static final RoundedCornersTransformation$CornerType OTHER_TOP_RIGHT = null;
    public static final RoundedCornersTransformation$CornerType RIGHT = null;
    public static final RoundedCornersTransformation$CornerType TOP = null;
    public static final RoundedCornersTransformation$CornerType TOP_LEFT = null;
    public static final RoundedCornersTransformation$CornerType TOP_RIGHT = null;

    static {
        RoundedCornersTransformation$CornerType r10 = new RoundedCornersTransformation$CornerType("ALL", 0);
        ALL = r10;
        RoundedCornersTransformation$CornerType r11 = new RoundedCornersTransformation$CornerType("TOP_LEFT", 1);
        TOP_LEFT = r11;
        RoundedCornersTransformation$CornerType r12 = new RoundedCornersTransformation$CornerType("TOP_RIGHT", 2);
        TOP_RIGHT = r12;
        RoundedCornersTransformation$CornerType r13 = new RoundedCornersTransformation$CornerType("BOTTOM_LEFT", 3);
        BOTTOM_LEFT = r13;
        RoundedCornersTransformation$CornerType r14 = new RoundedCornersTransformation$CornerType("BOTTOM_RIGHT", 4);
        BOTTOM_RIGHT = r14;
        RoundedCornersTransformation$CornerType r15 = new RoundedCornersTransformation$CornerType("TOP", 5);
        TOP = r15;
        RoundedCornersTransformation$CornerType r16 = new RoundedCornersTransformation$CornerType("BOTTOM", 6);
        BOTTOM = r16;
        RoundedCornersTransformation$CornerType r17 = new RoundedCornersTransformation$CornerType("LEFT", 7);
        LEFT = r17;
        RoundedCornersTransformation$CornerType r18 = new RoundedCornersTransformation$CornerType("RIGHT", 8);
        RIGHT = r18;
        RoundedCornersTransformation$CornerType r19 = new RoundedCornersTransformation$CornerType("OTHER_TOP_LEFT", 9);
        OTHER_TOP_LEFT = r19;
        RoundedCornersTransformation$CornerType r110 = new RoundedCornersTransformation$CornerType("OTHER_TOP_RIGHT", 10);
        OTHER_TOP_RIGHT = r110;
        RoundedCornersTransformation$CornerType r111 = new RoundedCornersTransformation$CornerType("OTHER_BOTTOM_LEFT", 11);
        OTHER_BOTTOM_LEFT = r111;
        RoundedCornersTransformation$CornerType r112 = new RoundedCornersTransformation$CornerType("OTHER_BOTTOM_RIGHT", 12);
        OTHER_BOTTOM_RIGHT = r112;
        RoundedCornersTransformation$CornerType r113 = new RoundedCornersTransformation$CornerType("DIAGONAL_FROM_TOP_LEFT", 13);
        DIAGONAL_FROM_TOP_LEFT = r113;
        RoundedCornersTransformation$CornerType r114 = new RoundedCornersTransformation$CornerType("DIAGONAL_FROM_TOP_RIGHT", 14);
        DIAGONAL_FROM_TOP_RIGHT = r114;
        $VALUES = new RoundedCornersTransformation$CornerType[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114};
    }

    private RoundedCornersTransformation$CornerType(String r10, int r11) {
        super(r10, r11);
    }

    public static RoundedCornersTransformation$CornerType valueOf(String r10) {
        return (RoundedCornersTransformation$CornerType) Enum.valueOf(RoundedCornersTransformation$CornerType.class, r10);
    }

    public static RoundedCornersTransformation$CornerType[] values() {
        return (RoundedCornersTransformation$CornerType[]) $VALUES.clone();
    }
}
