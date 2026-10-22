package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.RTCInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/RTCInfo;", "", "()V", "liveCoreExtraInfo", "", "getLiveCoreExtraInfo", "()Ljava/lang/String;", "setLiveCoreExtraInfo", "(Ljava/lang/String;)V", "rtcExtraInfo", "getRtcExtraInfo", "setRtcExtraInfo", "userId", "getUserId", "setUserId", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RTCInfo implements h {

    @SerializedName("live_core_extra_info")
    protected String liveCoreExtraInfo;

    @SerializedName("rtc_extra_info")
    protected String rtcExtraInfo;

    @SerializedName("user_id")
    protected String userId;

    public RTCInfo() {
    }

    public RTCInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.userId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.rtcExtraInfo = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.liveCoreExtraInfo = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String getLiveCoreExtraInfo() {
        return this.liveCoreExtraInfo;
    }

    public final String getRtcExtraInfo() {
        return this.rtcExtraInfo;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setLiveCoreExtraInfo(String r100) {
        this.liveCoreExtraInfo = r100;
    }

    public final void setRtcExtraInfo(String r100) {
        this.rtcExtraInfo = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }
}
