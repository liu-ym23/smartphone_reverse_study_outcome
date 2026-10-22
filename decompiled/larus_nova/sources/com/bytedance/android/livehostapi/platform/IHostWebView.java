package com.bytedance.android.livehostapi.platform;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.platform.base.IBaseHostWebView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostWebView extends IService, IBaseHostWebView {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.IHostWebView$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ArrayList $default$getXBridgeMethods(IHostWebView r100) {
            return null;
        }
    }

    Object createJsBridge2(Context r100, Object r101);

    Map<String, String> getHeaderMap(String r100);

    String getHostGeckoCacheDir();

    String getOfflineCacheDir();

    List<String> getSafeJsbHostList();

    List<String> getShareCookie(String r100);

    ArrayList<Class> getXBridgeMethods();

    void initXBridge();

    WebResourceResponse interceptRequest(String r100);

    boolean isSafeDomain(String r100);

    void setCachePrefix(List<Pattern> r100);
}
