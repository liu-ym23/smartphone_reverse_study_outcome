package com.bytedance.android.live.profile.ui.base;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f86337a;

    @Override // com.bytedance.android.live.profile.ui.base.n
    public final int getBottom() {
        return this.f86337a.getBottom();
    }

    @Override // com.bytedance.android.live.profile.ui.base.n
    public final ViewGroup.LayoutParams getLayoutParams() {
        return this.f86337a.getLayoutParams();
    }

    public o(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f86337a = r100;
    }

    @Override // com.bytedance.android.live.profile.ui.base.n
    public final void a(float r100) {
        this.f86337a.setRotation(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.n
    public final void setLayoutParams(ViewGroup.LayoutParams r100) {
        this.f86337a.setLayoutParams(r100);
    }
}
