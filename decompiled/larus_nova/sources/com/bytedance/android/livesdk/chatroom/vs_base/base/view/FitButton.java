package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;

/* JADX INFO: loaded from: classes8.dex */
public class FitButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f117951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f117952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f117953c;

    public FitButton(Context r100) {
        this(r100, null);
    }

    public FitButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f117953c = 6.0f;
        TextPaint r102 = new TextPaint();
        this.f117951a = r102;
        r102.set(getPaint());
        this.f117952b = getTextSize();
    }

    public final void a(String r100, int r101) {
        if (r101 <= 0) goto L14;
        int r102 = (r101 - getPaddingLeft()) - getPaddingRight();
        float r103 = this.f117952b;
        this.f117951a.setTextSize(r103);
    L5:
        if (this.f117951a.measureText(r100) <= r102) goto L10;
        r103 = r103 - 1.0f;
        float r104 = this.f117953c;
        if (r103 <= r104) goto L8;
        this.f117951a.setTextSize(r103);
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
        a(r100.toString(), getWidth());
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        if (r100 == r102) goto L5;
        a(getText().toString(), r100);
        return;
    }
}
