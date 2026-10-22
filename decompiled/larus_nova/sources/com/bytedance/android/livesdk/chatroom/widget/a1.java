package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.LiveStickerSelectDialogFactory;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class a1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveStickerSelectServiceWidget f118745a;

    public a1(LiveStickerSelectServiceWidget r100) {
        this.f118745a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = LiveStickerSelectDialogFactory.f68451a;
        LiveEffectScene r102 = LiveEffectScene.GiftMenuLive;
        LiveStickerSelectDialogFactory.a(r102, (zg1.d2) r100, new LiveStickerSelectServiceWidget$initJSBEventListener$1$1(this));
    }
}
