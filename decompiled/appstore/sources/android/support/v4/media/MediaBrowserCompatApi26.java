package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
class MediaBrowserCompatApi26 {

    public interface SubscriptionCallback extends MediaBrowserCompatApi21.SubscriptionCallback {
        void onChildrenLoaded(@NonNull String r10, List<?> r11, @NonNull Bundle r12);

        void onError(@NonNull String r10, @NonNull Bundle r11);
    }

    public static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T> {
        public SubscriptionCallbackProxy(T r10) {
            super(r10);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String r10, List<MediaBrowser.MediaItem> r11, @NonNull Bundle r12) {
            MediaSessionCompat.ensureClassLoader(r12);
            ((SubscriptionCallback) this.mSubscriptionCallback).onChildrenLoaded(r10, r11, r12);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@NonNull String r10, @NonNull Bundle r11) {
            MediaSessionCompat.ensureClassLoader(r11);
            ((SubscriptionCallback) this.mSubscriptionCallback).onError(r10, r11);
        }
    }

    private MediaBrowserCompatApi26() {
    }

    public static Object createSubscriptionCallback(SubscriptionCallback r10) {
        return new SubscriptionCallbackProxy(r10);
    }

    public static void subscribe(Object r10, String r11, Bundle r12, Object r13) {
        ((MediaBrowser) r10).subscribe(r11, r12, (MediaBrowser.SubscriptionCallback) r13);
    }

    public static void unsubscribe(Object r10, String r11, Object r12) {
        ((MediaBrowser) r10).unsubscribe(r11, (MediaBrowser.SubscriptionCallback) r12);
    }
}
