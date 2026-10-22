package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.DeviceViewInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/DeviceViewMessage;", "", "()V", "deviceId", "", "getDeviceId", "()Ljava/lang/Long;", "setDeviceId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "deviceModel", "", "getDeviceModel", "()Ljava/lang/String;", "setDeviceModel", "(Ljava/lang/String;)V", "rtcInfo", "Lcom/bytedance/android/livesdkapi/depend/message/RTCInfo;", "getRtcInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/RTCInfo;", "setRtcInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/RTCInfo;)V", "viewId", "getViewId", "setViewId", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeviceViewMessage implements h {

    @SerializedName("device_id")
    protected Long deviceId;

    @SerializedName("device_model")
    protected String deviceModel;

    @SerializedName("rtc_info")
    protected RTCInfo rtcInfo;

    @SerializedName(BitableResourceData.KEY_VIEW_ID)
    protected Long viewId;

    public DeviceViewMessage() {
    }

    public final Long getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final RTCInfo getRtcInfo() {
        return this.rtcInfo;
    }

    public final Long getViewId() {
        return this.viewId;
    }

    public DeviceViewMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.deviceId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.deviceModel = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.viewId = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.rtcInfo = new RTCInfo(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setDeviceId(Long r100) {
        this.deviceId = r100;
    }

    public final void setDeviceModel(String r100) {
        this.deviceModel = r100;
    }

    public final void setRtcInfo(RTCInfo r100) {
        this.rtcInfo = r100;
    }

    public final void setViewId(Long r100) {
        this.viewId = r100;
    }
}
