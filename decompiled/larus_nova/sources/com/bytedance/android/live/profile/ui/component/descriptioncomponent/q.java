package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.view.View;
import com.bytedance.android.live.base.model.user.HonorWallElement;

/* JADX INFO: loaded from: classes47.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f86684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HonorWallElement f86685b;

    public q(p r100, HonorWallElement r101) {
        this.f86684a = r100;
        this.f86685b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        p.j(this.f86684a, this.f86685b);
    }
}
