package com.android.ttcjpaysdk.base.gecko;

import android.content.Context;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ktextension.CJResult;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.bean.WebViewCommonConfig;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.base.utils.CJPaySharedPrefUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.env.INetEnv;
import com.bytedance.caijing.sdk.infra.base.api.gecko.GeckoService;
import com.bytedance.caijing.sdk.infra.base.api.localtest.CJLocalTestService;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.locallife.cube.bridge.POINativeModule;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import ve4.a;
import ve4.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/gecko/CJPayGeckoXUtils;", "", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayGeckoXUtils {
    private static final String CJ_PAY_WEB_OFFLINE_DATA_DIR = "/cjpayWebData/";
    public static final String CJ_PAY_WEB_OFFLINE_HTML_RESOURCE_MATCH_PATTERN = "HTML_RESOURCE_MATCH_PATTERN";
    public static final String CJ_PAY_WEB_OFFLINE_STATIC_RESOURCE_MATCH_PATTERN = "STATIC_RESOURCE_MATCH_PATTERN";
    public static final Companion Companion = null;
    private static final String DEFAULT_RES_ROOT_DIR = "offlineX";
    private static final String LIVE_GECKO_BOE_KEY = "68f927652a5370ec9f4ae1dbaf56fd85";
    private static final String LIVE_GECKO_ONLINE_KEY = "5fb33cde3ebff01c8433ddc22aac0816";
    private static final String LIVE_GECKO_TEST_KEY = "36723dc3e85a23e701d1697d57de07ed";

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0004J\u0012\u0010\u001f\u001a\u00020\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00142\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u0004\u0018\u00010\u0014J0\u0010&\u001a\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040)H\u0002J \u0010+\u001a\u00020'2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0004J \u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020-2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020-R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/android/ttcjpaysdk/base/gecko/CJPayGeckoXUtils$Companion;", "", "()V", "CJ_PAY_WEB_OFFLINE_DATA_DIR", "", "CJ_PAY_WEB_OFFLINE_HTML_RESOURCE_MATCH_PATTERN", "CJ_PAY_WEB_OFFLINE_STATIC_RESOURCE_MATCH_PATTERN", "DEFAULT_RES_ROOT_DIR", "LIVE_GECKO_BOE_KEY", "LIVE_GECKO_ONLINE_KEY", "LIVE_GECKO_TEST_KEY", "checkChannelUseful", "", "channel", "checkLiveChannelUseful", "fetchAccessKey", "fetchPrefix", "", "Ljava/util/regex/Pattern;", "webOfflineRule", "Lcom/android/ttcjpaysdk/base/gecko/CJPayOfflineRule;", "getAK", "getChannel", "url", "getChannelVersion", "getFileFromGecko", "Ljava/io/InputStream;", "path", "getGeckoService", "Lcom/bytedance/caijing/sdk/infra/base/api/gecko/GeckoService;", "getLiveAK", "getPath", "applicationContext", "Landroid/content/Context;", "parseWebOfflineRule", "webOfflineInfo", "Lorg/json/JSONObject;", "upDateGeckoSettings", "updateOfflineSP", "", "staticResourceMap", "", "htmlResourceMap", "uploadFalconInterceptResult", "result", "", POINativeModule.RESP_EXIST, "uploadInterceptResult", "offlineType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String fetchAccessKey() {
            if (CJPayHostInfo.serverType != 2) goto L5;
            return CJPayConstant.TT_CJ_PAY_GECKO_ACCESS_KEY_BOE;
        L5:
            return CJPayConstant.TT_CJ_PAY_GECKO_ACCESS_KEY_ONLINE;
        }

        public final GeckoService getGeckoService() {
            a.f554342a.getClass();
            return (GeckoService) a.a(GeckoService.class);
        }

        public final String getLiveAK() {
            String r100 = CJPayHostInfo.envChannel;
            if (Intrinsics.areEqual(r100, "boe") == false) goto L6;
            return CJPayGeckoXUtils.LIVE_GECKO_BOE_KEY;
        L6:
            if (Intrinsics.areEqual(r100, "local_test") == false) goto L8;
            return CJPayGeckoXUtils.LIVE_GECKO_TEST_KEY;
        L8:
            return CJPayGeckoXUtils.LIVE_GECKO_ONLINE_KEY;
        }

        public final String getAK() {
            WebViewCommonConfig r100 = CJPaySettingsManager.getInstance().getWebViewCommonConfig();
            Boolean r101 = null;
            if (r100 == null) goto L5;
            Boolean r102 = Boolean.valueOf(r100.use_new_env_ak);
        L6:
            boolean r103 = false;
            if (r102 == null) goto L9;
            boolean r104 = r102.booleanValue();
        L10:
            if (r104 == true) goto L21;
            CJLocalTestService r105 = (CJLocalTestService) b.b(CJLocalTestService.class);
            if (r105 == null) goto L14;
            Boolean r106 = Boolean.valueOf(r105.useNewEnvAk());
        L15:
            if (r106 == null) goto L17;
            boolean r107 = r106.booleanValue();
        L18:
            if (r107 == true) goto L21;
            return fetchAccessKey();
        L17:
            r107 = false;
            goto L18
        L14:
            r106 = null;
        L21:
            CJHostService r108 = (CJHostService) b.b(CJHostService.class);
            if (r108 == null) goto L33;
            INetEnv r109 = r108.getNetEnvHelper();
            if (r109 == null) goto L33;
            if (r109.isBoe() == false) goto L28;
        L31:
            boolean r110 = true;
        L32:
            r101 = Boolean.valueOf(r110);
            goto L33
        L28:
            if (r109.isPpe() == true) goto L31;
            r110 = false;
        L33:
            if (r101 == null) goto L35;
            r103 = r101.booleanValue();
        L35:
            if (r103 == false) goto L37;
            return CJPayConstant.TT_CJ_PAY_GECKO_ACCESS_KEY_BOE;
        L37:
            return CJPayConstant.TT_CJ_PAY_GECKO_ACCESS_KEY_ONLINE;
        L9:
            r104 = false;
            goto L10
        L5:
            r102 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CJPayOfflineRule upDateGeckoSettings() {
            String r100 = CJPaySettingsManager.getInstance().getSettingsInfo("cjpay_gecko_settings");
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            Object r102 = null;
            if (r101 == false) goto L61;
            return null;
        L61:
            CJPayOfflineRule r103 = parseWebOfflineRule(new JSONObject(r100).optJSONObject("intercept_rules"));     // Catch: Exception -> L56
            if (r103 != null) goto L59;
        L17:
            if (r102 != null) goto L19;
            return r103;
        L19:
            if ((!((Collection) r102).isEmpty()) == false) goto L83;
            HashMap r104 = new HashMap();     // Catch: Exception -> L15
            HashMap r105 = new HashMap();     // Catch: Exception -> L15
            Iterator r106 = ((Iterable) r102).iterator();     // Catch: Exception -> L15
        L22:
            if (r106.hasNext() == false) goto L54;
            CJPayOfflineRule.CustomConfigBean r107 = (CJPayOfflineRule.CustomConfigBean) r106.next();     // Catch: Exception -> L15
            if (r107.custom_open == false) goto L22;
            List<String> r108 = r107.host;     // Catch: Exception -> L15
            if (r108 == null) goto L22;
            Iterator<T> r109 = r108.iterator();     // Catch: Exception -> L15
        L29:
            if (r109.hasNext() == false) goto L22;
            String r110 = (String) r109.next();     // Catch: Exception -> L15
            if (r107.asset_path.length() <= 0) goto L33;
            boolean r111 = true;
        L34:
            if (r111 == false) goto L36;
            r104.put(r110 + r107.asset_path, r107.channel);     // Catch: Exception -> L15
        L36:
            List<CJPayOfflineRule.CustomConfigBean.HtmlFilesBean> r112 = r107.html_files;     // Catch: Exception -> L15
            if (r112 == null) goto L29;
            Iterator<T> r113 = r112.iterator();     // Catch: Exception -> L15
        L40:
            if (r113.hasNext() == false) goto L29;
            CJPayOfflineRule.CustomConfigBean.HtmlFilesBean r114 = (CJPayOfflineRule.CustomConfigBean.HtmlFilesBean) r113.next();     // Catch: Exception -> L15
            if (r107.intercept_html == false) goto L40;
            if (r114.path.length() <= 0) goto L46;
            boolean r115 = true;
        L47:
            if (r115 == false) goto L40;
            if (r114.file.length() <= 0) goto L51;
            boolean r116 = true;
        L52:
            if (r116 == false) goto L40;
            r105.put(r110 + r114.path, r107.channel + ';' + r114.file);     // Catch: Exception -> L15
            goto L40
        L51:
            r116 = false;
            goto L52
        L46:
            r115 = false;
            goto L47
        L33:
            r111 = false;
            goto L34
        L54:
            updateOfflineSP(r104, r105);     // Catch: Exception -> L15
            return r103;
        L15:
            e = e;
            r102 = r103;
        L57:
            CJBasicCommonUtils.reportCatchException("CJPayGeckoXUtils#upDateGeckoSettings", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayGeckoXUtils#upDateGeckoSettings", e);
            return r102;
        L83:
            return r103;
        L59:
            r102 = r103.custom_config;     // Catch: Exception -> L15
        L56:
            e = e;
            goto L57
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }

        private final CJPayOfflineRule parseWebOfflineRule(JSONObject r110) {
            if (r110 != null) goto L5;
            return null;
        L5:
            CJPayOfflineRule r100 = new CJPayOfflineRule();
            r100.offline_open = r110.optBoolean("offline_open");
            JSONArray r101 = r110.optJSONArray("custom_config");
            JSONArray r111 = r110.optJSONArray("falcon_config");
            if (r111 == null) goto L18;
            int r102 = r111.length();
            int r103 = 0;
        L8:
            if (r103 >= r102) goto L18;
            JSONObject r104 = r111.optJSONObject(r103);
            if (r104 == null) goto L17;
            CJPayOfflineRule.FalconConfigBean r105 = new CJPayOfflineRule.FalconConfigBean();
            r105.falcon_open = r104.optBoolean("falcon_open");
            JSONArray r106 = r104.optJSONArray("prefix");
            if (r106 == null) goto L16;
            int r107 = r106.length();
            int r108 = 0;
        L14:
            if (r108 >= r107) goto L16;
            r105.prefix.add(r106.optString(r108));
            r108 = r108 + 1;
        L16:
            r100.falcon_config.add(r105);
        L17:
            r103 = r103 + 1;
        L18:
            if (r101 == null) goto L38;
            int r112 = r101.length();
            int r109 = 0;
        L20:
            if (r109 >= r112) goto L38;
            JSONObject r113 = r101.optJSONObject(r109);
            if (r113 == null) goto L37;
            CJPayOfflineRule.CustomConfigBean r114 = new CJPayOfflineRule.CustomConfigBean();
            r114.channel = r113.optString("channel");
            r114.custom_open = r113.optBoolean("custom_open");
            r114.intercept_html = r113.optBoolean("intercept_html");
            r114.asset_path = r113.optString("asset_path");
            JSONArray r115 = r113.optJSONArray("host");
            if (r115 == null) goto L28;
            int r116 = r115.length();
            int r117 = 0;
        L26:
            if (r117 >= r116) goto L28;
            r114.host.add(r115.optString(r117));
            r117 = r117 + 1;
        L28:
            JSONArray r118 = r113.optJSONArray("html_files");
            if (r118 == null) goto L36;
            int r119 = r118.length();
            int r120 = 0;
        L31:
            if (r120 >= r119) goto L36;
            JSONObject r121 = r118.optJSONObject(r120);
            if (r121 == null) goto L35;
            List<CJPayOfflineRule.CustomConfigBean.HtmlFilesBean> r122 = r114.html_files;
            CJPayOfflineRule.CustomConfigBean.HtmlFilesBean r123 = new CJPayOfflineRule.CustomConfigBean.HtmlFilesBean();
            r123.path = r121.optString("path");
            r123.file = r121.optString("file");
            r122.add(r123);
        L35:
            r120 = r120 + 1;
        L36:
            r100.custom_config.add(r114);
        L37:
            r109 = r109 + 1;
        L38:
            return r100;
        }

        public final boolean checkChannelUseful(String r100) {
            GeckoService r101 = getGeckoService();
            if (r101 != null) goto L7;
            return false;
        L7:
            return r101.checkChannelUseful(r100, new PolarisFileWrapper(getPath$default(this, null, 1, null)), getAK());
        }

        public final boolean checkLiveChannelUseful(String r100) {
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L32
            if (r100 != null) goto L6;
        L9:
            boolean r102 = true;
        L10:
            String r103 = null;
            if (r102 == false) goto L13;
            String r104 = r100;
        L14:
            if (r104 == null) goto L16;
            return false;
        L16:
            StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L32
            Context r106 = CJPayHostInfo.applicationContext;     // Catch: Throwable -> L32
            if (r106 == null) goto L21;
            File r107 = r106.getFilesDir();     // Catch: Throwable -> L32
            if (r107 == null) goto L21;
            r103 = r107.getAbsolutePath();     // Catch: Throwable -> L32
        L21:
            r105.append(r103);     // Catch: Throwable -> L32
            r105.append(File.separator);     // Catch: Throwable -> L32
            r105.append("offlineX");     // Catch: Throwable -> L32
            String r108 = r105.toString();     // Catch: Throwable -> L32
            String r109 = CJPayHostInfo.envChannel;     // Catch: Throwable -> L32
            if (Intrinsics.areEqual(r109, "boe") == false) goto L25;
            String r110 = CJPayGeckoXUtils.LIVE_GECKO_BOE_KEY;
        L28:
            GeckoService r111 = CJPayGeckoXUtils.Companion.getGeckoService();     // Catch: Throwable -> L32
            if (r111 == null) goto L37;
            return r111.checkChannelUseful(r100, new PolarisFileWrapper(r108), r110);
        L37:
            return false;
        L25:
            if (Intrinsics.areEqual(r109, "local_test") == false) goto L27;
            r110 = CJPayGeckoXUtils.LIVE_GECKO_TEST_KEY;
            goto L28
        L27:
            r110 = CJPayGeckoXUtils.LIVE_GECKO_ONLINE_KEY;
            goto L28
        L13:
            r104 = null;
            goto L14
        L6:
            if (StringsKt.isBlank(r100) == true) goto L9;
            r102 = false;
        L32:
            th = move-exception;
            Result.Companion r112 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return false;
        }

        public final List<Pattern> fetchPrefix(CJPayOfflineRule r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            ArrayList r101 = new ArrayList();
            List<CJPayOfflineRule.FalconConfigBean> r102 = r100.falcon_config;
            if (r102 == null) goto L22;
            Iterator<T> r103 = r102.iterator();
        L9:
            if (r103.hasNext() == false) goto L22;
            CJPayOfflineRule.FalconConfigBean r104 = (CJPayOfflineRule.FalconConfigBean) r103.next();
            if (r104.falcon_open == false) goto L9;
            List<String> r105 = r104.prefix;
            if (r105 == null) goto L9;
            Iterator<T> r106 = r105.iterator();
        L16:
            if (r106.hasNext() == false) goto L9;
            r101.add(PatternProtector.compile((String) r106.next()));     // Catch: Exception -> L20
        L20:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayGeckoXUtils#fetchPrefix", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayGeckoXUtils#fetchPrefix", e);
        L22:
            return r101;
        }

        public final String getChannel(String r110) {
            Intrinsics.checkNotNullParameter(r110, "url");
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L41
            Companion r101 = CJPayGeckoXUtils.Companion;     // Catch: Throwable -> L41
            CJPayOfflineRule r102 = r101.upDateGeckoSettings();     // Catch: Throwable -> L41
            if (r102 != null) goto L6;
            return "";
        L6:
            List<Pattern> r103 = r101.fetchPrefix(r102);     // Catch: Throwable -> L41
            if (r103 != null) goto L9;
            return "";
        L9:
            Iterator<T> r104 = r103.iterator();     // Catch: Throwable -> L41
        L11:
            if (r104.hasNext() == false) goto L15;
            Object r105 = r104.next();     // Catch: Throwable -> L41
            if (((Pattern) r105).matcher(r110).find() == false) goto L11;
        L16:
            Pattern r106 = (Pattern) r105;     // Catch: Throwable -> L41
            if (r106 == null) goto L21;
            Matcher r107 = r106.matcher(r110);     // Catch: Throwable -> L41
            if (r107 == null) goto L21;
            r107.find();     // Catch: Throwable -> L41
        L22:
            if (r107 != null) goto L24;
            return "";
        L24:
            int r108 = StringsKt.indexOf$default(r110, "?", 0, false, 6, null);     // Catch: Throwable -> L41
            int r109 = StringsKt.indexOf$default(r110, "#", 0, false, 6, null);     // Catch: Throwable -> L41
            int r111 = Math.min(r108, r109);     // Catch: Throwable -> L41
            if (r111 != (-1)) goto L27;
            r111 = Math.max(r108, r109);     // Catch: Throwable -> L41
        L27:
            if (r111 == (-1)) goto L29;
            String r112 = r110.substring(r107.end(), r111);     // Catch: Throwable -> L41
        L31:
            if (StringsKt.endsWith$default(r112, HTTP.URL_DEFAULT, false, 2, null) == false) goto L34;
            r112 = r112.substring(0, r112.length() - 1);     // Catch: Throwable -> L41
        L34:
            if (StringsKt.startsWith$default(r112, HTTP.URL_DEFAULT, false, 2, null) == false) goto L36;
            r112 = r112.substring(1);     // Catch: Throwable -> L41
        L36:
            String r113 = r112.substring(0, StringsKt.indexOf$default(r112, HTTP.URL_DEFAULT, 0, false, 6, null));     // Catch: Throwable -> L41
            Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
        L44:
            Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L49
            if (r115 == null) goto L48;
            CJBasicCommonUtils.reportCatchException("CJPayGeckoXUtils#getChannel", r115);     // Catch: Throwable -> L49
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayGeckoXUtils#getChannel", r115);     // Catch: Throwable -> L49
            return "";
        L49:
            th = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayGeckoXUtils#getChannel", th);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayGeckoXUtils#getChannel", th);
            CJReporter r116 = CJReporter.f202294a;
            CJReporter.m(null, "CJPayGeckoXUtils_getChannel", 1, th);
            return "";
        L48:
            return r113;
        L39:
            Throwable th10 = th;
        L52:
            Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L49
            r114 = Result.m9449constructorimpl(ResultKt.createFailure(th10));     // Catch: Throwable -> L49
            goto L44
        L29:
            r112 = r110.substring(r107.end());     // Catch: Throwable -> L41
        L21:
            r107 = null;
            goto L22
        L15:
            r105 = null;
        L41:
            th = move-exception;
            th10 = th;
            r113 = "";
            goto L52
        }

        public final String getChannelVersion(String r100) {
            GeckoService r101 = getGeckoService();
            if (r101 == null) goto L6;
            String r102 = r101.getChannelVersion(r100, new PolarisFileWrapper(getPath$default(this, null, 1, null)), getAK());
            if (r102 == null) goto L6;
            return r102;
        L6:
            return "";
        }

        public final String getPath(Context r100) {
            if (r100 == null) goto L13;
            String r101 = r100.getFilesDir().getPath() + File.separator + "offlineX";     // Catch: Exception -> L8
            if (r101 != null) goto L14;
            return "/Android/data/cjpayWebData/";
        L14:
            return r101;
        L8:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayGeckoXUtils#getPath", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayGeckoXUtils#getPath", e);
            return "/Android/data/cjpayWebData/";
        L13:
            return "/Android/data/cjpayWebData/";
        }

        private final void updateOfflineSP(Map<String, String> r100, Map<String, String> r101) {
            if ((!r100.isEmpty()) == false) goto L6;
            CJPaySharedPrefUtils.clearMap(CJPayGeckoXUtils.CJ_PAY_WEB_OFFLINE_STATIC_RESOURCE_MATCH_PATTERN);
            CJPaySharedPrefUtils.singlePutMap(CJPayGeckoXUtils.CJ_PAY_WEB_OFFLINE_STATIC_RESOURCE_MATCH_PATTERN, r100);
        L6:
            if ((!r101.isEmpty()) == false) goto L9;
            CJPaySharedPrefUtils.clearMap(CJPayGeckoXUtils.CJ_PAY_WEB_OFFLINE_HTML_RESOURCE_MATCH_PATTERN);
            CJPaySharedPrefUtils.singlePutMap(CJPayGeckoXUtils.CJ_PAY_WEB_OFFLINE_HTML_RESOURCE_MATCH_PATTERN, r101);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final InputStream getFileFromGecko(String r210, String r211) {
            Intrinsics.checkNotNullParameter(r210, "channel");
            Intrinsics.checkNotNullParameter(r211, "path");
            boolean r100 = this instanceof ICJTag;
            String r101 = "runCatching";
            if (r100 == false) goto L10;
            String r102 = ((ICJTag) this).CJTag();
            if (r102 == null) goto L10;
            if (StringsKt.isBlank(r102) == false) goto L9;
            r102 = "runCatching";
        L9:
            String r103 = r102;
        L12:
            if (StringsKt.isBlank(r103) == false) goto L21;
            if (r100 == false) goto L20;
            String r104 = ((ICJTag) this).CJTag();
            if (r104 == null) goto L20;
            if (StringsKt.isBlank(r104) == true) goto L20;
            r101 = r104;
        L20:
            String r105 = r101;
        L22:
            String r110 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
            CJLogger.a(r105, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
            long r111 = System.currentTimeMillis();
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L27
            Companion r107 = CJPayGeckoXUtils.Companion;     // Catch: Throwable -> L27
            PolarisFileWrapper r108 = new PolarisFileWrapper(getPath$default(r107, null, 1, null));     // Catch: Throwable -> L27
            a.f554342a.getClass();     // Catch: Throwable -> L27
            GeckoService r109 = (GeckoService) a.a(GeckoService.class);     // Catch: Throwable -> L27
            if (r109 == null) goto L47;
            return r109.getFileFromGecko(CJEnv.a(), r108, r107.getAK(), r210, r211);
        L47:
            return null;
        L27:
            th = move-exception;
            Result.Companion r112 = Result.Companion;
            Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            if (Result.m9456isSuccessimpl(r113) == false) goto L31;
            CJLogger.d(r105, "onSuccess\n " + r110);
            Object r114 = r113;
            boolean r115 = true;
        L32:
            Throwable r116 = Result.m9452exceptionOrNullimpl(r113);
            if (r116 == null) goto L35;
            CJBasicCommonUtils.reportCatchException("CJResult#unknown", r116);
            CJLogger.c(r105, "onFailure", r116);
            r115 = false;
        L36:
            long r117 = System.currentTimeMillis() - r111;
            CJLogger.d(r105, "is_success: " + r115 + ", duration: " + r117);
            CJReporter r118 = CJReporter.f202294a;
            Set<String> r119 = CJContext.f202254w;
            String r120 = "";
            CJContext r121 = CJContext.c.a(r103, "", "", new HashMap());
            Pair[] r122 = new Pair[5];
            r122[0] = TuplesKt.to("tag", r103);
            r122[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r115, "1", "0"));
            if (r116 == null) goto L39;
            String r123 = r116.getMessage();
        L40:
            if (r123 == null) goto L43;
            r120 = r123;
        L43:
            r122[2] = TuplesKt.to("error_msg", r120);
            r122[3] = TuplesKt.to("trace", r110);
            r122[4] = TuplesKt.to("duration", Long.valueOf(r117));
            CJReporter.o(r121, "cjpay_run_catch_result", MapsKt.mapOf(r122));
            new CJResult(r114, r115, r116);
            return null;
        L39:
            r123 = null;
            goto L40
        L35:
            r116 = null;
            goto L36
        L31:
            r114 = null;
            r115 = false;
            goto L32
        L21:
            r105 = r103;
        L10:
            r103 = "runCatching";
            goto L12
        }

        public final void uploadFalconInterceptResult(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, POINativeModule.RESP_EXIST);
            JSONObject r103 = CJPayParamsUtils.getCommonLogParams("", "");
            if (r100 != null) goto L12;
            r100 = "";
        L12:
            r103.put("url", r100);     // Catch: Exception -> L8
            r103.put("result", r101);     // Catch: Exception -> L8
            r103.put("is_exist", r102);     // Catch: Exception -> L8
        L10:
            CJPayCallBackCenter.getInstance().onEvent("wallet_rd_falcon_intercept_result", new JSONObject[]{r103});
            return;
        L8:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayGeckoXUtils#uploadFalconInterceptResult", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayGeckoXUtils#uploadFalconInterceptResult", e);
            goto L10
        }

        public final void uploadInterceptResult(int r100, String r101, int r102) {
            JSONObject r103 = CJPayParamsUtils.getCommonLogParams("", "");
            r103.put("intercept_type", r100);     // Catch: Exception -> L8
            if (r101 != null) goto L6;
            r101 = "";
        L6:
            r103.put("intercept_url", r101);     // Catch: Exception -> L8
            r103.put("intercept_result", r102);     // Catch: Exception -> L8
        L10:
            CJPayCallBackCenter.getInstance().onEvent("wallet_rd_intercept_result", new JSONObject[]{r103});
            return;
        L8:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayGeckoXUtils#uploadInterceptResult", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayGeckoXUtils#uploadInterceptResult", e);
            goto L10
        }

        public static /* synthetic */ String getPath$default(Companion r100, Context r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = CJPayHostInfo.applicationContext;
        L6:
            return r100.getPath(r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPayGeckoXUtils() {
    }
}
