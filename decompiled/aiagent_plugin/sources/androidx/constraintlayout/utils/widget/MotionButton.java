package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public MotionButton(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r4);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r4, null);
    }

    public MotionButton(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r5, r6);
    }

    public MotionButton(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r6, r7);
    }

    private void init(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        int r12 = 0;
        setPadding(0, 0, 0, 0);
        if (r11 == null) goto L25;
        TypedArray r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r11, R.styleable.ImageFilterView);
        int r0 = r13.getIndexCount();
    L5:
        if (r12 >= r0) goto L17;
        int r1 = r13.getIndex(r12);
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_round, "styleable", "ImageFilterView_round")) goto L12;
        if (Build.VERSION.SDK_INT < 21) goto L16;
        setRound(r13.getDimension(r1, 0.0f));
    L16:
        r12 = r12 + 1;
        goto L5
    L12:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ImageFilterView_roundPercent, "styleable", "ImageFilterView_roundPercent")) goto L16;
        if (Build.VERSION.SDK_INT < 21) goto L16;
        setRoundPercent(r13.getFloat(r1, 0.0f));
        goto L16
    L17:
        r13.recycle();
        return;
    }

    public void setRoundPercent(float r7) {
        if (this.mRoundPercent == r7) goto L5;
        boolean r0 = true;
    L6:
        this.mRoundPercent = r7;
        if (r7 == 0.0f) goto L22;
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L15;
        this.mRect = new RectF();
    L15:
        if (Build.VERSION.SDK_INT >= 21) goto L17;
    L20:
        int r8 = getWidth();
        int r1 = getHeight();
        float r2 = (Math.min(r8, r1) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r8, r1);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r2, r2, Path.Direction.CW);
    L24:
        if (r0 == true) goto L26;
        return;
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L30;
        invalidateOutline();
        return;
    L30:
        return;
    L17:
        if (this.mViewOutlineProvider != null) goto L19;
        ViewOutlineProvider r9 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r9;
        setOutlineProvider(r9);
    L19:
        setClipToOutline(true);
        goto L20
    L22:
        if (Build.VERSION.SDK_INT < 21) goto L24;
        setClipToOutline(false);
        goto L24
    L5:
        r0 = false;
        goto L6
    }

    public void setRound(float r6) {
        if (Float.isNaN(r6) == false) goto L7;
        this.mRound = r6;
        float r7 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r7);
        return;
    L7:
        if (this.mRound == r6) goto L9;
        boolean r0 = true;
    L10:
        this.mRound = r6;
        if (r6 == 0.0f) goto L26;
        if (this.mPath != null) goto L16;
        this.mPath = new Path();
    L16:
        if (this.mRect != null) goto L19;
        this.mRect = new RectF();
    L19:
        if (Build.VERSION.SDK_INT >= 21) goto L21;
    L24:
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r8 = this.mPath;
        RectF r1 = this.mRect;
        float r2 = this.mRound;
        r8.addRoundRect(r1, r2, r2, Path.Direction.CW);
    L28:
        if (r0 == true) goto L30;
        return;
    L30:
        if (Build.VERSION.SDK_INT < 21) goto L34;
        invalidateOutline();
        return;
    L34:
        return;
    L21:
        if (this.mViewOutlineProvider != null) goto L23;
        ViewOutlineProvider r9 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r9;
        setOutlineProvider(r9);
    L23:
        setClipToOutline(true);
        goto L24
    L26:
        if (Build.VERSION.SDK_INT < 21) goto L28;
        setClipToOutline(false);
        goto L28
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
    public void draw(Canvas r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L9:
        boolean r0 = false;
    L10:
        super.draw(r3);
        if (r0 == false) goto L14;
        r3.restore();
        return;
    L14:
        return;
    L5:
        if (this.mRound == 0.0f) goto L9;
        if (this.mPath == null) goto L9;
        r0 = true;
        r3.save();
        r3.clipPath(this.mPath);
        goto L10
    }
}
