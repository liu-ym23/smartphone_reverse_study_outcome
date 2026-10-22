package com.android.server.inputmethod;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ImeTracker;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import android.window.ImeOnBackInvokedDispatcher;
import com.android.internal.inputmethod.IBooleanListener;
import com.android.internal.inputmethod.IConnectionlessHandwritingCallback;
import com.android.internal.inputmethod.IImeTracker;
import com.android.internal.inputmethod.IInputMethodClient;
import com.android.internal.inputmethod.IRemoteAccessibilityInputConnection;
import com.android.internal.inputmethod.IRemoteInputConnection;
import com.android.internal.inputmethod.InputBindResult;
import com.android.internal.inputmethod.InputMethodInfoSafeList;
import com.android.internal.inputmethod.InputMethodSubtypeSafeList;
import com.android.internal.view.IInputMethodManager;
import com.android.internal.view.IInputMethodManagerExt;
import com.android.internal.view.IInputMethodManagerSmtEx;
import com.android.internal.view.IObricInputMethodManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class IInputMethodManagerImpl extends IInputMethodManager.Stub {
    private final Callback mCallback;

    interface Callback {
        boolean acceptStylusHandwritingDelegation(IInputMethodClient r1, int r2, String r3, String r4, int r5);

        void acceptStylusHandwritingDelegationAsync(IInputMethodClient r1, int r2, String r3, String r4, int r5, IBooleanListener r6);

        void addClient(IInputMethodClient r1, IRemoteInputConnection r2, int r3);

        void addVirtualStylusIdForTestSession(IInputMethodClient r1);

        void dump(FileDescriptor r1, PrintWriter r2, String[] r3);

        InputMethodInfo getCurrentInputMethodInfoAsUser(int r1);

        InputMethodSubtype getCurrentInputMethodSubtype(int r1);

        InputMethodInfoSafeList getEnabledInputMethodList(int r1);

        List<InputMethodInfo> getEnabledInputMethodListLegacy(int r1);

        InputMethodSubtypeSafeList getEnabledInputMethodSubtypeList(String r1, boolean r2, int r3);

        IInputMethodManagerExt getIExt();

        IObricInputMethodManager getIObricExt();

        IImeTracker getImeTrackerService();

        InputMethodInfoSafeList getInputMethodList(int r1, int r2);

        List<InputMethodInfo> getInputMethodListLegacy(int r1, int r2);

        int getInputMethodWindowVisibleHeight(IInputMethodClient r1);

        InputMethodSubtype getLastInputMethodSubtype(int r1);

        boolean hideSoftInput(IInputMethodClient r1, IBinder r2, ImeTracker.Token r3, int r4, ResultReceiver r5, int r6, boolean r7);

        void hideSoftInputFromServerForTest();

        boolean isImeTraceEnabled();

        boolean isInputMethodPickerShownForTest();

        boolean isStylusHandwritingAvailableAsUser(int r1, boolean r2);

        void onImeSwitchButtonClickFromSystem(int r1);

        void onShellCommand(FileDescriptor r1, FileDescriptor r2, FileDescriptor r3, String[] r4, ShellCallback r5, ResultReceiver r6, Binder r7);

        void prepareStylusHandwritingDelegation(IInputMethodClient r1, int r2, String r3, String r4);

        void removeImeSurface(int r1);

        void removeImeSurfaceFromWindowAsync(IBinder r1);

        void reportPerceptibleAsync(IBinder r1, boolean r2);

        void setAdditionalInputMethodSubtypes(String r1, InputMethodSubtype[] r2, int r3);

        void setExplicitlyEnabledInputMethodSubtypes(String r1, int[] r2, int r3);

        void setStylusWindowIdleTimeoutForTest(IInputMethodClient r1, long r2);

        boolean shouldShowImeSwitcherButtonForTest();

        void showInputMethodPickerFromClient(IInputMethodClient r1, int r2);

        void showInputMethodPickerFromSystem(int r1, int r2);

        boolean showSoftInput(IInputMethodClient r1, IBinder r2, ImeTracker.Token r3, int r4, int r5, ResultReceiver r6, int r7, boolean r8);

        void startConnectionlessStylusHandwriting(IInputMethodClient r1, int r2, CursorAnchorInfo r3, String r4, String r5, IConnectionlessHandwritingCallback r6);

        void startImeTrace();

        InputBindResult startInputOrWindowGainedFocus(int r1, IInputMethodClient r2, IBinder r3, int r4, int r5, int r6, EditorInfo r7, IRemoteInputConnection r8, IRemoteAccessibilityInputConnection r9, int r10, int r11, ImeOnBackInvokedDispatcher r12, boolean r13);

        void startInputOrWindowGainedFocusAsync(int r1, IInputMethodClient r2, IBinder r3, int r4, int r5, int r6, EditorInfo r7, IRemoteInputConnection r8, IRemoteAccessibilityInputConnection r9, int r10, int r11, ImeOnBackInvokedDispatcher r12, boolean r13, int r14, boolean r15);

        void startProtoDump(byte[] r1, int r2, String r3);

        void startStylusHandwriting(IInputMethodClient r1);

        void stopImeTrace();
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    @interface PermissionVerified {
        String[] allOf() default {};

        String value() default "";
    }

    private IInputMethodManagerImpl(Callback callback) {
        this.mCallback = callback;
    }

    static IInputMethodManagerImpl create(Callback callback) {
        return new IInputMethodManagerImpl(callback);
    }

    public void addClient(IInputMethodClient client, IRemoteInputConnection fallbackInputConnection, int untrustedDisplayId) {
        this.mCallback.addClient(client, fallbackInputConnection, untrustedDisplayId);
    }

    public InputMethodInfo getCurrentInputMethodInfoAsUser(int userId) {
        return this.mCallback.getCurrentInputMethodInfoAsUser(userId);
    }

    public InputMethodInfoSafeList getInputMethodList(int userId, int directBootAwareness) {
        return this.mCallback.getInputMethodList(userId, directBootAwareness);
    }

    public InputMethodInfoSafeList getEnabledInputMethodList(int userId) {
        return this.mCallback.getEnabledInputMethodList(userId);
    }

    public List<InputMethodInfo> getInputMethodListLegacy(int userId, int directBootAwareness) {
        return this.mCallback.getInputMethodListLegacy(userId, directBootAwareness);
    }

    public List<InputMethodInfo> getEnabledInputMethodListLegacy(int userId) {
        return this.mCallback.getEnabledInputMethodListLegacy(userId);
    }

    public InputMethodSubtypeSafeList getEnabledInputMethodSubtypeList(String imiId, boolean allowsImplicitlyEnabledSubtypes, int userId) {
        return this.mCallback.getEnabledInputMethodSubtypeList(imiId, allowsImplicitlyEnabledSubtypes, userId);
    }

    public InputMethodSubtype getLastInputMethodSubtype(int userId) {
        return this.mCallback.getLastInputMethodSubtype(userId);
    }

    public boolean showSoftInput(IInputMethodClient client, IBinder windowToken, ImeTracker.Token statsToken, int flags, int lastClickToolType, ResultReceiver resultReceiver, int reason, boolean async) {
        return this.mCallback.showSoftInput(client, windowToken, statsToken, flags, lastClickToolType, resultReceiver, reason, async);
    }

    public boolean hideSoftInput(IInputMethodClient client, IBinder windowToken, ImeTracker.Token statsToken, int flags, ResultReceiver resultReceiver, int reason, boolean async) {
        return this.mCallback.hideSoftInput(client, windowToken, statsToken, flags, resultReceiver, reason, async);
    }

    public void hideSoftInputFromServerForTest() {
        super.hideSoftInputFromServerForTest_enforcePermission();
        this.mCallback.hideSoftInputFromServerForTest();
    }

    public InputBindResult startInputOrWindowGainedFocus(int startInputReason, IInputMethodClient client, IBinder windowToken, int startInputFlags, int softInputMode, int windowFlags, EditorInfo editorInfo, IRemoteInputConnection inputConnection, IRemoteAccessibilityInputConnection remoteAccessibilityInputConnection, int unverifiedTargetSdkVersion, int userId, ImeOnBackInvokedDispatcher imeDispatcher, boolean imeRequestedVisible) {
        return this.mCallback.startInputOrWindowGainedFocus(startInputReason, client, windowToken, startInputFlags, softInputMode, windowFlags, editorInfo, inputConnection, remoteAccessibilityInputConnection, unverifiedTargetSdkVersion, userId, imeDispatcher, imeRequestedVisible);
    }

    public void startInputOrWindowGainedFocusAsync(int startInputReason, IInputMethodClient client, IBinder windowToken, int startInputFlags, int softInputMode, int windowFlags, EditorInfo editorInfo, IRemoteInputConnection inputConnection, IRemoteAccessibilityInputConnection remoteAccessibilityInputConnection, int unverifiedTargetSdkVersion, int userId, ImeOnBackInvokedDispatcher imeDispatcher, boolean imeRequestedVisible, int startInputSeq, boolean useAsyncShowHideMethod) {
        this.mCallback.startInputOrWindowGainedFocusAsync(startInputReason, client, windowToken, startInputFlags, softInputMode, windowFlags, editorInfo, inputConnection, remoteAccessibilityInputConnection, unverifiedTargetSdkVersion, userId, imeDispatcher, imeRequestedVisible, startInputSeq, useAsyncShowHideMethod);
    }

    public void showInputMethodPickerFromClient(IInputMethodClient client, int auxiliarySubtypeMode) {
        this.mCallback.showInputMethodPickerFromClient(client, auxiliarySubtypeMode);
    }

    public void showInputMethodPickerFromSystem(int auxiliarySubtypeMode, int displayId) {
        super.showInputMethodPickerFromSystem_enforcePermission();
        this.mCallback.showInputMethodPickerFromSystem(auxiliarySubtypeMode, displayId);
    }

    public boolean isInputMethodPickerShownForTest() {
        super.isInputMethodPickerShownForTest_enforcePermission();
        return this.mCallback.isInputMethodPickerShownForTest();
    }

    public void onImeSwitchButtonClickFromSystem(int displayId) {
        super.onImeSwitchButtonClickFromSystem_enforcePermission();
        this.mCallback.onImeSwitchButtonClickFromSystem(displayId);
    }

    public boolean shouldShowImeSwitcherButtonForTest() {
        super.shouldShowImeSwitcherButtonForTest_enforcePermission();
        return this.mCallback.shouldShowImeSwitcherButtonForTest();
    }

    public InputMethodSubtype getCurrentInputMethodSubtype(int userId) {
        return this.mCallback.getCurrentInputMethodSubtype(userId);
    }

    public void setAdditionalInputMethodSubtypes(String id, InputMethodSubtype[] subtypes, int userId) {
        this.mCallback.setAdditionalInputMethodSubtypes(id, subtypes, userId);
    }

    public void setExplicitlyEnabledInputMethodSubtypes(String imeId, int[] subtypeHashCodes, int userId) {
        this.mCallback.setExplicitlyEnabledInputMethodSubtypes(imeId, subtypeHashCodes, userId);
    }

    public int getInputMethodWindowVisibleHeight(IInputMethodClient client) {
        return this.mCallback.getInputMethodWindowVisibleHeight(client);
    }

    public void reportPerceptibleAsync(IBinder windowToken, boolean perceptible) {
        this.mCallback.reportPerceptibleAsync(windowToken, perceptible);
    }

    public void removeImeSurface(int displayId) {
        super.removeImeSurface_enforcePermission();
        this.mCallback.removeImeSurface(displayId);
    }

    public void removeImeSurfaceFromWindowAsync(IBinder windowToken) {
        this.mCallback.removeImeSurfaceFromWindowAsync(windowToken);
    }

    public void startProtoDump(byte[] protoDump, int source, String where) {
        this.mCallback.startProtoDump(protoDump, source, where);
    }

    public boolean isImeTraceEnabled() {
        return this.mCallback.isImeTraceEnabled();
    }

    public void startImeTrace() {
        super.startImeTrace_enforcePermission();
        this.mCallback.startImeTrace();
    }

    public void stopImeTrace() {
        super.stopImeTrace_enforcePermission();
        this.mCallback.stopImeTrace();
    }

    public void startStylusHandwriting(IInputMethodClient client) {
        this.mCallback.startStylusHandwriting(client);
    }

    public void startConnectionlessStylusHandwriting(IInputMethodClient client, int userId, CursorAnchorInfo cursorAnchorInfo, String delegatePackageName, String delegatorPackageName, IConnectionlessHandwritingCallback callback) {
        this.mCallback.startConnectionlessStylusHandwriting(client, userId, cursorAnchorInfo, delegatePackageName, delegatorPackageName, callback);
    }

    public void prepareStylusHandwritingDelegation(IInputMethodClient client, int userId, String delegatePackageName, String delegatorPackageName) {
        this.mCallback.prepareStylusHandwritingDelegation(client, userId, delegatePackageName, delegatorPackageName);
    }

    public boolean acceptStylusHandwritingDelegation(IInputMethodClient client, int userId, String delegatePackageName, String delegatorPackageName, int flags) {
        return this.mCallback.acceptStylusHandwritingDelegation(client, userId, delegatePackageName, delegatorPackageName, flags);
    }

    public void acceptStylusHandwritingDelegationAsync(IInputMethodClient client, int userId, String delegatePackageName, String delegatorPackageName, int flags, IBooleanListener callback) {
        this.mCallback.acceptStylusHandwritingDelegationAsync(client, userId, delegatePackageName, delegatorPackageName, flags, callback);
    }

    public boolean isStylusHandwritingAvailableAsUser(int userId, boolean connectionless) {
        return this.mCallback.isStylusHandwritingAvailableAsUser(userId, connectionless);
    }

    public void addVirtualStylusIdForTestSession(IInputMethodClient client) {
        super.addVirtualStylusIdForTestSession_enforcePermission();
        this.mCallback.addVirtualStylusIdForTestSession(client);
    }

    public void setStylusWindowIdleTimeoutForTest(IInputMethodClient client, long timeout) {
        super.setStylusWindowIdleTimeoutForTest_enforcePermission();
        this.mCallback.setStylusWindowIdleTimeoutForTest(client, timeout);
    }

    public IImeTracker getImeTrackerService() {
        return this.mCallback.getImeTrackerService();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        this.mCallback.onShellCommand(in, out, err, args, callback, resultReceiver, this);
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        this.mCallback.dump(fd, pw, args);
    }

    public IInputMethodManagerSmtEx getISmtEx() {
        return null;
    }

    public IInputMethodManagerExt getIExt() {
        return this.mCallback.getIExt();
    }

    public IObricInputMethodManager getIObricExt() throws RemoteException {
        return this.mCallback.getIObricExt();
    }
}
