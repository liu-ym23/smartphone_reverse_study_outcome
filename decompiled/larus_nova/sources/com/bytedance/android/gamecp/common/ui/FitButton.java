package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;

/* JADX INFO: loaded from: classes44.dex */
public class FitButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f56921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f56922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f56923c;

    public FitButton(Context r100) {
        this(r100, null);
    }

    public FitButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f56923c = 6.0f;
        TextPaint r102 = new TextPaint();
        this.f56921a = r102;
        r102.set(getPaint());
        this.f56922b = getTextSize();
    }

    public final void a(String r100, int r101) {
        if (r101 <= 0) goto L14;
        int r102 = (r101 - getPaddingLeft()) - getPaddingRight();
        float r103 = this.f56922b;
        this.f56921a.setTextSize(r103);
    L5:
        if (this.f56921a.measureText(r100) <= r102) goto L10;
        r103 = r103 - 1.0f;
        float r104 = this.f56923c;
        if (r103 <= r104) goto L8;
        this.f56921a.setTextSize(r103);
        goto L5
    L8:
        r103 = r104;
    L10:
        setTextSize(0, r103);
        return;
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r100, r101);
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        a(r100.toString(), getWidth());
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        if (r100 == r102) goto L5;
        a(getText().toString(), r100);
        return;
    }
}
