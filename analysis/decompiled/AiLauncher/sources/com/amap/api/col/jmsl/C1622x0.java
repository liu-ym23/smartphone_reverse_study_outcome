package com.amap.api.col.jmsl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* renamed from: com.amap.api.col.jmsl.x0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1622x0 extends View {

    /* renamed from: b, reason: collision with root package name */
    public static final int f17028b = Color.argb(255, 235, 235, 235);

    /* renamed from: a, reason: collision with root package name */
    public Paint f17029a;

    static {
        Color.argb(255, 21, 21, 21);
    }

    public C1622x0(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f17029a = paint;
        paint.setAntiAlias(true);
        this.f17029a.setColor(f17028b);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f17029a);
    }
}
