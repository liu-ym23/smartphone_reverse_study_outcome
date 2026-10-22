package bytekn.foundation.encryption;

import android.R;
import com.byted.cast.common.CastMonitor;
import com.ss.ttm.player.MediaPlayer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f21756g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f21757h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f21758i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f21759j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f21760k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f21761l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f21762m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f21763n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f21764o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f21765p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f21766q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C0382a f21767r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f21771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f21772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f21773f;

    /* JADX INFO: renamed from: bytekn.foundation.encryption.a$a, reason: collision with other inner class name */
    public static final class C0382a {
        public C0382a() {
        }

        public static int[] b(byte[] r100) {
            int r101 = r100.length / 4;
            int[] r102 = new int[r101];
            int r103 = 0;
            int r104 = 0;
        L3:
            if (r103 >= r101) goto L5;
            int r105 = r104 + 1;
            int r106 = r100[r104] & UByte.MAX_VALUE;
            int r107 = r105 + 1;
            int r108 = r100[r105] & UByte.MAX_VALUE;
            int r109 = r107 + 1;
            int r110 = r100[r107] & UByte.MAX_VALUE;
            int r111 = r109 + 1;
            int r112 = r110 << 8;
            int r113 = r108 << 16;
            int r114 = r106 << 24;
            r102[r103] = r114 | (r113 | (r112 | ((r100[r109] & UByte.MAX_VALUE) << 0)));
            r103 = r103 + 1;
            r104 = r111;
            goto L3
        L5:
            return r102;
        }

        public static byte[] a(byte[] r310, byte[] r311, byte[] r312, Padding r313) {
            a r100 = new a(r311);
            int[] r101 = b(r310);
            int r102 = r101.length;
            byte[] r103 = new byte[16];
            char r104 = 0;
            if (r312 != null) goto L5;
        L9:
            int[] r105 = b(r103);
            int r106 = r105[0];
            char r107 = 1;
            int r108 = r105[1];
            char r109 = 2;
            int r110 = r105[2];
            char r111 = 3;
            int r112 = r105[3];
            IntProgression r113 = RangesKt.step(RangesKt.until(0, r102), 4);
            int r114 = r113.getFirst();
            int r115 = r113.getLast();
            int r116 = r113.getStep();
            if (r116 < 0) goto L13;
            if (r114 <= r115) goto L14;
        L20:
            Padding.a r117 = Padding.Companion;
            int r118 = r101.length * 4;
            byte[] r119 = new byte[r118];
            int r120 = r101.length;
            int r121 = 0;
            int r122 = 0;
        L21:
            if (r121 >= r120) goto L23;
            int r123 = r101[r121];
            int r124 = r122 + 1;
            r119[r122] = (byte) ((r123 >> 24) & 255);
            int r125 = r124 + 1;
            r119[r124] = (byte) ((r123 >> 16) & 255);
            int r126 = r125 + 1;
            r119[r125] = (byte) ((r123 >> 8) & 255);
            r122 = r126 + 1;
            r119[r126] = (byte) ((r123 >> 0) & 255);
            r121 = r121 + 1;
            goto L21
        L23:
            r117.getClass();
            int r127 = e.f21780a[r313.ordinal()];
            if (r127 != 1) goto L26;
            return r119;
        L26:
            if (r127 != 2) goto L28;
        L42:
            int r128 = r118 - (r119[r118 - 1] & 255);
            byte[] r129 = new byte[r128];
            ArraysKt.copyInto(r119, r129, 0, 0, r128 + 0);
        L44:
            return r129;
        L28:
            if (r127 == 3) goto L42;
            if (r127 == 4) goto L42;
            if (r127 != 5) goto L41;
            int r130 = r118 - 1;
            int r131 = 0;
        L34:
            if (r130 < 0) goto L39;
            if (r119[r130] != 0) goto L39;
            r131 = r131 + 1;
            r130 = r130 - 1;
        L39:
            int r132 = r118 - r131;
            r129 = new byte[r132];
            ArraysKt.copyInto(r119, r129, 0, 0, r132 + 0);
            goto L44
        L41:
            throw new NoWhenBranchMatchedException();
        L14:
            int r133 = r114 + 0;
            int r134 = r101[r133];
            int r135 = r114 + 1;
            int r136 = r101[r135];
            int r137 = r114 + 2;
            int r210 = r101[r137];
            int r211 = r114 + 3;
            int r212 = r101[r211];
            r101[r135] = r212;
            r101[r211] = r136;
            int[] r138 = r100.f21772e;
            int[] r213 = a.f21762m;
            int[] r214 = a.f21763n;
            int[] r215 = a.f21764o;
            int[] r216 = a.f21765p;
            int[] r217 = a.f21757h;
            int r218 = r101[r133] ^ r138[r104];
            int r219 = r101[r135] ^ r138[r107];
            int r314 = r101[r137] ^ r138[r109];
            int r315 = r138[r111] ^ r136;
            int r139 = r100.f21769b;
            int r316 = r315;
            int r140 = 1;
            int r317 = r314;
            int r318 = r219;
            int r220 = r218;
            int r221 = 4;
        L15:
            if (r140 >= r139) goto L17;
            int r141 = ((r214[(r318 >>> 16) & 255] ^ r213[(r220 >>> 24) & 255]) ^ r215[(r317 >>> 8) & 255]) ^ r216[(r316 >>> 0) & 255];
            int r142 = r221 + 1;
            int r222 = r138[r221] ^ r141;
            int r143 = ((r214[(r317 >>> 16) & 255] ^ r213[(r318 >>> 24) & 255]) ^ r215[(r316 >>> 8) & 255]) ^ r216[(r220 >>> 0) & 255];
            int r144 = r142 + 1;
            int r145 = r143 ^ r138[r142];
            a r319 = r100;
            int r146 = ((r214[(r316 >>> 16) & 255] ^ r213[(r317 >>> 24) & 255]) ^ r215[(r220 >>> 8) & 255]) ^ r216[(r318 >>> 0) & 255];
            int r147 = r144 + 1;
            int r148 = r146 ^ r138[r144];
            int r149 = ((r214[(r220 >>> 16) & 255] ^ r213[(r316 >>> 24) & 255]) ^ r215[(r318 >>> 8) & 255]) ^ r216[(r317 >>> 0) & 255];
            r316 = r149 ^ r138[r147];
            r140 = r140 + 1;
            r318 = r145;
            r220 = r222;
            r100 = r319;
            r317 = r148;
            r221 = r147 + 1;
            goto L15
        L17:
            a r320 = r100;
            int r150 = r221 + 1;
            int r151 = ((((r217[(r220 >>> 24) & 255] << 24) | (r217[(r318 >>> 16) & 255] << 16)) | (r217[(r317 >>> 8) & 255] << 8)) | r217[(r316 >>> 0) & 255]) ^ r138[r221];
            int r152 = r150 + 1;
            int r153 = r138[r150] ^ ((((r217[(r318 >>> 24) & 255] << 24) | (r217[(r317 >>> 16) & 255] << 16)) | (r217[(r316 >>> 8) & 255] << 8)) | r217[(r220 >>> 0) & 255]);
            int r154 = ((((r217[(r317 >>> 24) & 255] << 24) | (r217[(r316 >>> 16) & 255] << 16)) | (r217[(r220 >>> 8) & 255] << 8)) | r217[(r318 >>> 0) & 255]) ^ r138[r152];
            int r155 = ((((r217[(r316 >>> 24) & 255] << 24) | (r217[(r220 >>> 16) & 255] << 16)) | (r217[(r318 >>> 8) & 255] << 8)) | r217[(r317 >>> 0) & 255]) ^ r138[r152 + 1];
            r101[r133] = r151;
            r101[r135] = r153;
            r101[r137] = r154;
            r101[r211] = r155;
            int r156 = r101[r135];
            r101[r135] = r155;
            r101[r211] = r156;
            r101[r133] = r101[r133] ^ r106;
            r101[r135] = r101[r135] ^ r108;
            r101[r137] = r101[r137] ^ r110;
            r101[r211] = r112 ^ r101[r211];
            if (r114 == r115) goto L20;
            r114 = r114 + r116;
            r106 = r134;
            r108 = r136;
            r110 = r210;
            r112 = r212;
            r100 = r320;
            r104 = 0;
            r107 = 1;
            r109 = 2;
            r111 = 3;
            goto L14
        L13:
            if (r114 < r115) goto L20;
        L5:
            if (r312.length >= 16) goto L7;
            int r157 = r312.length;
        L8:
            ArraysKt.copyInto(r312, r103, 0, 0, r157 + 0);
            goto L9
        L7:
            r157 = 16;
            goto L8
        }
    }

    static {
        f21767r = new C0382a();
        f21756g = new int[256];
        f21757h = new int[256];
        f21758i = new int[256];
        f21759j = new int[256];
        f21760k = new int[256];
        f21761l = new int[256];
        f21762m = new int[256];
        f21763n = new int[256];
        f21764o = new int[256];
        f21765p = new int[256];
        f21766q = new int[]{0, 1, 2, 4, 8, 16, 32, 64, 128, 27, 54};
        int[] r100 = new int[256];
        int r101 = 0;
    L3:
        if (r101 >= 256) goto L9;
        if (r101 < 128) goto L7;
        int r102 = (r101 << 1) ^ MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS;
    L8:
        r100[r101] = r102;
        r101 = r101 + 1;
        goto L3
    L7:
        r102 = r101 << 1;
        goto L8
    L9:
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L10:
        if (r103 >= 256) goto L16;
        int r106 = ((((r104 << 1) ^ r104) ^ (r104 << 2)) ^ (r104 << 3)) ^ (r104 << 4);
        int r107 = r106 >>> 8;
        int r108 = ((r106 & 255) ^ r107) ^ 99;
        f21756g[r105] = r108;
        f21757h[r108] = r105;
        int r109 = r100[r105];
        int r110 = r100[r109];
        int r111 = r100[r110];
        int r112 = (r100[r108] * 257) ^ (r108 * R.attr.transcriptMode);
        f21758i[r105] = (r112 << 24) | (r112 >>> 8);
        f21759j[r105] = (r112 << 16) | (r112 >>> 16);
        f21760k[r105] = (r112 << 8) | (r112 >>> 24);
        f21761l[r105] = r112 << 0;
        int r113 = R.attr.cacheColorHint * r111;
        int r114 = (((r110 * CastMonitor.EVENT_TRACK) ^ r113) ^ (r109 * 257)) ^ (R.attr.transcriptMode * r105);
        f21762m[r108] = (r114 << 24) | (r114 >>> 8);
        f21763n[r108] = (r114 << 16) | (r114 >>> 16);
        f21764o[r108] = (r114 << 8) | (r114 >>> 24);
        f21765p[r108] = r114 << 0;
        if (r105 != 0) goto L14;
        r104 = 1;
        r105 = 1;
    L15:
        r103 = r103 + 1;
        goto L10
    L14:
        r105 = r100[r100[r100[r111 ^ r109]]] ^ r109;
        r104 = r104 ^ r100[r100[r104]];
        goto L15
    }

    public a(byte[] r110) {
        f21767r.getClass();
        int[] r111 = C0382a.b(r110);
        this.f21773f = r111;
        int r112 = r111.length;
        this.f21768a = r112;
        int r113 = r112 + 6;
        this.f21769b = r113;
        int r114 = (r113 + 1) * 4;
        this.f21770c = r114;
        int[] r100 = new int[r114];
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r114) goto L15;
        int r103 = this.f21768a;
        if (r102 >= r103) goto L7;
        int r104 = this.f21773f[r102];
    L14:
        r100[r102] = r104;
        r102 = r102 + 1;
        goto L3
    L7:
        int r105 = r100[r102 - 1];
        int r106 = r102 % r103;
        if (r106 != 0) goto L10;
        int r107 = (r105 >>> 24) | (r105 << 8);
        int[] r108 = f21756g;
        r105 = (r108[r107 & 255] | (((r108[(r107 >>> 24) & 255] << 24) | (r108[(r107 >>> 16) & 255] << 16)) | (r108[(r107 >>> 8) & 255] << 8))) ^ (f21766q[(r102 / r103) | 0] << 24);
    L13:
        r104 = r100[r102 - r103] ^ r105;
        goto L14
    L10:
        if (r103 <= 6) goto L13;
        if (r106 != 4) goto L13;
        int[] r109 = f21756g;
        r105 = r109[r105 & 255] | (((r109[(r105 >>> 24) & 255] << 24) | (r109[(r105 >>> 16) & 255] << 16)) | (r109[(r105 >>> 8) & 255] << 8));
        goto L13
    L15:
        this.f21771d = r100;
        int r115 = this.f21770c;
        int[] r116 = new int[r115];
    L16:
        if (r101 >= r115) goto L26;
        int r117 = this.f21770c - r101;
        if ((r101 % 4) == 0) goto L20;
        int r118 = this.f21771d[r117];
    L21:
        if (r101 < 4) goto L25;
        if (r117 <= 4) goto L25;
        int[] r119 = f21762m;
        int[] r120 = f21756g;
        r118 = f21765p[r120[r118 & 255]] ^ ((r119[r120[(r118 >>> 24) & 255]] ^ f21763n[r120[(r118 >>> 16) & 255]]) ^ f21764o[r120[(r118 >>> 8) & 255]]);
    L25:
        r116[r101] = r118;
        r101 = r101 + 1;
        goto L16
    L20:
        r118 = this.f21771d[r117 - 4];
        goto L21
    L26:
        this.f21772e = r116;
    }
}
