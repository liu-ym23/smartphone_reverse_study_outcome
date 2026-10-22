package com.android.server.display;

import android.hardware.display.DisplayTopology;
import android.hardware.display.DisplayTopologyGraph;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.DisplayInfo;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class DisplayTopologyCoordinator {
    private static final String TAG = "DisplayTopologyCoordinator";
    private final SparseIntArray mDensities;
    private final SparseArray<String> mDisplayIdToUniqueIdMapping;
    private final BooleanSupplier mIsExtendedDisplayAllowed;
    private final Consumer<Pair<DisplayTopology, DisplayTopologyGraph>> mOnTopologyChangedCallback;
    private final DisplayManagerService.SyncRoot mSyncRoot;
    private DisplayTopology mTopology;
    private final Executor mTopologyChangeExecutor;
    private final Runnable mTopologySavedCallback;
    private final DisplayTopologyStore mTopologyStore;
    private final Map<String, Integer> mUniqueIdToDisplayIdMapping;

    static class Injector {
        Injector() {
        }

        DisplayTopology getTopology() {
            return new DisplayTopology();
        }

        DisplayTopologyStore createTopologyStore(final SparseArray<String> displayIdToUniqueIdMapping, final Map<String, Integer> uniqueIdToDisplayIdMapping) {
            return new DisplayTopologyXmlStore(new AnonymousClass1(this, displayIdToUniqueIdMapping, uniqueIdToDisplayIdMapping));
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$FLGZO3IsBzi_ExNQa2xMif3tj-E, reason: not valid java name */
    public static /* synthetic */ void m3797$r8$lambda$FLGZO3IsBzi_ExNQa2xMif3tjE(DisplayTopologyCoordinator r0, DisplayTopology r1, SparseIntArray r2) {
        r0.lambda$sendTopologyUpdateLocked$0(r1, r2);
    }

    private static String getUniqueId(DisplayInfo info) {
        if (info.displayId != 0) goto L9;
        if (info.type != 1) goto L9;
        return "internal";
    L9:
        return info.uniqueId;
    }

    DisplayTopologyCoordinator(BooleanSupplier isExtendedDisplayAllowed, Consumer<Pair<DisplayTopology, DisplayTopologyGraph>> onTopologyChangedCallback, Executor topologyChangeExecutor, DisplayManagerService.SyncRoot syncRoot, Runnable topologySavedCallback) {
        this(new Injector(), isExtendedDisplayAllowed, onTopologyChangedCallback, topologyChangeExecutor, syncRoot, topologySavedCallback);
    }

    DisplayTopologyCoordinator(Injector injector, BooleanSupplier isExtendedDisplayAllowed, Consumer<Pair<DisplayTopology, DisplayTopologyGraph>> onTopologyChangedCallback, Executor topologyChangeExecutor, DisplayManagerService.SyncRoot syncRoot, Runnable topologySavedCallback) {
        this.mDensities = new SparseIntArray();
        this.mUniqueIdToDisplayIdMapping = new HashMap();
        this.mDisplayIdToUniqueIdMapping = new SparseArray();
        this.mTopology = injector.getTopology();
        this.mIsExtendedDisplayAllowed = isExtendedDisplayAllowed;
        this.mOnTopologyChangedCallback = onTopologyChangedCallback;
        this.mTopologyChangeExecutor = topologyChangeExecutor;
        this.mSyncRoot = syncRoot;
        this.mTopologyStore = injector.createTopologyStore(this.mDisplayIdToUniqueIdMapping, this.mUniqueIdToDisplayIdMapping);
        this.mTopologySavedCallback = topologySavedCallback;
    }

    void onDisplayAdded(DisplayInfo info) {
        if (isDisplayAllowedInTopology(info, true) == true) goto L5;
        return;
    L5:
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        addDisplayIdMappingLocked(info);     // Catch: Throwable -> L10
        this.mDensities.put(info.displayId, info.logicalDensityDpi);     // Catch: Throwable -> L10
        this.mTopology.addDisplay(info.displayId, getWidth(info), getHeight(info));     // Catch: Throwable -> L10
        Slog.i(TAG, "Display " + info.displayId + " added, new topology: " + this.mTopology);     // Catch: Throwable -> L10
        restoreTopologyLocked();     // Catch: Throwable -> L10
        sendTopologyUpdateLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void onDisplayChanged(DisplayInfo info) {
        if (isDisplayAllowedInTopology(info, false) == true) goto L5;
        return;
    L5:
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mDensities.indexOfKey(info.displayId) < 0) goto L13;
        this.mDensities.put(info.displayId, info.logicalDensityDpi);     // Catch: Throwable -> L10
    L13:
        if (this.mTopology.updateDisplay(info.displayId, getWidth(info), getHeight(info)) == false) goto L15;
        sendTopologyUpdateLocked();     // Catch: Throwable -> L10
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    void onDisplayRemoved(int displayId) {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mDensities.delete(displayId);     // Catch: Throwable -> L7
        if (this.mTopology.removeDisplay(displayId) == false) goto L9;
        Slog.i(TAG, "Display " + displayId + " removed, new topology: " + this.mTopology);     // Catch: Throwable -> L7
        removeDisplayIdMappingLocked(displayId);     // Catch: Throwable -> L7
        restoreTopologyLocked();     // Catch: Throwable -> L7
        sendTopologyUpdateLocked();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void reloadTopologies(int userId, boolean isUserSwitching) {
        boolean isTopologySaved = false;
        DisplayManagerService.SyncRoot r1 = this.mSyncRoot;
        monitor-enter(r1);
        this.mTopologyStore.reloadTopologies(userId);     // Catch: Throwable -> L7
        boolean isTopologyRestored = restoreTopologyLocked();     // Catch: Throwable -> L7
        if (isTopologyRestored == false) goto L9;
        sendTopologyUpdateLocked();     // Catch: Throwable -> L7
    L9:
        if (isUserSwitching == false) goto L12;
        if (isTopologyRestored == true) goto L12;
        isTopologySaved = this.mTopologyStore.saveTopology(this.mTopology);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L7
        if (isTopologySaved == false) goto L20;
        this.mTopologySavedCallback.run();
        return;
    L20:
        return;
    L7:
        th = move-exception;
        throw th;
    }

    DisplayTopology getTopology() {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        DisplayTopology r1 = this.mTopology.copy();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setTopology(DisplayTopology topology) {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        topology.normalize();     // Catch: Throwable -> L9
        this.mTopology = topology;     // Catch: Throwable -> L9
        sendTopologyUpdateLocked();     // Catch: Throwable -> L9
        boolean isTopologySaved = this.mTopologyStore.saveTopology(topology);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (isTopologySaved == false) goto L14;
        this.mTopologySavedCallback.run();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw) {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        this.mTopology.dump(pw);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeDisplayIdMappingLocked(int displayId) {
        String uniqueId = this.mDisplayIdToUniqueIdMapping.get(displayId);
        if (uniqueId != null) goto L6;
        Slog.e(TAG, "Can't find uniqueId for displayId=" + displayId);
        return;
    L6:
        this.mDisplayIdToUniqueIdMapping.remove(displayId);
        this.mUniqueIdToDisplayIdMapping.remove(uniqueId);
    }

    private void addDisplayIdMappingLocked(DisplayInfo info) {
        String uniqueId = getUniqueId(info);
        this.mUniqueIdToDisplayIdMapping.put(uniqueId, Integer.valueOf(info.displayId));
        this.mDisplayIdToUniqueIdMapping.put(info.displayId, uniqueId);
    }

    private float getWidth(DisplayInfo info) {
        return DisplayTopology.pxToDp(info.logicalWidth, info.logicalDensityDpi);
    }

    private float getHeight(DisplayInfo info) {
        return DisplayTopology.pxToDp(info.logicalHeight, info.logicalDensityDpi);
    }

    private boolean isDisplayAllowedInTopology(DisplayInfo info, boolean shouldLog) {
        if (info.type == 1) goto L12;
        if (info.type == 2) goto L12;
        if (info.type == 4) goto L12;
        if (shouldLog == false) goto L10;
        Slog.d(TAG, "Display " + info.displayId + " not allowed in topology because type is not INTERNAL, EXTERNAL or OVERLAY");
    L10:
        return false;
    L12:
        if (info.type != 1) goto L19;
        if (info.displayId == 0) goto L19;
        if (shouldLog == false) goto L17;
        Slog.d(TAG, "Display " + info.displayId + " not allowed in topology because it is a non-default internal display");
    L17:
        return false;
    L19:
        if (info.type == 2) goto L23;
        if (info.type == 4) goto L23;
    L27:
        return true;
    L23:
        if (this.mIsExtendedDisplayAllowed.getAsBoolean() == true) goto L27;
        if (shouldLog == false) goto L26;
        Slog.d(TAG, "Display " + info.displayId + " not allowed in topology because type is EXTERNAL or OVERLAY and !mIsExtendedDisplayAllowed");
    L26:
        return false;
    }

    private boolean restoreTopologyLocked() {
        DisplayTopology restoredTopology = this.mTopologyStore.restoreTopology(this.mTopology);
        if (restoredTopology != null) goto L6;
        return false;
    L6:
        this.mTopology = restoredTopology;
        this.mTopology.normalize();
        return true;
    }

    private void sendTopologyUpdateLocked() {
        final DisplayTopology copy = this.mTopology.copy();
        final SparseIntArray densities = this.mDensities.clone();
        this.mTopologyChangeExecutor.execute(new DisplayTopologyCoordinator$$ExternalSyntheticLambda0(this, copy, densities));
    }

    private /* synthetic */ void lambda$sendTopologyUpdateLocked$0(DisplayTopology copy, SparseIntArray densities) {
        this.mOnTopologyChangedCallback.accept(new Pair(copy, copy.getGraph(densities)));
    }
}
