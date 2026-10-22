package android.support.v4.media.session;

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
import android.util.Log;
import android.view.KeyEvent;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f68a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaSessionCompat.Token f69b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashSet<Callback> f70c;

    public static abstract class Callback implements IBinder.DeathRecipient {
        final Object mCallbackObj;
        MessageHandler mHandler;
        IMediaControllerCallback mIControllerCallback;

        private class MessageHandler extends Handler {
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

            MessageHandler(Callback r1, Looper r2) {
                this.this$0 = r1;
                super(r2);
                this.mRegistered = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message r4) {
                if (this.mRegistered == true) goto L6;
                return;
            L6:
                switch(r4.what) {
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
                this.this$0.onShuffleModeChanged(((Integer) ZeusTransformUtils.preCheckCast(r4.obj, Integer.class, "com.obric.aiagent.plugin")).intValue());
                return;
            L10:
                this.this$0.onCaptioningEnabledChanged(((Boolean) ZeusTransformUtils.preCheckCast(r4.obj, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
                return;
            L11:
                this.this$0.onRepeatModeChanged(((Integer) ZeusTransformUtils.preCheckCast(r4.obj, Integer.class, "com.obric.aiagent.plugin")).intValue());
                return;
            L12:
                this.this$0.onSessionDestroyed();
                return;
            L13:
                Bundle r5 = (Bundle) ZeusTransformUtils.preCheckCast(r4.obj, Bundle.class, "com.obric.aiagent.plugin");
                MediaSessionCompat.a(r5);
                this.this$0.onExtrasChanged(r5);
                return;
            L14:
                this.this$0.onQueueTitleChanged((CharSequence) ZeusTransformUtils.preCheckCast(r4.obj, CharSequence.class, "com.obric.aiagent.plugin"));
                return;
            L15:
                this.this$0.onQueueChanged((List) ZeusTransformUtils.preCheckCast(r4.obj, List.class, "com.obric.aiagent.plugin"));
                return;
            L16:
                this.this$0.onAudioInfoChanged((b) ZeusTransformUtils.preCheckCast(r4.obj, b.class, "com.obric.aiagent.plugin"));
                return;
            L17:
                this.this$0.onMetadataChanged((MediaMetadataCompat) ZeusTransformUtils.preCheckCast(r4.obj, MediaMetadataCompat.class, "com.obric.aiagent.plugin"));
                return;
            L18:
                this.this$0.onPlaybackStateChanged((PlaybackStateCompat) ZeusTransformUtils.preCheckCast(r4.obj, PlaybackStateCompat.class, "com.obric.aiagent.plugin"));
                return;
            L19:
                Bundle r0 = r4.getData();
                MediaSessionCompat.a(r0);
                this.this$0.onSessionEvent((String) ZeusTransformUtils.preCheckCast(r4.obj, String.class, "com.obric.aiagent.plugin"), r0);
                return;
            }
        }

        private static class StubApi21 implements MediaControllerCompatApi21.a {
            private final WeakReference<Callback> mCallback;

            StubApi21(Callback r2) {
                this.mCallback = new WeakReference(r2);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.a
            public void onSessionDestroyed() {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.onSessionDestroyed();
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.a
            public void onSessionEvent(String r3, Bundle r4) {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 != null) goto L5;
                return;
            L5:
                if (r2.mIControllerCallback != null) goto L7;
            L9:
                r2.onSessionEvent(r3, r4);
                return;
            L7:
                if (Build.VERSION.SDK_INT >= 23) goto L9;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.a
            public void onPlaybackStateChanged(Object r3) {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 != null) goto L5;
                return;
            L5:
                if (r2.mIControllerCallback != null) goto L10;
                r2.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(r3));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.a
            public void onMetadataChanged(Object r3) {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(r3));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.a
            public void onQueueChanged(List<?> r3) {
                List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(r4));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.a
            public void onQueueTitleChanged(CharSequence r3) {
                CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.onQueueTitleChanged(r4);
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.a
            public void onExtrasChanged(Bundle r3) {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.onExtrasChanged(r3);
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.a
            public void onAudioInfoChanged(int r8, int r9, int r10, int r11, int r12) {
                Callback r7 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r7 == null) goto L6;
                r7.onAudioInfoChanged(new b(r8, r9, r10, r11, r12));
                return;
            }
        }

        private static class StubCompat extends IMediaControllerCallback.Stub {
            private final WeakReference<Callback> mCallback;

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean r1) {
            }

            StubCompat(Callback r2) {
                this.mCallback = new WeakReference(r2);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String r3, Bundle r4) {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.postToHandler(1, r3, r4);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.postToHandler(8, null, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat r3) {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.postToHandler(2, r3, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r3) {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.postToHandler(3, r3, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r3) {
                List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.postToHandler(5, r4, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r3) {
                CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.postToHandler(6, r4, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean r3) {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.postToHandler(11, Boolean.valueOf(r3), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int r3) {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.postToHandler(9, Integer.valueOf(r3), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int r3) {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.postToHandler(12, Integer.valueOf(r3), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r3) {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.postToHandler(7, r3, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r9) {
                Callback r8 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r8 != null) goto L5;
                return;
            L5:
                if (r9 == null) goto L7;
                b r7 = new b(r9.volumeType, r9.audioStream, r9.controlType, r9.maxVolume, r9.currentVolume);
            L8:
                r8.postToHandler(4, r7, null);
                return;
            L7:
                r7 = null;
                goto L8
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() {
                Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(this.mCallback.get(), Callback.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L6;
                r2.postToHandler(13, null, null);
                return;
            }
        }

        public void onAudioInfoChanged(b r1) {
        }

        public void onCaptioningEnabledChanged(boolean r1) {
        }

        public void onExtrasChanged(Bundle r1) {
        }

        public void onMetadataChanged(MediaMetadataCompat r1) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat r1) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        public void onQueueTitleChanged(CharSequence r2) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        }

        public void onRepeatModeChanged(int r1) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String r1, Bundle r2) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int r1) {
        }

        public Callback() {
            if (Build.VERSION.SDK_INT < 21) goto L5;
            this.mCallbackObj = MediaControllerCompatApi21.a(new StubApi21(this));
            return;
        L5:
            StubCompat r0 = new StubCompat(this);
            this.mIControllerCallback = r0;
            this.mCallbackObj = r0;
        }

        public IMediaControllerCallback getIControllerCallback() {
            return this.mIControllerCallback;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            postToHandler(8, null, null);
        }

        void setHandler(Handler r2) {
            if (r2 != null) goto L6;
            MessageHandler r3 = this.mHandler;
            if (r3 == null) goto L8;
            r3.mRegistered = false;
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            return;
        L8:
            return;
        L6:
            MessageHandler r0 = new MessageHandler(this, r2.getLooper());
            this.mHandler = r0;
            r0.mRegistered = true;
        }

        void postToHandler(int r1, Object r2, Bundle r3) {
            MessageHandler r0 = this.mHandler;
            if (r0 == null) goto L6;
            Message r4 = r0.obtainMessage(r1, r2);
            r4.setData(r3);
            r4.sendToTarget();
            return;
        }
    }

    static class MediaControllerImplApi21 implements a {
        private HashMap<Callback, ExtraCallback> mCallbackMap;
        protected final Object mControllerObj;
        final Object mLock;
        private final List<Callback> mPendingCallbacks;
        final MediaSessionCompat.Token mSessionToken;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 r2) {
                super(null);
                this.mMediaControllerImpl = new WeakReference(r2);
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int r3, Bundle r4) {
                MediaControllerImplApi21 r2 = (MediaControllerImplApi21) ZeusTransformUtils.preCheckCast(this.mMediaControllerImpl.get(), MediaControllerImplApi21.class, "com.obric.aiagent.plugin");
                if (r2 == null) goto L14;
                if (r4 == null) goto L17;
                Object r5 = r2.mLock;
                monitor-enter(r5);
                r2.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(androidx.core.app.d.a(r4, "android.support.v4.media.session.EXTRA_BINDER")));     // Catch: Throwable -> L11
                r2.mSessionToken.setSessionToken2Bundle(r4.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));     // Catch: Throwable -> L11
                r2.processPendingCallbacksLocked();     // Catch: Throwable -> L11
                monitor-exit(r5);     // Catch: Throwable -> L11
                return;
            L11:
                th = move-exception;
                throw th;
            L17:
                return;
            }
        }

        private static class ExtraCallback extends Callback.StubCompat {
            ExtraCallback(Callback r1) {
                super(r1);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r2) {
                List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r2) {
                CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r1) {
                throw new AssertionError();
            }
        }

        public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        public MediaControllerImplApi21(Context r3, MediaSessionCompat.Token r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            this.mLock = new Object();
            this.mPendingCallbacks = new ArrayList();
            this.mCallbackMap = new HashMap();
            this.mSessionToken = r4;
            Object r6 = MediaControllerCompatApi21.a(r5, r4.getToken());
            this.mControllerObj = r6;
            if (r6 == null) goto L9;
            if (r4.getExtraBinder() != null) goto L10;
            requestExtraBinder();
            return;
        L10:
            return;
        L9:
            throw new RemoteException();
        }

        public final void registerCallback(Callback r4, Handler r5) {
            MediaControllerCompatApi21.a(this.mControllerObj, r4.mCallbackObj, r5);
            Object r6 = this.mLock;
            monitor-enter(r6);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.mSessionToken.getExtraBinder() == null) goto L11;
            ExtraCallback r0 = new ExtraCallback(r4);     // Catch: Throwable -> L14
            this.mCallbackMap.put(r4, r0);     // Catch: Throwable -> L14
            r4.mIControllerCallback = r0;     // Catch: Throwable -> L14
            this.mSessionToken.getExtraBinder().registerCallbackListener(r0);     // Catch: RemoteException -> L9 Throwable -> L14
            r4.postToHandler(13, null, null);     // Catch: RemoteException -> L9 Throwable -> L14
        L12:
            monitor-exit(r6);     // Catch: Throwable -> L14
            return;
        L9:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in registerCallback.", e);     // Catch: Throwable -> L14
            goto L12
        L11:
            r4.mIControllerCallback = null;     // Catch: Throwable -> L14
            this.mPendingCallbacks.add(r4);     // Catch: Throwable -> L14
            goto L12
        }

        public final void unregisterCallback(Callback r5) {
            MediaControllerCompatApi21.a(this.mControllerObj, r5.mCallbackObj);
            Object r0 = this.mLock;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.mSessionToken.getExtraBinder() != null) goto L18;
            this.mPendingCallbacks.remove(r5);     // Catch: Throwable -> L15
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L18:
            ExtraCallback r1 = (ExtraCallback) ZeusTransformUtils.preCheckCast(this.mCallbackMap.remove(r5), ExtraCallback.class, "com.obric.aiagent.plugin");     // Catch: RemoteException -> L10 Throwable -> L15
            if (r1 == null) goto L13;
            r5.mIControllerCallback = null;     // Catch: RemoteException -> L10 Throwable -> L15
            this.mSessionToken.getExtraBinder().unregisterCallbackListener(r1);     // Catch: RemoteException -> L10 Throwable -> L15
        L10:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in unregisterCallback.", e);     // Catch: Throwable -> L15
            goto L13
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public boolean dispatchMediaButtonEvent(KeyEvent r1) {
            return MediaControllerCompatApi21.a(this.mControllerObj, r1);
        }

        public c getTransportControls() {
            Object r1 = MediaControllerCompatApi21.a(this.mControllerObj);
            if (r1 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi21(r1);
        }

        public PlaybackStateCompat getPlaybackState() {
            if (this.mSessionToken.getExtraBinder() != null) goto L13;
        L8:
            Object r3 = MediaControllerCompatApi21.b(this.mControllerObj);
            if (r3 != null) goto L15;
            return null;
        L15:
            return PlaybackStateCompat.fromPlaybackState(r3);
        L13:
            return this.mSessionToken.getExtraBinder().getPlaybackState();
        L6:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
            goto L8
        }

        public MediaMetadataCompat getMetadata() {
            Object r0 = MediaControllerCompatApi21.c(this.mControllerObj);
            if (r0 != null) goto L7;
            return null;
        L7:
            return MediaMetadataCompat.fromMediaMetadata(r0);
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<Object> r0 = MediaControllerCompatApi21.d(this.mControllerObj);
            if (r0 != null) goto L7;
            return null;
        L7:
            return MediaSessionCompat.QueueItem.fromQueueItemList(r0);
        }

        public void addQueueItem(MediaDescriptionCompat r5) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r0 = new Bundle();
            r0.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", r5);
            sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", r0, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public void addQueueItem(MediaDescriptionCompat r5, int r6) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r0 = new Bundle();
            r0.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", r5);
            r0.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", r6);
            sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", r0, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public void removeQueueItem(MediaDescriptionCompat r5) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r0 = new Bundle();
            r0.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", r5);
            sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", r0, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.e(this.mControllerObj);
        }

        public Bundle getExtras() {
            return MediaControllerCompatApi21.f(this.mControllerObj);
        }

        public int getRatingType() {
            if (Build.VERSION.SDK_INT >= 22) goto L11;
            if (this.mSessionToken.getExtraBinder() == null) goto L11;
            return this.mSessionToken.getExtraBinder().getRatingType();
        L8:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getRatingType.", e);
        L11:
            return MediaControllerCompatApi21.g(this.mControllerObj);
        }

        public boolean isCaptioningEnabled() {
            if (this.mSessionToken.getExtraBinder() == null) goto L12;
            return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
        L6:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e);
            return false;
        L12:
            return false;
        }

        public int getRepeatMode() {
            if (this.mSessionToken.getExtraBinder() == null) goto L12;
            return this.mSessionToken.getExtraBinder().getRepeatMode();
        L6:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getRepeatMode.", e);
            return -1;
        L12:
            return -1;
        }

        public int getShuffleMode() {
            if (this.mSessionToken.getExtraBinder() == null) goto L12;
            return this.mSessionToken.getExtraBinder().getShuffleMode();
        L6:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getShuffleMode.", e);
            return -1;
        L12:
            return -1;
        }

        public long getFlags() {
            return MediaControllerCompatApi21.h(this.mControllerObj);
        }

        public b getPlaybackInfo() {
            Object r7 = MediaControllerCompatApi21.i(this.mControllerObj);
            if (r7 != null) goto L7;
            return null;
        L7:
            return new b(MediaControllerCompatApi21.b.a(r7), MediaControllerCompatApi21.b.c(r7), MediaControllerCompatApi21.b.d(r7), MediaControllerCompatApi21.b.e(r7), MediaControllerCompatApi21.b.f(r7));
        }

        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.j(this.mControllerObj);
        }

        public void setVolumeTo(int r1, int r2) {
            MediaControllerCompatApi21.a(this.mControllerObj, r1, r2);
        }

        public void adjustVolume(int r1, int r2) {
            MediaControllerCompatApi21.b(this.mControllerObj, r1, r2);
        }

        public void sendCommand(String r1, Bundle r2, ResultReceiver r3) {
            MediaControllerCompatApi21.a(this.mControllerObj, r1, r2, r3);
        }

        public boolean isSessionReady() {
            if (this.mSessionToken.getExtraBinder() == null) goto L5;
            return true;
        L5:
            return false;
        }

        public String getPackageName() {
            return MediaControllerCompatApi21.k(this.mControllerObj);
        }

        public Object getMediaController() {
            return this.mControllerObj;
        }

        private void requestExtraBinder() {
            sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        void processPendingCallbacksLocked() {
            if (this.mSessionToken.getExtraBinder() != null) goto L5;
            return;
        L5:
            Iterator<Callback> r0 = this.mPendingCallbacks.iterator();
        L7:
            if (r0.hasNext() == false) goto L13;
            Callback r1 = (Callback) ZeusTransformUtils.preCheckCast(r0.next(), Callback.class, "com.obric.aiagent.plugin");
            ExtraCallback r2 = new ExtraCallback(r1);
            this.mCallbackMap.put(r1, r2);
            r1.mIControllerCallback = r2;
            this.mSessionToken.getExtraBinder().registerCallbackListener(r2);     // Catch: RemoteException -> L11
            r1.postToHandler(13, null, null);
        L11:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in registerCallback.", e);
        L13:
            this.mPendingCallbacks.clear();
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplApi21_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context r3, MediaSessionCompat.Token r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21
        public c getTransportControls() {
            Object r1 = MediaControllerCompatApi21.a(this.mControllerObj);
            if (r1 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi23(r1);
        }
    }

    static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context r3, MediaSessionCompat.Token r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi23, android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21
        public c getTransportControls() {
            Object r1 = MediaControllerCompatApi21.a(this.mControllerObj);
            if (r1 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi24(r1);
        }
    }

    static class MediaControllerImplBase implements a {
        private IMediaSession mBinder;
        private c mTransportControls;

        public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        public Object getMediaController() {
            return null;
        }

        public boolean isSessionReady() {
            return true;
        }

        public MediaControllerImplBase(MediaSessionCompat.Token r3) {
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) ZeusTransformUtils.preCheckCast(r3.getToken(), IBinder.class, "com.obric.aiagent.plugin"));
        }

        public void registerCallback(Callback r4, Handler r5) {
            if (r4 == null) goto L10;
            this.mBinder.asBinder().linkToDeath(r4, 0);     // Catch: RemoteException -> L6
            this.mBinder.registerCallbackListener((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(r4.mCallbackObj, IMediaControllerCallback.class, "com.obric.aiagent.plugin"));     // Catch: RemoteException -> L6
            r4.postToHandler(13, null, null);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in registerCallback.", e);
            r4.postToHandler(8, null, null);
            return;
        L10:
            throw new IllegalArgumentException("callback may not be null.");
        }

        public void unregisterCallback(Callback r5) {
            if (r5 == null) goto L9;
            this.mBinder.unregisterCallbackListener((IMediaControllerCallback) ZeusTransformUtils.preCheckCast(r5.mCallbackObj, IMediaControllerCallback.class, "com.obric.aiagent.plugin"));     // Catch: RemoteException -> L5
            this.mBinder.asBinder().unlinkToDeath(r5, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in unregisterCallback.", e);
            return;
        L9:
            throw new IllegalArgumentException("callback may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public boolean dispatchMediaButtonEvent(KeyEvent r2) {
            if (r2 == null) goto L10;
            this.mBinder.sendMediaButton(r2);     // Catch: RemoteException -> L5
            return false;
        L5:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e);
            return false;
        L10:
            throw new IllegalArgumentException("event may not be null.");
        }

        public c getTransportControls() {
            if (this.mTransportControls != null) goto L6;
            this.mTransportControls = new TransportControlsBase(this.mBinder);
        L6:
            return this.mTransportControls;
        }

        public PlaybackStateCompat getPlaybackState() {
            return this.mBinder.getPlaybackState();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
            return null;
        }

        public MediaMetadataCompat getMetadata() {
            return this.mBinder.getMetadata();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getMetadata.", e);
            return null;
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            return this.mBinder.getQueue();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getQueue.", e);
            return null;
        }

        public void addQueueItem(MediaDescriptionCompat r5) {
        L7:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in addQueueItem.", e);
            return;
        L3:
            if ((this.mBinder.getFlags() & 4) == 0) goto L6;
            this.mBinder.addQueueItem(r5);     // Catch: RemoteException -> L7
            return;
        L6:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L7
        }

        public void addQueueItem(MediaDescriptionCompat r5, int r6) {
        L7:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in addQueueItemAt.", e);
            return;
        L3:
            if ((this.mBinder.getFlags() & 4) == 0) goto L6;
            this.mBinder.addQueueItemAt(r5, r6);     // Catch: RemoteException -> L7
            return;
        L6:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L7
        }

        public void removeQueueItem(MediaDescriptionCompat r5) {
        L7:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in removeQueueItem.", e);
            return;
        L3:
            if ((this.mBinder.getFlags() & 4) == 0) goto L6;
            this.mBinder.removeQueueItem(r5);     // Catch: RemoteException -> L7
            return;
        L6:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L7
        }

        public CharSequence getQueueTitle() {
            return this.mBinder.getQueueTitle();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getQueueTitle.", e);
            return null;
        }

        public Bundle getExtras() {
            return this.mBinder.getExtras();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getExtras.", e);
            return null;
        }

        public int getRatingType() {
            return this.mBinder.getRatingType();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getRatingType.", e);
            return 0;
        }

        public boolean isCaptioningEnabled() {
            return this.mBinder.isCaptioningEnabled();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e);
            return false;
        }

        public int getRepeatMode() {
            return this.mBinder.getRepeatMode();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getRepeatMode.", e);
            return -1;
        }

        public int getShuffleMode() {
            return this.mBinder.getShuffleMode();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getShuffleMode.", e);
            return -1;
        }

        public long getFlags() {
            return this.mBinder.getFlags();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getFlags.", e);
            return 0;
        }

        public b getPlaybackInfo() {
            ParcelableVolumeInfo r7 = this.mBinder.getVolumeAttributes();     // Catch: RemoteException -> L4
            return new b(r7.volumeType, r7.audioStream, r7.controlType, r7.maxVolume, r7.currentVolume);
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getPlaybackInfo.", e);
            return null;
        }

        public PendingIntent getSessionActivity() {
            return this.mBinder.getLaunchPendingIntent();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getSessionActivity.", e);
            return null;
        }

        public void setVolumeTo(int r2, int r3) {
            this.mBinder.setVolumeTo(r2, r3, null);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in setVolumeTo.", e);
        }

        public void adjustVolume(int r2, int r3) {
            this.mBinder.adjustVolume(r2, r3, null);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in adjustVolume.", e);
        }

        public void sendCommand(String r2, Bundle r3, ResultReceiver r4) {
            this.mBinder.sendCommand(r2, r3, new MediaSessionCompat.ResultReceiverWrapper(r4));     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in sendCommand.", e);
        }

        public String getPackageName() {
            return this.mBinder.getPackageName();
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in getPackageName.", e);
            return null;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$MediaControllerImplBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    static class TransportControlsApi21 extends c {
        protected final Object mControlsObj;

        public TransportControlsApi21(Object r1) {
            this.mControlsObj = r1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void prepare() {
            sendCustomAction("android.support.v4.media.session.action.PREPARE", null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void prepareFromMediaId(String r3, Bundle r4) {
            Bundle r0 = new Bundle();
            r0.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", r3);
            r0.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", r4);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void prepareFromSearch(String r3, Bundle r4) {
            Bundle r0 = new Bundle();
            r0.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", r3);
            r0.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", r4);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void prepareFromUri(Uri r3, Bundle r4) {
            Bundle r0 = new Bundle();
            r0.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", r3);
            r0.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", r4);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void play() {
            MediaControllerCompatApi21.c.a(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void pause() {
            MediaControllerCompatApi21.c.b(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void stop() {
            MediaControllerCompatApi21.c.c(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void seekTo(long r1) {
            MediaControllerCompatApi21.c.a(this.mControlsObj, r1);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void fastForward() {
            MediaControllerCompatApi21.c.d(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void rewind() {
            MediaControllerCompatApi21.c.e(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void skipToNext() {
            MediaControllerCompatApi21.c.f(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void skipToPrevious() {
            MediaControllerCompatApi21.c.g(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void setRating(RatingCompat r1) {
            Object r0 = this.mControlsObj;
            if (r1 == null) goto L5;
            Object r2 = r1.getRating();
        L6:
            MediaControllerCompatApi21.c.a(r0, r2);
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void setRating(RatingCompat r3, Bundle r4) {
            Bundle r0 = new Bundle();
            r0.putParcelable("android.support.v4.media.session.action.ARGUMENT_RATING", r3);
            r0.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", r4);
            sendCustomAction("android.support.v4.media.session.action.SET_RATING", r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void setCaptioningEnabled(boolean r3) {
            Bundle r0 = new Bundle();
            r0.putBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED", r3);
            sendCustomAction("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED", r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void setRepeatMode(int r3) {
            Bundle r0 = new Bundle();
            r0.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", r3);
            sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void setShuffleMode(int r3) {
            Bundle r0 = new Bundle();
            r0.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", r3);
            sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE", r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void playFromMediaId(String r1, Bundle r2) {
            MediaControllerCompatApi21.c.a(this.mControlsObj, r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void playFromSearch(String r1, Bundle r2) {
            MediaControllerCompatApi21.c.b(this.mControlsObj, r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void playFromUri(Uri r3, Bundle r4) {
            if (r3 == null) goto L8;
            if (Uri.EMPTY.equals(r3) == true) goto L8;
            Bundle r0 = new Bundle();
            r0.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", r3);
            r0.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", r4);
            sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", r0);
            return;
        L8:
            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void skipToQueueItem(long r1) {
            MediaControllerCompatApi21.c.b(this.mControlsObj, r1);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void sendCustomAction(PlaybackStateCompat.CustomAction r2, Bundle r3) {
            MediaControllerCompat.a(r2.getAction(), r3);
            MediaControllerCompatApi21.c.c(this.mControlsObj, r2.getAction(), r3);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void sendCustomAction(String r1, Bundle r2) {
            MediaControllerCompat.a(r1, r2);
            MediaControllerCompatApi21.c.c(this.mControlsObj, r1, r2);
        }
    }

    static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object r1) {
            super(r1);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.c
        public void playFromUri(Uri r1, Bundle r2) {
            android.support.v4.media.session.a.C0001a.a(this.mControlsObj, r1, r2);
        }
    }

    static class TransportControlsApi24 extends TransportControlsApi23 {
        public TransportControlsApi24(Object r1) {
            super(r1);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.c
        public void prepare() {
            android.support.v4.media.session.b.a.a(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.c
        public void prepareFromMediaId(String r1, Bundle r2) {
            android.support.v4.media.session.b.a.a(this.mControlsObj, r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.c
        public void prepareFromSearch(String r1, Bundle r2) {
            android.support.v4.media.session.b.a.b(this.mControlsObj, r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.c
        public void prepareFromUri(Uri r1, Bundle r2) {
            android.support.v4.media.session.b.a.a(this.mControlsObj, r1, r2);
        }
    }

    static class TransportControlsBase extends c {
        private IMediaSession mBinder;

        public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        public TransportControlsBase(IMediaSession r3) {
            this.mBinder = (IMediaSession) ZeusTransformUtils.wrapperContextForParams(r3, IMediaSession.class, "com.obric.aiagent.plugin");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void prepare() {
            this.mBinder.prepare();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in prepare.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void prepareFromMediaId(String r1, Bundle r2) {
            this.mBinder.prepareFromMediaId(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in prepareFromMediaId.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void prepareFromSearch(String r1, Bundle r2) {
            this.mBinder.prepareFromSearch(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in prepareFromSearch.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void prepareFromUri(Uri r1, Bundle r2) {
            this.mBinder.prepareFromUri(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in prepareFromUri.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void play() {
            this.mBinder.play();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in play.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void playFromMediaId(String r1, Bundle r2) {
            this.mBinder.playFromMediaId(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in playFromMediaId.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void playFromSearch(String r1, Bundle r2) {
            this.mBinder.playFromSearch(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in playFromSearch.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void playFromUri(Uri r1, Bundle r2) {
            this.mBinder.playFromUri(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in playFromUri.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void skipToQueueItem(long r1) {
            this.mBinder.skipToQueueItem(r1);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in skipToQueueItem.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void pause() {
            this.mBinder.pause();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in pause.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void stop() {
            this.mBinder.stop();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in stop.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void seekTo(long r1) {
            this.mBinder.seekTo(r1);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in seekTo.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void fastForward() {
            this.mBinder.fastForward();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in fastForward.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void skipToNext() {
            this.mBinder.next();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in skipToNext.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void rewind() {
            this.mBinder.rewind();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in rewind.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void skipToPrevious() {
            this.mBinder.previous();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in skipToPrevious.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void setRating(RatingCompat r2) {
            this.mBinder.rate(r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in setRating.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void setRating(RatingCompat r1, Bundle r2) {
            this.mBinder.rateWithExtras(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in setRating.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void setCaptioningEnabled(boolean r2) {
            this.mBinder.setCaptioningEnabled(r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in setCaptioningEnabled.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void setRepeatMode(int r2) {
            this.mBinder.setRepeatMode(r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in setRepeatMode.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void setShuffleMode(int r2) {
            this.mBinder.setShuffleMode(r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in setShuffleMode.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void sendCustomAction(PlaybackStateCompat.CustomAction r1, Bundle r2) {
            sendCustomAction(r1.getAction(), r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void sendCustomAction(String r1, Bundle r2) {
            MediaControllerCompat.a(r1, r2);
            this.mBinder.sendCustomAction(r1, r2);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("MediaControllerCompat", "Dead object in sendCustomAction.", e);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_android_support_v4_media_session_MediaControllerCompat$TransportControlsBase_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    interface a {
        boolean dispatchMediaButtonEvent(KeyEvent r1);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f71a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f72b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f73c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f74d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f75e;

        b(int r1, int r2, int r3, int r4, int r5) {
            this.f71a = r1;
            this.f72b = r2;
            this.f73c = r3;
            this.f74d = r4;
            this.f75e = r5;
        }
    }

    public static abstract class c {
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String r1, Bundle r2);

        public abstract void playFromSearch(String r1, Bundle r2);

        public abstract void playFromUri(Uri r1, Bundle r2);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String r1, Bundle r2);

        public abstract void prepareFromSearch(String r1, Bundle r2);

        public abstract void prepareFromUri(Uri r1, Bundle r2);

        public abstract void rewind();

        public abstract void seekTo(long r1);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction r1, Bundle r2);

        public abstract void sendCustomAction(String r1, Bundle r2);

        public abstract void setCaptioningEnabled(boolean r1);

        public abstract void setRating(RatingCompat r1);

        public abstract void setRating(RatingCompat r1, Bundle r2);

        public abstract void setRepeatMode(int r1);

        public abstract void setShuffleMode(int r1);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long r1);

        public abstract void stop();

        c() {
        }
    }

    static void a(String r2, Bundle r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.hashCode();
        if (r2.equals("android.support.v4.media.session.action.FOLLOW") == false) goto L7;
    L9:
        if (r3 == null) goto L14;
        if (r3.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE") == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + r2 + ".");
    L7:
        if (r2.equals("android.support.v4.media.session.action.UNFOLLOW") == true) goto L9;
    }

    public MediaControllerCompat(Context r3, MediaSessionCompat.Token r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f70c = new HashSet();
        if (r4 == null) goto L16;
        this.f69b = r4;
        if (Build.VERSION.SDK_INT < 24) goto L8;
        this.f68a = new MediaControllerImplApi24(r5, r4);
        return;
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        this.f68a = new MediaControllerImplApi23(r5, r4);
        return;
    L11:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        this.f68a = new MediaControllerImplApi21(r5, r4);
        return;
    L13:
        this.f68a = new MediaControllerImplBase(r4);
        return;
    L16:
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public boolean a(KeyEvent r1) {
        if (r1 == null) goto L6;
        return this.f68a.dispatchMediaButtonEvent(r1);
    L6:
        throw new IllegalArgumentException("KeyEvent may not be null");
    }
}
