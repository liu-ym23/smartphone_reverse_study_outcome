package com.android.server.hdmi;

import com.android.internal.util.FrameworkStatsLog;
import java.util.Arrays;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
final class HdmiCecKeycode {
    public static final int CEC_KEYCODE_ANGLE = 80;
    public static final int CEC_KEYCODE_BACKWARD = 76;
    public static final int CEC_KEYCODE_CHANNEL_DOWN = 49;
    public static final int CEC_KEYCODE_CHANNEL_UP = 48;
    public static final int CEC_KEYCODE_CLEAR = 44;
    public static final int CEC_KEYCODE_CONTENTS_MENU = 11;
    public static final int CEC_KEYCODE_DATA = 118;
    public static final int CEC_KEYCODE_DISPLAY_INFORMATION = 53;
    public static final int CEC_KEYCODE_DOT = 42;
    public static final int CEC_KEYCODE_DOWN = 2;
    public static final int CEC_KEYCODE_EJECT = 74;
    public static final int CEC_KEYCODE_ELECTRONIC_PROGRAM_GUIDE = 83;
    public static final int CEC_KEYCODE_ENTER = 43;
    public static final int CEC_KEYCODE_EXIT = 13;
    public static final int CEC_KEYCODE_F1_BLUE = 113;
    public static final int CEC_KEYCODE_F2_RED = 114;
    public static final int CEC_KEYCODE_F3_GREEN = 115;
    public static final int CEC_KEYCODE_F4_YELLOW = 116;
    public static final int CEC_KEYCODE_F5 = 117;
    public static final int CEC_KEYCODE_FAST_FORWARD = 73;
    public static final int CEC_KEYCODE_FAVORITE_MENU = 12;
    public static final int CEC_KEYCODE_FORWARD = 75;
    public static final int CEC_KEYCODE_HELP = 54;
    public static final int CEC_KEYCODE_INITIAL_CONFIGURATION = 85;
    public static final int CEC_KEYCODE_INPUT_SELECT = 52;
    public static final int CEC_KEYCODE_LEFT = 3;
    public static final int CEC_KEYCODE_LEFT_DOWN = 8;
    public static final int CEC_KEYCODE_LEFT_UP = 7;
    public static final int CEC_KEYCODE_MEDIA_CONTEXT_SENSITIVE_MENU = 17;
    public static final int CEC_KEYCODE_MEDIA_TOP_MENU = 16;
    public static final int CEC_KEYCODE_MUTE = 67;
    public static final int CEC_KEYCODE_MUTE_FUNCTION = 101;
    public static final int CEC_KEYCODE_NEXT_FAVORITE = 47;
    public static final int CEC_KEYCODE_NUMBERS_1 = 33;
    public static final int CEC_KEYCODE_NUMBERS_2 = 34;
    public static final int CEC_KEYCODE_NUMBERS_3 = 35;
    public static final int CEC_KEYCODE_NUMBERS_4 = 36;
    public static final int CEC_KEYCODE_NUMBERS_5 = 37;
    public static final int CEC_KEYCODE_NUMBERS_6 = 38;
    public static final int CEC_KEYCODE_NUMBERS_7 = 39;
    public static final int CEC_KEYCODE_NUMBERS_8 = 40;
    public static final int CEC_KEYCODE_NUMBERS_9 = 41;
    public static final int CEC_KEYCODE_NUMBER_0_OR_NUMBER_10 = 32;
    public static final int CEC_KEYCODE_NUMBER_11 = 30;
    public static final int CEC_KEYCODE_NUMBER_12 = 31;
    public static final int CEC_KEYCODE_NUMBER_ENTRY_MODE = 29;
    public static final int CEC_KEYCODE_PAGE_DOWN = 56;
    public static final int CEC_KEYCODE_PAGE_UP = 55;
    public static final int CEC_KEYCODE_PAUSE = 70;
    public static final int CEC_KEYCODE_PAUSE_PLAY_FUNCTION = 97;
    public static final int CEC_KEYCODE_PAUSE_RECORD = 78;
    public static final int CEC_KEYCODE_PAUSE_RECORD_FUNCTION = 99;
    public static final int CEC_KEYCODE_PLAY = 68;
    public static final int CEC_KEYCODE_PLAY_FUNCTION = 96;
    public static final int CEC_KEYCODE_POWER = 64;
    public static final int CEC_KEYCODE_POWER_OFF_FUNCTION = 108;
    public static final int CEC_KEYCODE_POWER_ON_FUNCTION = 109;
    public static final int CEC_KEYCODE_POWER_TOGGLE_FUNCTION = 107;
    public static final int CEC_KEYCODE_PREVIOUS_CHANNEL = 50;
    public static final int CEC_KEYCODE_RECORD = 71;
    public static final int CEC_KEYCODE_RECORD_FUNCTION = 98;
    public static final int CEC_KEYCODE_RESERVED = 79;
    public static final int CEC_KEYCODE_RESTORE_VOLUME_FUNCTION = 102;
    public static final int CEC_KEYCODE_REWIND = 72;
    public static final int CEC_KEYCODE_RIGHT = 4;
    public static final int CEC_KEYCODE_RIGHT_DOWN = 6;
    public static final int CEC_KEYCODE_RIGHT_UP = 5;
    public static final int CEC_KEYCODE_ROOT_MENU = 9;
    public static final int CEC_KEYCODE_SELECT = 0;
    public static final int CEC_KEYCODE_SELECT_AUDIO_INPUT_FUNCTION = 106;
    public static final int CEC_KEYCODE_SELECT_AV_INPUT_FUNCTION = 105;
    public static final int CEC_KEYCODE_SELECT_BROADCAST_TYPE = 86;
    public static final int CEC_KEYCODE_SELECT_MEDIA_FUNCTION = 104;
    public static final int CEC_KEYCODE_SELECT_SOUND_PRESENTATION = 87;
    public static final int CEC_KEYCODE_SETUP_MENU = 10;
    public static final int CEC_KEYCODE_SOUND_SELECT = 51;
    public static final int CEC_KEYCODE_STOP = 69;
    public static final int CEC_KEYCODE_STOP_FUNCTION = 100;
    public static final int CEC_KEYCODE_STOP_RECORD = 77;
    public static final int CEC_KEYCODE_SUB_PICTURE = 81;
    public static final int CEC_KEYCODE_TIMER_PROGRAMMING = 84;
    public static final int CEC_KEYCODE_TUNE_FUNCTION = 103;
    public static final int CEC_KEYCODE_UP = 1;
    public static final int CEC_KEYCODE_VIDEO_ON_DEMAND = 82;
    public static final int CEC_KEYCODE_VOLUME_DOWN = 66;
    public static final int CEC_KEYCODE_VOLUME_UP = 65;
    private static final KeycodeEntry[] KEYCODE_ENTRIES = null;
    public static final int NO_PARAM = -1;
    public static final int UI_BROADCAST_ANALOGUE = 16;
    public static final int UI_BROADCAST_ANALOGUE_CABLE = 48;
    public static final int UI_BROADCAST_ANALOGUE_SATELLITE = 64;
    public static final int UI_BROADCAST_ANALOGUE_TERRESTRIAL = 32;
    public static final int UI_BROADCAST_DIGITAL = 80;
    public static final int UI_BROADCAST_DIGITAL_CABLE = 112;
    public static final int UI_BROADCAST_DIGITAL_COMMNICATIONS_SATELLITE = 144;
    public static final int UI_BROADCAST_DIGITAL_COMMNICATIONS_SATELLITE_2 = 145;
    public static final int UI_BROADCAST_DIGITAL_SATELLITE = 128;
    public static final int UI_BROADCAST_DIGITAL_TERRESTRIAL = 96;
    public static final int UI_BROADCAST_IP = 160;
    public static final int UI_BROADCAST_TOGGLE_ALL = 0;
    public static final int UI_BROADCAST_TOGGLE_ANALOGUE_DIGITAL = 1;
    public static final int UI_SOUND_PRESENTATION_BASS_NEUTRAL = 178;
    public static final int UI_SOUND_PRESENTATION_BASS_STEP_MINUS = 179;
    public static final int UI_SOUND_PRESENTATION_BASS_STEP_PLUS = 177;
    public static final int UI_SOUND_PRESENTATION_SELECT_AUDIO_AUTO_EQUALIZER = 160;
    public static final int UI_SOUND_PRESENTATION_SELECT_AUDIO_AUTO_REVERBERATION = 144;
    public static final int UI_SOUND_PRESENTATION_SELECT_AUDIO_DOWN_MIX = 128;
    public static final int UI_SOUND_PRESENTATION_SOUND_MIX_DUAL_MONO = 32;
    public static final int UI_SOUND_PRESENTATION_SOUND_MIX_KARAOKE = 48;
    public static final int UI_SOUND_PRESENTATION_TREBLE_NEUTRAL = 194;
    public static final int UI_SOUND_PRESENTATION_TREBLE_STEP_MINUS = 195;
    public static final int UI_SOUND_PRESENTATION_TREBLE_STEP_PLUS = 193;
    public static final int UNSUPPORTED_KEYCODE = -1;

