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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserServiceCompatApi21 {

    static class MediaBrowserServiceAdaptor extends MediaBrowserService {
        final c mServiceProxy;

        MediaBrowserServiceAdaptor(Context r3, c r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
            attachBaseContext(r5);
            this.mServiceProxy = r6;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String r3, int r4, Bundle r5) {
            MediaSessionCompat.a(r5);
            c r2 = this.mServiceProxy;
            if (r5 != null) goto L5;
            Bundle r1 = null;
        L6:
            a r6 = r2.a(r3, r4, r1);
            if (r6 != null) goto L10;
            return null;
        L10:
            return new MediaBrowserService.BrowserRoot(r6.f2214a, r6.f2215b);
        L5:
            r1 = new Bundle(r5);
            goto L6
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r2, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r3) {
            this.mServiceProxy.a(r2, new b(r3));
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f2214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Bundle f2215b;

        a(String r1, Bundle r2) {
            this.f2214a = r1;
            this.f2215b = r2;
        }
    }

    static class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MediaBrowserService.Result f2216a;

        b(MediaBrowserService.Result r1) {
            this.f2216a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(T r4) {
            if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L6;
            this.f2216a.sendResult(a((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")));
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, Parcel.class) == false) goto L8;
            Parcel r5 = (Parcel) ZeusTransformUtils.preCheckCast(r4, Parcel.class, "com.obric.aiagent.plugin");
            r5.setDataPosition(0);
            this.f2216a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(r5));
            r5.recycle();
            return;
        L8:
            this.f2216a.sendResult(null);
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
    }

    public interface c {
        a a(String r1, int r2, Bundle r3);

        void a(String r1, b<List<Parcel>> r2);
    }

    public static Object a(Context r2, c r3) {
        return new MediaBrowserServiceAdaptor((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin"));
    }

    public static void a(Object r2) {
        ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.aiagent.plugin")).onCreate();
    }

    public static IBinder a(Object r2, Intent r3) {
        return ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.aiagent.plugin")).onBind(r3);
    }

    public static void a(Object r2, Object r3) {
        ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.aiagent.plugin")).setSessionToken((MediaSession.Token) ZeusTransformUtils.preCheckCast(r3, MediaSession.Token.class, "com.obric.aiagent.plugin"));
    }

    public static void a(Object r2, String r3) {
        ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.aiagent.plugin")).notifyChildrenChanged(r3);
    }
}
