package com.android.server.media;

import android.app.ActivityManagerInternal;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.compat.CompatChanges;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.ISession;
import android.media.session.ISessionCallback;
import android.media.session.ISessionController;
import android.media.session.ISessionControllerCallback;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.ParcelableListBinder;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.FrozenObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.Slog;
import android.view.KeyEvent;
import com.android.server.LocalServices;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.uri.UriGrantsManagerInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MediaSessionRecord extends MediaSessionRecordImpl implements IBinder.DeathRecipient {
    private static final List<Integer> ALWAYS_PRIORITY_STATES = null;
    private static final String[] ART_URIS = null;
    private static final boolean DEBUG = false;
    private static final AudioAttributes DEFAULT_ATTRIBUTES = null;
    private static final int OPTIMISTIC_VOLUME_TIMEOUT = 1000;
    private static final String TAG = "MediaSessionRecord";
    static final long THROW_FOR_ACTIVITY_MEDIA_BUTTON_RECEIVER = 272737196;
    static final long THROW_FOR_INVALID_BROADCAST_RECEIVER = 270049379;
    private static final List<Integer> TRANSITION_PRIORITY_STATES = null;
    private static final int USER_DISENGAGED = 2;
    private static final int USER_ENGAGEMENT_UNSET = -1;
    private static final int USER_PERMANENTLY_ENGAGED = 0;
    private static final int USER_TEMPORARILY_ENGAGED = 1;
    private AudioAttributes mAudioAttrs;
    private AudioManager mAudioManager;
    private final Runnable mClearOptimisticVolumeRunnable;
    private final Context mContext;
    private final ControllerStub mController;
    private final CopyOnWriteArrayList<ISessionControllerCallbackHolder> mControllerCallbackHolders;
    private int mCurrentVolume;
    private boolean mDestroyed;
    private long mDuration;
    private IMediaSessionRecordExtProxy mExt;
    private Bundle mExtras;
    private long mFlags;
    private final MessageHandler mHandler;
    private boolean mIsActive;
    private PendingIntent mLaunchIntent;
    private final Object mLock;
    private int mMaxVolume;
    private MediaButtonReceiverHolder mMediaButtonReceiverHolder;
    private MediaMetadata mMetadata;
    private String mMetadataDescription;
    private int mOptimisticVolume;
    private final int mOwnerPid;
    private final int mOwnerUid;
    private final String mPackageName;
    private PlaybackState mPlaybackState;
    private int mPolicies;
    private List<MediaSession.QueueItem> mQueue;
    private CharSequence mQueueTitle;
    private int mRatingType;
    private final MediaSessionService mService;
    private final SessionStub mSession;
    private final SessionCb mSessionCb;
    private final Bundle mSessionInfo;
    private final MediaSession.Token mSessionToken;
    private final String mTag;
    private final UriGrantsManagerInternal mUgmInternal;
    private int mUserEngagementState;
    private final Runnable mUserEngagementTimeoutExpirationRunnable;
    private final int mUserId;
    private String mVolumeControlId;
    private int mVolumeControlType;
    private int mVolumeType;

    private interface ControllerCallbackCall {
        void performOn(ISessionControllerCallbackHolder r1) throws RemoteException;
    }

    class ControllerStub extends ISessionController.Stub {
        final /* synthetic */ MediaSessionRecord this$0;

        public static /* synthetic */ void $r8$lambda$XqlSegvtdu2JR4dvKH81ASjKpt8(ControllerStub r0, ISessionControllerCallback r1) {
            r0.lambda$registerCallback$0(r1);
        }

        ControllerStub(MediaSessionRecord this$0) {
            this.this$0 = this$0;
        }

        public void sendCommand(String packageName, String command, Bundle args, ResultReceiver cb) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).sendCommand(packageName, Binder.getCallingPid(), Binder.getCallingUid(), command, args, cb);
        }

        public boolean sendMediaButton(String packageName, KeyEvent keyEvent) {
            return MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).sendMediaButton(packageName, Binder.getCallingPid(), Binder.getCallingUid(), false, keyEvent);
        }

        public void registerCallback(String packageName, final ISessionControllerCallback cb) {
            Object r1 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L28:
            th = th;
        L33:
            monitor-exit(r1);     // Catch: Throwable -> L21
            throw th;
        L5:
            if (MediaSessionRecord.m5625$$Nest$fgetmDestroyed(this.this$0) == false) goto L14;
            cb.onSessionDestroyed();     // Catch: Throwable -> L8 Exception -> L10
        L8:
            th = th;
        L11:
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L14:
            if (MediaSessionRecord.m5664$$Nest$mgetControllerHolderIndexForCb(this.this$0, cb) >= 0) goto L31;
            ISessionControllerCallbackHolder holder = new ISessionControllerCallbackHolder(this.this$0, cb, packageName, Binder.getCallingUid(), new MediaSessionRecord$ControllerStub$$ExternalSyntheticLambda0(this, cb));     // Catch: Throwable -> L21
            MediaSessionRecord.m5624$$Nest$fgetmControllerCallbackHolders(this.this$0).add(holder);     // Catch: Throwable -> L21
            if (MediaSessionRecord.m5679$$Nest$sfgetDEBUG() == false) goto L35;
            Slog.d(MediaSessionRecord.TAG, "registering controller callback " + cb + " from controller" + packageName);     // Catch: Throwable -> L21
        L35:
            cb.asBinder().linkToDeath(ISessionControllerCallbackHolder.m5683$$Nest$fgetmDeathMonitor(holder), 0);     // Catch: Throwable -> L21 RemoteException -> L25
        L25:
            e = move-exception;
            unregisterCallback(cb);     // Catch: Throwable -> L21
            Slog.w(MediaSessionRecord.TAG, "registerCallback failed to linkToDeath", e);     // Catch: Throwable -> L21
        L21:
            th = th;
        L31:
            monitor-exit(r1);     // Catch: Throwable -> L21
        }

        private /* synthetic */ void lambda$registerCallback$0(ISessionControllerCallback cb) {
            unregisterCallback(cb);
        }

        public void unregisterCallback(ISessionControllerCallback cb) {
            Object r0 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int index = MediaSessionRecord.m5664$$Nest$mgetControllerHolderIndexForCb(this.this$0, cb);     // Catch: Throwable -> L9
            if (index == (-1)) goto L15;
            cb.asBinder().unlinkToDeath(ISessionControllerCallbackHolder.m5683$$Nest$fgetmDeathMonitor((ISessionControllerCallbackHolder) MediaSessionRecord.m5624$$Nest$fgetmControllerCallbackHolders(this.this$0).get(index)), 0);     // Catch: Throwable -> L9 NoSuchElementException -> L11
        L13:
            MediaSessionRecord.m5624$$Nest$fgetmControllerCallbackHolders(this.this$0).remove(index);     // Catch: Throwable -> L9
            goto L15
        L11:
            e = move-exception;
            Slog.w(MediaSessionRecord.TAG, "error unlinking to binder death", e);     // Catch: Throwable -> L9
        L15:
            if (MediaSessionRecord.m5679$$Nest$sfgetDEBUG() == false) goto L17;
            Slog.d(MediaSessionRecord.TAG, "unregistering callback " + cb.asBinder());     // Catch: Throwable -> L9
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public String getPackageName() {
            return MediaSessionRecord.m5633$$Nest$fgetmPackageName(this.this$0);
        }

        public String getTag() {
            return MediaSessionRecord.m5642$$Nest$fgetmTag(this.this$0);
        }

        public Bundle getSessionInfo() {
            return MediaSessionRecord.m5641$$Nest$fgetmSessionInfo(this.this$0);
        }

        public PendingIntent getLaunchPendingIntent() {
            return MediaSessionRecord.m5630$$Nest$fgetmLaunchIntent(this.this$0);
        }

        public long getFlags() {
            return MediaSessionRecord.m5628$$Nest$fgetmFlags(this.this$0);
        }

        public MediaController.PlaybackInfo getVolumeAttributes() {
            return MediaSessionRecord.m5666$$Nest$mgetVolumeAttributes(this.this$0);
        }

        public void adjustVolume(String packageName, String opPackageName, int direction, int flags) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            this.this$0.adjustVolume(packageName, opPackageName, pid, uid, false, direction, flags, false);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return;
        L8:
            th = move-exception;
            Throwable r12 = th;
        L12:
            Binder.restoreCallingIdentity(token);
            throw r12;
        L10:
            th = move-exception;
            r12 = th;
            goto L12
        }

        public void setVolumeTo(String packageName, String opPackageName, int value, int flags) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            MediaSessionRecord.m5675$$Nest$msetVolumeTo(this.this$0, packageName, opPackageName, pid, uid, value, flags);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return;
        L8:
            th = move-exception;
            Throwable r10 = th;
        L12:
            Binder.restoreCallingIdentity(token);
            throw r10;
        L10:
            th = move-exception;
            r10 = th;
            goto L12
        }

        public void prepare(String packageName) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).prepare(packageName, Binder.getCallingPid(), Binder.getCallingUid());
        }

        public void prepareFromMediaId(String packageName, String mediaId, Bundle extras) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).prepareFromMediaId(packageName, Binder.getCallingPid(), Binder.getCallingUid(), mediaId, extras);
        }

        public void prepareFromSearch(String packageName, String query, Bundle extras) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).prepareFromSearch(packageName, Binder.getCallingPid(), Binder.getCallingUid(), query, extras);
        }

        public void prepareFromUri(String packageName, Uri uri, Bundle extras) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).prepareFromUri(packageName, Binder.getCallingPid(), Binder.getCallingUid(), uri, extras);
        }

        public void play(String packageName) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).play(packageName, Binder.getCallingPid(), Binder.getCallingUid());
        }

        public void playFromMediaId(String packageName, String mediaId, Bundle extras) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).playFromMediaId(packageName, Binder.getCallingPid(), Binder.getCallingUid(), mediaId, extras);
        }

        public void playFromSearch(String packageName, String query, Bundle extras) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).playFromSearch(packageName, Binder.getCallingPid(), Binder.getCallingUid(), query, extras);
        }

        public void playFromUri(String packageName, Uri uri, Bundle extras) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).playFromUri(packageName, Binder.getCallingPid(), Binder.getCallingUid(), uri, extras);
        }

        public void skipToQueueItem(String packageName, long id) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).skipToTrack(packageName, Binder.getCallingPid(), Binder.getCallingUid(), id);
        }

        public void pause(String packageName) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).pause(packageName, Binder.getCallingPid(), Binder.getCallingUid());
        }

        public void stop(String packageName) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).stop(packageName, Binder.getCallingPid(), Binder.getCallingUid());
        }

        public void next(String packageName) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).next(packageName, Binder.getCallingPid(), Binder.getCallingUid());
        }

        public void previous(String packageName) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).previous(packageName, Binder.getCallingPid(), Binder.getCallingUid());
        }

        public void fastForward(String packageName) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).fastForward(packageName, Binder.getCallingPid(), Binder.getCallingUid());
        }

        public void rewind(String packageName) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).rewind(packageName, Binder.getCallingPid(), Binder.getCallingUid());
        }

        public void seekTo(String packageName, long pos) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).seekTo(packageName, Binder.getCallingPid(), Binder.getCallingUid(), pos);
        }

        public void rate(String packageName, Rating rating) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).rate(packageName, Binder.getCallingPid(), Binder.getCallingUid(), rating);
        }

        public void setPlaybackSpeed(String packageName, float speed) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).setPlaybackSpeed(packageName, Binder.getCallingPid(), Binder.getCallingUid(), speed);
        }

        public void sendCustomAction(String packageName, String action, Bundle args) {
            MediaSessionRecord.m5640$$Nest$fgetmSessionCb(this.this$0).sendCustomAction(packageName, Binder.getCallingPid(), Binder.getCallingUid(), action, args);
        }

        public MediaMetadata getMetadata() {
            Object r0 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            MediaMetadata r1 = MediaSessionRecord.m5632$$Nest$fgetmMetadata(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public PlaybackState getPlaybackState() {
            return MediaSessionRecord.m5665$$Nest$mgetStateWithUpdatedPosition(this.this$0);
        }

        public ParceledListSlice getQueue() {
            Object r0 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (MediaSessionRecord.m5636$$Nest$fgetmQueue(this.this$0) != null) goto L7;
            ParceledListSlice r1 = null;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = new ParceledListSlice(MediaSessionRecord.m5636$$Nest$fgetmQueue(this.this$0));     // Catch: Throwable -> L10
            goto L8
        }

        public CharSequence getQueueTitle() {
            return MediaSessionRecord.m5637$$Nest$fgetmQueueTitle(this.this$0);
        }

        public Bundle getExtras() {
            Object r0 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            Bundle r1 = MediaSessionRecord.m5627$$Nest$fgetmExtras(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getRatingType() {
            return MediaSessionRecord.m5638$$Nest$fgetmRatingType(this.this$0);
        }
    }

    private class ISessionControllerCallbackHolder {
        private final ISessionControllerCallback mCallback;
        private final IBinder.DeathRecipient mDeathMonitor;
        private final String mPackageName;
        private final int mUid;

        /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ ISessionControllerCallback m5682$$Nest$fgetmCallback(ISessionControllerCallbackHolder r0) {
            return r0.mCallback;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDeathMonitor, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder.DeathRecipient m5683$$Nest$fgetmDeathMonitor(ISessionControllerCallbackHolder r0) {
            return r0.mDeathMonitor;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m5684$$Nest$fgetmPackageName(ISessionControllerCallbackHolder r0) {
            return r0.mPackageName;
        }

        ISessionControllerCallbackHolder(MediaSessionRecord r1, ISessionControllerCallback callback, String packageName, int uid, IBinder.DeathRecipient deathMonitor) {
            this.mCallback = callback;
            this.mPackageName = packageName;
            this.mUid = uid;
            this.mDeathMonitor = deathMonitor;
        }
    }

    private class MessageHandler extends Handler {
        private static final int MSG_DESTROYED = 9;
        private static final int MSG_SEND_EVENT = 6;
        private static final int MSG_UPDATE_EXTRAS = 5;
        private static final int MSG_UPDATE_METADATA = 1;
        private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
        private static final int MSG_UPDATE_QUEUE = 3;
        private static final int MSG_UPDATE_QUEUE_TITLE = 4;
        private static final int MSG_UPDATE_SESSION_STATE = 7;
        private static final int MSG_UPDATE_VOLUME = 8;
        final /* synthetic */ MediaSessionRecord this$0;

        public MessageHandler(MediaSessionRecord r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L22;
                case 8: goto L6;
                case 9: goto L5;
                default: goto L22;
            };
        L5:
            MediaSessionRecord.m5673$$Nest$mpushSessionDestroyed(this.this$0);
            return;
        L6:
            MediaSessionRecord.m5674$$Nest$mpushVolumeUpdate(this.this$0);
            return;
        L8:
            MediaSessionRecord.m5667$$Nest$mpushEvent(this.this$0, (String) msg.obj, msg.getData());
            return;
        L9:
            MediaSessionRecord.m5668$$Nest$mpushExtrasUpdate(this.this$0);
            return;
        L10:
            MediaSessionRecord.m5671$$Nest$mpushQueueTitleUpdate(this.this$0);
            return;
        L11:
            MediaSessionRecord.m5672$$Nest$mpushQueueUpdate(this.this$0);
            return;
        L12:
            MediaSessionRecord.m5670$$Nest$mpushPlaybackStateUpdate(this.this$0);
            return;
        L13:
            MediaSessionRecord.m5669$$Nest$mpushMetadataUpdate(this.this$0);
            return;
        }

        public void post(int what) {
            post(what, null);
        }

        public void post(int what, Object obj) {
            obtainMessage(what, obj).sendToTarget();
        }

        public void post(int what, Object obj, Bundle data) {
            Message msg = obtainMessage(what, obj);
            msg.setData(data);
            msg.sendToTarget();
        }
    }

    class SessionCb {
        private final ISessionCallback mCb;
        final /* synthetic */ MediaSessionRecord this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmCb, reason: not valid java name */
        static /* bridge */ /* synthetic */ ISessionCallback m5685$$Nest$fgetmCb(SessionCb r0) {
            return r0.mCb;
        }

        SessionCb(MediaSessionRecord this$0, ISessionCallback cb) {
            this.this$0 = this$0;
            this.mCb = cb;
        }

        public boolean sendMediaButton(String packageName, int pid, int uid, boolean asSystemService, KeyEvent keyEvent, int sequenceId, ResultReceiver cb) {
        L6:
            e = move-exception;
            Slog.e(MediaSessionRecord.TAG, "Remote failure in sendMediaRequest.", e);
            return false;
        L4:
            if (KeyEvent.isMediaSessionKey(keyEvent.getKeyCode()) == false) goto L8;
            String reason = "action=" + KeyEvent.actionToString(keyEvent.getAction()) + ";code=" + KeyEvent.keyCodeToString(keyEvent.getKeyCode());     // Catch: RemoteException -> L6
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, reason);     // Catch: RemoteException -> L6
        L8:
            if (asSystemService == false) goto L10;
            this.mCb.onMediaButton(MediaSessionRecord.m5622$$Nest$fgetmContext(this.this$0).getPackageName(), Process.myPid(), 1000, createMediaButtonIntent(keyEvent), sequenceId, cb);     // Catch: RemoteException -> L6
            return true;
        L10:
            this.mCb.onMediaButton(packageName, pid, uid, createMediaButtonIntent(keyEvent), sequenceId, cb);     // Catch: RemoteException -> L6
            return true;
        }

        public boolean sendMediaButton(String packageName, int pid, int uid, boolean asSystemService, KeyEvent keyEvent) {
        L5:
            e = move-exception;
            Slog.e(MediaSessionRecord.TAG, "Remote failure in sendMediaRequest.", e);
            return false;
        L3:
            if (KeyEvent.isMediaSessionKey(keyEvent.getKeyCode()) == false) goto L7;
            String reason = "action=" + KeyEvent.actionToString(keyEvent.getAction()) + ";code=" + KeyEvent.keyCodeToString(keyEvent.getKeyCode());     // Catch: RemoteException -> L5
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, reason);     // Catch: RemoteException -> L5
        L7:
            if (asSystemService == false) goto L9;
            this.mCb.onMediaButton(MediaSessionRecord.m5622$$Nest$fgetmContext(this.this$0).getPackageName(), Process.myPid(), 1000, createMediaButtonIntent(keyEvent), 0, null);     // Catch: RemoteException -> L5
            return true;
        L9:
            this.mCb.onMediaButtonFromController(packageName, pid, uid, createMediaButtonIntent(keyEvent));     // Catch: RemoteException -> L5
            return true;
        }

        public void sendCommand(String packageName, int pid, int uid, String command, Bundle args, ResultReceiver cb) {
            this.mCb.onCommand(packageName, pid, uid, command, args, cb);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in sendCommand.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        public void sendCustomAction(String packageName, int pid, int uid, String action, Bundle args) {
            String reason = "MediaSessionRecord:custom-" + action;     // Catch: RemoteException -> L4
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, reason);     // Catch: RemoteException -> L4
            this.mCb.onCustomAction(packageName, pid, uid, action, args);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(MediaSessionRecord.TAG, "Remote failure in sendCustomAction.", e);
        }

        public void prepare(String packageName, int pid, int uid) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:prepare");     // Catch: RemoteException -> L6
            this.mCb.onPrepare(packageName, pid, uid);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in prepare.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        public void prepareFromMediaId(String packageName, int pid, int uid, String mediaId, Bundle extras) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:prepareFromMediaId");     // Catch: RemoteException -> L5
            this.mCb.onPrepareFromMediaId(packageName, pid, uid, mediaId, extras);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(MediaSessionRecord.TAG, "Remote failure in prepareFromMediaId.", e);
        }

        public void prepareFromSearch(String packageName, int pid, int uid, String query, Bundle extras) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:prepareFromSearch");     // Catch: RemoteException -> L5
            this.mCb.onPrepareFromSearch(packageName, pid, uid, query, extras);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(MediaSessionRecord.TAG, "Remote failure in prepareFromSearch.", e);
        }

        public void prepareFromUri(String packageName, int pid, int uid, Uri uri, Bundle extras) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:prepareFromUri");     // Catch: RemoteException -> L5
            this.mCb.onPrepareFromUri(packageName, pid, uid, uri, extras);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(MediaSessionRecord.TAG, "Remote failure in prepareFromUri.", e);
        }

        public void play(String packageName, int pid, int uid) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:play");     // Catch: RemoteException -> L6
            this.mCb.onPlay(packageName, pid, uid);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in play.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        public void playFromMediaId(String packageName, int pid, int uid, String mediaId, Bundle extras) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:playFromMediaId");     // Catch: RemoteException -> L5
            this.mCb.onPlayFromMediaId(packageName, pid, uid, mediaId, extras);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(MediaSessionRecord.TAG, "Remote failure in playFromMediaId.", e);
        }

        public void playFromSearch(String packageName, int pid, int uid, String query, Bundle extras) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:playFromSearch");     // Catch: RemoteException -> L5
            this.mCb.onPlayFromSearch(packageName, pid, uid, query, extras);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(MediaSessionRecord.TAG, "Remote failure in playFromSearch.", e);
        }

        public void playFromUri(String packageName, int pid, int uid, Uri uri, Bundle extras) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:playFromUri");     // Catch: RemoteException -> L5
            this.mCb.onPlayFromUri(packageName, pid, uid, uri, extras);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(MediaSessionRecord.TAG, "Remote failure in playFromUri.", e);
        }

        public void skipToTrack(String packageName, int pid, int uid, long id) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:skipToTrack");     // Catch: RemoteException -> L5
            this.mCb.onSkipToTrack(packageName, pid, uid, id);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(MediaSessionRecord.TAG, "Remote failure in skipToTrack", e);
        }

        public void pause(String packageName, int pid, int uid) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:pause");     // Catch: RemoteException -> L6
            this.mCb.onPause(packageName, pid, uid);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in pause.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        public void stop(String packageName, int pid, int uid) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:stop");     // Catch: RemoteException -> L6
            this.mCb.onStop(packageName, pid, uid);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in stop.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        public void next(String packageName, int pid, int uid) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:next");     // Catch: RemoteException -> L6
            this.mCb.onNext(packageName, pid, uid);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in next.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        public void previous(String packageName, int pid, int uid) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:previous");     // Catch: RemoteException -> L6
            this.mCb.onPrevious(packageName, pid, uid);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in previous.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        public void fastForward(String packageName, int pid, int uid) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:fastForward");     // Catch: RemoteException -> L6
            this.mCb.onFastForward(packageName, pid, uid);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in fastForward.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        public void rewind(String packageName, int pid, int uid) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:rewind");     // Catch: RemoteException -> L6
            this.mCb.onRewind(packageName, pid, uid);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in rewind.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        public void seekTo(String packageName, int pid, int uid, long pos) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:seekTo");     // Catch: RemoteException -> L5
            this.mCb.onSeekTo(packageName, pid, uid, pos);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e(MediaSessionRecord.TAG, "Remote failure in seekTo.", e);
        }

        public void rate(String packageName, int pid, int uid, Rating rating) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:rate");     // Catch: RemoteException -> L6
            this.mCb.onRate(packageName, pid, uid, rating);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in rate.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        public void setPlaybackSpeed(String packageName, int pid, int uid, float speed) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:setPlaybackSpeed");     // Catch: RemoteException -> L6
            this.mCb.onSetPlaybackSpeed(packageName, pid, uid, speed);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in setPlaybackSpeed.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        public void adjustVolume(String packageName, int pid, int uid, boolean asSystemService, int direction) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:adjustVolume");     // Catch: RemoteException -> L7
            if (asSystemService == false) goto L9;
            this.mCb.onAdjustVolume(MediaSessionRecord.m5622$$Nest$fgetmContext(this.this$0).getPackageName(), Process.myPid(), 1000, direction);     // Catch: RemoteException -> L7
        L17:
            return;
        L9:
            this.mCb.onAdjustVolume(packageName, pid, uid, direction);     // Catch: RemoteException -> L7
        L7:
            e = move-exception;
            RemoteException e = e;
        L13:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in adjustVolume.", e);
            return;
        L11:
            e = move-exception;
            e = e;
            goto L13
        }

        public void setVolumeTo(String packageName, int pid, int uid, int value) {
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).tempAllowlistTargetPkgIfPossible(this.this$0.getUid(), this.this$0.getPackageName(), pid, uid, packageName, "MediaSessionRecord:setVolumeTo");     // Catch: RemoteException -> L6
            this.mCb.onSetVolumeTo(packageName, pid, uid, value);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException e = e;
        L10:
            Slog.e(MediaSessionRecord.TAG, "Remote failure in setVolumeTo.", e);
            return;
        L8:
            e = move-exception;
            e = e;
            goto L10
        }

        private Intent createMediaButtonIntent(KeyEvent keyEvent) {
            Intent mediaButtonIntent = new Intent("android.intent.action.MEDIA_BUTTON");
            mediaButtonIntent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
            return mediaButtonIntent;
        }
    }

    private final class SessionStub extends ISession.Stub {
        final /* synthetic */ MediaSessionRecord this$0;

        public static /* synthetic */ void $r8$lambda$nZ_maswLLKav8_d7bR7q6jd83GA(WeakReference r0, List r1) {
            lambda$getBinderForSetQueue$0(r0, r1);
        }

        /* synthetic */ SessionStub(MediaSessionRecord r1, MediaSessionRecordIA r2) {
            this(r1);
        }

        private SessionStub(MediaSessionRecord r1) {
            this.this$0 = r1;
        }

        public void destroySession() throws RemoteException {
            long token = Binder.clearCallingIdentity();
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).onSessionDied(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void sendEvent(String event, Bundle data) throws RemoteException {
            MessageHandler r0 = MediaSessionRecord.m5629$$Nest$fgetmHandler(this.this$0);
            if (data != null) goto L5;
            Bundle r1 = null;
        L6:
            r0.post(6, event, r1);
            return;
        L5:
            r1 = new Bundle(data);
            goto L6
        }

        public ISessionController getController() throws RemoteException {
            return MediaSessionRecord.m5623$$Nest$fgetmController(this.this$0);
        }

        public void setActive(boolean active) throws RemoteException {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            if (active == false) goto L5;
            ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).logFgsApiBegin(4, callingUid, callingPid);
        L6:
            boolean isGlobalPrioritySessionActive = MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).isGlobalPrioritySessionActive();
            Object r3 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r3);
            MediaSessionRecord.m5651$$Nest$fputmIsActive(this.this$0, active);     // Catch: Throwable -> L17
            MediaSessionRecord.m5676$$Nest$mupdateUserEngagedStateIfNeededLocked(this.this$0, false, isGlobalPrioritySessionActive);     // Catch: Throwable -> L17
            monitor-exit(r3);     // Catch: Throwable -> L17
            long token = Binder.clearCallingIdentity();
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).onSessionActiveStateChanged(this.this$0, MediaSessionRecord.m5634$$Nest$fgetmPlaybackState(this.this$0));     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(token);
            MediaSessionRecord.m5629$$Nest$fgetmHandler(this.this$0).post(7);
            return;
        L14:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L17:
            th = move-exception;
            throw th;
        L5:
            ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).logFgsApiEnd(4, callingUid, callingPid);
            goto L6
        }

        public void setFlags(int flags) throws RemoteException {
            if ((flags & 65536) == 0) goto L5;
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).enforcePhoneStatePermission(pid, uid);
        L5:
            MediaSessionRecord.m5650$$Nest$fputmFlags(this.this$0, flags);
            if ((65536 & flags) == 0) goto L13;
            long token = Binder.clearCallingIdentity();
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).setGlobalPrioritySession(this.this$0);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(token);
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L13:
            MediaSessionRecord.m5629$$Nest$fgetmHandler(this.this$0).post(7);
        }

        public void setMediaButtonReceiver(PendingIntent pi) throws RemoteException {
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L5:
            if ((MediaSessionRecord.m5635$$Nest$fgetmPolicies(this.this$0) & 1) == 0) goto L8;
            Binder.restoreCallingIdentity(token);
            return;
        L8:
            if (pi != null) goto L10;
        L20:
            MediaSessionRecord.m5654$$Nest$fputmMediaButtonReceiverHolder(this.this$0, MediaButtonReceiverHolder.create(MediaSessionRecord.m5644$$Nest$fgetmUserId(this.this$0), pi, MediaSessionRecord.m5633$$Nest$fgetmPackageName(this.this$0)));     // Catch: Throwable -> L16
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).onMediaButtonReceiverChanged(this.this$0);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(token);
            return;
        L10:
            if (pi.isActivity() == false) goto L20;
            if (CompatChanges.isChangeEnabled(MediaSessionRecord.THROW_FOR_ACTIVITY_MEDIA_BUTTON_RECEIVER, uid) == true) goto L19;
            Slog.w(MediaSessionRecord.TAG, "Ignoring invalid media button receiver targeting an activity.");     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(token);
            return;
        L19:
            throw new IllegalArgumentException("The media button receiver cannot be set to an activity.");     // Catch: Throwable -> L16
        }

        public void setMediaButtonBroadcastReceiver(ComponentName receiver) throws RemoteException {
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            if (receiver == null) goto L13;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L5:
            if (TextUtils.equals(MediaSessionRecord.m5633$$Nest$fgetmPackageName(this.this$0), receiver.getPackageName()) == true) goto L13;
            EventLog.writeEvent(1397638484, new Object[]{"238177121", -1, ""});     // Catch: Throwable -> L9
            throw new IllegalArgumentException("receiver does not belong to package name provided to MediaSessionRecord. Pkg = " + MediaSessionRecord.m5633$$Nest$fgetmPackageName(this.this$0) + ", Receiver Pkg = " + receiver.getPackageName());     // Catch: Throwable -> L9
        L13:
            if ((MediaSessionRecord.m5635$$Nest$fgetmPolicies(this.this$0) & 1) == 0) goto L17;
            Binder.restoreCallingIdentity(token);
            return;
        L17:
            if (MediaSessionRecord.m5681$$Nest$smcomponentNameExists(receiver, MediaSessionRecord.m5622$$Nest$fgetmContext(this.this$0), MediaSessionRecord.m5644$$Nest$fgetmUserId(this.this$0)) == false) goto L19;
            MediaSessionRecord.m5654$$Nest$fputmMediaButtonReceiverHolder(this.this$0, MediaButtonReceiverHolder.create(MediaSessionRecord.m5644$$Nest$fgetmUserId(this.this$0), receiver));     // Catch: Throwable -> L9
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).onMediaButtonReceiverChanged(this.this$0);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L19:
            if (CompatChanges.isChangeEnabled(MediaSessionRecord.THROW_FOR_INVALID_BROADCAST_RECEIVER, uid) == true) goto L24;
            Slog.w(MediaSessionRecord.TAG, "setMediaButtonBroadcastReceiver(): Ignoring invalid component name=" + receiver);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L24:
            throw new IllegalArgumentException("Invalid component name: " + receiver);     // Catch: Throwable -> L9
        }

        public void setLaunchPendingIntent(PendingIntent pi) throws RemoteException {
            MediaSessionRecord.m5652$$Nest$fputmLaunchIntent(this.this$0, pi);
        }

        public void setMetadata(MediaMetadata metadata, long duration, String metadataDescription) throws RemoteException {
            Object r0 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            MediaSessionRecord.m5648$$Nest$fputmDuration(this.this$0, duration);     // Catch: Throwable -> L8
            MediaSessionRecord.m5656$$Nest$fputmMetadataDescription(this.this$0, metadataDescription);     // Catch: Throwable -> L8
            MediaSessionRecord.m5655$$Nest$fputmMetadata(this.this$0, sanitizeMediaMetadata(metadata));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            MediaSessionRecord.m5626$$Nest$fgetmExt(this.this$0).setMetadata_onEnd(metadata);
            MediaSessionRecord.m5629$$Nest$fgetmHandler(this.this$0).post(1);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private MediaMetadata sanitizeMediaMetadata(MediaMetadata metadata) {
            if (metadata != null) goto L5;
            return null;
        L5:
            MediaMetadata.Builder metadataBuilder = new MediaMetadata.Builder(metadata);
            String[] r5 = MediaSessionRecord.m5678$$Nest$sfgetART_URIS();
            int r6 = r5.length;
            int r7 = 0;
        L6:
            if (r7 >= r6) goto L18;
            String key = r5[r7];
            String uriString = metadata.getString(key);
            if (TextUtils.isEmpty(uriString) == true) goto L17;
            Uri uri = Uri.parse(uriString);
            if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == false) goto L17;
            MediaSessionRecord.m5643$$Nest$fgetmUgmInternal(this.this$0).checkGrantUriPermission(this.this$0.getUid(), this.this$0.getPackageName(), ContentProvider.getUriWithoutUserId(uri), 1, ContentProvider.getUserIdFromUri(uri, this.this$0.getUserId()));     // Catch: SecurityException -> L15
        L16:
            metadataBuilder.putString(key, null);
        L17:
            r7 = r7 + 1;
            goto L6
        L18:
            MediaMetadata sanitizedMetadata = metadataBuilder.build();
            sanitizedMetadata.size();
            return sanitizedMetadata;
        }

        public void setPlaybackState(PlaybackState state) throws RemoteException {
            if (MediaSessionRecord.m5634$$Nest$fgetmPlaybackState(this.this$0) != null) goto L5;
            int oldState = 0;
        L6:
            if (state != null) goto L8;
            int newState = 0;
        L10:
            if (MediaSessionRecord.m5677$$Nest$sfgetALWAYS_PRIORITY_STATES().contains(Integer.valueOf(newState)) == false) goto L12;
        L17:
            boolean shouldUpdatePriority = true;
        L18:
            boolean isGlobalPrioritySessionActive = MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).isGlobalPrioritySessionActive();
            Object r5 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r5);
            MediaSessionRecord.m5657$$Nest$fputmPlaybackState(this.this$0, state);     // Catch: Throwable -> L29
            MediaSessionRecord.m5676$$Nest$mupdateUserEngagedStateIfNeededLocked(this.this$0, false, isGlobalPrioritySessionActive);     // Catch: Throwable -> L29
            monitor-exit(r5);     // Catch: Throwable -> L29
            long token = Binder.clearCallingIdentity();
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).onSessionPlaybackStateChanged(this.this$0, shouldUpdatePriority, MediaSessionRecord.m5634$$Nest$fgetmPlaybackState(this.this$0));     // Catch: Throwable -> L26
            Binder.restoreCallingIdentity(token);
            MediaSessionRecord.m5626$$Nest$fgetmExt(this.this$0).setPlaybackState_onEnd(state);
            MediaSessionRecord.m5629$$Nest$fgetmHandler(this.this$0).post(2);
            return;
        L26:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L29:
            th = move-exception;
            throw th;
        L12:
            if (MediaSessionRecord.m5680$$Nest$sfgetTRANSITION_PRIORITY_STATES().contains(Integer.valueOf(oldState)) == false) goto L14;
        L16:
            shouldUpdatePriority = false;
            goto L18
        L14:
            if (MediaSessionRecord.m5680$$Nest$sfgetTRANSITION_PRIORITY_STATES().contains(Integer.valueOf(newState)) == false) goto L16;
        L8:
            newState = state.getState();
            goto L10
        L5:
            oldState = MediaSessionRecord.m5634$$Nest$fgetmPlaybackState(this.this$0).getState();
            goto L6
        }

        public void resetQueue() throws RemoteException {
            Object r0 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            MediaSessionRecord.m5658$$Nest$fputmQueue(this.this$0, null);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            MediaSessionRecord.m5629$$Nest$fgetmHandler(this.this$0).post(3);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public IBinder getBinderForSetQueue() throws RemoteException {
            final WeakReference<MediaSessionRecord> recordRef = new WeakReference(this.this$0);
            return new ParcelableListBinder(MediaSession.QueueItem.class, new MediaSessionRecord$SessionStub$$ExternalSyntheticLambda0(recordRef));
        }

        private static /* synthetic */ void lambda$getBinderForSetQueue$0(WeakReference recordRef, List list) {
            MediaSessionRecord record = (MediaSessionRecord) recordRef.get();
            if (record == null) goto L12;
            Object r1 = MediaSessionRecord.m5631$$Nest$fgetmLock(record);
            monitor-enter(r1);
            MediaSessionRecord.m5658$$Nest$fputmQueue(record, list);     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            MediaSessionRecord.m5629$$Nest$fgetmHandler(record).post(3);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void setQueueTitle(CharSequence title) throws RemoteException {
            MediaSessionRecord.m5659$$Nest$fputmQueueTitle(this.this$0, title);
            MediaSessionRecord.m5629$$Nest$fgetmHandler(this.this$0).post(4);
        }

        public void setExtras(Bundle extras) throws RemoteException {
            Object r0 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            MediaSessionRecord r1 = this.this$0;     // Catch: Throwable -> L12
            if (extras != null) goto L7;
            Bundle r2 = null;
        L8:
            MediaSessionRecord.m5649$$Nest$fputmExtras(r1, r2);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            MediaSessionRecord.m5626$$Nest$fgetmExt(this.this$0).setExtras_onEnd(extras);
            MediaSessionRecord.m5629$$Nest$fgetmHandler(this.this$0).post(5);
            return;
        L7:
            r2 = new Bundle(extras);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        public void setRatingType(int type) throws RemoteException {
            MediaSessionRecord.m5660$$Nest$fputmRatingType(this.this$0, type);
        }

        public void setCurrentVolume(int volume) throws RemoteException {
            MediaSessionRecord.m5647$$Nest$fputmCurrentVolume(this.this$0, volume);
            MediaSessionRecord.m5629$$Nest$fgetmHandler(this.this$0).post(8);
        }

        public void setPlaybackToLocal(AudioAttributes attributes) throws RemoteException {
            Object r0 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (MediaSessionRecord.m5645$$Nest$fgetmVolumeType(this.this$0) != 2) goto L7;
            boolean typeChanged = true;
        L8:
            MediaSessionRecord.m5663$$Nest$fputmVolumeType(this.this$0, 1);     // Catch: Throwable -> L11
            MediaSessionRecord.m5661$$Nest$fputmVolumeControlId(this.this$0, null);     // Catch: Throwable -> L11
            if (attributes == null) goto L13;
            MediaSessionRecord.m5646$$Nest$fputmAudioAttrs(this.this$0, attributes);     // Catch: Throwable -> L11
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L11
            if (typeChanged == false) goto L22;
            long token = Binder.clearCallingIdentity();
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).onSessionPlaybackTypeChanged(this.this$0);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(token);
            MediaSessionRecord.m5629$$Nest$fgetmHandler(this.this$0).post(8);
            return;
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L22:
            return;
        L13:
            Slog.e(MediaSessionRecord.TAG, "Received null audio attributes, using existing attributes");     // Catch: Throwable -> L11
            goto L14
        L7:
            typeChanged = false;
            goto L8
        }

        public void setPlaybackToRemote(int control, int max, String controlId) throws RemoteException {
            Object r0 = MediaSessionRecord.m5631$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean typeChanged = true;
            if (MediaSessionRecord.m5645$$Nest$fgetmVolumeType(this.this$0) == 1) goto L8;
            typeChanged = false;
        L8:
            MediaSessionRecord.m5663$$Nest$fputmVolumeType(this.this$0, 2);     // Catch: Throwable -> L18
            MediaSessionRecord.m5662$$Nest$fputmVolumeControlType(this.this$0, control);     // Catch: Throwable -> L18
            MediaSessionRecord.m5653$$Nest$fputmMaxVolume(this.this$0, max);     // Catch: Throwable -> L18
            MediaSessionRecord.m5661$$Nest$fputmVolumeControlId(this.this$0, controlId);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            if (typeChanged == false) goto L17;
            long token = Binder.clearCallingIdentity();
            MediaSessionRecord.m5639$$Nest$fgetmService(this.this$0).onSessionPlaybackTypeChanged(this.this$0);     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(token);
            MediaSessionRecord.m5629$$Nest$fgetmHandler(this.this$0).post(8);
            return;
        L14:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L17:
            return;
        L18:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface UserEngagementState {
    }

    public static /* synthetic */ void $r8$lambda$5PDUSY3siMLu6mW70TwRKiPp28M(MediaMetadata r0, ISessionControllerCallbackHolder r1) {
        lambda$pushMetadataUpdate$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Bn7OQDqDqRcYBza56V2hENFC-ZU, reason: not valid java name */
    public static /* synthetic */ void m5619$r8$lambda$Bn7OQDqDqRcYBza56V2hENFCZU(ISessionControllerCallbackHolder r0) {
        lambda$pushSessionDestroyed$12(r0);
    }

    public static /* synthetic */ void $r8$lambda$Kf5gudr74o7QcD35njkfb1tkamg(MediaSessionRecord r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$TFs_Hc6AuF5bomA2UQsnvHLWYvQ(String r0, Bundle r1, ISessionControllerCallbackHolder r2) {
        lambda$pushEvent$11(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$YJTJ_AJAe8UBBJg4alMUctbOfN0(MediaSessionRecord r0, boolean r1) {
        r0.lambda$onGlobalPrioritySessionActiveChanged$3(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$_0JjLgIw0DZiNizRii5E-Yfjkjw, reason: not valid java name */
    public static /* synthetic */ void m5620$r8$lambda$_0JjLgIw0DZiNizRii5EYfjkjw(MediaSessionRecord r0, int r1, int r2, int r3, boolean r4, int r5, String r6, int r7, int r8) {
        r0.lambda$postAdjustLocalVolume$4(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: $r8$lambda$fJIAcRgukwRTXLGduUOf--3VhcA, reason: not valid java name */
    public static /* synthetic */ void m5621$r8$lambda$fJIAcRgukwRTXLGduUOf3VhcA(CharSequence r0, ISessionControllerCallbackHolder r1) {
        lambda$pushQueueTitleUpdate$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$l_DP5fU2CwN6md1U49YwCcD_sHA(MediaController.PlaybackInfo r0, ISessionControllerCallbackHolder r1) {
        lambda$pushVolumeUpdate$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$sWZQxMCOaEr9sAIplc5rZY8NvbQ(PlaybackState r0, ISessionControllerCallbackHolder r1) {
        lambda$pushPlaybackStateUpdate$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$uJeIcYkgD12htfmQzj81cOGe654(MediaSessionRecord r0, String r1, int r2, int r3, int r4, int r5, int r6) {
        r0.lambda$setVolumeTo$1(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$xzMDbEGpDVCX_wkq4Kg4TU50a6k(Bundle r0, ISessionControllerCallbackHolder r1) {
        lambda$pushExtrasUpdate$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$y2a7y6n8A1kCPAPIeP41HFSvmcE(MediaSessionRecord r0) {
        r0.lambda$new$13();
    }

    public static /* synthetic */ void $r8$lambda$zfJ41zYzLtahLc22KamjPu1LFfc(ArrayList r0, ISessionControllerCallbackHolder r1) {
        lambda$pushQueueUpdate$7(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m5622$$Nest$fgetmContext(MediaSessionRecord r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmController, reason: not valid java name */
    static /* bridge */ /* synthetic */ ControllerStub m5623$$Nest$fgetmController(MediaSessionRecord r0) {
        return r0.mController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmControllerCallbackHolders, reason: not valid java name */
    static /* bridge */ /* synthetic */ CopyOnWriteArrayList m5624$$Nest$fgetmControllerCallbackHolders(MediaSessionRecord r0) {
        return r0.mControllerCallbackHolders;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDestroyed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5625$$Nest$fgetmDestroyed(MediaSessionRecord r0) {
        return r0.mDestroyed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IMediaSessionRecordExtProxy m5626$$Nest$fgetmExt(MediaSessionRecord r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExtras, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m5627$$Nest$fgetmExtras(MediaSessionRecord r0) {
        return r0.mExtras;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5628$$Nest$fgetmFlags(MediaSessionRecord r2) {
        return r2.mFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ MessageHandler m5629$$Nest$fgetmHandler(MediaSessionRecord r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLaunchIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ PendingIntent m5630$$Nest$fgetmLaunchIntent(MediaSessionRecord r0) {
        return r0.mLaunchIntent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5631$$Nest$fgetmLock(MediaSessionRecord r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMetadata, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaMetadata m5632$$Nest$fgetmMetadata(MediaSessionRecord r0) {
        return r0.mMetadata;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5633$$Nest$fgetmPackageName(MediaSessionRecord r0) {
        return r0.mPackageName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPlaybackState, reason: not valid java name */
    static /* bridge */ /* synthetic */ PlaybackState m5634$$Nest$fgetmPlaybackState(MediaSessionRecord r0) {
        return r0.mPlaybackState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPolicies, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5635$$Nest$fgetmPolicies(MediaSessionRecord r0) {
        return r0.mPolicies;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m5636$$Nest$fgetmQueue(MediaSessionRecord r0) {
        return r0.mQueue;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQueueTitle, reason: not valid java name */
    static /* bridge */ /* synthetic */ CharSequence m5637$$Nest$fgetmQueueTitle(MediaSessionRecord r0) {
        return r0.mQueueTitle;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRatingType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5638$$Nest$fgetmRatingType(MediaSessionRecord r0) {
        return r0.mRatingType;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaSessionService m5639$$Nest$fgetmService(MediaSessionRecord r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionCb, reason: not valid java name */
    static /* bridge */ /* synthetic */ SessionCb m5640$$Nest$fgetmSessionCb(MediaSessionRecord r0) {
        return r0.mSessionCb;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m5641$$Nest$fgetmSessionInfo(MediaSessionRecord r0) {
        return r0.mSessionInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTag, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5642$$Nest$fgetmTag(MediaSessionRecord r0) {
        return r0.mTag;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUgmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ UriGrantsManagerInternal m5643$$Nest$fgetmUgmInternal(MediaSessionRecord r0) {
        return r0.mUgmInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5644$$Nest$fgetmUserId(MediaSessionRecord r0) {
        return r0.mUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVolumeType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5645$$Nest$fgetmVolumeType(MediaSessionRecord r0) {
        return r0.mVolumeType;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAudioAttrs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5646$$Nest$fputmAudioAttrs(MediaSessionRecord r0, AudioAttributes r1) {
        r0.mAudioAttrs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentVolume, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5647$$Nest$fputmCurrentVolume(MediaSessionRecord r0, int r1) {
        r0.mCurrentVolume = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDuration, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5648$$Nest$fputmDuration(MediaSessionRecord r0, long r1) {
        r0.mDuration = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmExtras, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5649$$Nest$fputmExtras(MediaSessionRecord r0, Bundle r1) {
        r0.mExtras = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5650$$Nest$fputmFlags(MediaSessionRecord r0, long r1) {
        r0.mFlags = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5651$$Nest$fputmIsActive(MediaSessionRecord r0, boolean r1) {
        r0.mIsActive = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLaunchIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5652$$Nest$fputmLaunchIntent(MediaSessionRecord r0, PendingIntent r1) {
        r0.mLaunchIntent = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMaxVolume, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5653$$Nest$fputmMaxVolume(MediaSessionRecord r0, int r1) {
        r0.mMaxVolume = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMediaButtonReceiverHolder, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5654$$Nest$fputmMediaButtonReceiverHolder(MediaSessionRecord r0, MediaButtonReceiverHolder r1) {
        r0.mMediaButtonReceiverHolder = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMetadata, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5655$$Nest$fputmMetadata(MediaSessionRecord r0, MediaMetadata r1) {
        r0.mMetadata = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMetadataDescription, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5656$$Nest$fputmMetadataDescription(MediaSessionRecord r0, String r1) {
        r0.mMetadataDescription = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPlaybackState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5657$$Nest$fputmPlaybackState(MediaSessionRecord r0, PlaybackState r1) {
        r0.mPlaybackState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5658$$Nest$fputmQueue(MediaSessionRecord r0, List r1) {
        r0.mQueue = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmQueueTitle, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5659$$Nest$fputmQueueTitle(MediaSessionRecord r0, CharSequence r1) {
        r0.mQueueTitle = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRatingType, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5660$$Nest$fputmRatingType(MediaSessionRecord r0, int r1) {
        r0.mRatingType = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmVolumeControlId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5661$$Nest$fputmVolumeControlId(MediaSessionRecord r0, String r1) {
        r0.mVolumeControlId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmVolumeControlType, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5662$$Nest$fputmVolumeControlType(MediaSessionRecord r0, int r1) {
        r0.mVolumeControlType = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmVolumeType, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5663$$Nest$fputmVolumeType(MediaSessionRecord r0, int r1) {
        r0.mVolumeType = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetControllerHolderIndexForCb, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5664$$Nest$mgetControllerHolderIndexForCb(MediaSessionRecord r0, ISessionControllerCallback r1) {
        return r0.getControllerHolderIndexForCb(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetStateWithUpdatedPosition, reason: not valid java name */
    static /* bridge */ /* synthetic */ PlaybackState m5665$$Nest$mgetStateWithUpdatedPosition(MediaSessionRecord r0) {
        return r0.getStateWithUpdatedPosition();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetVolumeAttributes, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaController.PlaybackInfo m5666$$Nest$mgetVolumeAttributes(MediaSessionRecord r0) {
        return r0.getVolumeAttributes();
    }

    /* JADX INFO: renamed from: -$$Nest$mpushEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5667$$Nest$mpushEvent(MediaSessionRecord r0, String r1, Bundle r2) {
        r0.pushEvent(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpushExtrasUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5668$$Nest$mpushExtrasUpdate(MediaSessionRecord r0) {
        r0.pushExtrasUpdate();
    }

    /* JADX INFO: renamed from: -$$Nest$mpushMetadataUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5669$$Nest$mpushMetadataUpdate(MediaSessionRecord r0) {
        r0.pushMetadataUpdate();
    }

    /* JADX INFO: renamed from: -$$Nest$mpushPlaybackStateUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5670$$Nest$mpushPlaybackStateUpdate(MediaSessionRecord r0) {
        r0.pushPlaybackStateUpdate();
    }

    /* JADX INFO: renamed from: -$$Nest$mpushQueueTitleUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5671$$Nest$mpushQueueTitleUpdate(MediaSessionRecord r0) {
        r0.pushQueueTitleUpdate();
    }

    /* JADX INFO: renamed from: -$$Nest$mpushQueueUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5672$$Nest$mpushQueueUpdate(MediaSessionRecord r0) {
        r0.pushQueueUpdate();
    }

    /* JADX INFO: renamed from: -$$Nest$mpushSessionDestroyed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5673$$Nest$mpushSessionDestroyed(MediaSessionRecord r0) {
        r0.pushSessionDestroyed();
    }

    /* JADX INFO: renamed from: -$$Nest$mpushVolumeUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5674$$Nest$mpushVolumeUpdate(MediaSessionRecord r0) {
        r0.pushVolumeUpdate();
    }

    /* JADX INFO: renamed from: -$$Nest$msetVolumeTo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5675$$Nest$msetVolumeTo(MediaSessionRecord r0, String r1, String r2, int r3, int r4, int r5, int r6) {
        r0.setVolumeTo(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateUserEngagedStateIfNeededLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5676$$Nest$mupdateUserEngagedStateIfNeededLocked(MediaSessionRecord r0, boolean r1, boolean r2) {
        r0.updateUserEngagedStateIfNeededLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetALWAYS_PRIORITY_STATES, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m5677$$Nest$sfgetALWAYS_PRIORITY_STATES() {
        return ALWAYS_PRIORITY_STATES;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetART_URIS, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m5678$$Nest$sfgetART_URIS() {
        return ART_URIS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5679$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTRANSITION_PRIORITY_STATES, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m5680$$Nest$sfgetTRANSITION_PRIORITY_STATES() {
        return TRANSITION_PRIORITY_STATES;
    }

    /* JADX INFO: renamed from: -$$Nest$smcomponentNameExists, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5681$$Nest$smcomponentNameExists(ComponentName r0, Context r1, int r2) {
        return componentNameExists(r0, r1, r2);
    }

    static {
        ART_URIS = new String[]{"android.media.metadata.ALBUM_ART_URI", "android.media.metadata.ART_URI", "android.media.metadata.DISPLAY_ICON_URI"};
        DEBUG = Log.isLoggable(TAG, 3);
        ALWAYS_PRIORITY_STATES = Arrays.asList(new Integer[]{4, 5, 9, 10});
        TRANSITION_PRIORITY_STATES = Arrays.asList(new Integer[]{6, 8, 3});
        DEFAULT_ATTRIBUTES = new AudioAttributes.Builder().setUsage(1).build();
    }

    private static int getVolumeStream(AudioAttributes attr) {
        if (attr == null) goto L4;
        int stream = attr.getVolumeControlStream();
        if (stream == Integer.MIN_VALUE) goto L8;
        return stream;
    L8:
        return DEFAULT_ATTRIBUTES.getVolumeControlStream();
    L4:
        return DEFAULT_ATTRIBUTES.getVolumeControlStream();
    }

    private /* synthetic */ void lambda$new$0() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        updateUserEngagedStateIfNeededLocked(true, false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public MediaSessionRecord(int ownerPid, int ownerUid, int userId, String ownerPackageName, ISessionCallback cb, String tag, Bundle sessionInfo, MediaSessionService service, Looper handlerLooper, int policies) throws RemoteException {
        this.mLock = new Object();
        this.mControllerCallbackHolders = new CopyOnWriteArrayList();
        this.mVolumeType = 1;
        this.mVolumeControlType = 2;
        this.mMaxVolume = 0;
        this.mCurrentVolume = 0;
        this.mOptimisticVolume = -1;
        this.mIsActive = false;
        this.mDestroyed = false;
        this.mDuration = -1;
        this.mUserEngagementTimeoutExpirationRunnable = new MediaSessionRecord$$ExternalSyntheticLambda4(this);
        this.mUserEngagementState = -1;
        this.mClearOptimisticVolumeRunnable = new MediaSessionRecord$$ExternalSyntheticLambda5(this);
        this.mOwnerPid = ownerPid;
        this.mOwnerUid = ownerUid;
        this.mUserId = userId;
        this.mPackageName = ownerPackageName;
        this.mTag = tag;
        this.mSessionInfo = sessionInfo;
        this.mController = new ControllerStub(this);
        this.mSessionToken = new MediaSession.Token(ownerUid, this.mController);
        this.mSession = new SessionStub(this, null);
        this.mSessionCb = new SessionCb(this, cb);
        this.mService = service;
        this.mContext = this.mService.getContext();
        this.mHandler = new MessageHandler(this, handlerLooper);
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mAudioAttrs = DEFAULT_ATTRIBUTES;
        this.mPolicies = policies;
        this.mUgmInternal = (UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class);
        SessionCb.m5685$$Nest$fgetmCb(this.mSessionCb).asBinder().linkToDeath(this, 0);
        this.mExt = IMediaSessionRecordExtProxy.get(this);
        this.mExt.init(ownerUid, userId, ownerPackageName, tag);
    }

    public ISession getSessionBinder() {
        return this.mSession;
    }

    public MediaSession.Token getSessionToken() {
        return this.mSessionToken;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public String getPackageName() {
        return this.mPackageName;
    }

    public MediaButtonReceiverHolder getMediaButtonReceiver() {
        return this.mMediaButtonReceiverHolder;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public int getUid() {
        return this.mOwnerUid;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public int getUserId() {
        return this.mUserId;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean hasLinkedNotificationSupport() {
        return true;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean isSystemPriority() {
        if ((this.mFlags & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public void adjustVolume(String packageName, String opPackageName, int pid, int uid, boolean asSystemService, int direction, int flags, boolean useSuggested) {
        int previousFlagPlaySound = flags & 4;
        if (checkPlaybackActiveState(true) == false) goto L5;
    L8:
        int flags2 = flags & (-5);
    L10:
        if (this.mVolumeType != 1) goto L12;
        int stream = getVolumeStream(this.mAudioAttrs);
        postAdjustLocalVolume(stream, direction, flags2, opPackageName, pid, uid, asSystemService, useSuggested, previousFlagPlaySound);
        return;
    L12:
        int flags3 = flags2;
        if (this.mVolumeControlType != 0) goto L18;
        if (DEBUG == false) goto L38;
        Slog.d(TAG, "Session does not support volume adjustment");
    L38:
        this.mService.notifyRemoteVolumeChanged(flags3, this);
        return;
    L18:
        if (direction != 101) goto L20;
    L37:
        Slog.w(TAG, "Muting remote playback is not supported");
        goto L38
    L20:
        if (direction == (-100)) goto L37;
        if (direction == 100) goto L37;
        if (DEBUG == false) goto L27;
        Slog.w(TAG, "adjusting volume, pkg=" + packageName + ", asSystemService=" + asSystemService + ", dir=" + direction);
    L27:
        this.mSessionCb.adjustVolume(packageName, pid, uid, asSystemService, direction);
        if (this.mOptimisticVolume >= 0) goto L30;
        int volumeBefore = this.mCurrentVolume;
    L31:
        this.mOptimisticVolume = volumeBefore + direction;
        this.mOptimisticVolume = Math.max(0, Math.min(this.mOptimisticVolume, this.mMaxVolume));
        this.mHandler.removeCallbacks(this.mClearOptimisticVolumeRunnable);
        this.mHandler.postDelayed(this.mClearOptimisticVolumeRunnable, 1000);
        if (volumeBefore == this.mOptimisticVolume) goto L35;
        pushVolumeUpdate();
    L35:
        if (DEBUG == false) goto L38;
        Slog.d(TAG, "Adjusted optimistic volume to " + this.mOptimisticVolume + " max is " + this.mMaxVolume);
        goto L38
    L30:
        volumeBefore = this.mOptimisticVolume;
        goto L31
    L5:
        if (isSystemPriority() == true) goto L8;
        flags2 = flags;
        goto L10
    }

    private void setVolumeTo(String packageName, final String opPackageName, final int pid, final int uid, final int value, final int flags) {
        if (this.mVolumeType != 1) goto L6;
        final int stream = getVolumeStream(this.mAudioAttrs);
        this.mHandler.post(new MediaSessionRecord$$ExternalSyntheticLambda0(this, opPackageName, pid, uid, flags, stream, value));
        return;
    L6:
        if (this.mVolumeControlType != 2) goto L8;
        int value2 = Math.max(0, Math.min(value, this.mMaxVolume));
        this.mSessionCb.setVolumeTo(packageName, pid, uid, value2);
        if (this.mOptimisticVolume >= 0) goto L13;
        int volumeBefore = this.mCurrentVolume;
    L14:
        this.mOptimisticVolume = Math.max(0, Math.min(value2, this.mMaxVolume));
        this.mHandler.removeCallbacks(this.mClearOptimisticVolumeRunnable);
        this.mHandler.postDelayed(this.mClearOptimisticVolumeRunnable, 1000);
        if (volumeBefore == this.mOptimisticVolume) goto L18;
        pushVolumeUpdate();
    L18:
        if (DEBUG == false) goto L20;
        Slog.d(TAG, "Set optimistic volume to " + this.mOptimisticVolume + " max is " + this.mMaxVolume);
    L20:
        this.mService.notifyRemoteVolumeChanged(flags, this);
        return;
    L13:
        volumeBefore = this.mOptimisticVolume;
        goto L14
    L8:
        if (DEBUG == false) goto L20;
        Slog.d(TAG, "Session does not support setting volume");
        goto L20
    }

    private /* synthetic */ void lambda$setVolumeTo$1(String opPackageName, int pid, int uid, int flags, int stream, int volumeValue) {
        setStreamVolumeForUid(opPackageName, pid, uid, flags, stream, volumeValue);
    }

    private void setStreamVolumeForUid(String opPackageName, int pid, int uid, int flags, int stream, int volumeValue) {
        int flags2 = flags;
        int stream2 = stream;
        int volumeValue2 = volumeValue;
        this.mAudioManager.setStreamVolumeForUid(stream2, volumeValue2, flags2, opPackageName, uid, pid, this.mContext.getApplicationInfo().targetSdkVersion);     // Catch: Throwable -> L6
        return;
    L6:
        e = move-exception;
        RuntimeException e = e;
    L10:
        Slog.e(TAG, "Cannot set volume: stream=" + stream2 + ", value=" + volumeValue2 + ", flags=" + flags2, e);
        return;
    L8:
        e = move-exception;
        flags2 = flags;
        stream2 = stream;
        volumeValue2 = volumeValue;
        e = e;
        goto L10
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean isActive() {
        if (this.mIsActive == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mDestroyed == true) goto L7;
        return true;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean checkPlaybackActiveState(boolean expected) {
        if (this.mPlaybackState != null) goto L6;
        return false;
    L6:
        if (this.mPlaybackState.isActive() != expected) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean isPlaybackTypeLocal() {
        if (this.mVolumeType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        this.mService.onSessionDied(this);
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public void close() {
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).logFgsApiEnd(4, callingUid, callingPid);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L10;
        monitor-exit(r2);     // Catch: Throwable -> L8
        return;
    L10:
        SessionCb.m5685$$Nest$fgetmCb(this.mSessionCb).asBinder().unlinkToDeath(this, 0);     // Catch: Throwable -> L8
        this.mDestroyed = true;     // Catch: Throwable -> L8
        this.mPlaybackState = null;     // Catch: Throwable -> L8
        disengageOnCloseLocked();     // Catch: Throwable -> L8
        this.mMetadata = null;     // Catch: Throwable -> L8
        this.mExtras = null;     // Catch: Throwable -> L8
        this.mHandler.post(9);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean isClosed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mDestroyed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public void expireTempEngaged() {
        this.mHandler.post(this.mUserEngagementTimeoutExpirationRunnable);
    }

    private void disengageOnCloseLocked() {
    }

    private /* synthetic */ void lambda$disengageOnCloseLocked$2() {
        this.mService.onSessionUserEngagementStateChange(this, false);
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public void onGlobalPrioritySessionActiveChanged(final boolean isGlobalPrioritySessionActive) {
        this.mHandler.post(new MediaSessionRecord$$ExternalSyntheticLambda3(this, isGlobalPrioritySessionActive));
    }

    private /* synthetic */ void lambda$onGlobalPrioritySessionActiveChanged$3(boolean isGlobalPrioritySessionActive) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (isGlobalPrioritySessionActive == false) goto L9;
        this.mHandler.removeCallbacks(this.mUserEngagementTimeoutExpirationRunnable);     // Catch: Throwable -> L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L9:
        if (this.mUserEngagementState != 1) goto L11;
        this.mHandler.postDelayed(this.mUserEngagementTimeoutExpirationRunnable, MediaSessionDeviceConfig.getMediaSessionTempUserEngagedDurationMs());     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean sendMediaButton(String packageName, int pid, int uid, boolean asSystemService, KeyEvent ke, int sequenceId, ResultReceiver cb) {
        return this.mSessionCb.sendMediaButton(packageName, pid, uid, asSystemService, ke, sequenceId, cb);
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    public boolean canHandleVolumeKey() {
        if (isPlaybackTypeLocal() == false) goto L9;
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "Local MediaSessionRecord can handle volume key");
    L7:
        return true;
    L9:
        if (this.mVolumeControlType == 0) goto L11;
        return true;
    L11:
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "Local MediaSessionRecord with FIXED volume control can't handle volume key");
        return false;
    L16:
        return false;
    }

    @Override // com.android.server.media.MediaSessionRecordImpl
    boolean isLinkedToNotification(Notification notification) {
        if (notification.isMediaNotification() == true) goto L5;
    L7:
        return false;
    L5:
        if (Objects.equals(notification.extras.getParcelable("android.mediaSession", MediaSession.Token.class), this.mSessionToken) == false) goto L7;
        return true;
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
        pw.println(prefix + this.mTag + " " + this);
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix);
        r0.append("  ");
        String indent = r0.toString();
        pw.println(indent + "ownerPid=" + this.mOwnerPid + ", ownerUid=" + this.mOwnerUid + ", userId=" + this.mUserId);
        StringBuilder r1 = new StringBuilder();
        r1.append(indent);
        r1.append("package=");
        r1.append(this.mPackageName);
        pw.println(r1.toString());
        pw.println(indent + "launchIntent=" + this.mLaunchIntent);
        pw.println(indent + "mediaButtonReceiver=" + this.mMediaButtonReceiverHolder);
        pw.println(indent + "active=" + this.mIsActive);
        pw.println(indent + "flags=" + this.mFlags);
        pw.println(indent + "rating type=" + this.mRatingType);
        pw.println(indent + "controllers: " + this.mControllerCallbackHolders.size());
        StringBuilder r2 = new StringBuilder();
        r2.append(indent);
        r2.append("state=");
        if (this.mPlaybackState != null) goto L5;
        String r3 = null;
    L6:
        r2.append(r3);
        pw.println(r2.toString());
        pw.println(indent + "audioAttrs=" + this.mAudioAttrs);
        pw.append(indent).append("volumeType=").append(toVolumeTypeString(this.mVolumeType)).append(", controlType=").append(toVolumeControlTypeString(this.mVolumeControlType)).append(", max=").append(Integer.toString(this.mMaxVolume)).append(", current=").append(Integer.toString(this.mCurrentVolume)).append(", volumeControlId=").append(this.mVolumeControlId).println();
        pw.println(indent + "metadata: " + this.mMetadataDescription);
        StringBuilder r4 = new StringBuilder();
        r4.append(indent);
        r4.append("queueTitle=");
        r4.append(this.mQueueTitle);
        r4.append(", size=");
        if (this.mQueue != null) goto L9;
        int r5 = 0;
    L10:
        r4.append(r5);
        pw.println(r4.toString());
        return;
    L9:
        r5 = this.mQueue.size();
        goto L10
    L5:
        r3 = this.mPlaybackState.toString();
        goto L6
    }

    private static String toVolumeControlTypeString(int volumeControlType) {
        switch(volumeControlType) {
            case 0: goto L6;
            case 1: goto L5;
            case 2: goto L4;
            default: goto L8;
        };
    L4:
        return "ABSOLUTE";
    L5:
        return "RELATIVE";
    L6:
        return "FIXED";
    L8:
        return TextUtils.formatSimple("unknown(%d)", new Object[]{Integer.valueOf(volumeControlType)});
    }

    private static String toVolumeTypeString(int volumeType) {
        switch(volumeType) {
            case 1: goto L5;
            case 2: goto L4;
            default: goto L7;
        };
    L4:
        return "REMOTE";
    L5:
        return "LOCAL";
    L7:
        return TextUtils.formatSimple("unknown(%d)", new Object[]{Integer.valueOf(volumeType)});
    }

    public String toString() {
        return this.mPackageName + SliceClientPermissions.SliceAuthority.DELIMITER + this.mTag + SliceClientPermissions.SliceAuthority.DELIMITER + getUniqueId() + " (userId=" + this.mUserId + ")";
    }

    private void postAdjustLocalVolume(final int stream, final int direction, final int flags, String callingOpPackageName, int callingPid, int callingUid, boolean asSystemService, boolean useSuggested, final int previousFlagPlaySound) {
        if (DEBUG == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append("adjusting local volume, stream=");
        r0.append(stream);
        r0.append(", dir=");
        r0.append(direction);
        r0.append(", asSystemService=");
        r0.append(asSystemService);
        r0.append(", useSuggested=");
        final boolean r5 = useSuggested;
        r0.append(r5);
        Slog.w(TAG, r0.toString());
    L6:
        if (asSystemService == false) goto L8;
        String opPackageName = this.mContext.getOpPackageName();
        final String opPackageName2 = opPackageName;
        final int uid = 1000;
        final int pid = Process.myPid();
    L9:
        this.mHandler.post(new MediaSessionRecord$$ExternalSyntheticLambda12(this, stream, direction, flags, r5, previousFlagPlaySound, opPackageName2, uid, pid));
        return;
    L8:
        opPackageName2 = callingOpPackageName;
        uid = callingUid;
        pid = callingPid;
        goto L9
    L5:
        r5 = useSuggested;
        goto L6
    }

    private /* synthetic */ void lambda$postAdjustLocalVolume$4(int stream, int direction, int flags, boolean useSuggested, int previousFlagPlaySound, String opPackageName, int uid, int pid) {
        adjustSuggestedStreamVolumeForUid(stream, direction, flags, useSuggested, previousFlagPlaySound, opPackageName, uid, pid);
    }

    private void adjustSuggestedStreamVolumeForUid(int stream, int direction, int flags, boolean useSuggested, int previousFlagPlaySound, String opPackageName, int uid, int pid) {
        if (useSuggested == true) goto L5;
        this.mAudioManager.adjustStreamVolumeForUid(stream, direction, flags, opPackageName, uid, pid, this.mContext.getApplicationInfo().targetSdkVersion);     // Catch: Throwable -> L7
    L11:
        return;
    L5:
        if (this.mExt.postAdjustLocalVolume_shouldApplyDedicatedStreamType(stream) == false) goto L9;
        this.mAudioManager.adjustSuggestedStreamVolumeForUid(stream, direction, flags, opPackageName, uid, pid, this.mContext.getApplicationInfo().targetSdkVersion);     // Catch: Throwable -> L7
        goto L11
    L9:
        this.mAudioManager.adjustSuggestedStreamVolumeForUid(Integer.MIN_VALUE, direction, flags | previousFlagPlaySound, opPackageName, uid, pid, this.mContext.getApplicationInfo().targetSdkVersion);     // Catch: Throwable -> L7
    L7:
        e = move-exception;
        Slog.e(TAG, "Cannot adjust volume: direction=" + direction + ", stream=" + stream + ", flags=" + flags + ", opPackageName=" + opPackageName + ", uid=" + uid + ", useSuggested=" + useSuggested + ", previousFlagPlaySound=" + previousFlagPlaySound, e);
    }

    private void logCallbackException(String msg, ISessionControllerCallbackHolder holder, Exception e) {
        Slog.v(TAG, msg + ", this=" + this + ", callback package=" + ISessionControllerCallbackHolder.m5684$$Nest$fgetmPackageName(holder) + ", exception=" + e);
    }

    private void pushPlaybackStateUpdate() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        final PlaybackState playbackState = this.mPlaybackState;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        performOnCallbackHolders("pushPlaybackStateUpdate", new MediaSessionRecord$$ExternalSyntheticLambda6(playbackState));
    }

    private static /* synthetic */ void lambda$pushPlaybackStateUpdate$5(PlaybackState playbackState, ISessionControllerCallbackHolder holder) throws RemoteException {
        ISessionControllerCallbackHolder.m5682$$Nest$fgetmCallback(holder).onPlaybackStateChanged(playbackState);
    }

    private void pushMetadataUpdate() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        final MediaMetadata metadata = this.mMetadata;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        performOnCallbackHolders("pushMetadataUpdate", new MediaSessionRecord$$ExternalSyntheticLambda9(metadata));
    }

    private static /* synthetic */ void lambda$pushMetadataUpdate$6(MediaMetadata metadata, ISessionControllerCallbackHolder holder) throws RemoteException {
        ISessionControllerCallbackHolder.m5682$$Nest$fgetmCallback(holder).onMetadataChanged(metadata);
    }

    private void pushQueueUpdate() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mQueue != null) goto L13;
        final ArrayList<MediaSession.QueueItem> toSend = null;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        performOnCallbackHolders("pushQueueUpdate", new MediaSessionRecord$$ExternalSyntheticLambda11(toSend));
        return;
    L13:
        toSend = new ArrayList(this.mQueue);     // Catch: Throwable -> L8
        goto L14
    }

    private static /* synthetic */ void lambda$pushQueueUpdate$7(ArrayList toSend, ISessionControllerCallbackHolder holder) throws RemoteException {
        ParceledListSlice<MediaSession.QueueItem> parcelableQueue = null;
        if (toSend == null) goto L5;
        parcelableQueue = new ParceledListSlice(toSend);
        parcelableQueue.setInlineCountLimit(1);
    L5:
        ISessionControllerCallbackHolder.m5682$$Nest$fgetmCallback(holder).onQueueChanged(parcelableQueue);
    }

    private void pushQueueTitleUpdate() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        final CharSequence queueTitle = this.mQueueTitle;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        performOnCallbackHolders("pushQueueTitleUpdate", new MediaSessionRecord$$ExternalSyntheticLambda8(queueTitle));
    }

    private static /* synthetic */ void lambda$pushQueueTitleUpdate$8(CharSequence queueTitle, ISessionControllerCallbackHolder holder) throws RemoteException {
        ISessionControllerCallbackHolder.m5682$$Nest$fgetmCallback(holder).onQueueTitleChanged(queueTitle);
    }

    private void pushExtrasUpdate() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        final Bundle extras = this.mExtras;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        performOnCallbackHolders("pushExtrasUpdate", new MediaSessionRecord$$ExternalSyntheticLambda10(extras));
    }

    private static /* synthetic */ void lambda$pushExtrasUpdate$9(Bundle extras, ISessionControllerCallbackHolder holder) throws RemoteException {
        ISessionControllerCallbackHolder.m5682$$Nest$fgetmCallback(holder).onExtrasChanged(extras);
    }

    private void pushVolumeUpdate() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        final MediaController.PlaybackInfo info = getVolumeAttributes();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        performOnCallbackHolders("pushVolumeUpdate", new MediaSessionRecord$$ExternalSyntheticLambda7(info));
    }

    private static /* synthetic */ void lambda$pushVolumeUpdate$10(MediaController.PlaybackInfo info, ISessionControllerCallbackHolder holder) throws RemoteException {
        ISessionControllerCallbackHolder.m5682$$Nest$fgetmCallback(holder).onVolumeInfoChanged(info);
    }

    private void pushEvent(final String event, final Bundle data) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        performOnCallbackHolders("pushEvent", new MediaSessionRecord$$ExternalSyntheticLambda1(event, data));
    }

    private static /* synthetic */ void lambda$pushEvent$11(String event, Bundle data, ISessionControllerCallbackHolder holder) throws RemoteException {
        ISessionControllerCallbackHolder.m5682$$Nest$fgetmCallback(holder).onEvent(event, data);
    }

    private void pushSessionDestroyed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        performOnCallbackHolders("pushSessionDestroyed", new MediaSessionRecord$$ExternalSyntheticLambda2());
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mControllerCallbackHolders.clear();     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$pushSessionDestroyed$12(ISessionControllerCallbackHolder holder) throws RemoteException {
        ISessionControllerCallbackHolder.m5682$$Nest$fgetmCallback(holder).asBinder().unlinkToDeath(ISessionControllerCallbackHolder.m5683$$Nest$fgetmDeathMonitor(holder), 0);
        ISessionControllerCallbackHolder.m5682$$Nest$fgetmCallback(holder).onSessionDestroyed();
    }

    private void performOnCallbackHolders(String operationName, ControllerCallbackCall call) {
        ArrayList<ISessionControllerCallbackHolder> deadCallbackHolders = new ArrayList();
        Iterator<ISessionControllerCallbackHolder> r1 = this.mControllerCallbackHolders.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        ISessionControllerCallbackHolder holder = r1.next();
        call.performOn(holder);     // Catch: Throwable -> L8 FrozenObjectException -> L10
    L8:
        exception = move-exception;
        deadCallbackHolders.add(holder);
        logCallbackException("Exception while executing: " + operationName, holder, exception);
        goto L4
    L13:
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mControllerCallbackHolders.removeAll(deadCallbackHolders);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private PlaybackState getStateWithUpdatedPosition() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L11:
        PlaybackState state = this.mPlaybackState;     // Catch: Throwable -> L9
        long duration = this.mDuration;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        PlaybackState result = null;
        if (state != null) goto L16;
    L32:
        if (result != null) goto L35;
        return state;
    L35:
        return result;
    L16:
        if (state.getState() != 3) goto L18;
    L21:
        long updateTime = state.getLastPositionUpdateTime();
        long currentTime = SystemClock.elapsedRealtime();
        if (updateTime <= 0) goto L32;
        long position = ((long) (state.getPlaybackSpeed() * (currentTime - updateTime))) + state.getPosition();
        if (duration < 0) goto L29;
        if (position <= duration) goto L29;
        position = duration;
    L31:
        PlaybackState.Builder builder = new PlaybackState.Builder(state);
        builder.setState(state.getState(), position, state.getPlaybackSpeed(), currentTime);
        result = builder.build();
    L29:
        if (position >= 0) goto L31;
        position = 0;
        goto L31
    L18:
        if (state.getState() == 4) goto L21;
        if (state.getState() != 5) goto L32;
        goto L21
    }

    private int getControllerHolderIndexForCb(ISessionControllerCallback cb) {
        IBinder binder = cb.asBinder();
        int i = this.mControllerCallbackHolders.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (binder.equals(ISessionControllerCallbackHolder.m5682$$Nest$fgetmCallback(this.mControllerCallbackHolders.get(i)).asBinder()) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return i;
    L8:
        return -1;
    }

    private MediaController.PlaybackInfo getVolumeAttributes() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mVolumeType == 2) goto L7;
        int volumeType = this.mVolumeType;     // Catch: Throwable -> L9
        AudioAttributes attributes = this.mAudioAttrs;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        int stream = getVolumeStream(attributes);
        int max = this.mAudioManager.getStreamMaxVolume(stream);
        int current = this.mAudioManager.getStreamVolume(stream);
        return new MediaController.PlaybackInfo(volumeType, 2, max, current, attributes, null);
    L7:
        if (this.mOptimisticVolume == (-1)) goto L11;
        int r0 = this.mOptimisticVolume;     // Catch: Throwable -> L9
    L12:
        int current2 = r0;
        MediaController.PlaybackInfo r2 = new MediaController.PlaybackInfo(this.mVolumeType, this.mVolumeControlType, this.mMaxVolume, current2, this.mAudioAttrs, this.mVolumeControlId);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    L11:
        r0 = this.mCurrentVolume;     // Catch: Throwable -> L9
        goto L12
    }

    private /* synthetic */ void lambda$new$13() {
        if (this.mOptimisticVolume == this.mCurrentVolume) goto L5;
        boolean needUpdate = true;
    L6:
        this.mOptimisticVolume = -1;
        if (needUpdate == false) goto L10;
        pushVolumeUpdate();
        return;
    L10:
        return;
    L5:
        needUpdate = false;
        goto L6
    }

    private static boolean componentNameExists(ComponentName componentName, Context context, int userId) {
        Intent mediaButtonIntent = new Intent("android.intent.action.MEDIA_BUTTON");
        mediaButtonIntent.addFlags(268435456);
        mediaButtonIntent.setComponent(componentName);
        UserHandle userHandle = UserHandle.of(userId);
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfos = pm.queryBroadcastReceiversAsUser(mediaButtonIntent, PackageManager.ResolveInfoFlags.of(0), userHandle);
        return !resolveInfos.isEmpty();
    }

    private void updateUserEngagedStateIfNeededLocked(boolean isTimeoutExpired, boolean isGlobalPrioritySessionActive) {
    }

    private /* synthetic */ void lambda$updateUserEngagedStateIfNeededLocked$14(boolean isNowUserEngaged) {
        this.mService.onSessionUserEngagementStateChange(this, isNowUserEngaged);
    }
}
