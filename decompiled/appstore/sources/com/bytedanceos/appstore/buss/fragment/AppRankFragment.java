package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemHorizontalAdapter;
import com.bytedanceos.appstore.buss.entity.AppRankEntityWrap;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.viewmodels.AppRankViewModel;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\rR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0011\u001a\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0017R\u001c\u00103\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00107\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/AppRankFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "onDestroyView", "R", "", "f", "I", "currentSpanCount", "", "g", "Lkotlin/Lazy;", "O", "()Ljava/lang/String;", "title", "h", "N", "()I", "source", "i", "M", "rankType", "j", "getPageSource", "pageSource", "k", "defaultSpanCount", "Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalAdapter;", "l", "Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalAdapter;", "adapter", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "m", "Ljava/util/List;", "dataList", "Lcom/bytedanceos/appstore/buss/viewmodels/AppRankViewModel;", "n", "P", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppRankViewModel;", "viewModel", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/p;", "L", "()Lx7/p;", "fragmentTvAppRankBinding", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppRankFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppRankFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppRankFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,198:1\n106#2,15:199\n50#3,9:214\n*S KotlinDebug\n*F\n+ 1 AppRankFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppRankFragment\n*L\n65#1:199,15\n72#1:214,9\n*E\n"})
public final class AppRankFragment extends h7.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f8506o = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f8510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8511j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8512k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ItemHorizontalAdapter f8513l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f8514m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f8515n;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10, Integer r11, String r12, String r13) {
            AppRankFragment r14 = new AppRankFragment();
            r14.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("title", r10), kotlin.d.a("source", r11), kotlin.d.a("rankType", r12), kotlin.d.a(NetKey.PAGE_SOURCE, r13)}));
            return r14;
        }

        public a() {
        }
    }

    static {
        f8506o = new a(null);
    }

    public AppRankFragment() {
        this.f8507f = 1;
        this.f8508g = kotlin.b.b(new AppRankFragment$title$2(this));
        this.f8509h = kotlin.b.b(new AppRankFragment$source$2(this));
        this.f8510i = kotlin.b.b(new AppRankFragment$rankType$2(this));
        this.f8511j = kotlin.b.b(new AppRankFragment$pageSource$2(this));
        this.f8512k = 1;
        this.f8514m = new ArrayList();
        Function0<ViewModelProvider.Factory> r10 = new AppRankFragment$viewModel$2(this);
        final Function0<Fragment> r11 = new AppRankFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new AppRankFragment$special$$inlined$viewModels$default$2(r11));
        final Function0 r13 = null;
        this.f8515n = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(AppRankViewModel.class), new AppRankFragment$special$$inlined$viewModels$default$3(r12), new AppRankFragment$special$$inlined$viewModels$default$4(r13, r12), r10);
    }

    public static /* synthetic */ void G(AppRankFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        S(r10, r11);
    }

    public static /* synthetic */ void H(AppRankFragment r10) {
        Q(r10);
    }

    public static final /* synthetic */ String I(AppRankFragment r10) {
        return r10.M();
    }

    public static final /* synthetic */ int J(AppRankFragment r10) {
        return r10.N();
    }

    public static final /* synthetic */ AppRankViewModel K(AppRankFragment r10) {
        return r10.P();
    }

    private final int N() {
        return ((Number) this.f8509h.getValue()).intValue();
    }

    private final String O() {
        return (String) this.f8508g.getValue();
    }

    public static final void Q(AppRankFragment r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.P().h();
    }

    public static final void S(AppRankFragment r11, com.bytedanceos.appstore.buss.network.h r12) {
        kotlin.jvm.internal.q.g(r11, "this$0");
        kotlin.jvm.internal.q.d(r12);
        if ((r12 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L8;
        if (r11.P().j() != 1) goto L81;
        r11.B();
        return;
    L81:
        return;
    L8:
        if ((r12 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L71;
        com.bytedanceos.appstore.buss.network.h.c r13 = (com.bytedanceos.appstore.buss.network.h.c) r12;
        AppRankEntityWrap r10 = (AppRankEntityWrap) r13.a();
        if (r10 == null) goto L12;
        List<CommonAppEntity> r14 = r10.getApps();
    L13:
        if (r10 == null) goto L15;
        Integer r15 = Integer.valueOf(r10.getLastId());
    L17:
        if (r11.P().j() != 1) goto L30;
        if (r10 == null) goto L29;
        if (r14 == null) goto L29;
        if (r14.isEmpty() == true) goto L29;
        r11.r();
        r11.f8514m.clear();
        r11.f8514m.addAll(r14);
        ItemHorizontalAdapter r16 = r11.f8513l;
        if (r16 == null) goto L26;
        r16.setList(r11.f8514m);
    L26:
        if (r15 == null) goto L28;
        r11.P().p(r15.intValue());
    L28:
        AppRankViewModel r17 = r11.P();
        r17.o(r17.j() + 1);
    L49:
        if (r14 != null) goto L51;
    L65:
        ItemHorizontalAdapter r18 = r11.f8513l;
        if (r18 == null) goto L86;
        BaseLoadMoreModule r19 = r18.getLoadMoreModule();
        if (r19 == null) goto L87;
        BaseLoadMoreModule.loadMoreEnd$default(r19, false, 1, null);
        return;
    L87:
        return;
    L86:
        return;
    L51:
        if (r14.isEmpty() == true) goto L65;
        if (r14.size() < r11.P().l()) goto L65;
        if (r13.b().getHas_more() == null) goto L65;
        if (kotlin.jvm.internal.q.b(r13.b().getHas_more(), Boolean.FALSE) == true) goto L65;
        ItemHorizontalAdapter r110 = r11.f8513l;
        if (r110 == null) goto L83;
        BaseLoadMoreModule r111 = r110.getLoadMoreModule();
        if (r111 == null) goto L84;
        r111.loadMoreComplete();
        return;
    L84:
        return;
    L83:
        return;
    L29:
        h7.c.A(r11, null, null, 0, 7, null);
        goto L49
    L30:
        r11.r();
        if (r11.f8514m.size() < (r11.P().j() * r11.P().l())) goto L33;
    L43:
        ItemHorizontalAdapter r20 = r11.f8513l;
        if (r20 == null) goto L46;
        r20.setList(r11.f8514m);
    L46:
        AppRankViewModel r21 = r11.P();
        r21.o(r21.j() + 1);
        if (r15 == null) goto L49;
        r11.P().p(r15.intValue());
        goto L49
    L33:
        if ((r11.f8514m.size() % r11.P().l()) != 0) goto L43;
        if (r10 == null) goto L46;
        if (r14 == null) goto L46;
        if (r14.isEmpty() == true) goto L46;
        r11.f8514m.addAll(r14);
        ItemHorizontalAdapter r22 = r11.f8513l;
        if (r22 == null) goto L46;
        r22.setList(r11.f8514m);
        goto L46
    L15:
        r15 = null;
        goto L17
    L12:
        r14 = null;
        goto L13
    L71:
        if ((r12 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L89;
        com.bytedanceos.appstore.buss.network.h.a r112 = (com.bytedanceos.appstore.buss.network.h.a) r12;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r112.c());
        if (r11.P().j() != 1) goto L75;
        r11.D(r112);
        return;
    L75:
        ItemHorizontalAdapter r113 = r11.f8513l;
        if (r113 == null) goto L91;
        BaseLoadMoreModule r114 = r113.getLoadMoreModule();
        if (r114 == null) goto L92;
        r114.loadMoreFail();
        return;
    L92:
        return;
    L91:
        return;
    }

    private final String getPageSource() {
        return (String) this.f8511j.getValue();
    }

    @Override // h7.c
    public void E() {
        P().i().i(this, new u(this));
    }

    @Override // h7.c
    public void F() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (L().f25725b == null) goto L13;
        com.bytedanceos.appstore.buss.utilities.f r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r11 = r10.f(getActivity());
        if (r11 == this.f8507f) goto L12;
        RecyclerView.LayoutManager r12 = L().f25725b.getLayoutManager();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) r12).Q(r11);
        this.f8507f = r11;
        ViewGroup.LayoutParams r13 = L().f25725b.getLayoutParams();
        r13.width = r11 * r10.a();
        L().f25725b.setLayoutParams(r13);
        return;
    L12:
        return;
    }

    public final x7.p L() {
        x7.p r10 = x7.p.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final String M() {
        return (String) this.f8510i.getValue();
    }

    public final AppRankViewModel P() {
        return (AppRankViewModel) this.f8515n.getValue();
    }

    public final void R() {
        Bundle r10 = new Bundle();
        String r11 = O();
        if (r11 == null) goto L23;
        int r12 = r11.hashCode();
        if (r12 == 21590370) goto L20;
        if (r12 == 24499317) goto L16;
        if (r12 != 27920805) goto L23;
        if (r11.equals("游戏榜") == false) goto L23;
        r10.putString("toplist_name", "toplist_game");
        goto L23
    L16:
        if (r11.equals("总排行") == false) goto L23;
        r10.putString("toplist_name", "toplist_all");
        goto L23
    L20:
        if (r11.equals("周排行") == false) goto L23;
        r10.putString("toplist_name", "toplist_week");
    L23:
        StringBuilder r13 = new StringBuilder();
        r13.append("");
        r13.append(P().j() - 1);
        r10.putString("toplist_page_count", r13.toString());
        f9.b.b("toplist_read_length", r10);
    }

    @Override // h7.c
    public void initData() {
        P().m();
        h7.c.w(this, O(), false, false, 6, null);
        int r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        if (r10 != 0) goto L5;
        L().f25725b.setLayoutManager(new GridLayoutManager(l(), this.f8512k));
    L6:
        this.f8507f = r10;
        ItemHorizontalAdapter r11 = new ItemHorizontalAdapter(true, null, getPageSource(), 2, null);
        r11.getLoadMoreModule().setOnLoadMoreListener(new t(this));
        r11.getLoadMoreModule().setAutoLoadMore(true);
        r11.getLoadMoreModule().setEnableLoadMore(true);
        r11.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(true);
        this.f8513l = r11;
        L().f25725b.setAdapter(this.f8513l);
        L().f25725b.setPageSource(getPageSource());
        L().f25725b.addItemDecoration(new u7.b(0, 1, null));
        Bundle r12 = new Bundle();
        r12.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, getPageSource());
        f9.b.b("exposure_pages_main", r12);
        return;
    L5:
        L().f25725b.setLayoutManager(new GridLayoutManager(l(), r10));
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_app_rank;
    }

    @Override // h7.c
    public Function0 o() {
        return new AppRankFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8513l = null;
        P().n(this);
        R();
    }

    @Override // h7.c
    public void t() {
    }
}
