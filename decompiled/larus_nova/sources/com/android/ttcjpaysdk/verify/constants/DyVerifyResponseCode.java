package com.android.ttcjpaysdk.verify.constants;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/verify/constants/DyVerifyResponseCode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "PWD_VERIFY_FAIL", "MSG_VERIFY_FAIL", "MSG_VERIFY_LIMIT", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum DyVerifyResponseCode extends Enum<DyVerifyResponseCode> {
    private static final /* synthetic */ DyVerifyResponseCode[] $VALUES = null;
    public static final DyVerifyResponseCode MSG_VERIFY_FAIL = null;
    public static final DyVerifyResponseCode MSG_VERIFY_LIMIT = null;
    public static final DyVerifyResponseCode PWD_VERIFY_FAIL = null;
    public static final DyVerifyResponseCode SUCCESS = null;
    private final String value;

    private static final /* synthetic */ DyVerifyResponseCode[] $values() {
        return new DyVerifyResponseCode[]{SUCCESS, PWD_VERIFY_FAIL, MSG_VERIFY_FAIL, MSG_VERIFY_LIMIT};
    }

    public static DyVerifyResponseCode valueOf(String r100) {
        return (DyVerifyResponseCode) a.a(DyVerifyResponseCode.class, r100);
    }

    public static DyVerifyResponseCode[] values() {
        return (DyVerifyResponseCode[]) $VALUES.clone();
    }

    static {
        SUCCESS = new DyVerifyResponseCode("SUCCESS", 0, "MP000000");
        PWD_VERIFY_FAIL = new DyVerifyResponseCode("PWD_VERIFY_FAIL", 1, "MP020403");
        MSG_VERIFY_FAIL = new DyVerifyResponseCode("MSG_VERIFY_FAIL", 2, "MP000003");
        MSG_VERIFY_LIMIT = new DyVerifyResponseCode("MSG_VERIFY_LIMIT", 3, "MP010018");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private DyVerifyResponseCode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
