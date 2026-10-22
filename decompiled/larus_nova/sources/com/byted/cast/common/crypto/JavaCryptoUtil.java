package com.byted.cast.common.crypto;

import android.text.TextUtils;
import com.alipay.sdk.m.n.d;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.UByte;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes39.dex */
public class JavaCryptoUtil {
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    public static abstract class Coder {

        /* JADX INFO: renamed from: op, reason: collision with root package name */
        public int f33710op;
        public byte[] output;

        public Coder() {
        }

        public abstract int maxOutputSize(int r100);

        public abstract boolean process(byte[] r100, int r101, int r102, boolean r103);
    }

    public static class Decoder extends Coder {
        private static final int[] DECODE = null;
        private static final int[] DECODE_WEBSAFE = null;
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        static {
            DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            DECODE_WEBSAFE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        @Override // com.byted.cast.common.crypto.JavaCryptoUtil.Coder
        public int maxOutputSize(int r100) {
            return ((r100 * 3) / 4) + 10;
        }

        public Decoder(int r100, byte[] r101) {
            this.output = r101;
            if ((r100 & 8) != 0) goto L5;
            int[] r102 = DECODE;
        L6:
            this.alphabet = r102;
            this.state = 0;
            this.value = 0;
            return;
        L5:
            r102 = DECODE_WEBSAFE;
            goto L6
        }

        @Override // com.byted.cast.common.crypto.JavaCryptoUtil.Coder
        public boolean process(byte[] r110, int r111, int r112, boolean r210) {
            int r100 = this.state;
            if (r100 != 6) goto L5;
            return false;
        L5:
            int r101 = r112 + r111;
            int r102 = this.value;
            byte[] r103 = this.output;
            int[] r104 = this.alphabet;
            int r105 = r102;
            int r106 = 0;
            int r107 = r100;
            int r108 = r111;
        L7:
            if (r108 >= r101) goto L59;
            if (r107 != 0) goto L16;
        L9:
            int r113 = r108 + 4;
            if (r113 > r101) goto L14;
            r105 = (((r104[r110[r108] & UByte.MAX_VALUE] << 18) | (r104[r110[r108 + 1] & UByte.MAX_VALUE] << 12)) | (r104[r110[r108 + 2] & UByte.MAX_VALUE] << 6)) | r104[r110[r108 + 3] & UByte.MAX_VALUE];
            if (r105 < 0) goto L14;
            r103[r106 + 2] = (byte) r105;
            r103[r106 + 1] = (byte) (r105 >> 8);
            r103[r106] = (byte) (r105 >> 16);
            r106 = r106 + 3;
            r108 = r113;
        L14:
            if (r108 >= r101) goto L59;
        L16:
            int r114 = r108 + 1;
            int r109 = r104[r110[r108] & UByte.MAX_VALUE];
            if (r107 == 0) goto L53;
            if (r107 != 1) goto L20;
            if (r109 < 0) goto L50;
        L49:
            r109 = r109 | (r105 << 6);
        L54:
            r107 = r107 + 1;
            r105 = r109;
        L58:
            r108 = r114;
            goto L7
        L50:
            if (r109 == (-1)) goto L58;
            this.state = 6;
            return false;
        L20:
            if (r107 != 2) goto L22;
            if (r109 >= 0) goto L49;
            if (r109 != (-2)) goto L45;
            r103[r106] = (byte) (r105 >> 4);
            r106 = r106 + 1;
            r107 = 4;
            goto L58
        L45:
            if (r109 == (-1)) goto L58;
            this.state = 6;
            return false;
        L22:
            if (r107 == 3) goto L34;
            if (r107 == 4) goto L29;
            if (r107 != 5) goto L58;
            if (r109 == (-1)) goto L58;
            this.state = 6;
            return false;
        L29:
            if (r109 != (-2)) goto L31;
            r107 = r107 + 1;
            goto L58
        L31:
            if (r109 == (-1)) goto L58;
            this.state = 6;
            return false;
        L34:
            if (r109 < 0) goto L36;
            int r115 = r109 | (r105 << 6);
            r103[r106 + 2] = (byte) r115;
            r103[r106 + 1] = (byte) (r115 >> 8);
            r103[r106] = (byte) (r115 >> 16);
            r106 = r106 + 3;
            r105 = r115;
            r107 = 0;
            goto L58
        L36:
            if (r109 != (-2)) goto L38;
            r103[r106 + 1] = (byte) (r105 >> 2);
            r103[r106] = (byte) (r105 >> 10);
            r106 = r106 + 2;
            r107 = 5;
            goto L58
        L38:
            if (r109 == (-1)) goto L58;
            this.state = 6;
            return false;
        L53:
            if (r109 >= 0) goto L54;
            if (r109 == (-1)) goto L58;
            this.state = 6;
            return false;
        L59:
            if (r210 == true) goto L62;
            this.state = r107;
            this.value = r105;
            this.f33710op = r106;
            return true;
        L62:
            if (r107 == 1) goto L71;
            if (r107 == 2) goto L68;
            if (r107 == 3) goto L67;
            if (r107 == 4) goto L71;
        L69:
            this.state = r107;
            this.f33710op = r106;
            return true;
        L67:
            int r116 = r106 + 1;
            r103[r106] = (byte) (r105 >> 10);
            r106 = r116 + 1;
            r103[r116] = (byte) (r105 >> 2);
            goto L69
        L68:
            r103[r106] = (byte) (r105 >> 4);
            r106 = r106 + 1;
        L71:
            this.state = 6;
            return false;
        }
    }

