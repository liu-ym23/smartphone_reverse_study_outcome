package com.jeffmony.async.http.cache;

/* JADX INFO: loaded from: classes3.dex */
final enum ResponseSource extends Enum<ResponseSource> {
    private static final /* synthetic */ ResponseSource[] $VALUES = null;
    public static final ResponseSource CACHE = null;
    public static final ResponseSource CONDITIONAL_CACHE = null;
    public static final ResponseSource NETWORK = null;

    static {
        ResponseSource r10 = new ResponseSource("CACHE", 0);
        CACHE = r10;
        ResponseSource r11 = new ResponseSource("CONDITIONAL_CACHE", 1);
        CONDITIONAL_CACHE = r11;
        ResponseSource r12 = new ResponseSource("NETWORK", 2);
        NETWORK = r12;
        $VALUES = new ResponseSource[]{r10, r11, r12};
    }

    private ResponseSource(String r10, int r11) {
        super(r10, r11);
    }

    public static ResponseSource valueOf(String r10) {
        return (ResponseSource) Enum.valueOf(ResponseSource.class, r10);
    }

    public static ResponseSource[] values() {
        return (ResponseSource[]) $VALUES.clone();
    }

    public boolean requiresConnection() {
        if (this != CONDITIONAL_CACHE) goto L5;
    L8:
        return true;
    L5:
        if (this == NETWORK) goto L8;
        return false;
    }
}
