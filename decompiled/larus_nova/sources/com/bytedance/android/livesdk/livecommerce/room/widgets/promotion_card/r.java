package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f152292a;

    public r(p r100) {
        this.f152292a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        p.a r101 = (p.a) r100;
        ECUIPromotion r102 = r101.f152289a;
        ECUIPromotion r103 = r101.f152290b;
        p r104 = this.f152292a;
        StringBuilder r105 = new StringBuilder("on all resp, explain card id=");
        if (r102 == null) goto L5;
        String r106 = r102.getPromotionId();
    L6:
        r105.append(r106);
        r105.append(", related card id=");
        if (r103 == null) goto L9;
        String r107 = r103.getPromotionId();
    L10:
        r105.append(r107);
        String r108 = r105.toString();
        r104.getClass();
        p.a(r108);
        this.f152292a.f152283b = false;
        this.f152292a.f152284c = r101;
        Function1<? super ECUIPromotion, Unit> r109 = this.f152292a.f152285d;
        if (r109 == null) goto L22;
        if (r103 == null) goto L20;
        if (r102 == null) goto L15;
        long r110 = r102.showPriority;
    L17:
        if (r110 < r103.showPriority) goto L19;
        r109.invoke(null);
        return;
    L19:
        r109.invoke(r103);
        this.f152292a.b(r103);
        return;
    L15:
        r110 = 0;
        goto L17
    L20:
        r109.invoke(null);
        Unit r111 = Unit.INSTANCE;
        return;
    L22:
        return;
    L9:
        r107 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }
}
