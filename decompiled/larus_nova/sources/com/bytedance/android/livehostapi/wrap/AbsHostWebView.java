package com.bytedance.android.livehostapi.wrap;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.bytedance.android.livehostapi.platform.ISaasHostWebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public class AbsHostWebView implements ISaasHostWebView {
    public AbsHostWebView() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostWebView
    public Object createJsBridge2(Context r100, Object r101) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.platform.ISaasHostWebView
    public String getFileProvider() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.platform.ISaasHostWebView
    public String getGeckoChannel(boolean r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostWebView
    public String getHostGeckoCacheDir() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostWebView
    public String getOfflineCacheDir() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.platform.ISaasHostWebView, com.bytedance.android.livehostapi.platform.IHostWebView
    public final /* synthetic */ ArrayList getXBridgeMethods() {
        return ISaasHostWebView.CC.$default$getXBridgeMethods(this);
    }

    @Override // com.bytedance.android.livehostapi.platform.ISaasHostWebView, com.bytedance.android.livehostapi.platform.IHostWebView
    public void initXBridge() {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostWebView
    public WebResourceResponse interceptRequest(String r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.platform.ISaasHostWebView
    public WebResourceResponse interceptRequestWithHost(String r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostWebView
    public boolean isSafeDomain(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostWebView
    public void setCachePrefix(List<Pattern> r100) {
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostWebView
    public List<String> getSafeJsbHostList() {
        return Collections.emptyList();
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostWebView
    public Map<String, String> getHeaderMap(String r100) {
        return Collections.emptyMap();
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostWebView
    public List<String> getShareCookie(String r100) {
        return Collections.emptyList();
    }
}
