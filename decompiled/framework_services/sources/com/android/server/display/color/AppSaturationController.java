package com.android.server.display.color;

import android.util.ArrayMap;
import android.util.SparseArray;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class AppSaturationController {
    static final float[] TRANSLATION_VECTOR = null;
    private final Map<String, SparseArray<SaturationController>> mAppsMap;
    private final Object mLock;

    private static class SaturationController {
        private static final int FULL_SATURATION = 100;
        private final List<WeakReference<ColorDisplayService.ColorTransformController>> mControllerRefs;
        private final ArrayMap<String, Integer> mSaturationLevels;
        private float[] mTransformMatrix;

        /* JADX INFO: renamed from: -$$Nest$maddColorTransformController, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4011$$Nest$maddColorTransformController(SaturationController r0, WeakReference r1) {
            return r0.addColorTransformController(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4012$$Nest$mdump(SaturationController r0, PrintWriter r1) {
            r0.dump(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetSaturationLevel, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4013$$Nest$msetSaturationLevel(SaturationController r0, String r1, int r2) {
            return r0.setSaturationLevel(r1, r2);
        }

        /* synthetic */ SaturationController(AppSaturationControllerIA r1) {
            this();
        }

        private SaturationController() {
            this.mControllerRefs = new ArrayList();
            this.mSaturationLevels = new ArrayMap();
            this.mTransformMatrix = new float[9];
        }

        private boolean setSaturationLevel(String callingPackageName, int saturationLevel) {
            if (saturationLevel != 100) goto L5;
            this.mSaturationLevels.remove(callingPackageName);
        L7:
            if (this.mControllerRefs.isEmpty() == false) goto L9;
            return false;
        L9:
            return updateState();
        L5:
            this.mSaturationLevels.put(callingPackageName, Integer.valueOf(saturationLevel));
            goto L7
        }

        private boolean addColorTransformController(WeakReference<ColorDisplayService.ColorTransformController> controller) {
            clearExpiredReferences();
            this.mControllerRefs.add(controller);
            if (this.mSaturationLevels.isEmpty() == false) goto L5;
            return false;
        L5:
            return updateState();
        }

        private int calculateSaturationLevel() {
            int saturationLevel = 100;
            int i = 0;
        L4:
            if (i >= this.mSaturationLevels.size()) goto L10;
            int level = this.mSaturationLevels.valueAt(i).intValue();
            if (level >= saturationLevel) goto L8;
            saturationLevel = level;
        L8:
            i = i + 1;
            goto L4
        L10:
            return saturationLevel;
        }

        private boolean updateState() {
            AppSaturationController.computeGrayscaleTransformMatrix(calculateSaturationLevel() / 100.0f, this.mTransformMatrix);
            boolean updated = false;
            Iterator<WeakReference<ColorDisplayService.ColorTransformController>> iterator = this.mControllerRefs.iterator();
        L4:
            if (iterator.hasNext() == false) goto L10;
            WeakReference<ColorDisplayService.ColorTransformController> controllerRef = iterator.next();
            ColorDisplayService.ColorTransformController controller = controllerRef.get();
            if (controller != null) goto L7;
            iterator.remove();
            goto L4
        L7:
            controller.applyAppSaturation(this.mTransformMatrix, AppSaturationController.TRANSLATION_VECTOR);
            updated = true;
            goto L4
        L10:
            return updated;
        }

        private void clearExpiredReferences() {
            Iterator<WeakReference<ColorDisplayService.ColorTransformController>> iterator = this.mControllerRefs.iterator();
        L4:
            if (iterator.hasNext() == false) goto L9;
            WeakReference<ColorDisplayService.ColorTransformController> controllerRef = iterator.next();
            ColorDisplayService.ColorTransformController controller = controllerRef.get();
            if (controller != null) goto L4;
            iterator.remove();
            goto L4
        }

        private void dump(PrintWriter pw) {
            pw.println("            mSaturationLevels: " + this.mSaturationLevels);
            pw.println("            mControllerRefs count: " + this.mControllerRefs.size());
        }
    }

    AppSaturationController() {
        this.mLock = new Object();
        this.mAppsMap = new HashMap();
    }

    static {
        TRANSLATION_VECTOR = new float[]{0.0f, 0.0f, 0.0f};
    }

    boolean addColorTransformController(String packageName, int userId, WeakReference<ColorDisplayService.ColorTransformController> controller) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = SaturationController.m4011$$Nest$maddColorTransformController(getSaturationControllerLocked(packageName, userId), controller);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setSaturationLevel(String callingPackageName, String affectedPackageName, int userId, int saturationLevel) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = SaturationController.m4013$$Nest$msetSaturationLevel(getSaturationControllerLocked(affectedPackageName, userId), callingPackageName, saturationLevel);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("App Saturation: ");     // Catch: Throwable -> L9
        if (this.mAppsMap.size() != 0) goto L11;
        pw.println("    No packages");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        List<String> packageNames = new ArrayList(this.mAppsMap.keySet());     // Catch: Throwable -> L9
        Collections.sort(packageNames);     // Catch: Throwable -> L9
        Iterator<String> r2 = packageNames.iterator();     // Catch: Throwable -> L9
    L13:
        if (r2.hasNext() == false) goto L19;
        String packageName = r2.next();     // Catch: Throwable -> L9
        pw.println("    " + packageName + ":");     // Catch: Throwable -> L9
        SparseArray<SaturationController> appUserIdMap = this.mAppsMap.get(packageName);     // Catch: Throwable -> L9
        int i = 0;
    L16:
        if (i >= appUserIdMap.size()) goto L13;
        pw.println("        " + appUserIdMap.keyAt(i) + ":");     // Catch: Throwable -> L9
        SaturationController.m4012$$Nest$mdump(appUserIdMap.valueAt(i), pw);     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L16
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private SaturationController getSaturationControllerLocked(String packageName, int userId) {
        return getOrCreateSaturationControllerLocked(getOrCreateUserIdMapLocked(packageName), userId);
    }

    private SparseArray<SaturationController> getOrCreateUserIdMapLocked(String packageName) {
        if (this.mAppsMap.get(packageName) != null) goto L5;
        SparseArray<SaturationController> appUserIdMap = new SparseArray();
        this.mAppsMap.put(packageName, appUserIdMap);
        return appUserIdMap;
    L5:
        return this.mAppsMap.get(packageName);
    }

    private SaturationController getOrCreateSaturationControllerLocked(SparseArray<SaturationController> appUserIdMap, int userId) {
        if (appUserIdMap.get(userId) != null) goto L5;
        SaturationController saturationController = new SaturationController(null);
        appUserIdMap.put(userId, saturationController);
        return saturationController;
    L5:
        return appUserIdMap.get(userId);
    }

    static void computeGrayscaleTransformMatrix(float saturation, float[] matrix) {
        float desaturation = 1.0f - saturation;
        float[] luminance = {0.231f * desaturation, 0.715f * desaturation, 0.072f * desaturation};
        matrix[0] = luminance[0] + saturation;
        matrix[1] = luminance[0];
        matrix[2] = luminance[0];
        matrix[3] = luminance[1];
        matrix[4] = luminance[1] + saturation;
        matrix[5] = luminance[1];
        matrix[6] = luminance[2];
        matrix[7] = luminance[2];
        matrix[8] = luminance[2] + saturation;
    }
}
