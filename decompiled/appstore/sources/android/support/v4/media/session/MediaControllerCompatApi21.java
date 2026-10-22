package android.support.v4.media.session;

import android.app.Activity;
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
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaControllerCompatApi21 {

    public interface Callback {
        void onAudioInfoChanged(int r10, int r11, int r12, int r13, int r14);

        void onExtrasChanged(Bundle r10);

        void onMetadataChanged(Object r10);

        void onPlaybackStateChanged(Object r10);

        void onQueueChanged(List<?> r10);

        void onQueueTitleChanged(CharSequence r10);

        void onSessionDestroyed();

        void onSessionEvent(String r10, Bundle r11);
    }

    public static class CallbackProxy<T extends Callback> extends MediaController.Callback {
        protected final T mCallback;

        public CallbackProxy(T r10) {
            this.mCallback = r10;
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo r10) {
            this.mCallback.onAudioInfoChanged(r10.getPlaybackType(), PlaybackInfo.getLegacyAudioStream(r10), r10.getVolumeControl(), r10.getMaxVolume(), r10.getCurrentVolume());
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle r10) {
            MediaSessionCompat.ensureClassLoader(r10);
            this.mCallback.onExtrasChanged(r10);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata r10) {
            this.mCallback.onMetadataChanged(r10);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState r10) {
            this.mCallback.onPlaybackStateChanged(r10);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> r10) {
            this.mCallback.onQueueChanged(r10);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence r10) {
            this.mCallback.onQueueTitleChanged(r10);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.mCallback.onSessionDestroyed();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String r10, Bundle r11) {
            MediaSessionCompat.ensureClassLoader(r11);
            this.mCallback.onSessionEvent(r10, r11);
        }
    }

    public static class PlaybackInfo {
        private static final int FLAG_SCO = 4;
        private static final int STREAM_BLUETOOTH_SCO = 6;
        private static final int STREAM_SYSTEM_ENFORCED = 7;

        private PlaybackInfo() {
        }

        public static AudioAttributes getAudioAttributes(Object r10) {
            return ((MediaController.PlaybackInfo) r10).getAudioAttributes();
        }

        public static int getCurrentVolume(Object r10) {
            return ((MediaController.PlaybackInfo) r10).getCurrentVolume();
        }

        public static int getLegacyAudioStream(Object r10) {
            return toLegacyStreamType(getAudioAttributes(r10));
        }

        public static int getMaxVolume(Object r10) {
            return ((MediaController.PlaybackInfo) r10).getMaxVolume();
        }

        public static int getPlaybackType(Object r10) {
            return ((MediaController.PlaybackInfo) r10).getPlaybackType();
        }

        public static int getVolumeControl(Object r10) {
            return ((MediaController.PlaybackInfo) r10).getVolumeControl();
        }

        private static int toLegacyStreamType(AudioAttributes r10) {
            if ((r10.getFlags() & 1) != 1) goto L7;
            return 7;
        L7:
            if ((r10.getFlags() & 4) != 4) goto L10;
            return 6;
        L10:
            int r11 = r10.getUsage();
            if (r11 == 13) goto L24;
            switch(r11) {
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

    public static class TransportControls {
        private TransportControls() {
        }

        public static void fastForward(Object r10) {
            ((MediaController.TransportControls) r10).fastForward();
        }

        public static void pause(Object r10) {
            ((MediaController.TransportControls) r10).pause();
        }

        public static void play(Object r10) {
            ((MediaController.TransportControls) r10).play();
        }

        public static void playFromMediaId(Object r10, String r11, Bundle r12) {
            ((MediaController.TransportControls) r10).playFromMediaId(r11, r12);
        }

        public static void playFromSearch(Object r10, String r11, Bundle r12) {
            ((MediaController.TransportControls) r10).playFromSearch(r11, r12);
        }

        public static void rewind(Object r10) {
            ((MediaController.TransportControls) r10).rewind();
        }

        public static void seekTo(Object r10, long r11) {
            ((MediaController.TransportControls) r10).seekTo(r11);
        }

        public static void sendCustomAction(Object r10, String r11, Bundle r12) {
            ((MediaController.TransportControls) r10).sendCustomAction(r11, r12);
        }

        public static void setRating(Object r10, Object r11) {
            ((MediaController.TransportControls) r10).setRating((Rating) r11);
        }

        public static void skipToNext(Object r10) {
            ((MediaController.TransportControls) r10).skipToNext();
        }

        public static void skipToPrevious(Object r10) {
            ((MediaController.TransportControls) r10).skipToPrevious();
        }

        public static void skipToQueueItem(Object r10, long r11) {
            ((MediaController.TransportControls) r10).skipToQueueItem(r11);
        }

        public static void stop(Object r10) {
            ((MediaController.TransportControls) r10).stop();
        }
    }

    private MediaControllerCompatApi21() {
    }

    public static void adjustVolume(Object r10, int r11, int r12) {
        ((MediaController) r10).adjustVolume(r11, r12);
    }

    public static Object createCallback(Callback r10) {
        return new CallbackProxy(r10);
    }

    public static boolean dispatchMediaButtonEvent(Object r10, KeyEvent r11) {
        return ((MediaController) r10).dispatchMediaButtonEvent(r11);
    }

    public static Object fromToken(Context r10, Object r11) {
        return new MediaController(r10, (MediaSession.Token) r11);
    }

    public static Bundle getExtras(Object r10) {
        return ((MediaController) r10).getExtras();
    }

    public static long getFlags(Object r10) {
        return ((MediaController) r10).getFlags();
    }

    public static Object getMediaController(Activity r10) {
        return r10.getMediaController();
    }

    public static Object getMetadata(Object r10) {
        return ((MediaController) r10).getMetadata();
    }

    public static String getPackageName(Object r10) {
        return ((MediaController) r10).getPackageName();
    }

    public static Object getPlaybackInfo(Object r10) {
        return ((MediaController) r10).getPlaybackInfo();
    }

    public static Object getPlaybackState(Object r10) {
        return ((MediaController) r10).getPlaybackState();
    }

    public static List<Object> getQueue(Object r10) {
        List<MediaSession.QueueItem> r11 = ((MediaController) r10).getQueue();
        if (r11 != null) goto L7;
        return null;
    L7:
        return new ArrayList(r11);
    }

    public static CharSequence getQueueTitle(Object r10) {
        return ((MediaController) r10).getQueueTitle();
    }

    public static int getRatingType(Object r10) {
        return ((MediaController) r10).getRatingType();
    }

    public static PendingIntent getSessionActivity(Object r10) {
        return ((MediaController) r10).getSessionActivity();
    }

    public static Object getSessionToken(Object r10) {
        return ((MediaController) r10).getSessionToken();
    }

    public static Object getTransportControls(Object r10) {
        return ((MediaController) r10).getTransportControls();
    }

    public static void registerCallback(Object r10, Object r11, Handler r12) {
        ((MediaController) r10).registerCallback((MediaController.Callback) r11, r12);
    }

    public static void sendCommand(Object r10, String r11, Bundle r12, ResultReceiver r13) {
        ((MediaController) r10).sendCommand(r11, r12, r13);
    }

    public static void setMediaController(Activity r10, Object r11) {
        r10.setMediaController((MediaController) r11);
    }

    public static void setVolumeTo(Object r10, int r11, int r12) {
        ((MediaController) r10).setVolumeTo(r11, r12);
    }

    public static void unregisterCallback(Object r10, Object r11) {
        ((MediaController) r10).unregisterCallback((MediaController.Callback) r11);
    }
}
