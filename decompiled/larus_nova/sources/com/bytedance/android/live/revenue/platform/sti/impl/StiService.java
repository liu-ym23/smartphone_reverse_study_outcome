package com.bytedance.android.live.revenue.platform.sti.impl;

import c01.a;
import com.bytedance.android.live.revenue.core.util.AsyncService;
import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class StiService extends AsyncService implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.sti.a f91661d;

    public StiService(com.bytedance.android.livesdk.revenue.service.sti.a r100) {
        Intrinsics.checkNotNullParameter(r100, "revStiService");
        this.f91661d = r100;
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService
    public final Object o0(Continuation<? super Unit> r100) {
        return Unit.INSTANCE;
    }

    @Override // c01.a
    public final <M extends IRevIconModel<?>> void D9(final Class<M> r100, final Function0<? extends M> r101) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        Intrinsics.checkNotNullParameter(r101, "factory");
        p0(this.f91661d, new StiService$loadIcon$1(r100, r101));
    }
}
