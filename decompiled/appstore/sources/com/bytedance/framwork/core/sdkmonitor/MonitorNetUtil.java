package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class MonitorNetUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IRequestIntercept f7569a;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r10 = new CompressType("NONE", 0, 0);
            NONE = r10;
            CompressType r11 = new CompressType("GZIP", 1, 1);
            GZIP = r11;
            CompressType r12 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r12;
            $VALUES = new CompressType[]{r10, r11, r12};
        }

        private CompressType(String r10, int r11, int r12) {
            super(r10, r11);
            this.nativeInt = r12;
        }

        public static CompressType valueOf(String r10) {
            return (CompressType) Enum.valueOf(CompressType.class, r10);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }
    }

    public interface IRequestIntercept {
        String addRequestVerifyParams(String r10, byte[] r11);
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        static {
            NetworkType r10 = new NetworkType("NONE", 0, 0);
            NONE = r10;
            NetworkType r11 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r11;
            NetworkType r12 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r12;
            NetworkType r13 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r13;
            NetworkType r14 = new NetworkType("WIFI", 4, 4);
            WIFI = r14;
            NetworkType r15 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r15;
            $VALUES = new NetworkType[]{r10, r11, r12, r13, r14, r15};
        }

        private NetworkType(String r10, int r11, int r12) {
            super(r10, r11);
            this.nativeInt = r12;
        }

        public static NetworkType valueOf(String r10) {
            return (NetworkType) Enum.valueOf(NetworkType.class, r10);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.nativeInt;
        }
    }

    public static byte[] a(byte[] r10, Map r11) {
        if (r10.length <= 128) goto L13;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r13 = new GZIPOutputStream(r12);
        r13.write(r10);     // Catch: Throwable -> L7 IOException -> L9
        r13.close();
        byte[] r14 = r12.toByteArray();
        r11.put("Content-Encoding", "gzip");
        return r14;
    L7:
        th = move-exception;
        r13.close();
        throw th;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    L13:
        return r10;
    }

    public static i6.c b(String r10, byte[] r11, CompressType r12, String r13, boolean r14) {
        String r15 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r11 != null) goto L8;
        r11 = new byte[0];
    L8:
        int r16 = r11.length;
        if (CompressType.GZIP != r12) goto L18;
        if (r16 <= 128) goto L18;
        ByteArrayOutputStream r17 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r18 = new GZIPOutputStream(r17);
        r18.write(r11);     // Catch: Throwable -> L15
        r18.close();
        r11 = r17.toByteArray();
        r15 = "gzip";
    L14:
        byte[] r19 = r11;
        String r20 = r15;
        if (r14 == false) goto L33;
        byte[] r110 = z4.a.a(r19, r19.length);
        if (r110 == null) goto L29;
        String r21 = r10 + "&tt_data=a";
        byte[] r22 = r110;
        String r23 = "application/octet-stream;tt-data=a";
    L31:
        return c(r21, r22, r23, r20, "POST", true, true);
    L29:
        r21 = r10;
        r23 = r13;
        r22 = r19;
        goto L31
    L33:
        return c(r10, r19, r13, r20, "POST", true, false);
    L15:
        r18.close();
        return null;
    L18:
        if (CompressType.DEFLATER != r12) goto L14;
        if (r16 <= 128) goto L14;
        ByteArrayOutputStream r111 = new ByteArrayOutputStream(8192);
        Deflater r24 = new Deflater();
        r24.setInput(r11);
        r24.finish();
        byte[] r112 = new byte[8192];
    L22:
        if (r24.finished() == true) goto L24;
        r111.write(r112, 0, r24.deflate(r112));
        goto L22
    L24:
        r24.end();
        r11 = r111.toByteArray();
        r15 = "deflate";
        goto L14
    }

    public static i6.c c(String r10, byte[] r11, String r12, String r13, String r14, boolean r15, boolean r16) {
        InputStream r17 = null;
        IRequestIntercept r18 = f7569a;     // Catch: Throwable -> L6
        if (r18 == null) goto L8;
        r10 = r18.addRequestVerifyParams(r10, r11);     // Catch: Throwable -> L6
    L8:
        LinkedList r19 = new LinkedList();     // Catch: Throwable -> L6
        if (r16 == false) goto L11;
        URL r20 = new URL(RequestEncryptUtils.g(r10, r19));     // Catch: Throwable -> L6
    L12:
        HttpURLConnection r21 = (HttpURLConnection) r20.openConnection();     // Catch: Throwable -> L6
        if (r16 == false) goto L26;
    L23:
        th = th;
    L24:
        Throwable r22 = th;
        HttpURLConnection r23 = r21;
        th = r22;
    L102:
        throw th;     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        d.a(r17);
        if (r23 != null) goto L95;
    L87:
        throw th;
    L95:
        r23.disconnect();     // Catch: Exception -> L89
        goto L87
    L15:
        if (r19.isEmpty() == true) goto L26;
        Iterator r110 = r19.iterator();     // Catch: Throwable -> L23
    L18:
        if (r110.hasNext() == false) goto L26;
        Pair r24 = (Pair) r110.next();     // Catch: Throwable -> L23
        if (r24 == null) goto L18;
        r21.setRequestProperty((String) r24.first, (String) r24.second);     // Catch: Throwable -> L23
    L26:
        if (r15 == false) goto L28;
        r21.setDoOutput(true);     // Catch: Throwable -> L23
    L29:
        if (r12 == null) goto L31;
        r21.setRequestProperty("Content-Type", r12);     // Catch: Throwable -> L23
    L31:
        if (r13 == null) goto L33;
        r21.setRequestProperty("Content-Encoding", r13);     // Catch: Throwable -> L23
    L33:
        r21.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L23
        r21.setRequestProperty("Version-Code", "1");     // Catch: Throwable -> L23
        if (r14 == null) goto L81;
        r21.setRequestMethod(r14);     // Catch: Throwable -> L23
        if (r11 != null) goto L38;
    L48:
        int r25 = r21.getResponseCode();     // Catch: Throwable -> L23
        if (r25 != 200) goto L79;
        InputStream r26 = r21.getInputStream();     // Catch: Throwable -> L23
        String r27 = r21.getContentEncoding();     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r27) == false) goto L54;
    L65:
        byte[] r28 = g(r26);     // Catch: Throwable -> L58
    L66:
        Map<String, List<String>> r29 = r21.getHeaderFields();     // Catch: Throwable -> L58
        HashMap r111 = new HashMap();     // Catch: Throwable -> L58
        Iterator<String> r30 = r29.keySet().iterator();     // Catch: Throwable -> L58
    L68:
        if (r30.hasNext() == false) goto L74;
        String r31 = r30.next();     // Catch: Throwable -> L58
        List<String> r32 = r29.get(r31);     // Catch: Throwable -> L58
        if (r32 == null) goto L68;
        if (f.a(r32) == true) goto L68;
        r111.put(r31, r32.get(0));     // Catch: Throwable -> L58
        goto L68
    L74:
        i6.c r33 = new i6.c(r25, r111, r28);     // Catch: Throwable -> L58
        d.a(r26);
        r21.disconnect();     // Catch: Exception -> L88
    L77:
        return r33;
    L54:
        if (r27.equalsIgnoreCase("gzip") == false) goto L65;
        GZIPInputStream r34 = new GZIPInputStream(r26);     // Catch: Throwable -> L62
        r28 = g(r34);     // Catch: Throwable -> L60
        d.a(r34);     // Catch: Throwable -> L58
    L60:
        th = th;
        r17 = r34;
    L63:
        d.a(r17);     // Catch: Throwable -> L58
        throw th;     // Catch: Throwable -> L58
    L62:
        th = th;
    L58:
        th = th;
        r17 = r26;
        goto L24
    L79:
        throw new HttpResponseException(r25, r21.getResponseMessage());     // Catch: Throwable -> L23
    L38:
        if (r11.length <= 0) goto L48;
        DataOutputStream r35 = new DataOutputStream(r21.getOutputStream());     // Catch: Throwable -> L44
        r35.write(r11);     // Catch: Throwable -> L42
        r35.flush();     // Catch: Throwable -> L42
        d.a(r35);     // Catch: Throwable -> L23
    L42:
        th = th;
    L46:
        d.a(r35);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L44:
        th = th;
        r35 = null;
        goto L46
    L81:
        throw new IllegalArgumentException("request method is not null");     // Catch: Throwable -> L23
    L28:
        r21.setDoOutput(false);     // Catch: Throwable -> L23
        goto L29
    L11:
        r20 = new URL(r10);     // Catch: Throwable -> L6
    L6:
        th = th;
        r23 = null;
        goto L102
    }

    public static NetworkType d(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L24
        if (r11 == null) goto L23;
        if (r11.isAvailable() == false) goto L23;
        int r12 = r11.getType();     // Catch: Throwable -> L24
        if (1 == r12) goto L10;
        if (r12 != 0) goto L21;
        switch(((TelephonyManager) r10.getSystemService("phone")).getNetworkType()) {
            case 3: goto L19;
            case 4: goto L15;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L15;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L15;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L15;
        };     // Catch: Throwable -> L24
    L15:
        return NetworkType.MOBILE;
    L17:
        return NetworkType.MOBILE_4G;
    L19:
        return NetworkType.MOBILE_3G;
    L21:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L23:
        return NetworkType.NONE;
    L25:
        return NetworkType.MOBILE;
    }

    public static byte[] e(String r10, String r11, boolean r12) {
        if (TextUtils.isDigitsOnly(r10) == false) goto L7;
        return null;
    L7:
        return c(r10, null, r11, null, "GET", false, r12).b();
    }

    public static boolean f(Context r10) {
        if (r10 != null) goto L15;
        return false;
    L15:
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L10
        if (r11 == null) goto L12;
        if (r11.isConnected() == false) goto L17;
        return true;
    L17:
        return false;
    L12:
        return false;
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static byte[] g(InputStream r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        byte[] r12 = new byte[8192];
    L3:
        int r13 = r10.read(r12);
        if ((-1) == r13) goto L6;
        r11.write(r12, 0, r13);
        goto L3
    L6:
        r10.close();
        return r11.toByteArray();
    }
}
