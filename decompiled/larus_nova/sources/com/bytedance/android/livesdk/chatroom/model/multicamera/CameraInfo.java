package com.bytedance.android.livesdk.chatroom.model.multicamera;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/multicamera/CameraInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/multicamera/a;", "", ShortVideoSegments.KEY_CAMERA_ID, "Ljava/lang/Long;", "getCameraId", "()Ljava/lang/Long;", "setCameraId", "(Ljava/lang/Long;)V", "", "cameraName", "Ljava/lang/String;", "getCameraName", "()Ljava/lang/String;", "setCameraName", "(Ljava/lang/String;)V", "rtmpPushUrl", "getRtmpPushUrl", "setRtmpPushUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CameraInfo extends FlexModelBase<a> implements a, h {

    @SerializedName(VSConstants.VS_CAMERA_ID)
    protected Long cameraId;

    @SerializedName("camera_name")
    protected String cameraName;

    @SerializedName("rtmp_push_url")
    protected String rtmpPushUrl;

    public CameraInfo() {
        super(a.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.multicamera.a
    public Long getCameraId() {
        return this.cameraId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.multicamera.a
    public String getCameraName() {
        return this.cameraName;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.multicamera.a
    public String getRtmpPushUrl() {
        return this.rtmpPushUrl;
    }

    public CameraInfo(g r100) {
        super(a.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.cameraId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.cameraName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.rtmpPushUrl = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.multicamera.a
    public void setCameraId(Long r100) {
        this.cameraId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.multicamera.a
    public void setCameraName(String r100) {
        this.cameraName = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.multicamera.a
    public void setRtmpPushUrl(String r100) {
        this.rtmpPushUrl = r100;
    }
}
