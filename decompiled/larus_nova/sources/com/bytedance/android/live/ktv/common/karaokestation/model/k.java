package com.bytedance.android.live.ktv.common.karaokestation.model;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f69533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f69534b;

    public k(long r100, Function1 r101) {
        this.f69533a = r100;
        this.f69534b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        mb0.d.a(LinkMonitorData.ApiListenSongList, System.currentTimeMillis() - this.f69533a, r101);
        ExceptionUtils.handleException(s1.getContext(), r101);
        this.f69534b.invoke(r101);
    }
}
