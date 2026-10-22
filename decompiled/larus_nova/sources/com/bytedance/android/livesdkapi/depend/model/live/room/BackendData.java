package com.bytedance.android.livesdkapi.depend.model.live.room;

import am3.g;
import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.room.EnterRoomBackendResponse.BackendData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\u001c\u0010'\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001a¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/room/BackendData;", "", "()V", "bizResp", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/room/BizResp;", "getBizResp", "()Ljava/util/Map;", "setBizResp", "(Ljava/util/Map;)V", "isApiAllFailure", "", "()Z", "setApiAllFailure", "(Z)V", "localBackendResponseTimeStamp", "", "getLocalBackendResponseTimeStamp", "()J", "setLocalBackendResponseTimeStamp", "(J)V", "logId", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", TriggerTiming.NOW, "getNow", "setNow", "requestType", "", "getRequestType", "()I", "setRequestType", "(I)V", "roomId", "getRoomId", "setRoomId", "traceId", "getTraceId", "setTraceId", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BackendData implements h {

    @SerializedName("biz_resp")
    protected Map<String, BizResp> bizResp;
    private boolean isApiAllFailure;
    private long localBackendResponseTimeStamp;
    private String logId;
    private long now;
    private int requestType;
    private long roomId;
    private String traceId;

    public BackendData() {
    }

    public BackendData(g r110) {
        this.bizResp = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L25;
        if (r101 != 2) goto L7;
        long r102 = r110.c();
        String r103 = null;
        BizResp r104 = null;
    L9:
        int r105 = r110.f();
        if (r105 == (-1)) goto L17;
        if (r105 != 1) goto L13;
        r103 = am3.h.c(r110);
        goto L9
    L13:
        if (r105 != 2) goto L14;
        r104 = new BizResp(r110);
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r102);
        Map<String, BizResp> r106 = this.bizResp;
        if (r103 == null) goto L24;
        if (r104 == null) goto L22;
        r106.put(r103, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.e(r110);
        goto L3
    L25:
        r110.d(r100);
    }

    public final Map<String, BizResp> getBizResp() {
        return this.bizResp;
    }

    public final long getLocalBackendResponseTimeStamp() {
        return this.localBackendResponseTimeStamp;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final long getNow() {
        return this.now;
    }

    public final int getRequestType() {
        return this.requestType;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final boolean isApiAllFailure() {
        return this.isApiAllFailure;
    }

    public final void setApiAllFailure(boolean r100) {
        this.isApiAllFailure = r100;
    }

    public final void setBizResp(Map<String, BizResp> r100) {
        this.bizResp = r100;
    }

    public final void setLocalBackendResponseTimeStamp(long r100) {
        this.localBackendResponseTimeStamp = r100;
    }

    public final void setLogId(String r100) {
        this.logId = r100;
    }

    public final void setNow(long r100) {
        this.now = r100;
    }

    public final void setRequestType(int r100) {
        this.requestType = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setTraceId(String r100) {
        this.traceId = r100;
    }
}
