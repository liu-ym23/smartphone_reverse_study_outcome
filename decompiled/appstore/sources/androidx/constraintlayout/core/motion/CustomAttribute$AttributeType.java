package androidx.constraintlayout.core.motion;

/* JADX INFO: loaded from: classes.dex */
public final enum CustomAttribute$AttributeType extends Enum<CustomAttribute$AttributeType> {
    private static final /* synthetic */ CustomAttribute$AttributeType[] $VALUES = null;
    public static final CustomAttribute$AttributeType BOOLEAN_TYPE = null;
    public static final CustomAttribute$AttributeType COLOR_DRAWABLE_TYPE = null;
    public static final CustomAttribute$AttributeType COLOR_TYPE = null;
    public static final CustomAttribute$AttributeType DIMENSION_TYPE = null;
    public static final CustomAttribute$AttributeType FLOAT_TYPE = null;
    public static final CustomAttribute$AttributeType INT_TYPE = null;
    public static final CustomAttribute$AttributeType REFERENCE_TYPE = null;
    public static final CustomAttribute$AttributeType STRING_TYPE = null;

    static {
        CustomAttribute$AttributeType r10 = new CustomAttribute$AttributeType("INT_TYPE", 0);
        INT_TYPE = r10;
        CustomAttribute$AttributeType r11 = new CustomAttribute$AttributeType("FLOAT_TYPE", 1);
        FLOAT_TYPE = r11;
        CustomAttribute$AttributeType r12 = new CustomAttribute$AttributeType("COLOR_TYPE", 2);
        COLOR_TYPE = r12;
        CustomAttribute$AttributeType r13 = new CustomAttribute$AttributeType("COLOR_DRAWABLE_TYPE", 3);
        COLOR_DRAWABLE_TYPE = r13;
        CustomAttribute$AttributeType r14 = new CustomAttribute$AttributeType("STRING_TYPE", 4);
        STRING_TYPE = r14;
        CustomAttribute$AttributeType r15 = new CustomAttribute$AttributeType("BOOLEAN_TYPE", 5);
        BOOLEAN_TYPE = r15;
        CustomAttribute$AttributeType r16 = new CustomAttribute$AttributeType("DIMENSION_TYPE", 6);
        DIMENSION_TYPE = r16;
        CustomAttribute$AttributeType r17 = new CustomAttribute$AttributeType("REFERENCE_TYPE", 7);
        REFERENCE_TYPE = r17;
        $VALUES = new CustomAttribute$AttributeType[]{r10, r11, r12, r13, r14, r15, r16, r17};
    }

    private CustomAttribute$AttributeType(String r10, int r11) {
        super(r10, r11);
    }

    public static CustomAttribute$AttributeType valueOf(String r10) {
        return (CustomAttribute$AttributeType) Enum.valueOf(CustomAttribute$AttributeType.class, r10);
    }

    public static CustomAttribute$AttributeType[] values() {
        return (CustomAttribute$AttributeType[]) $VALUES.clone();
    }
}
