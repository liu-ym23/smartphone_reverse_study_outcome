package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.net.Uri;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class z implements com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f77174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f77175b;

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onRuntimeReady(View r100) {
        this.f77174a.onLoadSuccess(r100);
    }

    public z(a0 r100, Uri r101) {
        this.f77174a = r100;
        this.f77175b = r101;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onLoadFailed(View r100, String r101) {
        this.f77174a.onLoadFail(r100, this.f77175b.toString(), r101);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onLoadStart(Uri r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f77174a.onLoadStart(r101, true);
    }
}
