package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends LiveDrawerManageStatus> f122659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Function1<? super LiveDrawerManageStatus, ? extends LiveDrawerManageStatus>, Unit> f122660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<? extends ArrayList<Long>> f122661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> f122662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<? extends ArrayList<FeedItem>> f122664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<? super Function1<? super ArrayList<FeedItem>, ? extends ArrayList<FeedItem>>, Unit> f122665g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Boolean> f122666h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Long> f122668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<? super Function1<? super Long, Long>, Unit> f122669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Boolean> f122670l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122671m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<? extends LiveDrawerPageName> f122672n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<? super Function1<? super LiveDrawerPageName, ? extends LiveDrawerPageName>, Unit> f122673o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<FeedExtra> f122674p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function1<? super Function1<? super FeedExtra, FeedExtra>, Unit> f122675q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function3<? super Boolean, ? super Boolean, ? super Function0<Unit>, Unit> f122676r;

    public j(Function0<? extends LiveDrawerManageStatus> r110, Function1<? super Function1<? super LiveDrawerManageStatus, ? extends LiveDrawerManageStatus>, Unit> r111, Function0<? extends ArrayList<Long>> r112, Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> r210, Function1<? super Function1<? super Boolean, Boolean>, Unit> r211, Function0<? extends ArrayList<FeedItem>> r212, Function1<? super Function1<? super ArrayList<FeedItem>, ? extends ArrayList<FeedItem>>, Unit> r213, Function0<Boolean> r214, Function1<? super Function1<? super Boolean, Boolean>, Unit> r215, Function0<Long> r216, Function1<? super Function1<? super Long, Long>, Unit> r217, Function0<Boolean> r218, Function1<? super Function1<? super Boolean, Boolean>, Unit> r219, Function0<? extends LiveDrawerPageName> r310, Function1<? super Function1<? super LiveDrawerPageName, ? extends LiveDrawerPageName>, Unit> r311, Function0<FeedExtra> r312, Function1<? super Function1<? super FeedExtra, FeedExtra>, Unit> r313, Function3<? super Boolean, ? super Boolean, ? super Function0<Unit>, Unit> r314) {
        Intrinsics.checkNotNullParameter(r110, "manageStatus");
        Intrinsics.checkNotNullParameter(r111, "setManageStatus");
        Intrinsics.checkNotNullParameter(r112, "deleteList");
        Intrinsics.checkNotNullParameter(r210, "setDeleteList");
        Intrinsics.checkNotNullParameter(r211, "setAllSelected");
        Intrinsics.checkNotNullParameter(r212, "dataList");
        Intrinsics.checkNotNullParameter(r213, "setDataList");
        Intrinsics.checkNotNullParameter(r214, "hasMore");
        Intrinsics.checkNotNullParameter(r215, "setHasMore");
        Intrinsics.checkNotNullParameter(r216, "maxTime");
        Intrinsics.checkNotNullParameter(r217, "setMaxTime");
        Intrinsics.checkNotNullParameter(r218, "firstLoading");
        Intrinsics.checkNotNullParameter(r219, "setFirstLoading");
        Intrinsics.checkNotNullParameter(r310, "pageName");
        Intrinsics.checkNotNullParameter(r311, "setPageName");
        Intrinsics.checkNotNullParameter(r312, "extra");
        Intrinsics.checkNotNullParameter(r313, "setExtra");
        Intrinsics.checkNotNullParameter(r314, "fetchFeed");
        this.f122659a = r110;
        this.f122660b = r111;
        this.f122661c = r112;
        this.f122662d = r210;
        this.f122663e = r211;
        this.f122664f = r212;
        this.f122665g = r213;
        this.f122666h = r214;
        this.f122667i = r215;
        this.f122668j = r216;
        this.f122669k = r217;
        this.f122670l = r218;
        this.f122671m = r219;
        this.f122672n = r310;
        this.f122673o = r311;
        this.f122674p = r312;
        this.f122675q = r313;
        this.f122676r = r314;
    }
}
