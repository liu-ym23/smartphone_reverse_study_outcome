package com.android.server.wm;

import android.os.RemoteException;
import android.os.Trace;
import android.util.Slog;
import android.view.IDisplayChangeWindowCallback;
import android.window.DisplayAreaInfo;
import android.window.WindowContainerTransaction;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RemoteDisplayChangeController {
    private static final int REMOTE_DISPLAY_CHANGE_TIMEOUT_MS = 800;
    private static final String REMOTE_DISPLAY_CHANGE_TRACE_TAG = "RemoteDisplayChange";
    private static final String TAG = "RemoteDisplayChangeController";
    private final List<ContinueRemoteDisplayChangeCallback> mCallbacks;
    private final DisplayContent mDisplayContent;
    private final WindowManagerService mService;
    private final Runnable mTimeoutRunnable;

    /* JADX INFO: renamed from: com.android.server.wm.RemoteDisplayChangeController$1, reason: invalid class name */
    class AnonymousClass1 extends IDisplayChangeWindowCallback.Stub {
        final /* synthetic */ RemoteDisplayChangeController this$0;
        final /* synthetic */ ContinueRemoteDisplayChangeCallback val$callback;

        public static /* synthetic */ void $r8$lambda$jbxhuxi0g9KRlvDyb9BRGTABwRI(AnonymousClass1 r0, ContinueRemoteDisplayChangeCallback r1, WindowContainerTransaction r2) {
            r0.lambda$continueDisplayChange$0(r1, r2);
        }

        AnonymousClass1(RemoteDisplayChangeController this$0, ContinueRemoteDisplayChangeCallback r2) {
            this.this$0 = this$0;
            this.val$callback = r2;
        }

        public void continueDisplayChange(final WindowContainerTransaction t) {
            WindowManagerGlobalLock r0 = RemoteDisplayChangeController.m10097$$Nest$fgetmService(this.this$0).mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (RemoteDisplayChangeController.m10096$$Nest$fgetmCallbacks(this.this$0).contains(this.val$callback) == true) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            WindowManagerService.H r1 = RemoteDisplayChangeController.m10097$$Nest$fgetmService(this.this$0).mH;     // Catch: Throwable -> L9
            final ContinueRemoteDisplayChangeCallback r2 = this.val$callback;     // Catch: Throwable -> L9
            r1.post(new RemoteDisplayChangeController$1$$ExternalSyntheticLambda0(this, r2, t));     // Catch: Throwable -> L9
            RemoteDisplayChangeController.m10097$$Nest$fgetmService(this.this$0).mH.removeCallbacks(RemoteDisplayChangeController.m10098$$Nest$fgetmTimeoutRunnable(this.this$0), this.val$callback);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
        }

        private /* synthetic */ void lambda$continueDisplayChange$0(ContinueRemoteDisplayChangeCallback callback, WindowContainerTransaction t) {
            this.this$0.continueDisplayChange(callback, t);
        }
    }

    public interface ContinueRemoteDisplayChangeCallback {
        void onContinueRemoteDisplayChange(WindowContainerTransaction r1);
    }

    public static /* synthetic */ void $r8$lambda$1lcIpCspaL4JekLeuK61scSbylM(RemoteDisplayChangeController r0) {
        r0.onContinueTimedOut();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m10096$$Nest$fgetmCallbacks(RemoteDisplayChangeController r0) {
        return r0.mCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m10097$$Nest$fgetmService(RemoteDisplayChangeController r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTimeoutRunnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m10098$$Nest$fgetmTimeoutRunnable(RemoteDisplayChangeController r0) {
        return r0.mTimeoutRunnable;
    }

    RemoteDisplayChangeController(DisplayContent displayContent) {
        this.mTimeoutRunnable = new RemoteDisplayChangeController$$ExternalSyntheticLambda0(this);
        this.mCallbacks = new ArrayList();
        this.mService = displayContent.mWmService;
        this.mDisplayContent = displayContent;
    }

    public boolean isWaitingForRemoteDisplayChange() {
        return !this.mCallbacks.isEmpty();
    }

    public boolean performRemoteDisplayChange(int fromRotation, int toRotation, DisplayAreaInfo newDisplayAreaInfo, ContinueRemoteDisplayChangeCallback callback) {
        if (this.mService.mDisplayChangeController != null) goto L5;
        return false;
    L5:
        this.mCallbacks.add(callback);
        if (Trace.isTagEnabled(32) == false) goto L9;
        Trace.beginAsyncSection(REMOTE_DISPLAY_CHANGE_TRACE_TAG, callback.hashCode());
    L9:
        if (newDisplayAreaInfo != null) goto L11;
        int r4 = fromRotation;
        int r5 = toRotation;
    L15:
        IDisplayChangeWindowCallback remoteCallback = createCallback(callback);
        this.mService.mDisplayChangeController.onDisplayChange(this.mDisplayContent.mDisplayId, r4, r5, newDisplayAreaInfo, remoteCallback);     // Catch: RemoteException -> L18
        this.mService.mH.postDelayed(this.mTimeoutRunnable, callback, 800);     // Catch: RemoteException -> L18
        return 1;
    L18:
        e = move-exception;
        Slog.e(TAG, "Exception while dispatching remote display-change", e);
        this.mCallbacks.remove(callback);
        return 0;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONFIGURATION_enabled[1] == false) goto L13;
        r4 = fromRotation;
        long protoLogParam0 = r4;
        long protoLogParam1 = newDisplayAreaInfo.configuration.windowConfiguration.getMaxBounds().width();
        long protoLogParam2 = newDisplayAreaInfo.configuration.windowConfiguration.getMaxBounds().height();
        r5 = toRotation;
        long protoLogParam3 = r5;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONFIGURATION, 1736084564226683342L, 85, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2), Long.valueOf(protoLogParam3)});
        goto L15
    L13:
        r4 = fromRotation;
        r5 = toRotation;
        goto L15
    }

    private void onContinueTimedOut() {
        Slog.e(TAG, "RemoteDisplayChange timed-out, UI might get messed-up after this.");
        this.mService.mH.removeCallbacks(this.mTimeoutRunnable);
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int i = 0;
    L23:
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L6:
        if (i >= this.mCallbacks.size()) goto L16;
        ContinueRemoteDisplayChangeCallback callback = this.mCallbacks.get(i);     // Catch: Throwable -> L10
        if (i != (this.mCallbacks.size() - 1)) goto L12;
        this.mCallbacks.clear();     // Catch: Throwable -> L10
    L12:
        callback.onContinueRemoteDisplayChange(null);     // Catch: Throwable -> L10
        if (Trace.isTagEnabled(32) == false) goto L15;
        Trace.endAsyncSection(REMOTE_DISPLAY_CHANGE_TRACE_TAG, callback.hashCode());     // Catch: Throwable -> L10
    L15:
        i = i + 1;     // Catch: Throwable -> L10
        goto L23
    L16:
        onCompleted();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    private void onCompleted() {
        if (this.mDisplayContent.mWaitingForConfig == false) goto L6;
        this.mDisplayContent.sendNewConfiguration();
        return;
    }

    void continueDisplayChange(ContinueRemoteDisplayChangeCallback callback, WindowContainerTransaction transaction) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int idx = this.mCallbacks.indexOf(callback);     // Catch: Throwable -> L9
        if (idx >= 0) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        int i = 0;
    L13:
        if (i >= idx) goto L18;
        ContinueRemoteDisplayChangeCallback currentCallback = this.mCallbacks.get(i);     // Catch: Throwable -> L9
        currentCallback.onContinueRemoteDisplayChange(null);     // Catch: Throwable -> L9
        if (Trace.isTagEnabled(32) == false) goto L17;
        Trace.endAsyncSection(REMOTE_DISPLAY_CHANGE_TRACE_TAG, currentCallback.hashCode());     // Catch: Throwable -> L9
    L17:
        i = i + 1;     // Catch: Throwable -> L9
        goto L13
    L18:
        this.mCallbacks.subList(0, idx + 1).clear();     // Catch: Throwable -> L9
        boolean completed = this.mCallbacks.isEmpty();     // Catch: Throwable -> L9
        callback.onContinueRemoteDisplayChange(transaction);     // Catch: Throwable -> L9
        if (completed == false) goto L22;
        onCompleted();     // Catch: Throwable -> L9
    L22:
        if (Trace.isTagEnabled(32) == false) goto L24;
        Trace.endAsyncSection(REMOTE_DISPLAY_CHANGE_TRACE_TAG, callback.hashCode());     // Catch: Throwable -> L9
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private IDisplayChangeWindowCallback createCallback(ContinueRemoteDisplayChangeCallback callback) {
        return new AnonymousClass1(this, callback);
    }
}
