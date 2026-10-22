package com.bytedance.android.live.browser.service;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livehostapi.platform.ISaasHostWebView;
import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class AnnieExternalServiceImpl implements f9.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f64265b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f64266a;

    public static final class a {
    }

    @Override // f9.b
    public final void setCachePrefix(List<Pattern> r100) {
        Intrinsics.checkNotNullParameter(r100, "patterns");
    }

    static {
        f64265b = "";
    }

    @Override // f9.b
    public final String getHostGeckoCacheDir() {
        return ((IHostWebView) jc1.k.n(IHostWebView.class)).getHostGeckoCacheDir();
    }

    @Override // f9.b
    public final List<String> getSafeJsbHostList() {
        ArrayList r100 = new ArrayList();
        r100.addAll(((IHostWebView) jc1.k.n(IHostWebView.class)).getSafeJsbHostList());
        r100.add("lf-webcast-sourcecdn-tos.bytegecko.com");
        return r100;
    }

    @Override // f9.b
    public final void m1() {
        ((IHostWebView) jc1.k.n(IHostWebView.class)).initXBridge();
    }

    public AnnieExternalServiceImpl() {
        this.f64266a = LazyKt.lazy(AnnieExternalServiceImpl$resourceInterceptor$2.INSTANCE);
    }

    @Override // f9.b
    public final Map<String, String> getHeaderMap(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        HashMap r101 = new HashMap();
        r101.put(ByteNetEnvHeaderName.PPE, "1");
        r101.put("X-Tt-Env", ((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).getHostBoeParams().getPpeLane());
        return r101;
    L6:
        return new LinkedHashMap();
    }

    @Override // f9.b
    public final WebResourceResponse interceptRequest(String r100) {
        o30.a r101 = (o30.a) this.f64266a.getValue();
        String r102 = f64265b;
        r101.getClass();
        r101.f521864a = r102 + File.separator;
        o30.a r103 = (o30.a) this.f64266a.getValue();
        Uri r104 = UriProtector.parse(r100);
        r103.getClass();
        WebResourceResponse r105 = null;
        if (TextUtils.equals(r104.getScheme(), "liveresource") == true) goto L5;
    L28:
        WebResourceResponse r106 = null;
    L29:
        if (r106 != null) goto L44;
        ISaasHostWebView r107 = (ISaasHostWebView) jc1.k.f(ISaasHostWebView.class);     // Catch: Exception -> L34
        if (r107 == null) goto L37;
        r105 = r107.interceptRequestWithHost(r100);     // Catch: Exception -> L34
    L37:
        return r105;
    L34:
        e = move-exception;
        ALogger.e("interceptRequestWithHost", e.getMessage());
        goto L37
    L44:
        return r106;
    L5:
        if (TextUtils.equals(r104.getHost(), "file") == false) goto L28;
        if (TextUtils.isEmpty(r103.f521864a) == true) goto L28;
        String r108 = UriProtector.getQueryParameter(r104, "path");
        if (TextUtils.isEmpty(r108) == true) goto L28;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r108);
        String r110 = r109.getCanonicalPath();     // Catch: IOException -> L16
    L18:
        if (TextUtils.isEmpty(r110) == true) goto L28;
        if (r110.startsWith(r103.f521864a) == false) goto L28;
        if (r109.exists() == false) goto L28;
        r106 = new WebResourceResponse("", "", new PolarisFileInputStreamWrapper(r109));     // Catch: FileNotFoundException -> L27
    L16:
        r110 = null;
        goto L18
    }
}
