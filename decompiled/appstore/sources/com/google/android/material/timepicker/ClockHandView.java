package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class ClockHandView extends View {
    private static final int ANIMATION_DURATION = 200;
    private boolean animatingOnTouchUp;
    private final float centerDotRadius;
    private boolean changedDuringTouch;
    private int circleRadius;
    private double degRad;
    private float downX;
    private float downY;
    private boolean isInTapRegion;
    private final List<OnRotateListener> listeners;
    private OnActionUpListener onActionUpListener;
    private float originalDeg;
    private final Paint paint;
    private ValueAnimator rotationAnimator;
    private int scaledTouchSlop;
    private final RectF selectorBox;
    private final int selectorRadius;

    @Px
    private final int selectorStrokeWidth;

    public interface OnActionUpListener {
        void onActionUp(@FloatRange(from = 0.0d, to = 360.0d) float r10, boolean r11);
    }

    public interface OnRotateListener {
        void onRotate(@FloatRange(from = 0.0d, to = 360.0d) float r10, boolean r11);
    }

    public ClockHandView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ void access$000(ClockHandView r10, float r11, boolean r12) {
        r10.setHandRotationInternal(r11, r12);
    }

    private void drawSelector(Canvas r11) {
        int r10 = getHeight() / 2;
        int r12 = getWidth() / 2;
        float r13 = r12;
        float r14 = (this.circleRadius * ((float) Math.cos(this.degRad))) + r13;
        float r15 = r10;
        float r16 = (this.circleRadius * ((float) Math.sin(this.degRad))) + r15;
        this.paint.setStrokeWidth(0.0f);
        r11.drawCircle(r14, r16, this.selectorRadius, this.paint);
        double r17 = Math.sin(this.degRad);
        double r18 = Math.cos(this.degRad);
        double r19 = this.circleRadius - this.selectorRadius;
        this.paint.setStrokeWidth(this.selectorStrokeWidth);
        r11.drawLine(r13, r15, r12 + ((int) (r18 * r19)), r10 + ((int) (r19 * r17)), this.paint);
        r11.drawCircle(r13, r15, this.centerDotRadius, this.paint);
    }

    private int getDegreesFromXY(float r10, float r11) {
        int r12 = getWidth() / 2;
        int r13 = (int) Math.toDegrees(Math.atan2(r11 - (getHeight() / 2), r10 - r12));
        int r14 = r13 + 90;
        if (r14 < 0) goto L5;
        return r14;
    L5:
        return r13 + AnimationConstants.DURATION_450;
    }

    private Pair<Float, Float> getValuesForAnimation(float r10) {
        float r11 = getHandRotation();
        if (Math.abs(r11 - r10) <= 180.0f) goto L15;
        if (r11 <= 180.0f) goto L10;
        if (r10 >= 180.0f) goto L10;
        r10 = r10 + 360.0f;
    L10:
        if (r11 >= 180.0f) goto L15;
        if (r10 <= 180.0f) goto L15;
        r11 = r11 + 360.0f;
    L15:
        return new Pair(Float.valueOf(r11), Float.valueOf(r10));
    }

    private boolean handleTouchInput(float r10, float r11, boolean r12, boolean r13, boolean r14) {
        float r15 = getDegreesFromXY(r10, r11);
        boolean r16 = false;
        if (getHandRotation() == r15) goto L5;
        boolean r17 = true;
    L6:
        if (r13 == false) goto L9;
        if (r17 == false) goto L9;
        return true;
    L9:
        if (r17 == true) goto L13;
        if (r12 == true) goto L13;
        return false;
    L13:
        if (r14 == true) goto L15;
    L17:
        setHandRotation(r15, r16);
        return true;
    L15:
        if (this.animatingOnTouchUp == false) goto L17;
        r16 = true;
        goto L17
    L5:
        r17 = false;
        goto L6
    }

    private void setHandRotationInternal(@FloatRange(from = 0.0d, to = 360.0d) float r10, boolean r11) {
        float r12 = r10 % 360.0f;
        this.originalDeg = r12;
        this.degRad = Math.toRadians(r12 - 90.0f);
        int r13 = getHeight() / 2;
        float r14 = (getWidth() / 2) + (this.circleRadius * ((float) Math.cos(this.degRad)));
        float r15 = r13 + (this.circleRadius * ((float) Math.sin(this.degRad)));
        RectF r16 = this.selectorBox;
        int r17 = this.selectorRadius;
        r16.set(r14 - r17, r15 - r17, r14 + r17, r15 + r17);
        Iterator<OnRotateListener> r18 = this.listeners.iterator();
    L4:
        if (r18.hasNext() == false) goto L6;
        r18.next().onRotate(r12, r11);
        goto L4
    L6:
        invalidate();
    }

    public void addOnRotateListener(OnRotateListener r10) {
        this.listeners.add(r10);
    }

    public RectF getCurrentSelectorBox() {
        return this.selectorBox;
    }

    @FloatRange(from = 0.0d, to = 360.0d)
    public float getHandRotation() {
        return this.originalDeg;
    }

    public int getSelectorRadius() {
        return this.selectorRadius;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        drawSelector(r10);
    }

    @Override // android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        setHandRotation(getHandRotation());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent r11) {
        int r10 = r11.getActionMasked();
        float r12 = r11.getX();
        float r13 = r11.getY();
        if (r10 == 0) goto L17;
        if (r10 != 1) goto L6;
    L8:
        int r14 = (int) (r12 - this.downX);
        int r15 = (int) (r13 - this.downY);
        if (((r14 * r14) + (r15 * r15)) <= this.scaledTouchSlop) goto L11;
        boolean r16 = true;
    L12:
        this.isInTapRegion = r16;
        boolean r17 = this.changedDuringTouch;
        if (r10 != 1) goto L15;
        boolean r18 = true;
    L16:
        boolean r19 = false;
        boolean r20 = r17;
    L18:
        boolean r21 = handleTouchInput(r12, r13, r20, r19, r18) | this.changedDuringTouch;
        this.changedDuringTouch = r21;
        if (r21 == false) goto L24;
        if (r18 == false) goto L24;
        OnActionUpListener r22 = this.onActionUpListener;
        if (r22 == null) goto L24;
        r22.onActionUp(getDegreesFromXY(r12, r13), this.isInTapRegion);
    L24:
        return true;
    L15:
        r18 = false;
        goto L16
    L11:
        r16 = false;
        goto L12
    L6:
        if (r10 == 2) goto L8;
        r18 = false;
        r20 = false;
        r19 = false;
        goto L18
    L17:
        this.downX = r12;
        this.downY = r13;
        this.isInTapRegion = true;
        this.changedDuringTouch = false;
        r18 = false;
        r20 = false;
        r19 = true;
        goto L18
    }

    public void setAnimateOnTouchUp(boolean r10) {
        this.animatingOnTouchUp = r10;
    }

    public void setCircleRadius(@Dimension int r10) {
        this.circleRadius = r10;
        invalidate();
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float r10) {
        setHandRotation(r10, false);
    }

    public void setOnActionUpListener(OnActionUpListener r10) {
        this.onActionUpListener = r10;
    }

    public ClockHandView(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.materialClockStyle);
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float r10, boolean r11) {
        ValueAnimator r12 = this.rotationAnimator;
        if (r12 == null) goto L5;
        r12.cancel();
    L5:
        if (r11 == true) goto L8;
        setHandRotationInternal(r10, false);
        return;
    L8:
        Pair<Float, Float> r13 = getValuesForAnimation(r10);
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{((Float) r13.first).floatValue(), ((Float) r13.second).floatValue()});
        this.rotationAnimator = r14;
        r14.setDuration(200);
        this.rotationAnimator.addUpdateListener(new AnonymousClass1(this));
        this.rotationAnimator.addListener(new AnonymousClass2(this));
        this.rotationAnimator.start();
    }

    public ClockHandView(Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.listeners = new ArrayList();
        Paint r13 = new Paint();
        this.paint = r13;
        this.selectorBox = new RectF();
        TypedArray r14 = r10.obtainStyledAttributes(r11, R.styleable.ClockHandView, r12, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.circleRadius = r14.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.selectorRadius = r14.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources r15 = getResources();
        this.selectorStrokeWidth = r15.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = r15.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int r16 = r14.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        r13.setAntiAlias(true);
        r13.setColor(r16);
        setHandRotation(0.0f);
        this.scaledTouchSlop = ViewConfiguration.get(r10).getScaledTouchSlop();
        ViewCompat.A0(this, 2);
        r14.recycle();
    }
}
