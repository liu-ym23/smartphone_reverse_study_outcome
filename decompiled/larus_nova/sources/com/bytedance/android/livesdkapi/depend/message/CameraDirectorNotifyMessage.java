package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.CameraDirectorNotifyMessage")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR$\u0010\"\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001e¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/CameraDirectorNotifyMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Ljava/io/Serializable;", "", "status", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "", "toast", "Ljava/lang/String;", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "", "connectedNum", "Ljava/lang/Long;", "getConnectedNum", "()Ljava/lang/Long;", "setConnectedNum", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/livesdkapi/depend/message/DeviceViewMessage;", "currentDeviceView", "Lcom/bytedance/android/livesdkapi/depend/message/DeviceViewMessage;", "getCurrentDeviceView", "()Lcom/bytedance/android/livesdkapi/depend/message/DeviceViewMessage;", "setCurrentDeviceView", "(Lcom/bytedance/android/livesdkapi/depend/message/DeviceViewMessage;)V", "mainDeviceView", "getMainDeviceView", "setMainDeviceView", "subDeviceView", "getSubDeviceView", "setSubDeviceView", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CameraDirectorNotifyMessage extends o0 implements Serializable, h {

    @SerializedName("connected_num")
    protected Long connectedNum;

    @SerializedName("current_device_view")
    protected DeviceViewMessage currentDeviceView;

    @SerializedName("main_device_view")
    protected DeviceViewMessage mainDeviceView;

    @SerializedName("status")
    protected Integer status;

    @SerializedName("sub_device_view")
    protected DeviceViewMessage subDeviceView;

    @SerializedName("toast")
    protected String toast;

    public CameraDirectorNotifyMessage() {
        this.type = MessageType.LIVE_MULTI_CAMERA_DIRECTOR;
    }

    public final Long getConnectedNum() {
        return this.connectedNum;
    }

    public final DeviceViewMessage getCurrentDeviceView() {
        return this.currentDeviceView;
    }

    public final DeviceViewMessage getMainDeviceView() {
        return this.mainDeviceView;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final DeviceViewMessage getSubDeviceView() {
        return this.subDeviceView;
    }

    public final String getToast() {
        return this.toast;
    }

    public CameraDirectorNotifyMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.subDeviceView = new DeviceViewMessage(r100);
        goto L3
    L8:
        this.mainDeviceView = new DeviceViewMessage(r100);
        goto L3
    L9:
        this.currentDeviceView = new DeviceViewMessage(r100);
        goto L3
    L10:
        this.connectedNum = Long.valueOf(r100.j());
        goto L3
    L11:
        this.toast = am3.h.c(r100);
        goto L3
    L12:
        this.status = Integer.valueOf(r100.i());
        goto L3
    L13:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        this.type = MessageType.LIVE_MULTI_CAMERA_DIRECTOR;
    }

    public final void setConnectedNum(Long r100) {
        this.connectedNum = r100;
    }

    public final void setCurrentDeviceView(DeviceViewMessage r100) {
        this.currentDeviceView = r100;
    }

    public final void setMainDeviceView(DeviceViewMessage r100) {
        this.mainDeviceView = r100;
    }

    public final void setStatus(Integer r100) {
        this.status = r100;
    }

    public final void setSubDeviceView(DeviceViewMessage r100) {
        this.subDeviceView = r100;
    }

    public final void setToast(String r100) {
        this.toast = r100;
    }
}
