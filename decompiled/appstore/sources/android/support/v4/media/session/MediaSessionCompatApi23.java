package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class MediaSessionCompatApi23 {

    public interface Callback extends MediaSessionCompatApi21.Callback {
        void onPlayFromUri(Uri r10, Bundle r11);
    }

    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T r10) {
            super(r10);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri r10, Bundle r11) {
            MediaSessionCompat.ensureClassLoader(r11);
            ((Callback) this.mCallback).onPlayFromUri(r10, r11);
        }
    }

    private MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback r10) {
        return new CallbackProxy(r10);
    }
}
