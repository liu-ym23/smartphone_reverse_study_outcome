package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserServiceCompatApi26 {
    private static final String TAG = "MBSCompatApi26";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Field f2217a;

    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context r3, b r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r3, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r4, Bundle r5) {
            MediaSessionCompat.a(r5);
            ((b) ZeusTransformUtils.preCheckCast(this.mServiceProxy, b.class, "com.obric.aiagent.plugin")).a(r3, new a(r4), r5);
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MediaBrowserService.Result f2218a;

        a(MediaBrowserService.Result r1) {
            this.f2218a = r1;
        }

        public void a(List<Parcel> r3, int r4) {
            List<Parcel> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            MediaBrowserServiceCompatApi26.f2217a.setInt(this.f2218a, r4);     // Catch: IllegalAccessException -> L5
        L7:
            this.f2218a.sendResult(a(r5));
            return;
        L5:
            e = move-exception;
            a(MediaBrowserServiceCompatApi26.TAG, e);
            goto L7
        }

        List<MediaBrowser.MediaItem> a(List<Parcel> r4) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L6;
            return null;
        L6:
            ArrayList r5 = new ArrayList();
            Iterator r6 = r3.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            Parcel r1 = (Parcel) ZeusTransformUtils.preCheckCast(r6.next(), Parcel.class, "com.obric.aiagent.plugin");
            r1.setDataPosition(0);
            r5.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(r1));
            r1.recycle();
            goto L8
        L10:
            return r5;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, Throwable r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    public interface b extends MediaBrowserServiceCompatApi23.a {
        void a(String r1, a r2, Bundle r3);
    }

    static {
        Field r0 = MediaBrowserService.Result.class.getDeclaredField("mFlags");     // Catch: NoSuchFieldException -> L4
        f2217a = r0;     // Catch: NoSuchFieldException -> L4
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L4
        return;
    L4:
        e = move-exception;
        a(TAG, e);
    }

    public static Object a(Context r2, b r3) {
        return new MediaBrowserServiceAdaptor((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin"));
    }

    public static void a(Object r2, String r3, Bundle r4) {
        ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.aiagent.plugin")).notifyChildrenChanged(r3, r4);
    }

    public static Bundle a(Object r2) {
        return ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.aiagent.plugin")).getBrowserRootHints();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, Throwable r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
