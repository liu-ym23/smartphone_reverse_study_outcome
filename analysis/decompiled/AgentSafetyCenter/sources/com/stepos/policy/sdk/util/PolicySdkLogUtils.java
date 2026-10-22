package com.stepos.policy.sdk.util;

import android.util.Log;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;
import yb.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicySdkLogUtils {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "PolicySDK";
    private static volatile boolean enabled;

    public static final boolean getEnabled() {
        return Companion.getEnabled();
    }

    public static final void setEnabled(boolean z10) {
        Companion.setEnabled(z10);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final String checkNewestSuggestion(int i, String str) {
            return (i == -10001 && k.a(str, "NO_LOCAL_FILE")) ? "先调用 PolicySdk.initSDK，且 policyCategoryMap 包含当前 category" : i == -10001 ? "检查 appId/appSecret/appVersionName/language/category 是否已 initSDK" : i == -10002 ? "本地协议文件名需为 {category}_{version}.html，检查 initSDK 拷贝是否成功" : (i == -10004 || k.a(str, "NO_NETWORK_WITH_LOCAL")) ? "当前无网络，已返回本地缓存路径，可展示本地协议；有网后重试 checkNewestPolicy" : (i == -1 && k.a(str, "NO_NETWORK_NO_LOCAL")) ? "无网络且无本地文件，需联网后检测，或确认 initSDK 已完成且 user_de 路径配置正确" : (i == -1 && k.a(str, "HTTP_FAILED")) ? "服务端请求失败，检查 appId/appSecret 签名、网络代理与服务端状态" : (i == -1 && k.a(str, "DOWNLOAD_FAILED")) ? "新版本下载失败，检查网络与存储权限" : (i == -1 && k.a(str, "SERVER_EMPTY_DATA")) ? "服务端返回空数据，联系协议平台确认 category 是否已配置" : i == -1 ? "查看上方原因日志；确认 initSDK、网络、category 与 DeviceProtectedStorage 配置" : "查看 PolicySDK 日志中 >>> START 与 >>> END 之间的详情";
        }

        public static /* synthetic */ void logCheckNewestResult$default(Companion companion, PolicySdkResultBean policySdkResultBean, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = "";
            }
            companion.logCheckNewestResult(policySdkResultBean, str, str2);
        }

        public final void d(String str, String str2) {
            str.getClass();
            str2.getClass();
            if (getEnabled()) {
                Log.d(PolicySdkLogUtils.TAG, str + " | " + str2);
            }
        }

        public final void e(String str, String str2) {
            str.getClass();
            str2.getClass();
            Log.e(PolicySdkLogUtils.TAG, str + " | " + str2);
        }

        public final String errorCodeLabel(int i) {
            if (i == -1) {
                return "FAILED(-1)";
            }
            if (i == 0) {
                return "SUCCESS(0)";
            }
            switch (i) {
                case PolicySdkErrorCode.NETWORK_ERROR /* -10004 */:
                    return "NETWORK_ERROR(-10004)";
                case PolicySdkErrorCode.NOT_NETWORK /* -10003 */:
                    return "NOT_NETWORK(-10003)";
                case PolicySdkErrorCode.PARAMETER_LOCAL_FILE_NAME_ERROR /* -10002 */:
                    return "PARAMETER_LOCAL_FILE_NAME_ERROR(-10002)";
                case PolicySdkErrorCode.PARAMETER_ERROR /* -10001 */:
                    return "PARAMETER_ERROR(-10001)";
                default:
                    return "UNKNOWN(" + i + ')';
            }
        }

        public final boolean getEnabled() {
            return PolicySdkLogUtils.enabled;
        }

        public final void i(String str, String str2) {
            str.getClass();
            str2.getClass();
            if (getEnabled()) {
                Log.i(PolicySdkLogUtils.TAG, str + " | " + str2);
            }
        }

        public final void logCheckNewestResult(PolicySdkResultBean policySdkResultBean, String str, String str2) {
            policySdkResultBean.getClass();
            str.getClass();
            str2.getClass();
            String str3 = policySdkResultBean.getPolicyRegrantFlag() ? "需弹再次授权" : "无需再次授权";
            String str4 = policySdkResultBean.getPolicyNewest() ? "本地已是最新" : "本地非最新/已拉取新版";
            StringBuilder sbO = androidx.activity.b.o(">>> END [", str, "] code=");
            sbO.append(errorCodeLabel(policySdkResultBean.getCode()));
            sbO.append(", ");
            sbO.append(str4);
            sbO.append(", ");
            sbO.append(str3);
            sbO.append(", localVersion=");
            sbO.append(policySdkResultBean.getPolicyNewestVersion());
            sbO.append(", serverVersion=");
            sbO.append(policySdkResultBean.getVersionServer());
            String string = sbO.toString();
            if (policySdkResultBean.getCode() == 0) {
                i("checkNewestPolicy", string);
                if (str2.length() > 0) {
                    d("checkNewestPolicy", str2);
                }
                if (policySdkResultBean.getPolicyRegrantFlag()) {
                    i("checkNewestPolicy", "回调建议: code==SUCCESS && !policyNewest && policyRegrantFlag → 弹更新授权框");
                    return;
                }
                return;
            }
            e("checkNewestPolicy", string);
            if (str2.length() > 0) {
                e("checkNewestPolicy", "原因: ".concat(str2));
            }
            e("checkNewestPolicy", "建议: " + checkNewestSuggestion(policySdkResultBean.getCode(), str));
        }

        public final void logCheckNewestStart(String str, String str2, boolean z10, boolean z11, String str3, boolean z12, String str4) {
            str.getClass();
            str2.getClass();
            StringBuilder sb2 = new StringBuilder(">>> START category=");
            sb2.append(str);
            sb2.append(", language=");
            sb2.append(str2);
            sb2.append(", network=");
            sb2.append(z10);
            sb2.append(", localFile=");
            sb2.append(z11);
            sb2.append(", syncDone=");
            sb2.append(z12);
            sb2.append(", storage=");
            if (str4 == null) {
                str4 = "unknown";
            }
            sb2.append(str4);
            i("checkNewestPolicy", sb2.toString());
            if (!z11 || str3 == null || str3.length() == 0) {
                return;
            }
            d("checkNewestPolicy", "localPath=" + str3);
        }

        public final void setEnabled(boolean z10) {
            PolicySdkLogUtils.enabled = z10;
        }

        public final void w(String str, String str2) {
            str.getClass();
            str2.getClass();
            Log.w(PolicySdkLogUtils.TAG, str + " | " + str2);
        }

        private Companion() {
        }

        public static /* synthetic */ void getEnabled$annotations() {
        }

        public final void d(String str) {
            str.getClass();
            if (getEnabled()) {
                Log.d(PolicySdkLogUtils.TAG, str);
            }
        }
    }
}
