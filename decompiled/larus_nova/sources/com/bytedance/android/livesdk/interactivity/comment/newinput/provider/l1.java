package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class l1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1.a f135929a;

    public l1(o1.a r100) {
        this.f135929a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        i40.h.c("shadow view click", true);
        this.f135929a.f135513b.K();
    }
}
