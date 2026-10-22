package com.amap.api.col.s;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import kotlin.UByte;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes28.dex */
public class bv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f26347a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f26348b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f26349c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f26350d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f26351e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f26352f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f26353g = null;

    private bv() {
    }

    static {
        f26347a = true;
        f26348b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f26349c = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f26350d = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        f26351e = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f26352f = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        f26353g = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, HTTP.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    public static String a(byte[] r100) {
        String r101 = a(r100, r100.length);     // Catch: IOException -> L4
    L9:
        if (f26347a == true) goto L14;
        if (r101 != null) goto L14;
        throw new AssertionError();
    L14:
        return r101;
    L4:
        e = move-exception;
        if (f26347a == false) goto L16;
        r101 = null;
        goto L9
    L16:
        throw new AssertionError(e.getMessage());
    }

    private static byte[] b(String r100) throws IOException {
        if (r100 == null) goto L50;
        byte[] r101 = r100.getBytes("US-ASCII");     // Catch: UnsupportedEncodingException -> L5
    L6:
        byte[] r102 = b(r101, r101.length);
        if (r102.length >= 4) goto L9;
    L48:
        return r102;
    L9:
        if (35615 != ((r102[0] & UByte.MAX_VALUE) | ((r102[1] << 8) & 65280))) goto L48;
        byte[] r103 = new byte[2048];
        ByteArrayOutputStream r104 = null;
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L36 IOException -> L38
        ByteArrayInputStream r106 = new ByteArrayInputStream(r102);     // Catch: Throwable -> L30 IOException -> L33
    L79:
        GZIPInputStream r107 = new GZIPInputStream(r106);     // Catch: Throwable -> L26 IOException -> L28
    L76:
        int r108 = r107.read(r103);     // Catch: Throwable -> L22 IOException -> L24
        if (r108 < 0) goto L17;
        r105.write(r103, 0, r108);     // Catch: Throwable -> L22 IOException -> L24
        goto L76
    L17:
        r102 = r105.toByteArray();     // Catch: Throwable -> L22 IOException -> L24
        r105.close();     // Catch: Exception -> L51
    L57:
        goto L62
    L24:
        e = e;
    L35:
        r104 = r105;
    L68:
        e.printStackTrace();     // Catch: Throwable -> L43
        r104.close();     // Catch: Exception -> L51
    L43:
        th = th;
    L66:
        r104.close();     // Catch: Exception -> L53
    L64:
        r107.close();     // Catch: Exception -> L54
    L72:
        r106.close();     // Catch: Exception -> L55
        throw th;
    L82:
        throw th;
    L22:
        th = th;
    L32:
        r104 = r105;
        goto L66
    L28:
        e = e;
        r107 = null;
    L26:
        th = th;
        r107 = null;
    L33:
        e = e;
        r106 = null;
        r107 = null;
    L30:
        th = th;
        r106 = null;
        r107 = null;
        goto L32
    L38:
        e = e;
        r106 = null;
        r107 = null;
    L36:
        th = th;
        r106 = null;
        r107 = null;
    L62:
        r107.close();     // Catch: Exception -> L52
    L70:
        r106.close();     // Catch: Exception -> L56
    L5:
        r101 = r100.getBytes();
        goto L6
    L50:
        throw new NullPointerException("Input string was null.");
    }

    public static byte[] a(String r100) throws IOException {
        return b(r100);
    }

    private static String a(byte[] r100, int r110) throws IOException {
        if (r100 == null) goto L27;
        if (r110 < 0) goto L25;
        if ((r110 + 0) > r100.length) goto L23;
        int r101 = 4;
        int r102 = (r110 / 3) * 4;
        if ((r110 % 3) > 0) goto L10;
        r101 = 0;
    L10:
        int r103 = r102 + r101;
        byte[] r104 = new byte[r103];
        int r105 = r110 - 2;
        int r106 = 0;
        int r107 = 0;
    L11:
        if (r106 >= r105) goto L13;
        a(r100, r106 + 0, 3, r104, r107);
        r106 = r106 + 3;
        r107 = r107 + 4;
        goto L11
    L13:
        if (r106 >= r110) goto L16;
        a(r100, r106 + 0, r110 - r106, r104, r107);
        r107 = r107 + 4;
    L16:
        if (r107 > (r103 - 1)) goto L28;
        byte[] r108 = new byte[r107];
        System.arraycopy(r104, 0, r108, 0, r107);
        r104 = r108;
    L28:
        return new String(r104, "US-ASCII");
    L21:
        return new String(r104);
    L23:
        throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{0, Integer.valueOf(r110), Integer.valueOf(r100.length)}));
    L25:
        throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(r110)));
    L27:
        throw new NullPointerException("Cannot serialize a null array.");
    }

    private static byte[] b(byte[] r110, int r111) throws IOException {
        if (r110 == null) goto L46;
        int r100 = r111 + 0;
        int r101 = 3;
        char r102 = 2;
        int r103 = 1;
        if (r100 > r110.length) goto L44;
        if (r111 != 0) goto L10;
        return new byte[0];
    L10:
        if (r111 < 4) goto L42;
        byte[] r104 = f26349c;
        int r105 = (r111 * 3) / 4;
        byte[] r106 = new byte[r105];
        byte[] r107 = new byte[4];
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
    L12:
        if (r112 >= r100) goto L39;
        byte r115 = r110[r112];
        byte r116 = r104[r115 & UByte.MAX_VALUE];
        if (r116 < (-5)) goto L38;
        if (r116 < (-1)) goto L36;
        int r117 = r113 + 1;
        r107[r113] = r115;
        if (r117 <= r101) goto L35;
        if (r114 < 0) goto L34;
        int r118 = r114 + 2;
        if (r118 >= r105) goto L34;
        byte[] r119 = f26349c;
        byte r120 = r107[r102];
        if (r120 != 61) goto L25;
        r106[r114] = (byte) ((((r119[r107[0]] & UByte.MAX_VALUE) << 18) | ((r119[r107[r103]] & UByte.MAX_VALUE) << 12)) >>> 16);
    L29:
        r114 = r114 + r103;
        if (r110[r112] == 61) goto L39;
        r113 = 0;
        goto L36
    L25:
        byte r108 = r107[r101];
        if (r108 != 61) goto L28;
        int r109 = (((r119[r107[0]] & UByte.MAX_VALUE) << 18) | ((r119[r107[r103]] & UByte.MAX_VALUE) << 12)) | ((r119[r120] & UByte.MAX_VALUE) << 6);
        r106[r114] = (byte) (r109 >>> 16);
        r106[r114 + 1] = (byte) (r109 >>> 8);
        r103 = 2;
        goto L29
    L28:
        int r121 = ((((r119[r107[0]] & UByte.MAX_VALUE) << 18) | ((r119[r107[r103]] & UByte.MAX_VALUE) << 12)) | ((r119[r120] & UByte.MAX_VALUE) << 6)) | (r119[r108] & UByte.MAX_VALUE);
        r106[r114] = (byte) (r121 >> 16);
        r106[r114 + 1] = (byte) (r121 >> 8);
        r106[r118] = (byte) r121;
        r103 = 3;
    L34:
        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(r105), Integer.valueOf(r114)}));
    L35:
        r113 = r117;
    L36:
        r112 = r112 + 1;
        r101 = 3;
        r102 = 2;
        r103 = 1;
        goto L12
    L38:
        throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", new Object[]{Integer.valueOf(r110[r112] & UByte.MAX_VALUE), Integer.valueOf(r112)}));
    L39:
        byte[] r122 = new byte[r114];
        System.arraycopy(r106, 0, r122, 0, r114);
        return r122;
    L42:
        throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(r111)));
    L44:
        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(r110.length), 0, Integer.valueOf(r111)}));
    L46:
        throw new NullPointerException("Cannot decode null source array.");
    }

    private static byte[] a(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        byte[] r105 = f26348b;
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
