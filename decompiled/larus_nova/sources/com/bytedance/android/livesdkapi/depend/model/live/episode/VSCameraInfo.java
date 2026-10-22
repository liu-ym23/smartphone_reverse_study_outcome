package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainVSCameraInfo;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class VSCameraInfo extends FlexModelBase<IVSCameraInfo> implements IVSCameraInfo {

    @SerializedName("ban_switch")
    public boolean banSwitch;

    @SerializedName(VSConstants.VS_CAMERA_ID)
    public long cameraId;

    @SerializedName("camera_id_str")
    public String cameraIdStr;

    @SerializedName("camera_match_info")
    public CameraMatchInfo cameraMatchInfo;

    @SerializedName("camera_room_auth")
    public IRoomAuthStatus cameraRoomAuth;

    @SerializedName("camera_type")
    public int cameraType;

    @SerializedName("cover")
    public k cover;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("group_id")
    public long groupId;

    @SerializedName("is_subscribed")
    public boolean isSubscribed;

    @SerializedName("label")
    public k label;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public long startTim;

    @SerializedName("stream_info")
    public IBaseStreamUrl streamUrl;

    @SerializedName("style")
    public int style;

    @SerializedName("title")
    public String title;

    @SerializedName("cover_vertical")
    public k verticalCover;

    public VSCameraInfo() {
        super(IVSCameraInfo.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfoEx
    public ICameraPaidInfo getCameraPaidInfo() {
        return ((IMainVSCameraInfo) castToOrNull(IMainVSCameraInfo.class)).getCameraPaidInfo();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfoEx
    public long getMatchId() {
        CameraMatchInfo r100 = this.cameraMatchInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getMatchId();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfoEx
    public boolean hasEnd() {
        if (this.endTime > (System.currentTimeMillis() / 1000)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfoEx
    public boolean isMatchCamera() {
        if (this.cameraType != VSCameraType.CAMERA_TYPE_MATCH.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfoEx
    public boolean isPaidCamera() {
        IMainVSCameraInfo r100 = (IMainVSCameraInfo) castToOrNull(IMainVSCameraInfo.class);
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getCameraPaidInfo() != null) goto L8;
        return false;
    L8:
        if (r100.getCameraPaidInfo().getPaidLiveBaseInfo() != null) goto L10;
        return false;
    L10:
        if (r100.getCameraPaidInfo().getPaidLiveBaseInfo().getPaidLiveType() != 3) goto L15;
        return true;
    L15:
        return false;
    }

    public boolean isPaidCameraInSameTicket() {
        IMainVSCameraInfo r100 = (IMainVSCameraInfo) castToOrNull(IMainVSCameraInfo.class);
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getCameraPaidInfo() != null) goto L8;
        return false;
    L8:
        if (r100.getCameraPaidInfo().getPaidLiveBaseInfo() != null) goto L10;
        return false;
    L10:
        if (r100.getCameraPaidInfo().getPaidLiveBaseInfo().getPaidLiveType() != 11) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfoEx
    public boolean viewRight() {
        IMainVSCameraInfo r100 = (IMainVSCameraInfo) castToOrNull(IMainVSCameraInfo.class);
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getCameraPaidInfo() != null) goto L8;
        return false;
    L8:
        if (r100.getCameraPaidInfo().getPaidLiveBaseInfo() != null) goto L10;
        return false;
    L10:
        if (r100.getCameraPaidInfo().getPaidLiveBaseInfo().getViewRight() == 0) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public /* bridge */ /* synthetic */ ICameraMatchInfo getCameraMatchInfo() {
        return getCameraMatchInfo();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public long getCameraId() {
        return this.cameraId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public String getCameraIdStr() {
        return this.cameraIdStr;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public IRoomAuthStatus getCameraRoomAuth() {
        return this.cameraRoomAuth;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public int getCameraType() {
        return this.cameraType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public k getCover() {
        return this.cover;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public long getEndTime() {
        return this.endTime;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public long getGroupId() {
        return this.groupId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public k getLabel() {
        return this.label;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public long getStartTime() {
        return this.startTim;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public IBaseStreamUrl getStreamUrl() {
        return this.streamUrl;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public int getStyle() {
        return this.style;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public String getTitle() {
        return this.title;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public k getVerticalCover() {
        return this.verticalCover;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public CameraMatchInfo getCameraMatchInfo() {
        return this.cameraMatchInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setCameraId(long r100) {
        this.cameraId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setCameraIdStr(String r100) {
        this.cameraIdStr = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setCameraMatchInfo(ICameraMatchInfo r100) {
        this.cameraMatchInfo = (CameraMatchInfo) r100;
    }

    public void setCameraPaidInfo(ICameraPaidInfo r100) {
        if ((r100 instanceof CameraPaidInfo) == false) goto L6;
        ((IMainVSCameraInfo) castToOrNull(IMainVSCameraInfo.class)).setCameraPaidInfo((CameraPaidInfo) r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setCameraRoomAuth(IRoomAuthStatus r100) {
        this.cameraRoomAuth = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setCameraType(int r100) {
        this.cameraType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setCover(k r100) {
        this.cover = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setEndTime(long r100) {
        this.endTime = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setGroupId(long r100) {
        this.groupId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setLabel(k r100) {
        this.label = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setStartTime(long r100) {
        this.startTim = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setStreamUrl(IBaseStreamUrl r100) {
        this.streamUrl = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setStyle(int r100) {
        this.style = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setTitle(String r100) {
        this.title = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo
    public void setVerticalCover(k r100) {
        this.verticalCover = r100;
    }
}
