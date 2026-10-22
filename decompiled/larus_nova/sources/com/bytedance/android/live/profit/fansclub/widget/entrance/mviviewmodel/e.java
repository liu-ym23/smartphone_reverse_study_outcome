package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f87593a;

    public e(m r100) {
        this.f87593a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.i("FollowMVIViewModel", "waiting fansclub incentive timeout " + this.f87593a);
    }
}
