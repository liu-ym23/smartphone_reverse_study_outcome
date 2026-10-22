package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f73424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gm2.i f73425b;

    public h(long r100, gm2.i r101) {
        this.f73424a = r100;
        this.f73425b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        long r102 = this.f73424a;
        long r103 = System.currentTimeMillis() - r102;
        String r104 = r101.logId;
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        InteractLinkFullLinkMonitor.U(100101, r103, r104);
        int r105 = nd0.g.f518750a;
        nd0.g.i(this.f73425b, this.f73424a, r101.logId);
    }
}
