package co.nstant.in.cbor.model;

/* JADX INFO: loaded from: classes.dex */
public final enum MajorType extends Enum<MajorType> {
    private static final /* synthetic */ MajorType[] $VALUES = null;
    public static final MajorType ARRAY = null;
    public static final MajorType BYTE_STRING = null;
    public static final MajorType INVALID = null;
    public static final MajorType MAP = null;
    public static final MajorType NEGATIVE_INTEGER = null;
    public static final MajorType SPECIAL = null;
    public static final MajorType TAG = null;
    public static final MajorType UNICODE_STRING = null;
    public static final MajorType UNSIGNED_INTEGER = null;
    private final int value;

    private static /* synthetic */ MajorType[] $values() {
        return new MajorType[]{INVALID, UNSIGNED_INTEGER, NEGATIVE_INTEGER, BYTE_STRING, UNICODE_STRING, ARRAY, MAP, TAG, SPECIAL};
    }

    public static MajorType valueOf(String name) {
        return (MajorType) Enum.valueOf(MajorType.class, name);
    }

    public static MajorType[] values() {
        return (MajorType[]) $VALUES.clone();
    }

    static {
        INVALID = new MajorType("INVALID", 0, -1);
        UNSIGNED_INTEGER = new MajorType("UNSIGNED_INTEGER", 1, 0);
        NEGATIVE_INTEGER = new MajorType("NEGATIVE_INTEGER", 2, 1);
        BYTE_STRING = new MajorType("BYTE_STRING", 3, 2);
        UNICODE_STRING = new MajorType("UNICODE_STRING", 4, 3);
        ARRAY = new MajorType("ARRAY", 5, 4);
        MAP = new MajorType("MAP", 6, 5);
        TAG = new MajorType("TAG", 7, 6);
        SPECIAL = new MajorType("SPECIAL", 8, 7);
        $VALUES = $values();
    }

    private MajorType(String r1, int r2, int value) {
        super(r1, r2);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static MajorType ofByte(int b) {
        switch((b >> 5)) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L5;
        };
    L5:
        return INVALID;
    L7:
        return SPECIAL;
    L9:
        return TAG;
    L11:
        return MAP;
    L13:
        return ARRAY;
    L15:
        return UNICODE_STRING;
    L17:
        return BYTE_STRING;
    L19:
        return NEGATIVE_INTEGER;
    L21:
        return UNSIGNED_INTEGER;
    }
}
