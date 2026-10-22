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
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
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
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.a;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import com.google.common.primitives.Ints;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    static final int DEF_STYLE_RES = 0;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
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
    private static final String WARNING_FLOATING_POINT_ERRROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.";
    private BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;

    @NonNull
    private final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;

    @NonNull
    private final Paint activeTicksPaint;

    @NonNull
    private final Paint activeTrackPaint;

    @NonNull
    private final List<L> changeListeners;
    private int defaultThumbRadius;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;

    @NonNull
    private ColorStateList haloColor;

    @NonNull
    private final Paint haloPaint;
    private int haloRadius;

    @NonNull
    private final Paint inactiveTicksPaint;

    @NonNull
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;

    @NonNull
    private final TooltipDrawableFactory labelMaker;
    private int labelPadding;

    @NonNull
    private final List<TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;
    private int minTrackSidePadding;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;

    @NonNull
    private final MaterialShapeDrawable thumbDrawable;
    private boolean thumbIsPressed;

    @NonNull
    private final Paint thumbPaint;
    private int thumbRadius;

    @NonNull
    private ColorStateList tickColorActive;

    @NonNull
    private ColorStateList tickColorInactive;
    private boolean tickVisible;
    private float[] ticksCoordinates;
    private float touchDownX;

    @NonNull
    private final List<T> touchListeners;
    private float touchPosition;

    @NonNull
    private ColorStateList trackColorActive;

    @NonNull
    private ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackTop;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetHeight;

    public class AccessibilityEventSender implements Runnable {
        final /* synthetic */ BaseSlider this$0;
        int virtualViewId;

        private AccessibilityEventSender(BaseSlider r10) {
            this.this$0 = r10;
            this.virtualViewId = -1;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.access$300(this.this$0).sendEventForVirtualView(this.virtualViewId, 4);
        }

        public void setVirtualViewId(int r10) {
            this.virtualViewId = r10;
        }

        public /* synthetic */ AccessibilityEventSender(BaseSlider r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public static class AccessibilityHelper extends a {
        private final BaseSlider<?, ?, ?> slider;
        Rect virtualViewBounds;

        public AccessibilityHelper(BaseSlider<?, ?, ?> r10) {
            super(r10);
            this.virtualViewBounds = new Rect();
            this.slider = r10;
        }

        @NonNull
        private String startOrEndDescription(int r10) {
            if (r10 == (this.slider.getValues().size() - 1)) goto L5;
            if (r10 == 0) goto L8;
            return "";
        L8:
            return this.slider.getContext().getString(R.string.material_slider_range_start);
        L5:
            return this.slider.getContext().getString(R.string.material_slider_range_end);
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float r10, float r11) {
            int r12 = 0;
        L4:
            if (r12 >= this.slider.getValues().size()) goto L9;
            this.slider.updateBoundsForVirturalViewId(r12, this.virtualViewBounds);
            if (this.virtualViewBounds.contains((int) r10, (int) r11) == true) goto L7;
            r12 = r12 + 1;
            goto L4
        L7:
            return r12;
        L9:
            return -1;
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(List<Integer> r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.slider.getValues().size()) goto L6;
            r10.add(Integer.valueOf(r11));
            r11 = r11 + 1;
            goto L4
        }

        @Override // androidx.customview.widget.a
        public boolean onPerformActionForVirtualView(int r10, int r11, Bundle r12) {
            if (this.slider.isEnabled() == true) goto L6;
            return false;
        L6:
            if (r11 == 4096) goto L20;
            if (r11 == 8192) goto L20;
            if (r11 == 16908349) goto L11;
            return false;
        L11:
            if (r12 != null) goto L13;
        L19:
            return false;
        L13:
            if (r12.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE") == false) goto L19;
            float r13 = r12.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
            if (BaseSlider.access$600(this.slider, r10, r13) == false) goto L19;
            BaseSlider.access$700(this.slider);
            this.slider.postInvalidate();
            invalidateVirtualView(r10);
            return true;
        L20:
            float r14 = BaseSlider.access$800(this.slider, 20);
            if (r11 != 8192) goto L24;
            r14 = -r14;
        L24:
            if (this.slider.isRtl() == false) goto L26;
            r14 = -r14;
        L26:
            float r15 = p.a.a(this.slider.getValues().get(r10).floatValue() + r14, this.slider.getValueFrom(), this.slider.getValueTo());
            if (BaseSlider.access$600(this.slider, r10, r15) == false) goto L30;
            BaseSlider.access$700(this.slider);
            this.slider.postInvalidate();
            invalidateVirtualView(r10);
            return true;
        L30:
            return false;
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int r10, AccessibilityNodeInfoCompat r11) {
            r11.b(AccessibilityNodeInfoCompat.a.L);
            List<Float> r12 = this.slider.getValues();
            float r13 = r12.get(r10).floatValue();
            float r14 = this.slider.getValueFrom();
            float r15 = this.slider.getValueTo();
            if (this.slider.isEnabled() == true) goto L5;
        L10:
            r11.o0(AccessibilityNodeInfoCompat.d.a(1, r14, r15, r13));
            r11.V(SeekBar.class.getName());
            StringBuilder r16 = new StringBuilder();
            if (this.slider.getContentDescription() == null) goto L14;
            r16.append(this.slider.getContentDescription());
            r16.append(",");
        L14:
            if (r12.size() <= 1) goto L16;
            r16.append(startOrEndDescription(r10));
            r16.append(BaseSlider.access$500(this.slider, r13));
        L16:
            r11.Z(r16.toString());
            this.slider.updateBoundsForVirturalViewId(r10, this.virtualViewBounds);
            r11.Q(this.virtualViewBounds);
            return;
        L5:
            if (r13 <= r14) goto L8;
            r11.a(8192);
        L8:
            if (r13 >= r15) goto L10;
            r11.a(4096);
            goto L10
        }
    }

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = null;
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        static {
            CREATOR = new AnonymousClass1();
        }

        public /* synthetic */ SliderState(Parcel r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeFloat(this.valueFrom);
            r10.writeFloat(this.valueTo);
            r10.writeList(this.values);
            r10.writeFloat(this.stepSize);
            r10.writeBooleanArray(new boolean[]{this.hasFocus});
        }

        public SliderState(Parcelable r10) {
            super(r10);
        }

        private SliderState(@NonNull Parcel r10) {
            super(r10);
            this.valueFrom = r10.readFloat();
            this.valueTo = r10.readFloat();
            ArrayList<Float> r11 = new ArrayList();
            this.values = r11;
            r10.readList(r11, Float.class.getClassLoader());
            this.stepSize = r10.readFloat();
            this.hasFocus = r10.createBooleanArray()[0];
        }
    }

    public interface TooltipDrawableFactory {
        TooltipDrawable createTooltipDrawable();
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
    }

    public BaseSlider(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ TooltipDrawable access$000(Context r10, TypedArray r11) {
        return parseLabelDrawable(r10, r11);
    }

    public static /* synthetic */ List access$100(BaseSlider r10) {
        return r10.labels;
    }

    public static /* synthetic */ AccessibilityHelper access$300(BaseSlider r10) {
        return r10.accessibilityHelper;
    }

    public static /* synthetic */ String access$500(BaseSlider r10, float r11) {
        return r10.formatValue(r11);
    }

    public static /* synthetic */ boolean access$600(BaseSlider r10, int r11, float r12) {
        return r10.snapThumbToValue(r11, r12);
    }

    public static /* synthetic */ void access$700(BaseSlider r10) {
        r10.updateHaloHotspot();
    }

    public static /* synthetic */ float access$800(BaseSlider r10, int r11) {
        return r10.calculateStepIncrement(r11);
    }

    private void attachLabelToContentView(TooltipDrawable r10) {
        r10.setRelativeToView(ViewUtils.getContentView(this));
    }

    private Float calculateIncrementForKey(int r10) {
        if (this.isLongPress == false) goto L5;
        float r11 = calculateStepIncrement(20);
    L7:
        if (r10 == 21) goto L28;
        if (r10 == 22) goto L23;
        if (r10 == 69) goto L21;
        if (r10 == 70) goto L19;
        if (r10 == 81) goto L19;
        return null;
    L19:
        return Float.valueOf(r11);
    L21:
        return Float.valueOf(-r11);
    L23:
        if (isRtl() == false) goto L26;
        r11 = -r11;
    L26:
        return Float.valueOf(r11);
    L28:
        if (isRtl() == true) goto L32;
        r11 = -r11;
    L32:
        return Float.valueOf(r11);
    L5:
        r11 = calculateStepIncrement();
        goto L7
    }

    private float calculateStepIncrement() {
        float r10 = this.stepSize;
        if (r10 != 0.0f) goto L6;
        return 1.0f;
    L6:
        return r10;
    }

    private int calculateTop() {
        int r10 = this.trackTop;
        int r11 = 0;
        if (this.labelBehavior != 1) goto L6;
        r11 = this.labels.get(0).getIntrinsicHeight();
    L6:
        return r10 + r11;
    }

    private ValueAnimator createLabelAnimator(boolean r10) {
        float r11 = 1.0f;
        if (r10 == false) goto L5;
        float r12 = 0.0f;
    L6:
        if (r10 == false) goto L8;
        ValueAnimator r13 = this.labelsOutAnimator;
    L9:
        float r14 = getAnimatorCurrentValueOrDefault(r13, r12);
        if (r10 == true) goto L13;
        r11 = 0.0f;
    L13:
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{r14, r11});
        if (r10 == false) goto L16;
        long r16 = LABEL_ANIMATION_ENTER_DURATION;
    L17:
        r15.setDuration(r16);
        if (r10 == false) goto L20;
        TimeInterpolator r17 = AnimationUtils.DECELERATE_INTERPOLATOR;
    L21:
        r15.setInterpolator(r17);
        r15.addUpdateListener(new AnonymousClass2(this));
        return r15;
    L20:
        r17 = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        goto L21
    L16:
        r16 = LABEL_ANIMATION_EXIT_DURATION;
        goto L17
    L8:
        r13 = this.labelsInAnimator;
        goto L9
    L5:
        r12 = 1.0f;
        goto L6
    }

    private void createLabelPool() {
        if (this.labels.size() <= this.values.size()) goto L12;
        List<TooltipDrawable> r10 = this.labels.subList(this.values.size(), this.labels.size());
        Iterator<TooltipDrawable> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        TooltipDrawable r12 = r11.next();
        if (ViewCompat.S(this) == false) goto L6;
        detachLabelFromContentView(r12);
        goto L6
    L10:
        r10.clear();
    L12:
        if (this.labels.size() >= this.values.size()) goto L16;
        TooltipDrawable r13 = this.labelMaker.createTooltipDrawable();
        this.labels.add(r13);
        if (ViewCompat.S(this) == false) goto L12;
        attachLabelToContentView(r13);
        goto L12
    L16:
        int r14 = 1;
        if (this.labels.size() != 1) goto L19;
        r14 = 0;
    L19:
        Iterator<TooltipDrawable> r15 = this.labels.iterator();
    L21:
        if (r15.hasNext() == false) goto L23;
        r15.next().setStrokeWidth(r14);
        goto L21
    }

    private void detachLabelFromContentView(TooltipDrawable r10) {
        ViewOverlayImpl r11 = ViewUtils.getContentViewOverlay(this);
        if (r11 == null) goto L6;
        r11.remove(r10);
        r10.detachView(ViewUtils.getContentView(this));
        return;
    }

    private float dimenToValue(float r10) {
        if (r10 != 0.0f) goto L5;
        return 0.0f;
    L5:
        float r11 = (r10 - this.trackSidePadding) / this.trackWidth;
        float r12 = this.valueFrom;
        return (r11 * (r12 - this.valueTo)) + r12;
    }

    private void dispatchOnChangedFromUser(int r10) {
        Iterator<L> r11 = this.changeListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onValueChange(this, this.values.get(r10).floatValue(), true);
        goto L4
    L6:
        AccessibilityManager r12 = this.accessibilityManager;
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.isEnabled() == false) goto L14;
        scheduleAccessibilityEventSender(r10);
        return;
    }

    private void dispatchOnChangedProgramatically() {
        Iterator<L> r10 = this.changeListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        L r11 = r10.next();
        Iterator<Float> r12 = this.values.iterator();
    L7:
        if (r12.hasNext() == false) goto L4;
        r11.onValueChange(this, r12.next().floatValue(), false);
        goto L7
    }

    private void drawActiveTrack(@NonNull Canvas r11, int r12, int r13) {
        float[] r10 = getActiveRange();
        int r14 = this.trackSidePadding;
        float r15 = r12;
        float r16 = r13;
        r11.drawLine(r14 + (r10[0] * r15), r16, r14 + (r10[1] * r15), r16, this.activeTrackPaint);
    }

    private void drawInactiveTrack(@NonNull Canvas r12, int r13, int r14) {
        float[] r10 = getActiveRange();
        int r11 = this.trackSidePadding;
        float r15 = r13;
        float r16 = r11 + (r10[1] * r15);
        if (r16 >= (r11 + r13)) goto L5;
        float r17 = r14;
        r12.drawLine(r16, r17, r11 + r13, r17, this.inactiveTrackPaint);
    L5:
        int r18 = this.trackSidePadding;
        float r19 = r18 + (r10[0] * r15);
        if (r19 <= r18) goto L9;
        float r20 = r14;
        r12.drawLine(r18, r20, r19, r20, this.inactiveTrackPaint);
        return;
    }

    private void drawThumbs(@NonNull Canvas r10, int r11, int r12) {
        if (isEnabled() == true) goto L8;
        Iterator<Float> r13 = this.values.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        r10.drawCircle(this.trackSidePadding + (normalizeValue(r13.next().floatValue()) * r11), r12, this.thumbRadius, this.thumbPaint);
    L8:
        Iterator<Float> r14 = this.values.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        Float r15 = r14.next();
        r10.save();
        int r16 = this.trackSidePadding + ((int) (normalizeValue(r15.floatValue()) * r11));
        int r17 = this.thumbRadius;
        r10.translate(r16 - r17, r12 - r17);
        this.thumbDrawable.draw(r10);
        r10.restore();
        goto L10
    }

    private void ensureLabelsAdded() {
        if (this.labelBehavior != 2) goto L6;
        return;
    L6:
        if (this.labelsAreAnimatedIn == true) goto L8;
        this.labelsAreAnimatedIn = true;
        ValueAnimator r10 = createLabelAnimator(true);
        this.labelsInAnimator = r10;
        this.labelsOutAnimator = null;
        r10.start();
    L8:
        Iterator<TooltipDrawable> r11 = this.labels.iterator();
        int r12 = 0;
    L10:
        if (r12 >= this.values.size()) goto L19;
        if (r11.hasNext() == false) goto L19;
        if (r12 == this.focusedThumbIdx) goto L17;
        setValueForLabel(r11.next(), this.values.get(r12).floatValue());
    L17:
        r12 = r12 + 1;
    L19:
        if (r11.hasNext() == false) goto L23;
        setValueForLabel(r11.next(), this.values.get(this.focusedThumbIdx).floatValue());
        return;
    L23:
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())}));
    }

    private void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn == false) goto L6;
        this.labelsAreAnimatedIn = false;
        ValueAnimator r10 = createLabelAnimator(false);
        this.labelsOutAnimator = r10;
        this.labelsInAnimator = null;
        r10.addListener(new AnonymousClass3(this));
        this.labelsOutAnimator.start();
        return;
    }

    private void focusThumbOnFocusGained(int r10) {
        if (r10 != 1) goto L5;
        moveFocus(Channel.UNLIMITED);
        return;
    L5:
        if (r10 != 2) goto L7;
        moveFocus(Integer.MIN_VALUE);
        return;
    L7:
        if (r10 != 17) goto L9;
        moveFocusInAbsoluteDirection(Channel.UNLIMITED);
        return;
    L9:
        if (r10 != 66) goto L19;
        moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        return;
    }

    private String formatValue(float r10) {
        if (hasLabelFormatter() == false) goto L7;
        return this.formatter.getFormattedValue(r10);
    L7:
        if (((int) r10) != r10) goto L9;
        String r11 = "%.0f";
    L11:
        return String.format(r11, new Object[]{Float.valueOf(r10)});
    L9:
        r11 = "%.2f";
        goto L11
    }

    private float[] getActiveRange() {
        float r10 = ((Float) Collections.max(getValues())).floatValue();
        float r11 = ((Float) Collections.min(getValues())).floatValue();
        if (this.values.size() != 1) goto L5;
        r11 = this.valueFrom;
    L5:
        float r12 = normalizeValue(r11);
        float r13 = normalizeValue(r10);
        if (isRtl() == false) goto L9;
        return new float[]{r13, r12};
    L9:
        return new float[]{r12, r13};
    }

    private static float getAnimatorCurrentValueOrDefault(ValueAnimator r10, float r11) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        if (r10.isRunning() == false) goto L8;
        float r12 = ((Float) r10.getAnimatedValue()).floatValue();
        r10.cancel();
        return r12;
    L8:
        return r11;
    }

    private float getClampedValue(int r10, float r11) {
        float r12 = 0.0f;
        if (this.stepSize != 0.0f) goto L6;
        r12 = getMinSeparation();
    L6:
        if (this.separationUnit != 0) goto L9;
        r12 = dimenToValue(r12);
    L9:
        if (isRtl() == false) goto L11;
        r12 = -r12;
    L11:
        int r13 = r10 + 1;
        if (r13 < this.values.size()) goto L14;
        float r14 = this.valueTo;
    L15:
        int r15 = r10 - 1;
        if (r15 >= 0) goto L18;
        float r16 = this.valueFrom;
    L20:
        return p.a.a(r11, r16, r14);
    L18:
        r16 = this.values.get(r15).floatValue() + r12;
        goto L20
    L14:
        r14 = this.values.get(r13).floatValue() - r12;
        goto L15
    }

    @ColorInt
    private int getColorForState(@NonNull ColorStateList r10) {
        return r10.getColorForState(getDrawableState(), r10.getDefaultColor());
    }

    private float getValueOfTouchPosition() {
        double r10 = snapPosition(this.touchPosition);
        if (isRtl() == false) goto L5;
        r10 = 1.0d - r10;
    L5:
        float r11 = this.valueTo;
        float r12 = this.valueFrom;
        return (float) ((r10 * ((double) (r11 - r12))) + ((double) r12));
    }

    private float getValueOfTouchPositionAbsolute() {
        float r10 = this.touchPosition;
        if (isRtl() == false) goto L5;
        r10 = 1.0f - r10;
    L5:
        float r11 = this.valueTo;
        float r12 = this.valueFrom;
        return (r10 * (r11 - r12)) + r12;
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
        this.activeTrackPaint.setStrokeWidth(this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
        this.activeTicksPaint.setStrokeWidth(this.trackHeight / 2.0f);
    }

    private boolean isInVerticalScrollingContainer() {
        ViewParent r10 = getParent();
    L4:
        if ((r10 instanceof ViewGroup) == false) goto L13;
        ViewGroup r11 = (ViewGroup) r10;
        if (r11.canScrollVertically(1) == true) goto L10;
        if (r11.canScrollVertically(-1) == true) goto L10;
    L12:
        r10 = r10.getParent();
    L10:
        if (r11.shouldDelayChildPressedState() == false) goto L12;
        return true;
    L13:
        return false;
    }

    private void loadResources(@NonNull Resources r10) {
        this.widgetHeight = r10.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int r11 = r10.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = r11;
        this.trackSidePadding = r11;
        this.defaultThumbRadius = r10.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.trackTop = r10.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.labelPadding = r10.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void maybeCalculateTicksCoordinates() {
        if (this.stepSize > 0.0f) goto L5;
        return;
    L5:
        validateConfigurationIfDirty();
        int r10 = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] r11 = this.ticksCoordinates;
        if (r11 != null) goto L8;
    L9:
        this.ticksCoordinates = new float[r10 * 2];
    L10:
        float r12 = this.trackWidth / (r10 - 1);
        int r13 = 0;
    L12:
        if (r13 >= (r10 * 2)) goto L14;
        float[] r14 = this.ticksCoordinates;
        r14[r13] = this.trackSidePadding + ((r13 / 2) * r12);
        r14[r13 + 1] = calculateTop();
        r13 = r13 + 2;
        goto L12
    L14:
        return;
    L8:
        if (r11.length == (r10 * 2)) goto L10;
        goto L9
    }

    private void maybeDrawHalo(@NonNull Canvas r10, int r11, int r12) {
        if (shouldDrawCompatHalo() == false) goto L6;
        r10.drawCircle((int) (this.trackSidePadding + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * r11)), r12, this.haloRadius, this.haloPaint);
        return;
    }

    private void maybeDrawTicks(@NonNull Canvas r10) {
        if (this.tickVisible == true) goto L5;
        return;
    L5:
        if (this.stepSize <= 0.0f) goto L10;
        float[] r11 = getActiveRange();
        int r12 = pivotIndex(this.ticksCoordinates, r11[0]);
        int r13 = pivotIndex(this.ticksCoordinates, r11[1]);
        int r14 = r12 * 2;
        r10.drawPoints(this.ticksCoordinates, 0, r14, this.inactiveTicksPaint);
        int r15 = r13 * 2;
        r10.drawPoints(this.ticksCoordinates, r14, r15 - r14, this.activeTicksPaint);
        float[] r16 = this.ticksCoordinates;
        r10.drawPoints(r16, r15, r16.length - r15, this.inactiveTicksPaint);
        return;
    }

    private void maybeIncreaseTrackSidePadding() {
        int r10 = Math.max(this.thumbRadius - this.defaultThumbRadius, 0);
        this.trackSidePadding = this.minTrackSidePadding + r10;
        if (ViewCompat.T(this) == false) goto L6;
        updateTrackWidth(getWidth());
        return;
    }

    private boolean moveFocus(int r12) {
        int r10 = this.focusedThumbIdx;
        int r13 = (int) p.a.c(((long) r10) + ((long) r12), 0, this.values.size() - 1);
        this.focusedThumbIdx = r13;
        if (r13 != r10) goto L7;
        return false;
    L7:
        if (this.activeThumbIdx == (-1)) goto L9;
        this.activeThumbIdx = r13;
    L9:
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int r10) {
        if (isRtl() == false) goto L9;
        if (r10 != Integer.MIN_VALUE) goto L7;
        r10 = Channel.UNLIMITED;
        goto L9
    L7:
        r10 = -r10;
    L9:
        return moveFocus(r10);
    }

    private float normalizeValue(float r10) {
        float r11 = this.valueFrom;
        float r12 = (r10 - r11) / (this.valueTo - r11);
        if (isRtl() == true) goto L5;
        return r12;
    L5:
        return 1.0f - r12;
    }

    private Boolean onKeyDownNoActiveThumb(int r10, @NonNull KeyEvent r11) {
        if (r10 == 61) goto L26;
        if (r10 != 66) goto L7;
    L23:
        this.activeThumbIdx = this.focusedThumbIdx;
        postInvalidate();
        return Boolean.TRUE;
    L7:
        if (r10 != 81) goto L9;
    L21:
        moveFocus(1);
        return Boolean.TRUE;
    L9:
        if (r10 != 69) goto L11;
        moveFocus(-1);
        return Boolean.TRUE;
    L11:
        if (r10 == 70) goto L21;
        switch(r10) {
            case 21: goto L17;
            case 22: goto L15;
            case 23: goto L23;
            default: goto L13;
        };
    L13:
        return null;
    L15:
        moveFocusInAbsoluteDirection(1);
        return Boolean.TRUE;
    L17:
        moveFocusInAbsoluteDirection(-1);
        return Boolean.TRUE;
    L26:
        if (r11.hasNoModifiers() == false) goto L30;
        return Boolean.valueOf(moveFocus(1));
    L30:
        if (r11.isShiftPressed() == false) goto L34;
        return Boolean.valueOf(moveFocus(-1));
    L34:
        return Boolean.FALSE;
    }

    private void onStartTrackingTouch() {
        Iterator<T> r10 = this.touchListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onStartTrackingTouch(this);
        goto L4
    }

    private void onStopTrackingTouch() {
        Iterator<T> r10 = this.touchListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onStopTrackingTouch(this);
        goto L4
    }

    @NonNull
    private static TooltipDrawable parseLabelDrawable(@NonNull Context r10, @NonNull TypedArray r11) {
        return TooltipDrawable.createFromAttributes(r10, null, 0, r11.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    private static int pivotIndex(float[] r10, float r11) {
        return Math.round(r11 * ((r10.length / 2) - 1));
    }

    private void processAttributes(Context r10, AttributeSet r11, int r12) {
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.Slider, r12, DEF_STYLE_RES, new int[0]);
        this.valueFrom = r13.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = r13.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(new Float[]{Float.valueOf(this.valueFrom)});
        this.stepSize = r13.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        int r14 = R.styleable.Slider_trackColor;
        boolean r15 = r13.hasValue(r14);
        if (r15 == false) goto L5;
        int r16 = r14;
    L6:
        if (r15 == true) goto L9;
        r14 = R.styleable.Slider_trackColorActive;
    L9:
        ColorStateList r17 = MaterialResources.getColorStateList(r10, r13, r16);
        if (r17 != null) goto L13;
        r17 = c.a.a(r10, R.color.material_slider_inactive_track_color);
    L13:
        setTrackInactiveTintList(r17);
        ColorStateList r18 = MaterialResources.getColorStateList(r10, r13, r14);
        if (r18 != null) goto L17;
        r18 = c.a.a(r10, R.color.material_slider_active_track_color);
    L17:
        setTrackActiveTintList(r18);
        ColorStateList r19 = MaterialResources.getColorStateList(r10, r13, R.styleable.Slider_thumbColor);
        this.thumbDrawable.setFillColor(r19);
        int r110 = R.styleable.Slider_thumbStrokeColor;
        if (r13.hasValue(r110) == false) goto L20;
        setThumbStrokeColor(MaterialResources.getColorStateList(r10, r13, r110));
    L20:
        setThumbStrokeWidth(r13.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList r111 = MaterialResources.getColorStateList(r10, r13, R.styleable.Slider_haloColor);
        if (r111 != null) goto L24;
        r111 = c.a.a(r10, R.color.material_slider_halo_color);
    L24:
        setHaloTintList(r111);
        this.tickVisible = r13.getBoolean(R.styleable.Slider_tickVisible, true);
        int r112 = R.styleable.Slider_tickColor;
        boolean r20 = r13.hasValue(r112);
        if (r20 == false) goto L27;
        int r21 = r112;
    L28:
        if (r20 == true) goto L31;
        r112 = R.styleable.Slider_tickColorActive;
    L31:
        ColorStateList r22 = MaterialResources.getColorStateList(r10, r13, r21);
        if (r22 != null) goto L35;
        r22 = c.a.a(r10, R.color.material_slider_inactive_tick_marks_color);
    L35:
        setTickInactiveTintList(r22);
        ColorStateList r113 = MaterialResources.getColorStateList(r10, r13, r112);
        if (r113 != null) goto L39;
        r113 = c.a.a(r10, R.color.material_slider_active_tick_marks_color);
    L39:
        setTickActiveTintList(r113);
        setThumbRadius(r13.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(r13.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(r13.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(r13.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.labelBehavior = r13.getInt(R.styleable.Slider_labelBehavior, 0);
        if (r13.getBoolean(R.styleable.Slider_android_enabled, true) == true) goto L42;
        setEnabled(false);
    L42:
        r13.recycle();
        return;
    L27:
        r21 = R.styleable.Slider_tickColorInactive;
        goto L28
    L5:
        r16 = R.styleable.Slider_trackColorInactive;
        goto L6
    }

    private void scheduleAccessibilityEventSender(int r10) {
        BaseSlider<S, L, T>.AccessibilityEventSender r11 = this.accessibilityEventSender;
        if (r11 != null) goto L5;
        this.accessibilityEventSender = new AccessibilityEventSender(this, null);
    L6:
        this.accessibilityEventSender.setVirtualViewId(r10);
        postDelayed(this.accessibilityEventSender, 200);
        return;
    L5:
        removeCallbacks(r11);
        goto L6
    }

    private void setValueForLabel(TooltipDrawable r10, float r11) {
        r10.setText(formatValue(r11));
        int r12 = (this.trackSidePadding + ((int) (normalizeValue(r11) * this.trackWidth))) - (r10.getIntrinsicWidth() / 2);
        int r13 = calculateTop() - (this.labelPadding + this.thumbRadius);
        r10.setBounds(r12, r13 - r10.getIntrinsicHeight(), r10.getIntrinsicWidth() + r12, r13);
        Rect r14 = new Rect(r10.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, r14);
        r10.setBounds(r14);
        ViewUtils.getContentViewOverlay(this).add(r10);
    }

    private void setValuesInternal(@NonNull ArrayList<Float> r10) {
        if (r10.isEmpty() == true) goto L12;
        Collections.sort(r10);
        if (this.values.size() == r10.size()) goto L7;
    L9:
        this.values = r10;
        this.dirtyConfig = true;
        this.focusedThumbIdx = 0;
        updateHaloHotspot();
        createLabelPool();
        dispatchOnChangedProgramatically();
        postInvalidate();
        return;
    L7:
        if (this.values.equals(r10) == false) goto L9;
        return;
    L12:
        throw new IllegalArgumentException("At least one value must be set");
    }

    private boolean shouldDrawCompatHalo() {
        if (this.forceDrawCompatHalo == false) goto L5;
    L8:
        return true;
    L5:
        if ((getBackground() instanceof RippleDrawable) == false) goto L8;
        return false;
    }

    private boolean snapActiveThumbToValue(float r10) {
        return snapThumbToValue(this.activeThumbIdx, r10);
    }

    private double snapPosition(float r10) {
        float r11 = this.stepSize;
        if (r11 <= 0.0f) goto L7;
        int r12 = (int) ((this.valueTo - this.valueFrom) / r11);
        return ((double) Math.round(r10 * r12)) / ((double) r12);
    L7:
        return r10;
    }

    private boolean snapThumbToValue(int r10, float r11) {
        if (Math.abs(r11 - this.values.get(r10).floatValue()) >= THRESHOLD) goto L6;
        return false;
    L6:
        this.values.set(r10, Float.valueOf(getClampedValue(r10, r11)));
        this.focusedThumbIdx = r10;
        dispatchOnChangedFromUser(r10);
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    private void updateHaloHotspot() {
        if (shouldDrawCompatHalo() == false) goto L5;
        return;
    L5:
        if (getMeasuredWidth() <= 0) goto L11;
        Drawable r10 = getBackground();
        if ((r10 instanceof RippleDrawable) == false) goto L12;
        int r11 = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding);
        int r12 = calculateTop();
        int r13 = this.haloRadius;
        o.a.f(r10, r11 - r13, r12 - r13, r11 + r13, r12 + r13);
        return;
    L12:
        return;
    }

    private void updateTrackWidth(int r10) {
        this.trackWidth = Math.max(r10 - (this.trackSidePadding * 2), 0);
        maybeCalculateTicksCoordinates();
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig == false) goto L6;
        validateValueFrom();
        validateValueTo();
        validateStepSize();
        validateValues();
        warnAboutFloatingPointError();
        this.dirtyConfig = false;
        return;
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f) goto L5;
        return;
    L5:
        if (valueLandsOnTick(this.valueTo) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.toString(this.stepSize), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, new Object[]{Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) goto L6;
        return;
    L6:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_TO, new Object[]{Float.toString(this.valueTo), Float.toString(this.valueFrom)}));
    }

    private void validateValues() {
        Iterator<Float> r10 = this.values.iterator();
    L4:
        if (r10.hasNext() == false) goto L18;
        Float r11 = r10.next();
        if (r11.floatValue() < this.valueFrom) goto L17;
        if (r11.floatValue() > this.valueTo) goto L17;
        if (this.stepSize <= 0.0f) goto L4;
        if (valueLandsOnTick(r11.floatValue()) == true) goto L4;
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, new Object[]{Float.toString(r11.floatValue()), Float.toString(this.valueFrom), Float.toString(this.stepSize), Float.toString(this.stepSize)}));
    L17:
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE, new Object[]{Float.toString(r11.floatValue()), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
    }

    private boolean valueLandsOnTick(float r10) {
        double r11 = new BigDecimal(Float.toString(r10)).subtract(new BigDecimal(Float.toString(this.valueFrom))).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        if (Math.abs(Math.round(r11) - r11) >= THRESHOLD) goto L5;
        return true;
    L5:
        return false;
    }

    private float valueToX(float r10) {
        return (normalizeValue(r10) * this.trackWidth) + this.trackSidePadding;
    }

    private void warnAboutFloatingPointError() {
        float r10 = this.stepSize;
        if (r10 != 0.0f) goto L6;
        return;
    L6:
        if (((int) r10) == r10) goto L8;
        Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, new Object[]{"stepSize", Float.valueOf(r10)}));
    L8:
        float r11 = this.valueFrom;
        if (((int) r11) == r11) goto L11;
        Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, new Object[]{"valueFrom", Float.valueOf(r11)}));
    L11:
        float r12 = this.valueTo;
        if (((int) r12) == r12) goto L15;
        Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, new Object[]{"valueTo", Float.valueOf(r12)}));
        return;
    }

    public void addOnChangeListener(@Nullable L r10) {
        this.changeListeners.add(r10);
    }

    public void addOnSliderTouchListener(@NonNull T r10) {
        this.touchListeners.add(r10);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent r10) {
        if (this.accessibilityHelper.dispatchHoverEvent(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchHoverEvent(r10) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent r10) {
        return super.dispatchKeyEvent(r10);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        Iterator<TooltipDrawable> r10 = this.labels.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        TooltipDrawable r11 = r10.next();
        if (r11.isStateful() == false) goto L4;
        r11.setState(getDrawableState());
        goto L4
    L9:
        if (this.thumbDrawable.isStateful() == false) goto L11;
        this.thumbDrawable.setState(getDrawableState());
    L11:
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    @VisibleForTesting
    public void forceDrawCompatHalo(boolean r10) {
        this.forceDrawCompatHalo = r10;
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    @Dimension
    public int getHaloRadius() {
        return this.haloRadius;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.thumbDrawable.getElevation();
    }

    @Dimension
    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.thumbDrawable.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.thumbDrawable.getStrokeWidth();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.thumbDrawable.getFillColor();
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive) == false) goto L7;
        return this.tickColorActive;
    L7:
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    @Dimension
    public int getTrackHeight() {
        return this.trackHeight;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive) == false) goto L7;
        return this.trackColorActive;
    L7:
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        if (this.formatter == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRtl() {
        if (ViewCompat.A(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isTickVisible() {
        return this.tickVisible;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<TooltipDrawable> r10 = this.labels.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        attachLabelToContentView(r10.next());
        goto L4
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender r10 = this.accessibilityEventSender;
        if (r10 == null) goto L5;
        removeCallbacks(r10);
    L5:
        this.labelsAreAnimatedIn = false;
        Iterator<TooltipDrawable> r11 = this.labels.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        detachLabelFromContentView(r11.next());
        goto L7
    L9:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas r10) {
        if (this.dirtyConfig == false) goto L5;
        validateConfigurationIfDirty();
        maybeCalculateTicksCoordinates();
    L5:
        super.onDraw(r10);
        int r11 = calculateTop();
        drawInactiveTrack(r10, this.trackWidth, r11);
        if (((Float) Collections.max(getValues())).floatValue() <= this.valueFrom) goto L8;
        drawActiveTrack(r10, this.trackWidth, r11);
    L8:
        maybeDrawTicks(r10);
        if (this.thumbIsPressed == true) goto L13;
        if (isFocused() == true) goto L13;
    L17:
        drawThumbs(r10, this.trackWidth, r11);
        return;
    L13:
        if (isEnabled() == false) goto L17;
        maybeDrawHalo(r10, this.trackWidth, r11);
        if (this.activeThumbIdx == (-1)) goto L17;
        ensureLabelsAdded();
        goto L17
    }

    @Override // android.view.View
    public void onFocusChanged(boolean r10, int r11, @Nullable Rect r12) {
        super.onFocusChanged(r10, r11, r12);
        if (r10 == true) goto L5;
        this.activeThumbIdx = -1;
        ensureLabelsRemoved();
        this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
        return;
    L5:
        focusThumbOnFocusGained(r11);
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, @NonNull KeyEvent r11) {
        if (isEnabled() == true) goto L7;
        return super.onKeyDown(r10, r11);
    L7:
        if (this.values.size() != 1) goto L10;
        this.activeThumbIdx = 0;
    L10:
        if (this.activeThumbIdx != (-1)) goto L16;
        Boolean r12 = onKeyDownNoActiveThumb(r10, r11);
        if (r12 == null) goto L15;
        return r12.booleanValue();
    L15:
        return super.onKeyDown(r10, r11);
    L16:
        this.isLongPress |= r11.isLongPress();
        Float r13 = calculateIncrementForKey(r10);
        if (r13 == null) goto L23;
        if (snapActiveThumbToValue(this.values.get(this.activeThumbIdx).floatValue() + r13.floatValue()) == false) goto L21;
        updateHaloHotspot();
        postInvalidate();
    L21:
        return true;
    L23:
        if (r10 != 23) goto L25;
    L39:
        this.activeThumbIdx = -1;
        ensureLabelsRemoved();
        postInvalidate();
        return true;
    L25:
        if (r10 == 61) goto L31;
        if (r10 == 66) goto L39;
        return super.onKeyDown(r10, r11);
    L31:
        if (r11.hasNoModifiers() == false) goto L35;
        return moveFocus(1);
    L35:
        if (r11.isShiftPressed() == true) goto L37;
        return false;
    L37:
        return moveFocus(-1);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r10, @NonNull KeyEvent r11) {
        this.isLongPress = false;
        return super.onKeyUp(r10, r11);
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = this.widgetHeight;
        int r13 = 0;
        if (this.labelBehavior != 1) goto L5;
        r13 = this.labels.get(0).getIntrinsicHeight();
    L5:
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(r12 + r13, Ints.MAX_POWER_OF_TWO));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        SliderState r11 = (SliderState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.valueFrom = r11.valueFrom;
        this.valueTo = r11.valueTo;
        setValuesInternal(r11.values);
        this.stepSize = r11.stepSize;
        if (r11.hasFocus == false) goto L5;
        requestFocus();
    L5:
        dispatchOnChangedProgramatically();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState r10 = new SliderState(super.onSaveInstanceState());
        r10.valueFrom = this.valueFrom;
        r10.valueTo = this.valueTo;
        r10.values = new ArrayList(this.values);
        r10.stepSize = this.stepSize;
        r10.hasFocus = hasFocus();
        return r10;
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        updateTrackWidth(r10);
        updateHaloHotspot();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent r10) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        float r11 = r10.getX();
        float r12 = (r11 - this.trackSidePadding) / this.trackWidth;
        this.touchPosition = r12;
        float r13 = Math.max(0.0f, r12);
        this.touchPosition = r13;
        this.touchPosition = Math.min(1.0f, r13);
        int r14 = r10.getActionMasked();
        if (r14 == 0) goto L38;
        if (r14 != 1) goto L9;
        this.thumbIsPressed = false;
        MotionEvent r15 = this.lastEvent;
        if (r15 == null) goto L35;
        if (r15.getActionMasked() != 0) goto L35;
        if (Math.abs(this.lastEvent.getX() - r10.getX()) > this.scaledTouchSlop) goto L35;
        if (Math.abs(this.lastEvent.getY() - r10.getY()) > this.scaledTouchSlop) goto L35;
        if (pickActiveThumb() == false) goto L35;
        onStartTrackingTouch();
    L35:
        if (this.activeThumbIdx == (-1)) goto L37;
        snapTouchPosition();
        this.activeThumbIdx = -1;
        onStopTrackingTouch();
    L37:
        ensureLabelsRemoved();
        invalidate();
    L45:
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(r10);
        return true;
    L9:
        if (r14 != 2) goto L45;
        if (this.thumbIsPressed == true) goto L20;
        if (isInVerticalScrollingContainer() == true) goto L16;
    L18:
        getParent().requestDisallowInterceptTouchEvent(true);
        onStartTrackingTouch();
        goto L20
    L16:
        if (Math.abs(r11 - this.touchDownX) >= this.scaledTouchSlop) goto L18;
        return false;
    L20:
        if (pickActiveThumb() == false) goto L45;
        this.thumbIsPressed = true;
        snapTouchPosition();
        updateHaloHotspot();
        invalidate();
        goto L45
    L38:
        this.touchDownX = r11;
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

    public boolean pickActiveThumb() {
        if (this.activeThumbIdx == (-1)) goto L5;
        return true;
    L5:
        float r10 = getValueOfTouchPositionAbsolute();
        float r11 = valueToX(r10);
        this.activeThumbIdx = 0;
        float r12 = Math.abs(this.values.get(0).floatValue() - r10);
        int r13 = 1;
    L7:
        if (r13 >= this.values.size()) goto L34;
        float r14 = Math.abs(this.values.get(r13).floatValue() - r10);
        float r15 = valueToX(this.values.get(r13).floatValue());
        if (Float.compare(r14, r12) > 1) goto L34;
        if (isRtl() == false) goto L18;
        if ((r15 - r11) <= 0.0f) goto L16;
    L15:
        boolean r16 = true;
    L21:
        if (Float.compare(r14, r12) >= 0) goto L24;
        this.activeThumbIdx = r13;
    L31:
        r12 = r14;
    L32:
        r13 = r13 + 1;
        goto L7
    L24:
        if (Float.compare(r14, r12) != 0) goto L32;
        if (Math.abs(r15 - r11) < this.scaledTouchSlop) goto L27;
        if (r16 == false) goto L32;
        this.activeThumbIdx = r13;
        goto L31
    L27:
        this.activeThumbIdx = -1;
        return false;
    L16:
        r16 = false;
        goto L21
    L18:
        if ((r15 - r11) >= 0.0f) goto L16;
    L34:
        if (this.activeThumbIdx == (-1)) goto L37;
        return true;
    L37:
        return false;
    }

    public void removeOnChangeListener(@NonNull L r10) {
        this.changeListeners.remove(r10);
    }

    public void removeOnSliderTouchListener(@NonNull T r10) {
        this.touchListeners.remove(r10);
    }

    public void setActiveThumbIndex(int r10) {
        this.activeThumbIdx = r10;
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        if (r10 == false) goto L5;
        int r11 = 0;
    L6:
        setLayerType(r11, null);
        return;
    L5:
        r11 = 2;
        goto L6
    }

    public void setFocusedThumbIndex(int r10) {
        if (r10 < 0) goto L8;
        if (r10 >= this.values.size()) goto L8;
        this.focusedThumbIdx = r10;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(r10);
        postInvalidate();
        return;
    L8:
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int r10) {
        if (r10 != this.haloRadius) goto L5;
        return;
    L5:
        this.haloRadius = r10;
        Drawable r11 = getBackground();
        if (shouldDrawCompatHalo() == false) goto L8;
    L11:
        postInvalidate();
        return;
    L8:
        if ((r11 instanceof RippleDrawable) == false) goto L11;
        DrawableUtils.setRippleDrawableRadius((RippleDrawable) r11, this.haloRadius);
    }

    public void setHaloRadiusResource(@DimenRes int r10) {
        setHaloRadius(getResources().getDimensionPixelSize(r10));
    }

    public void setHaloTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.haloColor) == false) goto L5;
        return;
    L5:
        this.haloColor = r10;
        Drawable r11 = getBackground();
        if (shouldDrawCompatHalo() == false) goto L8;
    L11:
        this.haloPaint.setColor(getColorForState(r10));
        this.haloPaint.setAlpha(63);
        invalidate();
        return;
    L8:
        if ((r11 instanceof RippleDrawable) == false) goto L11;
        ((RippleDrawable) r11).setColor(r10);
    }

    public void setLabelBehavior(int r10) {
        if (this.labelBehavior == r10) goto L6;
        this.labelBehavior = r10;
        requestLayout();
        return;
    }

    public void setLabelFormatter(@Nullable LabelFormatter r10) {
        this.formatter = r10;
    }

    public void setSeparationUnit(int r10) {
        this.separationUnit = r10;
    }

    public void setStepSize(float r10) {
        if (r10 < 0.0f) goto L9;
        if (this.stepSize == r10) goto L10;
        this.stepSize = r10;
        this.dirtyConfig = true;
        postInvalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.toString(r10), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
    }

    public void setThumbElevation(float r10) {
        this.thumbDrawable.setElevation(r10);
    }

    public void setThumbElevationResource(@DimenRes int r10) {
        setThumbElevation(getResources().getDimension(r10));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int r10) {
        if (r10 != this.thumbRadius) goto L5;
        return;
    L5:
        this.thumbRadius = r10;
        maybeIncreaseTrackSidePadding();
        this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
        MaterialShapeDrawable r11 = this.thumbDrawable;
        int r12 = this.thumbRadius;
        r11.setBounds(0, 0, r12 * 2, r12 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int r10) {
        setThumbRadius(getResources().getDimensionPixelSize(r10));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList r10) {
        this.thumbDrawable.setStrokeColor(r10);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int r10) {
        if (r10 == 0) goto L5;
        setThumbStrokeColor(c.a.a(getContext(), r10));
        return;
    }

    public void setThumbStrokeWidth(float r10) {
        this.thumbDrawable.setStrokeWidth(r10);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int r10) {
        if (r10 == 0) goto L5;
        setThumbStrokeWidth(getResources().getDimension(r10));
        return;
    }

    public void setThumbTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.thumbDrawable.getFillColor()) == false) goto L5;
        return;
    L5:
        this.thumbDrawable.setFillColor(r10);
        invalidate();
    }

    public void setTickActiveTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.tickColorActive) == false) goto L5;
        return;
    L5:
        this.tickColorActive = r10;
        this.activeTicksPaint.setColor(getColorForState(r10));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.tickColorInactive) == false) goto L5;
        return;
    L5:
        this.tickColorInactive = r10;
        this.inactiveTicksPaint.setColor(getColorForState(r10));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList r10) {
        setTickInactiveTintList(r10);
        setTickActiveTintList(r10);
    }

    public void setTickVisible(boolean r10) {
        if (this.tickVisible == r10) goto L6;
        this.tickVisible = r10;
        postInvalidate();
        return;
    }

    public void setTrackActiveTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.trackColorActive) == false) goto L5;
        return;
    L5:
        this.trackColorActive = r10;
        this.activeTrackPaint.setColor(getColorForState(r10));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int r10) {
        if (this.trackHeight == r10) goto L6;
        this.trackHeight = r10;
        invalidateTrack();
        postInvalidate();
        return;
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList r10) {
        if (r10.equals(this.trackColorInactive) == false) goto L5;
        return;
    L5:
        this.trackColorInactive = r10;
        this.inactiveTrackPaint.setColor(getColorForState(r10));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList r10) {
        setTrackInactiveTintList(r10);
        setTrackActiveTintList(r10);
    }

    public void setValueFrom(float r10) {
        this.valueFrom = r10;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float r10) {
        this.valueTo = r10;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValues(@NonNull Float... r10) {
        ArrayList<Float> r11 = new ArrayList();
        Collections.addAll(r11, r10);
        setValuesInternal(r11);
    }

    public void updateBoundsForVirturalViewId(int r10, Rect r11) {
        int r12 = this.trackSidePadding + ((int) (normalizeValue(getValues().get(r10).floatValue()) * this.trackWidth));
        int r13 = calculateTop();
        int r14 = this.thumbRadius;
        r11.set(r12 - r14, r13 - r14, r12 + r14, r13 + r14);
    }

    public BaseSlider(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.sliderStyle);
    }

    private float calculateStepIncrement(int r10) {
        float r11 = calculateStepIncrement();
        float r12 = (this.valueTo - this.valueFrom) / r11;
        float r13 = r10;
        if (r12 > r13) goto L6;
        return r11;
    L6:
        return Math.round(r12 / r13) * r11;
    }

    public BaseSlider(@NonNull Context r10, @Nullable final AttributeSet r11, final int r12) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, DEF_STYLE_RES), r11, r12);
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
        MaterialShapeDrawable r13 = new MaterialShapeDrawable();
        this.thumbDrawable = r13;
        this.separationUnit = 0;
        Context r14 = getContext();
        Paint r15 = new Paint();
        this.inactiveTrackPaint = r15;
        Paint.Style r16 = Paint.Style.STROKE;
        r15.setStyle(r16);
        Paint.Cap r17 = Paint.Cap.ROUND;
        r15.setStrokeCap(r17);
        Paint r18 = new Paint();
        this.activeTrackPaint = r18;
        r18.setStyle(r16);
        r18.setStrokeCap(r17);
        Paint r19 = new Paint(1);
        this.thumbPaint = r19;
        Paint.Style r20 = Paint.Style.FILL;
        r19.setStyle(r20);
        r19.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint r21 = new Paint(1);
        this.haloPaint = r21;
        r21.setStyle(r20);
        Paint r22 = new Paint();
        this.inactiveTicksPaint = r22;
        r22.setStyle(r16);
        r22.setStrokeCap(r17);
        Paint r23 = new Paint();
        this.activeTicksPaint = r23;
        r23.setStyle(r16);
        r23.setStrokeCap(r17);
        loadResources(r14.getResources());
        this.labelMaker = new AnonymousClass1(this, r11, r12);
        processAttributes(r14, r11, r12);
        setFocusable(true);
        setClickable(true);
        r13.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(r14).getScaledTouchSlop();
        AccessibilityHelper r24 = new AccessibilityHelper(this);
        this.accessibilityHelper = r24;
        ViewCompat.p0(this, r24);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(@NonNull List<Float> r10) {
        setValuesInternal(new ArrayList(r10));
    }
}
