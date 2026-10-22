package android.app;

import java.util.BitSet;

/* loaded from: classes.dex */
public final class CtaOpCodes {
    public static final int AOSP_OP = 10000;
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DIR_ALLOWED = 0;
    public static final int MODE_DIR_DEFAULT = -1;
    public static final int MODE_DIR_DENIED = 2;
    public static final int MODE_DIR_PART_ALLOWED = 1;
    public static final int MODE_DIR_PART_ALLOWED_RETURN_TO_MEDIA = 10;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;
    public static final int OP_ACCESS_EM_ACCOUNT = 104;
    public static final int OP_ACCESS_EM_APPS = 107;
    public static final int OP_ACCESS_EM_CALENDAR = 106;
    public static final int OP_ACCESS_EM_CALL_LOG = 105;
    public static final int OP_ACCESS_EM_CLIPBOARD = 108;
    public static final int OP_ACCESS_EM_CONTACTS = 103;
    public static final int OP_ACCESS_EM_IMEI = 101;
    public static final int OP_ACCESS_EM_SMS_MMS = 102;
    public static final int OP_ACCESS_EM_SMS_RECEIVED = 114;
    public static final int OP_ACCESS_LIMIT_URL = 113;
    public static final int OP_ACCESS_MEDIA_LOCATION = 100;
    public static final int OP_ACCESS_NETWORK = 111;
    public static final int OP_ACCESS_NOTIFICATIONS = 25;
    public static final int OP_ACTIVITY_RECOGNITION = 79;
    public static final int OP_AI_READ_CLIPBOARD = 200;
    public static final int OP_AUDIO_ALARM_VOLUME = 37;
    public static final int OP_AUDIO_BLUETOOTH_VOLUME = 39;
    public static final int OP_AUDIO_FM_VOLUME = 43;
    public static final int OP_AUDIO_MASTER_VOLUME = 33;
    public static final int OP_AUDIO_MATV_VOLUME = 44;
    public static final int OP_AUDIO_MEDIA_VOLUME = 36;
    public static final int OP_AUDIO_NOTIFICATION_VOLUME = 38;
    public static final int OP_AUDIO_RING_VOLUME = 35;
    public static final int OP_AUDIO_VOICE_VOLUME = 34;
    public static final int OP_AUTORUN = 65;
    public static final int OP_CALL_PHONE = 13;
    public static final int OP_CAMERA = 76;
    public static final int OP_COARSE_LOCATION = 0;
    public static final int OP_CONNECT_INTERNET = 58;
    public static final int OP_DELETE_CALL_LOG = 64;
    public static final int OP_DELETE_CONTACTS = 63;
    public static final int OP_DELETE_MMS = 62;
    public static final int OP_DELETE_SMS = 61;
    public static final int OP_DIR_FILES = 202;
    public static final int OP_DIR_GALLERY = 201;
    public static final int OP_DIR_STORAGE_FG = 211;
    public static final int OP_ENABLE_BLUETOOTH = 77;
    public static final int OP_ENABLE_MOBILE_DATA = 69;
    public static final int OP_ENABLE_WIFI = 68;
    public static final int OP_FINE_LOCATION = 1;
    public static final int OP_FUZZY_LOCATION = 110;
    public static final int OP_GET_INSTALL_PKG = 56;
    public static final int OP_GPS = 2;
    public static final int OP_LOCAL_NETWORK = 112;
    public static final int OP_LOCATION = 75;
    public static final int OP_MAC_ADDRESS = 80;
    public static final int OP_MONITOR_HIGH_POWER_LOCATION = 42;
    public static final int OP_MONITOR_LOCATION = 41;
    public static final int OP_NEIGHBORING_CELLS = 12;
    public static final int OP_NONE = -1;
    public static final int OP_PLAY_AUDIO = 28;
    public static final int OP_POST_NOTIFICATION = 11;
    public static final int OP_PROJECT_MEDIA = 46;
    public static final int OP_READ_CALENDAR = 8;
    public static final int OP_READ_CALL_LOG = 6;
    public static final int OP_READ_CLIPBOARD = 29;
    public static final int OP_READ_CONTACTS = 4;
    public static final int OP_READ_DIR_ANDROID = 207;
    public static final int OP_READ_DIR_AUDIO = 203;
    public static final int OP_READ_DIR_DOCUMENTS = 206;
    public static final int OP_READ_DIR_DOWNLOAD = 205;
    public static final int OP_READ_DIR_GALLERY = 204;
    public static final int OP_READ_DIR_HIDE = 209;
    public static final int OP_READ_DIR_OTHER = 208;
    public static final int OP_READ_DIR_ROOT_FILE = 210;
    public static final int OP_READ_ICC_SMS = 21;
    public static final int OP_READ_MMS = 66;
    public static final int OP_READ_PHONE_STATE = 73;
    public static final int OP_READ_SMS = 14;
    public static final int OP_RECEIVE_EMERGECY_SMS = 17;
    public static final int OP_RECEIVE_MMS = 18;
    public static final int OP_RECEIVE_SMS = 16;
    public static final int OP_RECEIVE_WAP_PUSH = 19;
    public static final int OP_RECORD_AUDIO = 27;
    public static final int OP_SEND_MMS = 67;
    public static final int OP_SEND_SHORTCUT_BROADCAST = 59;
    public static final int OP_SEND_SMS = 20;
    public static final int OP_SENSOR_EVENT = 78;
    public static final int OP_SYSTEM_ALERT_WINDOW = 24;
    public static final int OP_TAKE_AUDIO_FOCUS = 32;
    public static final int OP_TAKE_MEDIA_BUTTONS = 31;
    public static final int OP_VIBRATE = 3;
    public static final int OP_WAKE_LOCK = 40;
    public static final int OP_WIFI_SCAN = 10;
    public static final int OP_WRITE_CALENDAR = 9;
    public static final int OP_WRITE_CALL_LOG = 7;
    public static final int OP_WRITE_CLIPBOARD = 30;
    public static final int OP_WRITE_CONTACTS = 5;
    public static final int OP_WRITE_ICC_SMS = 22;
    public static final int OP_WRITE_MMS = 60;
    public static final int OP_WRITE_SETTINGS = 23;
    public static final int OP_WRITE_SMS = 15;
    public static final int _NUM_OP = 80;
    public static final int[] DIR_OP_ALL = {203, 204, 205, 206, 207, 208, 209, 210};
    public static final int[] DIR_VIRTUAL_OP = {203, 204, 205, 206, 207, 209};
    private static final int[] CTA_PERMISSIONS_OPS = {4, 5, 20, 14, 15, 18, 16, 0, 1, 65, 51, 13, 6, 7, 89, 27, 26, 46, 79, 8, 9, 47, 94, 56, 55, 78, 85, 83, 81};
    private static final BitSet CTA_PERMISSIONS_BITSET = new BitSet();

