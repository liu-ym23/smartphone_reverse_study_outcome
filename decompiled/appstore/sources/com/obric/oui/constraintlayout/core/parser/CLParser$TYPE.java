package com.obric.oui.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes4.dex */
final enum CLParser$TYPE extends Enum<CLParser$TYPE> {
    private static final /* synthetic */ CLParser$TYPE[] $VALUES = null;
    public static final CLParser$TYPE ARRAY = null;
    public static final CLParser$TYPE KEY = null;
    public static final CLParser$TYPE NUMBER = null;
    public static final CLParser$TYPE OBJECT = null;
    public static final CLParser$TYPE STRING = null;
    public static final CLParser$TYPE TOKEN = null;
    public static final CLParser$TYPE UNKNOWN = null;

    static {
        CLParser$TYPE r10 = new CLParser$TYPE("UNKNOWN", 0);
        UNKNOWN = r10;
        CLParser$TYPE r11 = new CLParser$TYPE("OBJECT", 1);
        OBJECT = r11;
        CLParser$TYPE r12 = new CLParser$TYPE("ARRAY", 2);
        ARRAY = r12;
        CLParser$TYPE r13 = new CLParser$TYPE("NUMBER", 3);
        NUMBER = r13;
        CLParser$TYPE r14 = new CLParser$TYPE("STRING", 4);
        STRING = r14;
        CLParser$TYPE r15 = new CLParser$TYPE("KEY", 5);
        KEY = r15;
        CLParser$TYPE r16 = new CLParser$TYPE("TOKEN", 6);
        TOKEN = r16;
        $VALUES = new CLParser$TYPE[]{r10, r11, r12, r13, r14, r15, r16};
    }

    private CLParser$TYPE(String r10, int r11) {
        super(r10, r11);
    }

    public static CLParser$TYPE valueOf(String r10) {
        return (CLParser$TYPE) Enum.valueOf(CLParser$TYPE.class, r10);
    }

    public static CLParser$TYPE[] values() {
        return (CLParser$TYPE[]) $VALUES.clone();
    }
}
