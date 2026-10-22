package com.bytedance.crash.n;

import android.app.ApplicationExitInfo;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.crash.o.l;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppExitInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7609e;
    private int f;
    private String g;
    private String h;
    private String i;
    private long j;
    private long k;
    private String l;

    public b() {
    }

    public static b a(ApplicationExitInfo r8) {
        b r0 = new b();
        r0.f7605a = r8.getProcessName();
        r0.f7606b = r8.getTimestamp();
        r0.f7607c = r8.getPid();
        r0.f = r8.getImportance();
        r0.f7608d = c.a(r8.getReason());
        r0.f7609e = r8.getStatus();
        r0.j = r8.getPss();
        r0.k = r8.getRss();
        r0.g = (r8.getPss() / 1024) + "M";
        r0.h = (r8.getRss() / 1024) + "M";
        r0.i = r8.getDescription();
        r0.l = c.b(((Integer) ZeusTransformUtils.preCheckCast(f.a(r8, "getSubReason", new Object[0]), Integer.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L5
    L6:
        return r0;
    L5:
        r0.l = "UNKNOWN";
        goto L6
    }

    public String a(long r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f7608d);
        r0.append("\n");
        r0.append("pid:");
        r0.append(this.f7607c);
        r0.append(" process:");
        r0.append(this.f7605a);
        r0.append(" alive_time:");
        r0.append(this.f7606b - r5);
        r0.append(" last_alive_time:");
        r0.append(this.f7606b - r5);
        r0.append("\n");
        r0.append("#exitInfo\n");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        r0.append(new SimpleDateFormat().format(new Date(this.f7606b))).append("\n");
    L5:
        r0.append("importance=").append(this.f).append("\n");
        r0.append("sub_reason=").append(this.l).append("\n");
        r0.append("status=").append(this.f7609e).append("\n");
        r0.append("description=").append(this.i).append("\n");
        r0.append("pss=").append(this.g).append("\n");
        r0.append("reason=").append(this.f7608d).append("\n");
        r0.append("process=").append(this.f7605a).append("\n");
        r0.append("rss=").append(this.h).append("\n");
        return r0.toString();
    }

    public JSONObject a(long r10, String r12) {
        HashMap r2 = new HashMap();
        r2.put("exit_status", String.valueOf(c()));
        r2.put("exit_pss", c.a(i()));
        r2.put("exit_rss", c.a(j()));
        r2.put("has_exit_info", "true");
        r2.put("exit_reason", a());
        r2.put("exit_sub_reason", b());
        HashMap r3 = new HashMap(r2);
        JSONObject r5 = new JSONObject();
        r5.put("event_type", "exception");     // Catch: Throwable -> L5
        r5.put("crash_time", this.f7606b);     // Catch: Throwable -> L5
        r5.put("log_type", "PROCESS_DIED");     // Catch: Throwable -> L5
        r5.put(DBHelper.COL_TIME, System.currentTimeMillis());     // Catch: Throwable -> L5
        r5.put("message", "PROCESS_DIED");     // Catch: Throwable -> L5
        r5.put("crash_thread_name", "UNKNOW");     // Catch: Throwable -> L5
        r5.put("crash_md5", com.bytedance.crash.o.e.a(r12));     // Catch: Throwable -> L5
        r5.put("process_name", d());     // Catch: Throwable -> L5
        r5.put("app_start_time", r10);     // Catch: Throwable -> L5
        r5.put("exception_type", 1);     // Catch: Throwable -> L5
        r5.put("pid", this.f7607c);     // Catch: Throwable -> L5
        r5.put("class_ref", "Native");     // Catch: Throwable -> L5
        r5.put("method", "Native");     // Catch: Throwable -> L5
        r5.put("is_core", 1);     // Catch: Throwable -> L5
        r5.put("line_num", -1);     // Catch: Throwable -> L5
        r5.put("ensure_type", "EnsureNotReachHere");     // Catch: Throwable -> L5
        r5.put("stack", r12);     // Catch: Throwable -> L5
        r5.put("has_dump", "true");     // Catch: Throwable -> L5
        r5.put("java_data", "DiedProcess.unknownReason: App was killed, please see logcat.\n");     // Catch: Throwable -> L5
        b(r5, r2);     // Catch: Throwable -> L5
        a(r5, r3);     // Catch: Throwable -> L5
    L4:
        return r5;
    }

    private void b(JSONObject r5, Map<String, String> r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L13
        if (r4 == null) goto L10;
        Iterator r8 = r4.entrySet().iterator();     // Catch: Throwable -> L13
    L7:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r7.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), r1.getValue());     // Catch: Throwable -> L13
    L10:
        if (l.a(r7) == true) goto L17;
        r5.put(MonitorConstants.CUSTOM, r7);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    }

    public void a(JSONObject r5, Map<String, String> r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L13
        if (r4 == null) goto L10;
        Iterator r8 = r4.entrySet().iterator();     // Catch: Throwable -> L13
    L7:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r7.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), r1.getValue());     // Catch: Throwable -> L13
    L10:
        if (l.a(r7) == true) goto L17;
        r5.put("filters", r7);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    }

    public String a() {
        return this.f7608d;
    }

    public String b() {
        return this.l;
    }

    public int c() {
        return this.f7609e;
    }

    public String d() {
        return this.f7605a;
    }

    public long e() {
        return this.f7606b;
    }

    public int f() {
        return this.f7607c;
    }

    public int g() {
        return this.f;
    }

    public String h() {
        return this.i;
    }

    public long i() {
        return this.j;
    }

    public long j() {
        return this.k;
    }

    public String toString() {
        return "AppExitInfo{mProcessName='" + this.f7605a + "', mTimestamp=" + this.f7606b + ", mPid=" + this.f7607c + ", mReason='" + this.f7608d + "', mStatus=" + this.f7609e + ", mImportance=" + this.f + ", mPss='" + this.g + "', mRss='" + this.h + "', mDescription='" + this.i + "', mRealPss=" + this.j + ", mRealRss=" + this.k + ", subReason='" + this.l + "'}";
    }
}
