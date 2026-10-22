package com.bytedance.android.livesdk.gamesticker.t01.anim;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TaskState f125757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f125758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f125759c;

    public abstract void a();

    public abstract void d();

    public abstract String e();

    public b() {
        this.f125757a = TaskState.CREATE;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        e();
    }

    public final void c(TaskState r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f125757a = r100;
        if (r100 != TaskState.END) goto L8;
        f r101 = this.f125758b;
        if (r101 == null) goto L13;
        r101.a(this);
        return;
    L13:
        return;
    L8:
        if (r100 != TaskState.START) goto L15;
        f r102 = this.f125758b;
        if (r102 == null) goto L16;
        r102.b(this);
        return;
    L16:
        return;
    }
}
