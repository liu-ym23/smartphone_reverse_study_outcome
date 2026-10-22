package com.bytedance.android.livesdk.gift.platform.business.tray2;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f130360a;

    public b(Ref.FloatRef r100) {
        this.f130360a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        com.bytedance.android.livesdk.revenue.service.interactivity.a r102 = (com.bytedance.android.livesdk.revenue.service.interactivity.a) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.interactivity.a.class));
        if (r102 == null) goto L6;
        r102.oe(this.f130360a.element);
        return;
    }
}
