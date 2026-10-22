package com.bytedance.android.live.componentsmarket.impl.components.titledetail;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTitleDetailWidget f64714a;

    public e(LiveTitleDetailWidget r100) {
        this.f64714a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(s1.y(), s1.w());
        this.f64714a.contentView.setLayoutParams(r102);
        this.f64714a.contentView.post(new d(this));
    }
}
