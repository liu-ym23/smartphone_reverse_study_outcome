package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes45.dex */
public class FitTextView extends LiveTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f66560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f66561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f66562e;

    public FitTextView(Context r100) {
        this(r100, null);
    }

    public FitTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f66562e = 6.0f;
        TextPaint r102 = new TextPaint();
        this.f66560c = r102;
        r102.set(getPaint());
        this.f66561d = getTextSize();
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r100, r101);
        y(r100.toString(), getWidth());
    }

    public final void y(String r100, int r101) {
        if (r101 <= 0) goto L14;
        int r102 = (r101 - getPaddingLeft()) - getPaddingRight();
        float r103 = this.f66561d;
        this.f66560c.setTextSize(r103);
    L5:
        if (this.f66560c.measureText(r100) <= r102) goto L10;
        r103 = r103 - 1.0f;
        float r104 = this.f66562e;
        if (r103 <= r104) goto L8;
        this.f66560c.setTextSize(r103);
        goto L5
    L8:
        r103 = r104;
    L10:
        setTextSize(0, r103);
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        if (r100 == r102) goto L5;
        y(getText().toString(), r100);
        return;
    }
}
