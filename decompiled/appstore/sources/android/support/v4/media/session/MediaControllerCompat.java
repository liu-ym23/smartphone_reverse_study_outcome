package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.ComponentActivity;
import androidx.core.app.d;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final HashSet<Callback> mRegisteredCallbacks;
    private final MediaSessionCompat.Token mToken;

    public static abstract class Callback implements IBinder.DeathRecipient {
        final Object mCallbackObj;
        MessageHandler mHandler;
        IMediaControllerCallback mIControllerCallback;

        public class MessageHandler extends Handler {
            private static final int MSG_DESTROYED = 8;
            private static final int MSG_EVENT = 1;
            private static final int MSG_SESSION_READY = 13;
            private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
            private static final int MSG_UPDATE_EXTRAS = 7;
            private static final int MSG_UPDATE_METADATA = 3;
            private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            private static final int MSG_UPDATE_QUEUE = 5;
            private static final int MSG_UPDATE_QUEUE_TITLE = 6;
            private static final int MSG_UPDATE_REPEAT_MODE = 9;
            private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
            private static final int MSG_UPDATE_VOLUME = 4;
            boolean mRegistered;
            final /* synthetic */ Callback this$0;

            public MessageHandler(Callback r10, Looper r11) {
                this.this$0 = r10;
                super(r11);
                this.mRegistered = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message r10) {
                if (this.mRegistered == true) goto L6;
                return;
            L6:
                switch(r10.what) {
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L15;
                    case 6: goto L14;
                    case 7: goto L13;
                    case 8: goto L12;
                    case 9: goto L11;
                    case 10: goto L32;
                    case 11: goto L10;
                    case 12: goto L9;
                    case 13: goto L8;
                    default: goto L32;
                };
            L8:
                this.this$0.onSessionReady();
                return;
            L9:
                this.this$0.onShuffleModeChanged(((Integer) r10.obj).intValue());
                return;
            L10:
                this.this$0.onCaptioningEnabledChanged(((Boolean) r10.obj).booleanValue());
                return;
            L11:
                this.this$0.onRepeatModeChanged(((Integer) r10.obj).intValue());
                return;
            L12:
                this.this$0.onSessionDestroyed();
                return;
            L13:
                Bundle r11 = (Bundle) r10.obj;
                MediaSessionCompat.ensureClassLoader(r11);
                this.this$0.onExtrasChanged(r11);
                return;
            L14:
                this.this$0.onQueueTitleChanged((CharSequence) r10.obj);
                return;
            L15:
                this.this$0.onQueueChanged((List) r10.obj);
                return;
            L16:
                this.this$0.onAudioInfoChanged((PlaybackInfo) r10.obj);
                return;
            L17:
                this.this$0.onMetadataChanged((MediaMetadataCompat) r10.obj);
                return;
            L18:
                this.this$0.onPlaybackStateChanged((PlaybackStateCompat) r10.obj);
                return;
            L19:
                Bundle r12 = r10.getData();
                MediaSessionCompat.ensureClassLoader(r12);
                this.this$0.onSessionEvent((String) r10.obj, r12);
                return;
            }
        }

        public static class StubApi21 implements MediaControllerCompatApi21.Callback {
            private final WeakReference<Callback> mCallback;

            public StubApi21(Callback r10) {
                this.mCallback = new WeakReference(r10);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onAudioInfoChanged(int r10, int r11, int r12, int r13, int r14) {
                Callback r15 = this.mCallback.get();
                if (r15 == null) goto L6;
                r15.onAudioInfoChanged(new PlaybackInfo(r10, r11, r12, r13, r14));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onExtrasChanged(Bundle r10) {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.onExtrasChanged(r10);
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onMetadataChanged(Object r10) {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(r10));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onPlaybackStateChanged(Object r10) {
                Callback r11 = this.mCallback.get();
                if (r11 != null) goto L5;
                return;
            L5:
                if (r11.mIControllerCallback != null) goto L10;
                r11.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(r10));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueChanged(List<?> r10) {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(r10));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueTitleChanged(CharSequence r10) {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.onQueueTitleChanged(r10);
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionDestroyed() {
                Callback r10 = this.mCallback.get();
                if (r10 == null) goto L6;
                r10.onSessionDestroyed();
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionEvent(String r10, Bundle r11) {
                Callback r12 = this.mCallback.get();
                if (r12 == null) goto L6;
                r12.onSessionEvent(r10, r11);
                return;
            }
        }

        public static class StubCompat extends IMediaControllerCallback.Stub {
            private final WeakReference<Callback> mCallback;

            public StubCompat(Callback r10) {
                this.mCallback = new WeakReference(r10);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean r10) throws RemoteException {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.postToHandler(11, Boolean.valueOf(r10), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String r10, Bundle r11) throws RemoteException {
                Callback r12 = this.mCallback.get();
                if (r12 == null) goto L6;
                r12.postToHandler(1, r10, r11);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r10) throws RemoteException {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.postToHandler(7, r10, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r10) throws RemoteException {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.postToHandler(3, r10, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat r10) throws RemoteException {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.postToHandler(2, r10, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r10) throws RemoteException {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.postToHandler(5, r10, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r10) throws RemoteException {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.postToHandler(6, r10, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int r10) throws RemoteException {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.postToHandler(9, Integer.valueOf(r10), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Callback r10 = this.mCallback.get();
                if (r10 == null) goto L6;
                r10.postToHandler(8, null, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Callback r10 = this.mCallback.get();
                if (r10 == null) goto L6;
                r10.postToHandler(13, null, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int r10) throws RemoteException {
                Callback r11 = this.mCallback.get();
                if (r11 == null) goto L6;
                r11.postToHandler(12, Integer.valueOf(r10), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean r10) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r10) throws RemoteException {
                Callback r11 = this.mCallback.get();
                if (r11 != null) goto L5;
                return;
            L5:
                if (r10 == null) goto L7;
                PlaybackInfo r12 = new PlaybackInfo(r10.volumeType, r10.audioStream, r10.controlType, r10.maxVolume, r10.currentVolume);
            L8:
                r11.postToHandler(4, r12, null);
                return;
            L7:
                r12 = null;
                goto L8
            }
        }

        public Callback() {
            this.mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21(this));
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            postToHandler(8, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public IMediaControllerCallback getIControllerCallback() {
            return this.mIControllerCallback;
        }

        public void onAudioInfoChanged(PlaybackInfo r10) {
        }

        public void onCaptioningEnabledChanged(boolean r10) {
        }

        public void onExtrasChanged(Bundle r10) {
        }

        public void onMetadataChanged(MediaMetadataCompat r10) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat r10) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> r10) {
        }

        public void onQueueTitleChanged(CharSequence r10) {
        }

        public void onRepeatModeChanged(int r10) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String r10, Bundle r11) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int r10) {
        }

        public void postToHandler(int r10, Object r11, Bundle r12) {
            MessageHandler r13 = this.mHandler;
            if (r13 == null) goto L6;
            Message r14 = r13.obtainMessage(r10, r11);
            r14.setData(r12);
            r14.sendToTarget();
            return;
        }

        public void setHandler(Handler r10) {
            if (r10 != null) goto L6;
            MessageHandler r11 = this.mHandler;
            if (r11 == null) goto L8;
            r11.mRegistered = false;
            r11.removeCallbacksAndMessages(null);
            this.mHandler = null;
            return;
        L8:
            return;
        L6:
            MessageHandler r12 = new MessageHandler(this, r10.getLooper());
            this.mHandler = r12;
            r12.mRegistered = true;
        }
    }

    public static class MediaControllerExtraData extends ComponentActivity.ExtraData {
        private final MediaControllerCompat mMediaController;

        public MediaControllerExtraData(MediaControllerCompat r10) {
            this.mMediaController = r10;
        }

        public MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }
    }

    public interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat r10);

        void addQueueItem(MediaDescriptionCompat r10, int r11);

        void adjustVolume(int r10, int r11);

        boolean dispatchMediaButtonEvent(KeyEvent r10);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<MediaSessionCompat.QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        int getShuffleMode();

        TransportControls getTransportControls();

        boolean isCaptioningEnabled();

        boolean isSessionReady();

        void registerCallback(Callback r10, Handler r11);

        void removeQueueItem(MediaDescriptionCompat r10);

        void sendCommand(String r10, Bundle r11, ResultReceiver r12);

        void setVolumeTo(int r10, int r11);

        void unregisterCallback(Callback r10);
    }

    @RequiresApi(21)
    public static class MediaControllerImplApi21 implements MediaControllerImpl {
        private HashMap<Callback, ExtraCallback> mCallbackMap;
        protected final Object mControllerObj;
        final Object mLock;

        @GuardedBy("mLock")
        private final List<Callback> mPendingCallbacks;
        final MediaSessionCompat.Token mSessionToken;

        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 r10) {
                super(null);
                this.mMediaControllerImpl = new WeakReference(r10);
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int r10, Bundle r11) {
                MediaControllerImplApi21 r12 = this.mMediaControllerImpl.get();
                if (r12 == null) goto L14;
                if (r11 == null) goto L17;
                Object r13 = r12.mLock;
                monitor-enter(r13);
                r12.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(d.a(r11, MediaSessionCompat.KEY_EXTRA_BINDER)));     // Catch: Throwable -> L11
                r12.mSessionToken.setSessionToken2Bundle(r11.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE));     // Catch: Throwable -> L11
                r12.processPendingCallbacksLocked();     // Catch: Throwable -> L11
                monitor-exit(r13);     // Catch: Throwable -> L11
                return;
            L11:
                th = move-exception;
                throw th;
            L17:
                return;
            }
        }

        public static class ExtraCallback extends Callback.StubCompat {
            public ExtraCallback(Callback r10) {
                super(r10);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r10) throws RemoteException {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context r10, MediaSessionCompat.Token r11) throws RemoteException {
            this.mLock = new Object();
            this.mPendingCallbacks = new ArrayList();
            this.mCallbackMap = new HashMap();
            this.mSessionToken = r11;
            Object r12 = MediaControllerCompatApi21.fromToken(r10, r11.getToken());
            this.mControllerObj = r12;
            if (r12 == null) goto L9;
            if (r11.getExtraBinder() != null) goto L10;
            requestExtraBinder();
            return;
        L10:
            return;
        L9:
            throw new RemoteException();
        }

        private void requestExtraBinder() {
            sendCommand(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r10) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r11 = new Bundle();
            r11.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, r10);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM, r11, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int r10, int r11) {
            MediaControllerCompatApi21.adjustVolume(this.mControllerObj, r10, r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent r10) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, r10);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            return MediaControllerCompatApi21.getFlags(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return this.mControllerObj;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            Object r10 = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            if (r10 != null) goto L7;
            return null;
        L7:
            return MediaMetadataCompat.fromMediaMetadata(r10);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            Object r10 = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            if (r10 != null) goto L7;
            return null;
        L7:
            return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(r10), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(r10), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(r10), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(r10), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(r10));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            if (this.mSessionToken.getExtraBinder() != null) goto L13;
        L8:
            Object r10 = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
            if (r10 != null) goto L15;
            return null;
        L15:
            return PlaybackStateCompat.fromPlaybackState(r10);
        L13:
            return this.mSessionToken.getExtraBinder().getPlaybackState();
        L6:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e);
            goto L8
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<Object> r10 = MediaControllerCompatApi21.getQueue(this.mControllerObj);
            if (r10 != null) goto L7;
            return null;
        L7:
            return MediaSessionCompat.QueueItem.fromQueueItemList(r10);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            if (this.mSessionToken.getExtraBinder() == null) goto L12;
            return this.mSessionToken.getExtraBinder().getRepeatMode();
        L6:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e);
            return -1;
        L12:
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            if (this.mSessionToken.getExtraBinder() == null) goto L12;
            return this.mSessionToken.getExtraBinder().getShuffleMode();
        L6:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getShuffleMode.", e);
            return -1;
        L12:
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object r10 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (r10 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi21(r10);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            if (this.mSessionToken.getExtraBinder() == null) goto L12;
            return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
        L6:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in isCaptioningEnabled.", e);
            return false;
        L12:
            return false;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            if (this.mSessionToken.getExtraBinder() == null) goto L5;
            return true;
        L5:
            return false;
        }

        @GuardedBy("mLock")
        public void processPendingCallbacksLocked() {
            if (this.mSessionToken.getExtraBinder() != null) goto L5;
            return;
        L5:
            Iterator<Callback> r10 = this.mPendingCallbacks.iterator();
        L7:
            if (r10.hasNext() == false) goto L13;
            Callback r11 = r10.next();
            ExtraCallback r12 = new ExtraCallback(r11);
            this.mCallbackMap.put(r11, r12);
            r11.mIControllerCallback = r12;
            this.mSessionToken.getExtraBinder().registerCallbackListener(r12);     // Catch: RemoteException -> L11
            r11.postToHandler(13, null, null);
        L11:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
        L13:
            this.mPendingCallbacks.clear();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void registerCallback(Callback r10, Handler r11) {
            MediaControllerCompatApi21.registerCallback(this.mControllerObj, r10.mCallbackObj, r11);
            Object r12 = this.mLock;
            monitor-enter(r12);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mSessionToken.getExtraBinder() == null) goto L13;
            ExtraCallback r13 = new ExtraCallback(r10);     // Catch: Throwable -> L9
            this.mCallbackMap.put(r10, r13);     // Catch: Throwable -> L9
            r10.mIControllerCallback = r13;     // Catch: Throwable -> L9
            this.mSessionToken.getExtraBinder().registerCallbackListener(r13);     // Catch: Throwable -> L9 RemoteException -> L11
            r10.postToHandler(13, null, null);     // Catch: Throwable -> L9 RemoteException -> L11
        L14:
            monitor-exit(r12);     // Catch: Throwable -> L9
            return;
        L11:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);     // Catch: Throwable -> L9
            goto L14
        L13:
            r10.mIControllerCallback = null;     // Catch: Throwable -> L9
            this.mPendingCallbacks.add(r10);     // Catch: Throwable -> L9
            goto L14
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat r10) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r11 = new Bundle();
            r11.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, r10);
            sendCommand(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM, r11, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String r10, Bundle r11, ResultReceiver r12) {
            MediaControllerCompatApi21.sendCommand(this.mControllerObj, r10, r11, r12);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int r10, int r11) {
            MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, r10, r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void unregisterCallback(Callback r10) {
            MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, r10.mCallbackObj);
            Object r11 = this.mLock;
            monitor-enter(r11);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mSessionToken.getExtraBinder() != null) goto L21;
            this.mPendingCallbacks.remove(r10);     // Catch: Throwable -> L10
        L15:
            monitor-exit(r11);     // Catch: Throwable -> L10
            return;
        L21:
            ExtraCallback r12 = this.mCallbackMap.remove(r10);     // Catch: Throwable -> L10 RemoteException -> L12
            if (r12 == null) goto L15;
            r10.mIControllerCallback = null;     // Catch: Throwable -> L10 RemoteException -> L12
            this.mSessionToken.getExtraBinder().unregisterCallbackListener(r12);     // Catch: Throwable -> L10 RemoteException -> L12
        L12:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback.", e);     // Catch: Throwable -> L10
            goto L15
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r10, int r11) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r12 = new Bundle();
            r12.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, r10);
            r12.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, r11);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, r12, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }
    }

    @RequiresApi(23)
    public static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context r10, MediaSessionCompat.Token r11) throws RemoteException {
            super(r10, r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object r10 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (r10 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi23(r10);
        }
    }

    @RequiresApi(24)
    public static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context r10, MediaSessionCompat.Token r11) throws RemoteException {
            super(r10, r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi23, android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object r10 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (r10 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi24(r10);
        }
    }

    public static class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession mBinder;
        private TransportControls mTransportControls;

        public MediaControllerImplBase(MediaSessionCompat.Token r10) {
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) r10.getToken());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r10) {
        L5:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItem.", e);
            return;
        L3:
            if ((this.mBinder.getFlags() & 4) == 0) goto L8;
            this.mBinder.addQueueItem(r10);     // Catch: RemoteException -> L5
            return;
        L8:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L5
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int r10, int r11) {
            this.mBinder.adjustVolume(r10, r11, null);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in adjustVolume.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent r10) {
            if (r10 == null) goto L10;
            this.mBinder.sendMediaButton(r10);     // Catch: RemoteException -> L5
            return false;
        L5:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in dispatchMediaButtonEvent.", e);
            return false;
        L10:
            throw new IllegalArgumentException("event may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            return this.mBinder.getExtras();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getExtras.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            return this.mBinder.getFlags();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getFlags.", e);
            return 0;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            return this.mBinder.getMetadata();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getMetadata.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            return this.mBinder.getPackageName();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getPackageName.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            ParcelableVolumeInfo r10 = this.mBinder.getVolumeAttributes();     // Catch: RemoteException -> L4
            return new PlaybackInfo(r10.volumeType, r10.audioStream, r10.controlType, r10.maxVolume, r10.currentVolume);
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackInfo.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            return this.mBinder.getPlaybackState();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            return this.mBinder.getQueue();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getQueue.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            return this.mBinder.getQueueTitle();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getQueueTitle.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            return this.mBinder.getRatingType();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getRatingType.", e);
            return 0;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            return this.mBinder.getRepeatMode();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e);
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            return this.mBinder.getLaunchPendingIntent();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getSessionActivity.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            return this.mBinder.getShuffleMode();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getShuffleMode.", e);
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            if (this.mTransportControls != null) goto L6;
            this.mTransportControls = new TransportControlsBase(this.mBinder);
        L6:
            return this.mTransportControls;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            return this.mBinder.isCaptioningEnabled();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in isCaptioningEnabled.", e);
            return false;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            return true;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void registerCallback(Callback r10, Handler r11) {
            if (r10 == null) goto L10;
            this.mBinder.asBinder().linkToDeath(r10, 0);     // Catch: RemoteException -> L6
            this.mBinder.registerCallbackListener((IMediaControllerCallback) r10.mCallbackObj);     // Catch: RemoteException -> L6
            r10.postToHandler(13, null, null);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
            r10.postToHandler(8, null, null);
            return;
        L10:
            throw new IllegalArgumentException("callback may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat r10) {
        L5:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in removeQueueItem.", e);
            return;
        L3:
            if ((this.mBinder.getFlags() & 4) == 0) goto L8;
            this.mBinder.removeQueueItem(r10);     // Catch: RemoteException -> L5
            return;
        L8:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L5
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String r10, Bundle r11, ResultReceiver r12) {
            this.mBinder.sendCommand(r10, r11, new MediaSessionCompat.ResultReceiverWrapper(r12));     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in sendCommand.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int r10, int r11) {
            this.mBinder.setVolumeTo(r10, r11, null);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setVolumeTo.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void unregisterCallback(Callback r10) {
            if (r10 == null) goto L9;
            this.mBinder.unregisterCallbackListener((IMediaControllerCallback) r10.mCallbackObj);     // Catch: RemoteException -> L5
            this.mBinder.asBinder().unlinkToDeath(r10, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback.", e);
            return;
        L9:
            throw new IllegalArgumentException("callback may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r10, int r11) {
        L5:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItemAt.", e);
            return;
        L3:
            if ((this.mBinder.getFlags() & 4) == 0) goto L8;
            this.mBinder.addQueueItemAt(r10, r11);     // Catch: RemoteException -> L5
            return;
        L8:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L5
        }
    }

    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final int mAudioStream;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        public PlaybackInfo(int r10, int r11, int r12, int r13, int r14) {
            this.mPlaybackType = r10;
            this.mAudioStream = r11;
            this.mVolumeControl = r12;
            this.mMaxVolume = r13;
            this.mCurrentVolume = r14;
        }

        public int getAudioStream() {
            return this.mAudioStream;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }
    }

    public static abstract class TransportControls {
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        public TransportControls() {
        }

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String r10, Bundle r11);

        public abstract void playFromSearch(String r10, Bundle r11);

        public abstract void playFromUri(Uri r10, Bundle r11);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String r10, Bundle r11);

        public abstract void prepareFromSearch(String r10, Bundle r11);

        public abstract void prepareFromUri(Uri r10, Bundle r11);

        public abstract void rewind();

        public abstract void seekTo(long r10);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction r10, Bundle r11);

        public abstract void sendCustomAction(String r10, Bundle r11);

        public abstract void setCaptioningEnabled(boolean r10);

        public abstract void setRating(RatingCompat r10);

        public abstract void setRating(RatingCompat r10, Bundle r11);

        public abstract void setRepeatMode(int r10);

        public abstract void setShuffleMode(int r10);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long r10);

        public abstract void stop();
    }

    public static class TransportControlsApi21 extends TransportControls {
        protected final Object mControlsObj;

        public TransportControlsApi21(Object r10) {
            this.mControlsObj = r10;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String r10, Bundle r11) {
            MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, r10, r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String r10, Bundle r11) {
            MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, r10, r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri r10, Bundle r11) {
            if (r10 == null) goto L8;
            if (Uri.EMPTY.equals(r10) == true) goto L8;
            Bundle r12 = new Bundle();
            r12.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, r10);
            r12.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r11);
            sendCustomAction(MediaSessionCompat.ACTION_PLAY_FROM_URI, r12);
            return;
        L8:
            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String r10, Bundle r11) {
            Bundle r12 = new Bundle();
            r12.putString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID, r10);
            r12.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r11);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID, r12);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String r10, Bundle r11) {
            Bundle r12 = new Bundle();
            r12.putString(MediaSessionCompat.ACTION_ARGUMENT_QUERY, r10);
            r12.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r11);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH, r12);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri r10, Bundle r11) {
            Bundle r12 = new Bundle();
            r12.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, r10);
            r12.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r11);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_URI, r12);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long r10) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, r10);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction r10, Bundle r11) {
            MediaControllerCompat.validateCustomAction(r10.getAction(), r11);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, r10.getAction(), r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean r10) {
            Bundle r11 = new Bundle();
            r11.putBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED, r10);
            sendCustomAction(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED, r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r10) {
            Object r11 = this.mControlsObj;
            if (r10 == null) goto L5;
            Object r12 = r10.getRating();
        L6:
            MediaControllerCompatApi21.TransportControls.setRating(r11, r12);
            return;
        L5:
            r12 = null;
            goto L6
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int r10) {
            Bundle r11 = new Bundle();
            r11.putInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE, r10);
            sendCustomAction(MediaSessionCompat.ACTION_SET_REPEAT_MODE, r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int r10) {
            Bundle r11 = new Bundle();
            r11.putInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE, r10);
            sendCustomAction(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE, r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long r10) {
            MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, r10);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r10, Bundle r11) {
            Bundle r12 = new Bundle();
            r12.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING, r10);
            r12.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r11);
            sendCustomAction(MediaSessionCompat.ACTION_SET_RATING, r12);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String r10, Bundle r11) {
            MediaControllerCompat.validateCustomAction(r10, r11);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, r10, r11);
        }
    }

    @RequiresApi(23)
    public static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object r10) {
            super(r10);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri r10, Bundle r11) {
            MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, r10, r11);
        }
    }

    @RequiresApi(24)
    public static class TransportControlsApi24 extends TransportControlsApi23 {
        public TransportControlsApi24(Object r10) {
            super(r10);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            MediaControllerCompatApi24.TransportControls.prepare(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String r10, Bundle r11) {
            MediaControllerCompatApi24.TransportControls.prepareFromMediaId(this.mControlsObj, r10, r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String r10, Bundle r11) {
            MediaControllerCompatApi24.TransportControls.prepareFromSearch(this.mControlsObj, r10, r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri r10, Bundle r11) {
            MediaControllerCompatApi24.TransportControls.prepareFromUri(this.mControlsObj, r10, r11);
        }
    }

    public static class TransportControlsBase extends TransportControls {
        private IMediaSession mBinder;

        public TransportControlsBase(IMediaSession r10) {
            this.mBinder = r10;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            this.mBinder.fastForward();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in fastForward.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            this.mBinder.pause();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in pause.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            this.mBinder.play();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in play.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String r10, Bundle r11) {
            this.mBinder.playFromMediaId(r10, r11);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in playFromMediaId.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String r10, Bundle r11) {
            this.mBinder.playFromSearch(r10, r11);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in playFromSearch.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri r10, Bundle r11) {
            this.mBinder.playFromUri(r10, r11);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in playFromUri.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            this.mBinder.prepare();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in prepare.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String r10, Bundle r11) {
            this.mBinder.prepareFromMediaId(r10, r11);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromMediaId.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String r10, Bundle r11) {
            this.mBinder.prepareFromSearch(r10, r11);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromSearch.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri r10, Bundle r11) {
            this.mBinder.prepareFromUri(r10, r11);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromUri.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            this.mBinder.rewind();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in rewind.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long r10) {
            this.mBinder.seekTo(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in seekTo.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction r10, Bundle r11) {
            sendCustomAction(r10.getAction(), r11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean r10) {
            this.mBinder.setCaptioningEnabled(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setCaptioningEnabled.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r10) {
            this.mBinder.rate(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setRating.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int r10) {
            this.mBinder.setRepeatMode(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setRepeatMode.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int r10) {
            this.mBinder.setShuffleMode(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setShuffleMode.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            this.mBinder.next();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in skipToNext.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            this.mBinder.previous();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in skipToPrevious.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long r10) {
            this.mBinder.skipToQueueItem(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in skipToQueueItem.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            this.mBinder.stop();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in stop.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String r10, Bundle r11) {
            MediaControllerCompat.validateCustomAction(r10, r11);
            this.mBinder.sendCustomAction(r10, r11);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in sendCustomAction.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r10, Bundle r11) {
            this.mBinder.rateWithExtras(r10, r11);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setRating.", e);
        }
    }

    public MediaControllerCompat(Context r10, @NonNull MediaSessionCompat r11) {
        this.mRegisteredCallbacks = new HashSet();
        if (r11 == null) goto L12;
        MediaSessionCompat.Token r12 = r11.getSessionToken();
        this.mToken = r12;
        MediaControllerImplApi24 r13 = new MediaControllerImplApi24(r10, r12);     // Catch: RemoteException -> L7
    L9:
        this.mImpl = r13;
        return;
    L7:
        e = move-exception;
        Log.w(TAG, "Failed to create MediaControllerImpl.", e);
        r13 = null;
        goto L9
    L12:
        throw new IllegalArgumentException("session must not be null");
    }

    public static MediaControllerCompat getMediaController(@NonNull Activity r10) {
        if ((r10 instanceof ComponentActivity) == false) goto L8;
        MediaControllerExtraData r11 = (MediaControllerExtraData) ((ComponentActivity) r10).getExtraData(MediaControllerExtraData.class);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getMediaController();
    L8:
        Object r12 = MediaControllerCompatApi21.getMediaController(r10);
        if (r12 != null) goto L17;
        return null;
    L17:
        return new MediaControllerCompat(r10, MediaSessionCompat.Token.fromToken(MediaControllerCompatApi21.getSessionToken(r12)));
    L14:
        e = move-exception;
        Log.e(TAG, "Dead object in getMediaController.", e);
        return null;
    }

    public static void setMediaController(@NonNull Activity r10, MediaControllerCompat r11) {
        if ((r10 instanceof ComponentActivity) == false) goto L5;
        ((ComponentActivity) r10).putExtraData(new MediaControllerExtraData(r11));
    L5:
        if (r11 == null) goto L7;
        Object r12 = MediaControllerCompatApi21.fromToken(r10, r11.getSessionToken().getToken());
    L8:
        MediaControllerCompatApi21.setMediaController(r10, r12);
        return;
    L7:
        r12 = null;
        goto L8
    }

    public static void validateCustomAction(String r10, Bundle r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.equals(MediaSessionCompat.ACTION_FOLLOW) == false) goto L7;
    L9:
        if (r11 == null) goto L14;
        if (r11.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE) == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + r10 + LibrarianImpl.Constants.DOT);
    L7:
        if (r10.equals(MediaSessionCompat.ACTION_UNFOLLOW) == true) goto L9;
    }

    public void addQueueItem(MediaDescriptionCompat r10) {
        this.mImpl.addQueueItem(r10);
    }

    public void adjustVolume(int r10, int r11) {
        this.mImpl.adjustVolume(r10, r11);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent r10) {
        if (r10 == null) goto L6;
        return this.mImpl.dispatchMediaButtonEvent(r10);
    L6:
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.mImpl.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mToken;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle getSessionToken2Bundle() {
        return this.mToken.getSessionToken2Bundle();
    }

    public int getShuffleMode() {
        return this.mImpl.getShuffleMode();
    }

    public TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public boolean isCaptioningEnabled() {
        return this.mImpl.isCaptioningEnabled();
    }

    public boolean isSessionReady() {
        return this.mImpl.isSessionReady();
    }

    public void registerCallback(@NonNull Callback r10) {
        registerCallback(r10, null);
    }

    public void removeQueueItem(MediaDescriptionCompat r10) {
        this.mImpl.removeQueueItem(r10);
    }

    @Deprecated
    public void removeQueueItemAt(int r10) {
        List<MediaSessionCompat.QueueItem> r11 = getQueue();
        if (r11 == null) goto L11;
        if (r10 >= 0) goto L6;
        return;
    L6:
        if (r10 >= r11.size()) goto L13;
        MediaSessionCompat.QueueItem r12 = r11.get(r10);
        if (r12 == null) goto L14;
        removeQueueItem(r12.getDescription());
        return;
    L14:
        return;
    L13:
        return;
    }

    public void sendCommand(@NonNull String r10, Bundle r11, ResultReceiver r12) {
        if (TextUtils.isEmpty(r10) == true) goto L7;
        this.mImpl.sendCommand(r10, r11, r12);
        return;
    L7:
        throw new IllegalArgumentException("command must neither be null nor empty");
    }

    public void setVolumeTo(int r10, int r11) {
        this.mImpl.setVolumeTo(r10, r11);
    }

    public void unregisterCallback(@NonNull Callback r10) {
        if (r10 == null) goto L11;
        this.mRegisteredCallbacks.remove(r10);     // Catch: Throwable -> L7
        this.mImpl.unregisterCallback(r10);     // Catch: Throwable -> L7
        r10.setHandler(null);
        return;
    L7:
        th = move-exception;
        r10.setHandler(null);
        throw th;
    L11:
        throw new IllegalArgumentException("callback must not be null");
    }

    public void addQueueItem(MediaDescriptionCompat r10, int r11) {
        this.mImpl.addQueueItem(r10, r11);
    }

    public void registerCallback(@NonNull Callback r10, Handler r11) {
        if (r10 == null) goto L8;
        if (r11 != null) goto L5;
        r11 = new Handler();
    L5:
        r10.setHandler(r11);
        this.mImpl.registerCallback(r10, r11);
        this.mRegisteredCallbacks.add(r10);
        return;
    L8:
        throw new IllegalArgumentException("callback must not be null");
    }

    public MediaControllerCompat(Context r10, @NonNull MediaSessionCompat.Token r11) throws RemoteException {
        this.mRegisteredCallbacks = new HashSet();
        if (r11 == null) goto L7;
        this.mToken = r11;
        this.mImpl = new MediaControllerImplApi24(r10, r11);
        return;
    L7:
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }
}
