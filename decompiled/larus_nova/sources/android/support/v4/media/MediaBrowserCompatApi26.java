package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class MediaBrowserCompatApi26 {

    public interface SubscriptionCallback extends MediaBrowserCompatApi21.SubscriptionCallback {
        void onChildrenLoaded(String r100, List<?> r101, Bundle r102);

        void onError(String r100, Bundle r101);
    }

    public static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T> {
        public SubscriptionCallbackProxy(T r100) {
            super(r100);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String r100, Bundle r101) {
            MediaSessionCompat.ensureClassLoader(r101);
            ((SubscriptionCallback) this.mSubscriptionCallback).onError(r100, r101);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String r100, List<MediaBrowser.MediaItem> r101, Bundle r102) {
            MediaSessionCompat.ensureClassLoader(r102);
            ((SubscriptionCallback) this.mSubscriptionCallback).onChildrenLoaded(r100, r101, r102);
        }
    }

    private MediaBrowserCompatApi26() {
    }

    public static Object createSubscriptionCallback(SubscriptionCallback r100) {
        return new SubscriptionCallbackProxy(r100);
    }

    public static void unsubscribe(Object r100, String r101, Object r102) {
        ((MediaBrowser) r100).unsubscribe(r101, (MediaBrowser.SubscriptionCallback) r102);
    }

    public static void subscribe(Object r100, String r101, Bundle r102, Object r103) {
        ((MediaBrowser) r100).subscribe(r101, r102, (MediaBrowser.SubscriptionCallback) r103);
    }
}
