package com.bytedance.android.live.broadcastgame.opengame.behavior;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class p implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f59781a;

    public p(Function1 r100) {
        this.f59781a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object r100) {
        this.f59781a.invoke(r100);
    }
}
