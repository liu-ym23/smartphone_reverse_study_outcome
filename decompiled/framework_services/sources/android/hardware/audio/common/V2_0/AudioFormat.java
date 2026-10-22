package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioFormat {
    public static final int AAC = 67108864;
    public static final int AAC_ADIF = 335544320;
    public static final int AAC_ADTS = 503316480;
    public static final int AAC_ADTS_ELD = 503316992;
    public static final int AAC_ADTS_ERLC = 503316544;
    public static final int AAC_ADTS_HE_V1 = 503316496;
    public static final int AAC_ADTS_HE_V2 = 503316736;
    public static final int AAC_ADTS_LC = 503316482;
    public static final int AAC_ADTS_LD = 503316608;
    public static final int AAC_ADTS_LTP = 503316488;
    public static final int AAC_ADTS_MAIN = 503316481;
    public static final int AAC_ADTS_SCALABLE = 503316512;
    public static final int AAC_ADTS_SSR = 503316484;
    public static final int AAC_ELD = 67109376;
    public static final int AAC_ERLC = 67108928;
    public static final int AAC_HE_V1 = 67108880;
    public static final int AAC_HE_V2 = 67109120;
    public static final int AAC_LC = 67108866;
    public static final int AAC_LD = 67108992;
    public static final int AAC_LTP = 67108872;
    public static final int AAC_MAIN = 67108865;
    public static final int AAC_SCALABLE = 67108896;
    public static final int AAC_SSR = 67108868;
    public static final int AAC_SUB_ELD = 512;
    public static final int AAC_SUB_ERLC = 64;
    public static final int AAC_SUB_HE_V1 = 16;
    public static final int AAC_SUB_HE_V2 = 256;
    public static final int AAC_SUB_LC = 2;
    public static final int AAC_SUB_LD = 128;
    public static final int AAC_SUB_LTP = 8;
    public static final int AAC_SUB_MAIN = 1;
    public static final int AAC_SUB_SCALABLE = 32;
    public static final int AAC_SUB_SSR = 4;
    public static final int AC3 = 150994944;
    public static final int AC4 = 570425344;
    public static final int ALAC = 469762048;
    public static final int AMR_NB = 33554432;
    public static final int AMR_SUB_NONE = 0;
    public static final int AMR_WB = 50331648;
    public static final int AMR_WB_PLUS = 385875968;
    public static final int APE = 486539264;
    public static final int APTX = 536870912;
    public static final int APTX_HD = 553648128;
    public static final int DEFAULT = 0;
    public static final int DOLBY_TRUEHD = 234881024;
    public static final int DSD = 436207616;
    public static final int DTS = 184549376;
    public static final int DTS_HD = 201326592;
    public static final int EVRC = 268435456;
    public static final int EVRCB = 285212672;
    public static final int EVRCNW = 318767104;
    public static final int EVRCWB = 301989888;
    public static final int E_AC3 = 167772160;
    public static final int FLAC = 452984832;
    public static final int HE_AAC_V1 = 83886080;
    public static final int HE_AAC_V2 = 100663296;
    public static final int IEC61937 = 218103808;
    public static final int INVALID = -1;
    public static final int LDAC = 587202560;
    public static final int MAIN_MASK = -16777216;
    public static final int MP2 = 402653184;
    public static final int MP3 = 16777216;
    public static final int MP3_SUB_NONE = 0;
    public static final int OPUS = 134217728;
    public static final int PCM = 0;
    public static final int PCM_16_BIT = 1;
    public static final int PCM_24_BIT_PACKED = 6;
    public static final int PCM_32_BIT = 3;
    public static final int PCM_8_24_BIT = 4;
    public static final int PCM_8_BIT = 2;
    public static final int PCM_FLOAT = 5;
    public static final int PCM_SUB_16_BIT = 1;
    public static final int PCM_SUB_24_BIT_PACKED = 6;
    public static final int PCM_SUB_32_BIT = 3;
    public static final int PCM_SUB_8_24_BIT = 4;
    public static final int PCM_SUB_8_BIT = 2;
    public static final int PCM_SUB_FLOAT = 5;
    public static final int QCELP = 419430400;
    public static final int SBC = 520093696;
    public static final int SUB_MASK = 16777215;
    public static final int VORBIS = 117440512;
    public static final int VORBIS_SUB_NONE = 0;
    public static final int WMA = 352321536;
    public static final int WMA_PRO = 369098752;

    public AudioFormat() {
    }

    public static final String toString(int o) {
        if (o != (-1)) goto L6;
        return "INVALID";
    L6:
        if (o != 0) goto L9;
        return "DEFAULT";
    L9:
        if (o != 0) goto L13;
        return "PCM";
    L13:
        if (o != 16777216) goto L17;
        return "MP3";
    L17:
        if (o != 33554432) goto L21;
        return "AMR_NB";
    L21:
        if (o != 50331648) goto L25;
        return "AMR_WB";
    L25:
        if (o != 67108864) goto L29;
        return "AAC";
    L29:
        if (o != 83886080) goto L33;
        return "HE_AAC_V1";
    L33:
        if (o != 100663296) goto L37;
        return "HE_AAC_V2";
    L37:
        if (o != 117440512) goto L41;
        return "VORBIS";
    L41:
        if (o != 134217728) goto L45;
        return "OPUS";
    L45:
        if (o != 150994944) goto L49;
        return "AC3";
    L49:
        if (o != 167772160) goto L53;
        return "E_AC3";
    L53:
        if (o != 184549376) goto L57;
        return "DTS";
    L57:
        if (o != 201326592) goto L61;
        return "DTS_HD";
    L61:
        if (o != 218103808) goto L65;
        return "IEC61937";
    L65:
        if (o != 234881024) goto L69;
        return "DOLBY_TRUEHD";
    L69:
        if (o != 268435456) goto L73;
        return "EVRC";
    L73:
        if (o != 285212672) goto L77;
        return "EVRCB";
    L77:
        if (o != 301989888) goto L81;
        return "EVRCWB";
    L81:
        if (o != 318767104) goto L85;
        return "EVRCNW";
    L85:
        if (o != 335544320) goto L89;
        return "AAC_ADIF";
    L89:
        if (o != 352321536) goto L93;
        return "WMA";
    L93:
        if (o != 369098752) goto L97;
        return "WMA_PRO";
    L97:
        if (o != 385875968) goto L101;
        return "AMR_WB_PLUS";
    L101:
        if (o != 402653184) goto L105;
        return "MP2";
    L105:
        if (o != 419430400) goto L109;
        return "QCELP";
    L109:
        if (o != 436207616) goto L113;
        return "DSD";
    L113:
        if (o != 452984832) goto L117;
        return "FLAC";
    L117:
        if (o != 469762048) goto L121;
        return "ALAC";
    L121:
        if (o != 486539264) goto L125;
        return "APE";
    L125:
        if (o != 503316480) goto L129;
        return "AAC_ADTS";
    L129:
        if (o != 520093696) goto L133;
        return "SBC";
    L133:
        if (o != 536870912) goto L137;
        return "APTX";
    L137:
        if (o != 553648128) goto L141;
        return "APTX_HD";
    L141:
        if (o != 570425344) goto L145;
        return "AC4";
    L145:
        if (o != 587202560) goto L149;
        return "LDAC";
    L149:
        if (o != (-16777216)) goto L153;
        return "MAIN_MASK";
    L153:
        if (o != 16777215) goto L157;
        return "SUB_MASK";
    L157:
        if (o != 1) goto L161;
        return "PCM_SUB_16_BIT";
    L161:
        if (o != 2) goto L165;
        return "PCM_SUB_8_BIT";
    L165:
        if (o != 3) goto L169;
        return "PCM_SUB_32_BIT";
    L169:
        if (o != 4) goto L173;
        return "PCM_SUB_8_24_BIT";
    L173:
        if (o != 5) goto L177;
        return "PCM_SUB_FLOAT";
    L177:
        if (o != 6) goto L180;
        return "PCM_SUB_24_BIT_PACKED";
    L180:
        if (o != 0) goto L183;
        return "MP3_SUB_NONE";
    L183:
        if (o != 0) goto L186;
        return "AMR_SUB_NONE";
    L186:
        if (o != 1) goto L189;
        return "AAC_SUB_MAIN";
    L189:
        if (o != 2) goto L192;
        return "AAC_SUB_LC";
    L192:
        if (o != 4) goto L196;
        return "AAC_SUB_SSR";
    L196:
        if (o != 8) goto L200;
        return "AAC_SUB_LTP";
    L200:
        if (o != 16) goto L204;
        return "AAC_SUB_HE_V1";
    L204:
        if (o != 32) goto L208;
        return "AAC_SUB_SCALABLE";
    L208:
        if (o != 64) goto L212;
        return "AAC_SUB_ERLC";
    L212:
        if (o != 128) goto L216;
        return "AAC_SUB_LD";
    L216:
        if (o != 256) goto L220;
        return "AAC_SUB_HE_V2";
    L220:
        if (o != 512) goto L223;
        return "AAC_SUB_ELD";
    L223:
        if (o != 0) goto L226;
        return "VORBIS_SUB_NONE";
    L226:
        if (o != 1) goto L229;
        return "PCM_16_BIT";
    L229:
        if (o != 2) goto L232;
        return "PCM_8_BIT";
    L232:
        if (o != 3) goto L235;
        return "PCM_32_BIT";
    L235:
        if (o != 4) goto L238;
        return "PCM_8_24_BIT";
    L238:
        if (o != 5) goto L241;
        return "PCM_FLOAT";
    L241:
        if (o != 6) goto L245;
        return "PCM_24_BIT_PACKED";
    L245:
        if (o != 67108865) goto L249;
        return "AAC_MAIN";
    L249:
        if (o != 67108866) goto L253;
        return "AAC_LC";
    L253:
        if (o != 67108868) goto L257;
        return "AAC_SSR";
    L257:
        if (o != 67108872) goto L261;
        return "AAC_LTP";
    L261:
        if (o != 67108880) goto L265;
        return "AAC_HE_V1";
    L265:
        if (o != 67108896) goto L269;
        return "AAC_SCALABLE";
    L269:
        if (o != 67108928) goto L273;
        return "AAC_ERLC";
    L273:
        if (o != 67108992) goto L277;
        return "AAC_LD";
    L277:
        if (o != 67109120) goto L281;
        return "AAC_HE_V2";
    L281:
        if (o != 67109376) goto L285;
        return "AAC_ELD";
    L285:
        if (o != 503316481) goto L289;
        return "AAC_ADTS_MAIN";
    L289:
        if (o != 503316482) goto L293;
        return "AAC_ADTS_LC";
    L293:
        if (o != 503316484) goto L297;
        return "AAC_ADTS_SSR";
    L297:
        if (o != 503316488) goto L301;
        return "AAC_ADTS_LTP";
    L301:
        if (o != 503316496) goto L305;
        return "AAC_ADTS_HE_V1";
    L305:
        if (o != 503316512) goto L309;
        return "AAC_ADTS_SCALABLE";
    L309:
        if (o != 503316544) goto L313;
        return "AAC_ADTS_ERLC";
    L313:
        if (o != 503316608) goto L317;
        return "AAC_ADTS_LD";
    L317:
        if (o != 503316736) goto L321;
        return "AAC_ADTS_HE_V2";
    L321:
        if (o != 503316992) goto L325;
        return "AAC_ADTS_ELD";
    L325:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & (-1)) != (-1)) goto L5;
        list.add("INVALID");
        flipped = 0 | (-1);
    L5:
        list.add("DEFAULT");
        list.add("PCM");
        if ((o & 16777216) != 16777216) goto L9;
        list.add("MP3");
        flipped = flipped | 16777216;
    L9:
        if ((o & 33554432) != 33554432) goto L12;
        list.add("AMR_NB");
        flipped = flipped | 33554432;
    L12:
        if ((o & AMR_WB) != 50331648) goto L15;
        list.add("AMR_WB");
        flipped = flipped | AMR_WB;
    L15:
        if ((o & 67108864) != 67108864) goto L18;
        list.add("AAC");
        flipped = flipped | 67108864;
    L18:
        if ((o & HE_AAC_V1) != 83886080) goto L21;
        list.add("HE_AAC_V1");
        flipped = flipped | HE_AAC_V1;
    L21:
        if ((o & HE_AAC_V2) != 100663296) goto L24;
        list.add("HE_AAC_V2");
        flipped = flipped | HE_AAC_V2;
    L24:
        if ((o & VORBIS) != 117440512) goto L27;
        list.add("VORBIS");
        flipped = flipped | VORBIS;
    L27:
        if ((o & 134217728) != 134217728) goto L30;
        list.add("OPUS");
        flipped = flipped | 134217728;
    L30:
        if ((o & AC3) != 150994944) goto L33;
        list.add("AC3");
        flipped = flipped | AC3;
    L33:
        if ((o & E_AC3) != 167772160) goto L36;
        list.add("E_AC3");
        flipped = flipped | E_AC3;
    L36:
        if ((o & DTS) != 184549376) goto L39;
        list.add("DTS");
        flipped = flipped | DTS;
    L39:
        if ((o & DTS_HD) != 201326592) goto L42;
        list.add("DTS_HD");
        flipped = flipped | DTS_HD;
    L42:
        if ((o & IEC61937) != 218103808) goto L45;
        list.add("IEC61937");
        flipped = flipped | IEC61937;
    L45:
        if ((o & DOLBY_TRUEHD) != 234881024) goto L48;
        list.add("DOLBY_TRUEHD");
        flipped = flipped | DOLBY_TRUEHD;
    L48:
        if ((o & 268435456) != 268435456) goto L51;
        list.add("EVRC");
        flipped = flipped | 268435456;
    L51:
        if ((285212672 & o) != 285212672) goto L54;
        list.add("EVRCB");
        flipped = flipped | EVRCB;
    L54:
        if ((301989888 & o) != 301989888) goto L57;
        list.add("EVRCWB");
        flipped = flipped | EVRCWB;
    L57:
        if ((318767104 & o) != 318767104) goto L60;
        list.add("EVRCNW");
        flipped = flipped | EVRCNW;
    L60:
        if ((335544320 & o) != 335544320) goto L63;
        list.add("AAC_ADIF");
        flipped = flipped | AAC_ADIF;
    L63:
        if ((352321536 & o) != 352321536) goto L66;
        list.add("WMA");
        flipped = flipped | WMA;
    L66:
        if ((369098752 & o) != 369098752) goto L69;
        list.add("WMA_PRO");
        flipped = flipped | WMA_PRO;
    L69:
        if ((385875968 & o) != 385875968) goto L72;
        list.add("AMR_WB_PLUS");
        flipped = flipped | AMR_WB_PLUS;
    L72:
        if ((402653184 & o) != 402653184) goto L75;
        list.add("MP2");
        flipped = flipped | MP2;
    L75:
        if ((419430400 & o) != 419430400) goto L78;
        list.add("QCELP");
        flipped = flipped | QCELP;
    L78:
        if ((436207616 & o) != 436207616) goto L81;
        list.add("DSD");
        flipped = flipped | DSD;
    L81:
        if ((452984832 & o) != 452984832) goto L84;
        list.add("FLAC");
        flipped = flipped | FLAC;
    L84:
        if ((469762048 & o) != 469762048) goto L87;
        list.add("ALAC");
        flipped = flipped | ALAC;
    L87:
        if ((486539264 & o) != 486539264) goto L90;
        list.add("APE");
        flipped = flipped | APE;
    L90:
        if ((503316480 & o) != 503316480) goto L93;
        list.add("AAC_ADTS");
        flipped = flipped | AAC_ADTS;
    L93:
        if ((520093696 & o) != 520093696) goto L96;
        list.add("SBC");
        flipped = flipped | SBC;
    L96:
        if ((536870912 & o) != 536870912) goto L99;
        list.add("APTX");
        flipped = flipped | 536870912;
    L99:
        if ((553648128 & o) != 553648128) goto L102;
        list.add("APTX_HD");
        flipped = flipped | APTX_HD;
    L102:
        if ((570425344 & o) != 570425344) goto L105;
        list.add("AC4");
        flipped = flipped | AC4;
    L105:
        if ((587202560 & o) != 587202560) goto L108;
        list.add("LDAC");
        flipped = flipped | LDAC;
    L108:
        if (((-16777216) & o) != (-16777216)) goto L111;
        list.add("MAIN_MASK");
        flipped = flipped | MAIN_MASK;
    L111:
        if ((16777215 & o) != 16777215) goto L114;
        list.add("SUB_MASK");
        flipped = flipped | SUB_MASK;
    L114:
        if ((o & 1) != 1) goto L117;
        list.add("PCM_SUB_16_BIT");
        flipped = flipped | 1;
    L117:
        if ((o & 2) != 2) goto L120;
        list.add("PCM_SUB_8_BIT");
        flipped = flipped | 2;
    L120:
        if ((o & 3) != 3) goto L123;
        list.add("PCM_SUB_32_BIT");
        flipped = flipped | 3;
    L123:
        if ((o & 4) != 4) goto L126;
        list.add("PCM_SUB_8_24_BIT");
        flipped = flipped | 4;
    L126:
        if ((o & 5) != 5) goto L129;
        list.add("PCM_SUB_FLOAT");
        flipped = flipped | 5;
    L129:
        if ((o & 6) != 6) goto L131;
        list.add("PCM_SUB_24_BIT_PACKED");
        flipped = flipped | 6;
    L131:
        list.add("MP3_SUB_NONE");
        list.add("AMR_SUB_NONE");
        if ((o & 1) != 1) goto L135;
        list.add("AAC_SUB_MAIN");
        flipped = flipped | 1;
    L135:
        if ((o & 2) != 2) goto L138;
        list.add("AAC_SUB_LC");
        flipped = flipped | 2;
    L138:
        if ((o & 4) != 4) goto L141;
        list.add("AAC_SUB_SSR");
        flipped = flipped | 4;
    L141:
        if ((o & 8) != 8) goto L144;
        list.add("AAC_SUB_LTP");
        flipped = flipped | 8;
    L144:
        if ((o & 16) != 16) goto L147;
        list.add("AAC_SUB_HE_V1");
        flipped = flipped | 16;
    L147:
        if ((o & 32) != 32) goto L150;
        list.add("AAC_SUB_SCALABLE");
        flipped = flipped | 32;
    L150:
        if ((o & 64) != 64) goto L153;
        list.add("AAC_SUB_ERLC");
        flipped = flipped | 64;
    L153:
        if ((o & 128) != 128) goto L156;
        list.add("AAC_SUB_LD");
        flipped = flipped | 128;
    L156:
        if ((o & 256) != 256) goto L159;
        list.add("AAC_SUB_HE_V2");
        flipped = flipped | 256;
    L159:
        if ((o & 512) != 512) goto L161;
        list.add("AAC_SUB_ELD");
        flipped = flipped | 512;
    L161:
        list.add("VORBIS_SUB_NONE");
        if ((o & 1) != 1) goto L165;
        list.add("PCM_16_BIT");
        flipped = flipped | 1;
    L165:
        if ((o & 2) != 2) goto L168;
        list.add("PCM_8_BIT");
        flipped = flipped | 2;
    L168:
        if ((o & 3) != 3) goto L171;
        list.add("PCM_32_BIT");
        flipped = flipped | 3;
    L171:
        if ((o & 4) != 4) goto L174;
        list.add("PCM_8_24_BIT");
        flipped = flipped | 4;
    L174:
        if ((o & 5) != 5) goto L177;
        list.add("PCM_FLOAT");
        flipped = flipped | 5;
    L177:
        if ((o & 6) != 6) goto L180;
        list.add("PCM_24_BIT_PACKED");
        flipped = flipped | 6;
    L180:
        if ((67108865 & o) != 67108865) goto L183;
        list.add("AAC_MAIN");
        flipped = flipped | AAC_MAIN;
    L183:
        if ((67108866 & o) != 67108866) goto L186;
        list.add("AAC_LC");
        flipped = flipped | AAC_LC;
    L186:
        if ((67108868 & o) != 67108868) goto L189;
        list.add("AAC_SSR");
        flipped = flipped | AAC_SSR;
    L189:
        if ((67108872 & o) != 67108872) goto L192;
        list.add("AAC_LTP");
        flipped = flipped | AAC_LTP;
    L192:
        if ((67108880 & o) != 67108880) goto L195;
        list.add("AAC_HE_V1");
        flipped = flipped | AAC_HE_V1;
    L195:
        if ((67108896 & o) != 67108896) goto L198;
        list.add("AAC_SCALABLE");
        flipped = flipped | AAC_SCALABLE;
    L198:
        if ((67108928 & o) != 67108928) goto L201;
        list.add("AAC_ERLC");
        flipped = flipped | AAC_ERLC;
    L201:
        if ((67108992 & o) != 67108992) goto L204;
        list.add("AAC_LD");
        flipped = flipped | AAC_LD;
    L204:
        if ((67109120 & o) != 67109120) goto L207;
        list.add("AAC_HE_V2");
        flipped = flipped | AAC_HE_V2;
    L207:
        if ((67109376 & o) != 67109376) goto L210;
        list.add("AAC_ELD");
        flipped = flipped | AAC_ELD;
    L210:
        if ((503316481 & o) != 503316481) goto L213;
        list.add("AAC_ADTS_MAIN");
        flipped = flipped | AAC_ADTS_MAIN;
    L213:
        if ((503316482 & o) != 503316482) goto L216;
        list.add("AAC_ADTS_LC");
        flipped = flipped | AAC_ADTS_LC;
    L216:
        if ((503316484 & o) != 503316484) goto L219;
        list.add("AAC_ADTS_SSR");
        flipped = flipped | AAC_ADTS_SSR;
    L219:
        if ((503316488 & o) != 503316488) goto L222;
        list.add("AAC_ADTS_LTP");
        flipped = flipped | AAC_ADTS_LTP;
    L222:
        if ((503316496 & o) != 503316496) goto L225;
        list.add("AAC_ADTS_HE_V1");
        flipped = flipped | AAC_ADTS_HE_V1;
    L225:
        if ((503316512 & o) != 503316512) goto L228;
        list.add("AAC_ADTS_SCALABLE");
        flipped = flipped | AAC_ADTS_SCALABLE;
    L228:
        if ((503316544 & o) != 503316544) goto L231;
        list.add("AAC_ADTS_ERLC");
        flipped = flipped | AAC_ADTS_ERLC;
    L231:
        if ((503316608 & o) != 503316608) goto L234;
        list.add("AAC_ADTS_LD");
        flipped = flipped | AAC_ADTS_LD;
    L234:
        if ((503316736 & o) != 503316736) goto L237;
        list.add("AAC_ADTS_HE_V2");
        flipped = flipped | AAC_ADTS_HE_V2;
    L237:
        if ((503316992 & o) != 503316992) goto L239;
        list.add("AAC_ADTS_ELD");
        flipped = flipped | AAC_ADTS_ELD;
    L239:
        if (o == flipped) goto L242;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L242:
        return String.join(" | ", list);
    }
}
