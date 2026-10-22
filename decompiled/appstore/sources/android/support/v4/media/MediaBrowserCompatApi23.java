package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class MediaBrowserCompatApi23 {

    public interface ItemCallback {
        void onError(@NonNull String r10);

        void onItemLoaded(Parcel r10);
    }

    public static class ItemCallbackProxy<T extends ItemCallback> extends MediaBrowser.ItemCallback {
        protected final T mItemCallback;

        public ItemCallbackProxy(T r10) {
            this.mItemCallback = r10;
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(@NonNull String r10) {
            this.mItemCallback.onError(r10);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem r10) {
            if (r10 != null) goto L4;
            this.mItemCallback.onItemLoaded(null);
            return;
        L4:
            Parcel r11 = Parcel.obtain();
            r10.writeToParcel(r11, 0);
            this.mItemCallback.onItemLoaded(r11);
        }
    }

    private MediaBrowserCompatApi23() {
    }

    public static Object createItemCallback(ItemCallback r10) {
        return new ItemCallbackProxy(r10);
    }

    public static void getItem(Object r10, String r11, Object r12) {
        ((MediaBrowser) r10).getItem(r11, (MediaBrowser.ItemCallback) r12);
    }
}
