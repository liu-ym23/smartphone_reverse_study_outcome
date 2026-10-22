package br3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f20125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f20126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f20127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f20128d;

    /* JADX INFO: renamed from: br3.a$a, reason: collision with other inner class name */
    public static final class C0345a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Rect r100 = getBounds();
        if (Intrinsics.areEqual(r100, this.f20126b) == true) goto L6;
        Paint r101 = this.f20125a;
        float r102 = r100.left;
        r101.setShader(new LinearGradient(r102, r100.top, r102, r100.bottom, this.f20127c, this.f20128d, Shader.TileMode.CLAMP));
        this.f20126b = r100;
    L6:
        r110.drawRect(getBounds(), this.f20125a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f20125a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f20125a.setColorFilter(r100);
    }

    public a(int[] r100, float[] r101) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        this.f20127c = r100;
        this.f20128d = r101;
        this.f20125a = new Paint(1);
    }
}
