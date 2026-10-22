package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.AppStoreActivity;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.adapter.app.pager.adapter.PagerTypeAdapter;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.TvSearchHotKeywordsEntity;
import com.bytedanceos.appstore.buss.entity.TvSearchRecommendEntityWrap;
import com.bytedanceos.appstore.buss.entity.bean.SearchHistoryEntityBean;
import com.bytedanceos.appstore.buss.viewmodels.SearchViewModel;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import com.obric.appstore.R;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\bH\u0014¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000e\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\nR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001c\u00103\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u0001008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00107\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/SearchRecommendFragment;", "Lh7/c;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "Lcom/bytedanceos/appstore/buss/entity/bean/SearchHistoryEntityBean;", ServerElements.LIST, "", "W", "(Ljava/util/List;)V", "E", "initData", "F", "t", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "onDestroyView", "Lcom/bytedanceos/appstore/buss/entity/TvSearchRecommendEntityWrap;", "wrap", "Y", "(Lcom/bytedanceos/appstore/buss/entity/TvSearchRecommendEntityWrap;)V", "Lcom/bytedanceos/appstore/buss/entity/TvSearchHotKeywordsEntity;", "U", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "f", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "hotAppsAdapter", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PagerTypeAdapter;", "g", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PagerTypeAdapter;", "recommendAdapter", "Lcom/bytedanceos/appstore/buss/viewmodels/SearchViewModel;", "h", "Lkotlin/Lazy;", "Q", "()Lcom/bytedanceos/appstore/buss/viewmodels/SearchViewModel;", "recommendViewModel", "", "q", "()Z", "showHeader", "", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/w;", "P", "()Lx7/w;", "fragmentTvSearchRecommendBinding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchRecommendFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchRecommendFragment.kt\ncom/bytedanceos/appstore/buss/fragment/SearchRecommendFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,225:1\n106#2,15:226\n57#3,3:241\n1864#4,3:244\n1864#4,3:247\n50#5,9:250\n*S KotlinDebug\n*F\n+ 1 SearchRecommendFragment.kt\ncom/bytedanceos/appstore/buss/fragment/SearchRecommendFragment\n*L\n47#1:226,15\n77#1:241,3\n151#1:244,3\n187#1:247,3\n58#1:250,9\n*E\n"})
public final class SearchRecommendFragment extends h7.c implements View.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BinderAdapter f8625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PagerTypeAdapter f8626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8627h;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchRecommendFragment f8628a;

        public a(SearchRecommendFragment r10) {
            this.f8628a = r10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (SearchRecommendFragment.L(this.f8628a).f25782g == null) goto L10;
            LinearLayout r10 = SearchRecommendFragment.L(this.f8628a).f25782g;
            if (r10 == null) goto L10;
            ViewTreeObserver r11 = r10.getViewTreeObserver();
            if (r11 == null) goto L10;
            r11.removeOnGlobalLayoutListener(this);
        L10:
            if (SearchRecommendFragment.L(this.f8628a).f25779d != null) goto L12;
            return;
        L12:
            if (SearchRecommendFragment.L(this.f8628a).f25778c != null) goto L14;
            return;
        L14:
            if (SearchRecommendFragment.L(this.f8628a).f25778c.getVisibility() != 0) goto L28;
            int r12 = SearchRecommendFragment.L(this.f8628a).f25778c.getChildCount();
            if (r12 < 0) goto L29;
            int r13 = 0;
            int r14 = 0;
        L19:
            if (SearchRecommendFragment.L(this.f8628a).f25778c.getChildAt(r13) == null) goto L23;
            r14 = r14 + SearchRecommendFragment.L(this.f8628a).f25778c.getChildAt(r13).getWidth();
            if ((((com.bytedanceos.appstore.buss.utilities.g.b(4) * r13) + r14) + SearchRecommendFragment.L(this.f8628a).f25779d.getWidth()) <= SearchRecommendFragment.L(this.f8628a).f25782g.getWidth()) goto L23;
            SearchRecommendFragment.L(this.f8628a).f25778c.removeViewAt(r13);
        L23:
            if (r13 == r12) goto L30;
            r13 = r13 + 1;
            goto L19
        L30:
            return;
        L29:
            return;
        }
    }

    public SearchRecommendFragment() {
        final Function0<Fragment> r10 = new SearchRecommendFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new SearchRecommendFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f8627h = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(SearchViewModel.class), new SearchRecommendFragment$special$$inlined$viewModels$default$3(r11), new SearchRecommendFragment$special$$inlined$viewModels$default$4(r12, r11), new SearchRecommendFragment$special$$inlined$viewModels$default$5(this, r11));
    }

    public static /* synthetic */ void G(SearchRecommendFragment r10, List r11) {
        T(r10, r11);
    }

    public static /* synthetic */ void H(SearchRecommendFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        S(r10, r11);
    }

    public static /* synthetic */ void I(SearchRecommendFragment r10) {
        R(r10);
    }

    public static /* synthetic */ void J(SearchRecommendFragment r10, SearchChipsView r11, TvSearchHotKeywordsEntity r12, View r13) {
        V(r10, r11, r12, r13);
    }

    public static /* synthetic */ void K(SearchRecommendFragment r10, SearchChipsView r11, View r12) {
        X(r10, r11, r12);
    }

    public static final /* synthetic */ x7.w L(SearchRecommendFragment r10) {
        return r10.P();
    }

    public static final /* synthetic */ BinderAdapter M(SearchRecommendFragment r10) {
        return r10.f8625f;
    }

    public static final /* synthetic */ PagerTypeAdapter N(SearchRecommendFragment r10) {
        return r10.f8626g;
    }

    public static final /* synthetic */ void O(SearchRecommendFragment r10, List r11) {
        r10.U(r11);
    }

    public static final void R(SearchRecommendFragment r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        if (r10.P().f25782g == null) goto L10;
        LinearLayout r11 = r10.P().f25782g;
        if (r11 == null) goto L11;
        ViewTreeObserver r12 = r11.getViewTreeObserver();
        if (r12 == null) goto L12;
        r12.addOnGlobalLayoutListener(new a(r10));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static final void S(SearchRecommendFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L12;
        TvSearchRecommendEntityWrap r12 = (TvSearchRecommendEntityWrap) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 != null) goto L10;
        h7.c.A(r10, null, null, 0, 7, null);
        return;
    L10:
        r10.Y(r12);
        return;
    L12:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L17;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(((com.bytedanceos.appstore.buss.network.h.a) r11).c());
        return;
    }

    public static final void T(SearchRecommendFragment r10, List r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        r10.W(r11);
    }

    public static final void V(SearchRecommendFragment r10, SearchChipsView r11, TvSearchHotKeywordsEntity r12, View r13) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$view");
        kotlin.jvm.internal.q.g(r12, "$entity");
        if ((r10.getContext() instanceof AppStoreActivity) == false) goto L6;
        String r14 = r11.getText().toString();
        Bundle r15 = new Bundle();
        r15.putString("search_hotword_app_pkg", r12.getPackageName());
        f9.b.b("click_search_hotwords", r15);
        EventBus.getDefault().post(new c7.b(r14));
        return;
    }

    private final void W(List r10) {
        if (r10 != null) goto L4;
    L18:
        P().f25778c.setVisibility(8);
        P().f25779d.setVisibility(8);
        return;
    L4:
        if (r10.isEmpty() == true) goto L18;
        P().f25778c.setVisibility(0);
        P().f25779d.setVisibility(0);
        P().f25778c.setMaxRows(1);
        P().f25778c.removeAllViews();
        ViewGroup.MarginLayoutParams r11 = new ViewGroup.MarginLayoutParams(-2, -2);
        Iterator r12 = r10.iterator();
        int r13 = 0;
    L8:
        if (r12.hasNext() == false) goto L17;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L12;
        kotlin.collections.t.q();
    L12:
        final SearchChipsView r16 = new SearchChipsView(l());
        r16.setText(((SearchHistoryEntityBean) r14).getWord());
        if (r13 != 0) goto L15;
        r16.setType(1);
    L16:
        r16.setOnClickListener(new z0(this, r16));
        P().f25778c.addView(r16, r11);
        r13 = r15;
        goto L8
    L15:
        r16.setType(0);
        goto L16
    }

    public static final void X(SearchRecommendFragment r10, SearchChipsView r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$view");
        if ((r10.getContext() instanceof AppStoreActivity) == false) goto L6;
        String r13 = r11.getText().toString();
        f9.b.b("click_search_history", null);
        EventBus.getDefault().post(new c7.b(r13));
        return;
    }

    @Override // h7.c
    public void E() {
        SearchViewModel r10 = Q();
        r10.k().i(this, new w0(this));
        r10.i().i(this, new x0(this));
    }

    @Override // h7.c
    public void F() {
    }

    public final x7.w P() {
        x7.w r10 = x7.w.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final SearchViewModel Q() {
        return (SearchViewModel) this.f8627h.getValue();
    }

    public final void U(List r10) {
        if (r10 != null) goto L4;
    L18:
        P().f25777b.setVisibility(8);
        return;
    L4:
        if (r10.isEmpty() == true) goto L18;
        int r11 = 0;
        P().f25777b.setVisibility(0);
        P().f25777b.setMaxRows(1);
        P().f25777b.removeAllViews();
        ViewGroup.MarginLayoutParams r12 = new ViewGroup.MarginLayoutParams(-2, -2);
        Iterator r13 = r10.iterator();
    L8:
        if (r13.hasNext() == false) goto L17;
        Object r14 = r13.next();
        int r15 = r11 + 1;
        if (r11 >= 0) goto L12;
        kotlin.collections.t.q();
    L12:
        final TvSearchHotKeywordsEntity r16 = (TvSearchHotKeywordsEntity) r14;
        final SearchChipsView r17 = new SearchChipsView(l());
        r17.setText(r16.getKeyword());
        if (r11 != 0) goto L15;
        r17.setType(4);
    L16:
        r17.setOnClickListener(new y0(this, r17, r16));
        P().f25777b.addView(r17, r12);
        r11 = r15;
        goto L8
    L15:
        r17.setType(2);
        goto L16
    }

    public final void Y(TvSearchRecommendEntityWrap r10) {
        kotlinx.coroutines.h.d(androidx.lifecycle.s.a(this), null, null, new SearchRecommendFragment$updateUi$1(r10, this, null), 3, null);
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, getString(R.string.search), false, true, 2, null);
        P().f25783h.setLayoutManager(new LinearLayoutManager(l()));
        BinderAdapter r10 = new BinderAdapter();
        r10.addItemBinder(AppEntityWrap.class, new d7.n("page_search_recommend"), null);
        this.f8625f = r10;
        P().f25783h.setAdapter(this.f8625f);
        P().f25784i.setLayoutManager(new LinearLayoutManager(l()));
        this.f8626g = new PagerTypeAdapter(null, "page_search_recommend", 1, null);
        P().f25784i.setAdapter(this.f8626g);
        P().f25784i.setPageSource("page_search_recommend");
        P().f25779d.setOnClickListener(this);
        Bundle r11 = new Bundle();
        r11.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_search_recommend");
        f9.b.b("exposure_pages_main", r11);
        new Handler().postDelayed(new v0(this), 50);
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_search_recommend;
    }

    @Override // h7.c
    public Function0 o() {
        return SearchRecommendFragment$onRetryListener$1.INSTANCE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.getId());
    L6:
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.intValue() != R.id.iv_history_clear) goto L12;
        f9.b.b("click_search_history_clear", null);
        Q().f();
        return;
    L12:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8625f = null;
        this.f8626g = null;
        Q().t(this);
    }

    @Override // h7.c
    public boolean q() {
        return true;
    }

    @Override // h7.c
    public void t() {
        r();
        Q().j();
    }
}
