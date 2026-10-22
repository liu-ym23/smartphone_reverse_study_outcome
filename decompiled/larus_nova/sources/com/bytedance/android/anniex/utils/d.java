package com.bytedance.android.anniex.utils;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f41405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f41406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f41408d;

    public d() {
        this(0);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.OPAQUE", imports = {"android.graphics.PixelFormat"}))
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public d(int r100) {
        this.f41405a = Integer.valueOf(ColorProtector.parseColor("#a63182f2"));
        TextPaint r101 = new TextPaint();
        Resources r102 = Resources.getSystem();
        r101.setTextSize((int) ((WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density * 10.0f) + 0.5f));
        r101.setColor(-1);
        r101.setTextAlign(Paint.Align.LEFT);
        this.f41406b = r101;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        String r100 = this.f41408d;
        if (r100 != null) goto L5;
        return;
    L5:
        SpannableString r101 = new SpannableString(r100);
        Integer r102 = this.f41405a;
        if (r102 == null) goto L8;
        r102.intValue();
        r101.setSpan(new BackgroundColorSpan(this.f41405a.intValue()), 0, r100.length(), 33);
    L8:
        StaticLayout r103 = new StaticLayout(r101, this.f41406b, getBounds().width(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        if (r103.getLineCount() <= 0) goto L11;
        this.f41407c = r103.getHeight();
    L11:
        r110.save();
        r110.translate(0.0f, getBounds().height() - this.f41407c);
        r103.draw(r110);
        r110.restore();
    }
}
