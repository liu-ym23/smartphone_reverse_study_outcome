package com.bytedance.android.live.effect.common;

import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes45.dex */
public final class m implements com.bytedance.android.live.effect.api.l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCommonStickerListAdapter f67863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Sticker f67864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LiveCommonStickerListAdapter.StickerViewHolder f67865c;

    @Override // com.bytedance.android.live.effect.api.l.a
    public final void a(boolean r100) {
        this.f67864b.setDownloaded(r100);
        this.f67863a.B2(this.f67864b, this.f67865c);
    }

    public m(LiveCommonStickerListAdapter r100, Sticker r101, LiveCommonStickerListAdapter.StickerViewHolder r102) {
        this.f67863a = r100;
        this.f67864b = r101;
        this.f67865c = r102;
    }
}
