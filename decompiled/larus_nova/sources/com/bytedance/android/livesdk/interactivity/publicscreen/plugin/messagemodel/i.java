package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import android.view.View;
import com.bytedance.android.live.base.model.message.m1;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PSInteractivityShareMessageViewHolder f139260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m1 f139261b;

    public i(PSInteractivityShareMessageViewHolder r100, m1 r101) {
        this.f139260a = r100;
        this.f139261b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PSInteractivityShareMessageViewHolder r101 = this.f139260a;
        r101.f139213o.invoke(this.f139261b, r101.itemView.getContext());
    }
}
