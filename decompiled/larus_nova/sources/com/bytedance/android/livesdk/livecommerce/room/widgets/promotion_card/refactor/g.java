package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.ec.model.response.ECAtmosphereItem;
import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f152326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECAtmosphereItem f152327b;

    public g(com.bytedance.android.ec.common.api.jump.model.g r100, ECAtmosphereItem r101) {
        this.f152326a = r100;
        this.f152327b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v r100 = new v("livesdk_show_atmosphere", this.f152326a);     // Catch: Throwable -> L4
        r100.d(this.f152327b.getEventParam());     // Catch: Throwable -> L4
        r100.i("c2627.d945454");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
