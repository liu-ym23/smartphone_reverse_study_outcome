package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public final class CoordinateTransform {
    private static final String MISMATCH_MSG = "The source viewport (%s) does not match the target viewport (%s). Please make sure they are associated with the same Viewport.";
    private static final String TAG = "CoordinateTransform";
    private final Matrix mMatrix;

    public void mapPoint(PointF r100) {
        float[] r101 = {r100.x, r100.y};
        this.mMatrix.mapPoints(r101);
        r100.x = r101[0];
        r100.y = r101[1];
    }

    public void mapPoints(float[] r100) {
        this.mMatrix.mapPoints(r100);
    }

    public void mapRect(RectF r100) {
        this.mMatrix.mapRect(r100);
    }

    public void transform(Matrix r100) {
        r100.set(this.mMatrix);
    }

    public CoordinateTransform(OutputTransform r100, OutputTransform r101) {
        if (TransformUtils.isAspectRatioMatchingWithRoundingError(r100.getViewPortSize(), r101.getViewPortSize()) == true) goto L5;
        Logger.w(TAG, String.format(MISMATCH_MSG, new Object[]{r100.getViewPortSize(), r101.getViewPortSize()}));
    L5:
        Matrix r102 = new Matrix();
        this.mMatrix = r102;
        Preconditions.checkState(r100.getMatrix().invert(r102), "The source transform cannot be inverted");
        r102.postConcat(r101.getMatrix());
    }
}
