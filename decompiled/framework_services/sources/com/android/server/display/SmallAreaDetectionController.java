package com.android.server.display;

import android.R;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.provider.DeviceConfigInterface;
import android.util.ArrayMap;
import android.util.SparseArray;
import com.android.internal.os.BackgroundThread;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.PackageStateInternal;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class SmallAreaDetectionController {
    private static final String KEY_SMALL_AREA_DETECTION_ALLOWLIST = "small_area_detection_allowlist";
    private final Map<String, Float> mAllowPkgMap;
    private final Context mContext;
    private final Object mLock;
    private final PackageManagerInternal mPackageManager;

    private class OnPropertiesChangedListener implements DeviceConfig.OnPropertiesChangedListener {
        final /* synthetic */ SmallAreaDetectionController this$0;

        /* synthetic */ OnPropertiesChangedListener(SmallAreaDetectionController r1, SmallAreaDetectionControllerIA r2) {
            this(r1);
        }

        private OnPropertiesChangedListener(SmallAreaDetectionController r1) {
            this.this$0 = r1;
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            if (properties.getKeyset().contains(SmallAreaDetectionController.KEY_SMALL_AREA_DETECTION_ALLOWLIST) == false) goto L6;
            this.this$0.updateAllowlist(properties.getString(SmallAreaDetectionController.KEY_SMALL_AREA_DETECTION_ALLOWLIST, null));
            return;
        }
    }

    private final class PackageReceiver implements PackageManagerInternal.PackageListObserver {
        final /* synthetic */ SmallAreaDetectionController this$0;

        /* synthetic */ PackageReceiver(SmallAreaDetectionController r1, SmallAreaDetectionControllerIA r2) {
            this(r1);
        }

        private PackageReceiver(SmallAreaDetectionController r1) {
            this.this$0 = r1;
        }

        @Override // android.content.pm.PackageManagerInternal.PackageListObserver
        public void onPackageAdded(String packageName, int uid) {
            float threshold = 0.0f;
            Object r1 = SmallAreaDetectionController.m3895$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (SmallAreaDetectionController.m3894$$Nest$fgetmAllowPkgMap(this.this$0).containsKey(packageName) == false) goto L9;
            threshold = ((Float) SmallAreaDetectionController.m3894$$Nest$fgetmAllowPkgMap(this.this$0).get(packageName)).floatValue();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L7
            if (threshold <= 0.0f) goto L18;
            this.this$0.setSmallAreaDetectionThreshold(UserHandle.getAppId(uid), threshold);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAllowPkgMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m3894$$Nest$fgetmAllowPkgMap(SmallAreaDetectionController r0) {
        return r0.mAllowPkgMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m3895$$Nest$fgetmLock(SmallAreaDetectionController r0) {
        return r0.mLock;
    }

    private static native void nativeSetSmallAreaDetectionThreshold(int r0, float r1);

    private static native void nativeUpdateSmallAreaDetection(int[] r0, float[] r1);

    static SmallAreaDetectionController create(Context context) {
        SmallAreaDetectionController controller = new SmallAreaDetectionController(context, DeviceConfigInterface.REAL);
        String property = DeviceConfigInterface.REAL.getProperty("display_manager", KEY_SMALL_AREA_DETECTION_ALLOWLIST);
        controller.updateAllowlist(property);
        return controller;
    }

    SmallAreaDetectionController(Context context, DeviceConfigInterface deviceConfig) {
        this.mLock = new Object();
        this.mAllowPkgMap = new ArrayMap();
        this.mContext = context;
        this.mPackageManager = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        SmallAreaDetectionControllerIA r2 = null;
        deviceConfig.addOnPropertiesChangedListener("display_manager", BackgroundThread.getExecutor(), new OnPropertiesChangedListener(this, r2));
        this.mPackageManager.getPackageList(new PackageReceiver(this, r2));
    }

    void updateAllowlist(String property) {
        Map<String, Float> allowPkgMap = new ArrayMap();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mAllowPkgMap.clear();     // Catch: Throwable -> L9
        int r2 = 0;
        if (property == null) goto L12;
        String[] mapStrings = property.split(",");     // Catch: Throwable -> L9
        int r4 = mapStrings.length;     // Catch: Throwable -> L9
    L7:
        if (r2 >= r4) goto L16;
        String mapString = mapStrings[r2];     // Catch: Throwable -> L9
        putToAllowlist(mapString);     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
    L16:
        if (this.mAllowPkgMap.isEmpty() == false) goto L19;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L19:
        allowPkgMap.putAll(this.mAllowPkgMap);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        updateSmallAreaDetection(allowPkgMap);
        return;
    L12:
        String[] defaultMapStrings = this.mContext.getResources().getStringArray(R.array.config_udfps_touch_detection_options);     // Catch: Throwable -> L9
        int r5 = defaultMapStrings.length;     // Catch: Throwable -> L9
    L13:
        if (r2 >= r5) goto L16;
        String defaultMapString = defaultMapStrings[r2];     // Catch: Throwable -> L9
        putToAllowlist(defaultMapString);     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void putToAllowlist(String rowData) {
        String[] items = rowData.split(":");
        if (items.length == 2) goto L9;
        return;
    L9:
        String pkg = items[0];     // Catch: Exception -> L7
        float threshold = Float.valueOf(items[1]).floatValue();     // Catch: Exception -> L7
        this.mAllowPkgMap.put(pkg, Float.valueOf(threshold));     // Catch: Exception -> L7
        return;
    }

    private void updateSmallAreaDetection(Map<String, Float> allowPkgMap) {
        SparseArray<Float> appIdThresholdList = new SparseArray(allowPkgMap.size());
        Iterator<String> r1 = allowPkgMap.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        String pkg = r1.next();
        float threshold = allowPkgMap.get(pkg).floatValue();
        PackageStateInternal stage = this.mPackageManager.getPackageStateInternal(pkg);
        if (stage == null) goto L4;
        appIdThresholdList.put(stage.getAppId(), Float.valueOf(threshold));
        goto L4
    L9:
        int[] appIds = new int[appIdThresholdList.size()];
        float[] thresholds = new float[appIdThresholdList.size()];
        int i = 0;
    L11:
        if (i >= appIdThresholdList.size()) goto L13;
        appIds[i] = appIdThresholdList.keyAt(i);
        thresholds[i] = appIdThresholdList.valueAt(i).floatValue();
        i = i + 1;
        goto L11
    L13:
        updateSmallAreaDetection(appIds, thresholds);
    }

    void updateSmallAreaDetection(int[] appIds, float[] thresholds) {
        nativeUpdateSmallAreaDetection(appIds, thresholds);
    }

    void setSmallAreaDetectionThreshold(int appId, float threshold) {
        nativeSetSmallAreaDetectionThreshold(appId, threshold);
    }

    void dump(PrintWriter pw) {
        pw.println("Small area detection allowlist:");
        pw.println("-------------------------------");
        pw.println("  Packages:");
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<String> r1 = this.mAllowPkgMap.keySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        String pkg = r1.next();     // Catch: Throwable -> L8
        pw.println("    " + pkg + " threshold = " + this.mAllowPkgMap.get(pkg));     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
