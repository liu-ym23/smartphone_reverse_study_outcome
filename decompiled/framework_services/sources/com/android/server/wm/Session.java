package com.android.server.wm;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.ActivityMetricsData;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.content.pm.ShortcutServiceInternal;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Slog;
import android.view.IWindow;
import android.view.IWindowId;
import android.view.IWindowSession;
import android.view.IWindowSessionCallback;
import android.view.IWindowSessionSmtEx;
import android.view.InputChannel;
import android.view.InsetsSourceControl;
import android.view.InsetsState;
import android.view.SurfaceControl;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowRelayoutResult;
import android.view.inputmethod.ImeTracker;
import android.window.InputTransferToken;
import android.window.OnBackInvokedCallbackInfo;
import com.android.internal.os.logging.MetricsLoggerWrapper;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.LocalServices;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes3.dex */
class Session extends IWindowSession.Stub implements IBinder.DeathRecipient {
    private final ArrayList<WindowState> mAddedWindows;
    private AlertWindowNotification mAlertWindowNotification;
    private final ArraySet<WindowState> mAlertWindows;
    final IWindowSessionCallback mCallback;
    final boolean mCanAddInternalSystemWindow;
    final boolean mCanAlwaysUpdateWallpaper;
    final boolean mCanCreateSystemApplicationOverlay;
    boolean mCanForceShowingInsets;
    final boolean mCanHideNonSystemOverlayWindows;
    final boolean mCanSetUnrestrictedGestureExclusion;
    private final boolean mCanStartTasksFromRecents;
    private boolean mClientDead;
    private final DragDropController mDragDropController;
    private final InsetsSourceControl.Array mDummyControls;
    private float mLastReportedAnimatorScale;
    protected String mPackageName;
    final int mPid;
    final WindowProcessController mProcess;
    private String mRelayoutTag;
    final WindowManagerService mService;
    final boolean mSetsUnrestrictedKeepClearAreas;
    private boolean mShowingAlertWindowNotificationAllowed;
    private final SessionSmtEx mSmtEx;
    private final String mStringName;
    final int mUid;

