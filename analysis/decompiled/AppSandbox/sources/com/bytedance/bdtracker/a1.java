package com.bytedance.bdtracker;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class a1 extends z0 {
    public final Runnable b;

    public a1(Runnable checkTask) {
        Intrinsics.checkParameterIsNotNull(checkTask, "checkTask");
        this.b = checkTask;
    }

    @Override // com.bytedance.bdtracker.z0
    public void a() {
        this.a.removeCallbacks(this.b);
        this.a.postDelayed(this.b, 100L);
    }
}
