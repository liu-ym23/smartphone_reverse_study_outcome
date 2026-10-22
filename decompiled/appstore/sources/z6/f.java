package z6;

import android.util.Log;
import com.bytedance.watson.assist.file.FileStatInfo;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f26296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f26297e;

    public f() {
        super("");
        this.f26296d = new ArrayList();
        this.f26297e = new ArrayList();
    }

    @Override // z6.a
    public FileStatInfo b() {
        if (this.f26296d.isEmpty() == false) goto L12;
        List r10 = com.bytedance.watson.assist.utils.a.h();
        if (r10 != null) goto L8;
        return null;
    L8:
        Iterator r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        com.bytedance.watson.assist.utils.a.h r12 = (com.bytedance.watson.assist.utils.a.h) r11.next();
        this.f26296d.add(new File("/sys/devices/system/cpu/cpufreq/" + r12.c() + "/stats/time_in_state"));
        this.f26297e.add(Integer.valueOf(r12.a().size()));
    L12:
        FileStatInfo r13 = c(this.f26296d, this.f26297e);
        this.f26288a = r13;
        return r13;
    }

    public final FileStatInfo c(List r10, List r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L23;
        if (r11 != null) goto L7;
        return null;
    L7:
        if (r11.isEmpty() == false) goto L9;
        return null;
    L9:
        if (r10.size() != r11.size()) goto L26;
        x6.c r12 = new x6.c();
        int r13 = r10.size();
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L17;
        LinkedHashMap r15 = d((File) r10.get(r14), ((Integer) r11.get(r14)).intValue());
        if (r15 == null) goto L16;
        r12.h(r15);
    L16:
        r14 = r14 + 1;
        goto L12
    L17:
        return r12;
    L26:
        return null;
    L23:
        return null;
    }

    public final LinkedHashMap d(File r10, int r11) {
        BufferedReader r12 = FileUtils.b(r10);
        LinkedHashMap r13 = null;
        if (r12 != null) goto L26;
        return null;
    L26:
        String r14 = r12.readLine();     // Catch: Exception -> L15 Throwable -> L24
        if (r14 == null) goto L19;
        if (r14.isEmpty() == true) goto L19;
        String[] r15 = r14.split(" ");     // Catch: Exception -> L15 Throwable -> L24
        if (r15.length <= 1) goto L19;
        if (r13 != null) goto L17;
        r13 = new LinkedHashMap();     // Catch: Exception -> L15 Throwable -> L24
    L17:
        r13.put(Long.valueOf(Long.parseLong(r15[0])), Long.valueOf(((long) (r11 * 10)) * Long.parseLong(r15[1])));     // Catch: Exception -> L15 Throwable -> L24
    L19:
        FileUtils.a(r12);
        return r13;
    L24:
        FileUtils.a(r12);
        return r13;
    L15:
        e = move-exception;
        a7.a.c(Log.getStackTraceString(e));     // Catch: Throwable -> L24
        FileUtils.a(r12);
        return r13;
    }
}
