package v4;

import android.content.SharedPreferences;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestHandler;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.google.common.base.Ascii;
import com.obric.capabilitykit.common.UiType;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25083a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f25084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f25085c;

    static {
    }

    public static void a(byte[] r10, int r11) {
        if (r10 == null) goto L9;
        if (r11 <= 0) goto L11;
        byte[] r12 = {-99, -114, Ascii.DEL, 90};
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L12;
        r10[r13] = (byte) (r10[r13] ^ r12[r13 % 4]);
        r13 = r13 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    public static boolean b(int r10) {
        if (r10 >= 4096) goto L5;
    L7:
        return false;
    L5:
        if (r10 > 5242880) goto L7;
        return true;
    }

    public static void c(SharedPreferences r10) {
        f25084b = r10.getInt("read_response_buff_init_size", 0);
        f25085c = r10.getInt("read_response_buff_increase_size", 0);
    }

    public static void d(SharedPreferences.Editor r10) {
        r10.putInt("read_response_buff_init_size", f25084b);
        r10.putInt("read_response_buff_increase_size", f25085c);
    }

    public static void e(JSONObject r10) {
        f25084b = r10.optInt("read_response_buff_init_size", 0);
        f25085c = r10.optInt("read_response_buff_increase_size", 0);
    }

    public static InputStream f(InputStream r10, Map r11, boolean r12, RetrofitMetrics r13) {
        if (r12 == true) goto L4;
        NetworkParams.StreamProcessor r14 = NetworkParams.l();
        if (r14 != null) goto L9;
        return r10;
    L9:
        return r14.processInputStream(r10, r11, r13);
    L4:
        return new GZIPInputStream(r10);
    }

    public static byte[] g(boolean r10, Map r11, int r12, InputStream r13, int[] r14, RetrofitMetrics r15) {
        if (r12 > 0) goto L6;
        r12 = 5242880;
    L6:
        if (r12 >= 1048576) goto L9;
        r12 = 1048576;
    L9:
        if (r13 != null) goto L70;
        return null;
    L70:
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L14
        r13 = f(r13, r11, r10, r15);     // Catch: Throwable -> L14
        if (b(f25084b) == false) goto L16;
        int r17 = f25084b;     // Catch: Throwable -> L14
    L18:
        if (b(f25085c) == false) goto L20;
        int r18 = f25085c;     // Catch: Throwable -> L14
    L21:
        byte[] r19 = new byte[r17];     // Catch: Throwable -> L14
        int r20 = 0;
    L71:
    L33:
        e = move-exception;
        if (r10 == false) goto L67;
        if (r20 <= 0) goto L67;
        Logger.w(f25083a, "ungzip got exception " + e);     // Catch: Throwable -> L14
    L59:
        if (r20 <= 0) goto L65;
        if (r15 == null) goto L62;
        r15.N.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r16));     // Catch: Throwable -> L14
        r15.N.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r20));     // Catch: Throwable -> L14
    L62:
        r14[0] = r20;     // Catch: Throwable -> L14
        i(r13);
        return r19;
    L65:
        i(r13);
        return null;
    L67:
        throw e;     // Catch: Throwable -> L14
    L31:
        e = move-exception;
        String r21 = e.getMessage();     // Catch: Throwable -> L14
        if (r10 == false) goto L55;
        if (r20 <= 0) goto L55;
        if ("CRC mismatch".equals(r21) == false) goto L53;
    L54:
        Logger.w(f25083a, "ungzip got exception " + e);     // Catch: Throwable -> L14
        goto L59
    L53:
        if ("Size mismatch".equals(r21) == true) goto L54;
    L55:
        throw e;     // Catch: Throwable -> L14
    L29:
        e = move-exception;
        Logger.e(f25083a, "new buff error" + e);     // Catch: Throwable -> L14
        i(r13);
        return null;
    L25:
        if ((r20 + 4096) > r19.length) goto L27;
    L37:
        int r22 = r13.read(r19, r20, r19.length - r20);     // Catch: Throwable -> L14 OutOfMemoryError -> L29 IOException -> L31 EOFException -> L33
        if (r22 <= 0) goto L59;
        r20 = r20 + r22;     // Catch: Throwable -> L14 OutOfMemoryError -> L29 IOException -> L31 EOFException -> L33
        if (r20 <= r12) goto L71;
        Logger.w(f25083a, "entity length did exceed given maxLength");     // Catch: Throwable -> L14 OutOfMemoryError -> L29 IOException -> L31 EOFException -> L33
        throw new DownloadFileTooLargeException(r12, r20);     // Catch: Throwable -> L14 OutOfMemoryError -> L29 IOException -> L31 EOFException -> L33
    L27:
        if (r19.length >= r18) goto L35;
        int r23 = r19.length + r18;     // Catch: Throwable -> L14 OutOfMemoryError -> L29 IOException -> L31 EOFException -> L33
    L36:
        byte[] r24 = new byte[r23];     // Catch: Throwable -> L14 OutOfMemoryError -> L29 IOException -> L31 EOFException -> L33
        System.arraycopy(r19, 0, r24, 0, r20);     // Catch: Throwable -> L14 OutOfMemoryError -> L29 IOException -> L31 EOFException -> L33
        r19 = r24;
        goto L37
    L35:
        r23 = r19.length * 2;     // Catch: Throwable -> L14 OutOfMemoryError -> L29 IOException -> L31 EOFException -> L33
        goto L36
    L20:
        r18 = 102400;
        goto L21
    L16:
        r17 = UiType.FLAG_SETTINGS_CARD;
    L14:
        th = move-exception;
        i(r13);
        throw th;
    }

    public static byte[] h(boolean r10, Map r11, int r12, InputStream r13, int[] r14, RequestHandler r15) {
        if (r13 != null) goto L18;
        return null;
    L18:
        byte[] r16 = g(r10, r11, r12, r13, r14, null);     // Catch: Exception -> L13
        if (r16 != null) goto L9;
    L12:
        return null;
    L9:
        if (r14[0] <= 0) goto L12;
        return r16;
    L13:
        e = move-exception;
        if (r15 != null) goto L20;
    L16:
        throw e;
    L20:
        r15.abort();     // Catch: Throwable -> L17
        goto L16
    }

    public static void i(Closeable r10) {
        j(r10, null);
    }

    public static void j(Closeable r10, String r11) {
        if (r10 == null) goto L13;
        r10.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (Logger.debug() == false) goto L14;
        if (r11 == null) goto L15;
        Logger.d(f25083a, r11 + " " + e);
        return;
    L15:
        return;
    L14:
        return;
    }

    public static boolean k(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = r10.indexOf("application/octet-stream");
        if (r11 < 0) goto L8;
        r11 = r10.indexOf("ssmix=", r11 + 24);
    L8:
        if (r11 <= 0) goto L11;
        return true;
    L11:
        return false;
    }
}
