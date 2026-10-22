package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class MotionButton extends AppCompatButton {
    private Path mPath;
    RectF mRect;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;

    static /* synthetic */ float access$000(MotionButton r0) {
        return r0.mRoundPercent;
    }

    static /* synthetic */ float access$100(MotionButton r0) {
        return r0.mRound;
    }

    public MotionButton(Context context) {
        super(context);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, null);
    }

    public MotionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, attrs);
    }

    public MotionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        int r5 = 0;
        setPadding(0, 0, 0, 0);
        if (attrs == null) goto L19;
        TypedArray r6 = getContext().obtainStyledAttributes(attrs, R.styleable.ImageFilterView);
        int r0 = r6.getIndexCount();
    L5:
        if (r5 >= r0) goto L13;
        int r1 = r6.getIndex(r5);
        if (r1 != R.styleable.ImageFilterView_round) goto L10;
        setRound(r6.getDimension(r1, 0.0f));
    L12:
        r5 = r5 + 1;
        goto L5
    L10:
        if (r1 != R.styleable.ImageFilterView_roundPercent) goto L12;
        setRoundPercent(r6.getFloat(r1, 0.0f));
        goto L12
    L13:
        r6.recycle();
        return;
    }

    public void setRoundPercent(float round) {
        if (this.mRoundPercent == round) goto L5;
        boolean r0 = true;
    L6:
        this.mRoundPercent = round;
        if (round != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r0 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L15;
        this.mRect = new RectF();
    L15:
        if (this.mViewOutlineProvider != null) goto L17;
        ViewOutlineProvider r6 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r6;
        setOutlineProvider(r6);
    L17:
        setClipToOutline(true);
        int r7 = getWidth();
        int r1 = getHeight();
        float r2 = (Math.min(r7, r1) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r7, r1);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r2, r2, Path.Direction.CW);
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    public void setRound(float round) {
        if (Float.isNaN(round) == false) goto L7;
        this.mRound = round;
        float r5 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r5);
        return;
    L7:
        if (this.mRound == round) goto L9;
        boolean r0 = true;
    L10:
        this.mRound = round;
        if (round != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r0 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.mPath != null) goto L16;
        this.mPath = new Path();
    L16:
        if (this.mRect != null) goto L19;
        this.mRect = new RectF();
    L19:
        if (this.mViewOutlineProvider != null) goto L21;
        ViewOutlineProvider r6 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r6;
        setOutlineProvider(r6);
    L21:
        setClipToOutline(true);
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r7 = this.mPath;
        RectF r1 = this.mRect;
        float r2 = this.mRound;
        r7.addRoundRect(r1, r2, r2, Path.Direction.CW);
        goto L23
    L9:
        r0 = false;
        goto L10
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getRound() {
        return this.mRound;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
