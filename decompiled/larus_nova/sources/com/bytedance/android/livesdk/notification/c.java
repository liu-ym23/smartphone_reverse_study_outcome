package com.bytedance.android.livesdk.notification;

import io.reactivex.functions.Consumer;
import zg1.h1;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioLiveNotificationManager f154072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f154073b;

    public c(AudioLiveNotificationManager r100, boolean r101) {
        this.f154072a = r100;
        this.f154073b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((h1) r100).f571836a != 7) goto L6;
        this.f154072a.g(this.f154073b, "live_end");
        return;
    }
}
