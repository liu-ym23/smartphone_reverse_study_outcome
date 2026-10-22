package android.app;

import android.content.ContextExt;
import android.os.ServiceManager;
import android.os.StepOSCtsUtils;
import android.permission.IStepOSPermissionService;
import android.text.TextUtils;
import android.util.Log;
import android.util.StepOSDateTimeUrlHelper;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class CtaDirAccessStore {
    public static final String DIRECTORY_ALARMS = "Alarms";
    public static final String DIRECTORY_ANDROID = "Android";
    public static final String DIRECTORY_AUDIOBOOKS = "Audiobooks";
    public static final String DIRECTORY_DCIM = "DCIM";
    public static final String DIRECTORY_DOCUMENTS = "Documents";
    public static final String DIRECTORY_DOWNLOADS = "Download";
    public static final String DIRECTORY_MEDIA = "media";
    public static final String DIRECTORY_MOVIES = "Movies";
    public static final String DIRECTORY_MUSIC = "Music";
    public static final String DIRECTORY_NOTIFICATIONS = "Notifications";
    public static final String DIRECTORY_PICTURES = "Pictures";
    public static final String DIRECTORY_PODCASTS = "Podcasts";
    public static final String DIRECTORY_RINGTONES = "Ringtones";
    public static final String DIRECTORY_THUMBNAILS = ".thumbnails";
    private static final String TAG = "CtaDirAccessStore";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final List<String> NATIVE_DIRECTORY_NAMES = Collections.unmodifiableList(Arrays.asList("Music", "Podcasts", "Ringtones", "Alarms", "Notifications", "Audiobooks", "Download", "Documents", "Pictures", "DCIM", "Movies", ".thumbnails", "media", "Android"));

    private CtaDirAccessStore() {
    }

    public static String getFileName(String filepath) {
        if (TextUtils.isEmpty(filepath)) {
            return "";
        }
        String path = filepath;
        if (path.endsWith(StepOSDateTimeUrlHelper.BACKSLASH_STRING)) {
            int index = path.lastIndexOf(StepOSDateTimeUrlHelper.BACKSLASH_STRING);
            path = path.substring(0, index);
        }
        int start = path.lastIndexOf(StepOSDateTimeUrlHelper.BACKSLASH_STRING);
        return start == -1 ? path : path.substring(start + 1);
    }

    public static boolean accept(File file, String path, String name) {
        if (TextUtils.isEmpty(name) || !file.exists() || file.isHidden()) {
            return false;
        }
        for (String nativeName : NATIVE_DIRECTORY_NAMES) {
            if (nativeName.equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    public static int checkTopDirAccessPermission(String pkg, String topName, String path) {
        return 0;
    }

    public static void wirteTopDirAccessPermission(String pkg, String topName, int value) {
        if (DEBUG) {
            Log.d(TAG, "wirteTopDirAccessPermission: " + pkg + " " + topName + " value=" + value);
        }
        try {
            IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).wirteTopDirAccessPermission(pkg, topName, value);
        } catch (Exception e) {
            Log.w(TAG, "wirteTopDirAccessPermission failed", e);
        }
    }

    public static void wirteTopDirAccessPermissionDefault(String pkg, String topName, int value, int tag, int priority) {
        Exception e;
        if (DEBUG) {
            Log.d(TAG, "wirteTopDirAccessPermissionDefault: " + pkg + " " + topName + " value=" + value);
        }
        try {
        } catch (Exception e2) {
            e = e2;
        }
        try {
            IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).wirteTopDirAccessPermissionDefault(pkg, topName, value, tag, priority);
        } catch (Exception e3) {
            e = e3;
            Log.w(TAG, "wirteTopDirAccessPermissionDefault failed", e);
        }
    }

    public static String getPkgForExclusiveDirectory(String callerPkg, String topName, String path) {
        try {
            return IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).getPkgForExclusiveDirectory(callerPkg, topName, path);
        } catch (Exception e) {
            Log.w(TAG, "getPkgForExclusiveDirectory failed", e);
            return null;
        }
    }

    public static int checkPkgForExclusiveDirectory(String pkg, String topName, String path) {
        if (StepOSCtsUtils.isCtsRunning()) {
            if (DEBUG) {
                Log.d(TAG, "checkPkgForExclusiveDirectory: " + pkg + " " + topName + " " + path + " cts is running, allow");
            }
            return 0;
        }
        if (DEBUG) {
            Log.d(TAG, "checkPkgForExclusiveDirectory: " + pkg + " " + topName);
        }
        try {
            return IStepOSPermissionService.Stub.asInterface(ServiceManager.getService(ContextExt.STEPOS_PERMISSION)).checkPkgForExclusiveDirectory(pkg, topName, path);
        } catch (Exception e) {
            Log.w(TAG, "checkPkgForExclusiveDirectory failed", e);
            return 0;
        }
    }
}
