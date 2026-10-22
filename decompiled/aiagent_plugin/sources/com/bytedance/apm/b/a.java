package com.bytedance.apm.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.util.j;
import com.bytedance.apm.util.r;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lego.init.model.InitTaskProcess;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AlogActiveUploadManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f4220a;

    public static void a(Context r2, f r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        if (f4220a != null) goto L6;
        f4220a = r5;
        return;
    }

    public static void a(String r15, long r16, long r18, String r20, e r21, d r22) {
        e r0 = (e) ZeusTransformUtils.wrapperContextForParams(r21, e.class, "com.obric.aiagent.plugin");
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r22, d.class, "com.obric.aiagent.plugin");
        long r10 = System.currentTimeMillis();
        com.bytedance.apm.b.a("apm_event_stats_alog", 0, null);
        b.a("begin upload alog:" + r15 + " startTime:" + r16 + " endTime:" + r18 + " scene:" + r20);
        boolean r3 = true;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != null) goto L6;
        String r1 = "apm context is null";
        int r4 = 0;
    L19:
        JSONObject r5 = new JSONObject();
        r5.put(DBDefinition.SEGMENT_INFO, r1);     // Catch: JSONException -> L22
    L24:
        JSONObject r6 = b.a(!r3, r4, null, r5);
        if (r3 == false) goto L28;
        if (r2 == null) goto L28;
        r2.onCallback(false, r6);
    L28:
        if (r3 == false) goto L30;
        com.bytedance.apm.b.a("apm_event_stats_alog_fail", r4, r6);
    L30:
        b.a("upload end. " + r1);
        JSONObject r7 = new JSONObject();
        r7.put("time", System.currentTimeMillis() - r10);     // Catch: JSONException -> L33
    L35:
        com.bytedance.apm.b.a("apm_event_stats_alog_time", null, r7, null);
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L6:
        if (TextUtils.isEmpty(r15) == true) goto L8;
        String r8 = r15;
    L13:
        if (new File(r8).exists() == true) goto L15;
        r1 = "alog file dir do not exist";
        r4 = 2;
        goto L19
    L15:
        if (r0 == null) goto L17;
        r0.flushAlogDataToFile();
        b.a("flush alog data to file");
    L18:
        a(r8, r16, r18, r20, r2);
        r1 = "";
        r4 = -1;
        r3 = false;
        goto L19
    L17:
        com.bytedance.apm.b.a("apm_event_stats_alog_fail", 3, null);
        goto L18
    L8:
        if (TextUtils.isEmpty(com.bytedance.apm.c.E()) == false) goto L10;
        r1 = "alog file dir is null";
        r4 = 1;
        goto L19
    L10:
        r8 = com.bytedance.apm.c.E();
        goto L13
    }

    private static void a(String r19, long r20, long r22, String r24, d r25) {
        final d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r25, d.class, "com.obric.aiagent.plugin");
        if (f4220a == null) goto L57;
        b.a("begin get alog file");
        List<String> r1 = f4220a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r19, r20, r22);
        b.a("end get alog file:" + r19);
        Object r3 = "null";
        if (j.a(r1) == true) goto L41;
        com.bytedance.apm.e.c r0 = b(r1);
        if (a(r0) == true) goto L21;
        com.bytedance.apm.b.a("apm_event_stats_alog_fail", 5, null);
        if (r8 == null) goto L19;
        JSONObject r2 = new JSONObject();
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L16
        r5.put(WsConstants.KEY_APP_ID, r0.b());     // Catch: Exception -> L16
        r5.put("did", r0.a());     // Catch: Exception -> L16
        r5.put("processName", r0.c());     // Catch: Exception -> L16
        if (r0.d() == null) goto L14;
        r3 = Integer.valueOf(r0.d().size());     // Catch: Exception -> L16
    L14:
        r5.put("alogSize", r3);     // Catch: Exception -> L16
        r2.put(DBDefinition.SEGMENT_INFO, r5.toString());     // Catch: Exception -> L16
    L18:
        r8.onCallback(false, b.a(false, 5, null, r2));
    L16:
        e = move-exception;
        e.printStackTrace();
    L19:
        b.a("upload param missed");
        return;
    L21:
        b.a("alog file begin zip");
        String r4 = a(r0.d());
        b.a("alog file end zip");
        final int[] r6 = {0};
        com.bytedance.apm.b.a.a.InterfaceC0105a r7 = new AnonymousClass1(r6, r8);
        if (TextUtils.isEmpty(r4) == false) goto L68;
        b.a("alog file upload origin file begin");
        boolean r9 = com.bytedance.apm.b.a.a.a(r0.b(), r0.a(), r0.c(), r0.d(), r24, r0.e(), r7);
        if (r9 == true) goto L26;
        r9 = com.bytedance.apm.b.a.a.a(r0.b(), r0.a(), r0.c(), r0.d(), r24, r0.e(), r7);
    L26:
        b.a("alog file upload origin file end. success :" + r9);
    L39:
        if (r9 == false) goto L71;
        com.bytedance.apm.b.a("apm_event_stats_alog_success", 0, null);
        return;
    L71:
        return;
    L68:
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L33
        r10.add(r4);     // Catch: Throwable -> L33
        b.a("alog file upload zip file begin");     // Catch: Throwable -> L33
        boolean r11 = com.bytedance.apm.b.a.a.a(r0.b(), r0.a(), r0.c(), r10, r24, r0.e(), r7);     // Catch: Throwable -> L33
        if (r11 == false) goto L66;
    L38:
        b.a("alog file upload zip file end. success:" + r11 + " zip file:" + r4);
        new File(r4).delete();
        r9 = r11;
        goto L39
    L66:
        r11 = com.bytedance.apm.b.a.a.a(r0.b(), r0.a(), r0.c(), r10, r24, r0.e(), r7);     // Catch: Throwable -> L31
    L31:
        th = th;
    L36:
        if (com.bytedance.apm.c.i() == false) goto L38;
        th.printStackTrace();
    L33:
        th = th;
        r11 = false;
        goto L36
    L41:
        JSONObject r12 = new JSONObject();
        r12.put(DBDefinition.SEGMENT_INFO, "alog upload file failed,local file is null");     // Catch: Exception -> L60
        r12.put("e_dir", r19);     // Catch: Exception -> L60
        r12.put("e_start_time", r20);     // Catch: Exception -> L60
        r12.put("e_end_time", r22);     // Catch: Exception -> L60
        File r13 = new File(r19);     // Catch: Exception -> L60
        if (r13.exists() == true) goto L46;
    L51:
        r12.put("e_file", "null");     // Catch: Exception -> L60
        goto L52
    L46:
        if (r13.listFiles() == null) goto L51;
        StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L60
        r14.append("[");     // Catch: Exception -> L60
        File[] r15 = r13.listFiles();     // Catch: Exception -> L60
        int r16 = r15.length;     // Catch: Exception -> L60
        int r17 = 0;
    L48:
        if (r17 >= r16) goto L50;
        r14.append(r15[r17].getName());     // Catch: Exception -> L60
        r14.append(",");     // Catch: Exception -> L60
        r17 = r17 + 1;     // Catch: Exception -> L60
        goto L48
    L50:
        r14.append("]");     // Catch: Exception -> L60
        r12.put("e_file", r14.toString());     // Catch: Exception -> L60
    L52:
        JSONObject r18 = b.a(false, 4, null, r12);
        com.bytedance.apm.b.a("apm_event_stats_alog_fail", 4, r18);
        if (r8 != null) goto L63;
    L55:
        b.a("alog upload file failed,local file is null");     // Catch: Exception -> L59
        return;
    L73:
        return;
    L63:
        r8.onCallback(false, r18);     // Catch: Exception -> L59
        goto L55
    L57:
        com.bytedance.apm.b.a("apm_event_stats_alog_fail", 12, b.a(false, 12, null, null));
    }

    private static String a(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        File r0 = new File((String) ZeusTransformUtils.preCheckCast(r6.get(0), String.class, "com.obric.aiagent.plugin"));
        File r3 = new File(r0.getParent(), a(r0.getName()));
        if (r3.exists() == false) goto L14;
        r3.delete();
    L14:
        com.bytedance.apm.util.f.a(r3.getAbsolutePath(), (String[]) ZeusTransformUtils.preCheckCast(r6.toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L8
        return r3.getAbsolutePath();
    L9:
        if (r3.exists() == false) goto L17;
        r3.delete();     // Catch: Exception -> L13
        return null;
    L17:
        return null;
    L18:
        return null;
    }

    private static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        int r0 = r4.lastIndexOf(".");
        if (r0 != (-1)) goto L11;
        return r4 + ".zip";
    L11:
        return r4.substring(0, r0) + ".zip";
    }

    private static com.bytedance.apm.e.c b(List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        com.bytedance.apm.e.c r0 = new com.bytedance.apm.e.c();
        JSONObject r2 = com.bytedance.apm.c.p();
        if (r2 == null) goto L6;
        r0.b(r2.optString(WsConstants.KEY_APP_ID));
        r0.a(r2.optString("device_id"));
    L6:
        if (r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).contains(":") == false) goto L8;
        String r1 = r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L9:
        r0.c(r1);
        r0.a(r6);
        r0.a(r2);
        return r0;
    L8:
        r1 = InitTaskProcess.MAIN;
        goto L9
    }

    private static boolean a(com.bytedance.apm.e.c r1) {
        if (TextUtils.isEmpty(r1.b()) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r1.a()) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r1.c()) == false) goto L9;
        return false;
    L9:
        if (r1.d() != null) goto L11;
        return false;
    L11:
        if (r1.d().size() == 0) goto L20;
        return true;
    L20:
        return false;
    }
}
