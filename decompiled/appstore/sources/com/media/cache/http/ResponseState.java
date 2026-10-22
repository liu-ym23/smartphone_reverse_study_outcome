package com.media.cache.http;

/* JADX INFO: loaded from: classes3.dex */
public final enum ResponseState extends Enum<ResponseState> implements IState {
    private static final /* synthetic */ ResponseState[] $VALUES = null;
    public static final ResponseState ACCEPTED = null;
    public static final ResponseState BAD_REQUEST = null;
    public static final ResponseState CONFLICT = null;
    public static final ResponseState CREATED = null;
    public static final ResponseState EXPECTATION_FAILED = null;
    public static final ResponseState FORBIDDEN = null;

    @Deprecated
    public static final ResponseState FOUND = null;
    public static final ResponseState GONE = null;
    public static final ResponseState INTERNAL_ERROR = null;
    public static final ResponseState LENGTH_REQUIRED = null;
    public static final ResponseState METHOD_NOT_ALLOWED = null;
    public static final ResponseState MULTI_STATUS = null;
    public static final ResponseState NOT_ACCEPTABLE = null;
    public static final ResponseState NOT_FOUND = null;
    public static final ResponseState NOT_IMPLEMENTED = null;
    public static final ResponseState NOT_MODIFIED = null;
    public static final ResponseState NO_CONTENT = null;
    public static final ResponseState OK = null;
    public static final ResponseState PARTIAL_CONTENT = null;
    public static final ResponseState PAYLOAD_TOO_LARGE = null;
    public static final ResponseState PRECONDITION_FAILED = null;
    public static final ResponseState RANGE_NOT_SATISFIABLE = null;
    public static final ResponseState REDIRECT = null;
    public static final ResponseState REDIRECT_SEE_OTHER = null;
    public static final ResponseState REQUEST_TIMEOUT = null;
    public static final ResponseState SERVICE_UNAVAILABLE = null;
    public static final ResponseState SWITCH_PROTOCOL = null;
    public static final ResponseState TEMPORARY_REDIRECT = null;
    public static final ResponseState TOO_MANY_REQUESTS = null;
    public static final ResponseState UNAUTHORIZED = null;
    public static final ResponseState UNSUPPORTED_HTTP_VERSION = null;
    public static final ResponseState UNSUPPORTED_MEDIA_TYPE = null;
    private final int mResponseCode;
    private final String mResponseDescription;

