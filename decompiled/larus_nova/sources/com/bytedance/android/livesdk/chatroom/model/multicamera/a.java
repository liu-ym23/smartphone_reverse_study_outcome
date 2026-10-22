package com.bytedance.android.livesdk.chatroom.model.multicamera;

import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/multicamera/a;", "Lvh7/c;", "", "getCameraId", "()Ljava/lang/Long;", "setCameraId", "(Ljava/lang/Long;)V", "getCameraId$annotations", "()V", ShortVideoSegments.KEY_CAMERA_ID, "", "getCameraName", "()Ljava/lang/String;", "setCameraName", "(Ljava/lang/String;)V", "getCameraName$annotations", "cameraName", "getRtmpPushUrl", "setRtmpPushUrl", "getRtmpPushUrl$annotations", "rtmpPushUrl", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.model.multicamera.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C1621a {
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = VSConstants.VS_CAMERA_ID)
    Long getCameraId();

    @FieldName(name = "camera_name")
    String getCameraName();

    @FieldName(name = "rtmp_push_url")
    String getRtmpPushUrl();

    @FieldName(name = "camera_id#setter")
    void setCameraId(Long r100);

    @FieldName(name = "camera_name#setter")
    void setCameraName(String r100);

    @FieldName(name = "rtmp_push_url#setter")
    void setRtmpPushUrl(String r100);
}
