package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.prepurchase.arch.container.state.ObservableData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class PdpDataStore {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final ObservableData H;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<com.bytedance.android.shopping.prepurchase.arch.container.intf.l<n>> I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableData f181891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableData f181892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObservableData f181893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f181894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f181895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f181896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f181897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f181898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f181899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f181900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f181901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f181902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f181903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f181904n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f181905o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f181906p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f181907q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f181908r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f181909s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f181910t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f181911u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f181912v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f181913w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f181914x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f181915y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f181916z;

    public final com.bytedance.android.shopping.prepurchase.arch.container.state.e<CommonMeta> a() {
        return (com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.f181894d.getValue();
    }

    public final com.bytedance.android.shopping.prepurchase.arch.container.state.e<List<com.bytedance.android.ecom.arch.slice.adapter.b>> b() {
        return (com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.A.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Control c() {
        return (Control) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.F.getValue()).a();
    }

    public final String d() {
        n r100 = (n) this.f181891a.a();
        if (r100 == null) goto L6;
        String r101 = r100.f181948c;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final ObservableData e() {
        return this.I.d(PdpDataStore$logIdObservable$1.INSTANCE);
    }

    public final ObservableData f() {
        return this.f181891a.f(PdpDataStore$subscribeSearchTopBannerDataChange$1.INSTANCE, PdpDataStore$subscribeSearchTopBannerDataChange$2.INSTANCE, PdpDataStore$subscribeSearchTopBannerDataChange$3.INSTANCE);
    }

    public PdpDataStore(com.bytedance.android.shopping.prepurchase.arch.container.state.d<com.bytedance.android.shopping.prepurchase.arch.container.intf.l<n>> r100) {
        Intrinsics.checkNotNullParameter(r100, "responseWithState");
        this.I = r100;
        this.f181891a = r100.d(PdpDataStore$responseData$1.INSTANCE);
        this.f181892b = r100.d(PdpDataStore$pageMetaObservable$1.INSTANCE);
        this.f181893c = r100.d(PdpDataStore$commonMetaAndControlObservable$1.INSTANCE);
        this.f181894d = LazyKt.lazy(new PdpDataStore$commonMetaObservable$2(this));
        this.f181895e = LazyKt.lazy(new PdpDataStore$topNavigationVOObservable$2(this));
        this.f181896f = LazyKt.lazy(new PdpDataStore$collapseInfoObservable$2(this));
        this.f181897g = LazyKt.lazy(new PdpDataStore$backgroundColorObservable$2(this));
        this.f181898h = LazyKt.lazy(new PdpDataStore$topRightControlsVOObservable$2(this));
        this.f181899i = LazyKt.lazy(new PdpDataStore$scrollNodesObservable$2(this));
        this.f181900j = LazyKt.lazy(new PdpDataStore$searchSuggestInfoObservable$2(this));
        this.f181901k = LazyKt.lazy(new PdpDataStore$bottomNavVOObservable$2(this));
        this.f181902l = LazyKt.lazy(new PdpDataStore$bottomButtonVOObservable$2(this));
        this.f181903m = LazyKt.lazy(new PdpDataStore$playBackObservable$2(this));
        this.f181904n = LazyKt.lazy(new PdpDataStore$headMoreVideoObservable$2(this));
        this.f181905o = LazyKt.lazy(new PdpDataStore$pendantContainerObservable$2(this));
        this.f181906p = LazyKt.lazy(new PdpDataStore$oldPendantContainerObservable$2(this));
        this.f181907q = LazyKt.lazy(new PdpDataStore$shopFloatEntryObservable$2(this));
        this.f181908r = LazyKt.lazy(new PdpDataStore$backToTopEntryObservable$2(this));
        this.f181909s = LazyKt.lazy(new PdpDataStore$questionnaireEntranceObservable$2(this));
        this.f181910t = LazyKt.lazy(new PdpDataStore$smallVideoWindowObservable$2(this));
        this.f181911u = LazyKt.lazy(new PdpDataStore$detailImagesObservable$2(this));
        this.f181912v = LazyKt.lazy(new PdpDataStore$headDataObservable$2(this));
        this.f181913w = LazyKt.lazy(new PdpDataStore$findSameGoodsObservable$2(this));
        this.f181914x = LazyKt.lazy(new PdpDataStore$galleryVOObservable$2(this));
        this.f181915y = LazyKt.lazy(new PdpDataStore$commentPreloadDataObservable$2(this));
        this.f181916z = LazyKt.lazy(new PdpDataStore$templatesObservable$2(this));
        this.A = LazyKt.lazy(new PdpDataStore$componentsVOsObservable$2(this));
        this.B = LazyKt.lazy(new PdpDataStore$actionStorage$2(this));
        this.C = LazyKt.lazy(new PdpDataStore$globalActionObservable$2(this));
        this.D = LazyKt.lazy(new PdpDataStore$pdpLynxDataAfterPackObservable$2(this));
        this.E = LazyKt.lazy(new PdpDataStore$auctionInfoObservable$2(this));
        this.F = LazyKt.lazy(new PdpDataStore$controlObservable$2(this));
        this.G = LazyKt.lazy(new PdpDataStore$halfScreenTransitionAnimationEnabledObservable$2(this));
        this.H = r100.d(PdpDataStore$mainFeedObservable$1.INSTANCE);
    }
}
