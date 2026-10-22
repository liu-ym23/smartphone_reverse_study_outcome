package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromotionCardLoadOptUtils f152594a;

    public j(PromotionCardLoadOptUtils r100) {
        this.f152594a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OptCardUtil.b(null, "handleResponse invoke callback");     // Catch: Throwable -> L6
        Function1<? super ECUIPromotion, Unit> r100 = this.f152594a.f152549g;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        Unit r101 = r100.invoke(this.f152594a.f152546d);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
