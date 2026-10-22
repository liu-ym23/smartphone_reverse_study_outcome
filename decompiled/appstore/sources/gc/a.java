package gc;

import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.tracker.TrackerElement;
import com.obric.matrix.proto.Response;
import kotlin.jvm.internal.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20041a = null;

    static {
        f20041a = new a();
    }

    public a() {
    }

    public final void a(int r10, int r11, String r12, Response r13, JSONObject r14) {
        q.g(r13, "response");
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L8
        r15.put("status", "status_receiver_result");     // Catch: Exception -> L8
        r15.put("cmd", r10);     // Catch: Exception -> L8
        r15.put("way", r11);     // Catch: Exception -> L8
        r15.put(TrackerElement.PACKAGE_NAME, r12);     // Catch: Exception -> L8
        Integer r16 = r13.statusCode;     // Catch: Exception -> L8
        q.f(r16, "response.statusCode");     // Catch: Exception -> L8
        r15.put(WsConstants.ERROR_CODE, r16.intValue());     // Catch: Exception -> L8
        r15.put("error_message", r13.errorMsg);     // Catch: Exception -> L8
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L8
        if (r14 == null) goto L15;
        String r18 = r14.optString("start_callback_time");     // Catch: Exception -> L8
        q.f(r18, "startCallbackTime");     // Catch: Exception -> L8
        long r19 = 0;
        if (r18.length() <= 0) goto L10;
        long r20 = System.currentTimeMillis() - Long.parseLong(r18);     // Catch: Exception -> L8
    L11:
        String r21 = r14.optString("start_intent_use_time");     // Catch: Exception -> L8
        String r22 = r14.optString("start_time");     // Catch: Exception -> L8
        q.f(r22, "realStartTime");     // Catch: Exception -> L8
        if (r22.length() <= 0) goto L14;
        r19 = System.currentTimeMillis() - Long.parseLong(r22);     // Catch: Exception -> L8
    L14:
        String r110 = r14.optString("process_time");     // Catch: Exception -> L8
        r17.put("cost_time", r19);     // Catch: Exception -> L8
        r17.put("start_intent_use_time", r21);     // Catch: Exception -> L8
        r17.put("process_time", r110);     // Catch: Exception -> L8
        r17.put("callback_use_time", r20);     // Catch: Exception -> L8
        goto L15
    L10:
        r20 = 0;
    L15:
        b.f20042a.j("event_send_cmd_result", r15, r17, new JSONObject());     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        hc.b.b("ReportMonitorHelper", "report exception " + Log.getStackTraceString(e), null, 4, null);
    }
}
