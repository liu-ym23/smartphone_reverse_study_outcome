package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import androidx.core.view.a;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.common.primitives.Ints;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {
    private static final float EPSILON = 0.001f;
    private static final int INITIAL_CAPACITY = 12;
    private static final String VALUE_PLACEHOLDER = "";
    private final int clockHandPadding;
    private final ClockHandView clockHandView;
    private final int clockSize;
    private float currentHandRotation;
    private final int[] gradientColors;
    private final float[] gradientPositions;
    private final int minimumHeight;
    private final int minimumWidth;
    private final RectF scratch;
    private final ColorStateList textColor;
    private final SparseArray<TextView> textViewPool;
    private final Rect textViewRect;
    private final a valueAccessibilityDelegate;
    private String[] values;

    public ClockFaceView(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ ClockHandView access$000(ClockFaceView r10) {
        return r10.clockHandView;
    }

    public static /* synthetic */ int access$100(ClockFaceView r10) {
        return r10.clockHandPadding;
    }

    public static /* synthetic */ SparseArray access$200(ClockFaceView r10) {
        return r10.textViewPool;
    }

    private void findIntersectingTextView() {
        RectF r10 = this.clockHandView.getCurrentSelectorBox();
        int r11 = 0;
    L4:
        if (r11 >= this.textViewPool.size()) goto L10;
        TextView r12 = this.textViewPool.get(r11);
        if (r12 == null) goto L9;
        r12.getDrawingRect(this.textViewRect);
        this.textViewRect.offset(r12.getPaddingLeft(), r12.getPaddingTop());
        offsetDescendantRectToMyCoords(r12, this.textViewRect);
        this.scratch.set(this.textViewRect);
        RadialGradient r13 = getGradientForTextView(r10, this.scratch);
        r12.getPaint().setShader(r13);
        r12.invalidate();
    L9:
        r11 = r11 + 1;
        goto L4
    }

    private RadialGradient getGradientForTextView(RectF r10, RectF r11) {
        if (RectF.intersects(r10, r11) == true) goto L7;
        return null;
    L7:
        return new RadialGradient(r10.centerX() - this.scratch.left, r10.centerY() - this.scratch.top, r10.width() * 0.5f, this.gradientColors, this.gradientPositions, Shader.TileMode.CLAMP);
    }

    private static float max3(float r10, float r11, float r12) {
        return Math.max(Math.max(r10, r11), r12);
    }

    private void updateTextViews(@StringRes int r10) {
        LayoutInflater r11 = LayoutInflater.from(getContext());
        int r12 = this.textViewPool.size();
        int r13 = 0;
    L4:
        if (r13 >= Math.max(this.values.length, r12)) goto L14;
        TextView r14 = this.textViewPool.get(r13);
        if (r13 < this.values.length) goto L8;
        removeView(r14);
        this.textViewPool.remove(r13);
    L13:
        r13 = r13 + 1;
        goto L4
    L8:
        if (r14 != null) goto L10;
        r14 = (TextView) r11.inflate(R.layout.material_clockface_textview, this, false);
        this.textViewPool.put(r13, r14);
        addView(r14);
    L10:
        r14.setVisibility(0);
        r14.setText(this.values[r13]);
        r14.setTag(R.id.material_value_index, Integer.valueOf(r13));
        ViewCompat.p0(r14, this.valueAccessibilityDelegate);
        r14.setTextColor(this.textColor);
        if (r10 == 0) goto L13;
        r14.setContentDescription(getResources().getString(r10, new Object[]{this.values[r13]}));
        goto L13
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        AccessibilityNodeInfoCompat.B0(r10).X(AccessibilityNodeInfoCompat.b.b(1, this.values.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        findIntersectingTextView();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        DisplayMetrics r12 = getResources().getDisplayMetrics();
        int r13 = (int) (this.clockSize / max3(this.minimumHeight / r12.heightPixels, this.minimumWidth / r12.widthPixels, 1.0f));
        int r14 = View.MeasureSpec.makeMeasureSpec(r13, Ints.MAX_POWER_OF_TWO);
        setMeasuredDimension(r13, r13);
        super.onMeasure(r14, r14);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float r10, boolean r11) {
        if (Math.abs(this.currentHandRotation - r10) <= EPSILON) goto L6;
        this.currentHandRotation = r10;
        findIntersectingTextView();
        return;
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float r10) {
        this.clockHandView.setHandRotation(r10);
        findIntersectingTextView();
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void setRadius(int r10) {
        if (r10 == getRadius()) goto L6;
        super.setRadius(r10);
        this.clockHandView.setCircleRadius(getRadius());
        return;
    }

    public void setValues(String[] r10, @StringRes int r11) {
        this.values = r10;
        updateTextViews(r11);
    }

    public ClockFaceView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.textViewRect = new Rect();
        this.scratch = new RectF();
        this.textViewPool = new SparseArray();
        this.gradientPositions = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray r13 = r10.obtainStyledAttributes(r11, R.styleable.ClockFaceView, r12, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources r14 = getResources();
        ColorStateList r15 = MaterialResources.getColorStateList(r10, r13, R.styleable.ClockFaceView_clockNumberTextColor);
        this.textColor = r15;
        LayoutInflater.from(r10).inflate(R.layout.material_clockface_view, this, true);
        ClockHandView r16 = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.clockHandView = r16;
        this.clockHandPadding = r14.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int r17 = r15.getColorForState(new int[]{android.R.attr.state_selected}, r15.getDefaultColor());
        this.gradientColors = new int[]{r17, r17, r15.getDefaultColor()};
        r16.addOnRotateListener(this);
        int r18 = c.a.a(r10, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList r19 = MaterialResources.getColorStateList(r10, r13, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        if (r19 == null) goto L6;
        r18 = r19.getDefaultColor();
    L6:
        setBackgroundColor(r18);
        getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(this));
        setFocusable(true);
        r13.recycle();
        this.valueAccessibilityDelegate = new AnonymousClass2(this);
        String[] r20 = new String[12];
        Arrays.fill(r20, "");
        setValues(r20, 0);
        this.minimumHeight = r14.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.minimumWidth = r14.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.clockSize = r14.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}
