package androidx.media;

import android.content.Context;
import android.service.media.MediaBrowserService;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends MediaBrowserServiceCompatApi21.b {
    public b(Context r10, MediaBrowserServiceCompatApi23$ServiceCompatProxy r11) {
        super(r10, r11);
    }

    @Override // android.service.media.MediaBrowserService
    public void onLoadItem(String r10, MediaBrowserService.Result r11) {
        ((MediaBrowserServiceCompatApi23$ServiceCompatProxy) this.f3707a).onLoadItem(r10, new MediaBrowserServiceCompatApi21.c(r11));
    }
}
