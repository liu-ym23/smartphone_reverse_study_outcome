package com.bytedance.apm;

/* JADX INFO: compiled from: FluencyMonitorManager.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: com.bytedance.apm.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: FluencyMonitorManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: FluencyMonitorManager.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f4639a = null;

        static /* synthetic */ g a() {
            return f4639a;
        }

        static {
            f4639a = new g(null);
        }
    }

    /* synthetic */ g(AnonymousClass1 r1) {
        this();
    }

    private g() {
        com.bytedance.apm6.service.c.a(com.bytedance.apm.config.f.class);
    }

    public static g a() {
        return a.a();
    }

    public void b() {
        com.bytedance.apm6.service.c.a(com.bytedance.apm.config.f.class);
    }

    public void a(com.bytedance.apm.config.e r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.bytedance.apm.block.l.a(r3.g());
        com.bytedance.apm.block.g.a().c();
        com.bytedance.apm.block.g.a().a(r3.c(), false);
        i.a(r3);
        com.bytedance.apm.block.f.a(r3.i(), r3.g());
    }
}
