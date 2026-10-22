package com.bytedance.android.annie.pia;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements i47.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebResourceResponse f39730a;

    @Override // i47.e
    public final InputStream getData() {
        return this.f39730a.getData();
    }

    @Override // i47.e
    public final String getEncoding() {
        return this.f39730a.getEncoding();
    }

    @Override // i47.e
    public final Map<String, String> getHeaders() {
        return this.f39730a.getResponseHeaders();
    }

    @Override // i47.e
    public final String getMimeType() {
        return this.f39730a.getMimeType();
    }

    @Override // i47.e
    public final String getReasonPhrase() {
        if (TextUtils.isEmpty(this.f39730a.getReasonPhrase()) == false) goto L6;
        return "OK";
    L6:
        return this.f39730a.getReasonPhrase();
    }

    @Override // i47.e
    public final int getStatusCode() {
        if (this.f39730a.getStatusCode() != 0) goto L6;
        return 200;
    L6:
        return this.f39730a.getStatusCode();
    }

    @Override // i47.e
    public final LoadFrom a() {
        return LoadFrom.Offline;
    }

    public e(WebResourceResponse r100) {
        this.f39730a = r100;
    }
}
