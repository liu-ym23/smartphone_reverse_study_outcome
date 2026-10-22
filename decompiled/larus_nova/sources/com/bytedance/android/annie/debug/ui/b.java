package com.bytedance.android.annie.debug.ui;

import android.view.View;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogItem f39460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DialogAdapter f39461b;

    public b(DialogItem r100, DialogAdapter r101) {
        this.f39460a = r100;
        this.f39461b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f39460a.a(this.f39461b.f39421b);
    }
}
