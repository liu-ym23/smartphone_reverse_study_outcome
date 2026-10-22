package com.bytedanceos.common.utils;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$color;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {
    public static byte[] a(Bitmap r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        r10.compress(Bitmap.CompressFormat.PNG, 100, r11);
        r10.recycle();
        byte[] r12 = r11.toByteArray();
        r11.close();     // Catch: Exception -> L5
    L7:
        return r12;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static byte[] b(Bitmap r10, boolean r11) {
        return a(c(r10, 90, r11));
    }

    public static Bitmap c(Bitmap r10, int r11, boolean r12) {
        int r13 = Math.min(r10.getHeight(), r10.getWidth());
        if (r13 > r11) goto L6;
        r11 = r13;
    L6:
        Bitmap r14 = Bitmap.createScaledBitmap(r10, r11, r11, true);
        if (r12 == false) goto L9;
        r10.recycle();
    L9:
        Bitmap r15 = Bitmap.createBitmap(r11, r11, Bitmap.Config.ARGB_8888);
        new Canvas(r15).drawBitmap(r14, new Rect(0, 0, r11, r11), new Rect(0, 0, r11, r11), null);
        r14.recycle();
        return r15;
    }

    public static Bitmap d(String r10, Bitmap r11, float r12) {
        Bitmap r13 = Bitmap.createBitmap(r11.getWidth(), r11.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: RuntimeException -> L4
        Canvas r14 = new Canvas(r13);     // Catch: RuntimeException -> L4
        r14.drawBitmap(r11, 0.0f, 0.0f, null);     // Catch: RuntimeException -> L4
        g(r14, r12);     // Catch: RuntimeException -> L4
        r11.recycle();     // Catch: RuntimeException -> L4
        return r13;
    L4:
        return r11;
    }

    public static Bitmap e(Context r10, String r11) {
        File r12 = new File(r11);
        if (r12.exists() == true) goto L7;
        return null;
    L7:
        return BitmapFactory.decodeFile(r12.getAbsolutePath());
    }

    public static TransitionDrawable f(int r10) {
        Bitmap r11 = BitmapFactory.decodeResource(BaseApplication.c().getResources(), r10);
        return new TransitionDrawable(new Drawable[]{new ColorDrawable(BaseApplication.c().getResources().getColor(R.color.transparent)), new BitmapDrawable(BaseApplication.c().getResources(), r11)});
    }

    public static void g(Canvas r10, float r11) {
        Rect r12 = r10.getClipBounds();
        Paint r13 = new Paint();
        r13.setColor(BaseApplication.c().getResources().getColor(R$color.header_view_icon_color_border));
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeWidth(1.0f);
        r13.setAntiAlias(true);
        r13.setDither(true);
        r13.setFilterBitmap(true);
        r10.drawRoundRect(new RectF(r12), r11, r11, r13);
    }

    public static Bitmap h(Bitmap r10, double r11, double r12) {
        float r13 = r10.getWidth();
        float r14 = r10.getHeight();
        Matrix r15 = new Matrix();
        r15.postScale(((float) r11) / r13, ((float) r12) / r14);
        return Bitmap.createBitmap(r10, 0, 0, (int) r13, (int) r14, r15, true);
    }
}
