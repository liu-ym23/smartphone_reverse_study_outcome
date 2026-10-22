package com.android.ttcjpaysdk.base.gecko;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.service.IUpdateConfig;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.caijing.sdk.infra.base.api.gecko.GeckoService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/base/gecko/CJPayGeckoXManager;", "", "()V", "accessKey", "", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "deviceId", "falconWebOffline", "geckoClient", "resPath", "resRootDir", "Ljava/io/File;", "webOfflineRules", "Lcom/android/ttcjpaysdk/base/gecko/CJPayOfflineRule;", "forceUpdateChannel", "", "config", "Lcom/android/ttcjpaysdk/base/service/IUpdateConfig;", "initFalcon", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "initGeckoClient", "appId", a.KEY_DID, "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "webView", "Landroid/webkit/WebView;", "url", "updateConfigWrapper", "updateConfig", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayGeckoXManager {
    public static final CJPayGeckoXManager INSTANCE = null;
    private static String accessKey;
    private static String deviceId;
    private static Object falconWebOffline;
    private static Object geckoClient;
    private static String resPath;
    private static File resRootDir;
    private static CJPayOfflineRule webOfflineRules;

    private CJPayGeckoXManager() {
    }

    static {
        INSTANCE = new CJPayGeckoXManager();
        resPath = "";
        accessKey = "";
        CJPayGeckoXUtils.Companion r100 = CJPayGeckoXUtils.Companion;
        accessKey = r100.getAK();
        resPath = CJPayGeckoXUtils.Companion.getPath$default(r100, null, 1, null);
        resRootDir = new PolarisFileWrapper(resPath);
    }

    public final String getAccessKey() {
        return accessKey;
    }

    private final void initFalcon(Context r110) {
        CJPayGeckoXUtils.Companion r100 = CJPayGeckoXUtils.Companion;
        GeckoService r101 = r100.getGeckoService();
        if (r101 == null) goto L5;
        Object r111 = r101.initFalcon(r110, accessKey, deviceId, CJPayConstant.TT_CJ_PAY_GECKO_HOST, r100.fetchPrefix(webOfflineRules), CollectionsKt.mutableListOf(new Uri[]{Uri.fromFile(resRootDir)}), new CJPayFalconXInterceptor());
    L6:
        falconWebOffline = r111;
        return;
    L5:
        r111 = null;
        goto L6
    }

    private final IUpdateConfig updateConfigWrapper(final IUpdateConfig r100) {
        return new C88411(r100);
    }

    public final void forceUpdateChannel(IUpdateConfig r100) {
        if (r100 == null) goto L16;
        List<String> r101 = r100.getChannelList();
        if (r101 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L18;
        IUpdateConfig r103 = updateConfigWrapper(r100);
        GeckoService r104 = CJPayGeckoXUtils.Companion.getGeckoService();
        if (r104 == null) goto L17;
        r104.forceUpdateChannel(r103, new AnonymousClass1());
        return;
    L17:
        return;
    L18:
        return;
    L6:
        if (r101.isEmpty() == true) goto L9;
        r102 = false;
        goto L10
    }

    public final void setAccessKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        accessKey = r100;
    }

    public final WebResourceResponse shouldInterceptRequest(String r100, Context r101) {
        boolean r102 = true;
        boolean r103 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L13;
        return null;
    L13:
        if (webOfflineRules != null) goto L15;
        webOfflineRules = CJPayGeckoXUtils.Companion.upDateGeckoSettings();
    L15:
        CJPayOfflineRule r105 = webOfflineRules;
        if (r105 != null) goto L18;
    L20:
        r102 = false;
    L21:
        if (r102 == true) goto L23;
        StringBuilder r106 = new StringBuilder("offline_open: ");
        CJPayOfflineRule r107 = webOfflineRules;
        if (r107 == null) goto L32;
        Boolean r108 = Boolean.valueOf(r107.offline_open);
    L33:
        if (r108 == null) goto L35;
        r103 = r108.booleanValue();
    L35:
        r106.append(r103);
        CJLogger.d("CJPayGeckoXManager", r106.toString());
        return null;
    L32:
        r108 = null;
        goto L33
    L23:
        if (falconWebOffline != null) goto L26;
        if (r101 == null) goto L26;
        initFalcon(r101);
    L26:
        GeckoService r109 = CJPayGeckoXUtils.Companion.getGeckoService();
        if (r109 != null) goto L38;
        return null;
    L38:
        return r109.shouldInterceptRequest(falconWebOffline, null, r100);
    L18:
        if (r105.offline_open != true) goto L20;
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L10
    }

    public final void initGeckoClient(String r110, String r111, Context r112) {
        Intrinsics.checkNotNullParameter(r111, a.KEY_DID);
        if (r112 != null) goto L5;
        return;
    L5:
        deviceId = r111;
        GeckoService r100 = CJPayGeckoXUtils.Companion.getGeckoService();
        if (r100 == null) goto L11;
        if (r110 == null) goto L9;
        long r101 = CastLongProtector.parseLong(r110);
    L10:
        Object r113 = r100.initGeckoClient(r101, r111, r112, accessKey, CJPayConstant.TT_CJ_PAY_GECKO_HOST, CJPayBasicUtils.getRealVersion(), resRootDir, CJPayConstant.TT_CJ_PAY_GECKO_GROUP_TYPE);
    L12:
        geckoClient = r113;
        return;
    L9:
        r101 = -1;
        goto L10
    L11:
        r113 = null;
        goto L12
    }

    public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101, Context r102) {
        if (r100 == null) goto L38;
        boolean r103 = true;
        boolean r104 = false;
        if (r101 != null) goto L7;
    L10:
        boolean r105 = true;
    L11:
        if (r105 == true) goto L39;
        if (r102 != null) goto L15;
        return null;
    L15:
        if (webOfflineRules != null) goto L17;
        webOfflineRules = CJPayGeckoXUtils.Companion.upDateGeckoSettings();
    L17:
        CJPayOfflineRule r106 = webOfflineRules;
        if (r106 != null) goto L20;
    L22:
        r103 = false;
    L23:
        if (r103 == true) goto L25;
        StringBuilder r107 = new StringBuilder("offline_open: ");
        CJPayOfflineRule r108 = webOfflineRules;
        if (r108 == null) goto L33;
        Boolean r109 = Boolean.valueOf(r108.offline_open);
    L34:
        if (r109 == null) goto L36;
        r104 = r109.booleanValue();
    L36:
        r107.append(r104);
        CJLogger.d("CJPayGeckoXManager", r107.toString());
        return null;
    L33:
        r109 = null;
        goto L34
    L25:
        if (falconWebOffline != null) goto L27;
        initFalcon(r102);
    L27:
        GeckoService r110 = CJPayGeckoXUtils.Companion.getGeckoService();
        if (r110 != null) goto L41;
        return null;
    L41:
        return r110.shouldInterceptRequest(falconWebOffline, r100, r101);
    L20:
        if (r106.offline_open != true) goto L22;
    L39:
        return null;
    L7:
        if (r101.length() == 0) goto L10;
        r105 = false;
        goto L11
    L38:
        return null;
    }
}
