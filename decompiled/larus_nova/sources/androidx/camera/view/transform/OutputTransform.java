package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.util.Size;

/* JADX INFO: loaded from: classes2.dex */
public final class OutputTransform {
    final Matrix mMatrix;
    final Size mViewPortSize;

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Size getViewPortSize() {
        return this.mViewPortSize;
    }

    public OutputTransform(Matrix r100, Size r101) {
        this.mMatrix = r100;
        this.mViewPortSize = r101;
    }
}
