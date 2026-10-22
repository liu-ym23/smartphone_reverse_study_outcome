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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionCompatApi21 {

    static class CallbackProxy<T extends a> extends MediaSession.Callback {
        protected final T mCallback;

        public CallbackProxy(T r3) {
            this.mCallback = (T) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(String r1, Bundle r2, ResultReceiver r3) {
            MediaSessionCompat.a(r2);
            this.mCallback.onCommand(r1, r2, r3);
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent r2) {
            if (this.mCallback.onMediaButtonEvent(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.onMediaButtonEvent(r2) == true) goto L8;
            return false;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            this.mCallback.onPlay();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String r1, Bundle r2) {
            MediaSessionCompat.a(r2);
            this.mCallback.onPlayFromMediaId(r1, r2);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String r1, Bundle r2) {
            MediaSessionCompat.a(r2);
            this.mCallback.onPlayFromSearch(r1, r2);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long r1) {
            this.mCallback.onSkipToQueueItem(r1);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            this.mCallback.onPause();
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
        public void onFastForward() {
            this.mCallback.onFastForward();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            this.mCallback.onRewind();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            this.mCallback.onStop();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long r1) {
            this.mCallback.onSeekTo(r1);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating r1) {
            this.mCallback.onSetRating(r1);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(String r1, Bundle r2) {
            MediaSessionCompat.a(r2);
            this.mCallback.onCustomAction(r1, r2);
        }
    }

    interface a {
        void onCommand(String r1, Bundle r2, ResultReceiver r3);

        void onCustomAction(String r1, Bundle r2);

        void onFastForward();

        boolean onMediaButtonEvent(Intent r1);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String r1, Bundle r2);

        void onPlayFromSearch(String r1, Bundle r2);

        void onRewind();

        void onSeekTo(long r1);

        void onSetRating(Object r1);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long r1);

        void onStop();
    }

    static class b {
        public static Object a(Object r3, long r4) {
            return new MediaSession.QueueItem((MediaDescription) ZeusTransformUtils.preCheckCast(r3, MediaDescription.class, "com.obric.aiagent.plugin"), r4);
        }

        public static Object a(Object r2) {
            return ((MediaSession.QueueItem) ZeusTransformUtils.preCheckCast(r2, MediaSession.QueueItem.class, "com.obric.aiagent.plugin")).getDescription();
        }

        public static long b(Object r2) {
            return ((MediaSession.QueueItem) ZeusTransformUtils.preCheckCast(r2, MediaSession.QueueItem.class, "com.obric.aiagent.plugin")).getQueueId();
        }
    }

    public static Object a(Context r2, String r3) {
        return new MediaSession((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    public static Object a(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, MediaSession.class) == false) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    public static Object b(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, MediaSession.Token.class) == false) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    public static Object a(a r2) {
        return new CallbackProxy((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin"));
    }

    public static void a(Object r2, Object r3, Handler r4) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setCallback((MediaSession.Callback) ZeusTransformUtils.preCheckCast(r3, MediaSession.Callback.class, "com.obric.aiagent.plugin"), r4);
    }

    public static void a(Object r2, int r3) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setFlags(r3);
    }

    public static void b(Object r2, int r3) {
        AudioAttributes.Builder r0 = new AudioAttributes.Builder();
        r0.setLegacyStreamType(r3);
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setPlaybackToLocal(r0.build());
    }

    public static void a(Object r2, Object r3) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setPlaybackToRemote((VolumeProvider) ZeusTransformUtils.preCheckCast(r3, VolumeProvider.class, "com.obric.aiagent.plugin"));
    }

    public static void a(Object r2, boolean r3) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setActive(r3);
    }

    public static boolean c(Object r2) {
        return ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).isActive();
    }

    public static void a(Object r2, String r3, Bundle r4) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).sendSessionEvent(r3, r4);
    }

    public static void d(Object r2) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).release();
    }

    public static Parcelable e(Object r2) {
        return ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).getSessionToken();
    }

    public static void b(Object r2, Object r3) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setPlaybackState((PlaybackState) ZeusTransformUtils.preCheckCast(r3, PlaybackState.class, "com.obric.aiagent.plugin"));
    }

    public static void c(Object r2, Object r3) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setMetadata((MediaMetadata) ZeusTransformUtils.preCheckCast(r3, MediaMetadata.class, "com.obric.aiagent.plugin"));
    }

    public static void a(Object r2, PendingIntent r3) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setSessionActivity(r3);
    }

    public static void b(Object r2, PendingIntent r3) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setMediaButtonReceiver(r3);
    }

    public static void a(Object r4, List<Object> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L6;
        ((MediaSession) ZeusTransformUtils.preCheckCast(r4, MediaSession.class, "com.obric.aiagent.plugin")).setQueue(null);
        return;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r0.add((MediaSession.QueueItem) ZeusTransformUtils.preCheckCast(r7.next(), MediaSession.QueueItem.class, "com.obric.aiagent.plugin"));
        goto L8
    L10:
        ((MediaSession) ZeusTransformUtils.preCheckCast(r4, MediaSession.class, "com.obric.aiagent.plugin")).setQueue(r0);
    }

    public static void a(Object r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setQueueTitle(r4);
    }

    public static void a(Object r2, Bundle r3) {
        ((MediaSession) ZeusTransformUtils.preCheckCast(r2, MediaSession.class, "com.obric.aiagent.plugin")).setExtras(r3);
    }
}
