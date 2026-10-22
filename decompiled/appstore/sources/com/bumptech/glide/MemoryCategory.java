package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
public final enum MemoryCategory extends Enum<MemoryCategory> {
    private static final /* synthetic */ MemoryCategory[] $VALUES = null;
    public static final MemoryCategory HIGH = null;
    public static final MemoryCategory LOW = null;
    public static final MemoryCategory NORMAL = null;
    private final float multiplier;

    static {
        MemoryCategory r10 = new MemoryCategory("LOW", 0, 0.5f);
        LOW = r10;
        MemoryCategory r11 = new MemoryCategory("NORMAL", 1, 1.0f);
        NORMAL = r11;
        MemoryCategory r12 = new MemoryCategory("HIGH", 2, 1.5f);
        HIGH = r12;
        $VALUES = new MemoryCategory[]{r10, r11, r12};
    }

    private MemoryCategory(String r10, int r11, float r12) {
        super(r10, r11);
        this.multiplier = r12;
    }

    public static MemoryCategory valueOf(String r10) {
        return (MemoryCategory) Enum.valueOf(MemoryCategory.class, r10);
    }

    public static MemoryCategory[] values() {
        return (MemoryCategory[]) $VALUES.clone();
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
