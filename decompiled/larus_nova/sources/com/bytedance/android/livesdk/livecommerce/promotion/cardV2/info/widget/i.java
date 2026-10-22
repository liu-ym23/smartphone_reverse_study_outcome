package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import com.bytedance.android.ec.model.response.o0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.view.CountDownView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements q83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f150648a;

    public i(h r100) {
        this.f150648a = r100;
    }

    @Override // q83.a
    public final boolean onTick(long r110) {
        o0 r100 = this.f150648a.f150644a;
        if (r100 == null) goto L18;
        com.bytedance.android.ec.model.response.k r101 = r100.a();
        if (r101 == null) goto L18;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r102 = this.f150648a.f150646c;
        if (r102 == null) goto L11;
        Long r103 = com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a.C2321a.a(r102, r101.c(), r101.a());
        if (r103 == null) goto L11;
        long r104 = r103.longValue();
    L12:
        h r105 = this.f150648a;
        long r106 = r104 - r110;
        CountDownView r111 = (CountDownView) r105.findViewById(R.id.countdown_view);
        if (r106 <= 0) goto L15;
        r111.setVisibility(0);
        r111.a(r106);
        return true;
    L15:
        r111.setVisibility(4);
        r105.f150647d.f150038b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.b(r105.f150645b);
        return true;
    L11:
        r104 = 0;
    L18:
        return false;
    }
}
