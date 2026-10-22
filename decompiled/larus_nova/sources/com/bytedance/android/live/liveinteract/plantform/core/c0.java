package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f76172a;

    public c0(long r100) {
        this.f76172a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        long r102 = this.f76172a;
        long r103 = System.currentTimeMillis() - r102;
        if (r101 == null) goto L6;
        String r104 = r101.logId;
        if (r104 == null) goto L6;
    L7:
        InteractLinkFullLinkMonitor.x("optimize_first_enter_in_list", r103, r104);
        return;
    L6:
        r104 = "";
        goto L7
    }
}
