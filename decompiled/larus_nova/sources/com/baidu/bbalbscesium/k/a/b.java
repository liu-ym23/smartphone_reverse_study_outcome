package com.baidu.bbalbscesium.k.a;

import com.ss.ttm.player.MediaPlayer;
import java.lang.reflect.Array;
import java.security.InvalidKeyException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class b implements a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int[] f30298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int[] f30299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte[] f30300j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final byte[] f30301k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f30302l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f30303m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f30304n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f30305o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f30306p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f30307q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f30308r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int[] f30309s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int[] f30310t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int[] f30311u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int[] f30312v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int[] f30313w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final byte[] f30314x = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f30315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object[] f30317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f30318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f30319g;

    static {
        int[] r100 = new int[256];
        f30298h = r100;
        f30299i = new int[256];
        f30300j = new byte[256];
        f30301k = new byte[256];
        f30302l = new int[256];
        f30303m = new int[256];
        f30304n = new int[256];
        f30305o = new int[256];
        f30306p = new int[256];
        f30307q = new int[256];
        f30308r = new int[256];
        f30309s = new int[256];
        f30310t = new int[256];
        f30311u = new int[256];
        f30312v = new int[256];
        f30313w = new int[256];
        f30314x = new byte[30];
        int r101 = 1;
        r100[0] = 1;
        int r102 = 1;
    L3:
        if (r102 >= 256) goto L8;
        int[] r103 = f30298h;
        int r104 = r103[r102 - 1];
        int r105 = r104 ^ (r104 << 1);
        if ((r105 & 256) == 0) goto L7;
        r105 = r105 ^ MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS;
    L7:
        r103[r102] = r105;
        r102 = r102 + 1;
        goto L3
    L8:
        int r106 = 1;
    L10:
        if (r106 >= 255) goto L12;
        f30299i[f30298h[r106]] = r106;
        r106 = r106 + 1;
        goto L10
    L12:
        byte[][] r107 = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] r108 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] r110 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{256, 8});
        r110[1][7] = 1;
        int r111 = 2;
    L13:
        if (r111 >= 256) goto L18;
        int r112 = f30298h[255 - f30299i[r111]];
        int r113 = 0;
    L15:
        if (r113 >= 8) goto L17;
        r110[r111][r113] = (byte) ((r112 >>> (7 - r113)) & 1);
        r113 = r113 + 1;
        goto L15
    L17:
        r111 = r111 + 1;
        goto L13
    L18:
        byte[][] r109 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{256, 8});
        int r114 = 0;
    L19:
        if (r114 >= 256) goto L27;
        int r115 = 0;
    L21:
        if (r115 >= 8) goto L26;
        r109[r114][r115] = r108[r115];
        int r116 = 0;
    L23:
        if (r116 >= 8) goto L25;
        byte[] r117 = r109[r114];
        r117[r115] = (byte) (r117[r115] ^ (r107[r115][r116] * r110[r114][r116]));
        r116 = r116 + 1;
        goto L23
    L25:
        r115 = r115 + 1;
        goto L21
    L26:
        r114 = r114 + 1;
        goto L19
    L27:
        int r118 = 0;
    L28:
        if (r118 >= 256) goto L33;
        f30300j[r118] = (byte) (r109[r118][0] << 7);
        int r119 = 1;
    L30:
        if (r119 >= 8) goto L32;
        byte[] r120 = f30300j;
        r120[r118] = (byte) (r120[r118] ^ (r109[r118][r119] << (7 - r119)));
        r119 = r119 + 1;
        goto L30
    L32:
        f30301k[f30300j[r118] & UByte.MAX_VALUE] = (byte) r118;
        r118 = r118 + 1;
        goto L28
    L33:
        byte[][] r121 = {new byte[]{2, 1, 1, 3}, new byte[]{3, 2, 1, 1}, new byte[]{1, 3, 2, 1}, new byte[]{1, 1, 3, 2}};
        byte[][] r122 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{4, 8});
        int r123 = 0;
    L34:
        if (r123 >= 4) goto L39;
        int r124 = 0;
    L36:
        if (r124 >= 4) goto L38;
        r122[r123][r124] = r121[r123][r124];
        r124 = r124 + 1;
        goto L36
    L38:
        r122[r123][r123 + 4] = 1;
        r123 = r123 + 1;
        goto L34
    L39:
        byte[][] r125 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{4, 4});
        int r126 = 0;
    L40:
        if (r126 >= 4) goto L70;
        byte r127 = r122[r126][r126];
        if (r127 != 0) goto L55;
        int r128 = r126 + 1;
    L45:
        if (r122[r128][r126] != 0) goto L48;
        if (r128 >= 4) goto L48;
        r128 = r128 + 1;
    L48:
        if (r128 == 4) goto L54;
        int r129 = 0;
    L50:
        if (r129 >= 8) goto L52;
        byte[] r130 = r122[r126];
        byte r131 = r130[r129];
        byte[] r132 = r122[r128];
        r130[r129] = r132[r129];
        r132[r129] = r131;
        r129 = r129 + 1;
        goto L50
    L52:
        r127 = r122[r126][r126];
        goto L55
    L54:
        throw new RuntimeException("G matrix is not invertible");
    L55:
        int r133 = 0;
    L56:
        if (r133 >= 8) goto L61;
        byte[] r134 = r122[r126];
        byte r135 = r134[r133];
        if (r135 == 0) goto L60;
        int[] r136 = f30298h;
        int[] r137 = f30299i;
        r134[r133] = (byte) r136[((r137[r135 & UByte.MAX_VALUE] + 255) - r137[r127 & UByte.MAX_VALUE]) % 255];
    L60:
        r133 = r133 + 1;
        goto L56
    L61:
        int r138 = 0;
    L62:
        if (r138 >= 4) goto L69;
        if (r126 == r138) goto L68;
        int r139 = r126 + 1;
    L65:
        if (r139 >= 8) goto L67;
        byte[] r140 = r122[r138];
        r140[r139] = (byte) (r140[r139] ^ a(r122[r126][r139], r140[r126]));
        r139 = r139 + 1;
        goto L65
    L67:
        r122[r138][r126] = 0;
    L68:
        r138 = r138 + 1;
        goto L62
    L69:
        r126 = r126 + 1;
        goto L40
    L70:
        int r141 = 0;
    L71:
        if (r141 >= 4) goto L76;
        int r142 = 0;
    L73:
        if (r142 >= 4) goto L75;
        r125[r141][r142] = r122[r141][r142 + 4];
        r142 = r142 + 1;
        goto L73
    L75:
        r141 = r141 + 1;
        goto L71
    L76:
        int r143 = 0;
    L77:
        if (r143 >= 256) goto L79;
        byte r144 = f30300j[r143];
        f30302l[r143] = a(r144, r121[0]);
        f30303m[r143] = a(r144, r121[1]);
        f30304n[r143] = a(r144, r121[2]);
        f30305o[r143] = a(r144, r121[3]);
        byte r145 = f30301k[r143];
        f30306p[r143] = a(r145, r125[0]);
        f30307q[r143] = a(r145, r125[1]);
        f30308r[r143] = a(r145, r125[2]);
        f30309s[r143] = a(r145, r125[3]);
        f30310t[r143] = a(r143, r125[0]);
        f30311u[r143] = a(r143, r125[1]);
        f30312v[r143] = a(r143, r125[2]);
        f30313w[r143] = a(r143, r125[3]);
        r143 = r143 + 1;
        goto L77
    L79:
        f30314x[0] = 1;
        int r146 = 1;
    L80:
        if (r101 >= 30) goto L82;
        r146 = a(2, r146);
        f30314x[r101] = (byte) r146;
        r101 = r101 + 1;
        goto L80
    L82:
        f30299i = null;
        f30298h = null;
    }

    public b() {
        this.f30315c = false;
        this.f30316d = false;
        this.f30317e = null;
        this.f30318f = null;
        this.f30319g = 0;
    }

    private static int a(int r100) {
        return (r100 >> 2) + 6;
    }

    private static final int a(int r100, int r101) {
        if (r100 == 0) goto L5;
        if (r101 == 0) goto L5;
        int[] r102 = f30298h;
        int[] r103 = f30299i;
        return r102[(r103[r100 & 255] + r103[r101 & 255]) % 255];
    L5:
        return 0;
    }

    private static final int a(int r100, byte[] r101) {
        int r102 = 0;
        if (r100 != 0) goto L5;
        return 0;
    L5:
        int[] r103 = f30299i;
        int r104 = r103[r100 & 255];
        byte r105 = r101[0];
        if (r105 == 0) goto L8;
        int r106 = f30298h[(r103[r105 & UByte.MAX_VALUE] + r104) % 255] & 255;
    L9:
        byte r107 = r101[1];
        if (r107 == 0) goto L12;
        int r108 = f30298h[(r103[r107 & UByte.MAX_VALUE] + r104) % 255] & 255;
    L13:
        byte r109 = r101[2];
        if (r109 == 0) goto L16;
        int r110 = f30298h[(r103[r109 & UByte.MAX_VALUE] + r104) % 255] & 255;
    L17:
        byte r111 = r101[3];
        if (r111 == 0) goto L21;
        r102 = f30298h[(r104 + r103[r111 & UByte.MAX_VALUE]) % 255] & 255;
    L21:
        return (((r106 << 24) | (r108 << 16)) | (r110 << 8)) | r102;
    L16:
        r110 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    private void a(boolean r110) {
        int[][] r100 = (int[][]) this.f30317e[r110 ? 1 : 0];
        int r101 = r100.length;
        this.f30318f = new int[r101 * 4];
        boolean r102 = false;
        int r103 = 0;
    L4:
        if (r103 >= r101) goto L10;
        int r104 = 0;
    L6:
        if (r104 >= 4) goto L8;
        this.f30318f[(r103 * 4) + r104] = r100[r103][r104];
        r104 = r104 + 1;
        goto L6
    L8:
        r103 = r103 + 1;
        goto L4
    L10:
        if (r110 == false) goto L16;
        int[] r111 = this.f30318f;
        int r105 = r111[r111.length - 4];
        int r106 = r111[r111.length - 3];
        int r107 = r111[r111.length - 2];
        int r108 = r111[r111.length - 1];
        int r112 = r111.length - 1;
    L12:
        if (r112 <= 3) goto L14;
        int[] r113 = this.f30318f;
        r113[r112] = r113[r112 - 4];
        r112 = r112 - 1;
        goto L12
    L14:
        int[] r114 = this.f30318f;
        r114[0] = r105;
        r114[1] = r106;
        r114[2] = r107;
        r114[3] = r108;
    L16:
        if (r101 < 13) goto L18;
        boolean r115 = true;
    L19:
        this.f30315c = r115;
        if (r101 != 15) goto L22;
        r102 = true;
    L22:
        this.f30316d = r102;
        this.f30319g = (r101 - 1) * 4;
        return;
    L18:
        r115 = false;
        goto L19
    }

    private static Object[] a(byte[] r110) throws InvalidKeyException {
        if (r110 == null) goto L42;
        if (b(r110.length) == false) goto L40;
        int r100 = a(r110.length);
        int r101 = r100 + 1;
        int r102 = r101 * 4;
        char r103 = 0;
        Class r104 = Integer.TYPE;
        int[][] r105 = (int[][]) Array.newInstance(r104, new int[]{r101, 4});
        int[][] r106 = (int[][]) Array.newInstance(r104, new int[]{r101, 4});
        int r107 = r110.length / 4;
        int[] r111 = new int[r107];
        int r112 = 0;
        int r113 = 0;
    L8:
        if (r112 >= r107) goto L10;
        r111[r112] = (((r110[r113 + 2] & UByte.MAX_VALUE) << 8) | ((r110[r113] << 24) | ((r110[r113 + 1] & UByte.MAX_VALUE) << 16))) | (r110[r113 + 3] & UByte.MAX_VALUE);
        r112 = r112 + 1;
        r113 = r113 + 4;
        goto L8
    L10:
        int r108 = 0;
        int r114 = 0;
    L11:
        if (r108 >= r107) goto L14;
        if (r114 >= r102) goto L14;
        int r115 = r114 / 4;
        int r116 = r114 % 4;
        r105[r115][r116] = r111[r108];
        r106[r100 - r115][r116] = r111[r108];
        r108 = r108 + 1;
        r114 = r114 + 1;
    L14:
        int r109 = 0;
    L15:
        if (r114 >= r102) goto L31;
        int r117 = r111[r107 - 1];
        int r118 = r111[r103];
        byte[] r119 = f30300j;
        int r120 = (((r119[(r117 >>> 16) & 255] << 24) ^ ((r119[(r117 >>> 8) & 255] & UByte.MAX_VALUE) << 16)) ^ ((r119[r117 & 255] & UByte.MAX_VALUE) << 8)) ^ (r119[r117 >>> 24] & UByte.MAX_VALUE);
        int r121 = r109 + 1;
        r111[r103] = ((f30314x[r109] << 24) ^ r120) ^ r118;
        int r122 = 1;
        int r123 = 0;
        if (r107 == 8) goto L20;
    L18:
        if (r122 >= r107) goto L26;
        r111[r122] = r111[r122] ^ r111[r123];
        r122 = r122 + 1;
        r123 = r123 + 1;
    L26:
        int r124 = 0;
    L27:
        if (r124 >= r107) goto L30;
        if (r114 >= r102) goto L30;
        int r125 = r114 / 4;
        int r126 = r114 % 4;
        r105[r125][r126] = r111[r124];
        r106[r100 - r125][r126] = r111[r124];
        r124 = r124 + 1;
        r114 = r114 + 1;
    L30:
        r109 = r121;
        r103 = 0;
    L20:
        int r127 = r107 / 2;
        if (r122 >= r127) goto L23;
        r111[r122] = r111[r122] ^ r111[r123];
        r122 = r122 + 1;
        r123 = r123 + 1;
        goto L20
    L23:
        int r128 = r111[r127 - 1];
        int r129 = r111[r127];
        byte[] r130 = f30300j;
        r111[r127] = ((r130[r128 >>> 24] << 24) ^ ((((r130[(r128 >>> 8) & 255] & UByte.MAX_VALUE) << 8) ^ (r130[r128 & 255] & UByte.MAX_VALUE)) ^ ((r130[(r128 >>> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ r129;
        int r131 = r127 + 1;
    L24:
        if (r131 >= r107) goto L26;
        r111[r131] = r111[r131] ^ r111[r127];
        r131 = r131 + 1;
        r127 = r127 + 1;
        goto L24
    L31:
        int r132 = 1;
    L32:
        if (r132 >= r100) goto L38;
        int r133 = 0;
    L34:
        if (r133 >= 4) goto L36;
        int[] r134 = r106[r132];
        int r135 = r134[r133];
        r134[r133] = f30313w[r135 & 255] ^ ((f30310t[(r135 >>> 24) & 255] ^ f30311u[(r135 >>> 16) & 255]) ^ f30312v[(r135 >>> 8) & 255]);
        r133 = r133 + 1;
        goto L34
    L36:
        r132 = r132 + 1;
        goto L32
    L38:
        return new Object[]{r105, r106};
    L40:
        throw new InvalidKeyException("Invalid AES key length: " + r110.length + " bytes");
    L42:
        throw new InvalidKeyException("Empty key");
    }

    public static final boolean b(int r100) {
        int r101 = 0;
    L3:
        int[] r102 = a.f30297b;
        if (r101 >= r102.length) goto L10;
        if (r100 == r102[r101]) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    public int a() {
        return 16;
    }

    public void a(boolean r100, String r101, byte[] r102) throws InvalidKeyException {
        if (b(r102.length) == false) goto L7;
        this.f30317e = a(r102);
        a(r100);
        return;
    L7:
        throw new InvalidKeyException("Invalid AES key length: " + r102.length + " bytes");
    }

    public void a(byte[] r110, int r111, byte[] r112, int r210) {
        int r100 = r111 + 1;
        int r101 = r110[r111] << 24;
        int r102 = r100 + 1;
        int r103 = ((r110[r100] & UByte.MAX_VALUE) << 16) | r101;
        int r104 = r102 + 1;
        int r105 = r103 | ((r110[r102] & UByte.MAX_VALUE) << 8);
        int r106 = r104 + 1;
        int r107 = r105 | (r110[r104] & UByte.MAX_VALUE);
        int[] r108 = this.f30318f;
        int r109 = r107 ^ r108[4];
        int r113 = r106 + 1;
        int r114 = r113 + 1;
        int r115 = (r110[r106] << 24) | ((r110[r113] & UByte.MAX_VALUE) << 16);
        int r116 = r114 + 1;
        int r117 = r115 | ((r110[r114] & UByte.MAX_VALUE) << 8);
        int r118 = r116 + 1;
        int r119 = (r117 | (r110[r116] & UByte.MAX_VALUE)) ^ r108[5];
        int r120 = r118 + 1;
        int r121 = r110[r118] << 24;
        int r122 = r120 + 1;
        int r123 = ((r110[r120] & UByte.MAX_VALUE) << 16) | r121;
        int r124 = r122 + 1;
        int r125 = r123 | ((r110[r122] & UByte.MAX_VALUE) << 8);
        int r126 = r124 + 1;
        int r127 = (r125 | (r110[r124] & UByte.MAX_VALUE)) ^ r108[6];
        int r128 = r126 + 1;
        int r129 = r110[r126] << 24;
        int r130 = r128 + 1;
        int r131 = ((r110[r128] & UByte.MAX_VALUE) << 16) | r129;
        int r132 = r130 + 1;
        int r133 = ((r131 | ((r110[r130] & UByte.MAX_VALUE) << 8)) | (r110[r132] & UByte.MAX_VALUE)) ^ r108[7];
        if (this.f30315c == false) goto L8;
        int[] r134 = f30306p;
        int r135 = r134[r109 >>> 24];
        int[] r136 = f30307q;
        int r137 = r135 ^ r136[(r133 >>> 16) & 255];
        int[] r138 = f30308r;
        int r139 = r137 ^ r138[(r127 >>> 8) & 255];
        int[] r140 = f30309s;
        int r141 = (r139 ^ r140[r119 & 255]) ^ r108[8];
        int r142 = (((r134[r119 >>> 24] ^ r136[(r109 >>> 16) & 255]) ^ r138[(r133 >>> 8) & 255]) ^ r140[r127 & 255]) ^ r108[9];
        int r143 = r134[r127 >>> 24];
        int r144 = (((r136[(r119 >>> 16) & 255] ^ r143) ^ r138[(r109 >>> 8) & 255]) ^ r140[r133 & 255]) ^ r108[10];
        int r145 = r134[r133 >>> 24];
        int r146 = r136[(r127 >>> 16) & 255] ^ r145;
        int r147 = r138[(r119 >>> 8) & 255] ^ r146;
        int r148 = (r140[r109 & 255] ^ r147) ^ r108[11];
        int r149 = (((r134[r141 >>> 24] ^ r136[(r148 >>> 16) & 255]) ^ r138[(r144 >>> 8) & 255]) ^ r140[r142 & 255]) ^ r108[12];
        int r150 = (((r134[r142 >>> 24] ^ r136[(r141 >>> 16) & 255]) ^ r138[(r148 >>> 8) & 255]) ^ r140[r144 & 255]) ^ r108[13];
        int r151 = (((r134[r144 >>> 24] ^ r136[(r142 >>> 16) & 255]) ^ r138[(r141 >>> 8) & 255]) ^ r140[r148 & 255]) ^ r108[14];
        int r152 = (((r134[r148 >>> 24] ^ r136[(r144 >>> 16) & 255]) ^ r138[(r142 >>> 8) & 255]) ^ r140[r141 & 255]) ^ r108[15];
        if (this.f30316d == false) goto L7;
        int r153 = (((r134[r149 >>> 24] ^ r136[(r152 >>> 16) & 255]) ^ r138[(r151 >>> 8) & 255]) ^ r140[r150 & 255]) ^ r108[16];
        int r154 = (((r134[r150 >>> 24] ^ r136[(r149 >>> 16) & 255]) ^ r138[(r152 >>> 8) & 255]) ^ r140[r151 & 255]) ^ r108[17];
        int r155 = (((r134[r151 >>> 24] ^ r136[(r150 >>> 16) & 255]) ^ r138[(r149 >>> 8) & 255]) ^ r140[r152 & 255]) ^ r108[18];
        int r156 = (((r134[r152 >>> 24] ^ r136[(r151 >>> 16) & 255]) ^ r138[(r150 >>> 8) & 255]) ^ r140[r149 & 255]) ^ r108[19];
        r149 = (((r134[r153 >>> 24] ^ r136[(r156 >>> 16) & 255]) ^ r138[(r155 >>> 8) & 255]) ^ r140[r154 & 255]) ^ r108[20];
        r150 = (((r134[r154 >>> 24] ^ r136[(r153 >>> 16) & 255]) ^ r138[(r156 >>> 8) & 255]) ^ r140[r155 & 255]) ^ r108[21];
        r151 = (((r134[r155 >>> 24] ^ r136[(r154 >>> 16) & 255]) ^ r138[(r153 >>> 8) & 255]) ^ r140[r156 & 255]) ^ r108[22];
        int r157 = (((r134[r156 >>> 24] ^ r136[(r155 >>> 16) & 255]) ^ r138[(r154 >>> 8) & 255]) ^ r140[r153 & 255]) ^ r108[23];
        int r158 = 24;
    L9:
        int[] r159 = f30306p;
        int r160 = r159[r149 >>> 24];
        int[] r161 = f30307q;
        int r162 = r160 ^ r161[(r157 >>> 16) & 255];
        int[] r163 = f30308r;
        int r164 = r162 ^ r163[(r151 >>> 8) & 255];
        int[] r165 = f30309s;
        int r166 = r164 ^ r165[r150 & 255];
        int r167 = r158 + 1;
        int r168 = r108[r158] ^ r166;
        int r169 = ((r159[r150 >>> 24] ^ r161[(r149 >>> 16) & 255]) ^ r163[(r157 >>> 8) & 255]) ^ r165[r151 & 255];
        int r170 = r167 + 1;
        int r171 = r169 ^ r108[r167];
        int r172 = r159[r151 >>> 24];
        int r173 = ((r161[(r150 >>> 16) & 255] ^ r172) ^ r163[(r149 >>> 8) & 255]) ^ r165[r157 & 255];
        int r174 = r170 + 1;
        int r175 = r173 ^ r108[r170];
        int r176 = (r159[r157 >>> 24] ^ r161[(r151 >>> 16) & 255]) ^ r163[(r150 >>> 8) & 255];
        int r177 = r165[r149 & 255] ^ r176;
        int r178 = r174 + 1;
        int r179 = r177 ^ r108[r174];
        int r180 = ((r159[r168 >>> 24] ^ r161[(r179 >>> 16) & 255]) ^ r163[(r175 >>> 8) & 255]) ^ r165[r171 & 255];
        int r181 = r178 + 1;
        int r182 = r108[r178] ^ r180;
        int r183 = ((r159[r171 >>> 24] ^ r161[(r168 >>> 16) & 255]) ^ r163[(r179 >>> 8) & 255]) ^ r165[r175 & 255];
        int r184 = r181 + 1;
        int r185 = r183 ^ r108[r181];
        int r186 = ((r159[r175 >>> 24] ^ r161[(r171 >>> 16) & 255]) ^ r163[(r168 >>> 8) & 255]) ^ r165[r179 & 255];
        int r187 = r184 + 1;
        int r188 = r186 ^ r108[r184];
        int r189 = (r159[r179 >>> 24] ^ r161[(r175 >>> 16) & 255]) ^ r163[(r171 >>> 8) & 255];
        int r190 = r165[r168 & 255] ^ r189;
        int r191 = r187 + 1;
        int r192 = r190 ^ r108[r187];
        int r193 = ((r159[r182 >>> 24] ^ r161[(r192 >>> 16) & 255]) ^ r163[(r188 >>> 8) & 255]) ^ r165[r185 & 255];
        int r194 = r191 + 1;
        int r195 = r108[r191] ^ r193;
        int r196 = ((r159[r185 >>> 24] ^ r161[(r182 >>> 16) & 255]) ^ r163[(r192 >>> 8) & 255]) ^ r165[r188 & 255];
        int r197 = r194 + 1;
        int r198 = r196 ^ r108[r194];
        int r199 = ((r159[r188 >>> 24] ^ r161[(r185 >>> 16) & 255]) ^ r163[(r182 >>> 8) & 255]) ^ r165[r192 & 255];
        int r1100 = r197 + 1;
        int r1101 = r199 ^ r108[r197];
        int r200 = ((r159[r192 >>> 24] ^ r161[(r188 >>> 16) & 255]) ^ r163[(r185 >>> 8) & 255]) ^ r165[r182 & 255];
        int r201 = r1100 + 1;
        int r202 = r200 ^ r108[r1100];
        int r203 = ((r159[r195 >>> 24] ^ r161[(r202 >>> 16) & 255]) ^ r163[(r1101 >>> 8) & 255]) ^ r165[r198 & 255];
        int r204 = r201 + 1;
        int r205 = r108[r201] ^ r203;
        int r206 = ((r159[r198 >>> 24] ^ r161[(r195 >>> 16) & 255]) ^ r163[(r202 >>> 8) & 255]) ^ r165[r1101 & 255];
        int r1102 = r204 + 1;
        int r207 = r206 ^ r108[r204];
        int r208 = ((r159[r1101 >>> 24] ^ r161[(r198 >>> 16) & 255]) ^ r163[(r195 >>> 8) & 255]) ^ r165[r202 & 255];
        int r1103 = r1102 + 1;
        int r209 = r208 ^ r108[r1102];
        int r211 = ((r159[r202 >>> 24] ^ r161[(r1101 >>> 16) & 255]) ^ r163[(r198 >>> 8) & 255]) ^ r165[r195 & 255];
        int r212 = r1103 + 1;
        int r213 = r211 ^ r108[r1103];
        int r214 = ((r159[r205 >>> 24] ^ r161[(r213 >>> 16) & 255]) ^ r163[(r209 >>> 8) & 255]) ^ r165[r207 & 255];
        int r1104 = r212 + 1;
        int r215 = r108[r212] ^ r214;
        int r216 = ((r159[r207 >>> 24] ^ r161[(r205 >>> 16) & 255]) ^ r163[(r213 >>> 8) & 255]) ^ r165[r209 & 255];
        int r1105 = r1104 + 1;
        int r217 = r216 ^ r108[r1104];
        int r1106 = ((r159[r209 >>> 24] ^ r161[(r207 >>> 16) & 255]) ^ r163[(r205 >>> 8) & 255]) ^ r165[r213 & 255];
        int r1107 = r1105 + 1;
        int r1108 = r1106 ^ r108[r1105];
        int r218 = ((r159[r213 >>> 24] ^ r161[(r209 >>> 16) & 255]) ^ r163[(r207 >>> 8) & 255]) ^ r165[r205 & 255];
        int r219 = r1107 + 1;
        int r220 = r218 ^ r108[r1107];
        int r221 = ((r159[r215 >>> 24] ^ r161[(r220 >>> 16) & 255]) ^ r163[(r1108 >>> 8) & 255]) ^ r165[r217 & 255];
        int r222 = r219 + 1;
        int r223 = r108[r219] ^ r221;
        int r224 = ((r159[r217 >>> 24] ^ r161[(r215 >>> 16) & 255]) ^ r163[(r220 >>> 8) & 255]) ^ r165[r1108 & 255];
        int r1109 = r222 + 1;
        int r225 = r224 ^ r108[r222];
        int r226 = ((r159[r1108 >>> 24] ^ r161[(r217 >>> 16) & 255]) ^ r163[(r215 >>> 8) & 255]) ^ r165[r220 & 255];
        int r1110 = r1109 + 1;
        int r227 = r226 ^ r108[r1109];
        int r228 = ((r159[r220 >>> 24] ^ r161[(r1108 >>> 16) & 255]) ^ r163[(r217 >>> 8) & 255]) ^ r165[r215 & 255];
        int r229 = r1110 + 1;
        int r230 = r228 ^ r108[r1110];
        int r231 = ((r159[r223 >>> 24] ^ r161[(r230 >>> 16) & 255]) ^ r163[(r227 >>> 8) & 255]) ^ r165[r225 & 255];
        int r1111 = r229 + 1;
        int r232 = r108[r229] ^ r231;
        int r233 = ((r159[r225 >>> 24] ^ r161[(r223 >>> 16) & 255]) ^ r163[(r230 >>> 8) & 255]) ^ r165[r227 & 255];
        int r1112 = r1111 + 1;
        int r234 = r233 ^ r108[r1111];
        int r1113 = ((r159[r227 >>> 24] ^ r161[(r225 >>> 16) & 255]) ^ r163[(r223 >>> 8) & 255]) ^ r165[r230 & 255];
        int r1114 = r1112 + 1;
        int r1115 = r1113 ^ r108[r1112];
        int r235 = ((r159[r230 >>> 24] ^ r161[(r227 >>> 16) & 255]) ^ r163[(r225 >>> 8) & 255]) ^ r165[r223 & 255];
        int r236 = r1114 + 1;
        int r237 = r235 ^ r108[r1114];
        int r238 = ((r159[r232 >>> 24] ^ r161[(r237 >>> 16) & 255]) ^ r163[(r1115 >>> 8) & 255]) ^ r165[r234 & 255];
        int r239 = r236 + 1;
        int r240 = r108[r236] ^ r238;
        int r241 = ((r159[r234 >>> 24] ^ r161[(r232 >>> 16) & 255]) ^ r163[(r237 >>> 8) & 255]) ^ r165[r1115 & 255];
        int r1116 = r239 + 1;
        int r242 = r241 ^ r108[r239];
        int r243 = ((r159[r1115 >>> 24] ^ r161[(r234 >>> 16) & 255]) ^ r163[(r232 >>> 8) & 255]) ^ r165[r237 & 255];
        int r1117 = r1116 + 1;
        int r244 = r243 ^ r108[r1116];
        int r245 = ((r159[r237 >>> 24] ^ r161[(r1115 >>> 16) & 255]) ^ r163[(r234 >>> 8) & 255]) ^ r165[r232 & 255];
        int r246 = r1117 + 1;
        int r247 = r245 ^ r108[r1117];
        int r248 = ((r159[r240 >>> 24] ^ r161[(r247 >>> 16) & 255]) ^ r163[(r244 >>> 8) & 255]) ^ r165[r242 & 255];
        int r1118 = r246 + 1;
        int r249 = r108[r246] ^ r248;
        int r250 = ((r159[r242 >>> 24] ^ r161[(r240 >>> 16) & 255]) ^ r163[(r247 >>> 8) & 255]) ^ r165[r244 & 255];
        int r1119 = r1118 + 1;
        int r251 = r250 ^ r108[r1118];
        int r1120 = ((r159[r244 >>> 24] ^ r161[(r242 >>> 16) & 255]) ^ r163[(r240 >>> 8) & 255]) ^ r165[r247 & 255];
        int r1121 = r1119 + 1;
        int r1122 = r1120 ^ r108[r1119];
        int r252 = (((r159[r247 >>> 24] ^ r161[(r244 >>> 16) & 255]) ^ r163[(r242 >>> 8) & 255]) ^ r165[r240 & 255]) ^ r108[r1121];
        int r253 = r108[0];
        int r254 = r210 + 1;
        byte[] r255 = f30301k;
        r112[r210] = (byte) (r255[r249 >>> 24] ^ (r253 >>> 24));
        int r256 = r254 + 1;
        r112[r254] = (byte) (r255[(r252 >>> 16) & 255] ^ (r253 >>> 16));
        int r257 = r256 + 1;
        r112[r256] = (byte) (r255[(r1122 >>> 8) & 255] ^ (r253 >>> 8));
        int r258 = r257 + 1;
        r112[r257] = (byte) (r253 ^ r255[r251 & 255]);
        int r259 = r108[1];
        int r260 = r258 + 1;
        r112[r258] = (byte) (r255[r251 >>> 24] ^ (r259 >>> 24));
        int r261 = r260 + 1;
        r112[r260] = (byte) (r255[(r249 >>> 16) & 255] ^ (r259 >>> 16));
        int r262 = r261 + 1;
        r112[r261] = (byte) (r255[(r252 >>> 8) & 255] ^ (r259 >>> 8));
        int r263 = r262 + 1;
        r112[r262] = (byte) (r259 ^ r255[r1122 & 255]);
        int r264 = r108[2];
        int r265 = r263 + 1;
        r112[r263] = (byte) (r255[r1122 >>> 24] ^ (r264 >>> 24));
        int r266 = r265 + 1;
        r112[r265] = (byte) (r255[(r251 >>> 16) & 255] ^ (r264 >>> 16));
        int r267 = r266 + 1;
        r112[r266] = (byte) (r255[(r249 >>> 8) & 255] ^ (r264 >>> 8));
        int r268 = r267 + 1;
        r112[r267] = (byte) (r264 ^ r255[r252 & 255]);
        int r269 = r108[3];
        int r270 = r268 + 1;
        r112[r268] = (byte) (r255[r252 >>> 24] ^ (r269 >>> 24));
        int r271 = r270 + 1;
        r112[r270] = (byte) (r255[(r1122 >>> 16) & 255] ^ (r269 >>> 16));
        r112[r271] = (byte) (r255[(r251 >>> 8) & 255] ^ (r269 >>> 8));
        r112[r271 + 1] = (byte) (r255[r249 & 255] ^ r269);
        return;
    L7:
        r157 = r152;
        r158 = 16;
        goto L9
    L8:
        r157 = r133;
        r151 = r127;
        r150 = r119;
        r149 = r109;
        r158 = 8;
        goto L9
    }

    public void b(byte[] r110, int r111, byte[] r112, int r210) {
        int r100 = r111 + 1;
        int r101 = r110[r111] << 24;
        int r102 = r100 + 1;
        int r103 = ((r110[r100] & UByte.MAX_VALUE) << 16) | r101;
        int r104 = r102 + 1;
        int r105 = r103 | ((r110[r102] & UByte.MAX_VALUE) << 8);
        int r106 = r104 + 1;
        int r107 = r105 | (r110[r104] & UByte.MAX_VALUE);
        int[] r108 = this.f30318f;
        int r109 = r107 ^ r108[0];
        int r113 = r106 + 1;
        int r114 = r113 + 1;
        int r115 = (r110[r106] << 24) | ((r110[r113] & UByte.MAX_VALUE) << 16);
        int r116 = r114 + 1;
        int r117 = r115 | ((r110[r114] & UByte.MAX_VALUE) << 8);
        int r118 = r116 + 1;
        int r119 = (r117 | (r110[r116] & UByte.MAX_VALUE)) ^ r108[1];
        int r120 = r118 + 1;
        int r121 = r110[r118] << 24;
        int r122 = r120 + 1;
        int r123 = ((r110[r120] & UByte.MAX_VALUE) << 16) | r121;
        int r124 = r122 + 1;
        int r125 = r123 | ((r110[r122] & UByte.MAX_VALUE) << 8);
        int r126 = r124 + 1;
        int r127 = (r125 | (r110[r124] & UByte.MAX_VALUE)) ^ r108[2];
        int r128 = r126 + 1;
        int r129 = r110[r126] << 24;
        int r130 = r128 + 1;
        int r131 = ((r110[r128] & UByte.MAX_VALUE) << 16) | r129;
        int r132 = r130 + 1;
        int r133 = (r131 | ((r110[r130] & UByte.MAX_VALUE) << 8)) | (r110[r132] & UByte.MAX_VALUE);
        int r134 = r108[3] ^ r133;
        int r135 = 4;
    L4:
        if (r135 >= this.f30319g) goto L6;
        int[] r136 = f30302l;
        int r137 = r136[r109 >>> 24];
        int[] r138 = f30303m;
        int r139 = r137 ^ r138[(r119 >>> 16) & 255];
        int[] r140 = f30304n;
        int r141 = r139 ^ r140[(r127 >>> 8) & 255];
        int[] r142 = f30305o;
        int r143 = r141 ^ r142[r134 & 255];
        int[] r144 = this.f30318f;
        int r145 = r135 + 1;
        int r146 = r144[r135] ^ r143;
        int r147 = ((r136[r119 >>> 24] ^ r138[(r127 >>> 16) & 255]) ^ r140[(r134 >>> 8) & 255]) ^ r142[r109 & 255];
        int r148 = r145 + 1;
        int r149 = r147 ^ r144[r145];
        int r150 = ((r136[r127 >>> 24] ^ r138[(r134 >>> 16) & 255]) ^ r140[(r109 >>> 8) & 255]) ^ r142[r119 & 255];
        int r151 = r148 + 1;
        int r152 = r150 ^ r144[r148];
        int r153 = r136[r134 >>> 24];
        int r154 = ((r138[(r109 >>> 16) & 255] ^ r153) ^ r140[(r119 >>> 8) & 255]) ^ r142[r127 & 255];
        int r155 = r154 ^ r144[r151];
        r119 = r149;
        r127 = r152;
        r134 = r155;
        r109 = r146;
        r135 = r151 + 1;
        goto L4
    L6:
        int[] r156 = this.f30318f;
        int r157 = r135 + 1;
        int r158 = r156[r135];
        int r159 = r210 + 1;
        byte[] r160 = f30300j;
        r112[r210] = (byte) (r160[r109 >>> 24] ^ (r158 >>> 24));
        int r161 = r159 + 1;
        r112[r159] = (byte) (r160[(r119 >>> 16) & 255] ^ (r158 >>> 16));
        int r162 = r161 + 1;
        r112[r161] = (byte) (r160[(r127 >>> 8) & 255] ^ (r158 >>> 8));
        int r163 = r162 + 1;
        r112[r162] = (byte) (r158 ^ r160[r134 & 255]);
        int r164 = r157 + 1;
        int r165 = r156[r157];
        int r166 = r163 + 1;
        r112[r163] = (byte) (r160[r119 >>> 24] ^ (r165 >>> 24));
        int r167 = r166 + 1;
        r112[r166] = (byte) (r160[(r127 >>> 16) & 255] ^ (r165 >>> 16));
        int r168 = r167 + 1;
        r112[r167] = (byte) (r160[(r134 >>> 8) & 255] ^ (r165 >>> 8));
        int r169 = r168 + 1;
        r112[r168] = (byte) (r165 ^ r160[r109 & 255]);
        int r170 = r164 + 1;
        int r171 = r156[r164];
        int r172 = r169 + 1;
        r112[r169] = (byte) (r160[r127 >>> 24] ^ (r171 >>> 24));
        int r173 = r172 + 1;
        r112[r172] = (byte) (r160[(r134 >>> 16) & 255] ^ (r171 >>> 16));
        int r174 = r173 + 1;
        r112[r173] = (byte) (r160[(r109 >>> 8) & 255] ^ (r171 >>> 8));
        int r175 = r174 + 1;
        r112[r174] = (byte) (r171 ^ r160[r119 & 255]);
        int r176 = r156[r170];
        int r177 = r175 + 1;
        r112[r175] = (byte) (r160[r134 >>> 24] ^ (r176 >>> 24));
        int r178 = r177 + 1;
        r112[r177] = (byte) (r160[(r109 >>> 16) & 255] ^ (r176 >>> 16));
        r112[r178] = (byte) (r160[(r119 >>> 8) & 255] ^ (r176 >>> 8));
        r112[r178 + 1] = (byte) (r160[r127 & 255] ^ r176);
    }
}
