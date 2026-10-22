package com.bytedance.android.openlive.wrapper;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.bytedance.android.livehostapi.wrap.AbsHostWebView;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import ry.i;

/* JADX INFO: loaded from: classes12.dex */
public class LiveHostWebViewWrapper extends AbsHostWebView {
    i webViewParam;

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWebView, com.bytedance.android.livehostapi.platform.IHostWebView
    public Object createJsBridge2(Context r100, Object r101) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWebView, com.bytedance.android.livehostapi.platform.ISaasHostWebView
    public String getFileProvider() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWebView, com.bytedance.android.livehostapi.platform.ISaasHostWebView
    public String getGeckoChannel(boolean r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWebView, com.bytedance.android.livehostapi.platform.IHostWebView
    public String getOfflineCacheDir() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWebView, com.bytedance.android.livehostapi.platform.IHostWebView
    public WebResourceResponse interceptRequest(String r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWebView, com.bytedance.android.livehostapi.platform.IHostWebView
    public boolean isSafeDomain(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWebView, com.bytedance.android.livehostapi.platform.IHostWebView
    public void setCachePrefix(List<Pattern> r100) {
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWebView, com.bytedance.android.livehostapi.platform.IHostWebView
    public List<String> getSafeJsbHostList() {
        return Collections.emptyList();
    }

    public LiveHostWebViewWrapper(i r100) {
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWebView, com.bytedance.android.livehostapi.platform.IHostWebView
    public Map<String, String> getHeaderMap(String r100) {
        return Collections.emptyMap();
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWebView, com.bytedance.android.livehostapi.platform.IHostWebView
    public List<String> getShareCookie(String r100) {
        return Collections.emptyList();
    }
}
