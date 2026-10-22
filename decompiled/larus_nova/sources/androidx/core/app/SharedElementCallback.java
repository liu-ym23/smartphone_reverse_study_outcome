package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public abstract class SharedElementCallback {
    private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
    private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
    private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
    private static final int MAX_IMAGE_SIZE = 1048576;
    private Matrix mTempMatrix;

    public interface OnSharedElementsReadyListener {
        void onSharedElementsReady();
    }

    public SharedElementCallback() {
    }

    public void onMapSharedElements(List<String> r100, Map<String, View> r101) {
    }

    public void onRejectSharedElements(List<View> r100) {
    }

    public void onSharedElementEnd(List<String> r100, List<View> r101, List<View> r102) {
    }

    public void onSharedElementStart(List<String> r100, List<View> r101, List<View> r102) {
    }

    private static Bitmap createDrawableBitmap(Drawable r100) {
        int r101 = r100.getIntrinsicWidth();
        int r102 = r100.getIntrinsicHeight();
        if (r101 <= 0) goto L14;
        if (r102 <= 0) goto L16;
        float r103 = Math.min(1.0f, 1048576.0f / (r101 * r102));
        if ((r100 instanceof BitmapDrawable) == true) goto L9;
    L12:
        int r104 = (int) (r101 * r103);
        int r105 = (int) (r102 * r103);
        Bitmap r106 = Bitmap.createBitmap(r104, r105, Bitmap.Config.ARGB_8888);
        Canvas r107 = new Canvas(r106);
        Rect r108 = r100.getBounds();
        int r109 = r108.left;
        int r110 = r108.top;
        int r111 = r108.right;
        int r112 = r108.bottom;
        r100.setBounds(0, 0, r104, r105);
        r100.draw(r107);
        r100.setBounds(r109, r110, r111, r112);
        return r106;
    L9:
        if (r103 != 1.0f) goto L12;
        return ((BitmapDrawable) r100).getBitmap();
    L16:
        return null;
    L14:
        return null;
    }

    public View onCreateSnapshotView(Context r100, Parcelable r101) {
        if ((r101 instanceof Bundle) == false) goto L11;
        Bundle r102 = (Bundle) r101;
        Bitmap r103 = (Bitmap) r102.getParcelable(BUNDLE_SNAPSHOT_BITMAP);
        if (r103 != null) goto L7;
        return null;
    L7:
        ImageView r104 = new ImageView(r100);
        r104.setImageBitmap(r103);
        r104.setScaleType(ImageView.ScaleType.valueOf(r102.getString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE)));
        if (r104.getScaleType() != ImageView.ScaleType.MATRIX) goto L14;
        float[] r105 = r102.getFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX);
        Matrix r106 = new Matrix();
        r106.setValues(r105);
        r104.setImageMatrix(r106);
        return r104;
    L14:
        return r104;
    L11:
        if ((r101 instanceof Bitmap) == false) goto L16;
        ImageView r107 = new ImageView(r100);
        r107.setImageBitmap((Bitmap) r101);
        return r107;
    L16:
        return null;
    }

    public Parcelable onCaptureSharedElementSnapshot(View r100, Matrix r101, RectF r102) {
        if ((r100 instanceof ImageView) == false) goto L13;
        ImageView r103 = (ImageView) r100;
        Drawable r104 = r103.getDrawable();
        Drawable r105 = r103.getBackground();
        if (r104 == null) goto L13;
        if (r105 != null) goto L13;
        Bitmap r106 = createDrawableBitmap(r104);
        if (r106 == null) goto L13;
        Bundle r107 = new Bundle();
        r107.putParcelable(BUNDLE_SNAPSHOT_BITMAP, r106);
        r107.putString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE, r103.getScaleType().toString());
        if (r103.getScaleType() != ImageView.ScaleType.MATRIX) goto L12;
        float[] r108 = new float[9];
        r103.getImageMatrix().getValues(r108);
        r107.putFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX, r108);
    L12:
        return r107;
    L13:
        int r109 = Math.round(r102.width());
        int r110 = Math.round(r102.height());
        if (r109 <= 0) goto L20;
        if (r110 <= 0) goto L20;
        float r111 = Math.min(1.0f, 1048576.0f / (r109 * r110));
        int r112 = (int) (r109 * r111);
        int r113 = (int) (r110 * r111);
        if (this.mTempMatrix != null) goto L19;
        this.mTempMatrix = new Matrix();
    L19:
        this.mTempMatrix.set(r101);
        this.mTempMatrix.postTranslate(-r102.left, -r102.top);
        this.mTempMatrix.postScale(r111, r111);
        Bitmap r114 = Bitmap.createBitmap(r112, r113, Bitmap.Config.ARGB_8888);
        Canvas r115 = new Canvas(r114);
        r115.concat(this.mTempMatrix);
        r100.draw(r115);
        return r114;
    L20:
        return null;
    }

    public void onSharedElementsArrived(List<String> r100, List<View> r101, OnSharedElementsReadyListener r102) {
        r102.onSharedElementsReady();
    }
}
