package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* loaded from: classes2.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    public abstract void calcPosition(int i, int i6, float f, float f7, float f9, float f10);

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int i, int i6, RectF rectF, RectF rectF2, float f, float f7);

    public abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f, float f7, String[] strArr, float[] fArr);
}
