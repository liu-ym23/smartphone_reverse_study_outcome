package org.apache.commons.compress.compressors.snappy;

/* JADX INFO: loaded from: classes3.dex */
public final enum FramedSnappyDialect extends Enum<FramedSnappyDialect> {
    private static final /* synthetic */ FramedSnappyDialect[] $VALUES = null;
    public static final FramedSnappyDialect IWORK_ARCHIVE = null;
    public static final FramedSnappyDialect STANDARD = null;
    private final boolean checksumWithCompressedChunks;
    private final boolean streamIdentifier;

    private static /* synthetic */ FramedSnappyDialect[] $values() {
        return new FramedSnappyDialect[]{STANDARD, IWORK_ARCHIVE};
    }

    public static FramedSnappyDialect valueOf(String name) {
        return (FramedSnappyDialect) Enum.valueOf(FramedSnappyDialect.class, name);
    }

    public static FramedSnappyDialect[] values() {
        return (FramedSnappyDialect[]) $VALUES.clone();
    }

    static {
        STANDARD = new FramedSnappyDialect("STANDARD", 0, true, true);
        IWORK_ARCHIVE = new FramedSnappyDialect("IWORK_ARCHIVE", 1, false, false);
        $VALUES = $values();
    }

    private FramedSnappyDialect(String r1, int r2, boolean hasStreamIdentifier, boolean usesChecksumWithCompressedChunks) {
        super(r1, r2);
        this.streamIdentifier = hasStreamIdentifier;
        this.checksumWithCompressedChunks = usesChecksumWithCompressedChunks;
    }

    boolean hasStreamIdentifier() {
        return this.streamIdentifier;
    }

    boolean usesChecksumWithCompressedChunks() {
        return this.checksumWithCompressedChunks;
    }
}
