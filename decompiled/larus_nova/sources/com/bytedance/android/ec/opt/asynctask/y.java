package com.bytedance.android.ec.opt.asynctask;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class y implements j {
    public y() {
    }

    @Override // com.bytedance.android.ec.opt.asynctask.j
    public final String name() {
        return "Django_timeliness_heavy";
    }

    @Override // com.bytedance.android.ec.opt.asynctask.j
    public final void a(w r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        TaskExecutor.f48030f.getClass();
        TaskExecutor.a.a().f48033c.execute(r100);
    }

    @Override // com.bytedance.android.ec.opt.asynctask.j
    public final void b(w r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        TaskExecutor.f48030f.getClass();
        TaskExecutor.a.a().f48033c.remove(r100);
    }
}
