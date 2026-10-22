package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f76943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ nh0.o f76944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f76945c;

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMessage");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onRelease() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onFail() {
        this.f76943a.g(this.f76945c);
        e.b(this.f76943a, this.f76944b, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onSuccess() {
        e.b(this.f76943a, this.f76944b, 1);
    }

    public g(e r100, nh0.o r101, String r102) {
        this.f76943a = r100;
        this.f76944b = r101;
        this.f76945c = r102;
    }
}
