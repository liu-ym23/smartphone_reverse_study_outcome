package com.android.server.inputmethod;

import android.os.Binder;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandleSmtEx;
import android.util.Slog;
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
import com.android.internal.util.FunctionalUtils;
import com.android.internal.view.IInputMethodManagerExt;
import com.android.internal.view.IObricInputMethodManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class ZeroJankProxy implements IInputMethodManagerImpl.Callback {
    private final Executor mExecutor;
    private final Callback mInner;

    interface Callback extends IInputMethodManagerImpl.Callback {
        ClientState getClientStateLocked(IInputMethodClient r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$2-twf30KVNWRngVw1aZPUvQ5GWM, reason: not valid java name */
    public static /* synthetic */ void m4791$r8$lambda$2twf30KVNWRngVw1aZPUvQ5GWM(ZeroJankProxy r0, IInputMethodClient r1, int r2, String r3, String r4, int r5, IBooleanListener r6) {
        r0.lambda$acceptStylusHandwritingDelegationAsync$11(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$5NCeGEQRBWokR2A7BJ1qFrtWRfc(ZeroJankProxy r0, IInputMethodClient r1, IBinder r2, ImeTracker.Token r3, int r4, int r5, ResultReceiver r6, int r7, boolean r8) {
        r0.lambda$showSoftInput$2(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: $r8$lambda$JGNc0QCBlRh6POjKVGdx2uRA-Z8, reason: not valid java name */
    public static /* synthetic */ void m4792$r8$lambda$JGNc0QCBlRh6POjKVGdx2uRAZ8(ZeroJankProxy r0, int r1, IInputMethodClient r2, IBinder r3, int r4, int r5, int r6, EditorInfo r7, IRemoteInputConnection r8, IRemoteAccessibilityInputConnection r9, int r10, int r11, ImeOnBackInvokedDispatcher r12, boolean r13, int r14) {
        r0.lambda$startInputOrWindowGainedFocusAsync$6(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    /* JADX INFO: renamed from: $r8$lambda$NGfwIqt2TkCLOc8HU8vX-EC6LuU, reason: not valid java name */
    public static /* synthetic */ Boolean m4793$r8$lambda$NGfwIqt2TkCLOc8HU8vXEC6LuU(ZeroJankProxy r0, IInputMethodClient r1, IBinder r2, ImeTracker.Token r3, int r4, ResultReceiver r5, int r6, boolean r7) {
        return r0.lambda$hideSoftInput$5(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: $r8$lambda$TA8Vd-sD1J1ATiZWjgM_VQy-ZNQ, reason: not valid java name */
    public static /* synthetic */ Boolean m4794$r8$lambda$TA8VdsD1J1ATiZWjgM_VQyZNQ(ZeroJankProxy r0, IInputMethodClient r1, IBinder r2, ImeTracker.Token r3, int r4, int r5, ResultReceiver r6, int r7, boolean r8) {
        return r0.lambda$showSoftInput$3(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ void $r8$lambda$UjtKovzrmi9qxLTiOWYxY50ugFI(ZeroJankProxy r0, IInputMethodClient r1) {
        r0.lambda$startStylusHandwriting$8(r1);
    }

    public static /* synthetic */ void $r8$lambda$WUdtZ2tp1_iIb2R8Q6G3Q0hd1Kg(long r0, Runnable r2) {
        lambda$offloadInner$0(r0, r2);
    }

    public static /* synthetic */ void $r8$lambda$dCAVl6gJgiis2qp06kEUsj6XrcQ(ZeroJankProxy r0, IInputMethodClient r1, int r2, CursorAnchorInfo r3, String r4, String r5, IConnectionlessHandwritingCallback r6) {
        r0.lambda$startConnectionlessStylusHandwriting$9(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$nNYYVmwGhx_L8q2hS7pl-XHl0gM, reason: not valid java name */
    public static /* synthetic */ Boolean m4795$r8$lambda$nNYYVmwGhx_L8q2hS7plXHl0gM(ZeroJankProxy r0, IInputMethodClient r1, int r2, String r3, String r4, int r5) {
        return r0.lambda$acceptStylusHandwritingDelegation$10(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$r10Pq3FDN1i-ox3lWCysTXCduXc, reason: not valid java name */
    public static /* synthetic */ void m4796$r8$lambda$r10Pq3FDN1iox3lWCysTXCduXc(ZeroJankProxy r0, IInputMethodClient r1, int r2, String r3, String r4) {
        r0.lambda$prepareStylusHandwritingDelegation$12(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$rj4kFTQMxZfX9Hd6xXzDHyNQAPs(ZeroJankProxy r0, IInputMethodClient r1, IBinder r2, ImeTracker.Token r3, int r4, ResultReceiver r5, int r6, boolean r7) {
        r0.lambda$hideSoftInput$4(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: $r8$lambda$rp2V_xQZve-BllSUG-MH3fgFE0s, reason: not valid java name */
    public static /* synthetic */ void m4797$r8$lambda$rp2V_xQZveBllSUGMH3fgFE0s(ZeroJankProxy r0, IInputMethodClient r1, IRemoteInputConnection r2, int r3) {
        r0.lambda$addClient$1(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$sBdBMotnFDZmWkfXujx49NYMzrs(ZeroJankProxy r0, IInputMethodClient r1, int r2) {
        r0.lambda$showInputMethodPickerFromClient$7(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$zwm76fC1ViRWLhoJV04CSZFLpTM(ZeroJankProxy r0, Runnable r1) {
        r0.offload(r1);
    }

    ZeroJankProxy(Executor executor, Callback inner) {
        this.mInner = inner;
        this.mExecutor = executor;
    }

    private void offload(FunctionalUtils.ThrowingRunnable r) {
        offloadInner(r);
    }

    private void offload(Runnable r) {
        offloadInner(r);
    }

    private void offloadInner(final Runnable r) {
        final long identity = Binder.clearCallingIdentity();
        this.mExecutor.execute(new ZeroJankProxy$$ExternalSyntheticLambda13(identity, r));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private static /* synthetic */ void lambda$offloadInner$0(long identity, Runnable r) {
        long inner = Binder.clearCallingIdentity();
        Binder.restoreCallingIdentity(identity);
        r.run();     // Catch: Throwable -> L5 Exception -> L7
    L9:
        Binder.restoreCallingIdentity(inner);
        return;
    L7:
        e = move-exception;
        Slog.e("InputMethodManagerService", "Error in async IMMS call", e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        Binder.restoreCallingIdentity(inner);
        throw th;
    }

    private /* synthetic */ void lambda$addClient$1(IInputMethodClient client, IRemoteInputConnection fallbackInputConnection, int selfReportedDisplayId) throws Exception {
        this.mInner.addClient(client, fallbackInputConnection, selfReportedDisplayId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void addClient(final IInputMethodClient client, final IRemoteInputConnection fallbackInputConnection, final int selfReportedDisplayId) {
        offload(new ZeroJankProxy$$ExternalSyntheticLambda12(this, client, fallbackInputConnection, selfReportedDisplayId));
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodInfo getCurrentInputMethodInfoAsUser(int userId) {
        return this.mInner.getCurrentInputMethodInfoAsUser(userId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodInfoSafeList getInputMethodList(int userId, int directBootAwareness) {
        return this.mInner.getInputMethodList(userId, directBootAwareness);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodInfoSafeList getEnabledInputMethodList(int userId) {
        return this.mInner.getEnabledInputMethodList(userId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public List<InputMethodInfo> getInputMethodListLegacy(int userId, int directBootAwareness) {
        return this.mInner.getInputMethodListLegacy(userId, directBootAwareness);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public List<InputMethodInfo> getEnabledInputMethodListLegacy(int userId) {
        return this.mInner.getEnabledInputMethodListLegacy(userId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodSubtypeSafeList getEnabledInputMethodSubtypeList(String imiId, boolean allowsImplicitlyEnabledSubtypes, int userId) {
        return this.mInner.getEnabledInputMethodSubtypeList(imiId, allowsImplicitlyEnabledSubtypes, userId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodSubtype getLastInputMethodSubtype(int userId) {
        return this.mInner.getLastInputMethodSubtype(userId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean showSoftInput(final IInputMethodClient client, final IBinder windowToken, final ImeTracker.Token statsToken, final int flags, final int lastClickToolType, final ResultReceiver resultReceiver, final int reason, final boolean async) {
        if (async == false) goto L5;
        offload(new ZeroJankProxy$$ExternalSyntheticLambda10(this, client, windowToken, statsToken, flags, lastClickToolType, resultReceiver, reason, async));
        return true;
    L5:
        CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(new ZeroJankProxy$$ExternalSyntheticLambda11(this, client, windowToken, statsToken, flags, lastClickToolType, resultReceiver, reason, async), new ZeroJankProxy$$ExternalSyntheticLambda4(this));
        return future.completeOnTimeout(false, 1, TimeUnit.SECONDS).join().booleanValue();
    }

    private /* synthetic */ void lambda$showSoftInput$2(IInputMethodClient client, IBinder windowToken, ImeTracker.Token statsToken, int flags, int lastClickToolType, ResultReceiver resultReceiver, int reason, boolean async) throws Exception {
        this.mInner.showSoftInput(client, windowToken, statsToken, flags, lastClickToolType, resultReceiver, reason, async);
    }

    private /* synthetic */ Boolean lambda$showSoftInput$3(IInputMethodClient client, IBinder windowToken, ImeTracker.Token statsToken, int flags, int lastClickToolType, ResultReceiver resultReceiver, int reason, boolean async) {
        return Boolean.valueOf(this.mInner.showSoftInput(client, windowToken, statsToken, flags, lastClickToolType, resultReceiver, reason, async));
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean hideSoftInput(final IInputMethodClient client, final IBinder windowToken, final ImeTracker.Token statsToken, final int flags, final ResultReceiver resultReceiver, final int reason, final boolean async) {
        if (async == false) goto L5;
        offload(new ZeroJankProxy$$ExternalSyntheticLambda2(this, client, windowToken, statsToken, flags, resultReceiver, reason, async));
        return true;
    L5:
        CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(new ZeroJankProxy$$ExternalSyntheticLambda3(this, client, windowToken, statsToken, flags, resultReceiver, reason, async), new ZeroJankProxy$$ExternalSyntheticLambda4(this));
        return future.completeOnTimeout(false, 1, TimeUnit.SECONDS).join().booleanValue();
    }

    private /* synthetic */ void lambda$hideSoftInput$4(IInputMethodClient client, IBinder windowToken, ImeTracker.Token statsToken, int flags, ResultReceiver resultReceiver, int reason, boolean async) throws Exception {
        this.mInner.hideSoftInput(client, windowToken, statsToken, flags, resultReceiver, reason, async);
    }

    private /* synthetic */ Boolean lambda$hideSoftInput$5(IInputMethodClient client, IBinder windowToken, ImeTracker.Token statsToken, int flags, ResultReceiver resultReceiver, int reason, boolean async) {
        return Boolean.valueOf(this.mInner.hideSoftInput(client, windowToken, statsToken, flags, resultReceiver, reason, async));
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void hideSoftInputFromServerForTest() {
        this.mInner.hideSoftInputFromServerForTest();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void startInputOrWindowGainedFocusAsync(final int startInputReason, final IInputMethodClient client, final IBinder windowToken, final int startInputFlags, final int softInputMode, final int windowFlags, final EditorInfo editorInfo, final IRemoteInputConnection inputConnection, final IRemoteAccessibilityInputConnection remoteAccessibilityInputConnection, final int unverifiedTargetSdkVersion, final int userId, final ImeOnBackInvokedDispatcher imeDispatcher, final boolean imeRequestedVisible, final int startInputSeq, boolean useAsyncShowHideMethod) {
        offload(new ZeroJankProxy$$ExternalSyntheticLambda8(this, startInputReason, client, windowToken, startInputFlags, softInputMode, windowFlags, editorInfo, inputConnection, remoteAccessibilityInputConnection, unverifiedTargetSdkVersion, userId, imeDispatcher, imeRequestedVisible, startInputSeq));
    }

    private /* synthetic */ void lambda$startInputOrWindowGainedFocusAsync$6(int startInputReason, IInputMethodClient client, IBinder windowToken, int startInputFlags, int softInputMode, int windowFlags, EditorInfo editorInfo, IRemoteInputConnection inputConnection, IRemoteAccessibilityInputConnection remoteAccessibilityInputConnection, int unverifiedTargetSdkVersion, int userId, ImeOnBackInvokedDispatcher imeDispatcher, boolean imeRequestedVisible, int startInputSeq) throws Exception {
        InputBindResult result = this.mInner.startInputOrWindowGainedFocus(startInputReason, client, windowToken, startInputFlags, softInputMode, windowFlags, editorInfo, inputConnection, remoteAccessibilityInputConnection, unverifiedTargetSdkVersion, userId, imeDispatcher, imeRequestedVisible);
        sendOnStartInputResult(client, result, startInputSeq);
        if (result.result != 1) goto L18;
        InputMethodManagerService imms = (InputMethodManagerService) this.mInner;
        monitor-enter(ImfLock.class);
        ClientState cs = imms.getClientStateLocked(client);     // Catch: Throwable -> L12
        if (cs == null) goto L14;
        int tmpUserId = userId;
        if (UserHandleSmtEx.isUserDoppelganger(userId) == false) goto L11;
        tmpUserId = 0;
    L11:
        imms.requestClientSessionLocked(cs, tmpUserId);     // Catch: Throwable -> L12
        imms.requestClientSessionForAccessibilityLocked(cs);     // Catch: Throwable -> L12
    L14:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputBindResult startInputOrWindowGainedFocus(int startInputReason, IInputMethodClient client, IBinder windowToken, int startInputFlags, int softInputMode, int windowFlags, EditorInfo editorInfo, IRemoteInputConnection inputConnection, IRemoteAccessibilityInputConnection remoteAccessibilityInputConnection, int unverifiedTargetSdkVersion, int userId, ImeOnBackInvokedDispatcher imeDispatcher, boolean imeRequestedVisible) {
        return null;
    }

    private /* synthetic */ void lambda$showInputMethodPickerFromClient$7(IInputMethodClient client, int auxiliarySubtypeMode) throws Exception {
        this.mInner.showInputMethodPickerFromClient(client, auxiliarySubtypeMode);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void showInputMethodPickerFromClient(final IInputMethodClient client, final int auxiliarySubtypeMode) {
        offload(new ZeroJankProxy$$ExternalSyntheticLambda6(this, client, auxiliarySubtypeMode));
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void showInputMethodPickerFromSystem(int auxiliarySubtypeMode, int displayId) {
        this.mInner.showInputMethodPickerFromSystem(auxiliarySubtypeMode, displayId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean isInputMethodPickerShownForTest() {
        return this.mInner.isInputMethodPickerShownForTest();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void onImeSwitchButtonClickFromSystem(int displayId) {
        this.mInner.onImeSwitchButtonClickFromSystem(displayId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean shouldShowImeSwitcherButtonForTest() {
        return this.mInner.shouldShowImeSwitcherButtonForTest();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public InputMethodSubtype getCurrentInputMethodSubtype(int userId) {
        return this.mInner.getCurrentInputMethodSubtype(userId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void setAdditionalInputMethodSubtypes(String imiId, InputMethodSubtype[] subtypes, int userId) {
        this.mInner.setAdditionalInputMethodSubtypes(imiId, subtypes, userId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void setExplicitlyEnabledInputMethodSubtypes(String imeId, int[] subtypeHashCodes, int userId) {
        this.mInner.setExplicitlyEnabledInputMethodSubtypes(imeId, subtypeHashCodes, userId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public int getInputMethodWindowVisibleHeight(IInputMethodClient client) {
        return this.mInner.getInputMethodWindowVisibleHeight(client);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void reportPerceptibleAsync(IBinder windowToken, boolean perceptible) {
        this.mInner.reportPerceptibleAsync(windowToken, perceptible);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void removeImeSurface(int displayId) {
        this.mInner.removeImeSurface(displayId);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void removeImeSurfaceFromWindowAsync(IBinder windowToken) {
        this.mInner.removeImeSurfaceFromWindowAsync(windowToken);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void startProtoDump(byte[] bytes, int i, String s) {
        this.mInner.startProtoDump(bytes, i, s);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean isImeTraceEnabled() {
        return this.mInner.isImeTraceEnabled();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void startImeTrace() {
        this.mInner.startImeTrace();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void stopImeTrace() {
        this.mInner.stopImeTrace();
    }

    private /* synthetic */ void lambda$startStylusHandwriting$8(IInputMethodClient client) throws Exception {
        this.mInner.startStylusHandwriting(client);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void startStylusHandwriting(final IInputMethodClient client) {
        offload(new ZeroJankProxy$$ExternalSyntheticLambda7(this, client));
    }

    private /* synthetic */ void lambda$startConnectionlessStylusHandwriting$9(IInputMethodClient client, int userId, CursorAnchorInfo cursorAnchorInfo, String delegatePackageName, String delegatorPackageName, IConnectionlessHandwritingCallback callback) throws Exception {
        this.mInner.startConnectionlessStylusHandwriting(client, userId, cursorAnchorInfo, delegatePackageName, delegatorPackageName, callback);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void startConnectionlessStylusHandwriting(final IInputMethodClient client, final int userId, final CursorAnchorInfo cursorAnchorInfo, final String delegatePackageName, final String delegatorPackageName, final IConnectionlessHandwritingCallback callback) {
        offload(new ZeroJankProxy$$ExternalSyntheticLambda0(this, client, userId, cursorAnchorInfo, delegatePackageName, delegatorPackageName, callback));
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean acceptStylusHandwritingDelegation(final IInputMethodClient client, final int userId, final String delegatePackageName, final String delegatorPackageName, final int flags) {
    L20:
        return ((Boolean) CompletableFuture.supplyAsync(new ZeroJankProxy$$ExternalSyntheticLambda9(this, client, userId, delegatePackageName, delegatorPackageName, flags), new ZeroJankProxy$$ExternalSyntheticLambda4(this)).get()).booleanValue();
    L8:
        e = move-exception;
        InterruptedException e = e;
    L16:
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    L6:
        e = move-exception;
        ExecutionException e2 = e;
    L13:
        throw new RuntimeException(e2);
    L14:
        e = move-exception;
        e = e;
    L10:
        e = move-exception;
        e2 = e;
        goto L13
    }

    private /* synthetic */ Boolean lambda$acceptStylusHandwritingDelegation$10(IInputMethodClient client, int userId, String delegatePackageName, String delegatorPackageName, int flags) {
        return Boolean.valueOf(this.mInner.acceptStylusHandwritingDelegation(client, userId, delegatePackageName, delegatorPackageName, flags));
    }

    private /* synthetic */ void lambda$acceptStylusHandwritingDelegationAsync$11(IInputMethodClient client, int userId, String delegatePackageName, String delegatorPackageName, int flags, IBooleanListener callback) throws Exception {
        this.mInner.acceptStylusHandwritingDelegationAsync(client, userId, delegatePackageName, delegatorPackageName, flags, callback);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void acceptStylusHandwritingDelegationAsync(final IInputMethodClient client, final int userId, final String delegatePackageName, final String delegatorPackageName, final int flags, final IBooleanListener callback) {
        offload(new ZeroJankProxy$$ExternalSyntheticLambda1(this, client, userId, delegatePackageName, delegatorPackageName, flags, callback));
    }

    private /* synthetic */ void lambda$prepareStylusHandwritingDelegation$12(IInputMethodClient client, int userId, String delegatePackageName, String delegatorPackageName) throws Exception {
        this.mInner.prepareStylusHandwritingDelegation(client, userId, delegatePackageName, delegatorPackageName);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void prepareStylusHandwritingDelegation(final IInputMethodClient client, final int userId, final String delegatePackageName, final String delegatorPackageName) {
        offload(new ZeroJankProxy$$ExternalSyntheticLambda5(this, client, userId, delegatePackageName, delegatorPackageName));
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public boolean isStylusHandwritingAvailableAsUser(int userId, boolean connectionless) {
        return this.mInner.isStylusHandwritingAvailableAsUser(userId, connectionless);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void addVirtualStylusIdForTestSession(IInputMethodClient client) {
        this.mInner.addVirtualStylusIdForTestSession(client);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void setStylusWindowIdleTimeoutForTest(IInputMethodClient client, long timeout) {
        this.mInner.setStylusWindowIdleTimeoutForTest(client, timeout);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public IImeTracker getImeTrackerService() {
        return this.mInner.getImeTrackerService();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver, Binder self) {
        this.mInner.onShellCommand(in, out, err, args, callback, resultReceiver, self);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        this.mInner.dump(fd, fout, args);
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public IInputMethodManagerExt getIExt() {
        InputMethodManagerService imms = (InputMethodManagerService) this.mInner;
        return imms.getIExt();
    }

    @Override // com.android.server.inputmethod.IInputMethodManagerImpl.Callback
    public IObricInputMethodManager getIObricExt() {
        InputMethodManagerService imms = (InputMethodManagerService) this.mInner;
        return imms.getIObricExt();
    }

    private void sendOnStartInputResult(IInputMethodClient client, InputBindResult res, int startInputSeq) {
        monitor-enter(ImfLock.class);
        ClientState cs = this.mInner.getClientStateLocked(client);     // Catch: Throwable -> L7
        if (cs == null) goto L9;
        cs.mClient.onStartInputResult(res, startInputSeq);     // Catch: Throwable -> L7
    L10:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L7
        return;
    L9:
        Slog.i("InputMethodManagerService", "Client that requested startInputOrWindowGainedFocus is no longer bound. InputBindResult: " + res + " for startInputSeq: " + startInputSeq);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
