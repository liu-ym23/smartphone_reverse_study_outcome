package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.locallife.dito.data.DitoNode;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f122715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Function1<? super String, String>, Unit> f122716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function5<? super Boolean, ? super String, ? super String, ? super Boolean, ? super Integer, Unit> f122717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f122718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f122719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super Function1<? super LiveSearchResultPageStatus, ? extends LiveSearchResultPageStatus>, Unit> f122720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<String> f122721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<? super Function1<? super String, String>, Unit> f122722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Boolean> f122723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<? extends ArrayList<String>> f122724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<? super Function1<? super ArrayList<String>, ? extends ArrayList<String>>, Unit> f122725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Boolean> f122726l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122727m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<Boolean> f122728n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122729o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<? extends Map<String, Object>> f122730p;

    public p0(Function0<String> r110, Function1<? super Function1<? super String, String>, Unit> r111, Function5<? super Boolean, ? super String, ? super String, ? super Boolean, ? super Integer, Unit> r112, Function0<Unit> r210, Function0<Boolean> r211, Function1<? super Function1<? super LiveSearchResultPageStatus, ? extends LiveSearchResultPageStatus>, Unit> r212, Function0<String> r213, Function1<? super Function1<? super String, String>, Unit> r214, Function0<Boolean> r215, Function0<? extends ArrayList<String>> r216, Function1<? super Function1<? super ArrayList<String>, ? extends ArrayList<String>>, Unit> r217, Function0<Boolean> r218, Function1<? super Function1<? super Boolean, Boolean>, Unit> r219, Function0<Boolean> r310, Function1<? super Function1<? super Boolean, Boolean>, Unit> r311, Function0<? extends Map<String, Object>> r312) {
        Intrinsics.checkNotNullParameter(r110, "searchText");
        Intrinsics.checkNotNullParameter(r111, "setSearchText");
        Intrinsics.checkNotNullParameter(r112, "searchWord");
        Intrinsics.checkNotNullParameter(r210, DitoNode.LOAD_MORE);
        Intrinsics.checkNotNullParameter(r211, "hasMore");
        Intrinsics.checkNotNullParameter(r212, "setResultPageStatus");
        Intrinsics.checkNotNullParameter(r213, "searchId");
        Intrinsics.checkNotNullParameter(r214, "setSearchId");
        Intrinsics.checkNotNullParameter(r215, "fromRecommend");
        Intrinsics.checkNotNullParameter(r216, "searchHistoryData");
        Intrinsics.checkNotNullParameter(r217, "setSearchHistoryData");
        Intrinsics.checkNotNullParameter(r218, "showAllHistory");
        Intrinsics.checkNotNullParameter(r219, "setShowAllHistory");
        Intrinsics.checkNotNullParameter(r310, "isFocus");
        Intrinsics.checkNotNullParameter(r311, "setIsFocus");
        Intrinsics.checkNotNullParameter(r312, "getLogPassback");
        this.f122715a = r110;
        this.f122716b = r111;
        this.f122717c = r112;
        this.f122718d = r210;
        this.f122719e = r211;
        this.f122720f = r212;
        this.f122721g = r213;
        this.f122722h = r214;
        this.f122723i = r215;
        this.f122724j = r216;
        this.f122725k = r217;
        this.f122726l = r218;
        this.f122727m = r219;
        this.f122728n = r310;
        this.f122729o = r311;
        this.f122730p = r312;
    }
}
