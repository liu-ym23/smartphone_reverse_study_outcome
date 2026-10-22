package co.nstant.in.cbor.model;

/* JADX INFO: loaded from: classes.dex */
public final enum AdditionalInformation extends Enum<AdditionalInformation> {
    private static final /* synthetic */ AdditionalInformation[] $VALUES = null;
    public static final AdditionalInformation DIRECT = null;
    public static final AdditionalInformation EIGHT_BYTES = null;
    public static final AdditionalInformation FOUR_BYTES = null;
    public static final AdditionalInformation INDEFINITE = null;
    public static final AdditionalInformation ONE_BYTE = null;
    public static final AdditionalInformation RESERVED = null;
    public static final AdditionalInformation TWO_BYTES = null;
    private final int value;

    private static /* synthetic */ AdditionalInformation[] $values() {
        return new AdditionalInformation[]{DIRECT, ONE_BYTE, TWO_BYTES, FOUR_BYTES, EIGHT_BYTES, RESERVED, INDEFINITE};
    }

    public static AdditionalInformation valueOf(String name) {
        return (AdditionalInformation) Enum.valueOf(AdditionalInformation.class, name);
    }

    public static AdditionalInformation[] values() {
        return (AdditionalInformation[]) $VALUES.clone();
    }

    static {
        DIRECT = new AdditionalInformation("DIRECT", 0, 0);
        ONE_BYTE = new AdditionalInformation("ONE_BYTE", 1, 24);
        TWO_BYTES = new AdditionalInformation("TWO_BYTES", 2, 25);
        FOUR_BYTES = new AdditionalInformation("FOUR_BYTES", 3, 26);
        EIGHT_BYTES = new AdditionalInformation("EIGHT_BYTES", 4, 27);
        RESERVED = new AdditionalInformation("RESERVED", 5, 28);
        INDEFINITE = new AdditionalInformation("INDEFINITE", 6, 31);
        $VALUES = $values();
    }

    private AdditionalInformation(String r1, int r2, int value) {
        super(r1, r2);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static AdditionalInformation ofByte(int b) {
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
        return DIRECT;
    L7:
        return INDEFINITE;
    L9:
        return RESERVED;
    L11:
        return EIGHT_BYTES;
    L13:
        return FOUR_BYTES;
    L15:
        return TWO_BYTES;
    L17:
        return ONE_BYTE;
    }
}
