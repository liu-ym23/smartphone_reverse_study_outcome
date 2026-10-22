package com.android.server.wm;

import android.app.WindowConfiguration;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.LocaleList;
import android.util.proto.ProtoOutputStream;
import android.view.DisplayInfo;
import com.android.server.wm.ConfigurationContainer;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConfigurationContainer<E extends ConfigurationContainer> {
    static final int BOUNDS_CHANGE_NONE = 0;
    static final int BOUNDS_CHANGE_POSITION = 1;
    static final int BOUNDS_CHANGE_SIZE = 2;
    private ArrayList<ConfigurationContainerListener> mChangeListeners;
    protected Configuration mFullConfiguration;
    private boolean mHasOverrideConfiguration;
    private Configuration mMergedOverrideConfiguration;
    private Configuration mRequestedOverrideConfiguration;
    private final Configuration mRequestsTmpConfig;
    private Configuration mResolvedOverrideConfiguration;
    private final Configuration mResolvedTmpConfig;
    private Rect mReturnBounds;
    private ConfigurationContainerSysEx mSysEx;
    private final Rect mTmpRect;

    protected abstract E getChildAt(int r1);

    protected abstract int getChildCount();

    protected abstract ConfigurationContainer getParent();

    public ConfigurationContainer() {
        this.mReturnBounds = new Rect();
        this.mRequestedOverrideConfiguration = new Configuration();
        this.mResolvedOverrideConfiguration = new Configuration();
        this.mFullConfiguration = new Configuration();
        this.mMergedOverrideConfiguration = new Configuration();
        this.mChangeListeners = new ArrayList();
        this.mRequestsTmpConfig = new Configuration();
        this.mResolvedTmpConfig = new Configuration();
        this.mTmpRect = new Rect();
    }

    public Configuration getConfiguration() {
        return this.mFullConfiguration;
    }

    public void onConfigurationChanged(Configuration newParentConfig) {
        this.mResolvedTmpConfig.setTo(this.mResolvedOverrideConfiguration);
        resolveOverrideConfiguration(newParentConfig);
        this.mFullConfiguration.setTo(newParentConfig);
        this.mFullConfiguration.windowConfiguration.unsetAlwaysOnTop();
        this.mFullConfiguration.updateFrom(this.mResolvedOverrideConfiguration);
        onMergedOverrideConfigurationChanged();
        if (this.mResolvedTmpConfig.equals(this.mResolvedOverrideConfiguration) == true) goto L7;
        int i = this.mChangeListeners.size() - 1;
    L5:
        if (i < 0) goto L7;
        this.mChangeListeners.get(i).onRequestedOverrideConfigurationChanged(this.mResolvedOverrideConfiguration);
        i = i - 1;
    L7:
        int i2 = this.mChangeListeners.size() - 1;
    L8:
        if (i2 < 0) goto L10;
        this.mChangeListeners.get(i2).onMergedOverrideConfigurationChanged(this.mMergedOverrideConfiguration);
        i2 = i2 - 1;
        goto L8
    L10:
        int i3 = getChildCount();
        int i4 = i3 - 1;
    L11:
        if (i4 < 0) goto L14;
        dispatchConfigurationToChild(getChildAt(i4), this.mFullConfiguration);
        i4 = i4 - 1;
        goto L11
    }

    void dispatchConfigurationToChild(E child, Configuration config) {
        child.onConfigurationChanged(config);
    }

    void resolveOverrideConfiguration(Configuration newParentConfig) {
        this.mResolvedOverrideConfiguration.setTo(this.mRequestedOverrideConfiguration);
    }

    static void applySizeOverrideIfNeeded(DisplayContent displayContent, ApplicationInfo appInfo, Configuration newParentConfiguration, Configuration inOutConfig, boolean optsOutEdgeToEdge, boolean hasFixedRotationTransform, boolean hasCompatDisplayInsets, Task task) {
        if (displayContent != null) goto L6;
        return;
    L6:
        if (displayContent.mWmService.mFlags.mInsetsDecoupledConfiguration == true) goto L8;
        boolean r1 = appInfo.isChangeEnabled(327313645);
    L14:
        boolean useOverrideInsetsForConfig = r1;
        int parentWindowingMode = newParentConfiguration.windowConfiguration.getWindowingMode();
        if (WindowConfiguration.isFloating(parentWindowingMode) == true) goto L17;
    L21:
        boolean r2 = false;
    L22:
        boolean isFloating = r2;
        int rotation = newParentConfiguration.windowConfiguration.getRotation();
        if (rotation != (-1)) goto L26;
        if (hasFixedRotationTransform == true) goto L26;
        int rotation2 = displayContent.getRotation();
    L27:
        if (optsOutEdgeToEdge == true) goto L32;
        if (useOverrideInsetsForConfig == false) goto L31;
        if (hasCompatDisplayInsets == true) goto L120;
        if (rotation2 != (-1)) goto L32;
        return;
    L120:
        return;
    L31:
        return;
    L32:
        if (isFloating == false) goto L34;
        return;
    L34:
        if (hasFixedRotationTransform == false) goto L36;
        inOutConfig.windowConfiguration.setAppBounds(null);
        inOutConfig.screenWidthDp = 0;
        inOutConfig.screenHeightDp = 0;
        inOutConfig.smallestScreenWidthDp = 0;
        inOutConfig.orientation = 0;
    L36:
        if (rotation2 != 1) goto L38;
    L41:
        boolean rotated = true;
    L42:
        if (rotated == false) goto L44;
        int dw = displayContent.mBaseDisplayHeight;
    L46:
        if (rotated == false) goto L48;
        int dh = displayContent.mBaseDisplayWidth;
    L49:
        Rect outAppBounds = inOutConfig.windowConfiguration.getAppBounds();
        Rect outConfigBounds = new Rect(outAppBounds);
        if (outAppBounds != null) goto L52;
    L55:
        inOutConfig.windowConfiguration.setAppBounds(newParentConfiguration.windowConfiguration.getBounds());
        Rect outAppBounds2 = inOutConfig.windowConfiguration.getAppBounds();
        outConfigBounds.set(outAppBounds2);
        if (task == null) goto L64;
        Task task2 = task.getCreatedByOrganizerTask();
        if (task2 != null) goto L60;
    L65:
        DisplayPolicy.DecorInsets.Info decor = displayContent.getDisplayPolicy().getDecorInsetsInfo(rotation2, dw, dh);
        if (outAppBounds2.intersect(decor.mOverrideNonDecorFrame) == true) goto L71;
        if (inOutConfig.windowConfiguration.getWindowingMode() != 6) goto L71;
        outAppBounds2.inset(decor.mOverrideNonDecorInsets);
    L71:
        if (outConfigBounds.intersect(decor.mOverrideConfigFrame) == false) goto L73;
    L75:
        if (task2 == null) goto L82;
        if (task2.mOffsetYForInsets == 0) goto L79;
    L80:
        outAppBounds2.offset(-task2.mOffsetXForInsets, -task2.mOffsetYForInsets);
        outConfigBounds.offset(-task2.mOffsetXForInsets, -task2.mOffsetYForInsets);
        goto L82
    L79:
        if (task2.mOffsetXForInsets != 0) goto L80;
    L82:
        float density = inOutConfig.densityDpi;
        if (density != 0.0f) goto L85;
        density = newParentConfiguration.densityDpi;
    L85:
        float density2 = density * 0.00625f;
        if (inOutConfig.screenWidthDp != 0) goto L89;
        inOutConfig.screenWidthDp = (int) ((outConfigBounds.width() / density2) + 0.5f);
    L89:
        if (inOutConfig.screenHeightDp != 0) goto L91;
        inOutConfig.screenHeightDp = (int) ((outConfigBounds.height() / density2) + 0.5f);
    L91:
        DisplayInfo tempInfo = displayContent.getDisplayInfo();
        if (tempInfo != null) goto L94;
    L102:
        boolean isNeedForceComputeSizeRanges = false;
    L104:
        if (inOutConfig.smallestScreenWidthDp == 0) goto L109;
        if (isNeedForceComputeSizeRanges == true) goto L109;
        int r17 = 1;
    L113:
        if (inOutConfig.orientation == 0) goto L115;
        return;
    L115:
        if (inOutConfig.screenWidthDp > inOutConfig.screenHeightDp) goto L117;
        int r0 = r17;
    L118:
        inOutConfig.orientation = r0;
        return;
    L117:
        r0 = 2;
    L109:
        if (parentWindowingMode != 1) goto L111;
        DisplayInfo info = new DisplayInfo(displayContent.getDisplayInfo());
        r17 = 1;
        displayContent.computeSizeRanges(info, rotated, dw, dh, displayContent.getDisplayMetrics().density, inOutConfig, true);
        goto L113
    L111:
        r17 = 1;
        goto L113
    L94:
        if (ActivityStarterHook.CAR_DISPLAY_NAME2.equals(tempInfo.name) == false) goto L96;
    L97:
        int tempSmallestScreenWidthDp = Math.min(inOutConfig.screenWidthDp, inOutConfig.screenHeightDp);
        if (tempSmallestScreenWidthDp != inOutConfig.smallestScreenWidthDp) goto L100;
        isNeedForceComputeSizeRanges = false;
        goto L104
    L100:
        isNeedForceComputeSizeRanges = true;
        goto L104
    L96:
        if (ActivityStarterHook.CAR_DISPLAY_NAME.equals(tempInfo.name) == false) goto L102;
    L73:
        if (inOutConfig.windowConfiguration.getWindowingMode() != 6) goto L75;
        outConfigBounds.inset(decor.mOverrideConfigInsets);
        goto L75
    L60:
        if (task2.mOffsetYForInsets == 0) goto L62;
    L63:
        outAppBounds2.offset(task2.mOffsetXForInsets, task2.mOffsetYForInsets);
        outConfigBounds.offset(task2.mOffsetXForInsets, task2.mOffsetYForInsets);
        goto L65
    L62:
        if (task2.mOffsetXForInsets == 0) goto L65;
    L64:
        task2 = task;
        goto L65
    L52:
        if (outAppBounds.isEmpty() == false) goto L82;
    L48:
        dh = displayContent.mBaseDisplayHeight;
        goto L49
    L44:
        dw = displayContent.mBaseDisplayWidth;
        goto L46
    L38:
        if (rotation2 == 3) goto L41;
        rotated = false;
    L26:
        rotation2 = rotation;
        goto L27
    L17:
        if (inOutConfig.windowConfiguration.getWindowingMode() != 0) goto L19;
    L20:
        r2 = true;
        goto L22
    L19:
        if (WindowConfiguration.isFloating(inOutConfig.windowConfiguration.getWindowingMode()) == false) goto L21;
    L8:
        if (appInfo.isChangeEnabled(151861875) == false) goto L10;
    L12:
        r1 = false;
        goto L14
    L10:
        if (appInfo.isChangeEnabled(327313645) == true) goto L12;
        r1 = true;
        goto L14
    }

    boolean hasRequestedOverrideConfiguration() {
        return this.mHasOverrideConfiguration;
    }

    public Configuration getRequestedOverrideConfiguration() {
        return this.mRequestedOverrideConfiguration;
    }

    Configuration getResolvedOverrideConfiguration() {
        return this.mResolvedOverrideConfiguration;
    }

    public void onRequestedOverrideConfigurationChanged(Configuration overrideConfiguration) {
        updateRequestedOverrideConfiguration(overrideConfiguration);
        ConfigurationContainer parent = getParent();
        if (parent == null) goto L5;
        Configuration r1 = parent.getConfiguration();
    L6:
        onConfigurationChanged(r1);
        return;
    L5:
        r1 = Configuration.EMPTY;
        goto L6
    }

    void updateRequestedOverrideConfiguration(Configuration overrideConfiguration) {
        this.mHasOverrideConfiguration = !Configuration.EMPTY.equals(overrideConfiguration);
        this.mRequestedOverrideConfiguration.setTo(overrideConfiguration);
        Rect newBounds = this.mRequestedOverrideConfiguration.windowConfiguration.getBounds();
        if (this.mHasOverrideConfiguration == true) goto L5;
        return;
    L5:
        if (providesMaxBounds() == true) goto L7;
        return;
    L7:
        if (diffRequestedOverrideMaxBounds(newBounds) == 0) goto L12;
        this.mRequestedOverrideConfiguration.windowConfiguration.setMaxBounds(newBounds);
        return;
    }

    public Configuration getMergedOverrideConfiguration() {
        return this.mMergedOverrideConfiguration;
    }

    void onMergedOverrideConfigurationChanged() {
        ConfigurationContainer parent = getParent();
        if (parent == null) goto L5;
        this.mMergedOverrideConfiguration.setTo(parent.getMergedOverrideConfiguration());
        this.mMergedOverrideConfiguration.windowConfiguration.unsetAlwaysOnTop();
        this.mMergedOverrideConfiguration.updateFrom(this.mResolvedOverrideConfiguration);
        return;
    L5:
        this.mMergedOverrideConfiguration.setTo(this.mResolvedOverrideConfiguration);
    }

    public boolean matchParentBounds() {
        return getResolvedOverrideBounds().isEmpty();
    }

    public boolean equivalentRequestedOverrideBounds(Rect bounds) {
        return equivalentBounds(getRequestedOverrideBounds(), bounds);
    }

    public boolean equivalentRequestedOverrideMaxBounds(Rect bounds) {
        return equivalentBounds(getRequestedOverrideMaxBounds(), bounds);
    }

    public static boolean equivalentBounds(Rect bounds, Rect other) {
        if (bounds == other) goto L15;
        if (bounds != null) goto L5;
    L9:
        if (other != null) goto L11;
    L14:
        return false;
    L11:
        if (other.isEmpty() == false) goto L14;
        if (bounds != null) goto L14;
    L5:
        if (bounds.equals(other) == true) goto L15;
        if (bounds.isEmpty() == false) goto L9;
        if (other != null) goto L9;
    L15:
        return true;
    }

    public Rect getBounds() {
        this.mReturnBounds.set(getConfiguration().windowConfiguration.getBounds());
        return this.mReturnBounds;
    }

    public void getBounds(Rect outBounds) {
        outBounds.set(getBounds());
    }

    public Rect getMaxBounds() {
        this.mReturnBounds.set(getConfiguration().windowConfiguration.getMaxBounds());
        return this.mReturnBounds;
    }

    public void getPosition(Point out) {
        Rect bounds = getBounds();
        out.set(bounds.left, bounds.top);
    }

    Rect getResolvedOverrideBounds() {
        this.mReturnBounds.set(getResolvedOverrideConfiguration().windowConfiguration.getBounds());
        return this.mReturnBounds;
    }

    public Rect getRequestedOverrideBounds() {
        this.mReturnBounds.set(getRequestedOverrideConfiguration().windowConfiguration.getBounds());
        return this.mReturnBounds;
    }

    public Rect getRequestedOverrideMaxBounds() {
        this.mReturnBounds.set(getRequestedOverrideConfiguration().windowConfiguration.getMaxBounds());
        return this.mReturnBounds;
    }

    public boolean hasOverrideBounds() {
        return !getRequestedOverrideBounds().isEmpty();
    }

    public void getRequestedOverrideBounds(Rect outBounds) {
        outBounds.set(getRequestedOverrideBounds());
    }

    public int setBounds(Rect bounds) {
        int boundsChange = diffRequestedOverrideBounds(bounds);
        if (providesMaxBounds() == true) goto L5;
    L7:
        boolean overrideMaxBounds = false;
    L9:
        if (boundsChange != 0) goto L12;
        if (overrideMaxBounds == true) goto L12;
        return boundsChange;
    L12:
        this.mRequestsTmpConfig.setTo(getRequestedOverrideConfiguration());
        this.mRequestsTmpConfig.windowConfiguration.setBounds(bounds);
        onRequestedOverrideConfigurationChanged(this.mRequestsTmpConfig);
        return boundsChange;
    L5:
        if (diffRequestedOverrideMaxBounds(bounds) == 0) goto L7;
        overrideMaxBounds = true;
        goto L9
    }

    public int setBounds(int left, int top, int right, int bottom) {
        this.mTmpRect.set(left, top, right, bottom);
        return setBounds(this.mTmpRect);
    }

    protected boolean providesMaxBounds() {
        return false;
    }

    int diffRequestedOverrideMaxBounds(Rect bounds) {
        if (equivalentRequestedOverrideMaxBounds(bounds) == false) goto L6;
        return 0;
    L6:
        int boundsChange = 0;
        Rect existingBounds = getRequestedOverrideMaxBounds();
        if (bounds != null) goto L9;
    L12:
        boundsChange = 0 | 1;
    L13:
        if (bounds == null) goto L19;
        if (existingBounds.width() != bounds.width()) goto L19;
        if (existingBounds.height() != bounds.height()) goto L19;
        return boundsChange;
    L19:
        return boundsChange | 2;
    L9:
        if (existingBounds.left != bounds.left) goto L12;
        if (existingBounds.top == bounds.top) goto L13;
        goto L12
    }

    int diffRequestedOverrideBounds(Rect bounds) {
        if (equivalentRequestedOverrideBounds(bounds) == false) goto L6;
        return 0;
    L6:
        int boundsChange = 0;
        Rect existingBounds = getRequestedOverrideBounds();
        if (bounds != null) goto L9;
    L12:
        boundsChange = 0 | 1;
    L13:
        if (bounds == null) goto L19;
        if (existingBounds.width() != bounds.width()) goto L19;
        if (existingBounds.height() != bounds.height()) goto L19;
        return boundsChange;
    L19:
        return boundsChange | 2;
    L9:
        if (existingBounds.left != bounds.left) goto L12;
        if (existingBounds.top == bounds.top) goto L13;
        goto L12
    }

    public WindowConfiguration getWindowConfiguration() {
        return this.mFullConfiguration.windowConfiguration;
    }

    public int getWindowingMode() {
        return this.mFullConfiguration.windowConfiguration.getWindowingMode();
    }

    public int getRequestedOverrideWindowingMode() {
        return this.mRequestedOverrideConfiguration.windowConfiguration.getWindowingMode();
    }

    public void setWindowingMode(int windowingMode) {
        this.mRequestsTmpConfig.setTo(getRequestedOverrideConfiguration());
        this.mRequestsTmpConfig.windowConfiguration.setWindowingMode(windowingMode);
        onRequestedOverrideConfigurationChanged(this.mRequestsTmpConfig);
    }

    public void setAlwaysOnTop(boolean alwaysOnTop) {
        this.mRequestsTmpConfig.setTo(getRequestedOverrideConfiguration());
        this.mRequestsTmpConfig.windowConfiguration.setAlwaysOnTop(alwaysOnTop);
        onRequestedOverrideConfigurationChanged(this.mRequestsTmpConfig);
    }

    public boolean inMultiWindowMode() {
        int windowingMode = this.mFullConfiguration.windowConfiguration.getWindowingMode();
        return WindowConfiguration.inMultiWindowMode(windowingMode);
    }

    public boolean inPinnedWindowingMode() {
        if (this.mFullConfiguration.windowConfiguration.getWindowingMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean inFreeformWindowingMode() {
        if (this.mFullConfiguration.windowConfiguration.getWindowingMode() != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public int getActivityType() {
        return this.mFullConfiguration.windowConfiguration.getActivityType();
    }

    public void setActivityType(int activityType) {
        int currentActivityType = getActivityType();
        if (currentActivityType != activityType) goto L5;
        return;
    L5:
        if (currentActivityType != 0) goto L9;
        this.mRequestsTmpConfig.setTo(getRequestedOverrideConfiguration());
        this.mRequestsTmpConfig.windowConfiguration.setActivityType(activityType);
        onRequestedOverrideConfigurationChanged(this.mRequestsTmpConfig);
        return;
    L9:
        throw new IllegalStateException("Can't change activity type once set: " + this + " activityType=" + WindowConfiguration.activityTypeToString(activityType));
    }

    public boolean isActivityTypeHome() {
        if (getActivityType() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isActivityTypeRecents() {
        if (getActivityType() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    final boolean isActivityTypeHomeOrRecents() {
        int activityType = getActivityType();
        if (activityType != 2) goto L5;
    L8:
        return true;
    L5:
        if (activityType == 3) goto L8;
        return false;
    }

    public boolean isActivityTypeAssistant() {
        if (getActivityType() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean applyAppSpecificConfig(Integer nightMode, LocaleList locales, Integer gender) {
        this.mRequestsTmpConfig.setTo(getRequestedOverrideConfiguration());
        if (nightMode != null) goto L5;
    L7:
        boolean newNightModeSet = false;
    L8:
        if (locales != null) goto L10;
    L12:
        boolean newLocalesSet = false;
    L13:
        Configuration r4 = this.mRequestsTmpConfig;
        if (gender != null) goto L16;
        int r5 = 0;
    L17:
        boolean newGenderSet = setOverrideGender(r4, r5);
        if (newNightModeSet == true) goto L21;
        if (newLocalesSet == true) goto L21;
        if (newGenderSet == true) goto L21;
    L22:
        if (newNightModeSet == true) goto L28;
        if (newLocalesSet == true) goto L29;
        if (newGenderSet == false) goto L27;
        return true;
    L27:
        return false;
    L29:
        return true;
    L28:
        return true;
    L21:
        onRequestedOverrideConfigurationChanged(this.mRequestsTmpConfig);
        goto L22
    L16:
        r5 = gender.intValue();
        goto L17
    L10:
        if (setOverrideLocales(this.mRequestsTmpConfig, locales) == false) goto L12;
        newLocalesSet = true;
        goto L13
    L5:
        if (setOverrideNightMode(this.mRequestsTmpConfig, nightMode.intValue()) == false) goto L7;
        newNightModeSet = true;
        goto L8
    }

    private boolean setOverrideNightMode(Configuration requestsTmpConfig, int nightMode) {
        int currentUiMode = this.mRequestedOverrideConfiguration.uiMode;
        int currentNightMode = currentUiMode & 48;
        int validNightMode = nightMode & 48;
        if (currentNightMode != validNightMode) goto L6;
        return false;
    L6:
        requestsTmpConfig.uiMode = (currentUiMode & (-49)) | validNightMode;
        return true;
    }

    private boolean setOverrideLocales(Configuration requestsTmpConfig, LocaleList overrideLocales) {
        if (this.mRequestedOverrideConfiguration.getLocales().equals(overrideLocales) == false) goto L6;
        return false;
    L6:
        requestsTmpConfig.setLocales(overrideLocales);
        requestsTmpConfig.userSetLocale = true;
        return true;
    }

    protected boolean setOverrideGender(Configuration requestsTmpConfig, int gender) {
        return false;
    }

    public boolean isActivityTypeDream() {
        if (getActivityType() != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isActivityTypeStandard() {
        if (getActivityType() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isActivityTypeStandardOrUndefined() {
        int activityType = getActivityType();
        if (activityType == 1) goto L8;
        if (activityType == 0) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public static boolean isCompatibleActivityType(int currentType, int otherType) {
        if (currentType != otherType) goto L6;
        return true;
    L6:
        if (currentType != 4) goto L8;
        return false;
    L8:
        if (currentType == 0) goto L13;
        if (otherType != 0) goto L12;
        return true;
    L12:
        return false;
    L13:
        return true;
    }

    public boolean isCompatible(int windowingMode, int activityType) {
        int thisActivityType = getActivityType();
        int thisWindowingMode = getWindowingMode();
        boolean sameWindowingMode = false;
        if (thisActivityType != activityType) goto L5;
        boolean sameActivityType = true;
    L6:
        if (thisWindowingMode != windowingMode) goto L8;
        sameWindowingMode = true;
    L8:
        if (sameActivityType == false) goto L11;
        if (sameWindowingMode == false) goto L11;
        return true;
    L11:
        if (activityType == 0) goto L14;
        if (activityType == 1) goto L14;
    L15:
        return sameActivityType;
    L14:
        if (isActivityTypeStandardOrUndefined() == false) goto L15;
        return sameWindowingMode;
    L5:
        sameActivityType = false;
        goto L6
    }

    void registerConfigurationChangeListener(ConfigurationContainerListener listener) {
        registerConfigurationChangeListener(listener, true);
    }

    void registerConfigurationChangeListener(ConfigurationContainerListener listener, boolean shouldDispatchConfig) {
        if (this.mChangeListeners.contains(listener) == false) goto L5;
        return;
    L5:
        this.mChangeListeners.add(listener);
        if (shouldDispatchConfig == false) goto L9;
        listener.onRequestedOverrideConfigurationChanged(this.mResolvedOverrideConfiguration);
        listener.onMergedOverrideConfigurationChanged(this.mMergedOverrideConfiguration);
        return;
    }

    void unregisterConfigurationChangeListener(ConfigurationContainerListener listener) {
        this.mChangeListeners.remove(listener);
    }

    boolean containsListener(ConfigurationContainerListener listener) {
        return this.mChangeListeners.contains(listener);
    }

    void onParentChanged(ConfigurationContainer newParent, ConfigurationContainer oldParent) {
        if (newParent == null) goto L5;
        onConfigurationChanged(newParent.mFullConfiguration);
        return;
    }

    protected void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        long token = proto.start(fieldId);
        if (logLevel != 0) goto L5;
    L6:
        Configuration r4 = this.mRequestedOverrideConfiguration;
        if (logLevel != 2) goto L9;
        boolean r5 = true;
    L10:
        r4.dumpDebug(proto, 1146756268033L, r5);
    L11:
        if (logLevel != 0) goto L13;
        this.mFullConfiguration.dumpDebug(proto, 1146756268034L, false);
        this.mMergedOverrideConfiguration.dumpDebug(proto, 1146756268035L, false);
    L13:
        if (logLevel != 1) goto L15;
        dumpDebugWindowingMode(proto);
    L15:
        proto.end(token);
        return;
    L9:
        r5 = false;
        goto L10
    L5:
        if (this.mHasOverrideConfiguration == false) goto L11;
        goto L6
    }

    private void dumpDebugWindowingMode(ProtoOutputStream proto) {
        long fullConfigToken = proto.start(1146756268034L);
        long windowConfigToken = proto.start(1146756268051L);
        int windowingMode = this.mFullConfiguration.windowConfiguration.getWindowingMode();
        proto.write(1120986464258L, windowingMode);
        proto.end(windowConfigToken);
        proto.end(fullConfigToken);
    }

    public void dumpChildrenNames(PrintWriter pw, String prefix) {
        dumpChildrenNames(pw, prefix, true);
    }

    public void dumpChildrenNames(PrintWriter pw, String prefix, boolean isLastChild) {
        int curWinMode = getWindowingMode();
        String winMode = WindowConfiguration.windowingModeToString(curWinMode);
        if (curWinMode == 0) goto L6;
        if (curWinMode == 1) goto L6;
        winMode = winMode.toUpperCase();
    L6:
        int requestedWinMode = getRequestedOverrideWindowingMode();
        String overrideWinMode = WindowConfiguration.windowingModeToString(requestedWinMode);
        if (requestedWinMode == 0) goto L10;
        if (requestedWinMode == 1) goto L10;
        overrideWinMode = overrideWinMode.toUpperCase();
    L10:
        String actType = WindowConfiguration.activityTypeToString(getActivityType());
        if (getActivityType() != 0) goto L13;
    L15:
        StringBuilder r6 = new StringBuilder();
        r6.append(prefix);
        if (isLastChild == false) goto L18;
        String r7 = "└─ ";
    L19:
        r6.append(r7);
        pw.print(r6.toString());
        pw.println(getName() + " type=" + actType + " mode=" + winMode + " override-mode=" + overrideWinMode + " requested-bounds=" + getRequestedOverrideBounds().toShortString() + " bounds=" + getBounds().toShortString());
        StringBuilder r8 = new StringBuilder();
        r8.append(prefix);
        if (isLastChild == false) goto L22;
        String r9 = "   ";
    L23:
        r8.append(r9);
        String childPrefix = r8.toString();
        int i = getChildCount() - 1;
    L24:
        if (i < 0) goto L31;
        ConfigurationContainer r10 = getChildAt(i);
        if (i != 0) goto L28;
        boolean r11 = true;
    L29:
        r10.dumpChildrenNames(pw, childPrefix, r11);
        i = i - 1;
        goto L24
    L28:
        r11 = false;
        goto L29
    L31:
        return;
    L22:
        r9 = "│  ";
        goto L23
    L18:
        r7 = "├─ ";
        goto L19
    L13:
        if (getActivityType() == 1) goto L15;
        actType = actType.toUpperCase();
        goto L15
    }

    String getName() {
        return toString();
    }

    public boolean isAlwaysOnTop() {
        return this.mFullConfiguration.windowConfiguration.isAlwaysOnTop();
    }

    boolean hasChild() {
        if (getChildCount() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ConfigurationContainerSysEx getSmtEx() {
        if (this.mSysEx != null) goto L6;
        this.mSysEx = ConfigurationContainerSysExFactory.createSmtEx(this);
    L6:
        return this.mSysEx;
    }
}
