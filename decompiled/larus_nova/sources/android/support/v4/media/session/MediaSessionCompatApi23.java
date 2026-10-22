package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
class MediaSessionCompatApi23 {

    public interface Callback extends MediaSessionCompatApi21.Callback {
        void onPlayFromUri(Uri r100, Bundle r101);
    }

    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T r100) {
            super(r100);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri r100, Bundle r101) {
            MediaSessionCompat.ensureClassLoader(r101);
            ((Callback) this.mCallback).onPlayFromUri(r100, r101);
        }
    }

    private MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback r100) {
        return new CallbackProxy(r100);
    }
}
