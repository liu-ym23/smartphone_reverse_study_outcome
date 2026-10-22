package com.bytedance.android.live.initialize.model;

import com.bytedance.android.live.initialize.IWTOTask;
import com.bytedance.android.live.initialize.state.WTOTaskStatus;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class WTOTaskProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile WTOTaskStatus f69393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f69394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f69395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f69396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f69397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f69398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f69399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f69400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f69401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f69402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IWTOTask f69403k;

    public WTOTaskProxy(IWTOTask r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        this.f69403k = r100;
        this.f69393a = WTOTaskStatus.IDLE;
        this.f69394b = new ReentrantLock();
        this.f69395c = LazyKt.lazy(new WTOTaskProxy$blockPeriod$2(this));
        this.f69396d = LazyKt.lazy(new WTOTaskProxy$threadType$2(this));
        this.f69397e = LazyKt.lazy(new WTOTaskProxy$taskName$2(this));
        this.f69398f = LazyKt.lazy(new WTOTaskProxy$taskBusinessInfo$2(this));
        this.f69399g = LazyKt.lazy(new WTOTaskProxy$baseInfo$2(this));
        this.f69401i = LazyKt.lazy(WTOTaskProxy$enableJatoOpt$2.INSTANCE);
    }
}
