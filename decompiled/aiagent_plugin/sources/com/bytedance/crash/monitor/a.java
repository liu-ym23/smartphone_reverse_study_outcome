package com.bytedance.crash.monitor;

import com.bytedance.crash.ah;
import java.util.Map;

/* JADX INFO: compiled from: AppMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends d {
    private static final ah n = null;

    @Override // com.bytedance.crash.monitor.f
    public Map<String, Object> b() {
        return null;
    }

    static {
        n = new ah();
    }

    static ah a() {
        return n;
    }

    a(String r10, String r11, long r12) {
        super(n, r10, r11, r12);
        com.bytedance.crash.i.a(r12, 0, 0, r11);
    }

    a() {
        super(n);
    }

    public c a(long r1) {
        return this.f7579a.g(r1);
    }

    @Override // com.bytedance.crash.monitor.f
    public com.bytedance.crash.d.e c() {
        com.bytedance.crash.d.e r0 = h.b();
        r0.a(this);
        return r0;
    }
}