    private CtaOpCodes() {
    }

    static {
        for (int op : CTA_PERMISSIONS_OPS) {
            if (op >= 0) {
                CTA_PERMISSIONS_BITSET.set(op);
            }
        }
    }

    public static boolean isCtaOps(int op) {
        return op >= 0 && CTA_PERMISSIONS_BITSET.get(op);
    }

    public static boolean isDirOp(int op) {
        for (int dirOp : DIR_OP_ALL) {
            if (dirOp == op) {
                return true;
            }
        }
        return false;
    }

    public static boolean matchEmOp(int op) {
        return op == 101 || op == 102 || op == 114 || op == 103 || op == 105 || op == 106 || op == 104 || op == 108 || op == 107;
    }

    public static boolean isNotShowOp(int op) {
        return op == 59 || op == 78;
    }

    public static boolean filterOp(int op) {
        return op == 26 || op == 27 || op == 0 || op == 1 || op == 41 || op == 42 || op == 2 || op == 4 || op == 5 || op == 20 || op == 14 || op == 29 || op == 30;
    }

    public static boolean filterBackgroundOp(int op) {
        return filterOp(op) || op == 59 || op == 60 || op == 6;
    }

    public static boolean filterAppHistoricalsOp(int op) {
        return op == 13 || op == 51 || op == 20 || op == 14 || op == 4 || op == 5 || op == 62 || op == 6 || op == 7 || op == 26 || op == 27 || op == 0 || op == 1 || op == 2 || op == 41 || op == 42 || op == 8 || op == 9 || op == 59 || op == 60 || op == 81 || op == 83 || op == 85 || op == 23 || op == 29 || op == 46 || op == 79 || op == 30 || op == 91;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int matchUriToOp(java.lang.String r2) {
        /*
            r0 = -1
            if (r2 != 0) goto L4
            return r0
        L4:
            int r1 = r2.hashCode()
            switch(r1) {
                case -845193793: goto L3e;
                case -456066902: goto L34;
                case -172298781: goto L2a;
                case 108243: goto L20;
                case 114009: goto L16;
                case 1181890399: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L48
        Lc:
            java.lang.String r1 = "mms-sms"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto Lb
            r1 = 2
            goto L49
        L16:
            java.lang.String r1 = "sms"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto Lb
            r1 = 0
            goto L49
        L20:
            java.lang.String r1 = "mms"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto Lb
            r1 = 1
            goto L49
        L2a:
            java.lang.String r1 = "call_log"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto Lb
            r1 = 4
            goto L49
        L34:
            java.lang.String r1 = "com.android.calendar"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto Lb
            r1 = 5
            goto L49
        L3e:
            java.lang.String r1 = "com.android.contacts"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto Lb
            r1 = 3
            goto L49
        L48:
            r1 = r0
        L49:
            switch(r1) {
                case 0: goto L56;
                case 1: goto L56;
                case 2: goto L56;
                case 3: goto L53;
                case 4: goto L50;
                case 5: goto L4d;
                default: goto L4c;
            }
        L4c:
            goto L58
        L4d:
            r0 = 106(0x6a, float:1.49E-43)
            goto L58
        L50:
            r0 = 105(0x69, float:1.47E-43)
            goto L58
        L53:
            r0 = 103(0x67, float:1.44E-43)
            goto L58
        L56:
            r0 = 102(0x66, float:1.43E-43)
        L58:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.CtaOpCodes.matchUriToOp(java.lang.String):int");
    }
}
