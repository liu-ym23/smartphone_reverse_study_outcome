package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullScreenOpenPanel f60680a;

    public e(FullScreenOpenPanel r100) {
        this.f60680a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ViewGroup r101 = this.f60680a.f60607g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
    L5:
        r101.setVisibility(8);
        this.f60680a.h();
        View.OnClickListener r102 = this.f60680a.B;
        if (r102 == null) goto L9;
        r102.onClick(r100);
        return;
    }
}
