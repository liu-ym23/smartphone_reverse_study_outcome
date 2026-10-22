package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiAudienceSeiComponent f97765a;

    public g(MultiAudienceSeiComponent r100) {
        this.f97765a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MultiAudienceSeiComponent r101 = this.f97765a;
        r101.getClass();
        String r102 = com.bytedance.android.live.revlink.link.biz.service.e.a.a(r101);
        jy0.b.b(r102, "", (Throwable) r100);
    }
}
