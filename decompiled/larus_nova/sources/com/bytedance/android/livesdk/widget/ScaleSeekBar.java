package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes11.dex */
public class ScaleSeekBar extends AppCompatSeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f161260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f161261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f161262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f161263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f161264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f161265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f161266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f161267h;

    public ScaleSeekBar(Context r100) {
        this(r100, null);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas r100) {
        monitor-enter(this);
        int r101 = getBottom();     // Catch: Throwable -> L9
        int r102 = getTop();     // Catch: Throwable -> L9
        setBottom((int) (r101 - ((this.f161261b + getPaddingTop()) + this.f161266g)));     // Catch: Throwable -> L9
        setTop((int) (((r102 + this.f161261b) + getPaddingTop()) + this.f161266g));     // Catch: Throwable -> L9
        r100.save();     // Catch: Throwable -> L9
        r100.translate(0.0f, (this.f161261b + getPaddingTop()) + this.f161266g);     // Catch: Throwable -> L9
        super.onDraw(r100);     // Catch: Throwable -> L9
        r100.restore();     // Catch: Throwable -> L9
        setBottom(r101);     // Catch: Throwable -> L9
        setTop(r102);     // Catch: Throwable -> L9
        int r103 = getProgress();     // Catch: Throwable -> L9
        String r104 = this.f161263d + String.valueOf(r103) + this.f161262c;     // Catch: Throwable -> L9
        if (RTLUtil.isAppRTL(getContext()) == false) goto L6;
        r100.drawText(r104, ((getWidth() - getPaddingLeft()) - getPaddingRight()) - ((((((getWidth() - getPaddingLeft()) - getPaddingRight()) * r103) / 100) - getPaddingStart()) + (this.f161260a.measureText(r104) / 2.0f)), (this.f161261b + getPaddingTop()) - this.f161267h, this.f161260a);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        r100.drawText(r104, (((((getWidth() - getPaddingLeft()) - getPaddingRight()) * r103) / 100) + getPaddingLeft()) - (this.f161260a.measureText(r104) / 2.0f), (this.f161261b + getPaddingTop()) - this.f161267h, this.f161260a);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public ScaleSeekBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int r100, int r101) {
        monitor-enter(this);
        super.onMeasure(r100, r101);     // Catch: Throwable -> L9
        int r102 = View.MeasureSpec.getMode(r101);     // Catch: Throwable -> L9
        int r103 = getMeasuredHeight();     // Catch: Throwable -> L9
        int r104 = getMeasuredWidth();     // Catch: Throwable -> L9
        if (r102 != Integer.MIN_VALUE) goto L6;
        int r105 = getMeasuredHeight();     // Catch: Throwable -> L9
        r103 = ((int) (((this.f161260a.descent() - this.f161260a.ascent()) + this.f161266g) * 2.0f)) + r105;     // Catch: Throwable -> L9
    L6:
        setMeasuredDimension(r104, r103);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public ScaleSeekBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f161264e = -1;
        this.f161265f = 30.0f;
        this.f161266g = 10.0f;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_textColor, R.attr.ttlive_textEnd, R.attr.ttlive_textInterval, R.attr.ttlive_textMarginBottom, R.attr.ttlive_textSize, R.attr.ttlive_textStart});
        if (r103 == null) goto L11;
        this.f161264e = r103.getColor(0, -1);
        this.f161265f = r103.getDimension(4, 30.0f);
        this.f161266g = r103.getDimension(3, 10.0f);
        Resources r104 = getResources();
        this.f161267h = r103.getDimensionPixelOffset(2, (int) ((WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density * 3.0f) + 0.5f));
        String r105 = r103.getString(5);
        this.f161263d = r105;
        if (TextUtils.isEmpty(r105) == false) goto L7;
        this.f161263d = "";
    L7:
        String r106 = r103.getString(1);
        this.f161262c = r106;
        if (TextUtils.isEmpty(r106) == false) goto L10;
        this.f161262c = "";
    L10:
        r103.recycle();
    L11:
        Paint r107 = new Paint();
        this.f161260a = r107;
        r107.setColor(this.f161264e);
        r107.setTextSize(this.f161265f);
        r107.setAntiAlias(true);
        this.f161261b = r107.descent() - r107.ascent();
    }
}
