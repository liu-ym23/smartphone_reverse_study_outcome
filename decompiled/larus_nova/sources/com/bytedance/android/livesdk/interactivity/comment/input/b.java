package com.bytedance.android.livesdk.interactivity.comment.input;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class b extends ImageSpan implements e90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f135144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f135145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f135146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f135147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f135148e;

    public static final class a {
    }

    static {
    }

    public int a() {
        return 3;
    }

    @Override // e90.a
    public boolean b() {
        return this instanceof c;
    }

    public String getDesc() {
        return " ";
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        return this.f135145b;
    }

    public int getType() {
        return this.f135144a;
    }

    public b(Drawable r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "spanDrawable");
        super(r100);
        this.f135145b = r100;
        this.f135146c = r101;
        this.f135147d = r102;
        this.f135148e = 1.0f;
        this.f135144a = 1;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Drawable r105 = this.f135145b;
        float r106 = this.f135148e;
        if (r106 <= 0) goto L5;
        r105.setBounds(0, 0, (int) (this.f135146c * r106), (int) (this.f135147d * r106));
    L6:
        Rect r107 = r105.getBounds();
        if (r104 == null) goto L10;
        Paint.FontMetricsInt r108 = r100.getFontMetricsInt();
        int r109 = r108.bottom - r108.top;
        int r110 = (r107.bottom - r107.top) / 2;
        int r111 = r109 / 4;
        int r112 = r110 - r111;
        int r113 = -(r110 + r111);
        r104.ascent = r113;
        r104.top = r113;
        r104.bottom = r112;
        r104.descent = r112;
    L10:
        return (r107.right + 0) + 0;
    L5:
        r105.setBounds(0, 0, this.f135146c, this.f135147d);
        goto L6
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        float r109 = 0;
        float r110 = r104 + r109;
        Drawable r111 = this.f135145b;
        float r112 = this.f135148e;
        if (r112 <= r109) goto L5;
        r111.setBounds(0, 0, (int) (this.f135146c * r112), (int) (this.f135147d * r112));
    L6:
        r100.save();
        Paint.FontMetricsInt r113 = r108.getFontMetricsInt();
        r100.translate(r110, (int) (((((r113.descent + r106) + (r106 + r113.ascent)) / 2) - (r111.getBounds().bottom / 2)) + 0.5f));
        r111.draw(r100);
        r100.restore();
        return;
    L5:
        r111.setBounds(0, 0, this.f135146c, this.f135147d);
        goto L6
    }
}
