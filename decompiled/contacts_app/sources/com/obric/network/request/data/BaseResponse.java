package com.obric.network.request.data;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.constant.ReportProtocal;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/obric/network/request/data/BaseResponse;", "", "()V", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "(ILjava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "logId", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "getMsg", "setMsg", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class BaseResponse {
    private int code;

    @SerializedName(ReportProtocal.KEY_LOG_ID)
    private String logId;
    private String msg;

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.msg = r2;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final void setLogId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.logId = r2;
    }

    public BaseResponse() {
        this.msg = "";
        this.logId = "";
    }

    public BaseResponse(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        this.logId = "";
        this.code = r2;
        this.msg = r3;
    }
}
