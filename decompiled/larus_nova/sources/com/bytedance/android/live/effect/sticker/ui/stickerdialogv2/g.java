package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveStickerDialogListAdapter f68742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Sticker f68743b;

    public g(LiveStickerDialogListAdapter r100, Sticker r101) {
        this.f68742a = r100;
        this.f68743b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        StickerDialogUIViewModel r101 = this.f68742a.z2();
        if (r101 == null) goto L6;
        Context r102 = r100.getContext();
        Sticker r103 = this.f68743b;
        LiveStickerDialogListAdapter r104 = this.f68742a;
        r101.tryApplySticker(r102, r103, r104.f68603i, r104.f68604j);
        return;
    }
}
