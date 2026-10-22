package com.bytedance.crash.crash;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.a.i;
import com.bytedance.crash.dumper.a.j;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.l;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JavaCrashSummary.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends CrashSummary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7328a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f7329d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7331c;

    static {
        f7328a = CrashType.JAVA + ".summary";
        f7329d = Pattern.compile("^start_time=(\\d+)\\nstart_up_time=(\\d+)\\ncrash_time=(\\d+)\\nprocess_name=(.*)\\nthread_name=(.*)\\npid=(\\d+)\\ntid=(\\d+)\\noom=(\\d+)\\nlaunch=(\\d+)\\nthrowable=(.*)");
    }

    private e(File r15, long r16, long r18, long r20, String r22, String r23, int r24, int r25, boolean r26, String r27, boolean r28) {
        if (r28 == false) goto L5;
        CrashType r0 = CrashType.LAUNCH;
    L6:
        super(r15, r0, r16, r18, r20, r22, r23, r24, r25);
        this.f7330b = r27;
        this.f7331c = r26;
        this.mStackTrace = loadStackTrace();
        return;
    L5:
        r0 = CrashType.JAVA;
        goto L6
    }

    public static void a(File r9, Thread r10, Throwable r11, long r12, boolean r14, boolean r15) {
        i r1 = new i(r9.getAbsolutePath() + "/" + f7328a);     // Catch: Throwable -> L14
        String r0 = com.bytedance.crash.o.b.a();     // Catch: Throwable -> L14
        String r13 = r10.getName();     // Catch: Throwable -> L14
        long r2 = com.bytedance.crash.i.f();     // Catch: Throwable -> L14
        long r4 = com.bytedance.crash.i.h();     // Catch: Throwable -> L14
        int r6 = Process.myPid();     // Catch: Throwable -> L14
        i r16 = r1.c("start_time=").b(r2).a('\n').c("start_up_time=").b(r4).a('\n').c("crash_time=").b(r12).a('\n').c("process_name=").c(r0).a('\n').c("thread_name=").c(r13).a('\n').c("pid=").b(r6).a('\n').c("tid=").b(Process.myTid()).a('\n').c("oom=");     // Catch: Throwable -> L14
        int r17 = 1;
        if (r15 == false) goto L5;
        int r18 = 1;
    L6:
        i r19 = r16.b(r18).a('\n').c("launch=");     // Catch: Throwable -> L14
        if (r14 == true) goto L10;
        r17 = 0;
    L10:
        r19.b(r17).a('\n').c("throwable=").a(r11).a('\n').f();     // Catch: Throwable -> L14
        if (r14 == false) goto L21;
        new File(r9, "launch").createNewFile();     // Catch: Throwable -> L14 Exception -> L17
        goto L23
    L22:
        return;
    L23:
        return;
    L21:
        return;
    L5:
        r18 = 0;
    L14:
        th = move-exception;
        com.bytedance.crash.c.b.c("NPTH_DUMP_SUMMARY", th);
    }

    public static e a(File r19) {
        if (r19.getName().equals(f7328a) == true) goto L5;
        return null;
    L5:
        String r0 = com.bytedance.crash.o.i.d(r19);
        if (r0 != null) goto L27;
        return null;
    L27:
        Matcher r1 = f7329d.matcher(r0);     // Catch: Throwable -> L24
        if (r1.find() == true) goto L11;
    L26:
        return null;
    L11:
        if (r1.groupCount() != 10) goto L26;
        String r17 = r1.group(10);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r17) == true) goto L26;
        long r6 = Long.parseLong(r1.group(1));     // Catch: Throwable -> L24
        long r8 = Long.parseLong(r1.group(2));     // Catch: Throwable -> L24
        long r10 = Long.parseLong(r1.group(3));     // Catch: Throwable -> L24
        String r12 = r1.group(4);     // Catch: Throwable -> L24
        String r13 = r1.group(5);     // Catch: Throwable -> L24
        int r14 = Integer.parseInt(r1.group(6));     // Catch: Throwable -> L24
        int r15 = Integer.parseInt(r1.group(7));     // Catch: Throwable -> L24
        if (Integer.parseInt(r1.group(8)) == 0) goto L17;
        boolean r16 = true;
    L19:
        if (Integer.parseInt(r1.group(9)) == 0) goto L21;
        boolean r18 = true;
    L22:
        return new e(r19.getParentFile(), r6, r8, r10, r12, r13, r14, r15, r16, r17, r18);
    L21:
        r18 = false;
        goto L22
    L17:
        r16 = false;
    L24:
        th = move-exception;
        com.bytedance.crash.c.b.b("NPTH_JAVA_SUMMARY", th);
        goto L26
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public String loadStackTrace() {
        String r0 = j.a(this.mDirectory);
        if (TextUtils.isEmpty(r0) == false) goto L10;
        StringBuilder r1 = new StringBuilder().append(this.f7330b).append("\n\tat InvalidStack.NoStackAvailable: ");
        if (this.f7331c == false) goto L7;
        String r2 = "Is OOM";
    L9:
        return r1.append(r2).append(" (SourceFile.java:-1).\n").toString();
    L7:
        r2 = "Not OOM";
        goto L9
    L10:
        return r0;
    }

    private static String a(String r5) {
        if (r5 != null) goto L19;
    L17:
        return null;
    L19:
        if (r5.isEmpty() == true) goto L17;
        String[] r6 = r5.split("\n", 2);     // Catch: Throwable -> L18
        if (r6.length != 0) goto L10;
        return null;
    L10:
        int r2 = r6[0].indexOf(58);     // Catch: Throwable -> L18
        if (r2 != (-1)) goto L13;
        r2 = r6[0].indexOf(65306);     // Catch: Throwable -> L18
    L13:
        if (r2 == (-1)) goto L16;
        return r6[0].substring(0, r2).trim();
    L16:
        return r6[0].trim();
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void assemblySpecialCrashBody(com.bytedance.crash.entity.a r3, Header r4) {
        com.bytedance.crash.dumper.b.a(r3.c(), this.mDirectory, false);
        r3.a("isOOM", Boolean.valueOf(this.f7331c));
        r3.a("launch_did", com.bytedance.crash.general.a.d());
        if (this.mCrashType != CrashType.LAUNCH) goto L7;
        r3.a("crash_type", "java");
        r3.a("event_type", "start_crash");
        r3.a("stack", String.valueOf(r3.c().remove("data")));
        JSONObject r2 = new JSONObject();
        r2.put("data", new JSONArray().put(r3.c()));     // Catch: JSONException -> L9
        r3.a(r2);     // Catch: JSONException -> L9
        return;
    L13:
        return;
    L7:
        r3.a("isJava", 1);
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public JSONObject getOriginalBody(JSONObject r2) {
        if (this.mCrashType != CrashType.LAUNCH) goto L10;
        JSONArray r1 = r2.optJSONArray("data");
        if (r1 == null) goto L10;
        if (r1.length() <= 0) goto L10;
        return r1.optJSONObject(0);
    L10:
        return r2;
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void appendSpecialFilter(JSONObject r4) {
        if (this.mCrashType != CrashType.LAUNCH) goto L5;
        r4 = getOriginalBody(r4);
    L5:
        JSONObject r5 = l.a(r4, "filters");
        if (new File(this.mDirectory, "ignore").exists() == false) goto L9;
        l.a(r5, "has_ignore", String.valueOf(true));
    L9:
        if (this.mCrashType != CrashType.LAUNCH) goto L11;
    L12:
        String r3 = a(this.mStackTrace);
        if (r3 == null) goto L15;
        l.a(r5, "java_reason", r3);
    L15:
        l.a(r5, "malloc_type", NativeBridge.n());
        l.a(r5, "from_custom", false);
        return;
    L11:
        if (this.mCrashType != CrashType.JAVA) goto L15;
        goto L12
    }
}
