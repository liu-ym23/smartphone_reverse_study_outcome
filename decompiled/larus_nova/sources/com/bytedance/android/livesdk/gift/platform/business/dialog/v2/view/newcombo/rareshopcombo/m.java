package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftRareShopComboView f126939a;

    public m(GiftRareShopComboView r100) {
        this.f126939a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        AnimatedDrawable2 r102 = this.f126939a.f126912y;
        if (r102 == null) goto L6;
        r102.setAnimationBackend(new q(r102.getAnimationBackend()));
        r102.stop();
        return;
    }
}
