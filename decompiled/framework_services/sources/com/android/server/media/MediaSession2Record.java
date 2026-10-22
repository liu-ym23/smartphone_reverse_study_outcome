package com.android.server.media;

import android.app.Notification;
import android.media.MediaController2;
import android.media.Session2CommandGroup;
import android.media.Session2Token;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.UserHandle;
import android.util.Log;
import android.view.KeyEvent;
import com.android.server.slice.SliceClientPermissions;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class MediaSession2Record extends MediaSessionRecordImpl {
    private static final boolean DEBUG = false;
    private static final String TAG = "MediaSession2Record";
    private final MediaController2 mController;
    private final HandlerExecutor mHandlerExecutor;
    private boolean mIsClosed;
    private boolean mIsConnected;
    private final Object mLock;
    private final int mPid;
    private int mPolicies;
    private final MediaSessionService mService;
    private final Session2Token mSessionToken;

    private class Controller2Callback extends MediaController2.ControllerCallback {
        final /* synthetic */ MediaSession2Record this$0;

        /* synthetic */ Controller2Callback(MediaSession2Record r1, MediaSession2RecordIA r2) {
            this(r1);
        }

        private Controller2Callback(MediaSession2Record r1) {
            this.this$0 = r1;
        }

        @Override // android.media.MediaController2.ControllerCallback
        public void onConnected(MediaController2 controller, Session2CommandGroup allowedCommands) {
            if (MediaSession2Record.m5616$$Nest$sfgetDEBUG() == false) goto L5;
            Log.d(MediaSession2Record.TAG, "connected to " + MediaSession2Record.m5614$$Nest$fgetmSessionToken(this.this$0) + ", allowed=" + allowedCommands);
        L5:
            Object r0 = MediaSession2Record.m5612$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            MediaSession2Record.m5615$$Nest$fputmIsConnected(this.this$0, true);     // Catch: Throwable -> L11
            MediaSessionService service = MediaSession2Record.m5613$$Nest$fgetmService(this.this$0);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            service.onSessionActiveStateChanged(this.this$0, null);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // android.media.MediaController2.ControllerCallback
        public void onDisconnected(MediaController2 controller) {
            if (MediaSession2Record.m5616$$Nest$sfgetDEBUG() == false) goto L5;
            Log.d(MediaSession2Record.TAG, "disconnected from " + MediaSession2Record.m5614$$Nest$fgetmSessionToken(this.this$0));
        L5:
            Object r0 = MediaSession2Record.m5612$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            MediaSession2Record.m5615$$Nest$fputmIsConnected(this.this$0, false);     // Catch: Throwable -> L11
            MediaSessionService service = MediaSession2Record.m5613$$Nest$fgetmService(this.this$0);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            service.onSessionDied(this.this$0);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // android.media.MediaController2.ControllerCallback
        public void onPlaybackActiveChanged(MediaController2 controller, boolean playbackActive) {
            if (MediaSession2Record.m5616$$Nest$sfgetDEBUG() == false) goto L5;
            Log.d(MediaSession2Record.TAG, "playback active changed, " + MediaSession2Record.m5614$$Nest$fgetmSessionToken(this.this$0) + ", active=" + playbackActive);
        L5:
            Object r0 = MediaSession2Record.m5612$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            MediaSessionService service = MediaSession2Record.m5613$$Nest$fgetmService(this.this$0);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            service.onSessionPlaybackStateChanged(this.this$0, playbackActive, null);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5612$$Nest$fgetmLock(MediaSession2Record r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaSessionService m5613$$Nest$fgetmService(MediaSession2Record r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ Session2Token m5614$$Nest$fgetmSessionToken(MediaSession2Record r0) {
        return r0.mSessionToken;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5615$$Nest$fputmIsConnected(MediaSession2Record r0, boolean r1) {
        r0.mIsConnected = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5616$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaSession2Record(Session2Token sessionToken, MediaSessionService service, Looper handlerLooper, int pid, int policies) {
        this.mLock = new Object();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSessionToken = sessionToken;     // Catch: Throwable -> L7
        this.mService = service;     // Catch: Throwable -> L7
        this.mHandlerExecutor = new HandlerExecutor(new Handler(handlerLooper));     // Catch: Throwable -> L7
        this.mController = new MediaController2.Builder(service.getContext(), sessionToken).setControllerCallback(this.mHandlerExecutor, new Controller2Callback(this, null)).build();     // Catch: Throwable -> L7
        this.mPid = pid;     // Catch: Throwable -> L7
        this.mPolicies = policies;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public String getPackageName() {
        return this.mSessionToken.getPackageName();
    }

    public Session2Token getSession2Token() {
        return this.mSessionToken;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public int getUid() {
        return this.mSessionToken.getUid();
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public int getUserId() {
        return UserHandle.getUserHandleForUid(this.mSessionToken.getUid()).getIdentifier();
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean hasLinkedNotificationSupport() {
        return false;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean isSystemPriority() {
        return false;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public void adjustVolume(String packageName, String opPackageName, int pid, int uid, boolean asSystemService, int direction, int flags, boolean useSuggested) {
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean isActive() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mIsConnected;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean checkPlaybackActiveState(boolean expected) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.mIsConnected == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        if (r1 != expected) goto L14;
        r2 = true;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (this.mController.isPlaybackActive() == false) goto L11;
        r1 = true;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean isPlaybackTypeLocal() {
        return true;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsClosed = true;     // Catch: Throwable -> L8
        this.mController.close();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean isClosed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mIsClosed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public void expireTempEngaged() {
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public void onGlobalPrioritySessionActiveChanged(boolean isGlobalPrioritySessionActive) {
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean sendMediaButton(String packageName, int pid, int uid, boolean asSystemService, KeyEvent ke, int sequenceId, ResultReceiver cb) {
        return false;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean canHandleVolumeKey() {
        return false;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    boolean isLinkedToNotification(Notification notification) {
        return false;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public int getSessionPolicies() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mPolicies;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public void setSessionPolicies(int policies) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPolicies = policies;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "uniqueId=" + getUniqueId());
        pw.println(prefix + "token=" + this.mSessionToken);
        pw.println(prefix + "controller=" + this.mController);
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix);
        r0.append("  ");
        String indent = r0.toString();
        pw.println(indent + "playbackActive=" + this.mController.isPlaybackActive());
    }

    public String toString() {
        return getPackageName() + SliceClientPermissions.SliceAuthority.DELIMITER + getUniqueId() + " (userId=" + getUserId() + ")";
    }
}
