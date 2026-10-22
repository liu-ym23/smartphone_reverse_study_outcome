package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class u extends r {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f145333k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f145334l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextPaint f145335m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f145336n;

    public u() {
        this.f145334l = Typeface.DEFAULT;
        TextPaint r100 = new TextPaint();
        r100.setAntiAlias(true);
        Unit r101 = Unit.INSTANCE;
        this.f145335m = r100;
    }

    public final void b(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        CharSequence r101 = this.f145333k;
        this.f145335m.setTextAlign(Paint.Align.CENTER);
        this.f145335m.setTypeface(this.f145334l);
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        if (this.f145265g == true) goto L13;
        return;
    L13:
        if (this.f145259a <= 0) goto L37;
        this.f145335m.setAlpha((int) (this.f145259a * 255));
        this.f145268j.reset();
        if (this.f145264f == 0.0f) goto L18;
        r102 = r100.save();
        r100.rotate(this.f145264f);
    L18:
        if (this.f145262d == 0.0f) goto L20;
    L23:
        this.f145268j.setTranslate(this.f145262d, this.f145263e);
        this.f145268j.mapRect(this.f145267i, this.f145266h);
    L25:
        if (this.f145260b == 1.0f) goto L27;
    L30:
        this.f145268j.reset();
        this.f145268j.setScale(this.f145260b, this.f145261c, this.f145267i.centerX(), this.f145267i.centerY());
        this.f145335m.setTextSize(this.f145336n * Math.max(this.f145260b, this.f145261c));
        Matrix r104 = this.f145268j;
        RectF r105 = this.f145267i;
        r104.mapRect(r105, r105);
    L31:
        int r106 = r101.length();
        Paint.FontMetrics r107 = this.f145335m.getFontMetrics();
        float r108 = this.f145267i.centerX();
        RectF r109 = this.f145267i;
        r100.drawText(r101, 0, r106, r108, ((r109.top + (r109.height() / 2.0f)) - (r107.top / 2.0f)) - (r107.bottom / 2.0f), this.f145335m);
        if (r102 <= 0) goto L38;
        r100.restoreToCount(r102);
        return;
    L38:
        return;
    L27:
        if (this.f145261c != 1.0f) goto L30;
        this.f145335m.setTextSize(this.f145336n);
        goto L31
    L20:
        if (this.f145263e != 0.0f) goto L23;
        this.f145267i.set(this.f145266h);
        goto L25
    L37:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
