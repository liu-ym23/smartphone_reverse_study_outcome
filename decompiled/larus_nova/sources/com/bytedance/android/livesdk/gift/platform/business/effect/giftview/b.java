package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftSwitchImageView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxVideoView f129367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f129368b;

    public b(LynxVideoView r100, int r101) {
        this.f129367a = r100;
        this.f129368b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        LynxVideoView r102 = this.f129367a;
        if (r102.f129339d == false) goto L13;
        GiftSwitchImageView r103 = r102.f129337b;
        if (r103 == null) goto L9;
        if (r103.getCurrentSwitchType() == 0) goto L13;
    L9:
        if (this.f129368b == 0) goto L13;
        GiftSwitchImageView r104 = this.f129367a.f129337b;
        if (r104 == null) goto L16;
        r104.setVisibility(0);
    L16:
        int r105 = this.f129368b;
        if (r105 == 0) goto L24;
        GiftSwitchImageView r106 = this.f129367a.f129337b;
        if (r106 == null) goto L21;
        r106.setDuration(r105);
    L21:
        GiftSwitchImageView r107 = this.f129367a.f129337b;
        if (r107 == null) goto L24;
        r107.V5();
    L24:
        Disposable r108 = this.f129367a.f129340e;
        if (r108 == null) goto L28;
        r108.dispose();
        return;
    L28:
        return;
    L13:
        GiftSwitchImageView r109 = this.f129367a.f129337b;
        if (r109 == null) goto L16;
        r109.setVisibility(8);
        goto L16
    }
}
