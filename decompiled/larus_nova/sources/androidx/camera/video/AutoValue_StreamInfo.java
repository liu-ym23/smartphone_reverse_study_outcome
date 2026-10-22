package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_StreamInfo extends StreamInfo {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f5387id;
    private final SurfaceRequest.TransformationInfo inProgressTransformationInfo;
    private final StreamInfo.StreamState streamState;

    public int hashCode() {
        int r100 = (((this.f5387id ^ 1000003) * 1000003) ^ this.streamState.hashCode()) * 1000003;
        SurfaceRequest.TransformationInfo r101 = this.inProgressTransformationInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 ^ r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "StreamInfo{id=" + this.f5387id + ", streamState=" + this.streamState + ", inProgressTransformationInfo=" + this.inProgressTransformationInfo + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.StreamInfo
    public int getId() {
        return this.f5387id;
    }

    @Override // androidx.camera.video.StreamInfo
    public SurfaceRequest.TransformationInfo getInProgressTransformationInfo() {
        return this.inProgressTransformationInfo;
    }

    @Override // androidx.camera.video.StreamInfo
    public StreamInfo.StreamState getStreamState() {
        return this.streamState;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof StreamInfo) == false) goto L21;
        StreamInfo r101 = (StreamInfo) r100;
        if (this.f5387id == r101.getId()) goto L10;
    L19:
        return false;
    L10:
        if (this.streamState.equals(r101.getStreamState()) == false) goto L19;
        SurfaceRequest.TransformationInfo r102 = this.inProgressTransformationInfo;
        if (r102 != null) goto L17;
        if (r101.getInProgressTransformationInfo() != null) goto L19;
        return true;
    L17:
        if (r102.equals(r101.getInProgressTransformationInfo()) == false) goto L19;
        return true;
    L21:
        return false;
    }

    public AutoValue_StreamInfo(int r100, StreamInfo.StreamState r101, SurfaceRequest.TransformationInfo r102) {
        this.f5387id = r100;
        if (r101 == null) goto L7;
        this.streamState = r101;
        this.inProgressTransformationInfo = r102;
        return;
    L7:
        throw new NullPointerException("Null streamState");
    }
}
