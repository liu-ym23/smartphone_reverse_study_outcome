package com.android.ttcjpaysdk.thirdparty.data;

import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/RequestType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FORGET_PWD_VERIFY", "CHECK_NOTHING_VERIFY", "TOKEN_VERIFY", "DEFAULT_FACE_VERIFY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum RequestType extends Enum<RequestType> {
    private static final /* synthetic */ RequestType[] $VALUES = null;
    public static final RequestType CHECK_NOTHING_VERIFY = null;
    public static final RequestType DEFAULT_FACE_VERIFY = null;
    public static final RequestType FORGET_PWD_VERIFY = null;
    public static final RequestType TOKEN_VERIFY = null;
    private final String value;

    private static final /* synthetic */ RequestType[] $values() {
        return new RequestType[]{FORGET_PWD_VERIFY, CHECK_NOTHING_VERIFY, TOKEN_VERIFY, DEFAULT_FACE_VERIFY};
    }

    public static RequestType valueOf(String r100) {
        return (RequestType) a.a(RequestType.class, r100);
    }

    public static RequestType[] values() {
        return (RequestType[]) $VALUES.clone();
    }

    static {
        FORGET_PWD_VERIFY = new RequestType("FORGET_PWD_VERIFY", 0, Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
        CHECK_NOTHING_VERIFY = new RequestType("CHECK_NOTHING_VERIFY", 1, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        TOKEN_VERIFY = new RequestType("TOKEN_VERIFY", 2, "11");
        DEFAULT_FACE_VERIFY = new RequestType("DEFAULT_FACE_VERIFY", 3, Constants.VIA_REPORT_TYPE_START_GROUP);
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private RequestType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
