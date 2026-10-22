package org.threeten.bp.format;

/* JADX INFO: loaded from: classes4.dex */
public final enum TextStyle extends Enum<TextStyle> {
    private static final /* synthetic */ TextStyle[] $VALUES = null;
    public static final TextStyle FULL = null;
    public static final TextStyle FULL_STANDALONE = null;
    public static final TextStyle NARROW = null;
    public static final TextStyle NARROW_STANDALONE = null;
    public static final TextStyle SHORT = null;
    public static final TextStyle SHORT_STANDALONE = null;

    static {
        TextStyle r10 = new TextStyle("FULL", 0);
        FULL = r10;
        TextStyle r11 = new TextStyle("FULL_STANDALONE", 1);
        FULL_STANDALONE = r11;
        TextStyle r12 = new TextStyle("SHORT", 2);
        SHORT = r12;
        TextStyle r13 = new TextStyle("SHORT_STANDALONE", 3);
        SHORT_STANDALONE = r13;
        TextStyle r14 = new TextStyle("NARROW", 4);
        NARROW = r14;
        TextStyle r15 = new TextStyle("NARROW_STANDALONE", 5);
        NARROW_STANDALONE = r15;
        $VALUES = new TextStyle[]{r10, r11, r12, r13, r14, r15};
    }

    private TextStyle(String r10, int r11) {
        super(r10, r11);
    }

    public static TextStyle valueOf(String r10) {
        return (TextStyle) Enum.valueOf(TextStyle.class, r10);
    }

    public static TextStyle[] values() {
        return (TextStyle[]) $VALUES.clone();
    }

    public TextStyle asNormal() {
        return values()[ordinal() & (-2)];
    }

    public TextStyle asStandalone() {
        return values()[ordinal() | 1];
    }

    public boolean isStandalone() {
        if ((ordinal() & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
