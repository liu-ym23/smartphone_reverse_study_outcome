package com.bytedance.android.live.revlink.impl.behavior;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes47.dex */
public final class z implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f92202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f92203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f92204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f92205d;

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void a() {
        this.f92202a.c(0.0f);
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void b() {
        this.f92204c.invoke();
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void c() {
        this.f92202a.f92143b.h();
        this.f92202a.c(1.0f);
        this.f92205d.invoke();
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void d() {
        this.f92203b.invoke();
    }

    public z(d0 r100, Function0 r101, Function0 r102, Function0 r103) {
        this.f92202a = r100;
        this.f92203b = r101;
        this.f92204c = r102;
        this.f92205d = r103;
    }
}
