package org.threeten.bp.format;

/* JADX INFO: loaded from: classes5.dex */
public final enum FormatStyle extends Enum<FormatStyle> {
    private static final /* synthetic */ FormatStyle[] $VALUES = null;
    public static final FormatStyle FULL = null;
    public static final FormatStyle LONG = null;
    public static final FormatStyle MEDIUM = null;
    public static final FormatStyle SHORT = null;

    private FormatStyle(String r1, int r2) {
        super(r1, r2);
    }

    public static FormatStyle valueOf(String r1) {
        return (FormatStyle) Enum.valueOf(FormatStyle.class, r1);
    }

    public static FormatStyle[] values() {
        return (FormatStyle[]) $VALUES.clone();
    }

    static {
        FormatStyle r0 = new FormatStyle("FULL", 0);
        FULL = r0;
        FormatStyle r1 = new FormatStyle("LONG", 1);
        LONG = r1;
        FormatStyle r3 = new FormatStyle("MEDIUM", 2);
        MEDIUM = r3;
        FormatStyle r5 = new FormatStyle("SHORT", 3);
        SHORT = r5;
        $VALUES = new FormatStyle[]{r0, r1, r3, r5};
    }
}
