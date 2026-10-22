package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
class MediaSessionCompatApi24 {
    private static final String TAG = "MediaSessionCompatApi24";

    public interface Callback extends MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(String r100, Bundle r101);

        void onPrepareFromSearch(String r100, Bundle r101);

        void onPrepareFromUri(Uri r100, Bundle r101);
    }

    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi23.CallbackProxy<T> {
        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            ((Callback) this.mCallback).onPrepare();
        }

        public CallbackProxy(T r100) {
            super(r100);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String r100, Bundle r101) {
            MediaSessionCompat.ensureClassLoader(r101);
            ((Callback) this.mCallback).onPrepareFromMediaId(r100, r101);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String r100, Bundle r101) {
            MediaSessionCompat.ensureClassLoader(r101);
            ((Callback) this.mCallback).onPrepareFromSearch(r100, r101);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri r100, Bundle r101) {
            MediaSessionCompat.ensureClassLoader(r101);
            ((Callback) this.mCallback).onPrepareFromUri(r100, r101);
        }
    }

    private MediaSessionCompatApi24() {
    }

    public static Object createCallback(Callback r100) {
        return new CallbackProxy(r100);
    }

    public static String getCallingPackage(Object r100) {
        MediaSession r101 = (MediaSession) r100;
        return (String) r101.getClass().getMethod("getCallingPackage", new Class[0]).invoke(r101, new Object[0]);
    L5:
        return null;
    }
}
