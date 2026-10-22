package com.bytedance.android.live.liveinteract.voicechat.radio;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f80566a;

    public l(String r100) {
        this.f80566a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        ALogger.i("RadioStageContainerWidget", "HybridCard load success:" + this.f80566a);
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        super.onInnerFallback(r100, r101);
        ALogger.e("RadioStageContainerWidget", "HybridCard onInnerFallback errorMessage=" + r101 + ", url:" + this.f80566a);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        ALogger.e("RadioStageContainerWidget", "HybridCard load fail reason=" + r102 + ", url:" + this.f80566a);
    }
}
