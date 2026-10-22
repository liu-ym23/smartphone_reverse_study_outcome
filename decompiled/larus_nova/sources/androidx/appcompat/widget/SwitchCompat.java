package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
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
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes2.dex */
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
    private final AppCompatTextHelper mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
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

    private static float constrain(float r100, float r101, float r102) {
        if (r100 >= r101) goto L6;
        return r101;
    L6:
        if (r100 > r102) goto L8;
        return r100;
    L8:
        return r102;
    }

    static {
        final Class<Float> r100 = Float.class;
        final String r101 = "thumbPos";
        THUMB_POS = new AnonymousClass1(r100, r101);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    private void applyThumbTint() {
        Drawable r100 = this.mThumbDrawable;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mHasThumbTint == false) goto L7;
    L8:
        Drawable r101 = DrawableCompat.wrap(r100).mutate();
        this.mThumbDrawable = r101;
        if (this.mHasThumbTint == false) goto L12;
        DrawableCompat.setTintList(r101, this.mThumbTintList);
    L12:
        if (this.mHasThumbTintMode == false) goto L15;
        DrawableCompat.setTintMode(this.mThumbDrawable, this.mThumbTintMode);
    L15:
        if (this.mThumbDrawable.isStateful() == false) goto L20;
        this.mThumbDrawable.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasThumbTintMode == true) goto L8;
    }

    private void applyTrackTint() {
        Drawable r100 = this.mTrackDrawable;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mHasTrackTint == false) goto L7;
    L8:
        Drawable r101 = DrawableCompat.wrap(r100).mutate();
        this.mTrackDrawable = r101;
        if (this.mHasTrackTint == false) goto L12;
        DrawableCompat.setTintList(r101, this.mTrackTintList);
    L12:
        if (this.mHasTrackTintMode == false) goto L15;
        DrawableCompat.setTintMode(this.mTrackDrawable, this.mTrackTintMode);
    L15:
        if (this.mTrackDrawable.isStateful() == false) goto L20;
        this.mTrackDrawable.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasTrackTintMode == true) goto L8;
    }

    private void cancelPositionAnimator() {
        ObjectAnimator r100 = this.mPositionAnimator;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    private boolean getTargetCheckedState() {
        if (this.mThumbPosition <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private int getThumbScrollRange() {
        Drawable r100 = this.mTrackDrawable;
        if (r100 == null) goto L10;
        Rect r101 = this.mTempRect;
        r100.getPadding(r101);
        Drawable r102 = this.mThumbDrawable;
        if (r102 == null) goto L7;
        Rect r103 = DrawableUtils.getOpticalBounds(r102);
    L9:
        return ((((this.mSwitchWidth - this.mThumbWidth) - r101.left) - r101.right) - r103.left) - r103.right;
    L7:
        r103 = DrawableUtils.INSETS_NONE;
        goto L9
    L10:
        return 0;
    }

    private void setOffStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT < 30) goto L9;
        CharSequence r100 = this.mTextOff;
        if (r100 != null) goto L7;
        r100 = getResources().getString(com.larus.nova.R.string.abc_capital_off);
    L7:
        ViewCompat.setStateDescription(this, r100);
        return;
    }

    private void setOnStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT < 30) goto L9;
        CharSequence r100 = this.mTextOn;
        if (r100 != null) goto L7;
        r100 = getResources().getString(com.larus.nova.R.string.abc_capital_on);
    L7:
        ViewCompat.setStateDescription(this, r100);
        return;
    }

    private int getThumbOffset() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        float r100 = 1.0f - this.mThumbPosition;
    L7:
        return (int) ((r100 * getThumbScrollRange()) + 0.5f);
    L5:
        r100 = this.mThumbPosition;
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r100 = getDrawableState();
        Drawable r101 = this.mThumbDrawable;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        Drawable r103 = this.mTrackDrawable;
        if (r103 != null) goto L10;
    L12:
        if (r102 == false) goto L15;
        invalidate();
        return;
    L15:
        return;
    L10:
        if (r103.isStateful() == false) goto L12;
        r102 = r102 | r103.setState(r100);
        goto L12
    L5:
        if (r101.isStateful() == false) goto L7;
        r102 = false | r101.setState(r100);
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        int r100 = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r100;
    L9:
        return r100 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L5;
        int r100 = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r100;
    L9:
        return r100 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingRight();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r100 = this.mThumbDrawable;
        if (r100 == null) goto L5;
        r100.jumpToCurrentState();
    L5:
        Drawable r101 = this.mTrackDrawable;
        if (r101 == null) goto L8;
        r101.jumpToCurrentState();
    L8:
        ObjectAnimator r102 = this.mPositionAnimator;
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.isStarted() == false) goto L15;
        this.mPositionAnimator.end();
        this.mPositionAnimator = null;
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
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

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    public SwitchCompat(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_SwitchCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void animateThumbToCheckedState(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = 1.0f;
    L5:
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{r101});
        this.mPositionAnimator = r102;
        r102.setDuration(250);
        this.mPositionAnimator.setAutoCancel(true);
        this.mPositionAnimator.start();
        return;
    L4:
        r101 = 0.0f;
        goto L5
    }

    private void cancelSuperTouch(MotionEvent r100) {
        MotionEvent r101 = MotionEvent.obtain(r100);
        r101.setAction(3);
        super.onTouchEvent(r101);
        r101.recycle();
    }

    private Layout makeLayout(CharSequence r100) {
        TransformationMethod r101 = this.mSwitchTransformationMethod;
        if (r101 == null) goto L5;
        r100 = r101.getTransformation(r100, this);
    L5:
        CharSequence r102 = r100;
        TextPaint r103 = this.mTextPaint;
        if (r102 == null) goto L8;
        int r104 = (int) Math.ceil(Layout.getDesiredWidth(r102, r103));
    L10:
        return new StaticLayout(r102, r103, r104, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    L8:
        r104 = 0;
        goto L10
    }

    private void stopDrag(MotionEvent r100) {
        this.mTouchMode = 0;
        boolean r101 = true;
        if (r100.getAction() == 1) goto L5;
    L7:
        boolean r102 = false;
    L8:
        boolean r103 = isChecked();
        if (r102 == false) goto L22;
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float r104 = this.mVelocityTracker.getXVelocity();
        if (Math.abs(r104) > this.mMinFlingVelocity) goto L13;
        r101 = getTargetCheckedState();
    L23:
        if (r101 == r103) goto L25;
        playSoundEffect(0);
    L25:
        setChecked(r101);
        cancelSuperTouch(r100);
        return;
    L13:
        if (ViewUtils.isLayoutRtl(this) == false) goto L18;
        if (r104 < 0.0f) goto L23;
    L20:
        r101 = false;
        goto L23
    L18:
        if (r104 <= 0.0f) goto L20;
    L22:
        r101 = r103;
        goto L23
    L5:
        if (isEnabled() == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // android.view.View
    public void draw(Canvas r110) {
        Rect r100 = this.mTempRect;
        int r101 = this.mSwitchLeft;
        int r102 = this.mSwitchTop;
        int r103 = this.mSwitchRight;
        int r104 = this.mSwitchBottom;
        int r105 = getThumbOffset() + r101;
        Drawable r106 = this.mThumbDrawable;
        if (r106 == null) goto L5;
        Rect r107 = DrawableUtils.getOpticalBounds(r106);
    L6:
        Drawable r108 = this.mTrackDrawable;
        if (r108 == null) goto L26;
        r108.getPadding(r100);
        int r109 = r100.left;
        r105 = r105 + r109;
        if (r107 == null) goto L23;
        int r111 = r107.left;
        if (r111 <= r109) goto L13;
        r101 = r101 + (r111 - r109);
    L13:
        int r112 = r107.top;
        int r113 = r100.top;
        if (r112 <= r113) goto L16;
        int r114 = (r112 - r113) + r102;
    L17:
        int r115 = r107.right;
        int r116 = r100.right;
        if (r115 <= r116) goto L20;
        r103 = r103 - (r115 - r116);
    L20:
        int r117 = r107.bottom;
        int r118 = r100.bottom;
        if (r117 <= r118) goto L24;
        int r119 = r104 - (r117 - r118);
    L25:
        this.mTrackDrawable.setBounds(r101, r114, r103, r119);
    L24:
        r119 = r104;
        goto L25
    L16:
        r114 = r102;
        goto L17
    L23:
        r114 = r102;
    L26:
        Drawable r120 = this.mThumbDrawable;
        if (r120 == null) goto L31;
        r120.getPadding(r100);
        int r121 = r105 - r100.left;
        int r122 = (r105 + this.mThumbWidth) + r100.right;
        this.mThumbDrawable.setBounds(r121, r102, r122, r104);
        Drawable r123 = getBackground();
        if (r123 == null) goto L31;
        DrawableCompat.setHotspotBounds(r123, r121, r102, r122, r104);
    L31:
        super.draw(r110);
        return;
    L5:
        r107 = DrawableUtils.INSETS_NONE;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (isChecked() == false) goto L5;
        CompoundButton.mergeDrawableStates(r101, CHECKED_STATE_SET);
    L5:
        return r101;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r110) {
        super.onDraw(r110);
        Rect r100 = this.mTempRect;
        Drawable r101 = this.mTrackDrawable;
        if (r101 == null) goto L5;
        r101.getPadding(r100);
    L6:
        int r102 = this.mSwitchTop;
        int r103 = this.mSwitchBottom;
        int r104 = r102 + r100.top;
        int r105 = r103 - r100.bottom;
        Drawable r106 = this.mThumbDrawable;
        if (r101 != null) goto L9;
    L13:
        int r107 = r110.save();
        if (r106 == null) goto L17;
        r106.draw(r110);
    L17:
        if (getTargetCheckedState() == false) goto L19;
        Layout r108 = this.mOnLayout;
    L20:
        if (r108 == null) goto L29;
        int[] r109 = getDrawableState();
        ColorStateList r111 = this.mTextColors;
        if (r111 == null) goto L24;
        this.mTextPaint.setColor(r111.getColorForState(r109, 0));
    L24:
        this.mTextPaint.drawableState = r109;
        if (r106 == null) goto L27;
        Rect r112 = r106.getBounds();
        int r113 = r112.left + r112.right;
    L28:
        r110.translate((r113 / 2) - (r108.getWidth() / 2), ((r104 + r105) / 2) - (r108.getHeight() / 2));
        r108.draw(r110);
        goto L29
    L27:
        r113 = getWidth();
    L29:
        r110.restoreToCount(r107);
        return;
    L19:
        r108 = this.mOffLayout;
        goto L20
    L9:
        if (this.mSplitTrack == false) goto L12;
        if (r106 == null) goto L12;
        Rect r114 = DrawableUtils.getOpticalBounds(r106);
        r106.copyBounds(r100);
        r100.left += r114.left;
        r100.right -= r114.right;
        int r115 = r110.save();
        r110.clipRect(r100, Region.Op.DIFFERENCE);
        r101.draw(r110);
        r110.restoreToCount(r115);
    L12:
        r101.draw(r110);
        goto L13
    L5:
        r100.setEmpty();
        goto L6
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
        super.onInitializeAccessibilityEvent(r100);
        r100.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
        super.onInitializeAccessibilityNodeInfo(r100);
        r100.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return;
    L5:
        if (isChecked() == false) goto L7;
        CharSequence r101 = this.mTextOn;
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        CharSequence r102 = r100.getText();
        if (TextUtils.isEmpty(r102) == false) goto L13;
        r100.setText(r101);
        return;
    L13:
        StringBuilder r103 = new StringBuilder();
        r103.append(r102);
        r103.append(' ');
        r103.append(r101);
        r100.setText(r103);
        return;
    L16:
        return;
    L7:
        r101 = this.mTextOff;
        goto L9
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent r100) {
        super.onPopulateAccessibilityEvent(r100);
        if (isChecked() == false) goto L5;
        CharSequence r101 = this.mTextOn;
    L6:
        if (r101 == null) goto L9;
        r100.getText().add(r101);
        return;
    L9:
        return;
    L5:
        r101 = this.mTextOff;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        this.mVelocityTracker.addMovement(r100);
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        float r102 = r100.getX();
        float r103 = r100.getY();
        if (isEnabled() == true) goto L42;
    L45:
        return super.onTouchEvent(r100);
    L42:
        if (hitThumb(r102, r103) == false) goto L45;
        this.mTouchMode = 1;
        this.mTouchX = r102;
        this.mTouchY = r103;
        goto L45
    L5:
        if (r101 == 1) goto L35;
        if (r101 != 2) goto L8;
        int r104 = this.mTouchMode;
        if (r104 == 1) goto L28;
        if (r104 != 2) goto L45;
        float r105 = r100.getX();
        int r106 = getThumbScrollRange();
        float r107 = r105 - this.mTouchX;
        if (r106 == 0) goto L18;
        float r108 = r107 / r106;
    L22:
        if (ViewUtils.isLayoutRtl(this) == false) goto L24;
        r108 = -r108;
    L24:
        float r109 = constrain(this.mThumbPosition + r108, 0.0f, 1.0f);
        if (r109 == this.mThumbPosition) goto L27;
        this.mTouchX = r105;
        setThumbPosition(r109);
    L27:
        return true;
    L18:
        if (r107 <= 0.0f) goto L20;
        r108 = 1.0f;
        goto L22
    L20:
        r108 = -1.0f;
        goto L22
    L28:
        float r110 = r100.getX();
        float r111 = r100.getY();
        if (Math.abs(r110 - this.mTouchX) <= this.mTouchSlop) goto L31;
    L32:
        this.mTouchMode = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.mTouchX = r110;
        this.mTouchY = r111;
        return true;
    L31:
        if (Math.abs(r111 - this.mTouchY) <= this.mTouchSlop) goto L45;
    L8:
        if (r101 != 3) goto L45;
    L35:
        if (this.mTouchMode != 2) goto L38;
        stopDrag(r100);
        super.onTouchEvent(r100);
        return true;
    L38:
        this.mTouchMode = 0;
        this.mVelocityTracker.clear();
        goto L45
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        super.setChecked(r100);
        boolean r101 = isChecked();
        if (r101 == false) goto L5;
        setOnStateDescriptionOnRAndAbove();
    L7:
        if (getWindowToken() != null) goto L9;
    L11:
        cancelPositionAnimator();
        if (r101 == false) goto L14;
        float r102 = 1.0f;
    L15:
        setThumbPosition(r102);
        return;
    L14:
        r102 = 0.0f;
        goto L15
    L9:
        if (ViewCompat.isLaidOut(this) == false) goto L11;
        animateThumbToCheckedState(r101);
        return;
    L5:
        setOffStateDescriptionOnRAndAbove();
        goto L7
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r100) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r100));
    }

    public void setShowText(boolean r100) {
        if (this.mShowText == r100) goto L6;
        this.mShowText = r100;
        requestLayout();
        return;
    }

    public void setSplitTrack(boolean r100) {
        this.mSplitTrack = r100;
        invalidate();
    }

    public void setSwitchMinWidth(int r100) {
        this.mSwitchMinWidth = r100;
        requestLayout();
    }

    public void setSwitchPadding(int r100) {
        this.mSwitchPadding = r100;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface r100) {
        if (this.mTextPaint.getTypeface() == null) goto L7;
        if (this.mTextPaint.getTypeface().equals(r100) == true) goto L7;
    L9:
        this.mTextPaint.setTypeface(r100);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.mTextPaint.getTypeface() != null) goto L11;
        if (r100 != null) goto L9;
        return;
    }

    public void setTextOff(CharSequence r100) {
        this.mTextOff = r100;
        requestLayout();
        if (isChecked() == true) goto L6;
        setOffStateDescriptionOnRAndAbove();
        return;
    }

    public void setTextOn(CharSequence r100) {
        this.mTextOn = r100;
        requestLayout();
        if (isChecked() == false) goto L6;
        setOnStateDescriptionOnRAndAbove();
        return;
    }

    public void setThumbDrawable(Drawable r100) {
        Drawable r101 = this.mThumbDrawable;
        if (r101 == null) goto L5;
        r101.setCallback(null);
    L5:
        this.mThumbDrawable = r100;
        if (r100 == null) goto L8;
        r100.setCallback(this);
    L8:
        requestLayout();
    }

    public void setThumbPosition(float r100) {
        this.mThumbPosition = r100;
        invalidate();
    }

    public void setThumbResource(int r100) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public void setThumbTextPadding(int r100) {
        this.mThumbTextPadding = r100;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList r100) {
        this.mThumbTintList = r100;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public void setThumbTintMode(PorterDuff.Mode r100) {
        this.mThumbTintMode = r100;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public void setTrackDrawable(Drawable r100) {
        Drawable r101 = this.mTrackDrawable;
        if (r101 == null) goto L5;
        r101.setCallback(null);
    L5:
        this.mTrackDrawable = r100;
        if (r100 == null) goto L8;
        r100.setCallback(this);
    L8:
        requestLayout();
    }

    public void setTrackResource(int r100) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r100));
    }

    public void setTrackTintList(ColorStateList r100) {
        this.mTrackTintList = r100;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public void setTrackTintMode(PorterDuff.Mode r100) {
        this.mTrackTintMode = r100;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (r100 == this.mThumbDrawable) goto L10;
        if (r100 == this.mTrackDrawable) goto L10;
        return false;
    }

    public SwitchCompat(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.switchStyle);
    }

    private boolean hitThumb(float r100, float r101) {
        if (this.mThumbDrawable != null) goto L5;
        return false;
    L5:
        int r102 = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int r103 = this.mSwitchTop;
        int r104 = this.mTouchSlop;
        int r105 = r103 - r104;
        int r106 = (this.mSwitchLeft + r102) - r104;
        int r107 = this.mThumbWidth + r106;
        Rect r108 = this.mTempRect;
        int r109 = ((r107 + r108.left) + r108.right) + r104;
        int r110 = this.mSwitchBottom + r104;
        if (r100 > r106) goto L8;
        return false;
    L8:
        if (r100 < r109) goto L10;
        return false;
    L10:
        if (r101 > r105) goto L12;
        return false;
    L12:
        if (r101 >= r110) goto L18;
        return true;
    L18:
        return false;
    }

    private void setSwitchTypefaceByIndex(int r100, int r101) {
        if (r100 != 1) goto L5;
        Typeface r102 = Typeface.SANS_SERIF;
    L12:
        setSwitchTypeface(r102, r101);
        return;
    L5:
        if (r100 != 2) goto L7;
        r102 = Typeface.SERIF;
        goto L12
    L7:
        if (r100 == 3) goto L9;
        r102 = null;
        goto L12
    L9:
        r102 = Typeface.MONOSPACE;
        goto L12
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float r100, float r101) {
        super.drawableHotspotChanged(r100, r101);
        Drawable r102 = this.mThumbDrawable;
        if (r102 == null) goto L5;
        DrawableCompat.setHotspot(r102, r100, r101);
    L5:
        Drawable r103 = this.mTrackDrawable;
        if (r103 == null) goto L9;
        DrawableCompat.setHotspot(r103, r100, r101);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.mShowText == true) goto L5;
    L10:
        Rect r102 = this.mTempRect;
        Drawable r103 = this.mThumbDrawable;
        int r104 = 0;
        if (r103 == null) goto L13;
        r103.getPadding(r102);
        int r105 = (this.mThumbDrawable.getIntrinsicWidth() - r102.left) - r102.right;
        int r106 = this.mThumbDrawable.getIntrinsicHeight();
    L15:
        if (this.mShowText == false) goto L17;
        int r107 = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + (this.mThumbTextPadding * 2);
    L18:
        this.mThumbWidth = Math.max(r107, r105);
        Drawable r108 = this.mTrackDrawable;
        if (r108 == null) goto L21;
        r108.getPadding(r102);
        r104 = this.mTrackDrawable.getIntrinsicHeight();
    L22:
        int r109 = r102.left;
        int r110 = r102.right;
        Drawable r111 = this.mThumbDrawable;
        if (r111 == null) goto L25;
        Rect r112 = DrawableUtils.getOpticalBounds(r111);
        r109 = Math.max(r109, r112.left);
        r110 = Math.max(r110, r112.right);
    L25:
        int r113 = Math.max(this.mSwitchMinWidth, ((this.mThumbWidth * 2) + r109) + r110);
        int r114 = Math.max(r104, r106);
        this.mSwitchWidth = r113;
        this.mSwitchHeight = r114;
        super.onMeasure(r100, r101);
        if (getMeasuredHeight() >= r114) goto L29;
        setMeasuredDimension(getMeasuredWidthAndState(), r114);
        return;
    L29:
        return;
    L21:
        r102.setEmpty();
        goto L22
    L17:
        r107 = 0;
        goto L18
    L13:
        r105 = 0;
        r106 = 0;
        goto L15
    L5:
        if (this.mOnLayout != null) goto L8;
        this.mOnLayout = makeLayout(this.mTextOn);
    L8:
        if (this.mOffLayout != null) goto L10;
        this.mOffLayout = makeLayout(this.mTextOff);
        goto L10
    }

    public void setSwitchTextAppearance(Context r100, int r101) {
        TintTypedArray r102 = TintTypedArray.obtainStyledAttributes(r100, r101, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        ColorStateList r103 = r102.getColorStateList(3);
        if (r103 == null) goto L5;
        this.mTextColors = r103;
    L6:
        int r104 = r102.getDimensionPixelSize(0, 0);
        if (r104 == 0) goto L11;
        float r105 = r104;
        if (r105 == this.mTextPaint.getTextSize()) goto L11;
        this.mTextPaint.setTextSize(r105);
        requestLayout();
    L11:
        setSwitchTypefaceByIndex(r102.getInt(1, -1), r102.getInt(2, -1));
        if (r102.getBoolean(14, false) == false) goto L14;
        this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
    L15:
        r102.recycle();
        return;
    L14:
        this.mSwitchTransformationMethod = null;
        goto L15
    L5:
        this.mTextColors = getTextColors();
        goto L6
    }

    public void setSwitchTypeface(Typeface r100, int r101) {
        float r102 = 0.0f;
        boolean r103 = false;
        if (r101 <= 0) goto L18;
        if (r100 != null) goto L6;
        Typeface r104 = Typeface.defaultFromStyle(r101);
    L7:
        setSwitchTypeface(r104);
        if (r104 == null) goto L10;
        int r105 = r104.getStyle();
    L11:
        int r106 = (~r105) & r101;
        TextPaint r107 = this.mTextPaint;
        if ((r106 & 1) == 0) goto L14;
        r103 = true;
    L14:
        r107.setFakeBoldText(r103);
        TextPaint r108 = this.mTextPaint;
        if ((r106 & 2) == 0) goto L17;
        r102 = -0.25f;
    L17:
        r108.setTextSkewX(r102);
        return;
    L10:
        r105 = 0;
        goto L11
    L6:
        r104 = Typeface.create(r100, r101);
        goto L7
    L18:
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(r100);
    }

    public SwitchCompat(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TextPaint r100 = new TextPaint(1);
        this.mTextPaint = r100;
        r100.density = INVOKEVIRTUAL_androidx_appcompat_widget_SwitchCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).density;
        TintTypedArray r101 = TintTypedArray.obtainStyledAttributes(r110, r111, new int[]{R.attr.textOn, R.attr.textOff, R.attr.thumb, com.larus.nova.R.attr.showText, com.larus.nova.R.attr.splitTrack, com.larus.nova.R.attr.switchMinWidth, com.larus.nova.R.attr.switchPadding, com.larus.nova.R.attr.switchTextAppearance, com.larus.nova.R.attr.thumbTextPadding, com.larus.nova.R.attr.thumbTint, com.larus.nova.R.attr.thumbTintMode, com.larus.nova.R.attr.track, com.larus.nova.R.attr.trackTint, com.larus.nova.R.attr.trackTintMode}, r112, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r110, new int[]{R.attr.textOn, R.attr.textOff, R.attr.thumb, com.larus.nova.R.attr.showText, com.larus.nova.R.attr.splitTrack, com.larus.nova.R.attr.switchMinWidth, com.larus.nova.R.attr.switchPadding, com.larus.nova.R.attr.switchTextAppearance, com.larus.nova.R.attr.thumbTextPadding, com.larus.nova.R.attr.thumbTint, com.larus.nova.R.attr.thumbTintMode, com.larus.nova.R.attr.track, com.larus.nova.R.attr.trackTint, com.larus.nova.R.attr.trackTintMode}, r111, r101.getWrappedTypeArray(), r112, 0);
        Drawable r102 = r101.getDrawable(2);
        this.mThumbDrawable = r102;
        if (r102 == null) goto L5;
        r102.setCallback(this);
    L5:
        Drawable r103 = r101.getDrawable(11);
        this.mTrackDrawable = r103;
        if (r103 == null) goto L8;
        r103.setCallback(this);
    L8:
        this.mTextOn = r101.getText(0);
        this.mTextOff = r101.getText(1);
        this.mShowText = r101.getBoolean(3, true);
        this.mThumbTextPadding = r101.getDimensionPixelSize(8, 0);
        this.mSwitchMinWidth = r101.getDimensionPixelSize(5, 0);
        this.mSwitchPadding = r101.getDimensionPixelSize(6, 0);
        this.mSplitTrack = r101.getBoolean(4, false);
        ColorStateList r104 = r101.getColorStateList(9);
        if (r104 == null) goto L11;
        this.mThumbTintList = r104;
        this.mHasThumbTint = true;
    L11:
        PorterDuff.Mode r105 = DrawableUtils.parseTintMode(r101.getInt(10, -1), null);
        if (this.mThumbTintMode == r105) goto L15;
        this.mThumbTintMode = r105;
        this.mHasThumbTintMode = true;
    L15:
        if (this.mHasThumbTint == false) goto L17;
    L18:
        applyThumbTint();
    L19:
        ColorStateList r106 = r101.getColorStateList(12);
        if (r106 == null) goto L22;
        this.mTrackTintList = r106;
        this.mHasTrackTint = true;
    L22:
        PorterDuff.Mode r107 = DrawableUtils.parseTintMode(r101.getInt(13, -1), null);
        if (this.mTrackTintMode == r107) goto L26;
        this.mTrackTintMode = r107;
        this.mHasTrackTintMode = true;
    L26:
        if (this.mHasTrackTint == false) goto L28;
    L29:
        applyTrackTint();
    L30:
        int r108 = r101.getResourceId(7, 0);
        if (r108 == 0) goto L33;
        setSwitchTextAppearance(r110, r108);
    L33:
        this.mTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper.loadFromAttributes(r111, r112);
        r101.recycle();
        ViewConfiguration r113 = ViewConfiguration.get(r110);
        this.mTouchSlop = r113.getScaledTouchSlop();
        this.mMinFlingVelocity = r113.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L28:
        if (this.mHasTrackTintMode == false) goto L30;
    L17:
        if (this.mHasThumbTintMode == false) goto L19;
        goto L18
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = 0;
        if (this.mThumbDrawable == null) goto L9;
        Rect r106 = this.mTempRect;
        Drawable r107 = this.mTrackDrawable;
        if (r107 == null) goto L7;
        r107.getPadding(r106);
    L8:
        Rect r108 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
        int r109 = Math.max(0, r108.left - r106.left);
        r105 = Math.max(0, r108.right - r106.right);
    L11:
        if (ViewUtils.isLayoutRtl(this) == false) goto L13;
        int r110 = getPaddingLeft() + r109;
        int r111 = ((this.mSwitchWidth + r110) - r109) - r105;
    L14:
        int r112 = getGravity() & 112;
        if (r112 != 16) goto L17;
        int r113 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r114 = this.mSwitchHeight;
        int r115 = r113 - (r114 / 2);
    L21:
        int r116 = r114 + r115;
    L22:
        this.mSwitchLeft = r110;
        this.mSwitchTop = r115;
        this.mSwitchBottom = r116;
        this.mSwitchRight = r111;
        return;
    L17:
        if (r112 == 80) goto L19;
        r115 = getPaddingTop();
        r114 = this.mSwitchHeight;
        goto L21
    L19:
        r116 = getHeight() - getPaddingBottom();
        r115 = r116 - this.mSwitchHeight;
        goto L22
    L13:
        r111 = (getWidth() - getPaddingRight()) - r105;
        r110 = ((r111 - this.mSwitchWidth) + r109) + r105;
        goto L14
    L7:
        r106.setEmpty();
        goto L8
    L9:
        r109 = 0;
        goto L11
    }
}
