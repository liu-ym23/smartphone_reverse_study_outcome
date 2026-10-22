package com.google.android.material.timepicker;

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
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
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
    private final List<b> listeners;
    private a onActionUpListener;
    private float originalDeg;
    private final Paint paint;
    private ValueAnimator rotationAnimator;
    private int scaledTouchSlop;
    private final RectF selectorBox;
    private final int selectorRadius;
    private final int selectorStrokeWidth;

    public interface a {
        void a(float r1, boolean r2);
    }

    public interface b {
        void onRotate(float r1, boolean r2);
    }

    static /* synthetic */ void access$000(ClockHandView r0, float r1, boolean r2) {
        r0.setHandRotationInternal(r1, r2);
    }

    public ClockHandView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public ClockHandView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.materialClockStyle, "attr", "materialClockStyle"));
    }

    public ClockHandView(Context r7, AttributeSet r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r10, r11, r9);
        this.listeners = new ArrayList();
        Paint r0 = new Paint();
        this.paint = r0;
        this.selectorBox = new RectF();
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.ClockHandView, r9, ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_TimePicker_Clock, "style", "Widget_MaterialComponents_TimePicker_Clock"));
        this.circleRadius = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ClockHandView_materialCircleRadius, "styleable", "ClockHandView_materialCircleRadius"), 0);
        this.selectorRadius = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ClockHandView_selectorSize, "styleable", "ClockHandView_selectorSize"), 0);
        Resources r13 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin");
        this.selectorStrokeWidth = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_clock_hand_stroke_width, "dimen", "material_clock_hand_stroke_width"));
        this.centerDotRadius = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_clock_hand_center_dot_radius, "dimen", "material_clock_hand_center_dot_radius"));
        int r14 = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.ClockHandView_clockHandColor, "styleable", "ClockHandView_clockHandColor"), 0);
        r0.setAntiAlias(true);
        r0.setColor(r14);
        setHandRotation(0.0f);
        this.scaledTouchSlop = ViewConfiguration.get(r10).getScaledTouchSlop();
        ViewCompat.c(this, 2);
        r12.recycle();
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        setHandRotation(getHandRotation());
    }

    public void setHandRotation(float r2) {
        setHandRotation(r2, false);
    }

    public void setHandRotation(float r5, boolean r6) {
        ValueAnimator r0 = this.rotationAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r6 == true) goto L9;
        setHandRotationInternal(r5, false);
        return;
    L9:
        Pair<Float, Float> r7 = getValuesForAnimation(r5);
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{((Float) ZeusTransformUtils.preCheckCast(r7.first, Float.class, "com.obric.aiagent.plugin")).floatValue(), ((Float) ZeusTransformUtils.preCheckCast(r7.second, Float.class, "com.obric.aiagent.plugin")).floatValue()});
        this.rotationAnimator = r8;
        r8.setDuration(200);
        this.rotationAnimator.addUpdateListener(new AnonymousClass1(this));
        this.rotationAnimator.addListener(new AnonymousClass2(this));
        this.rotationAnimator.start();
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
        float r1 = (getWidth() / 2) + (this.circleRadius * ((float) Math.cos(this.degRad)));
        float r2 = r0 + (this.circleRadius * ((float) Math.sin(this.degRad)));
        RectF r3 = this.selectorBox;
        int r4 = this.selectorRadius;
        r3.set(r1 - r4, r2 - r4, r1 + r4, r2 + r4);
        Iterator<b> r5 = this.listeners.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin")).onRotate(r10, r9);
        goto L4
    L6:
        invalidate();
    }

    public void setAnimateOnTouchUp(boolean r1) {
        this.animatingOnTouchUp = r1;
    }

    public void addOnRotateListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.listeners.add(r4);
    }

    public void setOnActionUpListener(a r3) {
        this.onActionUpListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public float getHandRotation() {
        return this.originalDeg;
    }

    @Override // android.view.View
    public void onDraw(Canvas r1) {
        super.onDraw(r1);
        drawSelector(r1);
    }

    private void drawSelector(Canvas r11) {
        int r0 = getHeight() / 2;
        int r1 = getWidth() / 2;
        float r8 = r1;
        float r2 = (this.circleRadius * ((float) Math.cos(this.degRad))) + r8;
        float r9 = r0;
        float r3 = (this.circleRadius * ((float) Math.sin(this.degRad))) + r9;
        this.paint.setStrokeWidth(0.0f);
        r11.drawCircle(r2, r3, this.selectorRadius, this.paint);
        double r4 = Math.sin(this.degRad);
        double r5 = Math.cos(this.degRad);
        double r6 = this.circleRadius - this.selectorRadius;
        this.paint.setStrokeWidth(this.selectorStrokeWidth);
        r11.drawLine(r8, r9, r1 + ((int) (r5 * r6)), r0 + ((int) (r6 * r4)), this.paint);
        r11.drawCircle(r8, r9, this.centerDotRadius, this.paint);
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
        if (r0 == 0) goto L17;
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
    L16:
        boolean r6 = false;
        boolean r8 = r5;
    L18:
        boolean r9 = handleTouchInput(r7, r12, r8, r6, r1) | this.changedDuringTouch;
        this.changedDuringTouch = r9;
        if (r9 == false) goto L24;
        if (r1 == false) goto L24;
        a r10 = this.onActionUpListener;
        if (r10 == null) goto L24;
        r10.a(getDegreesFromXY(r7, r12), this.isInTapRegion);
    L24:
        return true;
    L15:
        r1 = false;
        goto L16
    L11:
        r4 = false;
        goto L12
    L6:
        if (r0 == 2) goto L8;
        r1 = false;
        r8 = false;
        r6 = false;
        goto L18
    L17:
        this.downX = r7;
        this.downY = r12;
        this.isInTapRegion = true;
        this.changedDuringTouch = false;
        r1 = false;
        r8 = false;
        r6 = true;
        goto L18
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
}
