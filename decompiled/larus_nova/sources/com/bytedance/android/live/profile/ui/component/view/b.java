package com.bytedance.android.live.profile.ui.component.view;

import ak6.e;
import ak6.g;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProfileBadgeSuffixView f86857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f86858b;

    @Override // ak6.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // ak6.e
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        this.f86857a.f86801c.setText(r100.f4074a);
        int r101 = this.f86858b;
        if (r101 <= 0) goto L6;
        int r102 = UtilityKotlinExtentionsKt.i(r101);
        a1.k(this.f86857a.f86799a, r102);
        a1.k(this.f86857a.f86801c, r102);
        this.f86857a.f86799a.setVisibility(0);
        this.f86857a.f86801c.setVisibility(0);
        return;
    }

    public b(ProfileBadgeSuffixView r100, int r101) {
        this.f86857a = r100;
        this.f86858b = r101;
    }
}
