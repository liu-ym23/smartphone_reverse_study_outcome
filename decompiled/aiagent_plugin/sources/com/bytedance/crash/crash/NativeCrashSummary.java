package com.bytedance.crash.crash;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.k;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.h;
import com.bytedance.crash.o.l;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NativeCrashSummary extends CrashSummary {
    public static final String FILE_NAME = null;
    private final String mSigLine;
    private final int mStartPid;

    static {
        FILE_NAME = CrashType.NATIVE + ".summary";
    }

    NativeCrashSummary(String r15, long r16, long r18, long r20, String r22, String r23, int r24, int r25, int r26, String r27) {
        super(new File(r15).getParentFile(), CrashType.NATIVE, r16, r18, r20, r22, r23, r24, r25);
        this.mStartPid = r26;
        this.mSigLine = r27;
        this.mStackTrace = loadStackTrace();
    }

    public static NativeCrashSummary load(File r2) {
        if (r2.getName().equals(FILE_NAME) == true) goto L5;
        return null;
    L5:
        return NativeBridge.d(r2.getAbsolutePath());
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public String loadStackTrace() {
        return this.mSigLine + NativeBridge.h(this.mDirectory.getAbsolutePath());
    }

    private static String parseSignalType(String r3) {
        Matcher r4 = Pattern.compile("\\(([A-Z_]+)\\)").matcher(r3);     // Catch: Throwable -> L10
        ArrayList r0 = new ArrayList(2);     // Catch: Throwable -> L10
    L4:
        if (r4.find() == false) goto L8;
        if (r0.size() >= 2) goto L8;
        r0.add(r4.group(1));     // Catch: Throwable -> L10
    L8:
        return String.join("_", r0);
    L10:
        return "SIG_PARSE_ERR";
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void appendSpecialFilter(JSONObject r6) {
        JSONObject r0 = l.a(r6, "filters");
        l.b(r0, "coredump_send_cfg_valid", Boolean.valueOf(new File(new File(i.d(), "configs"), h.c() + ".config").exists()));
        boolean r1 = true;
        if (r6.opt("java_data") == null) goto L5;
        boolean r7 = true;
    L6:
        l.b(r0, "has_java_stack", String.valueOf(r7));
        l.b(r0, "malloc_type", NativeBridge.n());
        String r8 = this.mSigLine;
        if (r8 == null) goto L10;
        l.b(r0, "native_reason", parseSignalType(r8));
    L10:
        if (this.mStartPid != this.mPid) goto L13;
        r1 = false;
    L13:
        l.a(r0, "fork_crash", String.valueOf(r1));
        return;
    L5:
        r7 = false;
        goto L6
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void assemblySpecialCrashBody(com.bytedance.crash.entity.a r3, Header r4) {
        JSONObject r5 = r3.c().optJSONObject("filters");
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        r3.a("is_root", Boolean.valueOf(r6));
        r3.a("start_pid", Integer.valueOf(this.mStartPid));
        com.bytedance.crash.dumper.b.a(r3.c(), this.mDirectory, true);
        r3.a("is_native_crash", 1);
        if (com.bytedance.crash.a.b.c() == null) goto L11;
        r3.a("coredump_ver", Integer.valueOf(com.bytedance.crash.a.b.f() ? 1 : 0));
        r3.a("core_dump_uuid", com.bytedance.crash.a.b.c());
    L11:
        k.a(r3.c(), this.mDirectory);
        com.bytedance.crash.e.b.a(r3.c(), this.mDirectory);
        return;
    L5:
        if (r5.optBoolean("is_root") == false) goto L7;
        r6 = true;
        goto L8
    }
}
