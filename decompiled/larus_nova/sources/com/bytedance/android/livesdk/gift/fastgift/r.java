package com.bytedance.android.livesdk.gift.fastgift;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.FastGiftDialogHintView;

/* JADX INFO: loaded from: classes9.dex */
public final class r implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f126182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FastGiftDialogHintView f126183b;

    public r(String r100, FastGiftDialogHintView r101) {
        this.f126182a = r100;
        this.f126183b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        String r102 = this.f126182a;
        if (this.f126183b.f126961d.isChecked() == false) goto L5;
        String r103 = "1";
    L6:
        a.d(r102, "cancel", r103);
        return;
    L5:
        r103 = "0";
        goto L6
    }
}
