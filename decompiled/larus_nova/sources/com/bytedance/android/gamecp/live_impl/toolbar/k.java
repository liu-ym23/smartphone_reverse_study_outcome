package com.bytedance.android.gamecp.live_impl.toolbar;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f58008a;

    public k(l r100) {
        this.f58008a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ToolbarContext r101 = this.f58008a.f58011c;
        if (r101 == null) goto L5;
        r101.setPreloadToolbarHasClick(true);
    L5:
        yr.b.b(4, "AudiencePreloadToolbarView", SendEventContainerMethodParamModel.EventKinds.onClick);
    }
}
