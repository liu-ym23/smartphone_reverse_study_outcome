package com.google.android.material.color.utilities;

/* JADX INFO: loaded from: classes2.dex */
public final enum TonePolarity extends Enum<TonePolarity> {
    private static final /* synthetic */ TonePolarity[] $VALUES = null;
    public static final TonePolarity DARKER = null;
    public static final TonePolarity LIGHTER = null;
    public static final TonePolarity NO_PREFERENCE = null;

    public static TonePolarity valueOf(String r1) {
        return (TonePolarity) Enum.valueOf(TonePolarity.class, r1);
    }

    public static TonePolarity[] values() {
        return (TonePolarity[]) $VALUES.clone();
    }

    private TonePolarity(String r1, int r2) {
        super(r1, r2);
    }

    static {
        TonePolarity r0 = new TonePolarity("DARKER", 0);
        DARKER = r0;
        TonePolarity r1 = new TonePolarity("LIGHTER", 1);
        LIGHTER = r1;
        TonePolarity r3 = new TonePolarity("NO_PREFERENCE", 2);
        NO_PREFERENCE = r3;
        $VALUES = new TonePolarity[]{r0, r1, r3};
    }
}