    private static class KeycodeEntry {
        private final int mAndroidKeycode;
        private final byte[] mCecKeycodeAndParams;
        private final boolean mIsRepeatable;

        /* JADX INFO: renamed from: -$$Nest$misRepeatableIfMatched, reason: not valid java name */
        static /* bridge */ /* synthetic */ Boolean m4287$$Nest$misRepeatableIfMatched(KeycodeEntry r0, int r1) {
            return r0.isRepeatableIfMatched(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mtoAndroidKeycodeIfMatched, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4288$$Nest$mtoAndroidKeycodeIfMatched(KeycodeEntry r0, byte[] r1) {
            return r0.toAndroidKeycodeIfMatched(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mtoCecKeycodeAndParamIfMatched, reason: not valid java name */
        static /* bridge */ /* synthetic */ byte[] m4289$$Nest$mtoCecKeycodeAndParamIfMatched(KeycodeEntry r0, int r1) {
            return r0.toCecKeycodeAndParamIfMatched(r1);
        }

        /* synthetic */ KeycodeEntry(int r1, int r2, HdmiCecKeycodeIA r3) {
            this(r1, r2);
        }

        /* synthetic */ KeycodeEntry(int r1, int r2, boolean r3, HdmiCecKeycodeIA r4) {
            this(r1, r2, r3);
        }

        /* synthetic */ KeycodeEntry(int r1, int r2, boolean r3, byte[] r4, HdmiCecKeycodeIA r5) {
            this(r1, r2, r3, r4);
        }

        private KeycodeEntry(int androidKeycode, int cecKeycode, boolean isRepeatable, byte[] cecParams) {
            this.mAndroidKeycode = androidKeycode;
            this.mIsRepeatable = isRepeatable;
            this.mCecKeycodeAndParams = new byte[cecParams.length + 1];
            System.arraycopy(cecParams, 0, this.mCecKeycodeAndParams, 1, cecParams.length);
            this.mCecKeycodeAndParams[0] = (byte) (cecKeycode & 255);
        }

        private KeycodeEntry(int androidKeycode, int cecKeycode, boolean isRepeatable) {
            this(androidKeycode, cecKeycode, isRepeatable, EmptyArray.BYTE);
        }

        private KeycodeEntry(int androidKeycode, int cecKeycode, byte[] cecParams) {
            this(androidKeycode, cecKeycode, true, cecParams);
        }

        private KeycodeEntry(int androidKeycode, int cecKeycode) {
            this(androidKeycode, cecKeycode, true, EmptyArray.BYTE);
        }

        private byte[] toCecKeycodeAndParamIfMatched(int androidKeycode) {
            if (this.mAndroidKeycode == androidKeycode) goto L5;
            return null;
        L5:
            return this.mCecKeycodeAndParams;
        }

        private int toAndroidKeycodeIfMatched(byte[] cecKeycodeAndParams) {
            if (cecKeycodeAndParams.length >= this.mCecKeycodeAndParams.length) goto L5;
            return -1;
        L5:
            byte[] trimmedCecKeycodeAndParams = new byte[this.mCecKeycodeAndParams.length];
            System.arraycopy(cecKeycodeAndParams, 0, trimmedCecKeycodeAndParams, 0, this.mCecKeycodeAndParams.length);
            if (Arrays.equals(this.mCecKeycodeAndParams, trimmedCecKeycodeAndParams) == true) goto L8;
            return -1;
        L8:
            return this.mAndroidKeycode;
        }

        private Boolean isRepeatableIfMatched(int androidKeycode) {
            if (this.mAndroidKeycode == androidKeycode) goto L5;
            return null;
        L5:
            return Boolean.valueOf(this.mIsRepeatable);
        }
    }

    private HdmiCecKeycode() {
    }

    private static byte[] intToSingleByteArray(int value) {
        return new byte[]{(byte) (value & 255)};
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        HdmiCecKeycodeIA r3 = null;
        KeycodeEntry r1 = new KeycodeEntry(23, 0, r3);
        KeycodeEntry r0 = new KeycodeEntry(19, 1, r3);
        KeycodeEntry r4 = new KeycodeEntry(20, 2, r3);
        int r8 = 3;
        KeycodeEntry r5 = new KeycodeEntry(21, r8, r3);
        KeycodeEntry r6 = new KeycodeEntry(22, 4, r3);
        int r12 = -1;
        KeycodeEntry r7 = new KeycodeEntry(r12, 5, r3);
        KeycodeEntry r9 = new KeycodeEntry(r12, 6, r3);
        KeycodeEntry r13 = new KeycodeEntry(r12, 7, r3);
        KeycodeEntry r10 = new KeycodeEntry(r12, 8, r3);
        int r14 = 9;
        KeycodeEntry r11 = new KeycodeEntry(r8, r14, r3);
        KeycodeEntry r15 = new KeycodeEntry(82, r14, r3);
        KeycodeEntry r16 = new KeycodeEntry(FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__DOCSUI_PICK_RESULT, 10, r3);
        KeycodeEntry r17 = new KeycodeEntry(256, 11, 0 == true ? 1 : 0, r3);
        int r2 = -1;
        KeycodeEntry r18 = new KeycodeEntry(r2, 12, r3);
        int r19 = 13;
        KeycodeEntry r110 = new KeycodeEntry(4, r19, r3);
        KeycodeEntry r20 = new KeycodeEntry(111, r19, r3);
        KeycodeEntry r21 = new KeycodeEntry(226, 16, r3);
        KeycodeEntry r22 = new KeycodeEntry(257, 17, r3);
        KeycodeEntry r23 = new KeycodeEntry(234, 29, r3);
        KeycodeEntry r24 = new KeycodeEntry(FrameworkStatsLog.CAMERA_ACTION_EVENT, 30, r3);
        KeycodeEntry r25 = new KeycodeEntry(228, 31, r3);
        int r26 = 7;
        KeycodeEntry r27 = new KeycodeEntry(r26, 32, r3);
        int r28 = 8;
        KeycodeEntry r29 = new KeycodeEntry(r28, 33, r3);
        int r30 = 9;
        KeycodeEntry r31 = new KeycodeEntry(r30, 34, r3);
        int r32 = 10;
        KeycodeEntry r33 = new KeycodeEntry(r32, 35, r3);
        int r34 = 11;
        KeycodeEntry r35 = new KeycodeEntry(r34, 36, r3);
        int r36 = 12;
        KeycodeEntry r37 = new KeycodeEntry(r36, 37, r3);
        int r38 = 13;
        KeycodeEntry r39 = new KeycodeEntry(r38, 38, r3);
        KeycodeEntry r40 = new KeycodeEntry(14, 39, r3);
        KeycodeEntry r41 = new KeycodeEntry(15, 40, r3);
        int r42 = 16;
        KeycodeEntry r43 = new KeycodeEntry(r42, 41, r3);
        int r44 = 56;
        KeycodeEntry r45 = new KeycodeEntry(r44, 42, r3);
        KeycodeEntry r46 = new KeycodeEntry(160, 43, r3);
        KeycodeEntry r47 = new KeycodeEntry(28, 44, r3);
        int r48 = -1;
        KeycodeEntry r49 = new KeycodeEntry(r48, 47, r3);
        KeycodeEntry r50 = new KeycodeEntry(166, 48, r3);
        KeycodeEntry r51 = new KeycodeEntry(167, 49, r3);
        KeycodeEntry r52 = new KeycodeEntry(229, 50, r3);
        KeycodeEntry r53 = new KeycodeEntry(222, 51, r3);
        KeycodeEntry r54 = new KeycodeEntry(178, 52, r3);
        KeycodeEntry r55 = new KeycodeEntry(165, 53, r3);
        int r56 = -1;
        KeycodeEntry r57 = new KeycodeEntry(r56, 54, r3);
        KeycodeEntry r58 = new KeycodeEntry(92, 55, r3);
        KeycodeEntry r59 = new KeycodeEntry(93, 56, r3);
        KeycodeEntry r60 = new KeycodeEntry(26, 64, false, r3);
        KeycodeEntry r61 = new KeycodeEntry(24, 65, r3);
        KeycodeEntry r62 = new KeycodeEntry(25, 66, r3);
        KeycodeEntry r63 = new KeycodeEntry(164, 67, false, r3);
        KeycodeEntry r64 = new KeycodeEntry(126, 68, r3);
        int r65 = 86;
        KeycodeEntry r66 = new KeycodeEntry(r65, 69, r3);
        int r67 = 70;
        KeycodeEntry r68 = new KeycodeEntry(127, r67, r3);
        KeycodeEntry r69 = new KeycodeEntry(85, r67, r3);
        KeycodeEntry r70 = new KeycodeEntry(130, 71, r3);
        KeycodeEntry r71 = new KeycodeEntry(89, 72, r3);
        KeycodeEntry r72 = new KeycodeEntry(90, 73, r3);
        KeycodeEntry r73 = new KeycodeEntry(129, 74, r3);
        int r74 = 87;
        KeycodeEntry r75 = new KeycodeEntry(r74, 75, r3);
        KeycodeEntry r76 = new KeycodeEntry(88, 76, r3);
        int r77 = -1;
        KeycodeEntry r78 = new KeycodeEntry(r77, 77, r3);
        KeycodeEntry r79 = new KeycodeEntry(r77, 78, r3);
        KeycodeEntry r80 = new KeycodeEntry(r77, 79, r3);
        KeycodeEntry r81 = new KeycodeEntry(r77, 80, r3);
        KeycodeEntry r82 = new KeycodeEntry(FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__DOCSUI_LAUNCH_OTHER_APP, 81, r3);
        KeycodeEntry r83 = new KeycodeEntry(-1, 82, r3);
        KeycodeEntry r84 = new KeycodeEntry(FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__CROSS_PROFILE_SETTINGS_PAGE_PERMISSION_REVOKED, 83, r3);
        KeycodeEntry r85 = new KeycodeEntry(258, 84, r3);
        int r86 = -1;
        KeycodeEntry r87 = new KeycodeEntry(r86, 85, r3);
        KeycodeEntry r88 = new KeycodeEntry(r86, 86, r3);
        int r710 = 235;
        int r711 = 86;
        boolean r89 = true;
        KeycodeEntry r712 = new KeycodeEntry(r710, r711, r89, intToSingleByteArray(16), null);
        int r713 = 236;
        int r810 = 86;
        boolean r811 = true;
        KeycodeEntry r714 = new KeycodeEntry(r713, r810, r811, intToSingleByteArray(96), null);
        int r812 = FrameworkStatsLog.REBOOT_ESCROW_RECOVERY_REPORTED;
        int r813 = 86;
        boolean r814 = true;
        KeycodeEntry r715 = new KeycodeEntry(r812, r813, r814, intToSingleByteArray(128), null);
        int r815 = 239;
        int r816 = 86;
        boolean r817 = true;
        KeycodeEntry r818 = new KeycodeEntry(r815, r816, r817, intToSingleByteArray(144), null);
        int r819 = 241;
        int r820 = 86;
        boolean r821 = true;
        int r90 = -1;
        boolean r91 = false;
        KEYCODE_ENTRIES = new KeycodeEntry[]{r1, r0, r4, r5, r6, r7, r9, r13, r10, r11, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r27, r29, r31, r33, r35, r37, r39, r40, r41, r43, r45, r46, r47, r49, r50, r51, r52, r53, r54, r55, r57, r58, r59, r60, r61, r62, r63, r64, r66, r68, r69, r70, r71, r72, r73, r75, r76, r78, r79, r80, r81, r82, r83, r84, r85, r87, r88, r712, r714, r715, r818, new KeycodeEntry(r819, r820, r821, intToSingleByteArray(1), null), new KeycodeEntry(r90, 87, r3), new KeycodeEntry(r90, 96, r91, r3), new KeycodeEntry(r90, 97, r91, r3), new KeycodeEntry(r90, 98, r91, r3), new KeycodeEntry(r90, 99, r91, r3), new KeycodeEntry(r90, 100, r91, r3), new KeycodeEntry(r90, 101, r91, r3), new KeycodeEntry(r90, 102, r91, r3), new KeycodeEntry(r90, 103, r91, r3), new KeycodeEntry(r90, 104, r91, r3), new KeycodeEntry(r90, 105, r91, r3), new KeycodeEntry(r90, 106, r91, r3), new KeycodeEntry(r90, 107, r91, r3), new KeycodeEntry(r90, 108, r91, r3), new KeycodeEntry(r90, 109, r91, r3), new KeycodeEntry(186, 113, r3), new KeycodeEntry(183, 114, r3), new KeycodeEntry(184, 115, r3), new KeycodeEntry(185, 116, r3), new KeycodeEntry(135, 117, r3), new KeycodeEntry(FrameworkStatsLog.APP_PROCESS_DIED__IMPORTANCE__IMPORTANCE_PERCEPTIBLE, 118, r3)};
    }

    static byte[] androidKeyToCecKey(int keycode) {
        int i = 0;
    L4:
        if (i >= KEYCODE_ENTRIES.length) goto L9;
        byte[] cecKeycodeAndParams = KeycodeEntry.m4289$$Nest$mtoCecKeycodeAndParamIfMatched(KEYCODE_ENTRIES[i], keycode);
        if (cecKeycodeAndParams != null) goto L7;
        i = i + 1;
        goto L4
    L7:
        return cecKeycodeAndParams;
    L9:
        return null;
    }

    static int cecKeycodeAndParamsToAndroidKey(byte[] cecKeycodeAndParams) {
        int i = 0;
    L4:
        if (i >= KEYCODE_ENTRIES.length) goto L10;
        int androidKey = KeycodeEntry.m4288$$Nest$mtoAndroidKeycodeIfMatched(KEYCODE_ENTRIES[i], cecKeycodeAndParams);
        if (androidKey != (-1)) goto L7;
        i = i + 1;
        goto L4
    L7:
        return androidKey;
    L10:
        return -1;
    }

    static boolean isRepeatableKey(int androidKeycode) {
        int i = 0;
    L4:
        if (i >= KEYCODE_ENTRIES.length) goto L10;
        Boolean isRepeatable = KeycodeEntry.m4287$$Nest$misRepeatableIfMatched(KEYCODE_ENTRIES[i], androidKeycode);
        if (isRepeatable != null) goto L8;
        i = i + 1;
        goto L4
    L8:
        return isRepeatable.booleanValue();
    L10:
        return false;
    }

    static boolean isSupportedKeycode(int androidKeycode) {
        if (androidKeyToCecKey(androidKeycode) == null) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isVolumeKeycode(int androidKeycode) {
        int cecKeyCode = androidKeyToCecKey(androidKeycode)[0];
        if (isSupportedKeycode(androidKeycode) == true) goto L5;
        return false;
    L5:
        if (cecKeyCode != 65) goto L7;
    L14:
        return true;
    L7:
        if (cecKeyCode == 66) goto L14;
        if (cecKeyCode == 67) goto L14;
        if (cecKeyCode == 101) goto L14;
        if (cecKeyCode == 102) goto L14;
        return false;
    }

    public static int getMuteKey(boolean muting) {
        return 67;
    }

    public static String getKeycodeType(byte keycode) {
        switch(keycode) {
            case 0: goto L37;
            case 1: goto L35;
            case 2: goto L35;
            case 3: goto L35;
            case 4: goto L35;
            case 5: goto L35;
            case 6: goto L35;
            case 7: goto L35;
            case 8: goto L35;
            case 9: goto L33;
            case 10: goto L33;
            case 11: goto L33;
            case 12: goto L33;
            case 13: goto L35;
            case 14: goto L3;
            case 15: goto L3;
            case 16: goto L33;
            case 17: goto L33;
            case 18: goto L3;
            case 19: goto L3;
            case 20: goto L3;
            case 21: goto L3;
            case 22: goto L3;
            case 23: goto L3;
            case 24: goto L3;
            case 25: goto L3;
            case 26: goto L3;
            case 27: goto L3;
            case 28: goto L3;
            case 29: goto L31;
            case 30: goto L29;
            case 31: goto L29;
            case 32: goto L29;
            case 33: goto L29;
            case 34: goto L29;
            case 35: goto L29;
            case 36: goto L29;
            case 37: goto L29;
            case 38: goto L29;
            case 39: goto L29;
            case 40: goto L29;
            case 41: goto L29;
            case 42: goto L31;
            case 43: goto L31;
            case 44: goto L31;
            case 45: goto L3;
            case 46: goto L3;
            case 47: goto L27;
            case 48: goto L27;
            case 49: goto L27;
            case 50: goto L27;
            case 51: goto L37;
            case 52: goto L37;
            case 53: goto L31;
            case 54: goto L31;
            case 55: goto L35;
            case 56: goto L35;
            case 57: goto L3;
            case 58: goto L3;
            case 59: goto L3;
            case 60: goto L3;
            case 61: goto L3;
            case 62: goto L3;
            case 63: goto L3;
            case 64: goto L25;
            case 65: goto L23;
            case 66: goto L21;
            case 67: goto L19;
            case 68: goto L17;
            case 69: goto L17;
            case 70: goto L17;
            case 71: goto L17;
            case 72: goto L17;
            case 73: goto L17;
            case 74: goto L17;
            case 75: goto L17;
            case 76: goto L17;
            case 77: goto L17;
            case 78: goto L17;
            case 79: goto L3;
            case 80: goto L17;
            case 81: goto L17;
            case 82: goto L17;
            case 83: goto L15;
            case 84: goto L15;
            case 85: goto L31;
            case 86: goto L37;
            case 87: goto L37;
            case 88: goto L3;
            case 89: goto L3;
            case 90: goto L3;
            case 91: goto L3;
            case 92: goto L3;
            case 93: goto L3;
            case 94: goto L3;
            case 95: goto L3;
            case 96: goto L13;
            case 97: goto L13;
            case 98: goto L13;
            case 99: goto L13;
            case 100: goto L13;
            case 101: goto L13;
            case 102: goto L13;
            case 103: goto L13;
            case 104: goto L13;
            case 105: goto L13;
            case 106: goto L13;
            case 107: goto L11;
            case 108: goto L9;
            case 109: goto L7;
            case 110: goto L3;
            case 111: goto L3;
            case 112: goto L3;
            case 113: goto L5;
            case 114: goto L5;
            case 115: goto L5;
            case 116: goto L5;
            case 117: goto L5;
            case 118: goto L31;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "Function key";
    L7:
        return "Power on";
    L9:
        return "Power off";
    L11:
        return "Power toggle";
    L13:
        return "Functional";
    L15:
        return "Timer";
    L17:
        return "Media";
    L19:
        return "Volume mute";
    L21:
        return "Volume down";
    L23:
        return "Volume up";
    L25:
        return "Power";
    L27:
        return "Channel";
    L29:
        return "Number";
    L31:
        return "General";
    L33:
        return "Menu";
    L35:
        return "Navigation";
    L37:
        return "Select";
    }
}
