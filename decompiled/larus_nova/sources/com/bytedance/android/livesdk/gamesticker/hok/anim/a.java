package com.bytedance.android.livesdk.gamesticker.hok.anim;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TaskState f125575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f125576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f125577c;

    public abstract void a();

    public abstract void d();

    public abstract String e();

    public a() {
        this.f125575a = TaskState.CREATE;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        e();
    }

    public final void c(TaskState r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f125575a = r100;
        if (r100 != TaskState.END) goto L8;
        d r101 = this.f125576b;
        if (r101 == null) goto L13;
        r101.a(this);
        return;
    L13:
        return;
    L8:
        if (r100 != TaskState.START) goto L15;
        d r102 = this.f125576b;
        if (r102 == null) goto L16;
        r102.b(this);
        return;
    L16:
        return;
    }
}
