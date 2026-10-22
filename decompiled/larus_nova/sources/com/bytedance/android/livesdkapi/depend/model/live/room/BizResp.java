package com.bytedance.android.livesdkapi.depend.model.live.room;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.room.BizResp")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001e\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001e\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/room/BizResp;", "", "()V", "actualRoomId", "", "getActualRoomId", "()J", "setActualRoomId", "(J)V", "data", "", "getData", "()[B", "setData", "([B)V", "dataType", "", "getDataType", "()Ljava/lang/String;", "setDataType", "(Ljava/lang/String;)V", "errorInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/room/BizErrInfo;", "getErrorInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/room/BizErrInfo;", "setErrorInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/room/BizErrInfo;)V", "isSuccess", "", "()Z", "setSuccess", "(Z)V", "jsonData", "getJsonData", "setJsonData", "respType", "getRespType", "setRespType", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, "getWaitTime", "setWaitTime", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BizResp implements h {

    @SerializedName("actual_room_id")
    protected long actualRoomId;

    @SerializedName("data")
    protected byte[] data;

    @SerializedName("data_type")
    protected String dataType;

    @SerializedName("err_detail")
    protected BizErrInfo errorInfo;

    @SerializedName("is_success")
    protected boolean isSuccess;

    @SerializedName("data_str")
    protected String jsonData;

    @SerializedName("resp_type")
    protected long respType;

    @SerializedName("wait_time_ms")
    protected long waitTime;

    public BizResp() {
    }

    public final long getActualRoomId() {
        return this.actualRoomId;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getDataType() {
        return this.dataType;
    }

    public final BizErrInfo getErrorInfo() {
        return this.errorInfo;
    }

    public final String getJsonData() {
        return this.jsonData;
    }

    public final long getRespType() {
        return this.respType;
    }

    public final long getWaitTime() {
        return this.waitTime;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public BizResp(g r100) {
        new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.actualRoomId = r100.j();
        goto L3
    L8:
        this.waitTime = r100.j();
        goto L3
    L9:
        this.jsonData = am3.h.c(r100);
        goto L3
    L10:
        this.respType = r100.j();
        goto L3
    L11:
        this.errorInfo = new BizErrInfo(r100);
        goto L3
    L12:
        this.isSuccess = am3.h.a(r100);
        goto L3
    L13:
        this.dataType = am3.h.c(r100);
        goto L3
    L14:
        this.data = am3.h.b(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setActualRoomId(long r100) {
        this.actualRoomId = r100;
    }

    public final void setData(byte[] r100) {
        this.data = r100;
    }

    public final void setDataType(String r100) {
        this.dataType = r100;
    }

    public final void setErrorInfo(BizErrInfo r100) {
        this.errorInfo = r100;
    }

    public final void setJsonData(String r100) {
        this.jsonData = r100;
    }

    public final void setRespType(long r100) {
        this.respType = r100;
    }

    public final void setSuccess(boolean r100) {
        this.isSuccess = r100;
    }

    public final void setWaitTime(long r100) {
        this.waitTime = r100;
    }
}
