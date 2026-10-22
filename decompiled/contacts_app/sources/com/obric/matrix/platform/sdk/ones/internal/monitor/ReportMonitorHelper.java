package com.obric.matrix.platform.sdk.ones.internal.monitor;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.proto.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReportMonitorHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004J2\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/monitor/ReportMonitorHelper;", "", "()V", "TAG", "", "monitorBinderResult", "", "bindResult", "", "(Ljava/lang/Boolean;)V", "monitorSendCmdException", EventConstants.EVENT_KEY_CMD, "", "code", NotificationCompat.CATEGORY_MESSAGE, "monitorSendCmdResult", EventConstants.EVENT_KEY_WAY, "packageName", ApmTrafficStats.TTNET_RESPONSE, "Lcom/obric/matrix/proto/Response;", "extraData", "Lorg/json/JSONObject;", "monitorStartSendCmd", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReportMonitorHelper {
    public static final ReportMonitorHelper INSTANCE = null;
    public static final String TAG = "ReportMonitorHelper";

    static {
        INSTANCE = new ReportMonitorHelper();
    }

    private ReportMonitorHelper() {
    }

    public final void monitorStartSendCmd(int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        JSONObject r2 = new JSONObject();
        r2.put("status", EventConstants.STATUS_START);
        r2.put(EventConstants.EVENT_KEY_CMD, r3);
        r2.put(EventConstants.EVENT_KEY_WAY, r4);
        r2.put("package_name", r5);
        SdkMonitorManager.INSTANCE.sdkMonitorEvent(EventConstants.EVENT_SEND_CMD_START, r2);
    }

    public final void monitorSendCmdException(int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_MESSAGE);
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L5
        r2.put("status", EventConstants.STATUS_RECEIVER_RESULT);     // Catch: Exception -> L5
        r2.put(EventConstants.EVENT_KEY_CMD, r3);     // Catch: Exception -> L5
        r2.put("error_code", r4);     // Catch: Exception -> L5
        r2.put(EventConstants.EVENT_KEY_ERROR_MESSAGE, r5);     // Catch: Exception -> L5
        SdkMonitorManager.INSTANCE.sdkMonitorEvent(EventConstants.EVENT_SEND_CMD_RESULT, r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.d$default(TAG, "report exception " + Log.getStackTraceString(e), null, 4, null);
    }

    public final void monitorSendCmdResult(int r9, int r10, String r11, Response r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r12, ApmTrafficStats.TTNET_RESPONSE);
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L22
        r1.put("status", EventConstants.STATUS_RECEIVER_RESULT);     // Catch: Exception -> L22
        r1.put(EventConstants.EVENT_KEY_CMD, r9);     // Catch: Exception -> L22
        r1.put(EventConstants.EVENT_KEY_WAY, r10);     // Catch: Exception -> L22
        r1.put("package_name", r11);     // Catch: Exception -> L22
        Integer r14 = r12.statusCode;     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r14, "response.statusCode");     // Catch: Exception -> L22
        r1.put("error_code", r14.intValue());     // Catch: Exception -> L22
        r1.put(EventConstants.EVENT_KEY_ERROR_MESSAGE, r12.errorMsg);     // Catch: Exception -> L22
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L22
        if (r13 == null) goto L20;
        String r16 = r13.optString(EventConstants.EVENT_KEY_START_CALLBACK_TIME);     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r16, "startCallbackTime");     // Catch: Exception -> L22
        boolean r17 = true;
        if (r16.length() <= 0) goto L8;
        boolean r18 = true;
    L9:
        long r3 = 0;
        if (r18 == false) goto L12;
        long r5 = System.currentTimeMillis() - Long.parseLong(r16);     // Catch: Exception -> L22
    L13:
        String r19 = r13.optString(EventConstants.EVENT_KEY_START_INTENT_USE_TIME);     // Catch: Exception -> L22
        String r110 = r13.optString("start_time");     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r110, "realStartTime");     // Catch: Exception -> L22
        if (r110.length() > 0) goto L17;
        r17 = false;
    L17:
        if (r17 == false) goto L19;
        r3 = System.currentTimeMillis() - Long.parseLong(r110);     // Catch: Exception -> L22
    L19:
        String r111 = r13.optString(EventConstants.EVENT_KEY_PROCESS_TIME);     // Catch: Exception -> L22
        r15.put(EventConstants.EVENT_KEY_COST_TIME, r3);     // Catch: Exception -> L22
        r15.put(EventConstants.EVENT_KEY_START_INTENT_USE_TIME, r19);     // Catch: Exception -> L22
        r15.put(EventConstants.EVENT_KEY_PROCESS_TIME, r111);     // Catch: Exception -> L22
        r15.put(EventConstants.EVENT_KEY_CALLBACK_USE_TIME, r5);     // Catch: Exception -> L22
        goto L20
    L12:
        r5 = 0;
        goto L13
    L8:
        r18 = false;
    L20:
        SdkMonitorManager.INSTANCE.sdkMonitorEvent(EventConstants.EVENT_SEND_CMD_RESULT, r1, r15, new JSONObject());     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        MLog.d$default(TAG, "report exception " + Log.getStackTraceString(e), null, 4, null);
    }

    public final void monitorBinderResult(Boolean r3) {
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
        if (Intrinsics.areEqual(r3, true) == false) goto L5;
        String r4 = "1";
    L6:
        r2.put("result", r4);     // Catch: Exception -> L8
        SdkMonitorManager.INSTANCE.sdkMonitorEvent(EventConstants.EVENT_BIND_RESULT, r2);     // Catch: Exception -> L8
        return;
    L5:
        r4 = "0";
    L8:
        e = move-exception;
        MLog.d$default(TAG, "report exception " + Log.getStackTraceString(e), null, 4, null);
    }
}
