package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f71463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f71464b;

    public c(e r100, Function0 r101) {
        this.f71463a = r100;
        this.f71464b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f71464b.invoke();
        this.f71463a.f71486u.clear();
    }
}
