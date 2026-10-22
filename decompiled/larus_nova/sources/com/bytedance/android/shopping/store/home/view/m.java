package com.bytedance.android.shopping.store.home.view;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f184716a;

    public m(n r100) {
        this.f184716a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        n r101 = this.f184716a;
        ViewGroup r102 = r101.f184723g;
        if (r102 == null) goto L5;
        r102.removeView(r101);
    L5:
        ECBubbleControllerManager r103 = ECBubbleControllerManager.f48207b;
        com.bytedance.android.ec.store.common.bubble.c r104 = r103.a(r101.f184721e);
        r104.d();
        com.bytedance.android.ec.store.common.bubble.c.e(r104);
        com.bytedance.android.ec.store.common.bubble.c.e(r103.a(this.f184716a.getLifecycleOwner()));
    }
}
