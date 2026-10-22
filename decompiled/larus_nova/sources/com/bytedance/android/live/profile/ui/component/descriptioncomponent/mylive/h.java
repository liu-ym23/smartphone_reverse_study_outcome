package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profile.customview.ProfileNestedScrollView;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements ProfileNestedScrollView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProfileTabsComponent f86632a;

    public h(ProfileTabsComponent r100) {
        this.f86632a = r100;
    }

    @Override // com.bytedance.android.live.profile.customview.ProfileNestedScrollView.b
    public final void a(int r100, int r101, int r102) {
        if (r101 < r102) goto L6;
        View r103 = this.f86632a.f86579f;
        if (r103 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r103);
        return;
    L10:
        return;
    L6:
        View r104 = this.f86632a.f86579f;
        if (r104 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r104);
        return;
    }
}
