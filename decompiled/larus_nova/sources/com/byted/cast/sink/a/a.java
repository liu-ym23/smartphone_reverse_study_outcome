package com.byted.cast.sink.a;

import android.content.Context;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.PreferenceUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Random;

/* JADX INFO: loaded from: classes43.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Random f33788a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f33789b;

    static {
        f33788a = new Random(System.currentTimeMillis());
        f33789b = -1;
    }

    private static int a(int r100, int r101) {
        Random r102 = f33788a;
        return r102.nextInt(r101 - r100) + r100;
    }

    private static int a(Context r100, CastLogger r101) {
        int r102 = f33789b;     // Catch: Exception -> L11
        if (r102 != (-1)) goto L7;
        r102 = CastIntegerProtector.parseInt(PreferenceUtils.getValue(r100, "bytelink_avail_port", "-1"));     // Catch: Exception -> L11
    L7:
        if (a(r102) == false) goto L9;
        f33789b = r102;     // Catch: Exception -> L11
    L13:
        r101.i("SocketUtils", "getDiskAvailablePort:" + f33789b);
        return f33789b;
    L9:
        f33789b = -1;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        r101.w("SocketUtils", "getDiskAvailablePort:" + e);
        f33789b = -1;
        goto L13
    }

    public static int a(ContextManager.CastContext r100, Context r101) {
        return a(r100, r101, 49152, 65535);
    }

    public static int a(ContextManager.CastContext r100, Context r101, int r102, int r103) {
        CastLogger r104 = ContextManager.getLogger(r100);
        if (r102 < 49152) goto L16;
        if (r103 < r102) goto L16;
        if (r103 > 65535) goto L16;
        int r105 = a(r101, r104);
        if (r105 <= 0) goto L11;
        return r105;
    L11:
        int r106 = a(r102, r103);
        if (a(r106) == false) goto L11;
        r104.i("SocketUtils", "findAvailablePort:" + r106);
        a(r101, r106);
        return r106;
    L16:
        r104.w("SocketUtils", "findAvailablePort, wrong socket range, min:" + r102 + ", max:" + r103);
        return -1;
    }

    private static void a(Context r100, int r101) {
        f33789b = r101;
        PreferenceUtils.setValue(r100, "bytelink_avail_port", Integer.toString(r101));
    }

    public static boolean a(int r100) {
        return a(r100, null);
    }

    public static boolean a(int r100, InetAddress r101) {
        if (r100 < 49152) goto L37;
        if (r100 > 65535) goto L37;
        DatagramSocket r102 = null;
        if (r101 == null) goto L9;
        ServerSocket r103 = new ServerSocket(r100, 50, r101);     // Catch: Throwable -> L22 IOException -> L29
    L10:
        r103.setReuseAddress(true);     // Catch: Throwable -> L19 IOException -> L21
        if (r101 == null) goto L14;
        r102 = new DatagramSocket(r100, r101);     // Catch: Throwable -> L19 IOException -> L21
    L15:
        r102.setReuseAddress(true);     // Catch: Throwable -> L19 IOException -> L21
        r102.close();
        r103.close();     // Catch: IOException -> L38
    L18:
        return true;
        goto L30
    L14:
        r102 = new DatagramSocket(r100);     // Catch: Throwable -> L19 IOException -> L21
    L19:
        th = th;
    L24:
        if (r102 == null) goto L26;
        r102.close();
    L26:
        if (r103 != null) goto L41;
    L28:
        throw th;
    L41:
        r103.close();     // Catch: IOException -> L39
    L30:
        if (r102 == null) goto L32;
        r102.close();
    L32:
        if (r103 == null) goto L51;
        r103.close();     // Catch: IOException -> L40
        return false;
    L52:
        return false;
    L51:
        return false;
    L9:
        r103 = new ServerSocket(r100);     // Catch: Throwable -> L22 IOException -> L29
    L29:
        r103 = null;
    L22:
        th = th;
        r103 = null;
    L37:
        throw new IllegalArgumentException("Invalid start minPort: " + r100);
    }
}
