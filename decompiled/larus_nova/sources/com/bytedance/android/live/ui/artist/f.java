package com.bytedance.android.live.ui.artist;

import android.graphics.Paint;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends TextPaint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint.FontMetricsInt f102051a;

    public f() {
        super(1);
    }

    @Override // android.graphics.Paint
    public final Paint.FontMetricsInt getFontMetricsInt() {
        Paint.FontMetricsInt r100 = this.f102051a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return super.getFontMetricsInt();
    }
}
