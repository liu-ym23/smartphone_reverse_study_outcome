package org.threeten.bp.format;

/* JADX INFO: loaded from: classes4.dex */
public final enum FormatStyle extends Enum<FormatStyle> {
    private static final /* synthetic */ FormatStyle[] $VALUES = null;
    public static final FormatStyle FULL = null;
    public static final FormatStyle LONG = null;
    public static final FormatStyle MEDIUM = null;
    public static final FormatStyle SHORT = null;

    static {
        FormatStyle r10 = new FormatStyle("FULL", 0);
        FULL = r10;
        FormatStyle r11 = new FormatStyle("LONG", 1);
        LONG = r11;
        FormatStyle r12 = new FormatStyle("MEDIUM", 2);
        MEDIUM = r12;
        FormatStyle r13 = new FormatStyle("SHORT", 3);
        SHORT = r13;
        $VALUES = new FormatStyle[]{r10, r11, r12, r13};
    }

    private FormatStyle(String r10, int r11) {
        super(r10, r11);
    }

    public static FormatStyle valueOf(String r10) {
        return (FormatStyle) Enum.valueOf(FormatStyle.class, r10);
    }

    public static FormatStyle[] values() {
        return (FormatStyle[]) $VALUES.clone();
    }
}
