package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f146727a;

    public l(c r100) {
        this.f146727a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        ALogger.i("RealTimeChorusMicHybridCardManager", "main HybridCard load success");
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        ALogger.e("RealTimeChorusMicHybridCardManager", "main HybridCard onFallback errorMessage=" + r101);
        return super.onFallback(r100, r101);
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        super.onInnerFallback(r100, r101);
        ALogger.e("RealTimeChorusMicHybridCardManager", "main HybridCard onInnerFallback errorMessage=" + r101);
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        super.onContainerError(r100, r101, r102);
        ALogger.e("RealTimeChorusMicHybridCardManager", "main HybridCard onContainerError errorMessage=" + r102);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        ALogger.e("RealTimeChorusMicHybridCardManager", "main HybridCard load fail reason=" + r102);
        this.f146727a.f146698a = null;
    }
}
