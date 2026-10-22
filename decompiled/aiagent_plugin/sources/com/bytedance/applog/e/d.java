package com.bytedance.applog.e;

/* JADX INFO: compiled from: HandlerEventFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.c f5579a;

    public d(com.bytedance.applog.c r1) {
        this.f5579a = r1;
    }

    @Override // com.bytedance.applog.e.e
    public boolean a(com.bytedance.applog.monitor.b r2, String r3, String r4) {
        if (this.f5579a.af() != null) goto L7;
        return false;
    L7:
        return !this.f5579a.af().a(r2.name(), r3, r4);
    }

    @Override // com.bytedance.applog.e.e
    public boolean a() {
        if (this.f5579a.af() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
