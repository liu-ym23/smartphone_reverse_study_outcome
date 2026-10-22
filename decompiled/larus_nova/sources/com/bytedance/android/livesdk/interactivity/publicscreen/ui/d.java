package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorPublicScreenConfigDialog f140238a;

    public d(AnchorPublicScreenConfigDialog r100) {
        this.f140238a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnchorPublicScreenConfigDialog r101 = this.f140238a;
        int r102 = AnchorPublicScreenConfigDialog.B;
        r101.onCancel();
    }
}
