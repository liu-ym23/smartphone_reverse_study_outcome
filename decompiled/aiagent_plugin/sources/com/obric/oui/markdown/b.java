package com.obric.oui.markdown;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import d.h.b.o;

/* JADX INFO: compiled from: OMarkdownImageRunDelegate.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends com.lynx.markdown.d {
    private final Drawable f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final float k;
    private final int l;
    private final int m;

    public b(Drawable r7, int r8, int r9, int r10, int r11, float r12, int r13, int r14) {
        super(null, 0, 0, 0, 0);
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }

    @Override // com.lynx.markdown.d, com.lynx.markdown.i
    public void a(Canvas r8, Rect r9) {
        o.e(r8, "canvas");
        o.e(r9, "rect");
        if (this.f == null) goto L12;
        r8.save();
        if (this.i > 0) goto L7;
    L9:
        Path r10 = new Path();
        int r3 = this.l;
        RectF r2 = new RectF(0.0f, r3, this.g, this.h + r3);
        float r1 = this.k;
        r10.addRoundRect(r2, r1, r1, Path.Direction.CW);
        r8.clipPath(r10);
        Drawable r11 = this.f;
        int r4 = this.l;
        r11.setBounds(0, r4, this.g, this.h + r4);
    L10:
        this.f.draw(r8);
        r8.restore();
        return;
    L7:
        if (this.j <= 0) goto L9;
        Path r12 = new Path();
        int r5 = this.l;
        RectF r6 = new RectF(0.0f, r5, this.i, this.j + r5);
        float r7 = this.k;
        r12.addRoundRect(r6, r7, r7, Path.Direction.CW);
        r8.clipPath(r12);
        Drawable r13 = this.f;
        int r14 = this.l;
        r13.setBounds(0, r14, this.i, this.j + r14);
        goto L10
    }

    @Override // com.lynx.markdown.d, com.lynx.markdown.i, com.lynx.markdown.a.c
    public float a() {
        int r0 = this.j;
        if (r0 > 0) goto L8;
        if (this.f == null) goto L8;
        r0 = this.h;
    L8:
        return (-r0) - (this.l + this.m);
    }

    @Override // com.lynx.markdown.d, com.lynx.markdown.i, com.lynx.markdown.a.c
    public float b() {
        int r0 = this.i;
        if (r0 > 0) goto L8;
        if (this.f == null) goto L8;
        return this.g;
    L8:
        return r0;
    }
}
