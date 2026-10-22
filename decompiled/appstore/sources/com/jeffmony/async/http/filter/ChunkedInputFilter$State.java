package com.jeffmony.async.http.filter;

/* JADX INFO: loaded from: classes3.dex */
final enum ChunkedInputFilter$State extends Enum<ChunkedInputFilter$State> {
    private static final /* synthetic */ ChunkedInputFilter$State[] $VALUES = null;
    public static final ChunkedInputFilter$State CHUNK = null;
    public static final ChunkedInputFilter$State CHUNK_CR = null;
    public static final ChunkedInputFilter$State CHUNK_CRLF = null;
    public static final ChunkedInputFilter$State CHUNK_LEN = null;
    public static final ChunkedInputFilter$State CHUNK_LEN_CR = null;
    public static final ChunkedInputFilter$State CHUNK_LEN_CRLF = null;
    public static final ChunkedInputFilter$State COMPLETE = null;
    public static final ChunkedInputFilter$State ERROR = null;

    static {
        ChunkedInputFilter$State r10 = new ChunkedInputFilter$State("CHUNK_LEN", 0);
        CHUNK_LEN = r10;
        ChunkedInputFilter$State r11 = new ChunkedInputFilter$State("CHUNK_LEN_CR", 1);
        CHUNK_LEN_CR = r11;
        ChunkedInputFilter$State r12 = new ChunkedInputFilter$State("CHUNK_LEN_CRLF", 2);
        CHUNK_LEN_CRLF = r12;
        ChunkedInputFilter$State r13 = new ChunkedInputFilter$State("CHUNK", 3);
        CHUNK = r13;
        ChunkedInputFilter$State r14 = new ChunkedInputFilter$State("CHUNK_CR", 4);
        CHUNK_CR = r14;
        ChunkedInputFilter$State r15 = new ChunkedInputFilter$State("CHUNK_CRLF", 5);
        CHUNK_CRLF = r15;
        ChunkedInputFilter$State r16 = new ChunkedInputFilter$State("COMPLETE", 6);
        COMPLETE = r16;
        ChunkedInputFilter$State r17 = new ChunkedInputFilter$State("ERROR", 7);
        ERROR = r17;
        $VALUES = new ChunkedInputFilter$State[]{r10, r11, r12, r13, r14, r15, r16, r17};
    }

    private ChunkedInputFilter$State(String r10, int r11) {
        super(r10, r11);
    }

    public static ChunkedInputFilter$State valueOf(String r10) {
        return (ChunkedInputFilter$State) Enum.valueOf(ChunkedInputFilter$State.class, r10);
    }

    public static ChunkedInputFilter$State[] values() {
        return (ChunkedInputFilter$State[]) $VALUES.clone();
    }
}
