package com.bytedance.android.annie.pia;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements i47.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebResourceRequest f39727a;

    @Override // i47.d
    public final /* synthetic */ Map getOptions() {
        return null;
    }

    @Override // i47.d
    public final Map<String, String> getRequestHeaders() {
        return this.f39727a.getRequestHeaders();
    }

    @Override // i47.d
    public final Uri getUrl() {
        return this.f39727a.getUrl();
    }

    @Override // i47.d
    public final boolean isForMainFrame() {
        return this.f39727a.isForMainFrame();
    }

    public c(WebResourceRequest r100) {
        this.f39727a = r100;
    }
}
