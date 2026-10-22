package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import com.bytedance.android.livesdk.chatroom.gamestickerv2.GameStickerContext;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContainerViewProxy;
import com.bytedance.android.livesdkapi.view.IRenderView;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements IRenderView.LayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f125697a;

    public f(e r100) {
        this.f125697a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.view.IRenderView.LayoutListener
    public final void onLayoutReady(int r100, int r101, int r102, int r103) {
        GameStickerContext r104 = this.f125697a.a();
        if (r104 == null) goto L5;
        BottomContainerParams r105 = r104.getLandscapeOutputParam();
    L6:
        if (r105 == null) goto L21;
        this.f125697a.b("render view layout finish " + r105);
        e r106 = this.f125697a;
        GameStickerContext r107 = r106.a();
        if (r107 == null) goto L12;
        TranslationAndScaleProperty r108 = r107.getTranslationAndScaleProperty();
        if (r108 == null) goto L12;
        r106.c(r108.getTranslationX(), r108.getTranslationY(), r108.getScaleX(), r108.getScaleY());
    L12:
        IGameStickerContainerViewProxy r109 = this.f125697a.f125691a;
        if (r109 == null) goto L15;
        r109.setMargin(r105.getContainerY(), r105.getContainerX());
    L15:
        IGameStickerContainerViewProxy r110 = this.f125697a.f125691a;
        if (r110 == null) goto L18;
        r110.setSize(r105.getContainerW(), r105.getContainerH());
    L18:
        IGameStickerContainerViewProxy r111 = this.f125697a.f125691a;
        if (r111 == null) goto L28;
        r111.onLayoutFinished();
        return;
    L28:
        return;
    L21:
        this.f125697a.b("render view layout finish hide");
        IGameStickerContainerViewProxy r112 = this.f125697a.f125691a;
        if (r112 == null) goto L24;
        r112.setSize(0, 0);
    L24:
        IGameStickerContainerViewProxy r113 = this.f125697a.f125691a;
        if (r113 == null) goto L30;
        r113.onLayoutFinished();
        return;
    L30:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
