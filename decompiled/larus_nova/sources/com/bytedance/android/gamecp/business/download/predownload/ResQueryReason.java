package com.bytedance.android.gamecp.business.download.predownload;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/gamecp/business/download/predownload/ResQueryReason;", "", "", "failureCode", "I", "getFailureCode", "()I", "setFailureCode", "(I)V", "REASON_SUC", "REASON_PARAMS_FAIL", "REASON_GET_DOWNLOAD_INFO", "REASON_FILE_UN_EXIST", "REASON_GET_FILE_URI_FAIL", "REASON_FILE_UN_DOWNLOAD", "REASON_URI_FAIL", "REASON_SETTINGS_CLOSE", "REASON_GET_GAME_INFO_EXCEPTION", "REASON_CP_OPERATION_EXCEPTION", "REASON_DELETE_FAIL", "REASON_OTHER_URLS_NULL", "REASON_DELETE_EXCEPTION", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ResQueryReason extends Enum<ResQueryReason> {
    public static final ResQueryReason REASON_CP_OPERATION_EXCEPTION = null;
    public static final ResQueryReason REASON_DELETE_EXCEPTION = null;
    public static final ResQueryReason REASON_DELETE_FAIL = null;
    public static final ResQueryReason REASON_FILE_UN_DOWNLOAD = null;
    public static final ResQueryReason REASON_FILE_UN_EXIST = null;
    public static final ResQueryReason REASON_GET_DOWNLOAD_INFO = null;
    public static final ResQueryReason REASON_GET_FILE_URI_FAIL = null;
    public static final ResQueryReason REASON_GET_GAME_INFO_EXCEPTION = null;
    public static final ResQueryReason REASON_OTHER_URLS_NULL = null;
    public static final ResQueryReason REASON_PARAMS_FAIL = null;
    public static final ResQueryReason REASON_SETTINGS_CLOSE = null;
    public static final ResQueryReason REASON_SUC = null;
    public static final ResQueryReason REASON_URI_FAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResQueryReason[] f52889a = null;
    private int failureCode;

    public static ResQueryReason valueOf(String r100) {
        return (ResQueryReason) a.a(ResQueryReason.class, r100);
    }

    public static ResQueryReason[] values() {
        return (ResQueryReason[]) f52889a.clone();
    }

    static {
        ResQueryReason r100 = new ResQueryReason("REASON_SUC", 0, 0);
        REASON_SUC = r100;
        ResQueryReason r101 = new ResQueryReason("REASON_PARAMS_FAIL", 1, -1);
        REASON_PARAMS_FAIL = r101;
        ResQueryReason r102 = new ResQueryReason("REASON_GET_DOWNLOAD_INFO", 2, -2);
        REASON_GET_DOWNLOAD_INFO = r102;
        ResQueryReason r103 = new ResQueryReason("REASON_FILE_UN_EXIST", 3, -3);
        REASON_FILE_UN_EXIST = r103;
        ResQueryReason r104 = new ResQueryReason("REASON_GET_FILE_URI_FAIL", 4, -4);
        REASON_GET_FILE_URI_FAIL = r104;
        ResQueryReason r105 = new ResQueryReason("REASON_FILE_UN_DOWNLOAD", 5, -5);
        REASON_FILE_UN_DOWNLOAD = r105;
        ResQueryReason r106 = new ResQueryReason("REASON_URI_FAIL", 6, -6);
        REASON_URI_FAIL = r106;
        ResQueryReason r107 = new ResQueryReason("REASON_SETTINGS_CLOSE", 7, -7);
        REASON_SETTINGS_CLOSE = r107;
        ResQueryReason r108 = new ResQueryReason("REASON_GET_GAME_INFO_EXCEPTION", 8, -8);
        REASON_GET_GAME_INFO_EXCEPTION = r108;
        ResQueryReason r109 = new ResQueryReason("REASON_CP_OPERATION_EXCEPTION", 9, -9);
        REASON_CP_OPERATION_EXCEPTION = r109;
        ResQueryReason r110 = new ResQueryReason("REASON_DELETE_FAIL", 10, -10);
        REASON_DELETE_FAIL = r110;
        ResQueryReason r111 = new ResQueryReason("REASON_OTHER_URLS_NULL", 11, -11);
        REASON_OTHER_URLS_NULL = r111;
        ResQueryReason r112 = new ResQueryReason("REASON_DELETE_EXCEPTION", 12, -12);
        REASON_DELETE_EXCEPTION = r112;
        f52889a = new ResQueryReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final int getFailureCode() {
        return this.failureCode;
    }

    public final void setFailureCode(int r100) {
        this.failureCode = r100;
    }

    public ResQueryReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.failureCode = r102;
    }
}
