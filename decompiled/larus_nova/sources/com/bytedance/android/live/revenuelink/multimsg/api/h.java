package com.bytedance.android.live.revenuelink.multimsg.api;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<b> f91890a;

    public h(b r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f91890a = new WeakReference(r100);
    }

    @Override // com.bytedance.android.live.revenuelink.multimsg.api.b
    public final void f(e<?, ? extends Exception> r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        b r101 = this.f91890a.get();
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }
}
