package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.model.LatLng;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public class q3 {
    public static Drawable a(Context r210, String r211) throws Exception {
        InputStream r100 = p3.d(r210, r211);
        if (r100 != null) goto L5;
        Bitmap r101 = null;
    L88:
        if (r101.getNinePatchChunk() == null) goto L90;
        Rect r102 = new Rect();
        byte[] r103 = r101.getNinePatchChunk();
        r102.left = a(r103, 12);
        r102.right = a(r103, 16);
        r102.top = a(r103, 20);
        r102.bottom = a(r103, 24);
        return new NinePatchDrawable(r210.getResources(), r101, r101.getNinePatchChunk(), r102, null);
    L90:
        return new BitmapDrawable(r210.getResources(), r101);
    L5:
        Bitmap r110 = BitmapFactory.decodeStream(r100);
        int r104 = r110.getWidth();
        int r111 = r110.getHeight();
        ByteArrayOutputStream r112 = new ByteArrayOutputStream();
        int r105 = 0;
    L7:
        if (r105 >= 32) goto L9;
        r112.write(0);
        r105 = r105 + 1;
        goto L7
    L9:
        int r113 = r104 - 2;
        int[] r114 = new int[r113];
        r110.getPixels(r114, 0, r104, 1, 0, r113, 1);
        if (r114[0] != (-16777216)) goto L12;
        boolean r106 = true;
    L14:
        if (r114[r113 - 1] != (-16777216)) goto L16;
        boolean r107 = true;
    L17:
        int r108 = 0;
        int r109 = 0;
        int r115 = 0;
    L18:
        if (r108 >= r113) goto L23;
        if (r109 == r114[r108]) goto L22;
        r115 = r115 + 1;
        a(r112, r108);
        r109 = r114[r108];
    L22:
        r108 = r108 + 1;
        goto L18
    L23:
        if (r107 == false) goto L25;
        r115 = r115 + 1;
        a(r112, r113);
    L25:
        int r116 = r115;
        int r117 = r116 + 1;
        if (r106 == false) goto L28;
        r117 = r117 - 1;
    L28:
        if (r107 == false) goto L30;
        r117 = r117 - 1;
    L30:
        int r118 = r117;
        int r119 = r111 - 2;
        int[] r120 = new int[r119];
        r110.getPixels(r120, 0, 1, 0, 1, 1, r119);
        if (r120[0] != (-16777216)) goto L33;
        boolean r121 = true;
    L35:
        if (r120[r119 - 1] != (-16777216)) goto L37;
        boolean r122 = true;
    L38:
        int r123 = 0;
        int r124 = 0;
        int r125 = 0;
    L39:
        if (r123 >= r119) goto L44;
        if (r124 == r120[r123]) goto L43;
        r125 = r125 + 1;
        a(r112, r123);
        r124 = r120[r123];
    L43:
        r123 = r123 + 1;
        goto L39
    L44:
        if (r122 == false) goto L46;
        r125 = r125 + 1;
        a(r112, r119);
    L46:
        int r126 = r125 + 1;
        if (r121 == false) goto L49;
        r126 = r126 - 1;
    L49:
        if (r122 == false) goto L51;
        r126 = r126 - 1;
    L51:
        int r127 = 0;
    L52:
        int r128 = r118 * r126;
        if (r127 >= r128) goto L55;
        a(r112, 1);
        r127 = r127 + 1;
        goto L52
    L55:
        byte[] r129 = r112.toByteArray();
        r129[0] = 1;
        r129[1] = (byte) r116;
        r129[2] = (byte) r125;
        r129[3] = (byte) r128;
        int r130 = r110.getWidth() - 2;
        int[] r131 = new int[r130];
        r110.getPixels(r131, 0, r130, 1, r110.getHeight() - 1, r130, 1);
        int r132 = 0;
    L56:
        if (r132 >= r130) goto L61;
        if ((-16777216) == r131[r132]) goto L59;
        r132 = r132 + 1;
        goto L56
    L59:
        a(r129, 12, r132);
    L61:
        int r133 = r130 - 1;
    L62:
        if (r133 < 0) goto L67;
        if ((-16777216) == r131[r133]) goto L65;
        r133 = r133 - 1;
        goto L62
    L65:
        a(r129, 16, (r130 - r133) - 2);
    L67:
        int r134 = r110.getHeight() - 2;
        int[] r135 = new int[r134];
        r110.getPixels(r135, 0, 1, r110.getWidth() - 1, 0, 1, r134);
        int r136 = 0;
    L68:
        if (r136 >= r134) goto L73;
        if ((-16777216) == r135[r136]) goto L71;
        r136 = r136 + 1;
        goto L68
    L71:
        a(r129, 20, r136);
    L73:
        int r137 = r134 - 1;
    L74:
        if (r137 < 0) goto L80;
        if ((-16777216) == r135[r137]) goto L77;
        r137 = r137 - 1;
        goto L74
    L77:
        a(r129, 24, (r134 - r137) - 2);
    L80:
        if (NinePatch.isNinePatchChunk(r129) == false) goto L85;
        Bitmap r138 = Bitmap.createBitmap(r110, 1, 1, r110.getWidth() - 2, r110.getHeight() - 2);
        w3.a(r110);
        if (Build.VERSION.SDK_INT < 28) goto L84;
        Method r139 = r138.getClass().getDeclaredMethod("setNinePatchChunk", new Class[]{byte[].class});
        r139.setAccessible(true);
        r139.invoke(r138, new Object[]{r129});
    L86:
        r100.close();
        r101 = r138;
        goto L88
    L84:
        Field r140 = r138.getClass().getDeclaredField("mNinePatchChunk");
        r140.setAccessible(true);
        r140.set(r138, r129);
        goto L86
    L85:
        r138 = r110;
        goto L86
    L37:
        r122 = false;
        goto L38
    L33:
        r121 = false;
        goto L35
    L16:
        r107 = false;
        goto L17
    L12:
        r106 = false;
        goto L14
    }

    private static void a(OutputStream r100, int r101) throws IOException {
        r100.write((r101 >> 0) & 255);
        r100.write((r101 >> 8) & 255);
        r100.write((r101 >> 16) & 255);
        r100.write((r101 >> 24) & 255);
    }

    private static int a(byte[] r100, int r101) {
        byte r102 = r100[r101 + 0];
        byte r103 = r100[r101 + 1];
        byte r104 = r100[r101 + 2];
        byte r105 = r100[r101 + 3];
        int r106 = r105 << 24;
        return r106 | (((r102 & UByte.MAX_VALUE) | (r103 << 8)) | (r104 << 16));
    }

    private static void a(byte[] r100, int r101, int r102) {
        r100[r101 + 0] = (byte) (r102 >> 0);
        r100[r101 + 1] = (byte) (r102 >> 8);
        r100[r101 + 2] = (byte) (r102 >> 16);
        r100[r101 + 3] = (byte) (r102 >> 24);
    }

    private static boolean b(LatLng r110, LatLng r111, LatLng r112) {
        double r100 = r110.longitude;
        double r101 = r111.longitude;
        double r102 = r100 - r101;
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r103 = r100;
    L7:
        if (r102 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L10;
        r100 = r101;
    L10:
        double r104 = r110.latitude;
        double r113 = r111.latitude;
        double r105 = r104 - r113;
        if (r105 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        double r114 = r104;
    L15:
        if (r105 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L18;
        r104 = r113;
    L18:
        double r115 = r112.longitude;
        if (r100 <= r115) goto L21;
        return false;
    L21:
        if (r115 > r103) goto L30;
        double r116 = r112.latitude;
        if (r104 <= r116) goto L25;
        return false;
    L25:
        if (r116 > r114) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    L13:
        r114 = r113;
        goto L15
    L5:
        r103 = r101;
        goto L7
    }

    private static double a(LatLng r110, LatLng r111, LatLng r112) {
        double r100 = r110.latitude;
        double r101 = r100 - r112.latitude;
        double r102 = r110.longitude;
        double r103 = r102 - r112.longitude;
        double r104 = r100 - r111.latitude;
        return (r103 * r104) - ((r102 - r111.longitude) * r101);
    }

    public static boolean a(LatLng r110, LatLng r111, LatLng r210, LatLng r211) {
        double r100 = a(r210, r211, r110);
        double r101 = a(r210, r211, r111);
        double r102 = a(r110, r111, r210);
        double r112 = a(r110, r111, r211);
        if (r100 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
    L11:
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        if (r112 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
    L18:
        boolean r103 = true;
    L20:
        if (r103 == false) goto L22;
        return true;
    L22:
        if (r100 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L27;
        if (b(r210, r211, r110) == false) goto L27;
        return true;
    L27:
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L32;
        if (b(r210, r211, r111) == false) goto L32;
        return true;
    L32:
        if (r102 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L37;
        if (b(r110, r111, r210) == false) goto L37;
        return true;
    L37:
        if (r112 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L39;
    L41:
        return false;
    L39:
        if (b(r110, r111, r211) == false) goto L41;
        return true;
    L15:
        if (r102 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L17;
    L19:
        r103 = false;
        goto L20
    L17:
        if (r112 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
    L7:
        if (r100 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        if (r101 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        goto L19
    }

    public static void b(Context r100, String r101, String r102, Object r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        SharedPreferences.Editor r104 = r100.getSharedPreferences(r101, 0).edit();
        if ((r103 instanceof String) == false) goto L8;
        r104.putString(r102, (String) r103);
    L20:
        r104.apply();
        return;
    L8:
        if ((r103 instanceof Integer) == false) goto L11;
        r104.putInt(r102, ((Integer) r103).intValue());
        goto L20
    L11:
        if ((r103 instanceof Boolean) == false) goto L14;
        r104.putBoolean(r102, ((Boolean) r103).booleanValue());
        goto L20
    L14:
        if ((r103 instanceof Float) == false) goto L17;
        r104.putFloat(r102, ((Float) r103).floatValue());
        goto L20
    L17:
        if ((r103 instanceof Long) == false) goto L19;
        r104.putLong(r102, ((Long) r103).longValue());
        goto L20
    L19:
        r104.putString(r102, r103.toString());
        goto L20
    }

    private static Object a(Context r100, String r101, String r102, Object r103) {
        if (r100 != null) goto L5;
        return null;
    L5:
        SharedPreferences r104 = r100.getSharedPreferences(r101, 0);
        if ((r103 instanceof String) == false) goto L10;
        return r104.getString(r102, (String) r103);
    L10:
        if ((r103 instanceof Integer) == false) goto L14;
        return Integer.valueOf(r104.getInt(r102, ((Integer) r103).intValue()));
    L14:
        if ((r103 instanceof Boolean) == false) goto L18;
        return Boolean.valueOf(r104.getBoolean(r102, ((Boolean) r103).booleanValue()));
    L18:
        if ((r103 instanceof Float) == false) goto L22;
        return Float.valueOf(r104.getFloat(r102, ((Float) r103).floatValue()));
    L22:
        if ((r103 instanceof Long) == true) goto L24;
        return null;
    L24:
        return Long.valueOf(r104.getLong(r102, ((Long) r103).longValue()));
    }

    public static Long a(Context r100, String r101, String r102, Long r103) {
        Object r104 = a(r100, r101, r102, r103);
        if (r104 != null) goto L5;
        return r103;
    L5:
        return (Long) r104;
    }

    public static String a(Context r100, String r101, String r102, String r103) {
        Object r104 = a(r100, r101, r102, r103);
        if (r104 != null) goto L5;
        return r103;
    L5:
        return (String) r104;
    }
}
