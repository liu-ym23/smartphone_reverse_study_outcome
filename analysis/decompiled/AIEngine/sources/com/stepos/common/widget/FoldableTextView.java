package com.stepos.common.widget;

import android.annotation.SuppressLint;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.TypefaceSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FoldableTextView extends TextView implements View.OnClickListener {
    public static final /* synthetic */ int r = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f6893a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6894b;

    /* renamed from: c, reason: collision with root package name */
    public int f6895c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f6896d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f6897e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public int f6898j;

    /* renamed from: k, reason: collision with root package name */
    public Layout f6899k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6900l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6901m;

    /* renamed from: n, reason: collision with root package name */
    public int f6902n;

    /* renamed from: o, reason: collision with root package name */
    public float f6903o;

    /* renamed from: p, reason: collision with root package name */
    public float f6904p;

    /* renamed from: q, reason: collision with root package name */
    public int f6905q;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
            FoldableTextView.a(this.mFoldableTextView.get());
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends LinkMovementMethod {

        /* renamed from: b, reason: collision with root package name */
        public static a f6906b;

        /* renamed from: a, reason: collision with root package name */
        public boolean f6907a;

        public static a a() {
            if (f6906b == null) {
                a aVar = new a();
                aVar.f6907a = false;
                f6906b = aVar;
            }
            return f6906b;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            this.f6907a = false;
            if (action != 1 && action != 0) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            int x3 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            int totalPaddingLeft = x3 - textView.getTotalPaddingLeft();
            int totalPaddingTop = y3 - textView.getTotalPaddingTop();
            int scrollX = textView.getScrollX() + totalPaddingLeft;
            int scrollY = textView.getScrollY() + totalPaddingTop;
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
                    int i10 = FoldableTextView.r;
                    return true;
                }
            } else {
                if (clickableSpanArr.length == 0) {
                    Selection.removeSelection(spannable);
                    Touch.onTouchEvent(textView, spannable, motionEvent);
                    return false;
                }
                if (action == 1) {
                    clickableSpanArr[0].onClick(textView);
                    this.f6907a = true;
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                }
                if (textView instanceof FoldableTextView) {
                    int i11 = FoldableTextView.r;
                }
            }
            return true;
        }
    }

    public static void a(FoldableTextView foldableTextView) {
        foldableTextView.getClass();
        if (foldableTextView.f6901m) {
            return;
        }
        foldableTextView.f6893a = false;
        super.setText(foldableTextView.f6896d, TextView.BufferType.NORMAL);
    }

    private void setOnClickListener(boolean z) {
        if (z) {
            setOnClickListener(this);
        } else {
            setOnClickListener((View.OnClickListener) null);
        }
    }

    public final void b() {
        Layout layout = getLayout();
        this.f6899k = layout;
        if (layout == null) {
            return;
        }
        this.h = (int) (getPaddingTop() + getPaddingBottom() + (layout.getLineBottom(layout.getLineCount() - 1) - this.f6899k.getLineTop(0)) + 0.5d);
        if (this.f6899k.getLineCount() <= 0) {
            this.f6898j = this.h;
            return;
        }
        this.f6898j = (int) (getPaddingTop() + getPaddingBottom() + (this.f6899k.getLineBottom(-1) - this.f6899k.getLineTop(0)) + 0.5d + getLineSpacingExtra());
    }

    public int getFoldLineMax() {
        return 0;
    }

    public boolean getFoldStatus() {
        return this.f6893a;
    }

    public int getLinkColor() {
        return this.f6895c;
    }

    public CharSequence getMoreText() {
        return null;
    }

    public CharSequence getStrEllipse() {
        return null;
    }

    @Override // android.view.View
    public final boolean hasFocusable() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (a.a().f6907a || this.f6901m || !this.f6894b) {
            return;
        }
        if (this.f6893a) {
            this.f6893a = false;
            super.setText(this.f6896d, TextView.BufferType.NORMAL);
            return;
        }
        this.f6893a = true;
        if (this.h == 0 || getLayout() == null) {
            return;
        }
        getLayout().getLineCount();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(FoldableTextView.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f6896d == null) {
            this.f6896d = getText();
        }
        b();
        if (this.f6897e == null) {
            CharSequence charSequence = this.f6896d;
            Layout layout = getLayout();
            this.f6899k = layout;
            if (layout != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
                TextPaint paint = this.f6899k.getPaint();
                int width = this.f6905q;
                if (width == 0) {
                    width = this.f6899k.getWidth();
                }
                new DynamicLayout(spannableStringBuilder, paint, width, this.f6899k.getAlignment(), 1.0f, 0.0f, false).getLineCount();
            }
            this.f6897e = charSequence;
        }
        if (this.f6897e.equals(this.f6896d) || !getText().equals(this.f6896d)) {
            super.setText(this.f6896d, TextView.BufferType.SPANNABLE);
            setMeasuredDimension(i10, this.h);
        } else {
            if (getText().equals(this.f6897e)) {
                return;
            }
            super.setText(this.f6897e, TextView.BufferType.SPANNABLE);
            setMeasuredDimension(i10, this.f6898j);
        }
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        if (this.f6896d == null || this.f6897e == null || !(charSequence == null || charSequence.toString().equals(this.f6896d.toString()) || charSequence.toString().equals(this.f6897e.toString()))) {
            this.f6896d = charSequence;
            this.f6897e = null;
            b();
            if (this.f6893a) {
                setHeight(this.f6898j);
            } else {
                setHeight(this.h);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        if (!this.f6900l && this.f6893a) {
            return a.a().onTouchEvent(this, (Spannable) getText(), motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6903o = motionEvent.getX();
            this.f6904p = motionEvent.getY();
            this.f6902n = 0;
            removeCallbacks(null);
            postDelayed(null, ViewConfiguration.getLongPressTimeout());
        } else if (action == 1) {
            if (this.f6902n != 1 && !hasSelection()) {
                a.a().onTouchEvent(this, (Spannable) getText(), motionEvent);
                performClick();
                this.f6902n = 0;
            }
            if (hasSelection() && this.f6902n != 1) {
                Selection.setSelection((Spannable) getText(), 0);
            }
            removeCallbacks(null);
        } else if (action == 2) {
            this.f6903o = motionEvent.getX();
            this.f6904p = motionEvent.getY();
        } else if (action == 3) {
            removeCallbacks(null);
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean performLongClick() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean zPerformLongClick = super.performLongClick();
        this.f6902n = 1;
        if (!zPerformLongClick && this.f6900l) {
            float f8 = this.f6903o;
            float f9 = this.f6904p;
            Layout layout = getLayout();
            if (layout != null) {
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) (Math.min((getHeight() - getTotalPaddingBottom()) - 1, Math.max(0.0f, f9 - getTotalPaddingTop())) + getScrollY())), Math.min((getWidth() - getTotalPaddingRight()) - 1, Math.max(0.0f, f8 - getTotalPaddingLeft())) + getScrollX());
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
        }
        return zPerformLongClick;
    }

    public void setClickToFold(boolean z) {
        this.f6894b = z;
    }

    public void setFoldStatus(boolean z) {
        if (this.f6901m || this.f6893a == z) {
            return;
        }
        this.f6893a = z;
        requestLayout();
        invalidate();
    }

    public void setFoldTextMaxWidth(int i10) {
        this.f6905q = i10;
    }

    public void setForbidden(boolean z) {
        this.f6901m = z;
    }

    public void setLinkColor(int i10) {
        this.f6895c = i10;
        invalidate();
    }

    public void setNonSpanClickable(boolean z) {
        this.f6900l = z;
    }

    public void setFoldDuration(int i10) {
    }
}
