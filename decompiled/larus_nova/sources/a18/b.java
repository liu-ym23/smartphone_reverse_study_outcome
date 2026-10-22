package a18;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f1391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f1392g;

    @Override // a18.c
    public final int e() {
        return -1;
    }

    @Override // a18.c
    public final int d() {
        return this.f1393a.f569639b;
    }

    public b(z08.b r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        super(r100);
        this.f1390e = 300.0f;
    }

    @Override // a18.c
    public final void a(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Rect r101 = r100.getClipBounds();
        this.f1390e = r101.width();
        float r102 = this.f1393a.f569639b;
        r100.translate(r101.width() / 2.0f, (r101.height() / 2.0f) + Math.max(0.0f, (r101.height() - this.f1393a.f569639b) / 2.0f));
        float r103 = this.f1390e;
        float r104 = 2;
        r100.clipRect((-r103) / r104, (-r102) / r104, r103 / r104, r102 / r104);
        z08.b r105 = this.f1393a;
        this.f1391f = r105.f569639b * 1.0f;
        this.f1392g = r105.f569642e;
    }

    @Override // a18.c
    public final void c(Canvas r110, Paint r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        float r100 = 2;
        float r101 = ((-this.f1390e) / r100) + this.f1392g;
        float r113 = -r101;
        r111.setStyle(Paint.Style.FILL);
        r111.setAntiAlias(true);
        r111.setColor(r112);
        float r114 = this.f1391f;
        r110.drawRect(r101, (-r114) / r100, r113, r114 / r100, r111);
        float r102 = this.f1392g;
        float r103 = -r102;
        RectF r115 = new RectF(r103, r103, r102, r102);
        f(r110, r111, this.f1391f, this.f1392g, r101, true, r115);
        f(r110, r111, this.f1391f, this.f1392g, r113, false, r115);
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
        float r101 = this.f1390e;
        float r102 = 2;
        float r103 = this.f1392g;
        float r104 = ((-r101) / r102) + r103;
        float r105 = r101 - (r103 * r102);
        float r106 = r104 + (0.0f * r105);
        float r114 = r104 + (r105 * r112);
        r111.setStyle(Paint.Style.FILL);
        r111.setAntiAlias(true);
        r111.setColor(r113);
        float r107 = this.f1391f;
        r110.drawRect(r106, (-r107) / r102, r114, r107 / r102, r111);
        float r108 = this.f1392g;
        float r109 = -r108;
        RectF r115 = new RectF(r109, r109, r108, r108);
        f(r110, r111, this.f1391f, this.f1392g, r106, true, r115);
        f(r110, r111, this.f1391f, this.f1392g, r114 - 1, false, r115);
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void f(Canvas r110, Paint r111, float r112, float r113, float r114, boolean r115, RectF r116) {
        r110.save();
        r110.translate(r114, 0.0f);
        if (r115 == true) goto L5;
        r110.rotate(180.0f);
    L5:
        float r100 = 2;
        float r101 = ((-r112) / r100) + r113;
        float r102 = (r112 / r100) - r113;
        r110.drawRect(-r113, r101, 0.0f, r102, r111);
        r110.save();
        r110.translate(0.0f, r101);
        r110.drawArc(r116, 180.0f, 90.0f, true, r111);
        r110.restore();
        r110.translate(0.0f, r102);
        r110.drawArc(r116, 180.0f, -90.0f, true, r111);
        r110.restore();
    }
}
