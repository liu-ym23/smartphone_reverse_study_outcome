package com.amap.api.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.mapcore.util.b0;
import com.amap.api.mapcore.util.n3;
import com.amap.api.mapcore.util.p3;
import com.amap.api.mapcore.util.w3;
import com.amap.api.mapcore.util.z3;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes28.dex */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static final String ICON_ID_PREFIX = "com.amap.api.icon_";

    public static BitmapDescriptor defaultMarker() {
        return fromAsset(n3.f27631b.name() + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT);
    L4:
        th = move-exception;
        w3.a(th);
        return null;
    }

    public BitmapDescriptorFactory() {
    }

    public static Context getContext() {
        return b0.f27047f;
    }

    public static BitmapDescriptor defaultMarker(float r100) {
    L43:
        th = move-exception;
        w3.a(th);
        return null;
    L4:
        float r101 = (((int) (r100 + 15.0f)) / 30) * 30;
        float r102 = 330;
        if (r101 <= r102) goto L8;
        r101 = r102;
    L11:
        if (r101 != 0.0f) goto L14;
        String r103 = "RED";
    L41:
        return fromAsset(r103.concat(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT));
    L14:
        if (r101 != 30.0f) goto L17;
        r103 = "ORANGE";
        goto L41
    L17:
        if (r101 != 60.0f) goto L20;
        r103 = "YELLOW";
        goto L41
    L20:
        if (r101 != 120.0f) goto L23;
        r103 = "GREEN";
        goto L41
    L23:
        if (r101 != 180.0f) goto L26;
        r103 = "CYAN";
        goto L41
    L26:
        if (r101 != 210.0f) goto L29;
        r103 = "AZURE";
        goto L41
    L29:
        if (r101 != 240.0f) goto L32;
        r103 = "BLUE";
        goto L41
    L32:
        if (r101 != 270.0f) goto L35;
        r103 = "VIOLET";
        goto L41
    L35:
        if (r101 != 300.0f) goto L38;
        r103 = "MAGENTA";
        goto L41
    L38:
        if (r101 != 330.0f) goto L40;
        r103 = "ROSE";
        goto L41
    L40:
        r103 = "";
        goto L41
    L8:
        if (r101 >= 0.0f) goto L11;
        r101 = 0.0f;
        goto L11
    }

    public static BitmapDescriptor fromAsset(String r100) {
        Bitmap r101 = p3.b(getContext(), r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L6;
        InputStream r102 = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + r100);     // Catch: Throwable -> L12
        if (r102 == null) goto L11;
        Bitmap r103 = BitmapFactory.decodeStream(r102);     // Catch: Throwable -> L12
        r102.close();     // Catch: Throwable -> L12
        return fromBitmap(r103);
    L11:
        return null;
    L6:
        return fromBitmap(r101);
    L12:
        th = move-exception;
        w3.a(th);
        z3.a("[map][function][res]", "read bitmap from assets failed " + th.getMessage());
        return null;
    }

    public static BitmapDescriptor fromBitmap(Bitmap r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return new BitmapDescriptor(r100, ICON_ID_PREFIX + w3.a());
    L7:
        th = move-exception;
        w3.a(th);
        z3.a("[map][function][res]", "read bitmap from bitmap failed " + th.getMessage());
        return null;
    }

    public static BitmapDescriptor fromFile(String r100) {
        Context r101 = getContext();     // Catch: Throwable -> L8
        if (r101 == null) goto L7;
        FileInputStream r102 = r101.openFileInput(r100);     // Catch: Throwable -> L8
        Bitmap r103 = BitmapFactory.decodeStream(r102);     // Catch: Throwable -> L8
        r102.close();     // Catch: Throwable -> L8
        BitmapDescriptor r104 = fromBitmap(r103);     // Catch: Throwable -> L8
        w3.a(r103);     // Catch: Throwable -> L8
        return r104;
    L7:
        return null;
    L8:
        th = move-exception;
        w3.a(th);
        z3.a("[map][function][res]", "read bitmap from disk failed " + th.getMessage());
        return null;
    }

    public static BitmapDescriptor fromPath(String r100) {
        return fromBitmap(BitmapFactory.decodeFile(r100));
    L4:
        th = move-exception;
        w3.a(th);
        z3.a("[map][function][res]", "read bitmap from disk failed " + th.getMessage());
        return null;
    }

    public static BitmapDescriptor fromResource(int r100) {
        Context r101 = getContext();     // Catch: Throwable -> L8
        if (r101 == null) goto L7;
        return fromBitmap(BitmapFactory.decodeStream(r101.getResources().openRawResource(r100)));
    L7:
        return null;
    L8:
        th = move-exception;
        w3.a(th);
        z3.a("[map][function][res]", "read bitmap from res failed " + th.getMessage());
        return null;
    }

    public static BitmapDescriptor fromView(View r100) {
        Context r101 = getContext();     // Catch: Throwable -> L8
        if (r101 == null) goto L7;
        FrameLayout r102 = new FrameLayout(r101);     // Catch: Throwable -> L8
        r102.addView(r100);     // Catch: Throwable -> L8
        r102.setDrawingCacheEnabled(true);     // Catch: Throwable -> L8
        return fromBitmap(w3.a(r102));
    L7:
        return null;
    L8:
        th = move-exception;
        w3.a(th);
        z3.a("[map][function][res]", "read bitmap from view failed " + th.getMessage());
        return null;
    }
}
