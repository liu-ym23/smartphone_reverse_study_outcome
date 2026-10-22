package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import Ua.C1060i;
import Ua.L0;
import Ua.Y;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import h8.C4148a;
import io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransportKt;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\fJ?\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherDebugEnvelope;", "", "<init>", "()V", "", "budgetMs", "LY8/t;", "e", "(J)V", "", "displayName", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, "c", "templateId", "vendorId", "integrationId", "text", "Lorg/json/JSONObject;", "clientAction", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "DEBUG_POLL_PATH", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppAutherDebugEnvelope {
    private static final String DEBUG_POLL_PATH = "v1/oauth/sessions/oauth_sess_debug_probe";
    public static final AppAutherDebugEnvelope INSTANCE = new AppAutherDebugEnvelope();
    private static final String TAG = "AppAutherDebugProbe";

    public static /* synthetic */ void f(AppAutherDebugEnvelope appAutherDebugEnvelope, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 60000;
        }
        appAutherDebugEnvelope.e(j10);
    }

    public final String a(String displayName) throws JSONException {
        kotlin.jvm.internal.p.i(displayName, "displayName");
        String str = "为完成当前任务，Agent 需要使用「" + displayName + "」的 API 凭证，请前往第三方平台获取并完成授权。";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "bind_credential_form");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", "APP_KEY");
        jSONObject2.put("label", "API Key");
        jSONObject2.put("help_url", "https://open.alipay.com/develop/manage");
        jSONObject2.put(z.STEP_SOURCE_HELP_TEXT, "在开放平台「我的应用」中查看 App Key");
        Y8.t tVar = Y8.t.f7040a;
        jSONObject.put("fields", jSONArray.put(jSONObject2));
        return b("bind-credential", displayName, "alipay", "alipay-mcp", str, jSONObject);
    }

    public final String b(String templateId, String displayName, String vendorId, String integrationId, String text, JSONObject clientAction) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("kind", "auth_required");
        jSONObject.put("integration_id", integrationId);
        jSONObject.put("integration_type", WebSocketMcpTransportKt.MCP_SUBPROTOCOL);
        jSONObject.put("vendor_id", vendorId);
        jSONObject.put(StepOSRecipientEmailHistory.DISPLAY_NAME, displayName);
        jSONObject.put(z.STEP_SOURCE_GUIDE_TEXT, text);
        jSONObject.put("pending_id", "debug_pend_" + vendorId);
        jSONObject.put("client_action", clientAction);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("status", "auth_required");
        String str = text + "\n1. 打开申请页面：[点此申请](https://example.com/apply)\n2. 把 Key 发在对话里，我会调用 skill_credential(action=save, fields={...}) 保存";
        jSONObject2.put(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, new JSONArray().put(new JSONObject().put("type", "text").put("text", str)));
        jSONObject2.put("structuredContent", jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("templateId", templateId);
        jSONObject4.put("resourceUri", "ui://mcp-gateway/apps/" + templateId);
        Y8.t tVar = Y8.t.f7040a;
        jSONObject2.put("_meta", jSONObject3.put("ui", jSONObject4));
        jSONObject2.put("reply_to_user", str);
        jSONObject2.put("model_instruction", "用户完成授权后继续原任务");
        String string = jSONObject2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public final String c(String displayName) throws JSONException {
        kotlin.jvm.internal.p.i(displayName, "displayName");
        String strA0 = Z8.F.A0(C1173v.p("1. 打开" + displayName + "，私信 @微博龙虾助手", "2. 发送：链接龙虾", "3. 它会回复你 AppId 和 AppSecret", "4. 把这两个凭证告诉我，我帮你配好就能查激励计划了"), "\n", null, null, 0, null, null, 62, null);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "bind_credential_form");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", "WEIBO_APP_ID");
        jSONObject2.put("label", "AppId");
        jSONObject2.put("secret", false);
        jSONArray.put(jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("name", "WEIBO_APP_SECRET");
        jSONObject3.put("label", "AppSecret");
        jSONArray.put(jSONObject3);
        Y8.t tVar = Y8.t.f7040a;
        jSONObject.put("fields", jSONArray);
        return b("guide-steps", displayName, "weibo", "weibo-mcp", strA0, jSONObject);
    }

    public final String d(String displayName) throws JSONException {
        kotlin.jvm.internal.p.i(displayName, "displayName");
        String str = "为完成当前任务，Agent 需要使用「" + displayName + "」提供的相关服务，请完成授权后继续。";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "oauth_flow");
        jSONObject.put("integration_id", "alipay-mcp");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("method", "POST");
        jSONObject2.put("path", "/v1/oauth/sessions");
        jSONObject2.put("body", new JSONObject().put("integration_id", "alipay-mcp"));
        Y8.t tVar = Y8.t.f7040a;
        jSONObject.put("start_api", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("method", "GET");
        jSONObject3.put("path_template", "/v1/oauth/sessions/{session_id}");
        jSONObject.put("poll_api", jSONObject3);
        return b("oauth-authorize", displayName, "alipay", "alipay-mcp", str, jSONObject);
    }

    public final void e(long budgetMs) {
        C4148a.k(TAG, "起裸轮询：path=v1/oauth/sessions/oauth_sess_debug_probe 间隔=2000ms 预算=" + budgetMs + "ms。无 credential-service 环境时每轮都会失败，观察「连续=N 递增而循环不停」即为正确", false, 4, null);
        C1060i.d(kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c().getImmediate())), null, null, new AppAutherDebugEnvelope$startBarePolling$1(budgetMs, null), 3, null);
    }

    public final String g(String displayName) throws JSONException {
        kotlin.jvm.internal.p.i(displayName, "displayName");
        String str = "为完成当前任务，Agent 需要使用「" + displayName + "」提供的相关服务，请完成授权后继续。";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "vendor_callback_flow");
        jSONObject.put("integration_id", "mx-finance");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("method", "POST");
        jSONObject2.put("path", "/v1/auth/sessions");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("integration_id", "mx-finance");
        jSONObject3.put("redirect_type", "h5");
        Y8.t tVar = Y8.t.f7040a;
        jSONObject2.put("body", jSONObject3);
        jSONObject.put("start_api", jSONObject2);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("method", "GET");
        jSONObject4.put("path_template", "/v1/auth/sessions/{session_id}");
        jSONObject.put("poll_api", jSONObject4);
        return b("oauth-authorize", displayName, "eastmoney", "mx-finance", str, jSONObject);
    }
}
