package com.bytedance.android.live.openplatform.impl.minigameaudience.launch;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceLaunchMgContextService f85302a;

    public b(AudienceLaunchMgContextService r100) {
        this.f85302a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = qo0.a.f534145a;
        String r102 = this.f85302a.f85296a;
        qo0.a.b(r102, "login fail", (Throwable) r100);
    }
}
