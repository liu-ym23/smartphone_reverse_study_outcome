package f5;

import android.content.Context;
import com.bytedance.framwork.core.sdklog.LogHandler;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static b f19479f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f19481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.framwork.core.sdklog.a f19482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f19483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList f19484e;

    public b(Context r10) {
        AtomicBoolean r11 = new AtomicBoolean(false);
        this.f19483d = r11;
        LinkedList r12 = new LinkedList();
        this.f19484e = r12;
        Context r13 = r10.getApplicationContext();
        this.f19480a = r13;
        this.f19481b = new ConcurrentHashMap();
        com.bytedance.framwork.core.sdklog.a r14 = new com.bytedance.framwork.core.sdklog.a(r13, this, r12, r11);
        this.f19482c = r14;
        r14.start();
    }

    public static b c(Context r10) {
        if (f19479f != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19479f != null) goto L11;
        f19479f = new b(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f19479f;
    }

    public static void f(String r10) {
    }

    public static void g(String r10, String r11) {
    }

    public boolean a(String r10, byte[] r11) {
        if (e() == true) goto L27;
        if (r11 == null) goto L27;
        if (r11.length <= 0) goto L27;
        if (d(r10) != null) goto L11;
        return false;
    L11:
        LinkedList r12 = this.f19484e;
        monitor-enter(r12);
    L17:
        th = move-exception;
        throw th;
    L14:
        if (this.f19483d.get() == false) goto L20;
        monitor-exit(r12);     // Catch: Throwable -> L17
        return false;
    L20:
        if (this.f19484e.size() < 2000) goto L22;
        this.f19484e.poll();     // Catch: Throwable -> L17
    L22:
        boolean r13 = this.f19484e.add(new a(r10, r11));     // Catch: Throwable -> L17
        this.f19482c.a();     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        return r13;
    L27:
        return false;
    }

    public Map b() {
        return this.f19481b;
    }

    public LogHandler d(String r10) {
        return (LogHandler) this.f19481b.get(r10);
    }

    public boolean e() {
        return this.f19483d.get();
    }

    public void h(String r10, LogHandler r11) {
        if (e() == true) goto L8;
        if (r11 == null) goto L9;
        this.f19481b.put(r10, r11);
        return;
    L9:
        return;
    }
}
