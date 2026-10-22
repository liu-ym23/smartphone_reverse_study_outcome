package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements com.bytedance.android.live.effect.sticker.presenter.o.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveStickerDialogListAdapter f68736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Sticker f68737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LiveStickerDialogListAdapter.StickerViewHolder f68738c;

    @Override // com.bytedance.android.live.effect.sticker.presenter.o.b
    public final void a(boolean r100) {
        this.f68737b.setDownloaded(r100);
        LiveStickerDialogListAdapter r101 = this.f68736a;
        Sticker r102 = this.f68737b;
        LiveStickerDialogListAdapter.StickerViewHolder r103 = this.f68738c;
        r101.getClass();
        LiveStickerDialogListAdapter.D2(r102, r103);
    }

    public f(LiveStickerDialogListAdapter r100, Sticker r101, LiveStickerDialogListAdapter.StickerViewHolder r102) {
        this.f68736a = r100;
        this.f68737b = r101;
        this.f68738c = r102;
    }
}
