package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes4.dex */
public final enum KeyAttributes$Fit extends Enum<KeyAttributes$Fit> {
    private static final /* synthetic */ KeyAttributes$Fit[] $VALUES = null;
    public static final KeyAttributes$Fit LINEAR = null;
    public static final KeyAttributes$Fit SPLINE = null;

    static {
        KeyAttributes$Fit r10 = new KeyAttributes$Fit("SPLINE", 0);
        SPLINE = r10;
        KeyAttributes$Fit r11 = new KeyAttributes$Fit("LINEAR", 1);
        LINEAR = r11;
        $VALUES = new KeyAttributes$Fit[]{r10, r11};
    }

    private KeyAttributes$Fit(String r10, int r11) {
        super(r10, r11);
    }

    public static KeyAttributes$Fit valueOf(String r10) {
        return (KeyAttributes$Fit) Enum.valueOf(KeyAttributes$Fit.class, r10);
    }

    public static KeyAttributes$Fit[] values() {
        return (KeyAttributes$Fit[]) $VALUES.clone();
    }
}
