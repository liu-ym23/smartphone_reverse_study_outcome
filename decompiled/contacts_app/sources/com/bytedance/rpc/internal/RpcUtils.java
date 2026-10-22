package com.bytedance.rpc.internal;

import com.bytedance.librarian.LibrarianImpl;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class RpcUtils {
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final byte[] EMPTY_BYTE_ARR = null;
    public static final Object[] EMPTY_OBJ_ARR = null;
    public static final String[] EMPTY_STR_ARR = null;

    public RpcUtils() {
    }

    static {
        EMPTY_STR_ARR = new String[0];
        EMPTY_OBJ_ARR = new Object[0];
        EMPTY_BYTE_ARR = new byte[0];
    }

    public static String composeUrl(String r3, String r4) {
        if (isInvisible(r3) == false) goto L5;
    L21:
        return r4;
    L5:
        if (r4.indexOf("://") > 0) goto L21;
        if (r4 == null) goto L20;
        if (r4.length() <= 0) goto L20;
        int r1 = r4.indexOf(46);
        int r2 = r4.indexOf(47);
        if (r1 <= 0) goto L20;
        if (r1 >= r2) goto L20;
        int r0 = r3.indexOf("://");
        StringBuilder r5 = new StringBuilder();
        if (r0 <= 0) goto L16;
        String r6 = r3.substring(0, r0 + 3);
    L18:
        return r5.append(r6).append(r4).toString();
    L16:
        r6 = "https://";
    L20:
        return buildUrl(r3, r4);
    }

    public static String buildUrl(String r6, String r7) {
        if (isVisible(r7) == false) goto L23;
        boolean r1 = r6.endsWith(LibrarianImpl.Constants.SEPARATOR);
        boolean r2 = r7.startsWith(LibrarianImpl.Constants.SEPARATOR);
        boolean r3 = false;
        if (r1 == true) goto L9;
        if (r2 == true) goto L9;
        boolean r5 = false;
    L10:
        if (r1 == false) goto L13;
        if (r2 == false) goto L13;
        r3 = true;
    L13:
        if (r5 == false) goto L17;
        if (r3 == true) goto L17;
        return r6 + r7;
    L17:
        if (r3 == true) goto L19;
        if (r5 == false) goto L22;
        return r6;
    L22:
        return r6 + LibrarianImpl.Constants.SEPARATOR + r7;
    L19:
        return r6 + r7.substring(1);
    L9:
        r5 = true;
        goto L10
    L23:
        return r6;
    }

    public static String[] getBaseUrlAndPath(String r6) {
        int r0 = -1;
        if (r6 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 <= 0) goto L18;
        int r2 = r6.indexOf(47, r1 + 3);
        if (r2 <= 2) goto L12;
        r0 = r6.indexOf(47, r2);
    L12:
        if (r0 <= 0) goto L18;
        if ((r0 + 1) >= r6.length()) goto L18;
        return new String[]{r6.substring(0, r0), r6.substring(r0)};
    L18:
        return new String[]{r6, ""};
    L5:
        r1 = r6.indexOf(58);
        goto L7
    }

    public static Map<String, String> getUrlParams(String r9, String r10) {
        HashMap r0 = new HashMap(8);
        if (r9 != null) goto L5;
    L24:
        return r0;
    L5:
        if (r9.length() <= 2) goto L24;
        int r1 = r9.indexOf("?");
        if (r1 == (-1)) goto L9;
        r9 = r9.substring(r1 + 1);
    L9:
        String[] r11 = r9.split("&");
        if (r11 == null) goto L24;
        if (r11.length <= 0) goto L24;
        if (isInvisible(r10) == false) goto L16;
        r10 = "UTF-8";
    L16:
        int r2 = r11.length;
        int r5 = 0;
    L17:
        if (r5 >= r2) goto L24;
        String[] r6 = r11[r5].split("=", 2);
        if (r6 == null) goto L23;
        if (r6.length != 2) goto L23;
        r0.put(decode(r6[0], new String[]{r10}), decode(r6[1], new String[]{r10}));
    L23:
        r5 = r5 + 1;
        goto L17
    }

    public static String decode(String r2, String... r3) {
        if (isVisible(r2) == false) goto L10;
        if (r3 != null) goto L13;
    L9:
        r2 = URLDecoder.decode(r2);     // Catch: Exception -> L11
    L12:
        goto L10
    L13:
        if (r3.length < 1) goto L9;
        r2 = URLDecoder.decode(r2, r3[0]);     // Catch: Exception -> L11
    L10:
        return r2;
    }

    public static String replacePathParamsWithQuery(String r10, Map<String, String> r11, boolean r12) {
        String r0 = "";
        if (r10 != null) goto L5;
    L67:
        if (r10 == null) goto L69;
        return r10;
    L69:
        return "";
    L5:
        if (r10.length() <= 3) goto L67;
        if (r11 == null) goto L67;
        if (r11.size() <= 0) goto L67;
        int r2 = 0;
        int r3 = r10.indexOf(123, 0);
        if (r3 < 0) goto L12;
        int r6 = r10.indexOf(125, r3 + 1);
    L13:
        if (r6 <= 0) goto L32;
        StringBuilder r7 = new StringBuilder();
    L15:
        String r8 = r10.substring(r3 + 1, r6);
        if (r12 == false) goto L18;
        String r9 = r11.remove(r8);
    L19:
        String r13 = r9;
        r7.append(r10, r2, r3);
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        r7.append(r13);
        r2 = r6 + 1;
        r3 = r10.indexOf(123, r2);
        if (r3 < 0) goto L25;
        r6 = r10.indexOf(125, r3 + 1);
    L26:
        if (r6 > 0) goto L15;
        if (r2 >= r10.length()) goto L31;
        r7.append(r10.substring(r2));
    L31:
        return r7.toString();
    L25:
        r6 = -1;
        goto L26
    L18:
        r9 = r11.get(r8);
        goto L19
    L32:
        int r1 = r10.indexOf(58, r10.indexOf("://") + 1);
        if (r1 <= 0) goto L35;
        int r14 = r10.indexOf(47, r1 + 1);
    L36:
        if (r1 <= 0) goto L67;
        StringBuilder r15 = new StringBuilder();
        if (r14 <= 0) goto L51;
    L39:
        int r16 = r14;
        int r17 = r2;
        r2 = r16;
        String r18 = r10.substring(r1 + 1, r2);
        if (r12 == false) goto L42;
        String r19 = r11.remove(r18);
    L43:
        String r20 = r19;
        r15.append(r10, r17, r1);
        if (r20 != null) goto L46;
        r20 = "";
    L46:
        r15.append(r20);
        r1 = r10.indexOf(58, r2);
        if (r1 < 0) goto L49;
        r14 = r10.indexOf(47, r1 + 1);
    L50:
        if (r14 > 0) goto L39;
    L49:
        r14 = -1;
        goto L50
    L42:
        r19 = r11.get(r18);
    L51:
        if (r1 < 0) goto L63;
        if (r14 >= 0) goto L63;
        String r4 = r10.substring(r1 + 1);
        if (r12 == false) goto L56;
        String r110 = r11.remove(r4);
    L57:
        String r111 = r110;
        r15.append(r10, r2, r1);
        if (r111 == null) goto L61;
        r0 = r111;
    L61:
        r15.append(r0);
    L66:
        return r15.toString();
    L56:
        r110 = r11.get(r4);
    L63:
        if (r2 >= r10.length()) goto L66;
        r15.append(r10.substring(r2));
        goto L66
    L35:
        r14 = -1;
        goto L36
    L12:
        r6 = -1;
        goto L13
    }

    public static String toString(InputStream r4, String r5) throws IOException {
        if (r4 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[4096];
    L15:
        int r2 = r4.read(r1);     // Catch: Throwable -> L12
        if (r2 == (-1)) goto L9;
        r0.write(r1, 0, r2);     // Catch: Throwable -> L12
        goto L15
    L9:
        String r6 = r0.toString(r5);     // Catch: Throwable -> L12
        closeSilently(r0);
        closeSilently(r4);
        return r6;
    L12:
        th = move-exception;
        closeSilently(r0);
        closeSilently(r4);
        throw th;
    }

    public static byte[] toBytes(InputStream r4) throws IOException {
        if (r4 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[4096];
    L15:
        int r2 = r4.read(r1);     // Catch: Throwable -> L12
        if (r2 == (-1)) goto L9;
        r0.write(r1, 0, r2);     // Catch: Throwable -> L12
        goto L15
    L9:
        byte[] r3 = r0.toByteArray();     // Catch: Throwable -> L12
        closeSilently(r0);
        closeSilently(r4);
        return r3;
    L12:
        th = move-exception;
        closeSilently(r0);
        closeSilently(r4);
        throw th;
    }

    public static void closeSilently(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static byte[] gzip(byte[] r2) throws Exception {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (r2.length <= 0) goto L14;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8092);
        GZIPOutputStream r1 = new GZIPOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L8
        r1.close();
        return r0.toByteArray();
    L8:
        th = move-exception;
        r1.close();
        throw th;
    L14:
        return r2;
    }

    public static boolean isVisibleUnNull(CharSequence r0) {
        return !isInvisibleOrNull(r0);
    }

    public static boolean isVisible(CharSequence r0) {
        return !isInvisible(r0);
    }

    public static final boolean isInvisible(CharSequence r2) {
        boolean r0 = false;
        if (r2 != null) goto L5;
        int r1 = 0;
    L6:
        if (r1 != 0) goto L8;
        r0 = true;
    L8:
        if (r0 == true) goto L13;
        int r3 = r1 - 1;
        r0 = Character.isWhitespace(r2.charAt(r3));
    L10:
        if (r0 == false) goto L13;
        if (r3 <= 0) goto L13;
        r3 = r3 - 1;
        r0 = Character.isWhitespace(r2.charAt(r3));
    L13:
        return r0;
    L5:
        r1 = r2.length();
        goto L6
    }

    public static boolean isInvisibleOrNull(CharSequence r1) {
        if (isInvisible(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if ("null".equalsIgnoreCase(r1.toString()) == true) goto L8;
        return false;
    }
}
