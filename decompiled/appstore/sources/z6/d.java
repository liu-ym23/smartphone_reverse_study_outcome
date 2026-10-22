package z6;

import android.util.Log;
import com.bytedance.watson.assist.file.FileStatInfo;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    public d() {
        this("/proc/self/time_in_state");
    }

    @Override // z6.a
    public FileStatInfo a(File r10) {
        return c(r10);
    }

    public final FileStatInfo c(File r14) {
        BufferedReader r13 = FileUtils.b(r14);
        if (r13 != null) goto L5;
        return null;
    L5:
        x6.e r10 = new x6.e();
        LinkedHashMap r11 = null;
        long r12 = 0;
    L34:
        String r15 = r13.readLine();     // Catch: Exception -> L21 Throwable -> L32
        if (r15 == null) goto L26;
        if (r15.isEmpty() == true) goto L34;
        if (r15.contains("cpu") == true) goto L34;
        String[] r16 = r15.split(" ");     // Catch: Exception -> L21 Throwable -> L32
        if (r16.length <= 1) goto L26;
        long r17 = Long.parseLong(r16[0]);     // Catch: Exception -> L21 Throwable -> L32
        long r18 = Long.parseLong(r16[1]) * 10;     // Catch: Exception -> L21 Throwable -> L32
        if (r12 != 0) goto L19;
    L23:
        if (r11 != null) goto L25;
        r11 = new LinkedHashMap();     // Catch: Exception -> L21 Throwable -> L32
    L25:
        r11.put(Long.valueOf(r17), Long.valueOf(r18));     // Catch: Exception -> L21 Throwable -> L32
        r12 = r17;
        goto L34
    L19:
        if (r17 >= r12) goto L23;
        r10.a(r11);     // Catch: Exception -> L21 Throwable -> L32
        r11 = null;
    L26:
        r10.a(r11);     // Catch: Exception -> L21 Throwable -> L32
        FileUtils.a(r13);
        return r10;
    L21:
        e = move-exception;
        a7.a.c(Log.getStackTraceString(e));     // Catch: Throwable -> L32
        FileUtils.a(r13);
        return r10;
    L32:
        FileUtils.a(r13);
        return r10;
    }

    public d(int r10) {
        super("/proc/self/task/" + r10 + "/time_in_state");
    }

    public d(String r10) {
        super(r10);
    }
}
