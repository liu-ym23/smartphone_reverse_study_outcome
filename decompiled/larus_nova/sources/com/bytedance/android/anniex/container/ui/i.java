package com.bytedance.android.anniex.container.ui;

import android.view.View;

/* JADX INFO: loaded from: classes43.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f40579a;

    public i(h r100) {
        this.f40579a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f40579a.f40572b.goBack();
    }
}
