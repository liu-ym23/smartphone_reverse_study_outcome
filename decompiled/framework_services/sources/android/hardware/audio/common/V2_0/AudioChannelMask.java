package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioChannelMask {
    public static final int COUNT_MAX = 30;
    public static final int INDEX_HDR = Integer.MIN_VALUE;
    public static final int INDEX_MASK_1 = -2147483647;
    public static final int INDEX_MASK_2 = -2147483645;
    public static final int INDEX_MASK_3 = -2147483641;
    public static final int INDEX_MASK_4 = -2147483633;
    public static final int INDEX_MASK_5 = -2147483617;
    public static final int INDEX_MASK_6 = -2147483585;
    public static final int INDEX_MASK_7 = -2147483521;
    public static final int INDEX_MASK_8 = -2147483393;
    public static final int INVALID = -1073741824;
    public static final int IN_6 = 252;
    public static final int IN_ALL = 65532;
    public static final int IN_BACK = 32;
    public static final int IN_BACK_PROCESSED = 512;
    public static final int IN_FRONT = 16;
    public static final int IN_FRONT_BACK = 48;
    public static final int IN_FRONT_PROCESSED = 256;
    public static final int IN_LEFT = 4;
    public static final int IN_LEFT_PROCESSED = 64;
    public static final int IN_MONO = 16;
    public static final int IN_PRESSURE = 1024;
    public static final int IN_RIGHT = 8;
    public static final int IN_RIGHT_PROCESSED = 128;
    public static final int IN_STEREO = 12;
    public static final int IN_VOICE_CALL_MONO = 49168;
    public static final int IN_VOICE_DNLINK = 32768;
    public static final int IN_VOICE_DNLINK_MONO = 32784;
    public static final int IN_VOICE_UPLINK = 16384;
    public static final int IN_VOICE_UPLINK_MONO = 16400;
    public static final int IN_X_AXIS = 2048;
    public static final int IN_Y_AXIS = 4096;
    public static final int IN_Z_AXIS = 8192;
    public static final int NONE = 0;
    public static final int OUT_2POINT1 = 11;
    public static final int OUT_5POINT1 = 63;
    public static final int OUT_5POINT1_BACK = 63;
    public static final int OUT_5POINT1_SIDE = 1551;
    public static final int OUT_6POINT1 = 319;
    public static final int OUT_7POINT1 = 1599;
    public static final int OUT_ALL = 262143;
    public static final int OUT_BACK_CENTER = 256;
    public static final int OUT_BACK_LEFT = 16;
    public static final int OUT_BACK_RIGHT = 32;
    public static final int OUT_FRONT_CENTER = 4;
    public static final int OUT_FRONT_LEFT = 1;
    public static final int OUT_FRONT_LEFT_OF_CENTER = 64;
    public static final int OUT_FRONT_RIGHT = 2;
    public static final int OUT_FRONT_RIGHT_OF_CENTER = 128;
    public static final int OUT_LOW_FREQUENCY = 8;
    public static final int OUT_MONO = 1;
    public static final int OUT_PENTA = 55;
    public static final int OUT_QUAD = 51;
    public static final int OUT_QUAD_BACK = 51;
    public static final int OUT_QUAD_SIDE = 1539;
    public static final int OUT_SIDE_LEFT = 512;
    public static final int OUT_SIDE_RIGHT = 1024;
    public static final int OUT_STEREO = 3;
    public static final int OUT_SURROUND = 263;
    public static final int OUT_TOP_BACK_CENTER = 65536;
    public static final int OUT_TOP_BACK_LEFT = 32768;
    public static final int OUT_TOP_BACK_RIGHT = 131072;
    public static final int OUT_TOP_CENTER = 2048;
    public static final int OUT_TOP_FRONT_CENTER = 8192;
    public static final int OUT_TOP_FRONT_LEFT = 4096;
    public static final int OUT_TOP_FRONT_RIGHT = 16384;
    public static final int REPRESENTATION_INDEX = 2;
    public static final int REPRESENTATION_POSITION = 0;

    public AudioChannelMask() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L7;
        return "REPRESENTATION_POSITION";
    L7:
        if (o != 2) goto L10;
        return "REPRESENTATION_INDEX";
    L10:
        if (o != 0) goto L14;
        return "NONE";
    L14:
        if (o != (-1073741824)) goto L18;
        return "INVALID";
    L18:
        if (o != 1) goto L21;
        return "OUT_FRONT_LEFT";
    L21:
        if (o != 2) goto L25;
        return "OUT_FRONT_RIGHT";
    L25:
        if (o != 4) goto L29;
        return "OUT_FRONT_CENTER";
    L29:
        if (o != 8) goto L33;
        return "OUT_LOW_FREQUENCY";
    L33:
        if (o != 16) goto L37;
        return "OUT_BACK_LEFT";
    L37:
        if (o != 32) goto L41;
        return "OUT_BACK_RIGHT";
    L41:
        if (o != 64) goto L45;
        return "OUT_FRONT_LEFT_OF_CENTER";
    L45:
        if (o != 128) goto L49;
        return "OUT_FRONT_RIGHT_OF_CENTER";
    L49:
        if (o != 256) goto L53;
        return "OUT_BACK_CENTER";
    L53:
        if (o != 512) goto L57;
        return "OUT_SIDE_LEFT";
    L57:
        if (o != 1024) goto L61;
        return "OUT_SIDE_RIGHT";
    L61:
        if (o != 2048) goto L65;
        return "OUT_TOP_CENTER";
    L65:
        if (o != 4096) goto L69;
        return "OUT_TOP_FRONT_LEFT";
    L69:
        if (o != 8192) goto L73;
        return "OUT_TOP_FRONT_CENTER";
    L73:
        if (o != 16384) goto L77;
        return "OUT_TOP_FRONT_RIGHT";
    L77:
        if (o != 32768) goto L81;
        return "OUT_TOP_BACK_LEFT";
    L81:
        if (o != 65536) goto L85;
        return "OUT_TOP_BACK_CENTER";
    L85:
        if (o != 131072) goto L88;
        return "OUT_TOP_BACK_RIGHT";
    L88:
        if (o != 1) goto L92;
        return "OUT_MONO";
    L92:
        if (o != 3) goto L96;
        return "OUT_STEREO";
    L96:
        if (o != 11) goto L100;
        return "OUT_2POINT1";
    L100:
        if (o != 51) goto L103;
        return "OUT_QUAD";
    L103:
        if (o != 51) goto L107;
        return "OUT_QUAD_BACK";
    L107:
        if (o != 1539) goto L111;
        return "OUT_QUAD_SIDE";
    L111:
        if (o != 263) goto L115;
        return "OUT_SURROUND";
    L115:
        if (o != 55) goto L119;
        return "OUT_PENTA";
    L119:
        if (o != 63) goto L122;
        return "OUT_5POINT1";
    L122:
        if (o != 63) goto L126;
        return "OUT_5POINT1_BACK";
    L126:
        if (o != 1551) goto L130;
        return "OUT_5POINT1_SIDE";
    L130:
        if (o != 319) goto L134;
        return "OUT_6POINT1";
    L134:
        if (o != 1599) goto L138;
        return "OUT_7POINT1";
    L138:
        if (o != 262143) goto L141;
        return "OUT_ALL";
    L141:
        if (o != 4) goto L144;
        return "IN_LEFT";
    L144:
        if (o != 8) goto L147;
        return "IN_RIGHT";
    L147:
        if (o != 16) goto L150;
        return "IN_FRONT";
    L150:
        if (o != 32) goto L153;
        return "IN_BACK";
    L153:
        if (o != 64) goto L156;
        return "IN_LEFT_PROCESSED";
    L156:
        if (o != 128) goto L159;
        return "IN_RIGHT_PROCESSED";
    L159:
        if (o != 256) goto L162;
        return "IN_FRONT_PROCESSED";
    L162:
        if (o != 512) goto L165;
        return "IN_BACK_PROCESSED";
    L165:
        if (o != 1024) goto L168;
        return "IN_PRESSURE";
    L168:
        if (o != 2048) goto L171;
        return "IN_X_AXIS";
    L171:
        if (o != 4096) goto L174;
        return "IN_Y_AXIS";
    L174:
        if (o != 8192) goto L177;
        return "IN_Z_AXIS";
    L177:
        if (o != 16384) goto L181;
        return "IN_VOICE_UPLINK";
    L181:
        if (o != 32768) goto L184;
        return "IN_VOICE_DNLINK";
    L184:
        if (o != 16) goto L188;
        return "IN_MONO";
    L188:
        if (o != 12) goto L192;
        return "IN_STEREO";
    L192:
        if (o != 48) goto L196;
        return "IN_FRONT_BACK";
    L196:
        if (o != 252) goto L200;
        return "IN_6";
    L200:
        if (o != 16400) goto L204;
        return "IN_VOICE_UPLINK_MONO";
    L204:
        if (o != 32784) goto L208;
        return "IN_VOICE_DNLINK_MONO";
    L208:
        if (o != 49168) goto L212;
        return "IN_VOICE_CALL_MONO";
    L212:
        if (o != 65532) goto L216;
        return "IN_ALL";
    L216:
        if (o != 30) goto L220;
        return "COUNT_MAX";
    L220:
        if (o != Integer.MIN_VALUE) goto L224;
        return "INDEX_HDR";
    L224:
        if (o != (-2147483647)) goto L228;
        return "INDEX_MASK_1";
    L228:
        if (o != (-2147483645)) goto L232;
        return "INDEX_MASK_2";
    L232:
        if (o != (-2147483641)) goto L236;
        return "INDEX_MASK_3";
    L236:
        if (o != (-2147483633)) goto L240;
        return "INDEX_MASK_4";
    L240:
        if (o != (-2147483617)) goto L244;
        return "INDEX_MASK_5";
    L244:
        if (o != (-2147483585)) goto L248;
        return "INDEX_MASK_6";
    L248:
        if (o != (-2147483521)) goto L252;
        return "INDEX_MASK_7";
    L252:
        if (o != (-2147483393)) goto L256;
        return "INDEX_MASK_8";
    L256:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("REPRESENTATION_POSITION");
        if ((o & 2) != 2) goto L5;
        list.add("REPRESENTATION_INDEX");
        flipped = 0 | 2;
    L5:
        list.add("NONE");
        if ((o & (-1073741824)) != (-1073741824)) goto L9;
        list.add("INVALID");
        flipped = flipped | (-1073741824);
    L9:
        if ((o & 1) != 1) goto L12;
        list.add("OUT_FRONT_LEFT");
        flipped = flipped | 1;
    L12:
        if ((o & 2) != 2) goto L15;
        list.add("OUT_FRONT_RIGHT");
        flipped = flipped | 2;
    L15:
        if ((o & 4) != 4) goto L18;
        list.add("OUT_FRONT_CENTER");
        flipped = flipped | 4;
    L18:
        if ((o & 8) != 8) goto L21;
        list.add("OUT_LOW_FREQUENCY");
        flipped = flipped | 8;
    L21:
        if ((o & 16) != 16) goto L24;
        list.add("OUT_BACK_LEFT");
        flipped = flipped | 16;
    L24:
        if ((o & 32) != 32) goto L27;
        list.add("OUT_BACK_RIGHT");
        flipped = flipped | 32;
    L27:
        if ((o & 64) != 64) goto L30;
        list.add("OUT_FRONT_LEFT_OF_CENTER");
        flipped = flipped | 64;
    L30:
        if ((o & 128) != 128) goto L33;
        list.add("OUT_FRONT_RIGHT_OF_CENTER");
        flipped = flipped | 128;
    L33:
        if ((o & 256) != 256) goto L36;
        list.add("OUT_BACK_CENTER");
        flipped = flipped | 256;
    L36:
        if ((o & 512) != 512) goto L39;
        list.add("OUT_SIDE_LEFT");
        flipped = flipped | 512;
    L39:
        if ((o & 1024) != 1024) goto L42;
        list.add("OUT_SIDE_RIGHT");
        flipped = flipped | 1024;
    L42:
        if ((o & 2048) != 2048) goto L45;
        list.add("OUT_TOP_CENTER");
        flipped = flipped | 2048;
    L45:
        if ((o & 4096) != 4096) goto L48;
        list.add("OUT_TOP_FRONT_LEFT");
        flipped = flipped | 4096;
    L48:
        if ((o & 8192) != 8192) goto L51;
        list.add("OUT_TOP_FRONT_CENTER");
        flipped = flipped | 8192;
    L51:
        if ((o & 16384) != 16384) goto L54;
        list.add("OUT_TOP_FRONT_RIGHT");
        flipped = flipped | 16384;
    L54:
        if ((o & 32768) != 32768) goto L57;
        list.add("OUT_TOP_BACK_LEFT");
        flipped = flipped | 32768;
    L57:
        if ((o & 65536) != 65536) goto L60;
        list.add("OUT_TOP_BACK_CENTER");
        flipped = flipped | 65536;
    L60:
        if ((o & 131072) != 131072) goto L63;
        list.add("OUT_TOP_BACK_RIGHT");
        flipped = flipped | 131072;
    L63:
        if ((o & 1) != 1) goto L66;
        list.add("OUT_MONO");
        flipped = flipped | 1;
    L66:
        if ((o & 3) != 3) goto L69;
        list.add("OUT_STEREO");
        flipped = flipped | 3;
    L69:
        if ((o & 11) != 11) goto L72;
        list.add("OUT_2POINT1");
        flipped = flipped | 11;
    L72:
        if ((o & 51) != 51) goto L75;
        list.add("OUT_QUAD");
        flipped = flipped | 51;
    L75:
        if ((o & 51) != 51) goto L78;
        list.add("OUT_QUAD_BACK");
        flipped = flipped | 51;
    L78:
        if ((o & 1539) != 1539) goto L81;
        list.add("OUT_QUAD_SIDE");
        flipped = flipped | 1539;
    L81:
        if ((o & 263) != 263) goto L84;
        list.add("OUT_SURROUND");
        flipped = flipped | 263;
    L84:
        if ((o & 55) != 55) goto L87;
        list.add("OUT_PENTA");
        flipped = flipped | 55;
    L87:
        if ((o & 63) != 63) goto L90;
        list.add("OUT_5POINT1");
        flipped = flipped | 63;
    L90:
        if ((o & 63) != 63) goto L93;
        list.add("OUT_5POINT1_BACK");
        flipped = flipped | 63;
    L93:
        if ((o & OUT_5POINT1_SIDE) != 1551) goto L96;
        list.add("OUT_5POINT1_SIDE");
        flipped = flipped | OUT_5POINT1_SIDE;
    L96:
        if ((o & 319) != 319) goto L99;
        list.add("OUT_6POINT1");
        flipped = flipped | 319;
    L99:
        if ((o & OUT_7POINT1) != 1599) goto L102;
        list.add("OUT_7POINT1");
        flipped = flipped | OUT_7POINT1;
    L102:
        if ((262143 & o) != 262143) goto L105;
        list.add("OUT_ALL");
        flipped = flipped | OUT_ALL;
    L105:
        if ((o & 4) != 4) goto L108;
        list.add("IN_LEFT");
        flipped = flipped | 4;
    L108:
        if ((o & 8) != 8) goto L111;
        list.add("IN_RIGHT");
        flipped = flipped | 8;
    L111:
        if ((o & 16) != 16) goto L114;
        list.add("IN_FRONT");
        flipped = flipped | 16;
    L114:
        if ((o & 32) != 32) goto L117;
        list.add("IN_BACK");
        flipped = flipped | 32;
    L117:
        if ((o & 64) != 64) goto L120;
        list.add("IN_LEFT_PROCESSED");
        flipped = flipped | 64;
    L120:
        if ((o & 128) != 128) goto L123;
        list.add("IN_RIGHT_PROCESSED");
        flipped = flipped | 128;
    L123:
        if ((o & 256) != 256) goto L126;
        list.add("IN_FRONT_PROCESSED");
        flipped = flipped | 256;
    L126:
        if ((o & 512) != 512) goto L129;
        list.add("IN_BACK_PROCESSED");
        flipped = flipped | 512;
    L129:
        if ((o & 1024) != 1024) goto L132;
        list.add("IN_PRESSURE");
        flipped = flipped | 1024;
    L132:
        if ((o & 2048) != 2048) goto L135;
        list.add("IN_X_AXIS");
        flipped = flipped | 2048;
    L135:
        if ((o & 4096) != 4096) goto L138;
        list.add("IN_Y_AXIS");
        flipped = flipped | 4096;
    L138:
        if ((o & 8192) != 8192) goto L141;
        list.add("IN_Z_AXIS");
        flipped = flipped | 8192;
    L141:
        if ((o & 16384) != 16384) goto L144;
        list.add("IN_VOICE_UPLINK");
        flipped = flipped | 16384;
    L144:
        if ((o & 32768) != 32768) goto L147;
        list.add("IN_VOICE_DNLINK");
        flipped = flipped | 32768;
    L147:
        if ((o & 16) != 16) goto L150;
        list.add("IN_MONO");
        flipped = flipped | 16;
    L150:
        if ((o & 12) != 12) goto L153;
        list.add("IN_STEREO");
        flipped = flipped | 12;
    L153:
        if ((o & 48) != 48) goto L156;
        list.add("IN_FRONT_BACK");
        flipped = flipped | 48;
    L156:
        if ((o & IN_6) != 252) goto L159;
        list.add("IN_6");
        flipped = flipped | IN_6;
    L159:
        if ((o & IN_VOICE_UPLINK_MONO) != 16400) goto L162;
        list.add("IN_VOICE_UPLINK_MONO");
        flipped = flipped | IN_VOICE_UPLINK_MONO;
    L162:
        if ((32784 & o) != 32784) goto L165;
        list.add("IN_VOICE_DNLINK_MONO");
        flipped = flipped | IN_VOICE_DNLINK_MONO;
    L165:
        if ((49168 & o) != 49168) goto L168;
        list.add("IN_VOICE_CALL_MONO");
        flipped = flipped | IN_VOICE_CALL_MONO;
    L168:
        if ((65532 & o) != 65532) goto L171;
        list.add("IN_ALL");
        flipped = flipped | IN_ALL;
    L171:
        if ((o & 30) != 30) goto L174;
        list.add("COUNT_MAX");
        flipped = flipped | 30;
    L174:
        if ((Integer.MIN_VALUE & o) != Integer.MIN_VALUE) goto L177;
        list.add("INDEX_HDR");
        flipped = flipped | Integer.MIN_VALUE;
    L177:
        if (((-2147483647) & o) != (-2147483647)) goto L180;
        list.add("INDEX_MASK_1");
        flipped = flipped | (-2147483647);
    L180:
        if (((-2147483645) & o) != (-2147483645)) goto L183;
        list.add("INDEX_MASK_2");
        flipped = flipped | INDEX_MASK_2;
    L183:
        if (((-2147483641) & o) != (-2147483641)) goto L186;
        list.add("INDEX_MASK_3");
        flipped = flipped | INDEX_MASK_3;
    L186:
        if (((-2147483633) & o) != (-2147483633)) goto L189;
        list.add("INDEX_MASK_4");
        flipped = flipped | INDEX_MASK_4;
    L189:
        if (((-2147483617) & o) != (-2147483617)) goto L192;
        list.add("INDEX_MASK_5");
        flipped = flipped | INDEX_MASK_5;
    L192:
        if (((-2147483585) & o) != (-2147483585)) goto L195;
        list.add("INDEX_MASK_6");
        flipped = flipped | INDEX_MASK_6;
    L195:
        if (((-2147483521) & o) != (-2147483521)) goto L198;
        list.add("INDEX_MASK_7");
        flipped = flipped | INDEX_MASK_7;
    L198:
        if (((-2147483393) & o) != (-2147483393)) goto L200;
        list.add("INDEX_MASK_8");
        flipped = flipped | INDEX_MASK_8;
    L200:
        if (o == flipped) goto L203;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L203:
        return String.join(" | ", list);
    }
}
