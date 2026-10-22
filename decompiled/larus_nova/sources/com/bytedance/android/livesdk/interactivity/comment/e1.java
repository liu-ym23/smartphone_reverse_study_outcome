package com.bytedance.android.livesdk.interactivity.comment;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e1 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f134859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f134860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f134861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f134862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f134863e;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public e1() {
        this.f134859a = new Paint(1);
        this.f134860b = new RectF();
        this.f134861c = 1.0f;
        this.f134862d = ColorProtector.parseColor("#4D000000");
        this.f134863e = ColorProtector.parseColor("#4DFFFFFF");
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f134860b.set(getBounds());
        this.f134860b.right -= this.f134861c;
        this.f134859a.setColor(this.f134862d);
        this.f134859a.setStyle(Paint.Style.FILL);
        RectF r101 = this.f134860b;
        float r102 = 2;
        r100.drawRoundRect(r101, r101.height() / r102, this.f134860b.height() / r102, this.f134859a);
        this.f134859a.setColor(this.f134863e);
        this.f134859a.setStyle(Paint.Style.STROKE);
        this.f134859a.setStrokeWidth(this.f134861c);
        RectF r103 = this.f134860b;
        float r104 = this.f134861c;
        r103.inset(r104 / r102, r104 / r102);
        RectF r105 = this.f134860b;
        r100.drawRoundRect(r105, r105.height() / r102, this.f134860b.height() / r102, this.f134859a);
    }
}
