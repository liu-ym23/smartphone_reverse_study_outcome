package co.nstant.in.cbor.model;

/* JADX INFO: loaded from: classes.dex */
public final enum SimpleValueType extends Enum<SimpleValueType> {
    private static final /* synthetic */ SimpleValueType[] $VALUES = null;
    public static final SimpleValueType FALSE = null;
    public static final SimpleValueType NULL = null;
    public static final SimpleValueType RESERVED = null;
    public static final SimpleValueType TRUE = null;
    public static final SimpleValueType UNALLOCATED = null;
    public static final SimpleValueType UNDEFINED = null;
    private final int value;

    private static /* synthetic */ SimpleValueType[] $values() {
        return new SimpleValueType[]{FALSE, TRUE, NULL, UNDEFINED, RESERVED, UNALLOCATED};
    }

    public static SimpleValueType valueOf(String name) {
        return (SimpleValueType) Enum.valueOf(SimpleValueType.class, name);
    }

    public static SimpleValueType[] values() {
        return (SimpleValueType[]) $VALUES.clone();
    }

    static {
        FALSE = new SimpleValueType("FALSE", 0, 20);
        TRUE = new SimpleValueType("TRUE", 1, 21);
        NULL = new SimpleValueType("NULL", 2, 22);
        UNDEFINED = new SimpleValueType("UNDEFINED", 3, 23);
        RESERVED = new SimpleValueType("RESERVED", 4, 0);
        UNALLOCATED = new SimpleValueType("UNALLOCATED", 5, 0);
        $VALUES = $values();
    }

    private SimpleValueType(String r1, int r2, int value) {
        super(r1, r2);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static SimpleValueType ofByte(int b) {
        switch((b & 31)) {
            case 20: goto L15;
            case 21: goto L13;
            case 22: goto L11;
            case 23: goto L9;
            case 24: goto L7;
            case 25: goto L7;
            case 26: goto L7;
            case 27: goto L7;
            case 28: goto L7;
            case 29: goto L7;
            case 30: goto L7;
            case 31: goto L7;
            default: goto L5;
        };
    L5:
        return UNALLOCATED;
    L7:
        return RESERVED;
    L9:
        return UNDEFINED;
    L11:
        return NULL;
    L13:
        return TRUE;
    L15:
        return FALSE;
    }
}
