package e.a;

import d.h.b.o;
import d.x;
import e.e;
import e.h;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f38698a = null;

    public static final /* synthetic */ int a(char r0) {
        return b(r0);
    }

    public static final /* synthetic */ int a(byte[] r0, int r1) {
        return b(r0, r1);
    }

    public static final char[] a() {
        return f38698a;
    }

    static {
        f38698a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static final void a(h r1, e r2, int r3, int r4) {
        o.e(r1, "<this>");
        o.e(r2, "buffer");
        r2.b(r1.a(), r3, r4);
    }

    private static final int b(char r4) {
        boolean r1 = true;
        if ('0' <= r4) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L26;
        char r0 = 'a';
        if ('a' <= r4) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L29;
        r0 = 'A';
        if ('A' <= r4) goto L21;
    L23:
        r1 = false;
    L24:
        if (r1 == true) goto L29;
        throw new IllegalArgumentException("Unexpected hex digit: " + r4);
    L21:
        if (r4 >= 'G') goto L23;
    L29:
        return (r4 - r0) + 10;
    L13:
        if (r4 >= 'g') goto L15;
        r5 = true;
        goto L16
    L26:
        return r4 - '0';
    L5:
        if (r4 >= ':') goto L7;
        r3 = true;
        goto L8
    }

    private static final int b(byte[] r19, int r20) {
        int r2 = r19.length;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r4 >= r2) goto L254;
        byte r7 = r19[r4];
        if (r7 >= 0) goto L6;
        if ((r7 >> 5) != (-2)) goto L108;
        int r3 = r4 + 1;
        if (r2 <= r3) goto L64;
        byte r8 = r19[r4];
        byte r9 = r19[r3];
        if ((r9 & 192) != 128) goto L70;
        boolean r15 = true;
    L71:
        if (r15 == false) goto L72;
        int r10 = (r9 ^ 3968) ^ (r8 << 6);
        if (r10 < 128) goto L77;
        int r11 = r6 + 1;
        if (r6 == r20) goto L82;
        if (r10 == 10) goto L99;
        if (r10 == 13) goto L99;
        if (r10 < 0) goto L88;
        if (r10 >= 32) goto L88;
        boolean r12 = true;
    L89:
        if (r12 == true) goto L97;
        if (127 > r10) goto L93;
        if (r10 >= 160) goto L93;
        boolean r13 = true;
    L94:
        if (r13 == true) goto L97;
        boolean r14 = false;
    L98:
        if (r14 == false) goto L99;
    L100:
        return -1;
    L93:
        r13 = false;
    L97:
        r14 = true;
    L88:
        r12 = false;
    L99:
        if (r10 == 65533) goto L100;
        if (r10 >= 65536) goto L104;
        int r16 = 1;
    L105:
        r5 = r5 + r16;
        x r17 = x.f38692a;
        r4 = r4 + 2;
    L106:
        r6 = r11;
        goto L3
    L104:
        r16 = 2;
        goto L105
    L82:
        return r5;
    L77:
        if (r6 != r20) goto L79;
        return r5;
    L79:
        return -1;
    L72:
        if (r6 != r20) goto L74;
        return r5;
    L74:
        return -1;
    L70:
        r15 = false;
        goto L71
    L64:
        if (r6 != r20) goto L66;
        return r5;
    L66:
        return -1;
    L108:
        if ((r7 >> 4) != (-2)) goto L173;
        int r18 = r4 + 2;
        if (r2 <= r18) goto L111;
        byte r21 = r19[r4];
        byte r110 = r19[r4 + 1];
        if ((r110 & 192) != 128) goto L117;
        boolean r22 = true;
    L118:
        if (r22 == false) goto L119;
        byte r23 = r19[r18];
        if ((r23 & 192) != 128) goto L125;
        boolean r24 = true;
    L126:
        if (r24 == false) goto L127;
        int r25 = ((r23 ^ (-123008)) ^ (r110 << 6)) ^ (r21 << 12);
        if (r25 < 2048) goto L132;
        if (55296 > r25) goto L138;
        if (r25 >= 57344) goto L138;
        boolean r26 = true;
    L139:
        if (r26 == true) goto L140;
        r11 = r6 + 1;
        if (r6 == r20) goto L145;
        if (r25 == 10) goto L165;
        if (r25 == 13) goto L165;
        if (r25 < 0) goto L151;
        if (r25 >= 32) goto L151;
        boolean r27 = true;
    L152:
        if (r27 == false) goto L154;
    L162:
        boolean r28 = true;
    L163:
        if (r28 == false) goto L165;
    L166:
        return -1;
    L154:
        if (127 <= r25) goto L156;
    L158:
        boolean r29 = false;
    L159:
        if (r29 == true) goto L162;
        r28 = false;
        goto L163
    L156:
        if (r25 >= 160) goto L158;
        r29 = true;
    L151:
        r27 = false;
    L165:
        if (r25 == 65533) goto L166;
        if (r25 >= 65536) goto L170;
        int r111 = 1;
    L171:
        r5 = r5 + r111;
        x r30 = x.f38692a;
        r4 = r4 + 3;
        goto L106
    L170:
        r111 = 2;
        goto L171
    L145:
        return r5;
    L140:
        if (r6 != r20) goto L142;
        return r5;
    L142:
        return -1;
    L138:
        r26 = false;
        goto L139
    L132:
        if (r6 != r20) goto L134;
        return r5;
    L134:
        return -1;
    L127:
        if (r6 != r20) goto L129;
        return r5;
    L129:
        return -1;
    L125:
        r24 = false;
        goto L126
    L119:
        if (r6 != r20) goto L121;
        return r5;
    L121:
        return -1;
    L117:
        r22 = false;
        goto L118
    L111:
        if (r6 != r20) goto L113;
        return r5;
    L113:
        return -1;
    L173:
        if ((r7 >> 3) != (-2)) goto L251;
        int r31 = r4 + 3;
        if (r2 <= r31) goto L176;
        byte r32 = r19[r4];
        byte r33 = r19[r4 + 1];
        if ((r33 & 192) != 128) goto L182;
        boolean r112 = true;
    L183:
        if (r112 == false) goto L184;
        byte r113 = r19[r4 + 2];
        if ((r113 & 192) != 128) goto L190;
        boolean r114 = true;
    L191:
        if (r114 == false) goto L192;
        byte r34 = r19[r31];
        if ((r34 & 192) != 128) goto L198;
        boolean r115 = true;
    L199:
        if (r115 == false) goto L200;
        int r35 = (((r34 ^ 3678080) ^ (r113 << 6)) ^ (r33 << 12)) ^ (r32 << 18);
        if (r35 > 1114111) goto L205;
        if (55296 > r35) goto L211;
        if (r35 >= 57344) goto L211;
        boolean r36 = true;
    L212:
        if (r36 == true) goto L213;
        if (r35 < 65536) goto L218;
        r11 = r6 + 1;
        if (r6 == r20) goto L223;
        if (r35 == 10) goto L244;
        if (r35 == 13) goto L244;
        if (r35 >= 0) goto L228;
    L230:
        boolean r37 = false;
    L231:
        if (r37 == false) goto L233;
    L241:
        boolean r38 = true;
    L242:
        if (r38 == false) goto L244;
    L245:
        return -1;
    L233:
        if (127 <= r35) goto L235;
    L237:
        boolean r39 = false;
    L238:
        if (r39 == true) goto L241;
        r38 = false;
        goto L242
    L235:
        if (r35 >= 160) goto L237;
        r39 = true;
        goto L238
    L228:
        if (r35 >= 32) goto L230;
        r37 = true;
    L244:
        if (r35 == 65533) goto L245;
        if (r35 >= 65536) goto L249;
        int r116 = 1;
    L250:
        r5 = r5 + r116;
        x r40 = x.f38692a;
        r4 = r4 + 4;
        goto L106
    L249:
        r116 = 2;
        goto L250
    L223:
        return r5;
    L218:
        if (r6 != r20) goto L220;
        return r5;
    L220:
        return -1;
    L213:
        if (r6 != r20) goto L215;
        return r5;
    L215:
        return -1;
    L211:
        r36 = false;
        goto L212
    L205:
        if (r6 != r20) goto L207;
        return r5;
    L207:
        return -1;
    L200:
        if (r6 != r20) goto L202;
        return r5;
    L202:
        return -1;
    L198:
        r115 = false;
        goto L199
    L192:
        if (r6 != r20) goto L194;
        return r5;
    L194:
        return -1;
    L190:
        r114 = false;
        goto L191
    L184:
        if (r6 != r20) goto L186;
        return r5;
    L186:
        return -1;
    L182:
        r112 = false;
        goto L183
    L176:
        if (r6 != r20) goto L178;
        return r5;
    L178:
        return -1;
    L251:
        if (r6 != r20) goto L253;
        return r5;
    L253:
        return -1;
    L6:
        int r117 = r6 + 1;
        if (r6 == r20) goto L8;
        if (r7 == 10) goto L25;
        if (r7 == 13) goto L25;
        if (r7 < 0) goto L14;
        if (r7 >= 32) goto L14;
        boolean r41 = true;
    L15:
        if (r41 == true) goto L23;
        if (127 > r7) goto L19;
        if (r7 >= 160) goto L19;
        boolean r42 = true;
    L20:
        if (r42 == true) goto L23;
        boolean r43 = false;
    L24:
        if (r43 == false) goto L25;
    L26:
        return -1;
    L19:
        r42 = false;
    L23:
        r43 = true;
    L14:
        r41 = false;
    L25:
        if (r7 == 65533) goto L26;
        if (r7 >= 65536) goto L29;
        int r44 = 1;
    L30:
        r5 = r5 + r44;
        r4 = r4 + 1;
    L31:
        r6 = r117;
        if (r4 >= r2) goto L3;
        if (r19[r4] < 0) goto L3;
        int r45 = r4 + 1;
        byte r46 = r19[r4];
        r117 = r6 + 1;
        if (r6 == r20) goto L37;
        if (r46 == 10) goto L54;
        if (r46 == 13) goto L54;
        if (r46 < 0) goto L43;
        if (r46 >= 32) goto L43;
        boolean r47 = true;
    L44:
        if (r47 == true) goto L52;
        if (127 > r46) goto L48;
        if (r46 >= 160) goto L48;
        boolean r48 = true;
    L49:
        if (r48 == true) goto L52;
        boolean r49 = false;
    L53:
        if (r49 == false) goto L54;
    L55:
        return -1;
    L48:
        r48 = false;
    L52:
        r49 = true;
    L43:
        r47 = false;
    L54:
        if (r46 == 65533) goto L55;
        if (r46 >= 65536) goto L58;
        int r50 = 1;
    L59:
        r5 = r5 + r50;
        r4 = r45;
        goto L31
    L58:
        r50 = 2;
        goto L59
    L37:
        return r5;
    L29:
        r44 = 2;
        goto L30
    L8:
        return r5;
    L254:
        return r5;
    }
}
