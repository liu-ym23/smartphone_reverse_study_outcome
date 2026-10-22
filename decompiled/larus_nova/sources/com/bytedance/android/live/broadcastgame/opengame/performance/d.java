package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.broadcastgame.opengame.network.j0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f60734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f60735b;

    public d(Function1 r100, Function2 r101) {
        this.f60734a = r100;
        this.f60735b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        DATA r102 = r101.data;
        if (r102 != 0) goto L5;
        this.f60734a.invoke(1);
        return;
    L5:
        j0 r103 = (j0) r102;
        if (r103.canStop == false) goto L8;
        this.f60734a.invoke(Integer.valueOf(r103.status));
        return;
    L8:
        this.f60735b.invoke(Integer.valueOf(r103.status), Long.valueOf(((j0) r101.data).minRunMinute));
    }
}
