package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes2.dex */
public final enum Variant extends Enum<Variant> {
    private static final /* synthetic */ Variant[] $VALUES = null;
    public static final Variant CONTENT = null;
    public static final Variant EXPRESSIVE = null;
    public static final Variant FIDELITY = null;
    public static final Variant MONOCHROME = null;
    public static final Variant NEUTRAL = null;
    public static final Variant TONAL_SPOT = null;
    public static final Variant VIBRANT = null;

    public static Variant valueOf(String r1) {
        return (Variant) Enum.valueOf(Variant.class, r1);
    }

    public static Variant[] values() {
        return (Variant[]) $VALUES.clone();
    }

    private Variant(String r1, int r2) {
        super(r1, r2);
    }

    static {
        Variant r0 = new Variant("MONOCHROME", 0);
        MONOCHROME = r0;
        Variant r1 = new Variant("NEUTRAL", 1);
        NEUTRAL = r1;
        Variant r3 = new Variant("TONAL_SPOT", 2);
        TONAL_SPOT = r3;
        Variant r5 = new Variant("VIBRANT", 3);
        VIBRANT = r5;
        Variant r7 = new Variant("EXPRESSIVE", 4);
        EXPRESSIVE = r7;
        Variant r9 = new Variant("FIDELITY", 5);
        FIDELITY = r9;
        Variant r11 = new Variant("CONTENT", 6);
        CONTENT = r11;
        $VALUES = new Variant[]{r0, r1, r3, r5, r7, r9, r11};
    }
}
