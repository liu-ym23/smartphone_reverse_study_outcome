package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaSessionCompatApi21 {
    static final String TAG = "MediaSessionCompatApi21";

    public interface Callback {
        void onCommand(String r10, Bundle r11, ResultReceiver r12);

        void onCustomAction(String r10, Bundle r11);

        void onFastForward();

        boolean onMediaButtonEvent(Intent r10);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String r10, Bundle r11);

        void onPlayFromSearch(String r10, Bundle r11);

        void onRewind();

        void onSeekTo(long r10);

        void onSetRating(Object r10);

        void onSetRating(Object r10, Bundle r11);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long r10);

        void onStop();
    }

    public static class CallbackProxy<T extends Callback> extends MediaSession.Callback {
        protected final T mCallback;

        public CallbackProxy(T r10) {
            this.mCallback = r10;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(String r10, Bundle r11, ResultReceiver r12) {
            MediaSessionCompat.ensureClassLoader(r11);
            this.mCallback.onCommand(r10, r11, r12);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(String r10, Bundle r11) {
            MediaSessionCompat.ensureClassLoader(r11);
            this.mCallback.onCustomAction(r10, r11);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            this.mCallback.onFastForward();
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent r10) {
            if (this.mCallback.onMediaButtonEvent(r10) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.onMediaButtonEvent(r10) == true) goto L8;
            return false;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            this.mCallback.onPause();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            this.mCallback.onPlay();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String r10, Bundle r11) {
            MediaSessionCompat.ensureClassLoader(r11);
            this.mCallback.onPlayFromMediaId(r10, r11);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String r10, Bundle r11) {
            MediaSessionCompat.ensureClassLoader(r11);
            this.mCallback.onPlayFromSearch(r10, r11);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            this.mCallback.onRewind();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long r10) {
            this.mCallback.onSeekTo(r10);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating r10) {
            this.mCallback.onSetRating(r10);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            this.mCallback.onSkipToNext();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            this.mCallback.onSkipToPrevious();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long r10) {
            this.mCallback.onSkipToQueueItem(r10);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            this.mCallback.onStop();
        }
    }

    public static class QueueItem {
        private QueueItem() {
        }

        public static Object createItem(Object r10, long r11) {
            return new MediaSession.QueueItem((MediaDescription) r10, r11);
        }

        public static Object getDescription(Object r10) {
            return ((MediaSession.QueueItem) r10).getDescription();
        }

        public static long getQueueId(Object r10) {
            return ((MediaSession.QueueItem) r10).getQueueId();
        }
    }

    private MediaSessionCompatApi21() {
    }

    public static Object createCallback(Callback r10) {
        return new CallbackProxy(r10);
    }

    public static Object createSession(Context r10, String r11) {
        return new MediaSession(r10, r11);
    }

    public static Parcelable getSessionToken(Object r10) {
        return ((MediaSession) r10).getSessionToken();
    }

    public static boolean hasCallback(Object r10) {
        Field r11 = r10.getClass().getDeclaredField("mCallback");     // Catch: Throwable -> L9
        if (r11 == null) goto L10;
        r11.setAccessible(true);     // Catch: Throwable -> L9
        if (r11.get(r10) != null) goto L8;
        return false;
    L8:
        return true;
    L10:
        return false;
    L9:
        Log.w(TAG, "Failed to get mCallback object.");
        goto L10
    }

    public static boolean isActive(Object r10) {
        return ((MediaSession) r10).isActive();
    }

    public static void release(Object r10) {
        ((MediaSession) r10).release();
    }

    public static void sendSessionEvent(Object r10, String r11, Bundle r12) {
        ((MediaSession) r10).sendSessionEvent(r11, r12);
    }

    public static void setActive(Object r10, boolean r11) {
        ((MediaSession) r10).setActive(r11);
    }

    public static void setCallback(Object r10, Object r11, Handler r12) {
        ((MediaSession) r10).setCallback((MediaSession.Callback) r11, r12);
    }

    public static void setExtras(Object r10, Bundle r11) {
        ((MediaSession) r10).setExtras(r11);
    }

    public static void setFlags(Object r10, int r11) {
        ((MediaSession) r10).setFlags(r11);
    }

    public static void setMediaButtonReceiver(Object r10, PendingIntent r11) {
        ((MediaSession) r10).setMediaButtonReceiver(r11);
    }

    public static void setMetadata(Object r10, Object r11) {
        ((MediaSession) r10).setMetadata((MediaMetadata) r11);
    }

    public static void setPlaybackState(Object r10, Object r11) {
        ((MediaSession) r10).setPlaybackState((PlaybackState) r11);
    }

    public static void setPlaybackToLocal(Object r10, int r11) {
        AudioAttributes.Builder r12 = new AudioAttributes.Builder();
        r12.setLegacyStreamType(r11);
        ((MediaSession) r10).setPlaybackToLocal(r12.build());
    }

    public static void setPlaybackToRemote(Object r10, Object r11) {
        ((MediaSession) r10).setPlaybackToRemote((VolumeProvider) r11);
    }

    public static void setQueue(Object r10, List<Object> r11) {
        if (r11 != null) goto L5;
        ((MediaSession) r10).setQueue(null);
        return;
    L5:
        ArrayList r12 = new ArrayList();
        Iterator<Object> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        r12.add((MediaSession.QueueItem) r13.next());
        goto L7
    L9:
        ((MediaSession) r10).setQueue(r12);
    }

    public static void setQueueTitle(Object r10, CharSequence r11) {
        ((MediaSession) r10).setQueueTitle(r11);
    }

    public static void setSessionActivity(Object r10, PendingIntent r11) {
        ((MediaSession) r10).setSessionActivity(r11);
    }

    public static Object verifySession(Object r10) {
        if ((r10 instanceof MediaSession) == false) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    public static Object verifyToken(Object r10) {
        if ((r10 instanceof MediaSession.Token) == false) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
