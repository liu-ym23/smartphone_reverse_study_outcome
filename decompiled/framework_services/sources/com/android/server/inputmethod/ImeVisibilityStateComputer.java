package com.android.server.inputmethod;

import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.util.PrintWriterPrinter;
import android.util.Printer;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.WindowManager;
import android.view.inputmethod.ImeTracker;
import com.android.internal.inputmethod.InputMethodDebug;
import com.android.internal.protolog.ProtoLog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.pm.UserManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ImeVisibilityStateComputer {
    public static final int STATE_HIDE_IME = 0;
    public static final int STATE_HIDE_IME_EXPLICIT = 5;
    public static final int STATE_HIDE_IME_NOT_ALWAYS = 6;
    public static final int STATE_INVALID = -1;
    public static final int STATE_REMOVE_IME_SNAPSHOT = 8;
    public static final int STATE_SHOW_IME = 1;
    public static final int STATE_SHOW_IME_ABOVE_OVERLAY = 2;
    public static final int STATE_SHOW_IME_BEHIND_OVERLAY = 3;
    public static final int STATE_SHOW_IME_IMPLICIT = 7;
    public static final int STATE_SHOW_IME_SNAPSHOT = 4;
    static final String TAG = "ImeVisibilityStateComputer";
    private IBinder mCurVisibleImeInputTarget;
    private boolean mHasVisibleImeLayeringOverlay;
    final InputMethodManagerService.ImeDisplayValidator mImeDisplayValidator;
    private boolean mInputShown;
    private IBinder mLastImeTargetWindow;
    private final ImeVisibilityPolicy mPolicy;
    private final WeakHashMap<IBinder, ImeTargetWindowState> mRequestWindowStateMap;
    private boolean mRequestedImeScreenshot;
    boolean mRequestedShowExplicitly;
    private final InputMethodManagerService mService;
    boolean mShowForced;
    private final int mUserId;
    private final UserManagerInternal mUserManagerInternal;
    private final WindowManagerInternal mWindowManagerInternal;

    static class ImeTargetWindowState {
        private final boolean mHasFocusedEditor;
        private int mImeDisplayId;
        private final boolean mImeFocusChanged;
        private final boolean mIsStartInputByGainFocus;
        private IBinder mRequestImeToken;
        private boolean mRequestedImeVisible;
        private final int mSoftInputModeState;
        private final int mToolType;
        private final int mWindowFlags;

        /* JADX INFO: renamed from: -$$Nest$fgetmRequestedImeVisible, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4665$$Nest$fgetmRequestedImeVisible(ImeTargetWindowState r0) {
            return r0.mRequestedImeVisible;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSoftInputModeState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4666$$Nest$fgetmSoftInputModeState(ImeTargetWindowState r0) {
            return r0.mSoftInputModeState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmToolType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4667$$Nest$fgetmToolType(ImeTargetWindowState r0) {
            return r0.mToolType;
        }

        /* JADX INFO: renamed from: -$$Nest$msetImeDisplayId, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4668$$Nest$msetImeDisplayId(ImeTargetWindowState r0, int r1) {
            r0.setImeDisplayId(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetRequestedImeVisible, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4669$$Nest$msetRequestedImeVisible(ImeTargetWindowState r0, boolean r1) {
            r0.setRequestedImeVisible(r1);
        }

        ImeTargetWindowState(int softInputModeState, int windowFlags, boolean imeFocusChanged, boolean hasFocusedEditor, boolean isStartInputByGainFocus) {
            this(softInputModeState, windowFlags, imeFocusChanged, hasFocusedEditor, isStartInputByGainFocus, 0);
        }

        ImeTargetWindowState(int softInputModeState, int windowFlags, boolean imeFocusChanged, boolean hasFocusedEditor, boolean isStartInputByGainFocus, int toolType) {
            this.mImeDisplayId = 0;
            this.mSoftInputModeState = softInputModeState;
            this.mWindowFlags = windowFlags;
            this.mImeFocusChanged = imeFocusChanged;
            this.mHasFocusedEditor = hasFocusedEditor;
            this.mIsStartInputByGainFocus = isStartInputByGainFocus;
            this.mToolType = toolType;
        }

        boolean hasImeFocusChanged() {
            return this.mImeFocusChanged;
        }

        boolean hasEditorFocused() {
            return this.mHasFocusedEditor;
        }

        boolean isStartInputByGainFocus() {
            return this.mIsStartInputByGainFocus;
        }

        int getSoftInputModeState() {
            return this.mSoftInputModeState;
        }

        int getWindowFlags() {
            return this.mWindowFlags;
        }

        int getToolType() {
            return this.mToolType;
        }

        private void setImeDisplayId(int imeDisplayId) {
            this.mImeDisplayId = imeDisplayId;
        }

        int getImeDisplayId() {
            return this.mImeDisplayId;
        }

        private void setRequestedImeVisible(boolean requestedImeVisible) {
            this.mRequestedImeVisible = requestedImeVisible;
        }

        boolean isRequestedImeVisible() {
            return this.mRequestedImeVisible;
        }

        void setRequestImeToken(IBinder token) {
            this.mRequestImeToken = token;
        }

        IBinder getRequestImeToken() {
            return this.mRequestImeToken;
        }

        public String toString() {
            return "ImeTargetWindowState{ imeToken " + this.mRequestImeToken + " imeFocusChanged " + this.mImeFocusChanged + " hasEditorFocused " + this.mHasFocusedEditor + " requestedImeVisible " + this.mRequestedImeVisible + " imeDisplayId " + this.mImeDisplayId + " softInputModeState " + InputMethodDebug.softInputModeToString(this.mSoftInputModeState) + " isStartInputByGainFocus " + this.mIsStartInputByGainFocus + "}";
        }
    }

    static class ImeVisibilityPolicy {
        private boolean mA11yRequestingNoSoftKeyboard;
        private boolean mImeHiddenByDisplayPolicy;
        private boolean mPendingA11yRequestingHideKeyboard;

        /* JADX INFO: renamed from: -$$Nest$fgetmA11yRequestingNoSoftKeyboard, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4670$$Nest$fgetmA11yRequestingNoSoftKeyboard(ImeVisibilityPolicy r0) {
            return r0.mA11yRequestingNoSoftKeyboard;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmImeHiddenByDisplayPolicy, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4671$$Nest$fgetmImeHiddenByDisplayPolicy(ImeVisibilityPolicy r0) {
            return r0.mImeHiddenByDisplayPolicy;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPendingA11yRequestingHideKeyboard, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4672$$Nest$fgetmPendingA11yRequestingHideKeyboard(ImeVisibilityPolicy r0) {
            return r0.mPendingA11yRequestingHideKeyboard;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmPendingA11yRequestingHideKeyboard, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4673$$Nest$fputmPendingA11yRequestingHideKeyboard(ImeVisibilityPolicy r0, boolean r1) {
            r0.mPendingA11yRequestingHideKeyboard = r1;
        }

        ImeVisibilityPolicy() {
        }

        void setImeHiddenByDisplayPolicy(boolean hideIme) {
            this.mImeHiddenByDisplayPolicy = hideIme;
        }

        boolean isImeHiddenByDisplayPolicy() {
            return this.mImeHiddenByDisplayPolicy;
        }

        void setA11yRequestNoSoftKeyboard(int keyboardShowMode) {
            if ((keyboardShowMode & 3) != 1) goto L5;
            boolean r0 = true;
        L6:
            this.mA11yRequestingNoSoftKeyboard = r0;
            if (this.mA11yRequestingNoSoftKeyboard == false) goto L10;
            this.mPendingA11yRequestingHideKeyboard = true;
            return;
        L10:
            return;
        L5:
            r0 = false;
            goto L6
        }

        boolean isA11yRequestNoSoftKeyboard() {
            return this.mA11yRequestingNoSoftKeyboard;
        }
    }

    static class ImeVisibilityResult {
        private final int mReason;
        private final int mState;

        ImeVisibilityResult(int state, int reason) {
            this.mState = state;
            this.mReason = reason;
        }

        int getState() {
            return this.mState;
        }

        int getReason() {
            return this.mReason;
        }
    }

    interface Injector {
        InputMethodManagerService.ImeDisplayValidator getImeValidator();

        int getUserId();

        UserManagerInternal getUserManagerService();

        WindowManagerInternal getWmService();
    }

    @interface VisibilityState {
    }

    public ImeVisibilityStateComputer(InputMethodManagerService service, int userId) {
        UserManagerInternal r3 = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        WindowManagerInternal r4 = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        final WindowManagerInternal r0 = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        r0.getClass();
        this(service, r3, r4, new ImeVisibilityStateComputer$$ExternalSyntheticLambda0(r0), new ImeVisibilityPolicy(), userId);
    }

    public ImeVisibilityStateComputer(InputMethodManagerService service, Injector injector) {
        this(service, injector.getUserManagerService(), injector.getWmService(), injector.getImeValidator(), new ImeVisibilityPolicy(), injector.getUserId());
    }

    private ImeVisibilityStateComputer(InputMethodManagerService service, UserManagerInternal userManagerInternal, WindowManagerInternal wmService, InputMethodManagerService.ImeDisplayValidator imeDisplayValidator, ImeVisibilityPolicy imePolicy, int userId) {
        this.mRequestWindowStateMap = new WeakHashMap();
        this.mUserId = userId;
        this.mService = service;
        this.mUserManagerInternal = userManagerInternal;
        this.mWindowManagerInternal = wmService;
        this.mImeDisplayValidator = imeDisplayValidator;
        this.mPolicy = imePolicy;
    }

    void setHasVisibleImeLayeringOverlay(boolean hasVisibleOverlay) {
        this.mHasVisibleImeLayeringOverlay = hasVisibleOverlay;
    }

    void onImeInputTargetVisibilityChanged(IBinder imeInputTarget, boolean visibleAndNotRemoved) {
        if (visibleAndNotRemoved == false) goto L6;
        this.mCurVisibleImeInputTarget = imeInputTarget;
        return;
    L6:
        if (this.mHasVisibleImeLayeringOverlay == true) goto L8;
    L10:
        this.mCurVisibleImeInputTarget = null;
        return;
    L8:
        if (this.mCurVisibleImeInputTarget != imeInputTarget) goto L10;
        ImeTracker.Token statsToken = ImeTracker.forLogging().onStart(2, 6, 37, false);
        this.mService.onApplyImeVisibilityFromComputerLocked(imeInputTarget, statsToken, new ImeVisibilityResult(5, 37), this.mUserId);
        goto L10
    }

    boolean onImeShowFlags(ImeTracker.Token statsToken, int showFlags) {
        if (ImeVisibilityPolicy.m4670$$Nest$fgetmA11yRequestingNoSoftKeyboard(this.mPolicy) == false) goto L5;
    L14:
        ImeTracker.forLogging().onFailed(statsToken, 4);
        return false;
    L5:
        if (ImeVisibilityPolicy.m4671$$Nest$fgetmImeHiddenByDisplayPolicy(this.mPolicy) == true) goto L14;
        ImeTracker.forLogging().onProgress(statsToken, 4);
        if ((showFlags & 2) == 0) goto L11;
        this.mRequestedShowExplicitly = true;
        this.mShowForced = true;
    L13:
        return true;
    L11:
        if ((showFlags & 1) != 0) goto L13;
        this.mRequestedShowExplicitly = true;
        goto L13
    }

    boolean canHideIme(ImeTracker.Token statsToken, int hideFlags) {
        if ((hideFlags & 1) == 0) goto L11;
        if (this.mRequestedShowExplicitly == false) goto L7;
    L8:
        ProtoLog.v(ImeProtoLogGroup.IME_VIS_STATE_COMPUTER_DEBUG, "Not hiding: explicit show not cancelled by non-explicit hide", new Object[0]);
        ImeTracker.forLogging().onFailed(statsToken, 6);
        return false;
    L7:
        if (this.mShowForced == true) goto L8;
    L11:
        if (this.mShowForced == true) goto L13;
    L16:
        ImeTracker.forLogging().onProgress(statsToken, 7);
        return true;
    L13:
        if ((hideFlags & 2) == 0) goto L16;
        ProtoLog.v(ImeProtoLogGroup.IME_VIS_STATE_COMPUTER_DEBUG, "Not hiding: forced show not cancelled by not-always hide", new Object[0]);
        ImeTracker.forLogging().onFailed(statsToken, 7);
        return false;
    }

    int getShowFlagsForInputMethodServiceOnly() {
        int flags = 0;
        if (this.mShowForced == false) goto L6;
        flags = 0 | 3;
    L9:
        return flags | this.mService.getExt().getImeShowFlags();
    L6:
        if (this.mRequestedShowExplicitly == false) goto L9;
        flags = 0 | 1;
        goto L9
    }

    int getShowFlags() {
        int flags = 0;
        if (this.mShowForced == false) goto L6;
        flags = 0 | 2;
    L9:
        return flags | this.mService.getExt().getAppShowFlags();
    L6:
        if (this.mRequestedShowExplicitly == true) goto L9;
        flags = 0 | 1;
        goto L9
    }

    void clearImeShowFlags() {
        this.mRequestedShowExplicitly = false;
        this.mShowForced = false;
        this.mInputShown = false;
    }

    int computeImeDisplayId(ImeTargetWindowState state, int displayId) {
        PackageManager pm = this.mService.mContext.getPackageManager();
        if (pm.hasSystemFeature("android.hardware.type.automotive") == true) goto L5;
    L7:
        int displayToShowIme = InputMethodManagerService.computeImeDisplayIdForTarget(displayId, this.mImeDisplayValidator);
    L8:
        ImeTargetWindowState.m4668$$Nest$msetImeDisplayId(state, displayToShowIme);
        if (displayToShowIme != (-1)) goto L11;
        boolean imeHiddenByPolicy = true;
    L12:
        this.mPolicy.setImeHiddenByDisplayPolicy(imeHiddenByPolicy);
        return displayToShowIme;
    L11:
        imeHiddenByPolicy = false;
        goto L12
    L5:
        if (this.mUserManagerInternal.isVisibleBackgroundFullUser(this.mUserId) == false) goto L7;
        displayToShowIme = this.mService.computeImeDisplayIdForVisibleBackgroundUserOnAutomotive(displayId, this.mUserId, this.mImeDisplayValidator);
        goto L8
    }

    void requestImeVisibility(IBinder windowToken, boolean showIme) {
        ImeTargetWindowState state = getOrCreateWindowState(windowToken);
        if (ImeVisibilityPolicy.m4672$$Nest$fgetmPendingA11yRequestingHideKeyboard(this.mPolicy) == true) goto L5;
        ImeTargetWindowState.m4669$$Nest$msetRequestedImeVisible(state, showIme);
    L6:
        state.setRequestImeToken(new Binder());
        setWindowStateInner(windowToken, state);
        return;
    L5:
        ImeVisibilityPolicy.m4673$$Nest$fputmPendingA11yRequestingHideKeyboard(this.mPolicy, false);
        goto L6
    }

    ImeTargetWindowState getOrCreateWindowState(IBinder windowToken) {
        ImeTargetWindowState state = this.mRequestWindowStateMap.get(windowToken);
        if (state == null) goto L5;
        return state;
    L5:
        return new ImeTargetWindowState(0, 0, false, false, false);
    }

    ImeTargetWindowState getWindowStateOrNull(IBinder windowToken) {
        ImeTargetWindowState state = this.mRequestWindowStateMap.get(windowToken);
        return state;
    }

    void setWindowState(IBinder windowToken, ImeTargetWindowState newState) {
        ImeTargetWindowState state = this.mRequestWindowStateMap.get(windowToken);
        if (state != null) goto L5;
    L9:
        setWindowStateInner(windowToken, newState);
        return;
    L5:
        if (newState.hasEditorFocused() == false) goto L9;
        if (ImeTargetWindowState.m4667$$Nest$fgetmToolType(newState) == 2) goto L8;
    L8:
        ImeTargetWindowState.m4669$$Nest$msetRequestedImeVisible(newState, ImeTargetWindowState.m4665$$Nest$fgetmRequestedImeVisible(state));
        goto L9
    }

    private void setWindowStateInner(IBinder windowToken, ImeTargetWindowState newState) {
        ProtoLog.v(ImeProtoLogGroup.IME_VIS_STATE_COMPUTER_DEBUG, "setWindowStateInner, windowToken=%s, state=%s", new Object[]{windowToken, newState});
        this.mRequestWindowStateMap.put(windowToken, newState);
    }

    ImeVisibilityResult computeState(ImeTargetWindowState state, boolean allowVisible, boolean imeRequestedVisible) {
        int softInputVisibility = ImeTargetWindowState.m4666$$Nest$fgetmSoftInputModeState(state) & 15;
        if ((ImeTargetWindowState.m4666$$Nest$fgetmSoftInputModeState(state) & FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED) != 16) goto L5;
    L8:
        boolean doAutoShow = true;
    L10:
        if ((ImeTargetWindowState.m4666$$Nest$fgetmSoftInputModeState(state) & 256) == 0) goto L12;
        boolean isForwardNavigation = true;
    L14:
        if (state.hasEditorFocused() == false) goto L20;
        if (shouldRestoreImeVisibility(state) == false) goto L20;
        ProtoLog.v(ImeProtoLogGroup.IME_VIS_STATE_COMPUTER_DEBUG, "Will show input to restore visibility", new Object[0]);
        ImeTargetWindowState.m4669$$Nest$msetRequestedImeVisible(state, true);
        setWindowStateInner(getWindowTokenFrom(state), state);
        return new ImeVisibilityResult(7, 23);
    L20:
        switch(softInputVisibility) {
            case 0: goto L40;
            case 1: goto L36;
            case 2: goto L56;
            case 3: goto L56;
            case 4: goto L29;
            case 5: goto L22;
            default: goto L56;
        };
    L22:
        ProtoLog.v(ImeProtoLogGroup.IME_VIS_STATE_COMPUTER_DEBUG, "Window asks to always show input", new Object[0]);
        if (allowVisible == true) goto L25;
        Slog.e(TAG, "SOFT_INPUT_STATE_ALWAYS_VISIBLE is ignored because there is no focused view that also returns true from View#onCheckIsTextEditor()");
        goto L56
    L25:
        if (state.hasImeFocusChanged() == false) goto L56;
        return new ImeVisibilityResult(7, 8);
    L29:
        if (isForwardNavigation == false) goto L56;
        if (allowVisible == false) goto L33;
        ProtoLog.v(ImeProtoLogGroup.IME_VIS_STATE_COMPUTER_DEBUG, "Window asks to show input going forward", new Object[0]);
        return new ImeVisibilityResult(7, 7);
    L33:
        Slog.e(TAG, "SOFT_INPUT_STATE_VISIBLE is ignored because there is no focused view that also returns true from View#onCheckIsTextEditor()");
        goto L56
    L36:
        ImeTargetWindowState lastState = getWindowStateOrNull(this.mLastImeTargetWindow);
        if (lastState == null) goto L56;
        ImeTargetWindowState.m4669$$Nest$msetRequestedImeVisible(state, ImeTargetWindowState.m4665$$Nest$fgetmRequestedImeVisible(lastState));
        goto L56
    L40:
        if (state.hasImeFocusChanged() == false) goto L50;
        if (state.hasEditorFocused() == false) goto L46;
        if (doAutoShow == true) goto L50;
        goto L50
    L46:
        if (WindowManager.LayoutParams.mayUseInputMethod(state.getWindowFlags()) == false) goto L56;
        ProtoLog.v(ImeProtoLogGroup.IME_VIS_STATE_COMPUTER_DEBUG, "Unspecified window will hide input", new Object[0]);
        return new ImeVisibilityResult(6, 12);
    L50:
        if (state.hasEditorFocused() == false) goto L56;
        if (doAutoShow == false) goto L56;
        if (isForwardNavigation == false) goto L56;
        ProtoLog.v(ImeProtoLogGroup.IME_VIS_STATE_COMPUTER_DEBUG, "Unspecified window will show input", new Object[0]);
        return new ImeVisibilityResult(7, 6);
    L56:
        if (state.hasImeFocusChanged() == true) goto L62;
        if (state.isStartInputByGainFocus() == false) goto L62;
        ProtoLog.v(ImeProtoLogGroup.IME_VIS_STATE_COMPUTER_DEBUG, "Same window without editor will hide input", new Object[0]);
        return new ImeVisibilityResult(5, 21);
    L62:
        if (state.hasEditorFocused() == false) goto L64;
        return null;
    L64:
        if (this.mInputShown == true) goto L67;
        if (imeRequestedVisible == true) goto L67;
        return null;
    L67:
        if (state.isStartInputByGainFocus() == true) goto L69;
        return null;
    L69:
        if (this.mService.mInputMethodDeviceConfigs.shouldHideImeWhenNoEditorFocus() == false) goto L76;
        ProtoLog.v(ImeProtoLogGroup.IME_VIS_STATE_COMPUTER_DEBUG, "Window without editor will hide input", new Object[0]);
        ImeTargetWindowState.m4669$$Nest$msetRequestedImeVisible(state, false);
        return new ImeVisibilityResult(5, 33);
    L76:
        return null;
    L12:
        isForwardNavigation = false;
        goto L14
    L5:
        if (this.mService.mRes.getConfiguration().isLayoutSizeAtLeast(3) == true) goto L8;
        doAutoShow = false;
        goto L10
    }

    ImeVisibilityResult onInteractiveChanged(IBinder windowToken, boolean interactive) {
        ImeTargetWindowState state = getWindowStateOrNull(windowToken);
        if (state != null) goto L5;
    L11:
        if (interactive == true) goto L13;
        return null;
    L13:
        if (this.mRequestedImeScreenshot == false) goto L18;
        this.mRequestedImeScreenshot = false;
        return new ImeVisibilityResult(8, 35);
    L18:
        return null;
    L5:
        if (state.isRequestedImeVisible() == false) goto L11;
        if (this.mInputShown == false) goto L11;
        if (interactive == true) goto L11;
        this.mRequestedImeScreenshot = true;
        return new ImeVisibilityResult(4, 34);
    }

    IBinder getWindowTokenFrom(IBinder requestImeToken, int userId) {
        Iterator<IBinder> r0 = this.mRequestWindowStateMap.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        IBinder windowToken = r0.next();
        ImeTargetWindowState state = this.mRequestWindowStateMap.get(windowToken);
        if (state.getRequestImeToken() != requestImeToken) goto L4;
        return windowToken;
    L9:
        UserData userData = this.mService.getUserData(userId);
        return userData.mImeBindingState.mFocusedWindow;
    }

    IBinder getWindowTokenFrom(ImeTargetWindowState windowState) {
        Iterator<IBinder> r0 = this.mRequestWindowStateMap.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        IBinder windowToken = r0.next();
        ImeTargetWindowState state = this.mRequestWindowStateMap.get(windowToken);
        if (state != windowState) goto L4;
        return windowToken;
    L9:
        return null;
    }

    boolean shouldRestoreImeVisibility(ImeTargetWindowState state) {
        int softInputMode = state.getSoftInputModeState();
        switch((softInputMode & 15)) {
            case 2: goto L7;
            case 3: goto L5;
            default: goto L10;
        };
    L5:
        return false;
    L7:
        if ((softInputMode & 256) == 0) goto L10;
        return false;
    L10:
        return this.mWindowManagerInternal.shouldRestoreImeVisibility(getWindowTokenFrom(state));
    }

    int getUserId() {
        return this.mUserId;
    }

    boolean isInputShown() {
        return this.mInputShown;
    }

    void setInputShown(boolean inputShown) {
        this.mInputShown = inputShown;
    }

    IBinder getLastImeTargetWindow() {
        return this.mLastImeTargetWindow;
    }

    void setLastImeTargetWindow(IBinder imeTargetWindow) {
        this.mLastImeTargetWindow = imeTargetWindow;
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        proto.write(1133871366154L, this.mRequestedShowExplicitly);
        proto.write(1133871366155L, this.mShowForced);
        proto.write(1133871366168L, this.mPolicy.isA11yRequestNoSoftKeyboard());
        proto.write(1133871366156L, this.mInputShown);
    }

    void dump(PrintWriter pw, String prefix) {
        Printer p = new PrintWriterPrinter(pw);
        p.println(prefix + "mRequestedShowExplicitly=" + this.mRequestedShowExplicitly + " mShowForced=" + this.mShowForced);
        StringBuilder r1 = new StringBuilder();
        r1.append(prefix);
        r1.append("mImeHiddenByDisplayPolicy=");
        r1.append(this.mPolicy.isImeHiddenByDisplayPolicy());
        p.println(r1.toString());
        p.println(prefix + "mInputShown=" + this.mInputShown);
        p.println(prefix + "mLastImeTargetWindow=" + this.mLastImeTargetWindow);
    }

    ImeVisibilityPolicy getImePolicy() {
        return this.mPolicy;
    }
}
