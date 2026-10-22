package com.bytedance.android.livehostapi.business.depend;

import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes7.dex */
public interface OnStickerViewListener {
    void onStickerCancel(Sticker r100);

    void onStickerChosen(Sticker r100);

    void onStickerViewDismiss(String r100);

    void onStickerViewShow(String r100);

    void onTabChanged(String r100, String r101);
}
