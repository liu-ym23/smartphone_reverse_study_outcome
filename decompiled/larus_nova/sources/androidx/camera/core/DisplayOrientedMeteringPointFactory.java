package androidx.camera.core;

import android.graphics.PointF;
import android.view.Display;

/* JADX INFO: loaded from: classes2.dex */
public final class DisplayOrientedMeteringPointFactory extends MeteringPointFactory {
    private final CameraInfo mCameraInfo;
    private final Display mDisplay;
    private final float mHeight;
    private final float mWidth;

    private int getRelativeCameraOrientation(boolean r100) {
        int r101 = this.mDisplay.getRotation();     // Catch: Exception -> L6
        int r102 = this.mCameraInfo.getSensorRotationDegrees(r101);     // Catch: Exception -> L6
        if (r100 == false) goto L10;
        return (360 - r102) % 360;
    L10:
        return r102;
    L6:
        return 0;
    }

    @Override // androidx.camera.core.MeteringPointFactory
    public PointF convertPoint(float r100, float r110) {
        float r101 = this.mWidth;
        float r102 = this.mHeight;
        if (this.mCameraInfo.getLensFacing() != 0) goto L5;
        boolean r103 = true;
    L6:
        int r104 = getRelativeCameraOrientation(r103);
        if (r104 == 90) goto L11;
        if (r104 == 270) goto L11;
        r110 = r100;
        r100 = r110;
        r102 = r101;
        r101 = r102;
    L11:
        if (r104 != 90) goto L13;
    L18:
        r100 = r101 - r100;
    L19:
        if (r103 == false) goto L22;
        r110 = r102 - r110;
    L22:
        return new PointF(r110 / r102, r100 / r101);
    L13:
        if (r104 == 180) goto L17;
        if (r104 != 270) goto L19;
        r110 = r102 - r110;
        goto L19
    L17:
        r110 = r102 - r110;
        goto L18
    L5:
        r103 = false;
        goto L6
    }

    public DisplayOrientedMeteringPointFactory(Display r100, CameraInfo r101, float r102, float r103) {
        this.mWidth = r102;
        this.mHeight = r103;
        this.mDisplay = r100;
        this.mCameraInfo = r101;
    }
}
