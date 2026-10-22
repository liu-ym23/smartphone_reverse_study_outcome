package com.android.server.accessibility;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.AccessibilityShortcutInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.RemoteCallbackList;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.accessibility.IAccessibilityManagerClient;
import com.android.internal.accessibility.AccessibilityShortcutController;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.android.internal.accessibility.util.ShortcutUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
class AccessibilityUserState {
    private static final String LOG_TAG = null;
    private final Map<ComponentName, ComponentName> mA11yActivityToTileService;
    private final Map<ComponentName, ComponentName> mA11yServiceToTileService;
    private final ArraySet<ComponentName> mA11yTilesInQsPanel;
    private boolean mAccessibilityFocusOnlyInActiveWindow;
    private boolean mAlwaysOnMagnificationEnabled;
    private boolean mBindInstantServiceAllowed;
    final Set<ComponentName> mBindingServices;
    final ArrayList<AccessibilityServiceConnection> mBoundServices;
    final Map<ComponentName, AccessibilityServiceConnection> mComponentNameToServiceMap;
    private Context mContext;
    final Set<ComponentName> mCrashedServices;
    final Set<ComponentName> mEnabledServices;
    private int mFocusColor;
    private final int mFocusColorDefaultValue;
    private int mFocusStrokeWidth;
    private final int mFocusStrokeWidthDefaultValue;
    final List<AccessibilityServiceInfo> mInstalledServices;
    final List<AccessibilityShortcutInfo> mInstalledShortcuts;
    private int mInteractiveUiTimeout;
    private boolean mIsAudioDescriptionByDefaultRequested;
    private boolean mIsAutoclickEnabled;
    private boolean mIsFilterKeyEventsEnabled;
    private boolean mIsMagnificationSingleFingerTripleTapEnabled;
    private boolean mIsPerformGesturesEnabled;
    private boolean mIsTextHighContrastEnabled;
    private boolean mIsTouchExplorationEnabled;
    private int mLastSentClientState;
    private int mMagnificationCapabilities;
    private boolean mMagnificationFollowTypingEnabled;
    private final SparseIntArray mMagnificationModes;
    private boolean mMagnificationTwoFingerTripleTapEnabled;
    private boolean mMouseKeysEnabled;
    private int mNonInteractiveUiTimeout;
    private boolean mRequestMultiFingerGestures;
    private boolean mRequestTwoFingerPassthrough;
    private boolean mSendMotionEventsEnabled;
    private ComponentName mServiceChangingSoftKeyboardMode;
    private SparseArray<Boolean> mServiceDetectsGestures;
    private boolean mServiceHandlesDoubleTap;
    private final ServiceInfoChangeListener mServiceInfoChangeListener;
    private final HashMap<Integer, ArraySet<String>> mShortcutTargets;
    private int mSoftKeyboardShowMode;
    private final boolean mSupportWindowMagnification;
    private String mTargetAssignedToAccessibilityButton;
    final Set<ComponentName> mTouchExplorationGrantedServices;
    final RemoteCallbackList<IAccessibilityManagerClient> mUserClients;
    final int mUserId;
    private int mUserInteractiveUiTimeout;
    private int mUserNonInteractiveUiTimeout;

    interface ServiceInfoChangeListener {
        void onServiceInfoChangedLocked(AccessibilityUserState r1);
    }

