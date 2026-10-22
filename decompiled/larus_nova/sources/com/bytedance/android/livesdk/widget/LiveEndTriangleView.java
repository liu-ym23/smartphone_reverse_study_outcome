package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: classes11.dex */
public class LiveEndTriangleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f160974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f160975b;

    public LiveEndTriangleView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        this.f160975b.moveTo(0.0f, getMeasuredHeight());
        this.f160975b.lineTo(getMeasuredWidth(), getMeasuredHeight());
        this.f160975b.lineTo(getMeasuredWidth() / 2, 0.0f);
        this.f160975b.close();
        r100.drawPath(this.f160975b, this.f160974a);
    }

    public LiveEndTriangleView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LiveEndTriangleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        Paint r103 = new Paint();
        this.f160974a = r103;
        r103.setAntiAlias(true);
        this.f160974a.setStyle(Paint.Style.FILL);
        this.f160974a.setColor(ColorProtector.parseColor("#14ffffff"));
        this.f160975b = new Path();
    }
}
