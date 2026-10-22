package com.bytedance.android.ec.opt.asynctask;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class n extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f48041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f48042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f48043d;

    public final g b() {
        this.f48041b = false;
        g r100 = this.f48043d;
        r100.getClass();
        Intrinsics.checkNotNullParameter("django_live_event", "key");
        r100.f48040b = "django_live_event";
        return this.f48043d;
    }

    @Override // com.bytedance.android.ec.opt.asynctask.i
    public String name() {
        return "mustBeExecuted";
    }

    @Override // com.bytedance.android.ec.opt.asynctask.s, com.bytedance.android.ec.opt.asynctask.i
    public final s a() {
        if (this.f48041b == false) goto L6;
        return this.f48042c;
    L6:
        return this.f48043d;
    }

    public n(i r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
        this.f48042c = new d(this);
        this.f48043d = new g(this);
    }
}
