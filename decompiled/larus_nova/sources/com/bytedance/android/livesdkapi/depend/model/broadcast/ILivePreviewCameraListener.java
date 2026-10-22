package com.bytedance.android.livesdkapi.depend.model.broadcast;

import android.graphics.Point;
import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\nH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\nH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0015H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J(\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0010H&¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILivePreviewCameraListener;", "", "changePreviewFrameSize", "", "width", "", "height", "closeCamera", "getAllSize", "", "Landroid/graphics/Point;", "getCameraECInfo", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ExposureCompensationInfo;", "getCameraSurfaceView", "Landroid/view/View;", "getPreviewFps", "", "getPreviewFrameSize", "getPreviewSize", "getRecordSurfaceView", "isCameraOpen", "", "openCamera", "setCornersVisible", "visible", "setExposure", "value", "setFocus", "viewWidth", "viewHeight", "x", "y", "setPreviewSize", "startZoom", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePreviewCameraListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void closeCamera(ILivePreviewCameraListener r100) {
        }

        public static void openCamera(ILivePreviewCameraListener r100) {
        }

        public static void setExposure(ILivePreviewCameraListener r100, int r101) {
        }

        public static void setFocus(ILivePreviewCameraListener r100, float r101, float r102, float r103, float r104) {
        }
    }

    void changePreviewFrameSize(int r100, int r101);

    void closeCamera();

    List<Point> getAllSize();

    ExposureCompensationInfo getCameraECInfo();

    View getCameraSurfaceView();

    float getPreviewFps();

    Point getPreviewFrameSize();

    Point getPreviewSize();

    View getRecordSurfaceView();

    boolean isCameraOpen();

    void openCamera();

    void setCornersVisible(boolean r100);

    void setExposure(int r100);

    void setFocus(float r100, float r101, float r102, float r103);

    void setPreviewSize(int r100, int r101);

    void startZoom(float r100);
}
