package com.bytedance.android.live.revlink.impl.behavior;

/* JADX INFO: loaded from: classes47.dex */
public final class m0 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f92179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f92180b;

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void a() {
        c r100 = this.f92180b;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void b() {
        if (this.f92179a == false) goto L5;
        return;
    L5:
        c r100 = this.f92180b;
        if (r100 == null) goto L8;
        r100.b();
    L8:
        this.f92179a = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void c() {
        c r100 = this.f92180b;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void d() {
        c r100 = this.f92180b;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    public m0(c r100) {
        this.f92180b = r100;
    }
}
