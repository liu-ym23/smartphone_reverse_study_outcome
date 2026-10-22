package com.bytedance.crash.runtime;

import android.os.SystemClock;
import android.util.Printer;
import com.bytedance.crash.o.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: LooperMessageManager.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Printer f7743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f7744b;
    private static final Printer f = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f7745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Printer> f7746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Printer> f7747e;

    static /* synthetic */ void a(c r0, String r1) {
        r0.a(r1);
    }

    static /* synthetic */ Printer b() {
        return f7743a;
    }

    static /* synthetic */ void b(c r0, String r1) {
        r0.b(r1);
    }

    static /* synthetic */ Printer c() {
        return f;
    }

    static {
        f = new LooperMessageManager$1();
    }

    private c() {
        this.f7745c = -1;
        this.f7746d = new ArrayList();
        this.f7747e = new ArrayList();
    }

    public static c a() {
        if (f7744b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7744b != null) goto L9;
        f7744b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f7744b;
    }

    private void a(String r3) {
        this.f7745c = -1;
        a(this.f7746d, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r.b(e);
    }

    private void b(String r3) {
        this.f7745c = SystemClock.uptimeMillis();
        a(this.f7747e, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r.a(e);
    }

    private static void a(List<? extends Printer> r5, String r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.isEmpty() == true) goto L23;
        int r0 = r7.size();     // Catch: Throwable -> L14
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L24;
        Printer r3 = (Printer) ZeusTransformUtils.preCheckCast(r7.get(r2), Printer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r3 == null) goto L22;
        r3.println(r6);     // Catch: Throwable -> L14
        r2 = r2 + 1;
        goto L8
    L22:
        return;
    L24:
        return;
    L14:
        th = move-exception;
        r.b(th);
        return;
    }
}
