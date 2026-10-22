package com.bytedance.android.shopping.abscontainer.arch.platform.async;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements k33.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Job f164174a;

    @Override // k33.a
    public final void cancel() {
        Job.DefaultImpls.cancel$default(this.f164174a, null, 1, null);
    }

    public a(Job r100) {
        Intrinsics.checkNotNullParameter(r100, "job");
        this.f164174a = r100;
    }
}
