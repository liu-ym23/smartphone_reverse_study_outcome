package bh4;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.j;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static eh4.a a(com.bytedance.crash.monitor.a r100, String r101, long r102, String r103, Map r104, Map r110) {
        eh4.a r105 = new eh4.a();
        yh4.a r106 = r100.f203300l;     // Catch: Throwable -> L14
        if (r106 == null) goto L6;
        j r107 = (j) r106;     // Catch: Throwable -> L14
        com.bytedance.crash.util.j.d(r105.f472653a, r107.c(CrashType.DART));     // Catch: Throwable -> L14
    L6:
        r105.a("is_dart", 1);     // Catch: Throwable -> L14
        r105.a("data", r103);     // Catch: Throwable -> L14
        r105.a("crash_time", Long.valueOf(r102));     // Catch: Throwable -> L14
        r105.a("crash_thread_name", r101);     // Catch: Throwable -> L14
        r105.a("process_name", com.bytedance.crash.util.b.c());     // Catch: Throwable -> L14
        r105.a("app_start_time", Long.valueOf(i.b()));     // Catch: Throwable -> L14
        r105.a("upload_scene", "direct");     // Catch: Throwable -> L14
        MemoryInfo.b(r105.f472653a, null);     // Catch: Throwable -> L14
        Scraps.pushTo(r105.f472653a);     // Catch: Throwable -> L14
        if (r104 == null) goto L12;
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L14
        com.bytedance.crash.util.j.i(r108, r104);     // Catch: Throwable -> L14
        if (r110 == null) goto L11;
        com.bytedance.crash.util.j.i(r108, r110);     // Catch: Throwable -> L14
    L11:
        r105.a("custom", r108);     // Catch: Throwable -> L14
    L12:
        int r109 = Process.myPid();
        Header r111 = Header.b(r100, r102, CrashType.DART, r109);
        r105.a("header", r111.f203195a);
        r105.f472654b = r111;
        return r105;
    }
}
