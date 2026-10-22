package com.bytedance.android.shopping.buynow.container;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f170777a = null;

    static {
        f170777a = new d();
    }

    public d() {
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        r100.setVisibility(8);
        return true;
    }
}
