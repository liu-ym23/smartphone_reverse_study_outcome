package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.view.View;
import android.widget.RadioButton;

/* JADX INFO: loaded from: classes46.dex */
public final class u implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RadioButton f77724a;

    public u(RadioButton r100) {
        this.f77724a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RadioButton r101 = this.f77724a;
        r101.setChecked(!r101.isChecked());
    }
}
