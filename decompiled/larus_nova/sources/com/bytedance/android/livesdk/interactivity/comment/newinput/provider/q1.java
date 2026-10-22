package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class q1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TruthSectionProvider.TruthPanelController f135953a;

    public q1(TruthSectionProvider.TruthPanelController r100) {
        this.f135953a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f135953a.h();
        com.bytedance.android.livesdk.interactivity.comment.utils.i.b(null, false, false);
    }
}
