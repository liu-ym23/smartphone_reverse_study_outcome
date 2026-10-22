package com.android.server;

import android.os.FileUtils;
import android.os.UEventObserver;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Slog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ExtconUEventObserver extends UEventObserver {
    private static final boolean LOG = false;
    private static final String SELINUX_POLICIES_NEED_TO_BE_CHANGED = "This probably means the selinux policies need to be changed.";
    private static final String TAG = "ExtconUEventObserver";
    private final Map<String, ExtconInfo> mExtconInfos;

    public static final class ExtconInfo {
        public static final String EXTCON_CHARGE_DOWNSTREAM = "CHARGE-DOWNSTREAM";
        public static final String EXTCON_DOCK = "DOCK";
        public static final String EXTCON_DVI = "DVI";
        public static final String EXTCON_FAST_CHARGER = "FAST-CHARGER";
        public static final String EXTCON_HDMI = "HDMI";
        public static final String EXTCON_HEADPHONE = "HEADPHONE";
        public static final String EXTCON_JIG = "JIG";
        public static final String EXTCON_LINE_IN = "LINE-IN";
        public static final String EXTCON_LINE_OUT = "LINE-OUT";
        public static final String EXTCON_MECHANICAL = "MECHANICAL";
        public static final String EXTCON_MHL = "MHL";
        public static final String EXTCON_MICROPHONE = "MICROPHONE";
        public static final String EXTCON_SLOW_CHARGER = "SLOW-CHARGER";
        public static final String EXTCON_SPDIF_IN = "SPDIF-IN";
        public static final String EXTCON_SPDIF_OUT = "SPDIF-OUT";
        public static final String EXTCON_TA = "TA";
        public static final String EXTCON_USB = "USB";
        public static final String EXTCON_USB_HOST = "USB-HOST";
        public static final String EXTCON_VGA = "VGA";
        public static final String EXTCON_VIDEO_IN = "VIDEO-IN";
        public static final String EXTCON_VIDEO_OUT = "VIDEO-OUT";
        private static ExtconInfo[] sExtconInfos;
        private static final Object sLock = null;
        private final HashSet<String> mDeviceTypes;
        private final String mName;

        public @interface ExtconDeviceType {
        }

        /* JADX INFO: renamed from: $r8$lambda$aL2TC_hzbnWU0amCOmH3M-_vJvQ, reason: not valid java name */
        public static /* synthetic */ boolean m227$r8$lambda$aL2TC_hzbnWU0amCOmH3M_vJvQ(File r0, String r1) {
            return lambda$new$0(r0, r1);
        }

        static {
            sLock = new Object();
            sExtconInfos = null;
        }

        private static void initExtconInfos() {
            if (sExtconInfos == null) goto L5;
            return;
        L5:
            File file = new File("/sys/class/extcon");
            File[] files = file.listFiles();
            if (files != null) goto L8;
            Slog.w(ExtconUEventObserver.TAG, file + " exists " + file.exists() + " isDir " + file.isDirectory() + " but listFiles returns null." + ExtconUEventObserver.SELINUX_POLICIES_NEED_TO_BE_CHANGED);
            sExtconInfos = new ExtconInfo[0];
            return;
        L8:
            List<ExtconInfo> list = new ArrayList(files.length);
            int r4 = files.length;
            int r5 = 0;
        L9:
            if (r5 >= r4) goto L11;
            File f = files[r5];
            list.add(new ExtconInfo(f.getName()));
            r5 = r5 + 1;
            goto L9
        L11:
            sExtconInfos = (ExtconInfo[]) list.toArray(new ExtconInfo[0]);
        }

        public static List<ExtconInfo> getExtconInfoForTypes(String[] extconTypes) {
            Object r0 = sLock;
            monitor-enter(r0);
            initExtconInfos();     // Catch: Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L17
            List<ExtconInfo> extcons = new ArrayList();
            ExtconInfo[] r1 = sExtconInfos;
            int r2 = r1.length;
            int r4 = 0;
        L7:
            if (r4 >= r2) goto L16;
            ExtconInfo extcon = r1[r4];
            int r6 = extconTypes.length;
            int r7 = 0;
        L10:
            if (r7 >= r6) goto L15;
            String type = extconTypes[r7];
            if (extcon.hasCableType(type) == true) goto L13;
            r7 = r7 + 1;
            goto L10
        L13:
            extcons.add(extcon);
        L15:
            r4 = r4 + 1;
            goto L7
        L16:
            return extcons;
        L17:
            th = move-exception;
            throw th;
        }

        public boolean hasCableType(String type) {
            return this.mDeviceTypes.contains(type);
        }

        private ExtconInfo(String extconName) {
            this.mDeviceTypes = new HashSet();
            this.mName = extconName;
            File[] cableDirs = FileUtils.listFilesOrEmpty(new File("/sys/class/extcon", this.mName), new ExtconUEventObserver$ExtconInfo$$ExternalSyntheticLambda0());
            if (cableDirs.length != 0) goto L5;
            Slog.d(ExtconUEventObserver.TAG, "Unable to list cables in /sys/class/extcon/" + this.mName + ". " + ExtconUEventObserver.SELINUX_POLICIES_NEED_TO_BE_CHANGED);
        L5:
            int r2 = cableDirs.length;
            int r6 = 0;
        L6:
            if (r6 >= r2) goto L13;
            File cableDir = cableDirs[r6];
            String cableCanonicalPath = null;
            cableCanonicalPath = cableDir.getCanonicalPath();     // Catch: IOException -> L10
            String name = FileUtils.readTextFile(new File(cableDir, "name"), 0, null);     // Catch: IOException -> L10
            this.mDeviceTypes.add(name.replace("\n", "").replace("\r", ""));     // Catch: IOException -> L10
        L12:
            r6 = r6 + 1;
        L10:
            ex = move-exception;
            Slog.w(ExtconUEventObserver.TAG, "Unable to read " + cableCanonicalPath + "/name. " + ExtconUEventObserver.SELINUX_POLICIES_NEED_TO_BE_CHANGED, ex);
            goto L12
        }

        private static /* synthetic */ boolean lambda$new$0(File dir, String cable) {
            return cable.startsWith("cable.");
        }

        public String getName() {
            return this.mName;
        }

        public String getDevicePath() {
            String extconPath = TextUtils.formatSimple("/sys/class/extcon/%s", new Object[]{this.mName});     // Catch: IOException -> L7
            File devPath = new File(extconPath);     // Catch: IOException -> L7
            if (devPath.exists() == false) goto L9;
            String canonicalPath = devPath.getCanonicalPath();     // Catch: IOException -> L7
            int start = canonicalPath.indexOf("/devices");     // Catch: IOException -> L7
            return canonicalPath.substring(start);
        L9:
            return null;
        L7:
            e = move-exception;
            Slog.e(ExtconUEventObserver.TAG, "Could not get the extcon device path for " + this.mName, e);
            return null;
        }

        public String getStatePath() {
            return TextUtils.formatSimple("/sys/class/extcon/%s/state", new Object[]{this.mName});
        }
    }

    protected abstract void onUEvent(ExtconInfo r1, UEventObserver.UEvent r2);

    public ExtconUEventObserver() {
        this.mExtconInfos = new ArrayMap();
    }

    public final void onUEvent(UEventObserver.UEvent event) {
        String devPath = event.get("DEVPATH");
        ExtconInfo info = this.mExtconInfos.get(devPath);
        if (info == null) goto L5;
        onUEvent(info, event);
        return;
    L5:
        Slog.w(TAG, "No match found for DEVPATH of " + event + " in " + this.mExtconInfos);
    }

    public void startObserving(ExtconInfo extconInfo) {
        String devicePath = extconInfo.getDevicePath();
        if (devicePath != null) goto L5;
        Slog.wtf(TAG, "Unable to start observing  " + extconInfo.getName() + " because the device path is null. " + SELINUX_POLICIES_NEED_TO_BE_CHANGED);
        return;
    L5:
        this.mExtconInfos.put(devicePath, extconInfo);
        startObserving("DEVPATH=" + devicePath);
    }

    public static boolean extconExists() {
        File extconDir = new File("/sys/class/extcon");
        if (extconDir.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (extconDir.isDirectory() == false) goto L7;
        return true;
    }
}
