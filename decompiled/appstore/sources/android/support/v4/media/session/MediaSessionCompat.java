package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
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
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.d;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
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

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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

    /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$2, reason: invalid class name */
    public class AnonymousClass2 extends Callback {
        final /* synthetic */ MediaSessionCompat this$0;

        public AnonymousClass2(MediaSessionCompat r10) {
            this.this$0 = r10;
        }
    }

    public static abstract class Callback {
        private CallbackHandler mCallbackHandler;
        final Object mCallbackObj;
        private boolean mMediaPlayPauseKeyPending;
        WeakReference<MediaSessionImpl> mSessionImpl;

        public class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;
            final /* synthetic */ Callback this$0;

            public CallbackHandler(Callback r10, Looper r11) {
                this.this$0 = r10;
                super(r11);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r10) {
                if (r10.what != 1) goto L6;
                this.this$0.handleMediaPlayPauseKeySingleTapIfPending((MediaSessionManager$RemoteUserInfo) r10.obj);
                return;
            }
        }

        @RequiresApi(21)
        public class StubApi21 implements MediaSessionCompatApi21.Callback {
            final /* synthetic */ Callback this$0;

            public StubApi21(Callback r10) {
                this.this$0 = r10;
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCommand(String r10, Bundle r11, ResultReceiver r12) {
                QueueItem r13 = null;
                IBinder r14 = null;
                r13 = null;
                if (r10.equals(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER) == false) goto L13;
                MediaSessionImplApi21 r15 = (MediaSessionImplApi21) this.this$0.mSessionImpl.get();     // Catch: BadParcelableException -> L37
                if (r15 == null) goto L40;
                Bundle r16 = new Bundle();     // Catch: BadParcelableException -> L37
                Token r17 = r15.getSessionToken();     // Catch: BadParcelableException -> L37
                IMediaSession r18 = r17.getExtraBinder();     // Catch: BadParcelableException -> L37
                if (r18 == null) goto L10;
                r14 = r18.asBinder();     // Catch: BadParcelableException -> L37
            L10:
                d.b(r16, MediaSessionCompat.KEY_EXTRA_BINDER, r14);     // Catch: BadParcelableException -> L37
                r16.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, r17.getSessionToken2Bundle());     // Catch: BadParcelableException -> L37
                r12.send(0, r16);     // Catch: BadParcelableException -> L37
                return;
            L40:
                return;
            L13:
                if (r10.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM) == false) goto L17;
                this.this$0.onAddQueueItem((MediaDescriptionCompat) r11.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));     // Catch: BadParcelableException -> L37
                return;
            L17:
                if (r10.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT) == false) goto L20;
                this.this$0.onAddQueueItem((MediaDescriptionCompat) r11.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION), r11.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX));     // Catch: BadParcelableException -> L37
                return;
            L20:
                if (r10.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM) == false) goto L23;
                this.this$0.onRemoveQueueItem((MediaDescriptionCompat) r11.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));     // Catch: BadParcelableException -> L37
                return;
            L23:
                if (r10.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT) == false) goto L35;
                MediaSessionImplApi21 r19 = (MediaSessionImplApi21) this.this$0.mSessionImpl.get();     // Catch: BadParcelableException -> L37
                if (r19 != null) goto L27;
                return;
            L27:
                if (r19.mQueue == null) goto L46;
                int r20 = r11.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, -1);     // Catch: BadParcelableException -> L37
                if (r20 >= 0) goto L31;
            L33:
                if (r13 == null) goto L47;
                this.this$0.onRemoveQueueItem(r13.getDescription());     // Catch: BadParcelableException -> L37
                return;
            L47:
                return;
            L31:
                if (r20 >= r19.mQueue.size()) goto L33;
                r13 = r19.mQueue.get(r20);     // Catch: BadParcelableException -> L37
                goto L33
            L46:
                return;
            L35:
                this.this$0.onCommand(r10, r11, r12);     // Catch: BadParcelableException -> L37
                return;
            L37:
                Log.e(MediaSessionCompat.TAG, "Could not unparcel the extra data.");
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCustomAction(String r10, Bundle r11) {
                Bundle r12 = r11.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(r12);
                if (r10.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI) == false) goto L6;
                Uri r13 = (Uri) r11.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                this.this$0.onPlayFromUri(r13, r12);
                return;
            L6:
                if (r10.equals(MediaSessionCompat.ACTION_PREPARE) == false) goto L9;
                this.this$0.onPrepare();
                return;
            L9:
                if (r10.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID) == false) goto L12;
                String r14 = r11.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID);
                this.this$0.onPrepareFromMediaId(r14, r12);
                return;
            L12:
                if (r10.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH) == false) goto L15;
                String r15 = r11.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY);
                this.this$0.onPrepareFromSearch(r15, r12);
                return;
            L15:
                if (r10.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI) == false) goto L18;
                Uri r16 = (Uri) r11.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                this.this$0.onPrepareFromUri(r16, r12);
                return;
            L18:
                if (r10.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED) == false) goto L21;
                boolean r17 = r11.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED);
                this.this$0.onSetCaptioningEnabled(r17);
                return;
            L21:
                if (r10.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE) == false) goto L24;
                int r18 = r11.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE);
                this.this$0.onSetRepeatMode(r18);
                return;
            L24:
                if (r10.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE) == false) goto L27;
                int r19 = r11.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE);
                this.this$0.onSetShuffleMode(r19);
                return;
            L27:
                if (r10.equals(MediaSessionCompat.ACTION_SET_RATING) == false) goto L29;
                RatingCompat r20 = (RatingCompat) r11.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING);
                this.this$0.onSetRating(r20, r12);
                return;
            L29:
                this.this$0.onCustomAction(r10, r11);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onFastForward() {
                this.this$0.onFastForward();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public boolean onMediaButtonEvent(Intent r10) {
                return this.this$0.onMediaButtonEvent(r10);
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
            public void onPlayFromMediaId(String r10, Bundle r11) {
                this.this$0.onPlayFromMediaId(r10, r11);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromSearch(String r10, Bundle r11) {
                this.this$0.onPlayFromSearch(r10, r11);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onRewind() {
                this.this$0.onRewind();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSeekTo(long r10) {
                this.this$0.onSeekTo(r10);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(Object r10, Bundle r11) {
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
            public void onSkipToQueueItem(long r10) {
                this.this$0.onSkipToQueueItem(r10);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onStop() {
                this.this$0.onStop();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(Object r10) {
                this.this$0.onSetRating(RatingCompat.fromRating(r10));
            }
        }

        @RequiresApi(23)
        public class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback {
            final /* synthetic */ Callback this$0;

            public StubApi23(Callback r10) {
                this.this$0 = r10;
                super(r10);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
            public void onPlayFromUri(Uri r10, Bundle r11) {
                this.this$0.onPlayFromUri(r10, r11);
            }
        }

        @RequiresApi(24)
        public class StubApi24 extends StubApi23 implements MediaSessionCompatApi24.Callback {
            final /* synthetic */ Callback this$0;

            public StubApi24(Callback r10) {
                this.this$0 = r10;
                super(r10);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepare() {
                this.this$0.onPrepare();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromMediaId(String r10, Bundle r11) {
                this.this$0.onPrepareFromMediaId(r10, r11);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromSearch(String r10, Bundle r11) {
                this.this$0.onPrepareFromSearch(r10, r11);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromUri(Uri r10, Bundle r11) {
                this.this$0.onPrepareFromUri(r10, r11);
            }
        }

        public Callback() {
            this.mCallbackHandler = null;
            this.mCallbackObj = MediaSessionCompatApi24.createCallback(new StubApi24(this));
        }

        public void handleMediaPlayPauseKeySingleTapIfPending(MediaSessionManager$RemoteUserInfo r12) {
            if (this.mMediaPlayPauseKeyPending == true) goto L5;
            return;
        L5:
            boolean r10 = false;
            this.mMediaPlayPauseKeyPending = false;
            this.mCallbackHandler.removeMessages(1);
            MediaSessionImpl r11 = this.mSessionImpl.get();
            if (r11 != null) goto L8;
            return;
        L8:
            PlaybackStateCompat r13 = r11.getPlaybackState();
            if (r13 != null) goto L11;
            long r14 = 0;
        L12:
            if (r13 != null) goto L14;
        L16:
            boolean r15 = false;
        L18:
            if ((516 & r14) == 0) goto L20;
            boolean r16 = true;
        L22:
            if ((r14 & 514) == 0) goto L24;
            r10 = true;
        L24:
            r11.setCurrentControllerInfo(r12);
            if (r15 == false) goto L28;
            if (r10 == false) goto L28;
            onPause();
        L31:
            r11.setCurrentControllerInfo(null);
            return;
        L28:
            if (r15 == true) goto L31;
            if (r16 == false) goto L31;
            onPlay();
            goto L31
        L20:
            r16 = false;
            goto L22
        L14:
            if (r13.getState() != 3) goto L16;
            r15 = true;
            goto L18
        L11:
            r14 = r13.getActions();
            goto L12
        }

        public void onAddQueueItem(MediaDescriptionCompat r10) {
        }

        public void onCommand(String r10, Bundle r11, ResultReceiver r12) {
        }

        public void onCustomAction(String r10, Bundle r11) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent r10) {
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String r10, Bundle r11) {
        }

        public void onPlayFromSearch(String r10, Bundle r11) {
        }

        public void onPlayFromUri(Uri r10, Bundle r11) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String r10, Bundle r11) {
        }

        public void onPrepareFromSearch(String r10, Bundle r11) {
        }

        public void onPrepareFromUri(Uri r10, Bundle r11) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat r10) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int r10) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long r10) {
        }

        public void onSetCaptioningEnabled(boolean r10) {
        }

        public void onSetRating(RatingCompat r10) {
        }

        public void onSetRepeatMode(int r10) {
        }

        public void onSetShuffleMode(int r10) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long r10) {
        }

        public void onStop() {
        }

        public void setSessionImpl(MediaSessionImpl r10, Handler r11) {
            this.mSessionImpl = new WeakReference(r10);
            CallbackHandler r12 = this.mCallbackHandler;
            if (r12 == null) goto L5;
            r12.removeCallbacksAndMessages(null);
        L5:
            this.mCallbackHandler = new CallbackHandler(this, r11.getLooper());
        }

        public void onAddQueueItem(MediaDescriptionCompat r10, int r11) {
        }

        public void onSetRating(RatingCompat r10, Bundle r11) {
        }
    }

    public interface MediaSessionImpl {
        String getCallingPackage();

        MediaSessionManager$RemoteUserInfo getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String r10, Bundle r11);

        void setActive(boolean r10);

        void setCallback(Callback r10, Handler r11);

        void setCaptioningEnabled(boolean r10);

        void setCurrentControllerInfo(MediaSessionManager$RemoteUserInfo r10);

        void setExtras(Bundle r10);

        void setFlags(int r10);

        void setMediaButtonReceiver(PendingIntent r10);

        void setMetadata(MediaMetadataCompat r10);

        void setPlaybackState(PlaybackStateCompat r10);

        void setPlaybackToLocal(int r10);

        void setPlaybackToRemote(VolumeProviderCompat r10);

        void setQueue(List<QueueItem> r10);

        void setQueueTitle(CharSequence r10);

        void setRatingType(int r10);

        void setRepeatMode(int r10);

        void setSessionActivity(PendingIntent r10);

        void setShuffleMode(int r10);
    }

    @RequiresApi(18)
    public static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        static {
        }

        public MediaSessionImplApi18(Context r10, String r11, ComponentName r12, PendingIntent r13) {
            super(r10, r11, r12, r13);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public int getRccTransportControlFlagsFromActions(long r10) {
            int r11 = super.getRccTransportControlFlagsFromActions(r10);
            if ((r10 & 256) != 0) goto L5;
            return r11;
        L5:
            return r11 | 256;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void registerMediaButtonEventReceiver(PendingIntent r10, ComponentName r11) {
            if (sIsMbrPendingIntentSupported == false) goto L8;
            this.mAudioManager.registerMediaButtonEventReceiver(r10);     // Catch: NullPointerException -> L6
        L6:
            Log.w(MediaSessionCompat.TAG, "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
            sIsMbrPendingIntentSupported = false;
        L8:
            if (sIsMbrPendingIntentSupported == true) goto L13;
            super.registerMediaButtonEventReceiver(r10, r11);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r10, Handler r11) {
            super.setCallback(r10, r11);
            if (r10 != null) goto L5;
            this.mRcc.setPlaybackPositionUpdateListener(null);
            return;
        L5:
            RemoteControlClient.OnPlaybackPositionUpdateListener r12 = new AnonymousClass1(this);
            this.mRcc.setPlaybackPositionUpdateListener(r12);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void setRccState(PlaybackStateCompat r11) {
            long r10 = r11.getPosition();
            float r12 = r11.getPlaybackSpeed();
            long r13 = r11.getLastPositionUpdateTime();
            long r14 = SystemClock.elapsedRealtime();
            if (r11.getState() != 3) goto L14;
            long r15 = 0;
            if (r10 <= 0) goto L14;
            if (r13 <= 0) goto L13;
            r15 = r14 - r13;
            if (r12 <= 0.0f) goto L13;
            if (r12 == 1.0f) goto L13;
            r15 = (long) (r15 * r12);
        L13:
            r10 = r10 + r15;
        L14:
            this.mRcc.setPlaybackState(getRccStateFromState(r11.getState()), r10, r12);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void unregisterMediaButtonEventReceiver(PendingIntent r10, ComponentName r11) {
            if (sIsMbrPendingIntentSupported == false) goto L5;
            this.mAudioManager.unregisterMediaButtonEventReceiver(r10);
            return;
        L5:
            super.unregisterMediaButtonEventReceiver(r10, r11);
        }
    }

    @RequiresApi(19)
    public static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        public MediaSessionImplApi19(Context r10, String r11, ComponentName r12, PendingIntent r13) {
            super(r10, r11, r12, r13);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle r10) {
            RemoteControlClient.MetadataEditor r11 = super.buildRccMetadata(r10);
            PlaybackStateCompat r12 = this.mState;
            if (r12 != null) goto L5;
            long r13 = 0;
        L7:
            if ((r13 & 128) == 0) goto L9;
            r11.addEditableKey(268435457);
        L9:
            if (r10 != null) goto L12;
            return r11;
        L12:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR) == false) goto L15;
            r11.putLong(8, r10.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
        L15:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_RATING) == false) goto L18;
            r11.putObject(101, r10.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
        L18:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING) == false) goto L20;
            r11.putObject(268435457, r10.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
        L20:
            return r11;
        L5:
            r13 = r12.getActions();
            goto L7
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public int getRccTransportControlFlagsFromActions(long r10) {
            int r11 = super.getRccTransportControlFlagsFromActions(r10);
            if ((r10 & 128) != 0) goto L5;
            return r11;
        L5:
            return r11 | 512;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r10, Handler r11) {
            super.setCallback(r10, r11);
            if (r10 != null) goto L5;
            this.mRcc.setMetadataUpdateListener(null);
            return;
        L5:
            RemoteControlClient.OnMetadataUpdateListener r12 = new AnonymousClass1(this);
            this.mRcc.setMetadataUpdateListener(r12);
        }
    }

    @RequiresApi(21)
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

            public ExtraSession(MediaSessionImplApi21 r10) {
                this.this$0 = r10;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r10, int r11) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r10, int r11, String r12) {
                throw new AssertionError();
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
                MediaSessionImplApi21 r10 = this.this$0;
                return MediaSessionCompat.getStateWithUpdatedPosition(r10.mPlaybackState, r10.mMetadata);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                return null;
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
            public boolean isShuffleModeEnabledRemoved() {
                return false;
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
            public void playFromMediaId(String r10, Bundle r11) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r10, Bundle r11) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r10, Bundle r11) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r10, Bundle r11) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r10, Bundle r11) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r10, Bundle r11) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r10, Bundle r11) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r10) {
                MediaSessionImplApi21 r11 = this.this$0;
                if (r11.mDestroyed == true) goto L9;
                String r12 = r11.getCallingPackage();
                if (r12 != null) goto L7;
                r12 = "android.media.session.MediaController";
            L7:
                MediaSessionManager$RemoteUserInfo r13 = new MediaSessionManager$RemoteUserInfo(r12, Binder.getCallingPid(), Binder.getCallingUid());
                this.this$0.mExtraControllerCallbacks.register(r10, r13);
                return;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r10, Bundle r11, ResultReceiverWrapper r12) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r10, Bundle r11) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r10) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r10, int r11, String r12) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r10) {
                this.this$0.mExtraControllerCallbacks.unregister(r10);
            }
        }

        public MediaSessionImplApi21(Context r10, String r11, Bundle r12) {
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object r13 = MediaSessionCompatApi21.createSession(r10, r11);
            this.mSessionObj = r13;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(r13), new ExtraSession(this), r12);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            return MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
            return null;
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
        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mDestroyed = true;
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String r10, Bundle r11) {
            MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, r10, r11);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean r10) {
            MediaSessionCompatApi21.setActive(this.mSessionObj, r10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r10, Handler r11) {
            Object r12 = this.mSessionObj;
            if (r10 != null) goto L5;
            Object r13 = null;
        L6:
            MediaSessionCompatApi21.setCallback(r12, r13, r11);
            if (r10 == null) goto L10;
            r10.setSessionImpl(this, r11);
            return;
        L10:
            return;
        L5:
            r13 = r10.mCallbackObj;
            goto L6
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean r10) {
            if (this.mCaptioningEnabled == r10) goto L16;
            this.mCaptioningEnabled = r10;
            int r11 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r11 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r11)).onCaptioningEnabledChanged(r10);     // Catch: RemoteException -> L11
        L8:
            r11 = r11 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager$RemoteUserInfo r10) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle r10) {
            MediaSessionCompatApi21.setExtras(this.mSessionObj, r10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int r10) {
            MediaSessionCompatApi21.setFlags(this.mSessionObj, r10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent r10) {
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, r10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat r10) {
            this.mMetadata = r10;
            Object r11 = this.mSessionObj;
            if (r10 != null) goto L5;
            Object r12 = null;
        L6:
            MediaSessionCompatApi21.setMetadata(r11, r12);
            return;
        L5:
            r12 = r10.getMediaMetadata();
            goto L6
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat r10) {
            this.mPlaybackState = r10;
            int r11 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r11 < 0) goto L7;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r11)).onPlaybackStateChanged(r10);     // Catch: RemoteException -> L13
        L6:
            r11 = r11 - 1;
            goto L3
        L7:
            this.mExtraControllerCallbacks.finishBroadcast();
            Object r12 = this.mSessionObj;
            if (r10 != null) goto L10;
            Object r13 = null;
        L11:
            MediaSessionCompatApi21.setPlaybackState(r12, r13);
            return;
        L10:
            r13 = r10.getPlaybackState();
            goto L11
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int r10) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, r10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat r10) {
            MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, r10.d());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> r10) {
            this.mQueue = r10;
            if (r10 == null) goto L8;
            ArrayList r11 = new ArrayList();
            Iterator<QueueItem> r12 = r10.iterator();
        L6:
            if (r12.hasNext() == false) goto L9;
            r11.add(r12.next().getQueueItem());
        L9:
            MediaSessionCompatApi21.setQueue(this.mSessionObj, r11);
            return;
        L8:
            r11 = null;
            goto L9
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence r10) {
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, r10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int r10) {
            MediaSessionCompatApi22.setRatingType(this.mSessionObj, r10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int r10) {
            if (this.mRepeatMode == r10) goto L16;
            this.mRepeatMode = r10;
            int r11 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r11 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r11)).onRepeatModeChanged(r10);     // Catch: RemoteException -> L11
        L8:
            r11 = r11 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent r10) {
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, r10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int r10) {
            if (this.mShuffleMode == r10) goto L16;
            this.mShuffleMode = r10;
            int r11 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r11 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r11)).onShuffleModeChanged(r10);     // Catch: RemoteException -> L11
        L8:
            r11 = r11 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        public MediaSessionImplApi21(Object r10) {
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object r11 = MediaSessionCompatApi21.verifySession(r10);
            this.mSessionObj = r11;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(r11), new ExtraSession(this));
        }
    }

    @RequiresApi(28)
    public static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        public MediaSessionImplApi28(Context r10, String r11, Bundle r12) {
            super(r10, r11, r12);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        @NonNull
        public final MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
            return new MediaSessionManager$RemoteUserInfo(((MediaSession) this.mSessionObj).getCurrentControllerInfo());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager$RemoteUserInfo r10) {
        }

        public MediaSessionImplApi28(Object r10) {
            super(r10);
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
        private MediaSessionManager$RemoteUserInfo mRemoteUserInfo;
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

            public Command(String r10, Bundle r11, ResultReceiver r12) {
                this.command = r10;
                this.extras = r11;
                this.stub = r12;
            }
        }

        public class MediaSessionStub extends IMediaSession.Stub {
            final /* synthetic */ MediaSessionImplBase this$0;

            public MediaSessionStub(MediaSessionImplBase r10) {
                this.this$0 = r10;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r10) {
                postToHandler(25, r10);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r10, int r11) {
                postToHandler(26, r10, r11);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r10, int r11, String r12) {
                this.this$0.adjustVolume(r10, r11);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                postToHandler(16);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                Object r10 = this.this$0.mLock;
                monitor-enter(r10);
                Bundle r11 = this.this$0.mExtras;     // Catch: Throwable -> L7
                monitor-exit(r10);     // Catch: Throwable -> L7
                return r11;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                Object r10 = this.this$0.mLock;
                monitor-enter(r10);
                long r11 = this.this$0.mFlags;     // Catch: Throwable -> L7
                monitor-exit(r10);     // Catch: Throwable -> L7
                return r11;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                Object r10 = this.this$0.mLock;
                monitor-enter(r10);
                PendingIntent r11 = this.this$0.mSessionActivity;     // Catch: Throwable -> L7
                monitor-exit(r10);     // Catch: Throwable -> L7
                return r11;
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
                Object r10 = this.this$0.mLock;
                monitor-enter(r10);
                MediaSessionImplBase r11 = this.this$0;     // Catch: Throwable -> L8
                PlaybackStateCompat r12 = r11.mState;     // Catch: Throwable -> L8
                MediaMetadataCompat r13 = r11.mMetadata;     // Catch: Throwable -> L8
                monitor-exit(r10);     // Catch: Throwable -> L8
                return MediaSessionCompat.getStateWithUpdatedPosition(r12, r13);
            L8:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                Object r10 = this.this$0.mLock;
                monitor-enter(r10);
                List<QueueItem> r11 = this.this$0.mQueue;     // Catch: Throwable -> L7
                monitor-exit(r10);     // Catch: Throwable -> L7
                return r11;
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
                Object r10 = this.this$0.mLock;
                monitor-enter(r10);
                MediaSessionImplBase r11 = this.this$0;     // Catch: Throwable -> L7
                int r12 = r11.mVolumeType;     // Catch: Throwable -> L7
                int r13 = r11.mLocalStream;     // Catch: Throwable -> L7
                VolumeProviderCompat r14 = r11.mVolumeProvider;     // Catch: Throwable -> L7
                int r15 = 2;
                if (r12 != 2) goto L9;
                int r16 = r14.c();     // Catch: Throwable -> L7
                int r17 = r14.b();     // Catch: Throwable -> L7
                r15 = r16;
                int r18 = r17;
                int r19 = r14.a();     // Catch: Throwable -> L7
            L10:
                monitor-exit(r10);     // Catch: Throwable -> L7
                return new ParcelableVolumeInfo(r12, r13, r15, r18, r19);
            L9:
                int r20 = r11.mAudioManager.getStreamMaxVolume(r13);     // Catch: Throwable -> L7
                r19 = this.this$0.mAudioManager.getStreamVolume(r13);     // Catch: Throwable -> L7
                r18 = r20;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return this.this$0.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
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
            public void play() throws RemoteException {
                postToHandler(7);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r10, Bundle r11) throws RemoteException {
                postToHandler(8, r10, r11);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r10, Bundle r11) throws RemoteException {
                postToHandler(9, r10, r11);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r10, Bundle r11) throws RemoteException {
                postToHandler(10, r10, r11);
            }

            public void postToHandler(int r10) {
                this.this$0.postToHandler(r10, 0, 0, null, null);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                postToHandler(3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r10, Bundle r11) throws RemoteException {
                postToHandler(4, r10, r11);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r10, Bundle r11) throws RemoteException {
                postToHandler(5, r10, r11);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r10, Bundle r11) throws RemoteException {
                postToHandler(6, r10, r11);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                postToHandler(15);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r10) throws RemoteException {
                postToHandler(19, r10);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r10, Bundle r11) throws RemoteException {
                postToHandler(31, r10, r11);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r10) {
                if (this.this$0.mDestroyed == true) goto L9;
                MediaSessionManager$RemoteUserInfo r11 = new MediaSessionManager$RemoteUserInfo("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid());
                this.this$0.mControllerCallbacks.register(r10, r11);
                return;
            L9:
                r10.onSessionDestroyed();     // Catch: Exception -> L8
                return;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r10) {
                postToHandler(27, r10);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r10) {
                postToHandler(28, r10);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                postToHandler(17);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r10) throws RemoteException {
                postToHandler(18, Long.valueOf(r10));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r10, Bundle r11, ResultReceiverWrapper r12) {
                postToHandler(1, new Command(r10, r11, r12.mResultReceiver));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r10, Bundle r11) throws RemoteException {
                postToHandler(20, r10, r11);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r10) {
                boolean r11 = true;
                if ((this.this$0.mFlags & 1) != 0) goto L6;
                r11 = false;
            L6:
                if (r11 == false) goto L8;
                postToHandler(21, r10);
            L8:
                return r11;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r10) throws RemoteException {
                postToHandler(29, Boolean.valueOf(r10));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r10) throws RemoteException {
                postToHandler(23, r10);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r10) throws RemoteException {
                postToHandler(30, r10);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r10) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r10, int r11, String r12) {
                this.this$0.setVolumeTo(r10, r11);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r10) {
                postToHandler(11, Long.valueOf(r10));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                postToHandler(13);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r10) {
                this.this$0.mControllerCallbacks.unregister(r10);
            }

            public void postToHandler(int r10, int r11) {
                this.this$0.postToHandler(r10, r11, 0, null, null);
            }

            public void postToHandler(int r10, Object r11) {
                this.this$0.postToHandler(r10, 0, 0, r11, null);
            }

            public void postToHandler(int r10, Object r11, int r12) {
                this.this$0.postToHandler(r10, r12, 0, r11, null);
            }

            public void postToHandler(int r10, Object r11, Bundle r12) {
                this.this$0.postToHandler(r10, 0, 0, r11, r12);
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

            public MessageHandler(MediaSessionImplBase r10, Looper r11) {
                this.this$0 = r10;
                super(r11);
            }

            private void onMediaButtonEvent(KeyEvent r10, Callback r11) {
                if (r10 != null) goto L4;
                return;
            L4:
                if (r10.getAction() != 0) goto L56;
                PlaybackStateCompat r12 = this.this$0.mState;
                if (r12 != null) goto L9;
                long r13 = 0;
            L10:
                int r14 = r10.getKeyCode();
                if (r14 != 79) goto L13;
            L39:
                Log.w(MediaSessionCompat.TAG, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                return;
            L13:
                if (r14 == 126) goto L37;
                if (r14 == KEYCODE_MEDIA_PAUSE) goto L34;
                switch(r14) {
                    case 85: goto L39;
                    case 86: goto L31;
                    case 87: goto L28;
                    case 88: goto L25;
                    case 89: goto L22;
                    case 90: goto L19;
                    default: goto L57;
                };
            L57:
                return;
            L19:
                if ((64 & r13) == 0) goto L42;
                r11.onFastForward();
                return;
            L42:
                return;
            L22:
                if ((8 & r13) == 0) goto L44;
                r11.onRewind();
                return;
            L44:
                return;
            L25:
                if ((16 & r13) == 0) goto L46;
                r11.onSkipToPrevious();
                return;
            L46:
                return;
            L28:
                if ((32 & r13) == 0) goto L48;
                r11.onSkipToNext();
                return;
            L48:
                return;
            L31:
                if ((1 & r13) == 0) goto L50;
                r11.onStop();
                return;
            L50:
                return;
            L34:
                if ((2 & r13) == 0) goto L52;
                r11.onPause();
                return;
            L52:
                return;
            L37:
                if ((4 & r13) == 0) goto L54;
                r11.onPlay();
                return;
            L54:
                return;
            L9:
                r13 = r12.getActions();
                goto L10
            }

            @Override // android.os.Handler
            public void handleMessage(Message r10) {
                Callback r11 = this.this$0.mCallback;
                if (r11 != null) goto L5;
                return;
            L5:
                Bundle r12 = r10.getData();
                MediaSessionCompat.ensureClassLoader(r12);
                this.this$0.setCurrentControllerInfo(new MediaSessionManager$RemoteUserInfo(r12.getString(MediaSessionCompat.DATA_CALLING_PACKAGE), r12.getInt(MediaSessionCompat.DATA_CALLING_PID), r12.getInt(MediaSessionCompat.DATA_CALLING_UID)));
                Bundle r13 = r12.getBundle(MediaSessionCompat.DATA_EXTRAS);
                MediaSessionCompat.ensureClassLoader(r13);
            L10:
                th = move-exception;
                this.this$0.setCurrentControllerInfo(null);
                throw th;
            L7:
                switch(r10.what) {
                    case 1: goto L51;
                    case 2: goto L50;
                    case 3: goto L49;
                    case 4: goto L48;
                    case 5: goto L47;
                    case 6: goto L46;
                    case 7: goto L45;
                    case 8: goto L44;
                    case 9: goto L43;
                    case 10: goto L42;
                    case 11: goto L41;
                    case 12: goto L40;
                    case 13: goto L39;
                    case 14: goto L38;
                    case 15: goto L37;
                    case 16: goto L36;
                    case 17: goto L35;
                    case 18: goto L34;
                    case 19: goto L33;
                    case 20: goto L32;
                    case 21: goto L29;
                    case 22: goto L28;
                    case 23: goto L27;
                    case 24: goto L52;
                    case 25: goto L26;
                    case 26: goto L25;
                    case 27: goto L24;
                    case 28: goto L14;
                    case 29: goto L13;
                    case 30: goto L12;
                    case 31: goto L9;
                    default: goto L52;
                };     // Catch: Throwable -> L10
            L9:
                r11.onSetRating((RatingCompat) r10.obj, r13);     // Catch: Throwable -> L10
                goto L52
            L12:
                r11.onSetShuffleMode(r10.arg1);     // Catch: Throwable -> L10
                goto L52
            L13:
                r11.onSetCaptioningEnabled(((Boolean) r10.obj).booleanValue());     // Catch: Throwable -> L10
                goto L52
            L14:
                List<QueueItem> r14 = this.this$0.mQueue;     // Catch: Throwable -> L10
                if (r14 == null) goto L52;
                int r15 = r10.arg1;     // Catch: Throwable -> L10
                if (r15 >= 0) goto L19;
            L21:
                QueueItem r16 = null;
            L22:
                if (r16 == null) goto L52;
                r11.onRemoveQueueItem(r16.getDescription());     // Catch: Throwable -> L10
                goto L52
            L19:
                if (r15 >= r14.size()) goto L21;
                r16 = this.this$0.mQueue.get(r10.arg1);     // Catch: Throwable -> L10
                goto L22
            L24:
                r11.onRemoveQueueItem((MediaDescriptionCompat) r10.obj);     // Catch: Throwable -> L10
                goto L52
            L25:
                r11.onAddQueueItem((MediaDescriptionCompat) r10.obj, r10.arg1);     // Catch: Throwable -> L10
                goto L52
            L26:
                r11.onAddQueueItem((MediaDescriptionCompat) r10.obj);     // Catch: Throwable -> L10
                goto L52
            L27:
                r11.onSetRepeatMode(r10.arg1);     // Catch: Throwable -> L10
                goto L52
            L28:
                this.this$0.setVolumeTo(r10.arg1, 0);     // Catch: Throwable -> L10
                goto L52
            L29:
                KeyEvent r17 = (KeyEvent) r10.obj;     // Catch: Throwable -> L10
                Intent r18 = new Intent("android.intent.action.MEDIA_BUTTON");     // Catch: Throwable -> L10
                r18.putExtra("android.intent.extra.KEY_EVENT", r17);     // Catch: Throwable -> L10
                if (r11.onMediaButtonEvent(r18) == true) goto L52;
                onMediaButtonEvent(r17, r11);     // Catch: Throwable -> L10
                goto L52
            L32:
                r11.onCustomAction((String) r10.obj, r13);     // Catch: Throwable -> L10
                goto L52
            L33:
                r11.onSetRating((RatingCompat) r10.obj);     // Catch: Throwable -> L10
                goto L52
            L34:
                r11.onSeekTo(((Long) r10.obj).longValue());     // Catch: Throwable -> L10
                goto L52
            L35:
                r11.onRewind();     // Catch: Throwable -> L10
                goto L52
            L36:
                r11.onFastForward();     // Catch: Throwable -> L10
                goto L52
            L37:
                r11.onSkipToPrevious();     // Catch: Throwable -> L10
                goto L52
            L38:
                r11.onSkipToNext();     // Catch: Throwable -> L10
                goto L52
            L39:
                r11.onStop();     // Catch: Throwable -> L10
                goto L52
            L40:
                r11.onPause();     // Catch: Throwable -> L10
                goto L52
            L41:
                r11.onSkipToQueueItem(((Long) r10.obj).longValue());     // Catch: Throwable -> L10
                goto L52
            L42:
                r11.onPlayFromUri((Uri) r10.obj, r13);     // Catch: Throwable -> L10
                goto L52
            L43:
                r11.onPlayFromSearch((String) r10.obj, r13);     // Catch: Throwable -> L10
                goto L52
            L44:
                r11.onPlayFromMediaId((String) r10.obj, r13);     // Catch: Throwable -> L10
                goto L52
            L45:
                r11.onPlay();     // Catch: Throwable -> L10
                goto L52
            L46:
                r11.onPrepareFromUri((Uri) r10.obj, r13);     // Catch: Throwable -> L10
                goto L52
            L47:
                r11.onPrepareFromSearch((String) r10.obj, r13);     // Catch: Throwable -> L10
                goto L52
            L48:
                r11.onPrepareFromMediaId((String) r10.obj, r13);     // Catch: Throwable -> L10
                goto L52
            L49:
                r11.onPrepare();     // Catch: Throwable -> L10
                goto L52
            L50:
                this.this$0.adjustVolume(r10.arg1, 0);     // Catch: Throwable -> L10
                goto L52
            L51:
                Command r19 = (Command) r10.obj;     // Catch: Throwable -> L10
                r11.onCommand(r19.command, r19.extras, r19.stub);     // Catch: Throwable -> L10
            L52:
                this.this$0.setCurrentControllerInfo(null);
            }
        }

        public MediaSessionImplBase(Context r10, String r11, ComponentName r12, PendingIntent r13) {
            this.mLock = new Object();
            this.mControllerCallbacks = new RemoteCallbackList();
            this.mDestroyed = false;
            this.mIsActive = false;
            this.mIsMbrRegistered = false;
            this.mIsRccRegistered = false;
            this.mVolumeCallback = new AnonymousClass1(this);
            if (r12 == null) goto L7;
            this.mContext = r10;
            this.mPackageName = r10.getPackageName();
            this.mAudioManager = (AudioManager) r10.getSystemService("audio");
            this.mTag = r11;
            this.mMediaButtonReceiverComponentName = r12;
            this.mMediaButtonReceiverIntent = r13;
            MediaSessionStub r14 = new MediaSessionStub(this);
            this.mStub = r14;
            this.mToken = new Token(r14);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new RemoteControlClient(r13);
            return;
        L7:
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
        }

        private void sendCaptioningEnabled(boolean r10) {
            int r11 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r11 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r11)).onCaptioningEnabledChanged(r10);     // Catch: RemoteException -> L9
        L6:
            r11 = r11 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendEvent(String r10, Bundle r11) {
            int r12 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r12 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r12)).onEvent(r10, r11);     // Catch: RemoteException -> L9
        L6:
            r12 = r12 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendExtras(Bundle r10) {
            int r11 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r11 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r11)).onExtrasChanged(r10);     // Catch: RemoteException -> L9
        L6:
            r11 = r11 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat r10) {
            int r11 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r11 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r11)).onMetadataChanged(r10);     // Catch: RemoteException -> L9
        L6:
            r11 = r11 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List<QueueItem> r10) {
            int r11 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r11 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r11)).onQueueChanged(r10);     // Catch: RemoteException -> L9
        L6:
            r11 = r11 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence r10) {
            int r11 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r11 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r11)).onQueueTitleChanged(r10);     // Catch: RemoteException -> L9
        L6:
            r11 = r11 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendRepeatMode(int r10) {
            int r11 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r11 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r11)).onRepeatModeChanged(r10);     // Catch: RemoteException -> L9
        L6:
            r11 = r11 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            int r10 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r10 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r10)).onSessionDestroyed();     // Catch: RemoteException -> L9
        L6:
            r10 = r10 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        private void sendShuffleMode(int r10) {
            int r11 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r11 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r11)).onShuffleModeChanged(r10);     // Catch: RemoteException -> L9
        L6:
            r11 = r11 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(PlaybackStateCompat r10) {
            int r11 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r11 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r11)).onPlaybackStateChanged(r10);     // Catch: RemoteException -> L9
        L6:
            r11 = r11 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        public void adjustVolume(int r10, int r11) {
            if (this.mVolumeType != 2) goto L7;
            VolumeProviderCompat r12 = this.mVolumeProvider;
            if (r12 == null) goto L9;
            r12.e(r10);
            return;
        L9:
            return;
        L7:
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, r10, r11);
        }

        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle r10) {
            RemoteControlClient.MetadataEditor r11 = this.mRcc.editMetadata(true);
            if (r10 != null) goto L6;
            return r11;
        L6:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_ART) == false) goto L12;
            Bitmap r12 = (Bitmap) r10.getParcelable(MediaMetadataCompat.METADATA_KEY_ART);
            if (r12 == null) goto L10;
            r12 = r12.copy(r12.getConfig(), false);
        L10:
            r11.putBitmap(100, r12);
        L18:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM) == false) goto L21;
            r11.putString(1, r10.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
        L21:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST) == false) goto L24;
            r11.putString(13, r10.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
        L24:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_ARTIST) == false) goto L27;
            r11.putString(2, r10.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
        L27:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_AUTHOR) == false) goto L30;
            r11.putString(3, r10.getString(MediaMetadataCompat.METADATA_KEY_AUTHOR));
        L30:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_COMPILATION) == false) goto L33;
            r11.putString(15, r10.getString(MediaMetadataCompat.METADATA_KEY_COMPILATION));
        L33:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_COMPOSER) == false) goto L36;
            r11.putString(4, r10.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER));
        L36:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_DATE) == false) goto L39;
            r11.putString(5, r10.getString(MediaMetadataCompat.METADATA_KEY_DATE));
        L39:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER) == false) goto L42;
            r11.putLong(14, r10.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
        L42:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION) == false) goto L45;
            r11.putLong(9, r10.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
        L45:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_GENRE) == false) goto L48;
            r11.putString(6, r10.getString(MediaMetadataCompat.METADATA_KEY_GENRE));
        L48:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_TITLE) == false) goto L51;
            r11.putString(7, r10.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
        L51:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER) == false) goto L54;
            r11.putLong(0, r10.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
        L54:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_WRITER) == false) goto L56;
            r11.putString(11, r10.getString(MediaMetadataCompat.METADATA_KEY_WRITER));
        L56:
            return r11;
        L12:
            if (r10.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ART) == false) goto L18;
            Bitmap r13 = (Bitmap) r10.getParcelable(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
            if (r13 == null) goto L16;
            r13 = r13.copy(r13.getConfig(), false);
        L16:
            r11.putBitmap(100, r13);
            goto L18
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
            Object r10 = this.mLock;
            monitor-enter(r10);
            MediaSessionManager$RemoteUserInfo r11 = this.mRemoteUserInfo;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            Object r10 = this.mLock;
            monitor-enter(r10);
            PlaybackStateCompat r11 = this.mState;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        public int getRccStateFromState(int r10) {
            switch(r10) {
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

        public int getRccTransportControlFlagsFromActions(long r10) {
            if ((1 & r10) == 0) goto L5;
            int r11 = 32;
        L7:
            if ((2 & r10) == 0) goto L10;
            r11 = r11 | 16;
        L10:
            if ((4 & r10) == 0) goto L13;
            r11 = r11 | 4;
        L13:
            if ((8 & r10) == 0) goto L16;
            r11 = r11 | 2;
        L16:
            if ((16 & r10) == 0) goto L19;
            r11 = r11 | 1;
        L19:
            if ((32 & r10) == 0) goto L22;
            r11 = r11 | 128;
        L22:
            if ((64 & r10) == 0) goto L25;
            r11 = r11 | 64;
        L25:
            if ((r10 & 512) != 0) goto L27;
            return r11;
        L27:
            return r11 | 8;
        L5:
            r11 = 0;
            goto L7
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return this.mIsActive;
        }

        public void postToHandler(int r10, int r11, int r12, Object r13, Bundle r14) {
            Object r15 = this.mLock;
            monitor-enter(r15);
            MessageHandler r16 = this.mHandler;     // Catch: Throwable -> L9
            if (r16 == null) goto L12;
            Message r17 = r16.obtainMessage(r10, r11, r12, r13);     // Catch: Throwable -> L9
            Bundle r18 = new Bundle();     // Catch: Throwable -> L9
            r18.putString(MediaSessionCompat.DATA_CALLING_PACKAGE, "android.media.session.MediaController");     // Catch: Throwable -> L9
            r18.putInt(MediaSessionCompat.DATA_CALLING_PID, Binder.getCallingPid());     // Catch: Throwable -> L9
            r18.putInt(MediaSessionCompat.DATA_CALLING_UID, Binder.getCallingUid());     // Catch: Throwable -> L9
            if (r14 == null) goto L11;
            r18.putBundle(MediaSessionCompat.DATA_EXTRAS, r14);     // Catch: Throwable -> L9
        L11:
            r17.setData(r18);     // Catch: Throwable -> L9
            r17.sendToTarget();     // Catch: Throwable -> L9
        L12:
            monitor-exit(r15);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void registerMediaButtonEventReceiver(PendingIntent r10, ComponentName r11) {
            this.mAudioManager.registerMediaButtonEventReceiver(r11);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String r10, Bundle r11) {
            sendEvent(r10, r11);
        }

        public void sendVolumeInfoChanged(ParcelableVolumeInfo r10) {
            int r11 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r11 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r11)).onVolumeInfoChanged(r10);     // Catch: RemoteException -> L9
        L6:
            r11 = r11 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean r10) {
            if (r10 != this.mIsActive) goto L5;
            return;
        L5:
            this.mIsActive = r10;
            if (update() == false) goto L9;
            setMetadata(this.mMetadata);
            setPlaybackState(this.mState);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r10, Handler r11) {
            this.mCallback = r10;
            if (r10 == null) goto L18;
            if (r11 != null) goto L6;
            r11 = new Handler();
        L6:
            Object r12 = this.mLock;
            monitor-enter(r12);
            MessageHandler r13 = this.mHandler;     // Catch: Throwable -> L11
            if (r13 == null) goto L13;
            r13.removeCallbacksAndMessages(null);     // Catch: Throwable -> L11
        L13:
            this.mHandler = new MessageHandler(this, r11.getLooper());     // Catch: Throwable -> L11
            this.mCallback.setSessionImpl(this, r11);     // Catch: Throwable -> L11
            monitor-exit(r12);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean r10) {
            if (this.mCaptioningEnabled == r10) goto L6;
            this.mCaptioningEnabled = r10;
            sendCaptioningEnabled(r10);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager$RemoteUserInfo r10) {
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.mRemoteUserInfo = r10;     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle r10) {
            this.mExtras = r10;
            sendExtras(r10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int r10) {
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.mFlags = r10;     // Catch: Throwable -> L8
            monitor-exit(r11);     // Catch: Throwable -> L8
            update();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent r10) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat r10) {
            if (r10 == null) goto L4;
            r10 = new MediaMetadataCompat.Builder(r10, MediaSessionCompat.sMaxBitmapSize).build();
        L4:
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.mMetadata = r10;     // Catch: Throwable -> L16
            monitor-exit(r11);     // Catch: Throwable -> L16
            sendMetadata(r10);
            if (this.mIsActive == true) goto L11;
            return;
        L11:
            if (r10 != null) goto L13;
            Bundle r12 = null;
        L14:
            buildRccMetadata(r12).apply();
            return;
        L13:
            r12 = r10.getBundle();
        L16:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat r10) {
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.mState = r10;     // Catch: Throwable -> L13
            monitor-exit(r11);     // Catch: Throwable -> L13
            sendState(r10);
            if (this.mIsActive == true) goto L9;
            return;
        L9:
            if (r10 != null) goto L11;
            this.mRcc.setPlaybackState(0);
            this.mRcc.setTransportControlFlags(0);
            return;
        L11:
            setRccState(r10);
            this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(r10.getActions()));
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int r10) {
            VolumeProviderCompat r11 = this.mVolumeProvider;
            if (r11 == null) goto L5;
            r11.g(null);
        L5:
            this.mLocalStream = r10;
            this.mVolumeType = 1;
            int r12 = this.mVolumeType;
            int r13 = this.mLocalStream;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(r12, r13, 2, this.mAudioManager.getStreamMaxVolume(r13), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat r10) {
            if (r10 == null) goto L9;
            VolumeProviderCompat r11 = this.mVolumeProvider;
            if (r11 == null) goto L6;
            r11.g(null);
        L6:
            this.mVolumeType = 2;
            this.mVolumeProvider = r10;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.c(), this.mVolumeProvider.b(), this.mVolumeProvider.a()));
            r10.g(this.mVolumeCallback);
            return;
        L9:
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> r10) {
            this.mQueue = r10;
            sendQueue(r10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence r10) {
            this.mQueueTitle = r10;
            sendQueueTitle(r10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int r10) {
            this.mRatingType = r10;
        }

        public void setRccState(PlaybackStateCompat r10) {
            this.mRcc.setPlaybackState(getRccStateFromState(r10.getState()));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int r10) {
            if (this.mRepeatMode == r10) goto L6;
            this.mRepeatMode = r10;
            sendRepeatMode(r10);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent r10) {
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.mSessionActivity = r10;     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int r10) {
            if (this.mShuffleMode == r10) goto L6;
            this.mShuffleMode = r10;
            sendShuffleMode(r10);
            return;
        }

        public void setVolumeTo(int r10, int r11) {
            if (this.mVolumeType != 2) goto L7;
            VolumeProviderCompat r12 = this.mVolumeProvider;
            if (r12 == null) goto L9;
            r12.f(r10);
            return;
        L9:
            return;
        L7:
            this.mAudioManager.setStreamVolume(this.mLocalStream, r10, r11);
        }

        public void unregisterMediaButtonEventReceiver(PendingIntent r10, ComponentName r11) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(r11);
        }

        public boolean update() {
            if (this.mIsActive == false) goto L23;
            boolean r10 = this.mIsMbrRegistered;
            if (r10 == false) goto L7;
        L9:
            if (r10 == true) goto L11;
        L13:
            boolean r11 = this.mIsRccRegistered;
            if (r11 == false) goto L16;
        L18:
            if (r11 == true) goto L20;
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

        static {
            CREATOR = new AnonymousClass1();
        }

        public QueueItem(MediaDescriptionCompat r10, long r11) {
            this(null, r10, r11);
        }

        public static QueueItem fromQueueItem(Object r10) {
            if (r10 != null) goto L4;
            return null;
        L4:
            return new QueueItem(r10, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(r10)), MediaSessionCompatApi21.QueueItem.getQueueId(r10));
        }

        public static List<QueueItem> fromQueueItemList(List<?> r10) {
            if (r10 == null) goto L8;
            ArrayList r11 = new ArrayList();
            Iterator<?> r12 = r10.iterator();
        L5:
            if (r12.hasNext() == false) goto L7;
            r11.add(fromQueueItem(r12.next()));
            goto L5
        L7:
            return r11;
        L8:
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            Object r10 = this.mItem;
            if (r10 != null) goto L6;
            Object r11 = MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
            this.mItem = r11;
            return r11;
        L6:
            return r10;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            this.mDescription.writeToParcel(r10, r11);
            r10.writeLong(this.mId);
        }

        private QueueItem(Object r10, MediaDescriptionCompat r11, long r12) {
            if (r11 == null) goto L11;
            if (r12 == (-1)) goto L9;
            this.mDescription = r11;
            this.mId = r12;
            this.mItem = r10;
            return;
        L9:
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        L11:
            throw new IllegalArgumentException("Description cannot be null.");
        }

        public QueueItem(Parcel r10) {
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(r10);
            this.mId = r10.readLong();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = null;
        ResultReceiver mResultReceiver;

        static {
            CREATOR = new AnonymousClass1();
        }

        public ResultReceiverWrapper(ResultReceiver r10) {
            this.mResultReceiver = r10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            this.mResultReceiver.writeToParcel(r10, r11);
        }

        public ResultReceiverWrapper(Parcel r10) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface SessionFlags {
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = null;
        private IMediaSession mExtraBinder;
        private final Object mInner;
        private Bundle mSessionToken2Bundle;

        static {
            CREATOR = new AnonymousClass1();
        }

        public Token(Object r10) {
            this(r10, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Token fromBundle(Bundle r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            IMediaSession r11 = IMediaSession.Stub.asInterface(d.a(r10, MediaSessionCompat.KEY_EXTRA_BINDER));
            Bundle r12 = r10.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE);
            Token r13 = (Token) r10.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (r13 != null) goto L9;
            return null;
        L9:
            return new Token(r13.mInner, r11, r12);
        }

        public static Token fromToken(Object r10) {
            return fromToken(r10, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Token) == true) goto L8;
            return false;
        L8:
            Token r11 = (Token) r10;
            Object r12 = this.mInner;
            if (r12 == null) goto L11;
            Object r13 = r11.mInner;
            if (r13 != null) goto L19;
            return false;
        L19:
            return r12.equals(r13);
        L11:
            if (r11.mInner != null) goto L14;
            return true;
        L14:
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public IMediaSession getExtraBinder() {
            return this.mExtraBinder;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public Object getToken() {
            return this.mInner;
        }

        public int hashCode() {
            Object r10 = this.mInner;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.hashCode();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setExtraBinder(IMediaSession r10) {
            this.mExtraBinder = r10;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setSessionToken2Bundle(Bundle r10) {
            this.mSessionToken2Bundle = r10;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Bundle toBundle() {
            Bundle r10 = new Bundle();
            r10.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            IMediaSession r11 = this.mExtraBinder;
            if (r11 == null) goto L5;
            d.b(r10, MediaSessionCompat.KEY_EXTRA_BINDER, r11.asBinder());
        L5:
            Bundle r12 = this.mSessionToken2Bundle;
            if (r12 == null) goto L8;
            r10.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, r12);
        L8:
            return r10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeParcelable((Parcelable) this.mInner, r11);
        }

        public Token(Object r10, IMediaSession r11) {
            this(r10, r11, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Token fromToken(Object r10, IMediaSession r11) {
            if (r10 != null) goto L4;
            return null;
        L4:
            return new Token(MediaSessionCompatApi21.verifyToken(r10), r11);
        }

        public Token(Object r10, IMediaSession r11, Bundle r12) {
            this.mInner = r10;
            this.mExtraBinder = r11;
            this.mSessionToken2Bundle = r12;
        }
    }

    public MediaSessionCompat(Context r10, String r11) {
        this(r10, r11, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void ensureClassLoader(@Nullable Bundle r10) {
        if (r10 == null) goto L5;
        r10.setClassLoader(MediaSessionCompat.class.getClassLoader());
        return;
    }

    public static MediaSessionCompat fromMediaSession(Context r10, Object r11) {
        if (r10 == null) goto L6;
        if (r11 != null) goto L5;
        return null;
    L5:
        return new MediaSessionCompat(r10, new MediaSessionImplApi21(r11));
    L6:
        return null;
    }

    public static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat r14, MediaMetadataCompat r15) {
        if (r14 == null) goto L30;
        long r10 = -1;
        if (r14.getPosition() != (-1)) goto L7;
        return r14;
    L7:
        if (r14.getState() != 3) goto L9;
    L12:
        long r11 = r14.getLastPositionUpdateTime();
        if (r11 <= 0) goto L32;
        long r12 = SystemClock.elapsedRealtime();
        long r13 = ((long) (r14.getPlaybackSpeed() * (r12 - r11))) + r14.getPosition();
        if (r15 == null) goto L20;
        if (r15.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION) == false) goto L20;
        r10 = r15.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
    L20:
        if (r10 < 0) goto L25;
        if (r13 <= r10) goto L25;
        long r16 = r10;
    L29:
        return new PlaybackStateCompat.Builder(r14).setState(r14.getState(), r16, r14.getPlaybackSpeed(), r12).build();
    L25:
        if (r13 >= 0) goto L27;
        r16 = 0;
        goto L29
    L27:
        r16 = r13;
        goto L29
    L32:
        return r14;
    L9:
        if (r14.getState() == 4) goto L12;
        if (r14.getState() == 5) goto L12;
        return r14;
    L30:
        return r14;
    }

    public void addOnActiveChangeListener(OnActiveChangeListener r10) {
        if (r10 == null) goto L6;
        this.mActiveListeners.add(r10);
        return;
    L6:
        throw new IllegalArgumentException("Listener may not be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    @NonNull
    public final MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
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

    public void removeOnActiveChangeListener(OnActiveChangeListener r10) {
        if (r10 == null) goto L6;
        this.mActiveListeners.remove(r10);
        return;
    L6:
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void sendSessionEvent(String r10, Bundle r11) {
        if (TextUtils.isEmpty(r10) == true) goto L7;
        this.mImpl.sendSessionEvent(r10, r11);
        return;
    L7:
        throw new IllegalArgumentException("event cannot be null or empty");
    }

    public void setActive(boolean r10) {
        this.mImpl.setActive(r10);
        Iterator<OnActiveChangeListener> r11 = this.mActiveListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onActiveChanged();
        goto L4
    }

    public void setCallback(Callback r10) {
        setCallback(r10, null);
    }

    public void setCaptioningEnabled(boolean r10) {
        this.mImpl.setCaptioningEnabled(r10);
    }

    public void setExtras(Bundle r10) {
        this.mImpl.setExtras(r10);
    }

    public void setFlags(int r10) {
        this.mImpl.setFlags(r10);
    }

    public void setMediaButtonReceiver(PendingIntent r10) {
        this.mImpl.setMediaButtonReceiver(r10);
    }

    public void setMetadata(MediaMetadataCompat r10) {
        this.mImpl.setMetadata(r10);
    }

    public void setPlaybackState(PlaybackStateCompat r10) {
        this.mImpl.setPlaybackState(r10);
    }

    public void setPlaybackToLocal(int r10) {
        this.mImpl.setPlaybackToLocal(r10);
    }

    public void setPlaybackToRemote(VolumeProviderCompat r10) {
        if (r10 == null) goto L6;
        this.mImpl.setPlaybackToRemote(r10);
        return;
    L6:
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void setQueue(List<QueueItem> r10) {
        this.mImpl.setQueue(r10);
    }

    public void setQueueTitle(CharSequence r10) {
        this.mImpl.setQueueTitle(r10);
    }

    public void setRatingType(int r10) {
        this.mImpl.setRatingType(r10);
    }

    public void setRepeatMode(int r10) {
        this.mImpl.setRepeatMode(r10);
    }

    public void setSessionActivity(PendingIntent r10) {
        this.mImpl.setSessionActivity(r10);
    }

    public void setShuffleMode(int r10) {
        this.mImpl.setShuffleMode(r10);
    }

    public MediaSessionCompat(Context r10, String r11, ComponentName r12, PendingIntent r13) {
        this(r10, r11, r12, r13, null);
    }

    public void setCallback(Callback r10, Handler r11) {
        if (r10 != null) goto L4;
        this.mImpl.setCallback(null, null);
        return;
    L4:
        MediaSessionImpl r12 = this.mImpl;
        if (r11 != null) goto L8;
        r11 = new Handler();
    L8:
        r12.setCallback(r10, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MediaSessionCompat(Context r10, String r11, Bundle r12) {
        this(r10, r11, null, null, r12);
    }

    private MediaSessionCompat(Context r10, String r11, ComponentName r12, PendingIntent r13, Bundle r14) {
        this.mActiveListeners = new ArrayList();
        if (r10 == null) goto L20;
        if (TextUtils.isEmpty(r11) == true) goto L18;
        if (r12 != null) goto L10;
        r12 = MediaButtonReceiver.a(r10);
        if (r12 != null) goto L10;
        Log.w(TAG, "Couldn't find a unique registered media button receiver in the given context.");
    L10:
        if (r12 == null) goto L13;
        if (r13 != null) goto L13;
        Intent r15 = new Intent("android.intent.action.MEDIA_BUTTON");
        r15.setComponent(r12);
        r13 = PendingIntent.getBroadcast(r10, 0, r15, 0);
    L13:
        MediaSessionImplApi28 r16 = new MediaSessionImplApi28(r10, r11, r14);
        this.mImpl = r16;
        setCallback(new AnonymousClass1(this));
        r16.setMediaButtonReceiver(r13);
        this.mController = new MediaControllerCompat(r10, this);
        if (sMaxBitmapSize != 0) goto L21;
        sMaxBitmapSize = (int) (TypedValue.applyDimension(1, 320.0f, r10.getResources().getDisplayMetrics()) + 0.5f);
        return;
    L21:
        return;
    L18:
        throw new IllegalArgumentException("tag must not be null or empty");
    L20:
        throw new IllegalArgumentException("context must not be null");
    }

    private MediaSessionCompat(Context r10, MediaSessionImpl r11) {
        this.mActiveListeners = new ArrayList();
        this.mImpl = r11;
        if (MediaSessionCompatApi21.hasCallback(r11.getMediaSession()) == true) goto L5;
        setCallback(new AnonymousClass3(this));
    L5:
        this.mController = new MediaControllerCompat(r10, this);
    }
}
