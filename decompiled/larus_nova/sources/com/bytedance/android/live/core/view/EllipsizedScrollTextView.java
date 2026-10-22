package com.bytedance.android.live.core.view;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.util.Pair;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes45.dex */
public class EllipsizedScrollTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Scroller f66521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f66522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f66523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f66524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f66525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f66526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f66527g;

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        return 0.0f;
    }

    private Pair<String, Integer> getEllipsizedText() {
        TextPaint r100 = getPaint();
        int r101 = getWidth();
        if (r101 >= x(r100, getText().toString())) goto L5;
        int r102 = 1;
    L8:
        if (r102 >= getText().length()) goto L18;
        int r103 = x(r100, getText().subSequence(0, r102).toString() + this.f66525e);
        if (r103 == r101) goto L12;
        if (r103 > r101) goto L14;
        r102 = r102 + 1;
        goto L8
    L14:
        StringBuilder r104 = new StringBuilder();
        int r105 = r102 - 1;
        r104.append(getText().subSequence(0, r105));
        r104.append(this.f66525e);
        return new Pair(r104.toString(), Integer.valueOf(r101 - x(r100, getText().subSequence(0, r105).toString() + this.f66525e)));
    L12:
        return new Pair(getText().subSequence(0, r102) + this.f66525e, 0);
    L18:
        return new Pair(getText().toString(), 0);
    L5:
        return new Pair("", 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        Scroller r100 = this.f66521a;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isFinished() == false) goto L16;
        boolean r101 = this.f66523c;
        if (r101 == true) goto L17;
        Scroller r102 = this.f66521a;
        if (r102 == null) goto L18;
        if (r101 == true) goto L19;
        this.f66523c = true;
        this.f66522b = r102.getCurrX();
        this.f66521a.abortAnimation();
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setEllipsize(null);
        setTranslationX(0.0f);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setEllipsize(null);
        Scroller r100 = this.f66521a;
        if (r100 == null) goto L5;
        r100.abortAnimation();
        this.f66521a = null;
    L5:
        this.f66526f = null;
        this.f66522b = 0;
    }

    public final void y() {
        Pair<String, Integer> r100 = getEllipsizedText();
        this.f66526f = r100.first;
        this.f66527g = r100.second.intValue();
        this.f66523c = true;
        ALogger.i("EllipsizedScrollTextView", "getEllipsizedText; startScroll; mEllipsizedText=" + this.f66526f + ", mEllipsizedTextGap=" + this.f66527g);
        if (TextUtils.isEmpty(this.f66526f) == false) goto L6;
        return;
    L6:
        if (this.f66523c == false) goto L10;
        ALogger.i("EllipsizedScrollTextView", "resumeScroll");
        setText(getText() + this.f66524d + this.f66526f);
        setHorizontallyScrolling(true);
        Scroller r101 = new Scroller(getContext(), new LinearInterpolator());
        this.f66521a = r101;
        setScroller(r101);
        int r102 = x(getPaint(), getText().toString()) - (x(getPaint(), this.f66526f) + this.f66522b);
        this.f66521a.startScroll(this.f66522b, 0, r102, 0, (int) ((r102 / x(getPaint(), "正")) * 307.69232f));
        invalidate();
        this.f66523c = false;
        return;
    }

    public EllipsizedScrollTextView(Context r100) {
        this(r100, null);
        setSingleLine();
        setEllipsize(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public EllipsizedScrollTextView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.textViewStyle);
        setSingleLine();
        setEllipsize(null);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r100, r101);
    }

    public final int x(TextPaint r100, String r101) {
        Rect r102 = new Rect();
        r100.getTextBounds(r101, 0, r101.length(), r102);
        return r102.width();
    }

    public EllipsizedScrollTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f66522b = 0;
        this.f66523c = true;
        this.f66524d = "      ";
        this.f66525e = "...  ";
        setSingleLine();
        setEllipsize(null);
    }
}
