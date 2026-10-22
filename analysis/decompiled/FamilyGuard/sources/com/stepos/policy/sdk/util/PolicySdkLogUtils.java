package com.stepos.policy.sdk.util;

import android.util.Log;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;
import j4.k;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class PolicySdkLogUtils {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "PolicySDK";
    private static volatile boolean enabled;

    public static final class Companion {
        public /* synthetic */ Companion(j4.g gVar) {
            this();
        }

        private final String checkNewestSuggestion(int i5, String str) {
            return (i5 == -10001 && k.b(str, "NO_LOCAL_FILE")) ? "先调用 PolicySdk.initSDK，且 policyCategoryMap 包含当前 category" : i5 == -10001 ? "检查 appId/appSecret/appVersionName/language/category 是否已 initSDK" : i5 == -10002 ? "本地协议文件名需为 {category}_{version}.html，检查 initSDK 拷贝是否成功" : k.b(str, "NO_APP_SECRET") ? "无法换取 appSecret，已返回本地缓存；检查网络、/app/secret 接口，或在 initSDK 传入兜底 appSecret 后重试" : (i5 == -10004 || k.b(str, "NO_NETWORK_WITH_LOCAL")) ? "当前无网络，已返回本地缓存路径，可展示本地协议；有网后重试 checkNewestPolicy" : (i5 == -1 && k.b(str, "NO_NETWORK_NO_LOCAL")) ? "无网络且无本地文件，需联网后检测，或确认 initSDK 已完成且 user_de 路径配置正确" : (i5 == -1 && k.b(str, "HTTP_FAILED")) ? "服务端请求失败，检查 appId/appSecret 签名、网络代理与服务端状态" : (i5 == -1 && k.b(str, "DOWNLOAD_FAILED")) ? "新版本下载失败，检查网络与存储权限" : (i5 == -1 && k.b(str, "SERVER_EMPTY_DATA")) ? "服务端返回空数据，联系协议平台确认 category 是否已配置" : i5 == -1 ? "查看上方原因日志；确认 initSDK、网络、category 与 DeviceProtectedStorage 配置" : "查看 PolicySDK 日志中 >>> START 与 >>> END 之间的详情";
        }

        public static /* synthetic */ void getEnabled$annotations() {
        }

        public static /* synthetic */ void logCheckNewestResult$default(Companion companion, PolicySdkResultBean policySdkResultBean, String str, String str2, int i5, Object obj) {
            if ((i5 & 4) != 0) {
                str2 = BuildConfig.FLAVOR;
            }
            companion.logCheckNewestResult(policySdkResultBean, str, str2);
        }

        public final void d(String str, String str2) {
            k.g(str, "method");
            k.g(str2, "msg");
            if (getEnabled()) {
                Log.d(PolicySdkLogUtils.TAG, str + " | " + str2);
            }
        }

        public final void e(String str, String str2) {
            k.g(str, "method");
            k.g(str2, "msg");
            Log.e(PolicySdkLogUtils.TAG, str + " | " + str2);
        }

        public final String errorCodeLabel(int i5) {
            if (i5 == -1) {
                return "FAILED(-1)";
            }
            if (i5 == 0) {
                return "SUCCESS(0)";
            }
            switch (i5) {
                case PolicySdkErrorCode.NETWORK_ERROR /* -10004 */:
                    return "NETWORK_ERROR(-10004)";
                case PolicySdkErrorCode.NOT_NETWORK /* -10003 */:
                    return "NOT_NETWORK(-10003)";
                case PolicySdkErrorCode.PARAMETER_LOCAL_FILE_NAME_ERROR /* -10002 */:
                    return "PARAMETER_LOCAL_FILE_NAME_ERROR(-10002)";
                case PolicySdkErrorCode.PARAMETER_ERROR /* -10001 */:
                    return "PARAMETER_ERROR(-10001)";
                default:
                    return "UNKNOWN(" + i5 + ')';
            }
        }

        public final boolean getEnabled() {
            return PolicySdkLogUtils.enabled;
        }

        public final void i(String str, String str2) {
            k.g(str, "method");
            k.g(str2, "msg");
            if (getEnabled()) {
                Log.i(PolicySdkLogUtils.TAG, str + " | " + str2);
            }
        }

        public final void logCheckNewestResult(PolicySdkResultBean policySdkResultBean, String str, String str2) {
            k.g(policySdkResultBean, "result");
            k.g(str, "scenario");
            k.g(str2, "detail");
            String str3 = policySdkResultBean.getPolicyRegrantFlag() ? "需弹再次授权" : "无需再次授权";
            String str4 = ">>> END [" + str + "] code=" + errorCodeLabel(policySdkResultBean.getCode()) + ", " + (policySdkResultBean.getPolicyNewest() ? "本地已是最新" : "本地非最新/已拉取新版") + ", " + str3 + ", localVersion=" + policySdkResultBean.getPolicyNewestVersion() + ", serverVersion=" + policySdkResultBean.getVersionServer();
            if (policySdkResultBean.getCode() == 0) {
                i("checkNewestPolicy", str4);
                if (str2.length() > 0) {
                    d("checkNewestPolicy", str2);
                }
                if (policySdkResultBean.getPolicyRegrantFlag()) {
                    i("checkNewestPolicy", "回调建议: code==SUCCESS && !policyNewest && policyRegrantFlag → 弹更新授权框");
                    return;
                }
                return;
            }
            e("checkNewestPolicy", str4);
            if (str2.length() > 0) {
                e("checkNewestPolicy", "原因: " + str2);
            }
            e("checkNewestPolicy", "建议: " + checkNewestSuggestion(policySdkResultBean.getCode(), str));
        }

        public final void logCheckNewestStart(String str, String str2, boolean z5, boolean z6, String str3, boolean z7, String str4) {
            k.g(str, "category");
            k.g(str2, "language");
            StringBuilder sb = new StringBuilder();
            sb.append(">>> START category=");
            sb.append(str);
            sb.append(", language=");
            sb.append(str2);
            sb.append(", network=");
            sb.append(z5);
            sb.append(", localFile=");
            sb.append(z6);
            sb.append(", syncDone=");
            sb.append(z7);
            sb.append(", storage=");
            if (str4 == null) {
                str4 = "unknown";
            }
            sb.append(str4);
            i("checkNewestPolicy", sb.toString());
            if (!z6 || str3 == null || str3.length() == 0) {
                return;
            }
            d("checkNewestPolicy", "localPath=" + str3);
        }

        public final void setEnabled(boolean z5) {
            PolicySdkLogUtils.enabled = z5;
        }

        public final void w(String str, String str2) {
            k.g(str, "method");
            k.g(str2, "msg");
            Log.w(PolicySdkLogUtils.TAG, str + " | " + str2);
        }

        private Companion() {
        }

        public final void d(String str) {
            k.g(str, "method");
            if (getEnabled()) {
                Log.d(PolicySdkLogUtils.TAG, String.valueOf(str));
            }
        }
    }

    public static final boolean getEnabled() {
        return Companion.getEnabled();
    }

    public static final void setEnabled(boolean z5) {
        Companion.setEnabled(z5);
    }
}
