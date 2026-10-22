package com.bytedance.android.livesdk.interactivity.service.textrender.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements ak6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserDslBadgeUtils.a f141075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f141076b;

    @Override // ak6.e
    public final void a(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // ak6.e
    public final void b(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        this.f141075a.a(r100, this.f141076b.element);
    }

    public h(com.bytedance.android.livesdk.interactivity.enteranim.view.d r100, Ref.BooleanRef r101) {
        this.f141075a = r100;
        this.f141076b = r101;
    }
}
