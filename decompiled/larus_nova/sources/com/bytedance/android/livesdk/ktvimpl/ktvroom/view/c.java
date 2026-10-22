package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends r {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f144978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f144979l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f144980m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bitmap f144981n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f144982o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f144983p;

    public final void c() {
        Bitmap r100 = this.f144981n;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRecycled() == true) goto L9;
        r100.recycle();
        return;
    }

    public c() {
        this.f144978k = new Rect();
        this.f144980m = new RectF();
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        Unit r101 = Unit.INSTANCE;
        this.f144983p = r100;
    }

    public final void b(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Bitmap r101 = this.f144981n;
        if (this.f145265g == false) goto L37;
        int r102 = 0;
        if (this.f145259a <= 0) goto L38;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isRecycled() == true) goto L40;
        this.f144983p.setAlpha((int) (this.f145259a * 255));
        this.f144980m.set(this.f145266h);
        if (this.f144979l == false) goto L20;
        float r103 = this.f145266h.width();
        float r104 = this.f145266h.height();
        int r105 = r101.getWidth();
        int r106 = r101.getHeight();
        if (r103 == 0.0f) goto L20;
        if (r105 == 0) goto L20;
        float r107 = r104 / r103;
        float r108 = r106 / r105;
        if (r107 == r108) goto L20;
        if (r107 <= r108) goto L19;
        float r109 = r103 * r108;
        RectF r110 = this.f145266h;
        float r111 = r110.top + ((r110.height() - r109) / 2.0f);
        RectF r112 = this.f145266h;
        float r113 = r112.bottom - ((r112.height() - r109) / 2.0f);
        RectF r114 = this.f144980m;
        r114.top = r111;
        r114.bottom = r113;
        goto L20
    L19:
        float r115 = r104 / r108;
        RectF r116 = this.f145266h;
        float r117 = r116.left + ((r116.width() - r115) / 2.0f);
        RectF r118 = this.f145266h;
        float r119 = r118.right - ((r118.width() - r115) / 2.0f);
        RectF r120 = this.f144980m;
        r120.left = r117;
        r120.right = r119;
    L20:
        this.f145268j.reset();
        if (this.f145262d == 0.0f) goto L23;
    L24:
        this.f145268j.setTranslate(this.f145262d, this.f145263e);
    L25:
        this.f145268j.mapRect(this.f145267i, this.f144980m);
        if (this.f145260b == 1.0f) goto L28;
    L29:
        this.f145268j.reset();
        this.f145268j.setScale(this.f145260b, this.f145261c, this.f145267i.centerX(), this.f145267i.centerY());
        Matrix r121 = this.f145268j;
        RectF r122 = this.f145267i;
        r121.mapRect(r122, r122);
    L31:
        if (this.f145264f == 0.0f) goto L33;
        r102 = r100.save();
        r100.rotate(this.f145264f, this.f145267i.centerX(), this.f145267i.centerY());
    L33:
        r100.drawBitmap(r101, this.f144978k, this.f145267i, this.f144983p);
        if (r102 <= 0) goto L41;
        r100.restoreToCount(r102);
        return;
    L41:
        return;
    L28:
        if (this.f145261c == 1.0f) goto L31;
    L23:
        if (this.f145263e == 0.0f) goto L25;
    L40:
        return;
    L38:
        return;
    }

    public final void d(Bitmap r100) {
        this.f144981n = r100;
        if (r100 == null) goto L6;
        this.f144978k.set(0, 0, r100.getWidth(), r100.getHeight());
        return;
    }
}
