package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class MediaBrowserCompatApi21 {
    static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    public interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    public static class ConnectionCallbackProxy<T extends ConnectionCallback> extends MediaBrowser.ConnectionCallback {
        protected final T mConnectionCallback;

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

        public ConnectionCallbackProxy(T r100) {
            this.mConnectionCallback = r100;
        }
    }

    public static class MediaItem {
        private MediaItem() {
        }

        public static Object getDescription(Object r100) {
            return ((MediaBrowser.MediaItem) r100).getDescription();
        }

        public static int getFlags(Object r100) {
            return ((MediaBrowser.MediaItem) r100).getFlags();
        }
    }

    public interface SubscriptionCallback {
        void onChildrenLoaded(String r100, List<?> r101);

        void onError(String r100);
    }

    public static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowser.SubscriptionCallback {
        protected final T mSubscriptionCallback;

        public SubscriptionCallbackProxy(T r100) {
            this.mSubscriptionCallback = r100;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String r100) {
            this.mSubscriptionCallback.onError(r100);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String r100, List<MediaBrowser.MediaItem> r101) {
            this.mSubscriptionCallback.onChildrenLoaded(r100, r101);
        }
    }

    private MediaBrowserCompatApi21() {
    }

    public static void connect(Object r100) {
        ((MediaBrowser) r100).connect();
    }

    public static Object createConnectionCallback(ConnectionCallback r100) {
        return new ConnectionCallbackProxy(r100);
    }

    public static Object createSubscriptionCallback(SubscriptionCallback r100) {
        return new SubscriptionCallbackProxy(r100);
    }

    public static void disconnect(Object r100) {
        ((MediaBrowser) r100).disconnect();
    }

    public static Bundle getExtras(Object r100) {
        return ((MediaBrowser) r100).getExtras();
    }

    public static String getRoot(Object r100) {
        return ((MediaBrowser) r100).getRoot();
    }

    public static ComponentName getServiceComponent(Object r100) {
        return ((MediaBrowser) r100).getServiceComponent();
    }

    public static Object getSessionToken(Object r100) {
        return ((MediaBrowser) r100).getSessionToken();
    }

    public static boolean isConnected(Object r100) {
        return ((MediaBrowser) r100).isConnected();
    }

    public static void unsubscribe(Object r100, String r101) {
        ((MediaBrowser) r100).unsubscribe(r101);
    }

    public static void subscribe(Object r100, String r101, Object r102) {
        ((MediaBrowser) r100).subscribe(r101, (MediaBrowser.SubscriptionCallback) r102);
    }

    public static Object createBrowser(Context r100, ComponentName r101, Object r102, Bundle r103) {
        return new MediaBrowser(r100, r101, (MediaBrowser.ConnectionCallback) r102, r103);
    }
}
