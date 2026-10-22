package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import androidx.core.util.Consumer;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnPageScrollGuideAnimationEnd;

/* JADX INFO: loaded from: classes9.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftTabViewHolder f127908a;

    public z(GiftTabViewHolder r100) {
        this.f127908a = r100;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L6;
        this.f127908a.o(new OnPageScrollGuideAnimationEnd());
        return;
    }
}
