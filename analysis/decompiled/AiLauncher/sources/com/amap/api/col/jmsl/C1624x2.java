package com.amap.api.col.jmsl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.api.col.jmsl.x2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1624x2 {
    public static float a(int i10) {
        return Color.alpha(i10) / 255.0f;
    }

    public static int b(byte[] bArr, int i10) {
        byte b10 = bArr[i10];
        byte b11 = bArr[i10 + 1];
        byte b12 = bArr[i10 + 2];
        return (bArr[i10 + 3] << 24) | (b10 & 255) | (b11 << 8) | (b12 << 16);
    }

    public static Drawable c(Context context, String str) throws Exception {
        int i10;
        Bitmap bitmap;
        InputStream inputStreamOpen = S2.a(context).open(str);
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
        int width = bitmapDecodeStream.getWidth();
        int height = bitmapDecodeStream.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i11 = 0; i11 < 32; i11++) {
            byteArrayOutputStream.write(0);
        }
        int i12 = width - 2;
        int[] iArr = new int[i12];
        bitmapDecodeStream.getPixels(iArr, 0, width, 1, 0, i12, 1);
        boolean z10 = iArr[0] == -16777216;
        boolean z11 = iArr[width - 3] == -16777216;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i12; i15++) {
            if (i13 != iArr[i15]) {
                i14++;
                h(byteArrayOutputStream, i15);
                i13 = iArr[i15];
            }
        }
        if (z11) {
            i14++;
            h(byteArrayOutputStream, i12);
        }
        int i16 = i14;
        int i17 = i16 + 1;
        if (z10) {
            i17 = i16;
        }
        if (z11) {
            i17--;
        }
        int i18 = i17;
        int i19 = height - 2;
        int[] iArr2 = new int[i19];
        bitmapDecodeStream.getPixels(iArr2, 0, 1, 0, 1, 1, i19);
        boolean z12 = iArr2[0] == -16777216;
        boolean z13 = iArr2[height - 3] == -16777216;
        int i20 = 0;
        int i21 = 0;
        for (int i22 = 0; i22 < i19; i22++) {
            if (i20 != iArr2[i22]) {
                i21++;
                h(byteArrayOutputStream, i22);
                i20 = iArr2[i22];
            }
        }
        if (z13) {
            i21++;
            h(byteArrayOutputStream, i19);
        }
        int i23 = i21 + 1;
        if (z12) {
            i23 = i21;
        }
        if (z13) {
            i23--;
        }
        int i24 = 0;
        while (true) {
            i10 = i18 * i23;
            if (i24 >= i10) {
                break;
            }
            h(byteArrayOutputStream, 1);
            i24++;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray[0] = 1;
        byteArray[1] = (byte) i16;
        byteArray[2] = (byte) i21;
        byteArray[3] = (byte) i10;
        int width2 = bitmapDecodeStream.getWidth();
        int i25 = width2 - 2;
        int[] iArr3 = new int[i25];
        bitmapDecodeStream.getPixels(iArr3, 0, i25, 1, bitmapDecodeStream.getHeight() - 1, i25, 1);
        int i26 = 0;
        while (true) {
            if (i26 >= i25) {
                break;
            }
            if (-16777216 == iArr3[i26]) {
                i(byteArray, 12, i26);
                break;
            }
            i26++;
        }
        int i27 = width2 - 3;
        while (true) {
            if (i27 < 0) {
                break;
            }
            if (-16777216 == iArr3[i27]) {
                i(byteArray, 16, (i25 - i27) - 2);
                break;
            }
            i27--;
        }
        int height2 = bitmapDecodeStream.getHeight();
        int i28 = height2 - 2;
        int[] iArr4 = new int[i28];
        bitmapDecodeStream.getPixels(iArr4, 0, 1, bitmapDecodeStream.getWidth() - 1, 0, 1, i28);
        int i29 = 0;
        while (true) {
            if (i29 >= i28) {
                break;
            }
            if (-16777216 == iArr4[i29]) {
                i(byteArray, 20, i29);
                break;
            }
            i29++;
        }
        int i30 = height2 - 3;
        while (true) {
            if (i30 < 0) {
                break;
            }
            if (-16777216 == iArr4[i30]) {
                i(byteArray, 24, (i28 - i30) - 2);
                break;
            }
            i30--;
        }
        if (NinePatch.isNinePatchChunk(byteArray)) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 1, 1, bitmapDecodeStream.getWidth() - 2, bitmapDecodeStream.getHeight() - 2);
            C1570k.f(bitmapDecodeStream);
            Method declaredMethod = bitmapCreateBitmap.getClass().getDeclaredMethod("setNinePatchChunk", byte[].class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(bitmapCreateBitmap, byteArray);
            bitmap = bitmapCreateBitmap;
        } else {
            bitmap = bitmapDecodeStream;
        }
        inputStreamOpen.close();
        if (bitmap.getNinePatchChunk() == null) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        Rect rect = new Rect();
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        rect.left = b(ninePatchChunk, 12);
        rect.right = b(ninePatchChunk, 16);
        rect.top = b(ninePatchChunk, 20);
        rect.bottom = b(ninePatchChunk, 24);
        return new NinePatchDrawable(context.getResources(), bitmap, bitmap.getNinePatchChunk(), rect, null);
    }

    public static String d(int i10, float f10) {
        return String.format("#%02x%02x%02x%02x", Integer.valueOf((int) (Color.alpha(i10) * f10)), Integer.valueOf(Color.red(i10)), Integer.valueOf(Color.green(i10)), Integer.valueOf(Color.blue(i10)));
    }

    public static String e(Object obj) {
        if (obj instanceof String) {
            return "'" + obj.toString() + "'";
        }
        if (!(obj instanceof LatLng) && !(obj instanceof BitmapDescriptor)) {
            int i10 = 0;
            if (obj instanceof List) {
                List list = (List) obj;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[");
                int size = list.size();
                for (Object obj2 : list) {
                    if (obj2 != null) {
                        sb2.append(e(obj2));
                    }
                    i10++;
                    if (i10 != size) {
                        sb2.append(Const.STR_MART_COMMA);
                    }
                }
                sb2.append("]");
                return sb2.toString();
            }
            if (!obj.getClass().isArray()) {
                return obj.toString();
            }
            Object[] objArr = (Object[]) obj;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[");
            int length = objArr.length;
            int length2 = objArr.length;
            int i11 = 0;
            while (i10 < length2) {
                Object obj3 = objArr[i10];
                if (obj3 != null) {
                    sb3.append(e(obj3));
                }
                i11++;
                if (i11 != length) {
                    sb3.append(Const.STR_MART_COMMA);
                }
                i10++;
            }
            sb3.append("]");
            return sb3.toString();
        }
        return obj.toString();
    }

    public static String f(String str, float f10, float f11) {
        return String.format("new AMap.Icon({image:'%s',size:new AMap.Size(%.2f,%.2f),imageSize:new AMap.Size(%.2f,%.2f)})", str, Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f10), Float.valueOf(f11));
    }

    public static String g(Map<String, Object> map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Const.STR_MART_JSON_BEGIN);
        if (map != null) {
            int size = map.size();
            int i10 = 0;
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                if (obj != null) {
                    sb2.append(str);
                    sb2.append(ServerSentEventKt.COLON);
                    sb2.append(e(obj));
                }
                i10++;
                if (i10 != size) {
                    sb2.append(Const.STR_MART_COMMA);
                }
            }
        }
        sb2.append("}");
        return sb2.toString();
    }

    public static void h(OutputStream outputStream, int i10) throws IOException {
        outputStream.write(i10 & 255);
        outputStream.write((i10 >> 8) & 255);
        outputStream.write((i10 >> 16) & 255);
        outputStream.write((i10 >> 24) & 255);
    }

    public static void i(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) i11;
        bArr[i10 + 1] = (byte) (i11 >> 8);
        bArr[i10 + 2] = (byte) (i11 >> 16);
        bArr[i10 + 3] = (byte) (i11 >> 24);
    }

    public static String j(int i10) {
        return String.format("#%02x%02x%02x", Integer.valueOf(Color.red(i10)), Integer.valueOf(Color.green(i10)), Integer.valueOf(Color.blue(i10)));
    }
}
