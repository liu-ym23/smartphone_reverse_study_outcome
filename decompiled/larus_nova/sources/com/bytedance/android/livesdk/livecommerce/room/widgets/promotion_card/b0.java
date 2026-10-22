package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import android.os.SystemClock;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f152255a;

    public b0(y r100) {
        this.f152255a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        y r102 = this.f152255a;
        r102.f152730c = Long.valueOf(SystemClock.elapsedRealtime());
        y r103 = this.f152255a;
        r103.f152728a = false;
        r103.f152732e = false;
        Function1<? super ECUIPromotion, Unit> r104 = this.f152255a.f152734g;
        if (r104 == null) goto L5;
        Unit r105 = r104.invoke(null);
    L5:
        this.f152255a.f152734g = null;
    }
}
