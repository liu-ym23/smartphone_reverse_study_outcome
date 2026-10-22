package com.android.server.wm;

import android.view.Display;
import android.view.DisplayInfo;
import android.view.SurfaceControl;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class RefreshRatePolicy {
    static final int LAYER_PRIORITY_FOCUSED_WITHOUT_MODE = 1;
    static final int LAYER_PRIORITY_FOCUSED_WITH_MODE = 0;
    static final int LAYER_PRIORITY_NOT_FOCUSED_WITH_MODE = 2;
    static final int LAYER_PRIORITY_UNSET = -1;
    private final DisplayInfo mDisplayInfo;
    private final ForceRefreshRatePackageList mForceList;
    private final HighRefreshRateDenylist mHighRefreshRateDenylist;
    private final Display.Mode mLowRefreshRateMode;
    private float mMaxSupportedRefreshRate;
    private float mMinSupportedRefreshRate;
    private final PackageRefreshRate mNonHighRefreshRatePackages;
    private final WindowManagerService mWmService;

    public static class FrameRateVote {
        int mCompatibility;
        float mRefreshRate;
        int mSelectionStrategy;

        FrameRateVote(float refreshRate, int compatibility, int selectionStrategy) {
            update(refreshRate, compatibility, selectionStrategy);
        }

        FrameRateVote() {
            reset();
        }

        boolean update(float refreshRate, int compatibility, int selectionStrategy) {
            if (refreshRateEquals(refreshRate) == true) goto L5;
        L11:
            this.mRefreshRate = refreshRate;
            this.mCompatibility = compatibility;
            this.mSelectionStrategy = selectionStrategy;
            return true;
        L5:
            if (this.mCompatibility != compatibility) goto L11;
            if (this.mSelectionStrategy != selectionStrategy) goto L11;
            return false;
        }

        boolean reset() {
            return update(0.0f, 0, 0);
        }

        public boolean equals(Object o) {
            if ((o instanceof FrameRateVote) == true) goto L5;
            return false;
        L5:
            FrameRateVote other = (FrameRateVote) o;
            if (refreshRateEquals(other.mRefreshRate) == true) goto L8;
            return false;
        L8:
            if (this.mCompatibility == other.mCompatibility) goto L10;
            return false;
        L10:
            if (this.mSelectionStrategy != other.mSelectionStrategy) goto L15;
            return true;
        L15:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Float.valueOf(this.mRefreshRate), Integer.valueOf(this.mCompatibility), Integer.valueOf(this.mSelectionStrategy)});
        }

        public String toString() {
            return "mRefreshRate=" + this.mRefreshRate + ", mCompatibility=" + this.mCompatibility + ", mSelectionStrategy=" + this.mSelectionStrategy;
        }

        private boolean refreshRateEquals(float refreshRate) {
            if (this.mRefreshRate <= (refreshRate + 0.01f)) goto L5;
        L7:
            return false;
        L5:
            if (this.mRefreshRate < (refreshRate - 0.01f)) goto L7;
            return true;
        }
    }

    class PackageRefreshRate {
        private final HashMap<String, SurfaceControl.RefreshRateRange> mPackages;
        final /* synthetic */ RefreshRatePolicy this$0;

        PackageRefreshRate(RefreshRatePolicy this$0) {
            this.this$0 = this$0;
            this.mPackages = new HashMap();
        }

        public void add(String s, float minRefreshRate, float maxRefreshRate) {
            float minSupportedRefreshRate = Math.max(RefreshRatePolicy.m10095$$Nest$fgetmMinSupportedRefreshRate(this.this$0), minRefreshRate);
            float maxSupportedRefreshRate = Math.min(RefreshRatePolicy.m10094$$Nest$fgetmMaxSupportedRefreshRate(this.this$0), maxRefreshRate);
            this.mPackages.put(s, new SurfaceControl.RefreshRateRange(minSupportedRefreshRate, maxSupportedRefreshRate));
        }

        public SurfaceControl.RefreshRateRange get(String s) {
            return this.mPackages.get(s);
        }

        public void remove(String s) {
            this.mPackages.remove(s);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaxSupportedRefreshRate, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m10094$$Nest$fgetmMaxSupportedRefreshRate(RefreshRatePolicy r0) {
        return r0.mMaxSupportedRefreshRate;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMinSupportedRefreshRate, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m10095$$Nest$fgetmMinSupportedRefreshRate(RefreshRatePolicy r0) {
        return r0.mMinSupportedRefreshRate;
    }

    RefreshRatePolicy(WindowManagerService wmService, DisplayInfo displayInfo, HighRefreshRateDenylist denylist) {
        this.mNonHighRefreshRatePackages = new PackageRefreshRate(this);
        this.mDisplayInfo = displayInfo;
        this.mLowRefreshRateMode = findLowRefreshRateMode(displayInfo);
        this.mHighRefreshRateDenylist = denylist;
        this.mWmService = wmService;
        this.mForceList = new ForceRefreshRatePackageList(this.mWmService, displayInfo);
    }

    private Display.Mode findLowRefreshRateMode(DisplayInfo displayInfo) {
        Display.Mode defaultMode = displayInfo.getDefaultMode();
        float[] refreshRates = displayInfo.getDefaultRefreshRates();
        float bestRefreshRate = defaultMode.getRefreshRate();
        this.mMinSupportedRefreshRate = bestRefreshRate;
        this.mMaxSupportedRefreshRate = bestRefreshRate;
        int i = refreshRates.length - 1;
    L3:
        if (i < 0) goto L11;
        this.mMinSupportedRefreshRate = Math.min(this.mMinSupportedRefreshRate, refreshRates[i]);
        this.mMaxSupportedRefreshRate = Math.max(this.mMaxSupportedRefreshRate, refreshRates[i]);
        if (refreshRates[i] < 60.0f) goto L9;
        if (refreshRates[i] >= bestRefreshRate) goto L9;
        bestRefreshRate = refreshRates[i];
    L9:
        i = i - 1;
        goto L3
    L11:
        return displayInfo.findDefaultModeByRefreshRate(bestRefreshRate);
    }

    void addRefreshRateRangeForPackage(String packageName, float minRefreshRate, float maxRefreshRate) {
        this.mNonHighRefreshRatePackages.add(packageName, minRefreshRate, maxRefreshRate);
        this.mWmService.requestTraversal();
    }

    void removeRefreshRateRangeForPackage(String packageName) {
        this.mNonHighRefreshRatePackages.remove(packageName);
        this.mWmService.requestTraversal();
    }

    int getPreferredModeId(WindowState w) {
        int preferredDisplayModeId = w.mAttrs.preferredDisplayModeId;
        if (preferredDisplayModeId > 0) goto L6;
        return 0;
    L6:
        int forceRefreshRateId = this.mForceList.getForceRefreshRateId(w.getOwningPackage());
        if (forceRefreshRateId <= 0) goto L9;
        return forceRefreshRateId;
    L9:
        return preferredDisplayModeId;
    }

    int calculatePriority(WindowState w) {
        boolean isFocused = w.isFocused();
        int preferredModeId = getPreferredModeId(w);
        if (isFocused == true) goto L7;
        if (preferredModeId <= 0) goto L7;
        return 2;
    L7:
        if (isFocused == false) goto L11;
        if (preferredModeId != 0) goto L11;
        return 1;
    L11:
        if (isFocused == false) goto L15;
        if (preferredModeId <= 0) goto L17;
        return 0;
    L17:
        return -1;
    L15:
        return -1;
    }

    boolean updateFrameRateVote(WindowState w) {
        int refreshRateSwitchingType = this.mWmService.mDisplayManagerInternal.getRefreshRateSwitchingType();
        if (refreshRateSwitchingType == 0) goto L5;
        float forceRefreshRate = this.mForceList.getForceRefreshRate(w.getOwningPackage());
        if (forceRefreshRate <= 0.0f) goto L11;
        return w.mFrameRateVote.update(forceRefreshRate, 100, 1);
    L11:
        if (w.isInsetsAnimationRunning() == false) goto L15;
        return w.mFrameRateVote.reset();
    L15:
        if (refreshRateSwitchingType == 3) goto L27;
        int preferredModeId = w.mAttrs.preferredDisplayModeId;
        if (preferredModeId <= 0) goto L27;
        Display.Mode[] r8 = this.mDisplayInfo.appsSupportedModes;
        int r9 = r8.length;
        int r10 = 0;
    L20:
        if (r10 >= r9) goto L27;
        Display.Mode mode = r8[r10];
        if (preferredModeId == mode.getModeId()) goto L24;
        r10 = r10 + 1;
        goto L20
    L24:
        return w.mFrameRateVote.update(mode.getRefreshRate(), 100, 1);
    L27:
        if (w.mAttrs.preferredRefreshRate > 0.0f) goto L29;
        if (refreshRateSwitchingType == 3) goto L36;
        String packageName = w.getOwningPackage();
        if (this.mHighRefreshRateDenylist.isDenylisted(packageName) == false) goto L36;
        return w.mFrameRateVote.update(this.mLowRefreshRateMode.getRefreshRate(), 100, 1);
    L36:
        return w.mFrameRateVote.reset();
    L29:
        return w.mFrameRateVote.update(w.mAttrs.preferredRefreshRate, 0, 1);
    L5:
        return w.mFrameRateVote.reset();
    }

    float getPreferredMinRefreshRate(WindowState w) {
        if (w.isAnimationRunningSelfOrParent() == false) goto L5;
    L16:
        return 0.0f;
    L5:
        if (w.isInsetsAnimationRunning() == true) goto L16;
        if (w.mAttrs.preferredMinDisplayRefreshRate > 0.0f) goto L10;
        String packageName = w.getOwningPackage();
        SurfaceControl.RefreshRateRange range = this.mNonHighRefreshRatePackages.get(packageName);
        if (range != null) goto L14;
        return 0.0f;
    L14:
        return range.min;
    L10:
        return w.mAttrs.preferredMinDisplayRefreshRate;
    }

    float getPreferredMaxRefreshRate(WindowState w) {
        if (w.isAnimationRunningSelfOrParent() == false) goto L5;
    L16:
        return 0.0f;
    L5:
        if (w.isInsetsAnimationRunning() == true) goto L16;
        if (w.mAttrs.preferredMaxDisplayRefreshRate > 0.0f) goto L10;
        String packageName = w.getOwningPackage();
        SurfaceControl.RefreshRateRange range = this.mNonHighRefreshRatePackages.get(packageName);
        if (range != null) goto L14;
        return 0.0f;
    L14:
        return range.max;
    L10:
        return w.mAttrs.preferredMaxDisplayRefreshRate;
    }
}
