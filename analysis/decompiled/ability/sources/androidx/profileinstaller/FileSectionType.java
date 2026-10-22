package androidx.profileinstaller;

/* loaded from: classes2.dex */
enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    FileSectionType(long j5) {
        this.mValue = j5;
    }

    public static FileSectionType fromValue(long j5) {
        FileSectionType[] fileSectionTypeArrValues = values();
        for (int i = 0; i < fileSectionTypeArrValues.length; i++) {
            if (fileSectionTypeArrValues[i].getValue() == j5) {
                return fileSectionTypeArrValues[i];
            }
        }
        throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "Unsupported FileSection Type "));
    }

    public long getValue() {
        return this.mValue;
    }
}
