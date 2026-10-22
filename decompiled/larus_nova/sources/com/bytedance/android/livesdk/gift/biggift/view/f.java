package com.bytedance.android.livesdk.gift.biggift.view;

import android.view.View;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomGiftHintDialog f125974a;

    public f(CustomGiftHintDialog r100) {
        this.f125974a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CustomGiftHintDialog.a(this.f125974a, "continue");
        CustomGiftHintDialog.a r101 = this.f125974a.getOnCustomGiftDialogListener();
        if (r101 == null) goto L5;
        r101.b();
    L5:
        ViewUtilsKt.e(this.f125974a);
    }
}
