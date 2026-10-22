package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.view.View;
import com.bytedance.android.live.base.model.user.HonorWallElement;

/* JADX INFO: loaded from: classes47.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f86686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HonorWallElement f86687b;

    public r(p r100, HonorWallElement r101) {
        this.f86686a = r100;
        this.f86687b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        p.j(this.f86686a, this.f86687b);
    }
}
