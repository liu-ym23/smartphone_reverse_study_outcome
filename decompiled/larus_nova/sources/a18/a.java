package a18;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.core.graphics.ColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f1382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1386i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1388k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f1389l;

    @Override // a18.c
    public final int d() {
        return this.f1393a.f569644g;
    }

    @Override // a18.c
    public final int e() {
        return this.f1393a.f569644g;
    }

    public a(z08.b r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        super(r100);
        this.f1382e = -90.0f;
        this.f1383f = 90;
        this.f1384g = 180;
        this.f1385h = 360;
        this.f1386i = 1;
    }

    @Override // a18.c
    public final void a(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = this.f1393a.f569644g / 2.0f;
        r100.translate(r101, r101);
        r100.rotate(this.f1382e);
        float r102 = -r101;
        r100.clipRect(r102, r102, r101, r101);
        this.f1386i = 1;
        z08.b r103 = this.f1393a;
        int r104 = r103.f569639b;
        this.f1387j = r104 * 1.0f;
        this.f1388k = r103.f569642e;
        this.f1389l = (r103.f569644g - r104) / 2.0f;
    }

    @Override // a18.c
    public final void c(Canvas r100, Paint r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "paint");
        int r103 = this.f1393a.f569640c;
        int r104 = ColorUtils.setAlphaComponent(r103, (Color.alpha(r103) * this.f1395c) / 255);
        r101.setStyle(Paint.Style.STROKE);
        r101.setStrokeCap(Paint.Cap.BUTT);
        r101.setAntiAlias(true);
        r101.setColor(r104);
        r101.setStrokeWidth(this.f1387j);
        float r105 = this.f1389l;
        float r106 = -r105;
        r100.drawArc(new RectF(r106, r106, r105, r105), 0.0f, this.f1385h, false, r101);
    }

    @Override // a18.c
    public final void b(Canvas r110, Paint r111, float r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        if (0.0f != r112) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        r111.setStyle(Paint.Style.STROKE);
        r111.setStrokeCap(Paint.Cap.BUTT);
        r111.setAntiAlias(true);
        r111.setColor(r113);
        r111.setStrokeWidth(this.f1387j);
        float r101 = this.f1385h;
        float r102 = this.f1386i;
        float r114 = (r101 * 0.0f) * r102;
        if (r112 < 0.0f) goto L11;
        float r103 = r112 - 0.0f;
    L12:
        float r115 = (r103 * r101) * r102;
        float r104 = this.f1389l;
        float r105 = -r104;
        r110.drawArc(new RectF(r105, r105, r104, r104), r114, r115, false, r111);
        if (this.f1388k > 0.0f) goto L15;
        return;
    L15:
        if (Math.abs(r115) >= this.f1385h) goto L19;
        r111.setStyle(Paint.Style.FILL);
        float r106 = this.f1388k;
        float r107 = -r106;
        RectF r116 = new RectF(r107, r107, r106, r106);
        f(r110, r111, this.f1387j, this.f1388k, r114, true, r116);
        f(r110, r111, this.f1387j, this.f1388k, r114 + r115, false, r116);
        return;
    L19:
        return;
    L11:
        r103 = (1 + r112) - 0.0f;
        goto L12
    L5:
        r100 = false;
        goto L6
    }

    public final void f(Canvas r110, Paint r111, float r112, float r113, float r114, boolean r115, RectF r116) {
        if (r115 == false) goto L5;
        float r100 = -1.0f;
    L6:
        r110.save();
        r110.rotate(r114);
        float r101 = 2;
        float r117 = r112 / r101;
        float r102 = r100 * r113;
        r110.drawRect((this.f1389l - r117) + r113, Math.min(0.0f, this.f1386i * r102), (this.f1389l + r117) - r113, Math.max(0.0f, r102 * this.f1386i), r111);
        r110.translate((this.f1389l - r117) + r113, 0.0f);
        r110.drawArc(r116, this.f1384g, ((-r100) * this.f1383f) * this.f1386i, true, r111);
        r110.translate(r112 - (r101 * r113), 0.0f);
        r110.drawArc(r116, 0.0f, (r100 * this.f1383f) * this.f1386i, true, r111);
        r110.restore();
        return;
    L5:
        r100 = 1.0f;
        goto L6
    }
}
