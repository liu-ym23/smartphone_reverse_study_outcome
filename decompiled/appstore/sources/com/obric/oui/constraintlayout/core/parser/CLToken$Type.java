package com.obric.oui.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes4.dex */
final enum CLToken$Type extends Enum<CLToken$Type> {
    private static final /* synthetic */ CLToken$Type[] $VALUES = null;
    public static final CLToken$Type FALSE = null;
    public static final CLToken$Type NULL = null;
    public static final CLToken$Type TRUE = null;
    public static final CLToken$Type UNKNOWN = null;

    static {
        CLToken$Type r10 = new CLToken$Type("UNKNOWN", 0);
        UNKNOWN = r10;
        CLToken$Type r11 = new CLToken$Type("TRUE", 1);
        TRUE = r11;
        CLToken$Type r12 = new CLToken$Type("FALSE", 2);
        FALSE = r12;
        CLToken$Type r13 = new CLToken$Type("NULL", 3);
        NULL = r13;
        $VALUES = new CLToken$Type[]{r10, r11, r12, r13};
    }

    private CLToken$Type(String r10, int r11) {
        super(r10, r11);
    }

    public static CLToken$Type valueOf(String r10) {
        return (CLToken$Type) Enum.valueOf(CLToken$Type.class, r10);
    }

    public static CLToken$Type[] values() {
        return (CLToken$Type[]) $VALUES.clone();
    }
}
