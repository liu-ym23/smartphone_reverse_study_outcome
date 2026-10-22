package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioDevice {
    public static final int BIT_DEFAULT = 1073741824;
    public static final int BIT_IN = Integer.MIN_VALUE;
    public static final int IN_ALL = -1021313025;
    public static final int IN_ALL_SCO = -2147483640;
    public static final int IN_ALL_USB = -2113923072;
    public static final int IN_AMBIENT = -2147483646;
    public static final int IN_ANLG_DOCK_HEADSET = -2147483136;
    public static final int IN_AUX_DIGITAL = -2147483616;
    public static final int IN_BACK_MIC = -2147483520;
    public static final int IN_BLUETOOTH_A2DP = -2147352576;
    public static final int IN_BLUETOOTH_SCO_HEADSET = -2147483640;
    public static final int IN_BUILTIN_MIC = -2147483644;
    public static final int IN_BUS = -2146435072;
    public static final int IN_COMMUNICATION = -2147483647;
    public static final int IN_DEFAULT = -1073741824;
    public static final int IN_DGTL_DOCK_HEADSET = -2147482624;
    public static final int IN_FM_TUNER = -2147475456;
    public static final int IN_HDMI = -2147483616;
    public static final int IN_IP = -2146959360;
    public static final int IN_LINE = -2147450880;
    public static final int IN_LOOPBACK = -2147221504;
    public static final int IN_PROXY = -2130706432;
    public static final int IN_REMOTE_SUBMIX = -2147483392;
    public static final int IN_SPDIF = -2147418112;
    public static final int IN_TELEPHONY_RX = -2147483584;
    public static final int IN_TV_TUNER = -2147467264;
    public static final int IN_USB_ACCESSORY = -2147481600;
    public static final int IN_USB_DEVICE = -2147479552;
    public static final int IN_USB_HEADSET = -2113929216;
    public static final int IN_VOICE_CALL = -2147483584;
    public static final int IN_WIRED_HEADSET = -2147483632;
    public static final int NONE = 0;
    public static final int OUT_ALL = 1207959551;
    public static final int OUT_ALL_A2DP = 896;
    public static final int OUT_ALL_SCO = 112;
    public static final int OUT_ALL_USB = 67133440;
    public static final int OUT_ANLG_DOCK_HEADSET = 2048;
    public static final int OUT_AUX_DIGITAL = 1024;
    public static final int OUT_AUX_LINE = 2097152;
    public static final int OUT_BLUETOOTH_A2DP = 128;
    public static final int OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
    public static final int OUT_BLUETOOTH_A2DP_SPEAKER = 512;
    public static final int OUT_BLUETOOTH_SCO = 16;
    public static final int OUT_BLUETOOTH_SCO_CARKIT = 64;
    public static final int OUT_BLUETOOTH_SCO_HEADSET = 32;
    public static final int OUT_BUS = 16777216;
    public static final int OUT_DEFAULT = 1073741824;
    public static final int OUT_DGTL_DOCK_HEADSET = 4096;
    public static final int OUT_EARPIECE = 1;
    public static final int OUT_FM = 1048576;
    public static final int OUT_HDMI = 1024;
    public static final int OUT_HDMI_ARC = 262144;
    public static final int OUT_IP = 8388608;
    public static final int OUT_LINE = 131072;
    public static final int OUT_PROXY = 33554432;
    public static final int OUT_REMOTE_SUBMIX = 32768;
    public static final int OUT_SPDIF = 524288;
    public static final int OUT_SPEAKER = 2;
    public static final int OUT_SPEAKER_SAFE = 4194304;
    public static final int OUT_TELEPHONY_TX = 65536;
    public static final int OUT_USB_ACCESSORY = 8192;
    public static final int OUT_USB_DEVICE = 16384;
    public static final int OUT_USB_HEADSET = 67108864;
    public static final int OUT_WIRED_HEADPHONE = 8;
    public static final int OUT_WIRED_HEADSET = 4;

    public AudioDevice() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "NONE";
    L6:
        if (o != Integer.MIN_VALUE) goto L10;
        return "BIT_IN";
    L10:
        if (o != 1073741824) goto L14;
        return "BIT_DEFAULT";
    L14:
        if (o != 1) goto L18;
        return "OUT_EARPIECE";
    L18:
        if (o != 2) goto L22;
        return "OUT_SPEAKER";
    L22:
        if (o != 4) goto L26;
        return "OUT_WIRED_HEADSET";
    L26:
        if (o != 8) goto L30;
        return "OUT_WIRED_HEADPHONE";
    L30:
        if (o != 16) goto L34;
        return "OUT_BLUETOOTH_SCO";
    L34:
        if (o != 32) goto L38;
        return "OUT_BLUETOOTH_SCO_HEADSET";
    L38:
        if (o != 64) goto L42;
        return "OUT_BLUETOOTH_SCO_CARKIT";
    L42:
        if (o != 128) goto L46;
        return "OUT_BLUETOOTH_A2DP";
    L46:
        if (o != 256) goto L50;
        return "OUT_BLUETOOTH_A2DP_HEADPHONES";
    L50:
        if (o != 512) goto L54;
        return "OUT_BLUETOOTH_A2DP_SPEAKER";
    L54:
        if (o != 1024) goto L57;
        return "OUT_AUX_DIGITAL";
    L57:
        if (o != 1024) goto L61;
        return "OUT_HDMI";
    L61:
        if (o != 2048) goto L65;
        return "OUT_ANLG_DOCK_HEADSET";
    L65:
        if (o != 4096) goto L69;
        return "OUT_DGTL_DOCK_HEADSET";
    L69:
        if (o != 8192) goto L73;
        return "OUT_USB_ACCESSORY";
    L73:
        if (o != 16384) goto L77;
        return "OUT_USB_DEVICE";
    L77:
        if (o != 32768) goto L81;
        return "OUT_REMOTE_SUBMIX";
    L81:
        if (o != 65536) goto L85;
        return "OUT_TELEPHONY_TX";
    L85:
        if (o != 131072) goto L89;
        return "OUT_LINE";
    L89:
        if (o != 262144) goto L93;
        return "OUT_HDMI_ARC";
    L93:
        if (o != 524288) goto L97;
        return "OUT_SPDIF";
    L97:
        if (o != 1048576) goto L101;
        return "OUT_FM";
    L101:
        if (o != 2097152) goto L105;
        return "OUT_AUX_LINE";
    L105:
        if (o != 4194304) goto L109;
        return "OUT_SPEAKER_SAFE";
    L109:
        if (o != 8388608) goto L113;
        return "OUT_IP";
    L113:
        if (o != 16777216) goto L117;
        return "OUT_BUS";
    L117:
        if (o != 33554432) goto L121;
        return "OUT_PROXY";
    L121:
        if (o != 67108864) goto L124;
        return "OUT_USB_HEADSET";
    L124:
        if (o != 1073741824) goto L128;
        return "OUT_DEFAULT";
    L128:
        if (o != 1207959551) goto L132;
        return "OUT_ALL";
    L132:
        if (o != 896) goto L136;
        return "OUT_ALL_A2DP";
    L136:
        if (o != 112) goto L140;
        return "OUT_ALL_SCO";
    L140:
        if (o != 67133440) goto L144;
        return "OUT_ALL_USB";
    L144:
        if (o != (-2147483647)) goto L148;
        return "IN_COMMUNICATION";
    L148:
        if (o != (-2147483646)) goto L152;
        return "IN_AMBIENT";
    L152:
        if (o != (-2147483644)) goto L156;
        return "IN_BUILTIN_MIC";
    L156:
        if (o != (-2147483640)) goto L160;
        return "IN_BLUETOOTH_SCO_HEADSET";
    L160:
        if (o != (-2147483632)) goto L164;
        return "IN_WIRED_HEADSET";
    L164:
        if (o != (-2147483616)) goto L167;
        return "IN_AUX_DIGITAL";
    L167:
        if (o != (-2147483616)) goto L171;
        return "IN_HDMI";
    L171:
        if (o != (-2147483584)) goto L174;
        return "IN_VOICE_CALL";
    L174:
        if (o != (-2147483584)) goto L178;
        return "IN_TELEPHONY_RX";
    L178:
        if (o != (-2147483520)) goto L182;
        return "IN_BACK_MIC";
    L182:
        if (o != (-2147483392)) goto L186;
        return "IN_REMOTE_SUBMIX";
    L186:
        if (o != (-2147483136)) goto L190;
        return "IN_ANLG_DOCK_HEADSET";
    L190:
        if (o != (-2147482624)) goto L194;
        return "IN_DGTL_DOCK_HEADSET";
    L194:
        if (o != (-2147481600)) goto L198;
        return "IN_USB_ACCESSORY";
    L198:
        if (o != (-2147479552)) goto L202;
        return "IN_USB_DEVICE";
    L202:
        if (o != (-2147475456)) goto L206;
        return "IN_FM_TUNER";
    L206:
        if (o != (-2147467264)) goto L210;
        return "IN_TV_TUNER";
    L210:
        if (o != (-2147450880)) goto L214;
        return "IN_LINE";
    L214:
        if (o != (-2147418112)) goto L218;
        return "IN_SPDIF";
    L218:
        if (o != (-2147352576)) goto L222;
        return "IN_BLUETOOTH_A2DP";
    L222:
        if (o != (-2147221504)) goto L226;
        return "IN_LOOPBACK";
    L226:
        if (o != (-2146959360)) goto L230;
        return "IN_IP";
    L230:
        if (o != (-2146435072)) goto L234;
        return "IN_BUS";
    L234:
        if (o != (-2130706432)) goto L238;
        return "IN_PROXY";
    L238:
        if (o != (-2113929216)) goto L242;
        return "IN_USB_HEADSET";
    L242:
        if (o != (-1073741824)) goto L246;
        return "IN_DEFAULT";
    L246:
        if (o != (-1021313025)) goto L249;
        return "IN_ALL";
    L249:
        if (o != (-2147483640)) goto L253;
        return "IN_ALL_SCO";
    L253:
        if (o != (-2113923072)) goto L257;
        return "IN_ALL_USB";
    L257:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("NONE");
        if ((o & Integer.MIN_VALUE) != Integer.MIN_VALUE) goto L6;
        list.add("BIT_IN");
        flipped = 0 | Integer.MIN_VALUE;
    L6:
        if ((o & 1073741824) != 1073741824) goto L9;
        list.add("BIT_DEFAULT");
        flipped = flipped | 1073741824;
    L9:
        if ((o & 1) != 1) goto L12;
        list.add("OUT_EARPIECE");
        flipped = flipped | 1;
    L12:
        if ((o & 2) != 2) goto L15;
        list.add("OUT_SPEAKER");
        flipped = flipped | 2;
    L15:
        if ((o & 4) != 4) goto L18;
        list.add("OUT_WIRED_HEADSET");
        flipped = flipped | 4;
    L18:
        if ((o & 8) != 8) goto L21;
        list.add("OUT_WIRED_HEADPHONE");
        flipped = flipped | 8;
    L21:
        if ((o & 16) != 16) goto L24;
        list.add("OUT_BLUETOOTH_SCO");
        flipped = flipped | 16;
    L24:
        if ((o & 32) != 32) goto L27;
        list.add("OUT_BLUETOOTH_SCO_HEADSET");
        flipped = flipped | 32;
    L27:
        if ((o & 64) != 64) goto L30;
        list.add("OUT_BLUETOOTH_SCO_CARKIT");
        flipped = flipped | 64;
    L30:
        if ((o & 128) != 128) goto L33;
        list.add("OUT_BLUETOOTH_A2DP");
        flipped = flipped | 128;
    L33:
        if ((o & 256) != 256) goto L36;
        list.add("OUT_BLUETOOTH_A2DP_HEADPHONES");
        flipped = flipped | 256;
    L36:
        if ((o & 512) != 512) goto L39;
        list.add("OUT_BLUETOOTH_A2DP_SPEAKER");
        flipped = flipped | 512;
    L39:
        if ((o & 1024) != 1024) goto L42;
        list.add("OUT_AUX_DIGITAL");
        flipped = flipped | 1024;
    L42:
        if ((o & 1024) != 1024) goto L45;
        list.add("OUT_HDMI");
        flipped = flipped | 1024;
    L45:
        if ((o & 2048) != 2048) goto L48;
        list.add("OUT_ANLG_DOCK_HEADSET");
        flipped = flipped | 2048;
    L48:
        if ((o & 4096) != 4096) goto L51;
        list.add("OUT_DGTL_DOCK_HEADSET");
        flipped = flipped | 4096;
    L51:
        if ((o & 8192) != 8192) goto L54;
        list.add("OUT_USB_ACCESSORY");
        flipped = flipped | 8192;
    L54:
        if ((o & 16384) != 16384) goto L57;
        list.add("OUT_USB_DEVICE");
        flipped = flipped | 16384;
    L57:
        if ((o & 32768) != 32768) goto L60;
        list.add("OUT_REMOTE_SUBMIX");
        flipped = flipped | 32768;
    L60:
        if ((o & 65536) != 65536) goto L63;
        list.add("OUT_TELEPHONY_TX");
        flipped = flipped | 65536;
    L63:
        if ((131072 & o) != 131072) goto L66;
        list.add("OUT_LINE");
        flipped = flipped | 131072;
    L66:
        if ((262144 & o) != 262144) goto L69;
        list.add("OUT_HDMI_ARC");
        flipped = flipped | 262144;
    L69:
        if ((524288 & o) != 524288) goto L72;
        list.add("OUT_SPDIF");
        flipped = flipped | 524288;
    L72:
        if ((1048576 & o) != 1048576) goto L75;
        list.add("OUT_FM");
        flipped = flipped | 1048576;
    L75:
        if ((2097152 & o) != 2097152) goto L78;
        list.add("OUT_AUX_LINE");
        flipped = flipped | 2097152;
    L78:
        if ((4194304 & o) != 4194304) goto L81;
        list.add("OUT_SPEAKER_SAFE");
        flipped = flipped | 4194304;
    L81:
        if ((8388608 & o) != 8388608) goto L84;
        list.add("OUT_IP");
        flipped = flipped | 8388608;
    L84:
        if ((16777216 & o) != 16777216) goto L87;
        list.add("OUT_BUS");
        flipped = flipped | 16777216;
    L87:
        if ((33554432 & o) != 33554432) goto L90;
        list.add("OUT_PROXY");
        flipped = flipped | 33554432;
    L90:
        if ((67108864 & o) != 67108864) goto L93;
        list.add("OUT_USB_HEADSET");
        flipped = flipped | 67108864;
    L93:
        if ((o & 1073741824) != 1073741824) goto L96;
        list.add("OUT_DEFAULT");
        flipped = flipped | 1073741824;
    L96:
        if ((1207959551 & o) != 1207959551) goto L99;
        list.add("OUT_ALL");
        flipped = flipped | OUT_ALL;
    L99:
        if ((o & OUT_ALL_A2DP) != 896) goto L102;
        list.add("OUT_ALL_A2DP");
        flipped = flipped | OUT_ALL_A2DP;
    L102:
        if ((o & 112) != 112) goto L105;
        list.add("OUT_ALL_SCO");
        flipped = flipped | 112;
    L105:
        if ((67133440 & o) != 67133440) goto L108;
        list.add("OUT_ALL_USB");
        flipped = flipped | OUT_ALL_USB;
    L108:
        if (((-2147483647) & o) != (-2147483647)) goto L111;
        list.add("IN_COMMUNICATION");
        flipped = flipped | (-2147483647);
    L111:
        if (((-2147483646) & o) != (-2147483646)) goto L114;
        list.add("IN_AMBIENT");
        flipped = flipped | IN_AMBIENT;
    L114:
        if (((-2147483644) & o) != (-2147483644)) goto L117;
        list.add("IN_BUILTIN_MIC");
        flipped = flipped | IN_BUILTIN_MIC;
    L117:
        if ((o & (-2147483640)) != (-2147483640)) goto L120;
        list.add("IN_BLUETOOTH_SCO_HEADSET");
        flipped = flipped | (-2147483640);
    L120:
        if (((-2147483632) & o) != (-2147483632)) goto L123;
        list.add("IN_WIRED_HEADSET");
        flipped = flipped | IN_WIRED_HEADSET;
    L123:
        if ((o & (-2147483616)) != (-2147483616)) goto L126;
        list.add("IN_AUX_DIGITAL");
        flipped = flipped | (-2147483616);
    L126:
        if ((o & (-2147483616)) != (-2147483616)) goto L129;
        list.add("IN_HDMI");
        flipped = flipped | (-2147483616);
    L129:
        if ((o & (-2147483584)) != (-2147483584)) goto L132;
        list.add("IN_VOICE_CALL");
        flipped = flipped | (-2147483584);
    L132:
        if ((o & (-2147483584)) != (-2147483584)) goto L135;
        list.add("IN_TELEPHONY_RX");
        flipped = flipped | (-2147483584);
    L135:
        if (((-2147483520) & o) != (-2147483520)) goto L138;
        list.add("IN_BACK_MIC");
        flipped = flipped | IN_BACK_MIC;
    L138:
        if (((-2147483392) & o) != (-2147483392)) goto L141;
        list.add("IN_REMOTE_SUBMIX");
        flipped = flipped | IN_REMOTE_SUBMIX;
    L141:
        if (((-2147483136) & o) != (-2147483136)) goto L144;
        list.add("IN_ANLG_DOCK_HEADSET");
        flipped = flipped | IN_ANLG_DOCK_HEADSET;
    L144:
        if (((-2147482624) & o) != (-2147482624)) goto L147;
        list.add("IN_DGTL_DOCK_HEADSET");
        flipped = flipped | IN_DGTL_DOCK_HEADSET;
    L147:
        if (((-2147481600) & o) != (-2147481600)) goto L150;
        list.add("IN_USB_ACCESSORY");
        flipped = flipped | IN_USB_ACCESSORY;
    L150:
        if (((-2147479552) & o) != (-2147479552)) goto L153;
        list.add("IN_USB_DEVICE");
        flipped = flipped | IN_USB_DEVICE;
    L153:
        if (((-2147475456) & o) != (-2147475456)) goto L156;
        list.add("IN_FM_TUNER");
        flipped = flipped | IN_FM_TUNER;
    L156:
        if (((-2147467264) & o) != (-2147467264)) goto L159;
        list.add("IN_TV_TUNER");
        flipped = flipped | IN_TV_TUNER;
    L159:
        if (((-2147450880) & o) != (-2147450880)) goto L162;
        list.add("IN_LINE");
        flipped = flipped | IN_LINE;
    L162:
        if (((-2147418112) & o) != (-2147418112)) goto L165;
        list.add("IN_SPDIF");
        flipped = flipped | IN_SPDIF;
    L165:
        if (((-2147352576) & o) != (-2147352576)) goto L168;
        list.add("IN_BLUETOOTH_A2DP");
        flipped = flipped | IN_BLUETOOTH_A2DP;
    L168:
        if (((-2147221504) & o) != (-2147221504)) goto L171;
        list.add("IN_LOOPBACK");
        flipped = flipped | IN_LOOPBACK;
    L171:
        if (((-2146959360) & o) != (-2146959360)) goto L174;
        list.add("IN_IP");
        flipped = flipped | IN_IP;
    L174:
        if (((-2146435072) & o) != (-2146435072)) goto L177;
        list.add("IN_BUS");
        flipped = flipped | IN_BUS;
    L177:
        if (((-2130706432) & o) != (-2130706432)) goto L180;
        list.add("IN_PROXY");
        flipped = flipped | IN_PROXY;
    L180:
        if (((-2113929216) & o) != (-2113929216)) goto L183;
        list.add("IN_USB_HEADSET");
        flipped = flipped | IN_USB_HEADSET;
    L183:
        if (((-1073741824) & o) != (-1073741824)) goto L186;
        list.add("IN_DEFAULT");
        flipped = flipped | (-1073741824);
    L186:
        if (((-1021313025) & o) != (-1021313025)) goto L189;
        list.add("IN_ALL");
        flipped = flipped | IN_ALL;
    L189:
        if ((o & (-2147483640)) != (-2147483640)) goto L192;
        list.add("IN_ALL_SCO");
        flipped = flipped | (-2147483640);
    L192:
        if (((-2113923072) & o) != (-2113923072)) goto L194;
        list.add("IN_ALL_USB");
        flipped = flipped | IN_ALL_USB;
    L194:
        if (o == flipped) goto L197;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L197:
        return String.join(" | ", list);
    }
}
