package com.google.android.material.timepicker;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
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
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class ClockHandView extends View {
    private static final int DEFAULT_ANIMATION_DURATION = 200;
    private boolean animatingOnTouchUp;
    private final int animationDuration;
    private final TimeInterpolator animationInterpolator;
    private final float centerDotRadius;
    private boolean changedDuringTouch;
    private int circleRadius;
    private int currentLevel;
    private double degRad;
    private float downX;
    private float downY;
    private boolean isInTapRegion;
    private boolean isMultiLevel;
    private final List<OnRotateListener> listeners;
    private OnActionUpListener onActionUpListener;
    private float originalDeg;
    private final Paint paint;
    private final ValueAnimator rotationAnimator;
    private final int scaledTouchSlop;
    private final RectF selectorBox;
    private final int selectorRadius;
    private final int selectorStrokeWidth;

    public interface OnActionUpListener {
        void onActionUp(float r1, boolean r2);
    }

    public interface OnRotateListener {
        void onRotate(float r1, boolean r2);
    }

    public ClockHandView(Context r2) {
        this(r2, null);
    }

    public ClockHandView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.materialClockStyle);
    }

    public ClockHandView(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.rotationAnimator = new ValueAnimator();
        this.listeners = new ArrayList();
        Paint r0 = new Paint();
        this.paint = r0;
        this.selectorBox = new RectF();
        this.currentLevel = 1;
        TypedArray r8 = r5.obtainStyledAttributes(r6, R.styleable.ClockHandView, r7, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.animationDuration = MotionUtils.resolveThemeDuration(r5, R.attr.motionDurationLong2, 200);
        this.animationInterpolator = MotionUtils.resolveThemeInterpolator(r5, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.circleRadius = r8.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.selectorRadius = r8.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources r9 = getResources();
        this.selectorStrokeWidth = r9.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = r9.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int r10 = r8.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        r0.setAntiAlias(true);
        r0.setColor(r10);
        setHandRotation(0.0f);
        this.scaledTouchSlop = ViewConfiguration.get(r5).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        r8.recycle();
    }

    @Override // android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.rotationAnimator.isRunning() == true) goto L6;
        setHandRotation(getHandRotation());
        return;
    }

    public void setHandRotation(float r2) {
        setHandRotation(r2, false);
    }

    public void setHandRotation(float r4, boolean r5) {
        ValueAnimator r0 = this.rotationAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r5 == true) goto L9;
        setHandRotationInternal(r4, false);
        return;
    L9:
        Pair<Float, Float> r6 = getValuesForAnimation(r4);
        this.rotationAnimator.setFloatValues(new float[]{((Float) r6.first).floatValue(), ((Float) r6.second).floatValue()});
        this.rotationAnimator.setDuration(this.animationDuration);
        this.rotationAnimator.setInterpolator(this.animationInterpolator);
        this.rotationAnimator.addUpdateListener(new ClockHandView$$ExternalSyntheticLambda0(this));
        this.rotationAnimator.addListener(new AnonymousClass1(this));
        this.rotationAnimator.start();
    }

    /* JADX INFO: renamed from: lambda$setHandRotation$0$com-google-android-material-timepicker-ClockHandView, reason: not valid java name */
    /* synthetic */ void m284xb17f7076(ValueAnimator r2) {
        setHandRotationInternal(((Float) r2.getAnimatedValue()).floatValue(), true);
    }

    private Pair<Float, Float> getValuesForAnimation(float r4) {
        float r3 = getHandRotation();
        if (Math.abs(r3 - r4) <= 180.0f) goto L15;
        if (r3 <= 180.0f) goto L10;
        if (r4 >= 180.0f) goto L10;
        r4 = r4 + 360.0f;
    L10:
        if (r3 >= 180.0f) goto L15;
        if (r4 <= 180.0f) goto L15;
        r3 = r3 + 360.0f;
    L15:
        return new Pair(Float.valueOf(r3), Float.valueOf(r4));
    }

    private void setHandRotationInternal(float r8, boolean r9) {
        float r10 = r8 % 360.0f;
        this.originalDeg = r10;
        this.degRad = Math.toRadians(r10 - 90.0f);
        int r0 = getHeight() / 2;
        int r1 = getWidth() / 2;
        float r2 = getLeveledCircleRadius(this.currentLevel);
        float r3 = r1 + (((float) Math.cos(this.degRad)) * r2);
        float r4 = r0 + (r2 * ((float) Math.sin(this.degRad)));
        RectF r5 = this.selectorBox;
        int r6 = this.selectorRadius;
        r5.set(r3 - r6, r4 - r6, r3 + r6, r4 + r6);
        Iterator<OnRotateListener> r7 = this.listeners.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r7.next().onRotate(r10, r9);
        goto L4
    L6:
        invalidate();
    }

    public void setAnimateOnTouchUp(boolean r1) {
        this.animatingOnTouchUp = r1;
    }

    public void addOnRotateListener(OnRotateListener r1) {
        this.listeners.add(r1);
    }

    public void setOnActionUpListener(OnActionUpListener r1) {
        this.onActionUpListener = r1;
    }

    public float getHandRotation() {
        return this.originalDeg;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r1) {
        super.onDraw(r1);
        drawSelector(r1);
    }

    private void drawSelector(Canvas r12) {
        int r0 = getHeight() / 2;
        int r1 = getWidth() / 2;
        int r2 = getLeveledCircleRadius(this.currentLevel);
        float r9 = r1;
        float r3 = r2;
        float r4 = (((float) Math.cos(this.degRad)) * r3) + r9;
        float r10 = r0;
        float r5 = (r3 * ((float) Math.sin(this.degRad))) + r10;
        this.paint.setStrokeWidth(0.0f);
        r12.drawCircle(r4, r5, this.selectorRadius, this.paint);
        double r6 = Math.sin(this.degRad);
        double r7 = Math.cos(this.degRad);
        double r8 = r2 - this.selectorRadius;
        this.paint.setStrokeWidth(this.selectorStrokeWidth);
        r12.drawLine(r9, r10, r1 + ((int) (r7 * r8)), r0 + ((int) (r8 * r6)), this.paint);
        r12.drawCircle(r9, r10, this.centerDotRadius, this.paint);
    }

    public RectF getCurrentSelectorBox() {
        return this.selectorBox;
    }

    public int getSelectorRadius() {
        return this.selectorRadius;
    }

    public void setCircleRadius(int r1) {
        this.circleRadius = r1;
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r11) {
        int r0 = r11.getActionMasked();
        float r7 = r11.getX();
        float r12 = r11.getY();
        if (r0 == 0) goto L20;
        if (r0 != 1) goto L6;
    L8:
        int r2 = (int) (r7 - this.downX);
        int r3 = (int) (r12 - this.downY);
        if (((r2 * r2) + (r3 * r3)) <= this.scaledTouchSlop) goto L11;
        boolean r4 = true;
    L12:
        this.isInTapRegion = r4;
        boolean r5 = this.changedDuringTouch;
        if (r0 != 1) goto L15;
        boolean r1 = true;
    L17:
        if (this.isMultiLevel == false) goto L19;
        adjustLevel(r7, r12);
    L19:
        boolean r6 = false;
        boolean r8 = r5;
    L21:
        boolean r9 = handleTouchInput(r7, r12, r8, r6, r1) | this.changedDuringTouch;
        this.changedDuringTouch = r9;
        if (r9 == false) goto L27;
        if (r1 == false) goto L27;
        OnActionUpListener r10 = this.onActionUpListener;
        if (r10 == null) goto L27;
        r10.onActionUp(getDegreesFromXY(r7, r12), this.isInTapRegion);
    L27:
        return true;
    L15:
        r1 = false;
        goto L17
    L11:
        r4 = false;
        goto L12
    L6:
        if (r0 == 2) goto L8;
        r1 = false;
        r8 = false;
        r6 = false;
        goto L21
    L20:
        this.downX = r7;
        this.downY = r12;
        this.isInTapRegion = true;
        this.changedDuringTouch = false;
        r1 = false;
        r8 = false;
        r6 = true;
        goto L21
    }

    private void adjustLevel(float r4, float r5) {
        int r1 = 2;
        if (MathUtils.dist(getWidth() / 2, getHeight() / 2, r4, r5) <= (getLeveledCircleRadius(2) + ViewUtils.dpToPx(getContext(), 12))) goto L6;
        r1 = 1;
    L6:
        this.currentLevel = r1;
    }

    private boolean handleTouchInput(float r3, float r4, boolean r5, boolean r6, boolean r7) {
        float r8 = getDegreesFromXY(r3, r4);
        boolean r0 = false;
        if (getHandRotation() == r8) goto L5;
        boolean r9 = true;
    L6:
        if (r6 == false) goto L9;
        if (r9 == false) goto L9;
        return true;
    L9:
        if (r9 == true) goto L13;
        if (r5 == true) goto L13;
        return false;
    L13:
        if (r7 == true) goto L15;
    L17:
        setHandRotation(r8, r0);
        return true;
    L15:
        if (this.animatingOnTouchUp == false) goto L17;
        r0 = true;
        goto L17
    L5:
        r9 = false;
        goto L6
    }

    private int getDegreesFromXY(float r3, float r4) {
        int r0 = getWidth() / 2;
        int r2 = ((int) Math.toDegrees(Math.atan2(r4 - (getHeight() / 2), r3 - r0))) + 90;
        if (r2 < 0) goto L5;
        return r2;
    L5:
        return r2 + 360;
    }

    int getCurrentLevel() {
        return this.currentLevel;
    }

    void setCurrentLevel(int r1) {
        this.currentLevel = r1;
        invalidate();
    }

    void setMultiLevel(boolean r2) {
        if (this.isMultiLevel == false) goto L6;
        if (r2 == true) goto L6;
        this.currentLevel = 1;
    L6:
        this.isMultiLevel = r2;
        invalidate();
    }

    private int getLeveledCircleRadius(int r2) {
        int r1 = this.circleRadius;
        if (r2 == 2) goto L5;
        return r1;
    L5:
        return Math.round(r1 * 0.66f);
    }
}
