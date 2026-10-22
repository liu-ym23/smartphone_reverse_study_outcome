package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes4.dex */
public final enum ErrorMode extends Enum<ErrorMode> {
    private static final /* synthetic */ ErrorMode[] $VALUES = null;
    public static final ErrorMode BOUNDARY = null;
    public static final ErrorMode END = null;
    public static final ErrorMode IMMEDIATE = null;

    static {
        ErrorMode r10 = new ErrorMode("IMMEDIATE", 0);
        IMMEDIATE = r10;
        ErrorMode r11 = new ErrorMode("BOUNDARY", 1);
        BOUNDARY = r11;
        ErrorMode r12 = new ErrorMode("END", 2);
        END = r12;
        $VALUES = new ErrorMode[]{r10, r11, r12};
    }

    private ErrorMode(String r10, int r11) {
        super(r10, r11);
    }

    public static ErrorMode valueOf(String r10) {
        return (ErrorMode) Enum.valueOf(ErrorMode.class, r10);
    }

    public static ErrorMode[] values() {
        return (ErrorMode[]) $VALUES.clone();
    }
}
