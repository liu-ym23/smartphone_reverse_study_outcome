package com.bytedance.android.ui.ec.widget.tools;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes14.dex */
public class BlurImage {
    private static final int DEFAULT_STEUP = 10;
    private static final String TAG = "BlurImage";

    public BlurImage() {
    }

    public static void blur(Bitmap r310, Bitmap r311, int r312) {
        int r100 = r312;
        if (r100 >= 1) goto L5;
        return;
    L5:
        int r110 = r311.getWidth();
        int r111 = r311.getHeight();
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
    L6:
        if (r116 >= r114) goto L10;
        if (r109 == 0) goto L9;
        r115[r116] = r116 / r109;
    L9:
        r116 = r116 + 1;
        goto L6
    L10:
        int[][] r117 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r103, 3});
        int r118 = r100 + 1;
        int r119 = 0;
        int r120 = 0;
        int r121 = 0;
    L11:
        if (r119 >= r111) goto L28;
        int r210 = r111;
        int r211 = 0;
        int r212 = 0;
        int r213 = 0;
        int r214 = 0;
        int r215 = 0;
        int r216 = 0;
        int r217 = 0;
        int r218 = 0;
        int r122 = -r100;
        int r123 = 0;
    L14:
        if (r122 > r100) goto L20;
        int r313 = r102;
        int[] r314 = r107;
        int r124 = r113[r120 + Math.min(r101, Math.max(r122, 0))];
        int[] r315 = r117[r122 + r100];
        r315[0] = (r124 & 16711680) >> 16;
        r315[1] = (r124 & 65280) >> 8;
        r315[2] = r124 & 255;
        int r125 = r118 - Math.abs(r122);
        int r219 = r315[0];
        r123 = r123 + (r219 * r125);
        int r126 = r315[1];
        r211 = r211 + (r126 * r125);
        int r316 = r315[2];
        r212 = r212 + (r125 * r316);
        if (r122 <= 0) goto L18;
        r216 = r216 + r219;
        r217 = r217 + r126;
        r218 = r218 + r316;
    L19:
        r122 = r122 + 1;
        r102 = r313;
        r107 = r314;
        goto L14
    L18:
        r213 = r213 + r219;
        r214 = r214 + r126;
        r215 = r215 + r316;
        goto L19
    L20:
        int r317 = r102;
        int[] r318 = r107;
        int r127 = r100;
        int r128 = r123;
        int r129 = 0;
    L21:
        if (r129 >= r110) goto L27;
        r104[r120] = r115[r128];
        r105[r120] = r115[r211];
        r106[r120] = r115[r212];
        int r130 = r128 - r213;
        int r220 = r211 - r214;
        int r221 = r212 - r215;
        int[] r131 = r117[((r127 - r100) + r103) % r103];
        int r222 = r213 - r131[0];
        int r223 = r214 - r131[1];
        int r224 = r215 - r131[2];
        if (r119 != 0) goto L26;
        r318[r129] = Math.min((r129 + r100) + 1, r101);
    L26:
        int r132 = r113[r121 + r318[r129]];
        int r319 = (r132 & 16711680) >> 16;
        r131[0] = r319;
        int r320 = (r132 & 65280) >> 8;
        r131[1] = r320;
        int r133 = r132 & 255;
        r131[2] = r133;
        int r225 = r216 + r319;
        int r226 = r217 + r320;
        int r227 = r218 + r133;
        r128 = r130 + r225;
        r211 = r220 + r226;
        r212 = r221 + r227;
        r127 = (r127 + 1) % r103;
        int[] r134 = r117[r127 % r103];
        int r321 = r134[0];
        r213 = r222 + r321;
        int r322 = r134[1];
        r214 = r223 + r322;
        int r135 = r134[2];
        r215 = r224 + r135;
        r216 = r225 - r321;
        r217 = r226 - r322;
        r218 = r227 - r135;
        r120 = r120 + 1;
        r129 = r129 + 1;
        r115 = r115;
        goto L21
    L27:
        r121 = r121 + r110;
        r119 = r119 + 1;
        r111 = r210;
        r102 = r317;
        r107 = r318;
        goto L11
    L28:
        int r323 = r102;
        int[] r324 = r107;
        int r228 = r111;
        int[] r325 = r115;
        int r136 = 0;
    L29:
        if (r136 >= r110) goto L47;
        int r137 = -r100;
        int r229 = r103;
        int[] r230 = r113;
        int r138 = 0;
        int r139 = 0;
        int r140 = 0;
        int r141 = 0;
        int r142 = 0;
        int r143 = 0;
        int r231 = 0;
        int r144 = r137;
        int r145 = r137 * r110;
        int r146 = 0;
        int r147 = 0;
    L31:
        if (r144 > r100) goto L40;
        int r232 = r110;
        int r233 = Math.max(0, r145) + r136;
        int[] r234 = r117[r144 + r100];
        r234[0] = r104[r233];
        r234[1] = r105[r233];
        r234[2] = r106[r233];
        int r148 = r118 - Math.abs(r144);
        r146 = r146 + (r104[r233] * r148);
        r147 = r147 + (r105[r233] * r148);
        r138 = r138 + (r106[r233] * r148);
        if (r144 <= 0) goto L35;
        r142 = r142 + r234[0];
        r143 = r143 + r234[1];
        r231 = r231 + r234[2];
    L36:
        int r149 = r323;
        if (r144 >= r149) goto L39;
        r145 = r145 + r232;
    L39:
        r144 = r144 + 1;
        r323 = r149;
        r110 = r232;
        goto L31
    L35:
        r139 = r139 + r234[0];
        r140 = r140 + r234[1];
        r141 = r141 + r234[2];
        goto L36
    L40:
        int r235 = r110;
        int r150 = r323;
        int r236 = r100;
        int r237 = r136;
        int r151 = r228;
        int r152 = 0;
    L41:
        if (r152 >= r151) goto L46;
        r230[r237] = (((r230[r237] & (-16777216)) | (r325[r146] << 16)) | (r325[r147] << 8)) | r325[r138];
        int r153 = r146 - r139;
        int r154 = r147 - r140;
        int r155 = r138 - r141;
        int[] r238 = r117[((r236 - r100) + r229) % r229];
        int r156 = r139 - r238[0];
        int r157 = r140 - r238[1];
        int r158 = r141 - r238[2];
        if (r136 != 0) goto L45;
        r324[r152] = Math.min(r152 + r118, r150) * r235;
    L45:
        int r159 = r324[r152] + r136;
        int r239 = r104[r159];
        r238[0] = r239;
        int r240 = r105[r159];
        r238[1] = r240;
        int r160 = r106[r159];
        r238[2] = r160;
        int r161 = r142 + r239;
        int r162 = r143 + r240;
        int r241 = r231 + r160;
        r146 = r153 + r161;
        r147 = r154 + r162;
        r138 = r155 + r241;
        r236 = (r236 + 1) % r229;
        int[] r163 = r117[r236];
        int r242 = r163[0];
        r139 = r156 + r242;
        int r243 = r163[1];
        r140 = r157 + r243;
        int r164 = r163[2];
        r141 = r158 + r164;
        r142 = r161 - r242;
        r143 = r162 - r243;
        r231 = r241 - r164;
        r237 = r237 + r235;
        r152 = r152 + 1;
        r100 = r312;
        goto L41
    L46:
        r136 = r136 + 1;
        r100 = r312;
        r323 = r150;
        r228 = r151;
        r103 = r229;
        r113 = r230;
        r110 = r235;
        goto L29
    L47:
        int r244 = r110;
        r311.setPixels(r113, 0, r244, 0, 0, r244, r228);
    }
}
