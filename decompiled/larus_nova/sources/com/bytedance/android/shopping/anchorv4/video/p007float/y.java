package com.bytedance.android.shopping.anchorv4.video.p007float;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import com.bytedance.android.shopping.extensions.b;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class y extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f167666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f167667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f167668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ z f167669d;

    @Override // android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        r100.drawRect(this.f167667b, this.f167666a);
        if (this.f167669d.f167676h == false) goto L6;
        r100.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f167668c);
        return;
    }

    public y(z r100, Context r101) {
        this.f167669d = r100;
        super(r101);
        r100.f167677i = this;
        Paint r102 = new Paint();
        r102.setStyle(Paint.Style.FILL);
        Unit r103 = Unit.INSTANCE;
        this.f167666a = r102;
        this.f167667b = new RectF();
        Paint r104 = new Paint();
        r104.setStyle(Paint.Style.FILL);
        r104.setColor(504764451);
        this.f167668c = r104;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        this.f167667b.set(0.0f, r110 - b.a(26), r100, r110);
        Paint r101 = this.f167666a;
        RectF r113 = this.f167667b;
        r101.setShader(new LinearGradient(0.0f, r113.top, 0.0f, r113.bottom, 0, 1711276032, Shader.TileMode.CLAMP));
    }
}
