package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.SearchResultPromoteEntity;
import com.bytedanceos.appstore.buss.viewmodels.MainViewModel;
import com.bytedanceos.appstore.buss.viewmodels.SearchViewModel;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010$R\u0014\u0010-\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00104\u001a\u00020\"8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u001c\u00108\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/SearchResultFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "onDestroyView", "Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "f", "Lkotlin/Lazy;", "T", "()Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "mainViewModel", "Lcom/bytedanceos/appstore/buss/viewmodels/SearchViewModel;", "g", "U", "()Lcom/bytedanceos/appstore/buss/viewmodels/SearchViewModel;", "viewModel", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "h", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "adapter", "", "i", "Ljava/lang/String;", "searchKey", "", "", "j", "Ljava/util/List;", "dataList", "", "k", "I", "defaultSpanCount", "l", "currentSpanCount", "m", "downloadCount", "Lx7/d;", "R", "()Lx7/d;", "commonRecyclerViewBinding", "", "q", "()Z", "showHeader", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/x;", "S", "()Lx7/x;", "fragmentTvSearchResultBinding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchResultFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchResultFragment.kt\ncom/bytedanceos/appstore/buss/fragment/SearchResultFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,264:1\n172#2,9:265\n106#2,15:274\n57#3,3:289\n57#3,3:292\n57#3,3:295\n57#3,3:298\n1#4:301\n50#5,9:302\n*S KotlinDebug\n*F\n+ 1 SearchResultFragment.kt\ncom/bytedanceos/appstore/buss/fragment/SearchResultFragment\n*L\n48#1:265,9\n49#1:274,15\n147#1:289,3\n155#1:292,3\n156#1:295,3\n176#1:298,3\n77#1:302,9\n*E\n"})
public final class SearchResultFragment extends h7.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BinderAdapter f8631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f8632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f8633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8635l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8636m;

    public static final class a extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchResultFragment f8637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8638b;

        public a(SearchResultFragment r10, Ref$IntRef r11) {
            this.f8637a = r10;
            this.f8638b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            BinderAdapter r11 = SearchResultFragment.J(this.f8637a);
            Object r12 = null;
            if (r11 == null) goto L7;
            List<Object> r13 = r11.getData();
            if (r13 == null) goto L7;
            Integer r14 = Integer.valueOf(r13.size());
        L8:
            kotlin.jvm.internal.q.d(r14);
            if (r10 >= r14.intValue()) goto L18;
            BinderAdapter r15 = SearchResultFragment.J(this.f8637a);
            if (r15 == null) goto L16;
            List<Object> r16 = r15.getData();
            if (r16 == null) goto L16;
            r12 = r16.get(r10);
        L16:
            if ((r12 instanceof CommonAppEntity) == false) goto L18;
            return 1;
        L18:
            int r17 = this.f8638b.element;
            if (r17 != 0) goto L22;
            return 1;
        L22:
            return r17;
        L7:
            r14 = null;
            goto L8
        }
    }

    public static final class b implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchResultFragment f8639a;

        public b(SearchResultFragment r10) {
            this.f8639a = r10;
        }

        public void a(View r10, CommonAppEntity r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "entity");
            SearchResultFragment r12 = this.f8639a;
            SearchResultFragment.Q(r12, SearchResultFragment.M(r12) + 1);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            a((View) r10, (CommonAppEntity) r11);
            return Unit.f21064a;
        }
    }

    public static final class c implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchResultFragment f8640a;

        public c(SearchResultFragment r10) {
            this.f8640a = r10;
        }

        public void a(View r10, String r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "searchKey");
            if (SearchResultFragment.L(this.f8640a) != null) goto L5;
        L22:
            EventBus.getDefault().post(new c7.b(r11));
            return;
        L5:
            if (SearchResultFragment.L(this.f8640a).size() <= 0) goto L22;
            int r12 = 0;
            if (SearchResultFragment.L(this.f8640a).get(0) == null) goto L22;
            Object r13 = SearchResultFragment.L(this.f8640a).get(0);
            kotlin.jvm.internal.q.e(r13, "null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedanceos.appstore.buss.entity.SearchResultPromoteEntity>");
            List r14 = kotlin.jvm.internal.y.c(r13);
            Iterator r15 = r14.iterator();
        L10:
            if (r15.hasNext() == false) goto L22;
            Object r16 = r15.next();
            int r17 = r12 + 1;
            if (r12 >= 0) goto L15;
            kotlin.collections.t.q();
        L15:
            if (r11.equals(((SearchResultPromoteEntity) r16).getName()) == false) goto L21;
            Bundle r18 = new Bundle();
            if (r12 != (r14.size() - 1)) goto L19;
            String r19 = "category";
        L20:
            r18.putString("search_related_words_type", r19);
            r18.putString("search_related_words_position", String.valueOf(r17));
            f9.b.b("click_search_related_words", r18);
            goto L21
        L19:
            r19 = ServerElements.APP;
        L21:
            r12 = r17;
            goto L10
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            a((View) r10, (String) r11);
            return Unit.f21064a;
        }
    }

    public static final class d extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchResultFragment f8641a;

        public d(SearchResultFragment r10) {
            this.f8641a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView r10, int r11, int r12) {
            kotlin.jvm.internal.q.g(r10, "recyclerView");
            super.onScrolled(r10, r11, r12);
            if (SearchResultFragment.P(this.f8641a).h() == false) goto L9;
            RecyclerView.LayoutManager r13 = SearchResultFragment.K(this.f8641a).f25515b.getLayoutManager();
            kotlin.jvm.internal.q.e(r13, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            if (((LinearLayoutManager) r13).findFirstVisibleItemPosition() < SearchResultFragment.P(this.f8641a).q()) goto L7;
            ViewGroup.LayoutParams r14 = SearchResultFragment.N(this.f8641a).f25788b.b().getLayoutParams();
            r14.width = SearchResultFragment.K(this.f8641a).f25515b.getWidth();
            SearchResultFragment.N(this.f8641a).f25788b.b().setVisibility(0);
            return;
        L7:
            SearchResultFragment.N(this.f8641a).f25788b.b().setVisibility(8);
            return;
        }
    }

    public static final class e extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchResultFragment f8642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8643b;

        public e(SearchResultFragment r10, Ref$IntRef r11) {
            this.f8642a = r10;
            this.f8643b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            BinderAdapter r11 = SearchResultFragment.J(this.f8642a);
            Object r12 = null;
            if (r11 == null) goto L7;
            List<Object> r13 = r11.getData();
            if (r13 == null) goto L7;
            Integer r14 = Integer.valueOf(r13.size());
        L8:
            kotlin.jvm.internal.q.d(r14);
            if (r10 >= r14.intValue()) goto L18;
            BinderAdapter r15 = SearchResultFragment.J(this.f8642a);
            if (r15 == null) goto L16;
            List<Object> r16 = r15.getData();
            if (r16 == null) goto L16;
            r12 = r16.get(r10);
        L16:
            if ((r12 instanceof CommonAppEntity) == false) goto L18;
            return 1;
        L18:
            int r17 = this.f8643b.element;
            if (r17 != 0) goto L22;
            return 1;
        L22:
            return r17;
        L7:
            r14 = null;
            goto L8
        }
    }

    public SearchResultFragment() {
        final Function0 r10 = null;
        this.f8629f = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(MainViewModel.class), new SearchResultFragment$special$$inlined$activityViewModels$default$1(this), new SearchResultFragment$special$$inlined$activityViewModels$default$2(r10, this), new SearchResultFragment$special$$inlined$activityViewModels$default$3(this));
        final Function0<Fragment> r11 = new SearchResultFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new SearchResultFragment$special$$inlined$viewModels$default$2(r11));
        this.f8630g = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(SearchViewModel.class), new SearchResultFragment$special$$inlined$viewModels$default$3(r12), new SearchResultFragment$special$$inlined$viewModels$default$4(r10, r12), new SearchResultFragment$special$$inlined$viewModels$default$5(this, r12));
        this.f8633j = new ArrayList();
        this.f8634k = 1;
        this.f8635l = 1;
    }

    public static /* synthetic */ void G(SearchResultFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        X(r10, r11);
    }

    public static /* synthetic */ void H(SearchResultFragment r10, String r11) {
        W(r10, r11);
    }

    public static /* synthetic */ void I(SearchResultFragment r10) {
        V(r10);
    }

    public static final /* synthetic */ BinderAdapter J(SearchResultFragment r10) {
        return r10.f8631h;
    }

    public static final /* synthetic */ x7.d K(SearchResultFragment r10) {
        return r10.R();
    }

    public static final /* synthetic */ List L(SearchResultFragment r10) {
        return r10.f8633j;
    }

    public static final /* synthetic */ int M(SearchResultFragment r10) {
        return r10.f8636m;
    }

    public static final /* synthetic */ x7.x N(SearchResultFragment r10) {
        return r10.S();
    }

    public static final /* synthetic */ String O(SearchResultFragment r10) {
        return r10.f8632i;
    }

    public static final /* synthetic */ SearchViewModel P(SearchResultFragment r10) {
        return r10.U();
    }

    public static final /* synthetic */ void Q(SearchResultFragment r10, int r11) {
        r10.f8636m = r11;
    }

    private final x7.d R() {
        x7.d r10 = x7.d.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    private final MainViewModel T() {
        return (MainViewModel) this.f8629f.getValue();
    }

    public static final void V(SearchResultFragment r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        String r11 = r10.f8632i;
        if (r11 == null) goto L6;
        r10.U().l(r11);
        return;
    }

    public static final void W(SearchResultFragment r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        if (r11 != null) goto L5;
        return;
    L5:
        if (kotlin.text.o.r(r11) == true) goto L13;
        r10.f8632i = r11;
        r10.U().u(1);
        r10.f8633j.clear();
        BinderAdapter r12 = r10.f8631h;
        if (r12 == null) goto L10;
        r12.setList(r10.f8633j);
    L10:
        SearchViewModel r13 = r10.U();
        kotlin.jvm.internal.q.d(r11);
        r13.l(r11);
        EventBus.getDefault().post(new p7.a());
        r10.T().o("");
        return;
    }

    public static final void X(SearchResultFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L8;
        if (r10.U().g() != 1) goto L66;
        r10.B();
        return;
    L66:
        return;
    L8:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L50;
        com.bytedanceos.appstore.buss.network.h.c r12 = (com.bytedanceos.appstore.buss.network.h.c) r11;
        List r13 = (List) r12.a();
        if (r10.U().g() != 1) goto L20;
        if (r13 != null) goto L13;
    L19:
        String r14 = r10.getString(R.string.search_not_found_msg);
        kotlin.jvm.internal.q.f(r14, "getString(...)");
        String r15 = r10.getString(R.string.search_not_found, new Object[]{r10.f8632i});
        kotlin.jvm.internal.q.f(r15, "getString(...)");
        r10.z(r14, r15, R.drawable.search_empty);
    L28:
        if (r13 != null) goto L30;
    L44:
        BinderAdapter r16 = r10.f8631h;
        if (r16 == null) goto L71;
        BaseLoadMoreModule r17 = r16.getLoadMoreModule();
        if (r17 == null) goto L72;
        BaseLoadMoreModule.loadMoreEnd$default(r17, false, 1, null);
        return;
    L72:
        return;
    L71:
        return;
    L30:
        if (r13.isEmpty() == true) goto L44;
        if (r13.size() < r10.U().p()) goto L44;
        if (r12.b().getHas_more() == null) goto L44;
        if (kotlin.jvm.internal.q.b(r12.b().getHas_more(), Boolean.FALSE) == true) goto L44;
        BinderAdapter r18 = r10.f8631h;
        if (r18 == null) goto L68;
        BaseLoadMoreModule r19 = r18.getLoadMoreModule();
        if (r19 == null) goto L69;
        r19.loadMoreComplete();
        return;
    L69:
        return;
    L68:
        return;
    L13:
        if (r13.isEmpty() == true) goto L19;
        r10.r();
        r10.f8633j.clear();
        r10.f8633j.addAll(r13);
        BinderAdapter r20 = r10.f8631h;
        if (r20 == null) goto L18;
        r20.setList(r10.f8633j);
    L18:
        SearchViewModel r21 = r10.U();
        r21.u(r21.g() + 1);
        goto L28
    L20:
        if (r13 != null) goto L22;
    L27:
        SearchViewModel r22 = r10.U();
        r22.u(r22.g() + 1);
        goto L28
    L22:
        if (r13.isEmpty() == true) goto L27;
        r10.f8633j.addAll(r13);
        BinderAdapter r23 = r10.f8631h;
        if (r23 == null) goto L27;
        r23.setList(r10.f8633j);
        goto L27
    L50:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L74;
        com.bytedanceos.appstore.buss.network.h.a r24 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r24.c());
        List r25 = r10.f8633j;
        if (r25 != null) goto L54;
    L64:
        r10.D(r24);
        return;
    L54:
        if (r25.isEmpty() == true) goto L64;
        r10.r();
        BinderAdapter r26 = r10.f8631h;
        if (r26 == null) goto L59;
        r26.setList(r10.f8633j);
    L59:
        BinderAdapter r27 = r10.f8631h;
        if (r27 == null) goto L75;
        BaseLoadMoreModule r28 = r27.getLoadMoreModule();
        if (r28 == null) goto L76;
        r28.loadMoreFail();
        return;
    L76:
        return;
    L75:
        return;
    }

    @Override // h7.c
    public void E() {
        T().k().i(this, new b1(this));
        U().m().i(this, new c1(this));
    }

    @Override // h7.c
    public void F() {
        if (R().f25515b != null) goto L8;
        String r10 = this.f8632i;
        if (r10 == null) goto L8;
        T().o(r10);
    L8:
        if (getActivity() != null) goto L10;
        return;
    L10:
        if (R().f25515b == null) goto L18;
        Ref$IntRef r11 = new Ref$IntRef();
        com.bytedanceos.appstore.buss.utilities.f r12 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r13 = r12.f(getActivity());
        r11.element = r13;
        if (r13 == this.f8635l) goto L17;
        RecyclerView.LayoutManager r14 = R().f25515b.getLayoutManager();
        kotlin.jvm.internal.q.e(r14, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager r15 = (GridLayoutManager) r14;
        r15.Q(r11.element);
        r15.R(new e(this, r11));
        this.f8635l = r11.element;
        ViewGroup.LayoutParams r16 = R().f25515b.getLayoutParams();
        r16.width = r11.element * r12.a();
        R().f25515b.setLayoutParams(r16);
        return;
    L17:
        return;
    }

    public final x7.x S() {
        x7.x r10 = x7.x.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final SearchViewModel U() {
        return (SearchViewModel) this.f8630g.getValue();
    }

    @Override // h7.c
    public void initData() {
        this.f8636m = 0;
        U().s();
        h7.c.w(this, getString(R.string.search), false, true, 2, null);
        Ref$IntRef r10 = new Ref$IntRef();
        int r11 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        r10.element = r11;
        if (r11 != 0) goto L5;
        GridLayoutManager r12 = new GridLayoutManager(l(), this.f8634k);
    L6:
        this.f8635l = r10.element;
        r12.R(new a(this, r10));
        R().f25515b.setLayoutManager(r12);
        BinderAdapter r13 = new BinderAdapter();
        d7.c r14 = new d7.c("page_search_result");
        r14.e(new b(this));
        r13.addItemBinder(CommonAppEntity.class, r14, null);
        r13.addItemBinder(String.class, new d7.f(), null);
        d7.e r15 = new d7.e();
        r15.b(new c(this));
        r13.addItemBinder(ArrayList.class, r15, null);
        d7.h r16 = new d7.h();
        r16.c("page_search_result");
        r13.addItemBinder(AppSubEntity.class, r16, null);
        r13.getLoadMoreModule().setOnLoadMoreListener(new a1(this));
        r13.getLoadMoreModule().setAutoLoadMore(true);
        r13.getLoadMoreModule().setEnableLoadMore(true);
        r13.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(true);
        this.f8631h = r13;
        R().f25515b.setAdapter(this.f8631h);
        R().f25515b.setPageSource("page_search_result");
        u7.a.f24888a.a(R().f25515b);
        S().f25788b.b().setPadding(getResources().getDimensionPixelSize(R.dimen.tv_item_le_ri), 0, 0, 0);
        R().f25515b.addOnScrollListener(new d(this));
        Bundle r17 = new Bundle();
        r17.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_search_result");
        f9.b.b("exposure_pages_main", r17);
        return;
    L5:
        r12 = new GridLayoutManager(l(), r10.element);
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_search_result;
    }

    @Override // h7.c
    public Function0 o() {
        return new SearchResultFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Bundle r10 = new Bundle();
        r10.putString("count_search_download", String.valueOf(this.f8636m));
        f9.b.b("count_search_download", r10);
        this.f8631h = null;
        T().n(this);
        U().t(this);
        U().t(this);
    }

    @Override // h7.c
    public boolean q() {
        return true;
    }

    @Override // h7.c
    public void t() {
    }
}
