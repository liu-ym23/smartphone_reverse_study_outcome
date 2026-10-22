package com.bytedance.bdturing;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventReport.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final String TAG = "EventReport";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f6546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f6547b;

    /* JADX INFO: compiled from: EventReport.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6548a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f6549b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f6550c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f6551d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f6552e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        private static final /* synthetic */ a[] j = null;
        private String i;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(j.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("CLOSE_REASON_MASK", 0, "mask_click_close");
            f6548a = r0;
            a r1 = new a("CLOSE_REASON_BACK", 1, "back_close");
            f6549b = r1;
            a r3 = new a("CLOSE_REASON_APP", 2, "app_close");
            f6550c = r3;
            a r5 = new a("CLOSE_REASON_PAGE_LOAD_FAILED", 3, "page_load_failed_close");
            f6551d = r5;
            a r7 = new a("CLOSE_FB_MASK", 4, "close_fb_mask");
            f6552e = r7;
            a r9 = new a("CLOSE_FB_CLOSE", 5, "close_fb_close");
            f = r9;
            a r11 = new a("CLOSE_FB_FEEDBACK", 6, "close_fb_feedback");
            g = r11;
            a r13 = new a("CLOSE_FB_SYSTEM", 7, "close_fb_system");
            h = r13;
            j = new a[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private a(String r1, int r2, String r3) {
            super(r1, r2);
            this.i = r3;
        }

        public String a() {
            return this.i;
        }
    }

    public static void a(com.bytedance.bdturing.verify.a.a r0) {
        if (r0 == null) goto L4;
        String r1 = r0.e();
    L5:
        f6547b = r1;
        return;
    L4:
        r1 = "";
        goto L5
    }

    public static void a() {
        f6546a = System.currentTimeMillis();
    }

    public static void a(String r3, JSONObject r4) {
        if (TextUtils.isEmpty(r3) == false) goto L20;
        return;
    L20:
        BdTuringConfig r0 = b.a().b();     // Catch: Exception -> L17
        r4.put("params_for_special", "turing");     // Catch: Exception -> L17
        if (r0 == null) goto L8;
        r4.put("sdk_version", r0.getSdkVersion());     // Catch: Exception -> L17
        r4.put("host_app_id", r0.getAppId());     // Catch: Exception -> L17
    L8:
        if (r0 == null) goto L10;
        d r1 = r0.getEventClient();     // Catch: Exception -> L17
    L11:
        if (r1 == null) goto L14;
        r1.a(r3, r4);     // Catch: Exception -> L17
    L14:
        if (g.a() == false) goto L22;
        g.g("event", r4.toString());     // Catch: Exception -> L17
        return;
    L22:
        return;
    L10:
        r1 = null;
    L17:
        e = move-exception;
        g.a(e);
    }

    public static void b() {
        JSONObject r0 = new JSONObject();
        r0.put("key", "pop");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }

    public static void c() {
        JSONObject r0 = new JSONObject();
        r0.put("key", "background");     // Catch: JSONException -> L5
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L5
    L7:
        a("turing_verify_sdk", r0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void a(long r2, int r4) {
        if (e() == false) goto L12;
        JSONObject r0 = new JSONObject();
        r0.put("duration", r2);     // Catch: JSONException -> L7
        r0.put("result", r4);     // Catch: JSONException -> L7
        r0.put("key", "setting");     // Catch: JSONException -> L7
        a("turing_verify_sdk", r0);
        return;
    L7:
        e = move-exception;
        g.a(e);
        return;
    }

    private static boolean e() {
    L14:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (b.a().b() == null) goto L6;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a().b().getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L7:
        if (r1 == null) goto L19;
        SharedPreferences r2 = r1.getSharedPreferences("turing_log_config", 0);     // Catch: Throwable -> L14
        String r3 = r2.getString("turing_setting_request_date", "");     // Catch: Throwable -> L14
        String r4 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());     // Catch: Throwable -> L14
        g.g(TAG, "isFirstSetting cacheDateStr=" + r3 + ":dateStr=" + r4);     // Catch: Throwable -> L14
        if (r3 != null) goto L11;
        return false;
    L11:
        if (r3.equals(r4) == true) goto L21;
        SharedPreferences.Editor r5 = r2.edit();     // Catch: Throwable -> L14
        r5.putString("turing_setting_request_date", r4);     // Catch: Throwable -> L14
        r5.commit();     // Catch: Throwable -> L14
        return true;
    L21:
        return false;
    L19:
        return false;
    L6:
        r1 = null;
        goto L7
    }

    public static void a(long r2) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r2);     // Catch: JSONException -> L6
        r0.put("key", "pre_create_success");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }

    public static void b(long r2) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r2);     // Catch: JSONException -> L6
        r0.put("key", "pre_create_load_success");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }

    public static void a(a r6) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", System.currentTimeMillis() - f6546a);     // Catch: JSONException -> L6
        r0.put("result", r6.a());     // Catch: JSONException -> L6
        r0.put("key", "close");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }

    public static void d() {
        JSONObject r0 = new JSONObject();
        r0.put("key", "system_low");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }

    public static void a(int r6, String r7) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", System.currentTimeMillis() - f6546a);     // Catch: JSONException -> L6
        r0.put("result", r6);     // Catch: JSONException -> L6
        r0.put(MonitorConstants.CUSTOM, r7);     // Catch: JSONException -> L6
        r0.put("key", "load_webview");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }

    public static void a(int r7) {
        JSONObject r1 = new JSONObject();
        r1.put("duration", System.currentTimeMillis() - f6546a);     // Catch: JSONException -> L6
        r1.put("result", r7);     // Catch: JSONException -> L6
        r1.put("key", "result");     // Catch: JSONException -> L6
        r1.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r1);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }

    public static void b(int r2) {
        JSONObject r0 = new JSONObject();
        r0.put("result", r2);     // Catch: JSONException -> L6
        r0.put("key", "orientation");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }

    public static void c(int r2) {
        JSONObject r0 = new JSONObject();
        r0.put("result", r2);     // Catch: JSONException -> L6
        r0.put("key", "orientation_change");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }

    public static void d(int r2) {
        JSONObject r0 = new JSONObject();
        r0.put("is_success", r2);     // Catch: JSONException -> L6
        r0.put("key", "front_pop");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }

    public static void e(int r2) {
        JSONObject r0 = new JSONObject();
        r0.put("result", r2);     // Catch: JSONException -> L6
        r0.put("key", "agree");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }

    public static void f(int r2) {
        JSONObject r0 = new JSONObject();
        r0.put("is_success", r2);     // Catch: JSONException -> L6
        r0.put("key", "load_real_name");     // Catch: JSONException -> L6
        r0.put("shark_log_id", f6547b);     // Catch: JSONException -> L6
        a("turing_verify_sdk", r0);
        return;
    L6:
        e = move-exception;
        g.a(e);
    }
}
