package androidx.profileinstaller;

/* JADX INFO: loaded from: classes.dex */
final enum FileSectionType extends Enum<FileSectionType> {
    private static final /* synthetic */ FileSectionType[] $VALUES = null;
    public static final FileSectionType AGGREGATION_COUNT = null;
    public static final FileSectionType CLASSES = null;
    public static final FileSectionType DEX_FILES = null;
    public static final FileSectionType EXTRA_DESCRIPTORS = null;
    public static final FileSectionType METHODS = null;
    private final long mValue;

    private static /* synthetic */ FileSectionType[] $values() {
        return new FileSectionType[]{DEX_FILES, EXTRA_DESCRIPTORS, CLASSES, METHODS, AGGREGATION_COUNT};
    }

    static {
        DEX_FILES = new FileSectionType("DEX_FILES", 0, 0);
        EXTRA_DESCRIPTORS = new FileSectionType("EXTRA_DESCRIPTORS", 1, 1);
        CLASSES = new FileSectionType("CLASSES", 2, 2);
        METHODS = new FileSectionType("METHODS", 3, 3);
        AGGREGATION_COUNT = new FileSectionType("AGGREGATION_COUNT", 4, 4);
        $VALUES = $values();
    }

    private FileSectionType(String r10, int r11, long r12) {
        super(r10, r11);
        this.mValue = r12;
    }

    public static FileSectionType fromValue(long r10) {
        FileSectionType[] r11 = values();
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L11;
        if (r11[r12].getValue() == r10) goto L8;
        r12 = r12 + 1;
        goto L4
    L8:
        return r11[r12];
    L11:
        throw new IllegalArgumentException("Unsupported FileSection Type " + r10);
    }

    public static FileSectionType valueOf(String r10) {
        return (FileSectionType) Enum.valueOf(FileSectionType.class, r10);
    }

    public static FileSectionType[] values() {
        return (FileSectionType[]) $VALUES.clone();
    }

    public long getValue() {
        return this.mValue;
    }
}
