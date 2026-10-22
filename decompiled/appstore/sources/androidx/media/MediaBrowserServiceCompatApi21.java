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

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompatApi21 {

    public interface ServiceCompatProxy {
        a onGetRoot(String r10, int r11, Bundle r12);

        void onLoadChildren(String r10, c r11);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f3706b;
    }

    public static class b extends MediaBrowserService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ServiceCompatProxy f3707a;

        public b(Context r10, ServiceCompatProxy r11) {
            attachBaseContext(r10);
            this.f3707a = r11;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String r10, int r11, Bundle r12) {
            MediaSessionCompat.ensureClassLoader(r12);
            ServiceCompatProxy r13 = this.f3707a;
            if (r12 != null) goto L5;
            Bundle r14 = null;
        L6:
            r13.onGetRoot(r10, r11, r14);
            return null;
        L5:
            r14 = new Bundle(r12);
            goto L6
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r10, MediaBrowserService.Result r11) {
            this.f3707a.onLoadChildren(r10, new c(r11));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaBrowserService.Result f3708a;

        public c(MediaBrowserService.Result r10) {
            this.f3708a = r10;
        }

        public List a(List r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            ArrayList r11 = new ArrayList();
            Iterator r12 = r10.iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            Parcel r13 = (Parcel) r12.next();
            r13.setDataPosition(0);
            r11.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(r13));
            r13.recycle();
            goto L7
        L9:
            return r11;
        }

        public void b(Object r10) {
            if ((r10 instanceof List) == false) goto L6;
            this.f3708a.sendResult(a((List) r10));
            return;
        L6:
            if ((r10 instanceof Parcel) == false) goto L8;
            Parcel r11 = (Parcel) r10;
            r11.setDataPosition(0);
            this.f3708a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(r11));
            r11.recycle();
            return;
        L8:
            this.f3708a.sendResult(null);
        }
    }

    public static void a(Object r10, String r11) {
        ((MediaBrowserService) r10).notifyChildrenChanged(r11);
    }

    public static IBinder b(Object r10, Intent r11) {
        return ((MediaBrowserService) r10).onBind(r11);
    }

    public static void c(Object r10) {
        ((MediaBrowserService) r10).onCreate();
    }

    public static void d(Object r10, Object r11) {
        ((MediaBrowserService) r10).setSessionToken((MediaSession.Token) r11);
    }
}
