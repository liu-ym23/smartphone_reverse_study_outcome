package org.chromium;

import com.ttnet.org.chromium.net.x;

/* JADX INFO: compiled from: CronetSystemApiSandbox.java */
/* JADX INFO: loaded from: classes5.dex */
public class f implements x.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f40538a;

    public static f e() {
        if (f40538a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f40538a != null) goto L9;
        f40538a = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f40538a;
    }

    private f() {
    }

    @Override // com.ttnet.org.chromium.net.x.a
    public int a() {
        return c.a().V();
    }

    @Override // com.ttnet.org.chromium.net.x.a
    public int b() {
        return c.a().W();
    }

    @Override // com.ttnet.org.chromium.net.x.a
    public String c() {
        return c.a().X();
    }

    @Override // com.ttnet.org.chromium.net.x.a
    public String d() {
        return c.a().Y();
    }
}
