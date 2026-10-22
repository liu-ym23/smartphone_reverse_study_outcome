package com.stepos.common.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.TypefaceSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class FoldableTextView extends TextView implements View.OnClickListener {
    private static final boolean DEBUG = false;
    private static final String ELLIPSIS_THREE_DOTS = "...";
    private static final String TAG = "FoldableTextView";
    private static int TOUCH_STATE_LONGCLICK = 1;
    private static int TOUCH_STATE_NORMAL;
    private int CHAR_SIZE;
    private Layout layout;
    private boolean mAlignViewEdge;
    private Float mAnimatorFraction;
    private final Runnable mCheckLongPress;
    private boolean mClickToFold;
    private int mDuration;
    private CharSequence mEllipseText;
    private int mFoldLineMax;
    private int mFoldTextMaxWidth;
    private CharSequence mFoldedText;
    private boolean mIsAnimating;
    private boolean mIsForbidden;
    private boolean mIsfolded;
    private int mLinkColor;
    private boolean mLinkHit;
    private d mListener;
    private int mMaxHeight;
    private int mMinHeight;
    private CharSequence mMoreText;
    private boolean mNonClicks;
    private boolean mNonSpanClickable;
    private int mTouchState;
    private float mTouchX;
    private float mTouchY;
    private CharSequence mainText;

    @SuppressLint({"ParcelCreator"})
    public class MoreClickSpan extends TypefaceSpan {
        WeakReference<FoldableTextView> mFoldableTextView;
        private int mLinkColor;

        public MoreClickSpan(String str, CharSequence charSequence) {
            super(str);
            this.mLinkColor = 0;
        }

        public void onClick(View view) {
            WeakReference<FoldableTextView> weakReference = this.mFoldableTextView;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mFoldableTextView.get().r();
        }

        public void setFoldableTextView(FoldableTextView foldableTextView) {
            this.mFoldableTextView = new WeakReference<>(foldableTextView);
        }

        public void setLinkColor(int i10) {
            this.mLinkColor = i10;
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            int i10 = this.mLinkColor;
            if (i10 == 0) {
                textPaint.setColor(textPaint.linkColor);
            } else {
                textPaint.setColor(i10);
            }
        }
    }

    public class a implements Runnable {
        final /* synthetic */ FoldableTextView this$0;

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (!this.this$0.isLongClickable() || this.this$0.getWindowToken() == null || this.this$0.getParent() == null) {
                return;
            }
            this.this$0.performLongClick();
        }
    }

    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (FoldableTextView.this.mIsfolded) {
                FoldableTextView foldableTextView = FoldableTextView.this;
                foldableTextView.setText(foldableTextView.mFoldedText, TextView.BufferType.SPANNABLE);
                FoldableTextView foldableTextView2 = FoldableTextView.this;
                foldableTextView2.setMeasuredDimension(foldableTextView2.getMeasuredWidth(), FoldableTextView.this.mMinHeight);
            } else {
                FoldableTextView foldableTextView3 = FoldableTextView.this;
                foldableTextView3.setMeasuredDimension(foldableTextView3.getMeasuredWidth(), FoldableTextView.this.mMaxHeight);
            }
            FoldableTextView.this.mIsAnimating = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (FoldableTextView.this.mIsfolded) {
                FoldableTextView foldableTextView = FoldableTextView.this;
                foldableTextView.setText(foldableTextView.mFoldedText, TextView.BufferType.SPANNABLE);
                FoldableTextView foldableTextView2 = FoldableTextView.this;
                foldableTextView2.setMeasuredDimension(foldableTextView2.getMeasuredWidth(), FoldableTextView.this.mMinHeight);
            } else {
                FoldableTextView foldableTextView3 = FoldableTextView.this;
                foldableTextView3.setMeasuredDimension(foldableTextView3.getMeasuredWidth(), FoldableTextView.this.mMaxHeight);
            }
            FoldableTextView.this.mIsAnimating = false;
            FoldableTextView.this.mNonClicks = !r2.mNonClicks;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FoldableTextView.this.mAnimatorFraction = Float.valueOf(valueAnimator.getAnimatedFraction());
            FoldableTextView.this.requestLayout();
        }
    }

    public interface d {
    }

    public static class e extends LinkMovementMethod {
        static e sInstance;
        public boolean isLinkClick = false;

        public static e a() {
            if (sInstance == null) {
                sInstance = new e();
            }
            return sInstance;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            this.isLinkClick = false;
            if (action != 1 && action != 0) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
            int totalPaddingTop = y10 - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            if (layout == null) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            MoreClickSpan[] moreClickSpanArr = (MoreClickSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, MoreClickSpan.class);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (moreClickSpanArr.length != 0) {
                if (action == 1) {
                    moreClickSpanArr[0].onClick(textView);
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(moreClickSpanArr[0]), spannable.getSpanEnd(moreClickSpanArr[0]));
                }
                if (textView instanceof FoldableTextView) {
                    ((FoldableTextView) textView).mLinkHit = true;
                }
                return true;
            }
            if (clickableSpanArr.length == 0) {
                Selection.removeSelection(spannable);
                Touch.onTouchEvent(textView, spannable, motionEvent);
                return false;
            }
            if (action == 1) {
                clickableSpanArr[0].onClick(textView);
                this.isLinkClick = true;
            } else if (action == 0) {
                Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
            }
            if (textView instanceof FoldableTextView) {
                ((FoldableTextView) textView).mLinkHit = true;
            }
            return true;
        }
    }

    public class f {
        private int mHeight;

        public f() {
        }

        public /* synthetic */ f(FoldableTextView foldableTextView, a aVar) {
            this();
        }
    }

    private void setOnClickListener(boolean z10) {
        if (z10) {
            setOnClickListener(this);
        } else {
            setOnClickListener((View.OnClickListener) null);
        }
    }

    public int getFoldLineMax() {
        return this.mFoldLineMax;
    }

    public boolean getFoldStatus() {
        return this.mIsfolded;
    }

    public int getLinkColor() {
        return this.mLinkColor;
    }

    public CharSequence getMoreText() {
        return this.mMoreText;
    }

    public CharSequence getStrEllipse() {
        return this.mEllipseText;
    }

    @Override // android.view.View
    public boolean hasFocusable() {
        return false;
    }

    public void o() {
        if (this.mIsAnimating || this.mIsForbidden || !this.mClickToFold) {
            return;
        }
        if (this.mIsfolded) {
            this.mIsfolded = false;
            setText(this.mainText, TextView.BufferType.NORMAL);
            if (this.mMinHeight != 0) {
                t();
                return;
            }
            return;
        }
        this.mIsfolded = true;
        if (this.mMaxHeight == 0 || getLayout() == null || getLayout().getLineCount() <= this.mFoldLineMax) {
            return;
        }
        t();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (e.a().isLinkClick) {
            return;
        }
        o();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(FoldableTextView.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.mainText == null) {
            this.mainText = getText();
        }
        q(this.mainText);
        if (this.mIsAnimating) {
            if (this.mIsfolded) {
                setMeasuredDimension(i10, (int) (this.mMaxHeight - ((r4 - this.mMinHeight) * this.mAnimatorFraction.floatValue())));
                return;
            } else {
                setMeasuredDimension(i10, (int) (this.mMinHeight + ((this.mMaxHeight - r4) * this.mAnimatorFraction.floatValue())));
                return;
            }
        }
        if (this.mFoldedText == null) {
            this.mFoldedText = p(this.mainText);
        }
        if (this.mFoldedText.equals(this.mainText) || ((!this.mIsfolded || this.mFoldLineMax <= 0) && !getText().equals(this.mainText))) {
            setText(this.mainText, TextView.BufferType.SPANNABLE);
            setMeasuredDimension(i10, this.mMaxHeight);
        } else {
            if (getText().equals(this.mFoldedText)) {
                return;
            }
            setText(this.mFoldedText, TextView.BufferType.SPANNABLE);
            setMeasuredDimension(i10, this.mMinHeight);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        CharSequence charSequence2;
        super.onTextChanged(charSequence, i10, i11, i12);
        CharSequence charSequence3 = this.mainText;
        if (charSequence3 == null || (charSequence2 = this.mFoldedText) == null || !(charSequence3 == null || charSequence2 == null || charSequence == null || charSequence.toString().equals(this.mainText.toString()) || charSequence.toString().equals(this.mFoldedText.toString()))) {
            this.mainText = charSequence;
            this.mFoldedText = null;
            q(charSequence);
            if (this.mIsfolded) {
                setHeight(this.mMinHeight);
            } else {
                setHeight(this.mMaxHeight);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1 || this.mIsAnimating) {
            return false;
        }
        if (!this.mNonSpanClickable && this.mIsfolded) {
            return e.a().onTouchEvent(this, (Spannable) getText(), motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mTouchX = motionEvent.getX();
            this.mTouchY = motionEvent.getY();
            this.mTouchState = TOUCH_STATE_NORMAL;
            removeCallbacks(this.mCheckLongPress);
            postDelayed(this.mCheckLongPress, ViewConfiguration.getLongPressTimeout());
        } else if (action == 1) {
            if (this.mTouchState != TOUCH_STATE_LONGCLICK && !hasSelection()) {
                e.a().onTouchEvent(this, (Spannable) getText(), motionEvent);
                performClick();
                this.mTouchState = TOUCH_STATE_NORMAL;
            }
            if (hasSelection() && this.mTouchState != TOUCH_STATE_LONGCLICK) {
                Selection.setSelection((Spannable) getText(), 0);
            }
            removeCallbacks(this.mCheckLongPress);
        } else if (action == 2) {
            this.mTouchX = motionEvent.getX();
            this.mTouchY = motionEvent.getY();
        } else if (action == 3) {
            removeCallbacks(this.mCheckLongPress);
        }
        return !this.mNonClicks || this.mNonSpanClickable;
    }

    public final CharSequence p(CharSequence charSequence) {
        Layout layout = getLayout();
        this.layout = layout;
        if (layout != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            TextPaint paint = this.layout.getPaint();
            int width = this.mFoldTextMaxWidth;
            if (width == 0) {
                width = this.layout.getWidth();
            }
            int lineCount = new DynamicLayout(spannableStringBuilder, paint, width, this.layout.getAlignment(), 1.0f, 0.0f, false).getLineCount();
            int i10 = this.mFoldLineMax;
            if (lineCount > i10 && i10 != 0) {
                TextPaint paint2 = getPaint();
                int width2 = this.mFoldTextMaxWidth;
                if (width2 == 0) {
                    width2 = this.layout.getWidth();
                }
                float f10 = width2;
                String[] strArrSplit = spannableStringBuilder.toString().replaceAll("\r", "").split("\n");
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                int i11 = 0;
                for (String str : strArrSplit) {
                    StringBuilder sb2 = new StringBuilder();
                    if (paint2.measureText(str) <= f10) {
                        sb2.append(str);
                        sb2.append("\n");
                        i11++;
                    } else {
                        int i12 = 0;
                        float fMeasureText = 0.0f;
                        while (i12 != str.length()) {
                            char cCharAt = str.charAt(i12);
                            fMeasureText += paint2.measureText(String.valueOf(cCharAt));
                            if (fMeasureText <= f10) {
                                sb2.append(cCharAt);
                            } else {
                                i11++;
                                if (i11 >= this.mFoldLineMax) {
                                    break;
                                }
                                sb2.append("\n");
                                spannableStringBuilder2.append((CharSequence) sb2);
                                sb2.setLength(0);
                                i12--;
                                fMeasureText = 0.0f;
                            }
                            i12++;
                        }
                        i11++;
                        if (i11 < this.mFoldLineMax) {
                            sb2.append("\n");
                        }
                    }
                    if (i11 >= this.mFoldLineMax) {
                        int iIndexOf = sb2.indexOf("\n");
                        if (iIndexOf != -1) {
                            sb2.deleteCharAt(iIndexOf);
                        }
                        int length = sb2.length();
                        if (!TextUtils.isEmpty(this.mEllipseText)) {
                            sb2.append(this.mEllipseText);
                        }
                        sb2.append(' ');
                        int length2 = sb2.length();
                        sb2.append(this.mMoreText);
                        if (paint2.measureText(sb2.toString()) > f10) {
                            for (int i13 = length - 1; i13 > 0; i13--) {
                                sb2.delete(i13, i13 + 1);
                                length2--;
                                if (paint2.measureText(sb2.toString()) < f10) {
                                    break;
                                }
                            }
                        }
                        int length3 = spannableStringBuilder2.length() + length2;
                        spannableStringBuilder2.append((CharSequence) sb2);
                        MoreClickSpan moreClickSpan = new MoreClickSpan("sans-serif-medium", charSequence);
                        moreClickSpan.setLinkColor(this.mLinkColor);
                        moreClickSpan.setFoldableTextView(this);
                        spannableStringBuilder2.setSpan(moreClickSpan, length3, spannableStringBuilder2.length(), 33);
                        return spannableStringBuilder2;
                    }
                    spannableStringBuilder2.append((CharSequence) sb2);
                }
                return spannableStringBuilder2;
            }
        }
        return charSequence;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean zPerformLongClick = super.performLongClick();
        this.mTouchState = TOUCH_STATE_LONGCLICK;
        if (!zPerformLongClick && this.mNonSpanClickable) {
            s(this.mTouchX, this.mTouchY);
        }
        return zPerformLongClick;
    }

    public final void q(CharSequence charSequence) {
        Layout layout = getLayout();
        this.layout = layout;
        if (layout == null) {
            return;
        }
        this.mMaxHeight = (int) ((layout.getLineBottom(layout.getLineCount() - 1) - this.layout.getLineTop(0)) + getPaddingBottom() + getPaddingTop() + 0.5d);
        if (this.layout.getLineCount() <= this.mFoldLineMax) {
            this.mMinHeight = this.mMaxHeight;
        } else {
            this.mMinHeight = (int) ((this.layout.getLineBottom(r0 - 1) - this.layout.getLineTop(0)) + getPaddingBottom() + getPaddingTop() + 0.5d + getLineSpacingExtra());
        }
    }

    public final void r() {
        if (this.mIsAnimating || this.mIsForbidden) {
            return;
        }
        this.mIsfolded = false;
        setText(this.mainText, TextView.BufferType.NORMAL);
        t();
    }

    public final void s(float f10, float f11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) (Math.min((getHeight() - getTotalPaddingBottom()) - 1, Math.max(0.0f, f11 - getTotalPaddingTop())) + getScrollY())), Math.min((getWidth() - getTotalPaddingRight()) - 1, Math.max(0.0f, f10 - getTotalPaddingLeft())) + getScrollX());
        if (offsetForHorizontal < getText().length()) {
            Selection.setSelection((Spannable) getText(), offsetForHorizontal, offsetForHorizontal + 1);
            try {
                TextView.class.getDeclaredMethod("startSelectionActionMode", null).invoke(this, null);
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
    }

    public void setClickToFold(boolean z10) {
        this.mClickToFold = z10;
    }

    public void setFoldDuration(int i10) {
        this.mDuration = i10;
    }

    public void setFoldStatus(boolean z10) {
        if (this.mIsForbidden || this.mIsfolded == z10) {
            return;
        }
        this.mIsfolded = z10;
        requestLayout();
        invalidate();
    }

    public void setFoldTextMaxWidth(int i10) {
        this.mFoldTextMaxWidth = i10;
    }

    public void setForbidden(boolean z10) {
        this.mIsForbidden = z10;
    }

    public void setLinkColor(int i10) {
        this.mLinkColor = i10;
        invalidate();
    }

    public void setNonSpanClickable(boolean z10) {
        this.mNonSpanClickable = z10;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public final void t() {
        if (this.mFoldLineMax == 0) {
            return;
        }
        this.mIsAnimating = true;
        f fVar = new f(this, null);
        boolean z10 = this.mIsfolded;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(fVar, "height", z10 ? this.mMaxHeight : this.mMinHeight, z10 ? this.mMinHeight : this.mMaxHeight);
        objectAnimatorOfInt.setDuration(this.mDuration);
        objectAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfInt.addListener(new b());
        objectAnimatorOfInt.addUpdateListener(new c());
        objectAnimatorOfInt.start();
    }
}
