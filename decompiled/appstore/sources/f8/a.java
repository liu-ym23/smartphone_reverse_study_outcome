package f8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.WindowManager;
import com.bytedance.keva.KevaImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static Bitmap a(byte[] r10, int r11, int r12) {
        BitmapFactory.Options r13 = new BitmapFactory.Options();
        r13.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(r10, 0, r10.length, r13);
        int r14 = r13.outWidth;
        int r15 = r13.outHeight;
        int r16 = e(r11, r12, r14, r15);
        int r17 = e(r12, r11, r15, r14);
        r13.inJustDecodeBounds = false;
        r13.inSampleSize = d(r14, r15, r16, r17);
        Bitmap r18 = BitmapFactory.decodeByteArray(r10, 0, r10.length, r13);
        if (r18 != null) goto L5;
        return r18;
    L5:
        if (r18.getWidth() <= r16) goto L7;
    L8:
        Bitmap r19 = Bitmap.createScaledBitmap(r18, r16, r17, true);
        r18.recycle();
        return r19;
    L7:
        if (r18.getHeight() > r17) goto L8;
        return r18;
    }

    public static void b() {
        if (f() == false) goto L6;
        System.setProperty("http.keepAlive", "false");
        return;
    }

    public static Bitmap c(Context r10, String r11) {
        b();
        HttpURLConnection r12 = null;
        Bitmap r13 = null;
        HttpURLConnection r14 = (HttpURLConnection) new URL(r11).openConnection();     // Catch: Throwable -> L18 IOException -> L20
        r14.setReadTimeout(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);     // Catch: Throwable -> L9 IOException -> L11
        r14.setConnectTimeout(5000);     // Catch: Throwable -> L9 IOException -> L11
        InputStream r15 = r14.getInputStream();     // Catch: Throwable -> L9 IOException -> L11
        ByteArrayOutputStream r16 = new ByteArrayOutputStream();     // Catch: Throwable -> L9 IOException -> L11
        byte[] r17 = new byte[1024];     // Catch: Throwable -> L9 IOException -> L11
    L6:
        int r18 = r15.read(r17);     // Catch: Throwable -> L9 IOException -> L11
        if (r18 == (-1)) goto L13;
        r16.write(r17, 0, r18);     // Catch: Throwable -> L9 IOException -> L11
        goto L6
    L13:
        WindowManager r19 = (WindowManager) r10.getSystemService("window");     // Catch: Throwable -> L9 IOException -> L11
        if (r19 == null) goto L16;
        int r20 = r19.getDefaultDisplay().getWidth();     // Catch: Throwable -> L9 IOException -> L11
        int r21 = r19.getDefaultDisplay().getHeight();     // Catch: Throwable -> L9 IOException -> L11
        r13 = a(r16.toByteArray(), r20, r21);     // Catch: Throwable -> L9 IOException -> L11
    L16:
        r14.disconnect();
        return r13;
    L11:
        e = move-exception;
        throw e;     // Catch: Throwable -> L18
    L9:
        th = th;
        r12 = r14;
    L22:
        if (r12 == null) goto L24;
        r12.disconnect();
    L24:
        throw th;
    L20:
        e = move-exception;
        throw e;     // Catch: Throwable -> L18
    L18:
        th = th;
        goto L22
    }

    public static int d(int r10, int r11, int r12, int r13) {
        double r14 = Math.min(((double) r10) / ((double) r12), ((double) r11) / ((double) r13));
        int r15 = 1;
    L3:
        int r16 = r15 * 2;
        if (r16 > r14) goto L6;
        r15 = r16;
        goto L3
    L6:
        return r15;
    }

    public static int e(int r10, int r11, int r12, int r13) {
        if (r10 != 0) goto L5;
        if (r11 != 0) goto L5;
        return r12;
    L5:
        if (r10 == 0) goto L7;
        if (r11 != 0) goto L10;
        return r10;
    L10:
        double r14 = ((double) r13) / ((double) r12);
        double r15 = r11;
        if ((((double) r10) * r14) > r15) goto L13;
        return r10;
    L13:
        return (int) (r15 / r14);
    L7:
        return (int) (r12 * (((double) r11) / ((double) r13)));
    }

    public static boolean f() {
        return false;
    }
}
