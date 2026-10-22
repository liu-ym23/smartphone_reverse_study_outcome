package com.baidu.bbalbscesium.o;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f30412d = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f30413e = "0123456789ABCDEFGHIJKLMNOPQRSTUV=";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f30415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f30416c;

    public a(String r100, boolean r101, boolean r102) {
        this.f30414a = r100;
        this.f30415b = r101;
        this.f30416c = r102;
    }

    private static int a(int r100) {
        if (r100 != 1) goto L5;
        return 6;
    L5:
        if (r100 != 2) goto L7;
        return 4;
    L7:
        if (r100 == 3) goto L16;
        if (r100 != 4) goto L10;
        return 1;
    L10:
        if (r100 == 5) goto L13;
        return -1;
    L13:
        return 0;
    L16:
        return 3;
    }

    private static int b(int r100) {
        if (r100 != 0) goto L4;
        return 5;
    L4:
        if (r100 != 1) goto L6;
        return 4;
    L6:
        if (r100 == 3) goto L15;
        if (r100 != 4) goto L9;
        return 2;
    L9:
        if (r100 == 6) goto L12;
        return -1;
    L12:
        return 1;
    L15:
        return 3;
    }

    public String a(byte[] r110) {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        int r101 = 0;
    L4:
        if (r101 >= ((r110.length + 4) / 5)) goto L25;
        short[] r102 = new short[5];
        int[] r103 = new int[8];
        int r111 = 0;
        int r112 = 5;
    L6:
        if (r111 >= 5) goto L12;
        int r113 = (r101 * 5) + r111;
        if (r113 >= r110.length) goto L10;
        r102[r111] = (short) (r110[r113] & UByte.MAX_VALUE);
    L11:
        r111 = r111 + 1;
        goto L6
    L10:
        r102[r111] = 0;
        r112 = r112 - 1;
        goto L11
    L12:
        int r114 = a(r112);
        short r115 = r102[0];
        r103[0] = (byte) ((r115 >> 3) & 31);
        short r116 = r102[1];
        r103[1] = (byte) (((r115 & 7) << 2) | ((r116 >> 6) & 3));
        r103[2] = (byte) ((r116 >> 1) & 31);
        short r117 = r102[2];
        r103[3] = (byte) (((r116 & 1) << 4) | ((r117 >> 4) & 15));
        int r118 = (r117 & 15) << 1;
        short r119 = r102[3];
        r103[4] = (byte) (r118 | (1 & (r119 >> 7)));
        r103[5] = (byte) ((r119 >> 2) & 31);
        short r104 = r102[4];
        r103[6] = (byte) (((r104 >> 5) & 7) | ((r119 & 3) << 3));
        r103[7] = (byte) (r104 & 31);
        int r105 = 0;
    L13:
        int r106 = 8 - r114;
        if (r105 >= r106) goto L20;
        char r107 = this.f30414a.charAt(r103[r105]);
        if (this.f30416c == false) goto L18;
        r107 = Character.toLowerCase(r107);
    L18:
        r100.write(r107);
        r105 = r105 + 1;
        goto L13
    L20:
        if (this.f30415b == false) goto L23;
    L21:
        if (r106 >= 8) goto L23;
        r100.write(61);
        r106 = r106 + 1;
    L23:
        r101 = r101 + 1;
        goto L4
    L25:
        return new String(r100.toByteArray());
    }

    public byte[] a(String r210) {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        byte[] r101 = r210.getBytes();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        char r104 = (char) r101[r103];
        if (Character.isWhitespace(r104) == true) goto L7;
        r100.write((byte) Character.toUpperCase(r104));
    L7:
        r103 = r103 + 1;
        goto L3
    L9:
        if (this.f30415b == false) goto L14;
        if ((r100.size() % 8) == 0) goto L16;
        return null;
    L16:
        byte[] r105 = r100.toByteArray();
        r100.reset();
        DataOutputStream r106 = new DataOutputStream(r100);
        int r107 = 0;
    L18:
        if (r107 >= (r105.length / 8)) goto L37;
        short[] r108 = new short[8];
        int[] r110 = new int[5];
        int r111 = 0;
        int r112 = 8;
    L20:
        if (r111 >= 8) goto L28;
        byte r113 = r105[(r107 * 8) + r111];
        if (((char) r113) == '=') goto L28;
        short r114 = (short) this.f30414a.indexOf(r113);
        r108[r111] = r114;
        if (r114 < 0) goto L26;
        r112 = r112 - 1;
        r111 = r111 + 1;
        goto L20
    L26:
        return null;
    L28:
        int r115 = b(r112);
        if (r115 < 0) goto L30;
        int r116 = r108[0] << 3;
        short r117 = r108[1];
        r110[0] = r116 | (r117 >> 2);
        int r118 = ((r117 & 3) << 6) | (r108[2] << 1);
        short r119 = r108[3];
        r110[1] = r118 | (r119 >> 4);
        int r120 = (r119 & 15) << 4;
        short r121 = r108[4];
        r110[2] = r120 | ((r121 >> 1) & 15);
        int r122 = (r121 << 7) | (r108[5] << 2);
        short r123 = r108[6];
        r110[3] = r122 | (r123 >> 3);
        r110[4] = r108[7] | ((r123 & 7) << 5);
        int r109 = 0;
    L32:
        if (r109 >= r115) goto L35;
        r106.writeByte((byte) (r110[r109] & 255));     // Catch: IOException -> L38
        r109 = r109 + 1;
    L35:
        r107 = r107 + 1;
        goto L18
    L30:
        return null;
    L37:
        return r100.toByteArray();
    L14:
        if ((r100.size() % 8) == 0) goto L16;
        r100.write(61);
        goto L14
    }
}
