package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.SurfaceRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
abstract class PreviewViewImplementation {
    FrameLayout mParent;
    private final PreviewTransformation mPreviewTransform;
    Size mResolution;
    private boolean mWasSurfaceProvided;

    public interface OnSurfaceNotInUseListener {
        void onSurfaceNotInUse();
    }

    public abstract View getPreview();

    public abstract Bitmap getPreviewBitmap();

    public abstract void initializePreview();

    public abstract void onAttachedToWindow();

    public abstract void onDetachedFromWindow();

    public void onSurfaceProvided() {
        this.mWasSurfaceProvided = true;
        redrawPreview();
    }

    public abstract void onSurfaceRequested(SurfaceRequest r100, OnSurfaceNotInUseListener r101);

    public void setFrameUpdateListener(Executor r100, PreviewView.OnFrameUpdateListener r101) {
    }

    public abstract ListenableFuture<Void> waitForNextFrame();

    public Bitmap getBitmap() {
        Bitmap r100 = getPreviewBitmap();
        if (r100 != null) goto L7;
        return null;
    L7:
        return this.mPreviewTransform.createTransformedBitmap(r100, new Size(this.mParent.getWidth(), this.mParent.getHeight()), this.mParent.getLayoutDirection());
    }

    public void redrawPreview() {
        View r100 = getPreview();
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mWasSurfaceProvided == false) goto L10;
        this.mPreviewTransform.transformView(new Size(this.mParent.getWidth(), this.mParent.getHeight()), this.mParent.getLayoutDirection(), r100);
        return;
    }

    public PreviewViewImplementation(FrameLayout r100, PreviewTransformation r101) {
        this.mWasSurfaceProvided = false;
        this.mParent = r100;
        this.mPreviewTransform = r101;
    }
}
