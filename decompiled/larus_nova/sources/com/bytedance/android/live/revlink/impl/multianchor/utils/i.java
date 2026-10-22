package com.bytedance.android.live.revlink.impl.multianchor.utils;

import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f94937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f94938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ld.a f94939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f94940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f94941e;

    public static final class a {
    }

    static {
    }

    public i(ld.a r100, com.bytedance.android.livesdk.revenue.service.room.c r101, com.bytedance.android.live.revlink.impl.global.c r102) {
        this.f94939c = r100;
        this.f94940d = r101;
        this.f94941e = r102;
        this.f94937a = new CompositeDisposable();
        i97.a r103 = i97.a.f488802a;
        this.f94938b = System.currentTimeMillis();
    }
}
