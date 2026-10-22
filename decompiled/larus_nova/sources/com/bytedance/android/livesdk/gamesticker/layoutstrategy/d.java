package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import com.bytedance.android.livesdk.chatroom.gamestickerv2.GameStickerContext;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.view.IRenderView;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements IRenderView.TranslationAndScaleListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveFoldScreenLandscapeLayoutStrategy f125690a;

    public d(LiveFoldScreenLandscapeLayoutStrategy r100) {
        this.f125690a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView.TranslationAndScaleListener
    public final void onTranslationAndScaleChange(float r100, float r101, float r102, float r103) {
        this.f125690a.d(r100, r101, r102, r103);
        LiveFoldScreenLandscapeLayoutStrategy r104 = this.f125690a;
        GameStickerContext r105 = r104.b();
        if (r105 == null) goto L5;
        TranslationAndScaleProperty r106 = r105.getTranslationAndScaleProperty();
    L6:
        if (r106 != null) goto L8;
        r106 = new TranslationAndScaleProperty();
    L8:
        r106.setTranslationX(r100);
        r106.setTranslationY(r101);
        r106.setScaleX(r102);
        r106.setScaleY(r103);
        GameStickerContext r107 = r104.b();
        if (r107 == null) goto L12;
        r107.setTranslationAndScaleProperty(r106);
        return;
    L12:
        return;
    L5:
        r106 = null;
        goto L6
    }
}
