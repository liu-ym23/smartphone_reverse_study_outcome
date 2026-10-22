package com.bytedance.android.livehostapi.platform;

import android.webkit.WebResourceResponse;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public interface ISaasHostWebView extends IHostWebView {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.ISaasHostWebView$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ArrayList $default$getXBridgeMethods(ISaasHostWebView r100) {
            return null;
        }
    }

    String getFileProvider();

    String getGeckoChannel(boolean r100);

    @Override // com.bytedance.android.livehostapi.platform.IHostWebView
    ArrayList<Class> getXBridgeMethods();

    @Override // com.bytedance.android.livehostapi.platform.IHostWebView
    void initXBridge();

    WebResourceResponse interceptRequestWithHost(String r100);
}
