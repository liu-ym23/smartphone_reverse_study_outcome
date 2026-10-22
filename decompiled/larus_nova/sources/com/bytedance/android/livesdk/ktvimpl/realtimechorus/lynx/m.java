package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class m extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f146728a;

    public m(c r100) {
        this.f146728a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
        ALogger.i("RealTimeChorusMicHybridCardManager", "mGuestLinkMicSeatHybridCard load success");
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        ALogger.e("RealTimeChorusMicHybridCardManager", "mGuestLinkMicSeatHybridCard onFallback errorMessage=" + r101);
        return super.onFallback(r100, r101);
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        super.onInnerFallback(r100, r101);
        ALogger.e("RealTimeChorusMicHybridCardManager", "mGuestLinkMicSeatHybridCard onInnerFallback errorMessage=" + r101);
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        super.onContainerError(r100, r101, r102);
        ALogger.e("RealTimeChorusMicHybridCardManager", "mGuestLinkMicSeatHybridCard onContainerError errorMessage=" + r102);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        ALogger.e("RealTimeChorusMicHybridCardManager", "mGuestLinkMicSeatHybridCard load fail reason=" + r102);
        this.f146728a.f146699b = null;
    }
}
