package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompatApi23 {

    static class ItemCallbackProxy<T extends a> extends MediaBrowser.ItemCallback {
        protected final T mItemCallback;

        public ItemCallbackProxy(T r3) {
            this.mItemCallback = (T) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem r3) {
            if (r3 != null) goto L4;
            this.mItemCallback.onItemLoaded(null);
            return;
        L4:
            Parcel r0 = Parcel.obtain();
            r3.writeToParcel(r0, 0);
            this.mItemCallback.onItemLoaded(r0);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(String r1) {
            this.mItemCallback.onError(r1);
        }
    }

    interface a {
        void onError(String r1);

        void onItemLoaded(Parcel r1);
    }

    public static void a(Object r2, String r3, Object r4) {
        ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.aiagent.plugin")).getItem(r3, (MediaBrowser.ItemCallback) ZeusTransformUtils.preCheckCast(r4, MediaBrowser.ItemCallback.class, "com.obric.aiagent.plugin"));
    }
}
