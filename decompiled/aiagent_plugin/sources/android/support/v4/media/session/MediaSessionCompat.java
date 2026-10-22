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
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.media.f;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f76a;

    /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$1, reason: invalid class name */
    class AnonymousClass1 extends Callback {
        final /* synthetic */ MediaSessionCompat this$0;

        AnonymousClass1(MediaSessionCompat r1) {
            this.this$0 = r1;
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$2, reason: invalid class name */
    class AnonymousClass2 extends Callback {
        final /* synthetic */ MediaSessionCompat this$0;

        AnonymousClass2(MediaSessionCompat r1) {
            this.this$0 = r1;
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$3, reason: invalid class name */
    class AnonymousClass3 extends Callback {
        final /* synthetic */ MediaSessionCompat this$0;

        AnonymousClass3(MediaSessionCompat r1) {
            this.this$0 = r1;
        }
    }

    public static abstract class Callback {
        private CallbackHandler mCallbackHandler;
        final Object mCallbackObj;
        private boolean mMediaPlayPauseKeyPending;
        WeakReference<a> mSessionImpl;

        private class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;
            final /* synthetic */ Callback this$0;

            CallbackHandler(Callback r1, Looper r2) {
                this.this$0 = r1;
                super(r2);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r3) {
                if (r3.what != 1) goto L6;
                this.this$0.handleMediaPlayPauseKeySingleTapIfPending((androidx.media.b.C0067b) ZeusTransformUtils.preCheckCast(r3.obj, androidx.media.b.C0067b.class, "com.obric.aiagent.plugin"));
                return;
            }
        }

        private class StubApi21 implements MediaSessionCompatApi21.a {
            final /* synthetic */ Callback this$0;

            public static /* synthetic */ int access$000(String r0, String r1) {
                return Log.e(r0, r1);
            }

            public void onSetRating(Object r1, Bundle r2) {
            }

            StubApi21(Callback r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onCommand(String r6, Bundle r7, ResultReceiver r8) {
            L38:
                INVOKESTATIC_android_support_v4_media_session_MediaSessionCompat$Callback$StubApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaSessionCompat", "Could not unparcel the extra data.");
                return;
            L3:
                QueueItem r1 = null;
                IBinder r2 = null;
                r1 = null;
                if (r6.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER") == false) goto L14;
                MediaSessionImplApi21 r5 = (MediaSessionImplApi21) ZeusTransformUtils.preCheckCast(this.this$0.mSessionImpl.get(), MediaSessionImplApi21.class, "com.obric.aiagent.plugin");     // Catch: BadParcelableException -> L38
                if (r5 == null) goto L41;
                Bundle r9 = new Bundle();     // Catch: BadParcelableException -> L38
                Token r10 = r5.getSessionToken();     // Catch: BadParcelableException -> L38
                IMediaSession r11 = r10.getExtraBinder();     // Catch: BadParcelableException -> L38
                if (r11 == null) goto L11;
                r2 = r11.asBinder();     // Catch: BadParcelableException -> L38
            L11:
                androidx.core.app.d.a(r9, "android.support.v4.media.session.EXTRA_BINDER", r2);     // Catch: BadParcelableException -> L38
                r9.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", r10.getSessionToken2Bundle());     // Catch: BadParcelableException -> L38
                r8.send(0, r9);     // Catch: BadParcelableException -> L38
                return;
            L41:
                return;
            L14:
                if (r6.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM") == false) goto L18;
                this.this$0.onAddQueueItem((MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(r7.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), MediaDescriptionCompat.class, "com.obric.aiagent.plugin"));     // Catch: BadParcelableException -> L38
                return;
            L18:
                if (r6.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT") == false) goto L21;
                this.this$0.onAddQueueItem((MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(r7.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), MediaDescriptionCompat.class, "com.obric.aiagent.plugin"), r7.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));     // Catch: BadParcelableException -> L38
                return;
            L21:
                if (r6.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM") == false) goto L24;
                this.this$0.onRemoveQueueItem((MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(r7.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), MediaDescriptionCompat.class, "com.obric.aiagent.plugin"));     // Catch: BadParcelableException -> L38
                return;
            L24:
                if (r6.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT") == false) goto L36;
                MediaSessionImplApi21 r12 = (MediaSessionImplApi21) ZeusTransformUtils.preCheckCast(this.this$0.mSessionImpl.get(), MediaSessionImplApi21.class, "com.obric.aiagent.plugin");     // Catch: BadParcelableException -> L38
                if (r12 != null) goto L28;
                return;
            L28:
                if (r12.mQueue == null) goto L47;
                int r13 = r7.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);     // Catch: BadParcelableException -> L38
                if (r13 >= 0) goto L32;
            L34:
                if (r1 == null) goto L48;
                this.this$0.onRemoveQueueItem(r1.getDescription());     // Catch: BadParcelableException -> L38
                return;
            L48:
                return;
            L32:
                if (r13 >= r12.mQueue.size()) goto L34;
                r1 = (QueueItem) ZeusTransformUtils.preCheckCast(r12.mQueue.get(r13), QueueItem.class, "com.obric.aiagent.plugin");     // Catch: BadParcelableException -> L38
                goto L34
            L47:
                return;
            L36:
                this.this$0.onCommand(r6, r7, r8);     // Catch: BadParcelableException -> L38
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public boolean onMediaButtonEvent(Intent r1) {
                return this.this$0.onMediaButtonEvent(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onPlay() {
                this.this$0.onPlay();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onPlayFromMediaId(String r1, Bundle r2) {
                this.this$0.onPlayFromMediaId(r1, r2);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onPlayFromSearch(String r1, Bundle r2) {
                this.this$0.onPlayFromSearch(r1, r2);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onSkipToQueueItem(long r1) {
                this.this$0.onSkipToQueueItem(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onPause() {
                this.this$0.onPause();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onSkipToNext() {
                this.this$0.onSkipToNext();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onSkipToPrevious() {
                this.this$0.onSkipToPrevious();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onFastForward() {
                this.this$0.onFastForward();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onRewind() {
                this.this$0.onRewind();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onStop() {
                this.this$0.onStop();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onSeekTo(long r1) {
                this.this$0.onSeekTo(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onSetRating(Object r1) {
                this.this$0.onSetRating(RatingCompat.fromRating(r1));
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.a
            public void onCustomAction(String r5, Bundle r6) {
                Bundle r0 = r6.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                MediaSessionCompat.a(r0);
                if (r5.equals("android.support.v4.media.session.action.PLAY_FROM_URI") == false) goto L6;
                Uri r7 = (Uri) ZeusTransformUtils.preCheckCast(r6.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), Uri.class, "com.obric.aiagent.plugin");
                this.this$0.onPlayFromUri(r7, r0);
                return;
            L6:
                if (r5.equals("android.support.v4.media.session.action.PREPARE") == false) goto L9;
                this.this$0.onPrepare();
                return;
            L9:
                if (r5.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID") == false) goto L12;
                String r8 = r6.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                this.this$0.onPrepareFromMediaId(r8, r0);
                return;
            L12:
                if (r5.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH") == false) goto L15;
                String r9 = r6.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                this.this$0.onPrepareFromSearch(r9, r0);
                return;
            L15:
                if (r5.equals("android.support.v4.media.session.action.PREPARE_FROM_URI") == false) goto L18;
                Uri r10 = (Uri) ZeusTransformUtils.preCheckCast(r6.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), Uri.class, "com.obric.aiagent.plugin");
                this.this$0.onPrepareFromUri(r10, r0);
                return;
            L18:
                if (r5.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED") == false) goto L21;
                boolean r11 = r6.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
                this.this$0.onSetCaptioningEnabled(r11);
                return;
            L21:
                if (r5.equals("android.support.v4.media.session.action.SET_REPEAT_MODE") == false) goto L24;
                int r12 = r6.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE");
                this.this$0.onSetRepeatMode(r12);
                return;
            L24:
                if (r5.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE") == false) goto L27;
                int r13 = r6.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE");
                this.this$0.onSetShuffleMode(r13);
                return;
            L27:
                if (r5.equals("android.support.v4.media.session.action.SET_RATING") == false) goto L29;
                RatingCompat r14 = (RatingCompat) ZeusTransformUtils.preCheckCast(r6.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"), RatingCompat.class, "com.obric.aiagent.plugin");
                this.this$0.onSetRating(r14, r0);
                return;
            L29:
                this.this$0.onCustomAction(r5, r6);
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int INVOKESTATIC_android_support_v4_media_session_MediaSessionCompat$Callback$StubApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
                return Log.e(r0, r1);
            }
        }

        private class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback {
            final /* synthetic */ Callback this$0;

            StubApi23(Callback r1) {
                this.this$0 = r1;
                super(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
            public void onPlayFromUri(Uri r1, Bundle r2) {
                this.this$0.onPlayFromUri(r1, r2);
            }
        }

        private class StubApi24 extends StubApi23 implements MediaSessionCompatApi24.Callback {
            final /* synthetic */ Callback this$0;

            StubApi24(Callback r1) {
                this.this$0 = r1;
                super(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepare() {
                this.this$0.onPrepare();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromMediaId(String r1, Bundle r2) {
                this.this$0.onPrepareFromMediaId(r1, r2);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromSearch(String r1, Bundle r2) {
                this.this$0.onPrepareFromSearch(r1, r2);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromUri(Uri r1, Bundle r2) {
                this.this$0.onPrepareFromUri(r1, r2);
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat r1) {
        }

        public void onAddQueueItem(MediaDescriptionCompat r1, int r2) {
        }

        public void onCommand(String r1, Bundle r2, ResultReceiver r3) {
        }

        public void onCustomAction(String r1, Bundle r2) {
        }

        public void onFastForward() {
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String r1, Bundle r2) {
        }

        public void onPlayFromSearch(String r1, Bundle r2) {
        }

        public void onPlayFromUri(Uri r1, Bundle r2) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String r1, Bundle r2) {
        }

        public void onPrepareFromSearch(String r1, Bundle r2) {
        }

        public void onPrepareFromUri(Uri r1, Bundle r2) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat r1) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int r1) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long r1) {
        }

        public void onSetCaptioningEnabled(boolean r1) {
        }

        public void onSetRating(RatingCompat r1) {
        }

        public void onSetRating(RatingCompat r1, Bundle r2) {
        }

        public void onSetRepeatMode(int r1) {
        }

        public void onSetShuffleMode(int r1) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long r1) {
        }

        public void onStop() {
        }

        public Callback() {
            this.mCallbackHandler = null;
            if (Build.VERSION.SDK_INT < 24) goto L6;
            this.mCallbackObj = MediaSessionCompatApi24.a(new StubApi24(this));
            return;
        L6:
            if (Build.VERSION.SDK_INT < 23) goto L9;
            this.mCallbackObj = MediaSessionCompatApi23.a(new StubApi23(this));
            return;
        L9:
            if (Build.VERSION.SDK_INT < 21) goto L11;
            this.mCallbackObj = MediaSessionCompatApi21.a(new StubApi21(this));
            return;
        L11:
            this.mCallbackObj = null;
        }

        void setSessionImpl(a r3, Handler r4) {
            this.mSessionImpl = new WeakReference((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin"));
            CallbackHandler r5 = this.mCallbackHandler;
            if (r5 == null) goto L5;
            r5.removeCallbacksAndMessages(null);
        L5:
            this.mCallbackHandler = new CallbackHandler(this, r4.getLooper());
        }

        public boolean onMediaButtonEvent(Intent r9) {
            if (Build.VERSION.SDK_INT < 27) goto L5;
            return false;
        L5:
            a r0 = (a) ZeusTransformUtils.preCheckCast(this.mSessionImpl.get(), a.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L8;
        L35:
            return false;
        L8:
            if (this.mCallbackHandler == null) goto L35;
            KeyEvent r10 = (KeyEvent) ZeusTransformUtils.preCheckCast(r9.getParcelableExtra("android.intent.extra.KEY_EVENT"), KeyEvent.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L35;
            if (r10.getAction() != 0) goto L35;
            androidx.media.b.C0067b r2 = r0.getCurrentControllerInfo();
            int r3 = r10.getKeyCode();
            if (r3 == 79) goto L22;
            if (r3 == 85) goto L22;
            handleMediaPlayPauseKeySingleTapIfPending(r2);
            return false;
        L22:
            if (r10.getRepeatCount() <= 0) goto L25;
            handleMediaPlayPauseKeySingleTapIfPending(r2);
        L34:
            return true;
        L25:
            if (this.mMediaPlayPauseKeyPending == false) goto L33;
            this.mCallbackHandler.removeMessages(1);
            this.mMediaPlayPauseKeyPending = false;
            PlaybackStateCompat r11 = r0.getPlaybackState();
            if (r11 != null) goto L29;
            long r4 = 0;
        L31:
            if ((r4 & 32) == 0) goto L34;
            onSkipToNext();
            goto L34
        L29:
            r4 = r11.getActions();
            goto L31
        L33:
            this.mMediaPlayPauseKeyPending = true;
            CallbackHandler r8 = this.mCallbackHandler;
            r8.sendMessageDelayed(r8.obtainMessage(1, r2), ViewConfiguration.getDoubleTapTimeout());
            goto L34
        }

        void handleMediaPlayPauseKeySingleTapIfPending(androidx.media.b.C0067b r12) {
            if (this.mMediaPlayPauseKeyPending == true) goto L5;
            return;
        L5:
            boolean r0 = false;
            this.mMediaPlayPauseKeyPending = false;
            this.mCallbackHandler.removeMessages(1);
            a r1 = (a) ZeusTransformUtils.preCheckCast(this.mSessionImpl.get(), a.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L8;
            return;
        L8:
            PlaybackStateCompat r3 = r1.getPlaybackState();
            if (r3 != null) goto L11;
            long r6 = 0;
        L12:
            if (r3 != null) goto L14;
        L16:
            boolean r4 = false;
        L18:
            if ((516 & r6) == 0) goto L20;
            boolean r8 = true;
        L22:
            if ((r6 & 514) == 0) goto L24;
            r0 = true;
        L24:
            r1.setCurrentControllerInfo(r12);
            if (r4 == false) goto L28;
            if (r0 == false) goto L28;
            onPause();
        L31:
            r1.setCurrentControllerInfo(null);
            return;
        L28:
            if (r4 == true) goto L31;
            if (r8 == false) goto L31;
            onPlay();
            goto L31
        L20:
            r8 = false;
            goto L22
        L14:
            if (r3.getState() != 3) goto L16;
            r4 = true;
            goto L18
        L11:
            r6 = r3.getActions();
            goto L12
        }
    }

    static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        static {
        }

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.w(r0, r1);
        }

        MediaSessionImplApi18(Context r3, String r4, ComponentName r5, PendingIntent r6) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5, r6);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void setCallback(Callback r1, Handler r2) {
            super.setCallback(r1, r2);
            if (r1 != null) goto L5;
            this.mRcc.setPlaybackPositionUpdateListener(null);
            return;
        L5:
            RemoteControlClient.OnPlaybackPositionUpdateListener r3 = new AnonymousClass1(this);
            this.mRcc.setPlaybackPositionUpdateListener(r3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void setRccState(PlaybackStateCompat r11) {
            long r0 = r11.getPosition();
            float r2 = r11.getPlaybackSpeed();
            long r3 = r11.getLastPositionUpdateTime();
            long r5 = SystemClock.elapsedRealtime();
            if (r11.getState() != 3) goto L14;
            long r7 = 0;
            if (r0 <= 0) goto L14;
            if (r3 <= 0) goto L13;
            r7 = r5 - r3;
            if (r2 <= 0.0f) goto L13;
            if (r2 == 1.0f) goto L13;
            r7 = (long) (r7 * r2);
        L13:
            r0 = r0 + r7;
        L14:
            this.mRcc.setPlaybackState(getRccStateFromState(r11.getState()), r0, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        int getRccTransportControlFlagsFromActions(long r3) {
            int r2 = super.getRccTransportControlFlagsFromActions(r3);
            if ((r3 & 256) != 0) goto L5;
            return r2;
        L5:
            return r2 | 256;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void registerMediaButtonEventReceiver(PendingIntent r3, ComponentName r4) {
            if (sIsMbrPendingIntentSupported == false) goto L8;
            this.mAudioManager.registerMediaButtonEventReceiver(r3);     // Catch: NullPointerException -> L6
        L6:
            INVOKESTATIC_android_support_v4_media_session_MediaSessionCompat$MediaSessionImplApi18_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("MediaSessionCompat", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
            sIsMbrPendingIntentSupported = false;
        L8:
            if (sIsMbrPendingIntentSupported == true) goto L13;
            super.registerMediaButtonEventReceiver(r3, r4);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void unregisterMediaButtonEventReceiver(PendingIntent r2, ComponentName r3) {
            if (sIsMbrPendingIntentSupported == false) goto L5;
            this.mAudioManager.unregisterMediaButtonEventReceiver(r2);
            return;
        L5:
            super.unregisterMediaButtonEventReceiver(r2, r3);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_session_MediaSessionCompat$MediaSessionImplApi18_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        MediaSessionImplApi19(Context r3, String r4, ComponentName r5, PendingIntent r6) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5, r6);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void setCallback(Callback r1, Handler r2) {
            super.setCallback(r1, r2);
            if (r1 != null) goto L5;
            this.mRcc.setMetadataUpdateListener(null);
            return;
        L5:
            RemoteControlClient.OnMetadataUpdateListener r3 = new AnonymousClass1(this);
            this.mRcc.setMetadataUpdateListener(r3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        int getRccTransportControlFlagsFromActions(long r3) {
            int r2 = super.getRccTransportControlFlagsFromActions(r3);
            if ((r3 & 128) != 0) goto L5;
            return r2;
        L5:
            return r2 | 512;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        RemoteControlClient.MetadataEditor buildRccMetadata(Bundle r9) {
            RemoteControlClient.MetadataEditor r0 = super.buildRccMetadata(r9);
            if (this.mState != null) goto L5;
            long r4 = 0;
        L7:
            if ((r4 & 128) == 0) goto L9;
            r0.addEditableKey(268435457);
        L9:
            if (r9 != null) goto L12;
            return r0;
        L12:
            if (r9.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR) == false) goto L15;
            r0.putLong(8, r9.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
        L15:
            if (r9.containsKey(MediaMetadataCompat.METADATA_KEY_RATING) == false) goto L18;
            r0.putObject(101, r9.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
        L18:
            if (r9.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING) == false) goto L20;
            r0.putObject(268435457, r9.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
        L20:
            return r0;
        L5:
            r4 = this.mState.getActions();
            goto L7
        }
    }

    static class MediaSessionImplApi21 implements a {
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

        class ExtraSession extends IMediaSession.Stub {
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
            public void setShuffleModeEnabledRemoved(boolean r1) {
            }

            ExtraSession(MediaSessionImplApi21 r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r1, Bundle r2, ResultReceiverWrapper r3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r5) {
                IMediaControllerCallback r6 = (IMediaControllerCallback) ZeusTransformUtils.wrapperContextForParams(r5, IMediaControllerCallback.class, "com.obric.aiagent.plugin");
                if (this.this$0.mDestroyed == true) goto L9;
                String r0 = this.this$0.getCallingPackage();
                if (r0 != null) goto L7;
                r0 = "android.media.session.MediaController";
            L7:
                androidx.media.b.C0067b r1 = new androidx.media.b.C0067b(r0, getCallingPid(), getCallingUid());
                this.this$0.mExtraControllerCallbacks.register(r6, r1);
                return;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r3) {
                IMediaControllerCallback r4 = (IMediaControllerCallback) ZeusTransformUtils.wrapperContextForParams(r3, IMediaControllerCallback.class, "com.obric.aiagent.plugin");
                this.this$0.mExtraControllerCallbacks.unregister(r4);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r1, int r2, String r3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r1, int r2, String r3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r1, Bundle r2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r1, Bundle r2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r1, Bundle r2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r1, Bundle r2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r1, Bundle r2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r1, Bundle r2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r1, Bundle r2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r1, Bundle r2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                return MediaSessionCompat.a(this.this$0.mPlaybackState, this.this$0.mMetadata);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r1, int r2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return this.this$0.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return this.this$0.mCaptioningEnabled;
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
            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public androidx.media.b.C0067b getCurrentControllerInfo() {
            return null;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setCurrentControllerInfo(androidx.media.b.C0067b r1) {
        }

        MediaSessionImplApi21(Context r3, String r4, Bundle r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object r7 = MediaSessionCompatApi21.a(r6, r4);
            this.mSessionObj = r7;
            this.mToken = new Token(MediaSessionCompatApi21.e(r7), new ExtraSession(this), r5);
        }

        MediaSessionImplApi21(Object r3) {
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object r4 = MediaSessionCompatApi21.a(r3);
            this.mSessionObj = r4;
            this.mToken = new Token(MediaSessionCompatApi21.e(r4), new ExtraSession(this));
        }

        public void setCallback(Callback r3, Handler r4) {
            Object r0 = this.mSessionObj;
            if (r3 != null) goto L5;
            Object r1 = null;
        L6:
            MediaSessionCompatApi21.a(r0, r1, r4);
            if (r3 == null) goto L10;
            r3.setSessionImpl(this, r4);
            return;
        L10:
            return;
        L5:
            r1 = r3.mCallbackObj;
            goto L6
        }

        public void setFlags(int r1) {
            MediaSessionCompatApi21.a(this.mSessionObj, r1);
        }

        public void setPlaybackToLocal(int r1) {
            MediaSessionCompatApi21.b(this.mSessionObj, r1);
        }

        public void setPlaybackToRemote(f r1) {
            MediaSessionCompatApi21.a(this.mSessionObj, r1.d());
        }

        public void setActive(boolean r1) {
            MediaSessionCompatApi21.a(this.mSessionObj, r1);
        }

        public boolean isActive() {
            return MediaSessionCompatApi21.c(this.mSessionObj);
        }

        public void sendSessionEvent(String r5, Bundle r6) {
            if (Build.VERSION.SDK_INT >= 23) goto L10;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mExtraControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onEvent(r5, r6);     // Catch: RemoteException -> L12
        L8:
            r0 = r0 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
        L10:
            MediaSessionCompatApi21.a(this.mSessionObj, r5, r6);
        }

        public void release() {
            this.mDestroyed = true;
            MediaSessionCompatApi21.d(this.mSessionObj);
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public void setPlaybackState(PlaybackStateCompat r5) {
            this.mPlaybackState = r5;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mExtraControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onPlaybackStateChanged(r5);     // Catch: RemoteException -> L13
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mExtraControllerCallbacks.finishBroadcast();
            Object r4 = this.mSessionObj;
            if (r5 != null) goto L10;
            Object r6 = null;
        L11:
            MediaSessionCompatApi21.b(r4, r6);
            return;
        L10:
            r6 = r5.getPlaybackState();
            goto L11
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        public void setMetadata(MediaMetadataCompat r1) {
            this.mMetadata = r1;
            Object r0 = this.mSessionObj;
            if (r1 != null) goto L5;
            Object r2 = null;
        L6:
            MediaSessionCompatApi21.c(r0, r2);
            return;
        L5:
            r2 = r1.getMediaMetadata();
            goto L6
        }

        public void setSessionActivity(PendingIntent r1) {
            MediaSessionCompatApi21.a(this.mSessionObj, r1);
        }

        public void setMediaButtonReceiver(PendingIntent r1) {
            MediaSessionCompatApi21.b(this.mSessionObj, r1);
        }

        public void setQueue(List<QueueItem> r5) {
            List<QueueItem> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            this.mQueue = r6;
            if (r6 == null) goto L8;
            ArrayList r0 = new ArrayList();
            Iterator<QueueItem> r7 = r6.iterator();
        L6:
            if (r7.hasNext() == false) goto L9;
            r0.add(((QueueItem) ZeusTransformUtils.preCheckCast(r7.next(), QueueItem.class, "com.obric.aiagent.plugin")).getQueueItem());
        L9:
            MediaSessionCompatApi21.a(this.mSessionObj, r0);
            return;
        L8:
            r0 = null;
            goto L9
        }

        public void setQueueTitle(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            MediaSessionCompatApi21.a(this.mSessionObj, r4);
        }

        public void setRatingType(int r3) {
            if (Build.VERSION.SDK_INT >= 22) goto L5;
            this.mRatingType = r3;
            return;
        L5:
            c.a(this.mSessionObj, r3);
        }

        public void setCaptioningEnabled(boolean r5) {
            if (this.mCaptioningEnabled == r5) goto L16;
            this.mCaptioningEnabled = r5;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mExtraControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onCaptioningEnabledChanged(r5);     // Catch: RemoteException -> L11
        L8:
            r0 = r0 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        public void setRepeatMode(int r5) {
            if (this.mRepeatMode == r5) goto L16;
            this.mRepeatMode = r5;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mExtraControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onRepeatModeChanged(r5);     // Catch: RemoteException -> L11
        L8:
            r0 = r0 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        public void setShuffleMode(int r5) {
            if (this.mShuffleMode == r5) goto L16;
            this.mShuffleMode = r5;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mExtraControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onShuffleModeChanged(r5);     // Catch: RemoteException -> L11
        L8:
            r0 = r0 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        public void setExtras(Bundle r1) {
            MediaSessionCompatApi21.a(this.mSessionObj, r1);
        }

        public Object getMediaSession() {
            return this.mSessionObj;
        }

        public String getCallingPackage() {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return null;
        L7:
            return MediaSessionCompatApi24.a(this.mSessionObj);
        }
    }

    static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.a
        public void setCurrentControllerInfo(androidx.media.b.C0067b r1) {
        }

        MediaSessionImplApi28(Context r3, String r4, Bundle r5) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
        }

        MediaSessionImplApi28(Object r1) {
            super(r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.a
        public final androidx.media.b.C0067b getCurrentControllerInfo() {
            return new androidx.media.b.C0067b(((MediaSession) ZeusTransformUtils.preCheckCast(this.mSessionObj, MediaSession.class, "com.obric.aiagent.plugin")).getCurrentControllerInfo());
        }
    }

    static class MediaSessionImplBase implements a {
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
        private androidx.media.b.C0067b mRemoteUserInfo;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        int mShuffleMode;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        final String mTag;
        private final Token mToken;
        private f.a mVolumeCallback;
        f mVolumeProvider;
        int mVolumeType;

        class MediaSessionStub extends IMediaSession.Stub {
            final /* synthetic */ MediaSessionImplBase this$0;

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r1) {
            }

            MediaSessionStub(MediaSessionImplBase r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r2, Bundle r3, ResultReceiverWrapper r4) {
                postToHandler(1, new a(r2, r3, r4.mResultReceiver));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r3) {
                boolean r1 = true;
                if ((this.this$0.mFlags & 1) != 0) goto L6;
                r1 = false;
            L6:
                if (r1 == false) goto L8;
                postToHandler(21, r3);
            L8:
                return r1;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r5) {
                IMediaControllerCallback r6 = (IMediaControllerCallback) ZeusTransformUtils.wrapperContextForParams(r5, IMediaControllerCallback.class, "com.obric.aiagent.plugin");
                if (this.this$0.mDestroyed == true) goto L9;
                androidx.media.b.C0067b r0 = new androidx.media.b.C0067b("android.media.session.MediaController", getCallingPid(), getCallingUid());
                this.this$0.mControllerCallbacks.register(r6, r0);
                return;
            L9:
                r6.onSessionDestroyed();     // Catch: Exception -> L8
                return;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r3) {
                IMediaControllerCallback r4 = (IMediaControllerCallback) ZeusTransformUtils.wrapperContextForParams(r3, IMediaControllerCallback.class, "com.obric.aiagent.plugin");
                this.this$0.mControllerCallbacks.unregister(r4);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                return this.this$0.mPackageName;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                return this.this$0.mTag;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                PendingIntent r1 = this.this$0.mSessionActivity;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                long r1 = this.this$0.mFlags;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                int r3 = this.this$0.mVolumeType;     // Catch: Throwable -> L11
                int r4 = this.this$0.mLocalStream;     // Catch: Throwable -> L11
                f r1 = this.this$0.mVolumeProvider;     // Catch: Throwable -> L11
                if (r3 != 2) goto L7;
                int r8 = r1.b();     // Catch: Throwable -> L11
                int r2 = r1.c();     // Catch: Throwable -> L11
                int r5 = r8;
                int r7 = r1.a();     // Catch: Throwable -> L11
                int r6 = r2;
            L8:
                monitor-exit(r0);     // Catch: Throwable -> L11
                return new ParcelableVolumeInfo(r3, r4, r5, r6, r7);
            L7:
                int r9 = this.this$0.mAudioManager.getStreamMaxVolume(r4);     // Catch: Throwable -> L11
                r7 = this.this$0.mAudioManager.getStreamVolume(r4);     // Catch: Throwable -> L11
                r6 = r9;
                r5 = 2;
            L11:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r1, int r2, String r3) {
                this.this$0.adjustVolume(r1, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r1, int r2, String r3) {
                this.this$0.setVolumeTo(r1, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() {
                postToHandler(3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r2, Bundle r3) {
                postToHandler(4, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r2, Bundle r3) {
                postToHandler(5, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r2, Bundle r3) {
                postToHandler(6, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() {
                postToHandler(7);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r2, Bundle r3) {
                postToHandler(8, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r2, Bundle r3) {
                postToHandler(9, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r2, Bundle r3) {
                postToHandler(10, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r1) {
                postToHandler(11, Long.valueOf(r1));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() {
                postToHandler(12);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() {
                postToHandler(13);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() {
                postToHandler(14);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() {
                postToHandler(15);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() {
                postToHandler(16);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() {
                postToHandler(17);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r1) {
                postToHandler(18, Long.valueOf(r1));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r2) {
                postToHandler(19, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r2, Bundle r3) {
                postToHandler(31, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r2) {
                postToHandler(29, Boolean.valueOf(r2));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r2) {
                postToHandler(23, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r2) {
                postToHandler(30, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r2, Bundle r3) {
                postToHandler(20, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                return this.this$0.mMetadata;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                PlaybackStateCompat r1 = this.this$0.mState;     // Catch: Throwable -> L8
                MediaMetadataCompat r2 = this.this$0.mMetadata;     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                return MediaSessionCompat.a(r1, r2);
            L8:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                List<QueueItem> r1 = this.this$0.mQueue;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r2) {
                postToHandler(25, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r2, int r3) {
                postToHandler(26, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r2) {
                postToHandler(27, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r2) {
                postToHandler(28, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                return this.this$0.mQueueTitle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                Bundle r1 = this.this$0.mExtras;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return this.this$0.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return this.this$0.mCaptioningEnabled;
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
            public boolean isTransportControlEnabled() {
                if ((this.this$0.mFlags & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            void postToHandler(int r7) {
                this.this$0.postToHandler(r7, 0, 0, null, null);
            }

            void postToHandler(int r7, int r8) {
                this.this$0.postToHandler(r7, r8, 0, null, null);
            }

            void postToHandler(int r7, Object r8) {
                this.this$0.postToHandler(r7, 0, 0, r8, null);
            }

            void postToHandler(int r7, Object r8, int r9) {
                this.this$0.postToHandler(r7, r9, 0, r8, null);
            }

            void postToHandler(int r7, Object r8, Bundle r9) {
                this.this$0.postToHandler(r7, 0, 0, r8, r9);
            }
        }

        class MessageHandler extends Handler {
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

            public static /* synthetic */ int access$000(String r0, String r1) {
                return Log.w(r0, r1);
            }

            public MessageHandler(MediaSessionImplBase r1, Looper r2) {
                this.this$0 = r1;
                super(r2);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r8) {
                Callback r0 = this.this$0.mCallback;
                if (r0 != null) goto L5;
                return;
            L5:
                Bundle r1 = r8.getData();
                MediaSessionCompat.a(r1);
                this.this$0.setCurrentControllerInfo(new androidx.media.b.C0067b(r1.getString("data_calling_pkg"), r1.getInt("data_calling_pid"), r1.getInt("data_calling_uid")));
                Bundle r2 = r1.getBundle("data_extras");
                MediaSessionCompat.a(r2);
            L53:
                th = move-exception;
                this.this$0.setCurrentControllerInfo(null);
                throw th;
            L8:
                switch(r8.what) {
                    case 1: goto L50;
                    case 2: goto L49;
                    case 3: goto L48;
                    case 4: goto L47;
                    case 5: goto L46;
                    case 6: goto L45;
                    case 7: goto L44;
                    case 8: goto L43;
                    case 9: goto L42;
                    case 10: goto L41;
                    case 11: goto L40;
                    case 12: goto L39;
                    case 13: goto L38;
                    case 14: goto L37;
                    case 15: goto L36;
                    case 16: goto L35;
                    case 17: goto L34;
                    case 18: goto L33;
                    case 19: goto L32;
                    case 20: goto L31;
                    case 21: goto L28;
                    case 22: goto L27;
                    case 23: goto L26;
                    case 24: goto L51;
                    case 25: goto L25;
                    case 26: goto L24;
                    case 27: goto L23;
                    case 28: goto L14;
                    case 29: goto L12;
                    case 30: goto L11;
                    case 31: goto L10;
                    default: goto L51;
                };
            L10:
                r0.onSetRating((RatingCompat) ZeusTransformUtils.preCheckCast(r8.obj, RatingCompat.class, "com.obric.aiagent.plugin"), r2);     // Catch: Throwable -> L53
                goto L51
            L11:
                r0.onSetShuffleMode(r8.arg1);     // Catch: Throwable -> L53
                goto L51
            L12:
                r0.onSetCaptioningEnabled(((Boolean) ZeusTransformUtils.preCheckCast(r8.obj, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());     // Catch: Throwable -> L53
                goto L51
            L23:
                r0.onRemoveQueueItem((MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(r8.obj, MediaDescriptionCompat.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L53
                goto L51
            L24:
                r0.onAddQueueItem((MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(r8.obj, MediaDescriptionCompat.class, "com.obric.aiagent.plugin"), r8.arg1);     // Catch: Throwable -> L53
                goto L51
            L25:
                r0.onAddQueueItem((MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(r8.obj, MediaDescriptionCompat.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L53
                goto L51
            L26:
                r0.onSetRepeatMode(r8.arg1);     // Catch: Throwable -> L53
                goto L51
            L27:
                this.this$0.setVolumeTo(r8.arg1, 0);     // Catch: Throwable -> L53
                goto L51
            L28:
                KeyEvent r9 = (KeyEvent) ZeusTransformUtils.preCheckCast(r8.obj, KeyEvent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53
                Intent r3 = new Intent("android.intent.action.MEDIA_BUTTON");     // Catch: Throwable -> L53
                r3.putExtra("android.intent.extra.KEY_EVENT", r9);     // Catch: Throwable -> L53
                if (r0.onMediaButtonEvent(r3) == true) goto L51;
                onMediaButtonEvent(r9, r0);     // Catch: Throwable -> L53
                goto L51
            L31:
                r0.onCustomAction((String) ZeusTransformUtils.preCheckCast(r8.obj, String.class, "com.obric.aiagent.plugin"), r2);     // Catch: Throwable -> L53
                goto L51
            L32:
                r0.onSetRating((RatingCompat) ZeusTransformUtils.preCheckCast(r8.obj, RatingCompat.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L53
                goto L51
            L33:
                r0.onSeekTo(((Long) ZeusTransformUtils.preCheckCast(r8.obj, Long.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L53
                goto L51
            L34:
                r0.onRewind();     // Catch: Throwable -> L53
                goto L51
            L35:
                r0.onFastForward();     // Catch: Throwable -> L53
                goto L51
            L36:
                r0.onSkipToPrevious();     // Catch: Throwable -> L53
                goto L51
            L37:
                r0.onSkipToNext();     // Catch: Throwable -> L53
                goto L51
            L38:
                r0.onStop();     // Catch: Throwable -> L53
                goto L51
            L39:
                r0.onPause();     // Catch: Throwable -> L53
                goto L51
            L40:
                r0.onSkipToQueueItem(((Long) ZeusTransformUtils.preCheckCast(r8.obj, Long.class, "com.obric.aiagent.plugin")).longValue());     // Catch: Throwable -> L53
                goto L51
            L41:
                r0.onPlayFromUri((Uri) ZeusTransformUtils.preCheckCast(r8.obj, Uri.class, "com.obric.aiagent.plugin"), r2);     // Catch: Throwable -> L53
                goto L51
            L42:
                r0.onPlayFromSearch((String) ZeusTransformUtils.preCheckCast(r8.obj, String.class, "com.obric.aiagent.plugin"), r2);     // Catch: Throwable -> L53
                goto L51
            L43:
                r0.onPlayFromMediaId((String) ZeusTransformUtils.preCheckCast(r8.obj, String.class, "com.obric.aiagent.plugin"), r2);     // Catch: Throwable -> L53
                goto L51
            L44:
                r0.onPlay();     // Catch: Throwable -> L53
                goto L51
            L45:
                r0.onPrepareFromUri((Uri) ZeusTransformUtils.preCheckCast(r8.obj, Uri.class, "com.obric.aiagent.plugin"), r2);     // Catch: Throwable -> L53
                goto L51
            L46:
                r0.onPrepareFromSearch((String) ZeusTransformUtils.preCheckCast(r8.obj, String.class, "com.obric.aiagent.plugin"), r2);     // Catch: Throwable -> L53
                goto L51
            L47:
                r0.onPrepareFromMediaId((String) ZeusTransformUtils.preCheckCast(r8.obj, String.class, "com.obric.aiagent.plugin"), r2);     // Catch: Throwable -> L53
                goto L51
            L48:
                r0.onPrepare();     // Catch: Throwable -> L53
                goto L51
            L49:
                this.this$0.adjustVolume(r8.arg1, 0);     // Catch: Throwable -> L53
                goto L51
            L50:
                a r10 = (a) ZeusTransformUtils.preCheckCast(r8.obj, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53
                r0.onCommand(r10.f78a, r10.f79b, r10.f80c);     // Catch: Throwable -> L53
            L51:
                this.this$0.setCurrentControllerInfo(null);
                return;
            L14:
                if (this.this$0.mQueue == null) goto L51;
                if (r8.arg1 >= 0) goto L18;
            L20:
                QueueItem r11 = null;
            L21:
                if (r11 == null) goto L51;
                r0.onRemoveQueueItem(r11.getDescription());     // Catch: Throwable -> L53
                goto L51
            L18:
                if (r8.arg1 >= this.this$0.mQueue.size()) goto L20;
                r11 = (QueueItem) ZeusTransformUtils.preCheckCast(this.this$0.mQueue.get(r8.arg1), QueueItem.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53
                goto L21
            }

            private void onMediaButtonEvent(KeyEvent r6, Callback r7) {
                if (r6 != null) goto L4;
                return;
            L4:
                if (r6.getAction() == 0) goto L7;
                return;
            L7:
                if (this.this$0.mState != null) goto L9;
                long r3 = 0;
            L10:
                int r5 = r6.getKeyCode();
                if (r5 != 79) goto L13;
            L39:
                INVOKESTATIC_android_support_v4_media_session_MediaSessionCompat$MediaSessionImplBase$MessageHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("MediaSessionCompat", "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                return;
            L13:
                if (r5 == KEYCODE_MEDIA_PLAY) goto L37;
                if (r5 == KEYCODE_MEDIA_PAUSE) goto L34;
                switch(r5) {
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
                if ((64 & r3) == 0) goto L42;
                r7.onFastForward();
                return;
            L42:
                return;
            L22:
                if ((8 & r3) == 0) goto L44;
                r7.onRewind();
                return;
            L44:
                return;
            L25:
                if ((16 & r3) == 0) goto L46;
                r7.onSkipToPrevious();
                return;
            L46:
                return;
            L28:
                if ((32 & r3) == 0) goto L48;
                r7.onSkipToNext();
                return;
            L48:
                return;
            L31:
                if ((1 & r3) == 0) goto L50;
                r7.onStop();
                return;
            L50:
                return;
            L34:
                if ((2 & r3) == 0) goto L52;
                r7.onPause();
                return;
            L52:
                return;
            L37:
                if ((4 & r3) == 0) goto L54;
                r7.onPlay();
                return;
            L54:
                return;
            L9:
                r3 = this.this$0.mState.getActions();
                goto L10
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int INVOKESTATIC_android_support_v4_media_session_MediaSessionCompat$MediaSessionImplBase$MessageHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
                if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
                return 0;
            L5:
                return Log.w(r1, r2);
            }
        }

        private static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f78a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Bundle f79b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final ResultReceiver f80c;

            public a(String r1, Bundle r2, ResultReceiver r3) {
                this.f78a = r1;
                this.f79b = r2;
                this.f80c = r3;
            }
        }

        public String getCallingPackage() {
            return null;
        }

        public Object getMediaSession() {
            return null;
        }

        int getRccStateFromState(int r1) {
            switch(r1) {
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

        int getRccTransportControlFlagsFromActions(long r5) {
            if ((1 & r5) == 0) goto L5;
            int r4 = 32;
        L7:
            if ((2 & r5) == 0) goto L10;
            r4 = r4 | 16;
        L10:
            if ((4 & r5) == 0) goto L13;
            r4 = r4 | 4;
        L13:
            if ((8 & r5) == 0) goto L16;
            r4 = r4 | 2;
        L16:
            if ((16 & r5) == 0) goto L19;
            r4 = r4 | 1;
        L19:
            if ((32 & r5) == 0) goto L22;
            r4 = r4 | 128;
        L22:
            if ((64 & r5) == 0) goto L25;
            r4 = r4 | 64;
        L25:
            if ((r5 & 512) != 0) goto L27;
            return r4;
        L27:
            return r4 | 8;
        L5:
            r4 = 0;
            goto L7
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public void setMediaButtonReceiver(PendingIntent r1) {
        }

        public MediaSessionImplBase(Context r4, String r5, ComponentName r6, PendingIntent r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.mLock = new Object();
            this.mControllerCallbacks = new RemoteCallbackList();
            this.mDestroyed = false;
            this.mIsActive = false;
            this.mIsMbrRegistered = false;
            this.mIsRccRegistered = false;
            this.mVolumeCallback = new AnonymousClass1(this);
            if (r6 == null) goto L7;
            this.mContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
            this.mPackageName = r8.getPackageName();
            this.mAudioManager = (AudioManager) ZeusTransformUtils.preCheckCast(r8.getSystemService("audio"), AudioManager.class, "com.obric.aiagent.plugin");
            this.mTag = r5;
            this.mMediaButtonReceiverComponentName = r6;
            this.mMediaButtonReceiverIntent = r7;
            MediaSessionStub r9 = new MediaSessionStub(this);
            this.mStub = r9;
            this.mToken = new Token(r9);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new RemoteControlClient(r7);
            return;
        L7:
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
        }

        public void setCallback(Callback r3, Handler r4) {
            this.mCallback = r3;
            if (r3 == null) goto L17;
            if (r4 != null) goto L6;
            r4 = new Handler();
        L6:
            Object r5 = this.mLock;
            monitor-enter(r5);
            MessageHandler r0 = this.mHandler;     // Catch: Throwable -> L14
            if (r0 == null) goto L11;
            r0.removeCallbacksAndMessages(null);     // Catch: Throwable -> L14
        L11:
            this.mHandler = new MessageHandler(this, r4.getLooper());     // Catch: Throwable -> L14
            this.mCallback.setSessionImpl(this, r4);     // Catch: Throwable -> L14
            monitor-exit(r5);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        void postToHandler(int r2, int r3, int r4, Object r5, Bundle r6) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            MessageHandler r1 = this.mHandler;     // Catch: Throwable -> L12
            if (r1 == null) goto L10;
            Message r7 = r1.obtainMessage(r2, r3, r4, r5);     // Catch: Throwable -> L12
            Bundle r8 = new Bundle();     // Catch: Throwable -> L12
            r8.putString("data_calling_pkg", "android.media.session.MediaController");     // Catch: Throwable -> L12
            r8.putInt("data_calling_pid", Binder.getCallingPid());     // Catch: Throwable -> L12
            r8.putInt("data_calling_uid", Binder.getCallingUid());     // Catch: Throwable -> L12
            if (r6 == null) goto L9;
            r8.putBundle("data_extras", r6);     // Catch: Throwable -> L12
        L9:
            r7.setData(r8);     // Catch: Throwable -> L12
            r7.sendToTarget();     // Catch: Throwable -> L12
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public void setFlags(int r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mFlags = r2;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            update();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void setPlaybackToLocal(int r7) {
            f r0 = this.mVolumeProvider;
            if (r0 == null) goto L5;
            r0.a(null);
        L5:
            this.mLocalStream = r7;
            this.mVolumeType = 1;
            int r1 = this.mVolumeType;
            int r2 = this.mLocalStream;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(r1, r2, 2, this.mAudioManager.getStreamMaxVolume(r2), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        public void setPlaybackToRemote(f r8) {
            if (r8 == null) goto L9;
            f r0 = this.mVolumeProvider;
            if (r0 == null) goto L6;
            r0.a(null);
        L6:
            this.mVolumeType = 2;
            this.mVolumeProvider = r8;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.b(), this.mVolumeProvider.c(), this.mVolumeProvider.a()));
            r8.a(this.mVolumeCallback);
            return;
        L9:
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        public void setActive(boolean r2) {
            if (r2 != this.mIsActive) goto L5;
            return;
        L5:
            this.mIsActive = r2;
            if (update() == false) goto L9;
            setMetadata(this.mMetadata);
            setPlaybackState(this.mState);
            return;
        }

        public boolean isActive() {
            return this.mIsActive;
        }

        public void sendSessionEvent(String r1, Bundle r2) {
            sendEvent(r1, r2);
        }

        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public void setPlaybackState(PlaybackStateCompat r4) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mState = r4;     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            sendState(r4);
            if (this.mIsActive == true) goto L9;
            return;
        L9:
            if (r4 != null) goto L11;
            this.mRcc.setPlaybackState(0);
            this.mRcc.setTransportControlFlags(0);
            return;
        L11:
            setRccState(r4);
            this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(r4.getActions()));
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public PlaybackStateCompat getPlaybackState() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            PlaybackStateCompat r1 = this.mState;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        void setRccState(PlaybackStateCompat r2) {
            this.mRcc.setPlaybackState(getRccStateFromState(r2.getState()));
        }

        public void setMetadata(MediaMetadataCompat r3) {
            if (r3 == null) goto L4;
            r3 = new MediaMetadataCompat.a(r3, MediaSessionCompat.f76a).a();
        L4:
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mMetadata = r3;     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L16
            sendMetadata(r3);
            if (this.mIsActive == true) goto L11;
            return;
        L11:
            if (r3 != null) goto L13;
            Bundle r4 = null;
        L14:
            buildRccMetadata(r4).apply();
            return;
        L13:
            r4 = r3.getBundle();
        L16:
            th = move-exception;
            throw th;
        }

        RemoteControlClient.MetadataEditor buildRccMetadata(Bundle r7) {
            RemoteControlClient.MetadataEditor r6 = this.mRcc.editMetadata(true);
            if (r7 != null) goto L6;
            return r6;
        L6:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_ART) == false) goto L12;
            Bitmap r1 = (Bitmap) ZeusTransformUtils.preCheckCast(r7.getParcelable(MediaMetadataCompat.METADATA_KEY_ART), Bitmap.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L10;
            r1 = r1.copy(r1.getConfig(), false);
        L10:
            r6.putBitmap(100, r1);
        L18:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM) == false) goto L21;
            r6.putString(1, r7.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
        L21:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST) == false) goto L24;
            r6.putString(13, r7.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
        L24:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_ARTIST) == false) goto L27;
            r6.putString(2, r7.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
        L27:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_AUTHOR) == false) goto L30;
            r6.putString(3, r7.getString(MediaMetadataCompat.METADATA_KEY_AUTHOR));
        L30:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_COMPILATION) == false) goto L33;
            r6.putString(15, r7.getString(MediaMetadataCompat.METADATA_KEY_COMPILATION));
        L33:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_COMPOSER) == false) goto L36;
            r6.putString(4, r7.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER));
        L36:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_DATE) == false) goto L39;
            r6.putString(5, r7.getString(MediaMetadataCompat.METADATA_KEY_DATE));
        L39:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER) == false) goto L42;
            r6.putLong(14, r7.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
        L42:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION) == false) goto L45;
            r6.putLong(9, r7.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
        L45:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_GENRE) == false) goto L48;
            r6.putString(6, r7.getString(MediaMetadataCompat.METADATA_KEY_GENRE));
        L48:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_TITLE) == false) goto L51;
            r6.putString(7, r7.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
        L51:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER) == false) goto L54;
            r6.putLong(0, r7.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
        L54:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_WRITER) == false) goto L56;
            r6.putString(11, r7.getString(MediaMetadataCompat.METADATA_KEY_WRITER));
        L56:
            return r6;
        L12:
            if (r7.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ART) == false) goto L18;
            Bitmap r2 = (Bitmap) ZeusTransformUtils.preCheckCast(r7.getParcelable(MediaMetadataCompat.METADATA_KEY_ALBUM_ART), Bitmap.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L16;
            r2 = r2.copy(r2.getConfig(), false);
        L16:
            r6.putBitmap(100, r2);
            goto L18
        }

        public void setSessionActivity(PendingIntent r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mSessionActivity = r2;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setQueue(List<QueueItem> r3) {
            List<QueueItem> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            this.mQueue = r4;
            sendQueue(r4);
        }

        public void setQueueTitle(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            this.mQueueTitle = r4;
            sendQueueTitle(r4);
        }

        public void setRatingType(int r1) {
            this.mRatingType = r1;
        }

        public void setCaptioningEnabled(boolean r2) {
            if (this.mCaptioningEnabled == r2) goto L6;
            this.mCaptioningEnabled = r2;
            sendCaptioningEnabled(r2);
            return;
        }

        public void setRepeatMode(int r2) {
            if (this.mRepeatMode == r2) goto L6;
            this.mRepeatMode = r2;
            sendRepeatMode(r2);
            return;
        }

        public void setShuffleMode(int r2) {
            if (this.mShuffleMode == r2) goto L6;
            this.mShuffleMode = r2;
            sendShuffleMode(r2);
            return;
        }

        public void setExtras(Bundle r1) {
            this.mExtras = r1;
            sendExtras(r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public androidx.media.b.C0067b getCurrentControllerInfo() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            androidx.media.b.C0067b r1 = this.mRemoteUserInfo;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setCurrentControllerInfo(androidx.media.b.C0067b r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mRemoteUserInfo = r2;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        boolean update() {
            if (this.mIsActive == false) goto L23;
            boolean r0 = this.mIsMbrRegistered;
            if (r0 == false) goto L7;
        L9:
            if (r0 == true) goto L11;
        L13:
            boolean r1 = this.mIsRccRegistered;
            if (r1 == false) goto L16;
        L18:
            if (r1 == false) goto L29;
            if ((this.mFlags & 2) != 0) goto L29;
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = false;
        L29:
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
            if (this.mIsRccRegistered == false) goto L29;
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = false;
            goto L29
        }

        void registerMediaButtonEventReceiver(PendingIntent r1, ComponentName r2) {
            this.mAudioManager.registerMediaButtonEventReceiver(r2);
        }

        void unregisterMediaButtonEventReceiver(PendingIntent r1, ComponentName r2) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(r2);
        }

        void adjustVolume(int r3, int r4) {
            if (this.mVolumeType != 2) goto L7;
            f r2 = this.mVolumeProvider;
            if (r2 == null) goto L9;
            r2.b(r3);
            return;
        L9:
            return;
        L7:
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, r3, r4);
        }

        void setVolumeTo(int r3, int r4) {
            if (this.mVolumeType != 2) goto L7;
            f r2 = this.mVolumeProvider;
            if (r2 == null) goto L9;
            r2.a(r3);
            return;
        L9:
            return;
        L7:
            this.mAudioManager.setStreamVolume(this.mLocalStream, r3, r4);
        }

        void sendVolumeInfoChanged(ParcelableVolumeInfo r5) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onVolumeInfoChanged(r5);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onSessionDestroyed();     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        private void sendEvent(String r5, Bundle r6) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onEvent(r5, r6);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(PlaybackStateCompat r5) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onPlaybackStateChanged(r5);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat r5) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onMetadataChanged(r5);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List<QueueItem> r5) {
            List<QueueItem> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onQueueChanged(r6);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onQueueTitleChanged(r6);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendCaptioningEnabled(boolean r5) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onCaptioningEnabledChanged(r5);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendRepeatMode(int r5) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onRepeatModeChanged(r5);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendShuffleMode(int r5) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onShuffleModeChanged(r5);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendExtras(Bundle r5) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(this.mControllerCallbacks.getBroadcastItem(r0), IMediaControllerCallback.class, "com.obric.aiagent.plugin")).onExtrasChanged(r5);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }
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

        public QueueItem(MediaDescriptionCompat r2, long r3) {
            this(null, r2, r3);
        }

        private QueueItem(Object r3, MediaDescriptionCompat r4, long r5) {
            if (r4 == null) goto L11;
            if (r5 == (-1)) goto L9;
            this.mDescription = r4;
            this.mId = r5;
            this.mItem = r3;
            return;
        L9:
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        L11:
            throw new IllegalArgumentException("Description cannot be null.");
        }

        QueueItem(Parcel r4) {
            this.mDescription = (MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(MediaDescriptionCompat.CREATOR.createFromParcel(r4), MediaDescriptionCompat.class, "com.obric.aiagent.plugin");
            this.mId = r4.readLong();
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            this.mDescription.writeToParcel(r3, r4);
            r3.writeLong(this.mId);
        }

        public Object getQueueItem() {
            if (this.mItem != null) goto L10;
            if (Build.VERSION.SDK_INT < 21) goto L10;
            Object r0 = MediaSessionCompatApi21.b.a(this.mDescription.getMediaDescription(), this.mId);
            this.mItem = r0;
            return r0;
        L10:
            return this.mItem;
        }

        public static QueueItem fromQueueItem(Object r4) {
            if (r4 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT >= 21) goto L7;
            return null;
        L7:
            return new QueueItem(r4, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.b.a(r4)), MediaSessionCompatApi21.b.b(r4));
        }

        public static List<QueueItem> fromQueueItemList(List<?> r2) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L5;
            return null;
        L5:
            if (Build.VERSION.SDK_INT < 21) goto L15;
            ArrayList r0 = new ArrayList();
            Iterator r4 = r3.iterator();
        L9:
            if (r4.hasNext() == false) goto L11;
            r0.add(fromQueueItem(r4.next()));
            goto L9
        L11:
            return r0;
        L15:
            return null;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = null;
        ResultReceiver mResultReceiver;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public ResultReceiverWrapper(ResultReceiver r1) {
            this.mResultReceiver = r1;
        }

        ResultReceiverWrapper(Parcel r3) {
            this.mResultReceiver = (ResultReceiver) ZeusTransformUtils.preCheckCast(ResultReceiver.CREATOR.createFromParcel(r3), ResultReceiver.class, "com.obric.aiagent.plugin");
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            this.mResultReceiver.writeToParcel(r1, r2);
        }
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

        Token(Object r2) {
            this(r2, null, null);
        }

        Token(Object r3, IMediaSession r4) {
            this(r3, (IMediaSession) ZeusTransformUtils.wrapperContextForParams(r4, IMediaSession.class, "com.obric.aiagent.plugin"), null);
        }

        Token(Object r3, IMediaSession r4, Bundle r5) {
            IMediaSession r6 = (IMediaSession) ZeusTransformUtils.wrapperContextForParams(r4, IMediaSession.class, "com.obric.aiagent.plugin");
            this.mInner = r3;
            this.mExtraBinder = r6;
            this.mSessionToken2Bundle = r5;
        }

        public static Token fromToken(Object r1) {
            return fromToken(r1, null);
        }

        public static Token fromToken(Object r2, IMediaSession r3) {
            IMediaSession r4 = (IMediaSession) ZeusTransformUtils.wrapperContextForParams(r3, IMediaSession.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L5;
            return null;
        L5:
            if (Build.VERSION.SDK_INT >= 21) goto L7;
            return null;
        L7:
            return new Token(MediaSessionCompatApi21.b(r2), r4);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r4, int r5) {
            if (Build.VERSION.SDK_INT < 21) goto L5;
            r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.mInner, Parcelable.class, "com.obric.aiagent.plugin"), r5);
            return;
        L5:
            r4.writeStrongBinder((IBinder) ZeusTransformUtils.preCheckCast(this.mInner, IBinder.class, "com.obric.aiagent.plugin"));
        }

        public int hashCode() {
            Object r0 = this.mInner;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Token.class) == true) goto L8;
            return false;
        L8:
            Token r6 = (Token) ZeusTransformUtils.preCheckCast(r5, Token.class, "com.obric.aiagent.plugin");
            Object r4 = this.mInner;
            if (r4 == null) goto L11;
            Object r7 = r6.mInner;
            if (r7 != null) goto L19;
            return false;
        L19:
            return r4.equals(r7);
        L11:
            if (r6.mInner != null) goto L14;
            return true;
        L14:
            return false;
        }

        public Object getToken() {
            return this.mInner;
        }

        public IMediaSession getExtraBinder() {
            return this.mExtraBinder;
        }

        public void setExtraBinder(IMediaSession r3) {
            this.mExtraBinder = (IMediaSession) ZeusTransformUtils.wrapperContextForParams(r3, IMediaSession.class, "com.obric.aiagent.plugin");
        }

        public Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public void setSessionToken2Bundle(Bundle r1) {
            this.mSessionToken2Bundle = r1;
        }

        public Bundle toBundle() {
            Bundle r0 = new Bundle();
            r0.putParcelable("android.support.v4.media.session.TOKEN", this);
            IMediaSession r1 = this.mExtraBinder;
            if (r1 == null) goto L5;
            androidx.core.app.d.a(r0, "android.support.v4.media.session.EXTRA_BINDER", r1.asBinder());
        L5:
            Bundle r3 = this.mSessionToken2Bundle;
            if (r3 == null) goto L8;
            r0.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", r3);
        L8:
            return r0;
        }

        public static Token fromBundle(Bundle r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IMediaSession r1 = IMediaSession.Stub.asInterface(androidx.core.app.d.a(r5, "android.support.v4.media.session.EXTRA_BINDER"));
            Bundle r2 = r5.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
            Token r6 = (Token) ZeusTransformUtils.preCheckCast(r5.getParcelable("android.support.v4.media.session.TOKEN"), Token.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L9;
            return null;
        L9:
            return new Token(r6.mInner, r1, r2);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    interface a {
        androidx.media.b.C0067b getCurrentControllerInfo();

        PlaybackStateCompat getPlaybackState();

        void setCurrentControllerInfo(androidx.media.b.C0067b r1);
    }

    public static void a(Bundle r1) {
        if (r1 == null) goto L5;
        r1.setClassLoader(MediaSessionCompat.class.getClassLoader());
        return;
    }

    static PlaybackStateCompat a(PlaybackStateCompat r14, MediaMetadataCompat r15) {
        if (r14 == null) goto L30;
        long r2 = -1;
        if (r14.getPosition() != (-1)) goto L7;
        return r14;
    L7:
        if (r14.getState() != 3) goto L9;
    L12:
        long r0 = r14.getLastPositionUpdateTime();
        if (r0 <= 0) goto L32;
        long r12 = SystemClock.elapsedRealtime();
        long r1 = ((long) (r14.getPlaybackSpeed() * (r12 - r0))) + r14.getPosition();
        if (r15 == null) goto L20;
        if (r15.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION) == false) goto L20;
        r2 = r15.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
    L20:
        if (r2 < 0) goto L25;
        if (r1 <= r2) goto L25;
        long r9 = r2;
    L29:
        return new PlaybackStateCompat.a(r14).a(r14.getState(), r9, r14.getPlaybackSpeed(), r12).a();
    L25:
        if (r1 >= 0) goto L27;
        r9 = 0;
        goto L29
    L27:
        r9 = r1;
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
}
