package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserServiceCompatApi23 {

    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context r3, a r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String r3, MediaBrowserService.Result<MediaBrowser.MediaItem> r4) {
            ((a) ZeusTransformUtils.preCheckCast(this.mServiceProxy, a.class, "com.obric.aiagent.plugin")).b(r3, new MediaBrowserServiceCompatApi21.b(r4));
        }
    }

    public interface a extends MediaBrowserServiceCompatApi21.c {
        void b(String r1, MediaBrowserServiceCompatApi21.b<Parcel> r2);
    }

    public static Object a(Context r2, a r3) {
        return new MediaBrowserServiceAdaptor((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin"));
    }
}
