package com.bytedance.android.livehostapi.business.castscreen.bean;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 >2\u00020\u0001:\u0001>B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010=\u001a\u00020\u0011H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001a\u00104\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u0010\u0015R\u001a\u00107\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010\u0015R\u001a\u0010:\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0013\"\u0004\b<\u0010\u0015¨\u0006?"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveInfo;", "", "()V", ShortVideoSegments.KEY_CAMERA_ID, "", "getCameraId", "()J", "setCameraId", "(J)V", "cameraPosInfoList", "", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastCameraPosInfo;", "getCameraPosInfoList", "()Ljava/util/List;", "setCameraPosInfoList", "(Ljava/util/List;)V", "dirUrl", "", "getDirUrl", "()Ljava/lang/String;", "setDirUrl", "(Ljava/lang/String;)V", "enableSeek", "", "getEnableSeek", "()Z", "setEnableSeek", "(Z)V", "fromChangeCameraPos", "getFromChangeCameraPos", "setFromChangeCameraPos", "h265StreamData", "getH265StreamData", "setH265StreamData", "orientation", "", "getOrientation", "()I", "setOrientation", "(I)V", "qualityInfo", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveQualityInfo;", "getQualityInfo", "()Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveQualityInfo;", "setQualityInfo", "(Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveQualityInfo;)V", "roomId", "getRoomId", "setRoomId", "roomStartTime", "getRoomStartTime", "setRoomStartTime", "source", "getSource", "setSource", "streamData", "getStreamData", "setStreamData", "targetCameraPos", "getTargetCameraPos", "setTargetCameraPos", "toString", "Companion", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastLiveInfo {
    public static final Companion Companion = null;
    public static final int ORIENTATION_HORIZONTAL = 2;
    public static final int ORIENTATION_UNKNOWN = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    private long cameraId;
    private List<LiveCastCameraPosInfo> cameraPosInfoList;
    private String dirUrl;
    private boolean enableSeek;
    private boolean fromChangeCameraPos;
    private String h265StreamData;
    private int orientation;
    private LiveCastLiveQualityInfo qualityInfo;
    private long roomId;
    private long roomStartTime;
    private String source;
    private String streamData;
    private String targetCameraPos;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveInfo$Companion;", "", "()V", "ORIENTATION_HORIZONTAL", "", "ORIENTATION_UNKNOWN", "ORIENTATION_VERTICAL", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public String toString() {
        return "LiveCastLiveInfo(roomId=" + this.roomId + ", streamData='" + this.streamData + "', orientation=" + this.orientation + ", source='" + this.source + "', h265StreamData='" + this.h265StreamData + "', cameraPosInfoList=" + this.cameraPosInfoList + ", targetCameraPos='" + this.targetCameraPos + "', fromChangeCameraPos=" + this.fromChangeCameraPos + ", enableSeek=" + this.enableSeek + ", roomStartTime=" + this.roomStartTime + ')';
    }

    public LiveCastLiveInfo() {
        this.streamData = "";
        this.source = "";
        this.h265StreamData = "";
        this.cameraPosInfoList = new ArrayList();
        this.targetCameraPos = "";
        this.qualityInfo = new LiveCastLiveQualityInfo();
        this.dirUrl = "";
    }

    public final long getCameraId() {
        return this.cameraId;
    }

    public final List<LiveCastCameraPosInfo> getCameraPosInfoList() {
        return this.cameraPosInfoList;
    }

    public final String getDirUrl() {
        return this.dirUrl;
    }

    public final boolean getEnableSeek() {
        return this.enableSeek;
    }

    public final boolean getFromChangeCameraPos() {
        return this.fromChangeCameraPos;
    }

    public final String getH265StreamData() {
        return this.h265StreamData;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final LiveCastLiveQualityInfo getQualityInfo() {
        return this.qualityInfo;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getRoomStartTime() {
        return this.roomStartTime;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getStreamData() {
        return this.streamData;
    }

    public final String getTargetCameraPos() {
        return this.targetCameraPos;
    }

    public final void setCameraId(long r100) {
        this.cameraId = r100;
    }

    public final void setCameraPosInfoList(List<LiveCastCameraPosInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cameraPosInfoList = r100;
    }

    public final void setDirUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dirUrl = r100;
    }

    public final void setEnableSeek(boolean r100) {
        this.enableSeek = r100;
    }

    public final void setFromChangeCameraPos(boolean r100) {
        this.fromChangeCameraPos = r100;
    }

    public final void setH265StreamData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.h265StreamData = r100;
    }

    public final void setOrientation(int r100) {
        this.orientation = r100;
    }

    public final void setQualityInfo(LiveCastLiveQualityInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.qualityInfo = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setRoomStartTime(long r100) {
        this.roomStartTime = r100;
    }

    public final void setSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.source = r100;
    }

    public final void setStreamData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.streamData = r100;
    }

    public final void setTargetCameraPos(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.targetCameraPos = r100;
    }
}
