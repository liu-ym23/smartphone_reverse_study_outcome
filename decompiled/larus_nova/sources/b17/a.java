package b17;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f16929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Matrix f16933e;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public final void a() {
        if (this.f16929a == null) goto L6;
        RectF r100 = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f16933e = g.e(this.f16929a, this.f16931c, this.f16932d, r100, r100, this.f16930b);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        if (this.f16929a == null) goto L6;
        r100.concat(this.f16933e);
        this.f16929a.draw(r100);
        return;
    }

    public a(int r100, int r101) {
        this.f16931c = r100;
        this.f16932d = r101;
    }
}
