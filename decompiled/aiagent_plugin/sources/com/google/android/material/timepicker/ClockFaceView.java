package com.google.android.material.timepicker;

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
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.b {
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
    private final AccessibilityDelegateCompat valueAccessibilityDelegate;
    private String[] values;

    static /* synthetic */ ClockHandView access$000(ClockFaceView r0) {
        return r0.clockHandView;
    }

    static /* synthetic */ int access$100(ClockFaceView r0) {
        return r0.clockHandPadding;
    }

    static /* synthetic */ SparseArray access$200(ClockFaceView r0) {
        return r0.textViewPool;
    }

    public ClockFaceView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public ClockFaceView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.materialClockStyle, "attr", "materialClockStyle"));
    }

    public ClockFaceView(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r13, r14, r12);
        this.textViewRect = new Rect();
        this.scratch = new RectF();
        this.textViewPool = new SparseArray();
        this.gradientPositions = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray r15 = r13.obtainStyledAttributes(r14, R.styleable.ClockFaceView, r12, ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_TimePicker_Clock, "style", "Widget_MaterialComponents_TimePicker_Clock"));
        Resources r16 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin");
        ColorStateList r2 = com.google.android.material.g.c.a(r13, r15, ZeusTransformUtils.mapRes(R.styleable.ClockFaceView_clockNumberTextColor, "styleable", "ClockFaceView_clockNumberTextColor"));
        this.textColor = r2;
        ZeusTransformUtils.inflate(LayoutInflater.from(r13), ZeusTransformUtils.mapRes(R.layout.material_clockface_view, "layout", "material_clockface_view"), this, true, "com.obric.aiagent.plugin");
        ClockHandView r1 = (ClockHandView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.material_clock_hand, DbHelper.COL_ID, "material_clock_hand")), ClockHandView.class, "com.obric.aiagent.plugin");
        this.clockHandView = r1;
        this.clockHandPadding = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_clock_hand_padding, "dimen", "material_clock_hand_padding"));
        int r4 = r2.getColorForState(new int[]{android.R.attr.state_selected}, r2.getDefaultColor());
        this.gradientColors = new int[]{r4, r4, r2.getDefaultColor()};
        r1.addOnRotateListener(this);
        int r0 = androidx.appcompat.a.a.a.a(r13, ZeusTransformUtils.mapRes(R.color.material_timepicker_clockface, "color", "material_timepicker_clockface")).getDefaultColor();
        ColorStateList r17 = com.google.android.material.g.c.a(r13, r15, ZeusTransformUtils.mapRes(R.styleable.ClockFaceView_clockFaceBackgroundColor, "styleable", "ClockFaceView_clockFaceBackgroundColor"));
        if (r17 == null) goto L6;
        r0 = r17.getDefaultColor();
    L6:
        setBackgroundColor(r0);
        getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(this));
        setFocusable(true);
        r15.recycle();
        this.valueAccessibilityDelegate = new AnonymousClass2(this);
        String[] r18 = new String[12];
        Arrays.fill(r18, "");
        setValues(r18, 0);
        this.minimumHeight = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_time_picker_minimum_screen_height, "dimen", "material_time_picker_minimum_screen_height"));
        this.minimumWidth = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_time_picker_minimum_screen_width, "dimen", "material_time_picker_minimum_screen_width"));
        this.clockSize = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_clock_size, "dimen", "material_clock_size"));
    }

    public void setValues(String[] r1, int r2) {
        this.values = r1;
        updateTextViews(r2);
    }

    private void updateTextViews(int r10) {
        LayoutInflater r0 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        int r2 = this.textViewPool.size();
        int r4 = 0;
    L4:
        if (r4 >= Math.max(this.values.length, r2)) goto L14;
        TextView r5 = (TextView) ZeusTransformUtils.preCheckCast(this.textViewPool.get(r4), TextView.class, "com.obric.aiagent.plugin");
        if (r4 < this.values.length) goto L8;
        removeView(r5);
        this.textViewPool.remove(r4);
    L13:
        r4 = r4 + 1;
        goto L4
    L8:
        if (r5 != null) goto L10;
        r5 = (TextView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r0, ZeusTransformUtils.mapRes(R.layout.material_clockface_textview, "layout", "material_clockface_textview"), this, false, "com.obric.aiagent.plugin"), TextView.class, "com.obric.aiagent.plugin");
        this.textViewPool.put(r4, r5);
        addView(r5);
    L10:
        r5.setVisibility(0);
        r5.setText(this.values[r4]);
        r5.setTag(ZeusTransformUtils.mapRes(R.id.material_value_index, DbHelper.COL_ID, "material_value_index"), Integer.valueOf(r4));
        ViewCompat.a(r5, this.valueAccessibilityDelegate);
        r5.setTextColor(this.textColor);
        if (r10 == 0) goto L13;
        r5.setContentDescription(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(r10, new Object[]{this.values[r4]}));
        goto L13
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r3) {
        super.onInitializeAccessibilityNodeInfo(r3);
        androidx.core.view.accessibility.b.a(r3).b(androidx.core.view.accessibility.b.f.a(1, this.values.length, false, 1));
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void setRadius(int r2) {
        if (r2 == getRadius()) goto L6;
        super.setRadius(r2);
        this.clockHandView.setCircleRadius(getRadius());
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        findIntersectingTextView();
    }

    public void setHandRotation(float r2) {
        this.clockHandView.setHandRotation(r2);
        findIntersectingTextView();
    }

    private void findIntersectingTextView() {
        RectF r0 = this.clockHandView.getCurrentSelectorBox();
        int r1 = 0;
    L4:
        if (r1 >= this.textViewPool.size()) goto L10;
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(this.textViewPool.get(r1), TextView.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r2.getDrawingRect(this.textViewRect);
        offsetDescendantRectToMyCoords(r2, this.textViewRect);
        r2.setSelected(r0.contains(this.textViewRect.centerX(), this.textViewRect.centerY()));
        r2.getPaint().setShader(getGradientForTextView(r0, this.textViewRect, r2));
        r2.invalidate();
    L9:
        r1 = r1 + 1;
        goto L4
    }

    private RadialGradient getGradientForTextView(RectF r8, Rect r9, TextView r10) {
        this.scratch.set(r9);
        this.scratch.offset(r10.getPaddingLeft(), r10.getPaddingTop());
        if (RectF.intersects(r8, this.scratch) == true) goto L7;
        return null;
    L7:
        return new RadialGradient(r8.centerX() - this.scratch.left, r8.centerY() - this.scratch.top, r8.width() * 0.5f, this.gradientColors, this.gradientPositions, Shader.TileMode.CLAMP);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void onRotate(float r2, boolean r3) {
        if (Math.abs(this.currentHandRotation - r2) <= EPSILON) goto L6;
        this.currentHandRotation = r2;
        findIntersectingTextView();
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r3, int r4) {
        DisplayMetrics r5 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics();
        int r6 = (int) (this.clockSize / max3(this.minimumHeight / r5.heightPixels, this.minimumWidth / r5.widthPixels, 1.0f));
        int r7 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
        setMeasuredDimension(r6, r6);
        super.onMeasure(r7, r7);
    }

    private static float max3(float r0, float r1, float r2) {
        return Math.max(Math.max(r0, r1), r2);
    }
}
