package com.android.server.wm;

import android.app.AppGlobals;
import android.app.compat.CompatChanges;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.Xml;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.SysOptBridge;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.PackageManagerService;
import com.android.server.power.IBytedancePowerAdvisor;
import com.android.server.scene.SceneUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public final class CompatModePackages {
    private static final int COMPAT_FLAG_DONT_ASK = 1;
    private static final int COMPAT_FLAG_ENABLED = 2;
    public static final long DOWNSCALED = 168419799;
    public static final long DOWNSCALED_INVERSE = 273564678;
    public static final long DOWNSCALE_30 = 189970040;
    public static final long DOWNSCALE_35 = 189969749;
    public static final long DOWNSCALE_40 = 189970038;
    public static final long DOWNSCALE_45 = 189969782;
    public static final long DOWNSCALE_50 = 176926741;
    public static final long DOWNSCALE_55 = 189970036;
    public static final long DOWNSCALE_60 = 176926771;
    public static final long DOWNSCALE_65 = 189969744;
    public static final long DOWNSCALE_70 = 176926829;
    public static final long DOWNSCALE_75 = 189969779;
    public static final long DOWNSCALE_80 = 176926753;
    public static final long DOWNSCALE_85 = 189969734;
    public static final long DOWNSCALE_90 = 182811243;
    private static final long DO_NOT_DOWNSCALE_TO_1080P_ON_TV = 157629738;
    private static final int MSG_WRITE = 300;
    private static final String TAG = "ActivityTaskManager";
    private final AtomicFile mFile;
    private final CompatHandler mHandler;
    private final SparseBooleanArray mLegacyScreenCompatPackages;
    private final HashMap<String, Integer> mPackages;
    private final SparseArray<CompatScaleProvider> mProviders;
    private final ActivityTaskManagerService mService;

    private final class CompatHandler extends Handler {
        final /* synthetic */ CompatModePackages this$0;

        public CompatHandler(CompatModePackages r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 300: goto L5;
                default: goto L7;
            };
        L5:
            CompatModePackages.m9852$$Nest$msaveCompatModes(this.this$0);
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$fyPfwk2sJupIgrgLWv4GKb8kRIc(String r0, ArrayList r1, WindowState r2) {
        lambda$setPackageScreenCompatModeLocked$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msaveCompatModes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9852$$Nest$msaveCompatModes(CompatModePackages r0) {
        r0.saveCompatModes();
    }

    public CompatModePackages(ActivityTaskManagerService service, File systemDir, Handler handler) {
        this.mPackages = new HashMap();
        this.mLegacyScreenCompatPackages = new SparseBooleanArray();
        this.mProviders = new SparseArray();
        this.mService = service;
        this.mFile = new AtomicFile(new File(systemDir, "packages-compat.xml"), "compat-mode");
        this.mHandler = new CompatHandler(this, handler.getLooper());
        FileInputStream fis = null;
        fis = this.mFile.openRead();     // Catch: Throwable -> L9 IOException -> L11 XmlPullParserException -> L13
        TypedXmlPullParser parser = Xml.resolvePullParser(fis);     // Catch: Throwable -> L9 IOException -> L11 XmlPullParserException -> L13
        int eventType = parser.getEventType();     // Catch: Throwable -> L9 IOException -> L11 XmlPullParserException -> L13
    L5:
        if (eventType == 2) goto L15;
        if (eventType == 1) goto L15;
        eventType = parser.next();     // Catch: Throwable -> L9 IOException -> L11 XmlPullParserException -> L13
    L15:
        if (eventType != 1) goto L21;
        if (fis == null) goto L69;
        fis.close();     // Catch: IOException -> L19
        return;
    L20:
        return;
    L69:
        return;
    L21:
        String tagName = parser.getName();     // Catch: Throwable -> L9 IOException -> L11 XmlPullParserException -> L13
        if ("compat-packages".equals(tagName) == false) goto L36;
        int eventType2 = parser.next();     // Catch: Throwable -> L9 IOException -> L11 XmlPullParserException -> L13
    L24:
        if (eventType2 != 2) goto L34;
        String tagName2 = parser.getName();     // Catch: Throwable -> L9 IOException -> L11 XmlPullParserException -> L13
        if (parser.getDepth() != 2) goto L34;
        if (SceneUtils.KEY_PKG.equals(tagName2) == false) goto L34;
        String pkg = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L9 IOException -> L11 XmlPullParserException -> L13
        if (pkg == null) goto L34;
        int modeInt = parser.getAttributeInt(null, "mode", 0);     // Catch: Throwable -> L9 IOException -> L11 XmlPullParserException -> L13
        this.mPackages.put(pkg, Integer.valueOf(modeInt));     // Catch: Throwable -> L9 IOException -> L11 XmlPullParserException -> L13
        goto L34
    L34:
        eventType2 = parser.next();     // Catch: Throwable -> L9 IOException -> L11 XmlPullParserException -> L13
        if (eventType2 != 1) goto L24;
    L36:
        if (fis == null) goto L52;
        fis.close();     // Catch: IOException -> L39
        return;
    L52:
        return;
    L11:
        e = move-exception;
        if (fis == null) goto L44;
        Slog.w(TAG, "Error reading compat-packages", e);     // Catch: Throwable -> L9
    L44:
        if (fis == null) goto L71;
        fis.close();     // Catch: IOException -> L39
        return;
    L71:
        return;
    L13:
        e = move-exception;
        Slog.w(TAG, "Error reading compat-packages", e);     // Catch: Throwable -> L9
        if (fis == null) goto L72;
        fis.close();     // Catch: IOException -> L39
        return;
    L72:
        return;
    L74:
        return;
    L9:
        th = move-exception;
        if (0 != 0) goto L58;
    L57:
        throw th;
    L58:
        fis.close();     // Catch: IOException -> L56
        goto L57
    }

    public HashMap<String, Integer> getPackages() {
        return this.mPackages;
    }

    private int getPackageFlags(String packageName) {
        Integer flags = this.mPackages.get(packageName);
        if (flags != null) goto L7;
        return 0;
    L7:
        return flags.intValue();
    }

    public void handlePackageDataClearedLocked(String packageName) {
        removePackage(packageName);
    }

    public void handlePackageUninstalledLocked(String packageName) {
        removePackage(packageName);
    }

    private void removePackage(String packageName) {
        if (this.mPackages.containsKey(packageName) == false) goto L5;
        this.mPackages.remove(packageName);
        scheduleWrite();
    L5:
        this.mLegacyScreenCompatPackages.delete(packageName.hashCode());
    }

    public void handlePackageAddedLocked(String packageName, boolean updated) {
        ApplicationInfo ai = null;
        boolean mayCompat = false;
        ai = AppGlobals.getPackageManager().getApplicationInfo(packageName, 0, 0);     // Catch: RemoteException -> L5
    L6:
        if (ai != null) goto L8;
        return;
    L8:
        CompatibilityInfo ci = compatibilityInfoForPackageLocked(ai);
        if (ci.alwaysSupportsScreen() == false) goto L11;
    L15:
        if (updated == false) goto L23;
        if (mayCompat == false) goto L18;
        return;
    L18:
        if (this.mPackages.containsKey(packageName) == false) goto L25;
        this.mPackages.remove(packageName);
        scheduleWrite();
        return;
    L25:
        return;
    L23:
        return;
    L11:
        if (ci.neverSupportsScreen() == true) goto L15;
        mayCompat = true;
        goto L15
    }

    private void scheduleWrite() {
        this.mHandler.removeMessages(300);
        Message msg = this.mHandler.obtainMessage(300);
        this.mHandler.sendMessageDelayed(msg, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    boolean useLegacyScreenCompatMode(String packageName) {
        if (this.mLegacyScreenCompatPackages.size() != 0) goto L7;
        return false;
    L7:
        return this.mLegacyScreenCompatPackages.get(packageName.hashCode());
    }

    public CompatibilityInfo compatibilityInfoForPackageLocked(ApplicationInfo ai) {
        boolean forceCompat = getPackageCompatModeEnabledLocked(ai);
        CompatibilityInfo.CompatScale compatScale = getCompatScaleFromProvider(ai.packageName, ai.uid);
        if (compatScale == null) goto L5;
        float appScale = compatScale.mScaleFactor;
    L7:
        if (compatScale == null) goto L9;
        float densityScale = compatScale.mDensityScaleFactor;
    L10:
        Configuration config = this.mService.getGlobalConfiguration();
        CompatibilityInfo info = new CompatibilityInfo(ai, config.screenLayout, config.smallestScreenWidthDp, forceCompat, appScale, densityScale);
        if (ai.flags != 0) goto L13;
    L22:
        return info;
    L13:
        if (ai.sourceDir == null) goto L22;
        if (info.supportsScreen() == true) goto L20;
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(ai.packageName) == true) goto L20;
        Slog.i(TAG, "Use legacy screen compat mode: " + ai.packageName);
        this.mLegacyScreenCompatPackages.put(ai.packageName.hashCode(), true);
    L20:
        if (this.mLegacyScreenCompatPackages.size() <= 0) goto L22;
        this.mLegacyScreenCompatPackages.delete(ai.packageName.hashCode());
        goto L22
    L9:
        densityScale = appScale;
        goto L10
    L5:
        appScale = getCompatScale(ai.packageName, ai.uid, false);
        goto L7
    }

    float getCompatScale(String packageName, int uid) {
        return getCompatScale(packageName, uid, true);
    }

    private CompatibilityInfo.CompatScale getCompatScaleFromProvider(String packageName, int uid) {
        int i = 0;
    L4:
        if (i >= this.mProviders.size()) goto L9;
        CompatScaleProvider provider = this.mProviders.valueAt(i);
        CompatibilityInfo.CompatScale compatScale = provider.getCompatScale(packageName, uid);
        if (compatScale != null) goto L7;
        i = i + 1;
        goto L4
    L7:
        return compatScale;
    L9:
        return null;
    }

    private float getCompatScale(String packageName, int uid, boolean checkProviders) {
        IBytedancePowerAdvisor powerAdvisor = SysOptBridge.getFactory().getBytedancePowerAdvisorInstance();
        if (powerAdvisor == null) goto L9;
        if (packageName == null) goto L9;
        float scaleFactor = powerAdvisor.getCompatScaleFactor(packageName);
        if (scaleFactor <= 0.0f) goto L9;
        Slog.i(TAG, "getCompatScale: app resolution scaling, pkg: " + packageName + ", scaleFactor: " + scaleFactor);
        return scaleFactor;
    L9:
        if (checkProviders == false) goto L14;
        CompatibilityInfo.CompatScale compatScale = getCompatScaleFromProvider(packageName, uid);
        if (compatScale == null) goto L14;
        return compatScale.mScaleFactor;
    L14:
        UserHandle userHandle = UserHandle.getUserHandleForUid(uid);
        boolean isDownscaledEnabled = CompatChanges.isChangeEnabled(DOWNSCALED, packageName, userHandle);
        boolean isDownscaledInverseEnabled = CompatChanges.isChangeEnabled(DOWNSCALED_INVERSE, packageName, userHandle);
        if (isDownscaledEnabled == true) goto L17;
        if (isDownscaledInverseEnabled == true) goto L17;
    L24:
        if (this.mService.mHasLeanbackFeature == false) goto L31;
        Configuration config = this.mService.getGlobalConfiguration();
        float density = config.densityDpi / 160.0f;
        int smallestScreenWidthPx = (int) ((config.smallestScreenWidthDp * density) + 0.5f);
        if (smallestScreenWidthPx <= 1080) goto L31;
        if (CompatChanges.isChangeEnabled(DO_NOT_DOWNSCALE_TO_1080P_ON_TV, packageName, userHandle) == true) goto L31;
        return smallestScreenWidthPx / 1080.0f;
    L31:
        return 1.0f;
    L17:
        float scalingFactor = getScalingFactor(packageName, userHandle);
        if (scalingFactor == 1.0f) goto L24;
        if (isDownscaledInverseEnabled == false) goto L22;
        return scalingFactor;
    L22:
        return 1.0f / scalingFactor;
    }

    void registerCompatScaleProvider(int id, CompatScaleProvider provider) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mProviders.contains(id) == true) goto L20;
        if (provider == null) goto L18;
        if (CompatScaleProvider.isValidOrderId(id) == false) goto L16;
        this.mProviders.put(id, provider);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L16:
        throw new IllegalArgumentException("Provided id " + id + " is not in range of valid ids for system services [0,2]");     // Catch: Throwable -> L13
    L18:
        throw new IllegalArgumentException("The passed CompatScaleProvider can not be null");     // Catch: Throwable -> L13
    L20:
        throw new IllegalArgumentException("Duplicate id provided: " + id);     // Catch: Throwable -> L13
    }

    void unregisterCompatScaleProvider(int id) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mProviders.contains(id) == false) goto L13;
        this.mProviders.remove(id);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        throw new IllegalArgumentException("CompatScaleProvider with id (" + id + ") is not registered");     // Catch: Throwable -> L10
    }

    private static float getScalingFactor(String packageName, UserHandle userHandle) {
        if (CompatChanges.isChangeEnabled(DOWNSCALE_90, packageName, userHandle) == false) goto L7;
        return 0.9f;
    L7:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_85, packageName, userHandle) == false) goto L11;
        return 0.85f;
    L11:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_80, packageName, userHandle) == false) goto L15;
        return 0.8f;
    L15:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_75, packageName, userHandle) == false) goto L19;
        return 0.75f;
    L19:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_70, packageName, userHandle) == false) goto L23;
        return 0.7f;
    L23:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_65, packageName, userHandle) == false) goto L27;
        return 0.65f;
    L27:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_60, packageName, userHandle) == false) goto L31;
        return 0.6f;
    L31:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_55, packageName, userHandle) == false) goto L35;
        return 0.55f;
    L35:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_50, packageName, userHandle) == false) goto L39;
        return 0.5f;
    L39:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_45, packageName, userHandle) == false) goto L43;
        return 0.45f;
    L43:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_40, packageName, userHandle) == false) goto L47;
        return 0.4f;
    L47:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_35, packageName, userHandle) == false) goto L51;
        return 0.35f;
    L51:
        if (CompatChanges.isChangeEnabled(DOWNSCALE_30, packageName, userHandle) == false) goto L54;
        return 0.3f;
    L54:
        return 1.0f;
    }

    public int computeCompatModeLocked(ApplicationInfo ai) {
        CompatibilityInfo info = compatibilityInfoForPackageLocked(ai);
        if (info.alwaysSupportsScreen() == false) goto L7;
        return -2;
    L7:
        if (info.neverSupportsScreen() == false) goto L11;
        return -1;
    L11:
        if (getPackageCompatModeEnabledLocked(ai) == false) goto L13;
        return 1;
    L13:
        return 0;
    }

    public boolean getPackageAskCompatModeLocked(String packageName) {
        if ((getPackageFlags(packageName) & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public void setPackageAskCompatModeLocked(String packageName, boolean ask) {
        setPackageFlagLocked(packageName, 1, ask);
    }

    private boolean getPackageCompatModeEnabledLocked(ApplicationInfo ai) {
        if ((getPackageFlags(ai.packageName) & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void setPackageFlagLocked(String packageName, int flag, boolean set) {
        int curFlags = getPackageFlags(packageName);
        if (set == false) goto L5;
        int newFlags = (~flag) & curFlags;
    L6:
        if (curFlags == newFlags) goto L12;
        if (newFlags == 0) goto L9;
        this.mPackages.put(packageName, Integer.valueOf(newFlags));
    L10:
        scheduleWrite();
        return;
    L9:
        this.mPackages.remove(packageName);
        goto L10
    L12:
        return;
    L5:
        newFlags = curFlags | flag;
        goto L6
    }

    public int getPackageScreenCompatModeLocked(String packageName) {
        ApplicationInfo ai = null;
        ai = AppGlobals.getPackageManager().getApplicationInfo(packageName, 0, 0);     // Catch: RemoteException -> L5
    L6:
        if (ai != null) goto L10;
        return -3;
    L10:
        return computeCompatModeLocked(ai);
    }

    public void setPackageScreenCompatModeLocked(String packageName, int mode) {
        ApplicationInfo ai = null;
        ai = AppGlobals.getPackageManager().getApplicationInfo(packageName, 0, 0);     // Catch: RemoteException -> L5
    L6:
        if (ai != null) goto L9;
        Slog.w(TAG, "setPackageScreenCompatMode failed: unknown package " + packageName);
        return;
    L9:
        setPackageScreenCompatModeLocked(ai, mode);
    }

    void setPackageScreenCompatModeLocked(ApplicationInfo ai, int mode) {
        final String packageName = ai.packageName;
        int curFlags = getPackageFlags(packageName);
        char r7 = 1;
        switch(mode) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L7;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "Unknown screen compat mode req #" + mode + "; ignoring");
        return;
    L11:
        boolean enable = true;
    L14:
        if (enable == false) goto L16;
        int newFlags = curFlags | 2;
    L17:
        CompatibilityInfo ci = compatibilityInfoForPackageLocked(ai);
        if (ci.alwaysSupportsScreen() == false) goto L21;
        Slog.w(TAG, "Ignoring compat mode change of " + packageName + "; compatibility never needed");
        newFlags = 0;
    L21:
        if (ci.neverSupportsScreen() == false) goto L23;
        Slog.w(TAG, "Ignoring compat mode change of " + packageName + "; compatibility always needed");
        newFlags = 0;
    L23:
        if (newFlags == curFlags) goto L52;
        if (newFlags == 0) goto L26;
        this.mPackages.put(packageName, Integer.valueOf(newFlags));
    L27:
        CompatibilityInfo ci2 = compatibilityInfoForPackageLocked(ai);
        scheduleWrite();
        final ArrayList<WindowProcessController> restartedApps = new ArrayList();
        this.mService.mRootWindowContainer.forAllWindows(new CompatModePackages$$ExternalSyntheticLambda0(packageName, restartedApps), true);
        SparseArray<WindowProcessController> pidMap = this.mService.mProcessMap.getPidMap();
        int i = pidMap.size() - 1;
    L28:
        if (i < 0) goto L64;
        WindowProcessController app = pidMap.valueAt(i);
        if (app.containsPackage(packageName) == false) goto L51;
        if (restartedApps.contains(app) == true) goto L51;
        if (app.hasThread() == false) goto L51;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[r7] == false) goto L46;
        String protoLogParam0 = String.valueOf(app.mName);     // Catch: Exception -> L43
        String protoLogParam1 = String.valueOf(ci2);     // Catch: Exception -> L43
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, -74949168947384056L, 0, new Object[]{protoLogParam0, protoLogParam1});     // Catch: Exception -> L41
    L46:
        app.getThread().updatePackageCompatibilityInfo(packageName, ci2);     // Catch: Exception -> L41
    L51:
        i = i - 1;
        r7 = 1;
        goto L28
    L64:
        return;
    L26:
        this.mPackages.remove(packageName);
        goto L27
    L52:
        return;
    L16:
        newFlags = curFlags & (-3);
        goto L17
    L12:
        enable = false;
        goto L14
    L7:
        if ((curFlags & 2) != 0) goto L9;
        enable = true;
        goto L14
    L9:
        enable = false;
        goto L14
    }

    private static /* synthetic */ void lambda$setPackageScreenCompatModeLocked$0(String packageName, ArrayList restartedApps, WindowState w) {
        ActivityRecord ar = w.mActivityRecord;
        if (ar == null) goto L10;
        if (ar.packageName.equals(packageName) == true) goto L7;
        return;
    L7:
        if (restartedApps.contains(ar.app) == true) goto L14;
        ar.restartProcessIfVisible();
        restartedApps.add(ar.app);
        return;
    L14:
        return;
    L10:
        if (w.getProcess().mInfo.packageName.equals(packageName) == false) goto L16;
        w.updateGlobalScale();
        return;
    }

    private void saveCompatModes() {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        HashMap<String, Integer> pkgs = new HashMap(this.mPackages);     // Catch: Throwable -> L34
        monitor-exit(r0);     // Catch: Throwable -> L34
        WindowManagerService.resetPriorityAfterLockedSection();
        FileOutputStream fos = null;
        fos = this.mFile.startWrite();     // Catch: IOException -> L16
        TypedXmlSerializer out = Xml.resolveSerializer(fos);     // Catch: IOException -> L16
        out.startDocument(null, true);     // Catch: IOException -> L16
        out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: IOException -> L16
        out.startTag(null, "compat-packages");     // Catch: IOException -> L16
        IPackageManager pm = AppGlobals.getPackageManager();     // Catch: IOException -> L16
        Iterator<Map.Entry<String, Integer>> it = pkgs.entrySet().iterator();     // Catch: IOException -> L16
    L9:
        if (it.hasNext() == false) goto L28;
        Map.Entry<String, Integer> entry = it.next();     // Catch: IOException -> L16
        String pkg = entry.getKey();     // Catch: IOException -> L16
        int mode = entry.getValue().intValue();     // Catch: IOException -> L16
        if (mode == 0) goto L9;
        ApplicationInfo ai = null;
        ai = pm.getApplicationInfo(pkg, 0, 0);     // Catch: IOException -> L16 RemoteException -> L18
    L19:
        if (ai == null) goto L9;
        CompatibilityInfo info = compatibilityInfoForPackageLocked(ai);     // Catch: IOException -> L16
        if (info.alwaysSupportsScreen() == true) goto L9;
        if (info.neverSupportsScreen() == true) goto L9;
        out.startTag(null, SceneUtils.KEY_PKG);     // Catch: IOException -> L16
        out.attribute(null, "name", pkg);     // Catch: IOException -> L16
        out.attributeInt(null, "mode", mode);     // Catch: IOException -> L16
        out.endTag(null, SceneUtils.KEY_PKG);     // Catch: IOException -> L16
        goto L9
    L28:
        out.endTag(null, "compat-packages");     // Catch: IOException -> L16
        out.endDocument();     // Catch: IOException -> L16
        this.mFile.finishWrite(fos);     // Catch: IOException -> L16
        return;
    L16:
        e1 = move-exception;
        Slog.w(TAG, "Error writing compat packages", e1);
        if (fos == null) goto L57;
        this.mFile.failWrite(fos);
        return;
    L57:
        return;
    L34:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }
}
