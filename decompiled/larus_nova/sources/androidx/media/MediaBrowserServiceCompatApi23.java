package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;

/* JADX INFO: loaded from: classes17.dex */
class MediaBrowserServiceCompatApi23 {

    public static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
        public MediaBrowserServiceAdaptor(Context r100, ServiceCompatProxy r101) {
            super(r100, r101);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String r100, MediaBrowserService.Result<MediaBrowser.MediaItem> r101) {
            ((ServiceCompatProxy) this.mServiceProxy).onLoadItem(r100, new MediaBrowserServiceCompatApi21.ResultWrapper(r101));
        }
    }

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(String r100, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> r101);
    }

    private MediaBrowserServiceCompatApi23() {
    }

    public static Object createService(Context r100, ServiceCompatProxy r101) {
        return new MediaBrowserServiceAdaptor(r100, r101);
    }
}
