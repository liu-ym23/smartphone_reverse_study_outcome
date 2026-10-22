package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TogetherComboView f129993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f129994b;

    public k(TogetherComboView r100, ImageView r101) {
        this.f129993a = r100;
        this.f129994b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Bitmap r111 = (Bitmap) r110;
        if (r111 == null) goto L20;
        float r100 = Math.min(r111.getWidth(), r111.getHeight()) / 2.0f;
        float r101 = 1.2f * r100;
        PointF r102 = new PointF(-r101, (r100 * 2) - r101);
        int r103 = RevBitmapTranslateUtils.f90807a;
        Intrinsics.checkNotNullParameter(r111, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r102, "maskPoint");
        Bitmap r104 = RevBitmapTranslateUtils.b(r111);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        if (r104 == null) goto L13;
        Bitmap r105 = Bitmap.createBitmap(r104.getWidth(), r104.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        Canvas r106 = new Canvas(r105);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        Paint r107 = new Paint();     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r107.setAntiAlias(true);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r106.drawARGB(0, 0, 0, 0);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r107.setColor(-16777216);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r107.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));     // Catch: OutOfMemoryError -> L11 Exception -> L12
        float r108 = r102.x;     // Catch: OutOfMemoryError -> L11 Exception -> L12
        float r109 = r102.y;     // Catch: OutOfMemoryError -> L11 Exception -> L12
        float r112 = 2.0f * r101;     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r106.drawRoundRect(new RectF(r108, r109, r108 + r112, r112 + r109), r101, r101, r107);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        Rect r113 = new Rect(0, 0, r104.getWidth(), r104.getHeight());     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r106.drawBitmap(r104, r113, r113, r107);     // Catch: OutOfMemoryError -> L11 Exception -> L12
        r111 = r105;
        goto L13
    L11:
        r111 = null;
    L13:
        ImageView r114 = this.f129994b;
        if (r114 == null) goto L16;
        r114.setImageBitmap(r111);
    L16:
        this.f129993a.invalidate();
        return;
    }
}
