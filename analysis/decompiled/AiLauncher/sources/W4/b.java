package W4;

import Y8.j;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.N;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b$\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J%\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010!2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010#J-\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00042\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010!H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010)R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010)R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010)R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010)R\u0014\u0010/\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010)R\u0014\u00100\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010)R\u0014\u00101\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010)R\u0014\u00102\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010)R\u0014\u00103\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010)R\u0014\u00104\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010)R\u0014\u00105\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010)R\u0014\u00106\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u0010)R\u0014\u00107\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010)R\u0014\u00108\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010)R\u0014\u00109\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010)R\u0014\u0010:\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u0010)R\u0014\u0010;\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010)R\u0014\u0010<\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u0010)R\u0014\u0010=\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010)R\u0014\u0010>\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010)R\u0014\u0010?\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010)R\u0014\u0010@\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010)R\u0014\u0010A\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010)R\u0014\u0010B\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010)R\u0014\u0010C\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010)R\u0014\u0010D\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010)¨\u0006E"}, d2 = {"LW4/b;", "", "<init>", "()V", "", "name", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "stepName", "pageState", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "step", "result", "failReason", "", "durationMs", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "buttonType", "status", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "entrySource", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;)V", "vipcaseId", "vipcaseName", "", "vipcaseIndex", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/util/Map;", "event", "params", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/util/Map;)V", "EVENT_CONNECT_START_CLICK", "Ljava/lang/String;", "EVENT_CONNECT_STEP_EXPOSURE", "EVENT_CONNECT_STEP_RESULT", "EVENT_CONNECT_STEP_CLICK", "EVENT_CONNECTED_DETAIL_EXPOSURE", "EVENT_VIP_CASE_CLICK", "TOOL_FEISHU", "TOOL_WECOM", "STEP_INSTALL", "STEP_CREATE_APP", "STEP_AUTHORIZE", "STEP_SCAN_QR", "STEP_CONNECT_CHECK", "STEP_ADMIN_REVIEW", "PAGE_NORMAL", "PAGE_FAIL_PAGE", "PAGE_FAIL_POPUP", "RESULT_SUCCESS", "RESULT_FAIL", "BTN_AUTHORIZE", "BTN_SAVE_ALBUM", "BTN_TERMINATE", "BTN_DONE", "BTN_RECONNECT", "ENTRY_CONNECTION_SUCCESS", "ENTRY_MARKET_CLICK", "ENTRY_OTHER", "PAGE_NAME", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final String BTN_AUTHORIZE = "authorize";
    public static final String BTN_DONE = "done";
    public static final String BTN_RECONNECT = "reconnect";
    public static final String BTN_SAVE_ALBUM = "save_album";
    public static final String BTN_TERMINATE = "terminate";
    public static final String ENTRY_CONNECTION_SUCCESS = "connection_success";
    public static final String ENTRY_MARKET_CLICK = "market_click";
    public static final String ENTRY_OTHER = "other";
    private static final String EVENT_CONNECTED_DETAIL_EXPOSURE = "cli_connected_detail_exposure";
    private static final String EVENT_CONNECT_START_CLICK = "cli_connect_start_click";
    private static final String EVENT_CONNECT_STEP_CLICK = "cli_connect_step_click";
    private static final String EVENT_CONNECT_STEP_EXPOSURE = "cli_connect_step_exposure";
    private static final String EVENT_CONNECT_STEP_RESULT = "cli_connect_step_result";
    private static final String EVENT_VIP_CASE_CLICK = "cli_vip_case_click";
    public static final b INSTANCE = new b();
    public static final String PAGE_FAIL_PAGE = "fail_page";
    public static final String PAGE_FAIL_POPUP = "fail_popup";
    private static final String PAGE_NAME = "cli";
    public static final String PAGE_NORMAL = "normal";
    public static final String RESULT_FAIL = "fail";
    public static final String RESULT_SUCCESS = "success";
    public static final String STEP_ADMIN_REVIEW = "admin_review";
    public static final String STEP_AUTHORIZE = "authorize";
    public static final String STEP_CONNECT_CHECK = "connect_check";
    public static final String STEP_CREATE_APP = "create_app";
    public static final String STEP_INSTALL = "install";
    public static final String STEP_SCAN_QR = "scan_qr";
    public static final String TOOL_FEISHU = "feishu";
    public static final String TOOL_WECOM = "wecom";

    public static /* synthetic */ void d(b bVar, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str4 = null;
        }
        bVar.c(str, str2, str3, str4);
    }

    public final Map<String, Object> a(String name) {
        return Q.f(j.a("tool_name", name));
    }

    public final void b(String name) {
        p.i(name, "name");
        h(EVENT_CONNECT_START_CLICK, a(name));
    }

    public final void c(String name, String step, String buttonType, String status) {
        p.i(name, "name");
        p.i(step, "step");
        p.i(buttonType, "buttonType");
        h(EVENT_CONNECT_STEP_CLICK, kotlin.collections.a.r(a(name), kotlin.collections.a.m(j.a("step", step), j.a("button_type", buttonType), j.a("status", status))));
    }

    public final void e(String name, String stepName, String pageState) {
        p.i(name, "name");
        p.i(stepName, "stepName");
        p.i(pageState, "pageState");
        h(EVENT_CONNECT_STEP_EXPOSURE, kotlin.collections.a.r(a(name), kotlin.collections.a.m(j.a("step_name", stepName), j.a("page_state", pageState))));
    }

    public final void f(String name, String step, String result, String failReason, Long durationMs) {
        p.i(name, "name");
        p.i(step, "step");
        p.i(result, "result");
        h(EVENT_CONNECT_STEP_RESULT, kotlin.collections.a.r(a(name), kotlin.collections.a.m(j.a("step", step), j.a("result", result), j.a("fail_reason", failReason), j.a("duration", durationMs))));
    }

    public final void g(String name, String entrySource) {
        p.i(name, "name");
        p.i(entrySource, "entrySource");
        h(EVENT_CONNECTED_DETAIL_EXPOSURE, kotlin.collections.a.r(a(name), Q.f(j.a("entry_source", entrySource))));
    }

    public final void h(String event, Map<String, ? extends Object> params) {
        HashMap map = new HashMap();
        for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                map.put(key, value.toString());
            }
        }
        N.a(event, PAGE_NAME, map);
    }

    public final void i(String name, String vipcaseId, String vipcaseName, int vipcaseIndex) {
        p.i(name, "name");
        p.i(vipcaseId, "vipcaseId");
        p.i(vipcaseName, "vipcaseName");
        h(EVENT_VIP_CASE_CLICK, kotlin.collections.a.r(a(name), kotlin.collections.a.m(j.a("vipcase_id", vipcaseId), j.a("vipcase_name", vipcaseName), j.a("vipcase_index", Integer.valueOf(vipcaseIndex)))));
    }
}
