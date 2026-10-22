package com.obric.oui.oswitch;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.q;
import androidx.appcompat.widget.y;
import androidx.core.widget.TextViewCompat;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: SwitchCompat.kt */
/* JADX INFO: loaded from: classes4.dex */
public class SwitchCompat extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final boolean CAN_SHOW_TEXT = false;
    private static final int[] CHECKED_STATE_SET = null;
    public static final a Companion = null;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    public static final long THUMB_ANIMATION_DURATION = 443;
    private static final Property<SwitchCompat, Float> THUMB_POS = null;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    public static final int TRACK_ANIMATION_DURATION_OFF = 100;
    public static final int TRACK_ANIMATION_DURATION_ON = 260;
    private boolean autoCheck;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private final int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    private ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private final TextPaint mTextPaint;
    private int mThumbConstraintLeft;
    private int mThumbConstraintRight;
    private float mThumbDragPosition;
    private Drawable mThumbDrawable;
    private int mThumbHeight;
    private float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private final int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private final VelocityTracker mVelocityTracker;
    private int switchWidthOffsetPx;
    private final PathInterpolator thumbAnimInterpolator;

    /* JADX INFO: compiled from: SwitchCompat.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private final float a(float r1, float r2, float r3) {
            if (r1 >= r2) goto L6;
            return r2;
        L6:
            if (r1 > r3) goto L8;
            return r1;
        L8:
            return r3;
        }

        private a() {
        }

        public static final /* synthetic */ float a(a r0, float r1, float r2, float r3) {
            return r0.a(r1, r2, r3);
        }
    }

    public SwitchCompat(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
    }

    public SwitchCompat(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin"), 0, 4, null);
    }

    public final void setShowText(boolean r1) {
    }

    public /* synthetic */ SwitchCompat(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = ZeusTransformUtils.mapRes(R.attr.switchStyle, "attr", "switchStyle");
    L8:
        this(r7, r8, r4);
    }

    public SwitchCompat(Context r8, AttributeSet r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r11, r12, r10);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.autoCheck = true;
        this.thumbAnimInterpolator = new PathInterpolator(0.33f, 1.3f, 0.15f, 1.0f);
        refreshDimensionCache();
        TextPaint r2 = new TextPaint(1);
        this.mTextPaint = r2;
        r2.density = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        y r13 = y.a(r11, r12, R.styleable.SwitchCompat, r10, 0);
        Drawable r14 = r13.a(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_android_thumb, "styleable", "SwitchCompat_android_thumb"));
        this.mThumbDrawable = r14;
        if (r14 == null) goto L5;
        o.a(r14);
        r14.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.aiagent.plugin"));
    L5:
        Drawable r15 = r13.a(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_track, "styleable", "SwitchCompat_track"));
        this.mTrackDrawable = r15;
        if (r15 == null) goto L8;
        o.a(r15);
        r15.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.aiagent.plugin"));
    L8:
        this.mTextOn = r13.c(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_android_textOn, "styleable", "SwitchCompat_android_textOn"));
        this.mTextOff = r13.c(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_android_textOff, "styleable", "SwitchCompat_android_textOff"));
        this.mShowText = false;
        this.mThumbTextPadding = r13.e(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_thumbTextPadding, "styleable", "SwitchCompat_thumbTextPadding"), 0);
        this.mSwitchMinWidth = r13.e(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_switchMinWidth, "styleable", "SwitchCompat_switchMinWidth"), 0);
        this.mSwitchPadding = r13.e(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_switchPadding, "styleable", "SwitchCompat_switchPadding"), 0);
        this.mSplitTrack = r13.a(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_splitTrack, "styleable", "SwitchCompat_splitTrack"), false);
        ColorStateList r16 = r13.e(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_thumbTint, "styleable", "SwitchCompat_thumbTint"));
        if (r16 == null) goto L11;
        this.mThumbTintList = r16;
        this.mHasThumbTint = true;
    L11:
        PorterDuff.Mode r17 = q.a(r13.a(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_thumbTintMode, "styleable", "SwitchCompat_thumbTintMode"), -1), null);
        if (this.mThumbTintMode == r17) goto L15;
        this.mThumbTintMode = r17;
        this.mHasThumbTintMode = true;
    L15:
        if (this.mHasThumbTint == false) goto L17;
    L18:
        applyThumbTint();
    L19:
        ColorStateList r18 = r13.e(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_trackTint, "styleable", "SwitchCompat_trackTint"));
        if (r18 == null) goto L22;
        this.mTrackTintList = r18;
        this.mHasTrackTint = true;
    L22:
        PorterDuff.Mode r19 = q.a(r13.a(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_trackTintMode, "styleable", "SwitchCompat_trackTintMode"), -1), null);
        if (this.mTrackTintMode == r19) goto L26;
        this.mTrackTintMode = r19;
        this.mHasTrackTintMode = true;
    L26:
        if (this.mHasTrackTint == false) goto L28;
    L29:
        applyTrackTint();
    L30:
        int r110 = r13.g(ZeusTransformUtils.mapRes(R.styleable.SwitchCompat_switchTextAppearance, "styleable", "SwitchCompat_switchTextAppearance"), 0);
        if (r110 == 0) goto L33;
        setSwitchTextAppearance(r11, r110);
    L33:
        r13.b();
        if (r11 == null) goto L36;
        ViewConfiguration r20 = ViewConfiguration.get(r11);
        this.mTouchSlop = r20.getScaledTouchSlop();
        this.mMinFlingVelocity = r20.getScaledMinimumFlingVelocity();
    L37:
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L36:
        this.mTouchSlop = 0;
        this.mMinFlingVelocity = 0;
        goto L37
    L28:
        if (this.mHasTrackTintMode == false) goto L30;
    L17:
        if (this.mHasThumbTintMode == false) goto L19;
        goto L18
    }

    public final float getMThumbPosition() {
        return this.mThumbPosition;
    }

    public final void setMThumbPosition(float r1) {
        this.mThumbPosition = r1;
    }

    public final ObjectAnimator getMPositionAnimator() {
        return this.mPositionAnimator;
    }

    public final void setMPositionAnimator(ObjectAnimator r1) {
        this.mPositionAnimator = r1;
    }

    public final int getThumbConstraintLeft() {
        return this.mThumbConstraintLeft;
    }

    public final void setThumbConstraintLeft(int r1) {
        this.mThumbConstraintLeft = r1;
    }

    public final int getThumbConstraintRight() {
        return this.mThumbConstraintRight;
    }

    public final void setThumbConstraintRight(int r1) {
        this.mThumbConstraintRight = r1;
    }

    public final boolean getAutoCheck() {
        return this.autoCheck;
    }

    public final void setAutoCheck(boolean r1) {
        this.autoCheck = r1;
    }

    public final void setSwitchTextAppearance(Context r7, int r8) {
        y r9 = y.a((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), r8, R.styleable.TextAppearance);
        ColorStateList r10 = r9.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));
        if (r10 != null) goto L5;
        r10 = getTextColors();
    L5:
        this.mTextColors = r10;
        int r11 = r9.e(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), 0);
        if (r11 == 0) goto L13;
        float r12 = r11;
        if (r12 != this.mTextPaint.getTextSize()) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
        this.mTextPaint.setTextSize(r12);
        requestLayout();
        goto L13
    L10:
        r3 = false;
    L13:
        setSwitchTypefaceByIndex(r9.a(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_typeface, "styleable", "TextAppearance_android_typeface"), -1), r9.a(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textStyle, "styleable", "TextAppearance_android_textStyle"), -1));
        if (r9.a(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps"), false) == false) goto L16;
        TransformationMethod r13 = (TransformationMethod) ZeusTransformUtils.preCheckCast(new AllCapsTransformationMethod((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), TransformationMethod.class, "com.obric.aiagent.plugin");
    L17:
        this.mSwitchTransformationMethod = r13;
        r9.b();
        return;
    L16:
        r13 = (TransformationMethod) ZeusTransformUtils.preCheckCast(null, TransformationMethod.class, "com.obric.aiagent.plugin");
        goto L17
    }

    private final void setSwitchTypefaceByIndex(int r2, int r3) {
        if (r2 != 1) goto L5;
        Typeface r4 = Typeface.SANS_SERIF;
    L12:
        setSwitchTypeface(r4, r3);
        return;
    L5:
        if (r2 != 2) goto L7;
        r4 = Typeface.SERIF;
        goto L12
    L7:
        if (r2 == 3) goto L9;
        r4 = null;
        goto L12
    L9:
        r4 = Typeface.MONOSPACE;
        goto L12
    }

    public final void setSwitchTypeface(Typeface r4, int r5) {
        float r0 = 0.0f;
        boolean r1 = false;
        if (r5 <= 0) goto L18;
        if (r4 != null) goto L6;
        Typeface r6 = Typeface.defaultFromStyle(r5);
    L7:
        setSwitchTypeface(r6);
        if (r6 != null) goto L10;
        int r7 = 0;
    L11:
        int r8 = (~r7) & r5;
        TextPaint r9 = this.mTextPaint;
        if ((r8 & 1) == 0) goto L14;
        r1 = true;
    L14:
        r9.setFakeBoldText(r1);
        TextPaint r3 = this.mTextPaint;
        if ((r8 & 2) == 0) goto L17;
        r0 = -0.25f;
    L17:
        r3.setTextSkewX(r0);
        return;
    L10:
        r7 = r6.getStyle();
        goto L11
    L6:
        r6 = Typeface.create(r4, r5);
        goto L7
    L18:
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(r4);
    }

    public final void setSwitchTypeface(Typeface r2) {
        if (this.mTextPaint.getTypeface() == null) goto L7;
        if (o.a(this.mTextPaint.getTypeface(), r2) == true) goto L7;
    L9:
        this.mTextPaint.setTypeface(r2);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.mTextPaint.getTypeface() != null) goto L11;
        if (r2 != null) goto L9;
        return;
    }

    public final int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public final void setSwitchPadding(int r1) {
        this.mSwitchPadding = r1;
        requestLayout();
    }

    public final int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public final void setSwitchMinWidth(int r1) {
        this.mSwitchMinWidth = r1;
        requestLayout();
    }

    public final int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public final void setThumbTextPadding(int r1) {
        this.mThumbTextPadding = r1;
        requestLayout();
    }

    public final void setTrackResource(int r4) {
        setTrackDrawable(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public final Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public final void setTrackDrawable(Drawable r3) {
        Drawable r0 = this.mTrackDrawable;
        if (r0 == null) goto L5;
        o.a(r0);
        r0.setCallback(null);
    L5:
        this.mTrackDrawable = r3;
        if (r3 == null) goto L8;
        r3.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.aiagent.plugin"));
    L8:
        requestLayout();
    }

    public final ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public final void setTrackTintList(ColorStateList r1) {
        this.mTrackTintList = r1;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public final PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    public final void setTrackTintMode(PorterDuff.Mode r1) {
        this.mTrackTintMode = r1;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    private final void applyTrackTint() {
        Drawable r0 = this.mTrackDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasTrackTint == false) goto L7;
    L8:
        o.a(r0);
        Drawable r1 = r0.mutate();
        this.mTrackDrawable = r1;
        if (this.mHasTrackTint == false) goto L12;
        o.a(r1);
        androidx.core.graphics.drawable.a.a(r1, this.mTrackTintList);
    L12:
        if (this.mHasTrackTintMode == false) goto L14;
        Drawable r2 = this.mTrackDrawable;
        o.a(r2);
        PorterDuff.Mode r3 = this.mTrackTintMode;
        o.a(r3);
        androidx.core.graphics.drawable.a.a(r2, r3);
    L14:
        Drawable r4 = this.mTrackDrawable;
        o.a(r4);
        if (r4.isStateful() == false) goto L20;
        Drawable r5 = this.mTrackDrawable;
        o.a(r5);
        r5.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasTrackTintMode == true) goto L8;
    }

    public final void setThumbResource(int r4) {
        setThumbDrawable(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public final Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public final void setThumbDrawable(Drawable r3) {
        Drawable r0 = this.mThumbDrawable;
        if (r0 == null) goto L5;
        o.a(r0);
        r0.setCallback(null);
    L5:
        this.mThumbDrawable = r3;
        if (r3 == null) goto L8;
        r3.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.aiagent.plugin"));
    L8:
        requestLayout();
    }

    public final ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public final void setThumbTintList(ColorStateList r1) {
        this.mThumbTintList = r1;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public final PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public final void setThumbTintMode(PorterDuff.Mode r1) {
        this.mThumbTintMode = r1;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    private final void applyThumbTint() {
        Drawable r0 = this.mThumbDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasThumbTint == false) goto L7;
    L8:
        o.a(r0);
        Drawable r1 = r0.mutate();
        this.mThumbDrawable = r1;
        if (this.mHasThumbTint == false) goto L12;
        o.a(r1);
        androidx.core.graphics.drawable.a.a(r1, this.mThumbTintList);
    L12:
        if (this.mHasThumbTintMode == false) goto L14;
        Drawable r2 = this.mThumbDrawable;
        o.a(r2);
        PorterDuff.Mode r3 = this.mThumbTintMode;
        o.a(r3);
        androidx.core.graphics.drawable.a.a(r2, r3);
    L14:
        Drawable r4 = this.mThumbDrawable;
        o.a(r4);
        if (r4.isStateful() == false) goto L20;
        Drawable r5 = this.mThumbDrawable;
        o.a(r5);
        r5.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasThumbTintMode == true) goto L8;
    }

    public final boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public final void setSplitTrack(boolean r1) {
        this.mSplitTrack = r1;
        invalidate();
    }

    public final CharSequence getTextOn() {
        return this.mTextOn;
    }

    public final void setTextOn(CharSequence r3) {
        this.mTextOn = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        requestLayout();
    }

    public final CharSequence getTextOff() {
        return this.mTextOff;
    }

    public final void setTextOff(CharSequence r3) {
        this.mTextOff = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        requestLayout();
    }

    public final boolean getShowText() {
        return this.mShowText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r7, int r8) {
        if (this.mShowText == true) goto L5;
    L10:
        Rect r0 = this.mTempRect;
        Drawable r1 = this.mThumbDrawable;
        int r2 = 0;
        if (r1 == null) goto L13;
        o.a(r1);
        r1.getPadding(r0);
        Drawable r3 = this.mThumbDrawable;
        o.a(r3);
        int r4 = (r3.getIntrinsicWidth() - r0.left) - r0.right;
        Drawable r5 = this.mThumbDrawable;
        o.a(r5);
        int r6 = r5.getIntrinsicHeight();
    L15:
        if (this.mShowText == false) goto L25;
        Layout r9 = this.mOnLayout;
        if (r9 != null) goto L19;
        int r10 = 0;
    L20:
        Layout r11 = this.mOffLayout;
        if (r11 != null) goto L23;
        int r12 = 0;
    L24:
        int r13 = Math.max(r10, r12) + (this.mThumbTextPadding * 2);
    L26:
        this.mThumbWidth = Math.max(r13, r4);
        this.mThumbHeight = r6;
        Drawable r14 = this.mTrackDrawable;
        if (r14 == null) goto L29;
        o.a(r14);
        r14.getPadding(r0);
        Drawable r15 = this.mTrackDrawable;
        o.a(r15);
        r2 = r15.getIntrinsicHeight();
    L30:
        int r16 = r0.left;
        int r17 = r0.right;
        Drawable r18 = this.mThumbDrawable;
        if (r18 == null) goto L33;
        Rect r19 = q.a(r18);
        r16 = Math.max(r16, r19.left);
        r17 = Math.max(r17, r19.right);
    L33:
        int r20 = Math.max(this.mSwitchMinWidth, ((this.mThumbWidth * 2) + r16) + r17);
        int r21 = Math.max(r2, r6);
        this.mSwitchWidth = r20 - this.switchWidthOffsetPx;
        this.mSwitchHeight = r21;
        super.onMeasure(r7, r8);
        if (getMeasuredHeight() >= r21) goto L37;
        setMeasuredDimension(getMeasuredWidthAndState(), r21);
        return;
    L37:
        return;
    L29:
        r0.setEmpty();
        goto L30
    L23:
        r12 = r11.getWidth();
        goto L24
    L19:
        r10 = r9.getWidth();
        goto L20
    L25:
        r13 = 0;
        goto L26
    L13:
        r4 = 0;
        r6 = 0;
        goto L15
    L5:
        if (this.mOnLayout != null) goto L8;
        this.mOnLayout = makeLayout(this.mTextOn);
    L8:
        if (this.mOffLayout != null) goto L10;
        this.mOffLayout = makeLayout(this.mTextOff);
        goto L10
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
    }

    private final void refreshDimensionCache() {
        this.switchWidthOffsetPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent r2) {
        o.e(r2, "event");
        super.onPopulateAccessibilityEvent(r2);
        if (isChecked() == false) goto L5;
        CharSequence r1 = this.mTextOn;
    L6:
        if (r1 == null) goto L9;
        r2.getText().add(r1);
        return;
    L9:
        return;
    L5:
        r1 = this.mTextOff;
        goto L6
    }

    private final Layout makeLayout(CharSequence r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L6;
        return null;
    L6:
        TransformationMethod r0 = this.mSwitchTransformationMethod;
        if (r0 == null) goto L9;
        o.a(r0);
        r12 = r0.getTransformation(r12, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L9:
        CharSequence r3 = r12;
        TextPaint r4 = this.mTextPaint;
        if (r3 == null) goto L12;
        int r10 = (int) Math.ceil(Layout.getDesiredWidth(r3, r4));
    L14:
        return (Layout) ZeusTransformUtils.preCheckCast(new StaticLayout(r3, r4, r10, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true), Layout.class, "com.obric.aiagent.plugin");
    L12:
        r10 = 0;
        goto L14
    }

    private final boolean hitThumb(float r6, float r7) {
        if (this.mThumbDrawable != null) goto L5;
        return false;
    L5:
        int r0 = getThumbOffset();
        Drawable r2 = this.mThumbDrawable;
        o.a(r2);
        r2.getPadding(this.mTempRect);
        int r3 = this.mSwitchTop;
        int r4 = this.mTouchSlop;
        int r5 = r3 - r4;
        int r8 = (this.mSwitchLeft + r0) - r4;
        int r1 = ((this.mThumbWidth + r8) + this.mTempRect.left) + this.mTempRect.right;
        int r9 = this.mTouchSlop;
        int r10 = r1 + r9;
        int r11 = this.mSwitchBottom + r9;
        if (r6 > r8) goto L8;
        return false;
    L8:
        if (r6 < r10) goto L10;
        return false;
    L10:
        if (r7 > r5) goto L12;
        return false;
    L12:
        if (r7 >= r11) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r8) {
        o.e(r8, "ev");
        this.mVelocityTracker.addMovement(r8);
        int r0 = r8.getActionMasked();
        if (r0 == 0) goto L41;
        boolean r2 = false;
        if (r0 == 1) goto L37;
        if (r0 != 2) goto L8;
        int r1 = this.mTouchMode;
        if (r1 == 1) goto L30;
        if (r1 != 2) goto L47;
        float r9 = r8.getX();
        int r3 = getThumbScrollRange();
        float r4 = r9 - this.mTouchX;
        if (r3 == 0) goto L18;
        float r5 = r4 / r3;
    L22:
        if (ac.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == false) goto L24;
        r5 = -r5;
    L24:
        float r6 = a.a(Companion, this.mThumbDragPosition + r5, 0.0f, 1.0f);
        if (r6 != this.mThumbDragPosition) goto L27;
        r2 = true;
    L27:
        if (r2 == true) goto L29;
        this.mTouchX = r9;
        this.mThumbDragPosition = r6;
    L29:
        return true;
    L18:
        if (r4 <= 0.0f) goto L20;
        r5 = 1.0f;
        goto L22
    L20:
        r5 = -1.0f;
    L47:
        return super.onTouchEvent(r8);
    L30:
        float r7 = r8.getX();
        float r10 = r8.getY();
        if (Math.abs(r7 - this.mTouchX) <= this.mTouchSlop) goto L33;
    L34:
        this.mTouchMode = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.mTouchX = r7;
        this.mTouchY = r10;
        return true;
    L33:
        if (Math.abs(r10 - this.mTouchY) <= this.mTouchSlop) goto L47;
    L8:
        if (r0 != 3) goto L47;
    L37:
        if (this.mTouchMode != 2) goto L40;
        stopDrag(r8);
        super.onTouchEvent(r8);
        return true;
    L40:
        this.mTouchMode = 0;
        this.mVelocityTracker.clear();
        goto L47
    L41:
        float r11 = r8.getX();
        float r12 = r8.getY();
        if (isEnabled() == false) goto L47;
        if (hitThumb(r11, r12) == false) goto L47;
        this.mTouchMode = 1;
        this.mTouchX = r11;
        this.mTouchY = r12;
        goto L47
    }

    private final void cancelSuperTouch(MotionEvent r2) {
        MotionEvent r3 = MotionEvent.obtain(r2);
        r3.setAction(3);
        super.onTouchEvent(r3);
        r3.recycle();
    }

    private final void stopDrag(MotionEvent r7) {
        this.mTouchMode = 0;
        boolean r2 = true;
        if (r7.getAction() == 1) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean r3 = isChecked();
        if (r1 == false) goto L22;
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float r4 = this.mVelocityTracker.getXVelocity();
        if (Math.abs(r4) > this.mMinFlingVelocity) goto L13;
        r2 = getTargetCheckedState();
    L23:
        if (r2 == r3) goto L25;
        playSoundEffect(0);
    L25:
        setChecked(r2);
        cancelSuperTouch(r7);
        return;
    L13:
        if (ac.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == false) goto L18;
        if (r4 < 0.0f) goto L23;
    L20:
        r2 = false;
        goto L23
    L18:
        if (r4 <= 0.0f) goto L20;
    L22:
        r2 = r3;
        goto L23
    L5:
        if (isEnabled() == false) goto L7;
        r1 = true;
        goto L8
    }

    private final void animateThumbToCheckedState(boolean r5) {
        if (r5 == false) goto L4;
        float r6 = 1.0f;
    L5:
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{r6});
        this.mPositionAnimator = r7;
        if (r7 == null) goto L10;
        r7.setDuration(443);
    L10:
        if (Build.VERSION.SDK_INT < 18) goto L15;
        ObjectAnimator r8 = this.mPositionAnimator;
        if (r8 == null) goto L15;
        r8.setAutoCancel(true);
    L15:
        ObjectAnimator r9 = this.mPositionAnimator;
        if (r9 == null) goto L19;
        r9.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.thumbAnimInterpolator, TimeInterpolator.class, "com.obric.aiagent.plugin"));
    L19:
        ObjectAnimator r4 = this.mPositionAnimator;
        if (r4 == null) goto L24;
        r4.start();
        return;
    L24:
        return;
    L4:
        r6 = 0.0f;
        goto L5
    }

    private final void cancelPositionAnimator() {
        ObjectAnimator r0 = this.mPositionAnimator;
        if (r0 == null) goto L6;
        o.a(r0);
        r0.cancel();
        return;
    }

    private final boolean getTargetCheckedState() {
        if (this.mThumbDragPosition <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setThumbPosition(float r1) {
        this.mThumbPosition = r1;
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        if (this.autoCheck == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        boolean r0 = super.performClick();
        if (isHapticFeedbackEnabled() == false) goto L5;
        performHapticFeedback(isChecked());
    L5:
        return r0;
    }

    public void performHapticFeedback(boolean r2) {
        if (r2 == false) goto L5;
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 4);
        return;
    L5:
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 5);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        super.setChecked(r2);
        boolean r3 = isChecked();
        if (getWindowToken() != null) goto L5;
    L7:
        cancelPositionAnimator();
        if (r3 == false) goto L10;
        float r4 = 1.0f;
    L11:
        setThumbPosition(r4);
        return;
    L10:
        r4 = 0.0f;
        goto L11
    L5:
        if (hasValidSize() == false) goto L7;
        animateThumbToCheckedState(r3);
    }

    public void setCheckedNoAnim(boolean r1) {
        super.setChecked(r1);
        cancelPositionAnimator();
        if (isChecked() == false) goto L5;
        float r2 = 1.0f;
    L6:
        setThumbPosition(r2);
        return;
    L5:
        r2 = 0.0f;
        goto L6
    }

    public final boolean hasValidSize() {
        if (getWidth() > 0) goto L5;
    L7:
        return false;
    L5:
        if (getHeight() <= 0) goto L7;
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = 0;
        if (this.mThumbDrawable == null) goto L9;
        Rect r7 = this.mTempRect;
        Drawable r8 = this.mTrackDrawable;
        if (r8 == null) goto L7;
        o.a(r8);
        r8.getPadding(r7);
    L8:
        Rect r9 = q.a(this.mThumbDrawable);
        int r10 = Math.max(0, r9.left - r7.left);
        r6 = Math.max(0, r9.right - r7.right);
    L11:
        if (ac.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == false) goto L13;
        int r11 = getPaddingLeft() + r10;
        int r12 = ((this.mSwitchWidth + r11) - r10) - r6;
    L14:
        int r13 = getGravity() & 112;
        if (r13 != 16) goto L17;
        int r14 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r15 = this.mSwitchHeight;
        int r16 = r14 - (r15 / 2);
    L24:
        int r17 = r15 + r16;
    L25:
        this.mSwitchLeft = r11;
        this.mSwitchTop = r16;
        this.mSwitchBottom = r17;
        this.mSwitchRight = r12;
        return;
    L17:
        if (r13 != 48) goto L19;
        r16 = getPaddingTop();
        r15 = this.mSwitchHeight;
        goto L24
    L19:
        if (r13 == 80) goto L21;
        r16 = getPaddingTop();
        r15 = this.mSwitchHeight;
        goto L24
    L21:
        r17 = getHeight() - getPaddingBottom();
        r16 = r17 - this.mSwitchHeight;
        goto L25
    L13:
        r12 = (getWidth() - getPaddingRight()) - r6;
        r11 = ((r12 - this.mSwitchWidth) + r10) + r6;
        goto L14
    L7:
        r7.setEmpty();
        goto L8
    L9:
        r10 = 0;
        goto L11
    }

    @Override // android.view.View
    public void draw(Canvas r11) {
        o.e(r11, "c");
        Rect r0 = this.mTempRect;
        int r1 = this.mSwitchLeft;
        int r2 = this.mSwitchTop;
        int r3 = this.mSwitchRight;
        int r4 = this.mSwitchBottom;
        int r5 = getThumbOffset() + r1;
        Drawable r6 = this.mThumbDrawable;
        if (r6 == null) goto L5;
        Rect r7 = q.a(r6);
    L6:
        Drawable r8 = this.mTrackDrawable;
        if (r8 == null) goto L26;
        o.a(r8);
        r8.getPadding(r0);
        r5 = r5 + r0.left;
        if (r7 != null) goto L11;
        int r9 = r2;
    L24:
        int r10 = r4;
    L25:
        Drawable r12 = this.mTrackDrawable;
        o.a(r12);
        r12.setBounds(r1, r9, r3, r10);
        goto L26
    L11:
        if (r7.left <= r0.left) goto L14;
        r1 = r1 + (r7.left - r0.left);
    L14:
        if (r7.top <= r0.top) goto L16;
        r9 = (r7.top - r0.top) + r2;
    L18:
        if (r7.right <= r0.right) goto L21;
        r3 = r3 - (r7.right - r0.right);
    L21:
        if (r7.bottom <= r0.bottom) goto L24;
        r10 = r4 - (r7.bottom - r0.bottom);
        goto L25
    L16:
        r9 = r2;
    L26:
        Drawable r13 = this.mThumbDrawable;
        if (r13 == null) goto L31;
        o.a(r13);
        r13.getPadding(r0);
        int r14 = (r5 - r0.left) + this.mThumbConstraintLeft;
        int r15 = ((r5 + this.mThumbWidth) + r0.right) + this.mThumbConstraintLeft;
        int r16 = ((r4 - r2) - this.mThumbHeight) / 2;
        Drawable r17 = this.mThumbDrawable;
        o.a(r17);
        r17.setBounds(r14, r16, r15, this.mThumbHeight + r16);
        Drawable r18 = getBackground();
        if (r18 == null) goto L31;
        androidx.core.graphics.drawable.a.a(r18, r14, r2, r15, r4);
    L31:
        super.draw(r11);
        return;
    L5:
        r7 = q.f468a;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        o.e(r10, "canvas");
        super.onDraw(r10);
        Rect r0 = this.mTempRect;
        Drawable r1 = this.mTrackDrawable;
        if (r1 != null) goto L5;
        Boolean r2 = null;
    L6:
        if (r2 != null) goto L8;
        r0.setEmpty();
        x r3 = x.f38692a;
    L8:
        int r4 = this.mSwitchTop;
        int r5 = this.mSwitchBottom;
        int r6 = r4 + r0.top;
        int r7 = r5 - r0.bottom;
        Drawable r8 = this.mThumbDrawable;
        if (r1 != null) goto L11;
    L15:
        int r9 = r10.save();
        if (r8 == null) goto L20;
        r8.draw(r10);
    L20:
        if (getTargetCheckedState() == false) goto L22;
        Layout r11 = this.mOnLayout;
    L23:
        if (r11 == null) goto L32;
        int[] r12 = getDrawableState();
        ColorStateList r13 = this.mTextColors;
        if (r13 == null) goto L27;
        TextPaint r14 = this.mTextPaint;
        o.a(r13);
        r14.setColor(r13.getColorForState(r12, 0));
    L27:
        this.mTextPaint.drawableState = r12;
        if (r8 == null) goto L30;
        Rect r15 = r8.getBounds();
        o.c(r15, "thumbDrawable.bounds");
        int r16 = r15.left + r15.right;
    L31:
        r10.translate((r16 / 2) - (r11.getWidth() / 2), ((r6 + r7) / 2) - (r11.getHeight() / 2));
        r11.draw(r10);
        goto L32
    L30:
        r16 = getWidth();
    L32:
        r10.restoreToCount(r9);
        return;
    L22:
        r11 = this.mOffLayout;
        goto L23
    L11:
        if (this.mSplitTrack == false) goto L14;
        if (r8 == null) goto L14;
        Rect r17 = q.a(r8);
        r8.copyBounds(r0);
        r0.left += r17.left;
        r0.right -= r17.right;
        int r18 = r10.save();
        r10.clipRect(r0, Region.Op.DIFFERENCE);
        r1.draw(r10);
        r10.restoreToCount(r18);
    L14:
        r1.draw(r10);
        goto L15
    L5:
        r2 = Boolean.valueOf(r1.getPadding(r0));
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ac.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == false) goto L5;
        int r0 = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ac.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == true) goto L5;
        int r0 = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingRight();
    }

    private final int getThumbOffset() {
        if (ac.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) == false) goto L5;
        float r0 = 1 - this.mThumbPosition;
    L7:
        return (int) ((r0 * getThumbScrollRange()) + 0.5f);
    L5:
        r0 = this.mThumbPosition;
        goto L7
    }

    private final int getThumbScrollRange() {
        Drawable r0 = this.mTrackDrawable;
        if (r0 == null) goto L9;
        Rect r1 = this.mTempRect;
        o.a(r0);
        r0.getPadding(r1);
        Drawable r2 = this.mThumbDrawable;
        if (r2 == null) goto L7;
        Rect r3 = q.a(r2);
        o.c(r3, "{\n                Drawab…mbDrawable)\n            }");
    L11:
        return ((((((this.mSwitchWidth - this.mThumbWidth) - r1.left) - r1.right) - r3.left) - r3.right) - this.mThumbConstraintRight) - this.mThumbConstraintLeft;
    L7:
        r3 = q.f468a;
        o.c(r3, "{\n                Drawab…INSETS_NONE\n            }");
        goto L11
    L9:
        return 0;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r1) {
        int[] r2 = super.onCreateDrawableState(r1 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r2, CHECKED_STATE_SET);
    L5:
        o.c(r2, "drawableState");
        return r2;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.mThumbDrawable;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        Drawable r3 = this.mTrackDrawable;
        if (r3 != null) goto L10;
    L12:
        if (r2 == false) goto L15;
        invalidate();
        return;
    L15:
        return;
    L10:
        if (r3.isStateful() == false) goto L12;
        r2 = r2 | r3.setState(r0);
        goto L12
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = false | r1.setState(r0);
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.drawableHotspotChanged(r3, r4);
    L5:
        Drawable r0 = this.mThumbDrawable;
        if (r0 == null) goto L8;
        o.a(r0);
        androidx.core.graphics.drawable.a.a(r0, r3, r4);
    L8:
        Drawable r2 = this.mTrackDrawable;
        if (r2 == null) goto L12;
        o.a(r2);
        androidx.core.graphics.drawable.a.a(r2, r3, r4);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r2) {
        o.e(r2, "who");
        if (super.verifyDrawable(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2 == this.mThumbDrawable) goto L10;
        if (r2 == this.mTrackDrawable) goto L10;
        return false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r0 = this.mThumbDrawable;
        if (r0 == null) goto L5;
        o.a(r0);
        r0.jumpToCurrentState();
    L5:
        Drawable r1 = this.mTrackDrawable;
        if (r1 == null) goto L8;
        o.a(r1);
        r1.jumpToCurrentState();
    L8:
        ObjectAnimator r2 = this.mPositionAnimator;
        if (r2 == null) goto L14;
        o.a(r2);
        if (r2.isStarted() == false) goto L15;
        ObjectAnimator r3 = this.mPositionAnimator;
        o.a(r3);
        r3.end();
        this.mPositionAnimator = null;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r3) {
        o.e(r3, "event");
        super.onInitializeAccessibilityEvent(r3);
        r3.setClassName((CharSequence) ZeusTransformUtils.preCheckCast(ACCESSIBILITY_EVENT_CLASS_NAME, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        o.e(r5, DBDefinition.SEGMENT_INFO);
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName((CharSequence) ZeusTransformUtils.preCheckCast(ACCESSIBILITY_EVENT_CLASS_NAME, CharSequence.class, "com.obric.aiagent.plugin"));
        if (isChecked() == false) goto L5;
        CharSequence r4 = this.mTextOn;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L13;
        CharSequence r0 = r5.getText();
        if (TextUtils.isEmpty(r0) == false) goto L11;
        r5.setText(r4);
        return;
    L11:
        StringBuilder r1 = new StringBuilder();
        r1.append(r0).append(' ').append(r4);
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        return;
    L5:
        r4 = this.mTextOff;
        goto L7
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r3) {
        ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
        o.e(r4, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(TextViewCompat.a((TextView) ZeusTransformUtils.preCheckCast(this, TextView.class, "com.obric.aiagent.plugin"), r4));
    }

    static {
        Companion = new a(null);
        final Class r0 = Float.TYPE;
        THUMB_POS = (Property) ZeusTransformUtils.preCheckCast(new SwitchCompat$Companion$THUMB_POS$1(r0), Property.class, "com.obric.aiagent.plugin");
        CHECKED_STATE_SET = new int[]{android.R.attr.state_checked};
    }
}
