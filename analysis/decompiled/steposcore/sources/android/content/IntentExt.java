package android.content;

import android.content.Intent;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class IntentExt {
    public static final String STEPOS_ACTION_CAMERA_CLOSE = "com.stepos.action.CAMERA_CLOSE";
    public static final String STEPOS_ACTION_CAMERA_OPEN = "com.stepos.action.CAMERA_OPEN";
    public static final String STEPOS_ACTION_DEVICE_CONNECTION_STATE_CHANGED = "com.stepos.action.DEVICE_CONNECTION_STATE_CHANGED";
    public static final String STEPOS_ACTION_DISPLAY_RESET = "com.stepos.action.DISPLAY_RESET";
    public static final String STEPOS_ACTION_DO_NOT_DISTURB_END = "com.stepos.action.DO_NOT_DISTURB_END";
    public static final String STEPOS_ACTION_DO_NOT_DISTURB_START = "com.stepos.action.DO_NOT_DISTURB_START";
    public static final String STEPOS_ACTION_DRIVER_MODE_START = "com.stepos.action.DRIVER_MODE_START";
    public static final String STEPOS_ACTION_DRIVER_MODE_STOP = "com.stepos.action.DRIVER_MODE_STOP";
    public static final String STEPOS_ACTION_FINDPHONE_LOCK = "com.stepos.action.FINDPHONE_LOCK";
    public static final String STEPOS_ACTION_FINDPHONE_MESSAGE = "com.stepos.action.FINDPHONE_MESSAGE";
    public static final String STEPOS_ACTION_FINDPHONE_STATE_CHANGED = "com.stepos.action.FINDPHONE_STATE_CHANGED";
    public static final String STEPOS_ACTION_FINDPHONE_UNLOCK = "com.stepos.action.FINDPHONE_UNLOCK";
    public static final String STEPOS_ACTION_FOLDER_SEND = "com.stepos.action.FOLDER_SEND";
    public static final String STEPOS_ACTION_FOLDER_SEND_MULTIPLE = "com.stepos.action.FOLDER_SEND_MULTIPLE";
    public static final String STEPOS_ACTION_HANDOVER_SEND = "com.stepos.action.HANDOVER_SEND";
    public static final String STEPOS_ACTION_HANDOVER_SEND_MULTIPLE = "com.stepos.action.HANDOVER_SEND_MULTIPLE";
    public static final String STEPOS_ACTION_HDR_MODE = "com.stepos.action.HDRModeSwitch";
    public static final String STEPOS_ACTION_LOCK_WALLPAPER_CHANGED = "com.stepos.action.LOCK_WALLPAPER_CHANGED";
    public static final String STEPOS_ACTION_MTP_LOCK = "com.stepos.action.MTPLOCK";
    public static final String STEPOS_ACTION_MTP_OPEN = "com.stepos.action.MTP_OPEN";
    public static final String STEPOS_ACTION_MTP_START_SERVICE = "com.stepos.action.MTP_START_SERVICE";
    public static final String STEPOS_ACTION_PACKAGE_FIRST_LAUNCH = "com.stepos.action.PACKAGE_FIRST_LAUNCH";
    public static final String STEPOS_ACTION_RECOMMEND = "com.stepos.action.RECOMMEND";
    public static final String STEPOS_ACTION_RESTART = "com.stepos.action.RESTART";
    public static final String STEPOS_ACTION_SCAN_EXTERNAL_VOLUME = "com.stepos.action.SCAN_EXTERNAL_VOLUME";
    public static final String STEPOS_ACTION_SCHEDULED_POWEROFF = "com.stepos.action.SCHEDULED_POWEROFF";
    public static final String STEPOS_ACTION_SCHEDULED_POWERON = "com.stepos.action.SCHEDULED_POWERON";
    public static final String STEPOS_ACTION_SEND_NFC_TEXT = "com.stepos.action.SEND_NFC_TEXT";
    public static final String STEPOS_ACTION_STEPOS_DEVICE_NAME_CHANGE = "com.stepos.action.STEPOS_DEVICE_NAME_CHANGE";
    public static final String STEPOS_ACTION_STEPOS_FILE_CHANGED = "com.stepos.action.STEPOS_FILE_CHANGED";
    public static final String STEPOS_ACTION_STEPOS_FINDPHONE_UNLOCK = "com.stepos.action.FINDPHONE_UNLOCK";
    public static final String STEPOS_ACTION_SUB_DISPLAY_SCREEN_OFF = "com.stepos.action.SUB_DISPLAY_SCREEN_OFF";
    public static final String STEPOS_ACTION_SUB_DISPLAY_SCREEN_ON = "com.stepos.action.SUB_DISPLAY_SCREEN_ON";
    public static final String STEPOS_ACTION_SWITCH_CHILD_MODE = "com.stepos.action.SWITCH_CHILD_MODE";
    public static final String STEPOS_ACTION_SWITCH_SYSTEM_MODE = "com.stepos.action.SWITCH_SYSTEM_MODE";
    public static final String STEPOS_ACTION_THEME_CHANGED = "com.stepos.action.THEME_CHANGED";
    public static final String STEPOS_ACTION_VIDEO_MODE_CHANGE = "com.stepos.action.VideoModeChange";
    public static final String STEPOS_ACTION_VPN_PROFILE_CHANGED = "com.stepos.action.VPN_PROFILE_CHANGED";
    public static final String STEPOS_ACTION_VPN_STATE_CHANGED = "com.stepos.action.VPN_STATE_CHANGED";
    public static final String STEPOS_ACTION_VPN_STATE_SWITCH = "com.stepos.action.VPN_STATE_SWITCH";
    public static final String STEPOS_ACTION_WIFIP2P_SENDFILE_MODE = "com.stepos.action.WIFIP2P_SENDFILE_MODE";
    public static final String STEPOS_ACTION_WINDOW_MODE_CHANGED = "com.stepos.action.WINDOW_MODE_CHANGED";
    public static final String STEPOS_ACTION_WINDOW_MODE_VISIBLE = "com.stepos.action.WINDOW_MODE_VISIBLE";
    public static final int STEPOS_FLAG_ACTIVITYINFO_BLACKLIST = 33554432;
    public static final int STEPOS_FLAG_ACTIVITYINFO_WHITELIST = 67108864;
    public static final int STEPOS_FLAG_ACTIVITY_FAST_STARTING = 32;
    public static final int STEPOS_FLAG_ACTIVITY_SECURITY_START = 128;
    public static final int STEPOS_FLAG_ACTIVITY_START_FROM_KEYGUARD = 16;
    public static final int STEPOS_FLAG_CLICK_NOTIFICATION_START_ACTION = 134217728;
    public static final int STEPOS_FLAG_DISABLE_SNAPSHOT = Integer.MIN_VALUE;
    public static final int STEPOS_FLAG_FORCE_FULL_SCREEN = 512;
    public static final int STEPOS_FLAG_IMMEDIATE_BROADCAST = 268435456;
    public static final int STEPOS_FLAG_KEEP_SHOW_FOR_KEYGUARD = 1048576;
    public static final int STEPOS_FLAG_LAUNCH_APP_BEHIND = 536870912;
    public static final int STEPOS_FLAG_LAUNCH_APP_BEHIND_HIDE_RECENT = 1073741824;
    public static final int STEPOS_FLAG_PAUSE_FULL_TASK = 1024;
    public static final int STEPOS_FLAG_PREVIEW_ON_KEYGUARD = 131072;
    public static final int STEPOS_FLAG_REMOVE_SECOND_ACTIVITY = 64;
    public static final int STEPOS_FLAG_SPLIT_MODE = 65536;
    public static final int STEPOS_FLAG_START_FORM_APP_SWITCH = 256;
    public static final int STEPOS_FLAG_START_FROM_ALARM = 8192;
    public static final int STEPOS_FLAG_START_FROM_DISPLAY_SWITCH_COMMIT = 16384;
    public static final int STEPOS_FLAG_START_FROM_JOB_SERVICE = 4194304;
    public static final int STEPOS_FLAG_START_FROM_LAUNCHER = 262144;
    public static final int STEPOS_FLAG_START_FROM_NOTIFICATION = 2097152;
    public static final int STEPOS_FLAG_START_FROM_REMOTE = 524288;
    public static final int STEPOS_FLAG_START_FROM_SYNC_SERVICE = 4096;
    public static final int STEPOS_FLAG_UNINSTALL = 16777216;
    public static final int STEPOS_FLAG_UN_RESIZE_TASK = 2048;
    public static final int STEPOS_FLAG_WINDOW_MODE_APP = 8388608;
    public static final int STEPOS_FLAG_WM_SPECIAL_SIZE = 32768;

    private IntentExt() {
    }

    private static Intent.StepOSExtData getOrCreateData(Intent intent) {
        if (intent.mStepOSExtData == null) {
            intent.mStepOSExtData = new Intent.StepOSExtData();
        }
        return intent.mStepOSExtData;
    }

    public static int getStepOSFlags(Intent intent) {
        if (intent == null || intent.mStepOSExtData == null) {
            return 0;
        }
        return intent.mStepOSExtData.flags;
    }

    public static void setStepOSFlags(Intent intent, int flags) {
        if (intent == null) {
            return;
        }
        getOrCreateData(intent).flags = flags;
    }

    public static void addStepOSFlags(Intent intent, int flags) {
        if (intent == null || flags == 0) {
            return;
        }
        getOrCreateData(intent).flags |= flags;
    }

    public static void removeStepOSFlags(Intent intent, int flags) {
        if (intent != null && intent.mStepOSExtData != null) {
            intent.mStepOSExtData.flags &= ~flags;
        }
    }

    public static boolean hasStepOSFlag(Intent intent, int flag) {
        return (getStepOSFlags(intent) & flag) != 0;
    }

    public static void setAccessSrcPkg(Intent intent, String pkgName) {
        if (intent == null) {
            return;
        }
        getOrCreateData(intent).accessSrcPkg = pkgName;
    }

    public static String getAccessSrcPkg(Intent intent) {
        if (intent == null || intent.mStepOSExtData == null) {
            return null;
        }
        return intent.mStepOSExtData.accessSrcPkg;
    }

    public static void setAccessSrcFlags(Intent intent, int flags) {
        if (intent == null) {
            return;
        }
        getOrCreateData(intent).accessSrcFlags = flags;
    }

    public static int getAccessSrcFlags(Intent intent) {
        if (intent == null || intent.mStepOSExtData == null) {
            return 0;
        }
        return intent.mStepOSExtData.accessSrcFlags;
    }

    public static void setAccessSrcClassName(Intent intent, String className) {
        if (intent == null) {
            return;
        }
        getOrCreateData(intent).accessSrcClassName = className;
    }

    public static String getAccessSrcClassName(Intent intent) {
        if (intent == null || intent.mStepOSExtData == null) {
            return null;
        }
        return intent.mStepOSExtData.accessSrcClassName;
    }

    public static void setInterceptSrcPkg(Intent intent, String pkgName) {
        if (intent == null) {
            return;
        }
        getOrCreateData(intent).interceptSrcPkg = pkgName;
    }

    public static String getInterceptSrcPkg(Intent intent) {
        if (intent == null || intent.mStepOSExtData == null) {
            return null;
        }
        return intent.mStepOSExtData.interceptSrcPkg;
    }

    public static void setAccessPackageName(Intent intent, String pkgName) {
        if (intent == null) {
            return;
        }
        getOrCreateData(intent).accessPkg = pkgName;
    }

    public static String getAccessPackageName(Intent intent) {
        if (intent == null || intent.mStepOSExtData == null) {
            return null;
        }
        return intent.mStepOSExtData.accessPkg;
    }

    public static void setMiniAppId(Intent intent, String appId) {
        if (intent == null) {
            return;
        }
        getOrCreateData(intent).miniAppId = appId;
    }

    public static String getMiniAppId(Intent intent) {
        if (intent == null || intent.mStepOSExtData == null) {
            return null;
        }
        return intent.mStepOSExtData.miniAppId;
    }

    public static void copyIntent(Intent dst, Intent src) {
        if (dst == null || src == null || src.mStepOSExtData == null) {
            return;
        }
        Intent.StepOSExtData srcData = src.mStepOSExtData;
        Intent.StepOSExtData dstData = getOrCreateData(dst);
        dstData.flags = srcData.flags;
        dstData.accessSrcFlags = srcData.accessSrcFlags;
        dstData.accessSrcPkg = srcData.accessSrcPkg;
        dstData.accessSrcClassName = srcData.accessSrcClassName;
        dstData.interceptSrcPkg = srcData.interceptSrcPkg;
        dstData.miniAppId = srcData.miniAppId;
        dstData.accessPkg = srcData.accessPkg;
    }

    public static void copyFlags(Intent dst, Intent src) {
        if (dst == null || src == null || src.mStepOSExtData == null) {
            return;
        }
        getOrCreateData(dst).flags = src.mStepOSExtData.flags;
    }

    public static void writeIntentExt(Parcel out, Intent intent) {
        if (intent == null || intent.mStepOSExtData == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        Intent.StepOSExtData data = intent.mStepOSExtData;
        out.writeInt(data.flags);
        out.writeInt(data.accessSrcFlags);
        out.writeString(data.accessSrcPkg);
        out.writeString(data.accessSrcClassName);
        out.writeString(data.interceptSrcPkg);
        out.writeString(data.miniAppId);
        out.writeString(data.accessPkg);
    }

    public static void readIntentExt(Parcel in, Intent intent) {
        if (intent == null) {
            return;
        }
        int hasData = in.readInt();
        if (hasData == 0) {
            intent.mStepOSExtData = null;
            return;
        }
        Intent.StepOSExtData data = getOrCreateData(intent);
        data.flags = in.readInt();
        data.accessSrcFlags = in.readInt();
        data.accessSrcPkg = in.readString();
        data.accessSrcClassName = in.readString();
        data.interceptSrcPkg = in.readString();
        data.miniAppId = in.readString();
        data.accessPkg = in.readString();
    }

    public static String toFlagsString(Intent intent) {
        int flags = getStepOSFlags(intent);
        if (flags == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if ((flags & 16) != 0) {
            sb.append("KEYGUARD|");
        }
        if ((flags & 32) != 0) {
            sb.append("FAST_START|");
        }
        if ((flags & 128) != 0) {
            sb.append("SECURITY|");
        }
        if ((flags & 256) != 0) {
            sb.append("APP_SWITCH|");
        }
        if ((flags & 512) != 0) {
            sb.append("FORCE_FULL|");
        }
        if ((flags & 1024) != 0) {
            sb.append("PAUSE_TASK|");
        }
        if ((flags & 2048) != 0) {
            sb.append("UN_RESIZE|");
        }
        if ((32768 & flags) != 0) {
            sb.append("SPECIAL_SIZE|");
        }
        if ((65536 & flags) != 0) {
            sb.append("SPLIT|");
        }
        if ((2097152 & flags) != 0) {
            sb.append("NOTIFICATION|");
        }
        if ((8388608 & flags) != 0) {
            sb.append("WINDOW_MODE|");
        }
        if ((268435456 & flags) != 0) {
            sb.append("IMMEDIATE_BC|");
        }
        if ((536870912 & flags) != 0) {
            sb.append("BEHIND|");
        }
        if ((Integer.MIN_VALUE & flags) != 0) {
            sb.append("NO_SNAPSHOT|");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String toShortString(Intent intent) {
        if (intent == null || intent.mStepOSExtData == null) {
            return "IntentExt{null}";
        }
        Intent.StepOSExtData d = intent.mStepOSExtData;
        return "IntentExt{flags=0x" + Integer.toHexString(d.flags) + ", srcPkg=" + d.accessSrcPkg + ", miniApp=" + d.miniAppId + "}";
    }

    @Deprecated
    public static Intent.StepOSExtData getIntentExt(Intent intent) {
        if (intent == null) {
            return null;
        }
        return getOrCreateData(intent);
    }
}
