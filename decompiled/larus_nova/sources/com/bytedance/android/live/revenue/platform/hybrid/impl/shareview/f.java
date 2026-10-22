package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import io.reactivex.functions.Action;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevShareViewServiceImpl.c f91449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c f91450b;

    public f(RevShareViewServiceImpl.c r100, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r101) {
        this.f91449a = r100;
        this.f91450b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Map<String, ? extends Object> r100 = MapsKt.mapOf(TuplesKt.to("id", this.f91449a.f91424b));
        this.f91450b.a("share-view-unload", r100);
        RevShareViewServiceImpl.c r101 = this.f91449a;
        r101.f91423a.f91417a.remove(r101.f91424b);
    }
}
