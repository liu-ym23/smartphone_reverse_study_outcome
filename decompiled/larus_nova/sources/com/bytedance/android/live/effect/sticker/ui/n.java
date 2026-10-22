package com.bytedance.android.live.effect.sticker.ui;

/* JADX INFO: loaded from: classes45.dex */
public final class n implements StickerFavoriteImageView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerFavoriteView f68590a;

    @Override // com.bytedance.android.live.effect.sticker.ui.StickerFavoriteImageView.b
    public final void onAnimationEnd() {
        StickerFavoriteView.a r100 = this.f68590a.getFavoriteStatusListener();
        if (r100 == null) goto L5;
        StickerFavoriteView r101 = this.f68590a;
        r100.a(r101.f68465g, r101.f68464f);
    L5:
        StickerFavoriteView r102 = this.f68590a;
        r102.f68466h = true;
        if (r102.f68471m == false) goto L9;
        r102.f68471m = false;
        r102.e(r102.f68469k, r102.f68470l);
        return;
    }

    public n(StickerFavoriteView r100) {
        this.f68590a = r100;
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.StickerFavoriteImageView.b
    public final void onStateChange(int r100) {
        if (r100 != 1) goto L6;
        StickerFavoriteView.a(this.f68590a).setSelected(this.f68590a.f68464f);
        return;
    }
}
