package com.alibaba.fastjson.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes28.dex */
public class Base64 {
    public static final char[] CA = null;
    public static final int[] IA = null;

    public Base64() {
    }

    static {
        char[] r100 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = r100;
        int[] r101 = new int[256];
        IA = r101;
        Arrays.fill(r101, -1);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        IA[CA[r103]] = r103;
        r103 = r103 + 1;
        goto L3
    L5:
        IA[61] = 0;
    }

    public static byte[] decodeFast(String r110) {
        int r100 = r110.length();
        int r101 = 0;
        if (r100 == 0) goto L5;
        int r102 = r100 - 1;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L11;
        if (IA[r110.charAt(r103) & 255] >= 0) goto L11;
        r103 = r103 + 1;
    L11:
        if (r102 <= 0) goto L16;
        if (IA[r110.charAt(r102) & 255] >= 0) goto L16;
        r102 = r102 - 1;
    L16:
        if (r110.charAt(r102) == '=') goto L18;
        int r104 = 0;
    L22:
        int r105 = (r102 - r103) + 1;
        if (r100 > 76) goto L25;
        int r106 = 0;
    L30:
        int r107 = (((r105 - r106) * 6) >> 3) - r104;
        byte[] r108 = new byte[r107];
        int r109 = (r107 / 3) * 3;
        int r111 = 0;
        int r112 = 0;
    L31:
        if (r111 >= r109) goto L39;
        int[] r113 = IA;
        int r114 = r103 + 1;
        int r115 = r114 + 1;
        int r116 = (r113[r110.charAt(r103)] << 18) | (r113[r110.charAt(r114)] << 12);
        int r117 = r115 + 1;
        int r118 = r116 | (r113[r110.charAt(r115)] << 6);
        int r119 = r117 + 1;
        int r120 = r118 | r113[r110.charAt(r117)];
        int r121 = r111 + 1;
        r108[r111] = (byte) (r120 >> 16);
        int r122 = r121 + 1;
        r108[r121] = (byte) (r120 >> 8);
        int r123 = r122 + 1;
        r108[r122] = (byte) r120;
        if (r106 <= 0) goto L37;
        r112 = r112 + 1;
        if (r112 != 19) goto L37;
        r103 = r119 + 2;
        r112 = 0;
    L38:
        r111 = r123;
    L37:
        r103 = r119;
        goto L38
    L39:
        if (r111 >= r107) goto L47;
        int r124 = 0;
    L42:
        if (r103 > (r102 - r104)) goto L44;
        r101 = r101 | (IA[r110.charAt(r103)] << (18 - (r124 * 6)));
        r124 = r124 + 1;
        r103 = r103 + 1;
        goto L42
    L44:
        int r125 = 16;
    L45:
        if (r111 >= r107) goto L47;
        r108[r111] = (byte) (r101 >> r125);
        r125 = r125 - 8;
        r111 = r111 + 1;
    L47:
        return r108;
    L25:
        if (r110.charAt(76) != '\r') goto L27;
        int r126 = r105 / 78;
    L28:
        r106 = r126 << 1;
        goto L30
    L27:
        r126 = 0;
        goto L28
    L18:
        if (r110.charAt(r102 - 1) != '=') goto L20;
        r104 = 2;
        goto L22
    L20:
        r104 = 1;
        goto L22
    L5:
        return new byte[0];
    }

