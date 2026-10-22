package com.android.ttcjpaysdk.thirdparty.voiceprint.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/ResponseCode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "CONTINUE_VERIFY", "RECOGNIZE_FAIL", "FAILED", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ResponseCode extends Enum<ResponseCode> {
    private static final /* synthetic */ ResponseCode[] $VALUES = null;
    public static final ResponseCode CONTINUE_VERIFY = null;
    public static final ResponseCode FAILED = null;
    public static final ResponseCode RECOGNIZE_FAIL = null;
    public static final ResponseCode SUCCESS = null;
    private final String value;

    private static final /* synthetic */ ResponseCode[] $values() {
        return new ResponseCode[]{SUCCESS, CONTINUE_VERIFY, RECOGNIZE_FAIL, FAILED};
    }

    public static ResponseCode valueOf(String r100) {
        return (ResponseCode) a.a(ResponseCode.class, r100);
    }

    public static ResponseCode[] values() {
        return (ResponseCode[]) $VALUES.clone();
    }

    static {
        SUCCESS = new ResponseCode("SUCCESS", 0, "MP000000");
        CONTINUE_VERIFY = new ResponseCode("CONTINUE_VERIFY", 1, "MP181001");
        RECOGNIZE_FAIL = new ResponseCode("RECOGNIZE_FAIL", 2, "MP1812");
        FAILED = new ResponseCode("FAILED", 3, "MP181003");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private ResponseCode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
