package com.bytedance.crash.anr;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.dumper.k;
import com.bytedance.crash.dumper.l;
import com.bytedance.crash.dumper.n;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.j;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.lego.init.model.InitTaskProcess;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AnrSummary.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends CrashSummary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7231a = null;
    private static final Pattern h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i f7235e;
    private d f;
    private f.a g;

    static {
        f7231a = CrashType.ANR + ".summary";
        h = Pattern.compile("^start_time=(\\d+)\\nstart_up_time=(\\d+)\\ncrash_time=(\\d+)\\nprocess_name=(.*)\\npid=(\\d+)\\nby_signal=(true|false)\\n(?:trigger=(\\d+)\\n?)?");
    }

    public h(File r15, long r16, long r18, long r20, String r22, int r23, int r24, boolean r25) {
        super(r15, CrashType.ANR, r16, r18, r20, r22, InitTaskProcess.MAIN, r23, r23);
        this.f7232b = r25;
        this.f7233c = r24;
        this.f7235e = new i(r15, r23);
        this.mStackTrace = loadStackTrace();
    }

    private static h c(File r14) {
        String r0 = com.bytedance.crash.o.i.d(r14);
        if (TextUtils.isEmpty(r0) == true) goto L18;
        Matcher r1 = h.matcher(r0);     // Catch: Throwable -> L12
        if (r1.find() == false) goto L19;
        long r4 = Long.parseLong(r1.group(1));     // Catch: Throwable -> L12
        long r6 = Long.parseLong(r1.group(2));     // Catch: Throwable -> L12
        long r8 = Long.parseLong(r1.group(3));     // Catch: Throwable -> L12
        String r10 = r1.group(4);     // Catch: Throwable -> L12
        int r11 = Integer.parseInt(r1.group(5));     // Catch: Throwable -> L12
        boolean r13 = Boolean.parseBoolean(r1.group(6));     // Catch: Throwable -> L12
        if (r1.group(7) == null) goto L9;
        int r12 = Integer.parseInt(r1.group(7));     // Catch: Throwable -> L12
    L10:
        return new h(r14.getParentFile(), r4, r6, r8, r10, r11, r12, r13);
    L9:
        r12 = 9999;
        goto L10
    L19:
        return null;
    L12:
        th = move-exception;
        com.bytedance.crash.c.b.b("NPTH_ANR_ERROR_LOAD", th);
        return null;
    L18:
        return null;
    }

    public static h a(File r2) {
        return c(new File(r2, f7231a));
    }

    static void a(File r7, long r8, boolean r10, int r11) {
        com.bytedance.crash.dumper.a.i r0 = new com.bytedance.crash.dumper.a.i(r7 + "/" + f7231a);
        String r9 = com.bytedance.crash.o.b.a();
        long r1 = com.bytedance.crash.i.f();
        long r3 = com.bytedance.crash.i.h();
        r0.c("start_time=").b(r1).a('\n').c("start_up_time=").b(r3).a('\n').c("crash_time=").b(r8).a('\n').c("process_name=").c(r9).a('\n').c("pid=").b(Process.myPid()).a('\n').c("by_signal=").b(r10).a('\n').c("trigger=").b(r11).a('\n').f();
    }

    static boolean b(File r2) {
        return new File(r2, f7231a).exists();
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public boolean upload(com.bytedance.crash.monitor.a r1, JSONObject r2) {
        boolean r3 = super.upload(r1, r2);
        if (j.a() == true) goto L6;
        if (r3 == true) goto L6;
        com.bytedance.crash.o.i.c(this.mDirectory);
    L6:
        return r3;
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public String loadStackTrace() {
        JSONObject r0 = new JSONObject();
        String r1 = this.f7235e.b();
        this.f7234d = r1;
        if (TextUtils.isEmpty(r1) == false) goto L6;
        this.f7234d = k.b(this.mDirectory);
    L6:
        if (TextUtils.isEmpty(this.f7234d) == false) goto L16;
        this.f7234d = "at InvalidStack.NoStackAvailable(Invalid.java:1).\n";
    L16:
        r0.put("mainStackFromTrace", this.f7234d);     // Catch: JSONException -> L15
        if (this.f7234d != "at InvalidStack.NoStackAvailable(Invalid.java:1).\n") goto L11;
        boolean r4 = true;
    L12:
        r0.put("invalid", r4);     // Catch: JSONException -> L15
        r0.put("is_new_stack", 10);     // Catch: JSONException -> L15
        goto L14
    L11:
        r4 = false;
    L14:
        return r0.toString();
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void assemblySpecialCrashBody(com.bytedance.crash.entity.a r6, Header r7) {
        r6.a("is_anr", 1);     // Catch: Throwable -> L4
        this.f7235e.a(r6.c());     // Catch: Throwable -> L4
        d r0 = new d(this.mDirectory);     // Catch: Throwable -> L4
        this.f = r0;     // Catch: Throwable -> L4
        r0.a(r6.c());     // Catch: Throwable -> L4
        com.bytedance.crash.g.c.a(r6.c());     // Catch: Throwable -> L4
        l.a(r6.c());     // Catch: Throwable -> L4
        f.a r1 = new f.a(this.mDirectory, r6.c(), this.f7235e, this.f);     // Catch: Throwable -> L4
        this.g = r1;     // Catch: Throwable -> L4
        r1.a(r6.c(), this.mDirectory);     // Catch: Throwable -> L4
        a(r6.c());     // Catch: Throwable -> L4
        com.bytedance.crash.n.a.a(r6.c());     // Catch: Throwable -> L4
    L7:
        if (this.f.c() == true) goto L9;
    L18:
        com.bytedance.crash.o.l.a(r7.b(), WsConstants.KEY_APP_ID, 2010);
        return;
    L9:
        if (this.f7234d == "at InvalidStack.NoStackAvailable(Invalid.java:1).\n") goto L18;
        if (j.e() == false) goto L22;
        String r5 = r6.c().optString("exit_reason");
        if (TextUtils.isEmpty(r5) == false) goto L16;
        return;
    L16:
        if (r5.contains("6") == true) goto L24;
        com.bytedance.crash.o.l.a(r7.b(), WsConstants.KEY_APP_ID, 2010);
        return;
    L24:
        return;
    L22:
        return;
    L4:
        th = move-exception;
        com.bytedance.crash.c.b.a(th);
        goto L7
    }

    private void a(JSONObject r5) {
        if (k.a(r5.optString("data")) == true) goto L5;
        return;
    L5:
        String r4 = k.b(this.mDirectory);
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return;
    L8:
        String[] r6 = r4.split("\n");
        JSONArray r0 = new JSONArray();
        int r1 = r6.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        r0.put(r6[r2]);
        r2 = r2 + 1;
        goto L9
    L11:
        com.bytedance.crash.entity.c.a(r5, "main_stack_2nd", r0);
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void appendSpecialFilter(JSONObject r4) {
        JSONObject r0 = com.bytedance.crash.o.l.a(r4, "filters");
        if (this.f7232b == false) goto L5;
        String r1 = "true";
    L6:
        com.bytedance.crash.o.l.a(r0, "by_signal", r1);
        com.bytedance.crash.o.l.a(r0, "anr_trigger", Integer.valueOf(this.f7233c));
        this.f7235e.a(r4, r0);
        d r2 = this.f;
        if (r2 == null) goto L9;
        r2.b(r0);
    L9:
        f.a r3 = this.g;
        if (r3 == null) goto L12;
        r3.a(r0);
    L12:
        com.bytedance.crash.g.c.a(r4, r0);
        b.a.a(this.mDirectory, r0);
        com.bytedance.crash.dumper.h.a(this.mDirectory, r0);
        n.a(this.mDirectory, r4, r0);
        com.bytedance.crash.n.a.a(r4, r0);
        com.bytedance.crash.o.l.a(r0, "malloc_type", NativeBridge.n());
        return;
    L5:
        r1 = "false";
        goto L6
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void loadCrashInfo(JSONObject r1, JSONObject r2, File r3) {
        b.a(r1, r2, r3);
    }
}
