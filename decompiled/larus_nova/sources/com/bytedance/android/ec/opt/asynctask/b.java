package com.bytedance.android.ec.opt.asynctask;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements j {
    public b() {
    }

    @Override // com.bytedance.android.ec.opt.asynctask.j
    public final String name() {
        return "Django_background";
    }

    @Override // com.bytedance.android.ec.opt.asynctask.j
    public final void a(w r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        TaskExecutor.f48030f.getClass();
        TaskExecutor.a.a().f48031a.execute(r100);
    }

    @Override // com.bytedance.android.ec.opt.asynctask.j
    public final void b(w r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        TaskExecutor.f48030f.getClass();
        TaskExecutor.a.a().f48031a.remove(r100);
    }
}
