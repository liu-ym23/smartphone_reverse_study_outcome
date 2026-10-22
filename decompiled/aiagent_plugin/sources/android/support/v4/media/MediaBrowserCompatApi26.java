package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompatApi26 {

    interface SubscriptionCallback extends MediaBrowserCompatApi21.c {
        void onChildrenLoaded(String r1, List<?> r2, Bundle r3);

        void onError(String r1, Bundle r2);
    }

    static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T> {
        SubscriptionCallbackProxy(T r3) {
            super((SubscriptionCallback) ZeusTransformUtils.wrapperContextForParams(r3, SubscriptionCallback.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String r3, List<MediaBrowser.MediaItem> r4, Bundle r5) {
            List<?> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            MediaSessionCompat.a(r5);
            ((SubscriptionCallback) ZeusTransformUtils.preCheckCast(this.mSubscriptionCallback, SubscriptionCallback.class, "com.obric.aiagent.plugin")).onChildrenLoaded(r3, r6, r5);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String r3, Bundle r4) {
            MediaSessionCompat.a(r4);
            ((SubscriptionCallback) ZeusTransformUtils.preCheckCast(this.mSubscriptionCallback, SubscriptionCallback.class, "com.obric.aiagent.plugin")).onError(r3, r4);
        }
    }

    static Object a(SubscriptionCallback r2) {
        return new SubscriptionCallbackProxy((SubscriptionCallback) ZeusTransformUtils.wrapperContextForParams(r2, SubscriptionCallback.class, "com.obric.aiagent.plugin"));
    }

    public static void a(Object r2, String r3, Bundle r4, Object r5) {
        ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).subscribe(r3, r4, (MediaBrowser.SubscriptionCallback) ZeusTransformUtils.preCheckCast(r5, MediaBrowser.SubscriptionCallback.class, "com.obric.aiagent.plugin"));
    }

    public static void a(Object r2, String r3, Object r4) {
        ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).unsubscribe(r3, (MediaBrowser.SubscriptionCallback) ZeusTransformUtils.preCheckCast(r4, MediaBrowser.SubscriptionCallback.class, "com.obric.aiagent.plugin"));
    }
}
