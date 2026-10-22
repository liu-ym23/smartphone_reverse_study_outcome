package com.bytedance.android.livesdk.gift.biggift.view;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomGiftHintDialog f125975a;

    public g(CustomGiftHintDialog r100) {
        this.f125975a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        jy0.b.d("CustomSpecialGiftEffects", "confirm dialog close");
        CustomGiftHintDialog.a(this.f125975a, "close");
        CustomGiftHintDialog.a r101 = this.f125975a.getOnCustomGiftDialogListener();
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
