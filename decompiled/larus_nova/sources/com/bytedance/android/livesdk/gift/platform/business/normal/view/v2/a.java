package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GamePlatformGiftCombView f129903a;

    public a(GamePlatformGiftCombView r100) {
        this.f129903a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        int r102 = (int) s1.e(24.0f);
        if (r101 != null) goto L5;
    L8:
        GamePlatformGiftCombView r103 = this.f129903a;
        Bitmap r104 = r103.q(BitmapFactory.decodeResource(r103.getResources(), R.drawable.ttlive_ic_default_gift), r102, r102);
    L9:
        if (r104 != null) goto L11;
        return;
    L11:
        if (r104.isRecycled() == true) goto L19;
        GiftIconMaskView r105 = (GiftIconMaskView) this.f129903a.o(R.id.gift_icon_animation_view);
        if (r105 == null) goto L18;
        r105.a(r104);
        return;
    L18:
        return;
    L19:
        return;
    L5:
        if (r101.isRecycled() == true) goto L8;
        r104 = this.f129903a.q(RevBitmapTranslateUtils.a(r101), r102, r102);
        goto L9
    }
}
