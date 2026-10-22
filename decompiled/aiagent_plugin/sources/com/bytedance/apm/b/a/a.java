package com.bytedance.apm.b.a;

import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.util.t;
import com.bytedance.apm6.service.c;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AlogUploadService.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4223a = "https://mon.zijieapi.com/monitor/collect/c/logcollect";

    /* JADX INFO: renamed from: com.bytedance.apm.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AlogUploadService.java */
    public interface InterfaceC0105a {
        void a(boolean r1, int r2, Exception r3, JSONObject r4);
    }

    static {
    }

    public static void a(String r2) {
        f4223a = "https://" + r2 + "/monitor/collect/c/logcollect";
    }

    public static boolean a(String r8, String r9, String r10, List<String> r11, String r12, JSONObject r13, InterfaceC0105a r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        InterfaceC0105a r16 = (InterfaceC0105a) ZeusTransformUtils.wrapperContextForParams(r14, InterfaceC0105a.class, "com.obric.aiagent.plugin");
        IHttpService r4 = (IHttpService) ZeusTransformUtils.preCheckCast(c.a(IHttpService.class), IHttpService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L46 IOException -> L49
        HashMap r5 = new HashMap();     // Catch: Exception -> L46 IOException -> L49
        r5.put(DBHelper.BATTERY_COL_SCENE, r12);     // Catch: Exception -> L46 IOException -> L49
        h r6 = r4.buildMultipartUpload(f4223a, "UTF-8", false, r5);     // Catch: Exception -> L46 IOException -> L49
        r6.a(WsConstants.KEY_APP_ID, r8);     // Catch: Exception -> L46 IOException -> L49
        r6.a("verify_info", t.a());     // Catch: Exception -> L46 IOException -> L49
        r6.a("device_id", r9);     // Catch: Exception -> L46 IOException -> L49
        r6.a(RomInfo.KEY_OS_TYPE, "Android");     // Catch: Exception -> L46 IOException -> L49
        r6.a("process_name", r10);     // Catch: Exception -> L46 IOException -> L49
        Iterator r17 = r15.iterator();     // Catch: Exception -> L46 IOException -> L49
    L6:
        if (r17.hasNext() == false) goto L10;
        File r7 = new File((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L46 IOException -> L49
        if (r7.exists() == false) goto L6;
        HashMap r18 = new HashMap();     // Catch: Exception -> L46 IOException -> L49
        r18.put("logtype", "alog");     // Catch: Exception -> L46 IOException -> L49
        r18.put(DBHelper.BATTERY_COL_SCENE, r12);     // Catch: Exception -> L46 IOException -> L49
        r18.put("env", "params.txt");     // Catch: Exception -> L46 IOException -> L49
        r6.a(r7.getName(), r7, null, r18);     // Catch: Exception -> L46 IOException -> L49
        goto L6
    L10:
        HashMap r19 = new HashMap();     // Catch: Exception -> L46 IOException -> L49
        r19.put("filetype", "common_params");     // Catch: Exception -> L46 IOException -> L49
        r19.put("logtype", "env");     // Catch: Exception -> L46 IOException -> L49
        if (r13 != null) goto L13;
        String r20 = null;
    L15:
        if (TextUtils.isEmpty(r20) == false) goto L19;
        JSONObject r21 = new JSONObject();     // Catch: Exception -> L46 IOException -> L49
        r21.put("defaultData", "none commonParams");     // Catch: JSONException -> L53 Exception -> L46 IOException -> L49
    L18:
        r20 = r21.toString();     // Catch: Exception -> L46 IOException -> L49
    L19:
        r6.a("params.txt", r20, "text/plain", r19);     // Catch: Exception -> L46 IOException -> L49
        com.bytedance.services.apm.api.c r22 = r6.a();     // Catch: Exception -> L46 IOException -> L49
    L41:
        e = move-exception;
        if (r16 != null) goto L44;
    L52:
        return false;
    L44:
        r16.a(false, 7, e, null);     // Catch: Exception -> L46 IOException -> L49
        goto L52
    L21:
        if (r22.b() != null) goto L25;
        if (r16 == null) goto L24;
        JSONObject r23 = new JSONObject();     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        r23.put("ALOG_UPLOAD_RESPONSE", "null");     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        r23.put("ALOG_UPLOAD_STATUS", r22.a());     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        r16.a(false, 11, null, r23);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
    L24:
        return false;
    L25:
        JSONObject r24 = new JSONObject(new String(r22.b()));     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        if (r24.optInt("errno", -1) != 200) goto L38;
        String r25 = r24.optString("message");     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        if ("long escape".equals(r25) == false) goto L30;
    L36:
        r16.a(false, 13, null, r24);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        return false;
    L30:
        if ("drop data".equals(r25) == true) goto L36;
        if (r16 == null) goto L35;
        r16.a(true, -1, null, r24);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
    L35:
        return true;
    L38:
        if (r16 == null) goto L52;
        r16.a(false, 6, null, r24);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        goto L52
    L13:
        r20 = r13.toString();     // Catch: Exception -> L46 IOException -> L49
    L49:
        e = move-exception;
        if (r16 == null) goto L52;
        r16.a(false, 8, e, null);
    L46:
        e = move-exception;
        if (r16 == null) goto L52;
        r16.a(false, 10, e, null);
        goto L52
    }
}