    public static byte[] decodeFast(String r110, int r111, int r112) {
        int r100 = 0;
        if (r112 == 0) goto L5;
        int r101 = (r111 + r112) - 1;
    L7:
        if (r111 >= r101) goto L11;
        if (IA[r110.charAt(r111)] >= 0) goto L11;
        r111 = r111 + 1;
    L11:
        if (r101 <= 0) goto L16;
        if (IA[r110.charAt(r101)] >= 0) goto L16;
        r101 = r101 - 1;
    L16:
        if (r110.charAt(r101) == '=') goto L18;
        int r102 = 0;
    L22:
        int r103 = (r101 - r111) + 1;
        if (r112 > 76) goto L25;
        int r113 = 0;
    L30:
        int r104 = (((r103 - r113) * 6) >> 3) - r102;
        byte[] r105 = new byte[r104];
        int r106 = (r104 / 3) * 3;
        int r107 = 0;
        int r108 = 0;
    L31:
        if (r107 >= r106) goto L39;
        int[] r109 = IA;
        int r114 = r111 + 1;
        int r115 = r114 + 1;
        int r116 = (r109[r110.charAt(r111)] << 18) | (r109[r110.charAt(r114)] << 12);
        int r117 = r115 + 1;
        int r118 = r116 | (r109[r110.charAt(r115)] << 6);
        int r119 = r117 + 1;
        int r120 = r118 | r109[r110.charAt(r117)];
        int r121 = r107 + 1;
        r105[r107] = (byte) (r120 >> 16);
        int r122 = r121 + 1;
        r105[r121] = (byte) (r120 >> 8);
        int r123 = r122 + 1;
        r105[r122] = (byte) r120;
        if (r113 <= 0) goto L37;
        r108 = r108 + 1;
        if (r108 != 19) goto L37;
        r111 = r119 + 2;
        r108 = 0;
    L38:
        r107 = r123;
    L37:
        r111 = r119;
        goto L38
    L39:
        if (r107 >= r104) goto L47;
        int r124 = 0;
    L42:
        if (r111 > (r101 - r102)) goto L44;
        r100 = r100 | (IA[r110.charAt(r111)] << (18 - (r124 * 6)));
        r124 = r124 + 1;
        r111 = r111 + 1;
        goto L42
    L44:
        int r125 = 16;
    L45:
        if (r107 >= r104) goto L47;
        r105[r107] = (byte) (r100 >> r125);
        r125 = r125 - 8;
        r107 = r107 + 1;
    L47:
        return r105;
    L25:
        if (r110.charAt(76) != '\r') goto L27;
        int r126 = r103 / 78;
    L28:
        r113 = r126 << 1;
        goto L30
    L27:
        r126 = 0;
        goto L28
    L18:
        if (r110.charAt(r101 - 1) != '=') goto L20;
        r102 = 2;
        goto L22
    L20:
        r102 = 1;
        goto L22
    L5:
        return new byte[0];
    }

    public static byte[] decodeFast(char[] r110, int r111, int r112) {
        int r100 = 0;
        if (r112 == 0) goto L5;
        int r101 = (r111 + r112) - 1;
    L7:
        if (r111 >= r101) goto L11;
        if (IA[r110[r111]] >= 0) goto L11;
        r111 = r111 + 1;
    L11:
        if (r101 <= 0) goto L16;
        if (IA[r110[r101]] >= 0) goto L16;
        r101 = r101 - 1;
    L16:
        if (r110[r101] == '=') goto L18;
        int r102 = 0;
    L22:
        int r103 = (r101 - r111) + 1;
        if (r112 > 76) goto L25;
        int r113 = 0;
    L30:
        int r104 = (((r103 - r113) * 6) >> 3) - r102;
        byte[] r105 = new byte[r104];
        int r106 = (r104 / 3) * 3;
        int r107 = 0;
        int r108 = 0;
    L31:
        if (r107 >= r106) goto L39;
        int[] r109 = IA;
        int r114 = r111 + 1;
        int r115 = r114 + 1;
        int r116 = (r109[r110[r111]] << 18) | (r109[r110[r114]] << 12);
        int r117 = r115 + 1;
        int r118 = r116 | (r109[r110[r115]] << 6);
        int r119 = r117 + 1;
        int r120 = r118 | r109[r110[r117]];
        int r121 = r107 + 1;
        r105[r107] = (byte) (r120 >> 16);
        int r122 = r121 + 1;
        r105[r121] = (byte) (r120 >> 8);
        int r123 = r122 + 1;
        r105[r122] = (byte) r120;
        if (r113 <= 0) goto L37;
        r108 = r108 + 1;
        if (r108 != 19) goto L37;
        r111 = r119 + 2;
        r108 = 0;
    L38:
        r107 = r123;
    L37:
        r111 = r119;
        goto L38
    L39:
        if (r107 >= r104) goto L47;
        int r124 = 0;
    L42:
        if (r111 > (r101 - r102)) goto L44;
        r100 = r100 | (IA[r110[r111]] << (18 - (r124 * 6)));
        r124 = r124 + 1;
        r111 = r111 + 1;
        goto L42
    L44:
        int r125 = 16;
    L45:
        if (r107 >= r104) goto L47;
        r105[r107] = (byte) (r100 >> r125);
        r125 = r125 - 8;
        r107 = r107 + 1;
    L47:
        return r105;
    L25:
        if (r110[76] != '\r') goto L27;
        int r126 = r103 / 78;
    L28:
        r113 = r126 << 1;
        goto L30
    L27:
        r126 = 0;
        goto L28
    L18:
        if (r110[r101 - 1] != '=') goto L20;
        r102 = 2;
        goto L22
    L20:
        r102 = 1;
        goto L22
    L5:
        return new byte[0];
    }
}
