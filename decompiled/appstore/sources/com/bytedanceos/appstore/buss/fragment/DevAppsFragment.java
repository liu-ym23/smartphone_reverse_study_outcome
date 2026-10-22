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
import com.bytedanceos.appstore.buss.viewmodels.DevAppsViewModel;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010*\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020!8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010.8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/DevAppsFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "onDestroyView", "", "f", "Lkotlin/Lazy;", "N", "()Ljava/lang/String;", "developerName", "g", "M", "developerId", "Lcom/bytedanceos/appstore/buss/viewmodels/DevAppsViewModel;", "h", "O", "()Lcom/bytedanceos/appstore/buss/viewmodels/DevAppsViewModel;", "viewModel", "Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalAdapter;", "i", "Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalAdapter;", "adapter", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "j", "Ljava/util/List;", "dataList", "", "k", "I", "defaultSpanCount", "l", "currentSpanCount", "Lx7/d;", "L", "()Lx7/d;", "commonRecyclerViewBinding", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "m", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDevAppsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DevAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/DevAppsFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,171:1\n106#2,15:172\n50#3,9:187\n*S KotlinDebug\n*F\n+ 1 DevAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/DevAppsFragment\n*L\n55#1:172,15\n68#1:187,9\n*E\n"})
public final class DevAppsFragment extends h7.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f8559m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ItemHorizontalAdapter f8563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f8564j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8565k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8566l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10, String r11) {
            kotlin.jvm.internal.q.g(r11, "developerId");
            DevAppsFragment r12 = new DevAppsFragment();
            r12.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("developerName", r10), kotlin.d.a("developerId", r11)}));
            return r12;
        }

        public a() {
        }
    }

    static {
        f8559m = new a(null);
    }

    public DevAppsFragment() {
        this.f8560f = kotlin.b.b(new DevAppsFragment$developerName$2(this));
        this.f8561g = kotlin.b.b(new DevAppsFragment$developerId$2(this));
        Function0<ViewModelProvider.Factory> r10 = new DevAppsFragment$viewModel$2(this);
        final Function0<Fragment> r11 = new DevAppsFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new DevAppsFragment$special$$inlined$viewModels$default$2(r11));
        final Function0 r13 = null;
        this.f8562h = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(DevAppsViewModel.class), new DevAppsFragment$special$$inlined$viewModels$default$3(r12), new DevAppsFragment$special$$inlined$viewModels$default$4(r13, r12), r10);
        this.f8564j = new ArrayList();
        this.f8565k = 1;
        this.f8566l = 1;
    }

    public static /* synthetic */ void G(DevAppsFragment r10) {
        P(r10);
    }

    public static /* synthetic */ void H(DevAppsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        Q(r10, r11);
    }

    public static final /* synthetic */ String I(DevAppsFragment r10) {
        return r10.M();
    }

    public static final /* synthetic */ String J(DevAppsFragment r10) {
        return r10.N();
    }

    public static final /* synthetic */ DevAppsViewModel K(DevAppsFragment r10) {
        return r10.O();
    }

    private final x7.d L() {
        x7.d r10 = x7.d.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public static final void P(DevAppsFragment r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.O().i();
    }

    public static final void Q(DevAppsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L8;
        if (r10.O().h() != 1) goto L68;
        r10.B();
        return;
    L68:
        return;
    L8:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L58;
        com.bytedanceos.appstore.buss.network.h.c r12 = (com.bytedanceos.appstore.buss.network.h.c) r11;
        List r13 = (List) r12.a();
        if (r10.O().h() != 1) goto L20;
        if (r13 != null) goto L13;
    L19:
        h7.c.A(r10, null, null, 0, 7, null);
    L36:
        if (r13 != null) goto L38;
    L52:
        ItemHorizontalAdapter r14 = r10.f8563i;
        if (r14 == null) goto L73;
        BaseLoadMoreModule r15 = r14.getLoadMoreModule();
        if (r15 == null) goto L74;
        BaseLoadMoreModule.loadMoreEnd$default(r15, false, 1, null);
        return;
    L74:
        return;
    L73:
        return;
    L38:
        if (r13.isEmpty() == true) goto L52;
        if (r13.size() < r10.O().k()) goto L52;
        if (r12.b().getHas_more() == null) goto L52;
        if (kotlin.jvm.internal.q.b(r12.b().getHas_more(), Boolean.FALSE) == true) goto L52;
        ItemHorizontalAdapter r16 = r10.f8563i;
        if (r16 == null) goto L70;
        BaseLoadMoreModule r17 = r16.getLoadMoreModule();
        if (r17 == null) goto L71;
        r17.loadMoreComplete();
        return;
    L71:
        return;
    L70:
        return;
    L13:
        if (r13.isEmpty() == true) goto L19;
        r10.r();
        r10.f8564j.clear();
        r10.f8564j.addAll(r13);
        ItemHorizontalAdapter r18 = r10.f8563i;
        if (r18 == null) goto L18;
        r18.setList(r10.f8564j);
    L18:
        DevAppsViewModel r19 = r10.O();
        r19.n(r19.h() + 1);
        goto L36
    L20:
        r10.r();
        if (r10.f8564j.size() < (r10.O().h() * r10.O().k())) goto L23;
    L32:
        ItemHorizontalAdapter r20 = r10.f8563i;
        if (r20 == null) goto L35;
        r20.setList(r10.f8564j);
    L35:
        DevAppsViewModel r21 = r10.O();
        r21.n(r21.h() + 1);
        goto L36
    L23:
        if ((r10.f8564j.size() % r10.O().k()) != 0) goto L32;
        if (r13 == null) goto L35;
        if (r13.isEmpty() == true) goto L35;
        r10.f8564j.addAll(r13);
        ItemHorizontalAdapter r22 = r10.f8563i;
        if (r22 == null) goto L35;
        r22.setList(r10.f8564j);
        goto L35
    L58:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L76;
        com.bytedanceos.appstore.buss.network.h.a r110 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r110.c());
        if (r10.O().h() != 1) goto L62;
        r10.D(r110);
        return;
    L62:
        ItemHorizontalAdapter r111 = r10.f8563i;
        if (r111 == null) goto L78;
        BaseLoadMoreModule r112 = r111.getLoadMoreModule();
        if (r112 == null) goto L79;
        r112.loadMoreFail();
        return;
    L79:
        return;
    L78:
        return;
    }

    @Override // h7.c
    public void E() {
        O().j().i(this, new i0(this));
    }

    @Override // h7.c
    public void F() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (L().f25515b == null) goto L13;
        com.bytedanceos.appstore.buss.utilities.f r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r11 = r10.f(getActivity());
        if (r11 == this.f8566l) goto L12;
        RecyclerView.LayoutManager r12 = L().f25515b.getLayoutManager();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) r12).Q(r11);
        this.f8566l = r11;
        ViewGroup.LayoutParams r13 = L().f25515b.getLayoutParams();
        r13.width = r11 * r10.a();
        L().f25515b.setLayoutParams(r13);
        return;
    L12:
        return;
    }

    public final String M() {
        return (String) this.f8561g.getValue();
    }

    public final String N() {
        return (String) this.f8560f.getValue();
    }

    public final DevAppsViewModel O() {
        return (DevAppsViewModel) this.f8562h.getValue();
    }

    @Override // h7.c
    public void initData() {
        O().l();
        h7.c.w(this, N(), true, false, 4, null);
        int r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        if (r10 != 0) goto L5;
        L().f25515b.setLayoutManager(new GridLayoutManager(l(), this.f8565k));
    L6:
        this.f8566l = r10;
        this.f8563i = new ItemHorizontalAdapter(false, null, null, 7, null);
        L().f25515b.setAdapter(this.f8563i);
        BaseLoadMoreModule r11 = null;
        L().f25515b.addItemDecoration(new u7.b(0, 1, null));
        ItemHorizontalAdapter r12 = this.f8563i;
        if (r12 == null) goto L11;
        BaseLoadMoreModule r13 = r12.getLoadMoreModule();
        if (r13 == null) goto L11;
        r13.setOnLoadMoreListener(new j0(this));
    L11:
        ItemHorizontalAdapter r14 = this.f8563i;
        if (r14 == null) goto L14;
        BaseLoadMoreModule r15 = r14.getLoadMoreModule();
    L15:
        if (r15 == null) goto L18;
        r15.setAutoLoadMore(true);
    L18:
        ItemHorizontalAdapter r16 = this.f8563i;
        if (r16 == null) goto L21;
        BaseLoadMoreModule r17 = r16.getLoadMoreModule();
    L22:
        if (r17 == null) goto L25;
        r17.setEnableLoadMore(true);
    L25:
        ItemHorizontalAdapter r18 = this.f8563i;
        if (r18 == null) goto L28;
        r11 = r18.getLoadMoreModule();
    L28:
        if (r11 == null) goto L31;
        r11.setEnableLoadMoreIfNotFullPage(false);
    L31:
        Bundle r19 = new Bundle();
        r19.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_dev_list");
        f9.b.b("exposure_pages_main", r19);
        return;
    L21:
        r17 = null;
        goto L22
    L14:
        r15 = null;
        goto L15
    L5:
        L().f25515b.setLayoutManager(new GridLayoutManager(l(), r10));
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_dev_apps;
    }

    @Override // h7.c
    public Function0 o() {
        return new DevAppsFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8563i = null;
        O().m(this);
    }

    @Override // h7.c
    public void t() {
    }
}
