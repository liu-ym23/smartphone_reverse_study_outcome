package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f92418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f92419b;

    public k(e r100, long r101) {
        this.f92418a = r100;
        this.f92419b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        this.f92418a.a(this.f92419b);
    }
}
