package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;

/* JADX INFO: loaded from: classes17.dex */
public class MotionTelltales extends MockView {
    private static final String TAG = "MotionTelltales";
    Matrix mInvertMatrix;
    MotionLayout mMotionLayout;
    private Paint mPaintTelltales;
    int mTailColor;
    float mTailScale;
    int mVelocityMode;
    float[] velocity;

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public MotionTelltales(Context r100) {
        super(r100);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = FakePickerAvatarCreator.MAGENTA;
        this.mTailScale = 0.25f;
        init(r100, null);
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas r210) {
        super.onDraw(r210);
        getMatrix().invert(this.mInvertMatrix);
        if (this.mMotionLayout != null) goto L8;
        ViewParent r100 = getParent();
        if ((r100 instanceof MotionLayout) == false) goto L17;
        this.mMotionLayout = (MotionLayout) r100;
        return;
    L17:
        return;
    L8:
        int r101 = getWidth();
        int r102 = getHeight();
        float[] r110 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int r111 = 0;
    L9:
        if (r111 >= 5) goto L14;
        float r112 = r110[r111];
        int r113 = 0;
    L11:
        if (r113 >= 5) goto L13;
        float r114 = r110[r113];
        this.mMotionLayout.getViewVelocity(this, r114, r112, this.velocity, this.mVelocityMode);
        this.mInvertMatrix.mapVectors(this.velocity);
        float r115 = r101 * r114;
        float r116 = r102 * r112;
        float[] r103 = this.velocity;
        float r104 = r103[0];
        float r105 = this.mTailScale;
        float r211 = r116 - (r103[1] * r105);
        this.mInvertMatrix.mapVectors(r103);
        r210.drawLine(r115, r116, r115 - (r104 * r105), r211, this.mPaintTelltales);
        r113 = r113 + 1;
        goto L11
    L13:
        r111 = r111 + 1;
        goto L9
    }

    public void setText(CharSequence r100) {
        this.mText = r100.toString();
        requestLayout();
    }

    public MotionTelltales(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = FakePickerAvatarCreator.MAGENTA;
        this.mTailScale = 0.25f;
        init(r100, r101);
    }

    private void init(Context r100, AttributeSet r101) {
        if (r101 == null) goto L16;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.telltales_tailColor, R.attr.telltales_tailScale, R.attr.telltales_velocityMode});
        int r103 = r102.getIndexCount();
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L15;
        int r105 = r102.getIndex(r104);
        if (r105 != 0) goto L9;
        this.mTailColor = r102.getColor(r105, this.mTailColor);
    L14:
        r104 = r104 + 1;
        goto L4
    L9:
        if (r105 != 2) goto L12;
        this.mVelocityMode = r102.getInt(r105, this.mVelocityMode);
        goto L14
    L12:
        if (r105 != 1) goto L14;
        this.mTailScale = r102.getFloat(r105, this.mTailScale);
        goto L14
    L15:
        r102.recycle();
    L16:
        this.mPaintTelltales.setColor(this.mTailColor);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    public MotionTelltales(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = FakePickerAvatarCreator.MAGENTA;
        this.mTailScale = 0.25f;
        init(r100, r101);
    }

    @Override // android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        postInvalidate();
    }
}
