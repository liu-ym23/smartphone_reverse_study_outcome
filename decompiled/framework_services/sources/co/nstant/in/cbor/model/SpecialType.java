package co.nstant.in.cbor.model;

/* JADX INFO: loaded from: classes.dex */
public final enum SpecialType extends Enum<SpecialType> {
    private static final /* synthetic */ SpecialType[] $VALUES = null;
    public static final SpecialType BREAK = null;
    public static final SpecialType IEEE_754_DOUBLE_PRECISION_FLOAT = null;
    public static final SpecialType IEEE_754_HALF_PRECISION_FLOAT = null;
    public static final SpecialType IEEE_754_SINGLE_PRECISION_FLOAT = null;
    public static final SpecialType SIMPLE_VALUE = null;
    public static final SpecialType SIMPLE_VALUE_NEXT_BYTE = null;
    public static final SpecialType UNALLOCATED = null;

    private static /* synthetic */ SpecialType[] $values() {
        return new SpecialType[]{SIMPLE_VALUE, SIMPLE_VALUE_NEXT_BYTE, IEEE_754_HALF_PRECISION_FLOAT, IEEE_754_SINGLE_PRECISION_FLOAT, IEEE_754_DOUBLE_PRECISION_FLOAT, UNALLOCATED, BREAK};
    }

    private SpecialType(String r1, int r2) {
        super(r1, r2);
    }

    public static SpecialType valueOf(String name) {
        return (SpecialType) Enum.valueOf(SpecialType.class, name);
    }

    public static SpecialType[] values() {
        return (SpecialType[]) $VALUES.clone();
    }

    static {
        SIMPLE_VALUE = new SpecialType("SIMPLE_VALUE", 0);
        SIMPLE_VALUE_NEXT_BYTE = new SpecialType("SIMPLE_VALUE_NEXT_BYTE", 1);
        IEEE_754_HALF_PRECISION_FLOAT = new SpecialType("IEEE_754_HALF_PRECISION_FLOAT", 2);
        IEEE_754_SINGLE_PRECISION_FLOAT = new SpecialType("IEEE_754_SINGLE_PRECISION_FLOAT", 3);
        IEEE_754_DOUBLE_PRECISION_FLOAT = new SpecialType("IEEE_754_DOUBLE_PRECISION_FLOAT", 4);
        UNALLOCATED = new SpecialType("UNALLOCATED", 5);
        BREAK = new SpecialType("BREAK", 6);
        $VALUES = $values();
    }

    public static SpecialType ofByte(int b) {
        switch((b & 31)) {
            case 24: goto L17;
            case 25: goto L15;
            case 26: goto L13;
            case 27: goto L11;
            case 28: goto L9;
            case 29: goto L9;
            case 30: goto L9;
            case 31: goto L7;
            default: goto L5;
        };
    L5:
        return SIMPLE_VALUE;
    L7:
        return BREAK;
    L9:
        return UNALLOCATED;
    L11:
        return IEEE_754_DOUBLE_PRECISION_FLOAT;
    L13:
        return IEEE_754_SINGLE_PRECISION_FLOAT;
    L15:
        return IEEE_754_HALF_PRECISION_FLOAT;
    L17:
        return SIMPLE_VALUE_NEXT_BYTE;
    }
}
