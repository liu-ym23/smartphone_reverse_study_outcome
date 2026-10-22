package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import android.os.SystemClock;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromotionCardLoadOptUtils f152604a;

    public o(PromotionCardLoadOptUtils r100) {
        this.f152604a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        PromotionCardLoadOptUtils r102 = this.f152604a;
        r102.f152545c = Long.valueOf(SystemClock.elapsedRealtime());
        this.f152604a.f152543a = false;
        this.f152604a.f152547e = false;
        Function1<? super ECUIPromotion, Unit> r103 = this.f152604a.f152549g;
        if (r103 == null) goto L5;
        Unit r104 = r103.invoke(null);
    L5:
        this.f152604a.f152549g = null;
    }
}
