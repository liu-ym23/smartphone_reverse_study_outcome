package com.android.server.accessibility;

import android.R;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.app.StatusBarManager;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.Slog;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.android.internal.accessibility.util.AccessibilityUtils;
import com.android.internal.util.ScreenshotHelper;
import com.android.server.LocalServices;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.usb.descriptors.UsbTerminalTypes;
import com.android.server.wm.WindowManagerInternal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class SystemActionPerformer {
    private static final String TAG = "SystemActionPerformer";
    private final Context mContext;
    private final DisplayUpdateCallBack mDisplayUpdateCallBack;
    private final AccessibilityNodeInfo.AccessibilityAction mLegacyBackAction;
    private final AccessibilityNodeInfo.AccessibilityAction mLegacyHomeAction;
    private final AccessibilityNodeInfo.AccessibilityAction mLegacyLockScreenAction;
    private final AccessibilityNodeInfo.AccessibilityAction mLegacyNotificationsAction;
    private final AccessibilityNodeInfo.AccessibilityAction mLegacyPowerDialogAction;
    private final AccessibilityNodeInfo.AccessibilityAction mLegacyQuickSettingsAction;
    private final AccessibilityNodeInfo.AccessibilityAction mLegacyRecentsAction;
    private final AccessibilityNodeInfo.AccessibilityAction mLegacyTakeScreenshotAction;
    private final SystemActionsChangedListener mListener;
    private final Map<Integer, RemoteAction> mRegisteredSystemActions;
    private Supplier<ScreenshotHelper> mScreenshotHelperSupplier;
    private final Object mSystemActionLock;
    private final WindowManagerInternal mWindowManagerService;

    interface DisplayUpdateCallBack {
        int getLastNonProxyTopFocusedDisplayId();

        void moveNonProxyTopFocusedDisplayToTopIfNeeded();
    }

    interface SystemActionsChangedListener {
        void onSystemActionsChanged();
    }

    public SystemActionPerformer(Context context, WindowManagerInternal windowManagerInternal) {
        this(context, windowManagerInternal, null, null, null);
    }

    public SystemActionPerformer(Context context, WindowManagerInternal windowManagerInternal, Supplier<ScreenshotHelper> screenshotHelperSupplier) {
        this(context, windowManagerInternal, screenshotHelperSupplier, null, null);
    }

    public SystemActionPerformer(Context context, WindowManagerInternal windowManagerInternal, Supplier<ScreenshotHelper> screenshotHelperSupplier, SystemActionsChangedListener listener, DisplayUpdateCallBack callback) {
        this.mSystemActionLock = new Object();
        this.mRegisteredSystemActions = new ArrayMap();
        this.mContext = context;
        this.mWindowManagerService = windowManagerInternal;
        this.mListener = listener;
        this.mDisplayUpdateCallBack = callback;
        this.mScreenshotHelperSupplier = screenshotHelperSupplier;
        this.mLegacyHomeAction = new AccessibilityNodeInfo.AccessibilityAction(2, this.mContext.getResources().getString(R.string.accessibility_uncheck_legacy_item_warning));
        this.mLegacyBackAction = new AccessibilityNodeInfo.AccessibilityAction(1, this.mContext.getResources().getString(R.string.accessibility_system_action_media_play_pause_label));
        this.mLegacyRecentsAction = new AccessibilityNodeInfo.AccessibilityAction(3, this.mContext.getResources().getString(R.string.activity_list_empty));
        this.mLegacyNotificationsAction = new AccessibilityNodeInfo.AccessibilityAction(4, this.mContext.getResources().getString(R.string.action_bar_up_description));
        this.mLegacyQuickSettingsAction = new AccessibilityNodeInfo.AccessibilityAction(5, this.mContext.getResources().getString(R.string.activity_chooser_view_see_all));
        this.mLegacyPowerDialogAction = new AccessibilityNodeInfo.AccessibilityAction(6, this.mContext.getResources().getString(R.string.activity_chooser_view_dialog_title_default));
        this.mLegacyLockScreenAction = new AccessibilityNodeInfo.AccessibilityAction(8, this.mContext.getResources().getString(R.string.action_bar_home_description));
        this.mLegacyTakeScreenshotAction = new AccessibilityNodeInfo.AccessibilityAction(9, this.mContext.getResources().getString(R.string.activity_resolver_use_always));
    }

    public void registerSystemAction(int id, RemoteAction action) {
        Object r0 = this.mSystemActionLock;
        monitor-enter(r0);
        this.mRegisteredSystemActions.put(Integer.valueOf(id), action);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (this.mListener == null) goto L15;
        this.mListener.onSystemActionsChanged();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void unregisterSystemAction(int id) {
        Object r0 = this.mSystemActionLock;
        monitor-enter(r0);
        this.mRegisteredSystemActions.remove(Integer.valueOf(id));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (this.mListener == null) goto L15;
        this.mListener.onSystemActionsChanged();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public List<AccessibilityNodeInfo.AccessibilityAction> getSystemActions() {
        List<AccessibilityNodeInfo.AccessibilityAction> systemActions = new ArrayList();
        Object r1 = this.mSystemActionLock;
        monitor-enter(r1);
        Iterator<Map.Entry<Integer, RemoteAction>> r2 = this.mRegisteredSystemActions.entrySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<Integer, RemoteAction> entry = r2.next();     // Catch: Throwable -> L8
        AccessibilityNodeInfo.AccessibilityAction systemAction = new AccessibilityNodeInfo.AccessibilityAction(entry.getKey().intValue(), entry.getValue().getTitle());     // Catch: Throwable -> L8
        systemActions.add(systemAction);     // Catch: Throwable -> L8
        goto L6
    L10:
        addLegacySystemActions(systemActions);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return systemActions;
    L8:
        th = move-exception;
        throw th;
    }

    private void addLegacySystemActions(List<AccessibilityNodeInfo.AccessibilityAction> systemActions) {
        if (this.mRegisteredSystemActions.containsKey(1) == true) goto L6;
        systemActions.add(this.mLegacyBackAction);
    L6:
        if (this.mRegisteredSystemActions.containsKey(2) == true) goto L9;
        systemActions.add(this.mLegacyHomeAction);
    L9:
        if (this.mRegisteredSystemActions.containsKey(3) == true) goto L12;
        systemActions.add(this.mLegacyRecentsAction);
    L12:
        if (this.mRegisteredSystemActions.containsKey(4) == true) goto L15;
        systemActions.add(this.mLegacyNotificationsAction);
    L15:
        if (this.mRegisteredSystemActions.containsKey(5) == true) goto L18;
        systemActions.add(this.mLegacyQuickSettingsAction);
    L18:
        if (this.mRegisteredSystemActions.containsKey(6) == true) goto L21;
        systemActions.add(this.mLegacyPowerDialogAction);
    L21:
        if (this.mRegisteredSystemActions.containsKey(8) == true) goto L24;
        systemActions.add(this.mLegacyLockScreenAction);
    L24:
        if (this.mRegisteredSystemActions.containsKey(9) == true) goto L27;
        systemActions.add(this.mLegacyTakeScreenshotAction);
        return;
    }

    public boolean performSystemAction(int actionId) {
        long identity = Binder.clearCallingIdentity();
        Object r2 = this.mSystemActionLock;     // Catch: Throwable -> L26
        monitor-enter(r2);     // Catch: Throwable -> L26
        this.mDisplayUpdateCallBack.moveNonProxyTopFocusedDisplayToTopIfNeeded();     // Catch: Throwable -> L12
        RemoteAction registeredAction = this.mRegisteredSystemActions.get(Integer.valueOf(actionId));     // Catch: Throwable -> L12
        if (registeredAction != null) goto L91;
        monitor-exit(r2);     // Catch: Throwable -> L12
        switch(actionId) {
            case 1: goto L84;
            case 2: goto L80;
            case 3: goto L76;
            case 4: goto L73;
            case 5: goto L70;
            case 6: goto L67;
            case 7: goto L23;
            case 8: goto L64;
            case 9: goto L61;
            case 10: goto L57;
            case 11: goto L23;
            case 12: goto L23;
            case 13: goto L23;
            case 14: goto L23;
            case 15: goto L23;
            case 16: goto L53;
            case 17: goto L49;
            case 18: goto L45;
            case 19: goto L41;
            case 20: goto L37;
            case 21: goto L33;
            case 22: goto L29;
            default: goto L23;
        };
    L23:
        Slog.e(TAG, "Invalid action id: " + actionId);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return false;
    L61:
        boolean r3 = takeScreenshot();     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return r3;
    L64:
        boolean r4 = lockScreen();     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return r4;
    L67:
        showGlobalActions();     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L70:
        expandQuickSettings();     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L73:
        expandNotifications();     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L76:
        boolean r5 = openRecents();     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return r5;
    L29:
        sendDownAndUpKeyEvents(85, 257);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L33:
        sendDownAndUpKeyEvents(82, 257);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L37:
        sendDownAndUpKeyEvents(23, UsbTerminalTypes.TERMINAL_OUT_SPEAKER);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L41:
        sendDownAndUpKeyEvents(22, UsbTerminalTypes.TERMINAL_OUT_SPEAKER);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L45:
        sendDownAndUpKeyEvents(21, UsbTerminalTypes.TERMINAL_OUT_SPEAKER);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L49:
        sendDownAndUpKeyEvents(20, UsbTerminalTypes.TERMINAL_OUT_SPEAKER);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L53:
        sendDownAndUpKeyEvents(19, UsbTerminalTypes.TERMINAL_OUT_SPEAKER);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L57:
        if (AccessibilityUtils.interceptHeadsetHookForActiveCall(this.mContext) == true) goto L59;
        sendDownAndUpKeyEvents(79, 257);     // Catch: Throwable -> L26
    L59:
        Binder.restoreCallingIdentity(identity);
        return true;
    L80:
        sendDownAndUpKeyEvents(3, 257);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L84:
        sendDownAndUpKeyEvents(4, 257);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(identity);
        return true;
    L91:
        registeredAction.getActionIntent().send();     // Catch: Throwable -> L12 PendingIntent.CanceledException -> L14
        monitor-exit(r2);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(identity);
        return true;
    L14:
        ex = move-exception;
        Slog.e(TAG, "canceled PendingIntent for global action " + registeredAction.getTitle(), ex);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(identity);
        return false;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void sendDownAndUpKeyEvents(int keyCode, int source) {
        long token = Binder.clearCallingIdentity();
        long downTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L10
        sendKeyEventIdentityCleared(keyCode, 0, downTime, downTime, source);     // Catch: Throwable -> L8
        sendKeyEventIdentityCleared(keyCode, 1, downTime, SystemClock.uptimeMillis(), source);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return;
    L8:
        th = move-exception;
        Throwable r14 = th;
    L12:
        Binder.restoreCallingIdentity(token);
        throw r14;
    L10:
        th = move-exception;
        r14 = th;
        goto L12
    }

    private void sendKeyEventIdentityCleared(int keyCode, int action, long downTime, long time, int source) {
        KeyEvent event = KeyEvent.obtain(downTime, time, action, keyCode, 0, 0, -1, 0, 8, source, this.mDisplayUpdateCallBack.getLastNonProxyTopFocusedDisplayId(), null);
        ((InputManager) this.mContext.getSystemService(InputManager.class)).injectInputEvent(event, 0);
        event.recycle();
    }

    private void expandNotifications() {
        long token = Binder.clearCallingIdentity();
        StatusBarManager statusBarManager = (StatusBarManager) this.mContext.getSystemService("statusbar");     // Catch: Throwable -> L6
        statusBarManager.expandNotificationsPanel();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void expandQuickSettings() {
        long token = Binder.clearCallingIdentity();
        StatusBarManager statusBarManager = (StatusBarManager) this.mContext.getSystemService("statusbar");     // Catch: Throwable -> L6
        statusBarManager.expandSettingsPanel();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private boolean openRecents() {
        long token = Binder.clearCallingIdentity();
        StatusBarManagerInternal statusBarService = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);     // Catch: Throwable -> L10
        if (statusBarService != null) goto L7;
        Binder.restoreCallingIdentity(token);
        return false;
    L7:
        statusBarService.toggleRecentApps();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(token);
        return true;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void showGlobalActions() {
        this.mWindowManagerService.showGlobalActions();
    }

    private boolean lockScreen() {
        ((PowerManager) this.mContext.getSystemService(PowerManager.class)).goToSleep(SystemClock.uptimeMillis(), 7, 0);
        this.mWindowManagerService.lockNow();
        return true;
    }

    private boolean takeScreenshot() {
        if (this.mScreenshotHelperSupplier == null) goto L5;
        ScreenshotHelper screenshotHelper = this.mScreenshotHelperSupplier.get();
    L6:
        screenshotHelper.takeScreenshot(4, new Handler(Looper.getMainLooper()), null);
        return true;
    L5:
        screenshotHelper = new ScreenshotHelper(this.mContext);
        goto L6
    }
}
