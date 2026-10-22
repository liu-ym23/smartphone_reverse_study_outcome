package com.android.server.inputmethod;

import android.os.IBinder;
import android.os.ResultReceiver;
import android.util.EventLog;
import android.view.inputmethod.ImeTracker;
import com.android.internal.inputmethod.InputMethodDebug;
import com.android.internal.protolog.ProtoLog;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import com.android.server.wm.ImeTargetVisibilityPolicy;
import com.android.server.wm.WindowManagerInternal;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class DefaultImeVisibilityApplier {
    static final String TAG = "DefaultImeVisibilityApplier";
    private final ImeTargetVisibilityPolicy mImeTargetVisibilityPolicy;
    private InputMethodManagerService mService;
    private final WindowManagerInternal mWindowManagerInternal;

    DefaultImeVisibilityApplier(InputMethodManagerService service) {
        this.mService = service;
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mImeTargetVisibilityPolicy = (ImeTargetVisibilityPolicy) LocalServices.getService(ImeTargetVisibilityPolicy.class);
    }

    void performShowIme(IBinder showInputToken, ImeTracker.Token statsToken, int showFlags, ResultReceiver resultReceiver, int reason, int userId) {
        UserData userData = this.mService.getUserData(userId);
        InputMethodBindingController bindingController = userData.mBindingController;
        IInputMethodInvoker curMethod = bindingController.getCurMethod();
        if (curMethod == null) goto L14;
        ProtoLog.v(ImeProtoLogGroup.IME_VISIBILITY_APPLIER_DEBUG, "Calling %s.showSoftInput(%s, %s, %s) for reason: %s", new Object[]{curMethod, showInputToken, Integer.valueOf(showFlags), resultReceiver, InputMethodDebug.softInputDisplayReasonToString(reason)});
        if (curMethod.showSoftInput(showInputToken, statsToken, showFlags, resultReceiver) == true) goto L7;
        return;
    L7:
        if (ImeTracker.DEBUG_IME_VISIBILITY == false) goto L12;
        if (statsToken == null) goto L10;
        String r1 = statsToken.getTag();
    L11:
        EventLog.writeEvent(EventLogTags.IMF_SHOW_IME, new Object[]{r1, Objects.toString(userData.mImeBindingState.mFocusedWindow), InputMethodDebug.softInputDisplayReasonToString(reason), InputMethodDebug.softInputModeToString(userData.mImeBindingState.mFocusedWindowSoftInputMode)});
        goto L12
    L10:
        r1 = "TOKEN_NONE";
    L12:
        this.mService.onShowHideSoftInputRequested(true, showInputToken, reason, statsToken, userId);
        return;
    }

    void performHideIme(IBinder hideInputToken, ImeTracker.Token statsToken, ResultReceiver resultReceiver, int reason, int userId) {
        UserData userData = this.mService.getUserData(userId);
        InputMethodBindingController bindingController = userData.mBindingController;
        IInputMethodInvoker curMethod = bindingController.getCurMethod();
        if (curMethod == null) goto L14;
        ProtoLog.v(ImeProtoLogGroup.IME_VISIBILITY_APPLIER_DEBUG, "Calling %s.hideSoftInput(0, %s, %s) for reason: %s", new Object[]{curMethod, hideInputToken, resultReceiver, InputMethodDebug.softInputDisplayReasonToString(reason)});
        if (curMethod.hideSoftInput(hideInputToken, statsToken, 0, resultReceiver) == true) goto L7;
        return;
    L7:
        if (ImeTracker.DEBUG_IME_VISIBILITY == false) goto L12;
        if (statsToken == null) goto L10;
        String r0 = statsToken.getTag();
    L11:
        EventLog.writeEvent(EventLogTags.IMF_HIDE_IME, new Object[]{r0, Objects.toString(userData.mImeBindingState.mFocusedWindow), InputMethodDebug.softInputDisplayReasonToString(reason), InputMethodDebug.softInputModeToString(userData.mImeBindingState.mFocusedWindowSoftInputMode)});
        goto L12
    L10:
        r0 = "TOKEN_NONE";
    L12:
        this.mService.onShowHideSoftInputRequested(false, hideInputToken, reason, statsToken, userId);
        return;
    }

    void applyImeVisibility(IBinder windowToken, ImeTracker.Token statsToken, int state, int reason, int userId) {
        UserData userData = this.mService.getUserData(userId);
        InputMethodBindingController bindingController = userData.mBindingController;
        int displayIdToShowIme = bindingController.getDisplayIdToShowIme();
        switch(state) {
            case 0: goto L18;
            case 1: goto L18;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        removeImeScreenshot(displayIdToShowIme, userId);
        return;
    L7:
        this.mService.setImeVisibilityOnFocusedWindowClient(true, userData, statsToken);
        return;
    L8:
        this.mService.setImeVisibilityOnFocusedWindowClient(false, userData, statsToken);
        return;
    L9:
        this.mService.setImeVisibilityOnFocusedWindowClient(false, userData, statsToken);
        return;
    L10:
        showImeScreenshot(windowToken, displayIdToShowIme, userId);
        return;
    L18:
        return;
    L5:
        throw new IllegalArgumentException("Invalid IME visibility state: " + state);
    }

    boolean showImeScreenshot(IBinder imeTarget, int displayId, int userId) {
        if (this.mImeTargetVisibilityPolicy.showImeScreenshot(imeTarget, displayId) == false) goto L7;
        this.mService.onShowHideSoftInputRequested(false, imeTarget, 34, null, userId);
        return true;
    L7:
        return false;
    }

    boolean removeImeScreenshot(int displayId, int userId) {
        UserData userData = this.mService.getUserData(userId);
        if (this.mImeTargetVisibilityPolicy.removeImeScreenshot(displayId) == false) goto L7;
        this.mService.onShowHideSoftInputRequested(false, userData.mImeBindingState.mFocusedWindow, 35, null, userId);
        return true;
    L7:
        return false;
    }
}
