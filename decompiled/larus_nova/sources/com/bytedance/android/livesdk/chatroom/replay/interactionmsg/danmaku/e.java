package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f109054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f109055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f109056c;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public e(int r100) {
        Paint r101 = new Paint(1);
        r101.setColor(r100);
        r101.setStyle(Paint.Style.FILL);
        Unit r102 = Unit.INSTANCE;
        this.f109054a = r101;
        this.f109055b = new RectF();
        this.f109056c = -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f109055b.set(getBounds());
        int r101 = this.f109056c;
        if (r101 < 0) goto L5;
        RectF r102 = this.f109055b;
        r102.right = r102.left + r101;
    L5:
        RectF r103 = this.f109055b;
        float r104 = 2;
        r100.drawRoundRect(r103, r103.height() / r104, this.f109055b.height() / r104, this.f109054a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f109054a.setAlpha(r100);
        invalidateSelf();
    }
}
