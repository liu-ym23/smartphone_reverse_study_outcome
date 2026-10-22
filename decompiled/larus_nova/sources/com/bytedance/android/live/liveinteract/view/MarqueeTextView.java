package com.bytedance.android.live.liveinteract.view;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.xb1;
import vm2.h;

/* JADX INFO: loaded from: classes46.dex */
public class MarqueeTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Scroller f79930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f79931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f79932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f79933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f79934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f79935f;

    public final void y() {
        String r100 = this.f79932c;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = x(r100) - getWidth();
        ALogger.i("MarqueeTextView", "startScroll distance " + r101);
        if (r101 > 0) goto L8;
        return;
    L8:
        String r102 = (this.f79932c + this.f79931b) + this.f79932c;
        int r103 = x(r102) - x(this.f79932c);
        setText(r102);
        setHorizontallyScrolling(true);
        Scroller r104 = new Scroller(getContext(), new LinearInterpolator());
        this.f79930a = r104;
        setScroller(r104);
        this.f79930a.startScroll(0, 0, r103, 0, (1000 / s1.f(this.f79933d)) * r103);
        invalidate();
        if (this.f79934e == false) goto L12;
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(50);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        Scroller r100 = this.f79930a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.isFinished();
        if (this.f79935f == true) goto L8;
        return;
    L8:
        if (this.f79930a.isFinished() == true) goto L10;
        return;
    L10:
        if (this.f79930a == null) goto L13;
        ALogger.i("MarqueeTextView", "resetScroll");
        this.f79930a.abortAnimation();
        scrollTo(0, 0);
    L13:
        y();
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
        Scroller r100 = this.f79930a;
        if (r100 == null) goto L6;
        r100.abortAnimation();
        this.f79930a = null;
        return;
    }

    public MarqueeTextView(Context r100) {
        this(r100, null);
        setSingleLine();
        setEllipsize(null);
    }

    public void setFadingEdge(boolean r100) {
        this.f79934e = r100;
    }

    public void setInfinite(boolean r100) {
        this.f79935f = r100;
    }

    public void setOriginText(CharSequence r100) {
        this.f79932c = r100.toString();
        if (this.f79930a == null) goto L7;
        ALogger.i("MarqueeTextView", "resetScroll");
        this.f79930a.abortAnimation();
        scrollTo(0, 0);
        return;
    }

    public final int x(String r100) {
        TextPaint r101 = getPaint();
        Rect r102 = new Rect();
        r101.getTextBounds(r100, 0, r100.length(), r102);
        return r102.width();
    }

    public MarqueeTextView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.textViewStyle);
        setSingleLine();
        setEllipsize(null);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r100, r101);
    }

    public MarqueeTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f79931b = "              ";
        this.f79933d = ((xb1) h.Z4.getValue(null, h.f556082a[310(0x136, float:4.34E-43)])).a();
        this.f79934e = false;
        this.f79935f = false;
        setSingleLine();
        setEllipsize(null);
    }
}
