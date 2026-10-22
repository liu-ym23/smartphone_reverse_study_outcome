package com.bytedance.android.livesdk.chatroom.broadcast.startlive;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.service.y;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ExposureCompensationInfo;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements ILivePreviewCameraListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f105358a;

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final void changePreviewFrameSize(int r100, int r101) {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final float getPreviewFps() {
        return 0.0f;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final View getRecordSurfaceView() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final void setCornersVisible(boolean r100) {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final void closeCamera() {
        com.bytedance.android.live.pushstream.d r100 = this.f105358a.getLiveStream();
        if (r100 == null) goto L6;
        r100.k1(new uv0.a(LiveRequestSourceRole.Business, "StartLiveCameraListener.closeCamera", null));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final ExposureCompensationInfo getCameraECInfo() {
        com.bytedance.android.live.pushstream.d r100 = this.f105358a.getLiveStream();
        if (r100 == null) goto L7;
        nc1.a r101 = r100.e();
        if (r101 == null) goto L7;
        oc1.a r102 = r101.a();
    L8:
        if (r102 == null) goto L11;
        ExposureCompensationInfo r103 = new ExposureCompensationInfo();
        r103.setMax(0);
        r103.setMin(0);
        r103.setExposure(0);
        r103.setStep(0.0f);
        return r103;
    L11:
        return null;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final View getCameraSurfaceView() {
        com.bytedance.android.live.pushstream.d r100 = this.f105358a.getLiveStream();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSurfaceView();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final Point getPreviewFrameSize() {
        com.bytedance.android.live.pushstream.d r100 = this.f105358a.getLiveStream();
        if (r100 == null) goto L6;
        return new Point(r100.W0(), r100.T0());
    L6:
        return new Point();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final Point getPreviewSize() {
        com.bytedance.android.live.pushstream.d r100 = this.f105358a.getLiveStream();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new Point(r100.W0(), r100.T0());
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final boolean isCameraOpen() {
        com.bytedance.android.live.pushstream.d r100 = this.f105358a.getLiveStream();
        if (r100 == null) goto L13;
        com.bytedance.android.live.pushstream.b.a r101 = r100.s1();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.f89390a != 1) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r102 = false;
        goto L10
    L13:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final void openCamera() {
        com.bytedance.android.live.pushstream.d r100 = this.f105358a.getLiveStream();
        if (r100 == null) goto L6;
        r100.U0(new uv0.a(LiveRequestSourceRole.Business, "StartLiveCameraListener.openCamera", null));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final List<Point> getAllSize() {
        return CollectionsKt.emptyList();
    }

    public c(y r100) {
        Intrinsics.checkNotNullParameter(r100, "broadcastProvider");
        this.f105358a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final void setExposure(int r100) {
        com.bytedance.android.live.pushstream.d r101 = this.f105358a.getLiveStream();
        if (r101 == null) goto L8;
        nc1.a r102 = r101.e();
        if (r102 == null) goto L9;
        r102.b(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final void startZoom(float r100) {
        com.bytedance.android.live.pushstream.d r101 = this.f105358a.getLiveStream();
        if (r101 == null) goto L6;
        r101.startZoom(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final void setPreviewSize(int r100, int r101) {
        com.bytedance.android.live.pushstream.d r102 = this.f105358a.getLiveStream();
        if (r102 == null) goto L6;
        Bundle r103 = new Bundle();
        r103.putInt("videoCaptureWidth", r100);
        r103.putInt("videoCaptureHeight", r101);
        Unit r104 = Unit.INSTANCE;
        r102.y(r103.toString());
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewCameraListener
    public final void setFocus(float r100, float r101, float r102, float r103) {
        com.bytedance.android.live.pushstream.d r104 = this.f105358a.getLiveStream();
        if (r104 == null) goto L8;
        nc1.a r105 = r104.e();
        if (r105 == null) goto L9;
        r105.c((int) r100, (int) r101, (int) r102, (int) r103);
        return;
    L9:
        return;
    }
}
