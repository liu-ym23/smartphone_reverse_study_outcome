package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
class MediaBrowserServiceCompatApi21 {

    public static class BrowserRoot {
        final Bundle mExtras;
        final String mRootId;

        public BrowserRoot(String r100, Bundle r101) {
            this.mRootId = r100;
            this.mExtras = r101;
        }
    }

    public static class MediaBrowserServiceAdaptor extends MediaBrowserService {
        final ServiceCompatProxy mServiceProxy;

        public MediaBrowserServiceAdaptor(Context r100, ServiceCompatProxy r101) {
            attachBaseContext(r100);
            this.mServiceProxy = r101;
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r100, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r101) {
            this.mServiceProxy.onLoadChildren(r100, new ResultWrapper(r101));
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String r100, int r101, Bundle r102) {
            MediaSessionCompat.ensureClassLoader(r102);
            ServiceCompatProxy r103 = this.mServiceProxy;
            if (r102 != null) goto L5;
            Bundle r104 = null;
        L6:
            BrowserRoot r105 = r103.onGetRoot(r100, r101, r104);
            if (r105 != null) goto L10;
            return null;
        L10:
            return new MediaBrowserService.BrowserRoot(r105.mRootId, r105.mExtras);
        L5:
            r104 = new Bundle(r102);
            goto L6
        }
    }

    public static class ResultWrapper<T> {
        MediaBrowserService.Result mResultObj;

        public void detach() {
            this.mResultObj.detach();
        }

        public ResultWrapper(MediaBrowserService.Result r100) {
            this.mResultObj = r100;
        }

        public List<MediaBrowser.MediaItem> parcelListToItemList(List<Parcel> r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            ArrayList r101 = new ArrayList();
            Iterator<Parcel> r102 = r100.iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            Parcel r103 = r102.next();
            r103.setDataPosition(0);
            r101.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(r103));
            r103.recycle();
            goto L7
        L9:
            return r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void sendResult(T r100) {
            if ((r100 instanceof List) == false) goto L6;
            this.mResultObj.sendResult(parcelListToItemList((List) r100));
            return;
        L6:
            if ((r100 instanceof Parcel) == false) goto L8;
            Parcel r101 = (Parcel) r100;
            r101.setDataPosition(0);
            this.mResultObj.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(r101));
            r101.recycle();
            return;
        L8:
            this.mResultObj.sendResult(null);
        }
    }

    public interface ServiceCompatProxy {
        BrowserRoot onGetRoot(String r100, int r101, Bundle r102);

        void onLoadChildren(String r100, ResultWrapper<List<Parcel>> r101);
    }

    private MediaBrowserServiceCompatApi21() {
    }

    public static void onCreate(Object r100) {
        ((MediaBrowserService) r100).onCreate();
    }

    public static Object createService(Context r100, ServiceCompatProxy r101) {
        return new MediaBrowserServiceAdaptor(r100, r101);
    }

    public static void notifyChildrenChanged(Object r100, String r101) {
        ((MediaBrowserService) r100).notifyChildrenChanged(r101);
    }

    public static IBinder onBind(Object r100, Intent r101) {
        return ((MediaBrowserService) r100).onBind(r101);
    }

    public static void setSessionToken(Object r100, Object r101) {
        ((MediaBrowserService) r100).setSessionToken((MediaSession.Token) r101);
    }
}
