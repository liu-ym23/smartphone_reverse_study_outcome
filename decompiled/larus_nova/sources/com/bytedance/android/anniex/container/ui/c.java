package com.bytedance.android.anniex.container.ui;

import android.view.View;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f40563a;

    public c(b r100) {
        this.f40563a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f40563a.f40561a.goBack();
    }
}
