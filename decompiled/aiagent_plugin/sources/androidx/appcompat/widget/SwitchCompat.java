package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
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
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int[] CHECKED_STATE_SET = null;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final Property<SwitchCompat, Float> THUMB_POS = null;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private f mAppCompatEmojiTextHelper;
    private b mEmojiCompatInitCallback;
    private boolean mEnforceSwitchWidth;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    ObjectAnimator mPositionAnimator;
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
    private final m mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOffTransformed;
    private CharSequence mTextOn;
    private CharSequence mTextOnTransformed;
    private final TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private VelocityTracker mVelocityTracker;

    static class a {
        static void a(ObjectAnimator r0, boolean r1) {
            r0.setAutoCancel(r1);
        }
    }

    static class b extends androidx.emoji2.text.d.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference<SwitchCompat> f394a;

        b(SwitchCompat r2) {
            this.f394a = new WeakReference(r2);
        }

        @Override // androidx.emoji2.text.d.e
        public void a() {
            SwitchCompat r2 = (SwitchCompat) ZeusTransformUtils.preCheckCast(this.f394a.get(), SwitchCompat.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L6;
            r2.onEmojiCompatInitializedForSwitchText();
            return;
        }

        @Override // androidx.emoji2.text.d.e
        public void a(Throwable r2) {
            SwitchCompat r1 = (SwitchCompat) ZeusTransformUtils.preCheckCast(this.f394a.get(), SwitchCompat.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L6;
            r1.onEmojiCompatInitializedForSwitchText();
            return;
        }
    }

    private static float constrain(float r1, float r2, float r3) {
        if (r1 >= r2) goto L6;
        return r2;
    L6:
        if (r1 > r3) goto L8;
        return r1;
    L8:
        return r3;
    }

    static {
        final Class<Float> r1 = Float.class;
        final String r2 = "thumbPos";
        THUMB_POS = new AnonymousClass1(r1, r2);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public SwitchCompat(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public SwitchCompat(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.switchStyle, "attr", "switchStyle"));
    }

    public SwitchCompat(Context r12, AttributeSet r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r15, r16, r14);
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mEnforceSwitchWidth = true;
        this.mTempRect = new Rect();
        w.a(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        TextPaint r2 = new TextPaint(1);
        this.mTextPaint = r2;
        r2.density = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        y r1 = y.a(r15, r16, com.obric.aiagent.plugin.R.styleable.SwitchCompat, r14, 0);
        ViewCompat.a(this, r15, com.obric.aiagent.plugin.R.styleable.SwitchCompat, r16, r1.a(), r14, 0);
        Drawable r3 = r1.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_android_thumb, "styleable", "SwitchCompat_android_thumb"));
        this.mThumbDrawable = r3;
        if (r3 == null) goto L5;
        r3.setCallback(this);
    L5:
        Drawable r4 = r1.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_track, "styleable", "SwitchCompat_track"));
        this.mTrackDrawable = r4;
        if (r4 == null) goto L8;
        r4.setCallback(this);
    L8:
        setTextOnInternal(r1.c(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_android_textOn, "styleable", "SwitchCompat_android_textOn")));
        setTextOffInternal(r1.c(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_android_textOff, "styleable", "SwitchCompat_android_textOff")));
        this.mShowText = r1.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_showText, "styleable", "SwitchCompat_showText"), true);
        this.mThumbTextPadding = r1.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_thumbTextPadding, "styleable", "SwitchCompat_thumbTextPadding"), 0);
        this.mSwitchMinWidth = r1.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_switchMinWidth, "styleable", "SwitchCompat_switchMinWidth"), 0);
        this.mSwitchPadding = r1.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_switchPadding, "styleable", "SwitchCompat_switchPadding"), 0);
        this.mSplitTrack = r1.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_splitTrack, "styleable", "SwitchCompat_splitTrack"), false);
        ColorStateList r5 = r1.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_thumbTint, "styleable", "SwitchCompat_thumbTint"));
        if (r5 == null) goto L11;
        this.mThumbTintList = r5;
        this.mHasThumbTint = true;
    L11:
        PorterDuff.Mode r6 = q.a(r1.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_thumbTintMode, "styleable", "SwitchCompat_thumbTintMode"), -1), null);
        if (this.mThumbTintMode == r6) goto L15;
        this.mThumbTintMode = r6;
        this.mHasThumbTintMode = true;
    L15:
        if (this.mHasThumbTint == false) goto L17;
    L18:
        applyThumbTint();
    L19:
        ColorStateList r7 = r1.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_trackTint, "styleable", "SwitchCompat_trackTint"));
        if (r7 == null) goto L22;
        this.mTrackTintList = r7;
        this.mHasTrackTint = true;
    L22:
        PorterDuff.Mode r0 = q.a(r1.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_trackTintMode, "styleable", "SwitchCompat_trackTintMode"), -1), null);
        if (this.mTrackTintMode == r0) goto L26;
        this.mTrackTintMode = r0;
        this.mHasTrackTintMode = true;
    L26:
        if (this.mHasTrackTint == false) goto L28;
    L29:
        applyTrackTint();
    L30:
        int r8 = r1.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.SwitchCompat_switchTextAppearance, "styleable", "SwitchCompat_switchTextAppearance"), 0);
        if (r8 == 0) goto L33;
        setSwitchTextAppearance(r15, r8);
    L33:
        m r9 = new m(this);
        this.mTextHelper = r9;
        r9.a(r16, r14);
        r1.b();
        ViewConfiguration r17 = ViewConfiguration.get(r15);
        this.mTouchSlop = r17.getScaledTouchSlop();
        this.mMinFlingVelocity = r17.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().a(r16, r14);
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L28:
        if (this.mHasTrackTintMode == false) goto L30;
    L17:
        if (this.mHasThumbTintMode == false) goto L19;
        goto L18
    }

    public void setSwitchTextAppearance(Context r7, int r8) {
        y r9 = y.a((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), r8, com.obric.aiagent.plugin.R.styleable.TextAppearance);
        ColorStateList r10 = r9.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));
        if (r10 == null) goto L5;
        this.mTextColors = r10;
    L6:
        int r11 = r9.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), 0);
        if (r11 == 0) goto L11;
        float r12 = r11;
        if (r12 == this.mTextPaint.getTextSize()) goto L11;
        this.mTextPaint.setTextSize(r12);
        requestLayout();
    L11:
        setSwitchTypefaceByIndex(r9.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.TextAppearance_android_typeface, "styleable", "TextAppearance_android_typeface"), -1), r9.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.TextAppearance_android_textStyle, "styleable", "TextAppearance_android_textStyle"), -1));
        if (r9.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps"), false) == false) goto L14;
        this.mSwitchTransformationMethod = new AllCapsTransformationMethod((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L15:
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        r9.b();
        return;
    L14:
        this.mSwitchTransformationMethod = null;
        goto L15
    L5:
        this.mTextColors = getTextColors();
        goto L6
    }

    private void setSwitchTypefaceByIndex(int r2, int r3) {
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

    public void setSwitchTypeface(Typeface r4, int r5) {
        float r0 = 0.0f;
        boolean r1 = false;
        if (r5 <= 0) goto L18;
        if (r4 != null) goto L6;
        Typeface r6 = Typeface.defaultFromStyle(r5);
    L7:
        setSwitchTypeface(r6);
        if (r6 == null) goto L10;
        int r7 = r6.getStyle();
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
        r7 = 0;
        goto L11
    L6:
        r6 = Typeface.create(r4, r5);
        goto L7
    L18:
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(r4);
    }

    public void setSwitchTypeface(Typeface r2) {
        if (this.mTextPaint.getTypeface() == null) goto L7;
        if (this.mTextPaint.getTypeface().equals(r2) == true) goto L7;
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

    public void setSwitchPadding(int r1) {
        this.mSwitchPadding = r1;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public void setSwitchMinWidth(int r1) {
        this.mSwitchMinWidth = r1;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public void setThumbTextPadding(int r1) {
        this.mThumbTextPadding = r1;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public void setTrackDrawable(Drawable r3) {
        Drawable r0 = this.mTrackDrawable;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.mTrackDrawable = r3;
        if (r3 == null) goto L8;
        r3.setCallback(this);
    L8:
        requestLayout();
    }

    public void setTrackResource(int r4) {
        setTrackDrawable(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public void setTrackTintList(ColorStateList r1) {
        this.mTrackTintList = r1;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public void setTrackTintMode(PorterDuff.Mode r1) {
        this.mTrackTintMode = r1;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    private void applyTrackTint() {
        Drawable r0 = this.mTrackDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasTrackTint == false) goto L7;
    L8:
        Drawable r1 = androidx.core.graphics.drawable.a.g(r0).mutate();
        this.mTrackDrawable = r1;
        if (this.mHasTrackTint == false) goto L12;
        androidx.core.graphics.drawable.a.a(r1, this.mTrackTintList);
    L12:
        if (this.mHasTrackTintMode == false) goto L15;
        androidx.core.graphics.drawable.a.a(this.mTrackDrawable, this.mTrackTintMode);
    L15:
        if (this.mTrackDrawable.isStateful() == false) goto L20;
        this.mTrackDrawable.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasTrackTintMode == true) goto L8;
    }

    public void setThumbDrawable(Drawable r3) {
        Drawable r0 = this.mThumbDrawable;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.mThumbDrawable = r3;
        if (r3 == null) goto L8;
        r3.setCallback(this);
    L8:
        requestLayout();
    }

    public void setThumbResource(int r4) {
        setThumbDrawable(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public void setThumbTintList(ColorStateList r1) {
        this.mThumbTintList = r1;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public void setThumbTintMode(PorterDuff.Mode r1) {
        this.mThumbTintMode = r1;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    private void applyThumbTint() {
        Drawable r0 = this.mThumbDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasThumbTint == false) goto L7;
    L8:
        Drawable r1 = androidx.core.graphics.drawable.a.g(r0).mutate();
        this.mThumbDrawable = r1;
        if (this.mHasThumbTint == false) goto L12;
        androidx.core.graphics.drawable.a.a(r1, this.mThumbTintList);
    L12:
        if (this.mHasThumbTintMode == false) goto L15;
        androidx.core.graphics.drawable.a.a(this.mThumbDrawable, this.mThumbTintMode);
    L15:
        if (this.mThumbDrawable.isStateful() == false) goto L20;
        this.mThumbDrawable.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasThumbTintMode == true) goto L8;
    }

    public void setSplitTrack(boolean r1) {
        this.mSplitTrack = r1;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    private void setTextOnInternal(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.mTextOn = r4;
        this.mTextOnTransformed = doTransformForOnOffText(r4);
        this.mOnLayout = null;
        if (this.mShowText == false) goto L6;
        setupEmojiCompatLoadCallback();
        return;
    }

    public void setTextOn(CharSequence r3) {
        setTextOnInternal((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        requestLayout();
        if (isChecked() == false) goto L6;
        setOnStateDescriptionOnRAndAbove();
        return;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    private void setTextOffInternal(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.mTextOff = r4;
        this.mTextOffTransformed = doTransformForOnOffText(r4);
        this.mOffLayout = null;
        if (this.mShowText == false) goto L6;
        setupEmojiCompatLoadCallback();
        return;
    }

    public void setTextOff(CharSequence r3) {
        setTextOffInternal((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        requestLayout();
        if (isChecked() == true) goto L6;
        setOffStateDescriptionOnRAndAbove();
        return;
    }

    private CharSequence doTransformForOnOffText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        TransformationMethod r0 = getEmojiTextViewHelper().a(this.mSwitchTransformationMethod);
        if (r0 != null) goto L5;
        return r4;
    L5:
        return r0.getTransformation(r4, this);
    }

    public void setShowText(boolean r2) {
        if (this.mShowText == r2) goto L8;
        this.mShowText = r2;
        requestLayout();
        if (r2 == false) goto L9;
        setupEmojiCompatLoadCallback();
        return;
    L9:
        return;
    }

    public boolean getShowText() {
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
        r1.getPadding(r0);
        int r3 = (this.mThumbDrawable.getIntrinsicWidth() - r0.left) - r0.right;
        int r4 = this.mThumbDrawable.getIntrinsicHeight();
    L15:
        if (this.mShowText == false) goto L17;
        int r5 = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + (this.mThumbTextPadding * 2);
    L18:
        this.mThumbWidth = Math.max(r5, r3);
        Drawable r6 = this.mTrackDrawable;
        if (r6 == null) goto L21;
        r6.getPadding(r0);
        r2 = this.mTrackDrawable.getIntrinsicHeight();
    L22:
        int r9 = r0.left;
        int r10 = r0.right;
        Drawable r11 = this.mThumbDrawable;
        if (r11 == null) goto L26;
        Rect r12 = q.a(r11);
        r9 = Math.max(r9, r12.left);
        r10 = Math.max(r10, r12.right);
    L26:
        if (this.mEnforceSwitchWidth == false) goto L28;
        int r13 = Math.max(this.mSwitchMinWidth, ((this.mThumbWidth * 2) + r9) + r10);
    L29:
        int r14 = Math.max(r2, r4);
        this.mSwitchWidth = r13;
        this.mSwitchHeight = r14;
        super.onMeasure(r7, r8);
        if (getMeasuredHeight() >= r14) goto L33;
        setMeasuredDimension(getMeasuredWidthAndState(), r14);
        return;
    L33:
        return;
    L28:
        r13 = this.mSwitchMinWidth;
        goto L29
    L21:
        r0.setEmpty();
        goto L22
    L17:
        r5 = 0;
        goto L18
    L13:
        r3 = 0;
        r4 = 0;
        goto L15
    L5:
        if (this.mOnLayout != null) goto L8;
        this.mOnLayout = makeLayout(this.mTextOnTransformed);
    L8:
        if (this.mOffLayout != null) goto L10;
        this.mOffLayout = makeLayout(this.mTextOffTransformed);
        goto L10
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent r2) {
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

    private Layout makeLayout(CharSequence r9) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        TextPaint r2 = this.mTextPaint;
        if (r1 == null) goto L5;
        int r8 = (int) Math.ceil(Layout.getDesiredWidth(r1, r2));
    L7:
        return new StaticLayout(r1, r2, r8, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    L5:
        r8 = 0;
        goto L7
    }

    private boolean hitThumb(float r6, float r7) {
        if (this.mThumbDrawable != null) goto L5;
        return false;
    L5:
        int r0 = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int r2 = this.mSwitchTop;
        int r3 = this.mTouchSlop;
        int r4 = r2 - r3;
        int r5 = (this.mSwitchLeft + r0) - r3;
        int r1 = ((this.mThumbWidth + r5) + this.mTempRect.left) + this.mTempRect.right;
        int r8 = this.mTouchSlop;
        int r9 = r1 + r8;
        int r10 = this.mSwitchBottom + r8;
        if (r6 > r5) goto L8;
        return false;
    L8:
        if (r6 < r9) goto L10;
        return false;
    L10:
        if (r7 > r4) goto L12;
        return false;
    L12:
        if (r7 >= r10) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r7) {
        this.mVelocityTracker.addMovement(r7);
        int r0 = r7.getActionMasked();
        if (r0 != 0) goto L5;
        float r1 = r7.getX();
        float r2 = r7.getY();
        if (isEnabled() == true) goto L42;
    L45:
        return super.onTouchEvent(r7);
    L42:
        if (hitThumb(r1, r2) == false) goto L45;
        this.mTouchMode = 1;
        this.mTouchX = r1;
        this.mTouchY = r2;
        goto L45
    L5:
        if (r0 == 1) goto L35;
        if (r0 != 2) goto L8;
        int r3 = this.mTouchMode;
        if (r3 == 1) goto L28;
        if (r3 != 2) goto L45;
        float r8 = r7.getX();
        int r4 = getThumbScrollRange();
        float r5 = r8 - this.mTouchX;
        if (r4 == 0) goto L18;
        float r6 = r5 / r4;
    L22:
        if (ac.a(this) == false) goto L24;
        r6 = -r6;
    L24:
        float r9 = constrain(this.mThumbPosition + r6, 0.0f, 1.0f);
        if (r9 == this.mThumbPosition) goto L27;
        this.mTouchX = r8;
        setThumbPosition(r9);
    L27:
        return true;
    L18:
        if (r5 <= 0.0f) goto L20;
        r6 = 1.0f;
        goto L22
    L20:
        r6 = -1.0f;
        goto L22
    L28:
        float r10 = r7.getX();
        float r11 = r7.getY();
        if (Math.abs(r10 - this.mTouchX) <= this.mTouchSlop) goto L31;
    L32:
        this.mTouchMode = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.mTouchX = r10;
        this.mTouchY = r11;
        return true;
    L31:
        if (Math.abs(r11 - this.mTouchY) <= this.mTouchSlop) goto L45;
    L8:
        if (r0 != 3) goto L45;
    L35:
        if (this.mTouchMode != 2) goto L38;
        stopDrag(r7);
        super.onTouchEvent(r7);
        return true;
    L38:
        this.mTouchMode = 0;
        this.mVelocityTracker.clear();
        goto L45
    }

    private void cancelSuperTouch(MotionEvent r2) {
        MotionEvent r3 = MotionEvent.obtain(r2);
        r3.setAction(3);
        super.onTouchEvent(r3);
        r3.recycle();
    }

    private void stopDrag(MotionEvent r7) {
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
        if (ac.a(this) == false) goto L18;
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

    private void animateThumbToCheckedState(boolean r5) {
        if (r5 == false) goto L4;
        float r6 = 1.0f;
    L5:
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{r6});
        this.mPositionAnimator = r7;
        r7.setDuration(250);
        if (Build.VERSION.SDK_INT < 18) goto L8;
        a.a(this.mPositionAnimator, true);
    L8:
        this.mPositionAnimator.start();
        return;
    L4:
        r6 = 0.0f;
        goto L5
    }

    private void cancelPositionAnimator() {
        ObjectAnimator r0 = this.mPositionAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    private boolean getTargetCheckedState() {
        if (this.mThumbPosition <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    public final float getThumbPosition() {
        return this.mThumbPosition;
    }

    void setThumbPosition(float r1) {
        this.mThumbPosition = r1;
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        super.setChecked(r2);
        boolean r3 = isChecked();
        if (r3 == false) goto L5;
        setOnStateDescriptionOnRAndAbove();
    L7:
        if (getWindowToken() != null) goto L9;
    L11:
        cancelPositionAnimator();
        if (r3 == false) goto L14;
        float r4 = 1.0f;
    L15:
        setThumbPosition(r4);
        return;
    L14:
        r4 = 0.0f;
        goto L15
    L9:
        if (ViewCompat.F(this) == false) goto L11;
        animateThumbToCheckedState(r3);
        return;
    L5:
        setOffStateDescriptionOnRAndAbove();
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = 0;
        if (this.mThumbDrawable == null) goto L9;
        Rect r7 = this.mTempRect;
        Drawable r8 = this.mTrackDrawable;
        if (r8 == null) goto L7;
        r8.getPadding(r7);
    L8:
        Rect r9 = q.a(this.mThumbDrawable);
        int r10 = Math.max(0, r9.left - r7.left);
        r6 = Math.max(0, r9.right - r7.right);
    L11:
        if (ac.a(this) == false) goto L13;
        int r11 = getPaddingLeft() + r10;
        int r12 = ((this.mSwitchWidth + r11) - r10) - r6;
    L14:
        int r13 = getGravity() & 112;
        if (r13 != 16) goto L17;
        int r14 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r15 = this.mSwitchHeight;
        int r16 = r14 - (r15 / 2);
    L21:
        int r17 = r15 + r16;
    L22:
        this.mSwitchLeft = r11;
        this.mSwitchTop = r16;
        this.mSwitchBottom = r17;
        this.mSwitchRight = r12;
        return;
    L17:
        if (r13 == 80) goto L19;
        r16 = getPaddingTop();
        r15 = this.mSwitchHeight;
        goto L21
    L19:
        r17 = getHeight() - getPaddingBottom();
        r16 = r17 - this.mSwitchHeight;
        goto L22
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
        r8.getPadding(r0);
        r5 = r5 + r0.left;
        if (r7 != null) goto L11;
        int r9 = r2;
    L24:
        int r10 = r4;
    L25:
        this.mTrackDrawable.setBounds(r1, r9, r3, r10);
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
        Drawable r12 = this.mThumbDrawable;
        if (r12 == null) goto L31;
        r12.getPadding(r0);
        int r13 = r5 - r0.left;
        int r14 = (r5 + this.mThumbWidth) + r0.right;
        this.mThumbDrawable.setBounds(r13, r2, r14, r4);
        Drawable r15 = getBackground();
        if (r15 == null) goto L31;
        androidx.core.graphics.drawable.a.a(r15, r13, r2, r14, r4);
    L31:
        super.draw(r11);
        return;
    L5:
        r7 = q.f468a;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        Rect r0 = this.mTempRect;
        Drawable r1 = this.mTrackDrawable;
        if (r1 == null) goto L5;
        r1.getPadding(r0);
    L6:
        int r2 = this.mSwitchTop;
        int r3 = this.mSwitchBottom;
        int r4 = r2 + r0.top;
        int r5 = r3 - r0.bottom;
        Drawable r6 = this.mThumbDrawable;
        if (r1 != null) goto L9;
    L13:
        int r7 = r10.save();
        if (r6 == null) goto L17;
        r6.draw(r10);
    L17:
        if (getTargetCheckedState() == false) goto L19;
        Layout r8 = this.mOnLayout;
    L20:
        if (r8 == null) goto L29;
        int[] r9 = getDrawableState();
        ColorStateList r11 = this.mTextColors;
        if (r11 == null) goto L24;
        this.mTextPaint.setColor(r11.getColorForState(r9, 0));
    L24:
        this.mTextPaint.drawableState = r9;
        if (r6 == null) goto L27;
        Rect r12 = r6.getBounds();
        int r13 = r12.left + r12.right;
    L28:
        r10.translate((r13 / 2) - (r8.getWidth() / 2), ((r4 + r5) / 2) - (r8.getHeight() / 2));
        r8.draw(r10);
        goto L29
    L27:
        r13 = getWidth();
    L29:
        r10.restoreToCount(r7);
        return;
    L19:
        r8 = this.mOffLayout;
        goto L20
    L9:
        if (this.mSplitTrack == false) goto L12;
        if (r6 == null) goto L12;
        Rect r14 = q.a(r6);
        r6.copyBounds(r0);
        r0.left += r14.left;
        r0.right -= r14.right;
        int r15 = r10.save();
        r10.clipRect(r0, Region.Op.DIFFERENCE);
        r1.draw(r10);
        r10.restoreToCount(r15);
    L12:
        r1.draw(r10);
        goto L13
    L5:
        r0.setEmpty();
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ac.a(this) == false) goto L5;
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
        if (ac.a(this) == true) goto L5;
        int r0 = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingRight();
    }

    private int getThumbOffset() {
        if (ac.a(this) == false) goto L5;
        float r0 = 1.0f - this.mThumbPosition;
    L7:
        return (int) ((r0 * getThumbScrollRange()) + 0.5f);
    L5:
        r0 = this.mThumbPosition;
        goto L7
    }

    private int getThumbScrollRange() {
        Drawable r0 = this.mTrackDrawable;
        if (r0 == null) goto L10;
        Rect r1 = this.mTempRect;
        r0.getPadding(r1);
        Drawable r2 = this.mThumbDrawable;
        if (r2 == null) goto L7;
        Rect r3 = q.a(r2);
    L9:
        return ((((this.mSwitchWidth - this.mThumbWidth) - r1.left) - r1.right) - r3.left) - r3.right;
    L7:
        r3 = q.f468a;
        goto L9
    L10:
        return 0;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r1) {
        int[] r2 = super.onCreateDrawableState(r1 + 1);
        if (isChecked() == false) goto L5;
        mergeDrawableStates(r2, CHECKED_STATE_SET);
    L5:
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
        androidx.core.graphics.drawable.a.a(r0, r3, r4);
    L8:
        Drawable r2 = this.mTrackDrawable;
        if (r2 == null) goto L12;
        androidx.core.graphics.drawable.a.a(r2, r3, r4);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r2) {
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
        r0.jumpToCurrentState();
    L5:
        Drawable r1 = this.mTrackDrawable;
        if (r1 == null) goto L8;
        r1.jumpToCurrentState();
    L8:
        ObjectAnimator r2 = this.mPositionAnimator;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.isStarted() == false) goto L15;
        this.mPositionAnimator.end();
        this.mPositionAnimator = null;
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r4) {
        super.onInitializeAccessibilityNodeInfo(r4);
        r4.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return;
    L5:
        if (isChecked() == false) goto L7;
        CharSequence r3 = this.mTextOn;
    L9:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        CharSequence r0 = r4.getText();
        if (TextUtils.isEmpty(r0) == false) goto L13;
        r4.setText(r3);
        return;
    L13:
        StringBuilder r1 = new StringBuilder();
        r1.append(r0).append(' ').append(r3);
        r4.setText(r1);
        return;
    L16:
        return;
    L7:
        r3 = this.mTextOff;
        goto L9
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r3) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.a(this, (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin")));
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.a(super.getCustomSelectionActionModeCallback());
    }

    public final void setEnforceSwitchWidth(boolean r1) {
        this.mEnforceSwitchWidth = r1;
        invalidate();
    }

    private void setOnStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT < 30) goto L9;
        CharSequence r0 = this.mTextOn;
        if (r0 != null) goto L7;
        r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.abc_capital_on, WsChannelMultiProcessSharedProvider.STRING_TYPE, "abc_capital_on"));
    L7:
        ViewCompat.a(this, r0);
        return;
    }

    private void setOffStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT < 30) goto L9;
        CharSequence r0 = this.mTextOff;
        if (r0 != null) goto L7;
        r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.string.abc_capital_off, WsChannelMultiProcessSharedProvider.STRING_TYPE, "abc_capital_off"));
    L7:
        ViewCompat.a(this, r0);
        return;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r1) {
        super.setAllCaps(r1);
        getEmojiTextViewHelper().b(r1);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] r2) {
        super.setFilters(getEmojiTextViewHelper().a(r2));
    }

    private f getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper != null) goto L6;
        this.mAppCompatEmojiTextHelper = new f(this);
    L6:
        return this.mAppCompatEmojiTextHelper;
    }

    public void setEmojiCompatEnabled(boolean r2) {
        getEmojiTextViewHelper().a(r2);
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().a();
    }

    private void setupEmojiCompatLoadCallback() {
        if (this.mEmojiCompatInitCallback == null) goto L5;
        return;
    L5:
        if (this.mAppCompatEmojiTextHelper.a() == true) goto L8;
        return;
    L8:
        if (androidx.emoji2.text.d.a() == false) goto L15;
        androidx.emoji2.text.d r0 = androidx.emoji2.text.d.b();
        int r1 = r0.e();
        if (r1 == 3) goto L12;
        if (r1 == 0) goto L12;
        return;
    L12:
        b r2 = new b(this);
        this.mEmojiCompatInitCallback = r2;
        r0.a(r2);
        return;
    }

    void onEmojiCompatInitializedForSwitchText() {
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }
}
