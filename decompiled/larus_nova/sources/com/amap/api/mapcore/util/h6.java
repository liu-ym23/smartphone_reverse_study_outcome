package com.amap.api.mapcore.util;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import kotlin.UByte;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes28.dex */
public class h6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f27400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f27401b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f27402c = false;

    static {
        f27402c = true;
        f27400a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f27401b = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    private h6() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] a(String r110) throws IOException {
        if (r110 == null) goto L94;
        byte[] r100 = r110.getBytes("US-ASCII");     // Catch: UnsupportedEncodingException -> L6
    L7:
        int r101 = r100.length;
        int r102 = r101 + 0;
        int r103 = 3;
        char r104 = 2;
        int r105 = 1;
        if (r102 > r100.length) goto L92;
        if (r101 != 0) goto L13;
        byte[] r106 = new byte[0];
    L12:
        byte[] r107 = r106;
        if (r107.length >= 4) goto L46;
    L88:
        return r107;
    L46:
        if (35615 != ((r107[0] & UByte.MAX_VALUE) | ((r107[1] << 8) & 65280))) goto L88;
        byte[] r108 = new byte[2048];
        ByteArrayOutputStream r109 = null;
        GZIPInputStream r111 = null;
        ByteArrayOutputStream r112 = null;
        ByteArrayOutputStream r113 = new ByteArrayOutputStream();     // Catch: Throwable -> L70 IOException -> L72
    L126:
        ByteArrayInputStream r114 = new ByteArrayInputStream(r107);     // Catch: Throwable -> L65 IOException -> L67
        GZIPInputStream r115 = new GZIPInputStream(r114);     // Catch: Throwable -> L61 IOException -> L63
    L124:
        int r116 = r115.read(r108);     // Catch: Throwable -> L57 IOException -> L59
        if (r116 < 0) goto L54;
        r113.write(r108, 0, r116);     // Catch: Throwable -> L57 IOException -> L59
        goto L124
    L54:
        byte[] r117 = r113.toByteArray();     // Catch: Throwable -> L57 IOException -> L59
        r113.close();     // Catch: Exception -> L95
    L56:
        r107 = r117;
    L108:
        r115.close();     // Catch: Exception -> L97
    L114:
        r114.close();     // Catch: Exception -> L101
        goto L88
    L59:
        e = e;
    L69:
        r112 = r113;
    L112:
        e.printStackTrace();     // Catch: Throwable -> L79
        r112.close();     // Catch: Exception -> L96
    L79:
        th = th;
        r113 = r112;
    L81:
        r111 = r115;
    L82:
        GZIPInputStream r118 = r111;
    L83:
        r109 = r113;
    L110:
        r109.close();     // Catch: Exception -> L98
    L118:
        r118.close();     // Catch: Exception -> L99
    L116:
        r114.close();     // Catch: Exception -> L100
        throw th;
    L137:
        throw th;
    L57:
        th = th;
    L63:
        e = e;
        r115 = null;
    L61:
        th = th;
        goto L82
    L67:
        e = e;
        r114 = null;
        r115 = null;
    L65:
        th = th;
        r118 = null;
        r114 = null;
    L72:
        e = e;
        r114 = null;
        r115 = null;
    L70:
        th = th;
        r118 = null;
        r114 = null;
        goto L110
    L13:
        if (r101 < 4) goto L90;
        byte[] r119 = f27401b;
        int r120 = (r101 * 3) / 4;
        byte[] r121 = new byte[r120];
        byte[] r122 = new byte[4];
        int r123 = 0;
        int r124 = 0;
        int r125 = 0;
    L15:
        if (r123 >= r102) goto L42;
        byte r126 = r100[r123];
        byte r127 = r119[r126 & UByte.MAX_VALUE ? 1 : 0];
        if (r127 < (-5)) goto L41;
        if (r127 < (-1)) goto L39;
        int r128 = r124 + 1;
        r122[r124] = r126;
        if (r128 <= r103) goto L38;
        if (r125 < 0) goto L37;
        int r129 = r125 + 2;
        if (r129 >= r120) goto L37;
        byte[] r130 = f27401b;
        byte r131 = r122[r104];
        if (r131 != 61) goto L28;
        r121[r125] = (byte) ((((r130[r122[0]] & UByte.MAX_VALUE) << 18) | ((r130[r122[r105]] & UByte.MAX_VALUE) << 12)) >>> 16);
    L32:
        r125 = r125 + r105;
        if (r100[r123] == 61) goto L42;
        r124 = 0;
        goto L39
    L28:
        byte r132 = r122[r103];
        if (r132 != 61) goto L31;
        int r133 = (((r130[r122[0]] & UByte.MAX_VALUE) << 18) | ((r130[r122[r105]] & UByte.MAX_VALUE) << 12)) | ((r130[r131] & UByte.MAX_VALUE) << 6);
        r121[r125] = (byte) (r133 >>> 16);
        r121[r125 + 1] = (byte) (r133 >>> 8);
        r105 = 2;
        goto L32
    L31:
        int r134 = ((((r130[r122[0]] & UByte.MAX_VALUE) << 18) | ((r130[r122[r105]] & UByte.MAX_VALUE) << 12)) | ((r130[r131] & UByte.MAX_VALUE) << 6)) | (r130[r132] & UByte.MAX_VALUE);
        r121[r125] = (byte) (r134 >> 16);
        r121[r125 + 1] = (byte) (r134 >> 8);
        r121[r129] = (byte) r134;
        r105 = 3;
    L37:
        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(r120), Integer.valueOf(r125)}));
    L38:
        r124 = r128;
    L39:
        r123 = r123 + 1;
        r103 = 3;
        r104 = 2;
        r105 = 1;
        goto L15
    L41:
        throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", new Object[]{Integer.valueOf(r100[r123] & UByte.MAX_VALUE), Integer.valueOf(r123)}));
    L42:
        r106 = new byte[r125];
        System.arraycopy(r121, 0, r106, 0, r125);
        goto L12
    L90:
        throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(r101)));
    L92:
        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(r100.length), 0, Integer.valueOf(r101)}));
    L6:
        r100 = r110.getBytes();
        goto L7
    L94:
        throw new NullPointerException("Input string was null.");
    }

    public static String a(byte[] r100) {
        String r101 = a(r100, r100.length);     // Catch: IOException -> L4
    L9:
        if (f27402c == true) goto L14;
        if (r101 != null) goto L14;
        throw new AssertionError();
    L14:
        return r101;
    L4:
        e = move-exception;
        if (f27402c == false) goto L16;
        r101 = null;
        goto L9
    L16:
        throw new AssertionError(e.getMessage());
    }

    private static String a(byte[] r100, int r110) throws IOException {
        if (r110 < 0) goto L24;
        if ((r110 + 0) > r100.length) goto L22;
        int r101 = 4;
        int r102 = (r110 / 3) * 4;
        if ((r110 % 3) > 0) goto L9;
        r101 = 0;
    L9:
        int r103 = r102 + r101;
        byte[] r104 = new byte[r103];
        int r105 = r110 - 2;
        int r106 = 0;
        int r107 = 0;
    L10:
        if (r106 >= r105) goto L12;
        a(r100, r106 + 0, 3, r104, r107);
        r106 = r106 + 3;
        r107 = r107 + 4;
        goto L10
    L12:
        if (r106 >= r110) goto L15;
        a(r100, r106 + 0, r110 - r106, r104, r107);
        r107 = r107 + 4;
    L15:
        if (r107 > (r103 - 1)) goto L25;
        byte[] r108 = new byte[r107];
        System.arraycopy(r104, 0, r108, 0, r107);
        r104 = r108;
    L25:
        return new String(r104, "US-ASCII");
    L20:
        return new String(r104);
    L22:
        throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{0, Integer.valueOf(r110), Integer.valueOf(r100.length)}));
    L24:
        throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(r110)));
    }

    private static byte[] a(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        byte[] r105 = f27400a;
        int r106 = 0;
        if (r102 <= 0) goto L5;
        int r107 = (r100[r101] << 24) >>> 8;
    L7:
        if (r102 <= 1) goto L9;
        int r108 = (r100[r101 + 1] << 24) >>> 16;
    L10:
        int r109 = r107 | r108;
        if (r102 <= 2) goto L13;
        r106 = (r100[r101 + 2] << 24) >>> 24;
    L13:
        int r110 = r109 | r106;
        if (r102 == 1) goto L22;
        if (r102 == 2) goto L20;
        if (r102 == 3) goto L18;
        return r103;
    L18:
        r103[r104] = r105[r110 >>> 18];
        r103[r104 + 1] = r105[(r110 >>> 12) & 63];
        r103[r104 + 2] = r105[(r110 >>> 6) & 63];
        r103[r104 + 3] = r105[r110 & 63];
        return r103;
    L20:
        r103[r104] = r105[r110 >>> 18];
        r103[r104 + 1] = r105[(r110 >>> 12) & 63];
        r103[r104 + 2] = r105[(r110 >>> 6) & 63];
        r103[r104 + 3] = Base64.padSymbol;
        return r103;
    L22:
        r103[r104] = r105[r110 >>> 18];
        r103[r104 + 1] = r105[(r110 >>> 12) & 63];
        r103[r104 + 2] = Base64.padSymbol;
        r103[r104 + 3] = Base64.padSymbol;
        return r103;
    L9:
        r108 = 0;
        goto L10
    L5:
        r107 = 0;
        goto L7
    }
}
