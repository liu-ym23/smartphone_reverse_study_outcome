package com.alipay.sdk.m.l0;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes28.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f25510a = false;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f25511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f25512b;

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.l0.b$b, reason: collision with other inner class name */
    public static class C0487b extends a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int[] f25513f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int[] f25514g = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f25515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f25516d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f25517e;

        static {
            f25513f = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            f25514g = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public C0487b(int r100, byte[] r101) {
            this.f25511a = r101;
            if ((r100 & 8) != 0) goto L5;
            int[] r102 = f25513f;
        L6:
            this.f25517e = r102;
            this.f25515c = 0;
            this.f25516d = 0;
            return;
        L5:
            r102 = f25514g;
            goto L6
        }

        public boolean a(byte[] r110, int r111, int r112, boolean r210) {
            int r100 = this.f25515c;
            if (r100 != 6) goto L5;
            return false;
        L5:
            int r101 = r112 + r111;
            int r102 = this.f25516d;
            byte[] r103 = this.f25511a;
            int[] r104 = this.f25517e;
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
            this.f25515c = 6;
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
            this.f25515c = 6;
            return false;
        L22:
            if (r107 == 3) goto L34;
            if (r107 == 4) goto L29;
            if (r107 != 5) goto L58;
            if (r109 == (-1)) goto L58;
            this.f25515c = 6;
            return false;
        L29:
            if (r109 != (-2)) goto L31;
            r107 = r107 + 1;
            goto L58
        L31:
            if (r109 == (-1)) goto L58;
            this.f25515c = 6;
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
            this.f25515c = 6;
            return false;
        L53:
            if (r109 >= 0) goto L54;
            if (r109 == (-1)) goto L58;
            this.f25515c = 6;
            return false;
        L59:
            if (r210 == true) goto L62;
            this.f25515c = r107;
            this.f25516d = r105;
            this.f25512b = r106;
            return true;
        L62:
            if (r107 == 1) goto L73;
            if (r107 == 2) goto L70;
            if (r107 == 3) goto L69;
            if (r107 != 4) goto L71;
            this.f25515c = 6;
            return false;
        L71:
            this.f25515c = r107;
            this.f25512b = r106;
            return true;
        L69:
            int r116 = r106 + 1;
            r103[r106] = (byte) (r105 >> 10);
            r106 = r116 + 1;
            r103[r116] = (byte) (r105 >> 2);
            goto L71
        L70:
            r103[r106] = (byte) (r105 >> 4);
            r106 = r106 + 1;
            goto L71
        L73:
            this.f25515c = 6;
            return false;
        }
    }

    public static class c extends a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final byte[] f25518j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final byte[] f25519k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ boolean f25520l = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f25521c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f25522d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f25523e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f25524f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f25525g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f25526h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final byte[] f25527i;

        static {
            f25520l = true;
            f25518j = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            f25519k = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        public c(int r100, byte[] r101) {
            this.f25511a = r101;
            boolean r102 = true;
            if ((r100 & 1) != 0) goto L5;
            boolean r103 = true;
        L6:
            this.f25524f = r103;
            if ((r100 & 2) != 0) goto L9;
            boolean r104 = true;
        L10:
            this.f25525g = r104;
            if ((r100 & 4) != 0) goto L14;
            r102 = false;
        L14:
            this.f25526h = r102;
            if ((r100 & 8) != 0) goto L17;
            byte[] r105 = f25518j;
        L18:
            this.f25527i = r105;
            this.f25521c = new byte[2];
            this.f25522d = 0;
            if (r104 == false) goto L21;
            int r106 = 19;
        L22:
            this.f25523e = r106;
            return;
        L21:
            r106 = -1;
            goto L22
        L17:
            r105 = f25519k;
            goto L18
        L9:
            r104 = false;
            goto L10
        L5:
            r103 = false;
            goto L6
        }

        public boolean a(byte[] r110, int r111, int r210, boolean r211) {
            byte[] r100 = this.f25527i;
            byte[] r101 = this.f25511a;
            int r102 = this.f25523e;
            int r103 = r210 + r111;
            int r104 = this.f25522d;
            int r105 = 0;
            if (r104 == 1) goto L10;
            if (r104 != 2) goto L12;
            int r106 = r111 + 1;
            if (r106 > r103) goto L12;
            byte[] r112 = this.f25521c;
            int r113 = (((r112[1] & UByte.MAX_VALUE) << 8) | ((r112[0] & UByte.MAX_VALUE) << 16)) | (r110[r111] & UByte.MAX_VALUE);
            this.f25522d = 0;
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
            if (this.f25526h == false) goto L32;
            int r109 = r107 + 1;
            r101[r107] = HTTP.CR;
        L32:
            r101[r109] = 10;
            r107 = r109 + 1;
            r114 = r115;
        L22:
            r102 = 19;
            goto L25
        L99:
            r101[r107] = 10;
            r107 = r107 + 1;
            r114 = r115;
            goto L22
        L34:
            if (r211 == false) goto L92;
            int r116 = this.f25522d;
            int r117 = r114 - r116;
            if (r117 != (r103 - 1)) goto L51;
            if (r116 <= 0) goto L39;
            byte r118 = this.f25521c[0];
            r105 = 1;
        L40:
            int r119 = (r118 & UByte.MAX_VALUE) << 4;
            this.f25522d = r116 - r105;
            int r120 = r107 + 1;
            r101[r107] = r100[(r119 >> 6) & 63];
            int r121 = r120 + 1;
            r101[r120] = r100[r119 & 63];
            if (this.f25524f == false) goto L44;
            int r122 = r121 + 1;
            r101[r121] = Base64.padSymbol;
            r121 = r122 + 1;
            r101[r122] = Base64.padSymbol;
        L44:
            if (this.f25525g == true) goto L46;
            r107 = r121;
        L79:
            boolean r123 = f25520l;
            if (r123 == false) goto L82;
        L86:
            if (r123 == true) goto L97;
            if (r114 == r103) goto L97;
            throw new AssertionError();
        L97:
            this.f25512b = r107;
            this.f25523e = r102;
            return true;
        L82:
            if (this.f25522d == 0) goto L86;
            throw new AssertionError();
        L46:
            if (this.f25526h == false) goto L48;
            r101[r121] = HTTP.CR;
            r121 = r121 + 1;
        L48:
            int r124 = r121 + 1;
            r101[r121] = 10;
        L78:
            r107 = r124;
            goto L79
        L39:
            byte r125 = r110[r114];
            r114 = r114 + 1;
            r118 = r125;
            goto L40
        L51:
            if (r117 != (r103 - 2)) goto L70;
            if (r116 <= 1) goto L54;
            byte r126 = this.f25521c[0];
            int r127 = 1;
        L55:
            int r128 = (r126 & UByte.MAX_VALUE) << 10;
            if (r116 <= 0) goto L58;
            int r129 = r127 + 1;
            byte r130 = this.f25521c[r127];
        L59:
            int r131 = ((r130 & UByte.MAX_VALUE) << 2) | r128;
            this.f25522d = r116 - r129;
            int r132 = r107 + 1;
            r101[r107] = r100[(r131 >> 12) & 63];
            int r133 = r132 + 1;
            r101[r132] = r100[(r131 >> 6) & 63];
            int r134 = r133 + 1;
            r101[r133] = r100[r131 & 63];
            if (this.f25524f == false) goto L63;
            r101[r134] = Base64.padSymbol;
            r134 = r134 + 1;
        L63:
            if (this.f25525g == true) goto L65;
            r107 = r134;
            goto L79
        L65:
            if (this.f25526h == false) goto L67;
            r101[r134] = HTTP.CR;
            r134 = r134 + 1;
        L67:
            r124 = r134 + 1;
            r101[r134] = 10;
            goto L78
        L58:
            r129 = r127;
            r130 = r110[r114];
            r114 = r114 + 1;
            goto L59
        L54:
            r126 = r110[r114];
            r114 = r114 + 1;
            r127 = 0;
            goto L55
        L70:
            if (this.f25525g == false) goto L79;
            if (r107 <= 0) goto L79;
            if (r102 == 19) goto L79;
            if (this.f25526h == false) goto L77;
            r101[r107] = HTTP.CR;
            r107 = r107 + 1;
        L77:
            r124 = r107 + 1;
            r101[r107] = 10;
            goto L78
        L92:
            if (r114 != (r103 - 1)) goto L95;
            byte[] r135 = this.f25521c;
            int r136 = this.f25522d;
            this.f25522d = r136 + 1;
            r135[r136] = r110[r114];
            goto L97
        L95:
            if (r114 != (r103 - 2)) goto L97;
            byte[] r137 = this.f25521c;
            int r138 = this.f25522d;
            int r139 = r138 + 1;
            r137[r138] = r110[r114];
            this.f25522d = r139 + 1;
            r137[r139] = r110[r114 + 1];
            goto L97
        L18:
            if (this.f25526h == false) goto L20;
            r101[4] = HTTP.CR;
            int r140 = 5;
        L21:
            r107 = r140 + 1;
            r101[r140] = 10;
            goto L22
        L20:
            r140 = 4;
            goto L21
        L24:
            r107 = 0;
        L12:
            r114 = r111;
            r113 = -1;
            goto L14
        L10:
            if ((r111 + 2) > r103) goto L12;
            int r141 = r111 + 1;
            r114 = r141 + 1;
            r113 = (r110[r141] & UByte.MAX_VALUE) | (((this.f25521c[0] & UByte.MAX_VALUE) << 16) | ((r110[r111] & UByte.MAX_VALUE) << 8));
            this.f25522d = 0;
            goto L14
        }
    }

    static {
        f25510a = true;
    }

    public b() {
    }

    public static byte[] a(byte[] r100, int r101) {
        return a(r100, 0, r100.length, r101);
    }

    public static byte[] b(byte[] r100, int r101) {
        return b(r100, 0, r100.length, r101);
    }

    public static String c(byte[] r100, int r101) {
        return new String(b(r100, r101), "US-ASCII");
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static byte[] a(byte[] r100, int r101, int r102, int r103) {
        C0487b r104 = new C0487b(r103, new byte[(r102 * 3) / 4]);
        if (r104.a(r100, r101, r102, true) == false) goto L10;
        int r105 = r104.f25512b;
        byte[] r106 = r104.f25511a;
        if (r105 != r106.length) goto L7;
        return r106;
    L7:
        byte[] r107 = new byte[r105];
        System.arraycopy(r106, 0, r107, 0, r105);
        return r107;
    L10:
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] b(byte[] r100, int r101, int r102, int r103) {
        c r104 = new c(r103, null);
        int r105 = (r102 / 3) * 4;
        int r106 = 2;
        if (r104.f25524f == true) goto L5;
        int r107 = r102 % 3;
        if (r107 == 1) goto L12;
        if (r107 != 2) goto L14;
        r105 = r105 + 3;
    L14:
        if (r104.f25525g == false) goto L21;
        if (r102 <= 0) goto L21;
        int r108 = ((r102 - 1) / 57) + 1;
        if (r104.f25526h == true) goto L20;
        r106 = 1;
    L20:
        r105 = r105 + (r108 * r106);
    L21:
        r104.f25511a = new byte[r105];
        r104.a(r100, r101, r102, true);
        if (f25510a == true) goto L29;
        if (r104.f25512b == r105) goto L29;
        throw new AssertionError();
    L29:
        return r104.f25511a;
    L12:
        r105 = r105 + 2;
        goto L14
    L5:
        if ((r102 % 3) <= 0) goto L14;
        r105 = r105 + 4;
        goto L14
    }
}
