package okhttp3.internal.http2;

/* JADX INFO: loaded from: classes4.dex */
public final enum ErrorCode extends Enum<ErrorCode> {
    private static final /* synthetic */ ErrorCode[] $VALUES = null;
    public static final ErrorCode CANCEL = null;
    public static final ErrorCode COMPRESSION_ERROR = null;
    public static final ErrorCode CONNECT_ERROR = null;
    public static final ErrorCode ENHANCE_YOUR_CALM = null;
    public static final ErrorCode FLOW_CONTROL_ERROR = null;
    public static final ErrorCode HTTP_1_1_REQUIRED = null;
    public static final ErrorCode INADEQUATE_SECURITY = null;
    public static final ErrorCode INTERNAL_ERROR = null;
    public static final ErrorCode NO_ERROR = null;
    public static final ErrorCode PROTOCOL_ERROR = null;
    public static final ErrorCode REFUSED_STREAM = null;
    public final int httpCode;

    static {
        ErrorCode r10 = new ErrorCode("NO_ERROR", 0, 0);
        NO_ERROR = r10;
        ErrorCode r11 = new ErrorCode("PROTOCOL_ERROR", 1, 1);
        PROTOCOL_ERROR = r11;
        ErrorCode r12 = new ErrorCode("INTERNAL_ERROR", 2, 2);
        INTERNAL_ERROR = r12;
        ErrorCode r13 = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
        FLOW_CONTROL_ERROR = r13;
        ErrorCode r14 = new ErrorCode("REFUSED_STREAM", 4, 7);
        REFUSED_STREAM = r14;
        ErrorCode r15 = new ErrorCode("CANCEL", 5, 8);
        CANCEL = r15;
        ErrorCode r16 = new ErrorCode("COMPRESSION_ERROR", 6, 9);
        COMPRESSION_ERROR = r16;
        ErrorCode r17 = new ErrorCode("CONNECT_ERROR", 7, 10);
        CONNECT_ERROR = r17;
        ErrorCode r18 = new ErrorCode("ENHANCE_YOUR_CALM", 8, 11);
        ENHANCE_YOUR_CALM = r18;
        ErrorCode r19 = new ErrorCode("INADEQUATE_SECURITY", 9, 12);
        INADEQUATE_SECURITY = r19;
        ErrorCode r110 = new ErrorCode("HTTP_1_1_REQUIRED", 10, 13);
        HTTP_1_1_REQUIRED = r110;
        $VALUES = new ErrorCode[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110};
    }

    private ErrorCode(String r10, int r11, int r12) {
        super(r10, r11);
        this.httpCode = r12;
    }

    public static ErrorCode fromHttp2(int r10) {
        ErrorCode[] r11 = values();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        ErrorCode r14 = r11[r13];
        if (r14.httpCode == r10) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L8:
        return null;
    }

    public static ErrorCode valueOf(String r10) {
        return (ErrorCode) Enum.valueOf(ErrorCode.class, r10);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) $VALUES.clone();
    }
}
