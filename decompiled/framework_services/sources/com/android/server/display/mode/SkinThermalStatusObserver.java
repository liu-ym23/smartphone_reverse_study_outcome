package com.android.server.display.mode;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.IThermalEventListener;
import android.os.Temperature;
import android.util.Slog;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayInfo;
import android.view.SurfaceControl;
import com.android.internal.os.BackgroundThread;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
final class SkinThermalStatusObserver extends IThermalEventListener.Stub implements DisplayManager.DisplayListener {
    private static final String TAG = "SkinThermalStatusObserver";
    private final Handler mHandler;
    private final DisplayModeDirector.Injector mInjector;
    private boolean mLoggingEnabled;
    private int mStatus;
    private final Object mThermalObserverLock;
    private final SparseArray<SparseArray<SurfaceControl.RefreshRateRange>> mThermalThrottlingByDisplay;
    private final VotesStorage mVotesStorage;

    public static /* synthetic */ void $r8$lambda$2JiTk7i2BQKkJt51qs77kJyS4uw(SkinThermalStatusObserver r0) {
        r0.updateVotes();
    }

    public static /* synthetic */ void $r8$lambda$HMJT7YFVLnmHC9esWPjr6wLo4y8(SkinThermalStatusObserver r0, int r1) {
        r0.lambda$updateThermalRefreshRateThrottling$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$SsLgruNT-NHGekse-w2y7avspzU, reason: not valid java name */
    public static /* synthetic */ void m4137$r8$lambda$SsLgruNTNHGeksew2y7avspzU(SkinThermalStatusObserver r0, int r1) {
        r0.lambda$onDisplayRemoved$0(r1);
    }

    SkinThermalStatusObserver(DisplayModeDirector.Injector injector, VotesStorage votesStorage) {
        this(injector, votesStorage, BackgroundThread.getHandler());
    }

    SkinThermalStatusObserver(DisplayModeDirector.Injector injector, VotesStorage votesStorage, Handler handler) {
        this.mThermalObserverLock = new Object();
        this.mStatus = 0;
        this.mThermalThrottlingByDisplay = new SparseArray();
        this.mInjector = injector;
        this.mVotesStorage = votesStorage;
        this.mHandler = handler;
    }

    public static SurfaceControl.RefreshRateRange findBestMatchingRefreshRateRange(int currentStatus, SparseArray<SurfaceControl.RefreshRateRange> throttlingMap) {
        SurfaceControl.RefreshRateRange foundRange = null;
        int status = currentStatus;
    L3:
        if (status < 0) goto L8;
        SurfaceControl.RefreshRateRange foundRange2 = throttlingMap.get(status);
        foundRange = foundRange2;
        if (foundRange != null) goto L8;
        status = status - 1;
    L8:
        return foundRange;
    }

    void observe() {
        if (this.mInjector.registerThermalServiceListener(this) == true) goto L5;
        return;
    L5:
        registerDisplayListener();
        populateInitialDisplayInfo();
    }

    private void registerDisplayListener() {
        this.mInjector.registerDisplayListener(this, this.mHandler, 7);
    }

    void setLoggingEnabled(boolean enabled) {
        this.mLoggingEnabled = enabled;
    }

    public void notifyThrottling(Temperature temp) {
        int currentStatus = temp.getStatus();
        Object r1 = this.mThermalObserverLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mStatus != currentStatus) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        this.mStatus = currentStatus;     // Catch: Throwable -> L8
        this.mHandler.post(new SkinThermalStatusObserver$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        if (this.mLoggingEnabled == false) goto L19;
        Slog.d(TAG, "New thermal throttling status , current thermal status = " + currentStatus);
        return;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int displayId) {
        updateThermalRefreshRateThrottling(displayId);
        if (this.mLoggingEnabled == false) goto L6;
        Slog.d(TAG, "Display added:" + displayId);
        return;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(final int displayId) {
        Object r0 = this.mThermalObserverLock;
        monitor-enter(r0);
        this.mThermalThrottlingByDisplay.remove(displayId);     // Catch: Throwable -> L10
        this.mHandler.post(new SkinThermalStatusObserver$$ExternalSyntheticLambda2(this, displayId));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (this.mLoggingEnabled == false) goto L15;
        Slog.d(TAG, "Display removed and voted: displayId=" + displayId);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onDisplayRemoved$0(int displayId) {
        this.mVotesStorage.updateVote(displayId, 21, null);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int displayId) {
        updateThermalRefreshRateThrottling(displayId);
        if (this.mLoggingEnabled == false) goto L6;
        Slog.d(TAG, "Display changed:" + displayId);
        return;
    }

    private void populateInitialDisplayInfo() {
        DisplayInfo info = new DisplayInfo();
        Display[] displays = this.mInjector.getDisplays();
        int size = displays.length;
        SparseArray<SparseArray<SurfaceControl.RefreshRateRange>> localMap = new SparseArray(size);
        int r4 = displays.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L5;
        Display d = displays[r5];
        int displayId = d.getDisplayId();
        d.getDisplayInfo(info);
        localMap.put(displayId, info.thermalRefreshRateThrottling);
        r5 = r5 + 1;
        goto L3
    L5:
        Object r6 = this.mThermalObserverLock;
        monitor-enter(r6);
        int i = 0;
    L8:
        if (i >= size) goto L13;
        this.mThermalThrottlingByDisplay.put(localMap.keyAt(i), localMap.valueAt(i));     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(r6);     // Catch: Throwable -> L10
        if (this.mLoggingEnabled == false) goto L24;
        Slog.d(TAG, "Display initial info:" + localMap);
        return;
    }

    private void updateThermalRefreshRateThrottling(final int displayId) {
        DisplayInfo displayInfo = new DisplayInfo();
        this.mInjector.getDisplayInfo(displayId, displayInfo);
        SparseArray<SurfaceControl.RefreshRateRange> throttlingMap = displayInfo.thermalRefreshRateThrottling;
        Object r2 = this.mThermalObserverLock;
        monitor-enter(r2);
        this.mThermalThrottlingByDisplay.put(displayId, throttlingMap);     // Catch: Throwable -> L10
        this.mHandler.post(new SkinThermalStatusObserver$$ExternalSyntheticLambda0(this, displayId));     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        if (this.mLoggingEnabled == false) goto L15;
        Slog.d(TAG, "Thermal throttling updated: display=" + displayId + ", map=" + throttlingMap);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$updateThermalRefreshRateThrottling$1(int displayId) {
        updateVoteForDisplay(displayId);
    }

    private void updateVotes() {
        Object r0 = this.mThermalObserverLock;
        monitor-enter(r0);
        int localStatus = this.mStatus;     // Catch: Throwable -> L14
        SparseArray<SparseArray<SurfaceControl.RefreshRateRange>> localMap = this.mThermalThrottlingByDisplay.clone();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (this.mLoggingEnabled == false) goto L9;
        Slog.d(TAG, "Updating votes for status=" + localStatus + ", map=" + localMap);
    L9:
        int size = localMap.size();
        int i = 0;
    L10:
        if (i >= size) goto L13;
        reportThrottlingIfNeeded(localMap.keyAt(i), localStatus, localMap.valueAt(i));
        i = i + 1;
        goto L10
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void updateVoteForDisplay(int displayId) {
        Object r0 = this.mThermalObserverLock;
        monitor-enter(r0);
        int localStatus = this.mStatus;     // Catch: Throwable -> L14
        SparseArray<SurfaceControl.RefreshRateRange> localMap = this.mThermalThrottlingByDisplay.get(displayId);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (localMap != null) goto L10;
        Slog.d(TAG, "Updating votes, display already removed, display=" + displayId);
        return;
    L10:
        if (this.mLoggingEnabled == false) goto L12;
        Slog.d(TAG, "Updating votes for status=" + localStatus + ", display =" + displayId + ", map=" + localMap);
    L12:
        reportThrottlingIfNeeded(displayId, localStatus, localMap);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void reportThrottlingIfNeeded(int displayId, int currentStatus, SparseArray<SurfaceControl.RefreshRateRange> throttlingMap) {
        if (currentStatus != (-1)) goto L6;
        return;
    L6:
        if (throttlingMap.size() != 0) goto L9;
        fallbackReportThrottlingIfNeeded(displayId, currentStatus);
        return;
    L9:
        SurfaceControl.RefreshRateRange foundRange = findBestMatchingRefreshRateRange(currentStatus, throttlingMap);
        Vote vote = null;
        if (foundRange == null) goto L12;
        vote = Vote.forRenderFrameRates(foundRange.min, foundRange.max);
    L12:
        this.mVotesStorage.updateVote(displayId, 21, vote);
        if (this.mLoggingEnabled == false) goto L16;
        Slog.d(TAG, "Voted: vote=" + vote + ", display =" + displayId);
        return;
    }

    private void fallbackReportThrottlingIfNeeded(int displayId, int currentStatus) {
        Vote vote = null;
        if (currentStatus < 4) goto L5;
        vote = Vote.forRenderFrameRates(0.0f, 60.0f);
    L5:
        this.mVotesStorage.updateVote(displayId, 21, vote);
        if (this.mLoggingEnabled == false) goto L9;
        Slog.d(TAG, "Voted(fallback): vote=" + vote + ", display =" + displayId);
        return;
    }

    void dumpLocked(PrintWriter writer) {
        Object r0 = this.mThermalObserverLock;
        monitor-enter(r0);
        int localStatus = this.mStatus;     // Catch: Throwable -> L8
        SparseArray<SparseArray<SurfaceControl.RefreshRateRange>> localMap = this.mThermalThrottlingByDisplay.clone();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        writer.println("  SkinThermalStatusObserver:");
        writer.println("    mStatus: " + localStatus);
        writer.println("    mThermalThrottlingByDisplay: " + localMap);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
