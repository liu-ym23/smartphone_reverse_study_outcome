package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
class MediaBrowserServiceCompatApi26 {
    private static final String TAG = "MBSCompatApi26";
    static Field sResultFlags;

    public static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
        public MediaBrowserServiceAdaptor(Context r100, ServiceCompatProxy r101) {
            super(r100, r101);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r100, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r101, Bundle r102) {
            MediaSessionCompat.ensureClassLoader(r102);
            ((ServiceCompatProxy) this.mServiceProxy).onLoadChildren(r100, new ResultWrapper(r101), r102);
        }
    }

    public static class ResultWrapper {
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

        public void sendResult(List<Parcel> r100, int r101) {
            MediaBrowserServiceCompatApi26.sResultFlags.setInt(this.mResultObj, r101);     // Catch: IllegalAccessException -> L5
        L3:
            this.mResultObj.sendResult(parcelListToItemList(r100));
        }
    }

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String r100, ResultWrapper r101, Bundle r102);
    }

    static {
        Field r100 = MediaBrowserService.Result.class.getDeclaredField("mFlags");     // Catch: NoSuchFieldException -> L4
        sResultFlags = r100;     // Catch: NoSuchFieldException -> L4
        r100.setAccessible(true);     // Catch: NoSuchFieldException -> L4
        return;
    }

    private MediaBrowserServiceCompatApi26() {
    }

    public static Bundle getBrowserRootHints(Object r100) {
        return ((MediaBrowserService) r100).getBrowserRootHints();
    }

    public static Object createService(Context r100, ServiceCompatProxy r101) {
        return new MediaBrowserServiceAdaptor(r100, r101);
    }

    public static void notifyChildrenChanged(Object r100, String r101, Bundle r102) {
        ((MediaBrowserService) r100).notifyChildrenChanged(r101, r102);
    }
}
