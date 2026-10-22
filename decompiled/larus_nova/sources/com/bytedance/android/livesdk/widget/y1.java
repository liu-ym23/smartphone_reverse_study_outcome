package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class y1 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f162260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f162261b;

    public y1(Context r100) {
        super(r100);
        Paint r101 = new Paint();
        this.f162261b = r101;
        r101.setColor(-65536);
        r101.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.drawRect(this.f162260a, this.f162261b);
    }
}
