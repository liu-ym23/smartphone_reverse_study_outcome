package com.bytedance.android.live.ktv.common.karaokestation.model;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f69529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f69530b;

    public i(long r100, Function1 r101) {
        this.f69529a = r100;
        this.f69530b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        mb0.d.a(LinkMonitorData.ApiGetHotWords, System.currentTimeMillis() - this.f69529a, r101);
        this.f69530b.invoke(r101);
    }
}
