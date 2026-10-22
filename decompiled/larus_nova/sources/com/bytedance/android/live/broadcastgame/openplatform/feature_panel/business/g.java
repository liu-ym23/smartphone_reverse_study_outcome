package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.live.broadcastgame.opengame.q;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f61439a = null;

    static {
        f61439a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = q.f60744a;
        q.i((Throwable) r100, "OpenFeatureListHandler", "saveOpenFeatureList2Local error");
    }
}
