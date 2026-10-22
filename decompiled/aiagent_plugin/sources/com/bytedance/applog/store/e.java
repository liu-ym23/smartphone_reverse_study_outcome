package com.bytedance.applog.store;

/* JADX INFO: compiled from: ForwardEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends d {
    @Override // com.bytedance.applog.store.d
    public void a(com.bytedance.applog.priority.a r1) {
    }

    @Override // com.bytedance.applog.store.d, com.bytedance.applog.store.a
    String h() {
        return "forward_eventv3";
    }

    public e(String r1, String r2) {
        super(r1, r2);
    }

    public e() {
        super(null, null);
    }

    public static a a(d r3) {
        e r0 = new e(r3.m, r3.w);
        r0.x = r3.x;
        r0.u = r3.u;
        r0.a(r3.f5992b);
        r0.h = r3.h;
        r0.f5993c = r3.f5993c;
        r0.n = r3.n;
        r0.i = r3.i;
        r0.f5994d = r3.f5994d;
        r0.f = r3.f;
        r0.f5995e = r3.f5995e;
        r0.g = r3.g;
        r0.l = r3.l;
        r0.k = r3.k;
        r0.j = r3.j;
        r0.v = r3.v;
        r0.p = 1;
        r0.r = r3.r;
        r0.s = r3.s;
        return r0;
    }
}
