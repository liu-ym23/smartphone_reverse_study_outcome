package z6;

import android.util.Log;
import com.bytedance.watson.assist.file.FileStatInfo;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    public c(long r10) {
        super("proc/self/task/" + r10 + "/stat");
    }

    @Override // z6.b, z6.a
    public FileStatInfo a(File r10) {
        return d(r10, null);
    }

    public FileStatInfo d(File r10, x6.f r11) {
        BufferedReader r12 = FileUtils.b(r10);
        if (r12 != null) goto L33;
        return null;
    L33:
        String r13 = r12.readLine();     // Catch: Exception -> L18 Throwable -> L30
        if (r13 != null) goto L9;
    L25:
        FileUtils.a(r12);
        return r11;
    L9:
        if (r13.isEmpty() == true) goto L25;
        String r14 = r13.trim();     // Catch: Exception -> L18 Throwable -> L30
        Character r15 = b.f26291d;     // Catch: Exception -> L18 Throwable -> L30
        String r16 = r14.substring(0, r14.indexOf(r15.charValue())).trim();     // Catch: Exception -> L18 Throwable -> L30
        String r17 = r14.substring(r14.indexOf(r15.charValue()) + 1, r14.length()).trim();     // Catch: Exception -> L18 Throwable -> L30
        String[] r18 = r16.split("\\(");     // Catch: Exception -> L18 Throwable -> L30
        String[] r19 = r17.split(" ");     // Catch: Exception -> L18 Throwable -> L30
        if (r18.length > 1) goto L14;
    L23:
        FileUtils.a(r12);
        return r11;
    L14:
        if (r19.length <= 14) goto L23;
        if (r11 != null) goto L20;
        r11 = new x6.f();     // Catch: Exception -> L18 Throwable -> L30
    L20:
        r11.j(Integer.parseInt(r18[0].trim()));     // Catch: Exception -> L18 Throwable -> L30
        r11.k(r18[1].trim());     // Catch: Exception -> L18 Throwable -> L30
        r11.h((Integer.parseInt(r19[11]) + Integer.parseInt(r19[12])) * 10);     // Catch: Exception -> L18 Throwable -> L30
        FileUtils.a(r12);
        return r11;
    L18:
        e = move-exception;
        a7.a.c(Log.getStackTraceString(e));     // Catch: Throwable -> L30
        FileUtils.a(r12);
        return r11;
    L30:
        FileUtils.a(r12);
        return r11;
    }
}