    static {
        ResponseState r10 = new ResponseState("SWITCH_PROTOCOL", 0, 101, "Switching Protocols");
        SWITCH_PROTOCOL = r10;
        ResponseState r11 = new ResponseState("OK", 1, 200, "OK");
        OK = r11;
        ResponseState r12 = new ResponseState("CREATED", 2, 201, "Created");
        CREATED = r12;
        ResponseState r13 = new ResponseState("ACCEPTED", 3, 202, "Accepted");
        ACCEPTED = r13;
        ResponseState r14 = new ResponseState("NO_CONTENT", 4, 204, "No Content");
        NO_CONTENT = r14;
        ResponseState r15 = new ResponseState("PARTIAL_CONTENT", 5, 206, "Partial Content");
        PARTIAL_CONTENT = r15;
        ResponseState r16 = new ResponseState("MULTI_STATUS", 6, 207, "Multi-Status");
        MULTI_STATUS = r16;
        ResponseState r17 = new ResponseState("REDIRECT", 7, 301, "Moved Permanently");
        REDIRECT = r17;
        ResponseState r18 = new ResponseState("FOUND", 8, 302, "Found");
        FOUND = r18;
        ResponseState r19 = new ResponseState("REDIRECT_SEE_OTHER", 9, 303, "See Other");
        REDIRECT_SEE_OTHER = r19;
        ResponseState r110 = new ResponseState("NOT_MODIFIED", 10, 304, "Not Modified");
        NOT_MODIFIED = r110;
        ResponseState r111 = new ResponseState("TEMPORARY_REDIRECT", 11, 307, "Temporary Redirect");
        TEMPORARY_REDIRECT = r111;
        ResponseState r20 = new ResponseState("BAD_REQUEST", 12, 400, "Bad Request");
        BAD_REQUEST = r20;
        ResponseState r21 = new ResponseState("UNAUTHORIZED", 13, 401, "Unauthorized");
        UNAUTHORIZED = r21;
        ResponseState r22 = new ResponseState("FORBIDDEN", 14, 403, "Forbidden");
        FORBIDDEN = r22;
        ResponseState r23 = new ResponseState("NOT_FOUND", 15, 404, "Not Found");
        NOT_FOUND = r23;
        ResponseState r24 = new ResponseState("METHOD_NOT_ALLOWED", 16, 405, "Method Not Allowed");
        METHOD_NOT_ALLOWED = r24;
        ResponseState r25 = new ResponseState("NOT_ACCEPTABLE", 17, 406, "Not Acceptable");
        NOT_ACCEPTABLE = r25;
        ResponseState r26 = new ResponseState("REQUEST_TIMEOUT", 18, 408, "Request Timeout");
        REQUEST_TIMEOUT = r26;
        ResponseState r27 = new ResponseState("CONFLICT", 19, 409, "Conflict");
        CONFLICT = r27;
        ResponseState r28 = new ResponseState("GONE", 20, 410, "Gone");
        GONE = r28;
        ResponseState r29 = new ResponseState("LENGTH_REQUIRED", 21, 411, "Length Required");
        LENGTH_REQUIRED = r29;
        ResponseState r30 = new ResponseState("PRECONDITION_FAILED", 22, 412, "Precondition Failed");
        PRECONDITION_FAILED = r30;
        ResponseState r31 = new ResponseState("PAYLOAD_TOO_LARGE", 23, 413, "Payload Too Large");
        PAYLOAD_TOO_LARGE = r31;
        ResponseState r32 = new ResponseState("UNSUPPORTED_MEDIA_TYPE", 24, 415, "Unsupported Media Type");
        UNSUPPORTED_MEDIA_TYPE = r32;
        ResponseState r33 = new ResponseState("RANGE_NOT_SATISFIABLE", 25, 416, "Requested Range Not Satisfiable");
        RANGE_NOT_SATISFIABLE = r33;
        ResponseState r34 = new ResponseState("EXPECTATION_FAILED", 26, 417, "Expectation Failed");
        EXPECTATION_FAILED = r34;
        ResponseState r35 = new ResponseState("TOO_MANY_REQUESTS", 27, 429, "Too Many Requests");
        TOO_MANY_REQUESTS = r35;
        ResponseState r36 = new ResponseState("INTERNAL_ERROR", 28, 500, "Internal Server Error");
        INTERNAL_ERROR = r36;
        ResponseState r37 = new ResponseState("NOT_IMPLEMENTED", 29, 501, "Not Implemented");
        NOT_IMPLEMENTED = r37;
        ResponseState r38 = new ResponseState("SERVICE_UNAVAILABLE", 30, 503, "Service Unavailable");
        SERVICE_UNAVAILABLE = r38;
        ResponseState r39 = new ResponseState("UNSUPPORTED_HTTP_VERSION", 31, 505, "HTTP Version Not Supported");
        UNSUPPORTED_HTTP_VERSION = r39;
        $VALUES = new ResponseState[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39};
    }

    private ResponseState(String r10, int r11, int r12, String r13) {
        super(r10, r11);
        this.mResponseCode = r12;
        this.mResponseDescription = r13;
    }

    public static ResponseState lookup(int r10) {
        ResponseState[] r11 = values();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        ResponseState r14 = r11[r13];
        if (r14.getResponseCode() == r10) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L8:
        return null;
    }

    public static ResponseState valueOf(String r10) {
        return (ResponseState) Enum.valueOf(ResponseState.class, r10);
    }

    public static ResponseState[] values() {
        return (ResponseState[]) $VALUES.clone();
    }

    @Override // com.media.cache.http.IState
    public String getDescription() {
        return "" + this.mResponseCode + " " + this.mResponseDescription;
    }

    @Override // com.media.cache.http.IState
    public int getResponseCode() {
        return this.mResponseCode;
    }
}
