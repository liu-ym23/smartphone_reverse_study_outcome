package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Integer> f122639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<FeedExtra> f122640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f122641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<? extends FeedItem> f122642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f122643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l0 f122644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<? extends l0> f122645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<String> f122646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<? super Function1<? super String, String>, Unit> f122647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<String> f122648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<? super Function1<? super String, String>, Unit> f122649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<? super String, Unit> f122650l;

    public g0(Function0<Integer> r100, Function0<FeedExtra> r101, Function0<Boolean> r102, Function0<? extends FeedItem> r103, boolean r104, l0 r105, Function0<? extends l0> r106, Function0<String> r107, Function1<? super Function1<? super String, String>, Unit> r110, Function0<String> r111, Function1<? super Function1<? super String, String>, Unit> r112, Function1<? super String, Unit> r113) {
        Intrinsics.checkNotNullParameter(r100, "index");
        Intrinsics.checkNotNullParameter(r101, ControlRule.KEY_EXTRA_DATA);
        Intrinsics.checkNotNullParameter(r102, "multiTab");
        Intrinsics.checkNotNullParameter(r103, "feedItem");
        Intrinsics.checkNotNullParameter(r105, "tabItem");
        Intrinsics.checkNotNullParameter(r106, "recommendTabItem");
        Intrinsics.checkNotNullParameter(r107, "showDislikeRoomId");
        Intrinsics.checkNotNullParameter(r110, "setShowDislikeRoomId");
        Intrinsics.checkNotNullParameter(r111, "showUnfollowRoomId");
        Intrinsics.checkNotNullParameter(r112, "setShowUnfollowRoomId");
        Intrinsics.checkNotNullParameter(r113, "deleteRoom");
        this.f122639a = r100;
        this.f122640b = r101;
        this.f122641c = r102;
        this.f122642d = r103;
        this.f122643e = r104;
        this.f122644f = r105;
        this.f122645g = r106;
        this.f122646h = r107;
        this.f122647i = r110;
        this.f122648j = r111;
        this.f122649k = r112;
        this.f122650l = r113;
    }
}
