package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
class MediaSessionCompatApi24 {
    private static final String TAG = "MediaSessionCompatApi24";

    public interface Callback extends MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(String r10, Bundle r11);

        void onPrepareFromSearch(String r10, Bundle r11);

        void onPrepareFromUri(Uri r10, Bundle r11);
    }

    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi23.CallbackProxy<T> {
        public CallbackProxy(T r10) {
            super(r10);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            ((Callback) this.mCallback).onPrepare();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String r10, Bundle r11) {
            MediaSessionCompat.ensureClassLoader(r11);
            ((Callback) this.mCallback).onPrepareFromMediaId(r10, r11);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String r10, Bundle r11) {
            MediaSessionCompat.ensureClassLoader(r11);
            ((Callback) this.mCallback).onPrepareFromSearch(r10, r11);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri r10, Bundle r11) {
            MediaSessionCompat.ensureClassLoader(r11);
            ((Callback) this.mCallback).onPrepareFromUri(r10, r11);
        }
    }

    private MediaSessionCompatApi24() {
    }

    public static Object createCallback(Callback r10) {
        return new CallbackProxy(r10);
    }

    public static String getCallingPackage(Object r10) {
        MediaSession r11 = (MediaSession) r10;
        return (String) r11.getClass().getMethod("getCallingPackage", null).invoke(r11, null);
    L5:
        e = move-exception;
        Log.e(TAG, "Cannot execute MediaSession.getCallingPackage()", e);
        return null;
    }
}
