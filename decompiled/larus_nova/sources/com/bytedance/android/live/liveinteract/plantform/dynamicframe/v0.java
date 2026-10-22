package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.net.Uri;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class v0 implements com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w0 f77156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f77157b;

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onRuntimeReady(View r100) {
        this.f77156a.onLoadSuccess(r100);
    }

    public v0(w0 r100, Uri r101) {
        this.f77156a = r100;
        this.f77157b = r101;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onLoadFailed(View r100, String r101) {
        this.f77156a.onLoadFail(r100, this.f77157b.toString(), r101);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onLoadStart(Uri r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f77156a.onLoadStart(r101, true);
    }
}
