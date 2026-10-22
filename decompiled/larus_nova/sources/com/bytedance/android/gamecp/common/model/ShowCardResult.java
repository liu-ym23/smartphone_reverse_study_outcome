package com.bytedance.android.gamecp.common.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/gamecp/common/model/ShowCardResult;", "", "", "code", "I", "getCode", "()I", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "SUCCESS", "SETTGING_DISABLE", "PAID_LIVE_RIGHT", "PROP_DISABLE", "DATA_ERROR", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShowCardResult extends Enum<ShowCardResult> {
    public static final ShowCardResult DATA_ERROR = null;
    public static final ShowCardResult PAID_LIVE_RIGHT = null;
    public static final ShowCardResult PROP_DISABLE = null;
    public static final ShowCardResult SETTGING_DISABLE = null;
    public static final ShowCardResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShowCardResult[] f56532a = null;
    private final int code;
    private final String msg;

    static {
        ShowCardResult r100 = new ShowCardResult("SUCCESS", 0, 0, "success");
        SUCCESS = r100;
        ShowCardResult r101 = new ShowCardResult("SETTGING_DISABLE", 1, -1, "setting disable");
        SETTGING_DISABLE = r101;
        ShowCardResult r102 = new ShowCardResult("PAID_LIVE_RIGHT", 2, -2, "do not has full watch right in paid live");
        PAID_LIVE_RIGHT = r102;
        ShowCardResult r103 = new ShowCardResult("PROP_DISABLE", 3, -3, "prop card disable prop");
        PROP_DISABLE = r103;
        ShowCardResult r104 = new ShowCardResult("DATA_ERROR", 4, -4, "data has error");
        DATA_ERROR = r104;
        f56532a = new ShowCardResult[]{r100, r101, r102, r103, r104};
    }

    public static ShowCardResult valueOf(String r100) {
        return (ShowCardResult) r27.a.a(ShowCardResult.class, r100);
    }

    public static ShowCardResult[] values() {
        return (ShowCardResult[]) f56532a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public ShowCardResult(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.msg = r103;
    }
}
