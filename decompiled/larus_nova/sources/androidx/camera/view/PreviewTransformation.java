package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
final class PreviewTransformation {
    private static final PreviewView.ScaleType DEFAULT_SCALE_TYPE = null;
    private static final String TAG = "PreviewTransform";
    private boolean mHasCameraTransform;
    private boolean mIsFrontCamera;
    private int mPreviewRotationDegrees;
    private Size mResolution;
    private PreviewView.ScaleType mScaleType;
    private Matrix mSensorToBufferTransform;
    private Rect mSurfaceCropRect;
    private int mTargetRotation;

    /* JADX INFO: renamed from: androidx.camera.view.PreviewTransformation$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ScaleType = null;

        static {
            int[] r100 = new int[PreviewView.ScaleType.values().length];
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType = r100;
            r100[PreviewView.ScaleType.FIT_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_START.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        DEFAULT_SCALE_TYPE = PreviewView.ScaleType.FILL_CENTER;
    }

    private int getRemainingRotationDegrees() {
        if (this.mHasCameraTransform == true) goto L7;
        return this.mPreviewRotationDegrees;
    L7:
        return -CameraOrientationUtil.surfaceRotationToDegrees(this.mTargetRotation);
    }

    private Size getRotatedViewportSize() {
        if (TransformUtils.is90or270(this.mPreviewRotationDegrees) == false) goto L7;
        return new Size(this.mSurfaceCropRect.height(), this.mSurfaceCropRect.width());
    L7:
        return new Size(this.mSurfaceCropRect.width(), this.mSurfaceCropRect.height());
    }

    private boolean isTransformationInfoReady() {
        if (this.mHasCameraTransform == true) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (this.mSurfaceCropRect != null) goto L12;
        return false;
    L12:
        if (this.mResolution == null) goto L17;
        if (r100 == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L5:
        if (this.mTargetRotation != (-1)) goto L8;
        r100 = false;
        goto L10
    }

    public PreviewTransformation() {
        this.mScaleType = DEFAULT_SCALE_TYPE;
    }

    public Matrix getTextureViewCorrectionMatrix() {
        Preconditions.checkState(isTransformationInfoReady());
        RectF r100 = new RectF(0.0f, 0.0f, this.mResolution.getWidth(), this.mResolution.getHeight());
        return TransformUtils.getRectToRect(r100, r100, getRemainingRotationDegrees());
    }

    public PreviewView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public Rect getSurfaceCropRect() {
        return this.mSurfaceCropRect;
    }

    public boolean isViewportAspectRatioMatchPreviewView(Size r100) {
        return TransformUtils.isAspectRatioMatchingWithRoundingError(r100, true, getRotatedViewportSize(), false);
    }

    public void setScaleType(PreviewView.ScaleType r100) {
        this.mScaleType = r100;
    }

    private static RectF flipHorizontally(RectF r100, float r101) {
        float r102 = r101 + r101;
        return new RectF(r102 - r100.right, r100.top, r102 - r100.left, r100.bottom);
    }

    private RectF getTransformedSurfaceRect(Size r100, int r101) {
        Preconditions.checkState(isTransformationInfoReady());
        Matrix r102 = getSurfaceToPreviewViewMatrix(r100, r101);
        RectF r103 = new RectF(0.0f, 0.0f, this.mResolution.getWidth(), this.mResolution.getHeight());
        r102.mapRect(r103);
        return r103;
    }

    public RectF getPreviewViewViewportRectForMismatchedAspectRatios(Size r100, int r101) {
        RectF r102 = new RectF(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
        Size r103 = getRotatedViewportSize();
        RectF r104 = new RectF(0.0f, 0.0f, r103.getWidth(), r103.getHeight());
        Matrix r105 = new Matrix();
        setMatrixRectToRect(r105, r104, r102, this.mScaleType);
        r105.mapRect(r104);
        if (r101 == 1) goto L5;
        return r104;
    L5:
        return flipHorizontally(r104, r100.getWidth() / 2.0f);
    }

    public Matrix getSensorToViewTransform(Size r100, int r101) {
        if (isTransformationInfoReady() == true) goto L6;
        return null;
    L6:
        Matrix r102 = new Matrix(this.mSensorToBufferTransform);
        r102.postConcat(getSurfaceToPreviewViewMatrix(r100, r101));
        return r102;
    }

    public Matrix getSurfaceToPreviewViewMatrix(Size r100, int r101) {
        Preconditions.checkState(isTransformationInfoReady());
        if (isViewportAspectRatioMatchPreviewView(r100) == false) goto L5;
        RectF r102 = new RectF(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
    L6:
        Matrix r103 = TransformUtils.getRectToRect(new RectF(this.mSurfaceCropRect), r102, this.mPreviewRotationDegrees);
        if (this.mIsFrontCamera == true) goto L9;
    L14:
        return r103;
    L9:
        if (this.mHasCameraTransform == false) goto L14;
        if (TransformUtils.is90or270(this.mPreviewRotationDegrees) == false) goto L13;
        r103.preScale(1.0f, -1.0f, this.mSurfaceCropRect.centerX(), this.mSurfaceCropRect.centerY());
        goto L14
    L13:
        r103.preScale(-1.0f, 1.0f, this.mSurfaceCropRect.centerX(), this.mSurfaceCropRect.centerY());
        goto L14
    L5:
        r102 = getPreviewViewViewportRectForMismatchedAspectRatios(r100, r101);
        goto L6
    }

    public void overrideWithDisplayRotation(int r100, int r101) {
        if (this.mHasCameraTransform == true) goto L5;
        return;
    L5:
        this.mPreviewRotationDegrees = r100;
        this.mTargetRotation = r101;
    }

    public Bitmap createTransformedBitmap(Bitmap r100, Size r101, int r102) {
        if (isTransformationInfoReady() == true) goto L5;
        return r100;
    L5:
        Matrix r103 = getTextureViewCorrectionMatrix();
        RectF r104 = getTransformedSurfaceRect(r101, r102);
        Bitmap r105 = Bitmap.createBitmap(r101.getWidth(), r101.getHeight(), r100.getConfig());
        Canvas r106 = new Canvas(r105);
        Matrix r107 = new Matrix();
        r107.postConcat(r103);
        r107.postScale(r104.width() / this.mResolution.getWidth(), r104.height() / this.mResolution.getHeight());
        r107.postTranslate(r104.left, r104.top);
        r106.drawBitmap(r100, r107, new Paint(7));
        return r105;
    }

    public Matrix getPreviewViewToNormalizedSensorMatrix(Size r100, int r101, Rect r102) {
        if (isTransformationInfoReady() == true) goto L6;
        return null;
    L6:
        Matrix r103 = new Matrix();
        getSensorToViewTransform(r100, r101).invert(r103);
        Matrix r104 = new Matrix();
        r104.setRectToRect(new RectF(0.0f, 0.0f, r102.width(), r102.height()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
        r103.postConcat(r104);
        return r103;
    }

    public void setTransformationInfo(SurfaceRequest.TransformationInfo r100, Size r101, boolean r102) {
        Logger.d(TAG, "Transformation info set: " + r100 + " " + r101 + " " + r102);
        this.mSurfaceCropRect = r100.getCropRect();
        this.mPreviewRotationDegrees = r100.getRotationDegrees();
        this.mTargetRotation = r100.getTargetRotation();
        this.mResolution = r101;
        this.mIsFrontCamera = r102;
        this.mHasCameraTransform = r100.hasCameraTransform();
        this.mSensorToBufferTransform = r100.getSensorToBufferTransform();
    }

    public void transformView(Size r100, int r101, View r102) {
        if (r100.getHeight() != 0) goto L5;
    L31:
        Logger.w(TAG, "Transform not applied due to PreviewView size: " + r100);
        return;
    L5:
        if (r100.getWidth() == 0) goto L31;
        if (isTransformationInfoReady() == true) goto L11;
        return;
    L11:
        if ((r102 instanceof TextureView) == false) goto L13;
        ((TextureView) r102).setTransform(getTextureViewCorrectionMatrix());
    L29:
        RectF r103 = getTransformedSurfaceRect(r100, r101);
        r102.setPivotX(0.0f);
        r102.setPivotY(0.0f);
        r102.setScaleX(r103.width() / this.mResolution.getWidth());
        r102.setScaleY(r103.height() / this.mResolution.getHeight());
        r102.setTranslationX(r103.left - r102.getLeft());
        r102.setTranslationY(r103.top - r102.getTop());
        return;
    L13:
        Display r104 = r102.getDisplay();
        boolean r105 = true;
        if (this.mHasCameraTransform == false) goto L19;
        if (r104 == null) goto L19;
        if (r104.getRotation() == this.mTargetRotation) goto L19;
        boolean r106 = true;
    L21:
        if (this.mHasCameraTransform == false) goto L23;
    L25:
        r105 = false;
    L26:
        if (r106 == true) goto L28;
        if (r105 == false) goto L29;
    L28:
        Logger.e(TAG, "Custom rotation not supported with SurfaceView/PERFORMANCE mode.");
        goto L29
    L23:
        if (getRemainingRotationDegrees() == 0) goto L25;
    L19:
        r106 = false;
        goto L21
    }

    private static void setMatrixRectToRect(Matrix r100, RectF r101, RectF r102, PreviewView.ScaleType r103) {
        switch(AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[r103.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        Logger.e(TAG, "Unexpected crop rect: " + r103);
        Matrix.ScaleToFit r104 = Matrix.ScaleToFit.FILL;
    L9:
        if (r103 != PreviewView.ScaleType.FIT_CENTER) goto L11;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
        r100.setRectToRect(r101, r102, r104);
        return;
    L19:
        r100.setRectToRect(r102, r101, r104);
        r100.invert(r100);
        return;
    L11:
        if (r103 == PreviewView.ScaleType.FIT_START) goto L16;
        if (r103 == PreviewView.ScaleType.FIT_END) goto L16;
        r105 = false;
        goto L17
    L5:
        r104 = Matrix.ScaleToFit.START;
        goto L9
    L6:
        r104 = Matrix.ScaleToFit.END;
        goto L9
    L7:
        r104 = Matrix.ScaleToFit.CENTER;
        goto L9
    }
}