    public static class Encoder extends Coder {
        private static final byte[] ENCODE = null;
        private static final byte[] ENCODE_WEBSAFE = null;
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        static {
            ENCODE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            ENCODE_WEBSAFE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        @Override // com.byted.cast.common.crypto.JavaCryptoUtil.Coder
        public int maxOutputSize(int r100) {
            return ((r100 * 8) / 5) + 10;
        }

        public Encoder(int r100, byte[] r101) {
            this.output = r101;
            boolean r102 = true;
            if ((r100 & 1) != 0) goto L5;
            boolean r103 = true;
        L6:
            this.do_padding = r103;
            if ((r100 & 2) != 0) goto L9;
            boolean r104 = true;
        L10:
            this.do_newline = r104;
            if ((r100 & 4) != 0) goto L14;
            r102 = false;
        L14:
            this.do_cr = r102;
            if ((r100 & 8) != 0) goto L17;
            byte[] r105 = ENCODE;
        L18:
            this.alphabet = r105;
            this.tail = new byte[2];
            this.tailLen = 0;
            if (r104 == false) goto L21;
            int r106 = 19;
        L22:
            this.count = r106;
            return;
        L21:
            r106 = -1;
            goto L22
        L17:
            r105 = ENCODE_WEBSAFE;
            goto L18
        L9:
            r104 = false;
            goto L10
        L5:
            r103 = false;
            goto L6
        }

        @Override // com.byted.cast.common.crypto.JavaCryptoUtil.Coder
        public boolean process(byte[] r110, int r111, int r210, boolean r211) {
            byte[] r100 = this.alphabet;
            byte[] r101 = this.output;
            int r102 = this.count;
            int r103 = r210 + r111;
            int r104 = this.tailLen;
            int r105 = 0;
            if (r104 == 1) goto L10;
            if (r104 != 2) goto L12;
            int r106 = r111 + 1;
            if (r106 > r103) goto L12;
            byte[] r112 = this.tail;
            int r113 = (((r112[1] & UByte.MAX_VALUE) << 8) | ((r112[0] & UByte.MAX_VALUE) << 16)) | (r110[r111] & UByte.MAX_VALUE);
            this.tailLen = 0;
            int r114 = r106;
        L14:
            if (r113 == (-1)) goto L24;
            r101[0] = r100[(r113 >> 18) & 63];
            r101[1] = r100[(r113 >> 12) & 63];
            r101[2] = r100[(r113 >> 6) & 63];
            r101[3] = r100[r113 & 63];
            r102 = r102 - 1;
            if (r102 == 0) goto L18;
            int r107 = 4;
        L25:
            int r115 = r114 + 3;
            if (r115 > r103) goto L34;
            int r108 = (((r110[r114 + 1] & UByte.MAX_VALUE) << 8) | ((r110[r114] & UByte.MAX_VALUE) << 16)) | (r110[r114 + 2] & UByte.MAX_VALUE);
            r101[r107] = r100[(r108 >> 18) & 63];
            r101[r107 + 1] = r100[(r108 >> 12) & 63];
            r101[r107 + 2] = r100[(r108 >> 6) & 63];
            r101[r107 + 3] = r100[r108 & 63];
            r107 = r107 + 4;
            r102 = r102 - 1;
            if (r102 == 0) goto L30;
            r114 = r115;
            goto L25
        L30:
            if (this.do_cr == false) goto L32;
            int r109 = r107 + 1;
            r101[r107] = HTTP.CR;
        L32:
            r101[r109] = 10;
            r107 = r109 + 1;
            r114 = r115;
        L22:
            r102 = 19;
            goto L25
        L87:
            r101[r107] = 10;
            r107 = r107 + 1;
            r114 = r115;
            goto L22
        L34:
            if (r211 == false) goto L80;
            int r116 = this.tailLen;
            if ((r114 - r116) != (r103 - 1)) goto L51;
            if (r116 <= 0) goto L39;
            byte r117 = this.tail[0];
            r105 = 1;
        L40:
            int r118 = (r117 & UByte.MAX_VALUE) << 4;
            this.tailLen = r116 - r105;
            int r119 = r107 + 1;
            r101[r107] = r100[(r118 >> 6) & 63];
            int r120 = r119 + 1;
            r101[r119] = r100[r118 & 63];
            if (this.do_padding == false) goto L44;
            int r121 = r120 + 1;
            r101[r120] = Base64.padSymbol;
            r120 = r121 + 1;
            r101[r121] = Base64.padSymbol;
        L44:
            if (this.do_newline == true) goto L46;
            r107 = r120;
        L85:
            this.f33710op = r107;
            this.count = r102;
            return true;
        L46:
            if (this.do_cr == false) goto L48;
            r101[r120] = HTTP.CR;
            r120 = r120 + 1;
        L48:
            int r122 = r120 + 1;
            r101[r120] = 10;
        L78:
            r107 = r122;
            goto L85
        L39:
            r117 = r110[r114];
            goto L40
        L51:
            if ((r114 - r116) != (r103 - 2)) goto L70;
            if (r116 <= 1) goto L54;
            byte r123 = this.tail[0];
            r105 = 1;
        L55:
            int r124 = (r123 & UByte.MAX_VALUE) << 10;
            if (r116 <= 0) goto L58;
            int r125 = r105 + 1;
            byte r126 = this.tail[r105];
        L59:
            int r127 = r124 | ((r126 & UByte.MAX_VALUE) << 2);
            this.tailLen = r116 - r125;
            int r128 = r107 + 1;
            r101[r107] = r100[(r127 >> 12) & 63];
            int r129 = r128 + 1;
            r101[r128] = r100[(r127 >> 6) & 63];
            int r130 = r129 + 1;
            r101[r129] = r100[r127 & 63];
            if (this.do_padding == false) goto L63;
            r101[r130] = Base64.padSymbol;
            r130 = r130 + 1;
        L63:
            if (this.do_newline == true) goto L65;
            r107 = r130;
            goto L85
        L65:
            if (this.do_cr == false) goto L67;
            r101[r130] = HTTP.CR;
            r130 = r130 + 1;
        L67:
            r122 = r130 + 1;
            r101[r130] = 10;
            goto L78
        L58:
            byte r131 = r110[r114];
            r125 = r105;
            r126 = r131;
            goto L59
        L54:
            byte r132 = r110[r114];
            r114 = r114 + 1;
            r123 = r132;
            goto L55
        L70:
            if (this.do_newline == false) goto L85;
            if (r107 <= 0) goto L85;
            if (r102 == 19) goto L85;
            if (this.do_cr == false) goto L77;
            r101[r107] = HTTP.CR;
            r107 = r107 + 1;
        L77:
            r122 = r107 + 1;
            r101[r107] = 10;
            goto L78
        L80:
            if (r114 != (r103 - 1)) goto L83;
            byte[] r133 = this.tail;
            int r134 = this.tailLen;
            this.tailLen = r134 + 1;
            r133[r134] = r110[r114];
            goto L85
        L83:
            if (r114 != (r103 - 2)) goto L85;
            byte[] r135 = this.tail;
            int r136 = this.tailLen;
            int r137 = r136 + 1;
            r135[r136] = r110[r114];
            this.tailLen = r137 + 1;
            r135[r137] = r110[r114 + 1];
            goto L85
        L18:
            if (this.do_cr == false) goto L20;
            r101[4] = HTTP.CR;
            int r138 = 5;
        L21:
            r107 = r138 + 1;
            r101[r138] = 10;
            goto L22
        L20:
            r138 = 4;
            goto L21
        L24:
            r107 = 0;
        L12:
            r114 = r111;
            r113 = -1;
            goto L14
        L10:
            if ((r111 + 2) > r103) goto L12;
            int r139 = r111 + 1;
            r114 = r139 + 1;
            r113 = (r110[r139] & UByte.MAX_VALUE) | (((this.tail[0] & UByte.MAX_VALUE) << 16) | ((r110[r111] & UByte.MAX_VALUE) << 8));
            this.tailLen = 0;
            goto L14
        }
    }

