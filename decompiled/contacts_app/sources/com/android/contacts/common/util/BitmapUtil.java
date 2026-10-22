package com.android.contacts.common.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class BitmapUtil {
    public static int findOptimalSampleSize(int r5, int r6) {
        if (r6 >= 1) goto L5;
        return 1;
    L5:
        if (r5 >= 1) goto L7;
        return 1;
    L7:
        int r1 = 1;
    L8:
        r5 = r5 >> 1;
        if (r5 < (r6 * 0.8f)) goto L11;
        r1 = r1 << 1;
        goto L8
    L11:
        return r1;
    }

    private BitmapUtil() {
    }

    public static int getSmallerExtentFromBytes(byte[] r3) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(r3, 0, r3.length, r0);
        return Math.min(r0.outWidth, r0.outHeight);
    }

    public static Bitmap decodeBitmapFromBytes(byte[] r2, int r3) {
        if (r3 > 1) goto L5;
        BitmapFactory.Options r4 = null;
    L7:
        return BitmapFactory.decodeByteArray(r2, 0, r2.length, r4);
    L5:
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inSampleSize = r3;
        r4 = r0;
        goto L7
    }

    public static Drawable getRotatedDrawable(Resources r4, int r5, float r6) {
        Bitmap r7 = BitmapFactory.decodeResource(r4, r5);
        Bitmap r0 = Bitmap.createBitmap(r7.getWidth(), r7.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        r1.rotate(r6, r7.getWidth() / 2, r7.getHeight() / 2);
        r1.drawBitmap(r7, 0.0f, 0.0f, null);
        return new BitmapDrawable(r4, r0);
    }

    public static Bitmap getRoundedBitmap(Bitmap r9, int r10, int r11) {
        if (r9 != null) goto L5;
        return null;
    L5:
        Bitmap.Config r0 = r9.getConfig();
        if (r0 != null) goto L9;
        r0 = Bitmap.Config.ARGB_8888;
    L9:
        Bitmap r1 = Bitmap.createBitmap(r10, r11, r0);
        Canvas r2 = new Canvas(r1);
        Paint r3 = new Paint();
        r2.drawARGB(0, 0, 0, 0);
        r3.setAntiAlias(true);
        float r12 = r10;
        float r13 = r11;
        RectF r4 = new RectF(0.0f, 0.0f, r12, r13);
        r2.drawOval(r4, r3);
        r3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        int r5 = r9.getWidth();
        int r6 = r9.getHeight();
        float r7 = Math.min(r5 / r12, r6 / r13);
        int r14 = (int) ((r12 * r7) / 2.0f);
        int r15 = (int) ((r7 * r13) / 2.0f);
        int r8 = r5 / 2;
        int r16 = r6 / 2;
        r2.drawBitmap(r9, new Rect(r8 - r14, r16 - r15, r8 + r14, r16 + r15), r4, r3);
        return r1;
    }
}
