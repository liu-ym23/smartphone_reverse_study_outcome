package com.android.server.inputmethod;

import android.util.Pair;
import android.util.SparseArray;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ImeTracker;
import android.view.inputmethod.InputMethodSubtype;
import android.window.ImeOnBackInvokedDispatcher;
import com.android.internal.inputmethod.IRemoteAccessibilityInputConnection;
import com.android.internal.inputmethod.IRemoteInputConnection;
import com.android.internal.inputmethod.InputMethodSubtypeHandle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class UserData {
    final CountDownLatch mBackgroundLoadLatch;
    final InputMethodBindingController mBindingController;
    boolean mBoundToAccessibility;
    boolean mBoundToMethod;
    ClientState mCurClient;
    EditorInfo mCurEditorInfo;
    ImeOnBackInvokedDispatcher mCurImeDispatcher;
    IRemoteInputConnection mCurInputConnection;
    IRemoteAccessibilityInputConnection mCurRemoteAccessibilityInputConnection;
    ImeTracker.Token mCurStatsToken;
    SparseArray<InputMethodManagerService.AccessibilitySessionState> mEnabledAccessibilitySessions;
    InputMethodManagerService.SessionState mEnabledSession;
    final HardwareKeyboardShortcutController mHardwareKeyboardShortcutController;
    ImeBindingState mImeBindingState;
    final AtomicBoolean mImeDrawsNavBar;
    boolean mInFullscreenMode;
    final AtomicBoolean mIsUnlockingOrUnlocked;
    String mLastEnabledInputMethodsStr;
    final AtomicReference<RawInputMethodMap> mRawInputMethodMap;
    Pair<InputMethodSubtypeHandle, InputMethodSubtype> mSubtypeForKeyboardLayoutMapping;
    final InputMethodSubtypeSwitchingController mSwitchingController;
    final int mUserId;
    final ImeVisibilityStateComputer mVisibilityStateComputer;

    UserData(int userId, InputMethodBindingController bindingController, ImeVisibilityStateComputer stateComputer) {
        this.mBackgroundLoadLatch = new CountDownLatch(1);
        this.mRawInputMethodMap = new AtomicReference(RawInputMethodMap.emptyMap());
        this.mSwitchingController = new InputMethodSubtypeSwitchingController();
        this.mHardwareKeyboardShortcutController = new HardwareKeyboardShortcutController();
        this.mBoundToMethod = false;
        this.mImeBindingState = ImeBindingState.newEmptyState();
        this.mCurClient = null;
        this.mEnabledAccessibilitySessions = new SparseArray();
        this.mLastEnabledInputMethodsStr = "";
        this.mImeDrawsNavBar = new AtomicBoolean();
        this.mIsUnlockingOrUnlocked = new AtomicBoolean(false);
        this.mUserId = userId;
        this.mBindingController = bindingController;
        this.mVisibilityStateComputer = stateComputer;
    }

    public String toString() {
        return "UserData{mUserId=" + this.mUserId + '}';
    }
}
