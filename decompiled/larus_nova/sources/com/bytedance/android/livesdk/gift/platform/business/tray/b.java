package com.bytedance.android.livesdk.gift.platform.business.tray;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f130269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientDrawable f130270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f130271c;

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

    public b() {
        this.f130270b = new GradientDrawable();
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        Unit r101 = Unit.INSTANCE;
        this.f130271c = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Rect r100 = getBounds();
        int r101 = Math.max(0, r100.height() - this.f130269a);
        r110.drawRect(0.0f, 0.0f, r100.width(), r101, this.f130271c);
        this.f130270b.setBounds(0, r101, r100.width(), r100.height());
        this.f130270b.draw(r110);
    }
}
