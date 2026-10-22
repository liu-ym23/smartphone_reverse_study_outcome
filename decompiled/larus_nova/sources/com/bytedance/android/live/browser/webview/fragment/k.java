package com.bytedance.android.live.browser.webview.fragment;

import android.view.View;

/* JADX INFO: loaded from: classes45.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridDebugConsoleDialog$HybridDebugConsoleAdapter f64383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HybridDebugConsoleDialog$HybridDebugConsoleViewHolder f64384b;

    public k(HybridDebugConsoleDialog$HybridDebugConsoleAdapter r100, HybridDebugConsoleDialog$HybridDebugConsoleViewHolder r101) {
        this.f64383a = r100;
        this.f64384b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f64383a.f64338a != this.f64384b.getAdapterPosition()) goto L5;
        HybridDebugConsoleDialog$HybridDebugConsoleAdapter r101 = this.f64383a;
        r101.f64338a = -1;
        r101.notifyItemChanged(this.f64384b.getAdapterPosition());
        return;
    L5:
        HybridDebugConsoleDialog$HybridDebugConsoleAdapter r102 = this.f64383a;
        r102.notifyItemChanged(r102.f64338a);
        HybridDebugConsoleDialog$HybridDebugConsoleAdapter r103 = this.f64383a;
        r103.f64338a = this.f64384b.getAdapterPosition();
        HybridDebugConsoleDialog$HybridDebugConsoleAdapter r104 = this.f64383a;
        r104.notifyItemChanged(r104.f64338a);
    }
}
