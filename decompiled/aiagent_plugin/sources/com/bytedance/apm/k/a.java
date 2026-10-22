package com.bytedance.apm.k;

import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.c;
import com.bytedance.apm.thread.b;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.lego.init.model.InitTaskProcess;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.f;
import com.bytedance.services.apm.api.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FileUploadServiceImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f4718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f4719c;

    public a() {
    }

    static /* synthetic */ void a(a r10, String r11, String r12, String r13, List r14, String r15, JSONObject r16, f r17) {
        r10.b(r11, r12, r13, (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin"), r15, r16, (f) ZeusTransformUtils.wrapperContextForParams(r17, f.class, "com.obric.aiagent.plugin"));
    }

    public static void a(String r2) {
        f4717a = "https://" + r2 + "/monitor/collect/c/logcollect";
        f4719c = r2;
    }

    public static void b(String r2) {
        f4718b = "https://" + r2 + "/monitor/collect/c/code_coverage";
    }

    public void a(final String r12, final String r13, final String r14, List<String> r15, final String r16, final JSONObject r17, f r18) {
        final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        final f r10 = (f) ZeusTransformUtils.wrapperContextForParams(r18, f.class, "com.obric.aiagent.plugin");
        b.a().c(new AnonymousClass1(this, r12, r13, r14, r7, r16, r17, r10));
    }

    private void b(String r6, String r7, String r8, List<String> r9, String r10, JSONObject r11, f r12) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        f r13 = (f) ZeusTransformUtils.wrapperContextForParams(r12, f.class, "com.obric.aiagent.plugin");
        IHttpService r14 = (IHttpService) ZeusTransformUtils.preCheckCast(d.a(IHttpService.class), IHttpService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L34
        if (r14 != null) goto L6;
        r14 = c.s();     // Catch: Exception -> L34
    L6:
        h r15 = r14.buildMultipartUpload(f4717a, "UTF-8", false);     // Catch: Exception -> L34
        r15.a(WsConstants.KEY_APP_ID, r6);     // Catch: Exception -> L34
        r15.a("device_id", r7);     // Catch: Exception -> L34
        r15.a(RomInfo.KEY_OS_TYPE, "Android");     // Catch: Exception -> L34
        r15.a("process_name", InitTaskProcess.MAIN);     // Catch: Exception -> L34
        Iterator r16 = r5.iterator();     // Catch: Exception -> L34
    L8:
        String r1 = null;
        if (r16.hasNext() == false) goto L13;
        File r4 = new File((String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L34
        if (r4.exists() == false) goto L8;
        HashMap r17 = new HashMap();     // Catch: Exception -> L34
        r17.put("logtype", r8);     // Catch: Exception -> L34
        r17.put(DBHelper.BATTERY_COL_SCENE, r10);     // Catch: Exception -> L34
        r17.put("env", "params.txt");     // Catch: Exception -> L34
        r15.a(r4.getName(), r4, null, r17);     // Catch: Exception -> L34
        goto L8
    L13:
        HashMap r18 = new HashMap();     // Catch: Exception -> L34
        r18.put("filetype", "common_params");     // Catch: Exception -> L34
        r18.put("logtype", "env");     // Catch: Exception -> L34
        if (r11 == null) goto L18;
        r1 = r11.toString();     // Catch: Exception -> L34
    L18:
        if (TextUtils.isEmpty(r1) == false) goto L22;
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L34
        r19.put("defaultData", "none commonParams");     // Catch: JSONException -> L38 Exception -> L34
    L21:
        r1 = r19.toString();     // Catch: Exception -> L34
    L22:
        r15.a("params.txt", r1, "text/plain", r18);     // Catch: Exception -> L34
        String r20 = new String(r15.a().b());     // Catch: Exception -> L34
        int r21 = -1;
        r21 = new JSONObject(r20).optInt("errno", -1);     // Catch: JSONException -> L26 Exception -> L34
    L28:
        if (r13 != null) goto L30;
        return;
    L30:
        if (r21 != 200) goto L32;
        r13.a();     // Catch: Exception -> L34
        return;
    L32:
        r13.a(r20);     // Catch: Exception -> L34
        return;
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        if (r13 == null) goto L51;
        r13.a(e.getMessage());
        return;
    }
}
