package com.bytedance.android.livesdk.ceremony.view;

import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CeremonyBorderWidget f104959a;

    public b(CeremonyBorderWidget r100) {
        this.f104959a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        com.bytedance.android.livesdk.ceremony.viewmodel.a r102 = this.f104959a.f104906f;
        if (r102 == null) goto L8;
        ITextureViewPlayerController r103 = r102.f104997b;
        if (r103 == null) goto L8;
        r103.stop();
    L8:
        if (((StaticBorderView) this.f104959a.f104904d.getValue()).f104957d == false) goto L11;
        ((StaticBorderView) this.f104959a.f104904d.getValue()).setAlpha(1.0f);
        return;
    }
}
