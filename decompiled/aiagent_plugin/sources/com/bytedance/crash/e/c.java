package com.bytedance.crash.e;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;
import com.bytedance.crash.monitor.f;

/* JADX INFO: compiled from: GameSummary.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    static com.bytedance.crash.entity.a a(f r2, String r3, long r4, String r6, String r7, String r8) {
        com.bytedance.crash.entity.a r0 = new com.bytedance.crash.entity.a();
        r0.a("data", r8);     // Catch: Throwable -> L6
        r0.a("crash_type", CrashType.GAME.getName());     // Catch: Throwable -> L6
        r0.a("crash_time", Long.valueOf(r4));     // Catch: Throwable -> L6
        r0.a("crash_name", r6);     // Catch: Throwable -> L6
        r0.a("crash_reason", r7);     // Catch: Throwable -> L6
        r0.a("crash_thread_name", r3);     // Catch: Throwable -> L6
        r0.a("process_name", com.bytedance.crash.o.b.a());     // Catch: Throwable -> L6
        r0.a("app_start_time", Long.valueOf(i.f()));     // Catch: Throwable -> L6
        r0.a("upload_scene", "direct");     // Catch: Throwable -> L6
    L4:
        int r5 = Process.myPid();
        return r0.a(Header.a(r2, r4, CrashType.GAME, r5));
    }
}
