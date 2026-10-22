package com.stepos.policy.sdk.util;

import android.util.Log;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicySdkLogUtils {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "PolicySDK";
    private static volatile boolean enabled;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private final String checkNewestSuggestion(int i10, String str) {
            return (i10 == -10001 && kotlin.jvm.internal.g.b(str, "NO_LOCAL_FILE")) ? "先调用 PolicySdk.initSDK，且 policyCategoryMap 包含当前 category" : i10 == -10001 ? "检查 appId/appSecret/appVersionName/language/category 是否已 initSDK" : i10 == -10002 ? "本地协议文件名需为 {category}_{version}.html，检查 initSDK 拷贝是否成功" : kotlin.jvm.internal.g.b(str, "NO_APP_SECRET") ? "无法换取 appSecret，已返回本地缓存；检查网络、/app/secret 接口，或在 initSDK 传入兜底 appSecret 后重试" : (i10 == -10004 || kotlin.jvm.internal.g.b(str, "NO_NETWORK_WITH_LOCAL")) ? "当前无网络，已返回本地缓存路径，可展示本地协议；有网后重试 checkNewestPolicy" : (i10 == -1 && kotlin.jvm.internal.g.b(str, "NO_NETWORK_NO_LOCAL")) ? "无网络且无本地文件，需联网后检测，或确认 initSDK 已完成且 user_de 路径配置正确" : (i10 == -1 && kotlin.jvm.internal.g.b(str, "HTTP_FAILED")) ? "服务端请求失败，检查 appId/appSecret 签名、网络代理与服务端状态" : (i10 == -1 && kotlin.jvm.internal.g.b(str, "DOWNLOAD_FAILED")) ? "新版本下载失败，检查网络与存储权限" : (i10 == -1 && kotlin.jvm.internal.g.b(str, "SERVER_EMPTY_DATA")) ? "服务端返回空数据，联系协议平台确认 category 是否已配置" : i10 == -1 ? "查看上方原因日志；确认 initSDK、网络、category 与 DeviceProtectedStorage 配置" : "查看 PolicySDK 日志中 >>> START 与 >>> END 之间的详情";
        }

        public static /* synthetic */ void logCheckNewestResult$default(Companion companion, PolicySdkResultBean policySdkResultBean, String str, String str2, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str2 = "";
            }
            companion.logCheckNewestResult(policySdkResultBean, str, str2);
        }

        public final void d(String method, String msg) {
            kotlin.jvm.internal.g.f(method, "method");
            kotlin.jvm.internal.g.f(msg, "msg");
            if (getEnabled()) {
                Log.d(PolicySdkLogUtils.TAG, method + " | " + msg);
            }
        }

        public final void e(String method, String msg) {
            kotlin.jvm.internal.g.f(method, "method");
            kotlin.jvm.internal.g.f(msg, "msg");
            Log.e(PolicySdkLogUtils.TAG, method + " | " + msg);
        }

        public final String errorCodeLabel(int i10) {
            if (i10 == -1) {
                return "FAILED(-1)";
            }
            if (i10 == 0) {
                return "SUCCESS(0)";
            }
            switch (i10) {
                case PolicySdkErrorCode.NETWORK_ERROR /* -10004 */:
                    return "NETWORK_ERROR(-10004)";
                case PolicySdkErrorCode.NOT_NETWORK /* -10003 */:
                    return "NOT_NETWORK(-10003)";
                case PolicySdkErrorCode.PARAMETER_LOCAL_FILE_NAME_ERROR /* -10002 */:
                    return "PARAMETER_LOCAL_FILE_NAME_ERROR(-10002)";
                case PolicySdkErrorCode.PARAMETER_ERROR /* -10001 */:
                    return "PARAMETER_ERROR(-10001)";
                default:
                    return "UNKNOWN(" + i10 + ')';
            }
        }

        public final boolean getEnabled() {
            return PolicySdkLogUtils.enabled;
        }

        public final void i(String method, String msg) {
            kotlin.jvm.internal.g.f(method, "method");
            kotlin.jvm.internal.g.f(msg, "msg");
            if (getEnabled()) {
                Log.i(PolicySdkLogUtils.TAG, method + " | " + msg);
            }
        }

        public final void logCheckNewestResult(PolicySdkResultBean result, String scenario, String detail) {
            kotlin.jvm.internal.g.f(result, "result");
            kotlin.jvm.internal.g.f(scenario, "scenario");
            kotlin.jvm.internal.g.f(detail, "detail");
            String str = result.getPolicyRegrantFlag() ? "需弹再次授权" : "无需再次授权";
            String str2 = result.getPolicyNewest() ? "本地已是最新" : "本地非最新/已拉取新版";
            StringBuilder sbQ = a0.a.q(">>> END [", scenario, "] code=");
            sbQ.append(errorCodeLabel(result.getCode()));
            sbQ.append(", ");
            sbQ.append(str2);
            sbQ.append(", ");
            sbQ.append(str);
            sbQ.append(", localVersion=");
            sbQ.append(result.getPolicyNewestVersion());
            sbQ.append(", serverVersion=");
            sbQ.append(result.getVersionServer());
            String string = sbQ.toString();
            if (result.getCode() == 0) {
                i("checkNewestPolicy", string);
                if (detail.length() > 0) {
                    d("checkNewestPolicy", detail);
                }
                if (result.getPolicyRegrantFlag()) {
                    i("checkNewestPolicy", "回调建议: code==SUCCESS && !policyNewest && policyRegrantFlag → 弹更新授权框");
                    return;
                }
                return;
            }
            e("checkNewestPolicy", string);
            if (detail.length() > 0) {
                e("checkNewestPolicy", "原因: ".concat(detail));
            }
            e("checkNewestPolicy", "建议: " + checkNewestSuggestion(result.getCode(), scenario));
        }

        public final void logCheckNewestStart(String category, String language, boolean z, boolean z3, String str, boolean z10, String str2) {
            kotlin.jvm.internal.g.f(category, "category");
            kotlin.jvm.internal.g.f(language, "language");
            StringBuilder sb2 = new StringBuilder(">>> START category=");
            ai.onnxruntime.a.z(sb2, category, ", language=", language, ", network=");
            sb2.append(z);
            sb2.append(", localFile=");
            sb2.append(z3);
            sb2.append(", syncDone=");
            sb2.append(z10);
            sb2.append(", storage=");
            if (str2 == null) {
                str2 = "unknown";
            }
            sb2.append(str2);
            i("checkNewestPolicy", sb2.toString());
            if (!z3 || str == null || str.length() == 0) {
                return;
            }
            d("checkNewestPolicy", "localPath=" + str);
        }

        public final void setEnabled(boolean z) {
            PolicySdkLogUtils.enabled = z;
        }

        public final void w(String method, String msg) {
            kotlin.jvm.internal.g.f(method, "method");
            kotlin.jvm.internal.g.f(msg, "msg");
            Log.w(PolicySdkLogUtils.TAG, method + " | " + msg);
        }

        private Companion() {
        }

        public final void d(String method) {
            kotlin.jvm.internal.g.f(method, "method");
            if (getEnabled()) {
                Log.d(PolicySdkLogUtils.TAG, method);
            }
        }

        public static /* synthetic */ void getEnabled$annotations() {
        }
    }

    public static final boolean getEnabled() {
        return Companion.getEnabled();
    }

    public static final void setEnabled(boolean z) {
        Companion.setEnabled(z);
    }
}
