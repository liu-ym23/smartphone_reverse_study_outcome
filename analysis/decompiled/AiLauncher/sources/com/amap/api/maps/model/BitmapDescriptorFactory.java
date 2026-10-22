package com.amap.api.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.col.jmsl.A;
import com.amap.api.col.jmsl.C1570k;
import com.amap.api.col.jmsl.C1585n2;
import com.amap.api.col.jmsl.S2;
import com.zyql.ai.selector.config.PictureMimeType;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: classes.dex */
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
    private static int nextId;

    public static BitmapDescriptor defaultMarker() {
        try {
            return fromAsset("marker_default.png");
        } catch (Throwable th) {
            C1570k.j(th);
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        Bitmap bitmapDecodeStream;
        try {
            Context context = getContext();
            if (context == null) {
                InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + str);
                Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(resourceAsStream);
                resourceAsStream.close();
                return fromBitmap(bitmapDecodeStream2);
            }
            HashMap<String, Long> map = C1570k.f16700b;
            try {
                InputStream inputStreamOpen = S2.a(context).open(str);
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                inputStreamOpen.close();
            } catch (Throwable th) {
                C1570k.j(th);
                bitmapDecodeStream = null;
            }
            return fromBitmap(bitmapDecodeStream);
        } catch (Throwable th2) {
            C1570k.j(th2);
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            if (nextId == Integer.MAX_VALUE) {
                nextId = 0;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("localhost_amap_bimapcom.amap.api.icon_");
            int i10 = nextId + 1;
            nextId = i10;
            sb2.append(i10);
            return new BitmapDescriptor(bitmap, sb2.toString());
        } catch (Throwable th) {
            C1570k.j(th);
            A.a("[map][function][res]", "read bitmap from bitmap failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
            fileInputStreamOpenFileInput.close();
            BitmapDescriptor bitmapDescriptorFromBitmap = fromBitmap(bitmapDecodeStream);
            C1570k.f(bitmapDecodeStream);
            return bitmapDescriptorFromBitmap;
        } catch (Throwable th) {
            C1570k.j(th);
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Throwable th) {
            C1570k.j(th);
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i10) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(BitmapFactory.decodeStream(context.getResources().openRawResource(i10)));
            }
            return null;
        } catch (Throwable th) {
            C1570k.j(th);
            return null;
        }
    }

    public static BitmapDescriptor fromView(View view) {
        try {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.addView(view);
            frameLayout.setDrawingCacheEnabled(true);
            return fromBitmap(C1570k.b(frameLayout));
        } catch (Throwable th) {
            C1570k.j(th);
            return null;
        }
    }

    public static Context getContext() {
        return C1585n2.f16776f;
    }

    public static BitmapDescriptor defaultMarker(float f10) {
        try {
            float f11 = (((int) (f10 + 15.0f)) / 30) * 30;
            float f12 = 330;
            if (f11 > f12) {
                f11 = f12;
            } else if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            return fromAsset((f11 == 0.0f ? "RED" : f11 == 30.0f ? "ORANGE" : f11 == 60.0f ? "YELLOW" : f11 == 120.0f ? "GREEN" : f11 == 180.0f ? "CYAN" : f11 == 210.0f ? "AZURE" : f11 == 240.0f ? "BLUE" : f11 == 270.0f ? "VIOLET" : f11 == 300.0f ? "MAGENTA" : f11 == 330.0f ? "ROSE" : "") + PictureMimeType.PNG);
        } catch (Throwable th) {
            C1570k.j(th);
            return null;
        }
    }
}
