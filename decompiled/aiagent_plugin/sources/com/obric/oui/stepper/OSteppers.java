package com.obric.oui.stepper;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUIConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OSteppers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSteppers extends OUIConstraintLayout {
    public static final a Companion = null;
    public static final int NUMBER_SIZE = 13;
    public static final int STEP = 1;
    public static final double TEXT_STROKE_WIDTH = 1.5d;
    private final ViewGroup addContainerView;
    private final ViewGroup decContainerView;
    private final EditText etCounter;
    private int mMaxValue;
    private int mMinValue;
    private int mStepValue;
    private int mValue;
    private b onValueChangeListener;
    private final OButton tvAdd;
    private final OButton tvDec;

    /* JADX INFO: compiled from: OSteppers.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OSteppers.kt */
    public interface b {
        void a();

        void a(int r1);

        void a(int r1, int r2);

        void b();

        void c();
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSteppers(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void lambda$FEXxyf6GhKLyMIUXnSW6PuJorPU(OSteppers r0, View r1) {
        m1188registerEvent$lambda3(r0, r1);
    }

    public static /* synthetic */ void lambda$FZLArISMxlA3RPflFS1f3RjaPCc(OSteppers r0, View r1) {
        m1189registerEvent$lambda4(r0, r1);
    }

    public static /* synthetic */ void lambda$K73YMD5GyDx5Fpa6c5sCLw4_hcY(OSteppers r0, View r1) {
        m1186registerEvent$lambda1(r0, r1);
    }

    public static /* synthetic */ void lambda$XexZo2eSlDcJfGqQZfF2Xb1EWho(OSteppers r0, View r1) {
        m1187registerEvent$lambda2(r0, r1);
    }

    public static /* synthetic */ void lambda$pY23Y3X_kqsSBSRhYCZO1AFAiM8(OSteppers r0, int r1) {
        m1190registerInputFilter$lambda5(r0, r1);
    }

    public /* synthetic */ OSteppers(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ void access$checkCounter(OSteppers r0) {
        r0.checkCounter();
    }

    public static final /* synthetic */ void access$setMValue(OSteppers r0, int r1) {
        r0.setMValue(r1);
    }

    public OSteppers(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        super(r12, r13, 0, null, 12, null);
        this.mMaxValue = 100;
        this.mStepValue = 1;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ConstraintLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        ZeusTransformUtils.inflate(LayoutInflater.from(r12), ZeusTransformUtils.mapRes(R.layout.o_widget_steppers, "layout", "o_widget_steppers"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_add, DbHelper.COL_ID, "tv_add"));
        o.c(r2, "findViewById(R.id.tv_add)");
        this.tvAdd = (OButton) ZeusTransformUtils.preCheckCast(r2, OButton.class, "com.obric.aiagent.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_dec, DbHelper.COL_ID, "tv_dec"));
        o.c(r3, "findViewById(R.id.tv_dec)");
        this.tvDec = (OButton) ZeusTransformUtils.preCheckCast(r3, OButton.class, "com.obric.aiagent.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.et_counter, DbHelper.COL_ID, "et_counter"));
        o.c(r4, "findViewById(R.id.et_counter)");
        this.etCounter = (EditText) ZeusTransformUtils.preCheckCast(r4, EditText.class, "com.obric.aiagent.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.increase_container, DbHelper.COL_ID, "increase_container"));
        o.c(r5, "findViewById(R.id.increase_container)");
        this.addContainerView = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.decrease_container, DbHelper.COL_ID, "decrease_container"));
        o.c(r6, "findViewById(R.id.decrease_container)");
        this.decContainerView = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin");
        TypedArray r14 = r12.obtainStyledAttributes(r13, R.styleable.OSteppers, 0, 0);
        setMValue(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSteppers_oui_stepper_value, "styleable", "OSteppers_oui_stepper_value"), 0));
        setMMinValue(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSteppers_oui_min_value, "styleable", "OSteppers_oui_min_value"), Integer.MIN_VALUE));
        setMMaxValue(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSteppers_oui_max_value, "styleable", "OSteppers_oui_max_value"), Integer.MAX_VALUE));
        setMStepValue(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSteppers_oui_step, "styleable", "OSteppers_oui_step"), 1));
        r14.recycle();
        View r15 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        int r0 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
        r15.setPadding(r0, r0, r0, r0);
        setRadius(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_r_m2_rect, "dimen", "oui_r_m2_rect")));
        setBackgroundResource(ZeusTransformUtils.mapRes(R.color.oui_fill_sunken_variable, "color", "oui_fill_sunken_variable"));
        registerEvent();
        refreshCounter();
    }

    public final b getOnValueChangeListener() {
        return this.onValueChangeListener;
    }

    public final void setOnValueChangeListener(b r3) {
        this.onValueChangeListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    private final void setMValue(int r2) {
        if (this.mValue != r2) goto L5;
        return;
    L5:
        this.mValue = r2;
        b r0 = this.onValueChangeListener;
        if (r0 == null) goto L9;
        r0.a(r2, r2);
    L9:
        refreshCounter();
    }

    private final void setMMinValue(int r1) {
        this.mMinValue = r1;
        registerInputFilter();
        refreshCounter();
    }

    private final void setMMaxValue(int r1) {
        this.mMaxValue = r1;
        registerInputFilter();
        refreshCounter();
    }

    private final void setMStepValue(int r1) {
        this.mStepValue = r1;
        refreshCounter();
    }

    private final void registerEvent() {
        this.tvAdd.setOnClickListener(new $$Lambda$OSteppers$K73YMD5GyDx5Fpa6c5sCLw4_hcY(this));
        this.tvDec.setOnClickListener(new $$Lambda$OSteppers$XexZo2eSlDcJfGqQZfF2Xb1EWho(this));
        this.addContainerView.setOnClickListener(new $$Lambda$OSteppers$FEXxyf6GhKLyMIUXnSW6PuJorPU(this));
        this.decContainerView.setOnClickListener(new $$Lambda$OSteppers$FZLArISMxlA3RPflFS1f3RjaPCc(this));
        this.etCounter.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this), TextWatcher.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: registerEvent$lambda-1, reason: not valid java name */
    private static final void m1186registerEvent$lambda1(OSteppers r1, View r2) {
        o.e(r1, "this$0");
        int r3 = r1.mValue + r1.mStepValue;
        if (r3 >= r1.mMinValue) goto L5;
        return;
    L5:
        if (r3 > r1.mMaxValue) goto L10;
        r1.setMValue(r3);
        r1.etCounter.clearFocus();
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 3);
        return;
    }

    /* JADX INFO: renamed from: registerEvent$lambda-2, reason: not valid java name */
    private static final void m1187registerEvent$lambda2(OSteppers r1, View r2) {
        o.e(r1, "this$0");
        int r3 = r1.mValue - r1.mStepValue;
        if (r3 >= r1.mMinValue) goto L5;
        return;
    L5:
        if (r3 > r1.mMaxValue) goto L10;
        r1.setMValue(r3);
        r1.etCounter.clearFocus();
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 3);
        return;
    }

    /* JADX INFO: renamed from: registerEvent$lambda-3, reason: not valid java name */
    private static final void m1188registerEvent$lambda3(OSteppers r0, View r1) {
        o.e(r0, "this$0");
        b r2 = r0.onValueChangeListener;
        if (r2 == null) goto L7;
        r2.c();
        return;
    }

    /* JADX INFO: renamed from: registerEvent$lambda-4, reason: not valid java name */
    private static final void m1189registerEvent$lambda4(OSteppers r0, View r1) {
        o.e(r0, "this$0");
        b r2 = r0.onValueChangeListener;
        if (r2 == null) goto L7;
        r2.b();
        return;
    }

    private final void registerInputFilter() {
        this.etCounter.setFilters((InputFilter[]) ZeusTransformUtils.preCheckCast(new InputFilterMinMax[]{new InputFilterMinMax(this.mMinValue, this.mMaxValue, new $$Lambda$OSteppers$pY23Y3X_kqsSBSRhYCZO1AFAiM8(this))}, InputFilter[].class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: registerInputFilter$lambda-5, reason: not valid java name */
    private static final void m1190registerInputFilter$lambda5(OSteppers r1, int r2) {
        o.e(r1, "this$0");
        b r3 = r1.onValueChangeListener;
        if (r3 == null) goto L7;
        r3.a(r2);
        return;
    }

    private final void checkCounter() {
        OButton r0 = this.tvAdd;
        boolean r3 = true;
        if (getValue() >= this.mMaxValue) goto L5;
        boolean r1 = true;
    L6:
        r0.setEnabled(r1);
        OButton r2 = this.tvAdd;
        if (getValue() >= this.mMaxValue) goto L9;
        boolean r4 = true;
    L10:
        r2.setClickable(r4);
        OButton r5 = this.tvDec;
        if (getValue() <= this.mMinValue) goto L13;
        boolean r6 = true;
    L14:
        r5.setEnabled(r6);
        OButton r7 = this.tvDec;
        if (getValue() > this.mMinValue) goto L18;
        r3 = false;
    L18:
        r7.setClickable(r3);
        return;
    L13:
        r6 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public static /* synthetic */ void expandTouchHeight$default(OSteppers r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = g.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), 44);
    L5:
        r0.expandTouchHeight(r1);
    }

    public final void expandTouchHeight(int r7) {
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 32), r7, new View[]{(View) ZeusTransformUtils.preCheckCast(this.addContainerView, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(this.etCounter, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(this.decContainerView, View.class, "com.obric.aiagent.plugin")});
        k.a((View) ZeusTransformUtils.preCheckCast(this.tvAdd, View.class, "com.obric.aiagent.plugin"), r7);
        k.a((View) ZeusTransformUtils.preCheckCast(this.tvDec, View.class, "com.obric.aiagent.plugin"), r7);
    }

    public final int getValue() {
        return this.mValue;
    }

    public final void setValue(int r3) {
        if (r3 < this.mMinValue) goto L9;
        if (r3 > this.mMaxValue) goto L9;
        setMValue(r3);
        return;
    L9:
        throw new IllegalArgumentException(r3 + " is not in [" + this.mMinValue + ", " + this.mMaxValue + "].");
    }

    public final int getMinValue() {
        return this.mMinValue;
    }

    public final void setMinValue(int r2) {
        setMMinValue(r2);
        setMValue(Math.max(r2, this.mValue));
    }

    public final int getMaxValue() {
        return this.mMaxValue;
    }

    public final void setMaxValue(int r2) {
        setMMaxValue(r2);
        setMValue(Math.min(r2, this.mValue));
    }

    public final void setStepValue(int r2) {
        if (this.mStepValue <= 0) goto L7;
        setMStepValue(r2);
        return;
    L7:
        throw new IllegalArgumentException("step value should be a positive integer");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        super.clearFocus();
        this.etCounter.clearFocus();
    }

    private final void refreshCounter() {
        this.etCounter.setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(this.mValue), CharSequence.class, "com.obric.aiagent.plugin"), TextView.BufferType.EDITABLE);
        checkCounter();
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
