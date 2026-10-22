package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f181593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f181594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f181595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a0 f181596d;

    @Override // android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        r100.drawRect(this.f181594b, this.f181593a);
        if (this.f181596d.f181524h == false) goto L6;
        r100.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f181595c);
        return;
    }

    public z(a0 r100, Context r101) {
        this.f181596d = r100;
        super(r101);
        r100.f181525i = this;
        Paint r102 = new Paint();
        r102.setStyle(Paint.Style.FILL);
        Unit r103 = Unit.INSTANCE;
        this.f181593a = r102;
        this.f181594b = new RectF();
        Paint r104 = new Paint();
        r104.setStyle(Paint.Style.FILL);
        r104.setColor(504764451);
        this.f181595c = r104;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        this.f181594b.set(0.0f, r110 - com.bytedance.android.shopping.extensions.b.a(26), r100, r110);
        Paint r101 = this.f181593a;
        RectF r113 = this.f181594b;
        r101.setShader(new LinearGradient(0.0f, r113.top, 0.0f, r113.bottom, 0, 1711276032, Shader.TileMode.CLAMP));
    }
}
