package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediaSessionCompat {
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final ArrayList<OnActiveChangeListener> mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    public static abstract class Callback {
        private CallbackHandler mCallbackHandler;
        final Object mCallbackObj;
        private boolean mMediaPlayPauseKeyPending;
        WeakReference<MediaSessionImpl> mSessionImpl;

        public class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;
            final /* synthetic */ Callback this$0;

            @Override // android.os.Handler
            public void handleMessage(Message r100) {
                if (r100.what != 1) goto L6;
                this.this$0.handleMediaPlayPauseKeySingleTapIfPending((MediaSessionManager.RemoteUserInfo) r100.obj);
                return;
            }

            public CallbackHandler(Callback r100, Looper r101) {
                this.this$0 = r100;
                super(r101);
            }
        }

        public class StubApi21 implements MediaSessionCompatApi21.Callback {
            final /* synthetic */ Callback this$0;

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(Object r100, Bundle r101) {
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onFastForward() {
                this.this$0.onFastForward();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPause() {
                this.this$0.onPause();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlay() {
                this.this$0.onPlay();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onRewind() {
                this.this$0.onRewind();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToNext() {
                this.this$0.onSkipToNext();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToPrevious() {
                this.this$0.onSkipToPrevious();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onStop() {
                this.this$0.onStop();
            }

            public StubApi21(Callback r100) {
                this.this$0 = r100;
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public boolean onMediaButtonEvent(Intent r100) {
                return this.this$0.onMediaButtonEvent(r100);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSeekTo(long r100) {
                this.this$0.onSeekTo(r100);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(Object r100) {
                this.this$0.onSetRating(RatingCompat.fromRating(r100));
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToQueueItem(long r100) {
                this.this$0.onSkipToQueueItem(r100);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCustomAction(String r100, Bundle r101) {
                Bundle r102 = r101.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(r102);
                if (r100.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI) == false) goto L6;
                Uri r103 = (Uri) r101.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                this.this$0.onPlayFromUri(r103, r102);
                return;
            L6:
                if (r100.equals(MediaSessionCompat.ACTION_PREPARE) == false) goto L9;
                this.this$0.onPrepare();
                return;
            L9:
                if (r100.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID) == false) goto L12;
                String r104 = r101.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID);
                this.this$0.onPrepareFromMediaId(r104, r102);
                return;
            L12:
                if (r100.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH) == false) goto L15;
                String r105 = r101.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY);
                this.this$0.onPrepareFromSearch(r105, r102);
                return;
            L15:
                if (r100.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI) == false) goto L18;
                Uri r106 = (Uri) r101.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                this.this$0.onPrepareFromUri(r106, r102);
                return;
            L18:
                if (r100.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED) == false) goto L21;
                boolean r107 = r101.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED);
                this.this$0.onSetCaptioningEnabled(r107);
                return;
            L21:
                if (r100.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE) == false) goto L24;
                int r108 = r101.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE);
                this.this$0.onSetRepeatMode(r108);
                return;
            L24:
                if (r100.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE) == false) goto L27;
                int r109 = r101.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE);
                this.this$0.onSetShuffleMode(r109);
                return;
            L27:
                if (r100.equals(MediaSessionCompat.ACTION_SET_RATING) == false) goto L29;
                RatingCompat r110 = (RatingCompat) r101.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING);
                this.this$0.onSetRating(r110, r102);
                return;
            L29:
                this.this$0.onCustomAction(r100, r101);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromMediaId(String r100, Bundle r101) {
                this.this$0.onPlayFromMediaId(r100, r101);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromSearch(String r100, Bundle r101) {
                this.this$0.onPlayFromSearch(r100, r101);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCommand(String r100, Bundle r101, ResultReceiver r102) {
                QueueItem r103 = null;
                IBinder r104 = null;
                r103 = null;
                if (r100.equals(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER) == false) goto L13;
                MediaSessionImplApi21 r105 = (MediaSessionImplApi21) this.this$0.mSessionImpl.get();     // Catch: BadParcelableException -> L37
                if (r105 == null) goto L39;
                Bundle r106 = new Bundle();     // Catch: BadParcelableException -> L37
                Token r107 = r105.getSessionToken();     // Catch: BadParcelableException -> L37
                IMediaSession r108 = r107.getExtraBinder();     // Catch: BadParcelableException -> L37
                if (r108 == null) goto L10;
                r104 = r108.asBinder();     // Catch: BadParcelableException -> L37
            L10:
                BundleCompat.putBinder(r106, MediaSessionCompat.KEY_EXTRA_BINDER, r104);     // Catch: BadParcelableException -> L37
                r106.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, r107.getSessionToken2Bundle());     // Catch: BadParcelableException -> L37
                r102.send(0, r106);     // Catch: BadParcelableException -> L37
                return;
            L39:
                return;
            L13:
                if (r100.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM) == false) goto L17;
                this.this$0.onAddQueueItem((MediaDescriptionCompat) r101.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));     // Catch: BadParcelableException -> L37
                return;
            L17:
                if (r100.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT) == false) goto L20;
                this.this$0.onAddQueueItem((MediaDescriptionCompat) r101.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION), r101.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX));     // Catch: BadParcelableException -> L37
                return;
            L20:
                if (r100.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM) == false) goto L23;
                this.this$0.onRemoveQueueItem((MediaDescriptionCompat) r101.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));     // Catch: BadParcelableException -> L37
                return;
            L23:
                if (r100.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT) == false) goto L35;
                MediaSessionImplApi21 r109 = (MediaSessionImplApi21) this.this$0.mSessionImpl.get();     // Catch: BadParcelableException -> L37
                if (r109 != null) goto L27;
                return;
            L27:
                if (r109.mQueue == null) goto L45;
                int r110 = r101.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, -1);     // Catch: BadParcelableException -> L37
                if (r110 >= 0) goto L31;
            L33:
                if (r103 == null) goto L46;
                this.this$0.onRemoveQueueItem(r103.getDescription());     // Catch: BadParcelableException -> L37
                return;
            L46:
                return;
            L31:
                if (r110 >= r109.mQueue.size()) goto L33;
                r103 = (QueueItem) ListProtector.get(r109.mQueue, r110);     // Catch: BadParcelableException -> L37
                goto L33
            L45:
                return;
            L35:
                this.this$0.onCommand(r100, r101, r102);     // Catch: BadParcelableException -> L37
                return;
            }
        }

        public class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback {
            final /* synthetic */ Callback this$0;

            public StubApi23(Callback r100) {
                this.this$0 = r100;
                super(r100);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
            public void onPlayFromUri(Uri r100, Bundle r101) {
                this.this$0.onPlayFromUri(r100, r101);
            }
        }

        public class StubApi24 extends StubApi23 implements MediaSessionCompatApi24.Callback {
            final /* synthetic */ Callback this$0;

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepare() {
                this.this$0.onPrepare();
            }

            public StubApi24(Callback r100) {
                this.this$0 = r100;
                super(r100);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromMediaId(String r100, Bundle r101) {
                this.this$0.onPrepareFromMediaId(r100, r101);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromSearch(String r100, Bundle r101) {
                this.this$0.onPrepareFromSearch(r100, r101);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromUri(Uri r100, Bundle r101) {
                this.this$0.onPrepareFromUri(r100, r101);
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat r100) {
        }

        public void onAddQueueItem(MediaDescriptionCompat r100, int r101) {
        }

        public void onCommand(String r100, Bundle r101, ResultReceiver r102) {
        }

        public void onCustomAction(String r100, Bundle r101) {
        }

        public void onFastForward() {
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String r100, Bundle r101) {
        }

        public void onPlayFromSearch(String r100, Bundle r101) {
        }

        public void onPlayFromUri(Uri r100, Bundle r101) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String r100, Bundle r101) {
        }

        public void onPrepareFromSearch(String r100, Bundle r101) {
        }

        public void onPrepareFromUri(Uri r100, Bundle r101) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat r100) {
        }

        public void onRemoveQueueItemAt(int r100) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long r100) {
        }

        public void onSetCaptioningEnabled(boolean r100) {
        }

        public void onSetRating(RatingCompat r100) {
        }

        public void onSetRating(RatingCompat r100, Bundle r101) {
        }

        public void onSetRepeatMode(int r100) {
        }

        public void onSetShuffleMode(int r100) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long r100) {
        }

        public void onStop() {
        }

        public Callback() {
            this.mCallbackHandler = null;
            int r100 = Build.VERSION.SDK_INT;
            if (r100 < 24) goto L6;
            this.mCallbackObj = MediaSessionCompatApi24.createCallback(new StubApi24(this));
            return;
        L6:
            if (r100 < 23) goto L8;
            this.mCallbackObj = MediaSessionCompatApi23.createCallback(new StubApi23(this));
            return;
        L8:
            this.mCallbackObj = MediaSessionCompatApi21.createCallback(new StubApi21(this));
        }

        public void handleMediaPlayPauseKeySingleTapIfPending(MediaSessionManager.RemoteUserInfo r110) {
            if (this.mMediaPlayPauseKeyPending == true) goto L5;
            return;
        L5:
            boolean r100 = false;
            this.mMediaPlayPauseKeyPending = false;
            this.mCallbackHandler.removeMessages(1);
            MediaSessionImpl r101 = this.mSessionImpl.get();
            if (r101 != null) goto L8;
            return;
        L8:
            PlaybackStateCompat r102 = r101.getPlaybackState();
            if (r102 != null) goto L11;
            long r103 = 0;
        L12:
            if (r102 != null) goto L14;
        L16:
            boolean r104 = false;
        L18:
            if ((516 & r103) == 0) goto L20;
            boolean r105 = true;
        L22:
            if ((r103 & 514) == 0) goto L24;
            r100 = true;
        L24:
            r101.setCurrentControllerInfo(r110);
            if (r104 == false) goto L28;
            if (r100 == false) goto L28;
            onPause();
        L31:
            r101.setCurrentControllerInfo(null);
            return;
        L28:
            if (r104 == true) goto L31;
            if (r105 == false) goto L31;
            onPlay();
            goto L31
        L20:
            r105 = false;
            goto L22
        L14:
            if (r102.getState() != 3) goto L16;
            r104 = true;
            goto L18
        L11:
            r103 = r102.getActions();
            goto L12
        }

        public boolean onMediaButtonEvent(Intent r100) {
            if (Build.VERSION.SDK_INT < 27) goto L5;
            return false;
        L5:
            MediaSessionImpl r101 = this.mSessionImpl.get();
            if (r101 != null) goto L8;
        L35:
            return false;
        L8:
            if (this.mCallbackHandler == null) goto L35;
            KeyEvent r102 = (KeyEvent) r100.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (r102 == null) goto L35;
            if (r102.getAction() != 0) goto L35;
            MediaSessionManager.RemoteUserInfo r103 = r101.getCurrentControllerInfo();
            int r104 = r102.getKeyCode();
            if (r104 == 79) goto L22;
            if (r104 == 85) goto L22;
            handleMediaPlayPauseKeySingleTapIfPending(r103);
            return false;
        L22:
            if (r102.getRepeatCount() <= 0) goto L25;
            handleMediaPlayPauseKeySingleTapIfPending(r103);
        L34:
            return true;
        L25:
            if (this.mMediaPlayPauseKeyPending == false) goto L33;
            this.mCallbackHandler.removeMessages(1);
            this.mMediaPlayPauseKeyPending = false;
            PlaybackStateCompat r105 = r101.getPlaybackState();
            if (r105 != null) goto L29;
            long r106 = 0;
        L31:
            if ((r106 & 32) == 0) goto L34;
            onSkipToNext();
            goto L34
        L29:
            r106 = r105.getActions();
            goto L31
        L33:
            this.mMediaPlayPauseKeyPending = true;
            CallbackHandler r107 = this.mCallbackHandler;
            r107.sendMessageDelayed(r107.obtainMessage(1, r103), ViewConfiguration.getDoubleTapTimeout());
            goto L34
        }

        public void setSessionImpl(MediaSessionImpl r100, Handler r101) {
            this.mSessionImpl = new WeakReference(r100);
            CallbackHandler r102 = this.mCallbackHandler;
            if (r102 == null) goto L5;
            r102.removeCallbacksAndMessages(null);
        L5:
            this.mCallbackHandler = new CallbackHandler(this, r101.getLooper());
        }
    }

    public interface MediaSessionImpl {
        String getCallingPackage();

        MediaSessionManager.RemoteUserInfo getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String r100, Bundle r101);

        void setActive(boolean r100);

        void setCallback(Callback r100, Handler r101);

        void setCaptioningEnabled(boolean r100);

        void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r100);

        void setExtras(Bundle r100);

        void setFlags(int r100);

        void setMediaButtonReceiver(PendingIntent r100);

        void setMetadata(MediaMetadataCompat r100);

        void setPlaybackState(PlaybackStateCompat r100);

        void setPlaybackToLocal(int r100);

        void setPlaybackToRemote(VolumeProviderCompat r100);

        void setQueue(List<QueueItem> r100);

        void setQueueTitle(CharSequence r100);

        void setRatingType(int r100);

        void setRepeatMode(int r100);

        void setSessionActivity(PendingIntent r100);

        void setShuffleMode(int r100);
    }

    public static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public int getRccTransportControlFlagsFromActions(long r100) {
            int r101 = super.getRccTransportControlFlagsFromActions(r100);
            if ((r100 & 256) != 0) goto L5;
            return r101;
        L5:
            return r101 | 256;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void setRccState(PlaybackStateCompat r110) {
            long r100 = r110.getPosition();
            float r101 = r110.getPlaybackSpeed();
            long r102 = r110.getLastPositionUpdateTime();
            long r103 = SystemClock.elapsedRealtime();
            if (r110.getState() != 3) goto L14;
            long r104 = 0;
            if (r100 <= 0) goto L14;
            if (r102 <= 0) goto L13;
            r104 = r103 - r102;
            if (r101 <= 0.0f) goto L13;
            if (r101 == 1.0f) goto L13;
            r104 = (long) (r104 * r101);
        L13:
            r100 = r100 + r104;
        L14:
            this.mRcc.setPlaybackState(getRccStateFromState(r110.getState()), r100, r101);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void registerMediaButtonEventReceiver(PendingIntent r100, ComponentName r101) {
            if (sIsMbrPendingIntentSupported == false) goto L8;
            this.mAudioManager.registerMediaButtonEventReceiver(r100);     // Catch: NullPointerException -> L6
        L6:
            sIsMbrPendingIntentSupported = false;
        L8:
            if (sIsMbrPendingIntentSupported == true) goto L13;
            super.registerMediaButtonEventReceiver(r100, r101);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r100, Handler r101) {
            super.setCallback(r100, r101);
            if (r100 != null) goto L5;
            this.mRcc.setPlaybackPositionUpdateListener(null);
            return;
        L5:
            RemoteControlClient.OnPlaybackPositionUpdateListener r102 = new AnonymousClass1(this);
            this.mRcc.setPlaybackPositionUpdateListener(r102);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void unregisterMediaButtonEventReceiver(PendingIntent r100, ComponentName r101) {
            if (sIsMbrPendingIntentSupported == false) goto L5;
            this.mAudioManager.unregisterMediaButtonEventReceiver(r100);
            return;
        L5:
            super.unregisterMediaButtonEventReceiver(r100, r101);
        }

        public MediaSessionImplApi18(Context r100, String r101, ComponentName r102, PendingIntent r103) {
            super(r100, r101, r102, r103);
        }
    }

    public static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle r100) {
            RemoteControlClient.MetadataEditor r101 = super.buildRccMetadata(r100);
            PlaybackStateCompat r102 = this.mState;
            if (r102 != null) goto L5;
            long r103 = 0;
        L7:
            if ((r103 & 128) == 0) goto L9;
            r101.addEditableKey(268435457);
        L9:
            if (r100 != null) goto L12;
            return r101;
        L12:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR) == false) goto L15;
            r101.putLong(8, r100.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
        L15:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_RATING) == false) goto L18;
            r101.putObject(101, r100.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
        L18:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING) == false) goto L20;
            r101.putObject(268435457, r100.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
        L20:
            return r101;
        L5:
            r103 = r102.getActions();
            goto L7
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public int getRccTransportControlFlagsFromActions(long r100) {
            int r101 = super.getRccTransportControlFlagsFromActions(r100);
            if ((r100 & 128) != 0) goto L5;
            return r101;
        L5:
            return r101 | 512;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r100, Handler r101) {
            super.setCallback(r100, r101);
            if (r100 != null) goto L5;
            this.mRcc.setMetadataUpdateListener(null);
            return;
        L5:
            RemoteControlClient.OnMetadataUpdateListener r102 = new AnonymousClass1(this);
            this.mRcc.setMetadataUpdateListener(r102);
        }

        public MediaSessionImplApi19(Context r100, String r101, ComponentName r102, PendingIntent r103) {
            super(r100, r101, r102, r103);
        }
    }

    public static class MediaSessionImplApi21 implements MediaSessionImpl {
        boolean mCaptioningEnabled;
        boolean mDestroyed;
        final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks;
        MediaMetadataCompat mMetadata;
        PlaybackStateCompat mPlaybackState;
        List<QueueItem> mQueue;
        int mRatingType;
        int mRepeatMode;
        final Object mSessionObj;
        int mShuffleMode;
        final Token mToken;

        public class ExtraSession extends IMediaSession.Stub {
            final /* synthetic */ MediaSessionImplApi21 this$0;

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r100) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                MediaSessionImplApi21 r100 = this.this$0;
                return MediaSessionCompat.getStateWithUpdatedPosition(r100.mPlaybackState, r100.mMetadata);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return this.this$0.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return this.this$0.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return this.this$0.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return this.this$0.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            public ExtraSession(MediaSessionImplApi21 r100) {
                this.this$0 = r100;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r100) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r100) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r100) {
                MediaSessionImplApi21 r101 = this.this$0;
                if (r101.mDestroyed == true) goto L9;
                String r102 = r101.getCallingPackage();
                if (r102 != null) goto L7;
                r102 = MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER;
            L7:
                MediaSessionManager.RemoteUserInfo r103 = new MediaSessionManager.RemoteUserInfo(r102, Binder.getCallingPid(), Binder.getCallingUid());
                this.this$0.mExtraControllerCallbacks.register(r100, r103);
                return;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r100) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r100) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r100) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r100) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r100) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r100) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r100) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r100) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r100) {
                this.this$0.mExtraControllerCallbacks.unregister(r100);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r100, int r101) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r100, Bundle r101) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r100, Bundle r101) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r100, Bundle r101) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r100, Bundle r101) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r100, Bundle r101) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r100, Bundle r101) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r100, Bundle r101) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r100, Bundle r101) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r100, int r101, String r102) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r100, Bundle r101, ResultReceiverWrapper r102) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r100, int r101, String r102) {
                throw new AssertionError();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mDestroyed = true;
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r100) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return null;
        L7:
            return MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            return this.mSessionObj;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        public MediaSessionImplApi21(Object r100) {
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object r101 = MediaSessionCompatApi21.verifySession(r100);
            this.mSessionObj = r101;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(r101), new ExtraSession(this));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean r100) {
            MediaSessionCompatApi21.setActive(this.mSessionObj, r100);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean r100) {
            if (this.mCaptioningEnabled == r100) goto L16;
            this.mCaptioningEnabled = r100;
            int r101 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r101 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r101)).onCaptioningEnabledChanged(r100);     // Catch: RemoteException -> L11
        L8:
            r101 = r101 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle r100) {
            MediaSessionCompatApi21.setExtras(this.mSessionObj, r100);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int r100) {
            MediaSessionCompatApi21.setFlags(this.mSessionObj, r100);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent r100) {
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, r100);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat r100) {
            this.mMetadata = r100;
            Object r101 = this.mSessionObj;
            if (r100 != null) goto L5;
            Object r102 = null;
        L6:
            MediaSessionCompatApi21.setMetadata(r101, r102);
            return;
        L5:
            r102 = r100.getMediaMetadata();
            goto L6
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat r100) {
            this.mPlaybackState = r100;
            int r101 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r101 < 0) goto L7;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r101)).onPlaybackStateChanged(r100);     // Catch: RemoteException -> L13
        L6:
            r101 = r101 - 1;
            goto L3
        L7:
            this.mExtraControllerCallbacks.finishBroadcast();
            Object r102 = this.mSessionObj;
            if (r100 != null) goto L10;
            Object r103 = null;
        L11:
            MediaSessionCompatApi21.setPlaybackState(r102, r103);
            return;
        L10:
            r103 = r100.getPlaybackState();
            goto L11
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int r100) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, r100);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat r100) {
            MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, r100.getVolumeProvider());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> r100) {
            this.mQueue = r100;
            if (r100 == null) goto L8;
            ArrayList r101 = new ArrayList();
            Iterator<QueueItem> r102 = r100.iterator();
        L6:
            if (r102.hasNext() == false) goto L9;
            r101.add(r102.next().getQueueItem());
        L9:
            MediaSessionCompatApi21.setQueue(this.mSessionObj, r101);
            return;
        L8:
            r101 = null;
            goto L9
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence r100) {
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, r100);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int r100) {
            if (Build.VERSION.SDK_INT >= 22) goto L5;
            this.mRatingType = r100;
            return;
        L5:
            MediaSessionCompatApi22.setRatingType(this.mSessionObj, r100);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int r100) {
            if (this.mRepeatMode == r100) goto L16;
            this.mRepeatMode = r100;
            int r101 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r101 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r101)).onRepeatModeChanged(r100);     // Catch: RemoteException -> L11
        L8:
            r101 = r101 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent r100) {
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, r100);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int r100) {
            if (this.mShuffleMode == r100) goto L16;
            this.mShuffleMode = r100;
            int r101 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r101 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r101)).onShuffleModeChanged(r100);     // Catch: RemoteException -> L11
        L8:
            r101 = r101 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String r100, Bundle r101) {
            if (Build.VERSION.SDK_INT >= 23) goto L10;
            int r102 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r102 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r102)).onEvent(r100, r101);     // Catch: RemoteException -> L12
        L8:
            r102 = r102 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
        L10:
            MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, r100, r101);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r100, Handler r101) {
            Object r102 = this.mSessionObj;
            if (r100 != null) goto L5;
            Object r103 = null;
        L6:
            MediaSessionCompatApi21.setCallback(r102, r103, r101);
            if (r100 == null) goto L10;
            r100.setSessionImpl(this, r101);
            return;
        L10:
            return;
        L5:
            r103 = r100.mCallbackObj;
            goto L6
        }

        public MediaSessionImplApi21(Context r100, String r101, Bundle r102) {
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object r103 = MediaSessionCompatApi21.createSession(r100, r101);
            this.mSessionObj = r103;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(r103), new ExtraSession(this), r102);
        }
    }

    public static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r100) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            return new MediaSessionManager.RemoteUserInfo(((MediaSession) this.mSessionObj).getCurrentControllerInfo());
        }

        public MediaSessionImplApi28(Object r100) {
            super(r100);
        }

        public MediaSessionImplApi28(Context r100, String r101, Bundle r102) {
            super(r100, r101, r102);
        }
    }

    public static class MediaSessionImplBase implements MediaSessionImpl {
        static final int RCC_PLAYSTATE_NONE = 0;
        final AudioManager mAudioManager;
        volatile Callback mCallback;
        boolean mCaptioningEnabled;
        private final Context mContext;
        final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks;
        boolean mDestroyed;
        Bundle mExtras;
        int mFlags;
        private MessageHandler mHandler;
        boolean mIsActive;
        private boolean mIsMbrRegistered;
        private boolean mIsRccRegistered;
        int mLocalStream;
        final Object mLock;
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        final String mPackageName;
        List<QueueItem> mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        final RemoteControlClient mRcc;
        private MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        int mShuffleMode;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        final String mTag;
        private final Token mToken;
        private VolumeProviderCompat.Callback mVolumeCallback;
        VolumeProviderCompat mVolumeProvider;
        int mVolumeType;

        public static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String r100, Bundle r101, ResultReceiver r102) {
                this.command = r100;
                this.extras = r101;
                this.stub = r102;
            }
        }

        public class MediaSessionStub extends IMediaSession.Stub {
            final /* synthetic */ MediaSessionImplBase this$0;

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                postToHandler(7);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                postToHandler(3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r100) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                postToHandler(16);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                Object r100 = this.this$0.mLock;
                monitor-enter(r100);
                Bundle r101 = this.this$0.mExtras;     // Catch: Throwable -> L7
                monitor-exit(r100);     // Catch: Throwable -> L7
                return r101;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                Object r100 = this.this$0.mLock;
                monitor-enter(r100);
                long r101 = this.this$0.mFlags;     // Catch: Throwable -> L7
                monitor-exit(r100);     // Catch: Throwable -> L7
                return r101;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                Object r100 = this.this$0.mLock;
                monitor-enter(r100);
                PendingIntent r101 = this.this$0.mSessionActivity;     // Catch: Throwable -> L7
                monitor-exit(r100);     // Catch: Throwable -> L7
                return r101;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                return this.this$0.mMetadata;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                return this.this$0.mPackageName;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                Object r100 = this.this$0.mLock;
                monitor-enter(r100);
                MediaSessionImplBase r101 = this.this$0;     // Catch: Throwable -> L8
                PlaybackStateCompat r102 = r101.mState;     // Catch: Throwable -> L8
                MediaMetadataCompat r103 = r101.mMetadata;     // Catch: Throwable -> L8
                monitor-exit(r100);     // Catch: Throwable -> L8
                return MediaSessionCompat.getStateWithUpdatedPosition(r102, r103);
            L8:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                Object r100 = this.this$0.mLock;
                monitor-enter(r100);
                List<QueueItem> r101 = this.this$0.mQueue;     // Catch: Throwable -> L7
                monitor-exit(r100);     // Catch: Throwable -> L7
                return r101;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                return this.this$0.mQueueTitle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return this.this$0.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return this.this$0.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return this.this$0.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                return this.this$0.mTag;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                Object r100 = this.this$0.mLock;
                monitor-enter(r100);
                MediaSessionImplBase r101 = this.this$0;     // Catch: Throwable -> L11
                int r102 = r101.mVolumeType;     // Catch: Throwable -> L11
                int r103 = r101.mLocalStream;     // Catch: Throwable -> L11
                VolumeProviderCompat r104 = r101.mVolumeProvider;     // Catch: Throwable -> L11
                int r105 = 2;
                if (r102 != 2) goto L7;
                int r106 = r104.getVolumeControl();     // Catch: Throwable -> L11
                int r107 = r104.getMaxVolume();     // Catch: Throwable -> L11
                int r108 = r104.getCurrentVolume();     // Catch: Throwable -> L11
                int r109 = r107;
                r105 = r106;
            L8:
                monitor-exit(r100);     // Catch: Throwable -> L11
                return new ParcelableVolumeInfo(r102, r103, r105, r109, r108);
            L7:
                int r110 = r101.mAudioManager.getStreamMaxVolume(r103);     // Catch: Throwable -> L11
                r109 = r110;
                r108 = this.this$0.mAudioManager.getStreamVolume(r103);     // Catch: Throwable -> L11
            L11:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return this.this$0.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                if ((this.this$0.mFlags & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                postToHandler(14);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                postToHandler(12);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                postToHandler(15);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                postToHandler(17);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                postToHandler(13);
            }

            public MediaSessionStub(MediaSessionImplBase r100) {
                this.this$0 = r100;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r100) {
                postToHandler(25, r100);
            }

            public void postToHandler(int r100) {
                this.this$0.postToHandler(r100, 0, 0, null, null);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r100) throws RemoteException {
                postToHandler(19, r100);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r100) {
                if (this.this$0.mDestroyed == true) goto L9;
                MediaSessionManager.RemoteUserInfo r101 = new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, Binder.getCallingPid(), Binder.getCallingUid());
                this.this$0.mControllerCallbacks.register(r100, r101);
                return;
            L9:
                r100.onSessionDestroyed();     // Catch: Exception -> L8
                return;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r100) {
                postToHandler(27, r100);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r100) {
                postToHandler(28, r100);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r100) throws RemoteException {
                postToHandler(18, Long.valueOf(r100));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r100) {
                boolean r101 = true;
                if ((this.this$0.mFlags & 1) != 0) goto L6;
                r101 = false;
            L6:
                if (r101 == false) goto L8;
                postToHandler(21, r100);
            L8:
                return r101;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r100) throws RemoteException {
                postToHandler(29, Boolean.valueOf(r100));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r100) throws RemoteException {
                postToHandler(23, r100);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r100) throws RemoteException {
                postToHandler(30, r100);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r100) {
                postToHandler(11, Long.valueOf(r100));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r100) {
                this.this$0.mControllerCallbacks.unregister(r100);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r100, int r101) {
                postToHandler(26, r100, r101);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r100, Bundle r101) throws RemoteException {
                postToHandler(8, r100, r101);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r100, Bundle r101) throws RemoteException {
                postToHandler(9, r100, r101);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r100, Bundle r101) throws RemoteException {
                postToHandler(10, r100, r101);
            }

            public void postToHandler(int r100, int r101) {
                this.this$0.postToHandler(r100, r101, 0, null, null);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r100, Bundle r101) throws RemoteException {
                postToHandler(4, r100, r101);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r100, Bundle r101) throws RemoteException {
                postToHandler(5, r100, r101);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r100, Bundle r101) throws RemoteException {
                postToHandler(6, r100, r101);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r100, Bundle r101) throws RemoteException {
                postToHandler(31, r100, r101);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r100, Bundle r101) throws RemoteException {
                postToHandler(20, r100, r101);
            }

            public void postToHandler(int r100, Object r101) {
                this.this$0.postToHandler(r100, 0, 0, r101, null);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r100, int r101, String r102) {
                this.this$0.adjustVolume(r100, r101);
            }

            public void postToHandler(int r100, Object r101, int r102) {
                this.this$0.postToHandler(r100, r102, 0, r101, null);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r100, Bundle r101, ResultReceiverWrapper r102) {
                postToHandler(1, new Command(r100, r101, r102.mResultReceiver));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r100, int r101, String r102) {
                this.this$0.setVolumeTo(r100, r101);
            }

            public void postToHandler(int r100, Object r101, Bundle r102) {
                this.this$0.postToHandler(r100, 0, 0, r101, r102);
            }
        }

        public class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 31;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;
            final /* synthetic */ MediaSessionImplBase this$0;

            @Override // android.os.Handler
            public void handleMessage(Message r100) {
                Callback r101 = this.this$0.mCallback;
                if (r101 != null) goto L5;
                return;
            L5:
                Bundle r102 = r100.getData();
                MediaSessionCompat.ensureClassLoader(r102);
                this.this$0.setCurrentControllerInfo(new MediaSessionManager.RemoteUserInfo(r102.getString(MediaSessionCompat.DATA_CALLING_PACKAGE), r102.getInt("data_calling_pid"), r102.getInt("data_calling_uid")));
                Bundle r103 = r102.getBundle(MediaSessionCompat.DATA_EXTRAS);
                MediaSessionCompat.ensureClassLoader(r103);
            L52:
                th = move-exception;
                this.this$0.setCurrentControllerInfo(null);
                throw th;
            L7:
                switch(r100.what) {
                    case 1: goto L49;
                    case 2: goto L48;
                    case 3: goto L47;
                    case 4: goto L46;
                    case 5: goto L45;
                    case 6: goto L44;
                    case 7: goto L43;
                    case 8: goto L42;
                    case 9: goto L41;
                    case 10: goto L40;
                    case 11: goto L39;
                    case 12: goto L38;
                    case 13: goto L37;
                    case 14: goto L36;
                    case 15: goto L35;
                    case 16: goto L34;
                    case 17: goto L33;
                    case 18: goto L32;
                    case 19: goto L31;
                    case 20: goto L30;
                    case 21: goto L27;
                    case 22: goto L26;
                    case 23: goto L25;
                    case 24: goto L50;
                    case 25: goto L24;
                    case 26: goto L23;
                    case 27: goto L22;
                    case 28: goto L12;
                    case 29: goto L11;
                    case 30: goto L10;
                    case 31: goto L9;
                    default: goto L50;
                };     // Catch: Throwable -> L52
            L9:
                r101.onSetRating((RatingCompat) r100.obj, r103);     // Catch: Throwable -> L52
                goto L50
            L10:
                r101.onSetShuffleMode(r100.arg1);     // Catch: Throwable -> L52
                goto L50
            L11:
                r101.onSetCaptioningEnabled(((Boolean) r100.obj).booleanValue());     // Catch: Throwable -> L52
                goto L50
            L12:
                List<QueueItem> r104 = this.this$0.mQueue;     // Catch: Throwable -> L52
                if (r104 == null) goto L50;
                int r105 = r100.arg1;     // Catch: Throwable -> L52
                if (r105 >= 0) goto L17;
            L19:
                QueueItem r106 = null;
            L20:
                if (r106 == null) goto L50;
                r101.onRemoveQueueItem(r106.getDescription());     // Catch: Throwable -> L52
                goto L50
            L17:
                if (r105 >= r104.size()) goto L19;
                r106 = this.this$0.mQueue.get(r100.arg1);     // Catch: Throwable -> L52
                goto L20
            L22:
                r101.onRemoveQueueItem((MediaDescriptionCompat) r100.obj);     // Catch: Throwable -> L52
                goto L50
            L23:
                r101.onAddQueueItem((MediaDescriptionCompat) r100.obj, r100.arg1);     // Catch: Throwable -> L52
                goto L50
            L24:
                r101.onAddQueueItem((MediaDescriptionCompat) r100.obj);     // Catch: Throwable -> L52
                goto L50
            L25:
                r101.onSetRepeatMode(r100.arg1);     // Catch: Throwable -> L52
                goto L50
            L26:
                this.this$0.setVolumeTo(r100.arg1, 0);     // Catch: Throwable -> L52
                goto L50
            L27:
                KeyEvent r107 = (KeyEvent) r100.obj;     // Catch: Throwable -> L52
                Intent r108 = new Intent("android.intent.action.MEDIA_BUTTON");     // Catch: Throwable -> L52
                r108.putExtra("android.intent.extra.KEY_EVENT", r107);     // Catch: Throwable -> L52
                if (r101.onMediaButtonEvent(r108) == true) goto L50;
                onMediaButtonEvent(r107, r101);     // Catch: Throwable -> L52
                goto L50
            L30:
                r101.onCustomAction((String) r100.obj, r103);     // Catch: Throwable -> L52
                goto L50
            L31:
                r101.onSetRating((RatingCompat) r100.obj);     // Catch: Throwable -> L52
                goto L50
            L32:
                r101.onSeekTo(((Long) r100.obj).longValue());     // Catch: Throwable -> L52
                goto L50
            L33:
                r101.onRewind();     // Catch: Throwable -> L52
                goto L50
            L34:
                r101.onFastForward();     // Catch: Throwable -> L52
                goto L50
            L35:
                r101.onSkipToPrevious();     // Catch: Throwable -> L52
                goto L50
            L36:
                r101.onSkipToNext();     // Catch: Throwable -> L52
                goto L50
            L37:
                r101.onStop();     // Catch: Throwable -> L52
                goto L50
            L38:
                r101.onPause();     // Catch: Throwable -> L52
                goto L50
            L39:
                r101.onSkipToQueueItem(((Long) r100.obj).longValue());     // Catch: Throwable -> L52
                goto L50
            L40:
                r101.onPlayFromUri((Uri) r100.obj, r103);     // Catch: Throwable -> L52
                goto L50
            L41:
                r101.onPlayFromSearch((String) r100.obj, r103);     // Catch: Throwable -> L52
                goto L50
            L42:
                r101.onPlayFromMediaId((String) r100.obj, r103);     // Catch: Throwable -> L52
                goto L50
            L43:
                r101.onPlay();     // Catch: Throwable -> L52
                goto L50
            L44:
                r101.onPrepareFromUri((Uri) r100.obj, r103);     // Catch: Throwable -> L52
                goto L50
            L45:
                r101.onPrepareFromSearch((String) r100.obj, r103);     // Catch: Throwable -> L52
                goto L50
            L46:
                r101.onPrepareFromMediaId((String) r100.obj, r103);     // Catch: Throwable -> L52
                goto L50
            L47:
                r101.onPrepare();     // Catch: Throwable -> L52
                goto L50
            L48:
                this.this$0.adjustVolume(r100.arg1, 0);     // Catch: Throwable -> L52
                goto L50
            L49:
                Command r109 = (Command) r100.obj;     // Catch: Throwable -> L52
                r101.onCommand(r109.command, r109.extras, r109.stub);     // Catch: Throwable -> L52
            L50:
                this.this$0.setCurrentControllerInfo(null);
            }

            public MessageHandler(MediaSessionImplBase r100, Looper r101) {
                this.this$0 = r100;
                super(r101);
            }

            private void onMediaButtonEvent(KeyEvent r100, Callback r101) {
                if (r100 != null) goto L4;
                return;
            L4:
                if (r100.getAction() != 0) goto L52;
                PlaybackStateCompat r102 = this.this$0.mState;
                if (r102 != null) goto L9;
                long r103 = 0;
            L10:
                int r104 = r100.getKeyCode();
                if (r104 == 126) goto L35;
                if (r104 == 127) goto L32;
                switch(r104) {
                    case 86: goto L29;
                    case 87: goto L26;
                    case 88: goto L23;
                    case 89: goto L20;
                    case 90: goto L17;
                    default: goto L53;
                };
            L53:
                return;
            L17:
                if ((r103 & 64) == 0) goto L39;
                r101.onFastForward();
                return;
            L39:
                return;
            L20:
                if ((r103 & 8) == 0) goto L41;
                r101.onRewind();
                return;
            L41:
                return;
            L23:
                if ((r103 & 16) == 0) goto L43;
                r101.onSkipToPrevious();
                return;
            L43:
                return;
            L26:
                if ((r103 & 32) == 0) goto L45;
                r101.onSkipToNext();
                return;
            L45:
                return;
            L29:
                if ((r103 & 1) == 0) goto L47;
                r101.onStop();
                return;
            L47:
                return;
            L32:
                if ((r103 & 2) == 0) goto L49;
                r101.onPause();
                return;
            L49:
                return;
            L35:
                if ((r103 & 4) == 0) goto L51;
                r101.onPlay();
                return;
            L51:
                return;
            L9:
                r103 = r102.getActions();
                goto L10
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            return null;
        }

        public int getRccStateFromState(int r100) {
            switch(r100) {
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L13;
                case 6: goto L11;
                case 7: goto L9;
                case 8: goto L11;
                case 9: goto L7;
                case 10: goto L5;
                case 11: goto L5;
                default: goto L3;
            };
        L3:
            return -1;
        L5:
            return 6;
        L7:
            return 7;
        L9:
            return 9;
        L11:
            return 8;
        L13:
            return 5;
        L15:
            return 4;
        L17:
            return 3;
        L19:
            return 2;
        L21:
            return 1;
        L23:
            return 0;
        }

        public int getRccTransportControlFlagsFromActions(long r100) {
            if ((1 & r100) == 0) goto L5;
            int r101 = 32;
        L7:
            if ((2 & r100) == 0) goto L10;
            r101 = r101 | 16;
        L10:
            if ((4 & r100) == 0) goto L13;
            r101 = r101 | 4;
        L13:
            if ((8 & r100) == 0) goto L16;
            r101 = r101 | 2;
        L16:
            if ((16 & r100) == 0) goto L19;
            r101 = r101 | 1;
        L19:
            if ((32 & r100) == 0) goto L22;
            r101 = r101 | 128;
        L22:
            if ((64 & r100) == 0) goto L25;
            r101 = r101 | 64;
        L25:
            if ((r100 & 512) != 0) goto L27;
            return r101;
        L27:
            return r101 | 8;
        L5:
            r101 = 0;
            goto L7
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent r100) {
        }

        private void sendSessionDestroyed() {
            int r100 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r100 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r100)).onSessionDestroyed();     // Catch: RemoteException -> L9
        L6:
            r100 = r100 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            Object r100 = this.mLock;
            monitor-enter(r100);
            MediaSessionManager.RemoteUserInfo r101 = this.mRemoteUserInfo;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            Object r100 = this.mLock;
            monitor-enter(r100);
            PlaybackStateCompat r101 = this.mState;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean update() {
            if (this.mIsActive == false) goto L23;
            boolean r100 = this.mIsMbrRegistered;
            if (r100 == false) goto L7;
        L9:
            if (r100 == true) goto L11;
        L13:
            boolean r101 = this.mIsRccRegistered;
            if (r101 == false) goto L16;
        L18:
            if (r101 == true) goto L20;
            return false;
        L20:
            if ((this.mFlags & 2) != 0) goto L31;
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = false;
            return false;
        L31:
            return false;
        L16:
            if ((this.mFlags & 2) == 0) goto L18;
            this.mAudioManager.registerRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = true;
            return true;
        L11:
            if ((this.mFlags & 1) != 0) goto L13;
            unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mIsMbrRegistered = false;
            goto L13
        L7:
            if ((this.mFlags & 1) == 0) goto L9;
            registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mIsMbrRegistered = true;
            goto L13
        L23:
            if (this.mIsMbrRegistered == false) goto L26;
            unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mIsMbrRegistered = false;
        L26:
            if (this.mIsRccRegistered == false) goto L33;
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = false;
            return false;
        L33:
            return false;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return this.mIsActive;
        }

        private void sendCaptioningEnabled(boolean r100) {
            int r101 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r101 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r101)).onCaptioningEnabledChanged(r100);     // Catch: RemoteException -> L9
        L6:
            r101 = r101 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendExtras(Bundle r100) {
            int r101 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r101 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r101)).onExtrasChanged(r100);     // Catch: RemoteException -> L9
        L6:
            r101 = r101 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat r100) {
            int r101 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r101 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r101)).onMetadataChanged(r100);     // Catch: RemoteException -> L9
        L6:
            r101 = r101 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List<QueueItem> r100) {
            int r101 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r101 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r101)).onQueueChanged(r100);     // Catch: RemoteException -> L9
        L6:
            r101 = r101 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence r100) {
            int r101 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r101 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r101)).onQueueTitleChanged(r100);     // Catch: RemoteException -> L9
        L6:
            r101 = r101 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendRepeatMode(int r100) {
            int r101 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r101 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r101)).onRepeatModeChanged(r100);     // Catch: RemoteException -> L9
        L6:
            r101 = r101 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendShuffleMode(int r100) {
            int r101 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r101 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r101)).onShuffleModeChanged(r100);     // Catch: RemoteException -> L9
        L6:
            r101 = r101 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(PlaybackStateCompat r100) {
            int r101 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r101 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r101)).onPlaybackStateChanged(r100);     // Catch: RemoteException -> L9
        L6:
            r101 = r101 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle r100) {
            RemoteControlClient.MetadataEditor r101 = this.mRcc.editMetadata(true);
            if (r100 != null) goto L6;
            return r101;
        L6:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_ART) == false) goto L12;
            Bitmap r102 = (Bitmap) r100.getParcelable(MediaMetadataCompat.METADATA_KEY_ART);
            if (r102 == null) goto L10;
            r102 = r102.copy(r102.getConfig(), false);
        L10:
            r101.putBitmap(100, r102);
        L18:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM) == false) goto L21;
            r101.putString(1, r100.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
        L21:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST) == false) goto L24;
            r101.putString(13, r100.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
        L24:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_ARTIST) == false) goto L27;
            r101.putString(2, r100.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
        L27:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_AUTHOR) == false) goto L30;
            r101.putString(3, r100.getString(MediaMetadataCompat.METADATA_KEY_AUTHOR));
        L30:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_COMPILATION) == false) goto L33;
            r101.putString(15, r100.getString(MediaMetadataCompat.METADATA_KEY_COMPILATION));
        L33:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_COMPOSER) == false) goto L36;
            r101.putString(4, r100.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER));
        L36:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_DATE) == false) goto L39;
            r101.putString(5, r100.getString(MediaMetadataCompat.METADATA_KEY_DATE));
        L39:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER) == false) goto L42;
            r101.putLong(14, r100.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
        L42:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION) == false) goto L45;
            r101.putLong(9, r100.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
        L45:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_GENRE) == false) goto L48;
            r101.putString(6, r100.getString(MediaMetadataCompat.METADATA_KEY_GENRE));
        L48:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_TITLE) == false) goto L51;
            r101.putString(7, r100.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
        L51:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER) == false) goto L54;
            r101.putLong(0, r100.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
        L54:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_WRITER) == false) goto L56;
            r101.putString(11, r100.getString(MediaMetadataCompat.METADATA_KEY_WRITER));
        L56:
            return r101;
        L12:
            if (r100.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ART) == false) goto L18;
            Bitmap r103 = (Bitmap) r100.getParcelable(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
            if (r103 == null) goto L16;
            r103 = r103.copy(r103.getConfig(), false);
        L16:
            r101.putBitmap(100, r103);
            goto L18
        }

        public void sendVolumeInfoChanged(ParcelableVolumeInfo r100) {
            int r101 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r101 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r101)).onVolumeInfoChanged(r100);     // Catch: RemoteException -> L9
        L6:
            r101 = r101 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean r100) {
            if (r100 != this.mIsActive) goto L5;
            return;
        L5:
            this.mIsActive = r100;
            if (update() == false) goto L9;
            setMetadata(this.mMetadata);
            setPlaybackState(this.mState);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean r100) {
            if (this.mCaptioningEnabled == r100) goto L6;
            this.mCaptioningEnabled = r100;
            sendCaptioningEnabled(r100);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r100) {
            Object r101 = this.mLock;
            monitor-enter(r101);
            this.mRemoteUserInfo = r100;     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle r100) {
            this.mExtras = r100;
            sendExtras(r100);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int r100) {
            Object r101 = this.mLock;
            monitor-enter(r101);
            this.mFlags = r100;     // Catch: Throwable -> L8
            monitor-exit(r101);     // Catch: Throwable -> L8
            update();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat r100) {
            if (r100 == null) goto L4;
            r100 = new MediaMetadataCompat.Builder(r100, MediaSessionCompat.sMaxBitmapSize).build();
        L4:
            Object r101 = this.mLock;
            monitor-enter(r101);
            this.mMetadata = r100;     // Catch: Throwable -> L16
            monitor-exit(r101);     // Catch: Throwable -> L16
            sendMetadata(r100);
            if (this.mIsActive == true) goto L11;
            return;
        L11:
            if (r100 != null) goto L13;
            Bundle r102 = null;
        L14:
            buildRccMetadata(r102).apply();
            return;
        L13:
            r102 = r100.getBundle();
        L16:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat r100) {
            Object r101 = this.mLock;
            monitor-enter(r101);
            this.mState = r100;     // Catch: Throwable -> L13
            monitor-exit(r101);     // Catch: Throwable -> L13
            sendState(r100);
            if (this.mIsActive == true) goto L9;
            return;
        L9:
            if (r100 != null) goto L11;
            this.mRcc.setPlaybackState(0);
            this.mRcc.setTransportControlFlags(0);
            return;
        L11:
            setRccState(r100);
            this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(r100.getActions()));
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int r100) {
            VolumeProviderCompat r101 = this.mVolumeProvider;
            if (r101 == null) goto L5;
            r101.setCallback(null);
        L5:
            this.mLocalStream = r100;
            this.mVolumeType = 1;
            int r102 = this.mVolumeType;
            int r103 = this.mLocalStream;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(r102, r103, 2, this.mAudioManager.getStreamMaxVolume(r103), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat r100) {
            if (r100 == null) goto L9;
            VolumeProviderCompat r101 = this.mVolumeProvider;
            if (r101 == null) goto L6;
            r101.setCallback(null);
        L6:
            this.mVolumeType = 2;
            this.mVolumeProvider = r100;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
            r100.setCallback(this.mVolumeCallback);
            return;
        L9:
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> r100) {
            this.mQueue = r100;
            sendQueue(r100);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence r100) {
            this.mQueueTitle = r100;
            sendQueueTitle(r100);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int r100) {
            this.mRatingType = r100;
        }

        public void setRccState(PlaybackStateCompat r100) {
            this.mRcc.setPlaybackState(getRccStateFromState(r100.getState()));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int r100) {
            if (this.mRepeatMode == r100) goto L6;
            this.mRepeatMode = r100;
            sendRepeatMode(r100);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent r100) {
            Object r101 = this.mLock;
            monitor-enter(r101);
            this.mSessionActivity = r100;     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int r100) {
            if (this.mShuffleMode == r100) goto L6;
            this.mShuffleMode = r100;
            sendShuffleMode(r100);
            return;
        }

        private void sendEvent(String r100, Bundle r101) {
            int r102 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r102 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r102)).onEvent(r100, r101);     // Catch: RemoteException -> L9
        L6:
            r102 = r102 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        public void adjustVolume(int r100, int r101) {
            if (this.mVolumeType != 2) goto L7;
            VolumeProviderCompat r102 = this.mVolumeProvider;
            if (r102 == null) goto L9;
            r102.onAdjustVolume(r100);
            return;
        L9:
            return;
        L7:
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, r100, r101);
        }

        public void registerMediaButtonEventReceiver(PendingIntent r100, ComponentName r101) {
            this.mAudioManager.registerMediaButtonEventReceiver(r101);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String r100, Bundle r101) {
            sendEvent(r100, r101);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r100, Handler r101) {
            this.mCallback = r100;
            if (r100 == null) goto L17;
            if (r101 != null) goto L6;
            r101 = new Handler();
        L6:
            Object r102 = this.mLock;
            monitor-enter(r102);
            MessageHandler r103 = this.mHandler;     // Catch: Throwable -> L14
            if (r103 == null) goto L11;
            r103.removeCallbacksAndMessages(null);     // Catch: Throwable -> L14
        L11:
            this.mHandler = new MessageHandler(this, r101.getLooper());     // Catch: Throwable -> L14
            this.mCallback.setSessionImpl(this, r101);     // Catch: Throwable -> L14
            monitor-exit(r102);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public void setVolumeTo(int r100, int r101) {
            if (this.mVolumeType != 2) goto L7;
            VolumeProviderCompat r102 = this.mVolumeProvider;
            if (r102 == null) goto L9;
            r102.onSetVolumeTo(r100);
            return;
        L9:
            return;
        L7:
            this.mAudioManager.setStreamVolume(this.mLocalStream, r100, r101);
        }

        public void unregisterMediaButtonEventReceiver(PendingIntent r100, ComponentName r101) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(r101);
        }

        public MediaSessionImplBase(Context r100, String r101, ComponentName r102, PendingIntent r103) {
            this.mLock = new Object();
            this.mControllerCallbacks = new RemoteCallbackList();
            this.mDestroyed = false;
            this.mIsActive = false;
            this.mIsMbrRegistered = false;
            this.mIsRccRegistered = false;
            this.mVolumeCallback = new AnonymousClass1(this);
            if (r102 == null) goto L7;
            this.mContext = r100;
            this.mPackageName = r100.getPackageName();
            this.mAudioManager = (AudioManager) r100.getSystemService("audio");
            this.mTag = r101;
            this.mMediaButtonReceiverComponentName = r102;
            this.mMediaButtonReceiverIntent = r103;
            MediaSessionStub r104 = new MediaSessionStub(this);
            this.mStub = r104;
            this.mToken = new Token(r104);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new RemoteControlClient(r103);
            return;
        L7:
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
        }

        public void postToHandler(int r100, int r101, int r102, Object r103, Bundle r104) {
            Object r105 = this.mLock;
            monitor-enter(r105);
            MessageHandler r106 = this.mHandler;     // Catch: Throwable -> L12
            if (r106 == null) goto L10;
            Message r107 = r106.obtainMessage(r100, r101, r102, r103);     // Catch: Throwable -> L12
            Bundle r108 = new Bundle();     // Catch: Throwable -> L12
            r108.putString(MediaSessionCompat.DATA_CALLING_PACKAGE, MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER);     // Catch: Throwable -> L12
            r108.putInt("data_calling_pid", Binder.getCallingPid());     // Catch: Throwable -> L12
            r108.putInt("data_calling_uid", Binder.getCallingUid());     // Catch: Throwable -> L12
            if (r104 == null) goto L9;
            r108.putBundle(MediaSessionCompat.DATA_EXTRAS, r104);     // Catch: Throwable -> L12
        L9:
            r107.setData(r108);     // Catch: Throwable -> L12
            r107.sendToTarget();     // Catch: Throwable -> L12
        L10:
            monitor-exit(r105);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = null;
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public Object getQueueItem() {
            Object r100 = this.mItem;
            if (r100 != null) goto L6;
            Object r101 = MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
            this.mItem = r101;
            return r101;
        L6:
            return r100;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public QueueItem(Parcel r100) {
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(r100);
            this.mId = r100.readLong();
        }

        public static QueueItem fromQueueItem(Object r100) {
            if (r100 != null) goto L4;
            return null;
        L4:
            return new QueueItem(r100, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(r100)), MediaSessionCompatApi21.QueueItem.getQueueId(r100));
        }

        public static List<QueueItem> fromQueueItemList(List<?> r100) {
            if (r100 == null) goto L8;
            ArrayList r101 = new ArrayList();
            Iterator<?> r102 = r100.iterator();
        L5:
            if (r102.hasNext() == false) goto L7;
            r101.add(fromQueueItem(r102.next()));
            goto L5
        L7:
            return r101;
        L8:
            return null;
        }

        public QueueItem(MediaDescriptionCompat r100, long r101) {
            this(null, r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            this.mDescription.writeToParcel(r100, r101);
            r100.writeLong(this.mId);
        }

        private QueueItem(Object r100, MediaDescriptionCompat r101, long r102) {
            if (r101 == null) goto L11;
            if (r102 == (-1)) goto L9;
            this.mDescription = r101;
            this.mId = r102;
            this.mItem = r100;
            return;
        L9:
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        L11:
            throw new IllegalArgumentException("Description cannot be null.");
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = null;
        ResultReceiver mResultReceiver;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public ResultReceiverWrapper(Parcel r100) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r100);
        }

        public ResultReceiverWrapper(ResultReceiver r100) {
            this.mResultReceiver = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            this.mResultReceiver.writeToParcel(r100, r101);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = null;
        private IMediaSession mExtraBinder;
        private final Object mInner;
        private Bundle mSessionToken2Bundle;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public int hashCode() {
            Object r100 = this.mInner;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public Bundle toBundle() {
            Bundle r100 = new Bundle();
            r100.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            IMediaSession r101 = this.mExtraBinder;
            if (r101 == null) goto L5;
            BundleCompat.putBinder(r100, MediaSessionCompat.KEY_EXTRA_BINDER, r101.asBinder());
        L5:
            Bundle r102 = this.mSessionToken2Bundle;
            if (r102 == null) goto L8;
            r100.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, r102);
        L8:
            return r100;
        }

        public IMediaSession getExtraBinder() {
            return this.mExtraBinder;
        }

        public Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public Object getToken() {
            return this.mInner;
        }

        public Token(Object r100) {
            this(r100, null, null);
        }

        public static Token fromBundle(Bundle r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IMediaSession r101 = IMediaSession.Stub.asInterface(BundleCompat.getBinder(r100, MediaSessionCompat.KEY_EXTRA_BINDER));
            Bundle r102 = r100.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE);
            Token r103 = (Token) r100.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (r103 != null) goto L9;
            return null;
        L9:
            return new Token(r103.mInner, r101, r102);
        }

        public static Token fromToken(Object r100) {
            return fromToken(r100, null);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Token) == true) goto L8;
            return false;
        L8:
            Token r101 = (Token) r100;
            Object r102 = this.mInner;
            if (r102 == null) goto L11;
            Object r103 = r101.mInner;
            if (r103 != null) goto L19;
            return false;
        L19:
            return r102.equals(r103);
        L11:
            if (r101.mInner == null) goto L20;
            return false;
        L20:
            return true;
        }

        public void setExtraBinder(IMediaSession r100) {
            this.mExtraBinder = r100;
        }

        public void setSessionToken2Bundle(Bundle r100) {
            this.mSessionToken2Bundle = r100;
        }

        public Token(Object r100, IMediaSession r101) {
            this(r100, r101, null);
        }

        public static Token fromToken(Object r100, IMediaSession r101) {
            if (r100 != null) goto L4;
            return null;
        L4:
            return new Token(MediaSessionCompatApi21.verifyToken(r100), r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable((Parcelable) this.mInner, r101);
        }

        public Token(Object r100, IMediaSession r101, Bundle r102) {
            this.mInner = r100;
            this.mExtraBinder = r101;
            this.mSessionToken2Bundle = r102;
        }
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public static DisplayMetrics INVOKEVIRTUAL_android_support_v4_media_session_MediaSessionCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static void ensureClassLoader(Bundle r100) {
        if (r100 == null) goto L5;
        r100.setClassLoader(MediaSessionCompat.class.getClassLoader());
        return;
    }

    public void addOnActiveChangeListener(OnActiveChangeListener r100) {
        if (r100 == null) goto L6;
        this.mActiveListeners.add(r100);
        return;
    L6:
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener r100) {
        if (r100 == null) goto L6;
        this.mActiveListeners.remove(r100);
        return;
    L6:
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void setActive(boolean r100) {
        this.mImpl.setActive(r100);
        Iterator<OnActiveChangeListener> r101 = this.mActiveListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onActiveChanged();
        goto L4
    }

    public void setCallback(Callback r100) {
        setCallback(r100, null);
    }

    public void setCaptioningEnabled(boolean r100) {
        this.mImpl.setCaptioningEnabled(r100);
    }

    public void setExtras(Bundle r100) {
        this.mImpl.setExtras(r100);
    }

    public void setFlags(int r100) {
        this.mImpl.setFlags(r100);
    }

    public void setMediaButtonReceiver(PendingIntent r100) {
        this.mImpl.setMediaButtonReceiver(r100);
    }

    public void setMetadata(MediaMetadataCompat r100) {
        this.mImpl.setMetadata(r100);
    }

    public void setPlaybackState(PlaybackStateCompat r100) {
        this.mImpl.setPlaybackState(r100);
    }

    public void setPlaybackToLocal(int r100) {
        this.mImpl.setPlaybackToLocal(r100);
    }

    public void setPlaybackToRemote(VolumeProviderCompat r100) {
        if (r100 == null) goto L6;
        this.mImpl.setPlaybackToRemote(r100);
        return;
    L6:
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void setQueue(List<QueueItem> r100) {
        this.mImpl.setQueue(r100);
    }

    public void setQueueTitle(CharSequence r100) {
        this.mImpl.setQueueTitle(r100);
    }

    public void setRatingType(int r100) {
        this.mImpl.setRatingType(r100);
    }

    public void setRepeatMode(int r100) {
        this.mImpl.setRepeatMode(r100);
    }

    public void setSessionActivity(PendingIntent r100) {
        this.mImpl.setSessionActivity(r100);
    }

    public void setShuffleMode(int r100) {
        this.mImpl.setShuffleMode(r100);
    }

    private MediaSessionCompat(Context r100, MediaSessionImpl r101) {
        this.mActiveListeners = new ArrayList();
        this.mImpl = r101;
        if (MediaSessionCompatApi21.hasCallback(r101.getMediaSession()) == true) goto L5;
        setCallback(new AnonymousClass3(this));
    L5:
        this.mController = new MediaControllerCompat(r100, this);
    }

    public static MediaSessionCompat fromMediaSession(Context r100, Object r101) {
        if (r100 == null) goto L6;
        if (r101 != null) goto L5;
        return null;
    L5:
        return new MediaSessionCompat(r100, new MediaSessionImplApi21(r101));
    L6:
        return null;
    }

    public static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat r110, MediaMetadataCompat r111) {
        if (r110 == null) goto L30;
        long r100 = -1;
        if (r110.getPosition() != (-1)) goto L7;
        return r110;
    L7:
        if (r110.getState() != 3) goto L9;
    L12:
        long r101 = r110.getLastPositionUpdateTime();
        if (r101 <= 0) goto L32;
        long r112 = SystemClock.elapsedRealtime();
        long r102 = ((long) (r110.getPlaybackSpeed() * (r112 - r101))) + r110.getPosition();
        if (r111 == null) goto L20;
        if (r111.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION) == false) goto L20;
        r100 = r111.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
    L20:
        if (r100 < 0) goto L25;
        if (r102 <= r100) goto L25;
        long r103 = r100;
    L29:
        return new PlaybackStateCompat.Builder(r110).setState(r110.getState(), r103, r110.getPlaybackSpeed(), r112).build();
    L25:
        if (r102 >= 0) goto L27;
        r103 = 0;
        goto L29
    L27:
        r103 = r102;
        goto L29
    L32:
        return r110;
    L9:
        if (r110.getState() == 4) goto L12;
        if (r110.getState() == 5) goto L12;
        return r110;
    L30:
        return r110;
    }

    public void sendSessionEvent(String r100, Bundle r101) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.mImpl.sendSessionEvent(r100, r101);
        return;
    L7:
        throw new IllegalArgumentException("event cannot be null or empty");
    }

    public void setCallback(Callback r100, Handler r101) {
        if (r100 != null) goto L4;
        this.mImpl.setCallback(null, null);
        return;
    L4:
        MediaSessionImpl r102 = this.mImpl;
        if (r101 != null) goto L8;
        r101 = new Handler();
    L8:
        r102.setCallback(r100, r101);
    }

    public MediaSessionCompat(Context r100, String r101) {
        this(r100, r101, null, null);
    }

    public MediaSessionCompat(Context r100, String r101, Bundle r102) {
        this(r100, r101, null, null, r102);
    }

    public MediaSessionCompat(Context r100, String r101, ComponentName r102, PendingIntent r110) {
        this(r100, r101, r102, r110, null);
    }

    private MediaSessionCompat(Context r100, String r101, ComponentName r102, PendingIntent r103, Bundle r104) {
        this.mActiveListeners = new ArrayList();
        if (r100 == null) goto L22;
        if (TextUtils.isEmpty(r101) == true) goto L20;
        if (r102 != null) goto L8;
        r102 = MediaButtonReceiver.getMediaButtonReceiverComponent(r100);
    L8:
        if (r102 == null) goto L12;
        if (r103 != null) goto L12;
        Intent r105 = new Intent("android.intent.action.MEDIA_BUTTON");
        r105.setComponent(r102);
        r103 = PendingIntent.getBroadcast(r100, 0, r105, 0);
    L12:
        if (Build.VERSION.SDK_INT < 28) goto L14;
        MediaSessionImplApi28 r106 = new MediaSessionImplApi28(r100, r101, r104);
        this.mImpl = r106;
        setCallback(new AnonymousClass1(this));
        r106.setMediaButtonReceiver(r103);
    L15:
        this.mController = new MediaControllerCompat(r100, this);
        if (sMaxBitmapSize != 0) goto L23;
        sMaxBitmapSize = (int) (TypedValue.applyDimension(1, 320.0f, INVOKEVIRTUAL_android_support_v4_media_session_MediaSessionCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources())) + 0.5f);
        return;
    L23:
        return;
    L14:
        MediaSessionImplApi21 r107 = new MediaSessionImplApi21(r100, r101, r104);
        this.mImpl = r107;
        setCallback(new AnonymousClass2(this));
        r107.setMediaButtonReceiver(r103);
        goto L15
    L20:
        throw new IllegalArgumentException("tag must not be null or empty");
    L22:
        throw new IllegalArgumentException(BDLocationExceptionMessage.CONTEXT_ERROR_NULL);
    }
}
