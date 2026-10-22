package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaBrowserCompatApi21 {
    static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    public interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    public static class ConnectionCallbackProxy<T extends ConnectionCallback> extends MediaBrowser.ConnectionCallback {
        protected final T mConnectionCallback;

        public ConnectionCallbackProxy(T r10) {
            this.mConnectionCallback = r10;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.mConnectionCallback.onConnected();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.mConnectionCallback.onConnectionFailed();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.mConnectionCallback.onConnectionSuspended();
        }
    }

    public static class MediaItem {
        private MediaItem() {
        }

        public static Object getDescription(Object r10) {
            return ((MediaBrowser.MediaItem) r10).getDescription();
        }

        public static int getFlags(Object r10) {
            return ((MediaBrowser.MediaItem) r10).getFlags();
        }
    }

    public interface SubscriptionCallback {
        void onChildrenLoaded(@NonNull String r10, List<?> r11);

        void onError(@NonNull String r10);
    }

    public static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowser.SubscriptionCallback {
        protected final T mSubscriptionCallback;

        public SubscriptionCallbackProxy(T r10) {
            this.mSubscriptionCallback = r10;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String r10, List<MediaBrowser.MediaItem> r11) {
            this.mSubscriptionCallback.onChildrenLoaded(r10, r11);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@NonNull String r10) {
            this.mSubscriptionCallback.onError(r10);
        }
    }

    private MediaBrowserCompatApi21() {
    }

    public static void connect(Object r10) {
        ((MediaBrowser) r10).connect();
    }

    public static Object createBrowser(Context r10, ComponentName r11, Object r12, Bundle r13) {
        return new MediaBrowser(r10, r11, (MediaBrowser.ConnectionCallback) r12, r13);
    }

    public static Object createConnectionCallback(ConnectionCallback r10) {
        return new ConnectionCallbackProxy(r10);
    }

    public static Object createSubscriptionCallback(SubscriptionCallback r10) {
        return new SubscriptionCallbackProxy(r10);
    }

    public static void disconnect(Object r10) {
        ((MediaBrowser) r10).disconnect();
    }

    public static Bundle getExtras(Object r10) {
        return ((MediaBrowser) r10).getExtras();
    }

    public static String getRoot(Object r10) {
        return ((MediaBrowser) r10).getRoot();
    }

    public static ComponentName getServiceComponent(Object r10) {
        return ((MediaBrowser) r10).getServiceComponent();
    }

    public static Object getSessionToken(Object r10) {
        return ((MediaBrowser) r10).getSessionToken();
    }

    public static boolean isConnected(Object r10) {
        return ((MediaBrowser) r10).isConnected();
    }

    public static void subscribe(Object r10, String r11, Object r12) {
        ((MediaBrowser) r10).subscribe(r11, (MediaBrowser.SubscriptionCallback) r12);
    }

    public static void unsubscribe(Object r10, String r11) {
        ((MediaBrowser) r10).unsubscribe(r11);
    }
}
