package com.bytedance.crash.b;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;
import com.bytedance.crash.monitor.f;
import com.bytedance.crash.o.l;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: DartSummary.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    static com.bytedance.crash.entity.a a(f r4, String r5, long r6, String r8, Map<? extends String, ? extends String> r9, Map<String, String> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.entity.a r0 = new com.bytedance.crash.entity.a();
        if (r4.p() == null) goto L6;
        l.b(r0.c(), r4.p().a(CrashType.DART));     // Catch: Throwable -> L15
    L6:
        r0.a("is_dart", 1);     // Catch: Throwable -> L15
        r0.a("data", r8);     // Catch: Throwable -> L15
        r0.a("crash_time", Long.valueOf(r6));     // Catch: Throwable -> L15
        r0.a("crash_thread_name", r5);     // Catch: Throwable -> L15
        r0.a("process_name", com.bytedance.crash.o.b.a());     // Catch: Throwable -> L15
        r0.a("app_start_time", Long.valueOf(i.f()));     // Catch: Throwable -> L15
        r0.a("upload_scene", "direct");     // Catch: Throwable -> L15
        MemoryInfo.a(r0.c());     // Catch: Throwable -> L15
        Scraps.pushTo(r0.c());     // Catch: Throwable -> L15
        if (com.bytedance.crash.monitor.b.g() == false) goto L13;
        if (r11 == null) goto L13;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L15
        l.a(r7, r11);     // Catch: Throwable -> L15
        if (r12 == null) goto L12;
        l.a(r7, r12);     // Catch: Throwable -> L15
    L12:
        r0.a(MonitorConstants.CUSTOM, r7);     // Catch: Throwable -> L15
    L13:
        int r13 = Process.myPid();
        return r0.a(Header.a(r4, r6, CrashType.DART, r13));
    }
}
