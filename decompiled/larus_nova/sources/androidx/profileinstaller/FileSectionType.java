package androidx.profileinstaller;

/* JADX INFO: loaded from: classes17.dex */
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

    public static FileSectionType[] values() {
        return (FileSectionType[]) $VALUES.clone();
    }

    public long getValue() {
        return this.mValue;
    }

    public static FileSectionType fromValue(long r100) {
        FileSectionType[] r101 = values();
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L11;
        if (r101[r102].getValue() == r100) goto L8;
        r102 = r102 + 1;
        goto L4
    L8:
        return r101[r102];
    L11:
        throw new IllegalArgumentException("Unsupported FileSection Type " + r100);
    }

    public static FileSectionType valueOf(String r100) {
        return (FileSectionType) r27.a.a(FileSectionType.class, r100);
    }

    private FileSectionType(String r100, int r101, long r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}
