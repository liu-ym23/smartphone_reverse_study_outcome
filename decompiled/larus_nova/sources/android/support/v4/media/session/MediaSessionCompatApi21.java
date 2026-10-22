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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class MediaSessionCompatApi21 {
    static final String TAG = "MediaSessionCompatApi21";

    public interface Callback {
        void onCommand(String r100, Bundle r101, ResultReceiver r102);

        void onCustomAction(String r100, Bundle r101);

        void onFastForward();

        boolean onMediaButtonEvent(Intent r100);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String r100, Bundle r101);

        void onPlayFromSearch(String r100, Bundle r101);

        void onRewind();

        void onSeekTo(long r100);

        void onSetRating(Object r100);

        void onSetRating(Object r100, Bundle r101);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long r100);

        void onStop();
    }

    public static class CallbackProxy<T extends Callback> extends MediaSession.Callback {
        protected final T mCallback;

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            this.mCallback.onFastForward();
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
        public void onRewind() {
            this.mCallback.onRewind();
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
        public void onStop() {
            this.mCallback.onStop();
        }

        public CallbackProxy(T r100) {
            this.mCallback = r100;
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent r100) {
            if (this.mCallback.onMediaButtonEvent(r100) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.onMediaButtonEvent(r100) == true) goto L8;
            return false;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long r100) {
            this.mCallback.onSeekTo(r100);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating r100) {
            this.mCallback.onSetRating(r100);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long r100) {
            this.mCallback.onSkipToQueueItem(r100);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(String r100, Bundle r101) {
            MediaSessionCompat.ensureClassLoader(r101);
            this.mCallback.onCustomAction(r100, r101);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String r100, Bundle r101) {
            MediaSessionCompat.ensureClassLoader(r101);
            this.mCallback.onPlayFromMediaId(r100, r101);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String r100, Bundle r101) {
            MediaSessionCompat.ensureClassLoader(r101);
            this.mCallback.onPlayFromSearch(r100, r101);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(String r100, Bundle r101, ResultReceiver r102) {
            MediaSessionCompat.ensureClassLoader(r101);
            this.mCallback.onCommand(r100, r101, r102);
        }
    }

    public static class QueueItem {
        private QueueItem() {
        }

        public static Object getDescription(Object r100) {
            return ((MediaSession.QueueItem) r100).getDescription();
        }

        public static long getQueueId(Object r100) {
            return ((MediaSession.QueueItem) r100).getQueueId();
        }

        public static Object createItem(Object r100, long r101) {
            return new MediaSession.QueueItem((MediaDescription) r100, r101);
        }
    }

    private MediaSessionCompatApi21() {
    }

    public static Object createCallback(Callback r100) {
        return new CallbackProxy(r100);
    }

    public static Parcelable getSessionToken(Object r100) {
        return ((MediaSession) r100).getSessionToken();
    }

    public static boolean hasCallback(Object r100) {
        Field r101 = r100.getClass().getDeclaredField("mCallback");     // Catch: Throwable -> L9
        if (r101 == null) goto L12;
        r101.setAccessible(true);     // Catch: Throwable -> L9
        if (r101.get(r100) == null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean isActive(Object r100) {
        return ((MediaSession) r100).isActive();
    }

    public static void release(Object r100) {
        ((MediaSession) r100).release();
    }

    public static Object verifySession(Object r100) {
        if ((r100 instanceof MediaSession) == false) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    public static Object verifyToken(Object r100) {
        if ((r100 instanceof MediaSession.Token) == false) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    public static Object createSession(Context r100, String r101) {
        return new MediaSession(r100, r101);
    }

    public static void setActive(Object r100, boolean r101) {
        ((MediaSession) r100).setActive(r101);
    }

    public static void setExtras(Object r100, Bundle r101) {
        ((MediaSession) r100).setExtras(r101);
    }

    public static void setFlags(Object r100, int r101) {
        ((MediaSession) r100).setFlags(r101);
    }

    public static void setMediaButtonReceiver(Object r100, PendingIntent r101) {
        ((MediaSession) r100).setMediaButtonReceiver(r101);
    }

    public static void setMetadata(Object r100, Object r101) {
        ((MediaSession) r100).setMetadata((MediaMetadata) r101);
    }

    public static void setPlaybackState(Object r100, Object r101) {
        ((MediaSession) r100).setPlaybackState((PlaybackState) r101);
    }

    public static void setPlaybackToLocal(Object r100, int r101) {
        AudioAttributes.Builder r102 = new AudioAttributes.Builder();
        r102.setLegacyStreamType(r101);
        ((MediaSession) r100).setPlaybackToLocal(r102.build());
    }

    public static void setPlaybackToRemote(Object r100, Object r101) {
        ((MediaSession) r100).setPlaybackToRemote((VolumeProvider) r101);
    }

    public static void setQueue(Object r100, List<Object> r101) {
        if (r101 != null) goto L5;
        ((MediaSession) r100).setQueue(null);
        return;
    L5:
        ArrayList r102 = new ArrayList();
        Iterator<Object> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.add((MediaSession.QueueItem) r103.next());
        goto L7
    L9:
        ((MediaSession) r100).setQueue(r102);
    }

    public static void setQueueTitle(Object r100, CharSequence r101) {
        ((MediaSession) r100).setQueueTitle(r101);
    }

    public static void setSessionActivity(Object r100, PendingIntent r101) {
        ((MediaSession) r100).setSessionActivity(r101);
    }

    public static void sendSessionEvent(Object r100, String r101, Bundle r102) {
        ((MediaSession) r100).sendSessionEvent(r101, r102);
    }

    public static void setCallback(Object r100, Object r101, Handler r102) {
        ((MediaSession) r100).setCallback((MediaSession.Callback) r101, r102);
    }
}
