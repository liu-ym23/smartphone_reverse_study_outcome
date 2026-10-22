package z6;

import android.util.Log;
import com.bytedance.watson.assist.file.FileStatInfo;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f26292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f26293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f26295g;

    public e() {
        super("");
        this.f26292d = false;
        this.f26293e = new ArrayList();
        this.f26294f = -1;
    }

    @Override // z6.a
    public FileStatInfo b() {
        if (this.f26292d == true) goto L6;
        this.f26294f = com.bytedance.watson.assist.utils.a.i();
        this.f26295g = com.bytedance.watson.assist.utils.a.l();
        this.f26292d = true;
    L6:
        if (this.f26295g != null) goto L10;
        return null;
    L10:
        if (this.f26293e.isEmpty() == false) goto L18;
        int r10 = 0;
    L13:
        if (r10 >= this.f26294f) goto L18;
        int r11 = ((Integer) this.f26295g.get(r10)).intValue();
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L15:
        if (r13 >= r11) goto L17;
        r12.add(new File("/sys/devices/system/cpu/cpu" + r10 + "/cpuidle/state" + r13 + "/time"));
        r13 = r13 + 1;
        goto L15
    L17:
        this.f26293e.add(r12);
        r10 = r10 + 1;
    L18:
        FileStatInfo r14 = c(this.f26293e);
        this.f26288a = r14;
        return r14;
    }

    public final FileStatInfo c(List r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L20;
        x6.a r11 = new x6.a();
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        List r13 = d((List) r12.next());
        if (r13 == null) goto L8;
        r11.f(r13);
        goto L8
    L12:
        return r11;
    L20:
        return null;
    }

    public final List d(List r10) {
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L25;
        BufferedReader r13 = FileUtils.b((File) r12.next());
        if (r13 == null) goto L7;
    L26:
        String r14 = r13.readLine();     // Catch: Throwable -> L16 Exception -> L18
        if (r14 == null) goto L20;
        if (r14.isEmpty() == true) goto L20;
        r11.add(Long.valueOf(Long.parseLong(r14) / 1000));     // Catch: Throwable -> L16 Exception -> L18
    L20:
        FileUtils.a(r13);
    L18:
        e = move-exception;
        a7.a.c(Log.getStackTraceString(e));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        FileUtils.a(r13);
        throw th;
    L7:
        return null;
    L25:
        return r11;
    }
}
