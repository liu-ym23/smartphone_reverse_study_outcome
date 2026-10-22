package com.android.server.display.mode;

import android.util.Slog;
import android.util.SparseArray;
import android.view.Display;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class VoteSummary {
    private static final float FLOAT_TOLERANCE = 0.01f;
    private static final String TAG = "VoteSummary";
    public float appRequestBaseModeRefreshRate;
    public boolean disableRefreshRateSwitching;
    public int height;
    final boolean mIsDisplayResolutionRangeVotingEnabled;
    private final boolean mLoggingEnabled;
    private final boolean mSupportedModesVoteEnabled;
    private final boolean mSupportsFrameRateOverride;
    public float maxPhysicalRefreshRate;
    public float maxRenderFrameRate;
    public int minHeight;
    public float minPhysicalRefreshRate;
    public float minRenderFrameRate;
    public int minWidth;
    public Set<Integer> rejectedModeIds;
    public Set<Float> requestedRefreshRates;
    public List<Integer> supportedModeIds;
    public List<SupportedRefreshRatesVote.RefreshRates> supportedRefreshRates;
    public int width;

    VoteSummary(boolean isDisplayResolutionRangeVotingEnabled, boolean supportedModesVoteEnabled, boolean loggingEnabled, boolean supportsFrameRateOverride) {
        this.requestedRefreshRates = new HashSet();
        this.rejectedModeIds = new HashSet();
        this.mIsDisplayResolutionRangeVotingEnabled = isDisplayResolutionRangeVotingEnabled;
        this.mSupportedModesVoteEnabled = supportedModesVoteEnabled;
        this.mLoggingEnabled = loggingEnabled;
        this.mSupportsFrameRateOverride = supportsFrameRateOverride;
        reset();
    }

    void applyVotes(SparseArray<Vote> votes, int lowestConsideredPriority, int highestConsideredPriority) {
        reset();
        int priority = highestConsideredPriority;
    L3:
        if (priority < lowestConsideredPriority) goto L10;
        Vote vote = votes.get(priority);
        if (vote == null) goto L8;
        vote.updateSummary(this);
    L8:
        priority = priority - 1;
        goto L3
    L10:
        if (this.mLoggingEnabled == false) goto L16;
        Slog.i(TAG, "applyVotes for range [" + Vote.priorityToString(lowestConsideredPriority) + ", " + Vote.priorityToString(highestConsideredPriority) + "]: " + this);
        return;
    }

    void adjustSize(Display.Mode defaultMode, Display.Mode[] modes) {
        if (this.height != (-1)) goto L5;
    L10:
        this.width = defaultMode.getPhysicalWidth();
        this.height = defaultMode.getPhysicalHeight();
    L12:
        if (this.mLoggingEnabled == false) goto L15;
        Slog.i(TAG, "adjustSize: " + this);
        return;
    L15:
        return;
    L5:
        if (this.width == (-1)) goto L10;
        if (this.mIsDisplayResolutionRangeVotingEnabled == false) goto L12;
        updateSummaryWithBestAllowedResolution(modes);
        goto L12
    }

    void limitRefreshRanges(VoteSummary otherSummary) {
        this.minPhysicalRefreshRate = Math.min(this.minPhysicalRefreshRate, otherSummary.minPhysicalRefreshRate);
        this.maxPhysicalRefreshRate = Math.max(this.maxPhysicalRefreshRate, otherSummary.maxPhysicalRefreshRate);
        this.minRenderFrameRate = Math.min(this.minRenderFrameRate, otherSummary.minRenderFrameRate);
        this.maxRenderFrameRate = Math.max(this.maxRenderFrameRate, otherSummary.maxRenderFrameRate);
        if (this.mLoggingEnabled == false) goto L6;
        Slog.i(TAG, "limitRefreshRanges: " + this);
        return;
    }

    List<Display.Mode> filterModes(Display.Mode[] modes) {
        if (isValid() == false) goto L5;
        ArrayList<Display.Mode> availableModes = new ArrayList();
        int r2 = 0;
        if (this.appRequestBaseModeRefreshRate <= 0.0f) goto L9;
        boolean missingBaseModeRefreshRate = true;
    L10:
        int r3 = modes.length;
    L11:
        if (r2 >= r3) goto L37;
        Display.Mode mode = modes[r2];
        if (validateRefreshRatesSupported(mode) == false) goto L36;
        if (validateModeSupported(mode) == false) goto L36;
        if (validateModeRejected(mode) == false) goto L36;
        if (validateModeSize(mode) == false) goto L36;
        if (validateModeWithinPhysicalRefreshRange(mode) == false) goto L36;
        if (validateModeWithinRenderRefreshRange(mode) == false) goto L36;
        if (validateModeRenderRateAchievable(mode) == false) goto L36;
        availableModes.add(mode);
        if (equalsWithinFloatTolerance(mode.getRefreshRate(), this.appRequestBaseModeRefreshRate) == false) goto L36;
        missingBaseModeRefreshRate = false;
    L36:
        r2 = r2 + 1;
        goto L11
    L37:
        if (missingBaseModeRefreshRate == true) goto L39;
        return availableModes;
    L39:
        return new ArrayList();
    L9:
        missingBaseModeRefreshRate = false;
        goto L10
    L5:
        return new ArrayList();
    }

    Display.Mode selectBaseMode(List<Display.Mode> availableModes, Display.Mode defaultMode) {
        if (this.appRequestBaseModeRefreshRate <= 0.0f) goto L5;
        float preferredRefreshRate = this.appRequestBaseModeRefreshRate;
    L6:
        Iterator<Display.Mode> r1 = availableModes.iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        Display.Mode availableMode = r1.next();
        if (equalsWithinFloatTolerance(preferredRefreshRate, availableMode.getRefreshRate()) == false) goto L8;
        return availableMode;
    L14:
        if (availableModes.isEmpty() == false) goto L21;
        return null;
    L21:
        return availableModes.get(0);
    L5:
        preferredRefreshRate = defaultMode.getRefreshRate();
        goto L6
    }

    void disableModeSwitching(float fps) {
        this.maxPhysicalRefreshRate = fps;
        this.minPhysicalRefreshRate = fps;
        this.maxRenderFrameRate = Math.min(this.maxRenderFrameRate, fps);
        if (this.mLoggingEnabled == false) goto L6;
        Slog.i(TAG, "Disabled mode switching on summary: " + this);
        return;
    }

    void disableRenderRateSwitching(float fps) {
        this.minRenderFrameRate = this.maxRenderFrameRate;
        if (isRenderRateAchievable(fps) == true) goto L6;
        this.maxRenderFrameRate = fps;
        this.minRenderFrameRate = fps;
    L6:
        if (this.mLoggingEnabled == false) goto L9;
        Slog.i(TAG, "Disabled render rate switching on summary: " + this);
        return;
    }

    private boolean validateModeSize(Display.Mode mode) {
        if (mode.getPhysicalWidth() != this.width) goto L10;
        if (mode.getPhysicalHeight() != this.height) goto L10;
        return true;
    L10:
        if (this.mLoggingEnabled == false) goto L14;
        Slog.w(TAG, "Discarding mode " + mode.getModeId() + ", wrong size: desiredWidth=" + this.width + ": desiredHeight=" + this.height + ": actualWidth=" + mode.getPhysicalWidth() + ": actualHeight=" + mode.getPhysicalHeight());
        return false;
    L14:
        return false;
    }

    private boolean validateModeWithinPhysicalRefreshRange(Display.Mode mode) {
        float refreshRate = mode.getRefreshRate();
        if (refreshRate < (this.minPhysicalRefreshRate - 0.01f)) goto L10;
        if (refreshRate > (this.maxPhysicalRefreshRate + 0.01f)) goto L10;
        return true;
    L10:
        if (this.mLoggingEnabled == false) goto L14;
        Slog.w(TAG, "Discarding mode " + mode.getModeId() + ", outside refresh rate bounds: minPhysicalRefreshRate=" + this.minPhysicalRefreshRate + ", maxPhysicalRefreshRate=" + this.maxPhysicalRefreshRate + ", modeRefreshRate=" + refreshRate);
        return false;
    L14:
        return false;
    }

    private boolean validateModeWithinRenderRefreshRange(Display.Mode mode) {
        float refreshRate = mode.getRefreshRate();
        if (this.mSupportsFrameRateOverride == false) goto L5;
        return true;
    L5:
        if (refreshRate < (this.minRenderFrameRate - 0.01f)) goto L9;
        if (refreshRate > (this.maxRenderFrameRate + 0.01f)) goto L9;
        return true;
    L9:
        if (this.mLoggingEnabled == false) goto L15;
        Slog.w(TAG, "Discarding mode " + mode.getModeId() + ", outside render rate bounds: minRenderFrameRate=" + this.minRenderFrameRate + ", maxRenderFrameRate=" + this.maxRenderFrameRate + ", modeRefreshRate=" + refreshRate);
        return false;
    L15:
        return false;
    }

    private boolean validateModeRenderRateAchievable(Display.Mode mode) {
        float refreshRate = mode.getRefreshRate();
        if (isRenderRateAchievable(refreshRate) == false) goto L5;
        return true;
    L5:
        if (this.mLoggingEnabled == false) goto L11;
        Slog.w(TAG, "Discarding mode " + mode.getModeId() + ", outside frame rate bounds: minRenderFrameRate=" + this.minRenderFrameRate + ", maxRenderFrameRate=" + this.maxRenderFrameRate + ", modePhysicalRefreshRate=" + refreshRate);
        return false;
    L11:
        return false;
    }

    private boolean validateModeSupported(Display.Mode mode) {
        if (this.supportedModeIds != null) goto L5;
    L15:
        return true;
    L5:
        if (this.mSupportedModesVoteEnabled == false) goto L15;
        if (this.supportedModeIds.contains(Integer.valueOf(mode.getModeId())) == false) goto L11;
        return true;
    L11:
        if (this.mLoggingEnabled == false) goto L16;
        Slog.w(TAG, "Discarding mode " + mode.getModeId() + ", supportedMode not found: mode.modeId=" + mode.getModeId() + ", supportedModeIds=" + this.supportedModeIds);
        return false;
    L16:
        return false;
    }

    private boolean validateModeRejected(Display.Mode mode) {
        if (this.rejectedModeIds != null) goto L6;
        return true;
    L6:
        if (this.rejectedModeIds.contains(Integer.valueOf(mode.getModeId())) == true) goto L9;
        return true;
    L9:
        if (this.mLoggingEnabled == false) goto L13;
        Slog.w(TAG, "Discarding mode" + mode.getModeId() + ", is a rejectedMode: mode.modeId=" + mode.getModeId() + ", rejectedModeIds=" + this.rejectedModeIds);
        return false;
    L13:
        return false;
    }

    private boolean validateRefreshRatesSupported(Display.Mode mode) {
        if (this.supportedRefreshRates != null) goto L5;
    L21:
        return true;
    L5:
        if (this.mSupportedModesVoteEnabled == false) goto L21;
        Iterator<SupportedRefreshRatesVote.RefreshRates> r0 = this.supportedRefreshRates.iterator();
    L9:
        if (r0.hasNext() == false) goto L17;
        SupportedRefreshRatesVote.RefreshRates refreshRates = r0.next();
        if (equalsWithinFloatTolerance(mode.getRefreshRate(), refreshRates.mPeakRefreshRate) == false) goto L9;
        if (equalsWithinFloatTolerance(mode.getVsyncRate(), refreshRates.mVsyncRate) == false) goto L9;
        return true;
    L17:
        if (this.mLoggingEnabled == false) goto L28;
        Slog.w(TAG, "Discarding mode " + mode.getModeId() + ", supportedRefreshRates not found: mode.refreshRate=" + mode.getRefreshRate() + ", mode.vsyncRate=" + mode.getVsyncRate() + ", supportedRefreshRates=" + this.supportedRefreshRates);
        return false;
    L28:
        return false;
    }

    private boolean isRenderRateAchievable(float physicalRefreshRate) {
        int divisor = (int) Math.ceil((physicalRefreshRate / this.maxRenderFrameRate) - 0.01f);
        float adjustedPhysicalRefreshRate = physicalRefreshRate / divisor;
        if (adjustedPhysicalRefreshRate < (this.minRenderFrameRate - 0.01f)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isValid() {
        if (this.minRenderFrameRate <= (this.maxRenderFrameRate + 0.01f)) goto L9;
        if (this.mLoggingEnabled == false) goto L7;
        Slog.w(TAG, "Vote summary resulted in empty set (invalid frame rate range): minRenderFrameRate=" + this.minRenderFrameRate + ", maxRenderFrameRate=" + this.maxRenderFrameRate);
    L7:
        return false;
    L9:
        if (this.supportedRefreshRates != null) goto L11;
    L18:
        Iterator<Float> r0 = this.requestedRefreshRates.iterator();
    L20:
        if (r0.hasNext() == false) goto L31;
        Float requestedRefreshRate = r0.next();
        if (requestedRefreshRate.floatValue() < this.minRenderFrameRate) goto L28;
        if (requestedRefreshRate.floatValue() <= this.maxRenderFrameRate) goto L20;
    L28:
        if (this.mLoggingEnabled == false) goto L30;
        Slog.w(TAG, "Requested refreshRate is outside frame rate range: requestedRefreshRates=" + this.requestedRefreshRates + ", requestedRefreshRate=" + requestedRefreshRate + ", minRenderFrameRate=" + this.minRenderFrameRate + ", maxRenderFrameRate=" + this.maxRenderFrameRate);
    L30:
        return false;
    L31:
        return true;
    L11:
        if (this.mSupportedModesVoteEnabled == false) goto L18;
        if (this.supportedRefreshRates.isEmpty() == false) goto L18;
        if (this.mLoggingEnabled == false) goto L17;
        Slog.w(TAG, "Vote summary resulted in empty set (empty supportedModes)");
    L17:
        return false;
    }

    private void updateSummaryWithBestAllowedResolution(Display.Mode[] supportedModes) {
        int maxAllowedWidth = this.width;
        int maxAllowedHeight = this.height;
        this.width = -1;
        this.height = -1;
        int maxNumberOfPixels = 0;
        int r3 = supportedModes.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L25;
        Display.Mode mode = supportedModes[r4];
        if (mode.getPhysicalWidth() > maxAllowedWidth) goto L24;
        if (mode.getPhysicalHeight() > maxAllowedHeight) goto L24;
        if (mode.getPhysicalWidth() < this.minWidth) goto L24;
        if (mode.getPhysicalHeight() < this.minHeight) goto L24;
        if (mode.getRefreshRate() < (this.minPhysicalRefreshRate - 0.01f)) goto L24;
        if (mode.getRefreshRate() > (this.maxPhysicalRefreshRate + 0.01f)) goto L24;
        int numberOfPixels = mode.getPhysicalHeight() * mode.getPhysicalWidth();
        if (numberOfPixels <= maxNumberOfPixels) goto L20;
    L23:
        maxNumberOfPixels = numberOfPixels;
        this.width = mode.getPhysicalWidth();
        this.height = mode.getPhysicalHeight();
        goto L24
    L20:
        if (mode.getPhysicalWidth() != maxAllowedWidth) goto L24;
        if (mode.getPhysicalHeight() == maxAllowedHeight) goto L23;
    L24:
        r4 = r4 + 1;
        goto L3
    }

    private void reset() {
        this.minPhysicalRefreshRate = 0.0f;
        this.maxPhysicalRefreshRate = Float.POSITIVE_INFINITY;
        this.minRenderFrameRate = 0.0f;
        this.maxRenderFrameRate = Float.POSITIVE_INFINITY;
        this.width = -1;
        this.height = -1;
        this.minWidth = 0;
        this.minHeight = 0;
        this.disableRefreshRateSwitching = false;
        this.appRequestBaseModeRefreshRate = 0.0f;
        this.requestedRefreshRates.clear();
        this.supportedRefreshRates = null;
        this.supportedModeIds = null;
        this.rejectedModeIds.clear();
        if (this.mLoggingEnabled == false) goto L6;
        Slog.i(TAG, "Summary reset: " + this);
        return;
    }

    private static boolean equalsWithinFloatTolerance(float a, float b) {
        if (a >= (b - 0.01f)) goto L5;
    L7:
        return false;
    L5:
        if (a > (0.01f + b)) goto L7;
        return true;
    }

    public String toString() {
        return "VoteSummary{ minPhysicalRefreshRate=" + this.minPhysicalRefreshRate + ", maxPhysicalRefreshRate=" + this.maxPhysicalRefreshRate + ", minRenderFrameRate=" + this.minRenderFrameRate + ", maxRenderFrameRate=" + this.maxRenderFrameRate + ", width=" + this.width + ", height=" + this.height + ", minWidth=" + this.minWidth + ", minHeight=" + this.minHeight + ", disableRefreshRateSwitching=" + this.disableRefreshRateSwitching + ", appRequestBaseModeRefreshRate=" + this.appRequestBaseModeRefreshRate + ", requestRefreshRates=" + this.requestedRefreshRates + ", supportedRefreshRates=" + this.supportedRefreshRates + ", supportedModeIds=" + this.supportedModeIds + ", rejectedModeIds=" + this.rejectedModeIds + ", mIsDisplayResolutionRangeVotingEnabled=" + this.mIsDisplayResolutionRangeVotingEnabled + ", mSupportedModesVoteEnabled=" + this.mSupportedModesVoteEnabled + ", mSupportsFrameRateOverride=" + this.mSupportsFrameRateOverride + " }";
    }
}
