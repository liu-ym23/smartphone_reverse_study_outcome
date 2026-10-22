package auc;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static Bitmap a(Bitmap r310, int r311) {
        int r100 = r311;
        if (r100 >= 1) goto L6;
        return null;
    L6:
        int r110 = r310.getWidth();
        int r111 = r310.getHeight();
        int r112 = r110 * r111;
        int[] r113 = new int[r112];
        r310.getPixels(r113, 0, r110, 0, 0, r110, r111);
        int r101 = r110 - 1;
        int r102 = r111 - 1;
        int r103 = (r100 + r100) + 1;
        int[] r104 = new int[r112];
        int[] r105 = new int[r112];
        int[] r106 = new int[r112];
        int[] r107 = new int[Math.max(r110, r111)];
        int r108 = (r103 + 1) >> 1;
        int r109 = r108 * r108;
        int r114 = r109 * 256;
        int[] r115 = new int[r114];
        int r116 = 0;
    L7:
        if (r116 >= r114) goto L9;
        r115[r116] = r116 / r109;
        r116 = r116 + 1;
        goto L7
    L9:
        int[][] r117 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r103, 3});
        int r118 = r100 + 1;
        int r119 = 0;
        int r120 = 0;
        int r121 = 0;
    L10:
        if (r119 >= r111) goto L27;
        int r122 = -r100;
        int r210 = 0;
        int r211 = 0;
        int r212 = 0;
        int r213 = 0;
        int r214 = 0;
        int r215 = 0;
        int r216 = 0;
        int r217 = 0;
        int r218 = 0;
    L13:
        if (r122 > r100) goto L19;
        int r312 = r102;
        int r313 = r111;
        int r123 = r113[r120 + Math.min(r101, Math.max(r122, 0))];
        int[] r314 = r117[r122 + r100];
        r314[0] = (r123 & 16711680) >> 16;
        r314[1] = (r123 & 65280) >> 8;
        r314[2] = r123 & 255;
        int r124 = r118 - Math.abs(r122);
        int r315 = r314[0];
        r210 = r210 + (r315 * r124);
        int r125 = r314[1];
        r211 = r211 + (r125 * r124);
        int r316 = r314[2];
        r212 = r212 + (r124 * r316);
        if (r122 <= 0) goto L17;
        r216 = r216 + r315;
        r217 = r217 + r125;
        r218 = r218 + r316;
    L18:
        r122 = r122 + 1;
        r111 = r313;
        r102 = r312;
        goto L13
    L17:
        r213 = r213 + r315;
        r214 = r214 + r125;
        r215 = r215 + r316;
        goto L18
    L19:
        int r317 = r102;
        int r318 = r111;
        int r126 = r100;
        int r127 = 0;
    L20:
        if (r127 >= r110) goto L26;
        r104[r120] = r115[r210];
        r105[r120] = r115[r211];
        r106[r120] = r115[r212];
        int r219 = r210 - r213;
        int r220 = r211 - r214;
        int r221 = r212 - r215;
        int[] r128 = r117[((r126 - r100) + r103) % r103];
        int r222 = r213 - r128[0];
        int r223 = r214 - r128[1];
        int r224 = r215 - r128[2];
        if (r119 != 0) goto L25;
        r107[r127] = Math.min((r127 + r100) + 1, r101);
    L25:
        int r129 = r113[r121 + r107[r127]];
        int r319 = (r129 & 16711680) >> 16;
        r128[0] = r319;
        int r320 = (r129 & 65280) >> 8;
        r128[1] = r320;
        int r130 = r129 & 255;
        r128[2] = r130;
        int r225 = r216 + r319;
        int r226 = r217 + r320;
        int r227 = r218 + r130;
        r210 = r219 + r225;
        r211 = r220 + r226;
        r212 = r221 + r227;
        r126 = (r126 + 1) % r103;
        int[] r131 = r117[r126 % r103];
        int r321 = r131[0];
        r213 = r222 + r321;
        int r322 = r131[1];
        r214 = r223 + r322;
        int r132 = r131[2];
        r215 = r224 + r132;
        r216 = r225 - r321;
        r217 = r226 - r322;
        r218 = r227 - r132;
        r120 = r120 + 1;
        r127 = r127 + 1;
        r115 = r115;
        goto L20
    L26:
        r121 = r121 + r110;
        r119 = r119 + 1;
        r111 = r318;
        r102 = r317;
        goto L10
    L27:
        int r323 = r102;
        int r324 = r111;
        int[] r325 = r115;
        int r133 = 0;
    L28:
        if (r133 >= r110) goto L46;
        int r134 = -r100;
        int r135 = r134 * r110;
        int r136 = 0;
        int r137 = 0;
        int r138 = 0;
        int r139 = 0;
        int r140 = 0;
        int r228 = 0;
        int r229 = 0;
        int r230 = 0;
        int r231 = 0;
    L30:
        if (r134 > r100) goto L39;
        int[] r232 = r107;
        int r233 = Math.max(0, r135) + r133;
        int[] r234 = r117[r134 + r100];
        r234[0] = r104[r233];
        r234[1] = r105[r233];
        r234[2] = r106[r233];
        int r141 = r118 - Math.abs(r134);
        r136 = r136 + (r104[r233] * r141);
        r137 = r137 + (r105[r233] * r141);
        r138 = r138 + (r106[r233] * r141);
        if (r134 <= 0) goto L34;
        r229 = r229 + r234[0];
        r230 = r230 + r234[1];
        r231 = r231 + r234[2];
    L35:
        int r142 = r323;
        if (r134 >= r142) goto L38;
        r135 = r135 + r110;
    L38:
        r134 = r134 + 1;
        r323 = r142;
        r107 = r232;
        goto L30
    L34:
        r139 = r139 + r234[0];
        r140 = r140 + r234[1];
        r228 = r228 + r234[2];
        goto L35
    L39:
        int[] r235 = r107;
        int r143 = r323;
        int r236 = r100;
        int r237 = r133;
        int r144 = r324;
        int r145 = 0;
    L40:
        if (r145 >= r144) goto L45;
        r113[r237] = (((r113[r237] & (-16777216)) | (r325[r136] << 16)) | (r325[r137] << 8)) | r325[r138];
        int r146 = r136 - r139;
        int r147 = r137 - r140;
        int r148 = r138 - r228;
        int[] r238 = r117[((r236 - r100) + r103) % r103];
        int r149 = r139 - r238[0];
        int r150 = r140 - r238[1];
        int r239 = r228 - r238[2];
        if (r133 != 0) goto L44;
        r235[r145] = Math.min(r145 + r118, r143) * r110;
    L44:
        int r151 = r235[r145] + r133;
        int r240 = r104[r151];
        r238[0] = r240;
        int r326 = r105[r151];
        r238[1] = r326;
        int r152 = r106[r151];
        r238[2] = r152;
        int r241 = r229 + r240;
        int r242 = r230 + r326;
        int r243 = r231 + r152;
        r136 = r146 + r241;
        r137 = r147 + r242;
        r138 = r148 + r243;
        r236 = (r236 + 1) % r103;
        int[] r153 = r117[r236];
        int r244 = r153[0];
        r139 = r149 + r244;
        int r245 = r153[1];
        r140 = r150 + r245;
        int r154 = r153[2];
        r228 = r239 + r154;
        r229 = r241 - r244;
        r230 = r242 - r245;
        r231 = r243 - r154;
        r237 = r237 + r110;
        r145 = r145 + 1;
        r100 = r311;
        goto L40
    L45:
        r133 = r133 + 1;
        r100 = r311;
        r324 = r144;
        r323 = r143;
        r107 = r235;
        goto L28
    L46:
        r310.setPixels(r113, 0, r110, 0, 0, r110, r324);
        return r310;
    }
}
