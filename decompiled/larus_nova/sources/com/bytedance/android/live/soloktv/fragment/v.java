package com.bytedance.android.live.soloktv.fragment;

import android.view.View;
import com.bytedance.android.live.soloktv.viewmodel.SoloKtvEditViewModel;

/* JADX INFO: loaded from: classes7.dex */
public final class v implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvEditFragment f101230a;

    public v(SoloKtvEditFragment r100) {
        this.f101230a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SoloKtvEditViewModel r101 = this.f101230a.f101160n;
        if (r101 == null) goto L6;
        r101.doAction(com.bytedance.android.live.soloktv.viewmodel.f.c.f101885a);
        return;
    }
}
