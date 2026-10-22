package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.room.api.view.SimpleIndicatorTextSwitcher2;

/* JADX INFO: loaded from: classes47.dex */
public final class f0 implements fd0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleIndicatorTextSwitcher2 f86515a;

    public f0(SimpleIndicatorTextSwitcher2 r100) {
        this.f86515a = r100;
    }

    @Override // fd0.a
    public final void onStart() {
        SimpleIndicatorTextSwitcher2 r100 = this.f86515a;
        if (r100 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r100);
        return;
    }
}
