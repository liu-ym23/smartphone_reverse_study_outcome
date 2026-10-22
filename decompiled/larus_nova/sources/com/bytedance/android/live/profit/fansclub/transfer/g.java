package com.bytedance.android.live.profit.fansclub.transfer;

import android.os.SystemClock;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f87381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f87382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f87383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f87384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f87385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f87386f;

    public g(b r100, long r101, String r102, String r103, long r104, com.bytedance.android.live.revenue.common.g r105) {
        this.f87381a = r100;
        this.f87382b = r101;
        this.f87383c = r102;
        this.f87384d = r103;
        this.f87385e = r104;
        this.f87386f = r105;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        n r111 = (n) r110;
        long r100 = SystemClock.uptimeMillis() - this.f87382b;
        com.bytedance.android.live.profit.privilege.e.f88414a.r(this.f87383c, this.f87384d, this.f87385e, r100, this.f87381a.f87367a.c());
        this.f87386f.a("success");
    }
}
