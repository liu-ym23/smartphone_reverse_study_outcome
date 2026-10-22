package com.bytedance.android.live.revenue.common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class RevBitmapTranslateUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90807a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/common/RevBitmapTranslateUtils$CenterType;", "", "VERTICAL", "HORIZONTAL", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum CenterType extends Enum<CenterType> {
        public static final CenterType HORIZONTAL = null;
        public static final CenterType VERTICAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CenterType[] f90808a = null;

        static {
            CenterType r100 = new CenterType("VERTICAL", 0);
            VERTICAL = r100;
            CenterType r101 = new CenterType("HORIZONTAL", 1);
            HORIZONTAL = r101;
            f90808a = new CenterType[]{r100, r101};
        }

        public static CenterType valueOf(String r100) {
            return (CenterType) r27.a.a(CenterType.class, r100);
        }

        public static CenterType[] values() {
            return (CenterType[]) f90808a.clone();
        }

        public CenterType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }

    public static Bitmap a(Bitmap r100) {
        Intrinsics.checkNotNull(r100);     // Catch: OutOfMemoryError -> L4
        return Bitmap.createBitmap(r100);
    L4:
        return null;
    }

    public static Bitmap b(Bitmap r110) {
        Intrinsics.checkNotNullParameter(r110, SimplayerImageStrategy.RESULT_BITMAP);
        int r100 = Math.min(r110.getWidth(), r110.getHeight()) / 2;     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Point r101 = new Point(r110.getWidth() / 2, r110.getHeight() / 2);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        if (r110.getWidth() <= r110.getHeight()) goto L6;
        CenterType r102 = CenterType.HORIZONTAL;     // Catch: OutOfMemoryError -> L13 Exception -> L15
    L7:
        int r103 = r100 * 2;     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Bitmap r104 = Bitmap.createBitmap(r103, r103, Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Canvas r105 = new Canvas(r104);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Paint r106 = new Paint();     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Rect r107 = new Rect(0, 0, r103, r103);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        RectF r108 = new RectF(new Rect(0, 0, r103, r103));     // Catch: OutOfMemoryError -> L13 Exception -> L15
        float r111 = Math.min(r110.getWidth(), r110.getHeight()) / 2;     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r106.setAntiAlias(true);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r105.drawARGB(0, 0, 0, 0);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r106.setColor(-16777216);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r105.drawRoundRect(r108, r111, r111, r106);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r106.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));     // Catch: OutOfMemoryError -> L13 Exception -> L15
        if (r102 != CenterType.HORIZONTAL) goto L10;
        int r109 = r101.x;     // Catch: OutOfMemoryError -> L13 Exception -> L15
        Rect r112 = new Rect(r109 - r100, 0, r109 + r100, r103);     // Catch: OutOfMemoryError -> L13 Exception -> L15
    L11:
        r105.drawBitmap(r110, r112, r107, r106);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        goto L19
    L18:
        return r104;
    L10:
        int r113 = r101.y;     // Catch: OutOfMemoryError -> L13 Exception -> L15
        r112 = new Rect(0, r113 - r100, r103, r113 + r100);     // Catch: OutOfMemoryError -> L13 Exception -> L15
        goto L11
    L6:
        r102 = CenterType.VERTICAL;     // Catch: OutOfMemoryError -> L13 Exception -> L15
    L13:
        return null;
    L19:
        return r110;
    }
}
