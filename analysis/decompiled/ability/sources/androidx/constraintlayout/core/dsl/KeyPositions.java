package androidx.constraintlayout.core.dsl;

import androidx.compose.foundation.b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class KeyPositions extends Keys {
    private int[] mFrames;
    private String[] mTarget;
    private String mTransitionEasing = null;
    private Type mPositionType = null;
    private float[] mPercentWidth = null;
    private float[] mPercentHeight = null;
    private float[] mPercentX = null;
    private float[] mPercentY = null;

    public enum Type {
        CARTESIAN,
        SCREEN,
        PATH
    }

    public KeyPositions(int i, String... strArr) {
        this.mFrames = null;
        this.mTarget = strArr;
        this.mFrames = new int[i];
        float length = 100.0f / (r3.length + 1);
        int i6 = 0;
        while (true) {
            int[] iArr = this.mFrames;
            if (i6 >= iArr.length) {
                return;
            }
            iArr[i6] = (int) ((i6 * length) + length);
            i6++;
        }
    }

    public int[] getFrames() {
        return this.mFrames;
    }

    public float[] getPercentHeight() {
        return this.mPercentHeight;
    }

    public float[] getPercentWidth() {
        return this.mPercentWidth;
    }

    public float[] getPercentX() {
        return this.mPercentX;
    }

    public float[] getPercentY() {
        return this.mPercentY;
    }

    public Type getPositionType() {
        return this.mPositionType;
    }

    public String[] getTarget() {
        return this.mTarget;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setFrames(int... iArr) {
        this.mFrames = iArr;
    }

    public void setPercentHeight(float... fArr) {
        this.mPercentHeight = fArr;
    }

    public void setPercentWidth(float... fArr) {
        this.mPercentWidth = fArr;
    }

    public void setPercentX(float... fArr) {
        this.mPercentX = fArr;
    }

    public void setPercentY(float... fArr) {
        this.mPercentY = fArr;
    }

    public void setPositionType(Type type) {
        this.mPositionType = type;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public String toString() {
        StringBuilder sbV = b.v("KeyPositions:{\n");
        append(sbV, TypedValues.AttributesType.S_TARGET, this.mTarget);
        sbV.append("frame:");
        sbV.append(Arrays.toString(this.mFrames));
        sbV.append(",\n");
        if (this.mPositionType != null) {
            sbV.append("type:'");
            sbV.append(this.mPositionType);
            sbV.append("',\n");
        }
        append(sbV, "easing", this.mTransitionEasing);
        append(sbV, "percentX", this.mPercentX);
        append(sbV, "percentX", this.mPercentY);
        append(sbV, "percentWidth", this.mPercentWidth);
        append(sbV, "percentHeight", this.mPercentHeight);
        sbV.append("},\n");
        return sbV.toString();
    }
}
