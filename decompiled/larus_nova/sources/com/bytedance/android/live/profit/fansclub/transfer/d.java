package com.bytedance.android.live.profit.fansclub.transfer;

import android.os.SystemClock;
import com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f87369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f87370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f87371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f87372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f87373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f87374f;

    public d(b r100, long r101, String r102, String r103, long r104, com.bytedance.android.live.revenue.common.g r105) {
        this.f87369a = r100;
        this.f87370b = r101;
        this.f87371c = r102;
        this.f87372d = r103;
        this.f87373e = r104;
        this.f87374f = r105;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        IGetFansclubHomepageResult r111 = (IGetFansclubHomepageResult) r110;
        long r100 = SystemClock.uptimeMillis() - this.f87370b;
        com.bytedance.android.live.profit.privilege.e.f88414a.r(this.f87371c, this.f87372d, this.f87373e, r100, this.f87369a.f87367a.c());
        this.f87374f.a("success");
    }
}
