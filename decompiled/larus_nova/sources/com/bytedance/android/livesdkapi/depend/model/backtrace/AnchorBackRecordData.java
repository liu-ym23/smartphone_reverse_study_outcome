package com.bytedance.android.livesdkapi.depend.model.backtrace;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.room.AnchorBackRecordData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/backtrace/AnchorBackRecordData;", "", "()V", "executionId", "", "getExecutionId", "()Ljava/lang/String;", "setExecutionId", "(Ljava/lang/String;)V", "timeoutSeconds", "", "getTimeoutSeconds", "()J", "setTimeoutSeconds", "(J)V", "waitSeconds", "getWaitSeconds", "setWaitSeconds", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorBackRecordData implements h {

    @SerializedName("execution_id")
    protected String executionId;

    @SerializedName("wait_timeout_seconds")
    protected long timeoutSeconds;

    @SerializedName("approximate_wait_seconds")
    protected long waitSeconds;

    public AnchorBackRecordData() {
    }

    public final String getExecutionId() {
        return this.executionId;
    }

    public final long getTimeoutSeconds() {
        return this.timeoutSeconds;
    }

    public final long getWaitSeconds() {
        return this.waitSeconds;
    }

    public AnchorBackRecordData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.waitSeconds = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.timeoutSeconds = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.executionId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setExecutionId(String r100) {
        this.executionId = r100;
    }

    public final void setTimeoutSeconds(long r100) {
        this.timeoutSeconds = r100;
    }

    public final void setWaitSeconds(long r100) {
        this.waitSeconds = r100;
    }
}
