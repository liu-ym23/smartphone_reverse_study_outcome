package com.bytedance.android.live.effect.common;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes45.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCommonStickerListAdapter f67866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Sticker f67867b;

    public n(LiveCommonStickerListAdapter r100, Sticker r101) {
        this.f67866a = r100;
        this.f67867b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f67866a.f67824k.b(r100.getContext(), this.f67867b);
    }
}
