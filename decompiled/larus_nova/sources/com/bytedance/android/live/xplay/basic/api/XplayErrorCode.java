package com.bytedance.android.live.xplay.basic.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/xplay/basic/api/XplayErrorCode;", "", "", "code", "I", "getCode", "()I", "", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "STATE_NOT_STOPPED", "ALREADY_CREATED", "STATE_NOT_LOADED", "XPLAY_INSTANCE_NULL", "XPLAY_PLUGIN_FAILED", "REQUEST_APP_TOKEN_FAILED", "GAME_LOADED_FAILED", "REQUEST_APP_START_FAILED", "RECEIVE_FIRST_FRAME_TIMEOUT", "XPLAY_INTERNAL_ERROR", "UNKNOWN", "livexplaygamebasic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum XplayErrorCode extends Enum<XplayErrorCode> {
    public static final XplayErrorCode ALREADY_CREATED = null;
    public static final XplayErrorCode GAME_LOADED_FAILED = null;
    public static final XplayErrorCode RECEIVE_FIRST_FRAME_TIMEOUT = null;
    public static final XplayErrorCode REQUEST_APP_START_FAILED = null;
    public static final XplayErrorCode REQUEST_APP_TOKEN_FAILED = null;
    public static final XplayErrorCode STATE_NOT_LOADED = null;
    public static final XplayErrorCode STATE_NOT_STOPPED = null;
    public static final XplayErrorCode UNKNOWN = null;
    public static final XplayErrorCode XPLAY_INSTANCE_NULL = null;
    public static final XplayErrorCode XPLAY_INTERNAL_ERROR = null;
    public static final XplayErrorCode XPLAY_PLUGIN_FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XplayErrorCode[] f102773a = null;
    private final int code;
    private final String errorMsg;

    public static XplayErrorCode valueOf(String r100) {
        return (XplayErrorCode) a.a(XplayErrorCode.class, r100);
    }

    public static XplayErrorCode[] values() {
        return (XplayErrorCode[]) f102773a.clone();
    }

    static {
        XplayErrorCode r100 = new XplayErrorCode("STATE_NOT_STOPPED", 0, 101, "state is not stopped");
        STATE_NOT_STOPPED = r100;
        XplayErrorCode r101 = new XplayErrorCode("ALREADY_CREATED", 1, 102, "Xplay instance is already created");
        ALREADY_CREATED = r101;
        XplayErrorCode r102 = new XplayErrorCode("STATE_NOT_LOADED", 2, 103, "state is not loaded");
        STATE_NOT_LOADED = r102;
        XplayErrorCode r103 = new XplayErrorCode("XPLAY_INSTANCE_NULL", 3, 104, "Xplay instance is null");
        XPLAY_INSTANCE_NULL = r103;
        XplayErrorCode r104 = new XplayErrorCode("XPLAY_PLUGIN_FAILED", 4, 105, "xplay plugin failed");
        XPLAY_PLUGIN_FAILED = r104;
        XplayErrorCode r105 = new XplayErrorCode("REQUEST_APP_TOKEN_FAILED", 5, 301, "request token failure");
        REQUEST_APP_TOKEN_FAILED = r105;
        XplayErrorCode r106 = new XplayErrorCode("GAME_LOADED_FAILED", 6, 302, "game is not loaded");
        GAME_LOADED_FAILED = r106;
        XplayErrorCode r107 = new XplayErrorCode("REQUEST_APP_START_FAILED", 7, 303, "request app start failure");
        REQUEST_APP_START_FAILED = r107;
        XplayErrorCode r108 = new XplayErrorCode("RECEIVE_FIRST_FRAME_TIMEOUT", 8, 304, "receive first frame timeout");
        RECEIVE_FIRST_FRAME_TIMEOUT = r108;
        XplayErrorCode r109 = new XplayErrorCode("XPLAY_INTERNAL_ERROR", 9, -1, "xplay internal error");
        XPLAY_INTERNAL_ERROR = r109;
        XplayErrorCode r110 = new XplayErrorCode("UNKNOWN", 10, 0, "unknown");
        UNKNOWN = r110;
        f102773a = new XplayErrorCode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public XplayErrorCode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.errorMsg = r103;
    }
}
