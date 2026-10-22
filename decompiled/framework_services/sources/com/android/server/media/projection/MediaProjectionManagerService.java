package com.android.server.media.projection;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.AppOpsManager;
import android.app.compat.CompatChanges;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.media.MediaRouter;
import android.media.projection.IMediaProjection;
import android.media.projection.IMediaProjectionCallback;
import android.media.projection.IMediaProjectionManager;
import android.media.projection.IMediaProjectionWatcherCallback;
import android.media.projection.MediaProjectionEvent;
import android.media.projection.MediaProjectionInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PermissionEnforcer;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Slog;
import android.view.ContentRecordingSession;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.SystemService;
import com.android.server.Watchdog;
import com.android.server.media.IMediaSessionServiceExt;
import com.android.server.wm.WindowManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaProjectionManagerService extends SystemService implements Watchdog.Monitor {
    static final long MEDIA_PROJECTION_PREVENTS_REUSING_CONSENT = 266201607;
    private static final boolean REQUIRE_FG_SERVICE_FOR_PROJECTION = true;
    private static final String TAG = "MediaProjectionManagerService";
    private static final AtomicInteger sNextSessionId = null;
    private final ActivityManagerInternal mActivityManagerInternal;
    private final AppOpsManager mAppOps;
    private final CallbackDelegate mCallbackDelegate;
    private final Clock mClock;
    private final Context mContext;
    private final Map<IBinder, IBinder.DeathRecipient> mDeathEaters;
    private IMediaProjectionManagerServiceExt mExt;
    private final Handler mHandler;
    private final Injector mInjector;
    private final Object mLock;
    private final MediaProjectionMetricsLogger mMediaProjectionMetricsLogger;
    private final MediaProjectionStopController mMediaProjectionStopController;
    private MediaRouter.RouteInfo mMediaRouteInfo;
    private final MediaRouter mMediaRouter;
    private final MediaRouterCallback mMediaRouterCallback;
    private final PackageManager mPackageManager;
    private MediaProjection mProjectionGrant;
    private IBinder mProjectionToken;
    private final WindowManagerInternal mWmInternal;

    final class BinderService extends IMediaProjectionManager.Stub {
        final /* synthetic */ MediaProjectionManagerService this$0;

        BinderService(MediaProjectionManagerService this$0, Context context) {
            this.this$0 = this$0;
            super(PermissionEnforcer.fromContext(context));
        }

        public boolean hasProjectionPermission(int processUid, String packageName) {
            long token = Binder.clearCallingIdentity();
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L4:
            if (checkPermission(packageName, "android.permission.CAPTURE_VIDEO_OUTPUT") == true) goto L11;
            if (MediaProjectionManagerService.m5818$$Nest$fgetmAppOps(this.this$0).noteOpNoThrow(46, processUid, packageName) == 0) goto L11;
            boolean r3 = false;
        L12:
            boolean hasPermission = false | r3;
            Binder.restoreCallingIdentity(token);
            return hasPermission;
        L11:
            r3 = true;
            goto L12
        }

        public IMediaProjection createProjection(int processUid, String packageName, int type, boolean isPermanentGrant, int displayId) {
            if (MediaProjectionManagerService.m5821$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.MANAGE_MEDIA_PROJECTION") != 0) goto L12;
            if (packageName == null) goto L10;
            if (packageName.isEmpty() == true) goto L10;
            UserHandle callingUser = Binder.getCallingUserHandle();
            return this.this$0.createProjectionInternal(processUid, packageName, type, isPermanentGrant, callingUser, displayId);
        L10:
            throw new IllegalArgumentException("package name must not be empty");
        L12:
            throw new SecurityException("Requires MANAGE_MEDIA_PROJECTION in order to grant projection permission");
        }

        public IMediaProjection getProjection(int processUid, String packageName) {
            getProjection_enforcePermission();
            if (packageName == null) goto L14;
            if (packageName.isEmpty() == true) goto L14;
            long callingToken = Binder.clearCallingIdentity();
            MediaProjection projection = this.this$0.getProjectionInternal(processUid, packageName);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(callingToken);
            return projection;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(callingToken);
            throw th;
        L14:
            throw new IllegalArgumentException("package name must not be empty");
        }

        public boolean isCurrentProjection(IMediaProjection projection) {
            isCurrentProjection_enforcePermission();
            MediaProjectionManagerService r0 = this.this$0;
            if (projection != null) goto L5;
            IBinder r1 = null;
        L7:
            return r0.isCurrentProjection(r1);
        L5:
            r1 = projection.asBinder();
            goto L7
        }

        public MediaProjectionInfo getActiveProjectionInfo() {
            if (MediaProjectionManagerService.m5821$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.MANAGE_MEDIA_PROJECTION") != 0) goto L12;
            long token = Binder.clearCallingIdentity();
            MediaProjectionInfo r2 = this.this$0.getActiveProjectionInfo();     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return r2;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L12:
            throw new SecurityException("Requires MANAGE_MEDIA_PROJECTION in order to get active projection info");
        }

        public void stopActiveProjection(int stopReason) {
            stopActiveProjection_enforcePermission();
            long token = Binder.clearCallingIdentity();
            Object r2 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L15
            monitor-enter(r2);     // Catch: Throwable -> L15
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L6:
            if (MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0) == null) goto L10;
            Slog.d(MediaProjectionManagerService.TAG, "Content Recording: Stopping active projection");     // Catch: Throwable -> L8
            MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0).stop(stopReason);     // Catch: Throwable -> L8
        L10:
            monitor-exit(r2);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void notifyCaptureBoundsChanged(int contentToRecord, int targetProcessUid, Rect newBounds) {
            notifyCaptureBoundsChanged_enforcePermission();
            Object r0 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (isCurrentProjection(MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0)) == true) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            long token = Binder.clearCallingIdentity();
            Object r2 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L26
            monitor-enter(r2);     // Catch: Throwable -> L26
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L15:
            if (MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0) != null) goto L17;
        L21:
            monitor-exit(r2);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(token);
            return;
        L17:
            if (MediaProjectionManagerService.m5819$$Nest$fgetmCallbackDelegate(this.this$0) == null) goto L21;
            this.this$0.notifyCaptureBoundsChanged(contentToRecord, targetProcessUid, newBounds);     // Catch: Throwable -> L19
            MediaProjectionManagerService.m5819$$Nest$fgetmCallbackDelegate(this.this$0).dispatchResize(MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0), newBounds.width(), newBounds.height());     // Catch: Throwable -> L19
        L26:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void notifyActiveProjectionCapturedContentVisibilityChanged(boolean isVisible) {
            notifyActiveProjectionCapturedContentVisibilityChanged_enforcePermission();
            Object r0 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (isCurrentProjection(MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0)) == true) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            long token = Binder.clearCallingIdentity();
            Object r2 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L26
            monitor-enter(r2);     // Catch: Throwable -> L26
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L15:
            if (MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0) != null) goto L17;
        L21:
            monitor-exit(r2);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(token);
            return;
        L17:
            if (MediaProjectionManagerService.m5819$$Nest$fgetmCallbackDelegate(this.this$0) == null) goto L21;
            MediaProjectionManagerService.m5819$$Nest$fgetmCallbackDelegate(this.this$0).dispatchVisibilityChanged(MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0), isVisible);     // Catch: Throwable -> L19
        L26:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public MediaProjectionInfo addCallback(IMediaProjectionWatcherCallback callback) {
            addCallback_enforcePermission();
            long token = Binder.clearCallingIdentity();
            MediaProjectionInfo r2 = this.this$0.addCallback(callback);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void removeCallback(IMediaProjectionWatcherCallback callback) {
            if (MediaProjectionManagerService.m5821$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.MANAGE_MEDIA_PROJECTION") != 0) goto L12;
            long token = Binder.clearCallingIdentity();
            MediaProjectionManagerService.m5832$$Nest$mremoveCallback(this.this$0, callback);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L12:
            throw new SecurityException("Requires MANAGE_MEDIA_PROJECTION in order to remove projection callbacks");
        }

        public boolean setContentRecordingSession(ContentRecordingSession incomingSession, IMediaProjection projection) {
            setContentRecordingSession_enforcePermission();
            Object r0 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (isCurrentProjection(projection) == false) goto L17;
            monitor-exit(r0);     // Catch: Throwable -> L14
            long origId = Binder.clearCallingIdentity();
            boolean r2 = this.this$0.setContentRecordingSession(incomingSession);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(origId);
            return r2;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(origId);
            throw th;
        L17:
            throw new SecurityException("Unable to set ContentRecordingSession on non-current MediaProjection");     // Catch: Throwable -> L14
        }

        public void requestConsentForInvalidProjection(IMediaProjection projection) {
            requestConsentForInvalidProjection_enforcePermission();
            Object r0 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (isCurrentProjection(projection) == true) goto L12;
            Slog.v(MediaProjectionManagerService.TAG, "Reusing token: Won't request consent again for a token that isn't current");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            if (MediaProjectionManagerService.m5825$$Nest$fgetmMediaProjectionStopController(this.this$0).isStartForbidden(MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0)) == false) goto L16;
            Slog.v(MediaProjectionManagerService.TAG, "Reusing token: Won't request consent while MediaProjection is restricted");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L9
            long token = Binder.clearCallingIdentity();
            this.this$0.requestConsentForInvalidProjection();     // Catch: Throwable -> L21
            Binder.restoreCallingIdentity(token);
            return;
        L21:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setUserReviewGrantedConsentResult(int consentResult, IMediaProjection projection) {
            setUserReviewGrantedConsentResult_enforcePermission();
            long token = Binder.clearCallingIdentity();
            this.this$0.setUserReviewGrantedConsentResult(consentResult, projection);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void notifyPermissionRequestInitiated(int hostProcessUid, int sessionCreationSource) {
            notifyPermissionRequestInitiated_enforcePermission();
            long token = Binder.clearCallingIdentity();
            this.this$0.notifyPermissionRequestInitiated(hostProcessUid, sessionCreationSource);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void notifyPermissionRequestDisplayed(int hostProcessUid) {
            notifyPermissionRequestDisplayed_enforcePermission();
            long token = Binder.clearCallingIdentity();
            this.this$0.notifyPermissionRequestDisplayed(hostProcessUid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void notifyPermissionRequestCancelled(int hostProcessUid) {
            notifyPermissionRequestCancelled_enforcePermission();
            long token = Binder.clearCallingIdentity();
            this.this$0.notifyPermissionRequestCancelled(hostProcessUid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void notifyAppSelectorDisplayed(int hostProcessUid) {
            notifyAppSelectorDisplayed_enforcePermission();
            long token = Binder.clearCallingIdentity();
            this.this$0.notifyAppSelectorDisplayed(hostProcessUid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void notifyWindowingModeChanged(int contentToRecord, int targetProcessUid, int windowingMode) {
            notifyWindowingModeChanged_enforcePermission();
            long token = Binder.clearCallingIdentity();
            this.this$0.notifyWindowingModeChanged(contentToRecord, targetProcessUid, windowingMode);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(MediaProjectionManagerService.m5821$$Nest$fgetmContext(this.this$0), MediaProjectionManagerService.TAG, pw) == true) goto L5;
            return;
        L5:
            long token = Binder.clearCallingIdentity();
            MediaProjectionManagerService.m5830$$Nest$mdump(this.this$0, pw);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        private boolean checkPermission(String packageName, String permission) {
            if (MediaProjectionManagerService.m5821$$Nest$fgetmContext(this.this$0).getPackageManager().checkPermission(permission, packageName) != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static class CallbackDelegate {
        private Map<IBinder, IMediaProjectionCallback> mClientCallbacks;
        private Handler mHandler;
        private final Object mLock;
        private Map<IBinder, IMediaProjectionWatcherCallback> mWatcherCallbacks;

        public static /* synthetic */ void $r8$lambda$Fa2bVa93zgMzmNpn6U8izJMdlyY(IMediaProjectionCallback r0, boolean r1) {
            lambda$dispatchVisibilityChanged$1(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$SJEaqO89vrpcq5DUBDoAXFgIFIg(IMediaProjectionCallback r0, int r1, int r2) {
            lambda$dispatchResize$0(r0, r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mdispatchEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5836$$Nest$mdispatchEvent(CallbackDelegate r0, MediaProjectionEvent r1, MediaProjectionInfo r2, ContentRecordingSession r3) {
            r0.dispatchEvent(r1, r2, r3);
        }

        CallbackDelegate(Looper callbackLooper) {
            this.mLock = new Object();
            this.mHandler = new Handler(callbackLooper, null, true);
            this.mClientCallbacks = new ArrayMap();
            this.mWatcherCallbacks = new ArrayMap();
        }

        public void add(IMediaProjectionCallback callback) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mClientCallbacks.put(callback.asBinder(), callback);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void add(IMediaProjectionWatcherCallback callback) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mWatcherCallbacks.put(callback.asBinder(), callback);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void remove(IMediaProjectionCallback callback) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mClientCallbacks.remove(callback.asBinder());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void remove(IMediaProjectionWatcherCallback callback) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mWatcherCallbacks.remove(callback.asBinder());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void dispatchStart(MediaProjection projection) {
            if (projection != null) goto L5;
            Slog.e(MediaProjectionManagerService.TAG, "Tried to dispatch start notification for a null media projection. Ignoring!");
            return;
        L5:
            Object r0 = this.mLock;
            monitor-enter(r0);
            Iterator<IMediaProjectionWatcherCallback> r1 = this.mWatcherCallbacks.values().iterator();     // Catch: Throwable -> L11
        L9:
            if (r1.hasNext() == false) goto L13;
            IMediaProjectionWatcherCallback callback = r1.next();     // Catch: Throwable -> L11
            MediaProjectionInfo info = projection.getProjectionInfo();     // Catch: Throwable -> L11
            this.mHandler.post(new WatcherStartCallback(info, callback));     // Catch: Throwable -> L11
            goto L9
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void dispatchStop(MediaProjection projection) {
            if (projection != null) goto L5;
            Slog.e(MediaProjectionManagerService.TAG, "Tried to dispatch stop notification for a null media projection. Ignoring!");
            return;
        L5:
            Object r0 = this.mLock;
            monitor-enter(r0);
            Iterator<IMediaProjectionCallback> r1 = this.mClientCallbacks.values().iterator();     // Catch: Throwable -> L11
        L9:
            if (r1.hasNext() == false) goto L13;
            IMediaProjectionCallback callback = r1.next();     // Catch: Throwable -> L11
            this.mHandler.post(new ClientStopCallback(callback));     // Catch: Throwable -> L11
            goto L9
        L13:
            Iterator<IMediaProjectionWatcherCallback> r2 = this.mWatcherCallbacks.values().iterator();     // Catch: Throwable -> L11
        L15:
            if (r2.hasNext() == false) goto L17;
            IMediaProjectionWatcherCallback callback2 = r2.next();     // Catch: Throwable -> L11
            MediaProjectionInfo info = projection.getProjectionInfo();     // Catch: Throwable -> L11
            this.mHandler.post(new WatcherStopCallback(info, callback2));     // Catch: Throwable -> L11
            goto L15
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private void dispatchEvent(MediaProjectionEvent event, MediaProjectionInfo info, ContentRecordingSession session) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Iterator<IMediaProjectionWatcherCallback> r1 = this.mWatcherCallbacks.values().iterator();     // Catch: Throwable -> L8
        L6:
            if (r1.hasNext() == false) goto L10;
            IMediaProjectionWatcherCallback callback = r1.next();     // Catch: Throwable -> L8
            this.mHandler.post(new WatcherEventCallback(callback, event, info, session));     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void dispatchSession(MediaProjectionInfo projectionInfo, ContentRecordingSession session) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Iterator<IMediaProjectionWatcherCallback> r1 = this.mWatcherCallbacks.values().iterator();     // Catch: Throwable -> L8
        L6:
            if (r1.hasNext() == false) goto L10;
            IMediaProjectionWatcherCallback callback = r1.next();     // Catch: Throwable -> L8
            this.mHandler.post(new WatcherSessionCallback(callback, projectionInfo, session));     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void dispatchResize(MediaProjection projection, final int width, final int height) {
            if (projection != null) goto L5;
            Slog.e(MediaProjectionManagerService.TAG, "Tried to dispatch resize notification for a null media projection. Ignoring!");
            return;
        L5:
            Object r0 = this.mLock;
            monitor-enter(r0);
            Iterator<IMediaProjectionCallback> r1 = this.mClientCallbacks.values().iterator();     // Catch: Throwable -> L11
        L9:
            if (r1.hasNext() == false) goto L13;
            final IMediaProjectionCallback callback = r1.next();     // Catch: Throwable -> L11
            this.mHandler.post(new MediaProjectionManagerService$CallbackDelegate$$ExternalSyntheticLambda0(callback, width, height));     // Catch: Throwable -> L11
            goto L9
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$dispatchResize$0(IMediaProjectionCallback callback, int width, int height) {
            callback.onCapturedContentResize(width, height);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(MediaProjectionManagerService.TAG, "Failed to notify media projection has resized to " + width + " x " + height, e);
        }

        public void dispatchVisibilityChanged(MediaProjection projection, final boolean isVisible) {
            if (projection != null) goto L5;
            Slog.e(MediaProjectionManagerService.TAG, "Tried to dispatch visibility changed notification for a null media projection. Ignoring!");
            return;
        L5:
            Object r0 = this.mLock;
            monitor-enter(r0);
            Iterator<IMediaProjectionCallback> r1 = this.mClientCallbacks.values().iterator();     // Catch: Throwable -> L11
        L9:
            if (r1.hasNext() == false) goto L13;
            final IMediaProjectionCallback callback = r1.next();     // Catch: Throwable -> L11
            this.mHandler.post(new MediaProjectionManagerService$CallbackDelegate$$ExternalSyntheticLambda1(callback, isVisible));     // Catch: Throwable -> L11
            goto L9
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$dispatchVisibilityChanged$1(IMediaProjectionCallback callback, boolean isVisible) {
            callback.onCapturedContentVisibilityChanged(isVisible);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(MediaProjectionManagerService.TAG, "Failed to notify media projection has captured content visibility change to " + isVisible, e);
        }
    }

    private static final class ClientStopCallback implements Runnable {
        private IMediaProjectionCallback mCallback;

        public ClientStopCallback(IMediaProjectionCallback callback) {
            this.mCallback = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mCallback.onStop();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(MediaProjectionManagerService.TAG, "Failed to notify media projection has stopped", e);
        }
    }

    interface Clock {
        long uptimeMillis();
    }

    static class Injector {
        Injector() {
        }

        boolean shouldMediaProjectionPreventReusingConsent(MediaProjection projection) {
            return CompatChanges.isChangeEnabled(MediaProjectionManagerService.MEDIA_PROJECTION_PREVENTS_REUSING_CONSENT, projection.packageName, UserHandle.getUserHandleForUid(projection.uid));
        }

        Clock createClock() {
            return new MediaProjectionManagerService$Injector$$ExternalSyntheticLambda0();
        }

        Looper createCallbackLooper() {
            return Looper.getMainLooper();
        }

        MediaProjectionMetricsLogger mediaProjectionMetricsLogger(Context context) {
            return MediaProjectionMetricsLogger.getInstance(context);
        }
    }

    final class MediaProjection extends IMediaProjection.Stub {
        private IMediaProjectionCallback mCallback;
        private int mCountStarts;
        private final long mCreateTimeMillis;
        private IBinder.DeathRecipient mDeathEater;
        final long mDefaultTimeoutMillis;
        private final int mDisplayId;
        private final boolean mIsPrivileged;
        private ActivityOptions.LaunchCookie mLaunchCookie;
        private boolean mRestoreSystemAlertWindow;
        public IMediaProjectionManagerServiceExt mServiceExt;
        private ContentRecordingSession mSession;
        private final int mTargetSdkVersion;
        private int mTaskId;
        private final long mTimeoutMillis;
        private IBinder mToken;
        private final int mType;
        private int mVirtualDisplayId;
        public final String packageName;
        final /* synthetic */ MediaProjectionManagerService this$0;
        public final int uid;
        public final UserHandle userHandle;

        public static /* synthetic */ void $r8$lambda$NnShKJPHvOB46A1R7bI3fcnZ2OY(MediaProjection r0) {
            r0.lambda$stop$1();
        }

        public static /* synthetic */ void $r8$lambda$pSaMeYhcLhUPzKCyAZ6BcuCIr3E(MediaProjection r0, IMediaProjectionCallback r1) {
            r0.lambda$start$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ ContentRecordingSession m5837$$Nest$fgetmSession(MediaProjection r0) {
            return r0.mSession;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTaskId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5838$$Nest$fgetmTaskId(MediaProjection r0) {
            return r0.mTaskId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmVirtualDisplayId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5839$$Nest$fgetmVirtualDisplayId(MediaProjection r0) {
            return r0.mVirtualDisplayId;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5840$$Nest$fputmSession(MediaProjection r0, ContentRecordingSession r1) {
            r0.mSession = r1;
        }

        MediaProjection(MediaProjectionManagerService this$0, int type, int uid, String packageName, int targetSdkVersion, boolean isPrivileged, int displayId) {
            this.this$0 = this$0;
            this.mDefaultTimeoutMillis = Duration.ofMinutes(5).toMillis();
            this.mTimeoutMillis = this.mDefaultTimeoutMillis;
            this.mTaskId = -1;
            this.mLaunchCookie = null;
            this.mCountStarts = 0;
            this.mVirtualDisplayId = -1;
            this.mType = type;
            this.uid = uid;
            this.packageName = packageName;
            this.userHandle = new UserHandle(UserHandle.getUserId(uid));
            this.mTargetSdkVersion = targetSdkVersion;
            this.mIsPrivileged = isPrivileged;
            this.mCreateTimeMillis = MediaProjectionManagerService.m5820$$Nest$fgetmClock(this$0).uptimeMillis();
            MediaProjectionManagerService.m5817$$Nest$fgetmActivityManagerInternal(this$0).notifyMediaProjectionEvent(uid, asBinder(), 0);
            this.mDisplayId = displayId;
        }

        int getVirtualDisplayId() {
            return this.mVirtualDisplayId;
        }

        public boolean canProjectVideo() {
            if (this.mType != 1) goto L5;
            return true;
        L5:
            if (this.mType == 0) goto L10;
            return false;
        L10:
            return true;
        }

        public boolean canProjectSecureVideo() {
            return false;
        }

        public boolean canProjectAudio() {
            if (this.mType != 1) goto L5;
            return true;
        L5:
            if (this.mType != 2) goto L7;
            return true;
        L7:
            if (this.mType == 0) goto L13;
            return false;
        L13:
            return true;
        }

        public int applyVirtualDisplayFlags(int flags) {
            applyVirtualDisplayFlags_enforcePermission();
            if (this.mType != 0) goto L7;
            return (flags & (-9)) | 18;
        L7:
            if (this.mType != 1) goto L11;
            return (flags & (-18)) | 10;
        L11:
            if (this.mType != 2) goto L15;
            return (flags & (-9)) | 19;
        L15:
            throw new RuntimeException("Unknown MediaProjection type");
        }

        public void start(final IMediaProjectionCallback callback) {
            if (callback == null) goto L52;
            Slog.v(MediaProjectionManagerService.TAG, "Start the token instance " + this + " uid=" + this.uid);
            boolean hasFGS = MediaProjectionManagerService.m5817$$Nest$fgetmActivityManagerInternal(this.this$0).hasRunningForegroundService(this.uid, 32);
            Object r2 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
            this.mServiceExt.MediaProjection_start_onStart();     // Catch: Throwable -> L11
            if (this.this$0.isCurrentProjection(asBinder()) == false) goto L14;
            Slog.w(MediaProjectionManagerService.TAG, "UID " + Binder.getCallingUid() + " attempted to start already started MediaProjection");     // Catch: Throwable -> L11
            this.mCountStarts = this.mCountStarts + 1;     // Catch: Throwable -> L11
            this.mServiceExt.MediaProjection_start_onFailure("ALREADY_STARTED", null);     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            return;
        L14:
            if (requiresForegroundService() == false) goto L19;
            if (hasFGS == true) goto L19;
            SecurityException ex = new SecurityException("Media projections require a foreground service of type ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PROJECTION");     // Catch: Throwable -> L11
            this.mServiceExt.MediaProjection_start_onFailure("FGS_REQUIRED", ex);     // Catch: Throwable -> L11
            throw ex;     // Catch: Throwable -> L11
        L19:
            SysOptBridge.getFactory().getProcessStatusChecker().addRecordingUid(this.uid);     // Catch: Throwable -> L11
            this.mToken = callback.asBinder();     // Catch: Throwable -> L11 RemoteException -> L46
            this.mDeathEater = new MediaProjectionManagerService$MediaProjection$$ExternalSyntheticLambda0(this, callback);     // Catch: Throwable -> L11 RemoteException -> L46
            this.mToken.linkToDeath(this.mDeathEater, 0);     // Catch: Throwable -> L11 RemoteException -> L46
        L22:
            if (this.mType != 0) goto L43;
            long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
            PackageInfo packageInfo = MediaProjectionManagerService.m5827$$Nest$fgetmPackageManager(this.this$0).getPackageInfoAsUser(this.packageName, 4096, UserHandle.getUserId(this.uid));     // Catch: Throwable -> L30 PackageManager.NameNotFoundException -> L32
            if (ArrayUtils.contains(packageInfo.requestedPermissions, "android.permission.SYSTEM_ALERT_WINDOW") == false) goto L34;
            int currentMode = MediaProjectionManagerService.m5818$$Nest$fgetmAppOps(this.this$0).unsafeCheckOpRawNoThrow(24, this.uid, this.packageName);     // Catch: Throwable -> L30 PackageManager.NameNotFoundException -> L32
            if (currentMode != 3) goto L34;
            MediaProjectionManagerService.m5818$$Nest$fgetmAppOps(this.this$0).setMode(24, this.uid, this.packageName, 0);     // Catch: Throwable -> L30 PackageManager.NameNotFoundException -> L32
            this.mRestoreSystemAlertWindow = true;     // Catch: Throwable -> L30 PackageManager.NameNotFoundException -> L32
        L34:
            Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L11
        L30:
            th = move-exception;
            Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L32:
            e = move-exception;
            Slog.w(MediaProjectionManagerService.TAG, "Package not found, aborting MediaProjection", e);     // Catch: Throwable -> L30
            Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L11
            return;
        L43:
            MediaProjectionManagerService.m5833$$Nest$mstartProjectionLocked(this.this$0, this);     // Catch: Throwable -> L11
            this.mCallback = callback;     // Catch: Throwable -> L11
            registerCallback(this.mCallback);     // Catch: Throwable -> L11
            this.mCountStarts++;     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            return;
        L46:
            e = move-exception;
            Slog.w(MediaProjectionManagerService.TAG, "MediaProjectionCallbacks must be valid, aborting MediaProjection", e);     // Catch: Throwable -> L11
            this.mServiceExt.MediaProjection_start_onFailure("CALLBACK_INVALID", e);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        L52:
            Object r1 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            this.mServiceExt.MediaProjection_start_onFailure("NULL_CALLBACK", null);     // Catch: Throwable -> L58
            monitor-exit(r1);     // Catch: Throwable -> L58
            throw new IllegalArgumentException("callback must not be null");
        L58:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$start$0(IMediaProjectionCallback callback) {
            Slog.d(MediaProjectionManagerService.TAG, "Content Recording: MediaProjection stopped by Binder death - id= " + this.mVirtualDisplayId);
            MediaProjectionManagerService.m5819$$Nest$fgetmCallbackDelegate(this.this$0).remove(callback);
            stop(2);
        }

        public void stop(int stopReason) {
            SysOptBridge.getFactory().getProcessStatusChecker().removeRecordingUid(this.uid);
            Object r0 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.isCurrentProjection(asBinder()) == true) goto L12;
            Slog.w(MediaProjectionManagerService.TAG, "Attempted to stop inactive MediaProjection (uid=" + Binder.getCallingUid() + ", pid=" + Binder.getCallingPid() + ")");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            if (this.mRestoreSystemAlertWindow == false) goto L23;
            long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            int currentMode = MediaProjectionManagerService.m5818$$Nest$fgetmAppOps(this.this$0).unsafeCheckOpRawNoThrow(24, this.uid, this.packageName);     // Catch: Throwable -> L17
            if (currentMode != 0) goto L19;
            MediaProjectionManagerService.m5818$$Nest$fgetmAppOps(this.this$0).setMode(24, this.uid, this.packageName, 3);     // Catch: Throwable -> L17
        L19:
            this.mRestoreSystemAlertWindow = false;     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L9
            goto L23
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L23:
            Slog.d(MediaProjectionManagerService.TAG, "Content Recording: handling stopping this projection token createTime= " + this.mCreateTimeMillis + " countStarts= " + this.mCountStarts);     // Catch: Throwable -> L9
            MediaProjectionManagerService.m5834$$Nest$mstopProjectionLocked(this.this$0, this, stopReason);     // Catch: Throwable -> L9
            this.mServiceExt.MediaProjection_stop_onEnd(stopReason);     // Catch: Throwable -> L9
            this.mToken.unlinkToDeath(this.mDeathEater, 0);     // Catch: Throwable -> L9
            this.mToken = null;     // Catch: Throwable -> L9
            unregisterCallback(this.mCallback);     // Catch: Throwable -> L9
            this.mCallback = null;     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            MediaProjectionManagerService.m5822$$Nest$fgetmHandler(this.this$0).post(new MediaProjectionManagerService$MediaProjection$$ExternalSyntheticLambda1(this));
        }

        private /* synthetic */ void lambda$stop$1() {
            MediaProjectionManagerService.m5817$$Nest$fgetmActivityManagerInternal(this.this$0).notifyMediaProjectionEvent(this.uid, asBinder(), 1);
        }

        public void registerCallback(IMediaProjectionCallback callback) {
            if (callback == null) goto L6;
            MediaProjectionManagerService.m5819$$Nest$fgetmCallbackDelegate(this.this$0).add(callback);
            return;
        L6:
            throw new IllegalArgumentException("callback must not be null");
        }

        public void unregisterCallback(IMediaProjectionCallback callback) {
            if (callback == null) goto L6;
            MediaProjectionManagerService.m5819$$Nest$fgetmCallbackDelegate(this.this$0).remove(callback);
            return;
        L6:
            throw new IllegalArgumentException("callback must not be null");
        }

        public void setLaunchCookie(ActivityOptions.LaunchCookie launchCookie) {
            setLaunchCookie_enforcePermission();
            this.mLaunchCookie = launchCookie;
        }

        public void setTaskId(int taskId) {
            setTaskId_enforcePermission();
            this.mTaskId = taskId;
        }

        public ActivityOptions.LaunchCookie getLaunchCookie() {
            getLaunchCookie_enforcePermission();
            return this.mLaunchCookie;
        }

        public int getTaskId() {
            getTaskId_enforcePermission();
            return this.mTaskId;
        }

        public int getDisplayId() {
            return this.mDisplayId;
        }

        long getCreateTimeMillis() {
            return this.mCreateTimeMillis;
        }

        public boolean isValid() {
            isValid_enforcePermission();
            Object r0 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            long curMillis = MediaProjectionManagerService.m5820$$Nest$fgetmClock(this.this$0).uptimeMillis();     // Catch: Throwable -> L17
            if ((curMillis - this.mCreateTimeMillis) <= this.mTimeoutMillis) goto L7;
            boolean hasTimedOut = true;
        L9:
            if (this.mVirtualDisplayId == (-1)) goto L11;
            boolean virtualDisplayCreated = true;
        L12:
            if (hasTimedOut == false) goto L14;
        L19:
            boolean isValid = false;
        L21:
            if (isValid == false) goto L25;
            monitor-exit(r0);     // Catch: Throwable -> L17
            return true;
        L25:
            if (MediaProjectionManagerService.m5823$$Nest$fgetmInjector(this.this$0).shouldMediaProjectionPreventReusingConsent(MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0)) == true) goto L28;
            monitor-exit(r0);     // Catch: Throwable -> L17
            return false;
        L28:
            Slog.v(MediaProjectionManagerService.TAG, "Reusing token: Throw exception due to invalid projection.");     // Catch: Throwable -> L17
            MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0).stop(10);     // Catch: Throwable -> L17
            throw new SecurityException("Don't re-use the resultData to retrieve the same projection instance, and don't use a token that has timed out. Don't take multiple captures by invoking MediaProjection#createVirtualDisplay multiple times on the same instance.");     // Catch: Throwable -> L17
        L14:
            if (this.mCountStarts > 1) goto L19;
            if (virtualDisplayCreated == true) goto L19;
            isValid = true;
            goto L21
        L11:
            virtualDisplayCreated = false;
            goto L12
        L7:
            hasTimedOut = false;
        L17:
            th = move-exception;
            throw th;
        }

        public void notifyVirtualDisplayCreated(int displayId) {
            notifyVirtualDisplayCreated_enforcePermission();
            Object r0 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (MediaProjectionManagerService.m5825$$Nest$fgetmMediaProjectionStopController(this.this$0).isStartForbidden(MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0)) == false) goto L11;
            Slog.w(MediaProjectionManagerService.TAG, "Content Recording: MediaProjection start disallowed, aborting MediaProjection");     // Catch: Throwable -> L9
            stop(3);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            this.mVirtualDisplayId = displayId;     // Catch: Throwable -> L9
            if (this.mSession != null) goto L14;
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L14:
            if (this.mSession.getVirtualDisplayId() != (-1)) goto L18;
            Slog.v(MediaProjectionManagerService.TAG, "Virtual display now created, so update session with the virtual display id");     // Catch: Throwable -> L9
            this.mSession.setVirtualDisplayId(this.mVirtualDisplayId);     // Catch: Throwable -> L9
            if (this.this$0.setContentRecordingSession(this.mSession) == true) goto L18;
            Slog.e(MediaProjectionManagerService.TAG, "Failed to set session for virtual display id");     // Catch: Throwable -> L9
            goto L18
        }

        public MediaProjectionInfo getProjectionInfo() {
            return new MediaProjectionInfo(this.packageName, this.userHandle, this.mLaunchCookie);
        }

        boolean requiresForegroundService() {
            if (this.mTargetSdkVersion >= 29) goto L5;
        L7:
            return false;
        L5:
            if (this.mIsPrivileged == true) goto L7;
            return true;
        }

        public void dump(PrintWriter pw) {
            pw.println("(" + this.packageName + ", uid=" + this.uid + "): " + MediaProjectionManagerService.m5835$$Nest$smtypeToString(this.mType));
        }
    }

    private class MediaRouterCallback extends MediaRouter.SimpleCallback {
        final /* synthetic */ MediaProjectionManagerService this$0;

        /* synthetic */ MediaRouterCallback(MediaProjectionManagerService r1, MediaProjectionManagerServiceIA r2) {
            this(r1);
        }

        private MediaRouterCallback(MediaProjectionManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.media.MediaRouter.SimpleCallback, android.media.MediaRouter.Callback
        public void onRouteSelected(MediaRouter router, int type, MediaRouter.RouteInfo info) {
            Object r0 = MediaProjectionManagerService.m5824$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            if ((type & 4) != 0) goto L15;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L15:
            MediaProjectionManagerService.m5829$$Nest$fputmMediaRouteInfo(this.this$0, info);     // Catch: Throwable -> L9
            if (MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0) == null) goto L11;
            Slog.d(MediaProjectionManagerService.TAG, "Content Recording: Stopped MediaProjection due to route type of REMOTE_DISPLAY not selected");     // Catch: Throwable -> L9
            MediaProjectionManagerService.m5828$$Nest$fgetmProjectionGrant(this.this$0).stop(9);     // Catch: Throwable -> L9
            goto L11
        }

        @Override // android.media.MediaRouter.SimpleCallback, android.media.MediaRouter.Callback
        public void onRouteUnselected(MediaRouter route, int type, MediaRouter.RouteInfo info) {
            if (MediaProjectionManagerService.m5826$$Nest$fgetmMediaRouteInfo(this.this$0) != info) goto L6;
            MediaProjectionManagerService.m5829$$Nest$fputmMediaRouteInfo(this.this$0, null);
            return;
        }
    }

    private static final class WatcherEventCallback implements Runnable {
        private final IMediaProjectionWatcherCallback mCallback;
        private final MediaProjectionEvent mEvent;
        private final MediaProjectionInfo mProjectionInfo;
        private final ContentRecordingSession mSession;

        WatcherEventCallback(IMediaProjectionWatcherCallback callback, MediaProjectionEvent event, MediaProjectionInfo projectionInfo, ContentRecordingSession session) {
            this.mCallback = callback;
            this.mEvent = event;
            this.mProjectionInfo = projectionInfo;
            this.mSession = session;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mCallback.onMediaProjectionEvent(this.mEvent, this.mProjectionInfo, this.mSession);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(MediaProjectionManagerService.TAG, "Failed to notify MediaProjectionEvent change", e);
        }
    }

    private static final class WatcherSessionCallback implements Runnable {
        private final IMediaProjectionWatcherCallback mCallback;
        private final MediaProjectionInfo mProjectionInfo;
        private final ContentRecordingSession mSession;

        WatcherSessionCallback(IMediaProjectionWatcherCallback callback, MediaProjectionInfo projectionInfo, ContentRecordingSession session) {
            this.mCallback = callback;
            this.mProjectionInfo = projectionInfo;
            this.mSession = session;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mCallback.onRecordingSessionSet(this.mProjectionInfo, this.mSession);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(MediaProjectionManagerService.TAG, "Failed to notify content recording session changed", e);
        }
    }

    private static final class WatcherStartCallback implements Runnable {
        private IMediaProjectionWatcherCallback mCallback;
        private MediaProjectionInfo mInfo;

        public WatcherStartCallback(MediaProjectionInfo info, IMediaProjectionWatcherCallback callback) {
            this.mInfo = info;
            this.mCallback = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mCallback.onStart(this.mInfo);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(MediaProjectionManagerService.TAG, "Failed to notify media projection has started", e);
        }
    }

    private static final class WatcherStopCallback implements Runnable {
        private IMediaProjectionWatcherCallback mCallback;
        private MediaProjectionInfo mInfo;

        public WatcherStopCallback(MediaProjectionInfo info, IMediaProjectionWatcherCallback callback) {
            this.mInfo = info;
            this.mCallback = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mCallback.onStop(this.mInfo);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(MediaProjectionManagerService.TAG, "Failed to notify media projection has stopped", e);
        }
    }

    public static /* synthetic */ void $r8$lambda$VZMDiw60tHV95Fyz9QDE__iDpMs(MediaProjectionManagerService r0, MediaProjectionEvent r1) {
        r0.lambda$maybeStopMediaProjection$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$jk_Lw_5XLA0KRD4zZfV2F6Mj4cc(MediaProjectionManagerService r0, int r1) {
        r0.maybeStopMediaProjection(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m5817$$Nest$fgetmActivityManagerInternal(MediaProjectionManagerService r0) {
        return r0.mActivityManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOps, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsManager m5818$$Nest$fgetmAppOps(MediaProjectionManagerService r0) {
        return r0.mAppOps;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbackDelegate, reason: not valid java name */
    static /* bridge */ /* synthetic */ CallbackDelegate m5819$$Nest$fgetmCallbackDelegate(MediaProjectionManagerService r0) {
        return r0.mCallbackDelegate;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Clock m5820$$Nest$fgetmClock(MediaProjectionManagerService r0) {
        return r0.mClock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m5821$$Nest$fgetmContext(MediaProjectionManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m5822$$Nest$fgetmHandler(MediaProjectionManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m5823$$Nest$fgetmInjector(MediaProjectionManagerService r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5824$$Nest$fgetmLock(MediaProjectionManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMediaProjectionStopController, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaProjectionStopController m5825$$Nest$fgetmMediaProjectionStopController(MediaProjectionManagerService r0) {
        return r0.mMediaProjectionStopController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMediaRouteInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaRouter.RouteInfo m5826$$Nest$fgetmMediaRouteInfo(MediaProjectionManagerService r0) {
        return r0.mMediaRouteInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m5827$$Nest$fgetmPackageManager(MediaProjectionManagerService r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProjectionGrant, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaProjection m5828$$Nest$fgetmProjectionGrant(MediaProjectionManagerService r0) {
        return r0.mProjectionGrant;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMediaRouteInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5829$$Nest$fputmMediaRouteInfo(MediaProjectionManagerService r0, MediaRouter.RouteInfo r1) {
        r0.mMediaRouteInfo = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5830$$Nest$mdump(MediaProjectionManagerService r0, PrintWriter r1) {
        r0.dump(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleForegroundServicesChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5831$$Nest$mhandleForegroundServicesChanged(MediaProjectionManagerService r0, int r1, int r2, int r3) {
        r0.handleForegroundServicesChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5832$$Nest$mremoveCallback(MediaProjectionManagerService r0, IMediaProjectionWatcherCallback r1) {
        r0.removeCallback(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartProjectionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5833$$Nest$mstartProjectionLocked(MediaProjectionManagerService r0, MediaProjection r1) {
        r0.startProjectionLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstopProjectionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5834$$Nest$mstopProjectionLocked(MediaProjectionManagerService r0, MediaProjection r1, int r2) {
        r0.stopProjectionLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smtypeToString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5835$$Nest$smtypeToString(int r0) {
        return typeToString(r0);
    }

    static {
        sNextSessionId = new AtomicInteger(1);
    }

    public MediaProjectionManagerService(Context context) {
        this(context, new Injector());
    }

    MediaProjectionManagerService(Context context, Injector injector) {
        super(context);
        this.mLock = new Object();
        this.mContext = context;
        this.mInjector = injector;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mClock = injector.createClock();
        this.mDeathEaters = new ArrayMap();
        this.mCallbackDelegate = new CallbackDelegate(injector.createCallbackLooper());
        this.mAppOps = (AppOpsManager) this.mContext.getSystemService("appops");
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mPackageManager = this.mContext.getPackageManager();
        this.mWmInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mMediaRouter = (MediaRouter) this.mContext.getSystemService("media_router");
        this.mMediaRouterCallback = new MediaRouterCallback(this, null);
        this.mMediaProjectionMetricsLogger = injector.mediaProjectionMetricsLogger(context);
        this.mMediaProjectionStopController = new MediaProjectionStopController(context, new MediaProjectionManagerService$$ExternalSyntheticLambda0(this));
        Watchdog.getInstance().addMonitor(this);
        this.mExt = IMediaProjectionManagerServiceExt.get(this);
    }

    private void maybeStopMediaProjection(int reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mMediaProjectionStopController.isExemptFromStopping(this.mProjectionGrant, reason) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mMediaProjectionStopController.isStopReasonCallEnd(reason) == false) goto L13;
        final MediaProjectionEvent event = new MediaProjectionEvent(0, System.currentTimeMillis());     // Catch: Throwable -> L8
        Slog.d(TAG, "Scheduling event: " + event.getEventType() + " for reason: " + MediaProjectionStopController.stopReasonToString(reason));     // Catch: Throwable -> L8
        this.mHandler.postDelayed(new MediaProjectionManagerService$$ExternalSyntheticLambda1(this, event), 500);     // Catch: Throwable -> L8
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        Slog.d(TAG, "Stopping MediaProjection due to reason: " + MediaProjectionStopController.stopReasonToString(reason));     // Catch: Throwable -> L8
        this.mProjectionGrant.stop(3);     // Catch: Throwable -> L8
        goto L14
    }

    private /* synthetic */ void lambda$maybeStopMediaProjection$0(MediaProjectionEvent event) {
        dispatchEvent(event);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("media_projection", new BinderService(this, this.mContext), false);
        this.mMediaRouter.addCallback(4, this.mMediaRouterCallback, 8);
        this.mActivityManagerInternal.registerProcessObserver(new AnonymousClass1(this));
        this.mMediaProjectionStopController.startTrackingStopReasons(this.mContext);
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        this.mMediaRouter.rebindAsUser(to.getUserIdentifier());
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mProjectionGrant == null) goto L9;
        Slog.d(TAG, "Content Recording: Stopped MediaProjection due to user switching");     // Catch: Throwable -> L7
        this.mProjectionGrant.stop(6);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    @Override // com.android.server.Watchdog.Monitor
    public void monitor() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void handleForegroundServicesChanged(int pid, int uid, int serviceTypes) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mProjectionGrant == null) goto L30;
        if (this.mProjectionGrant.uid != uid) goto L30;
        if (this.mProjectionGrant.requiresForegroundService() == true) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (this.mActivityManagerInternal.hasRunningForegroundService(uid, 32) == false) goto L19;
        return;
    L19:
        Object r1 = this.mLock;
        monitor-enter(r1);
        Slog.d(TAG, "Content Recording: Stopped MediaProjection due to foreground service change");     // Catch: Throwable -> L24
        if (this.mProjectionGrant == null) goto L26;
        this.mProjectionGrant.stop(7);     // Catch: Throwable -> L24
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    L30:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    private void startProjectionLocked(MediaProjection projection) {
        if (this.mProjectionGrant == null) goto L6;
        Slog.d(TAG, "Content Recording: Stopped MediaProjection to start new incoming projection");
        this.mProjectionGrant.stop(8);
    L6:
        if (this.mExt.skipSwitchMediarouter() == false) goto L8;
    L10:
        this.mProjectionToken = projection.asBinder();
        this.mProjectionGrant = projection;
        dispatchStart(projection);
        projection.mServiceExt.startProjectionLocked_onEnd();
        return;
    L8:
        if (this.mMediaRouteInfo == null) goto L10;
        this.mMediaRouter.getFallbackRoute().select();
        goto L10
    }

    private void stopProjectionLocked(MediaProjection projection, int stopReason) {
        Slog.d(TAG, "Content Recording: Stopped active MediaProjection and dispatching stop to callbacks");
        ContentRecordingSession session = MediaProjection.m5837$$Nest$fgetmSession(projection);
        if (session == null) goto L5;
        int targetUid = session.getTargetUid();
    L6:
        this.mMediaProjectionMetricsLogger.logStopped(projection.uid, targetUid, stopReason);
        this.mProjectionToken = null;
        this.mProjectionGrant = null;
        SysOptBridge.getFactory().getProcessStatusChecker().removeRecordingUid(projection.uid);
        dispatchStop(projection);
        return;
    L5:
        targetUid = -2;
        goto L6
    }

    MediaProjectionInfo addCallback(final IMediaProjectionWatcherCallback callback) {
        IBinder.DeathRecipient deathRecipient = new AnonymousClass2(this, callback);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mCallbackDelegate.add(callback);     // Catch: Throwable -> L7
        linkDeathRecipientLocked(callback, deathRecipient);     // Catch: Throwable -> L7
        if (this.mProjectionGrant == null) goto L9;
        MediaProjectionInfo r2 = this.mProjectionGrant.getProjectionInfo();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeCallback(IMediaProjectionWatcherCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        unlinkDeathRecipientLocked(callback);     // Catch: Throwable -> L7
        this.mCallbackDelegate.remove(callback);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void linkDeathRecipientLocked(IMediaProjectionWatcherCallback callback, IBinder.DeathRecipient deathRecipient) {
        IBinder token = callback.asBinder();     // Catch: RemoteException -> L4
        token.linkToDeath(deathRecipient, 0);     // Catch: RemoteException -> L4
        this.mDeathEaters.put(token, deathRecipient);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to link to death for media projection monitoring callback", e);
    }

    private void unlinkDeathRecipientLocked(IMediaProjectionWatcherCallback callback) {
        IBinder token = callback.asBinder();
        IBinder.DeathRecipient deathRecipient = this.mDeathEaters.remove(token);
        if (deathRecipient == null) goto L6;
        token.unlinkToDeath(deathRecipient, 0);
        return;
    }

    private void dispatchStart(MediaProjection projection) {
        this.mCallbackDelegate.dispatchStart(projection);
    }

    private void dispatchStop(MediaProjection projection) {
        this.mCallbackDelegate.dispatchStop(projection);
    }

    private void dispatchSessionSet(MediaProjectionInfo projectionInfo, ContentRecordingSession session) {
        this.mCallbackDelegate.dispatchSession(projectionInfo, session);
    }

    private void dispatchEvent(MediaProjectionEvent event) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ContentRecordingSession session = null;
        if (this.mProjectionGrant == null) goto L9;
        MediaProjectionInfo projectionInfo = this.mProjectionGrant.getProjectionInfo();     // Catch: Throwable -> L7
    L11:
        if (this.mProjectionGrant == null) goto L14;
        session = MediaProjection.m5837$$Nest$fgetmSession(this.mProjectionGrant);     // Catch: Throwable -> L7
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L7
        CallbackDelegate.m5836$$Nest$mdispatchEvent(this.mCallbackDelegate, event, projectionInfo, session);
        return;
    L9:
        projectionInfo = null;
    L7:
        th = move-exception;
        throw th;
    }

    boolean setContentRecordingSession(ContentRecordingSession incomingSession) {
        boolean setSessionSucceeded = this.mWmInternal.setContentRecordingSession(incomingSession);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mProjectionGrant == null) goto L9;
        this.mProjectionGrant.mServiceExt.setContentRecordingSession_onEnd(incomingSession, setSessionSucceeded);     // Catch: Throwable -> L7
    L9:
        if (setSessionSucceeded == true) goto L20;
        if (this.mProjectionGrant == null) goto L16;
        if (incomingSession == null) goto L14;
        String projectionType = ContentRecordingSession.recordContentToString(incomingSession.getContentToRecord());     // Catch: Throwable -> L7
    L15:
        Slog.w(TAG, "Content Recording: Stopped MediaProjection due to failing to set ContentRecordingSession - id= " + this.mProjectionGrant.getVirtualDisplayId() + "type=" + projectionType);     // Catch: Throwable -> L7
        this.mProjectionGrant.stop(10);     // Catch: Throwable -> L7
        goto L16
    L14:
        projectionType = "none";
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return false;
    L20:
        if (this.mProjectionGrant == null) goto L25;
        MediaProjection.m5840$$Nest$fputmSession(this.mProjectionGrant, incomingSession);     // Catch: Throwable -> L7
        if (incomingSession == null) goto L24;
        this.mMediaProjectionMetricsLogger.logInProgress(this.mProjectionGrant.uid, incomingSession.getTargetUid());     // Catch: Throwable -> L7
    L24:
        dispatchSessionSet(this.mProjectionGrant.getProjectionInfo(), incomingSession);     // Catch: Throwable -> L7
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return true;
    }

    boolean isCurrentProjection(IBinder token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProjectionToken == null) goto L11;
        boolean r1 = this.mProjectionToken.equals(token);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    }

    void requestConsentForInvalidProjection() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Intent reviewConsentIntent = buildReviewGrantedConsentIntentLocked();     // Catch: Throwable -> L8
        int uid = this.mProjectionGrant.uid;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Slog.v(TAG, "Reusing token: Reshow dialog for due to invalid projection.");
        this.mContext.startActivityAsUser(reviewConsentIntent, UserHandle.getUserHandleForUid(uid));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private Intent buildReviewGrantedConsentIntentLocked() {
        String permissionDialogString = this.mContext.getResources().getString(R.string.config_satellite_test_with_esp_replies_intent_action);
        ComponentName mediaProjectionPermissionDialogComponent = ComponentName.unflattenFromString(permissionDialogString);
        return new Intent().setComponent(mediaProjectionPermissionDialogComponent).putExtra("extra_media_projection_user_consent_required", true).putExtra("extra_media_projection_package_reusing_consent", this.mProjectionGrant.packageName).setFlags(276824064);
    }

    void notifyPermissionRequestInitiated(int hostUid, int sessionCreationSource) {
        this.mMediaProjectionMetricsLogger.logInitiated(hostUid, sessionCreationSource);
    }

    void notifyPermissionRequestDisplayed(int hostUid) {
        this.mMediaProjectionMetricsLogger.logPermissionRequestDisplayed(hostUid);
    }

    void notifyPermissionRequestCancelled(int hostUid) {
        this.mMediaProjectionMetricsLogger.logProjectionPermissionRequestCancelled(hostUid);
    }

    void notifyAppSelectorDisplayed(int hostUid) {
        this.mMediaProjectionMetricsLogger.logAppSelectorDisplayed(hostUid);
    }

    void notifyWindowingModeChanged(int contentToRecord, int targetUid, int windowingMode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mProjectionGrant != null) goto L9;
        Slog.i(TAG, "Cannot log MediaProjectionTargetChanged atom due to null projection");     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mMediaProjectionMetricsLogger.logChangedWindowingMode(contentToRecord, this.mProjectionGrant.uid, targetUid, windowingMode);     // Catch: Throwable -> L7
        goto L10
    }

    void notifyCaptureBoundsChanged(int contentToRecord, int targetUid, Rect captureBounds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mProjectionGrant != null) goto L9;
        Slog.i(TAG, "Cannot log MediaProjectionTargetChanged atom due to null projection");     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mMediaProjectionMetricsLogger.logChangedCaptureBounds(contentToRecord, this.mProjectionGrant.uid, targetUid, captureBounds);     // Catch: Throwable -> L7
        goto L10
    }

    void setUserReviewGrantedConsentResult(int consentResult, IMediaProjection projection) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (consentResult != 1) goto L7;
    L10:
        boolean consentGranted = true;
    L11:
        IBinder taskWindowContainerToken = null;
        if (consentGranted == false) goto L26;
        if (projection != null) goto L54;
        IBinder r5 = null;
    L17:
        if (isCurrentProjection(r5) == true) goto L26;
        Slog.v(TAG, "Reusing token: Ignore consent result of " + consentResult + " for a token that isn't current");     // Catch: Throwable -> L21
        if (this.mProjectionGrant == null) goto L23;
        this.mProjectionGrant.mServiceExt.setUserReviewGrantedConsentResult_onEnd(consentResult, false, "INVALID_TOKEN_REUSE");     // Catch: Throwable -> L21
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L54:
        r5 = projection.asBinder();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L26:
        if (this.mProjectionGrant != null) goto L31;
        Slog.w(TAG, "Reusing token: Can't review consent with no ongoing projection.");     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L31:
        if (MediaProjection.m5837$$Nest$fgetmSession(this.mProjectionGrant) != null) goto L33;
    L49:
        Slog.w(TAG, "Reusing token: Ignore consent result " + consentResult + " if not waiting for the result.");     // Catch: Throwable -> L21
        this.mProjectionGrant.mServiceExt.setUserReviewGrantedConsentResult_onEnd(consentResult, false, "REUSE_NOT_WAITING");     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L33:
        if (MediaProjection.m5837$$Nest$fgetmSession(this.mProjectionGrant).isWaitingForConsent() == false) goto L49;
        this.mProjectionGrant.mServiceExt.setUserReviewGrantedConsentResult_onEnd(consentResult, true, null);     // Catch: Throwable -> L21
        Slog.v(TAG, "Reusing token: Handling user consent result " + consentResult);     // Catch: Throwable -> L21
        switch(consentResult) {
            case -1: goto L44;
            case 0: goto L44;
            case 1: goto L43;
            case 2: goto L39;
            default: goto L47;
        };     // Catch: Throwable -> L21
    L43:
        setReviewedConsentSessionLocked(ContentRecordingSession.createDisplaySession(0));     // Catch: Throwable -> L21
        goto L47
    L44:
        setReviewedConsentSessionLocked(null);     // Catch: Throwable -> L21
        if (this.mProjectionGrant == null) goto L47;
        Slog.w(TAG, "Content Recording: Stopped MediaProjection due to user consent result of CANCEL - id= " + this.mProjectionGrant.getVirtualDisplayId());     // Catch: Throwable -> L21
        this.mProjectionGrant.stop(10);     // Catch: Throwable -> L21
    L47:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L39:
        if (this.mProjectionGrant.getLaunchCookie() == null) goto L42;
        taskWindowContainerToken = this.mProjectionGrant.getLaunchCookie().binder;     // Catch: Throwable -> L21
    L42:
        setReviewedConsentSessionLocked(ContentRecordingSession.createTaskSession(taskWindowContainerToken, MediaProjection.m5838$$Nest$fgetmTaskId(this.mProjectionGrant)));     // Catch: Throwable -> L21
        goto L47
    L7:
        if (consentResult == 2) goto L10;
        consentGranted = false;
        goto L11
    }

    private void setReviewedConsentSessionLocked(ContentRecordingSession session) {
        if (session == null) goto L5;
        session.setWaitingForConsent(false);
        session.setVirtualDisplayId(MediaProjection.m5839$$Nest$fgetmVirtualDisplayId(this.mProjectionGrant));
    L5:
        Slog.v(TAG, "Reusing token: Processed consent so set the session " + session);
        if (setContentRecordingSession(session) == true) goto L11;
        Slog.e(TAG, "Reusing token: Failed to set session for reused consent, so stop");
        if (this.mProjectionGrant == null) goto L14;
        this.mProjectionGrant.mServiceExt.setReviewedConsentSessionLocked_onEnd(session, false);
        return;
    L14:
        return;
    L11:
        if (this.mProjectionGrant == null) goto L16;
        this.mProjectionGrant.mServiceExt.setReviewedConsentSessionLocked_onEnd(session, true);
        return;
    }

    MediaProjection createProjectionInternal(int uid, String packageName, int type, boolean isPermanentGrant, UserHandle callingUser, int displayId) {
        int sid = sNextSessionId.getAndIncrement();
        IMediaProjectionManagerServiceExt sysoptLogger = IMediaProjectionManagerServiceExt.get(null);
        sysoptLogger.createProjectionInternal_onInit(sid, uid, packageName);
        ApplicationInfo ai = this.mPackageManager.getApplicationInfoAsUser(packageName, PackageManager.ApplicationInfoFlags.of(0), callingUser);     // Catch: PackageManager.NameNotFoundException -> L22
        long callingToken = Binder.clearCallingIdentity();
        MediaProjection projection = new MediaProjection(this, type, uid, packageName, ai.targetSdkVersion, ai.isPrivilegedApp(), displayId);     // Catch: Throwable -> L10 Exception -> L12
        projection.mServiceExt = sysoptLogger;     // Catch: Throwable -> L10 Exception -> L12
        if (isPermanentGrant == false) goto L14;
        this.mAppOps.setMode(46, projection.uid, projection.packageName, 0);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        sysoptLogger.createProjectionInternal_onResult(true, null, null);     // Catch: Throwable -> L10 Exception -> L12
        Binder.restoreCallingIdentity(callingToken);
        return projection;
    L12:
        e = move-exception;
        sysoptLogger.createProjectionInternal_onResult(false, IMediaSessionServiceExt.ERROR_EXCEPTION, e);     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(callingToken);
        throw th;
    L22:
        e = e;
    L26:
        sysoptLogger.createProjectionInternal_onResult(false, "PACKAGE_NOT_FOUND", e);
        throw new IllegalArgumentException("No package matching :" + packageName);
    L24:
        e = e;
        goto L26
    }

    MediaProjection getProjectionInternal(int uid, String packageName) {
        long callingToken = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L34
        monitor-enter(r2);     // Catch: Throwable -> L34
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L6:
        if (this.mProjectionGrant != null) goto L8;
    L26:
        Slog.e(TAG, "Reusing token: Not possible to reuse the current projection instance");     // Catch: Throwable -> L20
        if (this.mProjectionGrant == null) goto L29;
        this.mProjectionGrant.mServiceExt.getProjectionInternal_onEnd(false, "REUSE_NOT_WAITING");     // Catch: Throwable -> L20
    L29:
        monitor-exit(r2);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(callingToken);
        return null;
    L8:
        if (MediaProjection.m5837$$Nest$fgetmSession(this.mProjectionGrant) == null) goto L26;
        if (MediaProjection.m5837$$Nest$fgetmSession(this.mProjectionGrant).isWaitingForConsent() == false) goto L26;
        if (this.mProjectionGrant.uid == uid) goto L15;
    L22:
        Slog.e(TAG, "Reusing token: Not possible to reuse the current projection instance due to package details mismatching");     // Catch: Throwable -> L20
        this.mProjectionGrant.mServiceExt.getProjectionInternal_onEnd(false, "REUSE_PACKAGE_MISMATCH");     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(callingToken);
        return null;
    L15:
        if (Objects.equals(this.mProjectionGrant.packageName, packageName) == false) goto L22;
        Slog.v(TAG, "Reusing token: getProjection can reuse the current projection");     // Catch: Throwable -> L20
        this.mProjectionGrant.mServiceExt.getProjectionInternal_onEnd(true, null);     // Catch: Throwable -> L20
        MediaProjection r3 = this.mProjectionGrant;     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(callingToken);
        return r3;
    L34:
        th = move-exception;
        Binder.restoreCallingIdentity(callingToken);
        throw th;
    }

    MediaProjectionInfo getActiveProjectionInfo() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProjectionGrant != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        MediaProjectionInfo r1 = this.mProjectionGrant.getProjectionInfo();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    private void dump(PrintWriter pw) {
        pw.println("MEDIA PROJECTION MANAGER (dumpsys media_projection)");
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("Media Projection: ");     // Catch: Throwable -> L7
        if (this.mProjectionGrant == null) goto L9;
        this.mProjectionGrant.dump(pw);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        pw.println("null");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private static String typeToString(int type) {
        switch(type) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "TYPE_PRESENTATION";
    L7:
        return "TYPE_MIRRORING";
    L9:
        return "TYPE_SCREEN_CAPTURE";
    L4:
        return Integer.toString(type);
    }
}
