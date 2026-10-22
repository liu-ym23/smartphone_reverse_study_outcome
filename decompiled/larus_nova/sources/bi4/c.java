package bi4;

import com.bytedance.crash.util.h;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f19131d;

    public final void a() {
        boolean r100 = e.f19135b;
        String r101 = this.f19128a + '.' + this.f19129b + '@' + Long.toHexString(this.f19130c);
        long r102 = this.f19131d;
        File r103 = e.a();     // Catch: Throwable -> L10
        if (r103 == null) goto L13;
        StringBuilder r104 = new StringBuilder("activityLifeCycle ");     // Catch: Throwable -> L10
        r104.append(r101);     // Catch: Throwable -> L10
        r104.append(' ');     // Catch: Throwable -> L10
        if (com.bytedance.crash.util.c.f203409c != null) goto L8;
        com.bytedance.crash.util.c.f203409c = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss", Locale.getDefault());     // Catch: Throwable -> L10
    L8:
        r104.append(com.bytedance.crash.util.c.f203409c.format(new Date(r102)));     // Catch: Throwable -> L10
        r104.append('\n');     // Catch: Throwable -> L10
        h.h(r103, r104.toString(), true);     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(String r100, String r101, int r102, long r103) {
        this.f19128a = r100;
        this.f19129b = r101;
        this.f19130c = r102;
        this.f19131d = r103;
    }
}
