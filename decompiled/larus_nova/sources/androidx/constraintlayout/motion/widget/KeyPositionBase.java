package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: loaded from: classes17.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit;

    public abstract void calcPosition(int r100, int r101, float r102, float r103, float r104, float r105);

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> r100) {
    }

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int r100, int r101, RectF r102, RectF r103, float r104, float r105);

    public abstract void positionAttributes(View r100, RectF r101, RectF r102, float r103, float r104, String[] r105, float[] r106);

    public KeyPositionBase() {
        this.mCurveFit = Key.UNSET;
    }
}
