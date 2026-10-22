package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompatApi21 {

    static class ConnectionCallbackProxy<T extends a> extends MediaBrowser.ConnectionCallback {
        protected final T mConnectionCallback;

        public ConnectionCallbackProxy(T r3) {
            this.mConnectionCallback = (T) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.mConnectionCallback.onConnected();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.mConnectionCallback.onConnectionSuspended();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.mConnectionCallback.onConnectionFailed();
        }
    }

    static class SubscriptionCallbackProxy<T extends c> extends MediaBrowser.SubscriptionCallback {
        protected final T mSubscriptionCallback;

        public SubscriptionCallbackProxy(T r3) {
            this.mSubscriptionCallback = (T) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String r3, List<MediaBrowser.MediaItem> r4) {
            List<?> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.mSubscriptionCallback.onChildrenLoaded(r3, r5);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String r1) {
            this.mSubscriptionCallback.onError(r1);
        }
    }

    interface a {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    static class b {
        public static int a(Object r2) {
            return ((MediaBrowser.MediaItem) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.MediaItem.class, "com.obric.aiagent.plugin")).getFlags();
        }

        public static Object b(Object r2) {
            return ((MediaBrowser.MediaItem) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.MediaItem.class, "com.obric.aiagent.plugin")).getDescription();
        }
    }

    interface c {
        void onChildrenLoaded(String r1, List<?> r2);

        void onError(String r1);
    }

    public static Object a(a r2) {
        return new ConnectionCallbackProxy((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin"));
    }

    public static Object a(Context r3, ComponentName r4, Object r5, Bundle r6) {
        return new MediaBrowser((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (MediaBrowser.ConnectionCallback) ZeusTransformUtils.preCheckCast(r5, MediaBrowser.ConnectionCallback.class, "com.obric.aiagent.plugin"), r6);
    }

    public static void a(Object r2) {
        ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).connect();
    }

    public static void b(Object r2) {
        ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).disconnect();
    }

    public static boolean c(Object r2) {
        return ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).isConnected();
    }

    public static ComponentName d(Object r2) {
        return ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).getServiceComponent();
    }

    public static String e(Object r2) {
        return ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).getRoot();
    }

    public static Bundle f(Object r2) {
        return ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).getExtras();
    }

    public static Object g(Object r2) {
        return ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).getSessionToken();
    }

    public static Object a(c r2) {
        return new SubscriptionCallbackProxy((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin"));
    }

    public static void a(Object r2, String r3, Object r4) {
        ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).subscribe(r3, (MediaBrowser.SubscriptionCallback) ZeusTransformUtils.preCheckCast(r4, MediaBrowser.SubscriptionCallback.class, "com.obric.aiagent.plugin"));
    }

    public static void a(Object r2, String r3) {
        ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).unsubscribe(r3);
    }
}
