package com.android.server.display.mode;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import android.util.Slog;
import android.view.Display;
import android.view.DisplayAddress;
import android.view.DisplayEventReceiver;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class ModeChangeObserver {
    private static final String TAG = "ModeChangeObserver";
    DisplayManager.DisplayListener mDisplayListener;
    private final Handler mHandler;
    private final DisplayModeDirector.Injector mInjector;
    private final Looper mLooper;
    DisplayEventReceiver mModeChangeListener;
    private final LongSparseArray<Integer> mPhysicalIdToLogicalIdMap;
    private final LongSparseArray<Set<Integer>> mRejectedModesMap;
    private final VotesStorage mVotesStorage;

    /* JADX INFO: renamed from: -$$Nest$fgetmPhysicalIdToLogicalIdMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ LongSparseArray m4132$$Nest$fgetmPhysicalIdToLogicalIdMap(ModeChangeObserver r0) {
        return r0.mPhysicalIdToLogicalIdMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRejectedModesMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ LongSparseArray m4133$$Nest$fgetmRejectedModesMap(ModeChangeObserver r0) {
        return r0.mRejectedModesMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVotesStorage, reason: not valid java name */
    static /* bridge */ /* synthetic */ VotesStorage m4134$$Nest$fgetmVotesStorage(ModeChangeObserver r0) {
        return r0.mVotesStorage;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRejectedModesListByDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4135$$Nest$mupdateRejectedModesListByDisplay(ModeChangeObserver r0, long r1, int r3) {
        r0.updateRejectedModesListByDisplay(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateVoteForDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4136$$Nest$mupdateVoteForDisplay(ModeChangeObserver r0, int r1) {
        r0.updateVoteForDisplay(r1);
    }

    ModeChangeObserver(VotesStorage votesStorage, DisplayModeDirector.Injector injector, Looper looper) {
        this.mRejectedModesMap = new LongSparseArray();
        this.mPhysicalIdToLogicalIdMap = new LongSparseArray();
        this.mVotesStorage = votesStorage;
        this.mInjector = injector;
        this.mLooper = looper;
        this.mHandler = new Handler(this.mLooper);
    }

    void observe() {
        updatePhysicalIdToLogicalIdMap();
        this.mDisplayListener = new AnonymousClass1(this);
        this.mInjector.registerDisplayListener(this.mDisplayListener, this.mHandler, 7);
        final Looper r1 = this.mLooper;
        this.mModeChangeListener = new AnonymousClass2(this, r1);
    }

    private void updateVoteForDisplay(int displayId) {
        Display display = this.mInjector.getDisplay(displayId);
        if (display != null) goto L6;
        Slog.e(TAG, "Added or Changed display has disappeared");
        return;
    L6:
        DisplayAddress.Physical r1 = display.getAddress();
        if ((r1 instanceof DisplayAddress.Physical) == false) goto L14;
        DisplayAddress.Physical physical = r1;
        long physicalDisplayId = physical.getPhysicalDisplayId();
        this.mPhysicalIdToLogicalIdMap.put(physicalDisplayId, Integer.valueOf(displayId));
        Set<Integer> modes = this.mRejectedModesMap.get(physicalDisplayId);
        VotesStorage r6 = this.mVotesStorage;
        if (modes == null) goto L11;
        Vote r7 = Vote.forRejectedModes(modes);
    L12:
        r6.updateVote(displayId, 8, r7);
        return;
    L11:
        r7 = null;
        goto L12
    }

    private void updatePhysicalIdToLogicalIdMap() {
        Display[] displays = this.mInjector.getDisplays();
        int r1 = displays.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        Display display = displays[r2];
        if (display == null) goto L10;
        DisplayAddress.Physical r4 = display.getAddress();
        if ((r4 instanceof DisplayAddress.Physical) == false) goto L10;
        DisplayAddress.Physical physical = r4;
        this.mPhysicalIdToLogicalIdMap.put(physical.getPhysicalDisplayId(), Integer.valueOf(display.getDisplayId()));
    L10:
        r2 = r2 + 1;
        goto L3
    }

    private void updateRejectedModesListByDisplay(long rejectedModePhysicalDisplayId, int rejectedModeId) {
        Set<Integer> alreadyRejectedModes = this.mRejectedModesMap.get(rejectedModePhysicalDisplayId);
        if (alreadyRejectedModes != null) goto L5;
        alreadyRejectedModes = new HashSet();
        this.mRejectedModesMap.put(rejectedModePhysicalDisplayId, alreadyRejectedModes);
    L5:
        alreadyRejectedModes.add(Integer.valueOf(rejectedModeId));
    }
}
