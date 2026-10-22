package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
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
import android.view.KeyEvent;
import androidx.core.app.BundleCompat;
import androidx.core.app.ComponentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaControllerCompat {
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
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

            @Override // android.os.Handler
            public void handleMessage(Message r100) {
                if (this.mRegistered == true) goto L6;
                return;
            L6:
                switch(r100.what) {
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
                this.this$0.onShuffleModeChanged(((Integer) r100.obj).intValue());
                return;
            L10:
                this.this$0.onCaptioningEnabledChanged(((Boolean) r100.obj).booleanValue());
                return;
            L11:
                this.this$0.onRepeatModeChanged(((Integer) r100.obj).intValue());
                return;
            L12:
                this.this$0.onSessionDestroyed();
                return;
            L13:
                Bundle r101 = (Bundle) r100.obj;
                MediaSessionCompat.ensureClassLoader(r101);
                this.this$0.onExtrasChanged(r101);
                return;
            L14:
                this.this$0.onQueueTitleChanged((CharSequence) r100.obj);
                return;
            L15:
                this.this$0.onQueueChanged((List) r100.obj);
                return;
            L16:
                this.this$0.onAudioInfoChanged((PlaybackInfo) r100.obj);
                return;
            L17:
                this.this$0.onMetadataChanged((MediaMetadataCompat) r100.obj);
                return;
            L18:
                this.this$0.onPlaybackStateChanged((PlaybackStateCompat) r100.obj);
                return;
            L19:
                Bundle r102 = r100.getData();
                MediaSessionCompat.ensureClassLoader(r102);
                this.this$0.onSessionEvent((String) r100.obj, r102);
                return;
            }

            public MessageHandler(Callback r100, Looper r101) {
                this.this$0 = r100;
                super(r101);
                this.mRegistered = false;
            }
        }

        public static class StubApi21 implements MediaControllerCompatApi21.Callback {
            private final WeakReference<Callback> mCallback;

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionDestroyed() {
                Callback r100 = this.mCallback.get();
                if (r100 == null) goto L6;
                r100.onSessionDestroyed();
                return;
            }

            public StubApi21(Callback r100) {
                this.mCallback = new WeakReference(r100);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onExtrasChanged(Bundle r100) {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.onExtrasChanged(r100);
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onMetadataChanged(Object r100) {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(r100));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onPlaybackStateChanged(Object r100) {
                Callback r101 = this.mCallback.get();
                if (r101 != null) goto L5;
                return;
            L5:
                if (r101.mIControllerCallback != null) goto L10;
                r101.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(r100));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueChanged(List<?> r100) {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(r100));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueTitleChanged(CharSequence r100) {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.onQueueTitleChanged(r100);
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionEvent(String r100, Bundle r101) {
                Callback r102 = this.mCallback.get();
                if (r102 != null) goto L5;
                return;
            L5:
                if (r102.mIControllerCallback != null) goto L7;
            L9:
                r102.onSessionEvent(r100, r101);
                return;
            L7:
                if (Build.VERSION.SDK_INT >= 23) goto L9;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onAudioInfoChanged(int r100, int r110, int r111, int r112, int r113) {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.onAudioInfoChanged(new PlaybackInfo(r100, r110, r111, r112, r113));
                return;
            }
        }

        public static class StubCompat extends IMediaControllerCallback.Stub {
            private final WeakReference<Callback> mCallback;

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean r100) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Callback r100 = this.mCallback.get();
                if (r100 == null) goto L6;
                r100.postToHandler(8, null, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Callback r100 = this.mCallback.get();
                if (r100 == null) goto L6;
                r100.postToHandler(13, null, null);
                return;
            }

            public StubCompat(Callback r100) {
                this.mCallback = new WeakReference(r100);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean r100) throws RemoteException {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.postToHandler(11, Boolean.valueOf(r100), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r100) throws RemoteException {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.postToHandler(7, r100, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r100) throws RemoteException {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.postToHandler(3, r100, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat r100) throws RemoteException {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.postToHandler(2, r100, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r100) throws RemoteException {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.postToHandler(5, r100, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r100) throws RemoteException {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.postToHandler(6, r100, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int r100) throws RemoteException {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.postToHandler(9, Integer.valueOf(r100), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int r100) throws RemoteException {
                Callback r101 = this.mCallback.get();
                if (r101 == null) goto L6;
                r101.postToHandler(12, Integer.valueOf(r100), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r110) throws RemoteException {
                Callback r100 = this.mCallback.get();
                if (r100 != null) goto L5;
                return;
            L5:
                if (r110 == null) goto L7;
                PlaybackInfo r101 = new PlaybackInfo(r110.volumeType, r110.audioStream, r110.controlType, r110.maxVolume, r110.currentVolume);
            L8:
                r100.postToHandler(4, r101, null);
                return;
            L7:
                r101 = null;
                goto L8
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String r100, Bundle r101) throws RemoteException {
                Callback r102 = this.mCallback.get();
                if (r102 == null) goto L6;
                r102.postToHandler(1, r100, r101);
                return;
            }
        }

        public void onAudioInfoChanged(PlaybackInfo r100) {
        }

        public void onCaptioningEnabledChanged(boolean r100) {
        }

        public void onExtrasChanged(Bundle r100) {
        }

        public void onMetadataChanged(MediaMetadataCompat r100) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat r100) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> r100) {
        }

        public void onQueueTitleChanged(CharSequence r100) {
        }

        public void onRepeatModeChanged(int r100) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String r100, Bundle r101) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int r100) {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            postToHandler(8, null, null);
        }

        public Callback() {
            this.mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21(this));
        }

        public IMediaControllerCallback getIControllerCallback() {
            return this.mIControllerCallback;
        }

        public void setHandler(Handler r100) {
            if (r100 != null) goto L6;
            MessageHandler r101 = this.mHandler;
            if (r101 == null) goto L8;
            r101.mRegistered = false;
            r101.removeCallbacksAndMessages(null);
            this.mHandler = null;
            return;
        L8:
            return;
        L6:
            MessageHandler r102 = new MessageHandler(this, r100.getLooper());
            this.mHandler = r102;
            r102.mRegistered = true;
        }

        public void postToHandler(int r100, Object r101, Bundle r102) {
            MessageHandler r103 = this.mHandler;
            if (r103 == null) goto L6;
            Message r104 = r103.obtainMessage(r100, r101);
            r104.setData(r102);
            r104.sendToTarget();
            return;
        }
    }

    public static class MediaControllerExtraData extends ComponentActivity.ExtraData {
        private final MediaControllerCompat mMediaController;

        public MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }

        public MediaControllerExtraData(MediaControllerCompat r100) {
            this.mMediaController = r100;
        }
    }

    public interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat r100);

        void addQueueItem(MediaDescriptionCompat r100, int r101);

        void adjustVolume(int r100, int r101);

        boolean dispatchMediaButtonEvent(KeyEvent r100);

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

        void registerCallback(Callback r100, Handler r101);

        void removeQueueItem(MediaDescriptionCompat r100);

        void sendCommand(String r100, Bundle r101, ResultReceiver r102);

        void setVolumeTo(int r100, int r101);

        void unregisterCallback(Callback r100);
    }

    public static class MediaControllerImplApi21 implements MediaControllerImpl {
        private HashMap<Callback, ExtraCallback> mCallbackMap;
        protected final Object mControllerObj;
        final Object mLock;
        private final List<Callback> mPendingCallbacks;
        final MediaSessionCompat.Token mSessionToken;

        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 r100) {
                super(null);
                this.mMediaControllerImpl = new WeakReference(r100);
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int r100, Bundle r101) {
                MediaControllerImplApi21 r102 = this.mMediaControllerImpl.get();
                if (r102 == null) goto L14;
                if (r101 == null) goto L17;
                Object r103 = r102.mLock;
                monitor-enter(r103);
                r102.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(r101, MediaSessionCompat.KEY_EXTRA_BINDER)));     // Catch: Throwable -> L11
                r102.mSessionToken.setSessionToken2Bundle(r101.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE));     // Catch: Throwable -> L11
                r102.processPendingCallbacksLocked();     // Catch: Throwable -> L11
                monitor-exit(r103);     // Catch: Throwable -> L11
                return;
            L11:
                th = move-exception;
                throw th;
            L17:
                return;
            }
        }

        public static class ExtraCallback extends Callback.StubCompat {
            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            public ExtraCallback(Callback r100) {
                super(r100);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r100) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r100) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r100) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r100) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r100) throws RemoteException {
                throw new AssertionError();
            }
        }

        private void requestExtraBinder() {
            sendCommand(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, null, new ExtraBinderRequestResultReceiver(this));
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
        public MediaMetadataCompat getMetadata() {
            Object r100 = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            if (r100 != null) goto L7;
            return null;
        L7:
            return MediaMetadataCompat.fromMediaMetadata(r100);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            Object r100 = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            if (r100 != null) goto L7;
            return null;
        L7:
            return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(r100), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(r100), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(r100), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(r100), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(r100));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            if (this.mSessionToken.getExtraBinder() != null) goto L12;
        L7:
            Object r100 = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
            if (r100 != null) goto L14;
            return null;
        L14:
            return PlaybackStateCompat.fromPlaybackState(r100);
        L12:
            return this.mSessionToken.getExtraBinder().getPlaybackState();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<Object> r100 = MediaControllerCompatApi21.getQueue(this.mControllerObj);
            if (r100 != null) goto L7;
            return null;
        L7:
            return MediaSessionCompat.QueueItem.fromQueueItemList(r100);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            if (Build.VERSION.SDK_INT >= 22) goto L9;
            if (this.mSessionToken.getExtraBinder() == null) goto L9;
            return this.mSessionToken.getExtraBinder().getRatingType();
        L9:
            return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            if (this.mSessionToken.getExtraBinder() != null) goto L9;
            return -1;
        L9:
            return this.mSessionToken.getExtraBinder().getRepeatMode();
        L11:
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            if (this.mSessionToken.getExtraBinder() != null) goto L9;
            return -1;
        L9:
            return this.mSessionToken.getExtraBinder().getShuffleMode();
        L11:
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object r100 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (r100 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi21(r100);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            if (this.mSessionToken.getExtraBinder() != null) goto L9;
            return false;
        L9:
            return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
        L11:
            return false;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            if (this.mSessionToken.getExtraBinder() == null) goto L5;
            return true;
        L5:
            return false;
        }

        public void processPendingCallbacksLocked() {
            if (this.mSessionToken.getExtraBinder() != null) goto L5;
            return;
        L5:
            Iterator<Callback> r100 = this.mPendingCallbacks.iterator();
        L7:
            if (r100.hasNext() == false) goto L11;
            Callback r101 = r100.next();
            ExtraCallback r102 = new ExtraCallback(r101);
            this.mCallbackMap.put(r101, r102);
            r101.mIControllerCallback = r102;
            this.mSessionToken.getExtraBinder().registerCallbackListener(r102);     // Catch: RemoteException -> L13
            r101.postToHandler(13, null, null);
        L11:
            this.mPendingCallbacks.clear();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return this.mControllerObj;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r100) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r101 = new Bundle();
            r101.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, r100);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM, r101, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent r100) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, r100);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat r100) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r101 = new Bundle();
            r101.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, r100);
            sendCommand(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM, r101, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void unregisterCallback(Callback r100) {
            MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, r100.mCallbackObj);
            Object r101 = this.mLock;
            monitor-enter(r101);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.mSessionToken.getExtraBinder() != null) goto L19;
            this.mPendingCallbacks.remove(r100);     // Catch: Throwable -> L13
        L11:
            monitor-exit(r101);     // Catch: Throwable -> L13
            return;
        L19:
            ExtraCallback r102 = this.mCallbackMap.remove(r100);     // Catch: RemoteException -> L16 Throwable -> L13
            if (r102 == null) goto L11;
            r100.mIControllerCallback = null;     // Catch: RemoteException -> L16 Throwable -> L13
            this.mSessionToken.getExtraBinder().unregisterCallbackListener(r102);     // Catch: RemoteException -> L16 Throwable -> L13
            goto L11
        }

        public MediaControllerImplApi21(Context r100, MediaSessionCompat.Token r101) throws RemoteException {
            this.mLock = new Object();
            this.mPendingCallbacks = new ArrayList();
            this.mCallbackMap = new HashMap();
            this.mSessionToken = r101;
            Object r102 = MediaControllerCompatApi21.fromToken(r100, r101.getToken());
            this.mControllerObj = r102;
            if (r102 == null) goto L9;
            if (r101.getExtraBinder() != null) goto L10;
            requestExtraBinder();
            return;
        L10:
            return;
        L9:
            throw new RemoteException();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r100, int r101) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r102 = new Bundle();
            r102.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, r100);
            r102.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, r101);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, r102, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int r100, int r101) {
            MediaControllerCompatApi21.adjustVolume(this.mControllerObj, r100, r101);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void registerCallback(Callback r100, Handler r101) {
            MediaControllerCompatApi21.registerCallback(this.mControllerObj, r100.mCallbackObj, r101);
            Object r102 = this.mLock;
            monitor-enter(r102);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mSessionToken.getExtraBinder() == null) goto L9;
            ExtraCallback r103 = new ExtraCallback(r100);     // Catch: Throwable -> L12
            this.mCallbackMap.put(r100, r103);     // Catch: Throwable -> L12
            r100.mIControllerCallback = r103;     // Catch: Throwable -> L12
            this.mSessionToken.getExtraBinder().registerCallbackListener(r103);     // Catch: RemoteException -> L15 Throwable -> L12
            r100.postToHandler(13, null, null);     // Catch: RemoteException -> L15 Throwable -> L12
        L10:
            monitor-exit(r102);     // Catch: Throwable -> L12
            return;
        L9:
            r100.mIControllerCallback = null;     // Catch: Throwable -> L12
            this.mPendingCallbacks.add(r100);     // Catch: Throwable -> L12
            goto L10
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int r100, int r101) {
            MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, r100, r101);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String r100, Bundle r101, ResultReceiver r102) {
            MediaControllerCompatApi21.sendCommand(this.mControllerObj, r100, r101, r102);
        }
    }

    public static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object r100 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (r100 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi23(r100);
        }

        public MediaControllerImplApi23(Context r100, MediaSessionCompat.Token r101) throws RemoteException {
            super(r100, r101);
        }
    }

    public static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi23, android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object r100 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (r100 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi24(r100);
        }

        public MediaControllerImplApi24(Context r100, MediaSessionCompat.Token r101) throws RemoteException {
            super(r100, r101);
        }
    }

    public static class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession mBinder;
        private TransportControls mTransportControls;

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            return true;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            return this.mBinder.getExtras();
        L4:
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            return this.mBinder.getFlags();
        L4:
            return 0;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            return this.mBinder.getMetadata();
        L4:
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            return this.mBinder.getPackageName();
        L4:
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            ParcelableVolumeInfo r100 = this.mBinder.getVolumeAttributes();     // Catch: RemoteException -> L4
            return new PlaybackInfo(r100.volumeType, r100.audioStream, r100.controlType, r100.maxVolume, r100.currentVolume);
        L4:
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            return this.mBinder.getPlaybackState();
        L4:
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            return this.mBinder.getQueue();
        L4:
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            return this.mBinder.getQueueTitle();
        L4:
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            return this.mBinder.getRatingType();
        L4:
            return 0;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            return this.mBinder.getRepeatMode();
        L4:
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            return this.mBinder.getLaunchPendingIntent();
        L4:
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            return this.mBinder.getShuffleMode();
        L4:
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
            return false;
        }

        public MediaControllerImplBase(MediaSessionCompat.Token r100) {
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) r100.getToken());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r100) {
            if ((this.mBinder.getFlags() & 4) == 0) goto L6;
            this.mBinder.addQueueItem(r100);     // Catch: RemoteException -> L8
            return;
        L6:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L8
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent r100) {
            if (r100 == null) goto L7;
            this.mBinder.sendMediaButton(r100);     // Catch: RemoteException -> L8
            return false;
        L11:
            return false;
        L7:
            throw new IllegalArgumentException("event may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat r100) {
            if ((this.mBinder.getFlags() & 4) == 0) goto L6;
            this.mBinder.removeQueueItem(r100);     // Catch: RemoteException -> L8
            return;
        L6:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L8
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void unregisterCallback(Callback r100) {
            if (r100 == null) goto L6;
            this.mBinder.unregisterCallbackListener((IMediaControllerCallback) r100.mCallbackObj);     // Catch: RemoteException -> L7
            this.mBinder.asBinder().unlinkToDeath(r100, 0);     // Catch: RemoteException -> L7
            return;
        L10:
            return;
        L6:
            throw new IllegalArgumentException("callback may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r100, int r101) {
            if ((this.mBinder.getFlags() & 4) == 0) goto L6;
            this.mBinder.addQueueItemAt(r100, r101);     // Catch: RemoteException -> L8
            return;
        L6:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L8
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int r100, int r101) {
            this.mBinder.adjustVolume(r100, r101, null);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void registerCallback(Callback r100, Handler r101) {
            if (r100 == null) goto L9;
            this.mBinder.asBinder().linkToDeath(r100, 0);     // Catch: RemoteException -> L6
            this.mBinder.registerCallbackListener((IMediaControllerCallback) r100.mCallbackObj);     // Catch: RemoteException -> L6
            r100.postToHandler(13, null, null);     // Catch: RemoteException -> L6
            return;
        L6:
            r100.postToHandler(8, null, null);
            return;
        L9:
            throw new IllegalArgumentException("callback may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int r100, int r101) {
            this.mBinder.setVolumeTo(r100, r101, null);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String r100, Bundle r101, ResultReceiver r102) {
            this.mBinder.sendCommand(r100, r101, new MediaSessionCompat.ResultReceiverWrapper(r102));     // Catch: RemoteException -> L4
            return;
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

        public PlaybackInfo(int r100, int r101, int r102, int r103, int r104) {
            this.mPlaybackType = r100;
            this.mAudioStream = r101;
            this.mVolumeControl = r102;
            this.mMaxVolume = r103;
            this.mCurrentVolume = r104;
        }
    }

    public static abstract class TransportControls {
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String r100, Bundle r101);

        public abstract void playFromSearch(String r100, Bundle r101);

        public abstract void playFromUri(Uri r100, Bundle r101);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String r100, Bundle r101);

        public abstract void prepareFromSearch(String r100, Bundle r101);

        public abstract void prepareFromUri(Uri r100, Bundle r101);

        public abstract void rewind();

        public abstract void seekTo(long r100);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction r100, Bundle r101);

        public abstract void sendCustomAction(String r100, Bundle r101);

        public abstract void setCaptioningEnabled(boolean r100);

        public abstract void setRating(RatingCompat r100);

        public abstract void setRating(RatingCompat r100, Bundle r101);

        public abstract void setRepeatMode(int r100);

        public abstract void setShuffleMode(int r100);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long r100);

        public abstract void stop();

        public TransportControls() {
        }
    }

    public static class TransportControlsApi21 extends TransportControls {
        protected final Object mControlsObj;

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
        public void prepare() {
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
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
        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
        }

        public TransportControlsApi21(Object r100) {
            this.mControlsObj = r100;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long r100) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, r100);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean r100) {
            Bundle r101 = new Bundle();
            r101.putBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED, r100);
            sendCustomAction(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED, r101);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r100) {
            Object r101 = this.mControlsObj;
            if (r100 == null) goto L5;
            Object r102 = r100.getRating();
        L6:
            MediaControllerCompatApi21.TransportControls.setRating(r101, r102);
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int r100) {
            Bundle r101 = new Bundle();
            r101.putInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE, r100);
            sendCustomAction(MediaSessionCompat.ACTION_SET_REPEAT_MODE, r101);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int r100) {
            Bundle r101 = new Bundle();
            r101.putInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE, r100);
            sendCustomAction(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE, r101);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long r100) {
            MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, r100);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String r100, Bundle r101) {
            MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, r100, r101);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String r100, Bundle r101) {
            MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, r100, r101);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri r100, Bundle r101) {
            if (r100 == null) goto L8;
            if (Uri.EMPTY.equals(r100) == true) goto L8;
            Bundle r102 = new Bundle();
            r102.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, r100);
            r102.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r101);
            sendCustomAction(MediaSessionCompat.ACTION_PLAY_FROM_URI, r102);
            return;
        L8:
            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String r100, Bundle r101) {
            Bundle r102 = new Bundle();
            r102.putString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID, r100);
            r102.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r101);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID, r102);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String r100, Bundle r101) {
            Bundle r102 = new Bundle();
            r102.putString(MediaSessionCompat.ACTION_ARGUMENT_QUERY, r100);
            r102.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r101);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH, r102);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri r100, Bundle r101) {
            Bundle r102 = new Bundle();
            r102.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, r100);
            r102.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r101);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_URI, r102);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction r100, Bundle r101) {
            MediaControllerCompat.validateCustomAction(r100.getAction(), r101);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, r100.getAction(), r101);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r100, Bundle r101) {
            Bundle r102 = new Bundle();
            r102.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING, r100);
            r102.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r101);
            sendCustomAction(MediaSessionCompat.ACTION_SET_RATING, r102);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String r100, Bundle r101) {
            MediaControllerCompat.validateCustomAction(r100, r101);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, r100, r101);
        }
    }

    public static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object r100) {
            super(r100);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri r100, Bundle r101) {
            MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, r100, r101);
        }
    }

    public static class TransportControlsApi24 extends TransportControlsApi23 {
        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            MediaControllerCompatApi24.TransportControls.prepare(this.mControlsObj);
        }

        public TransportControlsApi24(Object r100) {
            super(r100);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String r100, Bundle r101) {
            MediaControllerCompatApi24.TransportControls.prepareFromMediaId(this.mControlsObj, r100, r101);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String r100, Bundle r101) {
            MediaControllerCompatApi24.TransportControls.prepareFromSearch(this.mControlsObj, r100, r101);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri r100, Bundle r101) {
            MediaControllerCompatApi24.TransportControls.prepareFromUri(this.mControlsObj, r100, r101);
        }
    }

    public static class TransportControlsBase extends TransportControls {
        private IMediaSession mBinder;

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            this.mBinder.fastForward();     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            this.mBinder.pause();     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            this.mBinder.play();     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            this.mBinder.prepare();     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            this.mBinder.rewind();     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            this.mBinder.next();     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            this.mBinder.previous();     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            this.mBinder.stop();     // Catch: RemoteException -> L4
            return;
        }

        public TransportControlsBase(IMediaSession r100) {
            this.mBinder = r100;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long r100) {
            this.mBinder.seekTo(r100);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean r100) {
            this.mBinder.setCaptioningEnabled(r100);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r100) {
            this.mBinder.rate(r100);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int r100) {
            this.mBinder.setRepeatMode(r100);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int r100) {
            this.mBinder.setShuffleMode(r100);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long r100) {
            this.mBinder.skipToQueueItem(r100);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String r100, Bundle r101) {
            this.mBinder.playFromMediaId(r100, r101);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String r100, Bundle r101) {
            this.mBinder.playFromSearch(r100, r101);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri r100, Bundle r101) {
            this.mBinder.playFromUri(r100, r101);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String r100, Bundle r101) {
            this.mBinder.prepareFromMediaId(r100, r101);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String r100, Bundle r101) {
            this.mBinder.prepareFromSearch(r100, r101);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri r100, Bundle r101) {
            this.mBinder.prepareFromUri(r100, r101);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String r100, Bundle r101) {
            MediaControllerCompat.validateCustomAction(r100, r101);
            this.mBinder.sendCustomAction(r100, r101);     // Catch: RemoteException -> L5
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r100, Bundle r101) {
            this.mBinder.rateWithExtras(r100, r101);     // Catch: RemoteException -> L4
            return;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction r100, Bundle r101) {
            sendCustomAction(r100.getAction(), r101);
        }
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
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

    public MediaSessionCompat.Token getSessionToken() {
        return this.mToken;
    }

    public static MediaControllerCompat getMediaController(Activity r100) {
        if ((r100 instanceof ComponentActivity) == false) goto L8;
        MediaControllerExtraData r101 = (MediaControllerExtraData) ((ComponentActivity) r100).getExtraData(MediaControllerExtraData.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getMediaController();
    L8:
        Object r102 = MediaControllerCompatApi21.getMediaController(r100);
        if (r102 != null) goto L15;
        return null;
    L15:
        return new MediaControllerCompat(r100, MediaSessionCompat.Token.fromToken(MediaControllerCompatApi21.getSessionToken(r102)));
    L14:
        return null;
    }

    public void addQueueItem(MediaDescriptionCompat r100) {
        this.mImpl.addQueueItem(r100);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent r100) {
        if (r100 == null) goto L6;
        return this.mImpl.dispatchMediaButtonEvent(r100);
    L6:
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public void registerCallback(Callback r100) {
        registerCallback(r100, null);
    }

    public void removeQueueItem(MediaDescriptionCompat r100) {
        this.mImpl.removeQueueItem(r100);
    }

    public void removeQueueItemAt(int r100) {
        List<MediaSessionCompat.QueueItem> r101 = getQueue();
        if (r101 == null) goto L11;
        if (r100 >= 0) goto L6;
        return;
    L6:
        if (r100 >= r101.size()) goto L13;
        MediaSessionCompat.QueueItem r102 = (MediaSessionCompat.QueueItem) ListProtector.get(r101, r100);
        if (r102 == null) goto L14;
        removeQueueItem(r102.getDescription());
        return;
    L14:
        return;
    L13:
        return;
    }

    public void unregisterCallback(Callback r100) {
        if (r100 == null) goto L11;
        this.mRegisteredCallbacks.remove(r100);     // Catch: Throwable -> L7
        this.mImpl.unregisterCallback(r100);     // Catch: Throwable -> L7
        r100.setHandler(null);
        return;
    L7:
        th = move-exception;
        r100.setHandler(null);
        throw th;
    L11:
        throw new IllegalArgumentException("callback must not be null");
    }

    public MediaControllerCompat(Context r100, MediaSessionCompat r101) {
        this.mRegisteredCallbacks = new HashSet();
        if (r101 == null) goto L17;
        MediaSessionCompat.Token r102 = r101.getSessionToken();
        this.mToken = r102;
        int r103 = Build.VERSION.SDK_INT;     // Catch: RemoteException -> L13
        if (r103 < 24) goto L9;
        MediaControllerImpl r104 = new MediaControllerImplApi24(r100, r102);     // Catch: RemoteException -> L13
    L18:
    L14:
        this.mImpl = r104;
        return;
    L9:
        if (r103 < 23) goto L11;
        r104 = new MediaControllerImplApi23(r100, r102);     // Catch: RemoteException -> L13
        goto L18
    L11:
        r104 = new MediaControllerImplApi21(r100, r102);     // Catch: RemoteException -> L13
    L13:
        r104 = null;
        goto L14
    L17:
        throw new IllegalArgumentException("session must not be null");
    }

    public static void setMediaController(Activity r100, MediaControllerCompat r101) {
        if ((r100 instanceof ComponentActivity) == false) goto L5;
        ((ComponentActivity) r100).putExtraData(new MediaControllerExtraData(r101));
    L5:
        if (r101 == null) goto L7;
        Object r102 = MediaControllerCompatApi21.fromToken(r100, r101.getSessionToken().getToken());
    L8:
        MediaControllerCompatApi21.setMediaController(r100, r102);
        return;
    L7:
        r102 = null;
        goto L8
    }

    public static void validateCustomAction(String r100, Bundle r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.equals(MediaSessionCompat.ACTION_FOLLOW) == false) goto L7;
    L9:
        if (r101 == null) goto L14;
        if (r101.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE) == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + r100 + ".");
    L7:
        if (r100.equals(MediaSessionCompat.ACTION_UNFOLLOW) == true) goto L9;
    }

    public void addQueueItem(MediaDescriptionCompat r100, int r101) {
        this.mImpl.addQueueItem(r100, r101);
    }

    public void adjustVolume(int r100, int r101) {
        this.mImpl.adjustVolume(r100, r101);
    }

    public void registerCallback(Callback r100, Handler r101) {
        if (r100 == null) goto L8;
        if (r101 != null) goto L5;
        r101 = new Handler();
    L5:
        r100.setHandler(r101);
        this.mImpl.registerCallback(r100, r101);
        this.mRegisteredCallbacks.add(r100);
        return;
    L8:
        throw new IllegalArgumentException("callback must not be null");
    }

    public void setVolumeTo(int r100, int r101) {
        this.mImpl.setVolumeTo(r100, r101);
    }

    public MediaControllerCompat(Context r100, MediaSessionCompat.Token r101) throws RemoteException {
        this.mRegisteredCallbacks = new HashSet();
        if (r101 == null) goto L13;
        this.mToken = r101;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 24) goto L8;
        this.mImpl = new MediaControllerImplApi24(r100, r101);
        return;
    L8:
        if (r102 < 23) goto L10;
        this.mImpl = new MediaControllerImplApi23(r100, r101);
        return;
    L10:
        this.mImpl = new MediaControllerImplApi21(r100, r101);
        return;
    L13:
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public void sendCommand(String r100, Bundle r101, ResultReceiver r102) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.mImpl.sendCommand(r100, r101, r102);
        return;
    L7:
        throw new IllegalArgumentException("command must neither be null nor empty");
    }
}