    public JavaCryptoUtil() {
    }

    public static byte[] base64Decode(String r100) {
        return decode(r100.trim().getBytes(), 0);
    L4:
        return null;
    }

    public static byte[] base64DecodeWithNoWrap(String r100) {
        return decode(r100.trim().getBytes(), 2);
    L4:
        return null;
    }

    public static String base64Encode(byte[] r100) {
        return new String(encode(r100, 0), Charset.forName("US-ASCII")).trim();
    L4:
        return null;
    }

    public static String base64EncodeWithNoWrap(byte[] r100) {
        return new String(encode(r100, 2), Charset.forName("US-ASCII")).trim();
    L4:
        return null;
    }

    private static RSAPrivateKey generatePrivateKey(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L19;
        return null;
    L19:
        byte[] r101 = base64Decode(ignoreIdentifier(r100));     // Catch: Exception -> L16
        if (r101 == null) goto L15;
        if (r101.length == 0) goto L15;
        KeyFactory r102 = KeyFactory.getInstance(d.f25615a);     // Catch: Exception -> L16
        return (RSAPrivateKey) r102.generatePrivate(new PKCS8EncodedKeySpec(r101));
    L13:
        return (RSAPrivateKey) r102.generatePrivate(new X509EncodedKeySpec(r101));
    L15:
        return null;
    }

