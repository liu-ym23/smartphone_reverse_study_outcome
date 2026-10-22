package com.bytedance.android.livesdk.gift.biggift.view;

import android.view.View;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.livesdk.gift.model.q3;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomGiftHintDialog f125972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q3 f125973b;

    public e(CustomGiftHintDialog r100, q3 r101) {
        this.f125972a = r100;
        this.f125973b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        q3 r101 = this.f125973b;
        HashMap r102 = new HashMap();
        r102.put("has_bought", "1");
        r102.put("card_number", String.valueOf(r101.getLeftScores()));
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(this.f125972a.getContext(), u.a(r101.getEntranceSchemeUrl(), r102));
        jy0.b.d("CustomSpecialGiftEffects", "confirm dialog continue buy relate id" + r101.getRelatedGiftId());
        CustomGiftHintDialog.a(this.f125972a, "buy");
        ViewUtilsKt.e(this.f125972a);
    }
}
