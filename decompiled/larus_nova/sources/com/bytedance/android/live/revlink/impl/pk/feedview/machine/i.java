package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.a5;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedPkMachinePresenter f96572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a5 f96573b;

    public i(FeedPkMachinePresenter r100, a5 r101) {
        this.f96572a = r100;
        this.f96573b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f96572a.h(this.f96573b);
    }
}
