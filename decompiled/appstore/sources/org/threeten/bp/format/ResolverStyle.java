package org.threeten.bp.format;

/* JADX INFO: loaded from: classes4.dex */
public final enum ResolverStyle extends Enum<ResolverStyle> {
    private static final /* synthetic */ ResolverStyle[] $VALUES = null;
    public static final ResolverStyle LENIENT = null;
    public static final ResolverStyle SMART = null;
    public static final ResolverStyle STRICT = null;

    static {
        ResolverStyle r10 = new ResolverStyle("STRICT", 0);
        STRICT = r10;
        ResolverStyle r11 = new ResolverStyle("SMART", 1);
        SMART = r11;
        ResolverStyle r12 = new ResolverStyle("LENIENT", 2);
        LENIENT = r12;
        $VALUES = new ResolverStyle[]{r10, r11, r12};
    }

    private ResolverStyle(String r10, int r11) {
        super(r10, r11);
    }

    public static ResolverStyle valueOf(String r10) {
        return (ResolverStyle) Enum.valueOf(ResolverStyle.class, r10);
    }

    public static ResolverStyle[] values() {
        return (ResolverStyle[]) $VALUES.clone();
    }
}
