package com.google.android.material.slider;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.core.view.ViewCompat;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.internal.d;
import com.google.android.material.internal.l;
import com.google.android.material.internal.q;
import com.google.android.material.internal.r;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.m;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import com.google.android.material.tooltip.TooltipDrawable;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a<S>, T extends com.google.android.material.slider.b<S>> extends View {
    static final int DEF_STYLE_RES = 0;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION = "minSeparation(%s) must be greater or equal to 0";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE = "minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT = "minSeparation(%s) cannot be set as a dimension when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final int HALO_ALPHA = 63;
    private static final long LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final long LABEL_ANIMATION_EXIT_DURATION = 117;
    private static final String TAG = "BaseSlider";
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    static final int UNIT_PX = 0;
    static final int UNIT_VALUE = 1;
    private static final String WARNING_FLOATING_POINT_ERROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";
    private BaseSlider<S, L, T>.a accessibilityEventSender;
    private final b accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;
    private final Paint activeTicksPaint;
    private final Paint activeTrackPaint;
    private final List<L> changeListeners;
    private Drawable customThumbDrawable;
    private List<Drawable> customThumbDrawablesForValues;
    private final MaterialShapeDrawable defaultThumbDrawable;
    private int defaultThumbRadius;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private com.google.android.material.slider.c formatter;
    private ColorStateList haloColor;
    private final Paint haloPaint;
    private int haloRadius;
    private final Paint inactiveTicksPaint;
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;
    private final c labelMaker;
    private int labelPadding;
    private final List<TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;
    private int minTrackSidePadding;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;
    private boolean thumbIsPressed;
    private final Paint thumbPaint;
    private int thumbRadius;
    private ColorStateList tickColorActive;
    private ColorStateList tickColorInactive;
    private boolean tickVisible;
    private float[] ticksCoordinates;
    private float touchDownX;
    private final List<T> touchListeners;
    private float touchPosition;
    private ColorStateList trackColorActive;
    private ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackTop;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetHeight;

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = null;
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        /* synthetic */ SliderState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        SliderState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        private SliderState(Parcel r3) {
            super(r3);
            this.valueFrom = r3.readFloat();
            this.valueTo = r3.readFloat();
            ArrayList<Float> r0 = new ArrayList();
            this.values = r0;
            r3.readList(r0, Float.class.getClassLoader());
            this.stepSize = r3.readFloat();
            this.hasFocus = r3.createBooleanArray()[0];
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeFloat(this.valueFrom);
            r2.writeFloat(this.valueTo);
            r2.writeList(this.values);
            r2.writeFloat(this.stepSize);
            r2.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseSlider f13595b;

        private a(BaseSlider r1) {
            this.f13595b = r1;
            this.f13594a = -1;
        }

        /* synthetic */ a(BaseSlider r1, AnonymousClass1 r2) {
            this(r1);
        }

        void a(int r1) {
            this.f13594a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.access$300(this.f13595b).a(this.f13594a, 4);
        }
    }

    private static class b extends androidx.customview.widget.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Rect f13596c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final BaseSlider<?, ?, ?> f13597d;

        b(BaseSlider<?, ?, ?> r2) {
            super(r2);
            this.f13596c = new Rect();
            this.f13597d = r2;
        }

        @Override // androidx.customview.widget.a
        public int a(float r5, float r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.f13597d.getValues().size()) goto L9;
            this.f13597d.updateBoundsForVirturalViewId(r0, this.f13596c);
            if (this.f13596c.contains((int) r5, (int) r6) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }

        @Override // androidx.customview.widget.a
        public void a(List<Integer> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            int r0 = 0;
        L4:
            if (r0 >= this.f13597d.getValues().size()) goto L6;
            r4.add(Integer.valueOf(r0));
            r0 = r0 + 1;
            goto L4
        }

        @Override // androidx.customview.widget.a
        public void a(int r7, androidx.core.view.accessibility.b r8) {
            r8.a(androidx.core.view.accessibility.b.a.H);
            List<Float> r0 = this.f13597d.getValues();
            float r1 = ((Float) ZeusTransformUtils.preCheckCast(r0.get(r7), Float.class, "com.obric.aiagent.plugin")).floatValue();
            float r2 = this.f13597d.getValueFrom();
            float r3 = this.f13597d.getValueTo();
            if (this.f13597d.isEnabled() == true) goto L5;
        L10:
            r8.a(androidx.core.view.accessibility.b.h.a(1, r2, r3, r1));
            r8.b(SeekBar.class.getName());
            StringBuilder r4 = new StringBuilder();
            if (this.f13597d.getContentDescription() == null) goto L14;
            r4.append(this.f13597d.getContentDescription()).append(",");
        L14:
            if (r0.size() <= 1) goto L16;
            r4.append(e(r7));
            r4.append(BaseSlider.access$500(this.f13597d, r1));
        L16:
            r8.e(r4.toString());
            this.f13597d.updateBoundsForVirturalViewId(r7, this.f13596c);
            r8.b(this.f13596c);
            return;
        L5:
            if (r1 <= r2) goto L8;
            r8.a(8192);
        L8:
            if (r1 >= r3) goto L10;
            r8.a(4096);
            goto L10
        }

        private String e(int r4) {
            if (r4 == (this.f13597d.getValues().size() - 1)) goto L5;
            if (r4 == 0) goto L8;
            return "";
        L8:
            return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13597d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.material_slider_range_start, WsChannelMultiProcessSharedProvider.STRING_TYPE, "material_slider_range_start"));
        L5:
            return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13597d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.material_slider_range_end, WsChannelMultiProcessSharedProvider.STRING_TYPE, "material_slider_range_end"));
        }

        @Override // androidx.customview.widget.a
        public boolean b(int r5, int r6, Bundle r7) {
            if (this.f13597d.isEnabled() == true) goto L6;
            return false;
        L6:
            if (r6 == 4096) goto L20;
            if (r6 == 8192) goto L20;
            if (r6 == 16908349) goto L11;
            return false;
        L11:
            if (r7 != null) goto L13;
        L19:
            return false;
        L13:
            if (r7.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE") == false) goto L19;
            float r8 = r7.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
            if (BaseSlider.access$600(this.f13597d, r5, r8) == false) goto L19;
            BaseSlider.access$700(this.f13597d);
            this.f13597d.postInvalidate();
            a(r5);
            return true;
        L20:
            float r9 = BaseSlider.access$800(this.f13597d, 20);
            if (r6 != 8192) goto L24;
            r9 = -r9;
        L24:
            if (this.f13597d.isRtl() == false) goto L26;
            r9 = -r9;
        L26:
            float r10 = androidx.core.a.a.a(((Float) ZeusTransformUtils.preCheckCast(this.f13597d.getValues().get(r5), Float.class, "com.obric.aiagent.plugin")).floatValue() + r9, this.f13597d.getValueFrom(), this.f13597d.getValueTo());
            if (BaseSlider.access$600(this.f13597d, r5, r10) == false) goto L30;
            BaseSlider.access$700(this.f13597d);
            this.f13597d.postInvalidate();
            a(r5);
            return true;
        L30:
            return false;
        }
    }

    private interface c {
        TooltipDrawable a();
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    static /* synthetic */ TooltipDrawable access$000(Context r2, TypedArray r3) {
        return parseLabelDrawable((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    static /* synthetic */ List access$100(BaseSlider r0) {
        return r0.labels;
    }

    static /* synthetic */ b access$300(BaseSlider r0) {
        return r0.accessibilityHelper;
    }

    static /* synthetic */ String access$500(BaseSlider r0, float r1) {
        return r0.formatValue(r1);
    }

    static /* synthetic */ boolean access$600(BaseSlider r0, int r1, float r2) {
        return r0.snapThumbToValue(r1, r2);
    }

    static /* synthetic */ void access$700(BaseSlider r0) {
        r0.updateHaloHotspot();
    }

    static /* synthetic */ float access$800(BaseSlider r0, int r1) {
        return r0.calculateStepIncrement(r1);
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_Slider, "style", "Widget_MaterialComponents_Slider");
    }

    public BaseSlider(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public BaseSlider(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.sliderStyle, "attr", "sliderStyle"));
    }

    public BaseSlider(Context r7, AttributeSet r8, final int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        final AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r10, r11, r9, DEF_STYLE_RES), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r11, r9);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.thumbIsPressed = false;
        this.values = new ArrayList();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.tickVisible = true;
        this.isLongPress = false;
        MaterialShapeDrawable r2 = new MaterialShapeDrawable();
        this.defaultThumbDrawable = r2;
        this.customThumbDrawablesForValues = Collections.emptyList();
        this.separationUnit = 0;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Paint r3 = new Paint();
        this.inactiveTrackPaint = r3;
        r3.setStyle(Paint.Style.STROKE);
        r3.setStrokeCap(Paint.Cap.ROUND);
        Paint r4 = new Paint();
        this.activeTrackPaint = r4;
        r4.setStyle(Paint.Style.STROKE);
        r4.setStrokeCap(Paint.Cap.ROUND);
        Paint r5 = new Paint(1);
        this.thumbPaint = r5;
        r5.setStyle(Paint.Style.FILL);
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint r6 = new Paint(1);
        this.haloPaint = r6;
        r6.setStyle(Paint.Style.FILL);
        Paint r13 = new Paint();
        this.inactiveTicksPaint = r13;
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeCap(Paint.Cap.ROUND);
        Paint r14 = new Paint();
        this.activeTicksPaint = r14;
        r14.setStyle(Paint.Style.STROKE);
        r14.setStrokeCap(Paint.Cap.ROUND);
        loadResources(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin"));
        this.labelMaker = new AnonymousClass1(this, r11, r9);
        processAttributes(r12, r11, r9);
        setFocusable(true);
        setClickable(true);
        r2.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(r12).getScaledTouchSlop();
        b r15 = new b(this);
        this.accessibilityHelper = r15;
        ViewCompat.a(this, r15);
        this.accessibilityManager = (AccessibilityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("accessibility"), AccessibilityManager.class, "com.obric.aiagent.plugin");
    }

    private void loadResources(Resources r4) {
        this.widgetHeight = r4.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_slider_widget_height, "dimen", "mtrl_slider_widget_height"));
        int r0 = r4.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_slider_track_side_padding, "dimen", "mtrl_slider_track_side_padding"));
        this.minTrackSidePadding = r0;
        this.trackSidePadding = r0;
        this.defaultThumbRadius = r4.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_slider_thumb_radius, "dimen", "mtrl_slider_thumb_radius"));
        this.trackTop = r4.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_slider_track_top, "dimen", "mtrl_slider_track_top"));
        this.labelPadding = r4.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_slider_label_padding, "dimen", "mtrl_slider_label_padding"));
    }

    private void processAttributes(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        TypedArray r13 = l.a(r12, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.Slider, r11, DEF_STYLE_RES, new int[0]);
        this.valueFrom = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.Slider_android_valueFrom, "styleable", "Slider_android_valueFrom"), 0.0f);
        this.valueTo = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.Slider_android_valueTo, "styleable", "Slider_android_valueTo"), 1.0f);
        setValues(new Float[]{Float.valueOf(this.valueFrom)});
        this.stepSize = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.Slider_android_stepSize, "styleable", "Slider_android_stepSize"), 0.0f);
        String r4 = "Slider_trackColor";
        boolean r3 = r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.Slider_trackColor, "styleable", "Slider_trackColor"));
        if (r3 == false) goto L5;
        int r5 = ZeusTransformUtils.mapRes(R.styleable.Slider_trackColor, "styleable", "Slider_trackColor");
    L6:
        if (r3 == false) goto L8;
        int r6 = R.styleable.Slider_trackColor;
    L9:
        int r7 = ZeusTransformUtils.mapRes(r6, "styleable", r4);
        ColorStateList r8 = com.google.android.material.g.c.a(r12, r13, r5);
        if (r8 != null) goto L13;
        r8 = androidx.appcompat.a.a.a.a(r12, ZeusTransformUtils.mapRes(R.color.material_slider_inactive_track_color, "color", "material_slider_inactive_track_color"));
    L13:
        setTrackInactiveTintList(r8);
        ColorStateList r14 = com.google.android.material.g.c.a(r12, r13, r7);
        if (r14 != null) goto L17;
        r14 = androidx.appcompat.a.a.a.a(r12, ZeusTransformUtils.mapRes(R.color.material_slider_active_track_color, "color", "material_slider_active_track_color"));
    L17:
        setTrackActiveTintList(r14);
        this.defaultThumbDrawable.setFillColor(com.google.android.material.g.c.a(r12, r13, ZeusTransformUtils.mapRes(R.styleable.Slider_thumbColor, "styleable", "Slider_thumbColor")));
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.Slider_thumbStrokeColor, "styleable", "Slider_thumbStrokeColor")) == false) goto L20;
        setThumbStrokeColor(com.google.android.material.g.c.a(r12, r13, ZeusTransformUtils.mapRes(R.styleable.Slider_thumbStrokeColor, "styleable", "Slider_thumbStrokeColor")));
    L20:
        setThumbStrokeWidth(r13.getDimension(ZeusTransformUtils.mapRes(R.styleable.Slider_thumbStrokeWidth, "styleable", "Slider_thumbStrokeWidth"), 0.0f));
        ColorStateList r15 = com.google.android.material.g.c.a(r12, r13, ZeusTransformUtils.mapRes(R.styleable.Slider_haloColor, "styleable", "Slider_haloColor"));
        if (r15 != null) goto L24;
        r15 = androidx.appcompat.a.a.a.a(r12, ZeusTransformUtils.mapRes(R.color.material_slider_halo_color, "color", "material_slider_halo_color"));
    L24:
        setHaloTintList(r15);
        this.tickVisible = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.Slider_tickVisible, "styleable", "Slider_tickVisible"), true);
        String r16 = "Slider_tickColor";
        boolean r17 = r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.Slider_tickColor, "styleable", "Slider_tickColor"));
        if (r17 == false) goto L27;
        int r18 = ZeusTransformUtils.mapRes(R.styleable.Slider_tickColor, "styleable", "Slider_tickColor");
    L28:
        if (r17 == false) goto L30;
        int r19 = R.styleable.Slider_tickColor;
    L31:
        int r20 = ZeusTransformUtils.mapRes(r19, "styleable", r16);
        ColorStateList r21 = com.google.android.material.g.c.a(r12, r13, r18);
        if (r21 != null) goto L35;
        r21 = androidx.appcompat.a.a.a.a(r12, ZeusTransformUtils.mapRes(R.color.material_slider_inactive_tick_marks_color, "color", "material_slider_inactive_tick_marks_color"));
    L35:
        setTickInactiveTintList(r21);
        ColorStateList r22 = com.google.android.material.g.c.a(r12, r13, r20);
        if (r22 != null) goto L39;
        r22 = androidx.appcompat.a.a.a.a(r12, ZeusTransformUtils.mapRes(R.color.material_slider_active_tick_marks_color, "color", "material_slider_active_tick_marks_color"));
    L39:
        setTickActiveTintList(r22);
        setThumbRadius(r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Slider_thumbRadius, "styleable", "Slider_thumbRadius"), 0));
        setHaloRadius(r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Slider_haloRadius, "styleable", "Slider_haloRadius"), 0));
        setThumbElevation(r13.getDimension(ZeusTransformUtils.mapRes(R.styleable.Slider_thumbElevation, "styleable", "Slider_thumbElevation"), 0.0f));
        setTrackHeight(r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.Slider_trackHeight, "styleable", "Slider_trackHeight"), 0));
        setLabelBehavior(r13.getInt(ZeusTransformUtils.mapRes(R.styleable.Slider_labelBehavior, "styleable", "Slider_labelBehavior"), 0));
        if (r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.Slider_android_enabled, "styleable", "Slider_android_enabled"), true) == true) goto L42;
        setEnabled(false);
    L42:
        r13.recycle();
        return;
    L30:
        r19 = R.styleable.Slider_tickColorActive;
        r16 = "Slider_tickColorActive";
        goto L31
    L27:
        r18 = ZeusTransformUtils.mapRes(R.styleable.Slider_tickColorInactive, "styleable", "Slider_tickColorInactive");
        goto L28
    L8:
        r6 = R.styleable.Slider_trackColorActive;
        r4 = "Slider_trackColorActive";
        goto L9
    L5:
        r5 = ZeusTransformUtils.mapRes(R.styleable.Slider_trackColorInactive, "styleable", "Slider_trackColorInactive");
        goto L6
    }

    private static TooltipDrawable parseLabelDrawable(Context r4, TypedArray r5) {
        return TooltipDrawable.createFromAttributes((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), null, 0, r5.getResourceId(ZeusTransformUtils.mapRes(R.styleable.Slider_labelStyle, "styleable", "Slider_labelStyle"), ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_Tooltip, "style", "Widget_MaterialComponents_Tooltip")));
    }

    private void maybeIncreaseTrackSidePadding() {
        int r0 = Math.max(this.thumbRadius - this.defaultThumbRadius, 0);
        this.trackSidePadding = this.minTrackSidePadding + r0;
        if (ViewCompat.F(this) == false) goto L6;
        updateTrackWidth(getWidth());
        return;
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, new Object[]{Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_TO, new Object[]{Float.valueOf(this.valueTo), Float.valueOf(this.valueFrom)}));
    }

    private boolean valueLandsOnTick(float r2) {
        return isMultipleOfStepSize(r2 - this.valueFrom);
    }

    private boolean isMultipleOfStepSize(float r3) {
        double r2 = new BigDecimal(Float.toString(r3)).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        if (Math.abs(Math.round(r2) - r2) >= THRESHOLD) goto L5;
        return true;
    L5:
        return false;
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f) goto L5;
        return;
    L5:
        if (valueLandsOnTick(this.valueTo) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.valueOf(this.stepSize), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
    }

    private void validateValues() {
        Iterator<Float> r0 = this.values.iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        Float r1 = (Float) ZeusTransformUtils.preCheckCast(r0.next(), Float.class, "com.obric.aiagent.plugin");
        if (r1.floatValue() < this.valueFrom) goto L17;
        if (r1.floatValue() > this.valueTo) goto L17;
        if (this.stepSize <= 0.0f) goto L4;
        if (valueLandsOnTick(r1.floatValue()) == true) goto L4;
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, new Object[]{r1, Float.valueOf(this.valueFrom), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)}));
    L17:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE, new Object[]{r1, Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
    }

    private void validateMinSeparation() {
        float r0 = getMinSeparation();
        if (r0 < 0.0f) goto L21;
        float r2 = this.stepSize;
        if (r2 > 0.0f) goto L7;
        return;
    L7:
        if (r0 > 0.0f) goto L9;
        return;
    L9:
        if (this.separationUnit != 1) goto L18;
        if (r0 < r2) goto L16;
        if (isMultipleOfStepSize(r0) == false) goto L16;
        return;
    L16:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE, new Object[]{Float.valueOf(r0), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)}));
    L18:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT, new Object[]{Float.valueOf(r0), Float.valueOf(this.stepSize)}));
    L21:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION, new Object[]{Float.valueOf(r0)}));
    }

    private void warnAboutFloatingPointError() {
        float r0 = this.stepSize;
        if (r0 != 0.0f) goto L6;
        return;
    L6:
        if (((int) r0) == r0) goto L8;
        INVOKESTATIC_com_google_android_material_slider_BaseSlider_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"stepSize", Float.valueOf(r0)}));
    L8:
        float r1 = this.valueFrom;
        if (((int) r1) == r1) goto L11;
        INVOKESTATIC_com_google_android_material_slider_BaseSlider_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"valueFrom", Float.valueOf(r1)}));
    L11:
        float r8 = this.valueTo;
        if (((int) r8) == r8) goto L15;
        INVOKESTATIC_com_google_android_material_slider_BaseSlider_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, new Object[]{"valueTo", Float.valueOf(r8)}));
        return;
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig == false) goto L6;
        validateValueFrom();
        validateValueTo();
        validateStepSize();
        validateValues();
        validateMinSeparation();
        warnAboutFloatingPointError();
        this.dirtyConfig = false;
        return;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public void setValueFrom(float r1) {
        this.valueFrom = r1;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public float getValueTo() {
        return this.valueTo;
    }

    public void setValueTo(float r1) {
        this.valueTo = r1;
        this.dirtyConfig = true;
        postInvalidate();
    }

    List<Float> getValues() {
        return new ArrayList(this.values);
    }

    void setValues(Float... r2) {
        ArrayList<Float> r0 = new ArrayList();
        Collections.addAll(r0, r2);
        setValuesInternal(r0);
    }

    void setValues(List<Float> r3) {
        setValuesInternal(new ArrayList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")));
    }

    private void setValuesInternal(ArrayList<Float> r3) {
        if (r3.isEmpty() == true) goto L12;
        Collections.sort(r3);
        if (this.values.size() == r3.size()) goto L7;
    L9:
        this.values = r3;
        this.dirtyConfig = true;
        this.focusedThumbIdx = 0;
        updateHaloHotspot();
        createLabelPool();
        dispatchOnChangedProgrammatically();
        postInvalidate();
        return;
    L7:
        if (this.values.equals(r3) == false) goto L9;
        return;
    L12:
        throw new IllegalArgumentException("At least one value must be set");
    }

    private void createLabelPool() {
        if (this.labels.size() <= this.values.size()) goto L12;
        List<TooltipDrawable> r0 = this.labels.subList(this.values.size(), this.labels.size());
        Iterator<TooltipDrawable> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        TooltipDrawable r3 = (TooltipDrawable) ZeusTransformUtils.preCheckCast(r1.next(), TooltipDrawable.class, "com.obric.aiagent.plugin");
        if (ViewCompat.I(this) == false) goto L6;
        detachLabelFromContentView(r3);
        goto L6
    L10:
        r0.clear();
    L12:
        if (this.labels.size() >= this.values.size()) goto L16;
        TooltipDrawable r2 = this.labelMaker.a();
        this.labels.add(r2);
        if (ViewCompat.I(this) == false) goto L12;
        attachLabelToContentView(r2);
        goto L12
    L16:
        int r4 = 1;
        if (this.labels.size() != 1) goto L19;
        r4 = 0;
    L19:
        Iterator<TooltipDrawable> r5 = this.labels.iterator();
    L21:
        if (r5.hasNext() == false) goto L23;
        ((TooltipDrawable) ZeusTransformUtils.preCheckCast(r5.next(), TooltipDrawable.class, "com.obric.aiagent.plugin")).setStrokeWidth(r4);
        goto L21
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public void setStepSize(float r5) {
        if (r5 < 0.0f) goto L9;
        if (this.stepSize == r5) goto L10;
        this.stepSize = r5;
        this.dirtyConfig = true;
        postInvalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.valueOf(r5), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)}));
    }

    void setCustomThumbDrawable(int r2) {
        setCustomThumbDrawable(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(r2));
    }

    void setCustomThumbDrawable(Drawable r1) {
        this.customThumbDrawable = initializeCustomThumbDrawable(r1);
        this.customThumbDrawablesForValues.clear();
        postInvalidate();
    }

    void setCustomThumbDrawablesForValues(int... r5) {
        Drawable[] r0 = new Drawable[r5.length];
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L6;
        r0[r1] = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(r5[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        setCustomThumbDrawablesForValues(r0);
    }

    void setCustomThumbDrawablesForValues(Drawable... r5) {
        this.customThumbDrawable = null;
        this.customThumbDrawablesForValues = new ArrayList();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Drawable r2 = r5[r1];
        this.customThumbDrawablesForValues.add(initializeCustomThumbDrawable(r2));
        r1 = r1 + 1;
        goto L3
    L5:
        postInvalidate();
    }

    private Drawable initializeCustomThumbDrawable(Drawable r1) {
        Drawable r2 = r1.mutate().getConstantState().newDrawable();
        adjustCustomThumbDrawableBounds(r2);
        return r2;
    }

    private void adjustCustomThumbDrawableBounds(Drawable r5) {
        int r4 = this.thumbRadius * 2;
        int r0 = r5.getIntrinsicWidth();
        int r1 = r5.getIntrinsicHeight();
        if (r0 != (-1)) goto L6;
        if (r1 != (-1)) goto L6;
        r5.setBounds(0, 0, r4, r4);
        return;
    L6:
        float r6 = r4 / Math.max(r0, r1);
        r5.setBounds(0, 0, (int) (r0 * r6), (int) (r1 * r6));
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    public void setFocusedThumbIndex(int r2) {
        if (r2 < 0) goto L8;
        if (r2 >= this.values.size()) goto L8;
        this.focusedThumbIdx = r2;
        this.accessibilityHelper.c(r2);
        postInvalidate();
        return;
    L8:
        throw new IllegalArgumentException("index out of range");
    }

    public void setActiveThumbIndex(int r1) {
        this.activeThumbIdx = r1;
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public void addOnChangeListener(L r3) {
        com.google.android.material.slider.a r4 = (com.google.android.material.slider.a) ZeusTransformUtils.wrapperContextForParams(r3, com.google.android.material.slider.a.class, "com.obric.aiagent.plugin");
        this.changeListeners.add((L) r4);
    }

    public void removeOnChangeListener(L r3) {
        com.google.android.material.slider.a r4 = (com.google.android.material.slider.a) ZeusTransformUtils.wrapperContextForParams(r3, com.google.android.material.slider.a.class, "com.obric.aiagent.plugin");
        this.changeListeners.remove(r4);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void addOnSliderTouchListener(T r3) {
        com.google.android.material.slider.b r4 = (com.google.android.material.slider.b) ZeusTransformUtils.wrapperContextForParams(r3, com.google.android.material.slider.b.class, "com.obric.aiagent.plugin");
        this.touchListeners.add((T) r4);
    }

    public void removeOnSliderTouchListener(T r3) {
        com.google.android.material.slider.b r4 = (com.google.android.material.slider.b) ZeusTransformUtils.wrapperContextForParams(r3, com.google.android.material.slider.b.class, "com.obric.aiagent.plugin");
        this.touchListeners.remove(r4);
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    public boolean hasLabelFormatter() {
        if (this.formatter == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void setLabelFormatter(com.google.android.material.slider.c r3) {
        this.formatter = (com.google.android.material.slider.c) ZeusTransformUtils.wrapperContextForParams(r3, com.google.android.material.slider.c.class, "com.obric.aiagent.plugin");
    }

    public float getThumbElevation() {
        return this.defaultThumbDrawable.getElevation();
    }

    public void setThumbElevation(float r1) {
        this.defaultThumbDrawable.setElevation(r1);
    }

    public void setThumbElevationResource(int r2) {
        setThumbElevation(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(r2));
    }

    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public void setThumbRadius(int r4) {
        if (r4 != this.thumbRadius) goto L5;
        return;
    L5:
        this.thumbRadius = r4;
        maybeIncreaseTrackSidePadding();
        this.defaultThumbDrawable.setShapeAppearanceModel(m.a().a(0, this.thumbRadius).a());
        MaterialShapeDrawable r5 = this.defaultThumbDrawable;
        int r0 = this.thumbRadius;
        r5.setBounds(0, 0, r0 * 2, r0 * 2);
        Drawable r6 = this.customThumbDrawable;
        if (r6 == null) goto L8;
        adjustCustomThumbDrawableBounds(r6);
    L8:
        Iterator<Drawable> r7 = this.customThumbDrawablesForValues.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        adjustCustomThumbDrawableBounds((Drawable) ZeusTransformUtils.preCheckCast(r7.next(), Drawable.class, "com.obric.aiagent.plugin"));
        goto L10
    L12:
        postInvalidate();
    }

    public void setThumbRadiusResource(int r2) {
        setThumbRadius(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(r2));
    }

    public void setThumbStrokeColor(ColorStateList r2) {
        this.defaultThumbDrawable.setStrokeColor(r2);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int r4) {
        if (r4 == 0) goto L5;
        setThumbStrokeColor(androidx.appcompat.a.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
        return;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.defaultThumbDrawable.getStrokeColor();
    }

    public void setThumbStrokeWidth(float r2) {
        this.defaultThumbDrawable.setStrokeWidth(r2);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int r2) {
        if (r2 == 0) goto L5;
        setThumbStrokeWidth(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(r2));
        return;
    }

    public float getThumbStrokeWidth() {
        return this.defaultThumbDrawable.getStrokeWidth();
    }

    public int getHaloRadius() {
        return this.haloRadius;
    }

    public void setHaloRadius(int r3) {
        if (r3 != this.haloRadius) goto L5;
        return;
    L5:
        this.haloRadius = r3;
        Drawable r4 = getBackground();
        if (shouldDrawCompatHalo() == false) goto L8;
    L11:
        postInvalidate();
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, RippleDrawable.class) == false) goto L11;
        com.google.android.material.b.a.a((RippleDrawable) ZeusTransformUtils.preCheckCast(r4, RippleDrawable.class, "com.obric.aiagent.plugin"), this.haloRadius);
    }

    public void setHaloRadiusResource(int r2) {
        setHaloRadius(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(r2));
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public void setLabelBehavior(int r2) {
        if (this.labelBehavior == r2) goto L6;
        this.labelBehavior = r2;
        requestLayout();
        return;
    }

    private boolean shouldAlwaysShowLabel() {
        if (this.labelBehavior != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public int getTrackWidth() {
        return this.trackWidth;
    }

    public int getTrackHeight() {
        return this.trackHeight;
    }

    public void setTrackHeight(int r2) {
        if (this.trackHeight == r2) goto L6;
        this.trackHeight = r2;
        invalidateTrack();
        postInvalidate();
        return;
    }

    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public void setHaloTintList(ColorStateList r3) {
        if (r3.equals(this.haloColor) == false) goto L5;
        return;
    L5:
        this.haloColor = r3;
        Drawable r0 = getBackground();
        if (shouldDrawCompatHalo() == false) goto L8;
    L11:
        this.haloPaint.setColor(getColorForState(r3));
        this.haloPaint.setAlpha(63);
        invalidate();
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, RippleDrawable.class) == false) goto L11;
        ((RippleDrawable) ZeusTransformUtils.preCheckCast(r0, RippleDrawable.class, "com.obric.aiagent.plugin")).setColor(r3);
    }

    public ColorStateList getThumbTintList() {
        return this.defaultThumbDrawable.getFillColor();
    }

    public void setThumbTintList(ColorStateList r2) {
        if (r2.equals(this.defaultThumbDrawable.getFillColor()) == false) goto L5;
        return;
    L5:
        this.defaultThumbDrawable.setFillColor(r2);
        invalidate();
    }

    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive) == false) goto L7;
        return this.tickColorActive;
    L7:
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public void setTickTintList(ColorStateList r1) {
        setTickInactiveTintList(r1);
        setTickActiveTintList(r1);
    }

    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    public void setTickActiveTintList(ColorStateList r2) {
        if (r2.equals(this.tickColorActive) == false) goto L5;
        return;
    L5:
        this.tickColorActive = r2;
        this.activeTicksPaint.setColor(getColorForState(r2));
        invalidate();
    }

    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    public void setTickInactiveTintList(ColorStateList r2) {
        if (r2.equals(this.tickColorInactive) == false) goto L5;
        return;
    L5:
        this.tickColorInactive = r2;
        this.inactiveTicksPaint.setColor(getColorForState(r2));
        invalidate();
    }

    public boolean isTickVisible() {
        return this.tickVisible;
    }

    public void setTickVisible(boolean r2) {
        if (this.tickVisible == r2) goto L6;
        this.tickVisible = r2;
        postInvalidate();
        return;
    }

    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive) == false) goto L7;
        return this.trackColorActive;
    L7:
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public void setTrackTintList(ColorStateList r1) {
        setTrackInactiveTintList(r1);
        setTrackActiveTintList(r1);
    }

    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    public void setTrackActiveTintList(ColorStateList r2) {
        if (r2.equals(this.trackColorActive) == false) goto L5;
        return;
    L5:
        this.trackColorActive = r2;
        this.activeTrackPaint.setColor(getColorForState(r2));
        invalidate();
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    public void setTrackInactiveTintList(ColorStateList r2) {
        if (r2.equals(this.trackColorInactive) == false) goto L5;
        return;
    L5:
        this.trackColorInactive = r2;
        this.inactiveTrackPaint.setColor(getColorForState(r2));
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        setLayerType(r3, null);
        return;
    L5:
        r3 = 2;
        goto L6
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<TooltipDrawable> r0 = this.labels.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        attachLabelToContentView((TooltipDrawable) ZeusTransformUtils.preCheckCast(r0.next(), TooltipDrawable.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    private void attachLabelToContentView(TooltipDrawable r1) {
        r1.setRelativeToView(r.f(this));
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.a r0 = this.accessibilityEventSender;
        if (r0 == null) goto L5;
        removeCallbacks(r0);
    L5:
        this.labelsAreAnimatedIn = false;
        Iterator<TooltipDrawable> r1 = this.labels.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        detachLabelFromContentView((TooltipDrawable) ZeusTransformUtils.preCheckCast(r1.next(), TooltipDrawable.class, "com.obric.aiagent.plugin"));
        goto L7
    L9:
        super.onDetachedFromWindow();
    }

    private void detachLabelFromContentView(TooltipDrawable r2) {
        q r0 = r.g(this);
        if (r0 == null) goto L6;
        r0.b(r2);
        r2.detachView(r.f(this));
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r4, int r5) {
        int r6 = this.widgetHeight;
        int r1 = 0;
        if (this.labelBehavior != 1) goto L5;
    L6:
        r1 = ((TooltipDrawable) ZeusTransformUtils.preCheckCast(this.labels.get(0), TooltipDrawable.class, "com.obric.aiagent.plugin")).getIntrinsicHeight();
    L7:
        super.onMeasure(r4, View.MeasureSpec.makeMeasureSpec(r6 + r1, 1073741824));
        return;
    L5:
        if (shouldAlwaysShowLabel() == false) goto L7;
        goto L6
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        updateTrackWidth(r1);
        updateHaloHotspot();
    }

    private void maybeCalculateTicksCoordinates() {
        if (this.stepSize > 0.0f) goto L5;
        return;
    L5:
        validateConfigurationIfDirty();
        int r0 = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] r1 = this.ticksCoordinates;
        if (r1 != null) goto L8;
    L9:
        this.ticksCoordinates = new float[r0 * 2];
    L10:
        float r2 = this.trackWidth / (r0 - 1);
        int r3 = 0;
    L12:
        if (r3 >= (r0 * 2)) goto L14;
        float[] r4 = this.ticksCoordinates;
        r4[r3] = this.trackSidePadding + ((r3 / 2) * r2);
        r4[r3 + 1] = calculateTop();
        r3 = r3 + 2;
        goto L12
    L14:
        return;
    L8:
        if (r1.length == (r0 * 2)) goto L10;
        goto L9
    }

    private void updateTrackWidth(int r2) {
        this.trackWidth = Math.max(r2 - (this.trackSidePadding * 2), 0);
        maybeCalculateTicksCoordinates();
    }

    private void updateHaloHotspot() {
        if (shouldDrawCompatHalo() == false) goto L5;
        return;
    L5:
        if (getMeasuredWidth() <= 0) goto L11;
        Drawable r0 = getBackground();
        if (ZeusTransformUtils.instanceOf(r0, RippleDrawable.class) == false) goto L12;
        int r1 = (int) ((normalizeValue(((Float) ZeusTransformUtils.preCheckCast(this.values.get(this.focusedThumbIdx), Float.class, "com.obric.aiagent.plugin")).floatValue()) * this.trackWidth) + this.trackSidePadding);
        int r2 = calculateTop();
        int r5 = this.haloRadius;
        androidx.core.graphics.drawable.a.a(r0, r1 - r5, r2 - r5, r1 + r5, r2 + r5);
        return;
    L12:
        return;
    }

    private int calculateTop() {
        int r0 = this.trackTop;
        int r2 = 0;
        if (this.labelBehavior != 1) goto L5;
    L6:
        r2 = ((TooltipDrawable) ZeusTransformUtils.preCheckCast(this.labels.get(0), TooltipDrawable.class, "com.obric.aiagent.plugin")).getIntrinsicHeight();
    L8:
        return r0 + r2;
    L5:
        if (shouldAlwaysShowLabel() == false) goto L8;
        goto L6
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        if (this.dirtyConfig == false) goto L5;
        validateConfigurationIfDirty();
        maybeCalculateTicksCoordinates();
    L5:
        super.onDraw(r5);
        int r0 = calculateTop();
        drawInactiveTrack(r5, this.trackWidth, r0);
        if (((Float) ZeusTransformUtils.preCheckCast(Collections.max(getValues()), Float.class, "com.obric.aiagent.plugin")).floatValue() <= this.valueFrom) goto L8;
        drawActiveTrack(r5, this.trackWidth, r0);
    L8:
        maybeDrawTicks(r5);
        if (this.thumbIsPressed == true) goto L15;
        if (isFocused() == true) goto L15;
        if (shouldAlwaysShowLabel() == true) goto L15;
    L23:
        ensureLabelsRemoved();
    L24:
        drawThumbs(r5, this.trackWidth, r0);
        return;
    L15:
        if (isEnabled() == false) goto L23;
        maybeDrawHalo(r5, this.trackWidth, r0);
        if (this.activeThumbIdx == (-1)) goto L19;
    L22:
        ensureLabelsAdded();
        goto L24
    L19:
        if (shouldAlwaysShowLabel() == true) goto L22;
        ensureLabelsRemoved();
        goto L24
    }

    private float[] getActiveRange() {
        float r0 = ((Float) ZeusTransformUtils.preCheckCast(Collections.max(getValues()), Float.class, "com.obric.aiagent.plugin")).floatValue();
        float r1 = ((Float) ZeusTransformUtils.preCheckCast(Collections.min(getValues()), Float.class, "com.obric.aiagent.plugin")).floatValue();
        if (this.values.size() != 1) goto L5;
        r1 = this.valueFrom;
    L5:
        float r2 = normalizeValue(r1);
        float r3 = normalizeValue(r0);
        if (isRtl() == false) goto L9;
        return new float[]{r3, r2};
    L9:
        return new float[]{r2, r3};
    }

    private void drawInactiveTrack(Canvas r12, int r13, int r14) {
        float[] r0 = getActiveRange();
        int r1 = this.trackSidePadding;
        float r4 = r13;
        float r6 = r1 + (r0[1] * r4);
        if (r6 >= (r1 + r13)) goto L5;
        float r9 = r14;
        r12.drawLine(r6, r9, r1 + r13, r9, this.inactiveTrackPaint);
    L5:
        int r15 = this.trackSidePadding;
        float r5 = r15 + (r0[0] * r4);
        if (r5 <= r15) goto L9;
        float r7 = r14;
        r12.drawLine(r15, r7, r5, r7, this.inactiveTrackPaint);
        return;
    }

    private float normalizeValue(float r3) {
        float r0 = this.valueFrom;
        float r4 = (r3 - r0) / (this.valueTo - r0);
        if (isRtl() == true) goto L5;
        return r4;
    L5:
        return 1.0f - r4;
    }

    private void drawActiveTrack(Canvas r11, int r12, int r13) {
        float[] r0 = getActiveRange();
        int r1 = this.trackSidePadding;
        float r14 = r12;
        float r8 = r13;
        r11.drawLine(r1 + (r0[0] * r14), r8, r1 + (r0[1] * r14), r8, this.activeTrackPaint);
    }

    private void maybeDrawTicks(Canvas r6) {
        if (this.tickVisible == true) goto L5;
        return;
    L5:
        if (this.stepSize <= 0.0f) goto L10;
        float[] r0 = getActiveRange();
        int r1 = pivotIndex(this.ticksCoordinates, r0[0]);
        int r2 = pivotIndex(this.ticksCoordinates, r0[1]);
        int r3 = r1 * 2;
        r6.drawPoints(this.ticksCoordinates, 0, r3, this.inactiveTicksPaint);
        int r4 = r2 * 2;
        r6.drawPoints(this.ticksCoordinates, r3, r4 - r3, this.activeTicksPaint);
        float[] r5 = this.ticksCoordinates;
        r6.drawPoints(r5, r4, r5.length - r4, this.inactiveTicksPaint);
        return;
    }

    private void drawThumbs(Canvas r11, int r12, int r13) {
        int r0 = 0;
    L4:
        if (r0 >= this.values.size()) goto L16;
        float r8 = ((Float) ZeusTransformUtils.preCheckCast(this.values.get(r0), Float.class, "com.obric.aiagent.plugin")).floatValue();
        Drawable r9 = this.customThumbDrawable;
        if (r9 == null) goto L9;
        drawThumbDrawable(r11, r12, r13, r8, r9);
    L15:
        r0 = r0 + 1;
        goto L4
    L9:
        if (r0 >= this.customThumbDrawablesForValues.size()) goto L12;
        drawThumbDrawable(r11, r12, r13, r8, (Drawable) ZeusTransformUtils.preCheckCast(this.customThumbDrawablesForValues.get(r0), Drawable.class, "com.obric.aiagent.plugin"));
        goto L15
    L12:
        if (isEnabled() == true) goto L14;
        r11.drawCircle(this.trackSidePadding + (normalizeValue(r8) * r12), r13, this.thumbRadius, this.thumbPaint);
    L14:
        drawThumbDrawable(r11, r12, r13, r8, this.defaultThumbDrawable);
        goto L15
    }

    private void drawThumbDrawable(Canvas r2, int r3, int r4, float r5, Drawable r6) {
        r2.save();
        r2.translate((this.trackSidePadding + ((int) (normalizeValue(r5) * r3))) - (r6.getBounds().width() / 2.0f), r4 - (r6.getBounds().height() / 2.0f));
        r6.draw(r2);
        r2.restore();
    }

    private void maybeDrawHalo(Canvas r9, int r10, int r11) {
        if (shouldDrawCompatHalo() == false) goto L9;
        int r12 = (int) (this.trackSidePadding + (normalizeValue(((Float) ZeusTransformUtils.preCheckCast(this.values.get(this.focusedThumbIdx), Float.class, "com.obric.aiagent.plugin")).floatValue()) * r10));
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        int r0 = this.haloRadius;
        r9.clipRect(r12 - r0, r11 - r0, r12 + r0, r0 + r11, Region.Op.UNION);
    L7:
        r9.drawCircle(r12, r11, this.haloRadius, this.haloPaint);
        return;
    }

    private boolean shouldDrawCompatHalo() {
        if (this.forceDrawCompatHalo == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L10;
        if (ZeusTransformUtils.instanceOf(getBackground(), RippleDrawable.class) == false) goto L10;
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        float r0 = r6.getX();
        float r2 = (r0 - this.trackSidePadding) / this.trackWidth;
        this.touchPosition = r2;
        float r3 = Math.max(0.0f, r2);
        this.touchPosition = r3;
        this.touchPosition = Math.min(1.0f, r3);
        int r4 = r6.getActionMasked();
        if (r4 == 0) goto L38;
        if (r4 != 1) goto L9;
        this.thumbIsPressed = false;
        MotionEvent r1 = this.lastEvent;
        if (r1 == null) goto L35;
        if (r1.getActionMasked() != 0) goto L35;
        if (Math.abs(this.lastEvent.getX() - r6.getX()) > this.scaledTouchSlop) goto L35;
        if (Math.abs(this.lastEvent.getY() - r6.getY()) > this.scaledTouchSlop) goto L35;
        if (pickActiveThumb() == false) goto L35;
        onStartTrackingTouch();
    L35:
        if (this.activeThumbIdx == (-1)) goto L37;
        snapTouchPosition();
        this.activeThumbIdx = -1;
        onStopTrackingTouch();
    L37:
        invalidate();
    L45:
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(r6);
        return true;
    L9:
        if (r4 != 2) goto L45;
        if (this.thumbIsPressed == true) goto L20;
        if (isInVerticalScrollingContainer() == true) goto L16;
    L18:
        getParent().requestDisallowInterceptTouchEvent(true);
        onStartTrackingTouch();
        goto L20
    L16:
        if (Math.abs(r0 - this.touchDownX) >= this.scaledTouchSlop) goto L18;
        return false;
    L20:
        if (pickActiveThumb() == false) goto L45;
        this.thumbIsPressed = true;
        snapTouchPosition();
        updateHaloHotspot();
        invalidate();
        goto L45
    L38:
        this.touchDownX = r0;
        if (isInVerticalScrollingContainer() == true) goto L45;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (pickActiveThumb() == false) goto L45;
        requestFocus();
        this.thumbIsPressed = true;
        snapTouchPosition();
        updateHaloHotspot();
        invalidate();
        onStartTrackingTouch();
        goto L45
    }

    private static int pivotIndex(float[] r0, float r1) {
        return Math.round(r1 * ((r0.length / 2) - 1));
    }

    private double snapPosition(float r3) {
        float r0 = this.stepSize;
        if (r0 <= 0.0f) goto L7;
        int r2 = (int) ((this.valueTo - this.valueFrom) / r0);
        return ((double) Math.round(r3 * r2)) / ((double) r2);
    L7:
        return r3;
    }

    public boolean pickActiveThumb() {
        if (this.activeThumbIdx == (-1)) goto L5;
        return true;
    L5:
        float r0 = getValueOfTouchPositionAbsolute();
        float r3 = valueToX(r0);
        this.activeThumbIdx = 0;
        float r5 = Math.abs(((Float) ZeusTransformUtils.preCheckCast(this.values.get(0), Float.class, "com.obric.aiagent.plugin")).floatValue() - r0);
        int r6 = 1;
    L7:
        if (r6 >= this.values.size()) goto L34;
        float r8 = Math.abs(((Float) ZeusTransformUtils.preCheckCast(this.values.get(r6), Float.class, "com.obric.aiagent.plugin")).floatValue() - r0);
        float r9 = valueToX(((Float) ZeusTransformUtils.preCheckCast(this.values.get(r6), Float.class, "com.obric.aiagent.plugin")).floatValue());
        if (Float.compare(r8, r5) > 1) goto L34;
        if (isRtl() == false) goto L17;
        if ((r9 - r3) > 0.0f) goto L18;
    L19:
        boolean r10 = false;
    L21:
        if (Float.compare(r8, r5) >= 0) goto L24;
        this.activeThumbIdx = r6;
    L31:
        r5 = r8;
    L32:
        r6 = r6 + 1;
        goto L7
    L24:
        if (Float.compare(r8, r5) != 0) goto L32;
        if (Math.abs(r9 - r3) < this.scaledTouchSlop) goto L27;
        if (r10 == false) goto L32;
        this.activeThumbIdx = r6;
        goto L31
    L27:
        this.activeThumbIdx = -1;
        return false;
    L18:
        r10 = true;
        goto L21
    L17:
        if ((r9 - r3) >= 0.0f) goto L19;
    L34:
        if (this.activeThumbIdx == (-1)) goto L37;
        return true;
    L37:
        return false;
    }

    private float getValueOfTouchPositionAbsolute() {
        float r0 = this.touchPosition;
        if (isRtl() == false) goto L5;
        r0 = 1.0f - r0;
    L5:
        float r1 = this.valueTo;
        float r2 = this.valueFrom;
        return (r0 * (r1 - r2)) + r2;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    private boolean snapActiveThumbToValue(float r2) {
        return snapThumbToValue(this.activeThumbIdx, r2);
    }

    private boolean snapThumbToValue(int r5, float r6) {
        this.focusedThumbIdx = r5;
        if (Math.abs(r6 - ((Float) ZeusTransformUtils.preCheckCast(this.values.get(r5), Float.class, "com.obric.aiagent.plugin")).floatValue()) >= THRESHOLD) goto L6;
        return false;
    L6:
        this.values.set(r5, Float.valueOf(getClampedValue(r5, r6)));
        dispatchOnChangedFromUser(r5);
        return true;
    }

    private float getClampedValue(int r5, float r6) {
        float r0 = getMinSeparation();
        if (this.separationUnit != 0) goto L6;
        r0 = dimenToValue(r0);
    L6:
        if (isRtl() == false) goto L8;
        r0 = -r0;
    L8:
        int r1 = r5 + 1;
        if (r1 < this.values.size()) goto L11;
        float r2 = this.valueTo;
    L12:
        int r7 = r5 - 1;
        if (r7 >= 0) goto L15;
        float r4 = this.valueFrom;
    L17:
        return androidx.core.a.a.a(r6, r4, r2);
    L15:
        r4 = ((Float) ZeusTransformUtils.preCheckCast(this.values.get(r7), Float.class, "com.obric.aiagent.plugin")).floatValue() + r0;
        goto L17
    L11:
        r2 = ((Float) ZeusTransformUtils.preCheckCast(this.values.get(r1), Float.class, "com.obric.aiagent.plugin")).floatValue() - r0;
        goto L12
    }

    private float dimenToValue(float r3) {
        if (r3 != 0.0f) goto L5;
        return 0.0f;
    L5:
        float r4 = (r3 - this.trackSidePadding) / this.trackWidth;
        float r0 = this.valueFrom;
        return (r4 * (r0 - this.valueTo)) + r0;
    }

    public void setSeparationUnit(int r1) {
        this.separationUnit = r1;
        this.dirtyConfig = true;
        postInvalidate();
    }

    private float getValueOfTouchPosition() {
        double r0 = snapPosition(this.touchPosition);
        if (isRtl() == false) goto L5;
        r0 = 1.0d - r0;
    L5:
        float r2 = this.valueTo;
        float r4 = this.valueFrom;
        return (float) ((r0 * ((double) (r2 - r4))) + ((double) r4));
    }

    private float valueToX(float r2) {
        return (normalizeValue(r2) * this.trackWidth) + this.trackSidePadding;
    }

    private static float getAnimatorCurrentValueOrDefault(ValueAnimator r2, float r3) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        if (r2.isRunning() == false) goto L8;
        float r4 = ((Float) ZeusTransformUtils.preCheckCast(r2.getAnimatedValue(), Float.class, "com.obric.aiagent.plugin")).floatValue();
        r2.cancel();
        return r4;
    L8:
        return r3;
    }

    private ValueAnimator createLabelAnimator(boolean r5) {
        float r0 = 0.0f;
        if (r5 == false) goto L5;
        float r2 = 0.0f;
    L6:
        if (r5 == false) goto L8;
        ValueAnimator r3 = this.labelsOutAnimator;
    L9:
        float r4 = getAnimatorCurrentValueOrDefault(r3, r2);
        if (r5 == false) goto L12;
        r0 = 1.0f;
    L12:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{r4, r0});
        if (r5 == false) goto L15;
        long r6 = LABEL_ANIMATION_ENTER_DURATION;
    L16:
        r1.setDuration(r6);
        if (r5 == false) goto L19;
        TimeInterpolator r7 = com.google.android.material.animation.a.f13146e;
    L20:
        r1.setInterpolator(r7);
        r1.addUpdateListener(new AnonymousClass2(this));
        return r1;
    L19:
        r7 = com.google.android.material.animation.a.f13144c;
        goto L20
    L15:
        r6 = LABEL_ANIMATION_EXIT_DURATION;
        goto L16
    L8:
        r3 = this.labelsInAnimator;
        goto L9
    L5:
        r2 = 1.0f;
        goto L6
    }

    private void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn == false) goto L6;
        this.labelsAreAnimatedIn = false;
        ValueAnimator r0 = createLabelAnimator(false);
        this.labelsOutAnimator = r0;
        this.labelsInAnimator = null;
        r0.addListener(new AnonymousClass3(this));
        this.labelsOutAnimator.start();
        return;
    }

    private void ensureLabelsAdded() {
        if (this.labelBehavior != 2) goto L6;
        return;
    L6:
        if (this.labelsAreAnimatedIn == true) goto L8;
        this.labelsAreAnimatedIn = true;
        ValueAnimator r0 = createLabelAnimator(true);
        this.labelsInAnimator = r0;
        this.labelsOutAnimator = null;
        r0.start();
    L8:
        Iterator<TooltipDrawable> r1 = this.labels.iterator();
        int r4 = 0;
    L10:
        if (r4 >= this.values.size()) goto L19;
        if (r1.hasNext() == false) goto L19;
        if (r4 == this.focusedThumbIdx) goto L17;
        setValueForLabel((TooltipDrawable) ZeusTransformUtils.preCheckCast(r1.next(), TooltipDrawable.class, "com.obric.aiagent.plugin"), ((Float) ZeusTransformUtils.preCheckCast(this.values.get(r4), Float.class, "com.obric.aiagent.plugin")).floatValue());
    L17:
        r4 = r4 + 1;
    L19:
        if (r1.hasNext() == false) goto L23;
        setValueForLabel((TooltipDrawable) ZeusTransformUtils.preCheckCast(r1.next(), TooltipDrawable.class, "com.obric.aiagent.plugin"), ((Float) ZeusTransformUtils.preCheckCast(this.values.get(this.focusedThumbIdx), Float.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L23:
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())}));
    }

    private String formatValue(float r3) {
        if (hasLabelFormatter() == false) goto L7;
        return this.formatter.a(r3);
    L7:
        if (((int) r3) != r3) goto L9;
        String r2 = "%.0f";
    L11:
        return String.format(r2, new Object[]{Float.valueOf(r3)});
    L9:
        r2 = "%.2f";
        goto L11
    }

    private void setValueForLabel(TooltipDrawable r4, float r5) {
        r4.setText(formatValue(r5));
        int r0 = (this.trackSidePadding + ((int) (normalizeValue(r5) * this.trackWidth))) - (r4.getIntrinsicWidth() / 2);
        int r6 = calculateTop() - (this.labelPadding + this.thumbRadius);
        r4.setBounds(r0, r6 - r4.getIntrinsicHeight(), r4.getIntrinsicWidth() + r0, r6);
        Rect r7 = new Rect(r4.getBounds());
        d.a(r.f(this), this, r7);
        r4.setBounds(r7);
        r.g(this).a(r4);
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
        this.activeTrackPaint.setStrokeWidth(this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
        this.activeTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
    }

    private boolean isInVerticalScrollingContainer() {
        ViewParent r4 = getParent();
    L3:
        boolean r1 = false;
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L15;
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin");
        if (r0.canScrollVertically(1) == false) goto L8;
    L9:
        r1 = true;
    L10:
        if (r1 == false) goto L14;
        if (r0.shouldDelayChildPressedState() == false) goto L14;
        return true;
    L14:
        r4 = r4.getParent();
        goto L3
    L8:
        if (r0.canScrollVertically(-1) == false) goto L10;
    L15:
        return false;
    }

    private void dispatchOnChangedProgrammatically() {
        Iterator<L> r0 = this.changeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        com.google.android.material.slider.a r1 = (com.google.android.material.slider.a) ZeusTransformUtils.preCheckCast(r0.next(), com.google.android.material.slider.a.class, "com.obric.aiagent.plugin");
        Iterator<Float> r2 = this.values.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        r1.a(this, ((Float) ZeusTransformUtils.preCheckCast(r2.next(), Float.class, "com.obric.aiagent.plugin")).floatValue(), false);
        goto L7
    }

    private void dispatchOnChangedFromUser(int r6) {
        Iterator<L> r0 = this.changeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.google.android.material.slider.a) ZeusTransformUtils.preCheckCast(r0.next(), com.google.android.material.slider.a.class, "com.obric.aiagent.plugin")).a(this, ((Float) ZeusTransformUtils.preCheckCast(this.values.get(r6), Float.class, "com.obric.aiagent.plugin")).floatValue(), true);
        goto L4
    L6:
        AccessibilityManager r1 = this.accessibilityManager;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isEnabled() == false) goto L14;
        scheduleAccessibilityEventSender(r6);
        return;
    }

    private void onStartTrackingTouch() {
        Iterator<T> r0 = this.touchListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.google.android.material.slider.b) ZeusTransformUtils.preCheckCast(r0.next(), com.google.android.material.slider.b.class, "com.obric.aiagent.plugin")).a(this);
        goto L4
    }

    private void onStopTrackingTouch() {
        Iterator<T> r0 = this.touchListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.google.android.material.slider.b) ZeusTransformUtils.preCheckCast(r0.next(), com.google.android.material.slider.b.class, "com.obric.aiagent.plugin")).b(this);
        goto L4
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        Iterator<TooltipDrawable> r0 = this.labels.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        TooltipDrawable r1 = (TooltipDrawable) ZeusTransformUtils.preCheckCast(r0.next(), TooltipDrawable.class, "com.obric.aiagent.plugin");
        if (r1.isStateful() == false) goto L4;
        r1.setState(getDrawableState());
        goto L4
    L9:
        if (this.defaultThumbDrawable.isStateful() == false) goto L11;
        this.defaultThumbDrawable.setState(getDrawableState());
    L11:
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    private int getColorForState(ColorStateList r2) {
        return r2.getColorForState(getDrawableState(), r2.getDefaultColor());
    }

    void forceDrawCompatHalo(boolean r1) {
        this.forceDrawCompatHalo = r1;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r6, KeyEvent r7) {
        if (isEnabled() == true) goto L7;
        return super.onKeyDown(r6, r7);
    L7:
        if (this.values.size() != 1) goto L10;
        this.activeThumbIdx = 0;
    L10:
        if (this.activeThumbIdx != (-1)) goto L16;
        Boolean r0 = onKeyDownNoActiveThumb(r6, r7);
        if (r0 == null) goto L15;
        return r0.booleanValue();
    L15:
        return super.onKeyDown(r6, r7);
    L16:
        this.isLongPress |= r7.isLongPress();
        Float r1 = calculateIncrementForKey(r6);
        if (r1 == null) goto L23;
        if (snapActiveThumbToValue(((Float) ZeusTransformUtils.preCheckCast(this.values.get(this.activeThumbIdx), Float.class, "com.obric.aiagent.plugin")).floatValue() + r1.floatValue()) == false) goto L21;
        updateHaloHotspot();
        postInvalidate();
    L21:
        return true;
    L23:
        if (r6 != 23) goto L25;
    L39:
        this.activeThumbIdx = -1;
        postInvalidate();
        return true;
    L25:
        if (r6 == 61) goto L31;
        if (r6 == 66) goto L39;
        return super.onKeyDown(r6, r7);
    L31:
        if (r7.hasNoModifiers() == false) goto L35;
        return moveFocus(1);
    L35:
        if (r7.isShiftPressed() == true) goto L37;
        return false;
    L37:
        return moveFocus(-1);
    }

    private Boolean onKeyDownNoActiveThumb(int r4, KeyEvent r5) {
        if (r4 == 61) goto L26;
        if (r4 != 66) goto L7;
    L23:
        this.activeThumbIdx = this.focusedThumbIdx;
        postInvalidate();
        return true;
    L7:
        if (r4 != 81) goto L9;
    L21:
        moveFocus(1);
        return true;
    L9:
        if (r4 != 69) goto L11;
        moveFocus(-1);
        return true;
    L11:
        if (r4 == 70) goto L21;
        switch(r4) {
            case 21: goto L17;
            case 22: goto L15;
            case 23: goto L23;
            default: goto L13;
        };
    L13:
        return null;
    L15:
        moveFocusInAbsoluteDirection(1);
        return true;
    L17:
        moveFocusInAbsoluteDirection(-1);
        return true;
    L26:
        if (r5.hasNoModifiers() == false) goto L30;
        return Boolean.valueOf(moveFocus(1));
    L30:
        if (r5.isShiftPressed() == false) goto L34;
        return Boolean.valueOf(moveFocus(-1));
    L34:
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r2, KeyEvent r3) {
        this.isLongPress = false;
        return super.onKeyUp(r2, r3);
    }

    final boolean isRtl() {
        if (ViewCompat.i(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean moveFocus(int r12) {
        int r0 = this.focusedThumbIdx;
        int r13 = (int) androidx.core.a.a.a(((long) r0) + ((long) r12), 0, this.values.size() - 1);
        this.focusedThumbIdx = r13;
        if (r13 != r0) goto L7;
        return false;
    L7:
        if (this.activeThumbIdx == (-1)) goto L9;
        this.activeThumbIdx = r13;
    L9:
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int r2) {
        if (isRtl() == false) goto L9;
        if (r2 != Integer.MIN_VALUE) goto L7;
        r2 = Integer.MAX_VALUE;
        goto L9
    L7:
        r2 = -r2;
    L9:
        return moveFocus(r2);
    }

    private Float calculateIncrementForKey(int r3) {
        if (this.isLongPress == false) goto L5;
        float r0 = calculateStepIncrement(20);
    L7:
        if (r3 == 21) goto L28;
        if (r3 == 22) goto L23;
        if (r3 == 69) goto L21;
        if (r3 == 70) goto L19;
        if (r3 == 81) goto L19;
        return null;
    L19:
        return Float.valueOf(r0);
    L21:
        return Float.valueOf(-r0);
    L23:
        if (isRtl() == false) goto L26;
        r0 = -r0;
    L26:
        return Float.valueOf(r0);
    L28:
        if (isRtl() == true) goto L32;
        r0 = -r0;
    L32:
        return Float.valueOf(r0);
    L5:
        r0 = calculateStepIncrement();
        goto L7
    }

    private float calculateStepIncrement() {
        float r1 = this.stepSize;
        if (r1 != 0.0f) goto L6;
        return 1.0f;
    L6:
        return r1;
    }

    private float calculateStepIncrement(int r3) {
        float r0 = calculateStepIncrement();
        float r1 = (this.valueTo - this.valueFrom) / r0;
        float r2 = r3;
        if (r1 > r2) goto L6;
        return r0;
    L6:
        return Math.round(r1 / r2) * r0;
    }

    @Override // android.view.View
    public void onFocusChanged(boolean r1, int r2, Rect r3) {
        super.onFocusChanged(r1, r2, r3);
        if (r1 == true) goto L5;
        this.activeThumbIdx = -1;
        this.accessibilityHelper.d(this.focusedThumbIdx);
        return;
    L5:
        focusThumbOnFocusGained(r2);
        this.accessibilityHelper.c(this.focusedThumbIdx);
    }

    private void focusThumbOnFocusGained(int r4) {
        if (r4 != 1) goto L5;
        moveFocus(Integer.MAX_VALUE);
        return;
    L5:
        if (r4 != 2) goto L7;
        moveFocus(Integer.MIN_VALUE);
        return;
    L7:
        if (r4 != 17) goto L9;
        moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        return;
    L9:
        if (r4 != 66) goto L19;
        moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        return;
    }

    final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.b();
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent r2) {
        if (this.accessibilityHelper.a(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchHoverEvent(r2) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent r1) {
        return super.dispatchKeyEvent(r1);
    }

    private void scheduleAccessibilityEventSender(int r3) {
        BaseSlider<S, L, T>.a r0 = this.accessibilityEventSender;
        if (r0 != null) goto L5;
        this.accessibilityEventSender = new a(this, null);
    L6:
        this.accessibilityEventSender.a(r3);
        postDelayed(this.accessibilityEventSender, 200);
        return;
    L5:
        removeCallbacks(r0);
        goto L6
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState r1 = new SliderState(super.onSaveInstanceState());
        r1.valueFrom = this.valueFrom;
        r1.valueTo = this.valueTo;
        r1.values = new ArrayList(this.values);
        r1.stepSize = this.stepSize;
        r1.hasFocus = hasFocus();
        return r1;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        SliderState r4 = (SliderState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"), SliderState.class, "com.obric.aiagent.plugin");
        super.onRestoreInstanceState(r4.getSuperState());
        this.valueFrom = r4.valueFrom;
        this.valueTo = r4.valueTo;
        setValuesInternal(r4.values);
        this.stepSize = r4.stepSize;
        if (r4.hasFocus == false) goto L6;
        requestFocus();
        return;
    }

    void updateBoundsForVirturalViewId(int r4, Rect r5) {
        int r0 = this.trackSidePadding + ((int) (normalizeValue(((Float) ZeusTransformUtils.preCheckCast(getValues().get(r4), Float.class, "com.obric.aiagent.plugin")).floatValue()) * this.trackWidth));
        int r6 = calculateTop();
        int r3 = this.thumbRadius;
        r5.set(r0 - r3, r6 - r3, r0 + r3, r6 + r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_google_android_material_slider_BaseSlider_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
