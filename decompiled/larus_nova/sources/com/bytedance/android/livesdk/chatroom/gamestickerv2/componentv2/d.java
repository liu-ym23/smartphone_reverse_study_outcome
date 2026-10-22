package com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2;

import android.view.View;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameStickerLynxComponentV2 f106339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f106340b;

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        super.onLoadSuccess(r100);
    }

    public d(GameStickerLynxComponentV2 r100, Function2 r101) {
        this.f106339a = r100;
        this.f106340b = r101;
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        GameStickerLynxComponentV2.f(this.f106339a, this.f106340b, r100, r101);
        return super.onFallback(r100, r101);
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        super.onInnerFallback(r100, r101);
        GameStickerLynxComponentV2.f(this.f106339a, this.f106340b, r100, r101);
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        super.onContainerError(r100, r101, r102);
        GameStickerLynxComponentV2.f(this.f106339a, this.f106340b, r101, r102);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        GameStickerLynxComponentV2 r103 = this.f106339a;
        Function2 r104 = this.f106340b;
        if (r102 != null) goto L5;
        r102 = "load fail";
    L5:
        GameStickerLynxComponentV2.f(r103, r104, -3002, r102);
    }
}
