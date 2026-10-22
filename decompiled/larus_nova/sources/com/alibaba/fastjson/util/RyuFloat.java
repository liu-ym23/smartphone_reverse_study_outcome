package com.alibaba.fastjson.util;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.tencent.mm.opensdk.constants.Build;
import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes28.dex */
public final class RyuFloat {
    private static final int[][] POW5_INV_SPLIT = null;
    private static final int[][] POW5_SPLIT = null;

    public RyuFloat() {
    }

    static {
        POW5_SPLIT = new int[][]{new int[]{536870912, 0}, new int[]{Build.SUPPORT_SEND_MUSIC_VIDEO_MESSAGE, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{1000000000, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};
        POW5_INV_SPLIT = new int[][]{new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};
    }

    public static String toString(float r100) {
        char[] r101 = new char[15];
        return new String(r101, 0, toString(r100, r101, 0));
    }

    public static int toString(float r310, char[] r311, int r312) {
        if (Float.isNaN(r310) == false) goto L8;
        int r100 = r312 + 1;
        r311[r312] = 'N';
        int r101 = r100 + 1;
        r311[r100] = 'a';
        int r102 = r101 + 1;
        r311[r101] = 'N';
    L6:
        return r102 - r312;
    L8:
        if (r310 != Float.POSITIVE_INFINITY) goto L12;
        int r103 = r312 + 1;
        r311[r312] = 'I';
        int r104 = r103 + 1;
        r311[r103] = 'n';
        int r105 = r104 + 1;
        r311[r104] = 'f';
        int r106 = r105 + 1;
        r311[r105] = 'i';
        int r107 = r106 + 1;
        r311[r106] = 'n';
        int r108 = r107 + 1;
        r311[r107] = 'i';
        int r109 = r108 + 1;
        r311[r108] = OthersPermission.STICKY_E;
        r311[r109] = 'y';
        return (r109 + 1) - r312;
    L12:
        if (r310 != Float.NEGATIVE_INFINITY) goto L14;
        int r110 = r312 + 1;
        r311[r312] = '-';
        int r111 = r110 + 1;
        r311[r110] = 'I';
        int r112 = r111 + 1;
        r311[r111] = 'n';
        int r113 = r112 + 1;
        r311[r112] = 'f';
        int r114 = r113 + 1;
        r311[r113] = 'i';
        int r115 = r114 + 1;
        r311[r114] = 'n';
        int r116 = r115 + 1;
        r311[r115] = 'i';
        int r117 = r116 + 1;
        r311[r116] = OthersPermission.STICKY_E;
        r102 = r117 + 1;
        r311[r117] = 'y';
        goto L6
    L14:
        int r118 = Float.floatToIntBits(r310);
        if (r118 != 0) goto L18;
        int r119 = r312 + 1;
        r311[r312] = '0';
        int r120 = r119 + 1;
        r311[r119] = '.';
        r102 = r120 + 1;
        r311[r120] = '0';
        goto L6
    L18:
        if (r118 != Integer.MIN_VALUE) goto L21;
        int r121 = r312 + 1;
        r311[r312] = '-';
        int r122 = r121 + 1;
        r311[r121] = '0';
        int r123 = r122 + 1;
        r311[r122] = '.';
        r311[r123] = '0';
        return (r123 + 1) - r312;
    L21:
        int r124 = (r118 >> 23) & 255;
        int r125 = 8388607 & r118;
        if (r124 != 0) goto L24;
        int r126 = NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
    L26:
        if (r118 >= 0) goto L28;
        boolean r127 = true;
    L30:
        if ((r125 & 1) != 0) goto L32;
        boolean r128 = true;
    L33:
        int r129 = r125 * 4;
        int r130 = r129 + 2;
        if (r125 != 8388608) goto L38;
        if (r124 <= 1) goto L38;
        int r131 = 1;
    L39:
        int r132 = r129 - r131;
        int r133 = r126 - 2;
        if (r133 < 0) goto L83;
        int r134 = (int) ((((long) r133) * 3010299) / StackLeakChecker.CHECK_INTERVAL_10_SEC);
        if (r134 != 0) goto L44;
        int r135 = 1;
    L45:
        int r136 = (-r133) + r134;
        int[][] r137 = POW5_INV_SPLIT;
        int[] r138 = r137[r134];
        long r139 = r138[0];
        long r140 = r138[1];
        long r141 = r129;
        int r142 = (((r135 + 59) - 1) + r136) - 31;
        int r210 = r129;
        int r143 = (int) (((r141 * r139) + ((r141 * r140) >> 31)) >> r142);
        long r144 = r130;
        int r145 = (int) (((r144 * r139) + ((r144 * r140) >> 31)) >> r142);
        long r146 = r132;
        int r147 = (int) (((r139 * r146) + ((r146 * r140) >> 31)) >> r142);
        if (r134 != 0) goto L48;
    L54:
        int r148 = 0;
    L55:
        int r149 = 0;
    L56:
        if (r130 <= 0) goto L61;
        if ((r130 % 5) != 0) goto L61;
        r130 = r130 / 5;
        r149 = r149 + 1;
    L61:
        int r150 = 0;
    L62:
        if (r210 <= 0) goto L67;
        if ((r210 % 5) != 0) goto L67;
        r210 = r210 / 5;
        r150 = r150 + 1;
    L67:
        int r151 = 0;
    L68:
        if (r132 <= 0) goto L73;
        if ((r132 % 5) != 0) goto L73;
        r132 = r132 / 5;
        r151 = r151 + 1;
    L73:
        if (r149 < r134) goto L75;
        boolean r152 = true;
    L76:
        if (r150 < r134) goto L78;
        boolean r153 = true;
    L79:
        if (r151 < r134) goto L81;
        boolean r154 = true;
    L82:
        boolean r155 = r153;
        int r211 = r143;
        int r156 = 0;
    L115:
        int r157 = 1000000000;
        int r158 = 10;
    L116:
        if (r158 <= 0) goto L120;
        if (r145 >= r157) goto L120;
        r157 = r157 / 10;
        r158 = r158 - 1;
    L120:
        int r159 = (r134 + r158) - 1;
        if (r159 >= (-3)) goto L123;
    L126:
        boolean r160 = true;
    L127:
        if (r152 == false) goto L130;
        if (r128 == true) goto L130;
        r145 = r145 - 1;
    L130:
        int r161 = 0;
    L131:
        int r162 = r145 / 10;
        int r163 = r147 / 10;
        if (r162 <= r163) goto L142;
        if (r145 >= 100) goto L138;
        if (r160 == true) goto L142;
    L138:
        if ((r147 % 10) != 0) goto L140;
        boolean r164 = true;
    L141:
        r154 = r154 & r164;
        r148 = r211 % 10;
        r211 = r211 / 10;
        r161 = r161 + 1;
        r145 = r162;
        r147 = r163;
        goto L131
    L140:
        r164 = false;
    L142:
        if (r154 == false) goto L151;
        if (r128 == 0) goto L151;
    L145:
        if ((r147 % 10) != 0) goto L151;
        if (r145 >= 100) goto L150;
        if (r160 == true) goto L151;
    L150:
        r145 = r145 / 10;
        r148 = r211 % 10;
        r211 = r211 / 10;
        r147 = r147 / 10;
        r161 = r161 + 1;
    L151:
        int r165 = r211;
        if (r155 == false) goto L157;
        if (r148 != 5) goto L157;
        if ((r165 % 2) != 0) goto L157;
        r148 = 4;
    L157:
        if (r165 != r147) goto L160;
        if (r154 == false) goto L161;
        if (r128 != 0) goto L160;
    L161:
        int r166 = 1;
    L163:
        int r167 = r165 + r166;
        int r168 = r158 - r161;
        if (r127 == false) goto L166;
        int r169 = r312 + 1;
        r311[r312] = '-';
    L167:
        if (r160 == true) goto L169;
        int r170 = 48;
        if (r159 >= 0) goto L191;
        int r171 = r169 + 1;
        r311[r169] = '0';
        int r172 = r171 + 1;
        r311[r171] = '.';
        int r173 = -1;
    L185:
        if (r173 <= r159) goto L187;
        r311[r172] = '0';
        r173 = r173 - 1;
        r172 = r172 + 1;
        goto L185
    L187:
        int r174 = r172;
    L188:
        if (r156 >= r168) goto L190;
        r311[((r172 + r168) - r156) - 1] = (char) ((r167 % 10) + r170);
        r167 = r167 / 10;
        r174 = r174 + 1;
        r156 = r156 + 1;
        r170 = 48;
        goto L188
    L190:
        int r175 = r174;
    L208:
        return r175 - r312;
    L191:
        int r176 = r159 + 1;
        if (r176 < r168) goto L199;
    L193:
        if (r156 >= r168) goto L195;
        r311[((r169 + r168) - r156) - 1] = (char) ((r167 % 10) + 48);
        r167 = r167 / 10;
        r156 = r156 + 1;
        goto L193
    L195:
        int r177 = r169 + r168;
    L196:
        if (r168 >= r176) goto L198;
        r311[r177] = '0';
        r168 = r168 + 1;
        r177 = r177 + 1;
        goto L196
    L198:
        int r178 = r177 + 1;
        r311[r177] = '.';
        r175 = r178 + 1;
        r311[r178] = '0';
        goto L208
    L199:
        int r179 = r169 + 1;
    L200:
        if (r156 >= r168) goto L206;
        if (((r168 - r156) - 1) != r159) goto L205;
        r311[((r179 + r168) - r156) - 1] = '.';
        r179 = r179 - 1;
    L205:
        r311[((r179 + r168) - r156) - 1] = (char) ((r167 % 10) + 48);
        r167 = r167 / 10;
        r156 = r156 + 1;
        goto L200
    L206:
        r175 = r169 + (r168 + 1);
    L169:
        if (r156 >= (r168 - 1)) goto L171;
        int r180 = r167 % 10;
        r167 = r167 / 10;
        r311[(r169 + r168) - r156] = (char) (r180 + 48);
        r156 = r156 + 1;
        goto L169
    L171:
        r311[r169] = (char) ((r167 % 10) + 48);
        r311[r169 + 1] = '.';
        int r181 = r169 + (r168 + 1);
        if (r168 != 1) goto L174;
        r311[r181] = '0';
        r181 = r181 + 1;
    L174:
        int r182 = r181 + 1;
        r311[r181] = 'E';
        if (r159 >= 0) goto L178;
        r311[r182] = '-';
        r159 = -r159;
        r182 = r182 + 1;
    L178:
        if (r159 < 10) goto L180;
        int r183 = 48;
        r311[r182] = (char) ((r159 / 10) + 48);
        r182 = r182 + 1;
    L181:
        r175 = r182 + 1;
        r311[r182] = (char) ((r159 % 10) + r183);
        goto L208
    L180:
        r183 = 48;
        goto L181
    L166:
        r169 = r312;
    L160:
        if (r148 >= 5) goto L161;
        r166 = 0;
        goto L163
    L123:
        if (r159 >= 7) goto L126;
        r160 = false;
        goto L127
    L81:
        r154 = false;
        goto L82
    L78:
        r153 = false;
        goto L79
    L75:
        r152 = false;
        goto L76
    L48:
        if (((r145 - 1) / 10) > (r147 / 10)) goto L54;
        int r184 = r134 - 1;
        if (r184 != 0) goto L52;
        int r185 = 1;
    L53:
        int[] r186 = r137[r184];
        r148 = (int) ((((((long) r186[0]) * r141) + ((((long) r186[1]) * r141) >> 31)) >> (((r136 - 1) + ((r185 + 59) - 1)) - 31)) % 10);
        goto L55
    L52:
        r185 = (int) ((((((long) r184) * 23219280) + StackLeakChecker.CHECK_INTERVAL_10_SEC) - 1) / StackLeakChecker.CHECK_INTERVAL_10_SEC);
        goto L53
    L44:
        r135 = (int) ((((((long) r134) * 23219280) + StackLeakChecker.CHECK_INTERVAL_10_SEC) - 1) / StackLeakChecker.CHECK_INTERVAL_10_SEC);
        goto L45
    L83:
        int r187 = -r133;
        int r188 = (int) ((((long) r187) * 6989700) / StackLeakChecker.CHECK_INTERVAL_10_SEC);
        int r189 = r187 - r188;
        if (r189 != 0) goto L86;
        int r190 = 1;
    L87:
        int r191 = r188 - (r190 - 61);
        int[][] r192 = POW5_SPLIT;
        int[] r193 = r192[r189];
        long r194 = r193[0];
        long r195 = r193[1];
        int r196 = r191 - 31;
        long r197 = r129;
        r211 = (int) (((r197 * r194) + ((r197 * r195) >> 31)) >> r196);
        long r198 = r130;
        int r199 = (int) (((r198 * r194) + ((r198 * r195) >> 31)) >> r196);
        long r200 = r132;
        int r201 = (int) (((r194 * r200) + ((r200 * r195) >> 31)) >> r196);
        if (r188 != 0) goto L90;
    L96:
        r156 = 0;
        r148 = 0;
    L97:
        int r202 = r133 + r188;
        if (1 < r188) goto L100;
        boolean r203 = true;
    L102:
        if (r188 < 23) goto L104;
    L106:
        r155 = false;
    L108:
        if ((r132 % 2) != 1) goto L110;
        int r204 = 0;
    L111:
        if (r204 < r188) goto L113;
        boolean r205 = true;
    L114:
        r145 = r199;
        r134 = r202;
        r152 = r203;
        r154 = r205;
        r147 = r201;
        goto L115
    L113:
        r205 = false;
        goto L114
    L110:
        r204 = 1;
        goto L111
    L104:
        if ((((1 << (r188 - 1)) - 1) & r129) != 0) goto L106;
        r155 = true;
        goto L108
    L100:
        r203 = false;
        goto L102
    L90:
        if (((r199 - 1) / 10) > (r201 / 10)) goto L96;
        int r206 = r189 + 1;
        int r207 = r188 - 1;
        if (r206 != 0) goto L94;
        int r1100 = 1;
    L95:
        int[] r208 = r192[r206];
        r156 = 0;
        r148 = (int) ((((((long) r208[0]) * r197) + ((((long) r208[1]) * r197) >> 31)) >> ((r207 - (r1100 - 61)) - 31)) % 10);
        goto L97
    L94:
        r1100 = (int) ((((((long) r206) * 23219280) + StackLeakChecker.CHECK_INTERVAL_10_SEC) - 1) / StackLeakChecker.CHECK_INTERVAL_10_SEC);
        goto L95
    L86:
        r190 = (int) ((((((long) r189) * 23219280) + StackLeakChecker.CHECK_INTERVAL_10_SEC) - 1) / StackLeakChecker.CHECK_INTERVAL_10_SEC);
    L38:
        r131 = 2;
        goto L39
    L32:
        r128 = false;
        goto L33
    L28:
        r127 = false;
        goto L30
    L24:
        r126 = (r124 - 127) - 23;
        r125 = r125 | 8388608;
        goto L26
    }
}
