package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class q implements qh0.a<rh0.a>, qh0.d<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qh0.d<rh0.a> f77392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qh0.a<rh0.a> f77393b;

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        this.f77392a = r100;
        qh0.a<rh0.a> r101 = this.f77393b;
        if (r101 == null) goto L5;
        r101.a(this);
        return;
    L5:
        c(null);
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        qh0.d<rh0.a> r101 = this.f77392a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.b(r100);
    }

    public final void c(rh0.a r100) {
        qh0.d<rh0.a> r101 = this.f77392a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r101.onResult(r100);
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r100) {
        c(r100);
    }

    public q(qh0.f.e r100, qh0.a<rh0.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "createConfig");
        this.f77393b = r101;
    }
}
