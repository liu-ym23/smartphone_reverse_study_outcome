package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.widget.LiveTextView;

/* JADX INFO: loaded from: classes8.dex */
public class NoMoreSpaceTextView extends LiveTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f112434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f112435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f112436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f112437f;

    @Override // android.view.View
    public final void scrollBy(int r100, int r101) {
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
    }

    private int getSpaceExtra() {
        if (getLineCount() == this.f112435d) goto L5;
        int r100 = getLineCount();
        this.f112435d = r100;
        this.f112434c = 0;
        int r101 = r100 - 1;
        Layout r102 = getLayout();
        if (r101 < 0) goto L12;
        if (getMeasuredHeight() != r102.getHeight()) goto L12;
        Paint.FontMetricsInt r103 = r102.getPaint().getFontMetricsInt();
        Rect r104 = new Rect();
        this.f112434c = (r104.bottom - (r103.ascent - r102.getLineAscent(r101))) - (getLineBounds(r101, r104) + r103.bottom);
    L12:
        return this.f112434c;
    L5:
        return this.f112434c;
    }

    public NoMoreSpaceTextView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);     // Catch: Exception -> L4
    L7:
        if (this.f112436e == false) goto L12;
        postInvalidateDelayed(this.f112437f);
        return;
    L12:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void setAlwaysInvalidate(boolean r100) {
        this.f112436e = r100;
    }

    public void setAlwaysInvalidateIntervalInMS(int r100) {
        this.f112437f = r100;
    }

    public NoMoreSpaceTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() - getSpaceExtra());
    }

    public NoMoreSpaceTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        SettingKey r103 = new SettingKey("live_text_message_invalidate_value", "延迟刷新值,默认50毫秒", 50, 50);
        this.f112436e = false;
        this.f112437f = ((Integer) com.bytedance.android.live.liveinteract.f.b(r103)).intValue();
    }
}
