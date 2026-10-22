package com.android.server.am;

import android.app.AnrController;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
final class ErrorDialogController {
    private AnrController mAnrController;
    private List<AppNotRespondingDialog> mAnrDialogs;
    private final ProcessRecord mApp;
    private List<AppErrorDialog> mCrashDialogs;
    private final ActivityManagerGlobalLock mProcLock;
    private final ActivityManagerService mService;
    private List<StrictModeViolationDialog> mViolationDialogs;
    private AppWaitingForDebuggerDialog mWaitDialog;

    public static /* synthetic */ void $r8$lambda$PGTeWgvsb4oQ3F3N9FtHOh5cjQA(ErrorDialogController r0, List r1, Consumer r2) {
        r0.lambda$scheduleForAllDialogs$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$aGlBSBYSScon6h9jcR60ItwHWYU(ErrorDialogController r0) {
        r0.lambda$showCrashDialogs$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$wG8Rs_jBa23FnPy-dZG8oQbwrMs, reason: not valid java name */
    public static /* synthetic */ void m1514$r8$lambda$wG8Rs_jBa23FnPydZG8oQbwrMs(ErrorDialogController r0) {
        r0.lambda$showDebugWaitingDialogs$2();
    }

    boolean hasCrashDialogs() {
        if (this.mCrashDialogs == null) goto L5;
        return true;
    L5:
        return false;
    }

    List<AppErrorDialog> getCrashDialogs() {
        return this.mCrashDialogs;
    }

    boolean hasAnrDialogs() {
        if (this.mAnrDialogs == null) goto L5;
        return true;
    L5:
        return false;
    }

    List<AppNotRespondingDialog> getAnrDialogs() {
        return this.mAnrDialogs;
    }

    boolean hasViolationDialogs() {
        if (this.mViolationDialogs == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasDebugWaitingDialog() {
        if (this.mWaitDialog == null) goto L5;
        return true;
    L5:
        return false;
    }

    void clearAllErrorDialogs() {
        clearCrashDialogs();
        clearAnrDialogs();
        clearViolationDialogs();
        clearWaitingDialog();
    }

    void clearCrashDialogs() {
        clearCrashDialogs(true);
    }

    void clearCrashDialogs(boolean needDismiss) {
        if (this.mCrashDialogs != null) goto L5;
        return;
    L5:
        if (needDismiss == false) goto L7;
        scheduleForAllDialogs(this.mCrashDialogs, new ErrorDialogController$$ExternalSyntheticLambda0());
    L7:
        this.mCrashDialogs = null;
    }

    void clearAnrDialogs() {
        if (this.mAnrDialogs != null) goto L5;
        return;
    L5:
        scheduleForAllDialogs(this.mAnrDialogs, new ErrorDialogController$$ExternalSyntheticLambda0());
        this.mAnrDialogs = null;
        this.mAnrController = null;
    }

    void clearViolationDialogs() {
        if (this.mViolationDialogs != null) goto L5;
        return;
    L5:
        scheduleForAllDialogs(this.mViolationDialogs, new ErrorDialogController$$ExternalSyntheticLambda0());
        this.mViolationDialogs = null;
    }

    void clearWaitingDialog() {
        if (this.mWaitDialog != null) goto L5;
        return;
    L5:
        final BaseErrorDialog dialog = this.mWaitDialog;
        Handler r1 = this.mService.mUiHandler;
        dialog.getClass();
        r1.post(new ErrorDialogController$$ExternalSyntheticLambda2(dialog));
        this.mWaitDialog = null;
    }

    void scheduleForAllDialogs(final List<? extends BaseErrorDialog> dialogs, final Consumer<BaseErrorDialog> c) {
        this.mService.mUiHandler.post(new ErrorDialogController$$ExternalSyntheticLambda1(this, dialogs, c));
    }

    private /* synthetic */ void lambda$scheduleForAllDialogs$0(List dialogs, Consumer c) {
        if (dialogs == null) goto L5;
        forAllDialogs(dialogs, c);
        return;
    }

    void forAllDialogs(List<? extends BaseErrorDialog> dialogs, Consumer<BaseErrorDialog> c) {
        int i = dialogs.size() - 1;
    L3:
        if (i < 0) goto L6;
        c.accept(dialogs.get(i));
        i = i - 1;
        goto L3
    }

    void showCrashDialogs(AppErrorDialog.Data data) {
        List<Context> contexts = getDisplayContexts(false);
        this.mCrashDialogs = new ArrayList();
        int i = contexts.size() - 1;
    L3:
        if (i < 0) goto L5;
        Context c = contexts.get(i);
        this.mCrashDialogs.add(new AppErrorDialog(c, this.mService, data));
        i = i - 1;
        goto L3
    L5:
        this.mService.mUiHandler.post(new ErrorDialogController$$ExternalSyntheticLambda5(this));
    }

    private /* synthetic */ void lambda$showCrashDialogs$1() {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        List<AppErrorDialog> dialogs = this.mCrashDialogs;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        if (dialogs == null) goto L16;
        forAllDialogs(dialogs, new ErrorDialogController$$ExternalSyntheticLambda4());
        return;
    L16:
        return;
    L10:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    void showAnrDialogs(AppNotRespondingDialog.Data data) {
        List<Context> contexts = getDisplayContexts(this.mApp.mErrorState.isSilentAnr());
        this.mAnrDialogs = new ArrayList();
        int i = contexts.size() - 1;
    L3:
        if (i < 0) goto L5;
        Context c = contexts.get(i);
        this.mAnrDialogs.add(new AppNotRespondingDialog(this.mService, c, data));
        i = i - 1;
        goto L3
    L5:
        scheduleForAllDialogs(this.mAnrDialogs, new ErrorDialogController$$ExternalSyntheticLambda4());
    }

    void showViolationDialogs(AppErrorResult res) {
        List<Context> contexts = getDisplayContexts(false);
        this.mViolationDialogs = new ArrayList();
        int i = contexts.size() - 1;
    L3:
        if (i < 0) goto L5;
        Context c = contexts.get(i);
        this.mViolationDialogs.add(new StrictModeViolationDialog(c, this.mService, res, this.mApp));
        i = i - 1;
        goto L3
    L5:
        scheduleForAllDialogs(this.mViolationDialogs, new ErrorDialogController$$ExternalSyntheticLambda4());
    }

    void showDebugWaitingDialogs() {
        List<Context> contexts = getDisplayContexts(true);
        Context c = contexts.get(0);
        this.mWaitDialog = new AppWaitingForDebuggerDialog(this.mService, c, this.mApp);
        this.mService.mUiHandler.post(new ErrorDialogController$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$showDebugWaitingDialogs$2() {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        Dialog dialog = this.mWaitDialog;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        if (dialog == null) goto L16;
        dialog.show();
        return;
    L16:
        return;
    L10:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    AnrController getAnrController() {
        return this.mAnrController;
    }

    void setAnrController(AnrController controller) {
        this.mAnrController = controller;
    }

    private List<Context> getDisplayContexts(boolean lastUsedOnly) {
        List<Context> displayContexts = new ArrayList();
        if (lastUsedOnly == true) goto L6;
        this.mApp.getWindowProcessController().getDisplayContextsWithErrorDialogs(displayContexts);
    L6:
        if (displayContexts.isEmpty() == true) goto L9;
        if (lastUsedOnly == true) goto L9;
    L13:
        return displayContexts;
    L9:
        if (this.mService.mWmInternal == null) goto L11;
        Context r1 = this.mService.mWmInternal.getTopFocusedDisplayUiContext();
    L12:
        displayContexts.add(r1);
        goto L13
    L11:
        r1 = this.mService.mUiContext;
        goto L12
    }

    ErrorDialogController(ProcessRecord app) {
        this.mApp = app;
        this.mService = app.mService;
        this.mProcLock = this.mService.mProcLock;
    }
}
