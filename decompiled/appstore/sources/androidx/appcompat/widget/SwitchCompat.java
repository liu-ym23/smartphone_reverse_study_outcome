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
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton implements EmojiCompatConfigurationView {
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

    @NonNull
    private h mAppCompatEmojiTextHelper;

    @Nullable
    private c mEmojiCompatInitCallback;
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

    @Nullable
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private final o mTextHelper;
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

    public class a extends Property {
        public a(Class r10, String r11) {
            super(r10, r11);
        }

        public Float a(SwitchCompat r10) {
            return Float.valueOf(r10.mThumbPosition);
        }

        public void b(SwitchCompat r10, Float r11) {
            r10.setThumbPosition(r11.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((SwitchCompat) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((SwitchCompat) r10, (Float) r11);
        }
    }

    public static class b {
        @DoNotInline
        public static void a(ObjectAnimator r10, boolean r11) {
            r10.setAutoCancel(r11);
        }
    }

    public static class c extends EmojiCompat.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference f944a;

        public c(SwitchCompat r10) {
            this.f944a = new WeakReference(r10);
        }

        @Override // androidx.emoji2.text.EmojiCompat.d
        public void a(Throwable r10) {
            SwitchCompat r11 = (SwitchCompat) this.f944a.get();
            if (r11 == null) goto L6;
            r11.onEmojiCompatInitializedForSwitchText();
            return;
        }

        @Override // androidx.emoji2.text.EmojiCompat.d
        public void b() {
            SwitchCompat r10 = (SwitchCompat) this.f944a.get();
            if (r10 == null) goto L6;
            r10.onEmojiCompatInitializedForSwitchText();
            return;
        }
    }

    static {
        THUMB_POS = new a(Float.class, "thumbPos");
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public SwitchCompat(@NonNull Context r10) {
        this(r10, null);
    }

    private void cancelSuperTouch(MotionEvent r10) {
        MotionEvent r11 = MotionEvent.obtain(r10);
        r11.setAction(3);
        super.onTouchEvent(r11);
        r11.recycle();
    }

    public static float e(float r10, float r11, float r12) {
        if (r10 >= r11) goto L6;
        return r11;
    L6:
        if (r10 > r12) goto L8;
        return r10;
    L8:
        return r12;
    }

    @NonNull
    private h getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper != null) goto L6;
        this.mAppCompatEmojiTextHelper = new h(this);
    L6:
        return this.mAppCompatEmojiTextHelper;
    }

    private boolean getTargetCheckedState() {
        if (this.mThumbPosition <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private int getThumbOffset() {
        if (i0.b(this) == false) goto L5;
        float r10 = 1.0f - this.mThumbPosition;
    L7:
        return (int) ((r10 * getThumbScrollRange()) + 0.5f);
    L5:
        r10 = this.mThumbPosition;
        goto L7
    }

    private int getThumbScrollRange() {
        Drawable r10 = this.mTrackDrawable;
        if (r10 == null) goto L10;
        Rect r11 = this.mTempRect;
        r10.getPadding(r11);
        Drawable r12 = this.mThumbDrawable;
        if (r12 == null) goto L7;
        Rect r13 = r.d(r12);
    L9:
        return ((((this.mSwitchWidth - this.mThumbWidth) - r11.left) - r11.right) - r13.left) - r13.right;
    L7:
        r13 = r.f1087c;
        goto L9
    L10:
        return 0;
    }

    private void setTextOffInternal(CharSequence r10) {
        this.mTextOff = r10;
        this.mTextOffTransformed = f(r10);
        this.mOffLayout = null;
        if (this.mShowText == false) goto L6;
        l();
        return;
    }

    private void setTextOnInternal(CharSequence r10) {
        this.mTextOn = r10;
        this.mTextOnTransformed = f(r10);
        this.mOnLayout = null;
        if (this.mShowText == false) goto L6;
        l();
        return;
    }

    private void stopDrag(MotionEvent r10) {
        this.mTouchMode = 0;
        boolean r11 = true;
        if (r10.getAction() == 1) goto L5;
    L7:
        boolean r12 = false;
    L8:
        boolean r13 = isChecked();
        if (r12 == false) goto L22;
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float r14 = this.mVelocityTracker.getXVelocity();
        if (Math.abs(r14) > this.mMinFlingVelocity) goto L13;
        r11 = getTargetCheckedState();
    L23:
        if (r11 == r13) goto L25;
        playSoundEffect(0);
    L25:
        setChecked(r11);
        cancelSuperTouch(r10);
        return;
    L13:
        if (i0.b(this) == false) goto L19;
        if (r14 < 0.0f) goto L23;
    L17:
        r11 = false;
        goto L23
    L19:
        if (r14 <= 0.0f) goto L17;
    L22:
        r11 = r13;
        goto L23
    L5:
        if (isEnabled() == false) goto L7;
        r12 = true;
        goto L8
    }

    public final void a(boolean r10) {
        if (r10 == false) goto L5;
        float r11 = 1.0f;
    L6:
        ObjectAnimator r12 = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{r11});
        this.mPositionAnimator = r12;
        r12.setDuration(250);
        b.a(this.mPositionAnimator, true);
        this.mPositionAnimator.start();
        return;
    L5:
        r11 = 0.0f;
        goto L6
    }

    public final void b() {
        Drawable r10 = this.mThumbDrawable;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mHasThumbTint == false) goto L7;
    L8:
        Drawable r11 = o.a.l(r10).mutate();
        this.mThumbDrawable = r11;
        if (this.mHasThumbTint == false) goto L12;
        o.a.i(r11, this.mThumbTintList);
    L12:
        if (this.mHasThumbTintMode == false) goto L15;
        o.a.j(this.mThumbDrawable, this.mThumbTintMode);
    L15:
        if (this.mThumbDrawable.isStateful() == false) goto L20;
        this.mThumbDrawable.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasThumbTintMode == true) goto L8;
    }

    public final void c() {
        Drawable r10 = this.mTrackDrawable;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mHasTrackTint == false) goto L7;
    L8:
        Drawable r11 = o.a.l(r10).mutate();
        this.mTrackDrawable = r11;
        if (this.mHasTrackTint == false) goto L12;
        o.a.i(r11, this.mTrackTintList);
    L12:
        if (this.mHasTrackTintMode == false) goto L15;
        o.a.j(this.mTrackDrawable, this.mTrackTintMode);
    L15:
        if (this.mTrackDrawable.isStateful() == false) goto L20;
        this.mTrackDrawable.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasTrackTintMode == true) goto L8;
    }

    public final void d() {
        ObjectAnimator r10 = this.mPositionAnimator;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r11) {
        Rect r10 = this.mTempRect;
        int r12 = this.mSwitchLeft;
        int r13 = this.mSwitchTop;
        int r14 = this.mSwitchRight;
        int r15 = this.mSwitchBottom;
        int r16 = getThumbOffset() + r12;
        Drawable r17 = this.mThumbDrawable;
        if (r17 == null) goto L5;
        Rect r18 = r.d(r17);
    L6:
        Drawable r19 = this.mTrackDrawable;
        if (r19 == null) goto L26;
        r19.getPadding(r10);
        int r20 = r10.left;
        r16 = r16 + r20;
        if (r18 == null) goto L24;
        int r21 = r18.left;
        if (r21 <= r20) goto L13;
        r12 = r12 + (r21 - r20);
    L13:
        int r22 = r18.top;
        int r23 = r10.top;
        if (r22 <= r23) goto L16;
        int r24 = (r22 - r23) + r13;
    L17:
        int r25 = r18.right;
        int r26 = r10.right;
        if (r25 <= r26) goto L20;
        r14 = r14 - (r25 - r26);
    L20:
        int r27 = r18.bottom;
        int r28 = r10.bottom;
        if (r27 <= r28) goto L23;
        int r29 = r15 - (r27 - r28);
    L25:
        this.mTrackDrawable.setBounds(r12, r24, r14, r29);
    L23:
        r29 = r15;
        goto L25
    L16:
        r24 = r13;
        goto L17
    L24:
        r24 = r13;
    L26:
        Drawable r30 = this.mThumbDrawable;
        if (r30 == null) goto L31;
        r30.getPadding(r10);
        int r31 = r16 - r10.left;
        int r32 = (r16 + this.mThumbWidth) + r10.right;
        this.mThumbDrawable.setBounds(r31, r13, r32, r15);
        Drawable r33 = getBackground();
        if (r33 == null) goto L31;
        o.a.f(r33, r31, r13, r32, r15);
    L31:
        super.draw(r11);
        return;
    L5:
        r18 = r.f1087c;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float r10, float r11) {
        super.drawableHotspotChanged(r10, r11);
        Drawable r12 = this.mThumbDrawable;
        if (r12 == null) goto L5;
        o.a.e(r12, r10, r11);
    L5:
        Drawable r13 = this.mTrackDrawable;
        if (r13 == null) goto L9;
        o.a.e(r13, r10, r11);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r10 = getDrawableState();
        Drawable r11 = this.mThumbDrawable;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        Drawable r13 = this.mTrackDrawable;
        if (r13 != null) goto L11;
    L13:
        if (r12 == false) goto L16;
        invalidate();
        return;
    L16:
        return;
    L11:
        if (r13.isStateful() == false) goto L13;
        r12 = r12 | r13.setState(r10);
        goto L13
    L5:
        if (r11.isStateful() == false) goto L7;
        r12 = r11.setState(r10);
        goto L8
    }

    public final CharSequence f(CharSequence r10) {
        TransformationMethod r11 = getEmojiTextViewHelper().f(this.mSwitchTransformationMethod);
        if (r11 != null) goto L5;
        return r10;
    L5:
        return r11.getTransformation(r10, this);
    }

    public final boolean g(float r10, float r11) {
        if (this.mThumbDrawable != null) goto L5;
        return false;
    L5:
        int r12 = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int r13 = this.mSwitchTop;
        int r14 = this.mTouchSlop;
        int r15 = r13 - r14;
        int r16 = (this.mSwitchLeft + r12) - r14;
        int r17 = this.mThumbWidth + r16;
        Rect r18 = this.mTempRect;
        int r19 = ((r17 + r18.left) + r18.right) + r14;
        int r20 = this.mSwitchBottom + r14;
        if (r10 > r16) goto L8;
        return false;
    L8:
        if (r10 < r19) goto L10;
        return false;
    L10:
        if (r11 > r15) goto L12;
        return false;
    L12:
        if (r11 >= r20) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (i0.b(this) == false) goto L5;
        int r10 = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r10;
    L9:
        return r10 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (i0.b(this) == true) goto L5;
        int r10 = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r10;
    L9:
        return r10 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingRight();
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.p(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getThumbPosition() {
        return this.mThumbPosition;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    public final Layout h(CharSequence r10) {
        TextPaint r11 = this.mTextPaint;
        if (r10 == null) goto L6;
        int r12 = (int) Math.ceil(Layout.getDesiredWidth(r10, r11));
    L8:
        return new StaticLayout(r10, r11, r12, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    L6:
        r12 = 0;
        goto L8
    }

    public final void i() {
        CharSequence r10 = this.mTextOff;
        if (r10 != null) goto L5;
        r10 = getResources().getString(R$string.abc_capital_off);
    L5:
        ViewCompat.G0(this, r10);
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    public final void j() {
        CharSequence r10 = this.mTextOn;
        if (r10 != null) goto L5;
        r10 = getResources().getString(R$string.abc_capital_on);
    L5:
        ViewCompat.G0(this, r10);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r10 = this.mThumbDrawable;
        if (r10 == null) goto L5;
        r10.jumpToCurrentState();
    L5:
        Drawable r11 = this.mTrackDrawable;
        if (r11 == null) goto L8;
        r11.jumpToCurrentState();
    L8:
        ObjectAnimator r12 = this.mPositionAnimator;
        if (r12 != null) goto L11;
        return;
    L11:
        if (r12.isStarted() == false) goto L15;
        this.mPositionAnimator.end();
        this.mPositionAnimator = null;
        return;
    }

    public final void k(int r10, int r11) {
        if (r10 != 1) goto L5;
        Typeface r12 = Typeface.SANS_SERIF;
    L12:
        setSwitchTypeface(r12, r11);
        return;
    L5:
        if (r10 != 2) goto L7;
        r12 = Typeface.SERIF;
        goto L12
    L7:
        if (r10 == 3) goto L9;
        r12 = null;
        goto L12
    L9:
        r12 = Typeface.MONOSPACE;
        goto L12
    }

    public final void l() {
        if (this.mEmojiCompatInitCallback == null) goto L5;
        return;
    L5:
        if (this.mAppCompatEmojiTextHelper.b() == true) goto L8;
        return;
    L8:
        if (EmojiCompat.h() == false) goto L15;
        EmojiCompat r10 = EmojiCompat.b();
        int r11 = r10.d();
        if (r11 == 3) goto L12;
        if (r11 == 0) goto L12;
        return;
    L12:
        c r12 = new c(this);
        this.mEmojiCompatInitCallback = r12;
        r10.s(r12);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 1);
        if (isChecked() == false) goto L5;
        CompoundButton.mergeDrawableStates(r11, CHECKED_STATE_SET);
    L5:
        return r11;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        Rect r11 = this.mTempRect;
        Drawable r12 = this.mTrackDrawable;
        if (r12 == null) goto L5;
        r12.getPadding(r11);
    L6:
        int r13 = this.mSwitchTop;
        int r14 = this.mSwitchBottom;
        int r15 = r13 + r11.top;
        int r16 = r14 - r11.bottom;
        Drawable r17 = this.mThumbDrawable;
        if (r12 != null) goto L9;
    L13:
        int r18 = r10.save();
        if (r17 == null) goto L17;
        r17.draw(r10);
    L17:
        if (getTargetCheckedState() == false) goto L19;
        Layout r19 = this.mOnLayout;
    L20:
        if (r19 == null) goto L29;
        int[] r20 = getDrawableState();
        ColorStateList r21 = this.mTextColors;
        if (r21 == null) goto L24;
        this.mTextPaint.setColor(r21.getColorForState(r20, 0));
    L24:
        this.mTextPaint.drawableState = r20;
        if (r17 == null) goto L27;
        Rect r22 = r17.getBounds();
        int r23 = r22.left + r22.right;
    L28:
        r10.translate((r23 / 2) - (r19.getWidth() / 2), ((r15 + r16) / 2) - (r19.getHeight() / 2));
        r19.draw(r10);
        goto L29
    L27:
        r23 = getWidth();
    L29:
        r10.restoreToCount(r18);
        return;
    L19:
        r19 = this.mOffLayout;
        goto L20
    L9:
        if (this.mSplitTrack == false) goto L12;
        if (r17 == null) goto L12;
        Rect r24 = r.d(r17);
        r17.copyBounds(r11);
        r11.left += r24.left;
        r11.right -= r24.right;
        int r25 = r10.save();
        r10.clipRect(r11, Region.Op.DIFFERENCE);
        r12.draw(r10);
        r10.restoreToCount(r25);
    L12:
        r12.draw(r10);
        goto L13
    L5:
        r11.setEmpty();
        goto L6
    }

    public void onEmojiCompatInitializedForSwitchText() {
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        int r15 = 0;
        if (this.mThumbDrawable == null) goto L9;
        Rect r16 = this.mTempRect;
        Drawable r17 = this.mTrackDrawable;
        if (r17 == null) goto L7;
        r17.getPadding(r16);
    L8:
        Rect r18 = r.d(this.mThumbDrawable);
        int r19 = Math.max(0, r18.left - r16.left);
        r15 = Math.max(0, r18.right - r16.right);
    L11:
        if (i0.b(this) == false) goto L13;
        int r20 = getPaddingLeft() + r19;
        int r21 = ((this.mSwitchWidth + r20) - r19) - r15;
    L14:
        int r22 = getGravity() & 112;
        if (r22 != 16) goto L17;
        int r23 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r24 = this.mSwitchHeight;
        int r25 = r23 - (r24 / 2);
    L19:
        int r26 = r24 + r25;
    L22:
        this.mSwitchLeft = r20;
        this.mSwitchTop = r25;
        this.mSwitchBottom = r26;
        this.mSwitchRight = r21;
        return;
    L17:
        if (r22 == 80) goto L20;
        r25 = getPaddingTop();
        r24 = this.mSwitchHeight;
        goto L19
    L20:
        r26 = getHeight() - getPaddingBottom();
        r25 = r26 - this.mSwitchHeight;
        goto L22
    L13:
        r21 = (getWidth() - getPaddingRight()) - r15;
        r20 = ((r21 - this.mSwitchWidth) + r19) + r15;
        goto L14
    L7:
        r16.setEmpty();
        goto L8
    L9:
        r19 = 0;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.mShowText == true) goto L5;
    L10:
        Rect r12 = this.mTempRect;
        Drawable r13 = this.mThumbDrawable;
        int r14 = 0;
        if (r13 == null) goto L13;
        r13.getPadding(r12);
        int r15 = (this.mThumbDrawable.getIntrinsicWidth() - r12.left) - r12.right;
        int r16 = this.mThumbDrawable.getIntrinsicHeight();
    L15:
        if (this.mShowText == false) goto L17;
        int r17 = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + (this.mThumbTextPadding * 2);
    L18:
        this.mThumbWidth = Math.max(r17, r15);
        Drawable r18 = this.mTrackDrawable;
        if (r18 == null) goto L21;
        r18.getPadding(r12);
        r14 = this.mTrackDrawable.getIntrinsicHeight();
    L22:
        int r19 = r12.left;
        int r20 = r12.right;
        Drawable r21 = this.mThumbDrawable;
        if (r21 == null) goto L26;
        Rect r22 = r.d(r21);
        r19 = Math.max(r19, r22.left);
        r20 = Math.max(r20, r22.right);
    L26:
        if (this.mEnforceSwitchWidth == false) goto L28;
        int r23 = Math.max(this.mSwitchMinWidth, ((this.mThumbWidth * 2) + r19) + r20);
    L29:
        int r24 = Math.max(r14, r16);
        this.mSwitchWidth = r23;
        this.mSwitchHeight = r24;
        super.onMeasure(r10, r11);
        if (getMeasuredHeight() >= r24) goto L33;
        setMeasuredDimension(getMeasuredWidthAndState(), r24);
        return;
    L33:
        return;
    L28:
        r23 = this.mSwitchMinWidth;
        goto L29
    L21:
        r12.setEmpty();
        goto L22
    L17:
        r17 = 0;
        goto L18
    L13:
        r15 = 0;
        r16 = 0;
        goto L15
    L5:
        if (this.mOnLayout != null) goto L8;
        this.mOnLayout = h(this.mTextOnTransformed);
    L8:
        if (this.mOffLayout != null) goto L10;
        this.mOffLayout = h(this.mTextOffTransformed);
        goto L10
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent r10) {
        super.onPopulateAccessibilityEvent(r10);
        if (isChecked() == false) goto L5;
        CharSequence r11 = this.mTextOn;
    L6:
        if (r11 == null) goto L9;
        r10.getText().add(r11);
        return;
    L9:
        return;
    L5:
        r11 = this.mTextOff;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        this.mVelocityTracker.addMovement(r10);
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L5;
        float r12 = r10.getX();
        float r13 = r10.getY();
        if (isEnabled() == true) goto L42;
    L45:
        return super.onTouchEvent(r10);
    L42:
        if (g(r12, r13) == false) goto L45;
        this.mTouchMode = 1;
        this.mTouchX = r12;
        this.mTouchY = r13;
        goto L45
    L5:
        if (r11 == 1) goto L35;
        if (r11 != 2) goto L8;
        int r14 = this.mTouchMode;
        if (r14 == 1) goto L28;
        if (r14 != 2) goto L45;
        float r15 = r10.getX();
        int r16 = getThumbScrollRange();
        float r17 = r15 - this.mTouchX;
        if (r16 == 0) goto L18;
        float r18 = r17 / r16;
    L22:
        if (i0.b(this) == false) goto L24;
        r18 = -r18;
    L24:
        float r19 = e(this.mThumbPosition + r18, 0.0f, 1.0f);
        if (r19 == this.mThumbPosition) goto L27;
        this.mTouchX = r15;
        setThumbPosition(r19);
    L27:
        return true;
    L18:
        if (r17 <= 0.0f) goto L20;
        r18 = 1.0f;
        goto L22
    L20:
        r18 = -1.0f;
        goto L22
    L28:
        float r20 = r10.getX();
        float r21 = r10.getY();
        if (Math.abs(r20 - this.mTouchX) <= this.mTouchSlop) goto L31;
    L32:
        this.mTouchMode = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.mTouchX = r20;
        this.mTouchY = r21;
        return true;
    L31:
        if (Math.abs(r21 - this.mTouchY) <= this.mTouchSlop) goto L45;
    L8:
        if (r11 != 3) goto L45;
    L35:
        if (this.mTouchMode != 2) goto L38;
        stopDrag(r10);
        super.onTouchEvent(r10);
        return true;
    L38:
        this.mTouchMode = 0;
        this.mVelocityTracker.clear();
        goto L45
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r10) {
        super.setAllCaps(r10);
        getEmojiTextViewHelper().d(r10);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        super.setChecked(r10);
        boolean r11 = isChecked();
        if (r11 == false) goto L5;
        j();
    L7:
        if (getWindowToken() != null) goto L9;
    L11:
        d();
        if (r11 == false) goto L14;
        float r12 = 1.0f;
    L15:
        setThumbPosition(r12);
        return;
    L14:
        r12 = 0.0f;
        goto L15
    L9:
        if (ViewCompat.T(this) == false) goto L11;
        a(r11);
        return;
    L5:
        i();
        goto L7
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback r10) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.q(this, r10));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r10) {
        getEmojiTextViewHelper().e(r10);
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean r10) {
        this.mEnforceSwitchWidth = r10;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] r10) {
        super.setFilters(getEmojiTextViewHelper().a(r10));
    }

    public void setShowText(boolean r10) {
        if (this.mShowText == r10) goto L8;
        this.mShowText = r10;
        requestLayout();
        if (r10 == false) goto L9;
        l();
        return;
    L9:
        return;
    }

    public void setSplitTrack(boolean r10) {
        this.mSplitTrack = r10;
        invalidate();
    }

    public void setSwitchMinWidth(int r10) {
        this.mSwitchMinWidth = r10;
        requestLayout();
    }

    public void setSwitchPadding(int r10) {
        this.mSwitchPadding = r10;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context r10, int r11) {
        b0 r12 = b0.t(r10, r11, R$styleable.TextAppearance);
        ColorStateList r13 = r12.c(R$styleable.TextAppearance_android_textColor);
        if (r13 == null) goto L5;
        this.mTextColors = r13;
    L6:
        int r14 = r12.f(R$styleable.TextAppearance_android_textSize, 0);
        if (r14 == 0) goto L11;
        float r15 = r14;
        if (r15 == this.mTextPaint.getTextSize()) goto L11;
        this.mTextPaint.setTextSize(r15);
        requestLayout();
    L11:
        k(r12.k(R$styleable.TextAppearance_android_typeface, -1), r12.k(R$styleable.TextAppearance_android_textStyle, -1));
        if (r12.a(R$styleable.TextAppearance_textAllCaps, false) == false) goto L14;
        this.mSwitchTransformationMethod = new f.a(getContext());
    L15:
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        r12.w();
        return;
    L14:
        this.mSwitchTransformationMethod = null;
        goto L15
    L5:
        this.mTextColors = getTextColors();
        goto L6
    }

    public void setSwitchTypeface(Typeface r10, int r11) {
        float r12 = 0.0f;
        boolean r13 = false;
        if (r11 <= 0) goto L18;
        if (r10 != null) goto L6;
        Typeface r14 = Typeface.defaultFromStyle(r11);
    L7:
        setSwitchTypeface(r14);
        if (r14 == null) goto L10;
        int r15 = r14.getStyle();
    L11:
        int r16 = (~r15) & r11;
        TextPaint r17 = this.mTextPaint;
        if ((r16 & 1) == 0) goto L14;
        r13 = true;
    L14:
        r17.setFakeBoldText(r13);
        TextPaint r18 = this.mTextPaint;
        if ((r16 & 2) == 0) goto L17;
        r12 = -0.25f;
    L17:
        r18.setTextSkewX(r12);
        return;
    L10:
        r15 = 0;
        goto L11
    L6:
        r14 = Typeface.create(r10, r11);
        goto L7
    L18:
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(r10);
    }

    public void setTextOff(CharSequence r10) {
        setTextOffInternal(r10);
        requestLayout();
        if (isChecked() == true) goto L6;
        i();
        return;
    }

    public void setTextOn(CharSequence r10) {
        setTextOnInternal(r10);
        requestLayout();
        if (isChecked() == false) goto L6;
        j();
        return;
    }

    public void setThumbDrawable(Drawable r10) {
        Drawable r11 = this.mThumbDrawable;
        if (r11 == null) goto L5;
        r11.setCallback(null);
    L5:
        this.mThumbDrawable = r10;
        if (r10 == null) goto L8;
        r10.setCallback(this);
    L8:
        requestLayout();
    }

    public void setThumbPosition(float r10) {
        this.mThumbPosition = r10;
        invalidate();
    }

    public void setThumbResource(int r10) {
        setThumbDrawable(c.a.b(getContext(), r10));
    }

    public void setThumbTextPadding(int r10) {
        this.mThumbTextPadding = r10;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList r10) {
        this.mThumbTintList = r10;
        this.mHasThumbTint = true;
        b();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode r10) {
        this.mThumbTintMode = r10;
        this.mHasThumbTintMode = true;
        b();
    }

    public void setTrackDrawable(Drawable r10) {
        Drawable r11 = this.mTrackDrawable;
        if (r11 == null) goto L5;
        r11.setCallback(null);
    L5:
        this.mTrackDrawable = r10;
        if (r10 == null) goto L8;
        r10.setCallback(this);
    L8:
        requestLayout();
    }

    public void setTrackResource(int r10) {
        setTrackDrawable(c.a.b(getContext(), r10));
    }

    public void setTrackTintList(@Nullable ColorStateList r10) {
        this.mTrackTintList = r10;
        this.mHasTrackTint = true;
        c();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode r10) {
        this.mTrackTintMode = r10;
        this.mHasTrackTintMode = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r10) {
        if (super.verifyDrawable(r10) == false) goto L5;
    L10:
        return true;
    L5:
        if (r10 == this.mThumbDrawable) goto L10;
        if (r10 == this.mTrackDrawable) goto L10;
        return false;
    }

    public SwitchCompat(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.switchStyle);
    }

    public SwitchCompat(@NonNull Context r13, @Nullable AttributeSet r14, int r15) {
        super(r13, r14, r15);
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
        x.a(this, getContext());
        TextPaint r10 = new TextPaint(1);
        this.mTextPaint = r10;
        r10.density = getResources().getDisplayMetrics().density;
        int[] r11 = R$styleable.SwitchCompat;
        b0 r12 = b0.v(r13, r14, r11, r15, 0);
        ViewCompat.n0(this, r13, r11, r14, r12.r(), r15, 0);
        Drawable r16 = r12.g(R$styleable.SwitchCompat_android_thumb);
        this.mThumbDrawable = r16;
        if (r16 == null) goto L5;
        r16.setCallback(this);
    L5:
        Drawable r17 = r12.g(R$styleable.SwitchCompat_track);
        this.mTrackDrawable = r17;
        if (r17 == null) goto L8;
        r17.setCallback(this);
    L8:
        setTextOnInternal(r12.p(R$styleable.SwitchCompat_android_textOn));
        setTextOffInternal(r12.p(R$styleable.SwitchCompat_android_textOff));
        this.mShowText = r12.a(R$styleable.SwitchCompat_showText, true);
        this.mThumbTextPadding = r12.f(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.mSwitchMinWidth = r12.f(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.mSwitchPadding = r12.f(R$styleable.SwitchCompat_switchPadding, 0);
        this.mSplitTrack = r12.a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList r18 = r12.c(R$styleable.SwitchCompat_thumbTint);
        if (r18 == null) goto L11;
        this.mThumbTintList = r18;
        this.mHasThumbTint = true;
    L11:
        PorterDuff.Mode r19 = r.e(r12.k(R$styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.mThumbTintMode == r19) goto L15;
        this.mThumbTintMode = r19;
        this.mHasThumbTintMode = true;
    L15:
        if (this.mHasThumbTint == false) goto L17;
    L18:
        b();
    L19:
        ColorStateList r20 = r12.c(R$styleable.SwitchCompat_trackTint);
        if (r20 == null) goto L22;
        this.mTrackTintList = r20;
        this.mHasTrackTint = true;
    L22:
        PorterDuff.Mode r21 = r.e(r12.k(R$styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.mTrackTintMode == r21) goto L26;
        this.mTrackTintMode = r21;
        this.mHasTrackTintMode = true;
    L26:
        if (this.mHasTrackTint == false) goto L28;
    L29:
        c();
    L30:
        int r22 = r12.n(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (r22 == 0) goto L33;
        setSwitchTextAppearance(r13, r22);
    L33:
        o r23 = new o(this);
        this.mTextHelper = r23;
        r23.m(r14, r15);
        r12.w();
        ViewConfiguration r110 = ViewConfiguration.get(r13);
        this.mTouchSlop = r110.getScaledTouchSlop();
        this.mMinFlingVelocity = r110.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(r14, r15);
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L28:
        if (this.mHasTrackTintMode == false) goto L30;
    L17:
        if (this.mHasThumbTintMode == false) goto L19;
        goto L18
    }

    public void setSwitchTypeface(Typeface r10) {
        if (this.mTextPaint.getTypeface() == null) goto L7;
        if (this.mTextPaint.getTypeface().equals(r10) == true) goto L7;
    L9:
        this.mTextPaint.setTypeface(r10);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.mTextPaint.getTypeface() != null) goto L11;
        if (r10 != null) goto L9;
        return;
    }
}
