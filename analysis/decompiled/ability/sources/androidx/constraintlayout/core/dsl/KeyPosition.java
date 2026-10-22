package androidx.constraintlayout.core.dsl;

import androidx.compose.foundation.b;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes2.dex */
public class KeyPosition extends Keys {
    private int mFrame;
    private String mTarget;
    private String mTransitionEasing = null;
    private float mPercentWidth = Float.NaN;
    private float mPercentHeight = Float.NaN;
    private float mPercentX = Float.NaN;
    private float mPercentY = Float.NaN;
    private Type mPositionType = Type.CARTESIAN;

    public enum Type {
        CARTESIAN,
        SCREEN,
        PATH
    }

    public KeyPosition(String str, int i) {
        this.mTarget = null;
        this.mFrame = 0;
        this.mTarget = str;
        this.mFrame = i;
    }

    public int getFrames() {
        return this.mFrame;
    }

    public float getPercentHeight() {
        return this.mPercentHeight;
    }

    public float getPercentWidth() {
        return this.mPercentWidth;
    }

    public float getPercentX() {
        return this.mPercentX;
    }

    public float getPercentY() {
        return this.mPercentY;
    }

    public Type getPositionType() {
        return this.mPositionType;
    }

    public String getTarget() {
        return this.mTarget;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setFrames(int i) {
        this.mFrame = i;
    }

    public void setPercentHeight(float f) {
        this.mPercentHeight = f;
    }

    public void setPercentWidth(float f) {
        this.mPercentWidth = f;
    }

    public void setPercentX(float f) {
        this.mPercentX = f;
    }

    public void setPercentY(float f) {
        this.mPercentY = f;
    }

    public void setPositionType(Type type) {
        this.mPositionType = type;
    }

    public void setTarget(String str) {
        this.mTarget = str;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public String toString() {
        StringBuilder sbV = b.v("KeyPositions:{\n");
        append(sbV, TypedValues.AttributesType.S_TARGET, this.mTarget);
        sbV.append("frame:");
        sbV.append(this.mFrame);
        sbV.append(",\n");
        if (this.mPositionType != null) {
            sbV.append("type:'");
            sbV.append(this.mPositionType);
            sbV.append("',\n");
        }
        append(sbV, "easing", this.mTransitionEasing);
        append(sbV, "percentX", this.mPercentX);
        append(sbV, "percentY", this.mPercentY);
        append(sbV, "percentWidth", this.mPercentWidth);
        append(sbV, "percentHeight", this.mPercentHeight);
        sbV.append("},\n");
        return sbV.toString();
    }
}
