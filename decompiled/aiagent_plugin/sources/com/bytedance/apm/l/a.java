package com.bytedance.apm.l;

import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.m.b;
import com.bytedance.apm.perf.c;

/* JADX INFO: compiled from: DefaultSampler.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    public a() {
    }

    @Override // com.bytedance.apm.m.b
    public boolean a(String r1) {
        return ApmDelegate.a().a(r1);
    }

    @Override // com.bytedance.apm.m.b
    public boolean b(String r1) {
        return ApmDelegate.a().b(r1);
    }

    @Override // com.bytedance.apm.m.b
    public boolean c(String r1) {
        return ApmDelegate.a().c(r1);
    }

    @Override // com.bytedance.apm.m.b
    public boolean d(String r1) {
        return c.a().a(r1);
    }

    @Override // com.bytedance.apm.m.b
    public boolean a(String r1, String r2) {
        return c.a().a(r1, r2);
    }

    @Override // com.bytedance.apm.m.b
    public boolean e(String r1) {
        return c.a().b(r1);
    }
}
