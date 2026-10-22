package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.utils.Threads;

/* JADX INFO: loaded from: classes2.dex */
class PreviewViewMeteringPointFactory extends MeteringPointFactory {
    static final PointF INVALID_POINT = null;
    private Matrix mMatrix;
    private final PreviewTransformation mPreviewTransformation;
    private Rect mSensorRect;

    static {
        INVALID_POINT = new PointF(2.0f, 2.0f);
    }

    public PreviewViewMeteringPointFactory(PreviewTransformation r100) {
        this.mSensorRect = null;
        this.mPreviewTransformation = r100;
    }

    public void setSensorRect(Rect r100) {
        setSurfaceAspectRatio(new Rational(r100.width(), r100.height()));
        monitor-enter(this);
        this.mSensorRect = r100;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.MeteringPointFactory
    public PointF convertPoint(float r100, float r101) {
        float[] r102 = {r100, r101};
        monitor-enter(this);
        Matrix r103 = this.mMatrix;     // Catch: Throwable -> L13
        if (r103 != null) goto L9;
        PointF r104 = INVALID_POINT;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r104;
    L9:
        r103.mapPoints(r102);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return new PointF(r102[0], r102[1]);
    L13:
        th = move-exception;
        throw th;
    }

    public void recalculate(Size r100, int r101) {
        Threads.checkMainThread();
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r100.getWidth() != 0) goto L7;
    L14:
        this.mMatrix = null;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L7:
        if (r100.getHeight() == 0) goto L14;
        Rect r102 = this.mSensorRect;     // Catch: Throwable -> L17
        if (r102 == null) goto L14;
        this.mMatrix = this.mPreviewTransformation.getPreviewViewToNormalizedSensorMatrix(r100, r101, r102);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
    }
}
