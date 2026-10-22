package com.bytedance.android.livesdk.interactivity.barrage.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f134059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f134060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f134061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f134062d;

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

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        this.f134061c.set(getBounds());
        RectF r100 = this.f134061c;
        float r101 = this.f134059a;
        float r102 = 2;
        r100.inset(r101 / r102, r101 / r102);
        if (this.f134062d == null) goto L5;
        RectF r103 = this.f134061c;
        float r104 = r103.right - r103.left;
        Paint r105 = this.f134060b;
        int r106 = com.bytedance.android.livesdk.interactivity.utils.b.c((String) ListProtector.get(this.f134062d, 0));
        List<String> r107 = this.f134062d;
        r105.setShader(new LinearGradient(0.0f, 1.0f, r104, 1.0f, r106, com.bytedance.android.livesdk.interactivity.utils.b.c((String) ListProtector.get(r107, r107.size() - 1)), Shader.TileMode.CLAMP));
    L5:
        RectF r108 = this.f134061c;
        r110.drawRoundRect(r108, r108.height() / r102, this.f134061c.height() / r102, this.f134060b);
    }

    public b(int r100, List r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f134062d = r101;
        float r103 = UtilityKotlinExtentionsKt.h(1);
        this.f134059a = r103;
        Paint r104 = new Paint(1);
        r104.setColor(r100);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(r103);
        Unit r105 = Unit.INSTANCE;
        this.f134060b = r104;
        this.f134061c = new RectF();
    }
}
