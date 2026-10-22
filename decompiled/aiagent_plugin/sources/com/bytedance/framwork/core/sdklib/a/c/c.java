package com.bytedance.framwork.core.sdklib.a.c;

/* JADX INFO: compiled from: EnhancedLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends d.a {

    /* JADX INFO: compiled from: EnhancedLogger.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f8603a = null;

        static /* synthetic */ c a() {
            return f8603a;
        }

        static {
            f8603a = new c();
        }
    }

    public c() {
    }

    public static c a() {
        return a.a();
    }

    @Override // com.bytedance.framwork.core.sdklib.a.c.d.a, com.bytedance.apm6.util.c.a
    public void a(String r1, String r2) {
        super.a(r1, r2);
        b.a(r1, r2, null);
    }

    @Override // com.bytedance.framwork.core.sdklib.a.c.d.a, com.bytedance.apm6.util.c.a
    public void a(String r1, String r2, Throwable r3) {
        super.a(r1, r2, r3);
        b.a(r1, r2, r3);
    }
}
