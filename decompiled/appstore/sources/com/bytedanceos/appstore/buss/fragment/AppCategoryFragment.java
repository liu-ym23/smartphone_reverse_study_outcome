package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.app.pager.adapter.PagerTypeAdapter;
import com.bytedanceos.appstore.buss.adapter.onetype.AppCategoryTitleAdapter;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.CategoryEntityWrap;
import com.bytedanceos.appstore.buss.entity.CategoryTitleEntity;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.viewmodels.AppCategoryViewModel;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u001f\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u001bR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R$\u00107\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`48\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R$\u0010:\u001a\u0012\u0012\u0004\u0012\u00020802j\b\u0012\u0004\u0012\u000208`48\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00106R\u0014\u0010;\u001a\u00020\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u001bR\u001c\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010<8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/AppCategoryFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "", "position", "U", "(I)V", "onDestroyView", "", "Lcom/bytedanceos/appstore/buss/entity/CategoryEntityWrap;", "data", "T", "(Ljava/util/List;)V", "", "f", "Lkotlin/Lazy;", "R", "()Ljava/lang/String;", "title", "g", "M", "()I", "categoryId", "h", "Q", "subCategoryId", "", "i", "P", "()Z", "showHomeAsUp", "Lcom/bytedanceos/appstore/buss/viewmodels/AppCategoryViewModel;", "j", "O", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppCategoryViewModel;", NetKey.MODEL, "Lcom/bytedanceos/appstore/buss/adapter/onetype/AppCategoryTitleAdapter;", "k", "Lcom/bytedanceos/appstore/buss/adapter/onetype/AppCategoryTitleAdapter;", "titleAdapter", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PagerTypeAdapter;", "l", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PagerTypeAdapter;", "appAdapter", "Ljava/util/ArrayList;", "Lcom/bytedanceos/appstore/buss/entity/CategoryTitleEntity;", "Lkotlin/collections/ArrayList;", "m", "Ljava/util/ArrayList;", "categoryTitleList", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "n", "categoryAppList", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/t;", "N", "()Lx7/t;", "fragmentTvCategoryBinding", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppCategoryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppCategoryFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppCategoryFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,177:1\n106#2,15:178\n1864#3,3:193\n50#4,9:196\n*S KotlinDebug\n*F\n+ 1 AppCategoryFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppCategoryFragment\n*L\n64#1:178,15\n130#1:193,3\n77#1:196,9\n*E\n"})
public final class AppCategoryFragment extends h7.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f8446o = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f8450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AppCategoryTitleAdapter f8452k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PagerTypeAdapter f8453l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f8454m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f8455n;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10, Integer r11, Integer r12, boolean r13) {
            AppCategoryFragment r14 = new AppCategoryFragment();
            r14.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("title", r10), kotlin.d.a("categoryId", r11), kotlin.d.a("subCategoryId", r12), kotlin.d.a("showHomeAsUp", Boolean.valueOf(r13))}));
            return r14;
        }

        public a() {
        }
    }

    public static final class b extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCategoryFragment f8456a;

        public b(AppCategoryFragment r10) {
            this.f8456a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView r10, int r11) {
            kotlin.jvm.internal.q.g(r10, "recyclerView");
            super.onScrollStateChanged(r10, r11);
            if (r11 != 0) goto L5;
        L7:
            RecyclerView.LayoutManager r12 = AppCategoryFragment.J(this.f8456a).f25757b.getLayoutManager();
            kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int r13 = ((LinearLayoutManager) r12).findFirstVisibleItemPosition();
            AppCategoryTitleAdapter r14 = AppCategoryFragment.L(this.f8456a);
            if (r14 == null) goto L11;
            r14.b(r13);
            return;
        L11:
            return;
        L5:
            if (r11 == 1) goto L7;
        }
    }

    static {
        f8446o = new a(null);
    }

    public AppCategoryFragment() {
        this.f8447f = kotlin.b.b(new AppCategoryFragment$title$2(this));
        this.f8448g = kotlin.b.b(new AppCategoryFragment$categoryId$2(this));
        this.f8449h = kotlin.b.b(new AppCategoryFragment$subCategoryId$2(this));
        this.f8450i = kotlin.b.b(new AppCategoryFragment$showHomeAsUp$2(this));
        Function0<ViewModelProvider.Factory> r10 = new AppCategoryFragment$model$2(this);
        final Function0<Fragment> r11 = new AppCategoryFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new AppCategoryFragment$special$$inlined$viewModels$default$2(r11));
        final Function0 r13 = null;
        this.f8451j = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(AppCategoryViewModel.class), new AppCategoryFragment$special$$inlined$viewModels$default$3(r12), new AppCategoryFragment$special$$inlined$viewModels$default$4(r13, r12), r10);
        this.f8454m = new ArrayList();
        this.f8455n = new ArrayList();
    }

    public static /* synthetic */ void G(AppCategoryFragment r10, BaseQuickAdapter r11, View r12, int r13) {
        S(r10, r11, r12, r13);
    }

    public static /* synthetic */ void H(AppCategoryFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        V(r10, r11);
    }

    public static final /* synthetic */ int I(AppCategoryFragment r10) {
        return r10.M();
    }

    public static final /* synthetic */ x7.t J(AppCategoryFragment r10) {
        return r10.N();
    }

    public static final /* synthetic */ AppCategoryViewModel K(AppCategoryFragment r10) {
        return r10.O();
    }

    public static final /* synthetic */ AppCategoryTitleAdapter L(AppCategoryFragment r10) {
        return r10.f8452k;
    }

    private final String R() {
        return (String) this.f8447f.getValue();
    }

    public static final void S(AppCategoryFragment r10, BaseQuickAdapter r11, View r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "<anonymous parameter 0>");
        kotlin.jvm.internal.q.g(r12, "view");
        r10.U(r13);
        Bundle r14 = new Bundle();
        r14.putString("first_category_name", r10.R());
        AppCategoryTitleAdapter r15 = r10.f8452k;
        String r16 = null;
        if (r15 == null) goto L5;
        CategoryTitleEntity r17 = r15.getItem(r13);
    L6:
        if (r17 == null) goto L8;
        r16 = r17.getName();
    L8:
        r14.putString("sec_category_name", r16);
        f9.b.b("click_category_navigation", r14);
        return;
    L5:
        r17 = null;
        goto L6
    }

    public static final void V(AppCategoryFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        r10.B();
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L15;
        List r12 = (List) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 != null) goto L10;
    L13:
        h7.c.A(r10, null, null, 0, 7, null);
        return;
    L10:
        if (r12.isEmpty() == true) goto L13;
        r10.r();
        r10.T(r12);
        return;
    L15:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L21;
        com.bytedanceos.appstore.buss.network.h.a r13 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r13.c());
        r10.D(r13);
        return;
    }

    @Override // h7.c
    public void E() {
        O().h().i(this, new com.bytedanceos.appstore.buss.fragment.b(this));
    }

    @Override // h7.c
    public void F() {
    }

    public final int M() {
        return ((Number) this.f8448g.getValue()).intValue();
    }

    public final x7.t N() {
        x7.t r10 = x7.t.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final AppCategoryViewModel O() {
        return (AppCategoryViewModel) this.f8451j.getValue();
    }

    public final boolean P() {
        return ((Boolean) this.f8450i.getValue()).booleanValue();
    }

    public final int Q() {
        return ((Number) this.f8449h.getValue()).intValue();
    }

    public final void T(List r25) {
        this.f8454m.clear();
        this.f8455n.clear();
        if (r25 == null) goto L23;
        Iterator r10 = r25.iterator();
        int r11 = 0;
        int r12 = 0;
    L6:
        if (r10.hasNext() == false) goto L22;
        Object r13 = r10.next();
        int r14 = r11 + 1;
        if (r11 >= 0) goto L10;
        kotlin.collections.t.q();
    L10:
        CategoryEntityWrap r15 = (CategoryEntityWrap) r13;
        AppEntityWrap r16 = new AppEntityWrap(null, null, null, null, null, null, null, null, null, 0, 0, null, null, 8191, null);
        CategoryTitleEntity r17 = r15.getCategory();
        if (r17 == null) goto L18;
        this.f8454m.add(r17);
        r16.setName(r17.getName());
        r16.setCid(r17.getId());
        if (kotlin.text.o.q(r16.getCid(), String.valueOf(Q()), false, 2, null) == true) goto L16;
        r11 = r12;
    L16:
        r12 = r11;
    L18:
        List<CommonAppEntity> r18 = r15.getApps();
        if (r18 == null) goto L21;
        r16.setApps(r18);
    L21:
        this.f8455n.add(r16);
        r11 = r14;
        goto L6
    L22:
        int r19 = r12;
    L24:
        AppCategoryTitleAdapter r20 = this.f8452k;
        if (r20 == null) goto L27;
        r20.setList(this.f8454m);
    L27:
        PagerTypeAdapter r21 = this.f8453l;
        if (r21 == null) goto L30;
        r21.setList(this.f8455n);
    L30:
        U(r19);
        return;
    L23:
        r19 = 0;
        goto L24
    }

    public final void U(int r10) {
        AppCategoryTitleAdapter r11 = this.f8452k;
        if (r11 == null) goto L5;
        r11.b(r10);
    L5:
        N().f25757b.scrollToPosition(r10);
        RecyclerView.LayoutManager r12 = N().f25757b.getLayoutManager();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) r12).scrollToPositionWithOffset(r10, 0);
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, R(), P(), false, 4, null);
        u(R());
        N().f25759d.setLayoutManager(new LinearLayoutManager(l(), 0, false));
        this.f8452k = new AppCategoryTitleAdapter();
        N().f25759d.setAdapter(this.f8452k);
        Map r10 = k8.a.f21034a;
        this.f8453l = new PagerTypeAdapter(null, (String) r10.get(Integer.valueOf(M())), 1, null);
        N().f25757b.setAdapter(this.f8453l);
        N().f25757b.setLayoutManager(new LinearLayoutManager(l()));
        N().f25757b.setPageSource((String) r10.get(Integer.valueOf(M())));
        N().f25757b.addOnScrollListener(new b(this));
        Bundle r11 = new Bundle();
        r11.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, (String) r10.get(Integer.valueOf(M())));
        f9.b.b("exposure_pages_main", r11);
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_category;
    }

    @Override // h7.c
    public Function0 o() {
        return new AppCategoryFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // h7.c
    public void t() {
        AppCategoryTitleAdapter r10 = this.f8452k;
        if (r10 == null) goto L6;
        r10.setOnItemClickListener(new c(this));
        return;
    }
}
