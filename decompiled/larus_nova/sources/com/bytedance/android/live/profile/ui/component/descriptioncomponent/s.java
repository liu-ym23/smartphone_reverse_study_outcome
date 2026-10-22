package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.view.View;
import com.bytedance.android.live.base.model.user.HonorWallElement;

/* JADX INFO: loaded from: classes47.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f86688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HonorWallElement f86689b;

    public s(p r100, HonorWallElement r101) {
        this.f86688a = r100;
        this.f86689b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        p.j(this.f86688a, this.f86689b);
    }
}
