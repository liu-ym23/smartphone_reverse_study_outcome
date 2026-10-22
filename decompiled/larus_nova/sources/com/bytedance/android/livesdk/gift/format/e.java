package com.bytedance.android.livesdk.gift.format;

import com.bytedance.android.livesdk.gift.platform.business.effect.player.k;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftPlayerView f126227a;

    public e(GiftPlayerView r100) {
        this.f126227a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        int r102 = GiftPlayerView.f126206k;
        this.f126227a.e("get assets path success: " + r101);
        if (r101.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        k r104 = this.f126227a.f126207a;
        if (r104 == null) goto L12;
        ITextureViewPlayerController.DefaultImpls.start$default(r104, r101, false, false, false, null, 28, null);
        return;
    L12:
        return;
    L10:
        GiftPlayerView.c(this.f126227a);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
