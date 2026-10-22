package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f85227a;

    public d(Function1 r100) {
        this.f85227a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function1 r102 = this.f85227a;
        String r103 = r101.getMessage();
        if (r103 != null) goto L5;
        r103 = "request live/data/real_time fail";
    L5:
        r102.invoke(r103);
        qo0.a.b("LiveMgMountContextService", "request live/data/real_time fail", r101);
    }
}
