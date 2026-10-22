package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes.dex */
public final enum EncodeStrategy extends Enum<EncodeStrategy> {
    private static final /* synthetic */ EncodeStrategy[] $VALUES = null;
    public static final EncodeStrategy NONE = null;
    public static final EncodeStrategy SOURCE = null;
    public static final EncodeStrategy TRANSFORMED = null;

    static {
        EncodeStrategy r10 = new EncodeStrategy("SOURCE", 0);
        SOURCE = r10;
        EncodeStrategy r11 = new EncodeStrategy("TRANSFORMED", 1);
        TRANSFORMED = r11;
        EncodeStrategy r12 = new EncodeStrategy("NONE", 2);
        NONE = r12;
        $VALUES = new EncodeStrategy[]{r10, r11, r12};
    }

    private EncodeStrategy(String r10, int r11) {
        super(r10, r11);
    }

    public static EncodeStrategy valueOf(String r10) {
        return (EncodeStrategy) Enum.valueOf(EncodeStrategy.class, r10);
    }

    public static EncodeStrategy[] values() {
        return (EncodeStrategy[]) $VALUES.clone();
    }
}
