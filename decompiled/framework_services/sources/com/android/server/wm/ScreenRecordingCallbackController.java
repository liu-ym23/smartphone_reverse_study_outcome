package com.android.server.wm;

import android.media.projection.IMediaProjectionManager;
import android.media.projection.IMediaProjectionWatcherCallback;
import android.media.projection.MediaProjectionEvent;
import android.media.projection.MediaProjectionInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.view.ContentRecordingSession;
import android.window.IScreenRecordingCallback;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ScreenRecordingCallbackController {
    private final ArrayMap<IBinder, Callback> mCallbacks;
    private final ArrayMap<Integer, Boolean> mLastInvokedStateByUid;
    private WindowContainer<WindowContainer> mRecordedWC;
    private boolean mWatcherCallbackRegistered;
    private final WindowManagerService mWms;

    private final class Callback implements IBinder.DeathRecipient {
        IScreenRecordingCallback mCallback;
        int mUid;
        final /* synthetic */ ScreenRecordingCallbackController this$0;

        Callback(ScreenRecordingCallbackController r1, IScreenRecordingCallback callback, int uid) {
            this.this$0 = r1;
            this.mCallback = callback;
            this.mUid = uid;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.unregister(this.mCallback);
        }
    }

    private final class MediaProjectionWatcherCallback extends IMediaProjectionWatcherCallback.Stub {
        final /* synthetic */ ScreenRecordingCallbackController this$0;

        /* synthetic */ MediaProjectionWatcherCallback(ScreenRecordingCallbackController r1, ScreenRecordingCallbackControllerIA r2) {
            this(r1);
        }

        private MediaProjectionWatcherCallback(ScreenRecordingCallbackController r1) {
            this.this$0 = r1;
        }

        public void onStart(MediaProjectionInfo mediaProjectionInfo) {
            ScreenRecordingCallbackController.m10132$$Nest$monScreenRecordingStart(this.this$0, mediaProjectionInfo);
        }

        public void onStop(MediaProjectionInfo mediaProjectionInfo) {
            ScreenRecordingCallbackController.m10133$$Nest$monScreenRecordingStop(this.this$0);
        }

        public void onRecordingSessionSet(MediaProjectionInfo mediaProjectionInfo, ContentRecordingSession contentRecordingSession) {
        }

        public void onMediaProjectionEvent(MediaProjectionEvent event, MediaProjectionInfo mediaProjectionInfo, ContentRecordingSession session) {
        }
    }

    public static /* synthetic */ void $r8$lambda$9n2dxgEob524thBiQbYBR3smIaM(ScreenRecordingCallbackController r0, ArraySet r1, ActivityRecord r2) {
        r0.lambda$getRecordedUids$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$MFPVWjUWaVAhkXMWfHeo3oYMd4s(ArrayList r0, boolean r1) {
        lambda$dispatchCallbacks$3(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$tRQLmFqk3azaCDR7YSY57sA3_sI(int r0, boolean[] r1, ActivityRecord r2) {
        return lambda$uidHasRecordedActivity$1(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$wBDBDhUmSS5K9SLBTBD1EEdmfjE(MediaProjectionInfo r0, ActivityRecord r1) {
        return lambda$setRecordedWindowContainer$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monScreenRecordingStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10132$$Nest$monScreenRecordingStart(ScreenRecordingCallbackController r0, MediaProjectionInfo r1) {
        r0.onScreenRecordingStart(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monScreenRecordingStop, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10133$$Nest$monScreenRecordingStop(ScreenRecordingCallbackController r0) {
        r0.onScreenRecordingStop();
    }

    ScreenRecordingCallbackController(WindowManagerService wms) {
        this.mCallbacks = new ArrayMap();
        this.mLastInvokedStateByUid = new ArrayMap();
        this.mWatcherCallbackRegistered = false;
        this.mWms = wms;
    }

    private void setRecordedWindowContainer(final MediaProjectionInfo mediaProjectionInfo) {
        if (mediaProjectionInfo.getLaunchCookie() != null) goto L5;
        this.mRecordedWC = this.mWms.mRoot.getDefaultDisplay();
        return;
    L5:
        ActivityRecord matchingActivity = this.mWms.mRoot.getActivity(new ScreenRecordingCallbackController$$ExternalSyntheticLambda1(mediaProjectionInfo));
        if (matchingActivity == null) goto L8;
        Task r1 = matchingActivity.getTask();
    L9:
        this.mRecordedWC = r1;
        return;
    L8:
        r1 = null;
        goto L9
    }

    private static /* synthetic */ boolean lambda$setRecordedWindowContainer$0(MediaProjectionInfo mediaProjectionInfo, ActivityRecord activity) {
        if (activity.mLaunchCookie != mediaProjectionInfo.getLaunchCookie().binder) goto L5;
        return true;
    L5:
        return false;
    }

    private void ensureMediaProjectionWatcherCallbackRegistered() {
        if (this.mWatcherCallbackRegistered == false) goto L5;
        return;
    L5:
        IBinder binder = ServiceManager.getService("media_projection");
        IMediaProjectionManager mediaProjectionManager = IMediaProjectionManager.Stub.asInterface(binder);
        long identityToken = Binder.clearCallingIdentity();
        MediaProjectionInfo mediaProjectionInfo = null;
        mediaProjectionInfo = mediaProjectionManager.addCallback(new MediaProjectionWatcherCallback(this, null));     // Catch: Throwable -> L8 RemoteException -> L10
        this.mWatcherCallbackRegistered = true;     // Catch: Throwable -> L8 RemoteException -> L10
    L7:
        Binder.restoreCallingIdentity(identityToken);
        if (mediaProjectionInfo == null) goto L23;
        setRecordedWindowContainer(mediaProjectionInfo);
        return;
    L23:
        return;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(identityToken);
        throw th;
    L12:
        if (ProtoLogImpl_798997914.Cache.WM_ERROR_enabled[4] == false) goto L7;
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_ERROR, 4666728330189027178L, 0, null);     // Catch: Throwable -> L8
        goto L7
    }

    boolean register(IScreenRecordingCallback callback) {
        WindowManagerGlobalLock r0 = this.mWms.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ensureMediaProjectionWatcherCallbackRegistered();     // Catch: Throwable -> L10
        IBinder binder = callback.asBinder();     // Catch: Throwable -> L10
        int uid = Binder.getCallingUid();     // Catch: Throwable -> L10
        if (this.mCallbacks.containsKey(binder) == false) goto L12;
        boolean r3 = this.mLastInvokedStateByUid.get(Integer.valueOf(uid)).booleanValue();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r3;
    L12:
        Callback callbackInfo = new Callback(this, callback, uid);     // Catch: Throwable -> L10
        binder.linkToDeath(callbackInfo, 0);     // Catch: Throwable -> L10 RemoteException -> L19
        boolean uidInRecording = uidHasRecordedActivity(callbackInfo.mUid);     // Catch: Throwable -> L10
        this.mLastInvokedStateByUid.put(Integer.valueOf(callbackInfo.mUid), Boolean.valueOf(uidInRecording));     // Catch: Throwable -> L10
        this.mCallbacks.put(binder, callbackInfo);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return uidInRecording;
    L21:
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void unregister(IScreenRecordingCallback callback) {
        WindowManagerGlobalLock r0 = this.mWms.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        IBinder binder = callback.asBinder();     // Catch: Throwable -> L9
        Callback callbackInfo = this.mCallbacks.remove(binder);     // Catch: Throwable -> L9
        if (callbackInfo != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        binder.unlinkToDeath(callbackInfo, 0);     // Catch: Throwable -> L9
        boolean uidHasCallback = false;
        int i = 0;
    L14:
        if (i >= this.mCallbacks.size()) goto L19;
        if (this.mCallbacks.valueAt(i).mUid == callbackInfo.mUid) goto L17;
        i = i + 1;     // Catch: Throwable -> L9
        goto L14
    L17:
        uidHasCallback = true;
    L19:
        if (uidHasCallback == true) goto L21;
        this.mLastInvokedStateByUid.remove(Integer.valueOf(callbackInfo.mUid));     // Catch: Throwable -> L9
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void onScreenRecordingStart(MediaProjectionInfo mediaProjectionInfo) {
        WindowManagerGlobalLock r0 = this.mWms.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        setRecordedWindowContainer(mediaProjectionInfo);     // Catch: Throwable -> L8
        dispatchCallbacks(getRecordedUids(), true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void onScreenRecordingStop() {
        WindowManagerGlobalLock r0 = this.mWms.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        dispatchCallbacks(getRecordedUids(), false);     // Catch: Throwable -> L8
        this.mRecordedWC = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void onProcessActivityVisibilityChanged(int uid, boolean processVisible) {
        if (this.mRecordedWC != null) goto L5;
        return;
    L5:
        if (this.mLastInvokedStateByUid.containsKey(Integer.valueOf(uid)) == true) goto L8;
        return;
    L8:
        if (processVisible != this.mLastInvokedStateByUid.get(Integer.valueOf(uid)).booleanValue()) goto L10;
        return;
    L10:
        boolean uidInRecording = uidHasRecordedActivity(uid);
        if (processVisible == false) goto L13;
        if (uidInRecording == true) goto L13;
        return;
    L13:
        if (processVisible == true) goto L16;
        if (uidInRecording == false) goto L16;
        return;
    L16:
        ArraySet<Integer> uidSet = new ArraySet();
        uidSet.add(Integer.valueOf(uid));
        dispatchCallbacks(uidSet, processVisible);
    }

    private boolean uidHasRecordedActivity(final int uid) {
        if (this.mRecordedWC != null) goto L5;
        return false;
    L5:
        final boolean[] hasRecordedActivity = {false};
        this.mRecordedWC.forAllActivities(new ScreenRecordingCallbackController$$ExternalSyntheticLambda0(uid, hasRecordedActivity), true);
        return hasRecordedActivity[0];
    }

    private static /* synthetic */ boolean lambda$uidHasRecordedActivity$1(int uid, boolean[] hasRecordedActivity, ActivityRecord activityRecord) {
        if (activityRecord.getUid() == uid) goto L5;
    L8:
        return false;
    L5:
        if (activityRecord.isVisibleRequested() == false) goto L8;
        hasRecordedActivity[0] = true;
        return true;
    }

    private ArraySet<Integer> getRecordedUids() {
        final ArraySet<Integer> result = new ArraySet();
        if (this.mRecordedWC != null) goto L5;
        return result;
    L5:
        this.mRecordedWC.forAllActivities(new ScreenRecordingCallbackController$$ExternalSyntheticLambda3(this, result), true);
        return result;
    }

    private /* synthetic */ void lambda$getRecordedUids$2(ArraySet result, ActivityRecord activityRecord) {
        if (activityRecord.isVisibleRequested() == true) goto L5;
        return;
    L5:
        if (this.mLastInvokedStateByUid.containsKey(Integer.valueOf(activityRecord.getUid())) == false) goto L9;
        result.add(Integer.valueOf(activityRecord.getUid()));
        return;
    }

    private void dispatchCallbacks(ArraySet<Integer> uids, final boolean visibleInScreenRecording) {
        if (uids.isEmpty() == false) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= uids.size()) goto L9;
        this.mLastInvokedStateByUid.put(uids.valueAt(i), Boolean.valueOf(visibleInScreenRecording));
        i = i + 1;
        goto L7
    L9:
        final ArrayList<IScreenRecordingCallback> callbacks = new ArrayList();
        int i2 = 0;
    L11:
        if (i2 >= this.mCallbacks.size()) goto L16;
        if (uids.contains(Integer.valueOf(this.mCallbacks.valueAt(i2).mUid)) == false) goto L15;
        callbacks.add(this.mCallbacks.valueAt(i2).mCallback);
    L15:
        i2 = i2 + 1;
        goto L11
    L16:
        this.mWms.mH.post(new ScreenRecordingCallbackController$$ExternalSyntheticLambda2(callbacks, visibleInScreenRecording));
    }

    private static /* synthetic */ void lambda$dispatchCallbacks$3(ArrayList callbacks, boolean visibleInScreenRecording) {
        int i = 0;
    L4:
        if (i >= callbacks.size()) goto L10;
        ((IScreenRecordingCallback) callbacks.get(i)).onScreenRecordingStateChanged(visibleInScreenRecording);     // Catch: RemoteException -> L7
    L8:
        i = i + 1;
        goto L4
    }

    void dump(PrintWriter pw) {
        pw.format("ScreenRecordingCallbackController:\n", new Object[0]);
        pw.format("  Registered callbacks:\n", new Object[0]);
        int i = 0;
    L4:
        if (i >= this.mCallbacks.size()) goto L6;
        pw.format("    callback=%s uid=%s\n", new Object[]{this.mCallbacks.keyAt(i), Integer.valueOf(this.mCallbacks.valueAt(i).mUid)});
        i = i + 1;
        goto L4
    L6:
        pw.format("  Last invoked states:\n", new Object[0]);
        int i2 = 0;
    L8:
        if (i2 >= this.mLastInvokedStateByUid.size()) goto L11;
        pw.format("    uid=%s isVisibleInScreenRecording=%s\n", new Object[]{this.mLastInvokedStateByUid.keyAt(i2), this.mLastInvokedStateByUid.valueAt(i2)});
        i2 = i2 + 1;
        goto L8
    }
}
