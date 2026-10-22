package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
class MediaBrowserCompatApi23 {

    public interface ItemCallback {
        void onError(String r100);

        void onItemLoaded(Parcel r100);
    }

    public static class ItemCallbackProxy<T extends ItemCallback> extends MediaBrowser.ItemCallback {
        protected final T mItemCallback;

        public ItemCallbackProxy(T r100) {
            this.mItemCallback = r100;
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(String r100) {
            this.mItemCallback.onError(r100);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem r100) {
            if (r100 != null) goto L4;
            this.mItemCallback.onItemLoaded(null);
            return;
        L4:
            Parcel r101 = Parcel.obtain();
            r100.writeToParcel(r101, 0);
            this.mItemCallback.onItemLoaded(r101);
        }
    }

    private MediaBrowserCompatApi23() {
    }

    public static Object createItemCallback(ItemCallback r100) {
        return new ItemCallbackProxy(r100);
    }

    public static void getItem(Object r100, String r101, Object r102) {
        ((MediaBrowser) r100).getItem(r101, (MediaBrowser.ItemCallback) r102);
    }
}
