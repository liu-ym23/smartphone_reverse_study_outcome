package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CandyToolbarContextService f85342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f85343b;

    public b(CandyToolbarContextService r100, Function1 r101) {
        this.f85342a = r100;
        this.f85343b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = qo0.a.f534145a;
        qo0.a.b(this.f85342a.f85311a, "request candy entrance_info failed", r101);
        Function1 r103 = this.f85343b;
        String r104 = r101.getMessage();
        if (r104 != null) goto L5;
        r104 = "candy entrance error: request candy entrance_info failed.";
    L5:
        r103.invoke(r104);
    }
}
