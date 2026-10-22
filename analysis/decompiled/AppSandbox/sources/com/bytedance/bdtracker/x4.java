package com.bytedance.bdtracker;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.log.AbstractAppLogLogger;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.util.WebViewJsUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class x4 {
    public static final List<String> a = Collections.singletonList("AppLogBridge");

    public static final class a {
        public String a;

        public final void a(String str, Object... objArr) {
            IAppLogLogger logger = AbstractAppLogLogger.getLogger(getAppId());
            if (logger == null) {
                logger = LoggerImpl.global();
            }
            logger.debug(x4.a, str, objArr);
        }

        @JavascriptInterface
        public void addHeaderInfo(String str, String str2) {
            a("_AppLogBridge:addHeaderInfo: {}, {}", str, str2);
            b.b(this.a).setHeaderInfo(str, str2);
        }

        @JavascriptInterface
        public String getABTestConfigValueForKey(String str, String str2) {
            a("_AppLogBridge:getABTestConfigValueForKey: {}, {}", str, str2);
            return (String) b.b(this.a).getAbConfig(str, str2);
        }

        @JavascriptInterface
        public String getAbSdkVersion() {
            a("_AppLogBridge:getAbSdkVersion", new Object[0]);
            return b.b(this.a).getAbSdkVersion();
        }

        @JavascriptInterface
        public String getAllAbTestConfigs() {
            a("_AppLogBridge:getAllAbTestConfigs", new Object[0]);
            JSONObject allAbTestConfigs = b.b(this.a).getAllAbTestConfigs();
            if (allAbTestConfigs != null) {
                return allAbTestConfigs.toString();
            }
            return null;
        }

        @JavascriptInterface
        public String getAppId() {
            return TextUtils.isEmpty(this.a) ? AppLog.getAppId() : this.a;
        }

        @JavascriptInterface
        public String getClientUdid() {
            a("_AppLogBridge:getClientUdid", new Object[0]);
            return b.b(this.a).getClientUdid();
        }

        @JavascriptInterface
        public String getIid() {
            a("_AppLogBridge:getIid", new Object[0]);
            return b.b(this.a).getIid();
        }

        @JavascriptInterface
        public String getOpenUdid() {
            a("_AppLogBridge:getOpenUdid", new Object[0]);
            return b.b(this.a).getOpenUdid();
        }

        @JavascriptInterface
        public String getSsid() {
            a("_AppLogBridge:getSsid", new Object[0]);
            return b.b(this.a).getSsid();
        }

        @JavascriptInterface
        public String getUdid() {
            a("_AppLogBridge:getUdid", new Object[0]);
            return b.b(this.a).getUdid();
        }

        @JavascriptInterface
        public String getUuid() {
            a("_AppLogBridge:getUuid", new Object[0]);
            return b.b(this.a).getUserUniqueID();
        }

        @JavascriptInterface
        @Deprecated
        public int hasStartedForJsSdkUnderV5_deprecated() {
            a("_AppLogBridge:hasStarted", new Object[0]);
            return b.b(this.a).hasStarted() ? 1 : 0;
        }

        @JavascriptInterface
        public void onEventV3(String str, String str2) {
            a("_AppLogBridge:onEventV3: {}, {}", str, str2);
            b.b(this.a).onEventV3(str, r.f(str2));
        }

        @JavascriptInterface
        public void profileAppend(String str) {
            a(com.bytedance.bdtracker.a.a("_AppLogBridge:profileAppend: ", str), new Object[0]);
            b.b(this.a).profileAppend(r.f(str));
        }

        @JavascriptInterface
        public void profileIncrement(String str) {
            a(com.bytedance.bdtracker.a.a("_AppLogBridge:profileIncrement: ", str), new Object[0]);
            b.b(this.a).profileIncrement(r.f(str));
        }

        @JavascriptInterface
        public void profileSet(String str) {
            a("_AppLogBridge:profileSet: {}", str);
            b.b(this.a).profileSet(r.f(str));
        }

        @JavascriptInterface
        public void profileSetOnce(String str) {
            a("_AppLogBridge:profileSetOnce: {}", str);
            b.b(this.a).profileSetOnce(r.f(str));
        }

        @JavascriptInterface
        public void profileUnset(String str) {
            a("_AppLogBridge:profileUnset: {}", str);
            b.b(this.a).profileUnset(str);
        }

        @JavascriptInterface
        public void removeHeaderInfo(String str) {
            a("_AppLogBridge:removeHeaderInfo: {}", str);
            b.b(this.a).removeHeaderInfo(str);
        }

        @JavascriptInterface
        public void setExternalAbVersion(String str) {
            a("_AppLogBridge:setExternalAbVersion: {}", str);
            b.b(this.a).setExternalAbVersion(str);
        }

        @JavascriptInterface
        public void setHeaderInfo(String str) {
            a("_AppLogBridge:setHeaderInfo: {}", str);
            if (TextUtils.isEmpty(str) || str.equals("undefined")) {
                b.b(this.a).setHeaderInfo(null);
                return;
            }
            JSONObject jSONObjectF = r.f(str);
            if (jSONObjectF == null) {
                return;
            }
            HashMap<String, Object> map = new HashMap<>();
            Iterator<String> itKeys = jSONObjectF.keys();
            while (itKeys.hasNext()) {
                try {
                    String next = itKeys.next();
                    map.put(next, jSONObjectF.get(next));
                } catch (JSONException e) {
                    a("_AppLogBridge: wrong Json format", e);
                    return;
                }
            }
            b.b(this.a).setHeaderInfo(map);
        }

        @JavascriptInterface
        public void setNativeAppId(String str) {
            a("_AppLogBridge:setNativeAppId: {}", str);
            if (TextUtils.isEmpty(str) || str.equals("undefined")) {
                str = null;
            }
            this.a = str;
        }

        @JavascriptInterface
        public void setUserUniqueId(String str) {
            a("_AppLogBridge:setUuid: {}", str);
            IAppLogInstance iAppLogInstanceB = b.b(this.a);
            InitConfig initConfig = iAppLogInstanceB.getInitConfig();
            if (initConfig != null ? initConfig.isUseBridgeUpdateUUIDEnabled() : true) {
                iAppLogInstanceB.setUserUniqueID(str);
            }
        }

        @JavascriptInterface
        public void setUserUniqueIdWithType(String str, String str2) {
            a("_AppLogBridge:setUuidWithType: {}, {}", str, str2);
            IAppLogInstance iAppLogInstanceB = b.b(this.a);
            InitConfig initConfig = iAppLogInstanceB.getInitConfig();
            if (initConfig != null ? initConfig.isUseBridgeUpdateUUIDEnabled() : true) {
                iAppLogInstanceB.setUserUniqueID(str, str2);
            }
        }
    }

    public static void a(View view) {
        LoggerImpl.global().debug(a, "Inject applog bridge compat js to: {}", view);
        WebViewJsUtil.evaluateJavascript(view, "if(typeof AppLogBridge !== 'undefined' && !AppLogBridge.hasOwnProperty('hasStarted')) { AppLogBridge.hasStarted = function(callback) {if(callback) callback(AppLogBridge.hasStartedForJsSdkUnderV5_deprecated());  return AppLogBridge.hasStartedForJsSdkUnderV5_deprecated();};}");
    }

    public static boolean a(View view, String str) {
        if (TextUtils.isEmpty(str)) {
            LoggerImpl.global().debug(a, "checkAllowList url is empty", new Object[0]);
        } else {
            List<d> listA = b.a(b.b);
            if (!listA.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList();
                boolean z = false;
                for (d dVar : listA) {
                    if (dVar.getInitConfig() != null) {
                        if (dVar.getInitConfig().isH5BridgeAllowAll()) {
                            z = true;
                        }
                        if (dVar.getInitConfig().getH5BridgeAllowlist() != null) {
                            arrayList.addAll(dVar.getInitConfig().getH5BridgeAllowlist());
                        }
                    }
                }
                if (!z) {
                    if (!arrayList.isEmpty()) {
                        try {
                            String host = Uri.parse(str).getHost();
                            if (TextUtils.isEmpty(host)) {
                                LoggerImpl.global().debug(a, "Host in url:{} is empty", str);
                            } else {
                                for (String str2 : arrayList) {
                                    try {
                                    } catch (Throwable th) {
                                        LoggerImpl.global().error(a, "Check allow list by pattern:{} failed", th, str2);
                                    }
                                    if (Pattern.compile(str2.replaceAll("\\.", "\\\\.").replaceAll("\\*", "[^\\\\.]*")).matcher(host).matches()) {
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            LoggerImpl.global().debug(a, com.bytedance.bdtracker.a.a("Parse host failed. url:", str), th2);
                        }
                    }
                }
                LoggerImpl.global().debug(a, "injectH5Bridge to url:{}", str);
                r.a(view, (Object) new a(), "AppLogBridge");
                return true;
            }
            LoggerImpl.global().debug(a, "No AppLog instance enabled h5 bridge", new Object[0]);
        }
        LoggerImpl.global().debug(a, "injectH5Bridge to url:{} not pass allowlist", str);
        return false;
    }
}
