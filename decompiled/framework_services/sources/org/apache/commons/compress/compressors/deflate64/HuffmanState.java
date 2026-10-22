package org.apache.commons.compress.compressors.deflate64;

/* JADX INFO: loaded from: classes3.dex */
final enum HuffmanState extends Enum<HuffmanState> {
    private static final /* synthetic */ HuffmanState[] $VALUES = null;
    public static final HuffmanState DYNAMIC_CODES = null;
    public static final HuffmanState FIXED_CODES = null;
    public static final HuffmanState INITIAL = null;
    public static final HuffmanState STORED = null;

    private static /* synthetic */ HuffmanState[] $values() {
        return new HuffmanState[]{INITIAL, STORED, DYNAMIC_CODES, FIXED_CODES};
    }

    private HuffmanState(String r1, int r2) {
        super(r1, r2);
    }

    public static HuffmanState valueOf(String name) {
        return (HuffmanState) Enum.valueOf(HuffmanState.class, name);
    }

    public static HuffmanState[] values() {
        return (HuffmanState[]) $VALUES.clone();
    }

    static {
        INITIAL = new HuffmanState("INITIAL", 0);
        STORED = new HuffmanState("STORED", 1);
        DYNAMIC_CODES = new HuffmanState("DYNAMIC_CODES", 2);
        FIXED_CODES = new HuffmanState("FIXED_CODES", 3);
        $VALUES = $values();
    }
}
