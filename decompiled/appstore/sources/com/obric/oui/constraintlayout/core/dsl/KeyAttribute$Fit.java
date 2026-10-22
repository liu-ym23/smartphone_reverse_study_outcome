package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum KeyAttribute$Fit extends Enum<KeyAttribute$Fit> {
    private static final /* synthetic */ KeyAttribute$Fit[] $VALUES = null;
    public static final KeyAttribute$Fit LINEAR = null;
    public static final KeyAttribute$Fit SPLINE = null;

    static {
        KeyAttribute$Fit r10 = new KeyAttribute$Fit("SPLINE", 0);
        SPLINE = r10;
        KeyAttribute$Fit r11 = new KeyAttribute$Fit("LINEAR", 1);
        LINEAR = r11;
        $VALUES = new KeyAttribute$Fit[]{r10, r11};
    }

    private KeyAttribute$Fit(String r10, int r11) {
        super(r10, r11);
    }

    public static KeyAttribute$Fit valueOf(String r10) {
        return (KeyAttribute$Fit) Enum.valueOf(KeyAttribute$Fit.class, r10);
    }

    public static KeyAttribute$Fit[] values() {
        return (KeyAttribute$Fit[]) $VALUES.clone();
    }
}