    public static /* synthetic */ void $r8$lambda$4BBKIi4FUrFxabKrdpy3ixXUGHE(IBinder r0, WallpaperController r1, WindowState r2) {
        lambda$wallpaperOffsetsComplete$3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$71MlbzHo9XQfq1o5frufHv-e65Q, reason: not valid java name */
    public static /* synthetic */ void m10137$r8$lambda$71MlbzHo9XQfq1o5frufHve65Q(boolean r0, WallpaperController r1, WindowState r2) {
        lambda$setShouldZoomOutWallpaper$2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$F9kDlT0jqppzrfLV5sjvg4-EJcU, reason: not valid java name */
    public static /* synthetic */ void m10138$r8$lambda$F9kDlT0jqppzrfLV5sjvg4EJcU(float r0, float r1, float r2, float r3, WallpaperController r4, WindowState r5) {
        lambda$setWallpaperPosition$0(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$KGk0Cvr6TVDYTfgJBINwLdTdv1c(float r0, WallpaperController r1, WindowState r2) {
        lambda$setWallpaperZoomOut$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ZslRXr7RJzPLxOKJwfJKhi4Z2WQ(IBinder r0, WallpaperController r1, WindowState r2) {
        lambda$wallpaperCommandComplete$5(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$glmJbfGvXNVgymktdm1zFUjjKJM(int r0, int r1, WallpaperController r2, WindowState r3) {
        lambda$setWallpaperDisplayOffset$4(r0, r1, r2, r3);
    }

    public Session(WindowManagerService service, IWindowSessionCallback callback) {
        this(service, callback, Binder.getCallingPid(), Binder.getCallingUid());
    }

    Session(WindowManagerService service, IWindowSessionCallback callback, int callingPid, int callingUid) {
        this.mAddedWindows = new ArrayList();
        this.mAlertWindows = new ArraySet();
        this.mClientDead = false;
        this.mDummyControls = new InsetsSourceControl.Array();
        this.mSmtEx = new SessionSmtEx(this);
        this.mService = service;
        this.mCallback = callback;
        this.mPid = callingPid;
        this.mUid = callingUid;
        WindowManagerGlobalLock r1 = service.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mLastReportedAnimatorScale = service.getCurrentAnimatorScale();     // Catch: Throwable -> L58
        this.mProcess = service.mAtmService.mProcessMap.getProcess(this.mPid);     // Catch: Throwable -> L58
        monitor-exit(r1);     // Catch: Throwable -> L58
        WindowManagerService.resetPriorityAfterLockedSection();
        if (this.mProcess == null) goto L57;
        if (service.mContext.checkCallingOrSelfPermission("android.permission.INTERNAL_SYSTEM_WINDOW") != 0) goto L11;
        boolean r2 = true;
    L12:
        this.mCanAddInternalSystemWindow = r2;
        if (service.mAtmService.isCallerRecents(this.mUid) == false) goto L15;
    L18:
        boolean r3 = true;
    L19:
        this.mCanForceShowingInsets = r3;
        if (service.mContext.checkCallingOrSelfPermission("android.permission.HIDE_NON_SYSTEM_OVERLAY_WINDOWS") != 0) goto L22;
    L25:
        boolean r4 = true;
    L26:
        this.mCanHideNonSystemOverlayWindows = r4;
        if (service.mContext.checkCallingOrSelfPermission("android.permission.SYSTEM_APPLICATION_OVERLAY") != 0) goto L29;
        boolean r5 = true;
    L30:
        this.mCanCreateSystemApplicationOverlay = r5;
        if (service.mContext.checkCallingOrSelfPermission("android.permission.START_TASKS_FROM_RECENTS") != 0) goto L33;
        boolean r6 = true;
    L34:
        this.mCanStartTasksFromRecents = r6;
        if (service.mContext.checkCallingOrSelfPermission("android.permission.SET_UNRESTRICTED_KEEP_CLEAR_AREAS") != 0) goto L37;
        boolean r7 = true;
    L38:
        this.mSetsUnrestrictedKeepClearAreas = r7;
        if (service.mContext.checkCallingOrSelfPermission("android.permission.SET_UNRESTRICTED_GESTURE_EXCLUSION") != 0) goto L41;
        boolean r8 = true;
    L42:
        this.mCanSetUnrestrictedGestureExclusion = r8;
        if (service.mContext.checkCallingOrSelfPermission("android.permission.ALWAYS_UPDATE_WALLPAPER") != 0) goto L45;
        boolean r9 = true;
    L46:
        this.mCanAlwaysUpdateWallpaper = r9;
        this.mShowingAlertWindowNotificationAllowed = this.mService.mShowAlertWindowNotifications;
        this.mDragDropController = this.mService.mDragDropController;
        StringBuilder sb = new StringBuilder();
        sb.append("Session{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" ");
        sb.append(this.mPid);
        if (this.mUid >= 10000) goto L49;
        sb.append(":");
        sb.append(this.mUid);
    L50:
        sb.append("}");
        this.mStringName = sb.toString();
        this.mCallback.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L53
        return;
    L54:
        this.mClientDead = true;
        return;
    L49:
        sb.append(":u");
        sb.append(UserHandle.getUserId(this.mUid));
        sb.append('a');
        sb.append(UserHandle.getAppId(this.mUid));
        goto L50
    L45:
        r9 = false;
        goto L46
    L41:
        r8 = false;
        goto L42
    L37:
        r7 = false;
        goto L38
    L33:
        r6 = false;
        goto L34
    L29:
        r5 = false;
        goto L30
    L22:
        if (service.mContext.checkCallingOrSelfPermission("android.permission.HIDE_OVERLAY_WINDOWS") == 0) goto L25;
        r4 = false;
        goto L26
    L15:
        if (service.mContext.checkCallingOrSelfPermission("android.permission.STATUS_BAR_SERVICE") == 0) goto L18;
        r3 = false;
        goto L19
    L11:
        r2 = false;
        goto L12
    L57:
        throw new IllegalStateException("Unknown pid=" + this.mPid + " uid=" + this.mUid);
    L58:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.onTransact(code, data, reply, flags);
    L4:
        e = move-exception;
        if ((e instanceof SecurityException) == true) goto L8;
        Slog.w("WindowManager", "Window Session Crash", e);
    L8:
        throw e;
    }

    boolean isClientDead() {
        return this.mClientDead;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mCallback.asBinder().unlinkToDeath(this, 0);     // Catch: Throwable -> L21
        this.mClientDead = true;     // Catch: Throwable -> L21
        int i = this.mAddedWindows.size() - 1;     // Catch: Throwable -> L12
    L6:
        if (i < 0) goto L17;
        WindowState w = this.mAddedWindows.get(i);     // Catch: Throwable -> L12
        Slog.i("WindowManager", "WIN DEATH: " + w);     // Catch: Throwable -> L12
        if (w.mActivityRecord != null) goto L10;
    L14:
        w.removeIfPossible();     // Catch: Throwable -> L12
        i = i - 1;
        goto L6
    L10:
        if (w.mActivityRecord.findMainWindow() != w) goto L14;
        this.mService.mSnapshotController.onAppDied(w.mActivityRecord);     // Catch: Throwable -> L12
        goto L14
    L17:
        killSessionLocked();     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        killSessionLocked();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public int addToDisplay(IWindow window, WindowManager.LayoutParams attrs, int viewVisibility, int displayId, int requestedVisibleTypes, InputChannel outInputChannel, InsetsState outInsetsState, InsetsSourceControl.Array outActiveControls, Rect outAttachedFrame, float[] outSizeCompatScale) {
        return this.mService.addWindow(this, window, attrs, viewVisibility, displayId, UserHandle.getUserId(this.mUid), requestedVisibleTypes, outInputChannel, outInsetsState, outActiveControls, outAttachedFrame, outSizeCompatScale);
    }

    public int addToDisplayAsUser(IWindow window, WindowManager.LayoutParams attrs, int viewVisibility, int displayId, int userId, int requestedVisibleTypes, InputChannel outInputChannel, InsetsState outInsetsState, InsetsSourceControl.Array outActiveControls, Rect outAttachedFrame, float[] outSizeCompatScale) {
        return this.mService.addWindow(this, window, attrs, viewVisibility, displayId, userId, requestedVisibleTypes, outInputChannel, outInsetsState, outActiveControls, outAttachedFrame, outSizeCompatScale);
    }

    public int addToDisplayWithoutInputChannel(IWindow window, WindowManager.LayoutParams attrs, int viewVisibility, int displayId, InsetsState outInsetsState, Rect outAttachedFrame, float[] outSizeCompatScale) {
        return this.mService.addWindow(this, window, attrs, viewVisibility, displayId, UserHandle.getUserId(this.mUid), WindowInsets.Type.defaultVisible(), null, outInsetsState, this.mDummyControls, outAttachedFrame, outSizeCompatScale);
    }

    public void remove(IBinder clientToken) {
        this.mService.removeClientToken(this, clientToken);
    }

    public boolean cancelDraw(IWindow window) {
        return this.mService.cancelDraw(this, window);
    }

    public int relayout(IWindow window, WindowManager.LayoutParams attrs, int requestedWidth, int requestedHeight, int viewFlags, int flags, int seq, int lastSyncSeqId, WindowRelayoutResult outRelayoutResult) {
        Trace.traceBegin(32, this.mRelayoutTag);
        int res = this.mService.relayoutWindow(this, window, attrs, requestedWidth, requestedHeight, viewFlags, flags, seq, lastSyncSeqId, outRelayoutResult);
        Trace.traceEnd(32);
        return res;
    }

    public void relayoutAsync(IWindow window, WindowManager.LayoutParams attrs, int requestedWidth, int requestedHeight, int viewFlags, int flags, int seq, int lastSyncSeqId) {
        relayout(window, attrs, requestedWidth, requestedHeight, viewFlags, flags, seq, lastSyncSeqId, null);
    }

    public boolean outOfMemory(IWindow window) {
        return this.mService.outOfMemoryWindow(this, window);
    }

    public void setInsets(IWindow window, int touchableInsets, Rect contentInsets, Rect visibleInsets, Region touchableArea) {
        this.mService.setInsetsWindow(this, window, touchableInsets, contentInsets, visibleInsets, touchableArea);
    }

    public void clearTouchableRegion(IWindow window) {
        this.mService.clearTouchableRegion(this, window);
    }

    public void finishDrawing(IWindow window, SurfaceControl.Transaction postDrawTransaction, int seqId) {
        if (WindowManagerDebugConfig.DEBUG == false) goto L6;
        Slog.v("WindowManager", "IWindow finishDrawing called for " + window);
    L6:
        if (Trace.isTagEnabled(32) == false) goto L8;
        Trace.traceBegin(32, "finishDrawing: " + this.mPackageName);
    L8:
        this.mService.finishDrawingWindow(this, window, postDrawTransaction, seqId);
        Trace.traceEnd(32);
    }

    public void finishDrawingWithMetrics(IWindow window, SurfaceControl.Transaction postDrawTransaction, int seqId, ActivityMetricsData data) {
        if (WindowManagerDebugConfig.DEBUG == false) goto L5;
        Slog.v("WindowManager", "IWindow finishDrawing called for " + window + " data=" + data);
    L5:
        this.mService.finishDrawingWindow(this, window, postDrawTransaction, seqId, data);
    }

    public IBinder performDrag(IWindow window, int flags, SurfaceControl surface, int touchSource, int touchDeviceId, int touchPointerId, float touchX, float touchY, float thumbCenterX, float thumbCenterY, ClipData data) {
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        validateAndResolveDragMimeTypeExtras(data, callingUid, callingPid, this.mPackageName);
        validateDragFlags(flags, callingUid);
        long ident = Binder.clearCallingIdentity();
        IBinder r0 = this.mDragDropController.performDrag(this.mPid, this.mUid, window, flags, surface, touchSource, touchDeviceId, touchPointerId, touchX, touchY, thumbCenterX, thumbCenterY, data);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r0;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean dropForAccessibility(IWindow window, int x, int y) {
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mDragDropController.dropForAccessibility(window, x, y);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    void validateDragFlags(int flags, int callingUid) {
        if ((flags & 2048) == 0) goto L10;
        if (this.mCanStartTasksFromRecents == true) goto L10;
        throw new SecurityException("Requires START_TASKS_FROM_RECENTS permission");
    L10:
        if ((flags & 16384) != 0) goto L12;
        return;
    L12:
        if (SafeActivityOptions.isAssistant(this.mService.mAtmService, callingUid) == false) goto L15;
        return;
    L15:
        throw new SecurityException("Caller is not the assistant");
    }

    void validateAndResolveDragMimeTypeExtras(ClipData r29, int r30, int r31, String r32) {
        if (r29 == null) goto L5;
        ClipDescription r0 = r29.getDescription();
    L6:
        ClipDescription r3 = r0;
        if (r3 != null) goto L9;
        return;
    L9:
        boolean r4 = r3.hasMimeType("application/vnd.android.activity");
        boolean r5 = r3.hasMimeType("application/vnd.android.shortcut");
        boolean r6 = r3.hasMimeType("application/vnd.android.task");
        int r7 = ((r4 ? 1 : 0) + (r5 ? 1 : 0)) + (r6 ? 1 : 0);
        if (r7 != 0) goto L13;
        return;
    L13:
        if (r7 > 1) goto L95;
        if (r29.getItemCount() == 0) goto L93;
        int r1 = 0;
    L18:
        if (r1 >= r29.getItemCount()) goto L25;
        if (r29.getItemAt(r1).getIntent() == null) goto L23;
        r1 = r1 + 1;
        goto L18
    L23:
        throw new IllegalArgumentException("Unexpected item, expected an intent");
    L25:
        if (r4 == false) goto L45;
        long r8 = Binder.clearCallingIdentity();
        int r10 = 0;
    L98:
    L37:
        th = th;
    L42:
        Binder.restoreCallingIdentity(r8);
        throw th;
    L28:
        if (r10 >= r29.getItemCount()) goto L41;
        ClipData.Item r11 = r29.getItemAt(r10);     // Catch: Throwable -> L37
        Intent r12 = r11.getIntent();     // Catch: Throwable -> L37
        PendingIntent r13 = (PendingIntent) r12.getParcelableExtra("android.intent.extra.PENDING_INTENT");     // Catch: Throwable -> L37
        UserHandle r14 = (UserHandle) r12.getParcelableExtra("android.intent.extra.USER");     // Catch: Throwable -> L37
        if (r13 == null) goto L40;
        if (r14 == null) goto L40;
        ActivityManagerInternal r15 = this.mService.mAmInternal;     // Catch: Throwable -> L37
        ClipDescription r17 = r3;
        Intent r9 = r15.getIntentForIntentSender(r13.getIntentSender().getTarget());     // Catch: Throwable -> L35
        r11.setActivityInfo(this.mService.mAtmService.resolveActivityInfoForIntent(r9, null, r14.getIdentifier(), r30, r31));     // Catch: Throwable -> L35
        r10 = r10 + 1;     // Catch: Throwable -> L35
        r3 = r17;
    L35:
        th = th;
    L40:
        throw new IllegalArgumentException("Clip data must include the pending intent to launch and its associated user to launch for.");     // Catch: Throwable -> L35
    L41:
        Binder.restoreCallingIdentity(r8);
        return;
    L45:
        if (r5 == true) goto L47;
        if (r6 == true) goto L72;
        return;
    L72:
        if (this.mCanStartTasksFromRecents == false) goto L90;
        int r2 = 0;
    L75:
        if (r2 >= r29.getItemCount()) goto L118;
        ClipData.Item r16 = r29.getItemAt(r2);
        int r18 = r16.getIntent().getIntExtra("android.intent.extra.TASK_ID", -1);
        if (r18 == (-1)) goto L88;
        Task r19 = this.mService.mRoot.anyTaskForId(r18);
        if (r19 == null) goto L86;
        if (r19.getRootActivity() == null) goto L83;
        r16.setActivityInfo(r19.getRootActivity().info);
    L84:
        r2 = r2 + 1;
        goto L75
    L83:
        r16.setActivityInfo(this.mService.mAtmService.resolveActivityInfoForIntent(r19.intent, null, r19.mUserId, r30, r31));
        goto L84
    L86:
        throw new IllegalArgumentException("Invalid task id.");
    L88:
        throw new IllegalArgumentException("Clip item must include the task id.");
    L118:
        return;
    L90:
        throw new SecurityException("Requires START_TASKS_FROM_RECENTS permission");
    L47:
        if (this.mCanStartTasksFromRecents == false) goto L69;
        int r20 = 0;
    L50:
        if (r20 >= r29.getItemCount()) goto L117;
        ClipData.Item r21 = r29.getItemAt(r20);
        Intent r22 = r21.getIntent();
        String r24 = r22.getStringExtra("android.intent.extra.shortcut.ID");
        String r23 = r22.getStringExtra("android.intent.extra.PACKAGE_NAME");
        UserHandle r110 = (UserHandle) r22.getParcelableExtra("android.intent.extra.USER");
        if (TextUtils.isEmpty(r24) == true) goto L66;
        if (TextUtils.isEmpty(r23) == true) goto L66;
        if (r110 == null) goto L66;
        Intent[] r111 = ((ShortcutServiceInternal) LocalServices.getService(ShortcutServiceInternal.class)).createShortcutIntents(UserHandle.getUserId(r30), r32, r23, r24, r110.getIdentifier(), r31, r30);
        if (r111 == null) goto L62;
        if (r111.length == 0) goto L62;
        r21.setActivityInfo(this.mService.mAtmService.resolveActivityInfoForIntent(r111[0], null, r110.getIdentifier(), r30, r31));
        r20 = r20 + 1;
    L62:
        throw new IllegalArgumentException("Invalid shortcut id");
    L66:
        throw new IllegalArgumentException("Clip item must include the package name, shortcut id, and the user to launch for.");
    L117:
        return;
    L69:
        throw new SecurityException("Requires START_TASKS_FROM_RECENTS permission");
    L93:
        throw new IllegalArgumentException("Unexpected number of items (none)");
    L95:
        throw new IllegalArgumentException("Can not specify more than one of activity, shortcut, or task mime types");
    L5:
        r0 = null;
        goto L6
    }

    public void reportDropResult(IWindow window, boolean consumed) {
        long ident = Binder.clearCallingIdentity();
        this.mDragDropController.reportDropResult(window, consumed);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void cancelDragAndDrop(IBinder dragToken, boolean skipAnimation) {
        long ident = Binder.clearCallingIdentity();
        this.mDragDropController.cancelDragAndDrop(dragToken, skipAnimation);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void dragRecipientEntered(IWindow window) {
        this.mDragDropController.dragRecipientEntered(window);
    }

    public void dragRecipientExited(IWindow window) {
        this.mDragDropController.dragRecipientExited(window);
    }

    public boolean startMovingTask(IWindow window, float startX, float startY) {
        return false;
    }

    public void finishMovingTask(IWindow window) {
    }

    public void reportSystemGestureExclusionChanged(IWindow window, List<Rect> exclusionRects) {
        long ident = Binder.clearCallingIdentity();
        this.mService.reportSystemGestureExclusionChanged(this, window, exclusionRects);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void reportDecorViewGestureInterceptionChanged(IWindow window, boolean intercepted) {
        long ident = Binder.clearCallingIdentity();
        this.mService.reportDecorViewGestureChanged(this, window, intercepted);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void reportKeepClearAreasChanged(IWindow window, List<Rect> restricted, List<Rect> unrestricted) {
        if (this.mSetsUnrestrictedKeepClearAreas == false) goto L5;
    L7:
        long ident = Binder.clearCallingIdentity();
        this.mService.reportKeepClearAreasChanged(this, window, restricted, unrestricted);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(ident);
        return;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L5:
        if (unrestricted.isEmpty() == true) goto L7;
        unrestricted = Collections.emptyList();
        goto L7
    }

    private void actionOnWallpaper(IBinder window, BiConsumer<WallpaperController, WindowState> action) {
        WindowState windowState = this.mService.windowForClientLocked(this, window, true);
        action.accept(windowState.getDisplayContent().mWallpaperController, windowState);
    }

    public void setWallpaperPosition(IBinder window, final float x, final float y, final float xStep, final float yStep) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        actionOnWallpaper(window, new Session$$ExternalSyntheticLambda5(x, y, xStep, yStep));     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$setWallpaperPosition$0(float x, float y, float xStep, float yStep, WallpaperController wpController, WindowState windowState) {
        wpController.setWindowWallpaperPosition(windowState, x, y, xStep, yStep);
    }

    public void setWallpaperZoomOut(IBinder window, final float zoom) {
        if (Float.compare(0.0f, zoom) > 0) goto L25;
        if (Float.compare(1.0f, zoom) < 0) goto L25;
        if (Float.isNaN(zoom) == true) goto L25;
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L16
        actionOnWallpaper(window, new Session$$ExternalSyntheticLambda1(zoom));     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L25:
        throw new IllegalArgumentException("Zoom must be a valid float between 0 and 1: " + zoom);
    }

    private static /* synthetic */ void lambda$setWallpaperZoomOut$1(float zoom, WallpaperController wpController, WindowState windowState) {
        wpController.setWallpaperZoomOut(windowState, zoom);
    }

    public void setShouldZoomOutWallpaper(IBinder window, final boolean shouldZoom) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        actionOnWallpaper(window, new Session$$ExternalSyntheticLambda3(shouldZoom));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$setShouldZoomOutWallpaper$2(boolean shouldZoom, WallpaperController wpController, WindowState windowState) {
        wpController.setShouldZoomOutWallpaper(windowState, shouldZoom);
    }

    public void wallpaperOffsetsComplete(final IBinder window) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        actionOnWallpaper(window, new Session$$ExternalSyntheticLambda2(window));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$wallpaperOffsetsComplete$3(IBinder window, WallpaperController wpController, WindowState windowState) {
        wpController.wallpaperOffsetsComplete(window);
    }

    public void setWallpaperDisplayOffset(IBinder window, final int x, final int y) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        actionOnWallpaper(window, new Session$$ExternalSyntheticLambda0(x, y));     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$setWallpaperDisplayOffset$4(int x, int y, WallpaperController wpController, WindowState windowState) {
        wpController.setWindowWallpaperDisplayOffset(windowState, x, y);
    }

    public void sendWallpaperCommand(IBinder window, String action, int x, int y, int z, Bundle extras, boolean sync) {
        WindowManagerGlobalLock r1 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L19
        WindowState windowState = this.mService.windowForClientLocked(this, window, true);     // Catch: Throwable -> L12
        WallpaperController wallpaperController = windowState.getDisplayContent().mWallpaperController;     // Catch: Throwable -> L12
        if (this.mCanAlwaysUpdateWallpaper == false) goto L8;
    L14:
        wallpaperController.sendWindowWallpaperCommandUnchecked(windowState, action, x, y, z, extras, sync);     // Catch: Throwable -> L12
    L15:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        if (windowState == wallpaperController.getWallpaperTarget()) goto L14;
        if (windowState != wallpaperController.getPrevWallpaperTarget()) goto L15;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void wallpaperCommandComplete(final IBinder window, Bundle result) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        actionOnWallpaper(window, new Session$$ExternalSyntheticLambda4(window));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$wallpaperCommandComplete$5(IBinder window, WallpaperController wpController, WindowState windowState) {
        wpController.wallpaperCommandComplete(window);
    }

    public void onRectangleOnScreenRequested(IBinder token, Rect rectangle) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        this.mService.onRectangleOnScreenRequested(token, rectangle);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public IWindowId getWindowId(IBinder window) {
        return this.mService.getWindowId(window);
    }

    public void pokeDrawLock(IBinder window) {
        long identity = Binder.clearCallingIdentity();
        this.mService.pokeDrawLock(this, window);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void updateTapExcludeRegion(IWindow window, Region region) {
        long identity = Binder.clearCallingIdentity();
        this.mService.updateTapExcludeRegion(window, region);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void updateRequestedVisibleTypes(IWindow window, int requestedVisibleTypes, ImeTracker.Token imeStatsToken) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState win = this.mService.windowForClientLocked(this, window, false);     // Catch: Throwable -> L9
        if (win == null) goto L12;
        ImeTracker.forLogging().onProgress(imeStatsToken, 56);     // Catch: Throwable -> L9
        int changedTypes = win.setRequestedVisibleTypes(requestedVisibleTypes);     // Catch: Throwable -> L9
        win.getDisplayContent().getInsetsPolicy().onRequestedVisibleTypesChanged(win, changedTypes, imeStatsToken);     // Catch: Throwable -> L9
        Task task = win.getTask();     // Catch: Throwable -> L9
        if (task == null) goto L16;
        task.dispatchTaskInfoChangedIfNeeded(true);     // Catch: Throwable -> L9
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        EmbeddedWindowController.EmbeddedWindow embeddedWindow = this.mService.mEmbeddedWindowController.getByWindowToken(window.asBinder());     // Catch: Throwable -> L9
        if (embeddedWindow == null) goto L15;
        ImeTracker.forLogging().onProgress(imeStatsToken, 56);     // Catch: Throwable -> L9
        int changedTypes2 = embeddedWindow.setRequestedVisibleTypes(WindowInsets.Type.ime() & requestedVisibleTypes);     // Catch: Throwable -> L9
        embeddedWindow.getDisplayContent().getInsetsPolicy().onRequestedVisibleTypesChanged(embeddedWindow, changedTypes2, imeStatsToken);     // Catch: Throwable -> L9
        goto L16
    L15:
        ImeTracker.forLogging().onFailed(imeStatsToken, 56);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void updateAnimatingTypes(IWindow window, int animatingTypes, ImeTracker.Token statsToken) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState win = this.mService.windowForClientLocked(this, window, false);     // Catch: Throwable -> L7
        if (win == null) goto L9;
        ImeTracker.forLogging().onProgress(statsToken, 72);     // Catch: Throwable -> L7
        win.setAnimatingTypes(animatingTypes, statsToken);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        ImeTracker.forLogging().onFailed(statsToken, 72);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void onWindowAdded(WindowState w) {
        if (this.mPackageName != null) goto L6;
        this.mPackageName = this.mProcess.mInfo.packageName;
        this.mRelayoutTag = "relayoutWindow: " + this.mPackageName;
    L6:
        if (this.mProcess.mWindowSession == null) goto L8;
    L14:
        this.mAddedWindows.add(w);
        return;
    L8:
        if (WindowManagerDebugConfig.DEBUG == false) goto L10;
        Slog.v("WindowManager", "First window added to " + this.mProcess);
    L10:
        this.mService.mSessions.add(this);
        if (this.mLastReportedAnimatorScale == this.mService.getCurrentAnimatorScale()) goto L13;
        this.mService.dispatchNewAnimatorScaleLocked(this);
    L13:
        this.mProcess.mWindowSession = this;
        goto L14
    }

    void onWindowRemoved(WindowState w) {
        this.mAddedWindows.remove(w);
        if (this.mAddedWindows.isEmpty() == false) goto L6;
        killSessionLocked();
        return;
    }

    boolean hasWindow() {
        return !this.mAddedWindows.isEmpty();
    }

    void onWindowSurfaceVisibilityChanged(WindowState window, boolean visible) {
        int type = window.mAttrs.type;
        if (WindowManager.LayoutParams.isSystemAlertWindowType(type) == true) goto L8;
        if (type == 2008) goto L8;
        return;
    L8:
        if (this.mCanAddInternalSystemWindow == false) goto L10;
    L12:
        boolean noSystemOverlayPermission = false;
    L14:
        if (visible == false) goto L20;
        boolean changed = this.mAlertWindows.add(window);
        if (type != 2038) goto L18;
        MetricsLoggerWrapper.logAppOverlayEnter(this.mUid, this.mPackageName, changed, type, false);
    L25:
        if (changed == false) goto L37;
        if (noSystemOverlayPermission == false) goto L37;
        if (this.mAlertWindows.isEmpty() == false) goto L31;
        cancelAlertWindowNotification();
        goto L37
    L31:
        if (this.mAlertWindowNotification != null) goto L37;
        if (isSatellitePointingUiPackage() == true) goto L37;
        this.mAlertWindowNotification = new AlertWindowNotification(this.mService, this.mPackageName);
        if (this.mShowingAlertWindowNotificationAllowed == false) goto L37;
        this.mAlertWindowNotification.post();
    L37:
        if (changed == true) goto L39;
        return;
    L39:
        if (this.mPid == WindowManagerService.MY_PID) goto L43;
        setHasOverlayUi(!this.mAlertWindows.isEmpty());
        return;
    L43:
        return;
    L18:
        if (noSystemOverlayPermission == false) goto L25;
        MetricsLoggerWrapper.logAppOverlayEnter(this.mUid, this.mPackageName, changed, type, true);
        goto L25
    L20:
        changed = this.mAlertWindows.remove(window);
        if (type != 2038) goto L23;
        MetricsLoggerWrapper.logAppOverlayExit(this.mUid, this.mPackageName, changed, type, false);
        goto L25
    L23:
        if (noSystemOverlayPermission == false) goto L25;
        MetricsLoggerWrapper.logAppOverlayExit(this.mUid, this.mPackageName, changed, type, true);
        goto L25
    L10:
        if (this.mCanCreateSystemApplicationOverlay == true) goto L12;
        noSystemOverlayPermission = true;
        goto L14
    }

    private boolean isSatellitePointingUiPackage() {
        if (this.mPackageName != null) goto L5;
    L11:
        return false;
    L5:
        if (this.mPackageName.equals(this.mService.mContext.getString(R.string.config_usbResolverActivity)) == false) goto L11;
        if (ActivityTaskManagerService.checkPermission("android.permission.SATELLITE_COMMUNICATION", this.mPid, this.mUid) != 0) goto L12;
        return true;
    L12:
        return false;
    }

    void setShowingAlertWindowNotificationAllowed(boolean allowed) {
        this.mShowingAlertWindowNotificationAllowed = allowed;
        if (this.mAlertWindowNotification == null) goto L8;
        if (allowed == false) goto L6;
        this.mAlertWindowNotification.post();
        return;
    L6:
        this.mAlertWindowNotification.cancel(false);
        return;
    }

    private void killSessionLocked() {
        if (this.mClientDead == true) goto L5;
        return;
    L5:
        this.mService.mSessions.remove(this);
        if (this.mProcess.mWindowSession != null) goto L8;
        return;
    L8:
        this.mProcess.mWindowSession = null;
        this.mAddedWindows.clear();
        this.mAlertWindows.clear();
        setHasOverlayUi(false);
        cancelAlertWindowNotification();
    }

    void setHasOverlayUi(boolean r4) {
        this.mService.mH.obtainMessage(58, this.mPid, r4 ? 1 : 0).sendToTarget();
    }

    private void cancelAlertWindowNotification() {
        if (this.mAlertWindowNotification != null) goto L5;
        return;
    L5:
        this.mAlertWindowNotification.cancel(true);
        this.mAlertWindowNotification = null;
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("numWindow=");
        pw.print(this.mAddedWindows.size());
        pw.print(" mCanAddInternalSystemWindow=");
        pw.print(this.mCanAddInternalSystemWindow);
        pw.print(" mAlertWindows=");
        pw.print(this.mAlertWindows);
        pw.print(" mClientDead=");
        pw.print(this.mClientDead);
        pw.print(prefix);
        pw.print("mPackageName=");
        pw.println(this.mPackageName);
        if (isSatellitePointingUiPackage() == false) goto L6;
        pw.print(prefix);
        pw.println("mIsSatellitePointingUiPackage=true");
        return;
    }

    public String toString() {
        return this.mStringName;
    }

    boolean hasAlertWindowSurfaces(DisplayContent displayContent) {
        int i = this.mAlertWindows.size() - 1;
    L3:
        if (i < 0) goto L8;
        WindowState window = this.mAlertWindows.valueAt(i);
        if (window.mDisplayContent == displayContent) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    public void grantInputChannel(int displayId, SurfaceControl surface, IBinder clientToken, InputTransferToken hostInputTransferToken, int flags, int privateFlags, int inputFeatures, int type, IBinder windowToken, InputTransferToken inputTransferToken, String inputHandleName, InputChannel outInputChannel) {
        if (hostInputTransferToken == null) goto L5;
    L9:
        long identity = Binder.clearCallingIdentity();
        WindowManagerService r0 = this.mService;     // Catch: Throwable -> L17
        int r2 = this.mUid;     // Catch: Throwable -> L17
        int r3 = this.mPid;     // Catch: Throwable -> L17
        if (this.mCanAddInternalSystemWindow == false) goto L13;
        int r9 = privateFlags;
    L14:
        r0.grantInputChannel(this, r2, r3, displayId, surface, clientToken, hostInputTransferToken, flags, r9, inputFeatures, type, windowToken, inputTransferToken, inputHandleName, outInputChannel);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(identity);
        return;
    L13:
        r9 = 0;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        if (this.mCanAddInternalSystemWindow == true) goto L9;
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");
    }

    public void updateInputChannel(IBinder channelToken, int displayId, SurfaceControl surface, int flags, int privateFlags, int inputFeatures, Region region) {
        long identity = Binder.clearCallingIdentity();
        WindowManagerService r3 = this.mService;     // Catch: Throwable -> L10
        if (this.mCanAddInternalSystemWindow == false) goto L6;
        int r8 = privateFlags;
    L7:
        r3.updateInputChannel(channelToken, displayId, surface, flags, r8, inputFeatures, region);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        r8 = 0;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void grantEmbeddedWindowFocus(IWindow callingWindow, InputTransferToken targetInputToken, boolean grantFocus) {
        long identity = Binder.clearCallingIdentity();
        if (callingWindow == null) goto L5;
        this.mService.grantEmbeddedWindowFocus(this, callingWindow, targetInputToken, grantFocus);     // Catch: Throwable -> L7
    L12:
        Binder.restoreCallingIdentity(identity);
        return;
    L5:
        if (this.mCanAddInternalSystemWindow == false) goto L10;
        this.mService.grantEmbeddedWindowFocus(this, targetInputToken, grantFocus);     // Catch: Throwable -> L7
        goto L12
    L10:
        throw new SecurityException("Requires INTERNAL_SYSTEM_WINDOW permission");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public boolean moveFocusToAdjacentWindow(IWindow fromWindow, int direction) {
        long identity = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mService.mGlobalLock;     // Catch: Throwable -> L19
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L19
        monitor-enter(r2);     // Catch: Throwable -> L19
        WindowState win = this.mService.windowForClientLocked(this, fromWindow, false);     // Catch: Throwable -> L10
        if (win != null) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(identity);
        return false;
    L12:
        boolean r4 = this.mService.moveFocusToAdjacentWindow(win, direction);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(identity);
        return r4;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void generateDisplayHash(IWindow window, Rect boundsInWindow, String hashAlgorithm, RemoteCallback callback) {
        long origId = Binder.clearCallingIdentity();
        this.mService.generateDisplayHash(this, window, boundsInWindow, hashAlgorithm, callback);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(origId);
        return;
    L8:
        th = move-exception;
        Throwable r10 = th;
    L12:
        Binder.restoreCallingIdentity(origId);
        throw r10;
    L10:
        th = move-exception;
        r10 = th;
        goto L12
    }

    public void setOnBackInvokedCallbackInfo(IWindow window, OnBackInvokedCallbackInfo callbackInfo) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState windowState = this.mService.windowForClientLocked(this, window, false);     // Catch: Throwable -> L7
        if (windowState != null) goto L9;
        Slog.i("WindowManager", "setOnBackInvokedCallback(): No window state for package:" + this.mPackageName);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        windowState.setOnBackInvokedCallbackInfo(callbackInfo);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void notifyImeWindowVisibilityChangedFromClient(IWindow window, boolean visible, ImeTracker.Token statsToken) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState win = this.mService.windowForClientLocked(this, window, false);     // Catch: Throwable -> L9
        if (win == null) goto L12;
        InsetsStateController insetsStateController = win.getDisplayContent().getInsetsStateController();     // Catch: Throwable -> L9
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[0] == false) goto L11;
        String protoLogParam0 = String.valueOf(insetsStateController.getImeSourceProvider());     // Catch: Throwable -> L9
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IME, 8453358838108075815L, 0, new Object[]{protoLogParam0});     // Catch: Throwable -> L9
    L11:
        ImeTracker.forLogging().onProgress(statsToken, 62);     // Catch: Throwable -> L9
        insetsStateController.getImeSourceProvider().receiveImeStatsToken(visible, statsToken);     // Catch: Throwable -> L9
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        ImeTracker.forLogging().onFailed(statsToken, 62);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean isQSWindowOrNotificationShade() {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent dc = this.mService.getDefaultDisplayContentLocked();     // Catch: Throwable -> L11
        WindowState currentFocus = dc.mCurrentFocus;     // Catch: Throwable -> L11
        if (currentFocus != null) goto L7;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L7:
        if (currentFocus.mAttrs.type == 2040) goto L13;
        if (currentFocus.mAttrs.type != 2017) goto L16;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        return true;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void updateResolutionScaleToServer(IWindow window, float scale) {
        this.mService.getExt().updateResolutionScaleToServer(window, scale);
    }

    public SessionSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    public IWindowSessionSmtEx getISmtEx() {
        return this.mSmtEx.getISmtEx();
    }

    boolean isAlertWindowEmpty() {
        return this.mAlertWindows.isEmpty();
    }
}
