package com.android.server.wm;

import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.view.DisplayInfo;
import android.window.DesktopExperienceFlags;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class DisplayWindowSettings {
    private final IExtDisplayWindowSettings mExt;
    private final WindowManagerService mService;
    private final SettingsProvider mSettingsProvider;

    interface SettingsProvider {

        public static class SettingsEntry {
            Boolean mDontMoveToTop;
            Integer mFixedToUserRotation;
            int mForcedDensity;
            float mForcedDensityRatio;
            int mForcedHeight;
            Integer mForcedScalingMode;
            int mForcedWidth;
            Boolean mIgnoreActivitySizeRestrictions;
            Boolean mIgnoreDisplayCutout;
            Boolean mIgnoreOrientationRequest;
            Integer mImePolicy;
            Boolean mIsHomeSupported;
            int mRemoveContentMode;
            Boolean mShouldShowSystemDecors;
            Boolean mShouldShowWithInsecureKeyguard;
            Integer mUserRotation;
            Integer mUserRotationMode;
            int mWindowingMode;

            SettingsEntry() {
                this.mWindowingMode = 0;
                this.mRemoveContentMode = 0;
            }

            SettingsEntry(SettingsEntry copyFrom) {
                this.mWindowingMode = 0;
                this.mRemoveContentMode = 0;
                setTo(copyFrom);
            }

            boolean setTo(SettingsEntry other) {
                boolean changed = false;
                if (other.mWindowingMode == this.mWindowingMode) goto L6;
                this.mWindowingMode = other.mWindowingMode;
                changed = true;
            L6:
                if (Objects.equals(other.mUserRotationMode, this.mUserRotationMode) == true) goto L9;
                this.mUserRotationMode = other.mUserRotationMode;
                changed = true;
            L9:
                if (Objects.equals(other.mUserRotation, this.mUserRotation) == true) goto L12;
                this.mUserRotation = other.mUserRotation;
                changed = true;
            L12:
                if (other.mForcedWidth == this.mForcedWidth) goto L15;
                this.mForcedWidth = other.mForcedWidth;
                changed = true;
            L15:
                if (other.mForcedHeight == this.mForcedHeight) goto L18;
                this.mForcedHeight = other.mForcedHeight;
                changed = true;
            L18:
                if (other.mForcedDensity == this.mForcedDensity) goto L21;
                this.mForcedDensity = other.mForcedDensity;
                changed = true;
            L21:
                if (other.mForcedDensityRatio == this.mForcedDensityRatio) goto L24;
                this.mForcedDensityRatio = other.mForcedDensityRatio;
                changed = true;
            L24:
                if (Objects.equals(other.mForcedScalingMode, this.mForcedScalingMode) == true) goto L27;
                this.mForcedScalingMode = other.mForcedScalingMode;
                changed = true;
            L27:
                if (other.mRemoveContentMode == this.mRemoveContentMode) goto L30;
                this.mRemoveContentMode = other.mRemoveContentMode;
                changed = true;
            L30:
                if (Objects.equals(other.mShouldShowWithInsecureKeyguard, this.mShouldShowWithInsecureKeyguard) == true) goto L33;
                this.mShouldShowWithInsecureKeyguard = other.mShouldShowWithInsecureKeyguard;
                changed = true;
            L33:
                if (Objects.equals(other.mShouldShowSystemDecors, this.mShouldShowSystemDecors) == true) goto L36;
                this.mShouldShowSystemDecors = other.mShouldShowSystemDecors;
                changed = true;
            L36:
                if (Objects.equals(other.mIsHomeSupported, this.mIsHomeSupported) == true) goto L39;
                this.mIsHomeSupported = other.mIsHomeSupported;
                changed = true;
            L39:
                if (Objects.equals(other.mImePolicy, this.mImePolicy) == true) goto L42;
                this.mImePolicy = other.mImePolicy;
                changed = true;
            L42:
                if (Objects.equals(other.mFixedToUserRotation, this.mFixedToUserRotation) == true) goto L45;
                this.mFixedToUserRotation = other.mFixedToUserRotation;
                changed = true;
            L45:
                if (Objects.equals(other.mIgnoreOrientationRequest, this.mIgnoreOrientationRequest) == true) goto L48;
                this.mIgnoreOrientationRequest = other.mIgnoreOrientationRequest;
                changed = true;
            L48:
                if (Objects.equals(other.mIgnoreDisplayCutout, this.mIgnoreDisplayCutout) == true) goto L51;
                this.mIgnoreDisplayCutout = other.mIgnoreDisplayCutout;
                changed = true;
            L51:
                if (Objects.equals(other.mDontMoveToTop, this.mDontMoveToTop) == true) goto L54;
                this.mDontMoveToTop = other.mDontMoveToTop;
                changed = true;
            L54:
                if (Objects.equals(other.mIgnoreActivitySizeRestrictions, this.mIgnoreActivitySizeRestrictions) == true) goto L57;
                this.mIgnoreActivitySizeRestrictions = other.mIgnoreActivitySizeRestrictions;
                return true;
            L57:
                return changed;
            }

            boolean updateFrom(SettingsEntry delta) {
                boolean changed = false;
                if (delta.mWindowingMode == 0) goto L8;
                if (delta.mWindowingMode == this.mWindowingMode) goto L8;
                this.mWindowingMode = delta.mWindowingMode;
                changed = true;
            L8:
                if (delta.mUserRotationMode == null) goto L13;
                if (Objects.equals(delta.mUserRotationMode, this.mUserRotationMode) == true) goto L13;
                this.mUserRotationMode = delta.mUserRotationMode;
                changed = true;
            L13:
                if (delta.mUserRotation == null) goto L18;
                if (Objects.equals(delta.mUserRotation, this.mUserRotation) == true) goto L18;
                this.mUserRotation = delta.mUserRotation;
                changed = true;
            L18:
                if (delta.mForcedWidth == 0) goto L23;
                if (delta.mForcedWidth == this.mForcedWidth) goto L23;
                this.mForcedWidth = delta.mForcedWidth;
                changed = true;
            L23:
                if (delta.mForcedHeight == 0) goto L28;
                if (delta.mForcedHeight == this.mForcedHeight) goto L28;
                this.mForcedHeight = delta.mForcedHeight;
                changed = true;
            L28:
                if (delta.mForcedDensity == 0) goto L33;
                if (delta.mForcedDensity == this.mForcedDensity) goto L33;
                this.mForcedDensity = delta.mForcedDensity;
                changed = true;
            L33:
                if (delta.mForcedDensityRatio == 0.0f) goto L38;
                if (delta.mForcedDensityRatio == this.mForcedDensityRatio) goto L38;
                this.mForcedDensityRatio = delta.mForcedDensityRatio;
                changed = true;
            L38:
                if (delta.mForcedScalingMode == null) goto L43;
                if (Objects.equals(delta.mForcedScalingMode, this.mForcedScalingMode) == true) goto L43;
                this.mForcedScalingMode = delta.mForcedScalingMode;
                changed = true;
            L43:
                if (delta.mRemoveContentMode == 0) goto L48;
                if (delta.mRemoveContentMode == this.mRemoveContentMode) goto L48;
                this.mRemoveContentMode = delta.mRemoveContentMode;
                changed = true;
            L48:
                if (delta.mShouldShowWithInsecureKeyguard == null) goto L53;
                if (Objects.equals(delta.mShouldShowWithInsecureKeyguard, this.mShouldShowWithInsecureKeyguard) == true) goto L53;
                this.mShouldShowWithInsecureKeyguard = delta.mShouldShowWithInsecureKeyguard;
                changed = true;
            L53:
                if (delta.mShouldShowSystemDecors == null) goto L58;
                if (Objects.equals(delta.mShouldShowSystemDecors, this.mShouldShowSystemDecors) == true) goto L58;
                this.mShouldShowSystemDecors = delta.mShouldShowSystemDecors;
                changed = true;
            L58:
                if (delta.mIsHomeSupported == null) goto L63;
                if (Objects.equals(delta.mIsHomeSupported, this.mIsHomeSupported) == true) goto L63;
                this.mIsHomeSupported = delta.mIsHomeSupported;
                changed = true;
            L63:
                if (delta.mImePolicy == null) goto L68;
                if (Objects.equals(delta.mImePolicy, this.mImePolicy) == true) goto L68;
                this.mImePolicy = delta.mImePolicy;
                changed = true;
            L68:
                if (delta.mFixedToUserRotation == null) goto L73;
                if (Objects.equals(delta.mFixedToUserRotation, this.mFixedToUserRotation) == true) goto L73;
                this.mFixedToUserRotation = delta.mFixedToUserRotation;
                changed = true;
            L73:
                if (delta.mIgnoreOrientationRequest == null) goto L78;
                if (Objects.equals(delta.mIgnoreOrientationRequest, this.mIgnoreOrientationRequest) == true) goto L78;
                this.mIgnoreOrientationRequest = delta.mIgnoreOrientationRequest;
                changed = true;
            L78:
                if (delta.mIgnoreDisplayCutout == null) goto L83;
                if (Objects.equals(delta.mIgnoreDisplayCutout, this.mIgnoreDisplayCutout) == true) goto L83;
                this.mIgnoreDisplayCutout = delta.mIgnoreDisplayCutout;
                changed = true;
            L83:
                if (delta.mDontMoveToTop == null) goto L88;
                if (Objects.equals(delta.mDontMoveToTop, this.mDontMoveToTop) == true) goto L88;
                this.mDontMoveToTop = delta.mDontMoveToTop;
                changed = true;
            L88:
                if (delta.mIgnoreActivitySizeRestrictions != null) goto L90;
                return changed;
            L90:
                if (Objects.equals(delta.mIgnoreActivitySizeRestrictions, this.mIgnoreActivitySizeRestrictions) == true) goto L94;
                this.mIgnoreActivitySizeRestrictions = delta.mIgnoreActivitySizeRestrictions;
                return true;
            L94:
                return changed;
            }

            boolean isEmpty() {
                if (this.mWindowingMode == 0) goto L5;
            L39:
                return false;
            L5:
                if (this.mUserRotationMode != null) goto L39;
                if (this.mUserRotation != null) goto L39;
                if (this.mForcedWidth != 0) goto L39;
                if (this.mForcedHeight != 0) goto L39;
                if (this.mForcedDensity != 0) goto L39;
                if (this.mForcedDensityRatio != 0.0f) goto L39;
                if (this.mForcedScalingMode != null) goto L39;
                if (this.mRemoveContentMode != 0) goto L39;
                if (this.mShouldShowWithInsecureKeyguard != null) goto L39;
                if (this.mShouldShowSystemDecors != null) goto L39;
                if (this.mIsHomeSupported != null) goto L39;
                if (this.mImePolicy != null) goto L39;
                if (this.mFixedToUserRotation != null) goto L39;
                if (this.mIgnoreOrientationRequest != null) goto L39;
                if (this.mIgnoreDisplayCutout != null) goto L39;
                if (this.mDontMoveToTop != null) goto L39;
                if (this.mIgnoreActivitySizeRestrictions != null) goto L39;
                return true;
            }

            public boolean equals(Object o) {
                if (this != o) goto L6;
                return true;
            L6:
                if (o != null) goto L8;
            L49:
                return false;
            L8:
                if (getClass() != o.getClass()) goto L49;
                SettingsEntry that = (SettingsEntry) o;
                if (this.mWindowingMode != that.mWindowingMode) goto L48;
                if (this.mForcedWidth != that.mForcedWidth) goto L48;
                if (this.mForcedHeight != that.mForcedHeight) goto L48;
                if (this.mForcedDensity != that.mForcedDensity) goto L48;
                if (this.mRemoveContentMode != that.mRemoveContentMode) goto L48;
                if (this.mForcedDensityRatio != that.mForcedDensityRatio) goto L48;
                if (Objects.equals(this.mUserRotationMode, that.mUserRotationMode) == false) goto L48;
                if (Objects.equals(this.mUserRotation, that.mUserRotation) == false) goto L48;
                if (Objects.equals(this.mForcedScalingMode, that.mForcedScalingMode) == false) goto L48;
                if (Objects.equals(this.mShouldShowWithInsecureKeyguard, that.mShouldShowWithInsecureKeyguard) == false) goto L48;
                if (Objects.equals(this.mShouldShowSystemDecors, that.mShouldShowSystemDecors) == false) goto L48;
                if (Objects.equals(this.mIsHomeSupported, that.mIsHomeSupported) == false) goto L48;
                if (Objects.equals(this.mImePolicy, that.mImePolicy) == false) goto L48;
                if (Objects.equals(this.mFixedToUserRotation, that.mFixedToUserRotation) == false) goto L48;
                if (Objects.equals(this.mIgnoreOrientationRequest, that.mIgnoreOrientationRequest) == false) goto L48;
                if (Objects.equals(this.mIgnoreDisplayCutout, that.mIgnoreDisplayCutout) == false) goto L48;
                if (Objects.equals(this.mDontMoveToTop, that.mDontMoveToTop) == false) goto L48;
                if (Objects.equals(this.mIgnoreActivitySizeRestrictions, that.mIgnoreActivitySizeRestrictions) == false) goto L48;
                return true;
            L48:
                return false;
            }

            public int hashCode() {
                return Objects.hash(new Object[]{Integer.valueOf(this.mWindowingMode), this.mUserRotationMode, this.mUserRotation, Integer.valueOf(this.mForcedWidth), Integer.valueOf(this.mForcedHeight), Integer.valueOf(this.mForcedDensity), Float.valueOf(this.mForcedDensityRatio), this.mForcedScalingMode, Integer.valueOf(this.mRemoveContentMode), this.mShouldShowWithInsecureKeyguard, this.mShouldShowSystemDecors, this.mIsHomeSupported, this.mImePolicy, this.mFixedToUserRotation, this.mIgnoreOrientationRequest, this.mIgnoreDisplayCutout, this.mDontMoveToTop, this.mIgnoreActivitySizeRestrictions});
            }

            public String toString() {
                return "SettingsEntry{mWindowingMode=" + this.mWindowingMode + ", mUserRotationMode=" + this.mUserRotationMode + ", mUserRotation=" + this.mUserRotation + ", mForcedWidth=" + this.mForcedWidth + ", mForcedHeight=" + this.mForcedHeight + ", mForcedDensity=" + this.mForcedDensity + ", mForcedDensityRatio=" + this.mForcedDensityRatio + ", mForcedScalingMode=" + this.mForcedScalingMode + ", mRemoveContentMode=" + this.mRemoveContentMode + ", mShouldShowWithInsecureKeyguard=" + this.mShouldShowWithInsecureKeyguard + ", mShouldShowSystemDecors=" + this.mShouldShowSystemDecors + ", mIsHomeSupported=" + this.mIsHomeSupported + ", mShouldShowIme=" + this.mImePolicy + ", mFixedToUserRotation=" + this.mFixedToUserRotation + ", mIgnoreOrientationRequest=" + this.mIgnoreOrientationRequest + ", mIgnoreDisplayCutout=" + this.mIgnoreDisplayCutout + ", mDontMoveToTop=" + this.mDontMoveToTop + ", mForceAppsUniversalResizable=" + this.mIgnoreActivitySizeRestrictions + '}';
            }
        }

        void clearDisplaySettings(DisplayInfo r1);

        SettingsEntry getOverrideSettings(DisplayInfo r1);

        SettingsEntry getSettings(DisplayInfo r1);

        void onDisplayRemoved(DisplayInfo r1);

        void updateOverrideSettings(DisplayInfo r1, SettingsEntry r2);
    }

    DisplayWindowSettings(WindowManagerService service, SettingsProvider settingsProvider) {
        this.mExt = (IExtDisplayWindowSettings) ExtImplFactory.getImpl(IExtDisplayWindowSettings.class, new Object[]{this});
        this.mService = service;
        this.mSettingsProvider = settingsProvider;
    }

    void setUserRotation(DisplayContent displayContent, int rotationMode, int rotation) {
        DisplayInfo displayInfo = displayContent.getDisplayInfo();
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mUserRotationMode = Integer.valueOf(rotationMode);
        overrideSettings.mUserRotation = Integer.valueOf(rotation);
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    void setForcedSize(DisplayContent displayContent, int width, int height) {
        if (displayContent.isDefaultDisplay == false) goto L10;
        if (width == 0) goto L8;
        if (height == 0) goto L8;
        String sizeString = width + "," + height;
    L9:
        Settings.Global.putString(this.mService.mContext.getContentResolver(), "display_size_forced", sizeString);
    L8:
        sizeString = "";
    L10:
        DisplayInfo displayInfo = displayContent.getDisplayInfo();
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mForcedWidth = width;
        overrideSettings.mForcedHeight = height;
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    void setForcedDensity(DisplayInfo info, int density, int userId) {
        if (info.displayId != 0) goto L8;
        if (density != 0) goto L6;
        String densityString = "";
    L7:
        Settings.Secure.putStringForUser(this.mService.mContext.getContentResolver(), "display_density_forced", densityString, userId);
        goto L8
    L6:
        densityString = Integer.toString(density);
    L8:
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(info);
        overrideSettings.mForcedDensity = density;
        this.mSettingsProvider.updateOverrideSettings(info, overrideSettings);
    }

    void setForcedDensityRatio(DisplayInfo info, float ratio) {
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(info);
        overrideSettings.mForcedDensityRatio = ratio;
        this.mSettingsProvider.updateOverrideSettings(info, overrideSettings);
    }

    void setForcedScalingMode(DisplayContent displayContent, int mode) {
        if (displayContent.isDefaultDisplay == false) goto L5;
        Settings.Global.putInt(this.mService.mContext.getContentResolver(), "display_scaling_force", mode);
    L5:
        DisplayInfo displayInfo = displayContent.getDisplayInfo();
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mForcedScalingMode = Integer.valueOf(mode);
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    void setFixedToUserRotation(DisplayContent displayContent, int fixedToUserRotation) {
        DisplayInfo displayInfo = displayContent.getDisplayInfo();
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mFixedToUserRotation = Integer.valueOf(fixedToUserRotation);
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    void setIgnoreOrientationRequest(DisplayContent displayContent, Boolean ignoreOrientationRequest) {
        DisplayInfo displayInfo = displayContent.getDisplayInfo();
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mIgnoreOrientationRequest = ignoreOrientationRequest;
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    private int getWindowingModeLocked(SettingsProvider.SettingsEntry settings, DisplayContent dc) {
        int windowingModeFromDisplaySettings = settings.mWindowingMode;
        if (windowingModeFromDisplaySettings == 5) goto L5;
    L7:
        if (windowingModeFromDisplaySettings == 0) goto L10;
        return windowingModeFromDisplaySettings;
    L10:
        if (this.mService.mAtmService.mSupportsFreeformWindowManagement == true) goto L12;
    L16:
        boolean forceFreeForm = false;
    L18:
        if (forceFreeForm == false) goto L20;
        return 5;
    L20:
        int currentWindowingMode = dc.getDefaultTaskDisplayArea().getWindowingMode();
        if (currentWindowingMode != 0) goto L23;
        return 1;
    L23:
        if (currentWindowingMode != 5) goto L25;
        return 1;
    L25:
        return currentWindowingMode;
    L12:
        if (this.mService.mIsPc == false) goto L14;
    L15:
        forceFreeForm = true;
        goto L18
    L14:
        if (dc.isPublicSecondaryDisplayWithDesktopModeForceEnabled() == false) goto L16;
    L5:
        if (this.mService.mAtmService.mSupportsFreeformWindowManagement == true) goto L7;
        return 1;
    }

    int getWindowingModeLocked(DisplayContent dc) {
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry settings = this.mSettingsProvider.getSettings(displayInfo);
        return getWindowingModeLocked(settings, dc);
    }

    void setWindowingModeLocked(DisplayContent dc, int mode) {
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mWindowingMode = mode;
        TaskDisplayArea defaultTda = dc.getDefaultTaskDisplayArea();
        if (defaultTda == null) goto L5;
        defaultTda.setWindowingMode(mode);
    L5:
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    int getRemoveContentModeLocked(DisplayContent dc) {
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry settings = this.mSettingsProvider.getSettings(displayInfo);
        if (settings.mRemoveContentMode != 0) goto L13;
        if (dc.isPrivate() == false) goto L7;
        return 2;
    L7:
        if (dc.getDisplay().getRemoveMode() == 1) goto L14;
        return 1;
    L14:
        return 2;
    L13:
        return settings.mRemoveContentMode;
    }

    void setRemoveContentModeLocked(DisplayContent dc, int mode) {
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mRemoveContentMode = mode;
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    boolean shouldShowWithInsecureKeyguardLocked(DisplayContent dc) {
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry settings = this.mSettingsProvider.getSettings(displayInfo);
        if (settings.mShouldShowWithInsecureKeyguard != null) goto L7;
        return false;
    L7:
        return settings.mShouldShowWithInsecureKeyguard.booleanValue();
    }

    void setShouldShowWithInsecureKeyguardLocked(DisplayContent dc, boolean shouldShow) {
        if (dc.isPrivate() == true) goto L8;
        if (shouldShow == false) goto L8;
        throw new IllegalArgumentException("Public display can't be allowed to show content when locked");
    L8:
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mShouldShowWithInsecureKeyguard = Boolean.valueOf(shouldShow);
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    void setDontMoveToTop(DisplayContent dc, boolean dontMoveToTop) {
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getSettings(displayInfo);
        overrideSettings.mDontMoveToTop = Boolean.valueOf(dontMoveToTop);
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    boolean shouldShowSystemDecorsLocked(DisplayContent dc) {
        if (dc.getDisplayId() != 0) goto L6;
        return true;
    L6:
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry settings = this.mSettingsProvider.getSettings(displayInfo);
        if (settings.mShouldShowSystemDecors != null) goto L11;
        return false;
    L11:
        return settings.mShouldShowSystemDecors.booleanValue();
    }

    void setShouldShowSystemDecorsLocked(DisplayContent dc, boolean shouldShow) {
        if (shouldShow == shouldShowSystemDecorsLocked(dc)) goto L5;
        boolean changed = true;
    L6:
        setShouldShowSystemDecorsInternalLocked(dc, shouldShow);
        if (DesktopExperienceFlags.ENABLE_DISPLAY_CONTENT_MODE_MANAGEMENT.isTrue() == true) goto L9;
        return;
    L9:
        if (dc.isDefaultDisplay == false) goto L11;
        return;
    L11:
        if (dc.isPrivate() == true) goto L20;
        if (changed == false) goto L21;
        dc.getDisplayPolicy().updateHasNavigationBarIfNeeded();
        if (shouldShow == false) goto L17;
        this.mService.mRoot.startSystemDecorations(dc, "setShouldShowSystemDecorsLocked");
        return;
    L17:
        dc.getDisplayPolicy().notifyDisplayRemoveSystemDecorations();
        return;
    L21:
        return;
    L20:
        return;
    L5:
        changed = false;
        goto L6
    }

    void setShouldShowSystemDecorsInternalLocked(DisplayContent dc, boolean shouldShow) {
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mShouldShowSystemDecors = Boolean.valueOf(shouldShow);
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    boolean isHomeSupportedLocked(DisplayContent dc) {
        if (dc.getDisplayId() != 0) goto L6;
        return true;
    L6:
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry settings = this.mSettingsProvider.getSettings(displayInfo);
        if (settings.mIsHomeSupported == null) goto L10;
        return settings.mIsHomeSupported.booleanValue();
    L10:
        return shouldShowSystemDecorsLocked(dc);
    }

    void setHomeSupportedOnDisplayLocked(String displayUniqueId, int displayType, boolean supported) {
        DisplayInfo displayInfo = new DisplayInfo();
        displayInfo.uniqueId = displayUniqueId;
        displayInfo.type = displayType;
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mIsHomeSupported = Boolean.valueOf(supported);
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    boolean isIgnoreActivitySizeRestrictionsLocked(DisplayContent dc) {
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry settings = this.mSettingsProvider.getSettings(displayInfo);
        if (settings.mIgnoreActivitySizeRestrictions != null) goto L5;
    L7:
        return false;
    L5:
        if (settings.mIgnoreActivitySizeRestrictions.booleanValue() == false) goto L7;
        return true;
    }

    void setIgnoreActivitySizeRestrictionsOnDisplayLocked(String displayUniqueId, int displayType, boolean enabled) {
        DisplayInfo displayInfo = new DisplayInfo();
        displayInfo.uniqueId = displayUniqueId;
        displayInfo.type = displayType;
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mIgnoreActivitySizeRestrictions = Boolean.valueOf(enabled);
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    void clearDisplaySettings(String displayUniqueId, int displayType) {
        DisplayInfo displayInfo = new DisplayInfo();
        displayInfo.uniqueId = displayUniqueId;
        displayInfo.type = displayType;
        this.mSettingsProvider.clearDisplaySettings(displayInfo);
    }

    int getImePolicyLocked(DisplayContent dc) {
        if (dc.getDisplayId() != 0) goto L6;
        return 0;
    L6:
        if (dc.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L8;
        return 0;
    L8:
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry settings = this.mSettingsProvider.getSettings(displayInfo);
        if (settings.mImePolicy != null) goto L13;
        return 1;
    L13:
        return settings.mImePolicy.intValue();
    }

    void setDisplayImePolicy(DisplayContent dc, int imePolicy) {
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry overrideSettings = this.mSettingsProvider.getOverrideSettings(displayInfo);
        overrideSettings.mImePolicy = Integer.valueOf(imePolicy);
        this.mSettingsProvider.updateOverrideSettings(displayInfo, overrideSettings);
    }

    void applySettingsToDisplayLocked(DisplayContent dc) {
        applySettingsToDisplayLocked(dc, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v9 */
    void applySettingsToDisplayLocked(DisplayContent r22, boolean r23) {
        SettingsProvider.SettingsEntry r6 = this.mSettingsProvider.getSettings(r22.getDisplayInfo());
        int r9 = getWindowingModeLocked(r6, r22);
        TaskDisplayArea r10 = r22.getDefaultTaskDisplayArea();
        if (r10 == null) goto L6;
        r10.setWindowingMode(r9);
    L6:
        if (r6.mUserRotationMode == null) goto L8;
        int r2 = r6.mUserRotationMode.intValue();
    L9:
        int r12 = r2;
        if (r6.mUserRotation == null) goto L12;
        int r3 = r6.mUserRotation.intValue();
    L13:
        int r13 = r3;
        if (r6.mFixedToUserRotation == null) goto L16;
        int r4 = r6.mFixedToUserRotation.intValue();
    L17:
        r22.getDisplayRotation().restoreSettings(r12, r13, r4);
        if (r6.mForcedDensity == 0) goto L20;
        boolean r5 = true;
    L22:
        if (r6.mForcedDensityRatio == 0.0f) goto L24;
        boolean r7 = true;
    L25:
        boolean r16 = r7;
        if (r6.mForcedWidth != 0) goto L28;
    L30:
        boolean r8 = false;
    L31:
        r22.mIsDensityForced = r5;
        r22.mIsSizeForced = r8;
        if (r6.mIgnoreDisplayCutout == null) goto L34;
        boolean r11 = r6.mIgnoreDisplayCutout.booleanValue();
    L35:
        r22.mIgnoreDisplayCutout = r11;
        if (r8 == false) goto L38;
        int r14 = r6.mForcedWidth;
    L39:
        if (r8 == false) goto L41;
        int r15 = r6.mForcedHeight;
    L42:
        if (r5 == false) goto L44;
        int r17 = r6.mForcedDensity;
    L46:
        if (r16 == false) goto L48;
        int r18 = 0;
        r22.mForcedDisplayDensityRatio = r6.mForcedDensityRatio;
    L49:
        int r19 = r14;
        int r20 = r15;
        int r21 = r17;
        int[] r24 = this.mExt.handleResolutionMigration(r22, r19, r20, r21, r6, r22.isDefaultDisplay);
        if (r24 == null) goto L52;
        int r25 = r24[r18];
        int r26 = r24[1];
        int r27 = r24[2];
    L53:
        r22.updateBaseDisplayMetrics(r25, r26, r27, r22.mBaseDisplayPhysicalXDpi, r22.mBaseDisplayPhysicalYDpi);
        if (r6.mForcedScalingMode == null) goto L56;
        int r28 = r6.mForcedScalingMode.intValue();
    L57:
        ?? r29 = 1;
        if (r28 == 1) goto L61;
        r29 = r18;
    L61:
        r22.mDisplayScalingDisabled = r29;
        if (r6.mDontMoveToTop == null) goto L64;
        ?? r30 = r6.mDontMoveToTop.booleanValue();
    L66:
        if (r22.canStealTopFocus() == false) goto L70;
        if (r30 != 0) goto L70;
        ?? r0 = r18;
    L71:
        r22.mDontMoveToTop = r0;
        if (r23 == false) goto L75;
        applyRotationSettingsToDisplayLocked(r22);
        return;
    L75:
        return;
    L70:
        r0 = 1;
        goto L71
    L64:
        r30 = r18;
        goto L66
    L56:
        r28 = r18;
        goto L57
    L52:
        r25 = r19;
        r26 = r20;
        r27 = r21;
        goto L53
    L48:
        r18 = 0;
        goto L49
    L44:
        r17 = r22.getInitialDisplayDensity();
        goto L46
    L41:
        r15 = r22.mInitialDisplayHeight;
        goto L42
    L38:
        r14 = r22.mInitialDisplayWidth;
        goto L39
    L34:
        r11 = false;
        goto L35
    L28:
        if (r6.mForcedHeight == 0) goto L30;
        r8 = true;
        goto L31
    L24:
        r7 = false;
        goto L25
    L20:
        r5 = false;
        goto L22
    L16:
        r4 = 0;
        goto L17
    L12:
        r3 = 0;
        goto L13
    L8:
        r2 = 0;
        goto L9
    }

    void applyRotationSettingsToDisplayLocked(DisplayContent dc) {
        DisplayInfo displayInfo = dc.getDisplayInfo();
        SettingsProvider.SettingsEntry settings = this.mSettingsProvider.getSettings(displayInfo);
        if (settings.mIgnoreOrientationRequest == null) goto L6;
        dc.setIgnoreOrientationRequest(settings.mIgnoreOrientationRequest.booleanValue());
    L8:
        dc.getDisplayRotation().resetAllowAllRotations();
        return;
    L6:
        if (dc.mHasSetIgnoreOrientationRequest == false) goto L8;
        dc.setIgnoreOrientationRequest(false);
        goto L8
    }

    boolean updateSettingsForDisplay(DisplayContent dc) {
        TaskDisplayArea defaultTda = dc.getDefaultTaskDisplayArea();
        if (defaultTda != null) goto L5;
        return false;
    L5:
        if (defaultTda.getWindowingMode() == getWindowingModeLocked(dc)) goto L10;
        defaultTda.setWindowingMode(getWindowingModeLocked(dc));
        return true;
    L10:
        return false;
    }

    void onDisplayRemoved(DisplayContent dc) {
        this.mSettingsProvider.onDisplayRemoved(dc.getDisplayInfo());
    }

    public IExtDisplayWindowSettings getExt() {
        return this.mExt;
    }

    public SettingsProvider getSettingsProvider() {
        return this.mSettingsProvider;
    }

    public WindowManagerService getService() {
        return this.mService;
    }
}
