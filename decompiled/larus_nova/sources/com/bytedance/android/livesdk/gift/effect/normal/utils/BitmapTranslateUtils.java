package com.bytedance.android.livesdk.gift.effect.normal.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
public final class BitmapTranslateUtils {

    public static final enum CenterType extends Enum<CenterType> {
        public static final CenterType HORIZONTAL = null;
        public static final CenterType VERTICAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CenterType[] f126043a = null;

        static {
            CenterType r100 = new CenterType("VERTICAL", 0);
            VERTICAL = r100;
            CenterType r101 = new CenterType("HORIZONTAL", 1);
            HORIZONTAL = r101;
            f126043a = new CenterType[]{r100, r101};
        }

        public static CenterType[] values() {
            return (CenterType[]) f126043a.clone();
        }

        public static CenterType valueOf(String r100) {
            return (CenterType) a.a(CenterType.class, r100);
        }

        public CenterType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static Bitmap a(View r100) {
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r100.layout(0, 0, r100.getMeasuredWidth(), r100.getMeasuredHeight());
        r100.setDrawingCacheEnabled(true);
        Bitmap r101 = r100.getDrawingCache();     // Catch: Exception -> L7
        if (r101 != null) goto L8;
        r101 = d(r100);     // Catch: Exception -> L7
    L8:
        Bitmap r102 = r101.copy(Bitmap.Config.ARGB_8888, true);
        r100.destroyDrawingCache();
        r100.setDrawingCacheEnabled(false);
        return r102;
    L7:
        r101 = d(r100);
        goto L8
    }

    public static Bitmap b(Bitmap r110) {
        int r100 = Math.min(r110.getWidth(), r110.getHeight()) / 2;     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Point r101 = new Point(r110.getWidth() / 2, r110.getHeight() / 2);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        if (r110.getWidth() <= r110.getHeight()) goto L5;
        CenterType r102 = CenterType.HORIZONTAL;     // Catch: OutOfMemoryError -> L12 Exception -> L14
    L6:
        int r103 = r100 * 2;     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Bitmap r104 = Bitmap.createBitmap(r103, r103, Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Canvas r105 = new Canvas(r104);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Paint r106 = new Paint();     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Rect r107 = new Rect(0, 0, r103, r103);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        RectF r108 = new RectF(new Rect(0, 0, r103, r103));     // Catch: OutOfMemoryError -> L12 Exception -> L14
        float r111 = Math.min(r110.getWidth(), r110.getHeight()) / 2;     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r106.setAntiAlias(true);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r105.drawARGB(0, 0, 0, 0);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r106.setColor(-16777216);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r105.drawRoundRect(r108, r111, r111, r106);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r106.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));     // Catch: OutOfMemoryError -> L12 Exception -> L14
        if (r102 != CenterType.HORIZONTAL) goto L9;
        int r109 = r101.x;     // Catch: OutOfMemoryError -> L12 Exception -> L14
        Rect r112 = new Rect(r109 - r100, 0, r109 + r100, r103);     // Catch: OutOfMemoryError -> L12 Exception -> L14
    L10:
        r105.drawBitmap(r110, r112, r107, r106);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        return r104;
        goto L17
    L9:
        int r113 = r101.y;     // Catch: OutOfMemoryError -> L12 Exception -> L14
        r112 = new Rect(0, r113 - r100, r103, r113 + r100);     // Catch: OutOfMemoryError -> L12 Exception -> L14
        goto L10
    L5:
        r102 = CenterType.VERTICAL;     // Catch: OutOfMemoryError -> L12 Exception -> L14
    L12:
        return null;
    L17:
        return r110;
    }

    public static Bitmap c(View r100) {
        Bitmap r101 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        r100.draw(new Canvas(r101));
        if (r100.isDirty() == false) goto L5;
        r100.postInvalidate();
    L5:
        return r101;
    }

    public static Bitmap d(View r100) {
        Bitmap r101 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r102 = new Canvas(r101);
        r100.layout(0, 0, r100.getMeasuredWidth(), r100.getMeasuredHeight());
        r100.draw(r102);
        return r101;
    }
}
