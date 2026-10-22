package org.threeten.bp.format;

/* JADX INFO: loaded from: classes4.dex */
public final enum SignStyle extends Enum<SignStyle> {
    private static final /* synthetic */ SignStyle[] $VALUES = null;
    public static final SignStyle ALWAYS = null;
    public static final SignStyle EXCEEDS_PAD = null;
    public static final SignStyle NEVER = null;
    public static final SignStyle NORMAL = null;
    public static final SignStyle NOT_NEGATIVE = null;

    static {
        SignStyle r10 = new SignStyle("NORMAL", 0);
        NORMAL = r10;
        SignStyle r11 = new SignStyle("ALWAYS", 1);
        ALWAYS = r11;
        SignStyle r12 = new SignStyle("NEVER", 2);
        NEVER = r12;
        SignStyle r13 = new SignStyle("NOT_NEGATIVE", 3);
        NOT_NEGATIVE = r13;
        SignStyle r14 = new SignStyle("EXCEEDS_PAD", 4);
        EXCEEDS_PAD = r14;
        $VALUES = new SignStyle[]{r10, r11, r12, r13, r14};
    }

    private SignStyle(String r10, int r11) {
        super(r10, r11);
    }

    public static SignStyle valueOf(String r10) {
        return (SignStyle) Enum.valueOf(SignStyle.class, r10);
    }

    public static SignStyle[] values() {
        return (SignStyle[]) $VALUES.clone();
    }

    public boolean parse(boolean r10, boolean r11, boolean r12) {
        int r13 = ordinal();
        if (r13 == 0) goto L12;
        if (r13 != 1) goto L6;
    L11:
        return true;
    L6:
        if (r13 == 4) goto L11;
        if (r11 == true) goto L16;
        if (r12 == false) goto L10;
        return false;
    L10:
        return true;
    L16:
        return false;
    L12:
        if (r10 == false) goto L15;
        if (r11 == false) goto L15;
        return false;
    L15:
        return true;
    }
}
