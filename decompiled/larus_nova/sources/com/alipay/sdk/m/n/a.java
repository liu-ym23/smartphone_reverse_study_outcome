package com.alipay.sdk.m.n;

import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f25605a = 128;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25606b = 64;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f25607c = 24;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25608d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f25609e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f25610f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25611g = -128;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final char f25612h = '=';

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f25613i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char[] f25614j = null;

    public static boolean b(char r100) {
        if (r100 != '=') goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean c(char r100) {
        if (r100 != ' ') goto L5;
    L12:
        return true;
    L5:
        if (r100 == '\r') goto L12;
        if (r100 == '\n') goto L12;
        if (r100 == '\t') goto L12;
        return false;
    }

    static {
        f25613i = new byte[128];
        f25614j = new char[64];
        int r100 = 0;
        int r101 = 0;
    L3:
        if (r101 >= 128) goto L5;
        f25613i[r101] = -1;
        r101 = r101 + 1;
        goto L3
    L5:
        int r102 = 90;
    L7:
        if (r102 < 65) goto L9;
        f25613i[r102] = (byte) (r102 - 65);
        r102 = r102 - 1;
        goto L7
    L9:
        int r103 = 122;
    L10:
        int r104 = 26;
        if (r103 < 97) goto L13;
        f25613i[r103] = (byte) ((r103 - 97) + 26);
        r103 = r103 - 1;
        goto L10
    L13:
        int r105 = 57;
    L14:
        int r106 = 52;
        if (r105 < 48) goto L17;
        f25613i[r105] = (byte) ((r105 - 48) + 52);
        r105 = r105 - 1;
        goto L14
    L17:
        byte[] r107 = f25613i;
        r107[43] = 62;
        r107[47] = 63;
        int r108 = 0;
    L19:
        if (r108 > 25) goto L21;
        f25614j[r108] = (char) (r108 + 65);
        r108 = r108 + 1;
        goto L19
    L21:
        int r109 = 0;
    L23:
        if (r104 > 51) goto L26;
        f25614j[r104] = (char) (r109 + 97);
        r104 = r104 + 1;
        r109 = r109 + 1;
    L26:
        if (r106 > 61) goto L28;
        f25614j[r106] = (char) (r100 + 48);
        r106 = r106 + 1;
        r100 = r100 + 1;
        goto L26
    L28:
        char[] r110 = f25614j;
        r110[62] = '+';
        r110[63] = '/';
    }

    public a() {
    }

    public static byte[] a(String r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        char[] r111 = r110.toCharArray();
        int r100 = a(r111);
        if ((r100 % 4) == 0) goto L8;
        return null;
    L8:
        int r101 = r100 / 4;
        if (r101 == 0) goto L11;
        byte[] r102 = new byte[r101 * 3];
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L14:
        if (r103 >= (r101 - 1)) goto L26;
        int r106 = r104 + 1;
        char r107 = r111[r104];
        if (a(r107) == false) goto L25;
        int r108 = r106 + 1;
        char r109 = r111[r106];
        if (a(r109) == false) goto L25;
        int r112 = r108 + 1;
        char r113 = r111[r108];
        if (a(r113) == false) goto L25;
        int r114 = r112 + 1;
        char r115 = r111[r112];
        if (a(r115) == false) goto L25;
        byte[] r116 = f25613i;
        byte r117 = r116[r107];
        byte r118 = r116[r109];
        byte r119 = r116[r113];
        byte r120 = r116[r115];
        int r121 = r105 + 1;
        r102[r105] = (byte) ((r117 << 2) | (r118 >> 4));
        int r122 = r121 + 1;
        r102[r121] = (byte) (((r118 & 15) << 4) | ((r119 >> 2) & 15));
        r105 = r122 + 1;
        r102[r122] = (byte) ((r119 << 6) | r120);
        r103 = r103 + 1;
        r104 = r114;
    L25:
        return null;
    L26:
        int r123 = r104 + 1;
        char r124 = r111[r104];
        if (a(r124) == false) goto L61;
        int r125 = r123 + 1;
        char r126 = r111[r123];
        if (a(r126) == false) goto L64;
        byte[] r127 = f25613i;
        byte r128 = r127[r124];
        byte r129 = r127[r126];
        int r130 = r125 + 1;
        char r131 = r111[r125];
        char r132 = r111[r130];
        if (a(r131) == false) goto L39;
        if (a(r132) == false) goto L39;
        byte r133 = r127[r131];
        byte r134 = r127[r132];
        int r135 = r105 + 1;
        r102[r105] = (byte) ((r128 << 2) | (r129 >> 4));
        r102[r135] = (byte) (((r129 & 15) << 4) | ((r133 >> 2) & 15));
        r102[r135 + 1] = (byte) (r134 | (r133 << 6));
        return r102;
    L39:
        if (b(r131) == false) goto L48;
        if (b(r132) == false) goto L48;
        if ((r129 & 15) == 0) goto L45;
        return null;
    L45:
        int r136 = r103 * 3;
        byte[] r137 = new byte[r136 + 1];
        System.arraycopy(r102, 0, r137, 0, r136);
        r137[r105] = (byte) ((r128 << 2) | (r129 >> 4));
        return r137;
    L48:
        if (b(r131) == false) goto L50;
        return null;
    L50:
        if (b(r132) == false) goto L63;
        byte r138 = r127[r131];
        if ((r138 & 3) == 0) goto L54;
        return null;
    L54:
        int r139 = r103 * 3;
        byte[] r140 = new byte[r139 + 2];
        System.arraycopy(r102, 0, r140, 0, r139);
        r140[r105] = (byte) ((r128 << 2) | (r129 >> 4));
        r140[r105 + 1] = (byte) (((r138 >> 2) & 15) | ((r129 & 15) << 4));
        return r140;
    L63:
        return null;
    L64:
        return null;
    L61:
        return null;
    L11:
        return new byte[0];
    }

    public static String a(byte[] r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        int r100 = r110.length * 8;
        if (r100 != 0) goto L9;
        return "";
    L9:
        int r101 = r100 % 24;
        int r102 = r100 / 24;
        if (r101 == 0) goto L12;
        int r103 = r102 + 1;
    L13:
        char[] r104 = new char[r103 * 4];
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L14:
        if (r105 >= r102) goto L29;
        int r108 = r106 + 1;
        byte r109 = r110[r106];
        int r111 = r108 + 1;
        byte r112 = r110[r108];
        int r113 = r111 + 1;
        byte r114 = r110[r111];
        byte r115 = (byte) (r112 & 15);
        byte r116 = (byte) (r109 & 3);
        int r117 = r109 & ByteCompanionObject.MIN_VALUE;
        int r118 = r109 >> 2;
        if (r117 == 0) goto L19;
        r118 = r118 ^ 192;
    L19:
        byte r119 = (byte) r118;
        int r120 = r112 & ByteCompanionObject.MIN_VALUE;
        int r121 = r112 >> 4;
        if (r120 == 0) goto L23;
        r121 = r121 ^ 240;
    L23:
        byte r122 = (byte) r121;
        if ((r114 & ByteCompanionObject.MIN_VALUE) != 0) goto L26;
        int r123 = r114 >> 6;
    L27:
        int r124 = r107 + 1;
        char[] r125 = f25614j;
        r104[r107] = r125[r119];
        int r126 = r124 + 1;
        r104[r124] = r125[(r116 << 4) | r122];
        int r127 = r126 + 1;
        int r128 = r115 << 2;
        r104[r126] = r125[r128 | ((byte) r123)];
        r104[r127] = r125[r114 & 63];
        r105 = r105 + 1;
        r107 = r127 + 1;
        r106 = r113;
        goto L14
    L26:
        r123 = (r114 >> 6) ^ 252;
        goto L27
    L29:
        if (r101 != 8) goto L36;
        byte r129 = r110[r106];
        byte r130 = (byte) (r129 & 3);
        int r131 = r129 & ByteCompanionObject.MIN_VALUE;
        int r132 = r129 >> 2;
        if (r131 == 0) goto L34;
        r132 = r132 ^ 192;
    L34:
        int r133 = r107 + 1;
        char[] r134 = f25614j;
        r104[r107] = r134[(byte) r132];
        int r135 = r133 + 1;
        r104[r133] = r134[r130 << 4];
        r104[r135] = f25612h;
        r104[r135 + 1] = f25612h;
    L47:
        return new String(r104);
    L36:
        if (r101 != 16) goto L47;
        byte r136 = r110[r106];
        byte r137 = r110[r106 + 1];
        byte r138 = (byte) (r137 & 15);
        byte r139 = (byte) (r136 & 3);
        int r140 = r136 & ByteCompanionObject.MIN_VALUE;
        int r141 = r136 >> 2;
        if (r140 == 0) goto L41;
        r141 = r141 ^ 192;
    L41:
        byte r142 = (byte) r141;
        int r143 = r137 & ByteCompanionObject.MIN_VALUE;
        int r144 = r137 >> 4;
        if (r143 == 0) goto L45;
        r144 = r144 ^ 240;
    L45:
        int r145 = r107 + 1;
        char[] r146 = f25614j;
        r104[r107] = r146[r142];
        int r147 = r145 + 1;
        r104[r145] = r146[((byte) r144) | (r139 << 4)];
        r104[r147] = r146[r138 << 2];
        r104[r147 + 1] = f25612h;
        goto L47
    L12:
        r103 = r102;
        goto L13
    }

    public static int a(char[] r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r101 >= r102) goto L11;
        if (c(r100[r101]) == true) goto L10;
        r100[r103] = r100[r101];
        r103 = r103 + 1;
    L10:
        r101 = r101 + 1;
        goto L6
    L11:
        return r103;
    }

    public static boolean a(char r100) {
        if (r100 < 128) goto L5;
    L7:
        return false;
    L5:
        if (f25613i[r100] == (-1)) goto L7;
        return true;
    }
}
