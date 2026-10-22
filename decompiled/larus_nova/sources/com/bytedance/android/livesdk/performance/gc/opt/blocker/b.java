package com.bytedance.android.livesdk.performance.gc.opt.blocker;

import com.bytedance.android.livesdk.t1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f154625a;

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void a(GcBlockScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f154625a.a(r100);
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void b(GcBlockScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f154625a.b(r100);
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void prepare() {
        this.f154625a.prepare();
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void release() {
        this.f154625a.release();
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.blocker.a
    public final void requestBlockGc(int r100) {
        this.f154625a.requestBlockGc(r100);
    }

    public b() {
        int r100 = t1.f158504a.getValue().getGcBlockerMode();
        if (r100 != 1) goto L5;
        a r101 = new d();
    L9:
        this.f154625a = r101;
        return;
    L5:
        if (r100 == 2) goto L7;
        r101 = new c();
        goto L9
    L7:
        r101 = new NewGcBlocker();
        goto L9
    }
}
