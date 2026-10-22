package com.stepos.policy.sdk.util;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkLogUtils;", "", "()V", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicySdkLogUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PolicySDK";
    private static volatile boolean enabled;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u000eJ\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014JI\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\"\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#R(\u0010$\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b$\u0010%\u0012\u0004\b*\u0010\u0003\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkLogUtils$Companion;", "", AppAgent.CONSTRUCT, "()V", "", "code", "", "scenario", "checkNewestSuggestion", "(ILjava/lang/String;)Ljava/lang/String;", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, NotificationCompat.CATEGORY_MESSAGE, "LC7/r;", "e", "(Ljava/lang/String;Ljava/lang/String;)V", "w", "d", "(Ljava/lang/String;)V", "i", "errorCodeLabel", "(I)Ljava/lang/String;", QueryAlgorithmBundle.KEY_CATEGORY, "language", "", "networkAvailable", "localFileExists", "localPath", "syncLocalFileFinished", "policyContextPath", "logCheckNewestStart", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ZLjava/lang/String;)V", "Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;", "result", "detail", "logCheckNewestResult", "(Lcom/stepos/policy/sdk/bean/PolicySdkResultBean;Ljava/lang/String;Ljava/lang/String;)V", "enabled", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "getEnabled$annotations", "TAG", "Ljava/lang/String;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private final String checkNewestSuggestion(int code, String scenario) {
            return (code == -10001 && k.b(scenario, "NO_LOCAL_FILE")) ? "先调用 PolicySdk.initSDK，且 policyCategoryMap 包含当前 category" : code == -10001 ? "检查 appId/appSecret/appVersionName/language/category 是否已 initSDK" : code == -10002 ? "本地协议文件名需为 {category}_{version}.html，检查 initSDK 拷贝是否成功" : (code == -10004 || k.b(scenario, "NO_NETWORK_WITH_LOCAL")) ? "当前无网络，已返回本地缓存路径，可展示本地协议；有网后重试 checkNewestPolicy" : (code == -1 && k.b(scenario, "NO_NETWORK_NO_LOCAL")) ? "无网络且无本地文件，需联网后检测，或确认 initSDK 已完成且 user_de 路径配置正确" : (code == -1 && k.b(scenario, "HTTP_FAILED")) ? "服务端请求失败，检查 appId/appSecret 签名、网络代理与服务端状态" : (code == -1 && k.b(scenario, "DOWNLOAD_FAILED")) ? "新版本下载失败，检查网络与存储权限" : (code == -1 && k.b(scenario, "SERVER_EMPTY_DATA")) ? "服务端返回空数据，联系协议平台确认 category 是否已配置" : code == -1 ? "查看上方原因日志；确认 initSDK、网络、category 与 DeviceProtectedStorage 配置" : "查看 PolicySDK 日志中 >>> START 与 >>> END 之间的详情";
        }

        public static /* synthetic */ void getEnabled$annotations() {
        }

        public static /* synthetic */ void logCheckNewestResult$default(Companion companion, PolicySdkResultBean policySdkResultBean, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = "";
            }
            companion.logCheckNewestResult(policySdkResultBean, str, str2);
        }

        public final void d(String method, String msg) {
            k.f(method, "method");
            k.f(msg, "msg");
            if (getEnabled()) {
                Log.d(PolicySdkLogUtils.TAG, method + " | " + msg);
            }
        }

        public final void e(String method, String msg) {
            k.f(method, "method");
            k.f(msg, "msg");
            Log.e(PolicySdkLogUtils.TAG, method + " | " + msg);
        }

        public final String errorCodeLabel(int code) {
            if (code == -1) {
                return "FAILED(-1)";
            }
            if (code == 0) {
                return "SUCCESS(0)";
            }
            switch (code) {
                case PolicySdkErrorCode.NETWORK_ERROR /* -10004 */:
                    return "NETWORK_ERROR(-10004)";
                case PolicySdkErrorCode.NOT_NETWORK /* -10003 */:
                    return "NOT_NETWORK(-10003)";
                case PolicySdkErrorCode.PARAMETER_LOCAL_FILE_NAME_ERROR /* -10002 */:
                    return "PARAMETER_LOCAL_FILE_NAME_ERROR(-10002)";
                case PolicySdkErrorCode.PARAMETER_ERROR /* -10001 */:
                    return "PARAMETER_ERROR(-10001)";
                default:
                    return androidx.appfunctions.metadata.a.k("UNKNOWN(", code, ')');
            }
        }

        public final boolean getEnabled() {
            return PolicySdkLogUtils.enabled;
        }

        public final void i(String method, String msg) {
            k.f(method, "method");
            k.f(msg, "msg");
            if (getEnabled()) {
                Log.i(PolicySdkLogUtils.TAG, method + " | " + msg);
            }
        }

        public final void logCheckNewestResult(PolicySdkResultBean result, String scenario, String detail) {
            k.f(result, "result");
            k.f(scenario, "scenario");
            k.f(detail, "detail");
            String str = result.getPolicyRegrantFlag() ? "需弹再次授权" : "无需再次授权";
            String str2 = result.getPolicyNewest() ? "本地已是最新" : "本地非最新/已拉取新版";
            StringBuilder sbV = B7.a.v(">>> END [", scenario, "] code=");
            sbV.append(errorCodeLabel(result.getCode()));
            sbV.append(", ");
            sbV.append(str2);
            sbV.append(", ");
            sbV.append(str);
            sbV.append(", localVersion=");
            sbV.append(result.getPolicyNewestVersion());
            sbV.append(", serverVersion=");
            sbV.append(result.getVersionServer());
            String string = sbV.toString();
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

        public final void logCheckNewestStart(String category, String language, boolean networkAvailable, boolean localFileExists, String localPath, boolean syncLocalFileFinished, String policyContextPath) {
            k.f(category, "category");
            k.f(language, "language");
            StringBuilder sb = new StringBuilder(">>> START category=");
            androidx.constraintlayout.core.dsl.a.A(sb, category, ", language=", language, ", network=");
            sb.append(networkAvailable);
            sb.append(", localFile=");
            sb.append(localFileExists);
            sb.append(", syncDone=");
            sb.append(syncLocalFileFinished);
            sb.append(", storage=");
            if (policyContextPath == null) {
                policyContextPath = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            sb.append(policyContextPath);
            i("checkNewestPolicy", sb.toString());
            if (!localFileExists || localPath == null || localPath.length() == 0) {
                return;
            }
            d("checkNewestPolicy", "localPath=" + localPath);
        }

        public final void setEnabled(boolean z10) {
            PolicySdkLogUtils.enabled = z10;
        }

        public final void w(String method, String msg) {
            k.f(method, "method");
            k.f(msg, "msg");
            Log.w(PolicySdkLogUtils.TAG, method + " | " + msg);
        }

        private Companion() {
        }

        public final void d(String method) {
            k.f(method, "method");
            if (getEnabled()) {
                Log.d(PolicySdkLogUtils.TAG, method);
            }
        }
    }

    public static final boolean getEnabled() {
        return INSTANCE.getEnabled();
    }

    public static final void setEnabled(boolean z10) {
        INSTANCE.setEnabled(z10);
    }
}
