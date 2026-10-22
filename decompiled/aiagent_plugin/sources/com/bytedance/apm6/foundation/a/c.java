package com.bytedance.apm6.foundation.a;

/* JADX INFO: compiled from: EnhancedLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.bytedance.apm6.util.c.b.a {
    public c() {
    }

    @Override // com.bytedance.apm6.util.c.b.a, com.bytedance.apm6.util.c.a
    public void a(String r1, String r2) {
        super.a(r1, r2);
        b.a(r1, r2, null);
    }

    @Override // com.bytedance.apm6.util.c.b.a, com.bytedance.apm6.util.c.a
    public void a(String r1, String r2, Throwable r3) {
        super.a(r1, r2, r3);
        b.a(r1, r2, r3);
    }
}
