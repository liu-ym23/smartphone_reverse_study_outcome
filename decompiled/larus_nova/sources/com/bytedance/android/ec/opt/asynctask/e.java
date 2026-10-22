package com.bytedance.android.ec.opt.asynctask;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f48038a;

    @Override // com.bytedance.android.ec.opt.asynctask.j
    public final String name() {
        return "Django_nonTimeliness_mustBeExecuted_highFreq";
    }

    public e() {
        this.f48038a = "";
    }

    @Override // com.bytedance.android.ec.opt.asynctask.j
    public final void a(w r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (this.f48038a.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        TaskExecutor.f48030f.getClass();
        TaskExecutor.a.a().a(this.f48038a, r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.ec.opt.asynctask.j
    public final void b(w r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (this.f48038a.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        TaskExecutor.f48030f.getClass();
        TaskExecutor.a.a().b(this.f48038a, r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.ec.opt.asynctask.h
    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f48038a = r100;
    }
}
