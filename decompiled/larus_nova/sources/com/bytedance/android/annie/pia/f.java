package com.bytedance.android.annie.pia;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements i47.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebResourceResponse f39731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoadFrom f39732b;

    @Override // i47.e
    public final InputStream getData() {
        return this.f39731a.getData();
    }

    @Override // i47.e
    public final String getEncoding() {
        return this.f39731a.getEncoding();
    }

    @Override // i47.e
    public final Map<String, String> getHeaders() {
        return this.f39731a.getResponseHeaders();
    }

    @Override // i47.e
    public final String getMimeType() {
        return this.f39731a.getMimeType();
    }

    @Override // i47.e
    public final String getReasonPhrase() {
        if (TextUtils.isEmpty(this.f39731a.getReasonPhrase()) == false) goto L6;
        return com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE;
    L6:
        return this.f39731a.getReasonPhrase();
    }

    @Override // i47.e
    public final int getStatusCode() {
        if (this.f39731a.getStatusCode() != 0) goto L6;
        return 200;
    L6:
        return this.f39731a.getStatusCode();
    }

    @Override // i47.e
    public final LoadFrom a() {
        return this.f39732b;
    }

    public f(WebResourceResponse r100, LoadFrom r101) {
        this.f39731a = r100;
        this.f39732b = r101;
    }
}
