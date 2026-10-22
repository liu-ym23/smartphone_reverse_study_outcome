package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.net.Uri;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m implements com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b7.a f77140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f77141b;

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onRuntimeReady(View r100) {
        this.f77140a.onLoadSuccess(r100);
    }

    public m(b7.a r100, Uri r101) {
        this.f77140a = r100;
        this.f77141b = r101;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onLoadFailed(View r100, String r101) {
        this.f77140a.onLoadFail(r100, this.f77141b.toString(), r101);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onLoadStart(Uri r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f77140a.onLoadStart(r101, true);
    }
}
