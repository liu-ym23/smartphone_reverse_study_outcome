package com.bytedance.android.debug;

import android.view.View;

/* JADX INFO: loaded from: classes43.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DebugLocalResourceListAdapter f42625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f42626b;

    public k(DebugLocalResourceListAdapter r100, String r101) {
        this.f42625a = r100;
        this.f42626b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DebugLocalResourceListAdapter.b r101 = this.f42625a.f42595c;
        if (r101 == null) goto L6;
        r101.a(this.f42626b);
        return;
    }
}
