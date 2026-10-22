package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f73428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gm2.i f73429b;

    public j(long r100, gm2.i r101) {
        this.f73428a = r100;
        this.f73429b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        long r102 = this.f73428a;
        long r103 = System.currentTimeMillis() - r102;
        String r104 = r101.logId;
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        InteractLinkFullLinkMonitor.U(100102, r103, r104);
        int r105 = nd0.g.f518750a;
        nd0.g.i(this.f73429b, this.f73428a, r101.logId);
    }
}