    public static /* synthetic */ void $r8$lambda$A9u88Wcnw6nxJFvcxVxU6ch1jmQ(AccessibilityUserState r0, Set r1, AccessibilityServiceInfo r2) {
        r0.lambda$updateTileServiceMapForAccessibilityServiceLocked$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Vr1J1yQFDhNN4Rwg21CufNgA7Gc(AccessibilityUserState r0, Set r1, AccessibilityShortcutInfo r2) {
        r0.lambda$updateTileServiceMapForAccessibilityActivityLocked$3(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$d3KxOS0O-qTw7v340hoftFR1OSY, reason: not valid java name */
    public static /* synthetic */ void m636$r8$lambda$d3KxOS0OqTw7v340hoftFR1OSY(Integer r0, ArraySet r1) {
        lambda$onSwitchToAnotherUserLocked$0(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$q4zgwJm8KhzSrw2Rp60awkSnRZk(ComponentName r0, String r1) {
        return lambda$removeShortcutTargetLocked$1(r0, r1);
    }

    static {
        LOG_TAG = AccessibilityUserState.class.getSimpleName();
    }

    boolean isValidMagnificationModeLocked(int displayId) {
        int mode = getMagnificationModeLocked(displayId);
        if (this.mSupportWindowMagnification == true) goto L8;
        if (mode != 2) goto L8;
        return false;
    L8:
        if ((this.mMagnificationCapabilities & mode) == 0) goto L11;
        return true;
    L11:
        return false;
    }

    AccessibilityUserState(int userId, Context context, ServiceInfoChangeListener serviceInfoChangeListener) {
        this.mUserClients = new RemoteCallbackList();
        this.mBoundServices = new ArrayList();
        this.mComponentNameToServiceMap = new HashMap();
        this.mInstalledServices = new ArrayList();
        this.mInstalledShortcuts = new ArrayList();
        this.mBindingServices = new HashSet();
        this.mCrashedServices = new HashSet();
        this.mEnabledServices = new HashSet();
        this.mTouchExplorationGrantedServices = new HashSet();
        this.mShortcutTargets = new HashMap();
        this.mA11yTilesInQsPanel = new ArraySet();
        boolean r1 = false;
        this.mServiceDetectsGestures = new SparseArray(0);
        this.mNonInteractiveUiTimeout = 0;
        this.mInteractiveUiTimeout = 0;
        this.mLastSentClientState = -1;
        this.mMagnificationModes = new SparseIntArray();
        this.mMagnificationCapabilities = 1;
        this.mMagnificationFollowTypingEnabled = true;
        this.mAlwaysOnMagnificationEnabled = false;
        this.mMouseKeysEnabled = false;
        this.mA11yServiceToTileService = new ArrayMap();
        this.mA11yActivityToTileService = new ArrayMap();
        this.mSoftKeyboardShowMode = 0;
        this.mUserId = userId;
        this.mContext = context;
        this.mServiceInfoChangeListener = serviceInfoChangeListener;
        this.mFocusStrokeWidthDefaultValue = this.mContext.getResources().getDimensionPixelSize(R.dimen.accessibility_focus_highlight_stroke_width);
        this.mFocusColorDefaultValue = this.mContext.getResources().getColor(R.color.accessibility_magnification_thumbnail_background_color);
        this.mFocusStrokeWidth = this.mFocusStrokeWidthDefaultValue;
        this.mFocusColor = this.mFocusColorDefaultValue;
        if (this.mContext.getResources().getBoolean(R.bool.config_mobile_data_capable) == true) goto L5;
    L8:
        this.mSupportWindowMagnification = r1;
        this.mShortcutTargets.put(2, new ArraySet());
        this.mShortcutTargets.put(1, new ArraySet());
        this.mShortcutTargets.put(32, new ArraySet());
        this.mShortcutTargets.put(16, new ArraySet());
        this.mShortcutTargets.put(64, new ArraySet());
        return;
    L5:
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.window_magnification") == false) goto L8;
        r1 = true;
        goto L8
    }

    boolean isHandlingAccessibilityEventsLocked() {
        if (this.mBoundServices.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (this.mBindingServices.isEmpty() == false) goto L8;
        return false;
    }

    void onSwitchToAnotherUserLocked() {
        unbindAllServicesLocked();
        this.mBoundServices.clear();
        this.mBindingServices.clear();
        this.mCrashedServices.clear();
        this.mLastSentClientState = -1;
        this.mNonInteractiveUiTimeout = 0;
        this.mInteractiveUiTimeout = 0;
        this.mEnabledServices.clear();
        this.mTouchExplorationGrantedServices.clear();
        this.mShortcutTargets.forEach(new AccessibilityUserState$$ExternalSyntheticLambda3());
        this.mA11yTilesInQsPanel.clear();
        this.mTargetAssignedToAccessibilityButton = null;
        this.mIsTouchExplorationEnabled = false;
        this.mServiceHandlesDoubleTap = false;
        this.mRequestMultiFingerGestures = false;
        this.mRequestTwoFingerPassthrough = false;
        this.mSendMotionEventsEnabled = false;
        this.mIsMagnificationSingleFingerTripleTapEnabled = false;
        this.mMagnificationTwoFingerTripleTapEnabled = false;
        this.mIsAutoclickEnabled = false;
        this.mUserNonInteractiveUiTimeout = 0;
        this.mUserInteractiveUiTimeout = 0;
        this.mMagnificationModes.clear();
        this.mFocusStrokeWidth = this.mFocusStrokeWidthDefaultValue;
        this.mFocusColor = this.mFocusColorDefaultValue;
        this.mMagnificationFollowTypingEnabled = true;
        this.mAlwaysOnMagnificationEnabled = false;
    }

    private static /* synthetic */ void lambda$onSwitchToAnotherUserLocked$0(Integer type, ArraySet targets) {
        targets.clear();
    }

    void addServiceLocked(AccessibilityServiceConnection serviceConnection) {
        if (this.mBoundServices.contains(serviceConnection) == true) goto L6;
        this.mBoundServices.add(serviceConnection);
        this.mComponentNameToServiceMap.put(serviceConnection.getComponentName(), serviceConnection);
        this.mServiceInfoChangeListener.onServiceInfoChangedLocked(this);
        return;
    }

    void removeServiceLocked(AccessibilityServiceConnection serviceConnection) {
        this.mBoundServices.remove(serviceConnection);
        serviceConnection.onRemoved();
        if (this.mServiceChangingSoftKeyboardMode != null) goto L5;
    L7:
        this.mComponentNameToServiceMap.clear();
        int i = 0;
    L9:
        if (i >= this.mBoundServices.size()) goto L11;
        AccessibilityServiceConnection boundClient = this.mBoundServices.get(i);
        this.mComponentNameToServiceMap.put(boundClient.getComponentName(), boundClient);
        i = i + 1;
        goto L9
    L11:
        this.mServiceInfoChangeListener.onServiceInfoChangedLocked(this);
        return;
    L5:
        if (this.mServiceChangingSoftKeyboardMode.equals(serviceConnection.getServiceInfo().getComponentName()) == false) goto L7;
        setSoftKeyboardModeLocked(0, null);
        goto L7
    }

    void serviceDisconnectedLocked(AccessibilityServiceConnection serviceConnection) {
        removeServiceLocked(serviceConnection);
        this.mCrashedServices.add(serviceConnection.getComponentName());
    }

    boolean setSoftKeyboardModeLocked(int r6, ComponentName r7) {
        boolean r0 = false;
        if (r6 == 0) goto L9;
        if (r6 == 1) goto L9;
        if (r6 == 2) goto L9;
        Slog.w(LOG_TAG, "Invalid soft keyboard mode");
        return false;
    L9:
        if (this.mSoftKeyboardShowMode != r6) goto L12;
        return true;
    L12:
        if (r6 != 2) goto L24;
        if (hasUserOverriddenHardKeyboardSetting() == false) goto L17;
        return false;
    L17:
        if (getSoftKeyboardValueFromSettings() != 2) goto L19;
    L22:
        putSecureIntForUser("show_ime_with_hard_keyboard", 1, this.mUserId);
    L26:
        saveSoftKeyboardValueToSettings(r6);
        this.mSoftKeyboardShowMode = r6;
        this.mServiceChangingSoftKeyboardMode = r7;
        int r1 = this.mBoundServices.size() - 1;
    L27:
        if (r1 < 0) goto L30;
        this.mBoundServices.get(r1).notifySoftKeyboardShowModeChangedLocked(this.mSoftKeyboardShowMode);
        r1 = r1 - 1;
        goto L27
    L30:
        return true;
    L19:
        if (getSecureIntForUser("show_ime_with_hard_keyboard", 0, this.mUserId) == 0) goto L21;
        r0 = true;
    L21:
        setOriginalHardKeyboardValue(r0);
        goto L22
    L24:
        if (this.mSoftKeyboardShowMode != 2) goto L26;
        boolean r2 = getOriginalHardKeyboardValue();
        putSecureIntForUser("show_ime_with_hard_keyboard", r2 ? 1 : 0, this.mUserId);
        goto L26
    }

    int getSoftKeyboardShowModeLocked() {
        return this.mSoftKeyboardShowMode;
    }

    void reconcileSoftKeyboardModeWithSettingsLocked() {
        if (getSecureIntForUser("show_ime_with_hard_keyboard", 0, this.mUserId) == 0) goto L5;
        boolean showWithHardKeyboardSettings = true;
    L7:
        if (this.mSoftKeyboardShowMode != 2) goto L11;
        if (showWithHardKeyboardSettings == true) goto L11;
        setSoftKeyboardModeLocked(0, null);
        setUserOverridesHardKeyboardSetting();
    L11:
        if (getSoftKeyboardValueFromSettings() == this.mSoftKeyboardShowMode) goto L14;
        Slog.e(LOG_TAG, "Show IME setting inconsistent with internal state. Overwriting");
        setSoftKeyboardModeLocked(0, null);
        putSecureIntForUser("accessibility_soft_keyboard_mode", 0, this.mUserId);
        return;
    L14:
        return;
    L5:
        showWithHardKeyboardSettings = false;
        goto L7
    }

    boolean getBindInstantServiceAllowedLocked() {
        return this.mBindInstantServiceAllowed;
    }

    void setBindInstantServiceAllowedLocked(boolean allowed) {
        this.mBindInstantServiceAllowed = allowed;
    }

    Set<ComponentName> getBindingServicesLocked() {
        return this.mBindingServices;
    }

    Set<ComponentName> getCrashedServicesLocked() {
        return this.mCrashedServices;
    }

    Set<ComponentName> getEnabledServicesLocked() {
        return this.mEnabledServices;
    }

    void removeDisabledServicesFromTemporaryStatesLocked() {
        int i = 0;
        int count = this.mInstalledServices.size();
    L3:
        if (i >= count) goto L9;
        AccessibilityServiceInfo installedService = this.mInstalledServices.get(i);
        ComponentName componentName = ComponentName.unflattenFromString(installedService.getId());
        if (this.mEnabledServices.contains(componentName) == true) goto L7;
        this.mCrashedServices.remove(componentName);
        this.mBindingServices.remove(componentName);
    L7:
        i = i + 1;
        goto L3
    }

    List<AccessibilityServiceConnection> getBoundServicesLocked() {
        return this.mBoundServices;
    }

    int getClientStateLocked(boolean uiAutomationCanIntrospect, int traceClientState) {
        int clientState = 0;
        if (uiAutomationCanIntrospect == false) goto L5;
    L8:
        boolean a11yEnabled = true;
    L10:
        if (a11yEnabled == false) goto L12;
        clientState = 0 | 1;
    L12:
        if (a11yEnabled == false) goto L17;
        if (this.mIsTouchExplorationEnabled == false) goto L17;
        clientState = ((clientState | 2) | 8) | 16;
    L17:
        if (this.mIsTextHighContrastEnabled == false) goto L20;
        clientState = clientState | 4;
    L20:
        if (this.mIsAudioDescriptionByDefaultRequested == false) goto L23;
        clientState = clientState | 4096;
    L23:
        return clientState | traceClientState;
    L5:
        if (isHandlingAccessibilityEventsLocked() == true) goto L8;
        a11yEnabled = false;
        goto L10
    }

    private void setUserOverridesHardKeyboardSetting() {
        int softKeyboardSetting = getSecureIntForUser("accessibility_soft_keyboard_mode", 0, this.mUserId);
        putSecureIntForUser("accessibility_soft_keyboard_mode", 1073741824 | softKeyboardSetting, this.mUserId);
    }

    private boolean hasUserOverriddenHardKeyboardSetting() {
        int softKeyboardSetting = getSecureIntForUser("accessibility_soft_keyboard_mode", 0, this.mUserId);
        if ((1073741824 & softKeyboardSetting) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setOriginalHardKeyboardValue(boolean originalHardKeyboardValue) {
        int r2 = 0;
        int oldSoftKeyboardSetting = getSecureIntForUser("accessibility_soft_keyboard_mode", 0, this.mUserId);
        int r3 = (-536870913) & oldSoftKeyboardSetting;
        if (originalHardKeyboardValue == false) goto L5;
        r2 = 536870912;
    L5:
        int newSoftKeyboardSetting = r2 | r3;
        putSecureIntForUser("accessibility_soft_keyboard_mode", newSoftKeyboardSetting, this.mUserId);
    }

    private void saveSoftKeyboardValueToSettings(int softKeyboardShowMode) {
        int oldSoftKeyboardSetting = getSecureIntForUser("accessibility_soft_keyboard_mode", 0, this.mUserId);
        int newSoftKeyboardSetting = (oldSoftKeyboardSetting & (-4)) | softKeyboardShowMode;
        putSecureIntForUser("accessibility_soft_keyboard_mode", newSoftKeyboardSetting, this.mUserId);
    }

    private int getSoftKeyboardValueFromSettings() {
        return getSecureIntForUser("accessibility_soft_keyboard_mode", 0, this.mUserId) & 3;
    }

    private boolean getOriginalHardKeyboardValue() {
        if ((getSecureIntForUser("accessibility_soft_keyboard_mode", 0, this.mUserId) & 536870912) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void unbindAllServicesLocked() {
        List<AccessibilityServiceConnection> services = this.mBoundServices;
        int count = services.size();
    L3:
        if (count <= 0) goto L6;
        services.get(0).unbindLocked();
        count = count - 1;
        goto L3
    }

    private int getSecureIntForUser(String key, int def, int userId) {
        return Settings.Secure.getIntForUser(this.mContext.getContentResolver(), key, def, userId);
    }

    private void putSecureIntForUser(String key, int value, int userId) {
        long identity = Binder.clearCallingIdentity();
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), key, value, userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void dumpShortcutTargets(PrintWriter pw, int shortcutType, String name) {
        pw.append("     ").append(name).append(":{");
        ArraySet<String> targets = getShortcutTargetsLocked(shortcutType);
        int size = targets.size();
        int i = 0;
    L3:
        if (i >= size) goto L7;
        if (i <= 0) goto L6;
        pw.append(", ");
    L6:
        pw.append(targets.valueAt(i));
        i = i + 1;
        goto L3
    L7:
        pw.println("}");
    }

    void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        pw.append("User state[");
        pw.println();
        pw.append("     attributes:{id=").append(String.valueOf(this.mUserId));
        pw.append(", touchExplorationEnabled=").append(String.valueOf(this.mIsTouchExplorationEnabled));
        pw.append(", serviceHandlesDoubleTap=").append(String.valueOf(this.mServiceHandlesDoubleTap));
        pw.append(", requestMultiFingerGestures=").append(String.valueOf(this.mRequestMultiFingerGestures));
        pw.append(", requestTwoFingerPassthrough=").append(String.valueOf(this.mRequestTwoFingerPassthrough));
        pw.append(", sendMotionEventsEnabled").append(String.valueOf(this.mSendMotionEventsEnabled));
        pw.append(", displayMagnificationEnabled=").append(String.valueOf(this.mIsMagnificationSingleFingerTripleTapEnabled));
        pw.append(", autoclickEnabled=").append(String.valueOf(this.mIsAutoclickEnabled));
        pw.append(", nonInteractiveUiTimeout=").append(String.valueOf(this.mNonInteractiveUiTimeout));
        pw.append(", interactiveUiTimeout=").append(String.valueOf(this.mInteractiveUiTimeout));
        pw.append(", installedServiceCount=").append(String.valueOf(this.mInstalledServices.size()));
        pw.append(", magnificationModes=").append(String.valueOf(this.mMagnificationModes));
        pw.append(", magnificationCapabilities=").append(String.valueOf(this.mMagnificationCapabilities));
        pw.append(", audioDescriptionByDefaultEnabled=").append(String.valueOf(this.mIsAudioDescriptionByDefaultRequested));
        pw.append(", magnificationFollowTypingEnabled=").append(String.valueOf(this.mMagnificationFollowTypingEnabled));
        pw.append(", alwaysOnMagnificationEnabled=").append(String.valueOf(this.mAlwaysOnMagnificationEnabled));
        pw.append("}");
        pw.println();
        pw.append("     button mode: ");
        pw.append(String.valueOf(ShortcutUtils.getButtonMode(this.mContext, this.mUserId)));
        pw.println();
        dumpShortcutTargets(pw, 2, "shortcut key");
        dumpShortcutTargets(pw, 1, "button");
        pw.append("     button target:{").append(this.mTargetAssignedToAccessibilityButton);
        pw.println("}");
        dumpShortcutTargets(pw, 32, "gesture");
        dumpShortcutTargets(pw, 16, "qs shortcut targets");
        pw.append("     a11y tiles in QS panel:").append(this.mA11yTilesInQsPanel.toString());
        pw.println();
        pw.append("     Bound services:{");
        int serviceCount = this.mBoundServices.size();
        int j = 0;
    L4:
        if (j >= serviceCount) goto L8;
        if (j <= 0) goto L7;
        pw.append(", ");
        pw.println();
        pw.append("                     ");
    L7:
        AccessibilityServiceConnection service = this.mBoundServices.get(j);
        service.dump(fd, pw, args);
        j = j + 1;
        goto L4
    L8:
        pw.println("}");
        pw.append("     Enabled services:{");
        Iterator<ComponentName> it = this.mEnabledServices.iterator();
        if (it.hasNext() == false) goto L14;
        ComponentName componentName = it.next();
        pw.append(componentName.toShortString());
    L12:
        if (it.hasNext() == false) goto L14;
        ComponentName componentName2 = it.next();
        pw.append(", ");
        pw.append(componentName2.toShortString());
    L14:
        pw.println("}");
        pw.append("     Binding services:{");
        Iterator<ComponentName> it2 = this.mBindingServices.iterator();
        if (it2.hasNext() == false) goto L20;
        ComponentName componentName3 = it2.next();
        pw.append(componentName3.toShortString());
    L18:
        if (it2.hasNext() == false) goto L20;
        ComponentName componentName4 = it2.next();
        pw.append(", ");
        pw.append(componentName4.toShortString());
    L20:
        pw.println("}");
        pw.append("     Crashed services:{");
        Iterator<ComponentName> it3 = this.mCrashedServices.iterator();
        if (it3.hasNext() == false) goto L26;
        ComponentName componentName5 = it3.next();
        pw.append(componentName5.toShortString());
    L24:
        if (it3.hasNext() == false) goto L26;
        ComponentName componentName6 = it3.next();
        pw.append(", ");
        pw.append(componentName6.toShortString());
    L26:
        pw.println("}");
        pw.println("     Client list info:{");
        this.mUserClients.dump(pw, "          Client list ");
        pw.println("          Registered clients:{");
        int i = 0;
    L28:
        if (i >= this.mUserClients.getRegisteredCallbackCount()) goto L30;
        AccessibilityManagerService.Client client = (AccessibilityManagerService.Client) this.mUserClients.getRegisteredCallbackCookie(i);
        pw.append(Arrays.toString(client.mPackageNames));
        i = i + 1;
        goto L28
    L30:
        pw.println("}]");
    }

    public boolean isAutoclickEnabledLocked() {
        return this.mIsAutoclickEnabled;
    }

    public void setAutoclickEnabledLocked(boolean enabled) {
        this.mIsAutoclickEnabled = enabled;
    }

    public boolean isMagnificationSingleFingerTripleTapEnabledLocked() {
        return this.mIsMagnificationSingleFingerTripleTapEnabled;
    }

    public void setMagnificationSingleFingerTripleTapEnabledLocked(boolean enabled) {
        this.mIsMagnificationSingleFingerTripleTapEnabled = enabled;
    }

    public boolean isMagnificationTwoFingerTripleTapEnabledLocked() {
        return this.mMagnificationTwoFingerTripleTapEnabled;
    }

    public void setMagnificationTwoFingerTripleTapEnabledLocked(boolean enabled) {
        this.mMagnificationTwoFingerTripleTapEnabled = enabled;
    }

    public boolean isFilterKeyEventsEnabledLocked() {
        return this.mIsFilterKeyEventsEnabled;
    }

    public void setFilterKeyEventsEnabledLocked(boolean enabled) {
        this.mIsFilterKeyEventsEnabled = enabled;
    }

    public void setMouseKeysEnabled(boolean enabled) {
        this.mMouseKeysEnabled = enabled;
    }

    public boolean isMouseKeysEnabled() {
        return this.mMouseKeysEnabled;
    }

    public int getInteractiveUiTimeoutLocked() {
        return this.mInteractiveUiTimeout;
    }

    public void setInteractiveUiTimeoutLocked(int timeout) {
        this.mInteractiveUiTimeout = timeout;
    }

    public int getLastSentClientStateLocked() {
        return this.mLastSentClientState;
    }

    public void setLastSentClientStateLocked(int state) {
        this.mLastSentClientState = state;
    }

    public boolean isShortcutMagnificationEnabledLocked() {
        int[] r0 = ShortcutConstants.USER_SHORTCUT_TYPES;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        int shortcutType = r0[r3];
        if (getShortcutTargetsLocked(shortcutType).contains("com.android.server.accessibility.MagnificationController") == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public int getMagnificationModeLocked(int displayId) {
        int mode = this.mMagnificationModes.get(displayId, 0);
        if (mode != 0) goto L6;
        setMagnificationModeLocked(displayId, 1);
        return 1;
    L6:
        return mode;
    }

    int getMagnificationCapabilitiesLocked() {
        return this.mMagnificationCapabilities;
    }

    public void setMagnificationCapabilitiesLocked(int capabilities) {
        this.mMagnificationCapabilities = capabilities;
    }

    public void setMagnificationFollowTypingEnabled(boolean enabled) {
        this.mMagnificationFollowTypingEnabled = enabled;
    }

    public boolean isMagnificationFollowTypingEnabled() {
        return this.mMagnificationFollowTypingEnabled;
    }

    public void setAlwaysOnMagnificationEnabled(boolean enabled) {
        this.mAlwaysOnMagnificationEnabled = enabled;
    }

    public boolean isAlwaysOnMagnificationEnabled() {
        return this.mAlwaysOnMagnificationEnabled;
    }

    public void setMagnificationModeLocked(int displayId, int mode) {
        this.mMagnificationModes.put(displayId, mode);
    }

    public ArraySet<String> getShortcutTargetsLocked(int shortcutTypes) {
        ArraySet<String> targets = new ArraySet();
        int[] r1 = ShortcutConstants.USER_SHORTCUT_TYPES;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L20;
        int shortcutType = r1[r3];
        if ((shortcutTypes & shortcutType) != shortcutType) goto L19;
        if (shortcutType != 4) goto L12;
        if (isMagnificationSingleFingerTripleTapEnabledLocked() == false) goto L12;
    L15:
        targets.add("com.android.server.accessibility.MagnificationController");
    L12:
        if (shortcutType != 8) goto L17;
        if (isMagnificationTwoFingerTripleTapEnabledLocked() == true) goto L15;
    L17:
        if (this.mShortcutTargets.containsKey(Integer.valueOf(shortcutType)) == false) goto L19;
        targets.addAll(this.mShortcutTargets.get(Integer.valueOf(shortcutType)));
    L19:
        r3 = r3 + 1;
        goto L3
    L20:
        return targets;
    }

    boolean updateShortcutTargetsLocked(Set<String> newTargets, int shortcutType) {
        if ((shortcutType & 12) != 0) goto L14;
        if (this.mShortcutTargets.containsKey(Integer.valueOf(shortcutType)) == true) goto L7;
        this.mShortcutTargets.put(Integer.valueOf(shortcutType), new ArraySet());
    L7:
        ArraySet<String> currentTargets = this.mShortcutTargets.get(Integer.valueOf(shortcutType));
        if (newTargets.equals(currentTargets) == false) goto L11;
        return false;
    L11:
        currentTargets.clear();
        currentTargets.addAll(newTargets);
        return true;
    L14:
        throw new IllegalArgumentException("Tap shortcuts cannot be updated with target sets.");
    }

    public boolean isShortcutTargetInstalledLocked(String name) {
        if (TextUtils.isEmpty(name) == false) goto L6;
        return false;
    L6:
        if ("com.android.server.accessibility.MagnificationController".equals(name) == false) goto L8;
        return true;
    L8:
        ComponentName componentName = ComponentName.unflattenFromString(name);
        if (componentName != null) goto L12;
        return false;
    L12:
        if (AccessibilityShortcutController.getFrameworkShortcutFeaturesMap().containsKey(componentName) == false) goto L15;
        return true;
    L15:
        if (getInstalledServiceInfoLocked(componentName) == null) goto L17;
        return true;
    L17:
        int i = 0;
    L19:
        if (i >= this.mInstalledShortcuts.size()) goto L25;
        if (this.mInstalledShortcuts.get(i).getComponentName().equals(componentName) == true) goto L22;
        i = i + 1;
        goto L19
    L22:
        return true;
    L25:
        return false;
    }

    public boolean removeShortcutTargetLocked(int shortcutType, final ComponentName target) {
        if (shortcutType == 4) goto L9;
        if (shortcutType == 8) goto L9;
        Set<String> targets = this.mShortcutTargets.get(Integer.valueOf(shortcutType));
        return targets.removeIf(new AccessibilityUserState$$ExternalSyntheticLambda0(target));
    L9:
        throw new UnsupportedOperationException("removeShortcutTargetLocked only support shortcut type: software and hardware and quick settings for now");
    }

    private static /* synthetic */ boolean lambda$removeShortcutTargetLocked$1(ComponentName target, String name) {
        if (name == null) goto L8;
        ComponentName componentName = ComponentName.unflattenFromString(name);
        if (componentName != null) goto L7;
        return false;
    L7:
        return componentName.equals(target);
    L8:
        return false;
    }

    public AccessibilityServiceInfo getInstalledServiceInfoLocked(ComponentName componentName) {
        int i = 0;
    L4:
        if (i >= this.mInstalledServices.size()) goto L9;
        AccessibilityServiceInfo serviceInfo = this.mInstalledServices.get(i);
        if (serviceInfo.getComponentName().equals(componentName) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return serviceInfo;
    L9:
        return null;
    }

    public AccessibilityServiceConnection getServiceConnectionLocked(ComponentName componentName) {
        return this.mComponentNameToServiceMap.get(componentName);
    }

    public int getNonInteractiveUiTimeoutLocked() {
        return this.mNonInteractiveUiTimeout;
    }

    public void setNonInteractiveUiTimeoutLocked(int timeout) {
        this.mNonInteractiveUiTimeout = timeout;
    }

    public boolean isPerformGesturesEnabledLocked() {
        return this.mIsPerformGesturesEnabled;
    }

    public void setPerformGesturesEnabledLocked(boolean enabled) {
        this.mIsPerformGesturesEnabled = enabled;
    }

    public boolean isAccessibilityFocusOnlyInActiveWindow() {
        return this.mAccessibilityFocusOnlyInActiveWindow;
    }

    public void setAccessibilityFocusOnlyInActiveWindow(boolean enabled) {
        this.mAccessibilityFocusOnlyInActiveWindow = enabled;
    }

    public ComponentName getServiceChangingSoftKeyboardModeLocked() {
        return this.mServiceChangingSoftKeyboardMode;
    }

    public void setServiceChangingSoftKeyboardModeLocked(ComponentName serviceChangingSoftKeyboardMode) {
        this.mServiceChangingSoftKeyboardMode = serviceChangingSoftKeyboardMode;
    }

    public boolean isTextHighContrastEnabledLocked() {
        return this.mIsTextHighContrastEnabled;
    }

    public void setTextHighContrastEnabledLocked(boolean enabled) {
        this.mIsTextHighContrastEnabled = enabled;
    }

    public boolean isAudioDescriptionByDefaultEnabledLocked() {
        return this.mIsAudioDescriptionByDefaultRequested;
    }

    public void setAudioDescriptionByDefaultEnabledLocked(boolean enabled) {
        this.mIsAudioDescriptionByDefaultRequested = enabled;
    }

    public boolean isTouchExplorationEnabledLocked() {
        return this.mIsTouchExplorationEnabled;
    }

    public void setTouchExplorationEnabledLocked(boolean enabled) {
        this.mIsTouchExplorationEnabled = enabled;
    }

    public boolean isServiceHandlesDoubleTapEnabledLocked() {
        return this.mServiceHandlesDoubleTap;
    }

    public void setServiceHandlesDoubleTapLocked(boolean enabled) {
        this.mServiceHandlesDoubleTap = enabled;
    }

    public boolean isMultiFingerGesturesEnabledLocked() {
        return this.mRequestMultiFingerGestures;
    }

    public void setMultiFingerGesturesLocked(boolean enabled) {
        this.mRequestMultiFingerGestures = enabled;
    }

    public boolean isTwoFingerPassthroughEnabledLocked() {
        return this.mRequestTwoFingerPassthrough;
    }

    public void setTwoFingerPassthroughLocked(boolean enabled) {
        this.mRequestTwoFingerPassthrough = enabled;
    }

    public boolean isSendMotionEventsEnabled() {
        return this.mSendMotionEventsEnabled;
    }

    public void setSendMotionEventsEnabled(boolean mode) {
        this.mSendMotionEventsEnabled = mode;
    }

    public int getUserInteractiveUiTimeoutLocked() {
        return this.mUserInteractiveUiTimeout;
    }

    public void setUserInteractiveUiTimeoutLocked(int timeout) {
        this.mUserInteractiveUiTimeout = timeout;
    }

    public int getUserNonInteractiveUiTimeoutLocked() {
        return this.mUserNonInteractiveUiTimeout;
    }

    public void setUserNonInteractiveUiTimeoutLocked(int timeout) {
        this.mUserNonInteractiveUiTimeout = timeout;
    }

    public String getTargetAssignedToAccessibilityButton() {
        return this.mTargetAssignedToAccessibilityButton;
    }

    public void setTargetAssignedToAccessibilityButton(String target) {
        this.mTargetAssignedToAccessibilityButton = target;
    }

    public static boolean doesShortcutTargetsStringContain(Collection<String> shortcutTargets, String targetName) {
        if (shortcutTargets == null) goto L22;
        if (targetName == null) goto L22;
        if (shortcutTargets.contains(targetName) == false) goto L9;
        return true;
    L9:
        ComponentName targetComponentName = ComponentName.unflattenFromString(targetName);
        if (targetComponentName != null) goto L12;
        return false;
    L12:
        Iterator<String> r3 = shortcutTargets.iterator();
    L14:
        if (r3.hasNext() == false) goto L21;
        String stringName = r3.next();
        if (TextUtils.isEmpty(stringName) == true) goto L14;
        if (targetComponentName.equals(ComponentName.unflattenFromString(stringName)) == false) goto L14;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    public int getFocusStrokeWidthLocked() {
        return this.mFocusStrokeWidth;
    }

    public int getFocusColorLocked() {
        return this.mFocusColor;
    }

    public void setFocusAppearanceLocked(int strokeWidth, int color) {
        this.mFocusStrokeWidth = strokeWidth;
        this.mFocusColor = color;
    }

    public void setServiceDetectsGesturesEnabled(int displayId, boolean mode) {
        this.mServiceDetectsGestures.put(displayId, Boolean.valueOf(mode));
    }

    public void resetServiceDetectsGestures() {
        this.mServiceDetectsGestures.clear();
    }

    public boolean isServiceDetectsGesturesEnabled(int displayId) {
        if (this.mServiceDetectsGestures.contains(displayId) == true) goto L5;
        return false;
    L5:
        return this.mServiceDetectsGestures.get(displayId).booleanValue();
    }

    public void updateTileServiceMapForAccessibilityServiceLocked(final Set<ComponentName> validA11yTileServices) {
        this.mA11yServiceToTileService.clear();
        if (validA11yTileServices.isEmpty() == false) goto L5;
        return;
    L5:
        this.mInstalledServices.forEach(new AccessibilityUserState$$ExternalSyntheticLambda1(this, validA11yTileServices));
    }

    private /* synthetic */ void lambda$updateTileServiceMapForAccessibilityServiceLocked$2(Set validA11yTileServices, AccessibilityServiceInfo a11yServiceInfo) {
        String tileServiceName = a11yServiceInfo.getTileServiceName();
        if (TextUtils.isEmpty(tileServiceName) == true) goto L8;
        ResolveInfo resolveInfo = a11yServiceInfo.getResolveInfo();
        ComponentName a11yFeature = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        ComponentName tileService = new ComponentName(a11yFeature.getPackageName(), tileServiceName);
        if (validA11yTileServices.contains(tileService) == false) goto L9;
        this.mA11yServiceToTileService.put(a11yFeature, tileService);
        return;
    L9:
        return;
    }

    public void updateTileServiceMapForAccessibilityActivityLocked(final Set<ComponentName> validA11yTileServices) {
        this.mA11yActivityToTileService.clear();
        if (validA11yTileServices.isEmpty() == false) goto L5;
        return;
    L5:
        this.mInstalledShortcuts.forEach(new AccessibilityUserState$$ExternalSyntheticLambda2(this, validA11yTileServices));
    }

    private /* synthetic */ void lambda$updateTileServiceMapForAccessibilityActivityLocked$3(Set validA11yTileServices, AccessibilityShortcutInfo a11yShortcutInfo) {
        String tileServiceName = a11yShortcutInfo.getTileServiceName();
        if (TextUtils.isEmpty(tileServiceName) == true) goto L8;
        ComponentName a11yFeature = a11yShortcutInfo.getComponentName();
        ComponentName tileService = new ComponentName(a11yFeature.getPackageName(), tileServiceName);
        if (validA11yTileServices.contains(tileService) == false) goto L9;
        this.mA11yActivityToTileService.put(a11yFeature, tileService);
        return;
    L9:
        return;
    }

    public void updateA11yTilesInQsPanelLocked(Set<ComponentName> componentNames) {
        this.mA11yTilesInQsPanel.clear();
        this.mA11yTilesInQsPanel.addAll(componentNames);
    }

    public ArraySet<ComponentName> getA11yQsTilesInQsPanel() {
        return new ArraySet(this.mA11yTilesInQsPanel);
    }

    public Map<ComponentName, ComponentName> getA11yFeatureToTileService() {
        Map<ComponentName, ComponentName> featureToTileServiceMap = new ArrayMap();
        featureToTileServiceMap.putAll(this.mA11yServiceToTileService);
        featureToTileServiceMap.putAll(this.mA11yActivityToTileService);
        return featureToTileServiceMap;
    }

    public Map<ComponentName, AccessibilityServiceInfo> getTileServiceToA11yServiceInfoMapLocked() {
        Map<ComponentName, AccessibilityServiceInfo> tileServiceToA11yServiceInfoMap = new ArrayMap();
        Map<ComponentName, AccessibilityServiceInfo> a11yServiceToServiceInfoMap = (Map) this.mInstalledServices.stream().collect(Collectors.toMap(new AccessibilityManagerService$$ExternalSyntheticLambda44(), Function.identity()));
        Iterator<Map.Entry<ComponentName, ComponentName>> r2 = this.mA11yServiceToTileService.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<ComponentName, ComponentName> serviceToTile = r2.next();
        if (a11yServiceToServiceInfoMap.containsKey(serviceToTile.getKey()) == false) goto L4;
        tileServiceToA11yServiceInfoMap.put(serviceToTile.getValue(), a11yServiceToServiceInfoMap.get(serviceToTile.getKey()));
        goto L4
    L9:
        return tileServiceToA11yServiceInfoMap;
    }
}
