package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.KeyEvent;
import android.view.View;
import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;

/* JADX INFO: loaded from: classes45.dex */
public final class l0 implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerSearchPageView f68759a;

    public l0(StickerSearchPageView r100) {
        this.f68759a = r100;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        boolean r103 = false;
        if (r101 != 66) goto L16;
        StickerSearchBox r104 = StickerSearchPageView.T5(this.f68759a);
        if (r104 == null) goto L7;
        String r105 = r104.getContent();
    L9:
        if (r105 != null) goto L11;
    L12:
        r103 = true;
    L13:
        if (r103 == true) goto L15;
        StickerSearchPageView r106 = this.f68759a;
        r106.f68703q = true;
        StickerSearchPageView.c6(r106);
        this.f68759a.hideKeyboard();
    L15:
        return true;
    L11:
        if (r105.length() != 0) goto L13;
    L7:
        r105 = null;
        goto L9
    L16:
        return false;
    }
}
