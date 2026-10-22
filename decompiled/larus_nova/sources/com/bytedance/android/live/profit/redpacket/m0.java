package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public final class m0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RedPacketIconModelLoadService f88659a;

    public m0(RedPacketIconModelLoadService r100) {
        this.f88659a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if ((!((List) r100).isEmpty()) == false) goto L6;
        this.f88659a.c(null);
        return;
    }
}
