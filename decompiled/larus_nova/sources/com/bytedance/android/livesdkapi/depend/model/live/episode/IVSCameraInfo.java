package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010 \u001a\u0004\u0018\u00010\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR$\u0010'\u001a\u0004\u0018\u00010!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\t\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010+\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\t\u001a\u0004\b(\u0010\u0005\"\u0004\b)\u0010\u0007R\"\u0010/\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\t\u001a\u0004\b,\u0010\u0005\"\u0004\b-\u0010\u0007R\"\u00106\u001a\u0002008&@&X§\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\t\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010=\u001a\u0004\u0018\u0001078&@&X§\u000e¢\u0006\u0012\u0012\u0004\b<\u0010\t\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010A\u001a\u0002008&@&X§\u000e¢\u0006\u0012\u0012\u0004\b@\u0010\t\u001a\u0004\b>\u00102\"\u0004\b?\u00104R\"\u0010E\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bD\u0010\t\u001a\u0004\bB\u0010\u0005\"\u0004\bC\u0010\u0007R$\u0010L\u001a\u0004\u0018\u00010F8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bK\u0010\t\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010P\u001a\u0004\u0018\u00010\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\bO\u0010\t\u001a\u0004\bM\u0010\u0018\"\u0004\bN\u0010\u001a¨\u0006Q"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSCameraInfo;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSCameraInfoEx;", "", "getCameraId", "()J", "setCameraId", "(J)V", "getCameraId$annotations", "()V", ShortVideoSegments.KEY_CAMERA_ID, "", "getCameraIdStr", "()Ljava/lang/String;", "setCameraIdStr", "(Ljava/lang/String;)V", "getCameraIdStr$annotations", "cameraIdStr", "getTitle", d.f25925o, "getTitle$annotations", "title", "Lpy/k;", "getCover", "()Lpy/k;", "setCover", "(Lpy/k;)V", "getCover$annotations", "cover", "getVerticalCover", "setVerticalCover", "getVerticalCover$annotations", "verticalCover", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "setStreamUrl", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;)V", "getStreamUrl$annotations", "streamUrl", "getStartTime", "setStartTime", "getStartTime$annotations", DyPayConstant.KEY_START_TIME, "getEndTime", "setEndTime", "getEndTime$annotations", "endTime", "", "getStyle", "()I", "setStyle", "(I)V", "getStyle$annotations", "style", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "getCameraRoomAuth", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "setCameraRoomAuth", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;)V", "getCameraRoomAuth$annotations", "cameraRoomAuth", "getCameraType", "setCameraType", "getCameraType$annotations", "cameraType", "getGroupId", "setGroupId", "getGroupId$annotations", "groupId", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ICameraMatchInfo;", "getCameraMatchInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ICameraMatchInfo;", "setCameraMatchInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ICameraMatchInfo;)V", "getCameraMatchInfo$annotations", "cameraMatchInfo", "getLabel", "setLabel", "getLabel$annotations", "label", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVSCameraInfo extends c<IVSCameraInfo>, IVSCameraInfoEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = VSConstants.VS_CAMERA_ID)
        public static /* synthetic */ void getCameraId$annotations() {
        }

        @FieldName(name = "camera_id_str")
        public static /* synthetic */ void getCameraIdStr$annotations() {
        }

        @FieldName(name = "camera_match_info")
        public static /* synthetic */ void getCameraMatchInfo$annotations() {
        }

        @FieldName(name = "camera_room_auth")
        public static /* synthetic */ void getCameraRoomAuth$annotations() {
        }

        @FieldName(name = "camera_type")
        public static /* synthetic */ void getCameraType$annotations() {
        }

        @FieldName(name = "cover")
        public static /* synthetic */ void getCover$annotations() {
        }

        @FieldName(name = "end_time")
        public static /* synthetic */ void getEndTime$annotations() {
        }

        @FieldName(name = "group_id")
        public static /* synthetic */ void getGroupId$annotations() {
        }

        @FieldName(name = "label")
        public static /* synthetic */ void getLabel$annotations() {
        }

        @FieldName(name = ILoadStallMonitor.START_TIME)
        public static /* synthetic */ void getStartTime$annotations() {
        }

        @FieldName(name = "stream_info")
        public static /* synthetic */ void getStreamUrl$annotations() {
        }

        @FieldName(name = "style")
        public static /* synthetic */ void getStyle$annotations() {
        }

        @FieldName(name = "title")
        public static /* synthetic */ void getTitle$annotations() {
        }

        @FieldName(name = "cover_vertical")
        public static /* synthetic */ void getVerticalCover$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = VSConstants.VS_CAMERA_ID)
    long getCameraId();

    @FieldName(name = "camera_id_str")
    String getCameraIdStr();

    @FieldName(name = "camera_match_info")
    ICameraMatchInfo getCameraMatchInfo();

    @FieldName(name = "camera_room_auth")
    IRoomAuthStatus getCameraRoomAuth();

    @FieldName(name = "camera_type")
    int getCameraType();

    @FieldName(name = "cover")
    k getCover();

    @FieldName(name = "end_time")
    long getEndTime();

    @FieldName(name = "group_id")
    long getGroupId();

    @FieldName(name = "label")
    k getLabel();

    @FieldName(name = ILoadStallMonitor.START_TIME)
    long getStartTime();

    @FieldName(name = "stream_info")
    IBaseStreamUrl getStreamUrl();

    @FieldName(name = "style")
    int getStyle();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "cover_vertical")
    k getVerticalCover();

    @FieldName(name = "camera_id#setter")
    void setCameraId(long r100);

    @FieldName(name = "camera_id_str#setter")
    void setCameraIdStr(String r100);

    @FieldName(name = "camera_match_info#setter")
    void setCameraMatchInfo(ICameraMatchInfo r100);

    @FieldName(name = "camera_room_auth#setter")
    void setCameraRoomAuth(IRoomAuthStatus r100);

    @FieldName(name = "camera_type#setter")
    void setCameraType(int r100);

    @FieldName(name = "cover#setter")
    void setCover(k r100);

    @FieldName(name = "end_time#setter")
    void setEndTime(long r100);

    @FieldName(name = "group_id#setter")
    void setGroupId(long r100);

    @FieldName(name = "label#setter")
    void setLabel(k r100);

    @FieldName(name = "start_time#setter")
    void setStartTime(long r100);

    @FieldName(name = "stream_info#setter")
    void setStreamUrl(IBaseStreamUrl r100);

    @FieldName(name = "style#setter")
    void setStyle(int r100);

    @FieldName(name = "title#setter")
    void setTitle(String r100);

    @FieldName(name = "cover_vertical#setter")
    void setVerticalCover(k r100);
}
