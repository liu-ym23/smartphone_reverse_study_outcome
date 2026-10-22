package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f77086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f77087b;

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMessage");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onRelease() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onSuccess() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onFail() {
        this.f77086a.b(this.f77087b);
    }

    public n(o r100, String r101) {
        this.f77086a = r100;
        this.f77087b = r101;
    }
}
