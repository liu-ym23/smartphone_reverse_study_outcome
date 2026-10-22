package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompatApi21 {

    static class CallbackProxy<T extends a> extends MediaController.Callback {
        protected final T mCallback;

        public CallbackProxy(T r3) {
            this.mCallback = (T) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.mCallback.onSessionDestroyed();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String r1, Bundle r2) {
            MediaSessionCompat.a(r2);
            this.mCallback.onSessionEvent(r1, r2);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState r1) {
            this.mCallback.onPlaybackStateChanged(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata r1) {
            this.mCallback.onMetadataChanged(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> r3) {
            List<?> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            this.mCallback.onQueueChanged(r4);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            this.mCallback.onQueueTitleChanged(r4);
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle r1) {
            MediaSessionCompat.a(r1);
            this.mCallback.onExtrasChanged(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo r7) {
            this.mCallback.onAudioInfoChanged(r7.getPlaybackType(), b.c(r7), r7.getVolumeControl(), r7.getMaxVolume(), r7.getCurrentVolume());
        }
    }

    public interface a {
        void onAudioInfoChanged(int r1, int r2, int r3, int r4, int r5);

        void onExtrasChanged(Bundle r1);

        void onMetadataChanged(Object r1);

        void onPlaybackStateChanged(Object r1);

        void onQueueChanged(List<?> r1);

        void onQueueTitleChanged(CharSequence r1);

        void onSessionDestroyed();

        void onSessionEvent(String r1, Bundle r2);
    }

    public static class b {
        public static int a(Object r2) {
            return ((MediaController.PlaybackInfo) ZeusTransformUtils.preCheckCast(r2, MediaController.PlaybackInfo.class, "com.obric.aiagent.plugin")).getPlaybackType();
        }

        public static AudioAttributes b(Object r2) {
            return ((MediaController.PlaybackInfo) ZeusTransformUtils.preCheckCast(r2, MediaController.PlaybackInfo.class, "com.obric.aiagent.plugin")).getAudioAttributes();
        }

        public static int c(Object r0) {
            return a(b(r0));
        }

        public static int d(Object r2) {
            return ((MediaController.PlaybackInfo) ZeusTransformUtils.preCheckCast(r2, MediaController.PlaybackInfo.class, "com.obric.aiagent.plugin")).getVolumeControl();
        }

        public static int e(Object r2) {
            return ((MediaController.PlaybackInfo) ZeusTransformUtils.preCheckCast(r2, MediaController.PlaybackInfo.class, "com.obric.aiagent.plugin")).getMaxVolume();
        }

        public static int f(Object r2) {
            return ((MediaController.PlaybackInfo) ZeusTransformUtils.preCheckCast(r2, MediaController.PlaybackInfo.class, "com.obric.aiagent.plugin")).getCurrentVolume();
        }

        private static int a(AudioAttributes r3) {
            if ((r3.getFlags() & 1) != 1) goto L7;
            return 7;
        L7:
            if ((r3.getFlags() & 4) != 4) goto L10;
            return 6;
        L10:
            int r4 = r3.getUsage();
            if (r4 == 13) goto L24;
            switch(r4) {
                case 2: goto L22;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L15;
                case 7: goto L17;
                case 8: goto L17;
                case 9: goto L17;
                case 10: goto L17;
                default: goto L13;
            };
        L13:
            return 3;
        L15:
            return 2;
        L17:
            return 5;
        L19:
            return 4;
        L20:
            return 8;
        L22:
            return 0;
        L24:
            return 1;
        }
    }

    public static class c {
        public static void a(Object r2) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).play();
        }

        public static void b(Object r2) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).pause();
        }

        public static void c(Object r2) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).stop();
        }

        public static void a(Object r2, long r3) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).seekTo(r3);
        }

        public static void d(Object r2) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).fastForward();
        }

        public static void e(Object r2) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).rewind();
        }

        public static void f(Object r2) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).skipToNext();
        }

        public static void g(Object r2) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).skipToPrevious();
        }

        public static void a(Object r2, Object r3) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).setRating((Rating) ZeusTransformUtils.preCheckCast(r3, Rating.class, "com.obric.aiagent.plugin"));
        }

        public static void a(Object r2, String r3, Bundle r4) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).playFromMediaId(r3, r4);
        }

        public static void b(Object r2, String r3, Bundle r4) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).playFromSearch(r3, r4);
        }

        public static void b(Object r2, long r3) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).skipToQueueItem(r3);
        }

        public static void c(Object r2, String r3, Bundle r4) {
            ((MediaController.TransportControls) ZeusTransformUtils.preCheckCast(r2, MediaController.TransportControls.class, "com.obric.aiagent.plugin")).sendCustomAction(r3, r4);
        }
    }

    public static Object a(Context r3, Object r4) {
        return new MediaController((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (MediaSession.Token) ZeusTransformUtils.preCheckCast(r4, MediaSession.Token.class, "com.obric.aiagent.plugin"));
    }

    public static Object a(a r2) {
        return new CallbackProxy((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin"));
    }

    public static void a(Object r2, Object r3, Handler r4) {
        ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).registerCallback((MediaController.Callback) ZeusTransformUtils.preCheckCast(r3, MediaController.Callback.class, "com.obric.aiagent.plugin"), r4);
    }

    public static void a(Object r2, Object r3) {
        ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).unregisterCallback((MediaController.Callback) ZeusTransformUtils.preCheckCast(r3, MediaController.Callback.class, "com.obric.aiagent.plugin"));
    }

    public static Object a(Object r2) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getTransportControls();
    }

    public static Object b(Object r2) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getPlaybackState();
    }

    public static Object c(Object r2) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getMetadata();
    }

    public static List<Object> d(Object r2) {
        List<MediaSession.QueueItem> r3 = ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getQueue();
        if (r3 != null) goto L7;
        return null;
    L7:
        return new ArrayList(r3);
    }

    public static CharSequence e(Object r2) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getQueueTitle();
    }

    public static Bundle f(Object r2) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getExtras();
    }

    public static int g(Object r2) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getRatingType();
    }

    public static long h(Object r2) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getFlags();
    }

    public static Object i(Object r2) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getPlaybackInfo();
    }

    public static PendingIntent j(Object r2) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getSessionActivity();
    }

    public static boolean a(Object r2, KeyEvent r3) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).dispatchMediaButtonEvent(r3);
    }

    public static void a(Object r2, int r3, int r4) {
        ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).setVolumeTo(r3, r4);
    }

    public static void b(Object r2, int r3, int r4) {
        ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).adjustVolume(r3, r4);
    }

    public static void a(Object r2, String r3, Bundle r4, ResultReceiver r5) {
        ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).sendCommand(r3, r4, r5);
    }

    public static String k(Object r2) {
        return ((MediaController) ZeusTransformUtils.preCheckCast(r2, MediaController.class, "com.obric.aiagent.plugin")).getPackageName();
    }
}
