package a18;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class c extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z08.b f1393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f1394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f1396d;

    public abstract void a(Canvas r100);

    public abstract void b(Canvas r100, Paint r101, float r102, int r103);

    public abstract void c(Canvas r100, Paint r101, int r102);

    public abstract int d();

    public abstract int e();

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f1395c;
    }

    public c(z08.b r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        this.f1393a = r100;
        this.f1394b = new Paint();
        this.f1395c = 255;
        this.f1396d = new Rect();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L7;
        return;
    L7:
        if (r100.getClipBounds(this.f1396d) == false) goto L13;
        r100.save();
        a(r100);
        int r101 = this.f1393a.f569640c;
        c(r100, this.f1394b, ColorUtils.setAlphaComponent(r101, (Color.alpha(r101) * this.f1395c) / 255));
        int r102 = this.f1393a.f569641d;
        b(r100, this.f1394b, this.f1393a.f569643f / 100.0f, ColorUtils.setAlphaComponent(r102, (Color.alpha(r102) * this.f1395c) / 255));
        r100.restore();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f1395c = r100;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f1394b.setColorFilter(r100);
        invalidateSelf();
    }
}
