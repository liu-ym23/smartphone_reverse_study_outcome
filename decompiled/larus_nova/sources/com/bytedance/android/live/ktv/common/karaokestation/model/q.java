package com.bytedance.android.live.ktv.common.karaokestation.model;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f69545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f69546b;

    public q(long r100, Function1 r101) {
        this.f69545a = r100;
        this.f69546b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        mb0.d.a(LinkMonitorData.ApiPinSong, System.currentTimeMillis() - this.f69545a, r101);
        ExceptionUtils.handleException(s1.getContext(), r101);
        this.f69546b.invoke(r101);
    }
}
