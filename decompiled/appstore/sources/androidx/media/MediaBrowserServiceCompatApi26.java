package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompatApi26 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f3709a;

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23$ServiceCompatProxy {
        void onLoadChildren(String r10, b r11, Bundle r12);
    }

    public static class a extends androidx.media.b {
        public a(Context r10, ServiceCompatProxy r11) {
            super(r10, r11);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r10, MediaBrowserService.Result r11, Bundle r12) {
            MediaSessionCompat.ensureClassLoader(r12);
            ((ServiceCompatProxy) this.f3707a).onLoadChildren(r10, new b(r11), r12);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaBrowserService.Result f3710a;

        public b(MediaBrowserService.Result r10) {
            this.f3710a = r10;
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

        public void b(List r10, int r11) {
            MediaBrowserServiceCompatApi26.f3709a.setInt(this.f3710a, r11);     // Catch: IllegalAccessException -> L4
        L6:
            this.f3710a.sendResult(a(r10));
            return;
        L4:
            e = move-exception;
            Log.w("MBSCompatApi26", e);
            goto L6
        }
    }

    static {
        Field r10 = MediaBrowserService.Result.class.getDeclaredField("mFlags");     // Catch: NoSuchFieldException -> L4
        f3709a = r10;     // Catch: NoSuchFieldException -> L4
        r10.setAccessible(true);     // Catch: NoSuchFieldException -> L4
        return;
    L4:
        e = move-exception;
        Log.w("MBSCompatApi26", e);
    }

    public static Object a(Context r10, ServiceCompatProxy r11) {
        return new a(r10, r11);
    }

    public static Bundle b(Object r10) {
        return ((MediaBrowserService) r10).getBrowserRootHints();
    }

    public static void c(Object r10, String r11, Bundle r12) {
        ((MediaBrowserService) r10).notifyChildrenChanged(r11, r12);
    }
}
