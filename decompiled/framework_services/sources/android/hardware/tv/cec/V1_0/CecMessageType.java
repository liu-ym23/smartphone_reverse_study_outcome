package android.hardware.tv.cec.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class CecMessageType {
    public static final int ABORT = 255;
    public static final int ACTIVE_SOURCE = 130;
    public static final int CEC_VERSION = 158;
    public static final int CLEAR_ANALOG_TIMER = 51;
    public static final int CLEAR_DIGITAL_TIMER = 153;
    public static final int CLEAR_EXTERNAL_TIMER = 161;
    public static final int DECK_CONTROL = 66;
    public static final int DECK_STATUS = 27;
    public static final int DEVICE_VENDOR_ID = 135;
    public static final int FEATURE_ABORT = 0;
    public static final int GET_CEC_VERSION = 159;
    public static final int GET_MENU_LANGUAGE = 145;
    public static final int GIVE_AUDIO_STATUS = 113;
    public static final int GIVE_DECK_STATUS = 26;
    public static final int GIVE_DEVICE_POWER_STATUS = 143;
    public static final int GIVE_DEVICE_VENDOR_ID = 140;
    public static final int GIVE_OSD_NAME = 70;
    public static final int GIVE_PHYSICAL_ADDRESS = 131;
    public static final int GIVE_SYSTEM_AUDIO_MODE_STATUS = 125;
    public static final int GIVE_TUNER_DEVICE_STATUS = 8;
    public static final int IMAGE_VIEW_ON = 4;
    public static final int INACTIVE_SOURCE = 157;
    public static final int INITIATE_ARC = 192;
    public static final int MENU_REQUEST = 141;
    public static final int MENU_STATUS = 142;
    public static final int PLAY = 65;
    public static final int RECORD_OFF = 11;
    public static final int RECORD_ON = 9;
    public static final int RECORD_STATUS = 10;
    public static final int RECORD_TV_SCREEN = 15;
    public static final int REPORT_ARC_INITIATED = 193;
    public static final int REPORT_ARC_TERMINATED = 194;
    public static final int REPORT_AUDIO_STATUS = 122;
    public static final int REPORT_PHYSICAL_ADDRESS = 132;
    public static final int REPORT_POWER_STATUS = 144;
    public static final int REPORT_SHORT_AUDIO_DESCRIPTOR = 163;
    public static final int REQUEST_ACTIVE_SOURCE = 133;
    public static final int REQUEST_ARC_INITIATION = 195;
    public static final int REQUEST_ARC_TERMINATION = 196;
    public static final int REQUEST_SHORT_AUDIO_DESCRIPTOR = 164;
    public static final int ROUTING_CHANGE = 128;
    public static final int ROUTING_INFORMATION = 129;
    public static final int SELECT_ANALOG_SERVICE = 146;
    public static final int SELECT_DIGITAL_SERVICE = 147;
    public static final int SET_ANALOG_TIMER = 52;
    public static final int SET_AUDIO_RATE = 154;
    public static final int SET_DIGITAL_TIMER = 151;
    public static final int SET_EXTERNAL_TIMER = 162;
    public static final int SET_MENU_LANGUAGE = 50;
    public static final int SET_OSD_NAME = 71;
    public static final int SET_OSD_STRING = 100;
    public static final int SET_STREAM_PATH = 134;
    public static final int SET_SYSTEM_AUDIO_MODE = 114;
    public static final int SET_TIMER_PROGRAM_TITLE = 103;
    public static final int STANDBY = 54;
    public static final int SYSTEM_AUDIO_MODE_REQUEST = 112;
    public static final int SYSTEM_AUDIO_MODE_STATUS = 126;
    public static final int TERMINATE_ARC = 197;
    public static final int TEXT_VIEW_ON = 13;
    public static final int TIMER_CLEARED_STATUS = 67;
    public static final int TIMER_STATUS = 53;
    public static final int TUNER_DEVICE_STATUS = 7;
    public static final int TUNER_STEP_DECREMENT = 6;
    public static final int TUNER_STEP_INCREMENT = 5;
    public static final int USER_CONTROL_PRESSED = 68;
    public static final int USER_CONTROL_RELEASED = 69;
    public static final int VENDOR_COMMAND = 137;
    public static final int VENDOR_COMMAND_WITH_ID = 160;
    public static final int VENDOR_REMOTE_BUTTON_DOWN = 138;
    public static final int VENDOR_REMOTE_BUTTON_UP = 139;

    public CecMessageType() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "FEATURE_ABORT";
    L6:
        if (o != 4) goto L10;
        return "IMAGE_VIEW_ON";
    L10:
        if (o != 5) goto L14;
        return "TUNER_STEP_INCREMENT";
    L14:
        if (o != 6) goto L18;
        return "TUNER_STEP_DECREMENT";
    L18:
        if (o != 7) goto L22;
        return "TUNER_DEVICE_STATUS";
    L22:
        if (o != 8) goto L26;
        return "GIVE_TUNER_DEVICE_STATUS";
    L26:
        if (o != 9) goto L30;
        return "RECORD_ON";
    L30:
        if (o != 10) goto L34;
        return "RECORD_STATUS";
    L34:
        if (o != 11) goto L38;
        return "RECORD_OFF";
    L38:
        if (o != 13) goto L42;
        return "TEXT_VIEW_ON";
    L42:
        if (o != 15) goto L46;
        return "RECORD_TV_SCREEN";
    L46:
        if (o != 26) goto L50;
        return "GIVE_DECK_STATUS";
    L50:
        if (o != 27) goto L54;
        return "DECK_STATUS";
    L54:
        if (o != 50) goto L58;
        return "SET_MENU_LANGUAGE";
    L58:
        if (o != 51) goto L62;
        return "CLEAR_ANALOG_TIMER";
    L62:
        if (o != 52) goto L66;
        return "SET_ANALOG_TIMER";
    L66:
        if (o != 53) goto L70;
        return "TIMER_STATUS";
    L70:
        if (o != 54) goto L74;
        return "STANDBY";
    L74:
        if (o != 65) goto L78;
        return "PLAY";
    L78:
        if (o != 66) goto L82;
        return "DECK_CONTROL";
    L82:
        if (o != 67) goto L86;
        return "TIMER_CLEARED_STATUS";
    L86:
        if (o != 68) goto L90;
        return "USER_CONTROL_PRESSED";
    L90:
        if (o != 69) goto L94;
        return "USER_CONTROL_RELEASED";
    L94:
        if (o != 70) goto L98;
        return "GIVE_OSD_NAME";
    L98:
        if (o != 71) goto L102;
        return "SET_OSD_NAME";
    L102:
        if (o != 100) goto L106;
        return "SET_OSD_STRING";
    L106:
        if (o != 103) goto L110;
        return "SET_TIMER_PROGRAM_TITLE";
    L110:
        if (o != 112) goto L114;
        return "SYSTEM_AUDIO_MODE_REQUEST";
    L114:
        if (o != 113) goto L118;
        return "GIVE_AUDIO_STATUS";
    L118:
        if (o != 114) goto L122;
        return "SET_SYSTEM_AUDIO_MODE";
    L122:
        if (o != 122) goto L126;
        return "REPORT_AUDIO_STATUS";
    L126:
        if (o != 125) goto L130;
        return "GIVE_SYSTEM_AUDIO_MODE_STATUS";
    L130:
        if (o != 126) goto L134;
        return "SYSTEM_AUDIO_MODE_STATUS";
    L134:
        if (o != 128) goto L138;
        return "ROUTING_CHANGE";
    L138:
        if (o != 129) goto L142;
        return "ROUTING_INFORMATION";
    L142:
        if (o != 130) goto L146;
        return "ACTIVE_SOURCE";
    L146:
        if (o != 131) goto L150;
        return "GIVE_PHYSICAL_ADDRESS";
    L150:
        if (o != 132) goto L154;
        return "REPORT_PHYSICAL_ADDRESS";
    L154:
        if (o != 133) goto L158;
        return "REQUEST_ACTIVE_SOURCE";
    L158:
        if (o != 134) goto L162;
        return "SET_STREAM_PATH";
    L162:
        if (o != 135) goto L166;
        return "DEVICE_VENDOR_ID";
    L166:
        if (o != 137) goto L170;
        return "VENDOR_COMMAND";
    L170:
        if (o != 138) goto L174;
        return "VENDOR_REMOTE_BUTTON_DOWN";
    L174:
        if (o != 139) goto L178;
        return "VENDOR_REMOTE_BUTTON_UP";
    L178:
        if (o != 140) goto L182;
        return "GIVE_DEVICE_VENDOR_ID";
    L182:
        if (o != 141) goto L186;
        return "MENU_REQUEST";
    L186:
        if (o != 142) goto L190;
        return "MENU_STATUS";
    L190:
        if (o != 143) goto L194;
        return "GIVE_DEVICE_POWER_STATUS";
    L194:
        if (o != 144) goto L198;
        return "REPORT_POWER_STATUS";
    L198:
        if (o != 145) goto L202;
        return "GET_MENU_LANGUAGE";
    L202:
        if (o != 146) goto L206;
        return "SELECT_ANALOG_SERVICE";
    L206:
        if (o != 147) goto L210;
        return "SELECT_DIGITAL_SERVICE";
    L210:
        if (o != 151) goto L214;
        return "SET_DIGITAL_TIMER";
    L214:
        if (o != 153) goto L218;
        return "CLEAR_DIGITAL_TIMER";
    L218:
        if (o != 154) goto L222;
        return "SET_AUDIO_RATE";
    L222:
        if (o != 157) goto L226;
        return "INACTIVE_SOURCE";
    L226:
        if (o != 158) goto L230;
        return "CEC_VERSION";
    L230:
        if (o != 159) goto L234;
        return "GET_CEC_VERSION";
    L234:
        if (o != 160) goto L238;
        return "VENDOR_COMMAND_WITH_ID";
    L238:
        if (o != 161) goto L242;
        return "CLEAR_EXTERNAL_TIMER";
    L242:
        if (o != 162) goto L246;
        return "SET_EXTERNAL_TIMER";
    L246:
        if (o != 163) goto L250;
        return "REPORT_SHORT_AUDIO_DESCRIPTOR";
    L250:
        if (o != 164) goto L254;
        return "REQUEST_SHORT_AUDIO_DESCRIPTOR";
    L254:
        if (o != 192) goto L258;
        return "INITIATE_ARC";
    L258:
        if (o != 193) goto L262;
        return "REPORT_ARC_INITIATED";
    L262:
        if (o != 194) goto L266;
        return "REPORT_ARC_TERMINATED";
    L266:
        if (o != 195) goto L270;
        return "REQUEST_ARC_INITIATION";
    L270:
        if (o != 196) goto L274;
        return "REQUEST_ARC_TERMINATION";
    L274:
        if (o != 197) goto L278;
        return "TERMINATE_ARC";
    L278:
        if (o != 255) goto L282;
        return "ABORT";
    L282:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("FEATURE_ABORT");
        if ((o & 4) != 4) goto L6;
        list.add("IMAGE_VIEW_ON");
        flipped = 0 | 4;
    L6:
        if ((o & 5) != 5) goto L9;
        list.add("TUNER_STEP_INCREMENT");
        flipped = flipped | 5;
    L9:
        if ((o & 6) != 6) goto L12;
        list.add("TUNER_STEP_DECREMENT");
        flipped = flipped | 6;
    L12:
        if ((o & 7) != 7) goto L15;
        list.add("TUNER_DEVICE_STATUS");
        flipped = flipped | 7;
    L15:
        if ((o & 8) != 8) goto L18;
        list.add("GIVE_TUNER_DEVICE_STATUS");
        flipped = flipped | 8;
    L18:
        if ((o & 9) != 9) goto L21;
        list.add("RECORD_ON");
        flipped = flipped | 9;
    L21:
        if ((o & 10) != 10) goto L24;
        list.add("RECORD_STATUS");
        flipped = flipped | 10;
    L24:
        if ((o & 11) != 11) goto L27;
        list.add("RECORD_OFF");
        flipped = flipped | 11;
    L27:
        if ((o & 13) != 13) goto L30;
        list.add("TEXT_VIEW_ON");
        flipped = flipped | 13;
    L30:
        if ((o & 15) != 15) goto L33;
        list.add("RECORD_TV_SCREEN");
        flipped = flipped | 15;
    L33:
        if ((o & 26) != 26) goto L36;
        list.add("GIVE_DECK_STATUS");
        flipped = flipped | 26;
    L36:
        if ((o & 27) != 27) goto L39;
        list.add("DECK_STATUS");
        flipped = flipped | 27;
    L39:
        if ((o & 50) != 50) goto L42;
        list.add("SET_MENU_LANGUAGE");
        flipped = flipped | 50;
    L42:
        if ((o & 51) != 51) goto L45;
        list.add("CLEAR_ANALOG_TIMER");
        flipped = flipped | 51;
    L45:
        if ((o & 52) != 52) goto L48;
        list.add("SET_ANALOG_TIMER");
        flipped = flipped | 52;
    L48:
        if ((o & 53) != 53) goto L51;
        list.add("TIMER_STATUS");
        flipped = flipped | 53;
    L51:
        if ((o & 54) != 54) goto L54;
        list.add("STANDBY");
        flipped = flipped | 54;
    L54:
        if ((o & 65) != 65) goto L57;
        list.add("PLAY");
        flipped = flipped | 65;
    L57:
        if ((o & 66) != 66) goto L60;
        list.add("DECK_CONTROL");
        flipped = flipped | 66;
    L60:
        if ((o & 67) != 67) goto L63;
        list.add("TIMER_CLEARED_STATUS");
        flipped = flipped | 67;
    L63:
        if ((o & 68) != 68) goto L66;
        list.add("USER_CONTROL_PRESSED");
        flipped = flipped | 68;
    L66:
        if ((o & 69) != 69) goto L69;
        list.add("USER_CONTROL_RELEASED");
        flipped = flipped | 69;
    L69:
        if ((o & 70) != 70) goto L72;
        list.add("GIVE_OSD_NAME");
        flipped = flipped | 70;
    L72:
        if ((o & 71) != 71) goto L75;
        list.add("SET_OSD_NAME");
        flipped = flipped | 71;
    L75:
        if ((o & 100) != 100) goto L78;
        list.add("SET_OSD_STRING");
        flipped = flipped | 100;
    L78:
        if ((o & 103) != 103) goto L81;
        list.add("SET_TIMER_PROGRAM_TITLE");
        flipped = flipped | 103;
    L81:
        if ((o & 112) != 112) goto L84;
        list.add("SYSTEM_AUDIO_MODE_REQUEST");
        flipped = flipped | 112;
    L84:
        if ((o & 113) != 113) goto L87;
        list.add("GIVE_AUDIO_STATUS");
        flipped = flipped | 113;
    L87:
        if ((o & 114) != 114) goto L90;
        list.add("SET_SYSTEM_AUDIO_MODE");
        flipped = flipped | 114;
    L90:
        if ((o & 122) != 122) goto L93;
        list.add("REPORT_AUDIO_STATUS");
        flipped = flipped | 122;
    L93:
        if ((o & 125) != 125) goto L96;
        list.add("GIVE_SYSTEM_AUDIO_MODE_STATUS");
        flipped = flipped | 125;
    L96:
        if ((o & 126) != 126) goto L99;
        list.add("SYSTEM_AUDIO_MODE_STATUS");
        flipped = flipped | 126;
    L99:
        if ((o & 128) != 128) goto L102;
        list.add("ROUTING_CHANGE");
        flipped = flipped | 128;
    L102:
        if ((o & 129) != 129) goto L105;
        list.add("ROUTING_INFORMATION");
        flipped = flipped | 129;
    L105:
        if ((o & 130) != 130) goto L108;
        list.add("ACTIVE_SOURCE");
        flipped = flipped | 130;
    L108:
        if ((o & 131) != 131) goto L111;
        list.add("GIVE_PHYSICAL_ADDRESS");
        flipped = flipped | 131;
    L111:
        if ((o & 132) != 132) goto L114;
        list.add("REPORT_PHYSICAL_ADDRESS");
        flipped = flipped | 132;
    L114:
        if ((o & 133) != 133) goto L117;
        list.add("REQUEST_ACTIVE_SOURCE");
        flipped = flipped | 133;
    L117:
        if ((o & 134) != 134) goto L120;
        list.add("SET_STREAM_PATH");
        flipped = flipped | 134;
    L120:
        if ((o & 135) != 135) goto L123;
        list.add("DEVICE_VENDOR_ID");
        flipped = flipped | 135;
    L123:
        if ((o & 137) != 137) goto L126;
        list.add("VENDOR_COMMAND");
        flipped = flipped | 137;
    L126:
        if ((o & 138) != 138) goto L129;
        list.add("VENDOR_REMOTE_BUTTON_DOWN");
        flipped = flipped | 138;
    L129:
        if ((o & 139) != 139) goto L132;
        list.add("VENDOR_REMOTE_BUTTON_UP");
        flipped = flipped | 139;
    L132:
        if ((o & 140) != 140) goto L135;
        list.add("GIVE_DEVICE_VENDOR_ID");
        flipped = flipped | 140;
    L135:
        if ((o & 141) != 141) goto L138;
        list.add("MENU_REQUEST");
        flipped = flipped | 141;
    L138:
        if ((o & 142) != 142) goto L141;
        list.add("MENU_STATUS");
        flipped = flipped | 142;
    L141:
        if ((o & 143) != 143) goto L144;
        list.add("GIVE_DEVICE_POWER_STATUS");
        flipped = flipped | 143;
    L144:
        if ((o & 144) != 144) goto L147;
        list.add("REPORT_POWER_STATUS");
        flipped = flipped | 144;
    L147:
        if ((o & 145) != 145) goto L150;
        list.add("GET_MENU_LANGUAGE");
        flipped = flipped | 145;
    L150:
        if ((o & 146) != 146) goto L153;
        list.add("SELECT_ANALOG_SERVICE");
        flipped = flipped | 146;
    L153:
        if ((o & 147) != 147) goto L156;
        list.add("SELECT_DIGITAL_SERVICE");
        flipped = flipped | 147;
    L156:
        if ((o & 151) != 151) goto L159;
        list.add("SET_DIGITAL_TIMER");
        flipped = flipped | 151;
    L159:
        if ((o & 153) != 153) goto L162;
        list.add("CLEAR_DIGITAL_TIMER");
        flipped = flipped | 153;
    L162:
        if ((o & 154) != 154) goto L165;
        list.add("SET_AUDIO_RATE");
        flipped = flipped | 154;
    L165:
        if ((o & 157) != 157) goto L168;
        list.add("INACTIVE_SOURCE");
        flipped = flipped | 157;
    L168:
        if ((o & 158) != 158) goto L171;
        list.add("CEC_VERSION");
        flipped = flipped | 158;
    L171:
        if ((o & 159) != 159) goto L174;
        list.add("GET_CEC_VERSION");
        flipped = flipped | 159;
    L174:
        if ((o & 160) != 160) goto L177;
        list.add("VENDOR_COMMAND_WITH_ID");
        flipped = flipped | 160;
    L177:
        if ((o & 161) != 161) goto L180;
        list.add("CLEAR_EXTERNAL_TIMER");
        flipped = flipped | 161;
    L180:
        if ((o & 162) != 162) goto L183;
        list.add("SET_EXTERNAL_TIMER");
        flipped = flipped | 162;
    L183:
        if ((o & 163) != 163) goto L186;
        list.add("REPORT_SHORT_AUDIO_DESCRIPTOR");
        flipped = flipped | 163;
    L186:
        if ((o & 164) != 164) goto L189;
        list.add("REQUEST_SHORT_AUDIO_DESCRIPTOR");
        flipped = flipped | 164;
    L189:
        if ((o & 192) != 192) goto L192;
        list.add("INITIATE_ARC");
        flipped = flipped | 192;
    L192:
        if ((o & 193) != 193) goto L195;
        list.add("REPORT_ARC_INITIATED");
        flipped = flipped | 193;
    L195:
        if ((o & 194) != 194) goto L198;
        list.add("REPORT_ARC_TERMINATED");
        flipped = flipped | 194;
    L198:
        if ((o & 195) != 195) goto L201;
        list.add("REQUEST_ARC_INITIATION");
        flipped = flipped | 195;
    L201:
        if ((o & 196) != 196) goto L204;
        list.add("REQUEST_ARC_TERMINATION");
        flipped = flipped | 196;
    L204:
        if ((o & 197) != 197) goto L207;
        list.add("TERMINATE_ARC");
        flipped = flipped | 197;
    L207:
        if ((o & 255) != 255) goto L209;
        list.add("ABORT");
        flipped = flipped | 255;
    L209:
        if (o == flipped) goto L212;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L212:
        return String.join(" | ", list);
    }
}