    private static RSAPublicKey generatePublicKey(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L14;
        return null;
    L14:
        byte[] r101 = base64Decode(ignoreIdentifier(r100));     // Catch: Exception -> L13
        if (r101 == null) goto L12;
        if (r101.length == 0) goto L12;
        return (RSAPublicKey) KeyFactory.getInstance(d.f25615a).generatePublic(new X509EncodedKeySpec(r101));
    L12:
        return null;
    }

    private static String ignoreIdentifier(String r100) {
        StringBuilder r101 = new StringBuilder();
        String[] r102 = r100.split("\n");
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        String r105 = r102[r104];
        if (r105.charAt(0) == '-') goto L7;
        r101.append(r105);
        r101.append('\n');
    L7:
        r104 = r104 + 1;
        goto L3
    L9:
        return r101.toString();
    }

    public static String sha256Encode(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return null;
    L11:
        byte[] r101 = MessageDigest.getInstance("SHA-256").digest(r100.getBytes());     // Catch: Exception -> L10
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L10
        int r103 = r101.length;     // Catch: Exception -> L10
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        r102.append(String.format("%02x", new Object[]{Byte.valueOf(r101[r104])}));     // Catch: Exception -> L10
        r104 = r104 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
        return r102.toString();
    L10:
        return null;
    }

    private static byte[] decode(byte[] r100, int r101) throws IllegalArgumentException {
        if (r100 == null) goto L15;
        if (r100.length == 0) goto L15;
        int r102 = r100.length;
        Decoder r103 = new Decoder(r101, new byte[(r102 * 3) / 4]);
        if (r103.process(r100, 0, r102, true) == false) goto L13;
        int r104 = r103.f33710op;
        byte[] r105 = r103.output;
        if (r104 != r105.length) goto L10;
        return r105;
    L10:
        byte[] r106 = new byte[r104];
        System.arraycopy(r105, 0, r106, 0, r104);
        return r106;
    L13:
        throw new IllegalArgumentException("bad base-64");
    L15:
        throw new IllegalArgumentException("data is null");
    }

    private static byte[] encode(byte[] r100, int r101) throws IllegalArgumentException {
        if (r100 == null) goto L26;
        if (r100.length == 0) goto L26;
        int r102 = r100.length;
        Encoder r103 = new Encoder(r101, null);
        int r104 = (r102 / 3) * 4;
        int r105 = 2;
        if (r103.do_padding == true) goto L8;
        int r106 = r102 % 3;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L17;
        r104 = r104 + 3;
    L17:
        if (r103.do_newline == false) goto L23;
        int r107 = ((r102 - 1) / 57) + 1;
        if (r103.do_cr == true) goto L22;
        r105 = 1;
    L22:
        r104 = r104 + (r107 * r105);
    L23:
        r103.output = new byte[r104];
        r103.process(r100, 0, r102, true);
        return r103.output;
    L15:
        r104 = r104 + 2;
        goto L17
    L8:
        if ((r102 % 3) <= 0) goto L17;
        r104 = r104 + 4;
    L26:
        throw new IllegalArgumentException("data is null");
    }

    public static String rsaDecryptWithPublicKey(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        byte[] r102 = base64Decode(r100);     // Catch: Exception -> L10
        RSAPublicKey r103 = generatePublicKey(r101);     // Catch: Exception -> L10
        Cipher r104 = Cipher.getInstance("RSA/ECB/PKCS1Padding");     // Catch: Exception -> L10
        r104.init(2, r103);     // Catch: Exception -> L10
        return new String(r104.doFinal(r102));
    }

    public static String rsaEncryptWithPrivateKey(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        RSAPrivateKey r102 = generatePrivateKey(r101);     // Catch: Exception -> L10
        Cipher r103 = Cipher.getInstance("RSA/ECB/PKCS1Padding");     // Catch: Exception -> L10
        r103.init(1, r102);     // Catch: Exception -> L10
        return base64Encode(r103.doFinal(r100.getBytes()));
    }
}
