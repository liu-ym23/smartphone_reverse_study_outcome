package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f88665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f88666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f88667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f88668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f88669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.u0 f88670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.u0 f88671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.u0 f88672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.u0 f88673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IBaseUser f88674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f88675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f88676l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f88677m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<m> f88678n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RedPacketDataSource f88679o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f88680p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f88681q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f88682r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f88683s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Object f88684t;

    public final int getType() {
        return this.f88675k;
    }

    public n0(String r110, int r111, com.bytedance.android.live.revenue.common.u0 r112, com.bytedance.android.live.revenue.common.u0 r113, com.bytedance.android.live.revenue.common.u0 r114, com.bytedance.android.live.revenue.common.u0 r115, IBaseUser r116, int r210, long r211, int r212, List r213, RedPacketDataSource r214, boolean r215, String r216, long r217, String r310, Object r311) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r112, "remoteCreatedAt");
        Intrinsics.checkNotNullParameter(r113, "waitDuration");
        Intrinsics.checkNotNullParameter(r114, "availableAt");
        Intrinsics.checkNotNullParameter(r115, "expireAt");
        Intrinsics.checkNotNullParameter(r116, "sender");
        Intrinsics.checkNotNullParameter(r213, "description");
        Intrinsics.checkNotNullParameter(r214, "dataSource");
        Intrinsics.checkNotNullParameter(r216, "voucherActivityId");
        Intrinsics.checkNotNullParameter(r311, "original");
        this.f88668d = r110;
        this.f88669e = r111;
        this.f88670f = r112;
        this.f88671g = r113;
        this.f88672h = r114;
        this.f88673i = r115;
        this.f88674j = r116;
        this.f88675k = r210;
        this.f88676l = r211;
        this.f88677m = r212;
        this.f88678n = r213;
        this.f88679o = r214;
        this.f88680p = r215;
        this.f88681q = r216;
        this.f88682r = r217;
        this.f88683s = r310;
        this.f88684t = r311;
        this.f88665a = new LinkedHashMap();
    }
}
