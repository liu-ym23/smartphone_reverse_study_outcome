package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.TextOptions;

/* JADX INFO: loaded from: classes28.dex */
public class r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Paint f27923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Rect f27924b;

    public static float a(int r100, boolean r101) {
        if (r101 == false) goto L13;
        if (r100 != 1) goto L7;
        return 0.0f;
    L7:
        if (r100 != 2) goto L21;
        return 1.0f;
    L21:
        return 0.5f;
    L13:
        if (r100 != 8) goto L15;
        return 0.0f;
    L15:
        if (r100 != 16) goto L23;
        return 1.0f;
    L23:
        return 0.5f;
    }

    static {
        f27923a = new Paint();
        f27924b = new Rect();
    }

    public static BitmapDescriptor a(TextOptions r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        f27923a.setTypeface(r100.getTypeface());
        f27923a.setSubpixelText(true);
        f27923a.setAntiAlias(true);
        f27923a.setStrokeWidth(5.0f);
        f27923a.setStrokeCap(Paint.Cap.ROUND);
        f27923a.setTextSize(r100.getFontSize());
        f27923a.setTextAlign(Paint.Align.CENTER);
        f27923a.setColor(r100.getFontColor());
        Paint.FontMetrics r101 = f27923a.getFontMetrics();
        int r102 = (int) (r101.descent - r101.ascent);
        int r103 = (int) (((r102 - r101.bottom) - r101.top) / 2.0f);
        if (r100.getText() == null) goto L8;
        f27923a.getTextBounds(r100.getText(), 0, r100.getText().length(), f27924b);
    L8:
        Bitmap r104 = Bitmap.createBitmap(f27924b.width() + 6, r102, Bitmap.Config.ARGB_8888);
        Canvas r105 = new Canvas(r104);
        r105.drawColor(r100.getBackgroundColor());
        if (r100.getText() == null) goto L12;
        r105.drawText(r100.getText(), f27924b.centerX() + 3, r103, f27923a);
    L12:
        return BitmapDescriptorFactory.fromBitmap(r104);
    }

    public static MarkerOptions b(TextOptions r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        MarkerOptions r101 = new MarkerOptions();
        r101.position(r100.getPosition());
        r101.visible(r100.isVisible());
        r101.zIndex(r100.getZIndex());
        r101.rotateAngle(r100.getRotate());
        r101.icon(a(r100));
        r101.anchor(a(r100.getAlignX(), true), a(r100.getAlignY(), false));
        return r101;
    }
}
