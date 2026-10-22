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
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class MediaControllerCompatApi21 {

    public interface Callback {
        void onAudioInfoChanged(int r100, int r101, int r102, int r103, int r104);

        void onExtrasChanged(Bundle r100);

        void onMetadataChanged(Object r100);

        void onPlaybackStateChanged(Object r100);

        void onQueueChanged(List<?> r100);

        void onQueueTitleChanged(CharSequence r100);

        void onSessionDestroyed();

        void onSessionEvent(String r100, Bundle r101);
    }

    public static class CallbackProxy<T extends Callback> extends MediaController.Callback {
        protected final T mCallback;

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.mCallback.onSessionDestroyed();
        }

        public CallbackProxy(T r100) {
            this.mCallback = r100;
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo r100) {
            this.mCallback.onAudioInfoChanged(r100.getPlaybackType(), PlaybackInfo.getLegacyAudioStream(r100), r100.getVolumeControl(), r100.getMaxVolume(), r100.getCurrentVolume());
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle r100) {
            MediaSessionCompat.ensureClassLoader(r100);
            this.mCallback.onExtrasChanged(r100);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata r100) {
            this.mCallback.onMetadataChanged(r100);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState r100) {
            this.mCallback.onPlaybackStateChanged(r100);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> r100) {
            this.mCallback.onQueueChanged(r100);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence r100) {
            this.mCallback.onQueueTitleChanged(r100);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String r100, Bundle r101) {
            MediaSessionCompat.ensureClassLoader(r101);
            this.mCallback.onSessionEvent(r100, r101);
        }
    }

    public static class PlaybackInfo {
        private static final int FLAG_SCO = 4;
        private static final int STREAM_BLUETOOTH_SCO = 6;
        private static final int STREAM_SYSTEM_ENFORCED = 7;

        private PlaybackInfo() {
        }

        public static AudioAttributes getAudioAttributes(Object r100) {
            return ((MediaController.PlaybackInfo) r100).getAudioAttributes();
        }

        public static int getCurrentVolume(Object r100) {
            return ((MediaController.PlaybackInfo) r100).getCurrentVolume();
        }

        public static int getLegacyAudioStream(Object r100) {
            return toLegacyStreamType(getAudioAttributes(r100));
        }

        public static int getMaxVolume(Object r100) {
            return ((MediaController.PlaybackInfo) r100).getMaxVolume();
        }

        public static int getPlaybackType(Object r100) {
            return ((MediaController.PlaybackInfo) r100).getPlaybackType();
        }

        public static int getVolumeControl(Object r100) {
            return ((MediaController.PlaybackInfo) r100).getVolumeControl();
        }

        private static int toLegacyStreamType(AudioAttributes r100) {
            if ((r100.getFlags() & 1) != 1) goto L7;
            return 7;
        L7:
            if ((r100.getFlags() & 4) != 4) goto L10;
            return 6;
        L10:
            int r101 = r100.getUsage();
            if (r101 == 13) goto L24;
            switch(r101) {
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

        public static void fastForward(Object r100) {
            ((MediaController.TransportControls) r100).fastForward();
        }

        public static void pause(Object r100) {
            ((MediaController.TransportControls) r100).pause();
        }

        public static void play(Object r100) {
            ((MediaController.TransportControls) r100).play();
        }

        public static void rewind(Object r100) {
            ((MediaController.TransportControls) r100).rewind();
        }

        public static void skipToNext(Object r100) {
            ((MediaController.TransportControls) r100).skipToNext();
        }

        public static void skipToPrevious(Object r100) {
            ((MediaController.TransportControls) r100).skipToPrevious();
        }

        public static void stop(Object r100) {
            ((MediaController.TransportControls) r100).stop();
        }

        public static void seekTo(Object r100, long r101) {
            ((MediaController.TransportControls) r100).seekTo(r101);
        }

        public static void setRating(Object r100, Object r101) {
            ((MediaController.TransportControls) r100).setRating((Rating) r101);
        }

        public static void skipToQueueItem(Object r100, long r101) {
            ((MediaController.TransportControls) r100).skipToQueueItem(r101);
        }

        public static void playFromMediaId(Object r100, String r101, Bundle r102) {
            ((MediaController.TransportControls) r100).playFromMediaId(r101, r102);
        }

        public static void playFromSearch(Object r100, String r101, Bundle r102) {
            ((MediaController.TransportControls) r100).playFromSearch(r101, r102);
        }

        public static void sendCustomAction(Object r100, String r101, Bundle r102) {
            ((MediaController.TransportControls) r100).sendCustomAction(r101, r102);
        }
    }

    private MediaControllerCompatApi21() {
    }

    public static Object createCallback(Callback r100) {
        return new CallbackProxy(r100);
    }

    public static Bundle getExtras(Object r100) {
        return ((MediaController) r100).getExtras();
    }

    public static long getFlags(Object r100) {
        return ((MediaController) r100).getFlags();
    }

    public static Object getMediaController(Activity r100) {
        return r100.getMediaController();
    }

    public static Object getMetadata(Object r100) {
        return ((MediaController) r100).getMetadata();
    }

    public static String getPackageName(Object r100) {
        return ((MediaController) r100).getPackageName();
    }

    public static Object getPlaybackInfo(Object r100) {
        return ((MediaController) r100).getPlaybackInfo();
    }

    public static Object getPlaybackState(Object r100) {
        return ((MediaController) r100).getPlaybackState();
    }

    public static List<Object> getQueue(Object r100) {
        List<MediaSession.QueueItem> r101 = ((MediaController) r100).getQueue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return new ArrayList(r101);
    }

    public static CharSequence getQueueTitle(Object r100) {
        return ((MediaController) r100).getQueueTitle();
    }

    public static int getRatingType(Object r100) {
        return ((MediaController) r100).getRatingType();
    }

    public static PendingIntent getSessionActivity(Object r100) {
        return ((MediaController) r100).getSessionActivity();
    }

    public static Object getSessionToken(Object r100) {
        return ((MediaController) r100).getSessionToken();
    }

    public static Object getTransportControls(Object r100) {
        return ((MediaController) r100).getTransportControls();
    }

    public static boolean dispatchMediaButtonEvent(Object r100, KeyEvent r101) {
        return ((MediaController) r100).dispatchMediaButtonEvent(r101);
    }

    public static Object fromToken(Context r100, Object r101) {
        return new MediaController(r100, (MediaSession.Token) r101);
    }

    public static void setMediaController(Activity r100, Object r101) {
        r100.setMediaController((MediaController) r101);
    }

    public static void unregisterCallback(Object r100, Object r101) {
        ((MediaController) r100).unregisterCallback((MediaController.Callback) r101);
    }

    public static void adjustVolume(Object r100, int r101, int r102) {
        ((MediaController) r100).adjustVolume(r101, r102);
    }

    public static void registerCallback(Object r100, Object r101, Handler r102) {
        ((MediaController) r100).registerCallback((MediaController.Callback) r101, r102);
    }

    public static void setVolumeTo(Object r100, int r101, int r102) {
        ((MediaController) r100).setVolumeTo(r101, r102);
    }

    public static void sendCommand(Object r100, String r101, Bundle r102, ResultReceiver r103) {
        ((MediaController) r100).sendCommand(r101, r102, r103);
    }
}
