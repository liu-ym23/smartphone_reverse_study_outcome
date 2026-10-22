package com.stepos.renderfilter.functor;

import android.graphics.Rect;
import android.opengl.Matrix;
import com.stepos.renderfilter.annotation.Keep;
import java.util.Arrays;

@Keep
/* loaded from: classes.dex */
public class DrawGlInfo {
    public int clipBottom;
    public int clipLeft;
    public int clipRight;
    public int clipTop;
    public int height;
    public boolean isLayer;
    public int mBottom;
    public int mLeft;
    public int mRight;
    private final float[] mTempVec = new float[4];
    public int mTop;
    public float[] transform;
    public int width;

    public DrawGlInfo() {
        float[] fArr = new float[16];
        this.transform = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public void adjustBounds(Rect rect) {
        float[] fArr = this.mTempVec;
        fArr[0] = rect.left;
        fArr[1] = rect.top;
        fArr[2] = 0.0f;
        fArr[3] = 1.0f;
        Matrix.multiplyMV(fArr, 0, this.transform, 0, fArr, 0);
        float[] fArr2 = this.mTempVec;
        this.mLeft = (int) fArr2[0];
        this.mTop = (int) fArr2[1];
        fArr2[0] = rect.right;
        fArr2[1] = rect.bottom;
        fArr2[2] = 0.0f;
        fArr2[3] = 1.0f;
        Matrix.multiplyMV(fArr2, 0, this.transform, 0, fArr2, 0);
        float[] fArr3 = this.mTempVec;
        this.mRight = (int) fArr3[0];
        this.mBottom = (int) fArr3[1];
    }

    public int getClipHeight() {
        return this.clipBottom - this.clipTop;
    }

    public int getClipWidth() {
        return this.clipRight - this.clipLeft;
    }

    public int getTransformHeight() {
        return this.mBottom - this.mTop;
    }

    public int getTransformWidth() {
        return this.mRight - this.mLeft;
    }

    public String toString() {
        return "DrawGlInfo{clipLeft=" + this.clipLeft + ", clipTop=" + this.clipTop + ", clipRight=" + this.clipRight + ", clipBottom=" + this.clipBottom + ", mLeft=" + this.mLeft + ", mTop=" + this.mTop + ", mRight=" + this.mRight + ", mBottom=" + this.mBottom + ", width=" + this.width + ", height=" + this.height + ", isLayer=" + this.isLayer + ", transform=" + Arrays.toString(this.transform) + '}';
    }
}
