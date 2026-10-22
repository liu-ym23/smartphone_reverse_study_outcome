package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revlink.impl.multianchor.feed.wm.FeedMultiWindowManager;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class MultiDynamicContextFeedImpl implements com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i, c, com.bytedance.android.live.revlink.impl.multianchor.dynamic.g, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f93898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f93899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, com.bytedance.ies.web.jsbridge2.f.b> f93900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.revlink.impl.lynxcontainer.a f93901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a1 f93902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o0 f93903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.l f93904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f93905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c f93906i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FeedMultiWindowManager f93907j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a f93908k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Pair<Integer, Integer>> f93909l;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.a
    public final void b(final zy0.b r100) {
        if (r100 == null) goto L5;
        r100.l1(new MultiDynamicContextFeedImpl$onHybridLoad$1(this, r100));
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i
    public final void c(List<? extends com.bytedance.android.livesdk.link.model.p> r100) {
        StringBuilder r101 = new StringBuilder("onOnlineListRefresh list = ");
        ArrayList r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.toString();
    L6:
        r101.append(r103);
        r101.append(", wrappedList = ");
        if (r100 == null) goto L12;
        r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r104 = r100.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        r102.add(new com.bytedance.android.live.revlink.impl.multianchor.dynamic.f((com.bytedance.android.livesdk.link.model.p) r104.next()));
    L12:
        r101.append(String.valueOf(r102));
        jy0.b.d("multi_lynx", r101.toString());
        this.f93902e.c(r100);
        this.f93903f.c(r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.g
    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return this.f93904g.d(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c
    public final void j(int r100) {
        if (((Boolean) this.f93905h.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        this.f93899b = r100;
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r101 = this.f93906i;
        k31.n r102 = new k31.n(com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97568m.a().s6(), UtilityKotlinExtentionsKt.i(this.f93899b));
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "topOpt");
        r101.F.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.F.d();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.g
    public final void a(List<String> r100, int r101) {
        this.f93904g.a(r100, r101);
    }

    public MultiDynamicContextFeedImpl(com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r100, FeedMultiWindowManager r101, com.bytedance.android.live.revlink.impl.pk.scopeservice.a r110, FeedMultiWindowManager r111, Function0 r112) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
        Intrinsics.checkNotNullParameter(r101, "windowManager");
        Intrinsics.checkNotNullParameter(r111, "dynamicWindowManager");
        Intrinsics.checkNotNullParameter(r112, "getPlayerWH");
        this.f93906i = r100;
        this.f93907j = r101;
        this.f93908k = r110;
        this.f93909l = r112;
        this.f93898a = new CompositeDisposable();
        this.f93900c = new HashMap();
        this.f93902e = new a1(r100, r101, r110, r111, r112);
        this.f93903f = new o0(r100, r101, r110, r111, r112);
        this.f93904g = new com.bytedance.android.live.revlink.impl.multianchor.dynamic.l(new MultiDynamicContextFeedImpl$localComponentManager$1(this));
        this.f93905h = LazyKt.lazy(MultiDynamicContextFeedImpl$isRelayoutOpt$2.INSTANCE);
    }
}
