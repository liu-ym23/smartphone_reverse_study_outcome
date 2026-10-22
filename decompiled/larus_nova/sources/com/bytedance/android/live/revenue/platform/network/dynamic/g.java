package com.bytedance.android.live.revenue.platform.network.dynamic;

import io.reactivex.processors.PublishProcessor;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements ylc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DynamicHostNetworkServiceImpl f91521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublishProcessor f91522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PublishSubject f91523c;

    @Override // ylc.c
    public final void onClear() {
    }

    @Override // ylc.c
    public final void a(com.ss.ugc.live.sdk.message.wrsc.data.a r100) {
        Intrinsics.checkNotNullParameter(r100, "roomDataSync");
        if (this.f91521a.f91493c.getEnableWRDSMethodSampling() == true) goto L5;
    L7:
        this.f91523c.onNext(r100);
        return;
    L5:
        if (this.f91521a.f91493c.getEnableWRDSMethodSamplingKey().contains(r100.f458186g) == false) goto L7;
        this.f91522b.onNext(r100);
    }

    public g(DynamicHostNetworkServiceImpl r100, PublishProcessor r101, PublishSubject r102) {
        this.f91521a = r100;
        this.f91522b = r101;
        this.f91523c = r102;
    }
}
