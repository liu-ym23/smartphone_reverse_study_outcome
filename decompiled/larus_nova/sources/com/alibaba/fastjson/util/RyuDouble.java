package com.alibaba.fastjson.util;

import androidx.collection.SieveCacheKt;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.ss.ttm.player.C;
import com.ss.ttm.player.MediaPlayer;
import com.ttnet.org.chromium.net.NetError;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes28.dex */
public final class RyuDouble {
    private static final int[][] POW5_INV_SPLIT = null;
    private static final int[][] POW5_SPLIT = null;

    static {
        Class r100 = Integer.TYPE;
        POW5_SPLIT = (int[][]) Array.newInstance(r100, new int[]{326, 4});
        POW5_INV_SPLIT = (int[][]) Array.newInstance(r100, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, 4});
        BigInteger r101 = BigInteger.ONE;
        BigInteger r102 = r101.shiftLeft(31).subtract(r101);
        BigInteger r103 = r101.shiftLeft(31).subtract(r101);
        int r104 = 0;
    L4:
        if (r104 >= 326) goto L26;
        BigInteger r105 = BigInteger.valueOf(5).pow(r104);
        int r106 = r105.bitLength();
        if (r104 != 0) goto L8;
        int r107 = 1;
    L9:
        if (r107 != r106) goto L25;
        if (r104 >= POW5_SPLIT.length) goto L16;
        int r108 = 0;
    L13:
        if (r108 >= 4) goto L16;
        POW5_SPLIT[r104][r108] = r105.shiftRight((r106 + NetError.ERR_SOCKS_CONNECTION_HOST_UNREACHABLE) + ((3 - r108) * 31)).and(r102).intValue();
        r108 = r108 + 1;
    L16:
        if (r104 >= POW5_INV_SPLIT.length) goto L23;
        BigInteger r109 = BigInteger.ONE;
        BigInteger r110 = r109.shiftLeft(r106 + 121).divide(r105).add(r109);
        int r111 = 0;
    L18:
        if (r111 >= 4) goto L23;
        if (r111 != 0) goto L21;
        POW5_INV_SPLIT[r104][r111] = r110.shiftRight((3 - r111) * 31).intValue();
    L22:
        r111 = r111 + 1;
        goto L18
    L21:
        POW5_INV_SPLIT[r104][r111] = r110.shiftRight((3 - r111) * 31).and(r103).intValue();
    L23:
        r104 = r104 + 1;
        goto L4
    L25:
        throw new IllegalStateException(r106 + " != " + r107);
    L8:
        r107 = (int) ((((((long) r104) * 23219280) + StackLeakChecker.CHECK_INTERVAL_10_SEC) - 1) / StackLeakChecker.CHECK_INTERVAL_10_SEC);
        goto L9
    }

    public RyuDouble() {
    }

    public static String toString(double r100) {
        char[] r101 = new char[24];
        return new String(r101, 0, toString(r100, r101, 0));
    }

    public static int toString(double r410, char[] r411, int r412) {
        if (Double.isNaN(r410) == false) goto L8;
        int r100 = r412 + 1;
        r411[r412] = 'N';
        int r101 = r100 + 1;
        r411[r100] = 'a';
        int r102 = r101 + 1;
        r411[r101] = 'N';
    L6:
        return r102 - r412;
    L8:
        if (r410 != Double.POSITIVE_INFINITY) goto L13;
        int r103 = r412 + 1;
        r411[r412] = 'I';
        int r104 = r103 + 1;
        r411[r103] = 'n';
        int r105 = r104 + 1;
        r411[r104] = 'f';
        int r106 = r105 + 1;
        r411[r105] = 'i';
        int r107 = r106 + 1;
        r411[r106] = 'n';
        int r108 = r107 + 1;
        r411[r107] = 'i';
        int r109 = r108 + 1;
        r411[r108] = OthersPermission.STICKY_E;
        int r110 = r109 + 1;
        r411[r109] = 'y';
    L11:
        return r110 - r412;
    L13:
        if (r410 != Double.NEGATIVE_INFINITY) goto L15;
        int r111 = r412 + 1;
        r411[r412] = '-';
        int r112 = r111 + 1;
        r411[r111] = 'I';
        int r113 = r112 + 1;
        r411[r112] = 'n';
        int r114 = r113 + 1;
        r411[r113] = 'f';
        int r115 = r114 + 1;
        r411[r114] = 'i';
        int r116 = r115 + 1;
        r411[r115] = 'n';
        int r117 = r116 + 1;
        r411[r116] = 'i';
        int r118 = r117 + 1;
        r411[r117] = OthersPermission.STICKY_E;
        r102 = r118 + 1;
        r411[r118] = 'y';
        goto L6
    L15:
        long r119 = Double.doubleToLongBits(r410);
        if (r119 != 0) goto L19;
        int r120 = r412 + 1;
        r411[r412] = '0';
        int r121 = r120 + 1;
        r411[r120] = '.';
        r102 = r121 + 1;
        r411[r121] = '0';
        goto L6
    L19:
        if (r119 != Long.MIN_VALUE) goto L21;
        int r122 = r412 + 1;
        r411[r412] = '-';
        int r123 = r122 + 1;
        r411[r122] = '0';
        int r124 = r123 + 1;
        r411[r123] = '.';
        r110 = r124 + 1;
        r411[r124] = '0';
        goto L11
    L21:
        int r125 = (int) ((r119 >>> 52) & 2047);
        long r126 = r119 & 4503599627370495L;
        if (r125 != 0) goto L24;
        int r127 = -1074;
    L26:
        if (r119 >= 0) goto L28;
        boolean r128 = true;
    L30:
        if ((r126 & 1) != 0) goto L32;
        boolean r129 = true;
    L33:
        long r130 = 4 * r126;
        long r131 = r130 + 2;
        if (r126 != 4503599627370496L) goto L38;
        if (r125 <= 1) goto L38;
        int r132 = 0;
    L39:
        long r133 = (r130 - 1) - ((long) r132);
        int r134 = r127 - 2;
        if (r134 < 0) goto L121;
        int r135 = Math.max(0, ((int) ((((long) r134) * 3010299) / StackLeakChecker.CHECK_INTERVAL_10_SEC)) - 1);
        if (r135 != 0) goto L44;
        int r136 = 1;
    L45:
        int r137 = ((((-r134) + r135) + ((r136 + 122) - 1)) - 93) - 21;
        if (r137 < 0) goto L120;
        int[] r138 = POW5_INV_SPLIT[r135];
        long r210 = r130 >>> 31;
        long r211 = r130 & SieveCacheKt.NodeLinkMask;
        int r139 = r138[0];
        boolean r310 = r128;
        long r140 = ((long) r139) * r210;
        int r141 = r138[1];
        long r142 = ((long) r141) * r210;
        int r143 = r138[2];
        long r144 = ((long) r143) * r210;
        int r145 = r138[3];
        boolean r311 = r129;
        long r212 = r210 * ((long) r145);
        long r146 = ((((((((((((r211 * ((long) r145)) >>> 31) + (((long) r143) * r211)) + r212) >>> 31) + (((long) r141) * r211)) + r144) >>> 31) + (((long) r139) * r211)) + r142) >>> 21) + (r140 << 10)) >>> r137;
        long r147 = r131 >>> 31;
        long r148 = r131 & SieveCacheKt.NodeLinkMask;
        long r149 = ((long) r139) * r147;
        long r150 = ((long) r141) * r147;
        long r151 = ((long) r143) * r147;
        int r152 = r135;
        long r153 = r147 * ((long) r145);
        long r154 = ((((((((((((r148 * ((long) r145)) >>> 31) + (((long) r143) * r148)) + r153) >>> 31) + (((long) r141) * r148)) + r151) >>> 31) + (((long) r139) * r148)) + r150) >>> 21) + (r149 << 10)) >>> r137;
        long r155 = r133 >>> 31;
        long r156 = r133 & SieveCacheKt.NodeLinkMask;
        long r157 = ((long) r139) * r155;
        long r158 = ((long) r141) * r155;
        long r213 = r154;
        long r159 = ((long) r143) * r155;
        long r160 = r155 * ((long) r145);
        long r161 = ((((((((((((r156 * ((long) r145)) >>> 31) + (((long) r143) * r156)) + r160) >>> 31) + (((long) r141) * r156)) + r159) >>> 31) + (((long) r139) * r156)) + r158) >>> 21) + (r157 << 10)) >>> r137;
        if (r152 > 21) goto L116;
        long r162 = r130 % 5;
        long r163 = 0;
        if (r162 != 0) goto L73;
        if (r162 == 0) goto L54;
        int r164 = 0;
    L69:
        if (r164 < r152) goto L71;
        boolean r165 = true;
    L72:
        boolean r166 = r165;
        boolean r167 = false;
    L118:
        long r168 = r146;
    L146:
        if (r213 < 1000000000000000000L) goto L149;
        int r169 = 19;
    L200:
        int r170 = (r152 + r169) - 1;
        if (r170 >= (-3)) goto L203;
    L206:
        boolean r171 = true;
    L207:
        if (r167 == true) goto L225;
        if (r166 == true) goto L225;
        int r172 = 0;
        int r173 = 0;
    L211:
        long r174 = r213 / 10;
        long r175 = r161 / 10;
        if (r174 <= r175) goto L219;
        if (r213 >= 100) goto L217;
        if (r171 == true) goto L219;
    L217:
        r173 = (int) (r168 % 10);
        r168 = r168 / 10;
        r172 = r172 + 1;
        r213 = r174;
        r161 = r175;
    L219:
        if (r168 == r161) goto L223;
        if (r173 >= 5) goto L223;
        int r176 = 0;
    L224:
        long r177 = r168 + ((long) r176);
    L266:
        int r178 = r169 - r172;
        if (r310 == false) goto L269;
        int r179 = r412 + 1;
        r411[r412] = '-';
    L270:
        if (r171 == false) goto L288;
        int r180 = 0;
    L273:
        if (r180 >= (r178 - 1)) goto L275;
        int r181 = (int) (r177 % 10);
        r177 = r177 / 10;
        r411[(r179 + r178) - r180] = (char) (r181 + 48);
        r180 = r180 + 1;
        goto L273
    L275:
        r411[r179] = (char) ((r177 % 10) + 48);
        r411[r179 + 1] = '.';
        int r182 = r179 + (r178 + 1);
        if (r178 != 1) goto L278;
        r411[r182] = '0';
        r182 = r182 + 1;
    L278:
        int r183 = r182 + 1;
        r411[r182] = 'E';
        if (r170 >= 0) goto L282;
        r411[r183] = '-';
        r170 = -r170;
        r183 = r183 + 1;
    L282:
        if (r170 < 100) goto L284;
        int r184 = r183 + 1;
        int r185 = 48;
        r411[r183] = (char) ((r170 / 100) + 48);
        r170 = r170 % 100;
        r183 = r184 + 1;
        r411[r184] = (char) ((r170 / 10) + 48);
    L287:
        r102 = r183 + 1;
        r411[r183] = (char) ((r170 % 10) + r185);
        goto L6
    L284:
        r185 = 48;
        if (r170 < 10) goto L287;
        r411[r183] = (char) ((r170 / 10) + 48);
        r183 = r183 + 1;
        goto L287
    L288:
        char r186 = '0';
        if (r170 >= 0) goto L296;
        int r187 = r179 + 1;
        r411[r179] = '0';
        int r188 = r187 + 1;
        r411[r187] = '.';
        int r189 = -1;
    L291:
        if (r189 <= r170) goto L293;
        r411[r188] = r186;
        r189 = r189 - 1;
        r188 = r188 + 1;
        r186 = '0';
        goto L291
    L293:
        int r190 = r188;
        int r191 = 0;
    L294:
        if (r191 >= r178) goto L314;
        r411[((r188 + r178) - r191) - 1] = (char) ((r177 % 10) + 48);
        r177 = r177 / 10;
        r190 = r190 + 1;
        r191 = r191 + 1;
    L314:
        return r190 - r412;
    L296:
        int r192 = r170 + 1;
        if (r192 < r178) goto L305;
        int r193 = 0;
    L299:
        if (r193 >= r178) goto L301;
        r411[((r179 + r178) - r193) - 1] = (char) ((r177 % 10) + 48);
        r177 = r177 / 10;
        r193 = r193 + 1;
        goto L299
    L301:
        int r194 = r179 + r178;
    L302:
        if (r178 >= r192) goto L304;
        r411[r194] = '0';
        r178 = r178 + 1;
        r194 = r194 + 1;
        goto L302
    L304:
        int r195 = r194 + 1;
        r411[r194] = '.';
        r190 = r195 + 1;
        r411[r195] = '0';
        goto L314
    L305:
        int r196 = r179 + 1;
        int r197 = 0;
    L306:
        if (r197 >= r178) goto L312;
        if (((r178 - r197) - 1) != r170) goto L311;
        r411[((r196 + r178) - r197) - 1] = '.';
        r196 = r196 - 1;
    L311:
        r411[((r196 + r178) - r197) - 1] = (char) ((r177 % 10) + 48);
        r177 = r177 / 10;
        r197 = r197 + 1;
        goto L306
    L312:
        r190 = r179 + (r178 + 1);
        goto L314
    L269:
        r179 = r412;
    L223:
        r176 = 1;
    L225:
        boolean r198 = r167;
        boolean r199 = r166;
        int r200 = 0;
        int r201 = 0;
    L226:
        long r1100 = r213 / 10;
        long r1101 = r161 / 10;
        if (r1100 <= r1101) goto L241;
        if (r213 >= 100) goto L233;
        if (r171 == true) goto L241;
    L233:
        if ((r161 % 10) != 0) goto L235;
        boolean r202 = true;
    L236:
        r198 = r198 & r202;
        if (r200 != 0) goto L239;
        boolean r203 = true;
    L240:
        r199 = r199 & r203;
        r200 = (int) (r168 % 10);
        r168 = r168 / 10;
        r201 = r201 + 1;
        r213 = r1100;
        r161 = r1101;
        goto L226
    L239:
        r203 = false;
        goto L240
    L235:
        r202 = false;
    L241:
        if (r198 == false) goto L253;
        if (r311 == false) goto L253;
    L244:
        if ((r161 % 10) != 0) goto L253;
        if (r213 >= 100) goto L249;
        if (r171 == true) goto L253;
    L249:
        if (r200 != 0) goto L251;
        boolean r204 = true;
    L252:
        r199 = r199 & r204;
        r200 = (int) (r168 % 10);
        r213 = r213 / 10;
        r168 = r168 / 10;
        r161 = r161 / 10;
        r201 = r201 + 1;
        goto L244
    L251:
        r204 = false;
    L253:
        if (r199 == false) goto L259;
        if (r200 != 5) goto L259;
        if ((r168 % 2) != 0) goto L259;
        r200 = 4;
    L259:
        if (r168 != r161) goto L262;
        if (r198 == false) goto L263;
        if (r311 == true) goto L262;
    L263:
        int r205 = 1;
    L265:
        r177 = r168 + ((long) r205);
        r172 = r201;
    L262:
        if (r200 >= 5) goto L263;
        r205 = 0;
        goto L265
    L203:
        if (r170 >= 7) goto L206;
        r171 = false;
        goto L207
    L149:
        if (r213 < 100000000000000000L) goto L152;
        r169 = 18;
        goto L200
    L152:
        if (r213 < 10000000000000000L) goto L155;
        r169 = 17;
        goto L200
    L155:
        if (r213 < 1000000000000000L) goto L158;
        r169 = 16;
        goto L200
    L158:
        if (r213 < 100000000000000L) goto L161;
        r169 = 15;
        goto L200
    L161:
        if (r213 < 10000000000000L) goto L164;
        r169 = 14;
        goto L200
    L164:
        if (r213 < 1000000000000L) goto L167;
        r169 = 13;
        goto L200
    L167:
        if (r213 < 100000000000L) goto L170;
        r169 = 12;
        goto L200
    L170:
        if (r213 < 10000000000L) goto L173;
        r169 = 11;
        goto L200
    L173:
        if (r213 < C.NANOS_PER_SECOND) goto L176;
        r169 = 10;
        goto L200
    L176:
        if (r213 < 100000000) goto L179;
        r169 = 9;
        goto L200
    L179:
        if (r213 < StackLeakChecker.CHECK_INTERVAL_10_SEC) goto L182;
        r169 = 8;
        goto L200
    L182:
        if (r213 < 1000000) goto L185;
        r169 = 7;
        goto L200
    L185:
        if (r213 < 100000) goto L188;
        r169 = 6;
        goto L200
    L188:
        if (r213 < 10000) goto L191;
        r169 = 5;
        goto L200
    L191:
        if (r213 < 1000) goto L194;
        r169 = 4;
        goto L200
    L194:
        if (r213 < 100) goto L197;
        r169 = 3;
        goto L200
    L197:
        if (r213 < 10) goto L199;
        r169 = 2;
        goto L200
    L199:
        r169 = 1;
        goto L200
    L71:
        r165 = false;
        goto L72
    L54:
        if ((r130 % 25) == 0) goto L57;
        r164 = 1;
        goto L69
    L57:
        if ((r130 % 125) == 0) goto L60;
        r164 = 2;
        goto L69
    L60:
        if ((r130 % 625) == 0) goto L62;
        r164 = 3;
        goto L69
    L62:
        long r1102 = r130 / 625;
        r164 = 4;
    L64:
        if (r1102 <= r163) goto L69;
        if ((r1102 % 5) != r163) goto L69;
        r1102 = r1102 / 5;
        r164 = r164 + 1;
        r163 = 0;
        goto L64
    L73:
        if (r311 == false) goto L95;
        long r206 = 0;
        if ((r133 % 5) == 0) goto L78;
        int r207 = 0;
    L93:
        if (r207 < r152) goto L116;
        r167 = true;
    L117:
        r166 = false;
        goto L118
    L78:
        if ((r133 % 25) == 0) goto L81;
        r207 = 1;
        goto L93
    L81:
        if ((r133 % 125) == 0) goto L84;
        r207 = 2;
        goto L93
    L84:
        if ((r133 % 625) == 0) goto L86;
        r207 = 3;
        goto L93
    L86:
        long r1103 = r133 / 625;
        r207 = 4;
    L88:
        if (r1103 <= r206) goto L93;
        if ((r1103 % 5) != r206) goto L93;
        r1103 = r1103 / 5;
        r207 = r207 + 1;
        r206 = 0;
        goto L88
    L95:
        long r208 = 0;
        if ((r131 % 5) == 0) goto L99;
        int r209 = 0;
    L114:
        if (r209 < r152) goto L116;
        r213 = r213 - 1;
        goto L116
    L99:
        if ((r131 % 25) == 0) goto L102;
        r209 = 1;
        goto L114
    L102:
        if ((r131 % 125) == 0) goto L105;
        r209 = 2;
        goto L114
    L105:
        if ((r131 % 625) == 0) goto L107;
        r209 = 3;
        goto L114
    L107:
        long r1104 = r131 / 625;
        r209 = 4;
    L109:
        if (r1104 <= r208) goto L114;
        if ((r1104 % 5) != r208) goto L114;
        r1104 = r1104 / 5;
        r209 = r209 + 1;
        r208 = 0;
    L116:
        r167 = false;
        goto L117
    L120:
        throw new IllegalArgumentException("" + r137);
    L44:
        r136 = (int) ((((((long) r135) * 23219280) + StackLeakChecker.CHECK_INTERVAL_10_SEC) - 1) / StackLeakChecker.CHECK_INTERVAL_10_SEC);
        goto L45
    L121:
        r310 = r128;
        r311 = r129;
        int r214 = -r134;
        int r215 = Math.max(0, ((int) ((((long) r214) * 6989700) / StackLeakChecker.CHECK_INTERVAL_10_SEC)) - 1);
        int r216 = r214 - r215;
        if (r216 != 0) goto L124;
        int r217 = 1;
    L125:
        int r218 = ((r215 - (r217 + NetError.ERR_SOCKS_CONNECTION_HOST_UNREACHABLE)) - 93) - 21;
        if (r218 < 0) goto L316;
        int[] r219 = POW5_SPLIT[r216];
        long r220 = r130 >>> 31;
        long r221 = r130 & SieveCacheKt.NodeLinkMask;
        int r1105 = r219[0];
        long r1106 = ((long) r1105) * r220;
        int r222 = r219[1];
        long r223 = ((long) r222) * r220;
        int r224 = r132;
        int r225 = r219[2];
        long r1107 = ((long) r225) * r220;
        int r226 = r219[3];
        long r227 = r220 * ((long) r226);
        long r228 = ((((((((((((r221 * ((long) r226)) >>> 31) + (((long) r225) * r221)) + r227) >>> 31) + (((long) r222) * r221)) + r1107) >>> 31) + (((long) r1105) * r221)) + r223) >>> 21) + (r1106 << 10)) >>> r218;
        long r229 = r131 >>> 31;
        long r230 = r131 & SieveCacheKt.NodeLinkMask;
        long r231 = ((long) r1105) * r229;
        long r1108 = ((long) r222) * r229;
        r168 = r228;
        long r232 = ((long) r225) * r229;
        long r233 = r229 * ((long) r226);
        long r234 = ((((((((((((r230 * ((long) r226)) >>> 31) + (((long) r225) * r230)) + r233) >>> 31) + (((long) r222) * r230)) + r232) >>> 31) + (((long) r1105) * r230)) + r1108) >>> 21) + (r231 << 10)) >>> r218;
        long r235 = r133 >>> 31;
        long r236 = r133 & SieveCacheKt.NodeLinkMask;
        long r1109 = ((long) r1105) * r236;
        long r1110 = ((long) r222) * r235;
        long r237 = ((long) r222) * r236;
        long r238 = ((long) r225) * r235;
        long r239 = ((r236 * ((long) r226)) >>> 31) + (((long) r225) * r236);
        r161 = (((((((((r239 + (r235 * ((long) r226))) >>> 31) + r237) + r238) >>> 31) + r1109) + r1110) >>> 21) + ((((long) r1105) * r235) << 10)) >>> r218;
        r152 = r215 + r134;
        if (r215 > 1) goto L138;
        if (r311 == true) goto L131;
        r213 = r234 - 1;
        r167 = false;
    L136:
        r166 = true;
        goto L146
    L131:
        if (r224 != 1) goto L133;
        boolean r312 = true;
    L134:
        r213 = r234;
        r167 = r312;
        goto L136
    L133:
        r312 = false;
        goto L134
    L138:
        if (r215 < 63) goto L140;
        r213 = r234;
        r167 = false;
        r166 = false;
        goto L146
    L140:
        if ((r130 & ((1 << (r215 - 1)) - 1)) != 0) goto L142;
        boolean r240 = true;
    L143:
        r166 = r240;
        r213 = r234;
        r167 = false;
        goto L146
    L142:
        r240 = false;
        goto L143
    L316:
        throw new IllegalArgumentException("" + r218);
    L124:
        r217 = (int) ((((((long) r216) * 23219280) + StackLeakChecker.CHECK_INTERVAL_10_SEC) - 1) / StackLeakChecker.CHECK_INTERVAL_10_SEC);
    L38:
        r132 = 1;
        goto L39
    L32:
        r129 = false;
        goto L33
    L28:
        r128 = false;
        goto L30
    L24:
        r127 = (r125 - 1023) - 52;
        r126 = r126 | 4503599627370496L;
        goto L26
    }
}
